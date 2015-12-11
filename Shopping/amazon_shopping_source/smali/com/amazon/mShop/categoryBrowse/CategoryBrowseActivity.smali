.class public Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "CategoryBrowseActivity.java"

# interfaces
.implements Lcom/amazon/mShop/search/ScopedSearch;


# instance fields
.field private mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 36
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    .line 38
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;)Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method


# virtual methods
.method protected createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 6

    .prologue
    .line 115
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    .line 116
    .local v1, "webviewContainer":Lcom/amazon/mShop/web/MShopWebViewContainer;
    const-string/jumbo v2, "%s Mobile"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v5

    invoke-virtual {v5}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v5

    invoke-virtual {v5}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 117
    .local v0, "ua":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 118
    return-object v1
.end method

.method public getCategoryMetadata()Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    .locals 2

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 145
    iget-object v0, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;

    .line 147
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentDepartmentDepth()I
    .locals 2

    .prologue
    .line 130
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    .line 133
    .local v0, "backForwardList":Landroid/webkit/WebBackForwardList;
    if-nez v0, :cond_0

    const/4 v1, -0x1

    :goto_0
    return v1

    :cond_0
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    goto :goto_0
.end method

.method public getSearchMetadata(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 75
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 107
    :goto_0
    return-void

    .line 79
    :cond_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;-><init>(Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 106
    .local v0, "loaderThread":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->setIntent(Landroid/content/Intent;)V

    .line 47
    invoke-static {p0}, Lorg/apache/cordova/Config;->init(Landroid/app/Activity;)V

    .line 48
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->calcWebviewStartTime()V

    .line 50
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "newUrl":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 56
    const-string/jumbo v1, "/s/browse?node=aps"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 57
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->clearHistory()V

    .line 59
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->stopLoading()V

    .line 60
    invoke-virtual {p0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 61
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->getSearchMetadata(Ljava/lang/String;)V

    .line 63
    :cond_1
    return-void
.end method
