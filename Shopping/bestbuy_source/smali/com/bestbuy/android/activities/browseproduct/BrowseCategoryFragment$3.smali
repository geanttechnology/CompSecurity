.class Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->onRefresh()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)V
    .locals 0

    .prologue
    .line 327
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 330
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->e(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setRefreshing(Z)V

    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 332
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 333
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 334
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->c(Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 335
    const-string v2, "bb.prevPageLink"

    const-string v3, "Wish list page: Blue Assist"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 339
    :goto_0
    sget-object v2, Llu;->aT:Ljava/lang/String;

    invoke-static {v2, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 340
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    const/16 v2, 0x2326

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 342
    :cond_0
    return-void

    .line 337
    :cond_1
    const-string v2, "bb.prevPageLink"

    const-string v3, "Products Tab: Blue Assist"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method
