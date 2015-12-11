.class public Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
.super Ljava/lang/Object;
.source "PrimeOneClickShippingOffers.java"


# instance fields
.field private note:Ljava/lang/String;

.field private shippingOffers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;",
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
.method public getNote()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->note:Ljava/lang/String;

    return-object v0
.end method

.method public getShippingOffers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->shippingOffers:Ljava/util/List;

    return-object v0
.end method

.method public setNote(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->note:Ljava/lang/String;

    .line 37
    return-void
.end method

.method public setShippingOffers(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->shippingOffers:Ljava/util/List;

    .line 24
    return-void
.end method
