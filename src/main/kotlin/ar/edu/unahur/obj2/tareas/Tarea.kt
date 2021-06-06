package ar.edu.unahur.obj2.tareas

interface Tareas {
    fun nominaDeEmpleados(): List<Any>

    fun cuantoTiempoLlevaTerminar(): Int

    fun costoDeTarea(): Int
}

class Tarea(val horasEstimadas:Int, val responsable: Empleado, val costosDeInfraestructura: Int): Tareas{

    var empleados = mutableListOf<Empleado>()

    fun agregarEmpleado(empleado: Empleado) = empleados.add(empleado)

    override fun nominaDeEmpleados() = empleados + responsable

    fun cantidadDeEmpleados()=empleados.size

    override fun cuantoTiempoLlevaTerminar()= horasEstimadas /this.cantidadDeEmpleados()

    override fun costoDeTarea() = this.sueldoDeTodosLosEmpleadosPorLaTarea() + this.sueldoDelResponsablePorLaTarea() + costosDeInfraestructura

    fun sueldoPorHoraDeTodosLosEmpleados() = empleados.sumBy { it.sueldoPorHora }

    fun sueldoDeTodosLosEmpleadosPorLaTarea() = this.cuantoTiempoLlevaTerminar() * this.sueldoPorHoraDeTodosLosEmpleados()

    fun sueldoDelResponsablePorLaTarea() = responsable.sueldoPorHora * horasEstimadas
}




class Empleado(val sueldoPorHora: Int) {


}

class TareasDeIntegracion(val responsable: Empleado): Tareas {

    var subtareas =mutableListOf<Tareas>()

    fun agregarSubtarea(subtarea: Tareas) = subtareas.add(subtarea)

    override fun cuantoTiempoLlevaTerminar()= subtareas.sumBy { c->c.cuantoTiempoLlevaTerminar() }+ this.horaDeReuniones()

    fun horaDeReuniones()=subtareas.sumBy { c->c.cuantoTiempoLlevaTerminar() }/8

    override fun costoDeTarea() = this.costosDeSubtarea() + this.bonusDelResponsable()

    fun costosDeSubtarea() = subtareas.sumBy { it.costoDeTarea() }

    fun bonusDelResponsable() = costosDeSubtarea() * 3 / 100

    override fun nominaDeEmpleados() = this.nominaDeEmpleadosDeSubtareas().flatten() + responsable

    fun nominaDeEmpleadosDeSubtareas() = subtareas.map{it.nominaDeEmpleados()}
}
