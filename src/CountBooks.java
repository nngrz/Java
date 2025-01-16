class Book {
    private String author;
    private String title;
    private String body;

    public Book(String name, String title, String body) {
        this.author = name;
        this.title = title;
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }
}

class Shelf {
    private String id;
    private Book[] books;

    public Shelf (String id, Book[] books) {
        this.id = id;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public Book[] getBooks() {
        return books;
    }
}

class Library {
    private Shelf[] shelves;

    public Library(Shelf[] shelves) {
        this.shelves = shelves;
    }

    public Shelf[] getShelves() {
        return shelves;
    }

    public int countAuthor(String authorName) {
        int count = 0;
        
        // Seacher each shelf
        for (Shelf shelf : shelves) {
            // Seacher each book of the shelf
            for (Book book : shelf.getBooks()) {
                // If the author name of the book equals to the user input, count++
                if (book.getAuthor().equals(authorName)) {
                    count++;
                }
            }
        }
        return count;
    }
}

class CountBooks {
    public static void main (String[] args) {
        Shelf shelf1 = new Shelf("Shelf1",
            new Book[]{
                new Book("Babel","Odessa Tales","babelode"),
                new Book("Joyce","Ulisses","joyceuli")
        });
        Shelf shelf2 = new Shelf("Shelf2",
            new Book[]{
                new Book("Mann","Dr Faustus","mannfau"),
                new Book("Babel","Red Cavalry","babelred")
        });
        Library lib = new Library(
            new Shelf[]{shelf1,shelf2});

        System.out.println("Number of books by this author: " + lib.countAuthor("Babel"));
     }
}
