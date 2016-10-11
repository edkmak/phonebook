# phonebook
A program that allows users to store contacts in a phonebook

Introduction

This phone book application contains entries of names and telephone numbers. A user can add entries, delete entries, list all entries, and search an entry by name. 

Use Cases

Adding a number to the phonebook
The user types in “add” into the console when prompted. The program then asks for the name of the person. The user types in a name. The program then asks for a number. The user types in a 10 digit number. The entry is added to the phonebook. 

Deleted a number from the phonebook
The user types in “delete” into the console when prompted. The user the inputs the name of the entry to be deleted. If there are two entries with the same name, the user must then choose which entry to be deleted. The entry is then deleted from the phonebook.

Searching a person’s entry by name
The user types in “search” into the console when prompted. The user then inputs the name of the entry he/she wishes to search for. All entries found will print to the console

Listing all the entries in the phonebook
The user types in “list” into the console. The phonebook prints the list of all the entries in sorted order.

Classes

This program is comprised of three classes: the Phonebook, the PhonebookEntry class, and the PhonebookStarter class:

The PhonebookEntry class represents a person in the phonebook.

The Phonebook class represents the phonebook and keeps track of the entries. The class contains the add, delete, search, and list all methods. 

The PhonebookStarter class contains the console-based UI which interacts with the user.

Design and Efficiency

To keep track of the different the entries in the phonebook, a balancing BST in the form of TreeMap<String,List<PhonebookEntry>> is used. The keys of the TreeMap are names and the values are lists of entries that have the same name. This mapping makes it easy to keep track of the entries with the same name.




Add
  Avg Case - O(log(N))
  Worst Case - O(N)
Delete
  Avg Case - O(log(N))
  Worst Case - O(N)
Search 
  Avg Case - O(log(N))
  Worst CaseO - (N)
List All
  Avg Case - O(N)
  Worst Case - O(N)

The table above shows the efficiencies of the different methods in the phonebook. The worst case occurs when every entry in the phonebook has the same name but a different number. However, because phonebooks usually have only a few entries with the same name, the add, search, and delete functions will run in O(log(n)) in the average case. The listAll function will run in O(N) in all cases because all nodes must be visited in order to print them. The benefit of using a TreeMap is that it keeps the entries sorted by name. The listAll function will return a sorted list without the extra work of sorting the data. 

A hash table is another possible data structure that could have been used. The main benefit of using a hash table is the average O(1) efficiency of add, search, and delete methods. However, because the size of a phonebook is usually small (<10000 entries), the difference in efficiency between the O(log(n)) and O(1) is minimal. The reason why a hash table is not used is because it does not keep the entries sorted and requires extra work to sort the data.

A trie data structure could have also been used to keep track of the different names in the phonebook. A benefit of a trie would be that the lookup of name would be O(M) where M is the length of the search string. However, trie’s require a large amount of memory compared to a binary search tree because each node requires a 26 character array.

An initial design idea was to map names to a list of numbers, therefore avoiding the need for an entry class. After more consideration, a PhonebookEntry class was created because it allows a developer to easily create/delete fields to change the information stored for each entry. For example, a user can add an address field to the PhonebookEntry class and the Phonebook class will function the same way. 

Data 

An entry represents a person in the phonebook. A name and number is stored for each entry.

Data Constraints:
-The name of a person must be a string containing only letters of the alphabet. 
-The phone number must be 10 digits long (area code and telephone number). 

Constraints between entries within the Phonebook:
-Two entries can have the same name, but different numbers.
-Two entries can have different names but the same number (same home phone).
-Two entries cannot have the same name and number.  

The phonebook is cleared when the process is terminated.
