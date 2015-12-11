.class Lcom/bestbuy/android/activities/BaseTabContainer$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Landroid/support/v4/app/Fragment;

.field final synthetic c:Lcom/bestbuy/android/activities/BaseTabContainer;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/BaseTabContainer;ZLandroid/support/v4/app/Fragment;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/activities/BaseTabContainer$1;->c:Lcom/bestbuy/android/activities/BaseTabContainer;

    iput-boolean p2, p0, Lcom/bestbuy/android/activities/BaseTabContainer$1;->a:Z

    iput-object p3, p0, Lcom/bestbuy/android/activities/BaseTabContainer$1;->b:Landroid/support/v4/app/Fragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/activities/BaseTabContainer$1;->c:Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 37
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/BaseTabContainer$1;->a:Z

    if-eqz v1, :cond_0

    .line 38
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 40
    :cond_0
    const v1, 0x7f0c009e

    iget-object v2, p0, Lcom/bestbuy/android/activities/BaseTabContainer$1;->b:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 41
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/activities/BaseTabContainer$1;->c:Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 43
    return-void
.end method
