.class public Lcom/amazon/device/ads/MraidView$MraidWebChromeClient;
.super Landroid/webkit/WebChromeClient;
.source "MraidView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "MraidWebChromeClient"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/MraidView;


# direct methods
.method protected constructor <init>(Lcom/amazon/device/ads/MraidView;)V
    .locals 0

    .prologue
    .line 600
    iput-object p1, p0, Lcom/amazon/device/ads/MraidView$MraidWebChromeClient;->this$0:Lcom/amazon/device/ads/MraidView;

    invoke-direct {p0}, Landroid/webkit/WebChromeClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onJsAlert(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "result"    # Landroid/webkit/JsResult;

    .prologue
    .line 603
    # getter for: Lcom/amazon/device/ads/MraidView;->LOGTAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/device/ads/MraidView;->access$700()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p3}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 604
    const/4 v0, 0x0

    return v0
.end method
