.class public final Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;
.super Ljava/lang/Object;
.source "AmazonWebViewUtils.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static sIsFactoryInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 17
    const-class v0, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->LOG_TAG:Ljava/lang/String;

    .line 19
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    sput-object v0, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->sIsFactoryInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    return-void
.end method

.method public static createAmazonWebView(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonWebView;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 81
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->initAmazonWebViewFactory(Landroid/content/Context;)V

    .line 83
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p0, v2, v1, v2}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->createWebView(Landroid/content/Context;ILjava/lang/Object;Z)Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v0

    return-object v0
.end method

.method public static getAmazonCookieManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonCookieManager;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 115
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->initAmazonWebViewFactory(Landroid/content/Context;)V

    .line 116
    invoke-static {}, Lcom/amazon/android/webkit/AmazonCookieManager;->getInstance()Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v0

    return-object v0
.end method

.method public static getAmazonWebViewFromView(Landroid/view/View;Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonWebView;
    .locals 7
    .param p0, "webView"    # Landroid/view/View;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    const/4 v6, 0x0

    .line 43
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->initAmazonWebViewFactory(Landroid/content/Context;)V

    .line 45
    instance-of v3, p0, Lcom/amazon/android/webkit/AmazonWebView;

    if-eqz v3, :cond_0

    move-object v0, p0

    .line 47
    check-cast v0, Lcom/amazon/android/webkit/AmazonWebView;

    .line 51
    .local v0, "amazonWebView":Lcom/amazon/android/webkit/AmazonWebView;
    :try_start_0
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v3, v0, v4, v5, v6}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->initializeWebView(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 69
    .end local v0    # "amazonWebView":Lcom/amazon/android/webkit/AmazonWebView;
    :goto_0
    return-object v0

    .line 56
    .restart local v0    # "amazonWebView":Lcom/amazon/android/webkit/AmazonWebView;
    :catch_0
    move-exception v1

    .line 58
    .local v1, "e":Ljava/lang/IllegalStateException;
    sget-object v3, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v4, "IllegalStateException occureed while calling AmazonWebView initialization. Please make sure you have not already initialized the webview"

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v2

    .line 61
    goto :goto_0

    .line 63
    .end local v1    # "e":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v1

    .line 65
    .local v1, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v4, "Unexpected Error calling AmazonWebView initialization."

    invoke-static {v3, v4, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v2

    .line 66
    goto :goto_0

    .line 73
    .end local v0    # "amazonWebView":Lcom/amazon/android/webkit/AmazonWebView;
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "The View object with class %s cann\'t be casted to AmazonWebView."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "The View object is not an AmazonWebView object"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public static initAmazonWebViewFactory(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x1

    .line 28
    sget-object v0, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->sIsFactoryInitialized:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 31
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->initialize(Landroid/content/Context;)V

    .line 32
    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->getCookieManager()Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/amazon/android/webkit/AmazonCookieManager;->setAcceptCookie(Z)V

    .line 33
    sget-object v0, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->LOG_TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Using the webview implementation:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/android/webkit/AmazonWebKitFactories;->getDefaultFactory()Lcom/amazon/android/webkit/AmazonWebKitFactory;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 36
    :cond_0
    return-void
.end method

.method public static makeSureAmazonCookieSyncManagerIsInitialized(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 101
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->initAmazonWebViewFactory(Landroid/content/Context;)V

    .line 104
    :try_start_0
    invoke-static {}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->getInstance()Lcom/amazon/android/webkit/AmazonCookieSyncManager;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 111
    :goto_0
    return-void

    .line 108
    :catch_0
    move-exception v0

    sget-object v0, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->LOG_TAG:Ljava/lang/String;

    .line 109
    invoke-static {p0}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->initialize(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public static syncAmazonCookieSyncManager(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 93
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->initAmazonWebViewFactory(Landroid/content/Context;)V

    .line 94
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->makeSureAmazonCookieSyncManagerIsInitialized(Landroid/content/Context;)V

    .line 96
    invoke-static {}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->getInstance()Lcom/amazon/android/webkit/AmazonCookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->sync()V

    .line 97
    return-void
.end method
