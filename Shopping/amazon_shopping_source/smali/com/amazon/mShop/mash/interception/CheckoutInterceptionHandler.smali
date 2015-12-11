.class public Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;
.super Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.source "CheckoutInterceptionHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    .line 26
    return-void
.end method


# virtual methods
.method public handle()Z
    .locals 5

    .prologue
    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    instance-of v1, v1, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    if-eqz v1, :cond_0

    .line 39
    const/4 v1, 0x0

    .line 51
    :goto_0
    return v1

    .line 41
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, -0x1

    invoke-static {v1, v2, v3, v4}, Lcom/amazon/mShop/util/ActivityUtils;->getStartWebActivityIntent(Landroid/content/Context;Ljava/lang/Class;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v0

    .line 49
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "isCartPurchase"

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v2

    instance-of v2, v2, Lcom/amazon/mShop/cart/web/WebCartActivity;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 50
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CheckoutInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 51
    const/4 v1, 0x1

    goto :goto_0
.end method
