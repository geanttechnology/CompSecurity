.class public Lcom/bestbuy/android/api/lib/models/home/SKU;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x303e3a413056b9cL


# instance fields
.field private active:Z

.field private attributes:Lcom/bestbuy/android/api/lib/models/home/Attributes;

.field private availability:Lcom/bestbuy/android/api/lib/models/home/availability/Availability;

.field private brand:Lcom/bestbuy/android/api/lib/models/home/Brand;

.field private brandClass:Lcom/bestbuy/android/api/lib/models/home/BrandClass;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "class"
    .end annotation
.end field

.field private condition:Ljava/lang/String;

.field private customerRatings:Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;

.field private department:Lcom/bestbuy/android/api/lib/models/home/Department;

.field private descriptions:Lcom/bestbuy/android/api/lib/models/home/Descriptions;

.field private itemId:Ljava/lang/String;

.field private manufacturerId:Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;

.field private media:Lcom/bestbuy/android/api/lib/models/home/Media;

.field private meta:Lcom/bestbuy/android/api/lib/models/home/Meta;

.field private names:Lcom/bestbuy/android/api/lib/models/home/Names;

.field private parentCategory:Lcom/bestbuy/android/api/lib/models/home/ParentCategory;

.field private priceBlock:Lcom/bestbuy/android/api/lib/models/home/PriceBlock;

.field private productId:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private properties:Lcom/bestbuy/android/api/lib/models/home/Properties;

.field private skuId:Ljava/lang/String;

.field private specialOffers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/SpecialOffer;",
            ">;"
        }
    .end annotation
.end field

.field private subclass:Lcom/bestbuy/android/api/lib/models/home/SubClass;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAttributes()Lcom/bestbuy/android/api/lib/models/home/Attributes;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->attributes:Lcom/bestbuy/android/api/lib/models/home/Attributes;

    return-object v0
.end method

.method public getAvailability()Lcom/bestbuy/android/api/lib/models/home/availability/Availability;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->availability:Lcom/bestbuy/android/api/lib/models/home/availability/Availability;

    return-object v0
.end method

.method public getBrand()Lcom/bestbuy/android/api/lib/models/home/Brand;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->brand:Lcom/bestbuy/android/api/lib/models/home/Brand;

    return-object v0
.end method

.method public getBrandClass()Lcom/bestbuy/android/api/lib/models/home/BrandClass;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->brandClass:Lcom/bestbuy/android/api/lib/models/home/BrandClass;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerRatings()Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->customerRatings:Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;

    return-object v0
.end method

.method public getDepartment()Lcom/bestbuy/android/api/lib/models/home/Department;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->department:Lcom/bestbuy/android/api/lib/models/home/Department;

    return-object v0
.end method

.method public getDescriptions()Lcom/bestbuy/android/api/lib/models/home/Descriptions;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->descriptions:Lcom/bestbuy/android/api/lib/models/home/Descriptions;

    return-object v0
.end method

.method public getItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->itemId:Ljava/lang/String;

    return-object v0
.end method

.method public getManufacturerId()Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->manufacturerId:Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;

    return-object v0
.end method

.method public getMedia()Lcom/bestbuy/android/api/lib/models/home/Media;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->media:Lcom/bestbuy/android/api/lib/models/home/Media;

    return-object v0
.end method

.method public getMeta()Lcom/bestbuy/android/api/lib/models/home/Meta;
    .locals 1

    .prologue
    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->meta:Lcom/bestbuy/android/api/lib/models/home/Meta;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/home/Names;
    .locals 1

    .prologue
    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    return-object v0
.end method

.method public getParentCategory()Lcom/bestbuy/android/api/lib/models/home/ParentCategory;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->parentCategory:Lcom/bestbuy/android/api/lib/models/home/ParentCategory;

    return-object v0
.end method

.method public getPriceBlock()Lcom/bestbuy/android/api/lib/models/home/PriceBlock;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->priceBlock:Lcom/bestbuy/android/api/lib/models/home/PriceBlock;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getProperties()Lcom/bestbuy/android/api/lib/models/home/Properties;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->properties:Lcom/bestbuy/android/api/lib/models/home/Properties;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSpecialOffers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/SpecialOffer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->specialOffers:Ljava/util/List;

    return-object v0
.end method

.method public getSubclass()Lcom/bestbuy/android/api/lib/models/home/SubClass;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->subclass:Lcom/bestbuy/android/api/lib/models/home/SubClass;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isActive()Z
    .locals 1

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->active:Z

    return v0
.end method

