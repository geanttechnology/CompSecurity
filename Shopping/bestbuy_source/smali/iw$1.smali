.class Liw$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Liw;->c()V
.end annotation


# instance fields
.field final synthetic a:Liw;


# direct methods
.method constructor <init>(Liw;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Liw$1;->a:Liw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    .line 67
    invoke-static {}, Liw;->f()I

    .line 68
    new-instance v0, Liw;

    iget-object v1, p0, Liw$1;->a:Liw;

    invoke-static {v1}, Liw;->a(Liw;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Liw$1;->a:Liw;

    invoke-static {v2}, Liw;->b(Liw;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Liw$1;->a:Liw;

    invoke-static {v3}, Liw;->c(Liw;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Liw$1;->a:Liw;

    invoke-static {v4}, Liw;->d(Liw;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v4

    iget-object v5, p0, Liw$1;->a:Liw;

    invoke-static {v5}, Liw;->e(Liw;)Landroid/view/View;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Liw;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liw;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 69
    return-void
.end method
