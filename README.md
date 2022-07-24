# **HOMEWORK-5**
## 1. Spring Profile nedir? Properties ya da yml dosya formları ile isbasi uygulamasına test profile ekleyin.(5 Puan)

Bir Spring projesinde kullanılan sınıf, bean, component ve configuration üyelerinin amaçlarını belirterek onların kontrolünü kolaylaştıran bir yöntem sağlar. Spesifik bir profile göre üretim ve test ortamları çerçevesinde profiller bazında gerekli üyelerin kontrol eder.

## 2. SQL injection örnekleyin. Nasıl korunabiliriz?(5 Puan)

SQL Injection, Database tabanlı uygulamalardan hassas veri çalabilmek amacıyla kullanılan ataklardan biridir. Bu yöntemi kullananan biri, birkaç farklı yöntem ile Database'e saldırabilir. Önemli yöntemlerden biri, Database'e direkt gönderilen query üzerinde gerçekleşebilir. Örneğin tek bir kullanıcının hassas bilgisini çekmek adına kullanılan bir query'e OR kapısı ve true statement ile tüm kullanıcıların hassas bilgilerini çekebilir.
```
SELECT * FROM Users WHERE UserId = 105 OR 1=1;
```

Bir farklı örnek ise girilen parametrenin erişilebilmesidir. Bu parametre dış kullanıcı tarafından manipule edilip farklı hassas değerler elde edilebilir. Örneğin aşağıdaki sql query'sinde email değeri değiştirilip, farklı hassas değerlere ulaşılabilir.

```
String sql = "SELECT * FROM users WHERE email = '" + email + "'";

```

Bu ataklardan korunmanın bazı yolları var. Örneğin:
* Kullanılan uygulamalara erişim yetkisi dağıtma. Bunun anlamı hangi servislerin ne yapmaya yetkisi olabileceğini(INSERT, UPDATE, DELETE) belirlemektir.
* Birden fazla Database kullanmak.
* Verilerin bütünlüğünü sürekli kontrol etmek.

## 3. Aşağıdaki kurallara göre bir film öneri uygulaması yazın. (90 Puan)

### **Teknolojiler;**
* Min Java8
* Spring Boot
* Restfull
* MySQL - Postgre - Mongo(Her servis farklı database kullanabilir)
* RabbitMQ

### **Gereksinimler;**

* Kullanıcı sisteme kayıt olup, login olabilmelidir.(Login işlemi için email ve şifre bilgileri
gereklidir.)
* Kullanıcı şifresi istediğiniz bir hashing algoritmasıyla database kaydedilmelidir.
* Kullanıcılar sisteme film ekleyebilir ve bu filmler herkes tarafından görülebilir.
* Kullanıcı kendi eklediği filmleri görebilmeli.(Profil sayfası gibi düşünün)
* Kullanıcı şifresini ve ismini değiştirebilir.
* Ücretli üye olmayan kullanıcılar sadece 3 film ekleyebilir.
* Ücretli üye olmayan kullanıcılar filmlere yorum yapamaz.
* Sisteme yeni bir film girildiğinde kullanıcılara email gider.
* Sistemi takip edebilmek için gerekli gördüğünüz yerlere Log ekleyin.

### **Sistem Kabulleri;**

* Ödeme işlemi senkron gerçekleşmelidir.
* Ödeme servisi sadece ödeme bilgilerini kaydeder ve başarılı response döner.
* Email gönderme işlemi asenkron gerçekleşmelidir.
* Üyelikler 1-3-6-12 ay olarak alınabilir.

## Proje Açıklaması
MovieUser, kullanıcı ile ilgili işlemlerin halledildiği projedir. Kullanıcı bilgileri, üyelik bilgileri, alınan emailler ve girilen filmleri içerir. Üyelik işlemleri, ödeme(membership) işlemleri gibi işlemler burada gerçekleşir. Ödeme senkron gerçekleşir. Öncelikle bazı entity'lerin kurulması adına bu projenin çalıştırılması gerekir.

MovieHome, filmlerin ve onlara ait bilgilerin işlendiği projedir. Filmlerle ilgili tüm işlemler burada yapılır. Film girildiği zaman, RabbitMQ üzerinden bilgiler MovieUser'a gönderilir ve burada herkese email gönderilir. Bu işlem asenkron olarak gerçekleşir.

NOT: Maalesef MovieHome'da kullandığım JDBC tarafında bir sorun yaşadım. O yüzden MovieHome tarafında herhangi bir bilgi alışverişi olmamaktadır.
