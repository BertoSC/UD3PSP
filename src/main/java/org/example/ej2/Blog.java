package org.example.ej2;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Blog implements Serializable {
   private String content_html;
   private String title;
   private String photo_url;
   private int user_id;
   private LocalDate updated_at;
   public Blog (){}

   public Blog(String content_html, String title, String photo_url, int user_id, LocalDate updated_at) {
      this.content_html = content_html;
      this.title = title;
      this.photo_url = photo_url;
      this.user_id = user_id;
      this.updated_at = updated_at;
   }

   public String getContent_html() {
      return content_html;
   }

   public void setContent_html(String content_html) {
      this.content_html = content_html;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getPhoto_url() {
      return photo_url;
   }

   public void setPhoto_url(String photo_url) {
      this.photo_url = photo_url;
   }

   public int getUser_id() {
      return user_id;
   }

   public void setUser_id(int user_id) {
      this.user_id = user_id;
   }

   public LocalDate getUpdated_at() {
      return updated_at;
   }

   public void setUpdated_at(LocalDate updated_at) {
      this.updated_at = updated_at;
   }

   @Override
   public String toString() {
      return "Blog{" +
              "content_html='" + content_html + '\'' +
              ", title='" + title + '\'' +
              ", photo_url='" + photo_url + '\'' +
              ", user_id=" + user_id +
              ", updated_at=" + updated_at +
              '}';
   }
}
