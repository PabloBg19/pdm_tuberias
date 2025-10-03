## Proyecto de Ordenación de Números Aleatorios

Este proyecto consta de dos aplicaciones Java que trabajan en conjunto mediante tuberías (pipes) en línea de comandos para generar números aleatorios y ordenarlos.

## 📋 Descripción del Proyecto

El proyecto se divide en dos aplicaciones independientes:

1. **aleatorio**: Genera 50 números aleatorios entre 0 y 100
2. **ordenarNumeros**: Lee números desde la entrada estándar y los ordena de forma ascendente

## 🔧 Estructura del Proyecto

```
proyecto/
├── aleatorio/
│   ├── src/main/java/aleatorio/App.java
│   └── pom.xml
└── ordenarNumeros/
    ├── src/main/java/ordenarNumeros/App.java
    └── pom.xml
```

## 📝 Explicación del Código

### Aplicación `aleatorio`

**Funcionalidad:**
- Genera 50 números enteros aleatorios entre 0 y 100
- Imprime los números en la salida estándar separados por espacios

**Código principal:**
```java
public static void main(String[] args) {
    int [] aleatorio= new int [50];  // Array para almacenar 50 números
    Random random = new Random();     // Generador de números aleatorios

    for (int i = 0; i < aleatorio.length; i++) {
        aleatorio[i]= random.nextInt(101);  // Genera número entre 0-100
        System.out.print(aleatorio[i] + " "); // Imprime en salida estándar
    }
}
```

**Aspectos clave:**
- `Random.nextInt(101)`: Genera números aleatorios de 0 a 100 (inclusive)
- `System.out.print()`: Escribe en la salida estándar (stdout)
- Los números se imprimen en una sola línea separados por espacios

### Aplicación `ordenarNumeros`

**Funcionalidad:**
- Lee números desde la entrada estándar (stdin)
- Ordena los números de forma ascendente usando `Arrays.sort()`
- Imprime los números ordenados en la salida estándar

**Código principal:**
```java
public static void main(String[] args) throws IOException {
    try{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String linea = null;

        while((linea = br.readLine()) != null){
            // Divide la línea por espacios en blanco
            String datos[] = linea.trim().split("\\s+");
            int numeros[] = new int[datos.length];

            // Convierte strings a enteros
            for(int i = 0; i < numeros.length; i++){
                numeros[i] = Integer.parseInt(datos[i]);
            }

            // Ordena el array
            Arrays.sort(numeros);

            // Imprime los números ordenados
            for(int i = 0; i < numeros.length; i++){
                System.out.print(numeros[i] + " ");
            }
            System.out.println();
        }
    } catch(Exception e){
        System.out.println(e);
    }
}
```

**Aspectos clave:**
- `InputStreamReader` y `BufferedReader`: Leen desde la entrada estándar
- `split("\\s+")`: Separa la línea por uno o más espacios en blanco
- `Integer.parseInt()`: Convierte cadenas de texto a números enteros
- `Arrays.sort()`: Ordena el array de forma ascendente

## 🏗️ Compilación con Maven

Ambos proyectos utilizan Maven para la gestión de dependencias y construcción del JAR.

### Configuración del POM.xml

El archivo `pom.xml` incluye la configuración del plugin `maven-jar-plugin` que especifica:
- La clase principal (`mainClass`) de cada aplicación
- El nombre del archivo JAR resultante (`finalName`)

