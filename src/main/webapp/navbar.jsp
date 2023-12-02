<nav class="bg-gray-800 p-4">
        <div class="container mx-auto flex items-center justify-between h-full">
            <!-- Logo -->
            <a href="#" class="text-white text-lg font-bold">Book-Store</a>

            <!-- Navigation Links -->
            <div class="space-x-4 hidden md:flex justify-center items-center h-full">
                <a href="home.jsp#" class="text-white">Home</a>
                <a href="AddBook.jsp#" class="text-white">Add Book</a>
                <a href="logout" class="text-white font-bold bg-red-500 h-full px-3 py-2 rounded-md">Log Out</a>
            </div>
            <!-- Mobile Menu (Hidden by default) -->
            <div id="mobile-menu" class="md:hidden hidden ">
                <a href="home.jsp#" class="block text-white py-2">Home</a>
                <a href="AddBook.jsp#" class="block text-white py-2">Add Book</a>
                <a href="logout" class="block text-white font-bold bg-red-500 rounded-md px-3 text-center py-2">Log Out</a>
            </div>

            <!-- Mobile Menu Button -->
            <div class="md:hidden">
                <button id="mobile-menu-button" class="text-white">
                    <svg class="h-6 w-6" fill="none" stroke="currentColor" viewBox="0 0 24 24"
                        xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M4 6h16M4 12h16m-7 6h7"></path>
                    </svg>
                </button>
            </div>

        </div>
    </nav>