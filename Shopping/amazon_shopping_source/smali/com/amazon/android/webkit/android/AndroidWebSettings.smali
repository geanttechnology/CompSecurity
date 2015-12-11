.class public Lcom/amazon/android/webkit/android/AndroidWebSettings;
.super Lcom/amazon/android/webkit/AmazonWebSettings;
.source "AndroidWebSettings.java"


# static fields
.field private static final GET_ENABLE_SMOOTH_TRANSITION:Ljava/lang/reflect/Method;

.field private static final GET_MEDIA_PLAYBACK:Ljava/lang/reflect/Method;

.field private static final GET_USER_AGENT:Ljava/lang/reflect/Method;

.field private static final SET_DISPLAY_ZOOM_CONTROLS:Ljava/lang/reflect/Method;

.field private static final SET_ENABLE_SMOOTH_TRANSITION:Ljava/lang/reflect/Method;

.field private static final SET_MEDIA_PLAYBACK:Ljava/lang/reflect/Method;

.field private static final SET_NAV_DUMP:Ljava/lang/reflect/Method;

.field private static final SET_PAGE_CACHE_CAPACITY:Ljava/lang/reflect/Method;

.field private static final SET_PROPERTY:Ljava/lang/reflect/Method;

.field private static final SET_USER_AGENT:Ljava/lang/reflect/Method;


# instance fields
.field private final webSettingsDelegate:Landroid/webkit/WebSettings;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 18
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "setPageCacheCapacity"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->SET_PAGE_CACHE_CAPACITY:Ljava/lang/reflect/Method;

    .line 23
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "setDisplayZoomControls"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->SET_DISPLAY_ZOOM_CONTROLS:Ljava/lang/reflect/Method;

    .line 26
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "setEnableSmoothTransition"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->SET_ENABLE_SMOOTH_TRANSITION:Ljava/lang/reflect/Method;

    .line 29
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "getEnableSmoothTransition"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->GET_ENABLE_SMOOTH_TRANSITION:Ljava/lang/reflect/Method;

    .line 32
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "setUserAgent"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->SET_USER_AGENT:Ljava/lang/reflect/Method;

    .line 35
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "getUserAgent"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->GET_USER_AGENT:Ljava/lang/reflect/Method;

    .line 38
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "setNavDump"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->SET_NAV_DUMP:Ljava/lang/reflect/Method;

    .line 41
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "setProperty"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Class;

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v4

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->SET_PROPERTY:Ljava/lang/reflect/Method;

    .line 45
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "setMediaPlaybackRequiresUserGesture"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->SET_MEDIA_PLAYBACK:Ljava/lang/reflect/Method;

    .line 48
    const-class v0, Landroid/webkit/WebSettings;

    const-string/jumbo v1, "getMediaPlaybackRequiresUserGesture"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->GET_MEDIA_PLAYBACK:Ljava/lang/reflect/Method;

    return-void
.end method

.method public constructor <init>(Landroid/webkit/WebSettings;)V
    .locals 0
    .param p1, "webSettingsDelegate"    # Landroid/webkit/WebSettings;

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/amazon/android/webkit/AmazonWebSettings;-><init>()V

    .line 55
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    .line 56
    return-void
.end method


# virtual methods
.method public getUserAgentString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setBuiltInZoomControls(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 109
    return-void
.end method

.method public setDatabaseEnabled(Z)V
    .locals 1
    .param p1, "databaseEnabled"    # Z

    .prologue
    .line 269
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setDatabaseEnabled(Z)V

    .line 270
    return-void
.end method

.method public setDefaultZoom(Lcom/amazon/android/webkit/AmazonWebSettings$ZoomDensity;)V
    .locals 2
    .param p1, "zoomDensity"    # Lcom/amazon/android/webkit/AmazonWebSettings$ZoomDensity;

    .prologue
    .line 229
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {p1}, Lcom/amazon/android/webkit/AmazonWebSettings$ZoomDensity;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/webkit/WebSettings$ZoomDensity;->valueOf(Ljava/lang/String;)Landroid/webkit/WebSettings$ZoomDensity;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setDefaultZoom(Landroid/webkit/WebSettings$ZoomDensity;)V

    .line 230
    return-void
.end method

.method public setDomStorageEnabled(Z)V
    .locals 1
    .param p1, "domStorageEnabled"    # Z

    .prologue
    .line 279
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 280
    return-void
.end method

.method public setDoubleTapToZoomEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 424
    return-void
.end method

.method public setJavaScriptCanOpenWindowsAutomatically(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V

    .line 145
    return-void
.end method

.method public setJavaScriptEnabled(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 61
    return-void
.end method

.method public setRenderPriority(Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;)V
    .locals 2
    .param p1, "priority"    # Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 455
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {p1}, Lcom/amazon/android/webkit/AmazonWebSettings$RenderPriority;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/webkit/WebSettings$RenderPriority;->valueOf(Ljava/lang/String;)Landroid/webkit/WebSettings$RenderPriority;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setRenderPriority(Landroid/webkit/WebSettings$RenderPriority;)V

    .line 456
    return-void
.end method

.method public setSaveFormData(Z)V
    .locals 1
    .param p1, "saveFormData"    # Z

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setSaveFormData(Z)V

    .line 235
    return-void
.end method

.method public setSavePassword(Z)V
    .locals 1
    .param p1, "rememberPasswords"    # Z

    .prologue
    .line 244
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setSavePassword(Z)V

    .line 245
    return-void
.end method

.method public setSupportZoom(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 119
    return-void
.end method

.method public setTextSize(Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;)V
    .locals 2
    .param p1, "textSize"    # Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 219
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {p1}, Lcom/amazon/android/webkit/AmazonWebSettings$TextSize;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/webkit/WebSettings$TextSize;->valueOf(Ljava/lang/String;)Landroid/webkit/WebSettings$TextSize;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setTextSize(Landroid/webkit/WebSettings$TextSize;)V

    .line 220
    return-void
.end method

.method public setTextZoom(I)V
    .locals 1
    .param p1, "textZoom"    # I

    .prologue
    .line 403
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setTextZoom(I)V

    .line 404
    return-void
.end method

.method public setUserAgentString(Ljava/lang/String;)V
    .locals 1
    .param p1, "userAgentString"    # Ljava/lang/String;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebSettings;->webSettingsDelegate:Landroid/webkit/WebSettings;

    invoke-virtual {v0, p1}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 71
    return-void
.end method
