.class Lcom/amazon/device/ads/MraidBrowser$1;
.super Landroid/webkit/WebViewClient;
.source "MraidBrowser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/MraidBrowser;->initializeWebView(Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/MraidBrowser;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidBrowser;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$1;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    .line 150
    sget-object v0, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "MRAID error: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p3, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 151
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 7
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 156
    if-nez p2, :cond_1

    .line 176
    :cond_0
    :goto_0
    return v1

    .line 158
    :cond_1
    const-string/jumbo v3, "market:"

    invoke-virtual {p2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "tel:"

    invoke-virtual {p2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "voicemail:"

    invoke-virtual {p2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "sms:"

    invoke-virtual {p2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "mailto:"

    invoke-virtual {p2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "geo:"

    invoke-virtual {p2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    const-string/jumbo v3, "google.streetview:"

    invoke-virtual {p2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 165
    :cond_2
    :try_start_0
    iget-object v3, p0, Lcom/amazon/device/ads/MraidBrowser$1;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->activity:Landroid/app/Activity;
    invoke-static {v3}, Lcom/amazon/device/ads/MraidBrowser;->access$000(Lcom/amazon/device/ads/MraidBrowser;)Landroid/app/Activity;

    move-result-object v3

    new-instance v4, Landroid/content/Intent;

    const-string/jumbo v5, "android.intent.action.VIEW"

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v3, v4}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    move v1, v2

    .line 174
    goto :goto_0

    .line 167
    :catch_0
    move-exception v0

    .line 169
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    sget-object v3, Lcom/amazon/device/ads/MraidBrowser;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v4, "Could not handle intent with URI: %s"

    new-array v5, v2, [Ljava/lang/Object;

    aput-object p2, v5, v1

    invoke-static {v3, v4, v5}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method
