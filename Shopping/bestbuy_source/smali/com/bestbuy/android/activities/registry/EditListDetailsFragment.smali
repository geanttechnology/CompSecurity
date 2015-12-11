.class public Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/widget/EditText;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private g:Ljava/lang/String;

.field private h:Lcv;

.field private i:Z

.field private j:Landroid/os/Bundle;

.field private k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private l:Landroid/support/v4/app/Fragment;

.field private m:Landroid/widget/RelativeLayout;

.field private n:Z


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Landroid/support/v4/app/Fragment;Z)V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 41
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->n:Z

    .line 49
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->l:Landroid/support/v4/app/Fragment;

    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 51
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->i:Z

    .line 52
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 41
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->n:Z

    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 56
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->g:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 41
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->n:Z

    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 61
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->g:Ljava/lang/String;

    .line 62
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->b:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;Z)Z
    .locals 0

    .prologue
    .line 29
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->n:Z

    return p1
.end method


# virtual methods
.method public b()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 162
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRegistryName(Ljava/lang/String;)V

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_0

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 165
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Llu;->N:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 168
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->b:Ljava/lang/String;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 169
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->b:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;)V

    move-object v2, v0

    .line 173
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 174
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_1

    move-object v0, v1

    .line 175
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "WishListPrivacyFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 177
    :cond_1
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_2

    move-object v0, v1

    .line 178
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "WishListPrivacyFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 180
    :cond_2
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_3

    .line 181
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v1, v2, v4}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 183
    :cond_3
    return-void

    .line 171
    :cond_4
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListPrivacyFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    move-object v2, v0

    goto :goto_0
.end method

.method public c()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 186
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 187
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRegistryName(Ljava/lang/String;)V

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddDescription(Ljava/lang/String;)V

    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->l:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v1, v2, v2}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;ZI)V

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 191
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 153
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->i:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->n:Z

    if-eqz v0, :cond_1

    .line 154
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c()V

    .line 159
    :cond_0
    :goto_0
    return-void

    .line 155
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->n:Z

    if-eqz v0, :cond_0

    .line 156
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->b()V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 68
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 69
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f080339

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 70
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 71
    check-cast p1, Lcv;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->h:Lcv;

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->h:Lcv;

    invoke-interface {v0}, Lcv;->onCreateWishListFragmentLaunch()V

    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 75
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Llu;->M:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 77
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 222
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 99
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 100
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->setHasOptionsMenu(Z)V

    .line 101
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 106
    const v0, 0x7f030037

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 107
    const v0, 0x7f0c0076

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->m:Landroid/widget/RelativeLayout;

    .line 108
    const v0, 0x7f0c00e6

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    new-instance v2, Lcs;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Lcs;-><init>(Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 112
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 113
    const/4 v2, 0x2

    invoke-virtual {v0, v2, v4}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "backtoschoollists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 117
    const-string v0, "Back To School"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    .line 133
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getRegistryName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getRegistryName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_9

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getRegistryName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getRegistryName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 146
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->m:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 148
    return-object v1

    .line 118
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "holidaylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 119
    const-string v0, "Holiday"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    goto :goto_0

    .line 120
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "birthdaylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 121
    const-string v0, "Birthday"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    goto :goto_0

    .line 122
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "anniversarylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 123
    const-string v0, "Anniversary"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    goto :goto_0

    .line 124
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "graduationlists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 125
    const-string v0, "Graduation"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    goto :goto_0

    .line 126
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "movinglists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 127
    const-string v0, "Moving"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    goto/16 :goto_0

    .line 128
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->k:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "weddinglists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 129
    const-string v0, "Wedding"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    goto/16 :goto_0

    .line 131
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->g:Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    goto/16 :goto_0

    .line 137
    :cond_9
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 138
    const-string v0, ""

    .line 139
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v0

    .line 140
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 141
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 142
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'s "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " List"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 143
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a:Landroid/widget/EditText;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "\'s "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->c:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " List"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    goto/16 :goto_1
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 81
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 82
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->j:Landroid/os/Bundle;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setSearchVisible(Z)V

    .line 85
    sput-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->j:Landroid/os/Bundle;

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->j:Landroid/os/Bundle;

    const-string v1, "isFromWishListSettings"

    invoke-virtual {v0, v1, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->i:Z

    .line 88
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->i:Z

    if-eqz v0, :cond_1

    .line 89
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "List Name"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "Save"

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 95
    :goto_0
    return-void

    .line 92
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f080339

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08026a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    goto :goto_0
.end method
