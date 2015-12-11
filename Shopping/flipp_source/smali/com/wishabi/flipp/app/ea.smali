.class final Lcom/wishabi/flipp/app/ea;
.super Lcom/wishabi/flipp/b/aq;
.source "SourceFile"


# instance fields
.field final synthetic a:Landroid/app/LoaderManager;

.field final synthetic b:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;Landroid/content/Context;Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Landroid/app/LoaderManager;)V
    .locals 0

    .prologue
    .line 631
    iput-object p1, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    iput-object p6, p0, Lcom/wishabi/flipp/app/ea;->a:Landroid/app/LoaderManager;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/wishabi/flipp/b/aq;-><init>(Landroid/content/Context;Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method protected final synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 6

    .prologue
    .line 631
    check-cast p1, Ljava/util/HashMap;

    if-eqz p1, :cond_3

    iget-object v1, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    const-string v0, "items"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v1, v0}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;Ljava/util/List;)Ljava/util/List;

    const-string v0, "coupons"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->k(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/b/aq;

    if-eqz v0, :cond_1

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    invoke-static {v0}, Lcom/wishabi/flipp/util/a;->a(Ljava/util/List;)[I

    move-result-object v0

    const-string v2, "coupon_ids"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putIntArray(Ljava/lang/String;[I)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->l(Lcom/wishabi/flipp/app/SearchFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->a:Landroid/app/LoaderManager;

    const/4 v2, 0x4

    iget-object v3, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v0, v2, v1, v3}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->a:Landroid/app/LoaderManager;

    const/4 v2, 0x6

    iget-object v3, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v0, v2, v1, v3}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->m(Lcom/wishabi/flipp/app/SearchFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->a:Landroid/app/LoaderManager;

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v0, v2, v1, v3}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    new-array v2, v0, [J

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->d(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/ai;

    iget-wide v4, v0, Lcom/wishabi/flipp/content/ai;->a:J

    aput-wide v4, v2, v1

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_2
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "item_ids"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putLongArray(Ljava/lang/String;[J)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/ea;->a:Landroid/app/LoaderManager;

    const/4 v2, 0x3

    iget-object v3, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    iget-object v1, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->n(Lcom/wishabi/flipp/app/SearchFragment;)Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/wishabi/flipp/app/ea;->a:Landroid/app/LoaderManager;

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/wishabi/flipp/app/ea;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_3
    return-void
.end method
