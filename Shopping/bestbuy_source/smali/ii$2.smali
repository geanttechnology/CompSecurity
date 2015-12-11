.class Lii$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lii;->c()V
.end annotation


# instance fields
.field final synthetic a:Lii;


# direct methods
.method constructor <init>(Lii;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lii$2;->a:Lii;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 77
    invoke-static {v2}, Lii;->a(I)I

    .line 78
    iget-object v0, p0, Lii$2;->a:Lii;

    invoke-static {v0}, Lii;->a(Lii;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 79
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/ProductTabContainer;

    if-eqz v1, :cond_1

    .line 81
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 82
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->b()Landroid/support/v4/app/FragmentTabHost;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentTabHost;->setCurrentTab(I)V

    .line 86
    :cond_0
    :goto_0
    return-void

    .line 83
    :cond_1
    if-nez v0, :cond_0

    .line 84
    iget-object v0, p0, Lii$2;->a:Lii;

    invoke-static {v0}, Lii;->b(Lii;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto :goto_0
.end method
