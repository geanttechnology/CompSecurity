.class Lcom/bestbuy/android/bbyobjects/BBYWebView$2$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


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
    .line 195
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$1;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$1;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    iget-object v0, v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$1;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    iget-object v0, v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$1;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    iget-object v0, v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setVisibility(I)V

    .line 201
    :cond_0
    return-void
.end method
