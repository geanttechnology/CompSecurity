.class Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V
    .locals 0

    .prologue
    .line 181
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 184
    new-instance v2, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-direct {v2, v0, v1, v4}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Landroid/support/v4/app/Fragment;Z)V

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$2;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 186
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 187
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "EditListDetailsFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 189
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_1

    .line 190
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v0, "EditListDetailsFragment"

    invoke-virtual {v1, v2, v4, v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 192
    :cond_1
    return-void
.end method
