.class Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;
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
    .line 169
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/Button;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v0

    .line 174
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    .line 175
    new-instance v2, Lks;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v3, v3, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-direct {v2, v3, v4, v0, v1}, Lks;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    invoke-virtual {v2}, Lks;->a()V

    .line 178
    return-void
.end method
