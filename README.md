Repaso 1: Entorno gráfico con menús, ayuda y acerca de...

Realiza una aplicación con interfaz gráfica. Tendrá las siguientes características:

    Menú Fichero, con las opciones Nuevo, abrir, guardar, guardar como... y salir. 
    Menú Fecha, con las opciones LocalDate, Period, ChronoUnit,
    Menú Ayuda, con las opciones
        Ayuda: singleton con un scroller no editable donde se responderá a las siguientes preguntas con respecto al entorno gráfico:
            Identitica con su objeto en la API de Java: VentanaPrincipal, Barra de menú, menú, elemento de menú, controles...
            Identifica los paquetes utilizados.
        Acerca de... que indique tus apellidos, nombre y fecha de la autoría (usa JLabel y etiquetas HTML).
    Todos los menús podrán gestinarse mediante mnemonics y aceleradores.
    
Repaso 2: Eventos, LocalDate, Period y ChronoUnit
    
Continuando con Repaso 1:

    Diálogo Periodo que calcule:
        Tiempo transcurrido entre una:
            Fecha de Inicio (spinner con fecha de hoy)
            Fecha de fin (spinner con fecha 3 años posteriores a hoy)
        La unidade de medida se selecciona mediante botones de opción
            Días
            Meses
            Años
        El tiempo lo mostrará en una caja de texto no editable (inicialmente 3 años)
        Un único botón para salir del diálogo
        El cálculo se mostrará al cambiar cualquiera de los controles
        
Repaso 3: Ficheros
        
Continuando con Repaso 2:

    Cada vez que le deis al salir de un diálogo, la información se añadirá en una línea nueva
    Cada vez que se recupere, se mostrarán las líneas en un JTextPanel con scroller
    La extensión será ".txt"
