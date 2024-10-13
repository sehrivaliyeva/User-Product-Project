package az.codebridge.task.rest;

public class ProductController {

    /**
     1)Create product(ProductStatus ACTIVE) --> Yeni gelen mehsullarin statusu buna kececek
     2)Update product(Statusdan basqa butun fieldlari update elemek ucun istifade edirik)
     3)Delete product(@PutMapping isledirik, Id sine gore productu getirib statusunu DELETED cevir)
     Statusu DELETED olanlar uje istifade edilmir.
     4)Get product
     5)Get all product(List)
     6)BuyProduct(ACTIVE statusunda olan productlari getirib yoxlama aparib sonra almaq islemini tamamlamalisan.
     Eger ki almaq istediyi miqdar stocda olandan coxdursa o zaman exception atsin. Eger almaq istese o zaman alsin ve
     Status OUT_OF_STOCK a kecsin; Bazadan miqdar azalsin;
     7)ReturnProduct(Aldigi mehsul geri qayitsin ve balance artsin)
     **/
}
