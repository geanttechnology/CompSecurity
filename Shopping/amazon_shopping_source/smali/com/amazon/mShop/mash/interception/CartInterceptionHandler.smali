.class public Lcom/amazon/mShop/mash/interception/CartInterceptionHandler;
.super Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.source "CartInterceptionHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    .line 24
    return-void
.end method


# virtual methods
.method public handle()Z
    .locals 3

    .prologue
    .line 32
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CartInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/cart/web/WebCartActivity;

    if-eqz v0, :cond_0

    .line 33
    const/4 v0, 0x0

    .line 35
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CartInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "ref"

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/CartInterceptionHandler;->getRefmarker()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v1

    const/4 v2, -0x1

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->startCartActivity(Landroid/content/Context;Ljava/util/Map;I)Z

    move-result v0

    goto :goto_0
.end method
