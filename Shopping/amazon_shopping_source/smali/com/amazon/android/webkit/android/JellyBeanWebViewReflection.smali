.class Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;
.super Lcom/amazon/android/webkit/android/AndroidWebViewReflection;
.source "JellyBeanWebViewReflection.java"


# static fields
.field private static final COMPUTE_VERTICAL_SCROLL_OFFSET:Ljava/lang/reflect/Method;

.field private static final DUMP_DISPLAY_TREE_METHOD:Ljava/lang/reflect/Method;

.field private static final DUMP_DOM_TREE_METHOD:Ljava/lang/reflect/Method;

.field private static final DUMP_RENDER_TREE_METHOD:Ljava/lang/reflect/Method;

.field private static final FROM_WEB_VIEW_METHOD:Ljava/lang/reflect/Method;

.field private static final GET_TOUCH_ICON_URL_METHOD:Ljava/lang/reflect/Method;

.field private static final LOAD_WEB_ARCHIVE_METHOD:Ljava/lang/reflect/Method;

.field private static final NOTIFY_FIND_DIALOG_DISMISSED_METHOD:Ljava/lang/reflect/Method;

.field private static final ON_PAUSE_METHOD:Ljava/lang/reflect/Method;

.field private static final ON_RESUME_METHOD:Ljava/lang/reflect/Method;

.field private static final SET_FIND_IS_UP_METHOD:Ljava/lang/reflect/Method;

.field private static final SET_NETWORK_TYPE_METHOD:Ljava/lang/reflect/Method;

.field private static final SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD:Ljava/lang/reflect/Method;

.field private static final WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field


# instance fields
.field private final webviewClassicDelegate:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 11
    const-string/jumbo v0, "android.webkit.WebViewClassic"

    invoke-static {v0}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    .line 14
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "setWebBackForwardListClient"

    new-array v2, v5, [Ljava/lang/Class;

    const-class v3, Landroid/webkit/WebBackForwardListClient;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD:Ljava/lang/reflect/Method;

    .line 18
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "fromWebView"

    new-array v2, v5, [Ljava/lang/Class;

    const-class v3, Landroid/webkit/WebView;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->FROM_WEB_VIEW_METHOD:Ljava/lang/reflect/Method;

    .line 22
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "onResume"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->ON_RESUME_METHOD:Ljava/lang/reflect/Method;

    .line 26
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "onPause"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->ON_PAUSE_METHOD:Ljava/lang/reflect/Method;

    .line 29
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "dumpRenderTree"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->DUMP_RENDER_TREE_METHOD:Ljava/lang/reflect/Method;

    .line 32
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "dumpDomTree"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->DUMP_DOM_TREE_METHOD:Ljava/lang/reflect/Method;

    .line 36
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "dumpDisplayTree"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->DUMP_DISPLAY_TREE_METHOD:Ljava/lang/reflect/Method;

    .line 40
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "notifyFindDialogDismissed"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredPrivateMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->NOTIFY_FIND_DIALOG_DISMISSED_METHOD:Ljava/lang/reflect/Method;

    .line 44
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "setFindIsUp"

    new-array v2, v5, [Ljava/lang/Class;

    sget-object v3, Ljava/lang/Boolean;->TYPE:Ljava/lang/Class;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredPrivateMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->SET_FIND_IS_UP_METHOD:Ljava/lang/reflect/Method;

    .line 47
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->WEB_VIEW_CLASSIC_CLASS:Ljava/lang/Class;

    const-string/jumbo v1, "setNetworkType"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Class;

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v4

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->SET_NETWORK_TYPE_METHOD:Ljava/lang/reflect/Method;

    .line 50
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "getTouchIconUrl"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->GET_TOUCH_ICON_URL_METHOD:Ljava/lang/reflect/Method;

    .line 53
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "computeVerticalScrollOffset"

    new-array v2, v4, [Ljava/lang/Class;

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getRequiredPrivateMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->COMPUTE_VERTICAL_SCROLL_OFFSET:Ljava/lang/reflect/Method;

    .line 56
    const-class v0, Landroid/webkit/WebView;

    const-string/jumbo v1, "loadWebArchive"

    new-array v2, v5, [Ljava/lang/Class;

    const-class v3, Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->getOptionalMethod(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->LOAD_WEB_ARCHIVE_METHOD:Ljava/lang/reflect/Method;

    return-void
.end method

.method public constructor <init>(Landroid/webkit/WebView;)V
    .locals 4
    .param p1, "webView"    # Landroid/webkit/WebView;

    .prologue
    .line 62
    invoke-direct {p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewReflection;-><init>(Landroid/webkit/WebView;)V

    .line 63
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->FROM_WEB_VIEW_METHOD:Ljava/lang/reflect/Method;

    const/4 v1, 0x0

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->webviewClassicDelegate:Ljava/lang/Object;

    .line 64
    return-void
.end method


# virtual methods
.method public getTouchIconUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 68
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->GET_TOUCH_ICON_URL_METHOD:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->webviewClassicDelegate:Ljava/lang/Object;

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
    .line 118
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->COMPUTE_VERTICAL_SCROLL_OFFSET:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->webView:Landroid/webkit/WebView;

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
    .line 78
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->SET_FIND_IS_UP_METHOD:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->webviewClassicDelegate:Ljava/lang/Object;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    return-void
.end method

.method public setFindListener(Lcom/amazon/android/webkit/AmazonFindListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/android/webkit/AmazonFindListener;

    .prologue
    .line 137
    iget-object v0, p0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->webView:Landroid/webkit/WebView;

    new-instance v1, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection$1;-><init>(Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;Lcom/amazon/android/webkit/AmazonFindListener;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setFindListener(Landroid/webkit/WebView$FindListener;)V

    .line 144
    return-void
.end method

.method public setWebBackForwardListClient(Landroid/webkit/WebBackForwardListClient;)V
    .locals 4
    .param p1, "client"    # Landroid/webkit/WebBackForwardListClient;

    .prologue
    .line 123
    sget-object v0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->SET_WEB_BACK_FORWARD_LIST_CLIENT_METHOD:Ljava/lang/reflect/Method;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/JellyBeanWebViewReflection;->webviewClassicDelegate:Ljava/lang/Object;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/android/webkit/android/Reflect;->invokeMethod(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    return-void
.end method
