.class Lik$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lik;->c()V
.end annotation


# instance fields
.field final synthetic a:Lik;


# direct methods
.method constructor <init>(Lik;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lik$1;->a:Lik;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    .line 74
    invoke-static {}, Lik;->f()I

    .line 75
    new-instance v0, Lik;

    iget-object v1, p0, Lik$1;->a:Lik;

    invoke-static {v1}, Lik;->a(Lik;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lik$1;->a:Lik;

    invoke-static {v2}, Lik;->b(Lik;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    iget-object v3, p0, Lik$1;->a:Lik;

    invoke-static {v3}, Lik;->c(Lik;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lik$1;->a:Lik;

    invoke-static {v4}, Lik;->d(Lik;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lik$1;->a:Lik;

    invoke-static {v5}, Lik;->e(Lik;)Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lik;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lik;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 76
    return-void
.end method
