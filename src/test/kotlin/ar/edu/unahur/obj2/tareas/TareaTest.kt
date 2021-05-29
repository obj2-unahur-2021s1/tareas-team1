package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
      val marcelo = Empleado()
      val cristian = Empleado()
      val brian = Empleado()
      val ezequiel = Empleado()

      val tarea1 = Tarea(50, marcelo)
      val tarea2 = Tarea(24, ezequiel)

      tarea1.agregarEmpleado(cristian)
      tarea1.agregarEmpleado(brian)
      tarea1.agregarEmpleado(ezequiel)

      tarea2.agregarEmpleado(cristian)

      describe("nomina de empleados") {
          tarea1.nominaDeEmpleados().shouldBe(listOf(cristian, brian, ezequiel, marcelo))
          tarea2.nominaDeEmpleados().shouldBe(listOf(cristian, ezequiel))
      }
      describe("cuanto tiempo le lleva una tarea")
      {
          //Saber cuántas horas se necesitan para finalizar una tarea.
          tarea1.cuantoTiempoLlevaTerminar().shouldBe(23)
          tarea2.cuantoTiempoLlevaTerminar().shouldBe(70)
      }
  }
})
