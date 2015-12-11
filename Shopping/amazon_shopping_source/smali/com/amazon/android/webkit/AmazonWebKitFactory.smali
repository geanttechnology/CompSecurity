.class public abstract Lcom/amazon/android/webkit/AmazonWebKitFactory;
.super Ljava/lang/Object;
.source "AmazonWebKitFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;,
        Lcom/amazon/android/webkit/AmazonWebKitFactory$OutOfBandResponseListener;
    }
.end annotation


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract clearAllVisitedLinkHistory()V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method

.method public abstract clearFormData(Landroid/content/Context;)V
.end method

.method public createWebView(Landroid/content/Context;ILjava/lang/Object;Z)Lcom/amazon/android/webkit/AmazonWebView;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "solidColor"    # I
    .param p3, "tab"    # Ljava/lang/Object;
    .param p4, "isPrivate"    # Z

    .prologue
    .line 274
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->createWebView(Landroid/content/Context;ILjava/lang/Object;ZLandroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v0

    return-object v0
.end method

.method public createWebView(Landroid/content/Context;ILjava/lang/Object;ZLandroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebView;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "solidColor"    # I
    .param p3, "tab"    # Ljava/lang/Object;
    .param p4, "isPrivate"    # Z
    .param p5, "extraData"    # Landroid/os/Bundle;

    .prologue
    .line 196
    sget-object v6, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->SURFACEVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->createWebView(Landroid/content/Context;ILjava/lang/Object;ZLandroid/os/Bundle;Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;)Lcom/amazon/android/webkit/AmazonWebView;

    move-result-object v0

    return-object v0
.end method

.method public createWebView(Landroid/content/Context;ILjava/lang/Object;ZLandroid/os/Bundle;Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;)Lcom/amazon/android/webkit/AmazonWebView;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "solidColor"    # I
    .param p3, "tab"    # Ljava/lang/Object;
    .param p4, "isPrivate"    # Z
    .param p5, "extraData"    # Landroid/os/Bundle;
    .param p6, "sType"    # Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    .prologue
    .line 204
    new-instance v1, Lcom/amazon/android/webkit/AmazonWebView;

    invoke-direct {v1, p1, p3}, Lcom/amazon/android/webkit/AmazonWebView;-><init>(Landroid/content/Context;Ljava/lang/Object;)V

    .local v1, "webView":Lcom/amazon/android/webkit/AmazonWebView;
    move-object v0, p0

    move v2, p2

    move v3, p4

    move-object v4, p5

    move-object v5, p6

    .line 205
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->initializeWebView(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;)V

    .line 207
    return-object v1
.end method

.method public abstract createWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;)Lcom/amazon/android/webkit/AmazonWebViewDelegate;
.end method

.method public abstract createWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;I)Lcom/amazon/android/webkit/AmazonWebViewDelegate;
.end method

.method public disableDeveloperTools()V
    .locals 0

    .prologue
    .line 592
    return-void
.end method

.method public enableDeveloperToolsTcp(I)V
    .locals 2
    .param p1, "tcpPort"    # I

    .prologue
    .line 584
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "Implementation does not support remote debugging"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public enableDeveloperToolsUnix(Ljava/lang/String;)V
    .locals 2
    .param p1, "socketName"    # Ljava/lang/String;

    .prologue
    .line 549
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "Implementation does not support remote debugging"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public abstract getAmazonPluginManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonPluginManager;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation
.end method

.method public abstract getApiLevel()I
.end method

.method public abstract getCacheManager()Lcom/amazon/android/webkit/AmazonCacheManager;
.end method

.method public abstract getCookieManager()Lcom/amazon/android/webkit/AmazonCookieManager;
.end method

.method public abstract getCookieSyncManager()Lcom/amazon/android/webkit/AmazonCookieSyncManager;
.end method

.method public abstract getGeolocationPermissions()Lcom/amazon/android/webkit/AmazonGeolocationPermissions;
.end method

.method public abstract getHistoryManager()Lcom/amazon/android/webkit/AmazonHistoryManager;
.end method

.method public abstract getMaxApiLevelSupported()I
.end method

.method public abstract getMediaDeviceSettings()Lcom/amazon/android/webkit/AmazonMediaDeviceSettings;
.end method

