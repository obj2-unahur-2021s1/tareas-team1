package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimadas:Int, val responsable: Empleado, val costosDeInfraestructura: Int){
    var empleados = mutableListOf<Empleado>()

    fun agregarEmpleado(empleado: Empleado) = empleados.add(empleado)
    fun cantidadDeEmpleados()=empleados.size
    fun nominaDeEmpleados() = empleados + responsable

    //Las horas necesarias para finalizar una tarea son las horas estimadas que requiere divido la cantidad de
    // empleados que tiene asignados (sin contar al responsable de la misma, que no aporta nada para reducir
    // este número).
    fun cuantoTiempoLlevaTerminar()= horasEstimadas /this.cantidadDeEmpleados()

    fun costoDeTarea() = this.sueldoDeTodosLosEmpleadosPorLaTarea() + this.sueldoDelResponsablePorLaTarea() + costosDeInfraestructura

    fun sueldoPorHoraDeTodosLosEmpleados() = empleados.sumBy { it.sueldoPorHora }

    fun sueldoDeTodosLosEmpleadosPorLaTarea() = this.cuantoTiempoLlevaTerminar() * this.sueldoPorHoraDeTodosLosEmpleados()

    fun sueldoDelResponsablePorLaTarea() = responsable.sueldoPorHora * horasEstimadas
}

class Empleado(val sueldoPorHora: Int) {


}
