.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->onRefresh()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V
    .locals 0

    .prologue
    .line 828
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 831
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setRefreshing(Z)V

    .line 832
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 833
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 834
    const-string v1, "fromPDPFragment"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 835
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 836
    const-string v2, "bb.prevPageLink"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "pdp: Blue Assist"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 837
    sget-object v2, Llu;->aT:Ljava/lang/String;

    invoke-static {v2, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 839
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    const/16 v2, 0x2326

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 841
    :cond_0
    return-void
.end method