.method public getOptimalWebViewCount()I
    .locals 1

    .prologue
    .line 639
    const/16 v0, 0xa

    return v0
.end method

.method public abstract getUpdateHandler()Lcom/amazon/android/webkit/AmazonWebKitUpdateHandler;
.end method

.method public abstract getWebIconDatabase()Lcom/amazon/android/webkit/AmazonWebIconDatabase;
.end method

.method public abstract getWebKitCapabilities()Lcom/amazon/android/webkit/AmazonWebKitCapabilities;
.end method

.method public abstract getWebStorage()Lcom/amazon/android/webkit/AmazonWebStorage;
.end method

.method public abstract getWebViewDatabase(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonWebViewDatabase;
.end method

.method public abstract initialize(Landroid/content/Context;)V
.end method

.method public abstract initialize(Landroid/content/Context;Ljava/util/List;)V
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
.end method

.method public initializeWebView(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;)V
    .locals 6
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "solidColor"    # I
    .param p3, "isPrivate"    # Z
    .param p4, "extraData"    # Landroid/os/Bundle;

    .prologue
    .line 232
    sget-object v5, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->SURFACEVIEW:Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->initializeWebView(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;)V

    .line 233
    return-void
.end method

.method public initializeWebView(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;)V
    .locals 6
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "solidColor"    # I
    .param p3, "isPrivate"    # Z
    .param p4, "extraData"    # Landroid/os/Bundle;
    .param p5, "sType"    # Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;

    .prologue
    .line 240
    if-eqz p1, :cond_0

    .line 241
    invoke-virtual {p5}, Lcom/amazon/android/webkit/AmazonWebKitFactory$SurfaceType;->getValue()I

    move-result v5

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/android/webkit/AmazonWebKitFactory;->createWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebView;IZLandroid/os/Bundle;I)Lcom/amazon/android/webkit/AmazonWebViewDelegate;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/amazon/android/webkit/AmazonWebView;->setWebViewDelegate(Lcom/amazon/android/webkit/AmazonWebViewDelegate;)V

    .line 246
    return-void

    .line 245
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Attempting to initialize an invalid WebView"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public abstract isRenderProcess(Landroid/content/Context;)Z
.end method

.method public javaScriptToUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "javascript"    # Ljava/lang/String;

    .prologue
    .line 451
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "javascript:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public abstract preconnect(Ljava/util/Map;)V
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
.end method

.method public abstract sendOutOfBandRequest(Ljava/util/concurrent/Executor;Lcom/amazon/android/webkit/AmazonWebKitFactory$OutOfBandResponseListener;Lcom/amazon/android/webkit/AmazonUrlRequest;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation
.end method

.method public setEmbeddedVideoEnabled(Z)V
    .locals 2
    .param p1, "enable"    # Z

    .prologue
    .line 628
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v1, "Implementation cannot toggle embedded video"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setExtraLibraryPath(Ljava/lang/String;)V
    .locals 0
    .param p1, "absPath"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 672
    return-void
.end method

.method public setMaxRenderProcessCount(I)V
    .locals 0
    .param p1, "numberOfProcesses"    # I

    .prologue
    .line 519
    return-void
.end method

.method public setNativeLibraryPackage(Ljava/lang/String;)V
    .locals 0
    .param p1, "pkgName"    # Ljava/lang/String;

    .prologue
    .line 689
    return-void
.end method

.method public setRenderingStatsEnabled(Z)V
    .locals 0
    .param p1, "enable"    # Z

    .prologue
    .line 607
    return-void
.end method

.method public abstract setTargetApiLevel(I)V
.end method

.method public abstract setWebKitErrorListener(Lcom/amazon/android/webkit/AmazonWebKitErrorListener;)V
.end method

.method public abstract setWebKitUrlRequestHandler(Lcom/amazon/android/webkit/AmazonUrlRequestHandler;)V
.end method

.method public setWebRtcEnabled(Z)V
    .locals 0
    .param p1, "enable"    # Z

    .prologue
    .line 655
    return-void
.end method

.method public abstract warmUp(Landroid/content/Context;)V
.end method

.method public abstract warmUp(Landroid/content/Context;Ljava/util/List;)V
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
.end method
