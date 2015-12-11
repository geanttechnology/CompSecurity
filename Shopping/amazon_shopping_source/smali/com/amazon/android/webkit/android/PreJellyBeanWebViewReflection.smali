.class public Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;
.super Lcom/amazon/android/webkit/android/AndroidWebViewReflection;
.source "PreJellyBeanWebViewReflection.java"


# static fields
.field private static final COMPUTE_VERTICAL_SCROLL_OFFSET:Ljava/lang/reflect/Method;

.field private static final DUMP_DISPLAY_TREE_METHOD:Ljava/lang/reflect/Method;

.field private static final DUMP_DOM_TREE_METHOD:Ljava/lang/reflect/Method;

.field private static final DUMP_RENDER_TREE_METHOD:Ljava/lang/reflect/Method;

.field private static final DUMP_V8_COUNTERS_METHOD:Ljava/lang/reflect/Method;

.field private static final GET_TOUCH_ICON_URL_METHOD:Ljava/lang/reflect/Method;

.field private static final LOAD_WEB_ARCHIVE_METHOD:Ljava/lang/reflect/Method;

.field private static final NOTIFY_FIND_DIALOG_DISMISSED_METHOD:Ljava/lang/reflect/Method;

.field private static final ON_PAUSE_METHOD:Ljava/lang/reflect/Method;

.field private static final ON_RESUME_METHOD:Ljava/lang/reflect/Method;

.field private static final SET_FIND_IS_UP_METHOD:Ljava/lang/reflect/Method;

.field private static final SET_NETWORK_TYPE_METHOD:Ljava/lang/reflect/Method;

.field private static final SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD:Ljava/lang/reflect/Method;


# instance fields
.field private amazonFindListener:Lcom/amazon/android/webkit/AmazonFindListener;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 12
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "setWebBackForwardListClient"

    new-array v2, v5, [Ljava/lang/Class;

    const-class v3, Landroid/webkit/WebBackForwardListClient;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD:Ljava/lang/reflect/Method;

    .line 17
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "onResume"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->ON_RESUME_METHOD:Ljava/lang/reflect/Method;

    .line 21
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "onPause"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->ON_PAUSE_METHOD:Ljava/lang/reflect/Method;

    .line 24
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "dumpV8Counters"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->DUMP_V8_COUNTERS_METHOD:Ljava/lang/reflect/Method;

    .line 27
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "dumpRenderTree"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->DUMP_RENDER_TREE_METHOD:Ljava/lang/reflect/Method;

    .line 30
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "dumpDomTree"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->DUMP_DOM_TREE_METHOD:Ljava/lang/reflect/Method;

    .line 33
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "dumpDisplayTree"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->DUMP_DISPLAY_TREE_METHOD:Ljava/lang/reflect/Method;

    .line 37
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "notifyFindDialogDismissed"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredPrivateMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->NOTIFY_FIND_DIALOG_DISMISSED_METHOD:Ljava/lang/reflect/Method;

    .line 41
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "setFindIsUp"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredPrivateMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->SET_FIND_IS_UP_METHOD:Ljava/lang/reflect/Method;

    .line 44
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "setNetworkType"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Class;

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v4

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->SET_NETWORK_TYPE_METHOD:Ljava/lang/reflect/Method;

    .line 47
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "getTouchIconUrl"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->GET_TOUCH_ICON_URL_METHOD:Ljava/lang/reflect/Method;

    .line 50
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "computeVerticalScrollOffset"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredPrivateMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->COMPUTE_VERTICAL_SCROLL_OFFSET:Ljava/lang/reflect/Method;

    .line 53
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "loadWebArchive"

    new-array v2, v5, [Ljava/lang/Class;

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->LOAD_WEB_ARCHIVE_METHOD:Ljava/lang/reflect/Method;

    return-void
.end method

.method public constructor <init>(Landroid/webkit/WebView;)V
    .locals 0
    .param p1, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;-><init>(Landroid/webkit/WebView;)V

    .line 58
    return-void
.end method


# virtual methods
.method public getTouchIconUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 62
    sget-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->GET_TOUCH_ICON_URL_METHOD:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->webView:Landroid/webkit/WebView;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getVerticalScrollOffset()I
    .locals 3

    .prologue
    .line 112
    sget-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->COMPUTE_VERTICAL_SCROLL_OFFSET:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->webView:Landroid/webkit/WebView;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public setFindIsUp(Z)V
    .locals 5
    .param p1, "isUp"    # Z

    .prologue
    .line 72
    sget-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->SET_FIND_IS_UP_METHOD:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->webView:Landroid/webkit/WebView;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    return-void
.end method

.method public setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonFindListener;

    .prologue
    .line 133
    iput-object p1, p0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->amazonFindListener:Lcom/amazon/android/webkit/AmazonFindListener;

    .line 134
    return-void
.end method

.method public setWebBackForwardListClient(Landroid/webkit/WebBackForwardListClient;)V
    .locals 4
    .param p1, "client"    # Landroid/webkit/WebBackForwardListClient;

    .prologue
    .line 117
    sget-object v0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/PreJellyBeanWebViewReflection;->webView:Landroid/webkit/WebView;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    return-void
.end method
