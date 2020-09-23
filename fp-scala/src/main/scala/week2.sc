// 2.1
////////////////////////////
// Higher-Order Functions //
////////////////////////////
// - Functional languages treat functions as first-class values
// - This means that, like any other value, a function can be passed as a parameter and returned as a result
// - This provides flexible way to to compose programs
// - Functions that take other functions as a parameters or that return functions as results are called higher order functions

// Examples

// Mathematical sum notation - sum(a <= i <= b) f(i)
def sum(f: Int => Int, a: Int, b: Int): Int= {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
}
def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x

def sumInts(a: Int, b: Int): Int = sum(id, a, b)
def sumCubes(a: Int, b: Int) : Int = sum(cube, a, b)

sumCubes(2, 4)

////////////////////
// Function Types //
////////////////////
// - The type A => B is the type of a function that takes an argument of type A and returns a result of type B

// With anonymous function

// Exercise
def sum1(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
        if (a > b) acc
        else loop(a + 1, acc + f(a))
    }
    loop(a, 0)
}
sum1(x => x, 1, 3)

