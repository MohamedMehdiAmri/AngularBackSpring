package com.example.car.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="car")
public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="author")
	private String author;
	
	@Column(name="category")
	private String category;

	
	@Column(name="price")
	private int price;

	@Column(name = "kilometrage")
	private int kilometrage;

	
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", author=" + author + ", category=" + category + ", price=" + price
				+ ", kilometrage=" + kilometrage + ", year=" + year + ", quantity=" + quantity + ", phone_number="
				+ phone_number + ", brand=" + brand + ", puissance=" + puissance + ", imgName=" + imgName + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "year")
	private String year;

	@Column(name = "quantity")
	private String quantity;


	@Column(name = "phone_number")
	private String phone_number;

	@ManyToOne
	private Marque brand;
	
	@Column(name = "puissance")
	private String puissance;
    
	@Column(name = "imgName")
	private String imgName;

	public String getImage() {
		return imgName;
	}

	public void setImage(String image) {
		this.imgName = image;
	}

	public Car() {
		super();
	}

	public Car(int id, String name, String author, String category, int price, int kilometrage, String year,
			String quantity, String phone_number, Marque brand, String puissance, String imgName) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
		this.price = price;
		this.kilometrage = kilometrage;
		this.year = year;
		this.quantity = quantity;
		this.phone_number = phone_number;
		this.brand = brand;
		this.puissance = puissance;
		this.imgName = imgName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Marque getBrand() {
		return brand;
	}

	public void setBrand(Marque brand) {
		this.brand = brand;
	}

	public String getPuissance() {
		return puissance;
	}

	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}

	}