.class public Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PurchaseEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Purchase;


# instance fields
.field private buyingPrice:Ljava/lang/String;

.field private date:Ljava/lang/String;

.field private image:Lcom/amazon/searchapp/retailsearch/model/Image;

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private prime:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getBuyingPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->buyingPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->date:Ljava/lang/String;

    return-object v0
.end method

.method public getImage()Lcom/amazon/searchapp/retailsearch/model/Image;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->image:Lcom/amazon/searchapp/retailsearch/model/Image;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->prime:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setBuyingPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "buyingPrice"    # Ljava/lang/String;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->buyingPrice:Ljava/lang/String;

    .line 150
    return-void
.end method

.method public setDate(Ljava/lang/String;)V
    .locals 0
    .param p1, "date"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->date:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setImage(Lcom/amazon/searchapp/retailsearch/model/Image;)V
    .locals 0
    .param p1, "image"    # Lcom/amazon/searchapp/retailsearch/model/Image;

    .prologue
    .line 129
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->image:Lcom/amazon/searchapp/retailsearch/model/Image;

    .line 130
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 70
    return-void
.end method

.method public setPrime(Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;)V
    .locals 0
    .param p1, "prime"    # Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->prime:Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    .line 50
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PurchaseEntity;->title:Ljava/lang/String;

    .line 90
    return-void
.end method
