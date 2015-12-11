.class Lcom/amazon/device/ads/AdWebViewClient$DefaultExecutor;
.super Ljava/lang/Object;
.source "AdWebViewClient.java"

# interfaces
.implements Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdWebViewClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DefaultExecutor"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdWebViewClient;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdWebViewClient;)V
    .locals 0

    .prologue
    .line 415
    iput-object p1, p0, Lcom/amazon/device/ads/AdWebViewClient$DefaultExecutor;->this$0:Lcom/amazon/device/ads/AdWebViewClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 420
    iget-object v0, p0, Lcom/amazon/device/ads/AdWebViewClient$DefaultExecutor;->this$0:Lcom/amazon/device/ads/AdWebViewClient;

    # getter for: Lcom/amazon/device/ads/AdWebViewClient;->adView:Lcom/amazon/device/ads/AdView;
    invoke-static {v0}, Lcom/amazon/device/ads/AdWebViewClient;->access$200(Lcom/amazon/device/ads/AdWebViewClient;)Lcom/amazon/device/ads/AdView;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/AdView;->launchExternalBrowserForLink(Ljava/lang/String;)Z

    .line 421
    const/4 v0, 0x1

    return v0
.end method
