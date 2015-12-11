.class Lir$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lno;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lir;->c()V
.end annotation


# instance fields
.field final synthetic a:Lir;


# direct methods
.method constructor <init>(Lir;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lir$1;->a:Lir;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 20

    .prologue
    .line 86
    invoke-static {}, Lir;->f()I

    .line 87
    new-instance v3, Lir;

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->a(Lir;)Landroid/app/Activity;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->b(Lir;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->c(Lir;)Landroid/view/View;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->d(Lir;)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->e(Lir;)D

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->f(Lir;)D

    move-result-wide v10

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->g(Lir;)I

    move-result v12

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->h(Lir;)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->i(Lir;)Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->j(Lir;)I

    move-result v15

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->k(Lir;)I

    move-result v16

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->l(Lir;)Ljava/util/ArrayList;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->m(Lir;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v2, v0, Lir$1;->a:Lir;

    invoke-static {v2}, Lir;->n(Lir;)Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v3 .. v19}, Lir;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Lir;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 88
    return-void
.end method
