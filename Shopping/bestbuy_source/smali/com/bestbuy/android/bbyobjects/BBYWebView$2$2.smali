.class Lcom/bestbuy/android/bbyobjects/BBYWebView$2$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$2;)V
    .locals 0

    .prologue
    .line 202
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    iget-object v0, v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->onBackPressed()V

    .line 205
    return-void
.end method
