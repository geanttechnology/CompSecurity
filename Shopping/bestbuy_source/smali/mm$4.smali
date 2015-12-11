.class final Lmm$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lmm;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field final synthetic b:Lcom/bestbuy/android/base/BBYBaseFragment;

.field final synthetic c:Z

.field final synthetic d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/base/BBYBaseFragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lmm$4;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iput-object p2, p0, Lmm$4;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    iput-boolean p3, p0, Lmm$4;->c:Z

    iput-object p4, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 110
    iget-object v0, p0, Lmm$4;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_1

    .line 111
    new-instance v1, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v0, p0, Lmm$4;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-object v2, p0, Lmm$4;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-boolean v3, p0, Lmm$4;->c:Z

    invoke-direct {v1, v0, v2, v3}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Landroid/support/v4/app/Fragment;Z)V

    .line 113
    iget-object v0, p0, Lmm$4;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 114
    instance-of v2, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v2, :cond_0

    .line 115
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 133
    :cond_0
    :goto_0
    return-void

    .line 117
    :cond_1
    iget-object v0, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_0

    .line 118
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 119
    const-string v1, "listType"

    iget-object v2, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    const-string v1, "listUuid"

    iget-object v2, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    const-string v1, "listName"

    iget-object v2, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    const-string v1, "listPrivacy"

    iget-object v2, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    const-string v1, "shippingAddress"

    iget-object v2, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShippingAddress()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string v1, "addDescription"

    iget-object v2, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPersonalizedMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v1, "location"

    iget-object v2, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getLocation()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v2, p0, Lmm$4;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lmm$4;->d:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v4, p0, Lmm$4;->c:Z

    invoke-direct {v1, v2, v3, v4}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    .line 127
    invoke-virtual {v1, v0}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 128
    iget-object v0, p0, Lmm$4;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 129
    instance-of v2, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v2, :cond_0

    .line 130
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "WishListSettingsFragment"

    invoke-virtual {v0, v1, v5, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_0
.end method
