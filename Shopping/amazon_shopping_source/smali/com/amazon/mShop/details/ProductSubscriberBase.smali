.class public Lcom/amazon/mShop/details/ProductSubscriberBase;
.super Ljava/lang/Object;
.source "ProductSubscriberBase.java"

# interfaces
.implements Lcom/amazon/mShop/control/item/ProductSubscriber;


# instance fields
.field private context:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    return-void
.end method


# virtual methods
.method public getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/details/ProductSubscriberBase;->context:Landroid/content/Context;

    return-object v0
.end method

.method public onBrowserAvailableCountChanged()V
    .locals 0

    .prologue
    .line 32
    return-void
.end method

.method public onCancelled()V
    .locals 0

    .prologue
    .line 89
    return-void
.end method

.method public onDealBlockUpdated()V
    .locals 0

    .prologue
    .line 66
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 99
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductSubscriberBase;->getContext()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 100
    invoke-virtual {p0}, Lcom/amazon/mShop/details/ProductSubscriberBase;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/Exception;)V

    .line 102
    :cond_0
    return-void
.end method

.method public onImageChanged()V
    .locals 0

    .prologue
    .line 82
    return-void
.end method

.method public onPriceBlockUpdated()V
    .locals 0

    .prologue
    .line 58
    return-void
.end method

.method public onProductUpdated()V
    .locals 0

    .prologue
    .line 48
    return-void
.end method

.method public onServiceCallComplete()V
    .locals 0

    .prologue
    .line 113
    return-void
.end method

.method public onSimilarItemsGalleryUpdated()V
    .locals 0

    .prologue
    .line 75
    return-void
.end method
