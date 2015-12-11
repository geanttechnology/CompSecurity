.class public Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
.super Ljava/lang/Object;
.source "OneClickAddress.java"


# instance fields
.field private address:Lcom/amazon/rio/j2me/client/services/mShop/Address;

.field private paymentMethod:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;",
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
.method public getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->address:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    return-object v0
.end method

.method public getPaymentMethod()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;",
            ">;"
        }
    .end annotation

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->paymentMethod:Ljava/util/List;

    return-object v0
.end method

.method public setAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->address:Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 24
    return-void
.end method

.method public setPaymentMethod(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->paymentMethod:Ljava/util/List;

    .line 34
    return-void
.end method
