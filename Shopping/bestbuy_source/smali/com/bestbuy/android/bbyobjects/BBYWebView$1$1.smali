.class Lcom/bestbuy/android/bbyobjects/BBYWebView$1$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/bbyobjects/BBYWebView$1;->onJsAlert(Landroid/webkit/WebView;Ljava/lang/String;Ljava/lang/String;Landroid/webkit/JsResult;)Z
.end annotation


# instance fields
.field final synthetic a:Landroid/webkit/JsResult;

.field final synthetic b:Lcom/bestbuy/android/bbyobjects/BBYWebView$1;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/bbyobjects/BBYWebView$1;Landroid/webkit/JsResult;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$1$1;->b:Lcom/bestbuy/android/bbyobjects/BBYWebView$1;

    iput-object p2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$1$1;->a:Landroid/webkit/JsResult;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView$1$1;->a:Landroid/webkit/JsResult;

    invoke-virtual {v0}, Landroid/webkit/JsResult;->confirm()V

    .line 125
    return-void
.end method
