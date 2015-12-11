.class public Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;
.super Ljava/lang/Object;
.source "GiftOptionItem.java"


# instance fields
.field private desc:Ljava/lang/String;

.field private giftMessage:Ljava/lang/String;

.field private giftOption:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;",
            ">;"
        }
    .end annotation
.end field

.field private lineItemId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setDesc(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;->desc:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setGiftMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;->giftMessage:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setGiftOption(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 54
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;->giftOption:Ljava/util/List;

    .line 55
    return-void
.end method

.method public setLineItemId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;->lineItemId:Ljava/lang/String;

    .line 29
    return-void
.end method
