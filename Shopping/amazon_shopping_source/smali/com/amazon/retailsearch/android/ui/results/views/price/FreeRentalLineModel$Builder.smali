.class public Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel$Builder;
.super Ljava/lang/Object;
.source "FreeRentalLineModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/Prices;Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;
    .locals 3
    .param p1, "prices"    # Lcom/amazon/searchapp/retailsearch/model/Prices;
    .param p2, "shipping"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .prologue
    .line 52
    invoke-static {p1, p2}, Lcom/amazon/retailsearch/android/ui/results/ProductUtil;->getShipping(Lcom/amazon/searchapp/retailsearch/model/Prices;Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/searchapp/retailsearch/model/Shipping;

    move-result-object v1

    .line 53
    .local v1, "shippingInfo":Lcom/amazon/searchapp/retailsearch/model/Shipping;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getHasFreeRental()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getFreeRentalLabel()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 58
    :cond_0
    const/4 v0, 0x0

    .line 62
    :goto_0
    return-object v0

    .line 60
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;-><init>()V

    .line 61
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;
    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;->getFreeRentalLabel()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;->setFreeRentalLabel(Ljava/lang/String;)V
    invoke-static {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/price/FreeRentalLineModel;Ljava/lang/String;)V

    goto :goto_0
.end method
