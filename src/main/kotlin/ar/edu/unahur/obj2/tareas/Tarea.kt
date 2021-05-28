package ar.edu.unahur.obj2.tareas

class Tarea(val horasEstimada:Int, val responsable: Empleado){
    var empleados = mutableListOf<Empleado>()

    fun agregarEmpleado(empleado: Empleado) = empleados.add(empleado)

    fun nominaDeEmpleados() = empleados + responsable

}

class Empleado {

}