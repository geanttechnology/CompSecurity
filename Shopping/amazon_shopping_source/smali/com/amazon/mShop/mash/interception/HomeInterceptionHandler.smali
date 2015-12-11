.class public Lcom/amazon/mShop/mash/interception/HomeInterceptionHandler;
.super Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.source "HomeInterceptionHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    .line 22
    return-void
.end method


# virtual methods
.method public handle()Z
    .locals 4

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/HomeInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "ref"

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/HomeInterceptionHandler;->getRefmarker()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/Maps;->of(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v1

    const/4 v2, -0x1

    const/4 v3, 0x0

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;Ljava/util/Map;IZ)Z

    .line 30
    const/4 v0, 0x1

    return v0
.end method
