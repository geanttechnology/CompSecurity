.class public Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;
.super Ljava/lang/Object;
.source "GiftOptionSummary.java"


# instance fields
.field private giftOptionItem:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;",
            ">;"
        }
    .end annotation
.end field

.field private orderId:Ljava/lang/String;

.field private printPrice:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setGiftOptionItem(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 53
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;->giftOptionItem:Ljava/util/List;

    .line 54
    return-void
.end method

.method public setOrderId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;->orderId:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setPrintPrice(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOptionSummary;->printPrice:Ljava/lang/Boolean;

    .line 41
    return-void
.end method
