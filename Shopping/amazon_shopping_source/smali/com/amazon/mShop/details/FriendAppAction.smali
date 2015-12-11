.class public Lcom/amazon/mShop/details/FriendAppAction;
.super Ljava/lang/Object;
.source "FriendAppAction.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private final context:Landroid/content/Context;

.field private final product:Lcom/amazon/mShop/control/item/ProductController;

.field private final proxy:Lcom/amazon/mShop/details/FriendAppProxy;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/details/FriendAppAction;->context:Landroid/content/Context;

    .line 26
    iput-object p2, p0, Lcom/amazon/mShop/details/FriendAppAction;->product:Lcom/amazon/mShop/control/item/ProductController;

    .line 27
    invoke-static {p2}, Lcom/amazon/mShop/details/FriendAppProxy$Factory;->getProxy(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/details/FriendAppProxy;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/FriendAppAction;->proxy:Lcom/amazon/mShop/details/FriendAppProxy;

    .line 28
    return-void
.end method

.method public static logRefMarker(Lcom/amazon/mShop/details/FriendAppProxy;)V
    .locals 1
    .param p0, "proxy"    # Lcom/amazon/mShop/details/FriendAppProxy;

    .prologue
    .line 40
    instance-of v0, p0, Lcom/amazon/mShop/details/AmazonAppStoreProxy;

    if-eqz v0, :cond_1

    .line 41
    const-string/jumbo v0, "dp_appstr"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 47
    :cond_0
    :goto_0
    return-void

    .line 42
    :cond_1
    instance-of v0, p0, Lcom/amazon/mShop/details/AmazonMp3Proxy;

    if-eqz v0, :cond_2

    .line 43
    const-string/jumbo v0, "dp_mp3"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 44
    :cond_2
    instance-of v0, p0, Lcom/amazon/mShop/details/AmazonKindleProxy;

    if-eqz v0, :cond_0

    .line 45
    const-string/jumbo v0, "dp_kindle"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static startProxyActivity(Landroid/content/Context;Lcom/amazon/mShop/details/FriendAppProxy;Landroid/content/Intent;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "proxy"    # Lcom/amazon/mShop/details/FriendAppProxy;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 50
    invoke-virtual {p1, p0}, Lcom/amazon/mShop/details/FriendAppProxy;->getRefTagForFriendApp(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 51
    .local v1, "refTag":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 53
    :try_start_0
    invoke-virtual {p0, p2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 54
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "fa_"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/net/UrlLogger;->logRefTag(Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 59
    :cond_0
    :goto_0
    return-void

    .line 55
    :catch_0
    move-exception v0

    .line 56
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    const-string/jumbo v2, "Amazon.FriendAppAction"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Activity is unknown for intent "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p2}, Landroid/content/Intent;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 32
    iget-object v1, p0, Lcom/amazon/mShop/details/FriendAppAction;->proxy:Lcom/amazon/mShop/details/FriendAppProxy;

    iget-object v2, p0, Lcom/amazon/mShop/details/FriendAppAction;->context:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/mShop/details/FriendAppAction;->product:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/details/FriendAppProxy;->getIntentForFriendApp(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)Landroid/content/Intent;

    move-result-object v0

    .line 33
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/details/FriendAppAction;->context:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/mShop/details/FriendAppAction;->proxy:Lcom/amazon/mShop/details/FriendAppProxy;

    invoke-static {v1, v2, v0}, Lcom/amazon/mShop/details/FriendAppAction;->startProxyActivity(Landroid/content/Context;Lcom/amazon/mShop/details/FriendAppProxy;Landroid/content/Intent;)V

    .line 34
    iget-object v1, p0, Lcom/amazon/mShop/details/FriendAppAction;->proxy:Lcom/amazon/mShop/details/FriendAppProxy;

    invoke-static {v1}, Lcom/amazon/mShop/details/FriendAppAction;->logRefMarker(Lcom/amazon/mShop/details/FriendAppProxy;)V

    .line 35
    return-void
.end method
