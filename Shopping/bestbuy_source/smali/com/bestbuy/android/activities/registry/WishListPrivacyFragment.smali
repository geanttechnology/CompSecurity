.class public Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field public a:Ljava/lang/String;

.field private b:Landroid/widget/RadioButton;

.field private c:Landroid/widget/RadioButton;

.field private g:Z

.field private h:Z

.field private i:Lcv;

.field private j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private k:Landroid/support/v4/app/Fragment;

.field private l:Landroid/widget/RelativeLayout;

.field private m:Ljava/lang/String;

.field private n:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 30
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 37
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->n:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 42
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 30
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 37
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->n:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 46
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->m:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;Landroid/support/v4/app/Fragment;Z)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 30
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 37
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->n:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 56
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 57
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->p:Ljava/lang/String;

    .line 58
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->k:Landroid/support/v4/app/Fragment;

    .line 59
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->g:Z

    .line 60
    return-void
.end method


# virtual methods
.method public b()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPrivacySetting(Ljava/lang/String;)V

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->m:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->m:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 185
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->m:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;)V

    move-object v2, v0

    .line 190
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 191
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 192
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "WishlistAdditionalOptions"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 194
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 195
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "WishlistAdditionalOptions"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 197
    :cond_1
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_2

    .line 198
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v1, v2, v4}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 200
    :cond_2
    return-void

    .line 188
    :cond_3
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    move-object v2, v0

    goto :goto_0
.end method

.method public c()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 203
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->g:Z

    if-eqz v0, :cond_0

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPrivacySetting(Ljava/lang/String;)V

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->k:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v1, v3, v3}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;ZI)V

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 209
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->h:Z

    if-eqz v0, :cond_1

    .line 210
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 211
    const-string v0, "privacySetting"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->n:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPrivacySetting(Ljava/lang/String;)V

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->k:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->n:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1, v2, v3, v3}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Landroid/os/Bundle;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;ZI)V

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 217
    :cond_1
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 174
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->g:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->h:Z

    if-eqz v0, :cond_1

    .line 175
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c()V

    .line 179
    :goto_0
    return-void

    .line 177
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->b()V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 77
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 78
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->d:Landroid/app/Activity;

    .line 79
    check-cast p1, Lcv;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->i:Lcv;

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->i:Lcv;

    invoke-interface {v0}, Lcv;->onCreateWishListFragmentLaunch()V

    .line 81
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c:Landroid/widget/RadioButton;

    if-ne p1, v0, :cond_1

    .line 164
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 170
    :cond_0
    :goto_0
    return-void

    .line 165
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->b:Landroid/widget/RadioButton;

    if-ne p1, v0, :cond_2

    .line 166
    const-string v0, "private"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    goto :goto_0

    .line 167
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->l:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 85
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 86
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->setHasOptionsMenu(Z)V

    .line 87
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 132
    const v0, 0x7f03011b

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 133
    const v0, 0x7f0c0076

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->l:Landroid/widget/RelativeLayout;

    .line 134
    const v0, 0x7f0c0424

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c:Landroid/widget/RadioButton;

    .line 135
    const v0, 0x7f0c0425

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->b:Landroid/widget/RadioButton;

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c:Landroid/widget/RadioButton;

    invoke-virtual {v0, v3}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    const-string v2, "public"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPrivacySetting(Ljava/lang/String;)V

    .line 140
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->o:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->o:Ljava/lang/String;

    const-string v2, "public"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 142
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c:Landroid/widget/RadioButton;

    invoke-virtual {v0, v3}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 152
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c:Landroid/widget/RadioButton;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802c4

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->b:Landroid/widget/RadioButton;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802b4

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c:Landroid/widget/RadioButton;

    invoke-virtual {v0, p0}, Landroid/widget/RadioButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->b:Landroid/widget/RadioButton;

    invoke-virtual {v0, p0}, Landroid/widget/RadioButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->l:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    return-object v1

    .line 144
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->o:Ljava/lang/String;

    const-string v2, "private"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 145
    const-string v0, "private"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->b:Landroid/widget/RadioButton;

    invoke-virtual {v0, v3}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0

    .line 148
    :cond_3
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    goto :goto_0
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 91
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 92
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchVisibility(Landroid/app/Activity;Z)V

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->p:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->p:Ljava/lang/String;

    const-string v1, "public"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 108
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->c:Landroid/widget/RadioButton;

    invoke-virtual {v0, v3}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 118
    :cond_0
    :goto_0
    sput-boolean v3, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 120
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->g:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->h:Z

    if-eqz v0, :cond_4

    .line 121
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Privacy"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "Save"

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 127
    :goto_1
    return-void

    .line 110
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->p:Ljava/lang/String;

    const-string v1, "private"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 111
    const-string v0, "private"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->b:Landroid/widget/RadioButton;

    invoke-virtual {v0, v3}, Landroid/widget/RadioButton;->setChecked(Z)V

    goto :goto_0

    .line 114
    :cond_3
    const-string v0, "public"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->a:Ljava/lang/String;

    goto :goto_0

    .line 124
    :cond_4
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08033b

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08026a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    goto :goto_1
.end method
