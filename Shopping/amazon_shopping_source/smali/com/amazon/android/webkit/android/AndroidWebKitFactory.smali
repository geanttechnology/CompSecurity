.class public Lcom/amazon/android/webkit/android/AndroidWebKitFactory;
.super Lcom/amazon/android/webkit/AmazonWebKitFactory;
.source "AndroidWebKitFactory.java"


# instance fields
.field private final cacheManager:Lcom/amazon/android/webkit/AmazonCacheManager;

.field private final cookieManager:Lcom/amazon/android/webkit/AmazonCookieManager;

.field private final cookieSyncManager:Lcom/amazon/android/webkit/AmazonCookieSyncManager;

.field private final geolocationPermission:Lcom/amazon/android/webkit/AmazonGeolocationPermissions;

.field private final historyManager:Lcom/amazon/android/webkit/AmazonHistoryManager;

.field private initialized:Z

.field private final updateHandler:Lcom/amazon/android/webkit/AmazonWebKitUpdateHandler;

.field private final urlRequestHandler:Ljava/util/concurrent/atomic/AtomicReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/atomic/AtomicReference",
            "<",
            "Lcom/amazon/android/webkit/AmazonUrlRequestHandler;",
            ">;"
        }
    .end annotation
.end field

.field private warmedUp:Z

.field private final webIconDatabase:Lcom/amazon/android/webkit/AmazonWebIconDatabase;

.field private final webKitCapabilities:Lcom/amazon/android/webkit/AmazonWebKitCapabilities;

.field private final webStorage:Lcom/amazon/android/webkit/AmazonWebStorage;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 78
    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonWebKitFactory;-><init>()V

    .line 66
    new-instance v0, Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicReference;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->urlRequestHandler:Ljava/util/concurrent/atomic/AtomicReference;

    .line 70
    iput-boolean v1, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->warmedUp:Z

    .line 73
    iput-boolean v1, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->initialized:Z

    .line 79
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidCacheManager;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidCacheManager;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->cacheManager:Lcom/amazon/android/webkit/AmazonCacheManager;

    .line 80
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidCookieManager;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidCookieManager;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->cookieManager:Lcom/amazon/android/webkit/AmazonCookieManager;

    .line 81
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidCookieSyncManager;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidCookieSyncManager;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->cookieSyncManager:Lcom/amazon/android/webkit/AmazonCookieSyncManager;

    .line 82
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidGeolocationPermissions;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidGeolocationPermissions;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->geolocationPermission:Lcom/amazon/android/webkit/AmazonGeolocationPermissions;

    .line 83
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebIconDatabase;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidWebIconDatabase;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->webIconDatabase:Lcom/amazon/android/webkit/AmazonWebIconDatabase;

    .line 84
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebKitCapabilities;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidWebKitCapabilities;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->webKitCapabilities:Lcom/amazon/android/webkit/AmazonWebKitCapabilities;

    .line 85
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebStorage;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidWebStorage;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->webStorage:Lcom/amazon/android/webkit/AmazonWebStorage;

    .line 86
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebKitUpdateHandler;

    invoke-direct {v0}, Lcom/amazon/android/webkit/android/AndroidWebKitUpdateHandler;-><init>()V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->updateHandler:Lcom/amazon/android/webkit/AmazonWebKitUpdateHandler;

    .line 88
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory$1;

    invoke-direct {v0, p0}, Lcom/amazon/android/webkit/android/AndroidWebKitFactory$1;-><init>(Lcom/amazon/android/webkit/android/AndroidWebKitFactory;)V

    iput-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->historyManager:Lcom/amazon/android/webkit/AmazonHistoryManager;

    .line 95
    invoke-static {}, Lcom/amazon/android/webkit/android/ClientApiLevel;->initialize()V

    .line 97
    return-void
.end method

.method public static getMaxApiLevelSupportedStatic()I
    .locals 1

    .prologue
    .line 281
    const/4 v0, 0x4

    return v0
.end method


# virtual methods
.method public clearAllVisitedLinkHistory()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 228
    return-void
.end method

