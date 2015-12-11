.class Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/dnm/DNMListFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V
    .locals 0

    .prologue
    .line 318
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 19

    .prologue
    .line 324
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->m(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 325
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->n(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I

    move-result v2

    move/from16 v0, p4

    if-le v0, v2, :cond_0

    .line 326
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    move/from16 v0, p4

    invoke-static {v2, v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;I)I

    .line 327
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Z)Z

    .line 330
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->m(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Z

    move-result v2

    if-nez v2, :cond_1

    sub-int v2, p4, p3

    move/from16 v0, p2

    if-ne v0, v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->o(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I

    move-result v2

    sub-int v2, p4, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->p(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 331
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b(Lcom/bestbuy/android/activities/dnm/DNMListFragment;I)I

    .line 332
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/app/Activity;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->f(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->d(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)D

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->e(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)D

    move-result-wide v10

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I

    move-result v13

    const/16 v14, 0x14

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/util/ArrayList;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 333
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;->a:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Z)Z

    .line 335
    :cond_1
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 321
    return-void
.end method
