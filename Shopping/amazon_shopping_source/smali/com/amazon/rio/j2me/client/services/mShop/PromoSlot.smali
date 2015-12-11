.class public Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
.super Ljava/lang/Object;
.source "PromoSlot.java"


# instance fields
.field private action:Lcom/amazon/rio/j2me/client/services/mShop/Action;

.field private clickStreamOrigin:Ljava/lang/String;

.field private imageUrl:Ljava/lang/String;

.field private product:Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

.field private productHeader:Ljava/lang/String;

.field private slotToken:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAction()Lcom/amazon/rio/j2me/client/services/mShop/Action;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->action:Lcom/amazon/rio/j2me/client/services/mShop/Action;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getProduct()Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->product:Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    return-object v0
.end method

.method public getProductHeader()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->productHeader:Ljava/lang/String;

    return-object v0
.end method

.method public getSlotToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->slotToken:Ljava/lang/String;

    return-object v0
.end method

.method public setAction(Lcom/amazon/rio/j2me/client/services/mShop/Action;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Action;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->action:Lcom/amazon/rio/j2me/client/services/mShop/Action;

    .line 54
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->clickStreamOrigin:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->imageUrl:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public setProduct(Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->product:Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 31
    return-void
.end method

.method public setProductHeader(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->productHeader:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setSlotToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;->slotToken:Ljava/lang/String;

    .line 93
    return-void
.end method
