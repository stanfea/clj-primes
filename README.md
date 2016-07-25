# clj-primes

Prints a multiplication table for the first 10 primes

This implementation uses trial division and runs in O(n) space complexity and O(n^2 / ln(n))? time complexity.

(based on the growth rate of the number of primes approximated by n / ln(n))

For large ranges of N, which would be impractical to print out the multiplication table, we can use the sieve of Atkin.
