.class Liq$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Liq;->c()V
.end annotation


# instance fields
.field final synthetic a:Liq;


# direct methods
.method constructor <init>(Liq;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Liq$1;->a:Liq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 19

    .prologue
    .line 84
    invoke-static {}, Liq;->f()I

    .line 85
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->a(Liq;)Landroid/app/Activity;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->b(Liq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->c(Liq;)Landroid/view/View;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->d(Liq;)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->e(Liq;)D

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->f(Liq;)D

    move-result-wide v10

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->g(Liq;)I

    move-result v12

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->h(Liq;)I

    move-result v13

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->i(Liq;)I

    move-result v14

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->j(Liq;)Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->k(Liq;)Ljava/util/ArrayList;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->l(Liq;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v2, v0, Liq$1;->a:Liq;

    invoke-static {v2}, Liq;->m(Liq;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 86
    return-void
.end method
