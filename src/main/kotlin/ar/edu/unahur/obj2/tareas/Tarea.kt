package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimada:Int, val responsable: Empleado){
    var empleados = mutableListOf<Empleado>()

    fun agregarEmpleado(empleado: Empleado) = empleados.add(empleado)
    fun cantidadDeEmpleados()=empleados.size
    fun nominaDeEmpleados() = empleados + responsable

    //Las horas necesarias para finalizar una tarea son las horas estimadas que requiere divido la cantidad de
    // empleados que tiene asignados (sin contar al responsable de la misma, que no aporta nada para reducir
    // este número).
    fun cuantoTiempoLlevaTerminar()= horasEstimadas.hora /this.cantidadDeEmpleados()

}

class Empleado {

}
object horasEstimadas
{
    val hora =70
}