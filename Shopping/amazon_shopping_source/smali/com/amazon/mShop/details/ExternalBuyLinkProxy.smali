.class public Lcom/amazon/mShop/details/ExternalBuyLinkProxy;
.super Lcom/amazon/mShop/details/FriendAppProxy;
.source "ExternalBuyLinkProxy.java"


# instance fields
.field private mWebLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/mShop/details/FriendAppProxy;-><init>()V

    .line 26
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 1
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/details/FriendAppProxy;-><init>()V

    .line 21
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getExternalBuyLink()Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/ExternalBuyLinkProxy;->mWebLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    .line 22
    return-void
.end method


# virtual methods
.method public getButtonLabel(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/details/ExternalBuyLinkProxy;->mWebLink:Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getIntentForStart(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 42
    invoke-virtual {p2}, Lcom/amazon/mShop/control/item/ProductController;->getExternalBuyLink()Lcom/amazon/rio/j2me/client/services/mShop/WebLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/WebLink;->getLinkUrl()Ljava/lang/String;

    move-result-object v2

    .line 44
    .local v2, "url":Ljava/lang/String;
    const-string/jumbo v3, "open:"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 46
    const-string/jumbo v3, "open:"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    .line 49
    :cond_0
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 50
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v3, "android.intent.action.VIEW"

    invoke-direct {v0, v3, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 51
    .local v0, "intent":Landroid/content/Intent;
    return-object v0
.end method

.method protected getIntentForStart(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 84
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getPackageName(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getRefTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    const-string/jumbo v0, "ext"

    return-object v0
.end method

.method protected isFriendAppInstalled(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    const/4 v0, 0x1

    return v0
.end method

.method protected needFriendAppUpdate(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    const/4 v0, 0x0

    return v0
.end method
