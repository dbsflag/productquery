登山產品管理平台

**主要技術點整合**
Spring Boot 提供了一個整合性的開發框架，簡化了應用程式的配置和部署
Spring MVC 負責處理 Web 請求和響應，並與後端業務邏輯（服務層）進行交互
Spring Data JPA 簡化了資料庫的訪問和操作，並通過 Repository 模式進行 CRUD 操作
JSP 和 JSTL 提供了一個靈活的前端模板系統，允許動態生成 HTML 頁面
JavaScript 和 jQuery 用於實現前端與後端的非同步通訊（AJAX），提高了使用者體驗
Maven 管理專案的依賴和構建，確保開發過程的高效和一致
這些技術共同組成了一個完整的 Web 應用程式開發技術棧，涵蓋了從前端到後端、從資料庫到應用程式伺服器的所有層面

**功能**
先藉由/product/productquerymainaction.controller的URL進入產品查詢主頁面，並透過前端頁面可以操作以下:
1.產品名稱 模糊搜尋
2.產品創建或更新
3.根據ID產品刪除
4.根據 ID 載入產品數據
5.產品清單分頁功能
6.顯示總頁數 總筆數

或是用/product/query/{pid}的URL，透過產品 ID 查詢單一特定產品
/product/queryall的URL，可以查詢全部產品

**運行環境需求**
前端:JSP,HTML/CSS,JavaScript,jQuery
後端:Java,Spring Boot,SQL server,Maven,Eclipse,Spring MVC,Spring Data JPA

