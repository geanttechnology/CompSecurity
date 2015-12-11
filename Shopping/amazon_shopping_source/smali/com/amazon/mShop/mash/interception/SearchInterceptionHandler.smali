.class public Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;
.super Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.source "SearchInterceptionHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    .line 33
    return-void
.end method


# virtual methods
.method public handle()Z
    .locals 5

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v2

    instance-of v2, v2, Lcom/amazon/mShop/search/SearchActivity;

    if-eqz v2, :cond_0

    .line 42
    const/4 v2, 0x0

    .line 46
    :goto_0
    return v2

    .line 44
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v2

    const-string/jumbo v3, "https://www.amazon.com/s"

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;->getRefmarker()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lcom/amazon/mobile/mash/util/MASHUtil;->canonicalizeUri(Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 45
    .local v0, "canonicalUri":Landroid/net/Uri;
    new-instance v3, Lcom/amazon/mShop/search/SearchIntentBuilder;

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v3, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->dataUrl(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v1

    .line 46
    .local v1, "searchIntent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/SearchInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v2, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    move-result v2

    goto :goto_0
.end method
