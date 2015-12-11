.class Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 20

    .prologue
    .line 249
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 250
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I

    move-result v2

    move/from16 v0, p4

    if-le v0, v2, :cond_0

    .line 251
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    move/from16 v0, p4

    invoke-static {v2, v0}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;I)I

    .line 252
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;Z)Z

    .line 255
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Z

    move-result v2

    if-nez v2, :cond_1

    sub-int v2, p4, p3

    move/from16 v0, p2

    if-ne v0, v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->c(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I

    move-result v2

    sub-int v2, p4, v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->d(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 256
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->e(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->b(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;I)I

    .line 257
    new-instance v3, Lir;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->f(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Landroid/app/Activity;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->h(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)D

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->i(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)D

    move-result-wide v10

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->j(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->k(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->e(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)I

    move-result v15

    const/16 v16, 0x14

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->l(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/util/ArrayList;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->m(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->n(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;)Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v3 .. v19}, Lir;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Lir;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 258
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;Z)Z

    .line 260
    :cond_1
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 246
    return-void
.end method
