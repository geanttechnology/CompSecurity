.class Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$2;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 221
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    .line 222
    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3$1;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;)V

    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 229
    return-void
.end method
