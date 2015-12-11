.class Ljz$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljz;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljz;


# direct methods
.method constructor <init>(Ljz;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Ljz$2;->a:Ljz;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 68
    invoke-static {v2}, Ljz;->a(I)I

    .line 69
    iget-object v0, p0, Ljz$2;->a:Ljz;

    invoke-static {v0}, Ljz;->a(Ljz;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 70
    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v1, :cond_0

    .line 71
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 72
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentTabHost;->setCurrentTab(I)V

    .line 74
    :cond_0
    return-void
.end method
