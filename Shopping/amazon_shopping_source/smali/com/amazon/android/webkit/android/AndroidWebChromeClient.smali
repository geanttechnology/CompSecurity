.class public Lcom/amazon/android/webkit/android/AndroidWebChromeClient;
.super Landroid/webkit/WebChromeClient;
.source "AndroidWebChromeClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/webkit/android/AndroidWebChromeClient$10;
    }
.end annotation


# instance fields
.field private final client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

.field private final webview:Lcom/amazon/android/webkit/AmazonWebView;


# direct methods
.method public constructor <init>(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonWebChromeClient;)V
    .locals 0
    .param p1, "webview"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "client"    # Lcom/amazon/android/webkit/AmazonWebChromeClient;

    .prologue
    .line 37
    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    .line 39
    iput-object p2, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    .line 40
    return-void
.end method

.method private convertConsoleMessage(Landroid/webkit/ConsoleMessage;)Lcom/amazon/android/webkit/AmazonConsoleMessage;
    .locals 5
    .param p1, "consoleMessage"    # Landroid/webkit/ConsoleMessage;

    .prologue
    .line 169
    new-instance v0, Lcom/amazon/android/webkit/AmazonConsoleMessage;

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage;->message()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage;->sourceId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage;->lineNumber()I

    move-result v3

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage;->messageLevel()Landroid/webkit/ConsoleMessage$MessageLevel;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertMessageLevel(Landroid/webkit/ConsoleMessage$MessageLevel;)Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/android/webkit/AmazonConsoleMessage;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;)V

    return-object v0
.end method

.method private convertJsPromptResult(Landroid/webkit/JsPromptResult;)Lcom/amazon/android/webkit/AmazonJsPromptResult;
    .locals 1
    .param p1, "jsPromptResult"    # Landroid/webkit/JsPromptResult;

    .prologue
    .line 213
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$7;

    invoke-direct {v0, p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$7;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/JsPromptResult;)V

    return-object v0
.end method

.method private convertJsResult(Landroid/webkit/JsResult;)Lcom/amazon/android/webkit/AmazonJsResult;
    .locals 1
    .param p1, "jsResult"    # Landroid/webkit/JsResult;

    .prologue
    .line 199
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$6;

    invoke-direct {v0, p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$6;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/JsResult;)V

    return-object v0
.end method

