** This is a sample application that shows how data binding can be used with RecyclerView **
It has 2 RecyclerView lists. 1 of them has the same item type and the other one has mixed items.

All of the items from the first list are included in the second list so you can observe how
two lists stay in sync.

You should take a look at `BaseDataBoundAdapter` class which adds a callback to the data binding
class to prevent items from updating themselves. Instead, it notifies the RecyclerView about the
change and waits for the RecyclerView to call onBind for that item.

This allows RecyclerView animations to work well and avoid unnecessary layout passes.