**Para aleatorio:**
```xml
<build>
    <finalName>aleatorio</finalName>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.4.1</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>aleatorio.App</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

### Pasos para crear los archivos JAR

1. **Compilar el proyecto aleatorio:**
   ```bash
   cd aleatorio
   mvn clean package
   ```
   Esto generará el archivo `aleatorio.jar` en la carpeta `target/`

2. **Compilar el proyecto ordenarNumeros:**
   ```bash
   cd ordenarNumeros
   mvn clean package
   ```
   Esto generará el archivo `ordenarnumeros.jar` en la carpeta `target/`

### Comandos Maven explicados

- `mvn clean`: Elimina la carpeta `target/` con compilaciones anteriores
- `mvn package`: Compila el código y genera el archivo JAR ejecutable
- `mvn clean package`: Ejecuta ambos comandos en secuencia

## 🚀 Ejecución de las Aplicaciones

### Ejecución individual

**Ejecutar aleatorio:**
```bash
java -jar aleatorio.jar
```
Salida esperada: Una línea con 50 números aleatorios entre 0 y 100

**Ejecutar ordenarNumeros (entrada manual):**
```bash
java -jar ordenarnumeros.jar
```
Luego escribir números separados por espacios y presionar Enter. El programa ordenará los números ingresados.

### 🔗 Uso de Tuberías (Pipe)

La tubería `|` redirige la salida estándar de un programa a la entrada estándar de otro.

**Comando completo:**
```bash
java -jar aleatorio.jar | java -jar ordenarnumeros.jar
```

**¿Cómo funciona?**
1. `aleatorio.jar` genera 50 números aleatorios y los escribe en stdout
2. El operador `|` captura esa salida
3. La salida capturada se redirige a la entrada (stdin) de `ordenarnumeros.jar`
4. `ordenarnumeros.jar` lee los números, los ordena y los imprime

**Ejemplo de resultado:**
```
Entrada (generada por aleatorio): 54 12 87 23 45 91 ...
Salida (ordenada): 0 2 3 6 8 13 16 17 22 23 25 29 30 32 33 ...
```

## 📊 Diagrama de Flujo

```
┌─────────────────┐
│  aleatorio.jar  │
│  Genera 50      │
│  números random │
└────────┬────────┘
         │ stdout
         ▼
    [ PIPE | ]
         │ stdin
         ▼
┌─────────────────┐
│ordenarnumeros   │
│     .jar        │
│  Lee y ordena   │
└────────┬────────┘
         │
         ▼
    Resultado
    ordenado
```

## 📚 Conceptos Clave

### Entrada y Salida Estándar
- **stdin (Entrada estándar)**: Por defecto, el teclado. Se lee con `System.in`
- **stdout (Salida estándar)**: Por defecto, la consola. Se escribe con `System.out`

### Tubería (Pipe) `|`
- Operador del shell que conecta la salida de un proceso con la entrada de otro
- Permite encadenar comandos y crear flujos de procesamiento de datos
- No requiere archivos intermedios, todo funciona en memoria

## ✅ Criterios de Evaluación Cumplidos

- ✅ Aplicación `ordenarNumeros` acepta número indeterminado de valores
- ✅ Aplicación `aleatorios` genera al menos 40 números aleatorios (genera 50)
- ✅ Documentación completa con Javadoc en ambas aplicaciones
- ✅ Prueba exitosa usando tubería `|` entre ambas aplicaciones
- ✅ No se produce interbloqueo ni inanición
- ✅ La ejecución produce el resultado esperado

## 👨‍💻 Autor

**Pablo Belascoain**

Versión: 1.0

## 📄 Licencia

Este proyecto es parte de una práctica evaluable académica.

---

## 🔍 Notas Adicionales

### Requisitos del Sistema
- Java JDK 8 o superior
- Maven 3.6 o superior
- Sistema operativo con terminal/línea de comandos (Windows, Linux, macOS)

### Solución de Problemas

**Problema:** "No se reconoce java como comando"
- **Solución:** Asegúrate de tener Java instalado y configurado en el PATH del sistema

**Problema:** "No se reconoce mvn como comando"
- **Solución:** Instala Maven y agrégalo al PATH del sistema

**Problema:** Los números no se ordenan correctamente
- **Solución:** Verifica que la salida de `aleatorio` termine con un espacio o salto de línea

### Extensiones Posibles

- Permitir al usuario especificar cuántos números generar
- Agregar opciones de ordenamiento (ascendente/descendente)
- Permitir especificar el rango de números aleatorios
- Agregar validación de entrada más robusta
- Implementar ordenamiento con diferentes algoritmos
