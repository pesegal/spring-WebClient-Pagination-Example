package com.example.paginationconsumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootApplication
public class PaginationConsumerApplication {

	WebClient webClient = WebClient
			.builder()
			.baseUrl("https://reqres.in")
			.build();

	public static void main(String[] args) {
		SpringApplication.run(PaginationConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner runnner() {
		return args -> {
			Response res = this.webClient.get().uri("/api/users").retrieve().bodyToMono(Response.class).block();
			res.getData().stream().forEach(data -> System.out.println(data));
		};
	}

}

class Response {
	Integer page;
	Integer per_page;
	Integer total;
	Integer total_pages;
	List<Data> data;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPer_page() {
		return per_page;
	}

	public void setPer_page(Integer per_page) {
		this.per_page = per_page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response{" +
				"page=" + page +
				", per_page=" + per_page +
				", total=" + total +
				", total_pages=" + total_pages +
				", data=" + data +
				'}';
	}
}


class Data {
	Integer id;
	String email;
	String first_name;
	String last_name;
	String avatar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "Data{" +
				"id=" + id +
				", email='" + email + '\'' +
				", first_name='" + first_name + '\'' +
				", last_name='" + last_name + '\'' +
				", avatar='" + avatar + '\'' +
				'}';
	}
}