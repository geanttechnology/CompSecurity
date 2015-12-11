.class Lcom/amazon/device/ads/MraidBrowser$7;
.super Ljava/lang/Object;
.source "MraidBrowser.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/MraidBrowser;->initializeButtons(Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final originalUrl:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/device/ads/MraidBrowser;

.field final synthetic val$intent:Landroid/content/Intent;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidBrowser;Landroid/content/Intent;)V
    .locals 2

    .prologue
    .line 221
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$7;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    iput-object p2, p0, Lcom/amazon/device/ads/MraidBrowser$7;->val$intent:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 222
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$7;->val$intent:Landroid/content/Intent;

    const-string/jumbo v1, "extra_url"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$7;->originalUrl:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 227
    iget-object v2, p0, Lcom/amazon/device/ads/MraidBrowser$7;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;
    invoke-static {v2}, Lcom/amazon/device/ads/MraidBrowser;->access$200(Lcom/amazon/device/ads/MraidBrowser;)Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 228
    .local v0, "currentUrl":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 230
    const-string/jumbo v1, "The current URL is null. Reverting to the original URL for external browser."

    .line 231
    .local v1, "msg":Ljava/lang/String;
    sget-object v2, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "The current URL is null. Reverting to the original URL for external browser."

    invoke-static {v2, v3}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$7;->originalUrl:Ljava/lang/String;

    .line 235
    .end local v1    # "msg":Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Lcom/amazon/device/ads/MraidBrowser$7;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;
    invoke-static {v2}, Lcom/amazon/device/ads/MraidBrowser;->access$200(Lcom/amazon/device/ads/MraidBrowser;)Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/amazon/device/ads/AdUtils;->launchActivityForIntentLink(Ljava/lang/String;Landroid/content/Context;)Z

    .line 236
    return-void
.end method
