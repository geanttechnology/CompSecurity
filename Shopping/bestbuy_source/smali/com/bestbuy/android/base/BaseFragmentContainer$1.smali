.class Lcom/bestbuy/android/base/BaseFragmentContainer$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Z

.field final synthetic b:Landroid/support/v4/app/Fragment;

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Lcom/bestbuy/android/base/BaseFragmentContainer;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/base/BaseFragmentContainer;ZLandroid/support/v4/app/Fragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->d:Lcom/bestbuy/android/base/BaseFragmentContainer;

    iput-boolean p2, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->a:Z

    iput-object p3, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->b:Landroid/support/v4/app/Fragment;

    iput-object p4, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->c:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->d:Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 31
    iget-boolean v1, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->a:Z

    if-eqz v1, :cond_0

    .line 32
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 34
    :cond_0
    const v1, 0x7f0c009e

    iget-object v2, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->b:Landroid/support/v4/app/Fragment;

    iget-object v3, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 35
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/base/BaseFragmentContainer$1;->d:Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 37
    return-void
.end method
