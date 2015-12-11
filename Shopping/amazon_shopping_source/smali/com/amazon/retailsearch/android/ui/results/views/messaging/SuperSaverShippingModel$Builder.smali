.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel$Builder;
.super Ljava/lang/Object;
.source "SuperSaverShippingModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/Shipping;)Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    .locals 2
    .param p1, "shippingInfo"    # Lcom/amazon/searchapp/retailsearch/model/Shipping;

    .prologue
    .line 54
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getSss()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getSss()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 56
    :cond_0
    const/4 v0, 0x0

    .line 60
    :goto_0
    return-object v0

    .line 58
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;-><init>()V

    .line 59
    .local v0, "model":Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Shipping;->getSss()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/SuperSaverShippingModel;->setSuperSaverShippingStyledText(Ljava/util/List;)V

    goto :goto_0
.end method
