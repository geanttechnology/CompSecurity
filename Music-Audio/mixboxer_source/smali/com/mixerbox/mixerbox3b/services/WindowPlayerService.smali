.class public Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;
.super Landroid/app/Service;
.source "SourceFile"


# instance fields
.field binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

.field current:I

.field flag:Z

.field isReady:Z

.field messenger:Landroid/os/Messenger;

.field musicId:Ljava/lang/String;

.field shouldPlayAfterReady:Z

.field private windowManager:Landroid/view/WindowManager;

.field wv:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 144
    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->loadUrl()V

    return-void
.end method

.method private loadUrl()V
    .locals 2

    .prologue
    .line 130
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    const-string v1, "http://static.mixerbox.com/yt_android.min.kk.v2.html"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 131
    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 67
    if-eqz p1, :cond_0

    .line 68
    const-string v0, "messenger"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/Messenger;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->messenger:Landroid/os/Messenger;

    .line 70
    :cond_0
    new-instance v0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;-><init>(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    .line 71
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    return-object v0
.end method

.method public onCreate()V
    .locals 7
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi",
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v6, 0x0

    .line 78
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 80
    const-string v0, "window"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->windowManager:Landroid/view/WindowManager;

    .line 82
    iput-boolean v6, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->flag:Z

    .line 83
    iput v6, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->current:I

    .line 84
    iput-boolean v6, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->isReady:Z

    .line 85
    iput-boolean v6, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->shouldPlayAfterReady:Z

    .line 86
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->musicId:Ljava/lang/String;

    .line 88
    new-instance v0, Landroid/webkit/WebView;

    invoke-direct {v0, p0}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    .line 90
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 91
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x11

    if-lt v2, v3, :cond_0

    .line 92
    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setMediaPlaybackRequiresUserGesture(Z)V

    .line 93
    :cond_0
    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 94
    new-instance v2, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyJavaScriptInterface;-><init>(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V

    .line 95
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    const-string v4, "AndroidFunction"

    invoke-virtual {v3, v2, v4}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 96
    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 97
    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setDatabaseEnabled(Z)V

    .line 98
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x12

    if-ge v2, v3, :cond_1

    .line 99
    sget-object v2, Landroid/webkit/WebSettings$PluginState;->ON:Landroid/webkit/WebSettings$PluginState;

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setPluginState(Landroid/webkit/WebSettings$PluginState;)V

    .line 100
    :cond_1
    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    .line 102
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$1;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$1;-><init>(Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;)V

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 108
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    new-instance v2, Landroid/webkit/WebChromeClient;

    invoke-direct {v2}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 109
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v6, v6, v6, v6}, Landroid/webkit/WebView;->setPadding(IIII)V

    .line 111
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 112
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 113
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v6}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    .line 114
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v6}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 116
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->loadUrl()V

    .line 118
    new-instance v0, Landroid/view/WindowManager$LayoutParams;

    const/16 v3, 0x7d2

    const v4, 0x1000008

    const/4 v5, -0x3

    move v2, v1

    invoke-direct/range {v0 .. v5}, Landroid/view/WindowManager$LayoutParams;-><init>(IIIII)V

    .line 122
    const/16 v1, 0x33

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 123
    iput v6, v0, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 124
    iput v6, v0, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 126
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->windowManager:Landroid/view/WindowManager;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-interface {v1, v2, v0}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 127
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    if-eqz v0, :cond_0

    .line 136
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 137
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    const-string v1, "about:blank"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 138
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->windowManager:Landroid/view/WindowManager;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;->wv:Landroid/webkit/WebView;

    invoke-interface {v0, v1}, Landroid/view/WindowManager;->removeView(Landroid/view/View;)V

    .line 140
    :cond_0
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 141
    return-void
.end method
