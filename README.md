# Kotlin docs

### What does ```by``` keyword does
<details>
  <summary>Click to expand</summary>

* One word answer would be it does `Property delegation`
  #### Property delegation
    * Kotlin supports property delegation on both primitive and user defined types
    * Using `by` keyword we can delegate the access of getter/setter to other classes
    * Syntax is `val/var <property name>: <Type> by <expression>`
        * Ex `val someValue: <Type> by delegate`
        * Where `someValue` is our regular const value which will read its value from `delegate`
        * Where `delegate`is class implementing either `kotlin.reflect.KProperty.ReadOnlyProperty` or
          `kotlin.reflect.KProperty.ReadWriteProperty`
        * `ReadOnlyProperty` is used when we use `by` keyword for const value since value cannot be reassiged
        * `ReadWriteProperty` is used when we use `by` keyword for mutable values.
          This interface has two operator overloaded methods called `getValue` and `setValue` which will be called
          when trying to read and write data to the variable respectively.
        * Delegates don't have to implement any interface as long it has `getValue` and (`setValue` only for var).

  #### Example [code](src/main/kotlin/ByKeywordExample.kt)

</details>

### Lazy
<details>
  <summary>Click to expand</summary>

* `lazy` is a function which takes a `initializer` block and executes when a first call to `getValue`
  happens on a property and remeber the result, all the subsequent calls will get the result computed form the
  `initializer` function.
  
* By default `lazy` executes the `initializer` block in synchronized, there is another overloaded function which
  `lazy(mode: LazyThreadSafetyMode, initializer: () -> T)` which takes mode as first argument to run the block in 
  non-synchronized mode (i.e `LazyThreadSafetyMode.PUBLICATION`) 

#### Example [code](src/main/kotlin/LazyKeywordExample.kt)
</details>


