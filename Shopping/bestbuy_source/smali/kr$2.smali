.class Lkr$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkr;->a()V
.end annotation


# instance fields
.field final synthetic a:Lkr;


# direct methods
.method constructor <init>(Lkr;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lkr$2;->a:Lkr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 39
    iget-object v0, p0, Lkr$2;->a:Lkr;

    invoke-static {v0}, Lkr;->a(Lkr;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lkr$2;->a:Lkr;

    invoke-static {v0}, Lkr;->a(Lkr;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 40
    :cond_0
    iget-object v0, p0, Lkr$2;->a:Lkr;

    iget-object v1, p0, Lkr$2;->a:Lkr;

    invoke-static {v1}, Lkr;->b(Lkr;)Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->d()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkr;->a(Lkr;Ljava/lang/String;)Ljava/lang/String;

    .line 41
    :cond_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    iget-object v2, p0, Lkr$2;->a:Lkr;

    invoke-static {v2}, Lkr;->a(Lkr;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 42
    iget-object v1, p0, Lkr$2;->a:Lkr;

    invoke-static {v1}, Lkr;->c(Lkr;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 43
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 44
    return-void
.end method
