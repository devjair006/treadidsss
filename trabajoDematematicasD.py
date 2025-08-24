def generar_tabla_verdad(operador, num_variables=2):
    """
    Genera una tabla de verdad para el operador lógico especificado
    con el número de variables dado.
    Parámetros:
        operador (str): Tipo de operador lógico ('conjuncion', 'disyuncion', etc.)
        num_variables (int): Número de variables lógicas (2, 3 o 4)
    Retorna:
        variables (list): Lista de nombres de variables usadas
        combinaciones (list): Lista de tuplas con todas las combinaciones posibles de valores de verdad
        resultados (list): Lista de resultados de aplicar el operador a cada combinación
    """
    from itertools import product  # Importa para generar combinaciones de valores de verdad
    
    # Selecciona los nombres de las variables según el número solicitado
    variables = ['p', 'q', 'r', 's'][:num_variables]
    # Genera todas las combinaciones posibles de valores de verdad (False, True)
    combinaciones = list(product([False, True], repeat=num_variables))
    
    resultados = []
    for combo in combinaciones:
        # Aplica el operador lógico correspondiente a la combinación actual
        if operador == 'conjuncion':
            resultado = all(combo)  # AND lógico entre todas las variables
        elif operador == 'disyuncion':
            resultado = any(combo)  # OR lógico entre todas las variables
        elif operador == 'disyuncion_exclusiva':
            # XOR entre todas las variables (paridad de True)
            resultado = combo[0]
            for val in combo[1:]:
                resultado = resultado != val
        elif operador == 'condicional':
            # Condicional solo para dos variables: p → q equivale a ¬p ∨ q
            resultado = not combo[0] or combo[1]
        elif operador == 'bicondicional':
            # Bicondicional: todas las variables deben tener el mismo valor
            todas_true = all(combo)      # True si todas son True
            todas_false = not any(combo) # True si todas son False
            resultado = todas_true or todas_false
            
        resultados.append(resultado)  # Guarda el resultado para la combinación actual
    
    return variables, combinaciones, resultados

def mostrar_tabla(variables, combinaciones, resultados, operador_nombre):
    """
    Muestra la tabla de verdad de forma legible en consola.
    Parámetros:
        variables (list): Nombres de las variables
        combinaciones (list): Combinaciones de valores de verdad
        resultados (list): Resultados de la operación lógica
        operador_nombre (str): Nombre legible del operador
    """
    print(f"\nTabla de verdad para {operador_nombre} con {len(variables)} variables:")
    
    # Imprime el encabezado de la tabla con los nombres de las variables y el operador
    for var in variables:
        print(f"{var:^6}", end="")
    print(f"| {operador_nombre:^10}")
    
    # Imprime una línea separadora
    print("-" * (6 * len(variables) + 12))
    
    # Imprime cada fila de la tabla con los valores de las variables y el resultado
    for i, combo in enumerate(combinaciones):
        for val in combo:
            print(f"{str(val):^6}", end="")
        print(f"| {str(resultados[i]):^10}")

def main():
    """
    Función principal que gestiona la interacción con el usuario.
    Permite seleccionar el operador lógico y el número de variables,
    y muestra la tabla de verdad correspondiente.
    """
    print("GENERADOR DE TABLAS DE VERDAD")
    print("=============================")
    
    # Diccionario de operadores disponibles con su nombre legible
    operadores = {
        '1': ('conjuncion', 'Conjunción (AND)'),
        '2': ('disyuncion', 'Disyunción (OR)'),
        '3': ('disyuncion_exclusiva', 'Disyunción Exclusiva (XOR)'),
        '4': ('condicional', 'Condicional (→)'),
        '5': ('bicondicional', 'Bicondicional (↔)')
    }
    
    while True:
        # Muestra el menú de selección de operador
        print("\nSeleccione el operador lógico:")
        for key, value in operadores.items():
            print(f"{key}. {value[1]}")
        print("6. Salir")
        
        opcion = input("\nIngrese su opción (1-6): ").strip()
        
        if opcion == '6':
            print("¡Hasta luego!")
            break  # Sale del ciclo y termina el programa
            
        if opcion not in operadores:
            print("Opción no válida. Intente nuevamente.")
            continue  # Vuelve a mostrar el menú
        
        # Solicita el número de variables al usuario
        num_vars = input("¿Cuántas variables? (2, 3 o 4): ").strip()
        if num_vars not in ['2', '3', '4']:
            print("Número de variables no válido. Usando 2 variables por defecto.")
            num_vars = 2
        else:
            num_vars = int(num_vars)
        
        # Obtiene el operador y su nombre legible
        operador, nombre = operadores[opcion]
        # Genera la tabla de verdad y la muestra
        variables, combinaciones, resultados = generar_tabla_verdad(operador, num_vars)
        mostrar_tabla(variables, combinaciones, resultados, nombre)
        
        input("\nPresione Enter para continuar...")  # Pausa antes de mostrar el menú nuevamente

if __name__ == "__main__":
    main()  # Ejecuta la función principal si el script se ejecuta directamente 