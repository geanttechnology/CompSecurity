.class Lcom/bestbuy/android/activities/home/HomeActivity$7;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeActivity;->getListener()Landroid/support/v4/app/FragmentManager$OnBackStackChangedListener;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeActivity;)V
    .locals 0

    .prologue
    .line 1383
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeActivity$7;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackStackChanged()V
    .locals 2

    .prologue
    .line 1385
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$7;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 1386
    if-eqz v0, :cond_0

    .line 1387
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v1

    .line 1388
    if-nez v1, :cond_1

    .line 1389
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$7;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->finish()V

    .line 1402
    :cond_0
    :goto_0
    return-void

    .line 1391
    :cond_1
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v0

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 1392
    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_0

    .line 1395
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$7;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    # getter for: Lcom/bestbuy/android/activities/home/HomeActivity;->homeTabFragment:Lcom/bestbuy/android/activities/home/HomeTabFragment;
    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->access$800(Lcom/bestbuy/android/activities/home/HomeActivity;)Lcom/bestbuy/android/activities/home/HomeTabFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTabHost;->getCurrentTab()I

    move-result v0

    .line 1396
    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 1397
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeActivity$7;->a:Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onStoresFramentLaunch()V

    goto :goto_0
.end method
