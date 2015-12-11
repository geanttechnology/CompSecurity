.class Lnu$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnu;->processHTML(Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lnu;


# direct methods
.method constructor <init>(Lnu;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lnu$3;->b:Lnu;

    iput-object p2, p0, Lnu$3;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lnu$3;->b:Lnu;

    invoke-static {v0}, Lnu;->a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;

    move-result-object v0

    iget-object v1, p0, Lnu$3;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setHtmlContent(Ljava/lang/String;)V

    .line 143
    return-void
.end method
