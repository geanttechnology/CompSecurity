.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V
    .locals 0

    .prologue
    .line 1209
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 14

    .prologue
    .line 1215
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1216
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v2

    move/from16 v0, p4

    if-le v0, v2, :cond_0

    .line 1217
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    move/from16 v0, p4

    invoke-static {v2, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;I)I

    .line 1218
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Z)Z

    .line 1221
    :cond_0
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-nez v2, :cond_2

    sub-int v2, p4, p3

    move/from16 v0, p2

    if-ne v0, v2, :cond_2

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v2

    sub-int v2, p4, v2

    int-to-long v2, v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-gez v2, :cond_2

    .line 1222
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    move/from16 v0, p4

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(I)V

    .line 1223
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;I)I

    .line 1224
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1225
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 1226
    new-instance v2, Lid;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v3, v3, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/util/ArrayList;

    move-result-object v7

    iget-object v8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v9}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    iget-object v11, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v11

    iget-object v12, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v12}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v12

    const/4 v13, 0x1

    invoke-direct/range {v2 .. v13}, Lid;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V

    sget-object v3, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v2, v3, v4}, Lid;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1239
    :cond_1
    :goto_0
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Z)Z

    .line 1241
    :cond_2
    return-void

    .line 1228
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1229
    new-instance v2, Ljh;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v3, v3, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v7

    invoke-direct/range {v2 .. v7}, Ljh;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;I)V

    sget-object v3, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v2, v3, v4}, Ljh;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 1230
    :cond_4
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 1231
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 1232
    new-instance v2, Lhf;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v3, v3, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "Best-Match"

    const/16 v7, 0x14

    iget-object v8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    iget-object v11, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v11

    iget-object v12, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v12}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v12

    invoke-direct/range {v2 .. v12}, Lhf;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;IIZLandroid/view/View;ZLcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lhf;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 1234
    :cond_5
    new-instance v2, Lhf;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v3, v3, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "Best-Match"

    const/16 v7, 0x14

    iget-object v8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I

    move-result v8

    const/4 v9, 0x0

    const/4 v10, 0x0

    iget-object v11, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v11

    invoke-direct/range {v2 .. v11}, Lhf;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;IIZLandroid/view/View;Z)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    invoke-virtual {v2, v3}, Lhf;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 1237
    :cond_6
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Z)V

    goto/16 :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 1212
    return-void
.end method
