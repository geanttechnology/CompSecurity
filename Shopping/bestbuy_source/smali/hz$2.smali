.class Lhz$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhz;->h()V
.end annotation


# instance fields
.field final synthetic a:Lhz;


# direct methods
.method constructor <init>(Lhz;)V
    .locals 0

    .prologue
    .line 253
    iput-object p1, p0, Lhz$2;->a:Lhz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    .line 255
    invoke-static {}, Lhz;->f()I

    .line 256
    new-instance v0, Lhz;

    iget-object v1, p0, Lhz$2;->a:Lhz;

    invoke-static {v1}, Lhz;->b(Lhz;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lhz$2;->a:Lhz;

    invoke-static {v2}, Lhz;->c(Lhz;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    iget-object v3, p0, Lhz$2;->a:Lhz;

    invoke-static {v3}, Lhz;->d(Lhz;)Landroid/view/View;

    move-result-object v3

    iget-object v4, p0, Lhz$2;->a:Lhz;

    invoke-static {v4}, Lhz;->e(Lhz;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lhz$2;->a:Lhz;

    invoke-static {v5}, Lhz;->f(Lhz;)Ljava/util/Map;

    move-result-object v5

    iget-object v6, p0, Lhz$2;->a:Lhz;

    invoke-static {v6}, Lhz;->g(Lhz;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lhz$2;->a:Lhz;

    invoke-static {v7}, Lhz;->h(Lhz;)I

    move-result v7

    iget-object v8, p0, Lhz$2;->a:Lhz;

    invoke-static {v8}, Lhz;->i(Lhz;)I

    move-result v8

    invoke-direct/range {v0 .. v8}, Lhz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 259
    return-void
.end method
