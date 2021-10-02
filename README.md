# Kotlin docs

### what does ```by``` keyword does
* One word answer would be it does `Property delegation`
    #### Property delegation
    * Kotlin supports property delegation on both primitive and user defined types
    * Using `by` keyword we can delegate the access of getter/setter to other classes
    * Syntax is `val someValue by delegate`
        * Where `someValue` is our regular const value which will read its value from `delegate`
        * Where `delegate`is class implementing either `kotlin.reflect.KProperty.ReadOnlyProperty` or 
          `kotlin.reflect.KProperty.ReadWriteProperty`
        * `ReadOnlyProperty` is used when we use `by` keyword for const value since value cannot be reassiged
        * `ReadWriteProperty` is used when we use `by` keyword for mutable values.
          This interface has two operator overloaded methods called `getValue` and `setValue` which will be called
          when trying to read and write data to the variable respectively. 
          
    #### Example [code](src/main/kotlin/ByKeywordExample.kt)