.method private convertMessageLevel(Landroid/webkit/ConsoleMessage$MessageLevel;)Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;
    .locals 3
    .param p1, "level"    # Landroid/webkit/ConsoleMessage$MessageLevel;

    .prologue
    .line 151
    sget-object v0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$10;->$SwitchMap$android$webkit$ConsoleMessage$MessageLevel:[I

    invoke-virtual {p1}, Landroid/webkit/ConsoleMessage$MessageLevel;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 163
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unexpected level: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 153
    :pswitch_0
    sget-object v0, Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;->ERROR:Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    .line 161
    :goto_0
    return-object v0

    .line 155
    :pswitch_1
    sget-object v0, Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;->DEBUG:Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    goto :goto_0

    .line 157
    :pswitch_2
    sget-object v0, Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;->LOG:Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    goto :goto_0

    .line 159
    :pswitch_3
    sget-object v0, Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;->TIP:Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    goto :goto_0

    .line 161
    :pswitch_4
    sget-object v0, Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;->WARNING:Lcom/amazon/android/webkit/AmazonConsoleMessage$MessageLevel;

    goto :goto_0

    .line 151
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method


# virtual methods
.method public getDefaultVideoPoster()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->getDefaultVideoPoster()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public getVideoLoadingProgressView()Landroid/view/View;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->getVideoLoadingProgressView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getVisitedHistory(Landroid/webkit/ValueCallback;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/webkit/ValueCallback",
            "<[",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 265
    .local p1, "callback":Landroid/webkit/ValueCallback;, "Landroid/webkit/ValueCallback<[Ljava/lang/String;>;"
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$8;

    invoke-direct {v0, p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$8;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/ValueCallback;)V

    .line 271
    .local v0, "amazonCallback":Lcom/amazon/android/webkit/AmazonValueCallback;, "Lcom/amazon/android/webkit/AmazonValueCallback<[Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v1, v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->getVisitedHistory(Lcom/amazon/android/webkit/AmazonValueCallback;)V

    .line 272
    return-void
.end method

.method public onCloseWindow(Landroid/webkit/WebView;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onCloseWindow(Lcom/amazon/android/webkit/AmazonWebView;)V

    .line 83
    return-void
.end method

.method public onConsoleMessage(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "lineNumber"    # I
    .param p3, "sourceID"    # Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 253
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onConsoleMessage(Ljava/lang/String;ILjava/lang/String;)V

    .line 254
    return-void
.end method

.method public onConsoleMessage(Landroid/webkit/ConsoleMessage;)Z
    .locals 2
    .param p1, "consoleMessage"    # Landroid/webkit/ConsoleMessage;

    .prologue
    .line 177
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-direct {p0, p1}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertConsoleMessage(Landroid/webkit/ConsoleMessage;)Lcom/amazon/android/webkit/AmazonConsoleMessage;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onConsoleMessage(Lcom/amazon/android/webkit/AmazonConsoleMessage;)Z

    .line 178
    const/4 v0, 0x0

    return v0
.end method

.method public onCreateWindow(Landroid/webkit/WebView;ZZLandroid/os/Message;)Z
    .locals 6
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "dialog"    # Z
    .param p3, "userGesture"    # Z
    .param p4, "resultMsg"    # Landroid/os/Message;

    .prologue
    .line 60
    new-instance v5, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$1;

    invoke-direct {v5, p0, p4}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$1;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/os/Message;)V

    .line 72
    .local v5, "callback":Lcom/amazon/android/webkit/AmazonWebChromeClient$OnCreateWindowCallback;
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    move v2, p2

    move v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onCreateWindow(Lcom/amazon/android/webkit/AmazonWebView;ZZLandroid/os/Bundle;Lcom/amazon/android/webkit/AmazonWebChromeClient$OnCreateWindowCallback;)Z

    move-result v0

    return v0
.end method

.method public onExceededDatabaseQuota(Ljava/lang/String;Ljava/lang/String;JJJLandroid/webkit/WebStorage$QuotaUpdater;)V
    .locals 11
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "databaseIdentifier"    # Ljava/lang/String;
    .param p3, "currentQuota"    # J
    .param p5, "estimatedSize"    # J
    .param p7, "totalUsedQuota"    # J
    .param p9, "quotaUpdater"    # Landroid/webkit/WebStorage$QuotaUpdater;

    .prologue
    .line 99
    new-instance v10, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$2;

    move-object/from16 v0, p9

    invoke-direct {v10, p0, v0}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$2;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/WebStorage$QuotaUpdater;)V

    .line 105
    .local v10, "amazonUpdater":Lcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    move-object v2, p1

    move-object v3, p2

    move-wide v4, p3

    move-wide/from16 v6, p5

    move-wide/from16 v8, p7

    invoke-virtual/range {v1 .. v10}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onExceededDatabaseQuota(Ljava/lang/String;Ljava/lang/String;JJJLcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;)V

    .line 107
    return-void
.end method

.method public onGeolocationPermissionsHidePrompt()V
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onGeolocationPermissionsHidePrompt()V

    .line 112
    return-void
.end method

.method public onGeolocationPermissionsShowPrompt(Ljava/lang/String;Landroid/webkit/GeolocationPermissions$Callback;)V
    .locals 2
    .param p1, "origin"    # Ljava/lang/String;
    .param p2, "callback"    # Landroid/webkit/GeolocationPermissions$Callback;

    .prologue
    .line 189
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$5;

    invoke-direct {v0, p0, p2}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$5;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/GeolocationPermissions$Callback;)V

    .line 195
    .local v0, "amazonCallback":Lcom/amazon/android/webkit/AmazonGeolocationPermissions$Callback;
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onGeolocationPermissionsShowPrompt(Ljava/lang/String;Lcom/amazon/android/webkit/AmazonGeolocationPermissions$Callback;)V

    .line 196
    return-void
.end method

.method public onHideCustomView()V
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onHideCustomView()V

    .line 147
    return-void
.end method

.method public onJsAlert(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "result"    # Landroid/webkit/JsResult;

    .prologue
    .line 233
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-direct {p0, p4}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertJsResult(Landroid/webkit/JsResult;)Lcom/amazon/android/webkit/AmazonJsResult;

    move-result-object v2

    invoke-virtual {v0, v1, p2, p3, v2}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onJsAlert(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsResult;)Z

    move-result v0

    return v0
.end method

.method public onJsBeforeUnload(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "result"    # Landroid/webkit/JsResult;

    .prologue
    .line 259
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-direct {p0, p4}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertJsResult(Landroid/webkit/JsResult;)Lcom/amazon/android/webkit/AmazonJsResult;

    move-result-object v2

    invoke-virtual {v0, v1, p2, p3, v2}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onJsBeforeUnload(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsResult;)Z

    move-result v0

    return v0
.end method

.method public onJsConfirm(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "result"    # Landroid/webkit/JsResult;

    .prologue
    .line 239
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-direct {p0, p4}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertJsResult(Landroid/webkit/JsResult;)Lcom/amazon/android/webkit/AmazonJsResult;

    move-result-object v2

    invoke-virtual {v0, v1, p2, p3, v2}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onJsConfirm(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsResult;)Z

    move-result v0

    return v0
.end method

.method public onJsPrompt(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsPromptResult;)Z
    .locals 6
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "defaultValue"    # Ljava/lang/String;
    .param p5, "result"    # Landroid/webkit/JsPromptResult;

    .prologue
    .line 246
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-direct {p0, p5}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->convertJsPromptResult(Landroid/webkit/JsPromptResult;)Lcom/amazon/android/webkit/AmazonJsPromptResult;

    move-result-object v5

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onJsPrompt(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsPromptResult;)Z

    move-result v0

    return v0
.end method

.method public onJsTimeout()Z
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onJsTimeout()Z

    move-result v0

    return v0
.end method

.method public onProgressChanged(Landroid/webkit/WebView;I)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "newProgress"    # I

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onProgressChanged(Lcom/amazon/android/webkit/AmazonWebView;I)V

    .line 45
    return-void
.end method

.method public onReachedMaxAppCacheSize(JJLandroid/webkit/WebStorage$QuotaUpdater;)V
    .locals 6
    .param p1, "spaceNeeded"    # J
    .param p3, "totalUsedQuota"    # J
    .param p5, "quotaUpdater"    # Landroid/webkit/WebStorage$QuotaUpdater;

    .prologue
    .line 117
    new-instance v5, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$3;

    invoke-direct {v5, p0, p5}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$3;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/WebStorage$QuotaUpdater;)V

    .line 123
    .local v5, "amazonUpdater":Lcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    move-wide v1, p1

    move-wide v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onReachedMaxAppCacheSize(JJLcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;)V

    .line 125
    return-void
.end method

.method public onReceivedIcon(Landroid/webkit/WebView;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "icon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onReceivedIcon(Lcom/amazon/android/webkit/AmazonWebView;Landroid/graphics/Bitmap;)V

    .line 50
    return-void
.end method

.method public onReceivedTitle(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onReceivedTitle(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V

    .line 55
    return-void
.end method

.method public onReceivedTouchIconUrl(Landroid/webkit/WebView;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "touchIconUrl"    # Ljava/lang/String;
    .param p3, "precomposed"    # Z

    .prologue
    .line 130
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1, p2, p3}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onReceivedTouchIconUrl(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Z)V

    .line 131
    return-void
.end method

.method public onRequestFocus(Landroid/webkit/WebView;)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->webview:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v0, v1}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onRequestFocus(Lcom/amazon/android/webkit/AmazonWebView;)V

    .line 78
    return-void
.end method

.method public onShowCustomView(Landroid/view/View;Landroid/webkit/WebChromeClient$CustomViewCallback;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "callback"    # Landroid/webkit/WebChromeClient$CustomViewCallback;

    .prologue
    .line 135
    new-instance v0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$4;

    invoke-direct {v0, p0, p2}, Lcom/amazon/android/webkit/android/AndroidWebChromeClient$4;-><init>(Lcom/amazon/android/webkit/android/AndroidWebChromeClient;Landroid/webkit/WebChromeClient$CustomViewCallback;)V

    .line 141
    .local v0, "amazonCallback":Lcom/amazon/android/webkit/AmazonWebChromeClient$CustomViewCallback;
    iget-object v1, p0, Lcom/amazon/android/webkit/android/AndroidWebChromeClient;->client:Lcom/amazon/android/webkit/AmazonWebChromeClient;

    invoke-virtual {v1, p1, v0}, Lcom/amazon/android/webkit/AmazonWebChromeClient;->onShowCustomView(Landroid/view/View;Lcom/amazon/android/webkit/AmazonWebChromeClient$CustomViewCallback;)V

    .line 142
    return-void
.end method
