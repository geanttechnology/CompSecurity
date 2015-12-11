.class public Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lcg;


# instance fields
.field private a:Landroid/support/v4/app/FragmentActivity;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/EditText;

.field private g:Landroid/widget/EditText;

.field private h:Landroid/widget/EditText;

.field private i:Lcu;

.field private j:Z

.field private k:Z

.field private l:Z

.field private m:Z

.field private n:Z

.field private o:Landroid/support/v4/app/Fragment;

.field private p:Z

.field private q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private r:Landroid/os/Bundle;

.field private s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private t:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 53
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 41
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->j:Z

    .line 42
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->k:Z

    .line 43
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->l:Z

    .line 44
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->m:Z

    .line 45
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->n:Z

    .line 54
    return-void
.end method

.method public constructor <init>(Landroid/support/v4/app/Fragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 60
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 41
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->j:Z

    .line 42
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->k:Z

    .line 43
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->l:Z

    .line 44
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->m:Z

    .line 45
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->n:Z

    .line 61
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->o:Landroid/support/v4/app/Fragment;

    .line 62
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->p:Z

    .line 63
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 64
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 56
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 41
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->j:Z

    .line 42
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->k:Z

    .line 43
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->l:Z

    .line 44
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->m:Z

    .line 45
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->n:Z

    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->t:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->k:Z

    return v0
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->k:Z

    return p1
.end method

.method private b()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 173
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 175
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 176
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->g:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 177
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->h:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 179
    new-instance v5, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v5}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v5, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 180
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, v5, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->firstName:Ljava/lang/String;

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->lastName:Ljava/lang/String;

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v3, v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->coregistrantFirstName:Ljava/lang/String;

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v4, v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->coregistrantLastName:Ljava/lang/String;

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->createdBy:Ljava/lang/String;

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->lastModifiedBy:Ljava/lang/String;

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->t:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->t:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 189
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->t:Ljava/lang/String;

    invoke-direct {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;-><init>(Ljava/lang/String;)V

    move-object v2, v0

    .line 193
    :goto_0
    const-string v0, "data"

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v0, v3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 194
    invoke-virtual {v2, v1}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->setArguments(Landroid/os/Bundle;)V

    .line 195
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 196
    instance-of v0, v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 197
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "WeddingDateFragment"

    invoke-virtual {v0, v2, v6, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 199
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v0, :cond_1

    .line 200
    check-cast v1, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    invoke-virtual {v1, v2, v6}, Lcom/bestbuy/android/activities/home/HomeTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 202
    :cond_1
    return-void

    .line 191
    :cond_2
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;-><init>()V

    move-object v2, v0

    goto :goto_0
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->l:Z

    return v0
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->l:Z

    return p1
.end method

.method private c()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 206
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 207
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->g:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 208
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->h:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 209
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    iput-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->r:Landroid/os/Bundle;

    .line 210
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->r:Landroid/os/Bundle;

    const-string v5, "firstName"

    invoke-virtual {v4, v5, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->r:Landroid/os/Bundle;

    const-string v5, "lastName"

    invoke-virtual {v4, v5, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 212
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->r:Landroid/os/Bundle;

    const-string v5, "coRegFirstName"

    invoke-virtual {v4, v5, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->r:Landroid/os/Bundle;

    const-string v5, "coRegLastName"

    invoke-virtual {v4, v5, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 214
    new-instance v4, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v4}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 215
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setFirstName(Ljava/lang/String;)V

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setLastName(Ljava/lang/String;)V

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantFirstName(Ljava/lang/String;)V

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantLastName(Ljava/lang/String;)V

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPrivacySetting(Ljava/lang/String;)V

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setTheKnot(Z)V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setMyregistry(Z)V

    .line 222
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->o:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->r:Landroid/os/Bundle;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->s:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1, v2, v6, v6}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Landroid/os/Bundle;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;ZI)V

    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 224
    return-void
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->m:Z

    return v0
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->m:Z

    return p1
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;)Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->n:Z

    return v0
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->n:Z

    return p1
.end method

.method public static synthetic e(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Z)Z
    .locals 0

    .prologue
    .line 33
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->j:Z

    return p1
.end method


# virtual methods
.method public g()V
    .locals 1

    .prologue
    .line 163
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->j:Z

    if-eqz v0, :cond_0

    .line 164
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->p:Z

    if-eqz v0, :cond_1

    .line 165
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c()V

    .line 170
    :cond_0
    :goto_0
    return-void

    .line 167
    :cond_1
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b()V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 68
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 69
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    move-object v0, p1

    .line 73
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f080338

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 74
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 75
    check-cast p1, Lcu;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->i:Lcu;

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->i:Lcu;

    invoke-interface {v0}, Lcu;->onCreateRegistryFragmentLaunch()V

    .line 77
    sget-object v0, Llu;->au:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 78
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 82
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 83
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->setHasOptionsMenu(Z)V

    .line 84
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const/4 v4, 0x0

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 99
    const v0, 0x7f030026

    invoke-virtual {p1, v0, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v2, 0x10

    invoke-virtual {v0, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 101
    const v0, 0x7f0c00a7

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    .line 102
    const v0, 0x7f0c00a8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    .line 103
    const v0, 0x7f0c00a9

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->g:Landroid/widget/EditText;

    .line 104
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->p:Z

    if-eqz v0, :cond_5

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 108
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 109
    invoke-virtual {v0, v6, v5}, Landroid/view/inputmethod/InputMethodManager;->toggleSoftInput(II)V

    .line 110
    const v0, 0x7f0c00aa

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->h:Landroid/widget/EditText;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    new-instance v2, Lcr;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Lcr;-><init>(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    new-instance v2, Lcr;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Lcr;-><init>(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-virtual {v0, v4}, Landroid/widget/EditText;->setKeyListener(Landroid/text/method/KeyListener;)V

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    invoke-virtual {v0, v4}, Landroid/widget/EditText;->setKeyListener(Landroid/text/method/KeyListener;)V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->g:Landroid/widget/EditText;

    new-instance v2, Lcr;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->g:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Lcr;-><init>(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->h:Landroid/widget/EditText;

    new-instance v2, Lcr;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->h:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Lcr;-><init>(Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 117
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v0

    .line 118
    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v2

    .line 119
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 120
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 121
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 122
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-virtual {v3, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 124
    :cond_0
    if-eqz v2, :cond_6

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_6

    .line 125
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 126
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 127
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 132
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_4

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getFirstName()Ljava/lang/String;

    move-result-object v0

    .line 134
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 135
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 136
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 137
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 139
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getLastName()Ljava/lang/String;

    move-result-object v0

    .line 140
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 141
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 142
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 143
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 145
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantFirstName()Ljava/lang/String;

    move-result-object v0

    .line 146
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantLastName()Ljava/lang/String;

    move-result-object v2

    .line 147
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    .line 148
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 149
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 150
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->g:Landroid/widget/EditText;

    invoke-virtual {v3, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 152
    :cond_3
    if-eqz v2, :cond_4

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 153
    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 154
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-static {v3}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 155
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->h:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 158
    :cond_4
    return-object v1

    .line 107
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    goto/16 :goto_0

    .line 129
    :cond_6
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->b:Landroid/widget/EditText;

    invoke-virtual {v3, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->c:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 228
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 230
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 231
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 87
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 88
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->p:Z

    if-eqz v0, :cond_0

    .line 89
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f0802e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 95
    :goto_0
    return-void

    .line 92
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f080338

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->a:Landroid/support/v4/app/FragmentActivity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08026a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    goto :goto_0
.end method
