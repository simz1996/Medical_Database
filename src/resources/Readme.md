Electronic Medical Record Extraction System
Overview
The Electronic Medical Record (EMR) Extraction System is designed to extract structured information from electronic medical record (EMR) data stored in CSV files, validate and parse the data, and store it in a MySQL database. The system provides functionality to handle irregular data, parse medical records, store them in a database, and display them for users.

Components
EMRSystem: The main class serving as the entry point of the system. It orchestrates the entire process, including extraction, validation, parsing, storage, and display of medical records.

MedicalRecordExtractor: Responsible for extracting medical records from a CSV file. It reads the CSV file, treats each line as a separate medical record, and returns a list of medical records.

IrregularDataHandler: Handles any irregularities in the medical records. It applies logic to handle irregular data before further processing.

MedicalRecordParser: Parses the medical records extracted from the CSV file. It applies specific parsing logic to extract structured information from the medical records.

DatabaseManager: Manages the interaction with the MySQL database. It provides methods for storing medical records in the database.

MedicalRecordDisplay: Retrieves medical records from the database and displays them. It enables users to view the stored medical records.

Usage
Clone the repository to your local machine.

Update the database connection details in the DatabaseManager class according to your MySQL server configuration.

Place your CSV file containing medical records in the "resources" directory of the project.

Compile and run the EMRSystem class to extract, validate, parse, store, and display medical records.

Requirements
Java Development Kit (JDK)
MySQL Server
MySQL Connector/J (for JDBC connectivity)

Chinese README.md
电子病历提取系统
该项目旨在使用Java从电子病历数据中提取有规律的信息，并以结构化的方式存储。

项目结构
项目目录包含以下文件：

MedicalRecordParser.java：包含用于从病历中解析症状和状态的MedicalRecordParser类。
IrregularDataHandler.java：包含用于处理不规则数据的IrregularDataHandler类。
MedicalRecordExtractor.java：包含用于从Excel文件中提取信息的MedicalRecordExtractor类。
DatabaseManager.java：包含用于将提取的数据存储在MySQL数据库中的DatabaseManager类。
MedicalRecordDisplay.java：包含用于显示病历和提取的数据的MedicalRecordDisplay类。
使用说明
要使用提供的代码文件实现每个任务：

1. 研究特定表达规则
打开 MedicalRecordParser.java 文件。
根据特定的表达规则自定义 parseSymptoms 和 parseStatus 方法。
编译并运行程序以应用更新后的解析规则。
2. 设计兼容性解决方案
打开 IrregularDataHandler.java 文件。
在 handleIrregularData 方法中实现自定义逻辑以处理不规则数据。
编译并运行程序以处理不规则数据。
3. 开发信息提取工具
打开 MedicalRecordExtractor.java 文件。
根据需要自定义 extractInformationFromExcel 方法以从Excel文件中提取信息。
编译并运行程序以提取信息。
4. 将提取的数据存储在MySQL中
打开 DatabaseManager.java 文件。
自定义 storeData 方法以将提取的数据存储在MySQL数据库中。
确保MySQL服务器正在运行，并配置数据库连接参数。
编译并运行程序以将数据存储在MySQL中。
5. 提供显示功能
打开 MedicalRecordDisplay.java 文件。
根据需要自定义 displayMedicalRecords 和 displayExtractedData 方法以显示病历和提取的数据。
编译并运行程序以显示数据。

6. 将 main 文件用于执行程序，只需导入执行任务所需的类并编译和运行它们。

7. 要编译程序，使用以下命令: javac -cp Main.java MedicalRecordExtractor.java MedicalRecordParser.java MedicalRecordDisplay.java DatabaseManager.java IrregularDataHandler.java DatabaseConfig.java

8. 要运行程序，请使用以下命令: java Main/(java -cp ".:lib/*:./" Main
)


医疗记录数据库访问
此存储库包含用于访问和管理MySQL数据库中的医疗记录数据的类。它包括两个主要类：MedicalRecordDAO 用于数据库操作和 DatabaseConfig 用于配置数据库连接。

使用方法
1. 数据库配置
根据您的MySQL服务器配置更新 DatabaseConfig 类中的数据库连接详细信息。使用您的数据库URL、用户名和密码修改 DB_URL、DB_USER 和 DB_PASSWORD 常量。

2. 医疗记录DAO
MedicalRecordDAO 类提供了执行与医疗记录相关的数据库操作的方法。它包括一个 insertRecord 方法，用于将新的医疗记录插入数据库。

要使用 MedicalRecordDAO 类，请按照以下步骤操作：

创建 MedicalRecordDAO 的一个实例。
使用症状和状态作为参数调用 insertRecord 方法。





