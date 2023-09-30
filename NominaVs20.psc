Función Bienvenida (argumento)
	Escribir '*****************************************'
	Escribir 'Bienvenidos a nuestro programa de nomina.'
	Escribir '*****************************************'
	Escribir '*****************************************'
	Escribir '*****************************************'
	Escribir ' '
	Escribir ' '
FinFunción

Función Datos (NumEmple)
	// numero de empleados
	Escribir 'Escriba cuantos empleados quiere ingresar: '
	Leer NumEmple
	// dimensionar arreglos
	Dimensionar cedula(NumEmple), NombreApellido(NumEmple), salarioBasico(NumEmple), DiasLabo(NumEmple), ValorVentas(NumEmple), HorasExtras(NumEmple), CuotaPrestamo(NumEmple)
	// ingreso de informacion
	Para i<-0 Hasta NumEmple-1 Con Paso 1 Hacer
		Escribir 'Ingrese cedula del empleado'
		Leer cedula[i]
		Escribir 'Ingrese nombres y apellidos del empleado'
		Leer NombreApellido[i]
		Escribir 'Ingrese salario basico del empleado'
		Leer salarioBasico[i]
		Escribir 'Ingrese numero de dias laborados del empleado'
		Leer DiasLabo[i]
		Escribir 'Ingrese valor ventas realizadas por el empleado'
		Leer ValorVentas[i]
		Escribir 'Ingrese numero de horas extras laboradas el empleado'
		Leer HorasExtras[i]
		Escribir 'Ingrese cuota de prestamo del empleado'
		Leer CuotaPrestamo[i]
	FinPara
	// se llama funcion para calculos
	ver(NumEmple,cedula,NombreApellido,salarioBasico,ComiVentas,CuotaPrestamo,SalarioNeto,DiasLabo,HorasExtras,ValorVentas)
FinFunción

Función ver(NumEmple,cedula,NombreApellido,salarioBasico,ComiVentas,CuotaPrestamo,SalarioNeto,DiasLabo,HorasExtras,ValorVentas)
	// dimensionar 
	Dimensionar SalarioDia(NumEmple), salario(NumEmple), SalarioHora(NumEmple), ValorExtras(NumEmple)
	Dimensionar Comision(NumEmple), SubNeto(NumEmple), Neto(NumEmple), aux_trasporte(NumEmple), Pension(NumEmple), salud(NumEmple)
	// contador
	SalarioP <- 0
	MayorSala <- 0
	MenorSala <- 1000000000
	Para i<-0 Hasta NumEmple-1 Con Paso 1 Hacer
		// calculo pension y salud
		Pension[i] <- salarioBasico[i]*0.04
		salud[i] <- salarioBasico[i]*0.04
		// salario x dias trabajados
		SalarioDia[i] <- salarioBasico[i]/30
		salario[i] <- SalarioDia[i]*DiasLabo[i]
		// calculo hora extra
		SalarioHora[i] <- SalarioDia[i]/8
		ValorExtras[i] <- (SalarioHora[i]+(SalarioHora[i]*0.30))*HorasExtras[i]
		// calculo comision ventas
		Comision[i] <- ValorVentas[i]*0.05
		SubNeto[i] <- salario[i]+ValorExtras[i]+Comision[i]-CuotaPrestamo[i]
		// calculo subsidio
		Si SubNeto[i]<2320000 Entonces
			aux_trasporte[i] <- 140606
			Neto[i] <- SubNeto[i]+aux_trasporte[i]
		SiNo
			aux_trasporte[i] <- 0
			Neto[i] <- SubNeto[i]+aux_trasporte[i]
		FinSi
		// promedio
		SalarioP <- SalarioP+Neto[i]
		// mayor y menor salario
		Si MayorSala<Neto[i] Entonces
			MayorSala <- Neto[i]
			CCMayor <- cedula[i]
			EmpMayor <- NombreApellido[i]
		FinSi
		Si MenorSala>Neto[i] Entonces
			MenorSala <- Neto[i]
			CCMenor <- cedula[i]
			EmpMenor <- NombreApellido[i]
		FinSi
	FinPara
	SalarioP <- SalarioP/NumEmple
	Para i<-0 Hasta NumEmple-1 Con Paso 1 Hacer
		Escribir ' ********************'
		Escribir '1.Cedula del empleado: ', cedula[i]
		Escribir '2.Nombres y Apellidos del empleado: ', NombreApellido[i]
		Escribir '3.Salario Basico: ', salarioBasico[i]
		Escribir '4.Auxilio de transporte: ', aux_trasporte[i]
		Escribir '5.Dias laborados : ', DiasLabo[i]
		Escribir '6.Ventas: ', ValorVentas[i]
		Escribir '7.Comisión de Ventas 5%: ', Comision[i]
		Escribir '8.Total horas extras: ', HorasExtras[i]
		Escribir '9.Prestamos: ', CuotaPrestamo[i]
		Escribir '10.Salud: ', salud[i]
		Escribir '11.Pension: ', Pension[i]
		Escribir '12. Salario Neto a Recibir: ', Neto[i]
	FinPara
	Escribir '***********************************'
	Escribir '8. El Salario Promedio de los empleados es: ', SalarioP
	Escribir 'El empleado con mayor salario es ', EmpMayor, ' identificado con CC ', CCMayor, ' con un salario Neto ', MayorSala
	Escribir 'El empleado con menor salario es ', EmpMenor, ' identificado con CC ', CCMenor, ' con un salario Neto ', MenorSala
FinFunción

Algoritmo Nomina
	Bienvenida(argumento)
	Datos(NumEmple)
FinAlgoritmo
