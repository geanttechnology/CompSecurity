.class public Lcom/inc247/ChatSDKWebView;
.super Landroid/webkit/WebView;
.source "SourceFile"


# static fields
.field private static final RESULT_OK:I = -0x1

.field public static final TAG:Ljava/lang/String;

.field private static self:Lcom/inc247/ChatSDKWebView;

.field public static settings:Landroid/webkit/WebSettings;


# instance fields
.field private mCapturedImageURI:Landroid/net/Uri;

.field protected mFileUploadCallbackFirst:Landroid/webkit/ValueCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field

.field protected mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/webkit/ValueCallback",
            "<[",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field

.field private spinnerLayout:Landroid/widget/RelativeLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const-class v0, Lcom/inc247/ChatSDKWebView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/inc247/ChatSDKWebView;->TAG:Ljava/lang/String;

    .line 62
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 73
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 55
    iput-object v0, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    .line 63
    iput-object v0, p0, Lcom/inc247/ChatSDKWebView;->mCapturedImageURI:Landroid/net/Uri;

    .line 74
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    .line 75
    invoke-direct {p0}, Lcom/inc247/ChatSDKWebView;->enableWebViewDebugging()V

    .line 77
    :cond_0
    new-instance v0, Landroid/widget/RelativeLayout;

    invoke-direct {v0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    .line 78
    invoke-direct {p0, p1}, Lcom/inc247/ChatSDKWebView;->loadChatSDKWebView(Landroid/content/Context;)V

    .line 79
    return-void
.end method

.method static synthetic access$0(Lcom/inc247/ChatSDKWebView;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 258
    invoke-direct {p0, p1, p2}, Lcom/inc247/ChatSDKWebView;->showProgessDialog(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$1(Lcom/inc247/ChatSDKWebView;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$2()Lcom/inc247/ChatSDKWebView;
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/inc247/ChatSDKWebView;->self:Lcom/inc247/ChatSDKWebView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/inc247/ChatSDKWebView;)V
    .locals 0

    .prologue
    .line 53
    sput-object p0, Lcom/inc247/ChatSDKWebView;->self:Lcom/inc247/ChatSDKWebView;

    return-void
.end method

.method private enableWebViewDebugging()V
    .locals 1
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "setWebContentsDebuggingEnabled",
            "NewApi"
        }
    .end annotation

    .prologue
    .line 84
    const/4 v0, 0x1

    invoke-static {v0}, Landroid/webkit/WebView;->setWebContentsDebuggingEnabled(Z)V

    .line 85
    return-void
.end method

.method public static getInstance(Landroid/content/Context;)Lcom/inc247/ChatSDKWebView;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/inc247/ChatSDKWebView;->self:Lcom/inc247/ChatSDKWebView;

    if-nez v0, :cond_0

    .line 96
    new-instance v0, Lcom/inc247/ChatSDKWebView;

    invoke-direct {v0, p0}, Lcom/inc247/ChatSDKWebView;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/inc247/ChatSDKWebView;->self:Lcom/inc247/ChatSDKWebView;

    .line 98
    :cond_0
    sget-object v0, Lcom/inc247/ChatSDKWebView;->self:Lcom/inc247/ChatSDKWebView;

    return-object v0
.end method

.method private loadChatSDKWebView(Landroid/content/Context;)V
    .locals 5
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled",
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v4, -0x2

    const/4 v1, -0x1

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 110
    invoke-virtual {p0, v2}, Lcom/inc247/ChatSDKWebView;->setScrollContainer(Z)V

    .line 113
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 116
    iget-object v1, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 117
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 120
    const/16 v1, 0xd

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 121
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    .line 123
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewManager;

    iget-object v1, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    invoke-interface {v0, v1}, Landroid/view/ViewManager;->removeView(Landroid/view/View;)V

    .line 126
    :cond_0
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 127
    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    .line 126
    check-cast v0, Landroid/view/ViewGroup;

    .line 128
    iget-object v1, p0, Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 130
    invoke-virtual {p0}, Lcom/inc247/ChatSDKWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    sput-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    .line 131
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 133
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    invoke-virtual {v0}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v0

    .line 134
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    invoke-static {v1}, Lcom/inc247/ChatSDKUtil;->isTablet(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 135
    sget-object v1, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, " "

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 136
    sget-object v2, Lcom/inc247/constants/ChatSDKConstants;->USER_AGENT_STRING_TABLET:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 135
    invoke-virtual {v1, v0}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 141
    :goto_0
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    .line 143
    new-instance v0, Lcom/inc247/bridge/ChatSDKJSToNativeBridge;

    invoke-direct {v0}, Lcom/inc247/bridge/ChatSDKJSToNativeBridge;-><init>()V

    .line 144
    const-string v1, "bridge"

    invoke-virtual {p0, v0, v1}, Lcom/inc247/ChatSDKWebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 145
    invoke-virtual {p0, v3}, Lcom/inc247/ChatSDKWebView;->setBackgroundColor(I)V

    .line 146
    new-instance v0, Lcom/inc247/ChatSDKWebView$1;

    invoke-direct {v0, p0}, Lcom/inc247/ChatSDKWebView$1;-><init>(Lcom/inc247/ChatSDKWebView;)V

    invoke-virtual {p0, v0}, Lcom/inc247/ChatSDKWebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 179
    new-instance v0, Lcom/inc247/ChatSDKWebView$2;

    invoke-direct {v0, p0}, Lcom/inc247/ChatSDKWebView$2;-><init>(Lcom/inc247/ChatSDKWebView;)V

    invoke-virtual {p0, v0}, Lcom/inc247/ChatSDKWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 237
    :try_start_0
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 238
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    const-wide/32 v2, 0x800000

    invoke-virtual {v0, v2, v3}, Landroid/webkit/WebSettings;->setAppCacheMaxSize(J)V

    .line 239
    invoke-virtual {p1}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 240
    sget-object v1, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    invoke-virtual {v1, v0}, Landroid/webkit/WebSettings;->setAppCachePath(Ljava/lang/String;)V

    .line 241
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V

    .line 242
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setAppCacheEnabled(Z)V

    .line 243
    sget-object v0, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    .line 244
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/inc247/ChatSDKWebView;->setVerticalScrollBarEnabled(Z)V

    .line 245
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/inc247/ChatSDKWebView;->setHorizontalScrollBarEnabled(Z)V

    .line 246
    invoke-virtual {p0}, Lcom/inc247/ChatSDKWebView;->requestFocus()Z

    .line 247
    invoke-virtual {p0}, Lcom/inc247/ChatSDKWebView;->requestFocusFromTouch()Z

    .line 248
    sget-object v0, Lcom/inc247/ChatSDKResources;->URL:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/inc247/ChatSDKWebView;->loadUrl(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 253
    :goto_1
    return-void

    .line 138
    :cond_1
    sget-object v1, Lcom/inc247/ChatSDKWebView;->settings:Landroid/webkit/WebSettings;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, " "

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 139
    sget-object v2, Lcom/inc247/constants/ChatSDKConstants;->USER_AGENT_STRING_MOBILE:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 138
    invoke-virtual {v1, v0}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 249
    :catch_0
    move-exception v0

    .line 250
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 251
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private showProgessDialog(ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 271
    return-void
.end method


# virtual methods
.method public destroyWebView()V
    .locals 2

    .prologue
    .line 277
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 278
    new-instance v1, Lcom/inc247/ChatSDKWebView$3;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDKWebView$3;-><init>(Lcom/inc247/ChatSDKWebView;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 290
    return-void
.end method

.method protected getFileUploadPromptLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 309
    const-string v0, "Choose a file"

    return-object v0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v1, 0x0

    .line 373
    const v0, 0xc8e2

    if-ne p1, v0, :cond_0

    .line 374
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;

    if-nez v0, :cond_1

    .line 407
    :cond_0
    :goto_0
    return-void

    .line 381
    :cond_1
    const/4 v0, -0x1

    if-eq p2, v0, :cond_3

    move-object v0, v1

    move-object v2, v1

    .line 395
    :goto_1
    iget-object v3, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackFirst:Landroid/webkit/ValueCallback;

    if-eqz v3, :cond_2

    .line 396
    iget-object v3, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackFirst:Landroid/webkit/ValueCallback;

    invoke-interface {v3, v0}, Landroid/webkit/ValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    .line 397
    iput-object v1, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackFirst:Landroid/webkit/ValueCallback;

    .line 399
    :cond_2
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;

    if-eqz v0, :cond_0

    .line 400
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;

    invoke-interface {v0, v2}, Landroid/webkit/ValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    .line 401
    iput-object v1, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;

    goto :goto_0

    .line 385
    :cond_3
    if-nez p3, :cond_4

    :try_start_0
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mCapturedImageURI:Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 387
    :goto_2
    const/4 v2, 0x1

    :try_start_1
    new-array v2, v2, [Landroid/net/Uri;

    const/4 v3, 0x0

    aput-object v0, v2, v3
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 389
    :catch_0
    move-exception v2

    .line 391
    :goto_3
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v3

    iget-object v3, v3, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 392
    invoke-virtual {v3}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 393
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "activity :"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 390
    invoke-static {v3, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 393
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    move-object v2, v1

    goto :goto_1

    .line 386
    :cond_4
    :try_start_2
    invoke-virtual {p3}, Landroid/content/Intent;->getData()Landroid/net/Uri;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v0

    goto :goto_2

    .line 389
    :catch_1
    move-exception v0

    move-object v2, v0

    move-object v0, v1

    goto :goto_3
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1

    .prologue
    .line 295
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 298
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->minimizeChat()V

    .line 299
    const/4 v0, 0x1

    .line 302
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/webkit/WebView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected openFileInput(Landroid/webkit/ValueCallback;Landroid/webkit/ValueCallback;)V
    .locals 5
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Landroid/webkit/ValueCallback",
            "<[",
            "Landroid/net/Uri;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 314
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackFirst:Landroid/webkit/ValueCallback;

    if-eqz v0, :cond_0

    .line 315
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackFirst:Landroid/webkit/ValueCallback;

    invoke-interface {v0, v1}, Landroid/webkit/ValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    .line 317
    :cond_0
    iput-object p1, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackFirst:Landroid/webkit/ValueCallback;

    .line 319
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;

    if-eqz v0, :cond_1

    .line 320
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;

    invoke-interface {v0, v1}, Landroid/webkit/ValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    .line 322
    :cond_1
    iput-object p2, p0, Lcom/inc247/ChatSDKWebView;->mFileUploadCallbackSecond:Landroid/webkit/ValueCallback;

    .line 328
    :try_start_0
    new-instance v0, Ljava/io/File;

    .line 330
    sget-object v1, Landroid/os/Environment;->DIRECTORY_PICTURES:Ljava/lang/String;

    invoke-static {v1}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v1

    .line 331
    const-string v2, "AndroidExampleFolder"

    .line 328
    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 333
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_2

    .line 335
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 339
    :cond_2
    new-instance v1, Ljava/io/File;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "IMG_"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 340
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ".jpg"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 339
    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 342
    invoke-static {v1}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v0

    iput-object v0, p0, Lcom/inc247/ChatSDKWebView;->mCapturedImageURI:Landroid/net/Uri;

    .line 345
    new-instance v0, Landroid/content/Intent;

    .line 346
    const-string v1, "android.media.action.IMAGE_CAPTURE"

    .line 345
    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 348
    const-string v1, "output"

    iget-object v2, p0, Lcom/inc247/ChatSDKWebView;->mCapturedImageURI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 350
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.GET_CONTENT"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 351
    const-string v2, "android.intent.category.OPENABLE"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 352
    const-string v2, "image/*"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 355
    const-string v2, "Image Chooser"

    invoke-static {v1, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v1

    .line 358
    const-string v2, "android.intent.extra.INITIAL_INTENTS"

    .line 359
    const/4 v3, 0x1

    new-array v3, v3, [Landroid/os/Parcelable;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    .line 358
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 363
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    iget-object v0, v0, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 364
    const v2, 0xc8e2

    .line 363
    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 369
    :goto_0
    return-void

    .line 366
    :catch_0
    move-exception v0

    .line 367
    const-string v0, "Error while choosing file"

    const-string v1, "An error occured while choosing file"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
