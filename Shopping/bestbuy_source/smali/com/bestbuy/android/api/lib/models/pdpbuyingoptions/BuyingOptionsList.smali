.class public Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private availability:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

.field private condition:Ljava/lang/String;

.field private displayCertifiedLogo:Z

.field private displayCondition:Ljava/lang/String;

.field private financingOffers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/FinancingOffers;",
            ">;"
        }
    .end annotation
.end field

.field private price:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

.field private productId:Ljava/lang/String;

.field private properties:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

.field private sellerInfo:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

.field private skuId:Ljava/lang/String;

.field private specialOffers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->availability:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    return-object v0
.end method

.method public getCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->condition:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayCondition()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->displayCondition:Ljava/lang/String;

    return-object v0
.end method

.method public getFinancingOffers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/FinancingOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->financingOffers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->price:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->productId:Ljava/lang/String;

    return-object v0
.end method

.method public getProperties()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->properties:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    return-object v0
.end method

.method public getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->sellerInfo:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public getSpecialOffers()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->specialOffers:Ljava/util/ArrayList;

    return-object v0
.end method

.method public isDisplayCertifiedLogo()Z
    .locals 1

    .prologue
    .line 111
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->displayCertifiedLogo:Z

    return v0
.end method

.method public setAvailability(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->availability:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    .line 84
    return-void
.end method

.method public setCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->condition:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public setDisplayCertifiedLogo(Z)V
    .locals 0

    .prologue
    .line 115
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->displayCertifiedLogo:Z

    .line 116
    return-void
.end method

.method public setDisplayCondition(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->displayCondition:Ljava/lang/String;

    .line 108
    return-void
.end method

.method public setFinancingOffers(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/FinancingOffers;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->financingOffers:Ljava/util/ArrayList;

    .line 68
    return-void
.end method

.method public setPrice(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->price:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    .line 92
    return-void
.end method

.method public setProductId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->productId:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setProperties(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->properties:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    .line 100
    return-void
.end method

.method public setSellerInfo(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->sellerInfo:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    .line 76
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->skuId:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setSpecialOffers(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SpecialOffers;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->specialOffers:Ljava/util/ArrayList;

    .line 60
    return-void
.end method
