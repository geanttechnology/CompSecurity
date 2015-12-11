.class Lnu$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnu;->processHTMLError(Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lnu;


# direct methods
.method constructor <init>(Lnu;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lnu$4;->b:Lnu;

    iput-object p2, p0, Lnu$4;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 157
    iget-object v0, p0, Lnu$4;->b:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    iget-object v1, p0, Lnu$4;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setHtmlError(Ljava/lang/String;)V

    .line 158
    return-void
.end method
