package ar.edu.unahur.obj2.tareas

open class Tarea(val horasEstimadas:Int, val responsable: Empleado, val costosDeInfraestructura: Int){
    var empleados = mutableListOf<Empleado>()

    fun agregarEmpleado(empleado: Empleado) = empleados.add(empleado)

    fun cantidadDeEmpleados()=empleados.size

    fun nominaDeEmpleados() = empleados + responsable

    fun cuantoTiempoLlevaTerminar()= horasEstimadas /this.cantidadDeEmpleados()

    fun costoDeTarea() = this.sueldoDeTodosLosEmpleadosPorLaTarea() + this.sueldoDelResponsablePorLaTarea() + costosDeInfraestructura

    fun sueldoPorHoraDeTodosLosEmpleados() = empleados.sumBy { it.sueldoPorHora }

    fun sueldoDeTodosLosEmpleadosPorLaTarea() = this.cuantoTiempoLlevaTerminar() * this.sueldoPorHoraDeTodosLosEmpleados()

    fun sueldoDelResponsablePorLaTarea() = responsable.sueldoPorHora * horasEstimadas
}

class Empleado(val sueldoPorHora: Int) {


}
class TareasDeIntegracion(val responsable: Empleado)
{
    var subtareas =mutableListOf<Tarea>()

    fun agregarSubtarea(subtarea: Tarea) = subtareas.add(subtarea)

    fun cuantoTiempoLlevaTerminar()= subtareas.sumBy { c->c.cuantoTiempoLlevaTerminar() }+ this.horaDeReuniones()

    fun horaDeReuniones()=subtareas.sumBy { c->c.cuantoTiempoLlevaTerminar() }/8

    fun costoDeTarea() = this.costosDeSubtarea() + this.bonusDelResponsable()

    fun costosDeSubtarea() = subtareas.sumBy { it.costoDeTarea() }

    fun bonusDelResponsable() = costosDeSubtarea() * 3 / 100

    fun nominaDeEmpleados() = this.nominaDeEmpleadosDeSubtareas().flatten() + responsable

    fun nominaDeEmpleadosDeSubtareas() = subtareas.map { it.nominaDeEmpleados() }
}
