.class public Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
.super Ljava/lang/Object;
.source "CartItems.java"


# instance fields
.field private alertMessages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;",
            ">;"
        }
    .end annotation
.end field

.field private alertMessagesDetailed:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;",
            ">;"
        }
    .end annotation
.end field

.field private alternateCartButton:Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;

.field private cartButtonUri:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

.field private cartItem:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CartItem;",
            ">;"
        }
    .end annotation
.end field

.field private interstitialCartInfo:Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;

.field private messages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private pointsTotal:Ljava/lang/String;

.field private subtotal:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCartItem()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CartItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->cartItem:Ljava/util/List;

    return-object v0
.end method

.method public getMessages()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->messages:Ljava/util/List;

    return-object v0
.end method

.method public setAlertMessages(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 66
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->alertMessages:Ljava/util/List;

    .line 67
    return-void
.end method

.method public setAlertMessagesDetailed(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 79
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->alertMessagesDetailed:Ljava/util/List;

    .line 80
    return-void
.end method

.method public setAlternateCartButton(Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->alternateCartButton:Lcom/amazon/rio/j2me/client/services/mShop/ButtonInfo;

    .line 119
    return-void
.end method

.method public setCartButtonUri(Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->cartButtonUri:Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    .line 106
    return-void
.end method

.method public setCartItem(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/CartItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->cartItem:Ljava/util/List;

    .line 31
    return-void
.end method

.method public setInterstitialCartInfo(Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->interstitialCartInfo:Lcom/amazon/rio/j2me/client/services/mShop/InterstitialCartItemsInfo;

    .line 132
    return-void
.end method

.method public setMessages(Ljava/util/List;)V
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
    .line 53
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->messages:Ljava/util/List;

    .line 54
    return-void
.end method

.method public setPointsTotal(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->pointsTotal:Ljava/lang/String;

    .line 93
    return-void
.end method

.method public setSubtotal(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->subtotal:Ljava/lang/String;

    .line 41
    return-void
.end method
