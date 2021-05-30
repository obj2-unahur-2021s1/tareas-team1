package ar.edu.unahur.obj2.tareas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class TareaTest : DescribeSpec({
  describe("Una tarea") {
      val marcelo = Empleado(36)
      val cristian = Empleado(30)
      val brian = Empleado(41)
      val ezequiel = Empleado(29)

      val tarea1 = Tarea(50, marcelo, 304)
      val tarea2 = Tarea(24, ezequiel, 689)

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
          tarea1.cuantoTiempoLlevaTerminar().shouldBe(16)
          tarea2.cuantoTiempoLlevaTerminar().shouldBe(24)
      }

      describe("costos de tarea") {
          tarea1.costoDeTarea().shouldBe(3704)
          tarea2.costoDeTarea().shouldBe(2105)
      }

  }
})
