.class public Lcom/amazon/rio/j2me/client/services/mShop/Item;
.super Ljava/lang/Object;
.source "Item.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private binding:Ljava/lang/String;

.field private byLine:Ljava/lang/String;

.field private imageUrl:Ljava/lang/String;

.field private itemId:Ljava/lang/String;

.field private lineItemId:Ljava/lang/String;

.field private merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

.field private price:Ljava/lang/String;

.field private quantity:I

.field private status:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->asin:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public setBinding(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 149
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->binding:Ljava/lang/String;

    .line 150
    return-void
.end method

.method public setByLine(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 162
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->byLine:Ljava/lang/String;

    .line 163
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->imageUrl:Ljava/lang/String;

    .line 137
    return-void
.end method

.method public setItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->itemId:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public setLineItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 87
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->lineItemId:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setMerchantInfo(Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->merchantInfo:Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    .line 124
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->price:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setQuantity(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 110
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->quantity:I

    .line 111
    return-void
.end method

.method public setStatus(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->status:Ljava/util/List;

    .line 62
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Item;->title:Ljava/lang/String;

    .line 49
    return-void
.end method
