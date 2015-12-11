.class Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)V
    .locals 0

    .prologue
    .line 606
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 11

    .prologue
    .line 612
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 613
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->n(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v0

    if-le p4, v0, :cond_0

    .line 614
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0, p4}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;I)I

    .line 615
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->c(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z

    .line 618
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->m(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z

    move-result v0

    if-nez v0, :cond_2

    sub-int v0, p4, p3

    if-ne p2, v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->e(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 619
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v1

    add-int/lit8 v1, v1, 0xa

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;I)I

    .line 620
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "IS_MAP_VIEW"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z

    .line 621
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->g(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 622
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->o(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    .line 623
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 624
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->b(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z

    .line 625
    new-instance v0, Ljy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    const/4 v3, 0x0

    iget-object v5, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v5}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v5

    const/16 v6, 0x32

    invoke-direct/range {v0 .. v6}, Ljy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 633
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->c(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Z)Z

    .line 635
    :cond_2
    return-void

    .line 628
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljz;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 629
    iget-object v10, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    new-instance v0, Ljz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->k(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)D

    move-result-wide v4

    iget-object v6, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->l(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)D

    move-result-wide v6

    iget-object v8, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v8}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->f(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)I

    move-result v8

    const/16 v9, 0x32

    invoke-direct/range {v0 .. v9}, Ljz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V

    invoke-static {v10, v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;Ljz;)Ljz;

    .line 630
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$4;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)Ljz;

    move-result-object v0

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 609
    return-void
.end method
