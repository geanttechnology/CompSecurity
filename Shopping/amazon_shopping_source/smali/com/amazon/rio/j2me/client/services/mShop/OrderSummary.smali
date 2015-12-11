.class public Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;
.super Ljava/lang/Object;
.source "OrderSummary.java"


# instance fields
.field private giftCardPresent:Ljava/lang/Boolean;

.field private giftCardPromoSubtotal:Ljava/lang/String;

.field private subtotalSection:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SubtotalSection;",
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
.method public setGiftCardPresent(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;->giftCardPresent:Ljava/lang/Boolean;

    .line 54
    return-void
.end method

.method public setGiftCardPromoSubtotal(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;->giftCardPromoSubtotal:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setSubtotalSection(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/SubtotalSection;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/SubtotalSection;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OrderSummary;->subtotalSection:Ljava/util/List;

    .line 28
    return-void
.end method
