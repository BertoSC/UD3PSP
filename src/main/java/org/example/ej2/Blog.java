package org.example.ej2;

import java.io.Serializable;

public class Blog implements Serializable {
   private String content_html;
   private String title;
   private String photo_url;

   public Blog (){}

   public Blog(String content_html, String title, String photo_url) {
      this.content_html = content_html;
      this.title = title;
      this.photo_url = photo_url;
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

   @Override
   public String toString() {
      return "Blog{" +
              "content_html='" + content_html + '\'' +
              ", title='" + title + '\'' +
              ", photo_url='" + photo_url + '\'' +
              '}';
   }
}
