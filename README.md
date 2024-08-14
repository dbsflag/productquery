登山產品清單管理平台

**Demo影片連結**
https://youtu.be/5DDqZzlJBAs

**主要技術點整合**
Spring Boot 提供了一個整合性的開發框架，簡化了應用程式的配置和部署。
Spring MVC 負責處理 Web 請求和響應，並與後端業務邏輯（服務層）進行交互。
Spring Data JPA 簡化了資料庫的訪問和操作，並通過 Repository 模式進行 CRUD 操作。
JSP 和 JSTL 提供了一個靈活的前端模板系統，允許動態生成 HTML 頁面。
JavaScript 和 jQuery 用於實現前端與後端的非同步通訊（AJAX），提高了使用者體驗。
Maven 管理專案的依賴和構建，確保開發過程的高效和一致。
這些技術共同組成了一個完整的 Web 應用程式開發技術棧，涵蓋了從前端到後端、從資料庫到應用程式伺服器的所有層面。

**功能**
先藉由/product/productquerymainaction.controller的URL進入產品查詢主頁面，並透過前端頁面可以操作以下:
1.產品名稱 模糊搜尋
2.產品創建或更新
3.根據ID產品刪除
4.根據 ID 載入產品數據
5.產品清單分頁功能
6.顯示總頁數 總筆數

或是用/product/query/{pid}的URL，透過產品 ID 查詢單一特定產品。 
用/product/queryall的URL，可以查詢全部產品。

**運行環境需求**
前端:JSP,HTML/CSS,JavaScript,jQuery
後端:Java,Spring Boot,SQL server,Maven,Eclipse,Spring MVC,Spring Data JPA


### Hiking Product List Management Platform

**Demo Video:** [https://youtu.be/5DDqZzlJBAs](https://youtu.be/5DDqZzlJBAs)

**Key Technologies:**

This project integrates several key technologies to create a comprehensive development framework. 

- **Spring Boot:** Provides an integrated development framework that simplifies application configuration and deployment.
- **Spring MVC:** Handles web requests and responses, interacting with the backend business logic (service layer).
- **Spring Data JPA:** Simplifies database access and operations through the Repository pattern, enabling efficient CRUD operations.
- **JSP and JSTL:** Offer a flexible front-end templating system, allowing dynamic generation of HTML pages.
- **JavaScript and jQuery:** Implement asynchronous communication (AJAX) between the front-end and back-end, enhancing the user experience.
- **Maven:** Manages project dependencies and builds, ensuring an efficient and consistent development process.

These technologies together form a complete web application development stack, covering all layers from front-end to back-end, and from the database to the application server.

**Features:**

- Access the main product query page via the URL `/product/productquerymainaction.controller`, and perform the following actions from the front-end interface:
  1. Fuzzy search by product name.
  2. Create or update products.
  3. Delete products by ID.
  4. Load product data by ID.
  5. Pagination for the product list.
  6. Display total page count and total record count.
  
- Query a single specific product using the URL `/product/query/{pid}` with the product ID.
- Query all products using the URL `/product/queryall`.

**Environment Requirements:**

- **Front-end:** JSP, HTML/CSS, JavaScript, jQuery
- **Back-end:** Java, Spring Boot, SQL Server, Maven, Eclipse, Spring MVC, Spring Data JPA




