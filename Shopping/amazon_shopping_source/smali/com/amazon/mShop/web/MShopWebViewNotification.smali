.class public Lcom/amazon/mShop/web/MShopWebViewNotification;
.super Ljava/lang/Object;
.source "MShopWebViewNotification.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;
    }
.end annotation


# static fields
.field private static sWebCartSubscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/web/MShopWebViewNotification;->sWebCartSubscribers:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method

.method public static addWebCartSubscriber(Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;)V
    .locals 1
    .param p0, "subscriber"    # Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;

    .prologue
    .line 28
    sget-object v0, Lcom/amazon/mShop/web/MShopWebViewNotification;->sWebCartSubscribers:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 29
    return-void
.end method

.method public static notifyCartCountChanged(I)V
    .locals 2
    .param p0, "cartCount"    # I

    .prologue
    .line 36
    sget-object v1, Lcom/amazon/mShop/web/MShopWebViewNotification;->sWebCartSubscribers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 37
    sget-object v1, Lcom/amazon/mShop/web/MShopWebViewNotification;->sWebCartSubscribers:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;

    invoke-interface {v1, p0}, Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;->onCartCountChanged(I)V

    .line 36
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 39
    :cond_0
    return-void
.end method

.method public static removeWebCartSubscriber(Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;)V
    .locals 1
    .param p0, "subscriber"    # Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;

    .prologue
    .line 32
    sget-object v0, Lcom/amazon/mShop/web/MShopWebViewNotification;->sWebCartSubscribers:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 33
    return-void
.end method
