.class public Lcom/amazon/mShop/details/FriendAppProxy$Factory;
.super Ljava/lang/Object;
.source "FriendAppProxy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/details/FriendAppProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Factory"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getProxy(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/mShop/details/FriendAppProxy;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 80
    const/4 v0, 0x0

    .line 81
    .local v0, "proxy":Lcom/amazon/mShop/details/FriendAppProxy;
    invoke-static {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->isAmazonAppstoreDownloadUrl(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 82
    invoke-static {}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getInstance()Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    move-result-object v0

    .line 87
    :cond_0
    :goto_0
    return-object v0

    .line 83
    :cond_1
    invoke-static {p0, p1}, Lcom/amazon/mShop/details/FriendAppProxy;->isAmazonMp3DownloadUrl(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 84
    invoke-static {}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->getInstance()Lcom/amazon/mShop/details/AmazonMp3Proxy;

    move-result-object v0

    goto :goto_0
.end method

.method public static getProxy(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/details/FriendAppProxy;
    .locals 2
    .param p0, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 37
    const/4 v0, 0x0

    .line 38
    .local v0, "proxy":Lcom/amazon/mShop/details/FriendAppProxy;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isMobileApp()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 39
    invoke-static {}, Lcom/amazon/mShop/details/AmazonAppStoreProxy;->getInstance()Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    move-result-object v0

    .line 51
    :cond_0
    :goto_0
    return-object v0

    .line 40
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isMusic()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 41
    invoke-static {}, Lcom/amazon/mShop/details/AmazonMp3Proxy;->getInstance()Lcom/amazon/mShop/details/AmazonMp3Proxy;

    move-result-object v0

    goto :goto_0

    .line 42
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isKindleBook()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 43
    invoke-static {}, Lcom/amazon/mShop/details/AmazonKindleProxy;->getInstance()Lcom/amazon/mShop/details/AmazonKindleProxy;

    move-result-object v0

    goto :goto_0

    .line 44
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isVideo()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 45
    invoke-static {}, Lcom/amazon/mShop/details/AmazonVideoProxy;->getInstance()Lcom/amazon/mShop/details/AmazonVideoProxy;

    move-result-object v0

    goto :goto_0

    .line 46
    :cond_4
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->hasExternalBuyLink()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 47
    new-instance v0, Lcom/amazon/mShop/details/ExternalBuyLinkProxy;

    .end local v0    # "proxy":Lcom/amazon/mShop/details/FriendAppProxy;
    invoke-direct {v0, p0}, Lcom/amazon/mShop/details/ExternalBuyLinkProxy;-><init>(Lcom/amazon/mShop/control/item/ProductController;)V

    .restart local v0    # "proxy":Lcom/amazon/mShop/details/FriendAppProxy;
    goto :goto_0

    .line 48
    :cond_5
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/ProductController;->isAudiobook()Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0
.end method
