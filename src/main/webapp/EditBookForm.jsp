<%@page import="com.entity.Book" %>
<%@page import="com.dao.BookDAO" %>

		<% 
        	String idAsString = request.getParameter("id");
			if(idAsString == null) {
				response.sendRedirect("error.jsp");
				return;
			}
			int id = Integer.parseInt(idAsString);
        	BookDAO bd = new BookDAO();
        	Book book = bd.getBookFromID(id);
        	
        %>

<div class="w-full flex flex-col justify-start items-center min-h-screen bg-gray-200 pt-7">
    <form class="flex flex-col h-full justify-center items-center md:bg-white py-7 rounded-lg" action="editbook" method="post">
        
        
        
        <div class="w-full h-full flex items-start justify-center mb-14">
            <h1 class="font-bold text-3xl text-blue-500 underline">Edit Book Information</h1>
        </div>
        <div class="flex flex-col  md:flex-row">
            <div class="flex flex-col justify-center items-center mx-5">
            
            	<div class=" hidden flex flex-col justify-start items-start w-full mb-2">
                    <label for="id">Name</label>
                    <input value=<% out.print(book.getId()); %> name="id" type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
                
                <div class="flex flex-col justify-start items-start w-full mb-2">
                    <label for="name">Name</label>
                    <input value=<% out.print(book.getName()); %> name="name" type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
                <div class="flex flex-col justify-start items-start w-full mb-2">
                    <label for="author">Author</label>
                    <input value=<% out.print(book.getAuthor()); %> name="author" type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
                <div class="flex flex-col justify-start items-start w-full mb-2">
                    <label for="publication">Publication</label>
                    <input value=<%out.print(book.getPublication()); %> name="publication"  type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
                <div class="flex flex-col justify-center items-start w-full mb-2">
                    <label for="price">Price</label>
                    <input value=<% out.print(book.getPrice()); %> name="price" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
            </div >
            <div class="flex flex-col justify-center items-center mx-5">
                <div class="flex flex-col justify-center items-start w-full mb-2">
                    <label for="pages">Pages</label>
                    <input value=<% out.print(book.getPages()); %> name="pages" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
                <div class="flex flex-col justify-center items-start w-full mb-2">
                    <label for="stocks">Stocks</label>
                    <input value=<% out.print(book.getStocks()); %> name="stocks" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
                <div class="flex flex-col justify-center items-start w-full mb-2">
                    <label for="edition">Edition</label>
                    <input value=<% out.print(book.getEdition()); %> name="edition"type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
                <div class="flex flex-col justify-center items-start w-full mb-2">
                    <label for="year">Year</label>
                    <input value=<% out.print(book.getYear()); %> name="year" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
                </div>
            </div>
            <div>
            </div>
        </div>
        <button class="bg-blue-500 text-white text-bold h-10 border rounded-lg py-5 text-xl flex justify-center items-center w-11/12 md:w-11/12 my-2" type="submit">Edit Book Information</button>
    </form>
</div>