<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="checkLoggedIn.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    <%@ include file="static/custom-style.jsp" %>
</head>

<body class="bg-gray-50 dark:bg-gray-900">
    <section class="flex flex-col items-center justify-center min-h-screen px-6 py-8">
        <a href="#" class="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">
            <img class="w-8 h-8 mr-2" src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/logo.svg"
                alt="logo">
            Book-Store
        </a>
        <div class="w-full bg-white rounded-lg shadow-md dark:border dark:bg-gray-800 dark:border-gray-700 sm:max-w-md">
            <div class=" p-6 space-y-4 md:space-y-6 w-full justify-center">
                <h1 class="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
                    Sign in to your account
                </h1>
                <form class=" flex flex-col  space-y-4 md:space-y-6 flex flex-col " method="post" action="login">
                    <div class="w-full flex flex-col">
                        <label for="email"
                            class=" block mb-2 text-sm font-medium text-gray-900 dark:text-white">Your
                            email</label>
                        <input type="email" name="email" id="email"
                            class="py-2 w-full input-field mx-auto"
                            placeholder="name@company.com" required="">
                    </div>
                    <div class="w-full flex flex-col">
                        <label for="password"
                            class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Password</label>
                        <input type="password" name="password" id="password" placeholder="••••••••"
                            class="py-2 w-full input-field mx-auto"
                            required="">
                    </div>
                    <div class="flex items-center justify-between w-full">
                        <div class="flex items-start">
                            <a href="#"
                                class="text-sm text-blue-500 font-medium text-primary-600 hover:underline dark:text-primary-500">Forgot
                                password?</a>
                        </div>
                    </div>
                    <button type="submit"
                        class="bg-blue-500 h-10 text-white font-bold rounded">Sign in</button>
                    <p class="text-sm font-light text-gray-500 dark:text-gray-400">
                        Don’t have an account yet? <a href="register.jsp"
                            class="font-medium text-blue-500 hover:underline dark:text-primary-500">Sign
                            up</a>
                    </p>
                </form>
            </div>
        </div>
    </section>
</body>

</html>
