 <div class="w-full flex flex-col justify-start items-center min-h-screen bg-gray-200 pt-7">
    <form class="flex flex-col h-full justify-center items-center md:bg-white py-7 rounded-lg" action="addbook" method="post">
      <div class="w-full h-full flex items-start justify-center mb-14">
        <h1 class="font-bold text-3xl text-blue-500 underline">Add new book</h1>
      </div>
        <div class="flex flex-col  md:flex-row">
          <div class="flex flex-col justify-center items-center mx-5">
            <div class="flex flex-col justify-start items-start w-full mb-2">
              <label for="name">Name</label>
              <input name="name" type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
            <div class="flex flex-col justify-start items-start w-full mb-2">
              <label for="author">Author</label>
              <input name="author" type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
            <div class="flex flex-col justify-start items-start w-full mb-2">
              <label for="publication">Publication</label>
              <input name="publication"  type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
            <div class="flex flex-col justify-center items-start w-full mb-2">
              <label for="price">Price</label>
              <input name="price" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
          </div >
          <div class="flex flex-col justify-center items-center mx-5">
            <div class="flex flex-col justify-center items-start w-full mb-2">
              <label for="pages">Pages</label>
              <input name="pages" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
            <div class="flex flex-col justify-center items-start w-full mb-2">
              <label for="stocks">Stocks</label>
              <input name="stocks" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
            <div class="flex flex-col justify-center items-start w-full mb-2">
              <label for="edition">Edition</label>
              <input name="edition"type="text" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
            <div class="flex flex-col justify-center items-start w-full mb-2">
              <label for="year">Year</label>
              <input name="year" type="number" class="border border-solid border-black rounded-md h-10 w-full px-2">
            </div>
          </div>
          <div>
        </div>
      </div>
      <button class="bg-blue-500 text-white text-bold h-10 border rounded-lg py-5 text-xl flex justify-center items-center w-11/12 md:w-11/12 my-2" type="submit">Add Book</button>
    </form>
  </div>