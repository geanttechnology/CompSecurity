.class Lcom/bestbuy/android/activities/home/HomeFragment$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/HomeFragment;->a(Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/widget/LinearLayout;

.field final synthetic b:Lcom/bestbuy/android/base/BBYBaseFragment;

.field final synthetic c:Lcom/bestbuy/android/activities/home/HomeFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeFragment;Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V
    .locals 0

    .prologue
    .line 431
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$5;->c:Lcom/bestbuy/android/activities/home/HomeFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/home/HomeFragment$5;->a:Landroid/widget/LinearLayout;

    iput-object p3, p0, Lcom/bestbuy/android/activities/home/HomeFragment$5;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 433
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$5;->c:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$5;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeFragment$5;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 434
    return-void
.end method
