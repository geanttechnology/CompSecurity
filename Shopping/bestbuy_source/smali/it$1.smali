.class Lit$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lit;->c()V
.end annotation


# instance fields
.field final synthetic a:Lit;


# direct methods
.method constructor <init>(Lit;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lit$1;->a:Lit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 52
    invoke-static {}, Lit;->f()I

    .line 53
    new-instance v0, Lit;

    iget-object v1, p0, Lit$1;->a:Lit;

    invoke-static {v1}, Lit;->a(Lit;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lit$1;->a:Lit;

    invoke-static {v2}, Lit;->b(Lit;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lit;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lit;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 54
    return-void
.end method
