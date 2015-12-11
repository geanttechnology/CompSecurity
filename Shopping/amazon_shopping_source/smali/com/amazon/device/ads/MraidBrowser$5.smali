.class Lcom/amazon/device/ads/MraidBrowser$5;
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
.field final synthetic this$0:Lcom/amazon/device/ads/MraidBrowser;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidBrowser;)V
    .locals 0

    .prologue
    .line 207
    iput-object p1, p0, Lcom/amazon/device/ads/MraidBrowser$5;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/device/ads/MraidBrowser$5;->this$0:Lcom/amazon/device/ads/MraidBrowser;

    # getter for: Lcom/amazon/device/ads/MraidBrowser;->mWebView:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/amazon/device/ads/MraidBrowser;->access$200(Lcom/amazon/device/ads/MraidBrowser;)Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->reload()V

    .line 210
    return-void
.end method
