.class Lhx$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhx;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhx;


# direct methods
.method constructor <init>(Lhx;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lhx$1;->a:Lhx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 7

    .prologue
    .line 70
    iget-object v0, p0, Lhx$1;->a:Lhx;

    invoke-static {v0}, Lhx;->a(Lhx;)I

    .line 71
    new-instance v0, Lhx;

    iget-object v1, p0, Lhx$1;->a:Lhx;

    invoke-static {v1}, Lhx;->b(Lhx;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lhx$1;->a:Lhx;

    invoke-static {v2}, Lhx;->c(Lhx;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    iget-object v3, p0, Lhx$1;->a:Lhx;

    invoke-static {v3}, Lhx;->d(Lhx;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lhx$1;->a:Lhx;

    invoke-static {v4}, Lhx;->e(Lhx;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lhx$1;->a:Lhx;

    invoke-static {v5}, Lhx;->f(Lhx;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lhx$1;->a:Lhx;

    invoke-static {v6}, Lhx;->g(Lhx;)Ljava/lang/String;

    move-result-object v6

    invoke-direct/range {v0 .. v6}, Lhx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhx;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 72
    return-void
.end method
