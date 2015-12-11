.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private active:Z

.field private attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

.field private availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

.field private brand:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

.field private classAttribute:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "class"
    .end annotation
.end field

.field private condition:Ljava/lang/String;

.field private customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

.field private department:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;

.field private descriptions:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

.field private itemId:Ljava/lang/String;

.field private manufacturerId:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

.field private media:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

.field private meta:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;

.field private names:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

.field private parentCategory:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ParentCategory;

.field private pdpMedia:Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

.field private productId:Ljava/lang/String;

.field private productType:Ljava/lang/String;

.field private properties:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

.field private skuId:Ljava/lang/String;

.field private specialOffers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;",
            ">;"
        }
    .end annotation
.end field

.field private subclass:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SubClass;

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
.method public getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    return-object v0
.end method

.method public getAvailability()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    return-object v0
.end method

.method public getBrand()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->brand:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    return-object v0
.end method

.method public getClassAttribute()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->classAttribute:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    return-object v0
.end method

.method public getDepartment()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->department:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;

    return-object v0
.end method

.method public getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->descriptions:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    return-object v0
.end method

.method public getItemId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->itemId:Ljava/lang/String;

    return-object v0
.end method

.method public getManufacturerId()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->manufacturerId:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    return-object v0
.end method

.method public getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->media:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    return-object v0
.end method

.method public getMeta()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;
    .locals 1

    .prologue
    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->meta:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->names:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    return-object v0
.end method

.method public getParentCategory()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ParentCategory;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->parentCategory:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ParentCategory;

    return-object v0
.end method

.method public getPdpMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->pdpMedia:Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->properties:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSpecialOffers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->specialOffers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getSubclass()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SubClass;
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->subclass:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SubClass;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->url:Ljava/lang/String;

    return-object v0
.end method

.method public isActive()Z
    .locals 1

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->active:Z

    return v0
.end method

.method public setActive(Z)V
    .locals 0

    .prologue
    .line 231
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->active:Z

    .line 232
    return-void
.end method

.method public setAttributes(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;)V
    .locals 0

    .prologue
    .line 280
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->attributes:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    .line 281
    return-void
.end method

.method public setAvailability(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;)V
    .locals 0

    .prologue
    .line 287
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->availability:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Availability;

    .line 288
    return-void
.end method

.method public setBrand(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;)V
    .locals 0

    .prologue
    .line 294
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->brand:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Brand;

    .line 295
    return-void
.end method

.method public setClassAttribute(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;)V
    .locals 0

    .prologue
    .line 301
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->classAttribute:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Class;

    .line 302
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 238
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->condition:Ljava/lang/String;

    .line 239
    return-void
.end method

.method public setCustomerRatings(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;)V
    .locals 0

    .prologue
    .line 308
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->customerRatings:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    .line 309
    return-void
.end method

.method public setDepartment(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;)V
    .locals 0

    .prologue
    .line 315
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->department:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Department;

    .line 316
    return-void
.end method

.method public setDescriptions(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;)V
    .locals 0

    .prologue
    .line 322
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->descriptions:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    .line 323
    return-void
.end method

.method public setItemId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 245
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->itemId:Ljava/lang/String;

    .line 246
    return-void
.end method

.method public setManufacturerId(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;)V
    .locals 0

    .prologue
    .line 329
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->manufacturerId:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Manufacturer;

    .line 330
    return-void
.end method

.method public setMedia(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;)V
    .locals 0

    .prologue
    .line 336
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->media:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    .line 337
    return-void
.end method

.method public setMeta(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;)V
    .locals 0

    .prologue
    .line 343
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->meta:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Meta;

    .line 344
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;)V
    .locals 0

    .prologue
    .line 350
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->names:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    .line 351
    return-void
.end method

.method public setParentCategory(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ParentCategory;)V
    .locals 0

    .prologue
    .line 357
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->parentCategory:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ParentCategory;

    .line 358
    return-void
.end method

.method public setPdpMedia(Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;)V
    .locals 0

    .prologue
    .line 70
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->pdpMedia:Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    .line 71
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 252
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->productId:Ljava/lang/String;

    .line 253
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 259
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->productType:Ljava/lang/String;

    .line 260
    return-void
.end method

.method public setProperties(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->properties:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    .line 365
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 266
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->skuId:Ljava/lang/String;

    .line 267
    return-void
.end method

.method public setSpecialOffers(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SpecialOffers;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 371
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->specialOffers:Ljava/util/ArrayList;

    .line 372
    return-void
.end method

.method public setSubclass(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SubClass;)V
    .locals 0

    .prologue
    .line 378
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->subclass:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SubClass;

    .line 379
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 273
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->url:Ljava/lang/String;

    .line 274
    return-void
.end method
