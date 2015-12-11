.class public Lcom/amazon/android/webkit/AmazonWebViewClient;
.super Ljava/lang/Object;
.source "AmazonWebViewClient.java"


# static fields
.field public static final ACCEPTED_URI_SCHEMA:Ljava/util/regex/Pattern;

.field public static final ERROR_AUTHENTICATION:I = -0x4

.field public static final ERROR_BAD_URL:I = -0xc

.field public static final ERROR_CONNECT:I = -0x6

.field public static final ERROR_FAILED_SSL_HANDSHAKE:I = -0xb

.field public static final ERROR_FILE:I = -0xd

.field public static final ERROR_FILE_NOT_FOUND:I = -0xe

.field public static final ERROR_HOST_LOOKUP:I = -0x2

.field public static final ERROR_IO:I = -0x7

.field public static final ERROR_OK:I = 0x0

.field public static final ERROR_PROXY_AUTHENTICATION:I = -0x5

.field public static final ERROR_REDIRECT_LOOP:I = -0x9

.field public static final ERROR_TIMEOUT:I = -0x8

.field public static final ERROR_TOO_MANY_REQUESTS:I = -0xf

.field public static final ERROR_UNKNOWN:I = -0x1

.field public static final ERROR_UNSUPPORTED_AUTH_SCHEME:I = -0x3

.field public static final ERROR_UNSUPPORTED_SCHEME:I = -0xa


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 122
    const-string/jumbo v0, "(?i)((?:http|https|file):\\/\\/|(?:inline|data|about|javascript):)(.*)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/webkit/AmazonWebViewClient;->ACCEPTED_URI_SCHEMA:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static defaultShouldOverrideUrlLoading(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Z
    .locals 6
    .param p0, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 134
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 153
    :cond_0
    :goto_0
    return v3

    .line 137
    :cond_1
    sget-object v5, Lcom/amazon/android/webkit/AmazonWebViewClient;->ACCEPTED_URI_SCHEMA:Ljava/util/regex/Pattern;

    invoke-virtual {v5, p1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 138
    .local v2, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->matches()Z

    move-result v5

    if-nez v5, :cond_0

    .line 144
    const/4 v5, 0x1

    :try_start_0
    invoke-static {p1, v5}, Landroid/content/Intent;->parseUri(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v1

    .line 145
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v5, "android.intent.category.BROWSABLE"

    invoke-virtual {v1, v5}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 146
    invoke-virtual {p0}, Lcom/amazon/android/webkit/AmazonWebView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move v3, v4

    .line 147
    goto :goto_0

    .line 148
    .end local v1    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v0

    .line 149
    .local v0, "ex":Ljava/net/URISyntaxException;
    const-string/jumbo v4, "AmazonWebViewClient"

    const-string/jumbo v5, "Unable to Launch Application, check URI"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 151
    .end local v0    # "ex":Ljava/net/URISyntaxException;
    :catch_1
    move-exception v0

    .line 152
    .local v0, "ex":Landroid/content/ActivityNotFoundException;
    const-string/jumbo v4, "AmazonWebViewClient"

    const-string/jumbo v5, "Unable to Launch Application"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method


# virtual methods
.method public doUpdateVisitedHistory(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "isReload"    # Z

    .prologue
    .line 210
    return-void
.end method

.method public onBeforeUrlRequest(Lcom/amazon/android/webkit/AmazonUrlRequest;)V
    .locals 0
    .param p1, "request"    # Lcom/amazon/android/webkit/AmazonUrlRequest;

    .prologue
    .line 327
    return-void
.end method

.method public onCompletedUrlRequest(Lcom/amazon/android/webkit/AmazonUrlRequest;)V
    .locals 0
    .param p1, "request"    # Lcom/amazon/android/webkit/AmazonUrlRequest;

    .prologue
    .line 341
    return-void
.end method

.method public onDocumentLoadFinished(Lcom/amazon/android/webkit/AmazonWebView;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;

    .prologue
    .line 187
    return-void
.end method

.method public onFormResubmission(Lcom/amazon/android/webkit/AmazonWebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "dontResend"    # Landroid/os/Message;
    .param p3, "resend"    # Landroid/os/Message;

    .prologue
    .line 241
    return-void
.end method

.method public onLoadResource(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 171
    return-void
.end method

.method public onPageFinished(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 178
    return-void
.end method

.method public onPageStarted(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    .line 194
    return-void
.end method

.method public onPrerenderingComplete(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/android/webkit/PrerenderStatus;)V
    .locals 0
    .param p1, "webview"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "referrer"    # Ljava/lang/String;
    .param p4, "prerenderStatus"    # Lcom/amazon/android/webkit/PrerenderStatus;

    .prologue
    .line 313
    return-void
.end method

.method public onPrerenderingPageLoadFinished(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "referrer"    # Ljava/lang/String;

    .prologue
    .line 288
    return-void
.end method

.method public onPrerenderingStarted(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "referrer"    # Ljava/lang/String;

    .prologue
    .line 295
    return-void
.end method

.method public onReceivedError(Lcom/amazon/android/webkit/AmazonWebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 202
    return-void
.end method

.method public onReceivedHttpAuthRequest(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonHttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "handler"    # Lcom/amazon/android/webkit/AmazonHttpAuthHandler;
    .param p3, "host"    # Ljava/lang/String;
    .param p4, "realm"    # Ljava/lang/String;

    .prologue
    .line 218
    return-void
.end method

.method public onReceivedLoginRequest(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "realm"    # Ljava/lang/String;
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "args"    # Ljava/lang/String;

    .prologue
    .line 233
    return-void
.end method

.method public onReceivedSslError(Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/android/webkit/AmazonSslErrorHandler;Landroid/net/http/SslError;)V
    .locals 0
    .param p1, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "sslErrorHandler"    # Lcom/amazon/android/webkit/AmazonSslErrorHandler;
    .param p3, "sslError"    # Landroid/net/http/SslError;

    .prologue
    .line 226
    return-void
.end method

.method public onScaleChanged(Lcom/amazon/android/webkit/AmazonWebView;FF)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "oldScale"    # F
    .param p3, "newScale"    # F

    .prologue
    .line 273
    return-void
.end method

.method public onTooManyRedirects(Lcom/amazon/android/webkit/AmazonWebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "cancelMsg"    # Landroid/os/Message;
    .param p3, "continueMsg"    # Landroid/os/Message;

    .prologue
    .line 249
    return-void
.end method

.method public onUnhandledKeyEvent(Lcom/amazon/android/webkit/AmazonWebView;Landroid/view/KeyEvent;)V
    .locals 0
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 265
    return-void
.end method

.method public shouldAllowPrerender(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "referrer"    # Ljava/lang/String;

    .prologue
    .line 305
    const/4 v0, 0x0

    return v0
.end method

.method public shouldInterceptRequest(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Lcom/amazon/android/webkit/AmazonWebResourceResponse;
    .locals 1
    .param p1, "webview"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 281
    const/4 v0, 0x0

    return-object v0
.end method

.method public shouldOverrideKeyEvent(Lcom/amazon/android/webkit/AmazonWebView;Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 257
    const/4 v0, 0x0

    return v0
.end method

.method public shouldOverrideUrlLoading(Lcom/amazon/android/webkit/AmazonWebView;Ljava/lang/String;)Z
    .locals 1
    .param p1, "view"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 163
    const/4 v0, 0x0

    return v0
.end method
