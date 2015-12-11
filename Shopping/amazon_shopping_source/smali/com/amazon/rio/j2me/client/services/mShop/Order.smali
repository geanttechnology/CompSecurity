.class public Lcom/amazon/rio/j2me/client/services/mShop/Order;
.super Ljava/lang/Object;
.source "Order.java"


# instance fields
.field private item:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Item;",
            ">;"
        }
    .end annotation
.end field

.field private merchantName:Ljava/lang/String;

.field private orderId:Ljava/lang/String;

.field private shippingMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

.field private shippingOption:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;",
            ">;"
        }
    .end annotation
.end field

.field private shippingSpeed:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;",
            ">;"
        }
    .end annotation
.end field

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


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setItem(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Item;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 57
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Item;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Order;->item:Ljava/util/List;

    .line 58
    return-void
.end method

.method public setMerchantName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Order;->merchantName:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setOrderId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Order;->orderId:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setShippingMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Order;->shippingMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .line 110
    return-void
.end method

.method public setShippingOption(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 83
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Order;->shippingOption:Ljava/util/List;

    .line 84
    return-void
.end method

.method public setShippingSpeed(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 96
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Order;->shippingSpeed:Ljava/util/List;

    .line 97
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
    .line 44
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Order;->status:Ljava/util/List;

    .line 45
    return-void
.end method
