<%@page import="java.util.List" %>
<%@page import="com.dao.BookDAO" %>
<%@page import="com.entity.Book" %>

<div class="container mx-auto mt-8 overflow-x-auto">
        <table class="min-w-full bg-white border border-gray-300 divide-y divide-gray-300">
            <thead class="bg-gray-200 text-center">
                <tr>
                	<th class="py-2 px-4 font-bold border">ID</th>
                    <th class="py-2 px-4 font-bold border">Name</th>
                    <th class="py-2 px-4 font-bold border">Author</th>
                    <th class="py-2 px-4 font-bold border">Publication</th>
                    <th class="py-2 px-4 font-bold border">Price</th>
                    <th class="py-2 px-4 font-bold border">Pages</th>
                    <th class="py-2 px-4 font-bold border">Stocks</th>
                    <th class="py-2 px-4 font-bold border">Edition</th>
                    <th class="py-2 px-4 font-bold border">Year</th>
                    <th class="py-2 px-4 font-bold border">Actions</th>
                </tr>
            </thead>
            <tbody class="text-center">
                <!-- Example row, you can add more rows with your data -->
                
                <% 
                	String editBookUrl = "http://localhost:8080/bookstore/EditBook.jsp?id=";
                	String deleteBookUrl = "http://localhost:8080/bookstore/deletebook?id=";
                	BookDAO bd = new BookDAO();
                	List<Book> booklist = bd.getBooks();
                	
                	for(Book book : booklist) {
                		
                %>
                
                <tr class="hover:bg-gray-100">
                	<td class="py-2 px-4 border"><% out.print(book.getId()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getName()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getAuthor()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getPublication()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getPrice()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getPages()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getStocks()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getEdition()); %></td>
                    <td class="py-2 px-4 border"><% out.print(book.getYear()); %></td>
                    <td class="py-2 px-4 border flex justify-center items-center text-center">
                        <a href=<% out.print(editBookUrl + book.getId()); %> class="text-center
text-center bg-blue-500 text-white px-4 py-2 rounded font-semibold">Edit</a>
                        <a href=<% out.print(deleteBookUrl + book.getId()); %> class="text-center
text-center bg-red-500 text-white px-4 py-2 rounded ml-2 font-semibold">Delete</a>
                    </td>
                </tr>
                		
                <%
                	}
                %>
                
                

                <!-- Add more rows with your data as needed -->
            </tbody>
        </table>
    </div>