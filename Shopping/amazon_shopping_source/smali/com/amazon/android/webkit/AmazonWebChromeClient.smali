.class public Lcom/amazon/android/webkit/AmazonWebChromeClient;
.super Ljava/lang/Object;
.source "AmazonWebChromeClient.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/android/webkit/AmazonWebChromeClient$OnCreateWindowCallback;,
        Lcom/amazon/android/webkit/AmazonWebChromeClient$CustomViewCallback;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method


# virtual methods
.method public getDefaultVideoPoster()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x0

    return-object v0
.end method

.method public getVideoLoadingProgressView()Landroid/view/View;
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x0

    return-object v0
.end method

.method public getVisitedHistory(Lcom/amazon/android/webkit/AmazonValueCallback;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/android/webkit/AmazonValueCallback",
            "<[",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 255
    .local p1, "callback":Lcom/amazon/android/webkit/AmazonValueCallback;, "Lcom/amazon/android/webkit/AmazonValueCallback<[Ljava/lang/String;>;"
    return-void
.end method

.method public onCloseWindow(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 155
    return-void
.end method

.method public onConsoleMessage(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "lineNumber"    # I
    .param p3, "sourceID"    # Ljava/lang/String;

    .prologue
    .line 238
    return-void
.end method

.method public onConsoleMessage(Lcom/amazon/android/webkit/AmazonConsoleMessage;)Z
    .locals 1
    .param p1, "consoleMessage"    # Lcom/amazon/android/webkit/AmazonConsoleMessage;

    .prologue
    .line 173
    const/4 v0, 0x0

    return v0
.end method

.method public onContentsReplaced(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "webview"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 340
    return-void
.end method

.method public onCreateWindow(Lcom/amazon/android/webkit/AmazonWebView;ZZLandroid/os/Bundle;Lcom/amazon/android/webkit/AmazonWebChromeClient$OnCreateWindowCallback;)Z
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "dialog"    # Z
    .param p3, "userGesture"    # Z
    .param p4, "extraData"    # Landroid/os/Bundle;
    .param p5, "callback"    # Lcom/amazon/android/webkit/AmazonWebChromeClient$OnCreateWindowCallback;

    .prologue
    .line 140
    const/4 v0, 0x0

    return v0
.end method

.method public onDocumentLoadTimes(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonDocumentLoadTimes;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "loadTimes"    # Lcom/amazon/android/webkit/AmazonDocumentLoadTimes;

    .prologue
    .line 300
    return-void
.end method

.method public onExceededDatabaseQuota(Ljava/lang/String;Ljava/lang/String;JJJLcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "databaseIdentifier"    # Ljava/lang/String;
    .param p3, "currentQuota"    # J
    .param p5, "estimatedSize"    # J
    .param p7, "totalUsedQuota"    # J
    .param p9, "quotaUpdater"    # Lcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;

    .prologue
    .line 72
    return-void
.end method

.method public onGeolocationPermissionsHidePrompt()V
    .locals 0

    .prologue
    .line 79
    return-void
.end method

.method public onGeolocationPermissionsShowPrompt(Ljava/lang/String;Lcom/amazon/android/webkit/AmazonGeolocationPermissions$Callback;)V
    .locals 0
    .param p1, "origin"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/android/webkit/AmazonGeolocationPermissions$Callback;

    .prologue
    .line 189
    return-void
.end method

.method public onHideAutofillPopup(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 333
    return-void
.end method

.method public onHideCustomView()V
    .locals 0

    .prologue
    .line 128
    return-void
.end method

.method public onInsecureContent(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "allowed"    # Z

    .prologue
    .line 362
    return-void
.end method

.method public onJsAlert(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsResult;)Z
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "result"    # Lcom/amazon/android/webkit/AmazonJsResult;

    .prologue
    .line 210
    const/4 v0, 0x0

    return v0
.end method

.method public onJsBeforeUnload(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsResult;)Z
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "result"    # Lcom/amazon/android/webkit/AmazonJsResult;

    .prologue
    .line 247
    const/4 v0, 0x0

    return v0
.end method

.method public onJsConfirm(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsResult;)Z
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "result"    # Lcom/amazon/android/webkit/AmazonJsResult;

    .prologue
    .line 220
    const/4 v0, 0x0

    return v0
.end method

.method public onJsPrompt(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/AmazonJsPromptResult;)Z
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "defaultValue"    # Ljava/lang/String;
    .param p5, "result"    # Lcom/amazon/android/webkit/AmazonJsPromptResult;

    .prologue
    .line 230
    const/4 v0, 0x0

    return v0
.end method

.method public onJsTimeout()Z
    .locals 1

    .prologue
    .line 180
    const/4 v0, 0x0

    return v0
.end method

.method public onMediaDevicePermissionsShowPrompt(Ljava/lang/String;Lcom/amazon/android/webkit/AmazonMediaDeviceSettings$Callback;)V
    .locals 0
    .param p1, "origin"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/amazon/android/webkit/AmazonMediaDeviceSettings$Callback;

    .prologue
    .line 201
    return-void
.end method

.method public onProgressChanged(Lcom/amazon/android/webkit/AmazonWebView;I)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "newProgress"    # I

    .prologue
    .line 86
    return-void
.end method

.method public onReachedMaxAppCacheSize(JJLcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;)V
    .locals 0
    .param p1, "spaceNeeded"    # J
    .param p3, "totalUsedQuota"    # J
    .param p5, "quotaUpdater"    # Lcom/amazon/android/webkit/AmazonWebStorage$QuotaUpdater;

    .prologue
    .line 94
    return-void
.end method

.method public onReceivedIcon(Lcom/amazon/android/webkit/AmazonWebView;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "icon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 101
    return-void
.end method

.method public onReceivedTitle(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 108
    return-void
.end method

.method public onReceivedTouchIconUrl(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "touchIconUrl"    # Ljava/lang/String;
    .param p3, "precomposed"    # Z

    .prologue
    .line 114
    return-void
.end method

.method public onRequestFocus(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 148
    return-void
.end method

.method public onSavePassword(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonSavePasswordCallback;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "callback"    # Lcom/amazon/android/webkit/AmazonSavePasswordCallback;

    .prologue
    .line 352
    invoke-interface {p2}, Lcom/amazon/android/webkit/AmazonSavePasswordCallback;->notNow()V

    .line 353
    return-void
.end method

.method public onSelectionDone(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 165
    return-void
.end method

.method public onSelectionStart(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 160
    return-void
.end method

.method public onShowAutofillPopup(Lcom/amazon/android/webkit/AmazonWebView;Landroid/graphics/Rect;[Lcom/amazon/android/webkit/AmazonAutofillSuggestion;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "rect"    # Landroid/graphics/Rect;
    .param p3, "suggestions"    # [Lcom/amazon/android/webkit/AmazonAutofillSuggestion;

    .prologue
    .line 323
    return-void
.end method

.method public onShowCustomView(Landroid/view/View;Lcom/amazon/android/webkit/AmazonWebChromeClient$CustomViewCallback;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "callback"    # Lcom/amazon/android/webkit/AmazonWebChromeClient$CustomViewCallback;

    .prologue
    .line 121
    return-void
.end method

.method public onWebTimings(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonWebTimings;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "timings"    # Lcom/amazon/android/webkit/AmazonWebTimings;

    .prologue
    .line 291
    return-void
.end method

.method public onWebViewMetrics(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonWebViewMetrics;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "metrics"    # Lcom/amazon/android/webkit/AmazonWebViewMetrics;

    .prologue
    .line 309
    return-void
.end method

.method public onWebViewResponsive(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 276
    return-void
.end method

.method public onWebViewTerminated(Lcom/amazon/android/webkit/AmazonWebView;I)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "errorCode"    # I

    .prologue
    .line 282
    return-void
.end method

.method public onWebViewUnresponsive(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 269
    return-void
.end method

.method public openFileChooser(Lcom/amazon/android/webkit/AmazonValueCallback;Ljava/lang/String;)V
    .locals 1
    .param p2, "acceptType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/android/webkit/AmazonValueCallback",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 261
    .local p1, "uploadFile":Lcom/amazon/android/webkit/AmazonValueCallback;, "Lcom/amazon/android/webkit/AmazonValueCallback<Landroid/net/Uri;>;"
    const/4 v0, 0x0

    invoke-interface {p1, v0}, Lcom/amazon/android/webkit/AmazonValueCallback;->onReceiveValue(Ljava/lang/Object;)V

    .line 262
    return-void
.end method

.method public toggleFullscreenModeForTab(Z)V
    .locals 0
    .param p1, "enterFullscreen"    # Z

    .prologue
    .line 374
    return-void
.end method
