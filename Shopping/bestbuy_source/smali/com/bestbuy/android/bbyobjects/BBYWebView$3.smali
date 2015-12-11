.class Lcom/bestbuy/android/bbyobjects/BBYWebView$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYWebView;->setHtmlError(Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYWebView;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYWebView;)V
    .locals 0

    .prologue
    .line 533
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$3;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 537
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$3;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$3;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->k(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnu;->updateCartCount(Ljava/lang/String;)V

    .line 539
    return-void
.end method