.method public setActive(Z)V
    .locals 0

    .prologue
    .line 211
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->active:Z

    .line 212
    return-void
.end method

.method public setAttributes(Lcom/bestbuy/android/api/lib/models/home/Attributes;)V
    .locals 0

    .prologue
    .line 260
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->attributes:Lcom/bestbuy/android/api/lib/models/home/Attributes;

    .line 261
    return-void
.end method

.method public setAvailability(Lcom/bestbuy/android/api/lib/models/home/availability/Availability;)V
    .locals 0

    .prologue
    .line 267
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->availability:Lcom/bestbuy/android/api/lib/models/home/availability/Availability;

    .line 268
    return-void
.end method

.method public setBrand(Lcom/bestbuy/android/api/lib/models/home/Brand;)V
    .locals 0

    .prologue
    .line 274
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->brand:Lcom/bestbuy/android/api/lib/models/home/Brand;

    .line 275
    return-void
.end method

.method public setBrandClass(Lcom/bestbuy/android/api/lib/models/home/BrandClass;)V
    .locals 0

    .prologue
    .line 281
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->brandClass:Lcom/bestbuy/android/api/lib/models/home/BrandClass;

    .line 282
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->condition:Ljava/lang/String;

    .line 219
    return-void
.end method

.method public setCustomerRatings(Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;)V
    .locals 0

    .prologue
    .line 288
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->customerRatings:Lcom/bestbuy/android/api/lib/models/home/CustomerRatings;

    .line 289
    return-void
.end method

.method public setDepartment(Lcom/bestbuy/android/api/lib/models/home/Department;)V
    .locals 0

    .prologue
    .line 295
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->department:Lcom/bestbuy/android/api/lib/models/home/Department;

    .line 296
    return-void
.end method

.method public setDescriptions(Lcom/bestbuy/android/api/lib/models/home/Descriptions;)V
    .locals 0

    .prologue
    .line 302
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->descriptions:Lcom/bestbuy/android/api/lib/models/home/Descriptions;

    .line 303
    return-void
.end method

.method public setItemId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->itemId:Ljava/lang/String;

    .line 226
    return-void
.end method

.method public setManufacturerId(Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;)V
    .locals 0

    .prologue
    .line 309
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->manufacturerId:Lcom/bestbuy/android/api/lib/models/home/ManufacturerId;

    .line 310
    return-void
.end method

.method public setMedia(Lcom/bestbuy/android/api/lib/models/home/Media;)V
    .locals 0

    .prologue
    .line 316
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->media:Lcom/bestbuy/android/api/lib/models/home/Media;

    .line 317
    return-void
.end method

.method public setMeta(Lcom/bestbuy/android/api/lib/models/home/Meta;)V
    .locals 0

    .prologue
    .line 323
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->meta:Lcom/bestbuy/android/api/lib/models/home/Meta;

    .line 324
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/home/Names;)V
    .locals 0

    .prologue
    .line 330
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->names:Lcom/bestbuy/android/api/lib/models/home/Names;

    .line 331
    return-void
.end method

.method public setParentCategory(Lcom/bestbuy/android/api/lib/models/home/ParentCategory;)V
    .locals 0

    .prologue
    .line 337
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->parentCategory:Lcom/bestbuy/android/api/lib/models/home/ParentCategory;

    .line 338
    return-void
.end method

.method public setPriceBlock(Lcom/bestbuy/android/api/lib/models/home/PriceBlock;)V
    .locals 0

    .prologue
    .line 365
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->priceBlock:Lcom/bestbuy/android/api/lib/models/home/PriceBlock;

    .line 366
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->productId:Ljava/lang/String;

    .line 233
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 239
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->productType:Ljava/lang/String;

    .line 240
    return-void
.end method

.method public setProperties(Lcom/bestbuy/android/api/lib/models/home/Properties;)V
    .locals 0

    .prologue
    .line 344
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->properties:Lcom/bestbuy/android/api/lib/models/home/Properties;

    .line 345
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->skuId:Ljava/lang/String;

    .line 247
    return-void
.end method

.method public setSpecialOffers(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/SpecialOffer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 351
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->specialOffers:Ljava/util/List;

    .line 352
    return-void
.end method

.method public setSubclass(Lcom/bestbuy/android/api/lib/models/home/SubClass;)V
    .locals 0

    .prologue
    .line 358
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->subclass:Lcom/bestbuy/android/api/lib/models/home/SubClass;

    .line 359
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 253
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/SKU;->url:Ljava/lang/String;

    .line 254
    return-void
.end method