.method public clearFormData(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 212
    const/4 v0, 0x0

    .line 214
    .local v0, "webView":Landroid/webkit/WebView;
    :try_start_0
    new-instance v1, Landroid/webkit/WebView;

    invoke-direct {v1, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 215
    .end local v0    # "webView":Landroid/webkit/WebView;
    .local v1, "webView":Landroid/webkit/WebView;
    :try_start_1
    invoke-virtual {v1}, Landroid/webkit/WebView;->clearFormData()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 218
    if-eqz v1, :cond_0

    .line 219
    invoke-virtual {v1}, Landroid/webkit/WebView;->destroy()V

    .line 222
    :cond_0
    return-void

    .line 218
    .end local v1    # "webView":Landroid/webkit/WebView;
    .restart local v0    # "webView":Landroid/webkit/WebView;
    :catchall_0
    move-exception v2

    :goto_0
    if-eqz v0, :cond_1

    .line 219
    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    :cond_1
    throw v2

    .line 218
    .end local v0    # "webView":Landroid/webkit/WebView;
    .restart local v1    # "webView":Landroid/webkit/WebView;
    :catchall_1
    move-exception v2

    move-object v0, v1

    .end local v1    # "webView":Landroid/webkit/WebView;
    .restart local v0    # "webView":Landroid/webkit/WebView;
    goto :goto_0
.end method

.method public createWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebViewDelegate;
    .locals 2
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "solidColorId"    # I
    .param p3, "isPrivate"    # Z
    .param p4, "extraData"    # Landroid/os/Bundle;

    .prologue
    .line 102
    if-eqz p3, :cond_0

    .line 103
    const-class v0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Ignoring unsupported isPrivate=true"

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    :cond_0
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->urlRequestHandler:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-direct {v0, p1, p2, v1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;-><init>(Lcom/amazon/android/webkit/AmazonWebView;ILjava/util/concurrent/atomic/AtomicReference;)V

    return-object v0
.end method

.method public createWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;I)Lcom/amazon/android/webkit/AmazonWebViewDelegate;
    .locals 1
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "solidColorId"    # I
    .param p3, "isPrivate"    # Z
    .param p4, "extraData"    # Landroid/os/Bundle;
    .param p5, "surfaceType"    # I

    .prologue
    .line 111
    invoke-virtual {p0, p1, p2, p3, p4}, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->createWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    return-object v0
.end method

.method public getAmazonPluginManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonPluginManager;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 164
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidPluginManager;

    invoke-direct {v0, p1}, Lcom/amazon/android/webkit/android/AndroidPluginManager;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public getApiLevel()I
    .locals 1

    .prologue
    .line 254
    invoke-static {}, Lcom/amazon/android/webkit/android/ClientApiLevel;->getInstance()Lcom/amazon/android/webkit/android/ClientApiLevel;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/android/ClientApiLevel;->getApiLevel()I

    move-result v0

    return v0
.end method

.method public declared-synchronized getCacheManager()Lcom/amazon/android/webkit/AmazonCacheManager;
    .locals 1

    .prologue
    .line 117
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->cacheManager:Lcom/amazon/android/webkit/AmazonCacheManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCookieManager()Lcom/amazon/android/webkit/AmazonCookieManager;
    .locals 1

    .prologue
    .line 122
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->cookieManager:Lcom/amazon/android/webkit/AmazonCookieManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getCookieSyncManager()Lcom/amazon/android/webkit/AmazonCookieSyncManager;
    .locals 1

    .prologue
    .line 127
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->cookieSyncManager:Lcom/amazon/android/webkit/AmazonCookieSyncManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getGeolocationPermissions()Lcom/amazon/android/webkit/AmazonGeolocationPermissions;
    .locals 1

    .prologue
    .line 132
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->geolocationPermission:Lcom/amazon/android/webkit/AmazonGeolocationPermissions;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getHistoryManager()Lcom/amazon/android/webkit/AmazonHistoryManager;
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->historyManager:Lcom/amazon/android/webkit/AmazonHistoryManager;

    return-object v0
.end method

.method public getMaxApiLevelSupported()I
    .locals 1

    .prologue
    .line 268
    invoke-static {}, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->getMaxApiLevelSupportedStatic()I

    move-result v0

    return v0
.end method

.method public declared-synchronized getMediaDeviceSettings()Lcom/amazon/android/webkit/AmazonMediaDeviceSettings;
    .locals 2

    .prologue
    .line 137
    monitor-enter p0

    :try_start_0
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "Unsupported method"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getUpdateHandler()Lcom/amazon/android/webkit/AmazonWebKitUpdateHandler;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->updateHandler:Lcom/amazon/android/webkit/AmazonWebKitUpdateHandler;

    return-object v0
.end method

.method public declared-synchronized getWebIconDatabase()Lcom/amazon/android/webkit/AmazonWebIconDatabase;
    .locals 1

    .prologue
    .line 142
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->webIconDatabase:Lcom/amazon/android/webkit/AmazonWebIconDatabase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getWebKitCapabilities()Lcom/amazon/android/webkit/AmazonWebKitCapabilities;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->webKitCapabilities:Lcom/amazon/android/webkit/AmazonWebKitCapabilities;

    return-object v0
.end method

.method public declared-synchronized getWebStorage()Lcom/amazon/android/webkit/AmazonWebStorage;
    .locals 1

    .prologue
    .line 152
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->webStorage:Lcom/amazon/android/webkit/AmazonWebStorage;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getWebViewDatabase(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonWebViewDatabase;
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 158
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebViewDatabase;

    invoke-direct {v0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewDatabase;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public initialize(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 179
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->initialize(Landroid/content/Context;Ljava/util/List;)V

    .line 180
    return-void
.end method

.method public initialize(Landroid/content/Context;Ljava/util/List;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 184
    .local p2, "options":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->getCookieSyncManager()Lcom/amazon/android/webkit/AmazonCookieSyncManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/AmazonCookieSyncManager;->createInstance(Landroid/content/Context;)V

    .line 185
    invoke-virtual {p0}, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->getCookieManager()Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonCookieManager;->removeExpiredCookie()V

    .line 186
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->initialized:Z

    .line 187
    return-void
.end method

.method public isRenderProcess(Landroid/content/Context;)Z
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 192
    const/4 v0, 0x0

    return v0
.end method

.method public javaScriptToUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "javascript"    # Ljava/lang/String;

    .prologue
    .line 233
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "javascript:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public preconnect(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 244
    .local p1, "preconnects":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Integer;>;"
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public sendOutOfBandRequest(Ljava/util/concurrent/Executor;Lcom/amazon/android/webkit/AmazonWebKitFactory$OutOfBandResponseListener;Lcom/amazon/android/webkit/AmazonUrlRequest;)V
    .locals 1
    .param p1, "listenerExecutor"    # Ljava/util/concurrent/Executor;
    .param p2, "listener"    # Lcom/amazon/android/webkit/AmazonWebKitFactory$OutOfBandResponseListener;
    .param p3, "request"    # Lcom/amazon/android/webkit/AmazonUrlRequest;

    .prologue
    .line 239
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setTargetApiLevel(I)V
    .locals 2
    .param p1, "apiLevel"    # I

    .prologue
    .line 259
    iget-boolean v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->warmedUp:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->initialized:Z

    if-eqz v0, :cond_1

    .line 260
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "The Target API Level can only be set before warmUp or initialization."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 263
    :cond_1
    invoke-static {}, Lcom/amazon/android/webkit/android/ClientApiLevel;->getInstance()Lcom/amazon/android/webkit/android/ClientApiLevel;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/android/webkit/android/ClientApiLevel;->setApiLevel(I)V

    .line 264
    return-void
.end method

.method public setWebKitErrorListener(Lcom/amazon/android/webkit/AmazonWebKitErrorListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonWebKitErrorListener;

    .prologue
    .line 198
    return-void
.end method

.method public setWebKitUrlRequestHandler(Lcom/amazon/android/webkit/AmazonUrlRequestHandler;)V
    .locals 1
    .param p1, "handler"    # Lcom/amazon/android/webkit/AmazonUrlRequestHandler;

    .prologue
    .line 202
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->urlRequestHandler:Ljava/util/concurrent/atomic/AtomicReference;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicReference;->set(Ljava/lang/Object;)V

    .line 203
    return-void
.end method

.method public warmUp(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 169
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->warmUp(Landroid/content/Context;Ljava/util/List;)V

    .line 170
    return-void
.end method

.method public warmUp(Landroid/content/Context;Ljava/util/List;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 174
    .local p2, "options":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/android/webkit/android/AndroidWebKitFactory;->warmedUp:Z

    .line 175
    return-void
.end method
