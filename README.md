**Exercise**<br>
Silver Bars Marketplace - Live Order Board
- - -

The implementation is presented as a console CLI app utilising an in memory solution.<br>
The user can:

- Register an order
- Cancel an order by Order ID (index)
- View all ordered entered
- Get a summary of BUY orders (sorted from highest to lowest)
- Get a summary of SELL orders (sorted from lowest to highest)
- Use usual getters to retrieve raw data from either the full, buy-only or sell-only orders list

BUY and SELL summary views also provide the the total amount of KGs for a common price.

To implement order filtering and summary views originally I thought of using classic loops, but the potential complexity and verbosity made me decide to use Java 8 streams.
This allowed to code to be more concise, readable and efficient.
