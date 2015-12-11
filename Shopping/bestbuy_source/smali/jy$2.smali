.class Ljy$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljy;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljy;


# direct methods
.method constructor <init>(Ljy;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Ljy$2;->a:Ljy;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 75
    invoke-static {v2}, Ljy;->a(I)I

    .line 76
    iget-object v0, p0, Ljy$2;->a:Ljy;

    invoke-static {v0}, Ljy;->a(Ljy;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 77
    instance-of v1, v0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;

    if-eqz v1, :cond_0

    .line 78
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 79
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentTabHost;->setCurrentTab(I)V

    .line 81
    :cond_0
    return-void
.end method
