class StockService {

    fun getStockPrice(tickerName: String): Double {
        // Some logic to fetch the actual stock price.
        return Math.random() * 100 // returning some random values for brevity
    }
}

class StockRepository(private val stockService: StockService) {
    init {
        /**
         * Constructor with heavy logic to open database connection, and setting observer on {@stockService} to keep
         * the local data in sync with server.
         */
        println("Constructing StockRepository.")
    }

    fun getStockPrice(tickerName: String): Double {
        return stockService.getStockPrice(tickerName)
    }
}


fun main() {
    // Assume constructing this `StockRepository` will take considerable amount of time, so obviously we don't want to
    // do it during main function call and block the execution, rather it would be nice to postpone the
    // initialization until we need this object actually. This is where `lazy` blocks comes to the rescue.
    val stockRepository: StockRepository by lazy {
        // This lamda executes when the `stockRepository` is gets accessed, and the result is stored.
        // The subsequent calls try to access `stockRepository` simply return the remembered result.
        StockRepository(StockService())
    }

    println("After stockRepository property declaration.")

    println("See the StockRepository constructor is not called yet.")

    println("Accessing the stockRepository first time.")
    val tickerNames = listOf<String>("APPL", "TWKS", "GOOG")
    tickerNames.forEach { tickerName -> println("$tickerName -> ${stockRepository.getStockPrice(tickerName)}") }

    println("The End :)")
}
