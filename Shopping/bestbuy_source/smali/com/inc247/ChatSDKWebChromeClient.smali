.class public Lcom/inc247/ChatSDKWebChromeClient;
.super Landroid/webkit/WebChromeClient;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onJsAlert(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 32
    :try_start_0
    new-instance v1, Landroid/app/AlertDialog$Builder;

    .line 33
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v2

    iget-object v2, v2, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 32
    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 34
    invoke-virtual {v1, p3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 35
    const-string v2, "Alert"

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 36
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 37
    const-string v2, "OK"

    .line 38
    new-instance v3, Lcom/inc247/ChatSDKWebChromeClient$1;

    invoke-direct {v3, p0, p4}, Lcom/inc247/ChatSDKWebChromeClient$1;-><init>(Lcom/inc247/ChatSDKWebChromeClient;Landroid/webkit/JsResult;)V

    .line 37
    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 43
    new-instance v2, Lcom/inc247/ChatSDKWebChromeClient$2;

    invoke-direct {v2, p0, p4}, Lcom/inc247/ChatSDKWebChromeClient$2;-><init>(Lcom/inc247/ChatSDKWebChromeClient;Landroid/webkit/JsResult;)V

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)Landroid/app/AlertDialog$Builder;

    .line 56
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 57
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 67
    :goto_0
    return v0

    .line 59
    :catch_0
    move-exception v0

    .line 60
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

    .line 62
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v0

    .line 63
    new-instance v1, Lcom/inc247/errors/ChatSDKError;

    .line 64
    sget-object v2, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKUnknownError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 63
    invoke-direct {v1, v2}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 65
    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    .line 67
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onJsConfirm(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 76
    new-instance v0, Landroid/app/AlertDialog$Builder;

    .line 77
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 76
    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 78
    invoke-virtual {v0, p3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 79
    const-string v1, "Confirm"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 80
    invoke-virtual {v0, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 81
    const-string v1, "OK"

    new-instance v2, Lcom/inc247/ChatSDKWebChromeClient$3;

    invoke-direct {v2, p0, p4}, Lcom/inc247/ChatSDKWebChromeClient$3;-><init>(Lcom/inc247/ChatSDKWebChromeClient;Landroid/webkit/JsResult;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 86
    const-string v1, "Cancel"

    new-instance v2, Lcom/inc247/ChatSDKWebChromeClient$4;

    invoke-direct {v2, p0, p4}, Lcom/inc247/ChatSDKWebChromeClient$4;-><init>(Lcom/inc247/ChatSDKWebChromeClient;Landroid/webkit/JsResult;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 91
    new-instance v1, Lcom/inc247/ChatSDKWebChromeClient$5;

    invoke-direct {v1, p0, p4}, Lcom/inc247/ChatSDKWebChromeClient$5;-><init>(Lcom/inc247/ChatSDKWebChromeClient;Landroid/webkit/JsResult;)V

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    .line 96
    new-instance v1, Lcom/inc247/ChatSDKWebChromeClient$6;

    invoke-direct {v1, p0, p4}, Lcom/inc247/ChatSDKWebChromeClient$6;-><init>(Lcom/inc247/ChatSDKWebChromeClient;Landroid/webkit/JsResult;)V

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)Landroid/app/AlertDialog$Builder;

    .line 109
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 110
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 111
    return v3
.end method

.method public onReachedMaxAppCacheSize(JJLandroid/webkit/WebStorage$QuotaUpdater;)V
    .locals 3

    .prologue
    .line 120
    const-wide/16 v0, 0x2

    mul-long/2addr v0, p1

    invoke-interface {p5, v0, v1}, Landroid/webkit/WebStorage$QuotaUpdater;->updateQuota(J)V

    .line 121
    return-void
.end method
