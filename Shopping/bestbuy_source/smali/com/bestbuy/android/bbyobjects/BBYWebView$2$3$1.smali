.class Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;->run()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3$1;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3$1;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;

    iget-object v0, v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2$3;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    iget-object v0, v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    invoke-static {v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 226
    return-void
.end method
