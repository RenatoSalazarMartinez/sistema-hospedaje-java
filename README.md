# 🏨 Sistema de Gestión de Hospedaje

Sistema de escritorio desarrollado en **Java (Swing)** para la gestión de estadías, habitaciones, huéspedes y pagos de un hospedaje.  
Incluye control de estados, registro de pagos y exportación de reportes en **PDF y Excel**.

---

## 📌 Características principales

- 📋 Gestión de **estadías** (registro, edición, finalización)
- 🛏️ Control visual de **habitaciones** (disponible, ocupada, limpieza)
- 👤 Gestión de **huéspedes**
- 💳 Registro de **pagos** con distintos métodos:
  - Efectivo
  - Yape
  - Plin
  - Transferencia
- 💰 Pagos parciales y pagos completos
- 📊 Exportación de pagos a:
  - **Excel (.xlsx)**
  - **PDF**
- 🎨 Interfaz moderna usando **FlatLaf**
- 🗄️ Persistencia de datos en **MySQL**

---

## 🧰 Tecnologías utilizadas

- **Java SE**
- **Swing (GUI)**
- **MySQL**
- **Maven**
- **Apache POI** (exportación a Excel)
- **iText / OpenPDF** (exportación a PDF)
- **FlatLaf** (estilos modernos)
- **JDateChooser** (selección de fechas)

---

## 📂 Estructura del proyecto

SistemaHospedaje/                                                                                                                                                 
├──📁 src/                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── 📁 Conexión/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Infraestructura de Red: Gestión de la cadena de conexión y con la base de datos MySQL                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Conexion.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── 📁 Controladores/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Capa de Lógica: Actúa como puente entre la Vista y el DAO                                                                                                                                                                                                                                                                                            
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── ControladorEstadia.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── ControladorHabitacion.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── ControladorHuesped.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── ControladorPago.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── ControladorUsuario.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── 📁DAO/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Data Access Objects (Lógica de base de datos)                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── CRUD.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── EstadiaDAO.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── HabitacionDAO.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── HuespedDAO.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── PagoDAO.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── UsuarioDAO.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── 📁 DTO/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Data Transfer Objects (Modelos de datos)                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Estadia.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Habitacion.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Huesped.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Pago.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Usuario.java                                                                                                                                                                                                                                                                                               
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── 📁 Utilidades/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Clases auxiliares y herramientas                                                                                                                                                   
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── ExportarPagosExcel.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── ExportarPagosPDF.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;├── 📁 Vistas/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Interfaces Gráficas (Swing + FlatLaf)                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── FrmEstadias.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── FrmHabitaciones.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── FrmHuespedes.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── FrmLogin.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── FrmPagos.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── FrmPrincipal.java                                                                                                                                                 
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── FrmUsuarios.java                                                                                                                                                                                                                                                                                              
│&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;└── Main.java&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Clase de inicio del sistema                                                                                                                                                 
├── 📚 lib/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Librerías externas (.jar)                                                                                                                                                 
├── 🖼️ resources/&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Activos (Iconos, Imágenes, Config)                                                                                                                                                 
├── ⚙️ pom.xml&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;# Gestión de dependencias (Maven)                                                                                                                                                 

---

## 🧰 Dependencias utilizadas

El proyecto se gestiona con Maven y utiliza las siguientes librerías:
| Depedencia | Propósito | Versión |
| ------------ | ------------ | ------------ |
| FlatLaf | Interfaz de usuario moderna estilo IntelliJ. | 3.5.4 |
| MySql Connector | Componentes para selección de fechas. | 8.3.0 |
| JCalendar | Componentes para selección de fechas. | 1.4 |
| Apache POI | Exportación a archivos Excel. | 5.2.5 |
| IText7 Core | Generación de documentos PDF. | 7.2.5 |
