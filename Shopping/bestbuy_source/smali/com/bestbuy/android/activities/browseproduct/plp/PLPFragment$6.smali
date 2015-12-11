.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->onRefresh()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V
    .locals 0

    .prologue
    .line 1396
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 1399
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->v(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setRefreshing(Z)V

    .line 1401
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1402
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1403
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1404
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1405
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1406
    const-string v2, "bb.prevPageLink"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Faceted : Blue Assist"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1417
    :goto_0
    sget-object v2, Llu;->aT:Ljava/lang/String;

    invoke-static {v2, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1419
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const/16 v2, 0x2326

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1421
    :cond_0
    return-void

    .line 1408
    :cond_1
    const-string v2, "bb.prevPageLink"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Llu;->f:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Blue Assist"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1411
    :cond_2
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1412
    const-string v2, "bb.prevPageLink"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Blue Assist"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1414
    :cond_3
    const-string v2, "bb.prevPageLink"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Llu;->e:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ": Blue Assist"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method
