class books {
    private String title;
    private String author;
    private String isbn;
    private double price;


    public books(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    // Set / Get for Title

    public void setTitle(String Title) {
        if (title.length() <= 80) {
            this.title = Title;
        } else {
            System.out.println("the title of the book is too long!");
        }
    }


    public String getTitle() {
        if (title.length() <= 80) {
            return title;
        } else {
            System.out.println("Error: Cannot get a valid title, please try again!");
            return null;
        }
    }

    // Set / Get for Author

    public void setAuthor(String Author) {
        if (author.length() <= 60) {
            this.author = Author;
        } else {
            System.out.println("the author's name is too long!");
        }
    }


    public String getAuthor() {
        if (author.length() <= 60) {
            return author;
        } else {
            System.out.println("Error: Cannot get a valid author, please try again!");
            return null;
        }
    }

    public void setISBN(String ISBN) {
        if (isbn.length() <= 100) {
            this.isbn = ISBN;
        } else {
            System.out.println("the ISBN code is too long!");
        }
    }

    // Set / Get for ISBN

    public String getISBN() {
        if (isbn.length() <= 100) {
            return title;
        } else {
            System.out.println("Error: Cannot get a valid ISBN, please try again!");
            return null;
        }
    }

    public void setprice(double Price) {
        if (price > 0 && price < 499.99) {
            this.price = Price;
        } else {
            System.out.println("the price is too high or low, please try again!");
        }
    }


    public double getPrice() {
        if (price > 0 && price < 499.99) {
            return price;
        } else {
            System.out.println("Error: Cannot get a valid price, please try again!");
            return -1;
        }
    }











}
