.class public Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;
.super Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
.source "DetailInterceptionHandler.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "configEntry"    # Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .prologue
    .line 41
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;-><init>(Landroid/content/Context;Landroid/net/Uri;Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;)V

    .line 42
    return-void
.end method


# virtual methods
.method public handle()Z
    .locals 9

    .prologue
    const/4 v5, 0x1

    .line 53
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v6

    instance-of v6, v6, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;

    if-eqz v6, :cond_0

    .line 54
    const/4 v5, 0x0

    .line 83
    :goto_0
    return v5

    .line 57
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->product_details_web_page_url:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 61
    .local v2, "canonicalUrl":Ljava/lang/String;
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-virtual {v6}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v7

    invoke-virtual {v7}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 62
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v3

    .line 69
    .local v3, "fullUri":Landroid/net/Uri;
    :goto_1
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 70
    .local v0, "associateTag":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 71
    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    .line 72
    .local v1, "builder":Landroid/net/Uri$Builder;
    const-string/jumbo v6, "tag"

    invoke-virtual {v1, v6, v0}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 73
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v3

    .line 76
    .end local v1    # "builder":Landroid/net/Uri$Builder;
    :cond_1
    new-instance v4, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v6

    const-class v7, Lcom/amazon/mShop/details/web/WebProductDetailsActivity;

    invoke-direct {v4, v6, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 77
    .local v4, "intent":Landroid/content/Intent;
    const-string/jumbo v6, "intentActionStartActivity"

    invoke-virtual {v4, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 78
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 79
    const-string/jumbo v6, "Launch_From_Public_Url"

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v7

    instance-of v7, v7, Lcom/amazon/mShop/publicurl/PublicURLActivity;

    invoke-virtual {v4, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 80
    const-string/jumbo v6, "isFromDetailInterception"

    invoke-virtual {v4, v6, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 81
    const-string/jumbo v6, "interceptedAsin"

    const-string/jumbo v7, "asin"

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getParam(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 82
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6, v4}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 64
    .end local v0    # "associateTag":Ljava/lang/String;
    .end local v3    # "fullUri":Landroid/net/Uri;
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_2
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "asin"

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getParam(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 65
    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getUri()Landroid/net/Uri;

    move-result-object v6

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    invoke-virtual {p0}, Lcom/amazon/mShop/mash/interception/DetailInterceptionHandler;->getRefmarker()Ljava/lang/String;

    move-result-object v8

    invoke-static {v6, v7, v8}, Lcom/amazon/mobile/mash/util/MASHUtil;->canonicalizeUri(Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .restart local v3    # "fullUri":Landroid/net/Uri;
    goto/16 :goto_1
.end method
