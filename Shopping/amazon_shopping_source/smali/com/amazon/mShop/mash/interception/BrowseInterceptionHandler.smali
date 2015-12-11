.class public Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;
.super Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.source "BrowseInterceptionHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    .line 28
    return-void
.end method


# virtual methods
.method public handle()Z
    .locals 4

    .prologue
    .line 35
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v1

    const-string/jumbo v2, "https://www.amazon.com/s/browse"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getRefmarker()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/amazon/mobile/mash/util/MASHUtil;->canonicalizeUri(Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 42
    .local v0, "canonicalUri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    instance-of v1, v1, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;

    if-eqz v1, :cond_1

    .line 43
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->shouldBrowseRedirect(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 44
    const/4 v1, 0x1

    .line 49
    :goto_0
    return v1

    .line 46
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getSearchMetadata(Ljava/lang/String;)V

    .line 47
    const/4 v1, 0x0

    goto :goto_0

    .line 49
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/BrowseInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/util/ActivityUtils;->startCategoryBrowseActivity(Landroid/content/Context;Landroid/net/Uri;)Z

    move-result v1

    goto :goto_0
.end method
