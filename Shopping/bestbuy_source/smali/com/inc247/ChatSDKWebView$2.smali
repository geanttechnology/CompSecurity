.class Lcom/inc247/ChatSDKWebView$2;
.super Landroid/webkit/WebViewClient;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDKWebView;->loadChatSDKWebView(Landroid/content/Context;)V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDKWebView;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDKWebView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDKWebView$2;->this$0:Lcom/inc247/ChatSDKWebView;

    .line 179
    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 221
    invoke-super {p0, p1, p2}, Landroid/webkit/WebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 222
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView$2;->this$0:Lcom/inc247/ChatSDKWebView;

    # getter for: Lcom/inc247/ChatSDKWebView;->spinnerLayout:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/inc247/ChatSDKWebView;->access$1(Lcom/inc247/ChatSDKWebView;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 223
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->maximizeChat()V

    .line 224
    return-void
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 3

    .prologue
    .line 211
    invoke-super {p0, p1, p2, p3}, Landroid/webkit/WebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 212
    iget-object v0, p0, Lcom/inc247/ChatSDKWebView$2;->this$0:Lcom/inc247/ChatSDKWebView;

    const/16 v1, 0x12c

    const-string v2, "Loading..."

    # invokes: Lcom/inc247/ChatSDKWebView;->showProgessDialog(ILjava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/inc247/ChatSDKWebView;->access$0(Lcom/inc247/ChatSDKWebView;ILjava/lang/String;)V

    .line 216
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 228
    .line 229
    sget-object v2, Lcom/inc247/constants/ChatSDKConstants;->CHATSDK_OFFLINEPAGE:Ljava/lang/String;

    const-string v4, "UTF-8"

    move-object v0, p1

    move-object v3, v1

    move-object v5, v1

    .line 228
    invoke-virtual/range {v0 .. v5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 231
    new-instance v0, Lcom/inc247/errors/ChatSDKError;

    .line 232
    sget-object v1, Lcom/inc247/errors/ChatSDKErrorCodes;->ChatSDKStartError:Lcom/inc247/errors/ChatSDKErrorCodes;

    .line 231
    invoke-direct {v0, v1}, Lcom/inc247/errors/ChatSDKError;-><init>(Lcom/inc247/errors/ChatSDKErrorCodes;)V

    .line 233
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->callback:Lcom/inc247/ChatSDKEventsCallback;

    invoke-virtual {v1, v0}, Lcom/inc247/ChatSDKEventsCallback;->sendonChatErrorEvent(Lcom/inc247/errors/ChatSDKError;)V

    .line 234
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 5

    .prologue
    .line 182
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p2, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "chatsdk_closedialog"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 183
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->endChat()V

    .line 205
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 184
    :cond_0
    sget-object v0, Lcom/inc247/ChatSDKResources;->CUSTOM_URL_SCHEME:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 185
    sget-object v0, Lcom/inc247/ChatSDKResources;->CUSTOM_URL_SCHEME:Ljava/lang/String;

    .line 186
    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 187
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p2, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 188
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "http://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcom/inc247/ChatSDKResources;->CUSTOM_URL_SCHEME:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 187
    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    .line 188
    if-eqz v0, :cond_1

    .line 190
    invoke-static {}, Lcom/inc247/ChatSDKEventsCallback;->getInstance()Lcom/inc247/ChatSDKEventsCallback;

    move-result-object v1

    .line 191
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2}, Lorg/json/JSONObject;-><init>()V

    .line 193
    :try_start_0
    const-string v0, "url"

    invoke-virtual {v2, v0, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 198
    :goto_1
    invoke-virtual {v1, v2}, Lcom/inc247/ChatSDKEventsCallback;->sendonNavigationRequest(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 194
    :catch_0
    move-exception v0

    .line 195
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 196
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "{\'Error\':\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "\'}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_1

    .line 200
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    .line 201
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 200
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 202
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v1

    iget-object v1, v1, Lcom/inc247/ChatSDK;->activity:Landroid/app/Activity;

    .line 203
    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
