.class Lcom/amazon/device/ads/MraidBrowser$2;
.super Landroid/webkit/WebChromeClient;
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
    .line 180
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$2;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onProgressChanged(Landroid/webkit/WebView;I)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "progress"    # I

    .prologue
    .line 182
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 183
    .local v0, "a":Landroid/app/Activity;
    const-string/jumbo v1, "Loading..."

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 184
    mul-int/lit8 v1, p2, 0x64

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setProgress(I)V

    .line 185
    const/16 v1, 0x64

    if-ne p2, v1, :cond_0

    .line 187
    invoke-virtual {p1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 189
    :cond_0
    iget-object v1, p0, Lcom/amazon/device/ads/MraidBrowser$2;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # invokes: Lcom/amazon/device/ads/MraidBrowser;->updateNavigationButtons(Landroid/webkit/WebView;)V
    invoke-static {v1, p1}, Lcom/amazon/device/ads/MraidBrowser;->access$100(Lcom/amazon/device/ads/MraidBrowser;Landroid/webkit/WebView;)V

    .line 190
    return-void
.end method
