.class Lcom/bestbuy/android/activities/cart/MyCartFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/cart/MyCartFragment;->onClick(Landroid/view/View;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

.field final synthetic c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

.field final synthetic d:Lcom/bestbuy/android/activities/cart/MyCartFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/cart/MyCartFragment;Lcom/bestbuy/android/activities/home/HomeTabFragment;Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V
    .locals 0

    .prologue
    .line 209
    iput-object p1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->d:Lcom/bestbuy/android/activities/cart/MyCartFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iput-object p3, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    iput-object p4, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 213
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    iget-object v1, p0, Lcom/bestbuy/android/activities/cart/MyCartFragment$1;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 215
    return-void
.end method
