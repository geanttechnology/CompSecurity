.class public Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/widget/EditText;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/EditText;

.field private g:Landroid/widget/EditText;

.field private h:Landroid/widget/Spinner;

.field private i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private j:Landroid/view/View;

.field private k:Z

.field private l:Landroid/support/v4/app/Fragment;

.field private m:Z

.field private n:Landroid/widget/RelativeLayout;

.field private o:Landroid/widget/RelativeLayout;

.field private p:Ljava/lang/String;

.field private q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 64
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 57
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->k:Z

    .line 59
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->m:Z

    .line 65
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 67
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 57
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->k:Z

    .line 59
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->m:Z

    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->m:Z

    return p1
.end method

.method private b()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 141
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 142
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 144
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->c:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->h:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 149
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_5

    const-string v5, "Select a state"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 150
    const-string v0, ""

    .line 155
    :cond_1
    :goto_0
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    if-eqz v5, :cond_2

    .line 156
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v1, v5, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->registryName:Ljava/lang/String;

    .line 157
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v2, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->addDescription:Ljava/lang/String;

    .line 158
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v3, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->eventLocation:Ljava/lang/String;

    .line 159
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v4, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->eventCity:Ljava/lang/String;

    .line 160
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, v1, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->eventState:Ljava/lang/String;

    .line 162
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 163
    :cond_3
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 164
    const-string v1, "bb.createList"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    sget-object v1, Llu;->az:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 167
    :cond_4
    new-instance v0, Liz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->j:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0, v1, p0, v2, v3}, Liz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 168
    return-void

    .line 151
    :cond_5
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_1

    .line 152
    const/4 v5, 0x2

    invoke-virtual {v0, v6, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private c()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 172
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 173
    const-string v2, "editRegistryName"

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setRegistryName(Ljava/lang/String;)V

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->l:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1, v2, v3, v3}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Landroid/os/Bundle;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;ZI)V

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 177
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 219
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 221
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 226
    :goto_0
    return-void

    .line 224
    :cond_0
    invoke-virtual {p0, v8}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->b(Z)V

    goto :goto_0
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 229
    if-eqz p1, :cond_0

    .line 230
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->b(Z)V

    .line 232
    :cond_0
    return-void
.end method

.method public b(Z)V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    .line 236
    invoke-static {v8}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lfr;->a(Ljava/lang/String;)Z

    .line 237
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lfr;->b(Ljava/lang/String;)Z

    .line 238
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->refreshHomeCard()V

    .line 241
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 242
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v4

    .line 243
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v2, v1

    .line 244
    :goto_0
    if-ltz v2, :cond_5

    .line 245
    invoke-interface {v4, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/Fragment;

    .line 246
    instance-of v5, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v5, :cond_1

    .line 247
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    if-eqz v5, :cond_3

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->p:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_3

    .line 248
    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    if-eqz v1, :cond_2

    .line 249
    sput-boolean v9, Lcom/bestbuy/android/activities/home/HomeActivity;->inPDPFragment:Z

    .line 250
    sput-boolean v8, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 252
    if-eqz p1, :cond_0

    .line 253
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 254
    const-string v5, "bb.prevPageLink"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "Create a Registry"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v1, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 255
    const-string v5, "bb.createList"

    const-string v6, "1"

    invoke-virtual {v1, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 256
    sget-object v5, Llu;->aH:Ljava/lang/String;

    invoke-static {v5, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 258
    :cond_0
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->q:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, p1, p0, v5, v8}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(ZLcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    .line 259
    const-string v5, "WishListWithProductsFragment"

    invoke-virtual {v0, v1, v8, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 244
    :cond_1
    :goto_1
    add-int/lit8 v1, v2, -0x1

    move v2, v1

    goto :goto_0

    .line 261
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    goto :goto_1

    .line 264
    :cond_3
    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v1

    const-string v5, "RegistryAndGiftsFragment"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 265
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    goto :goto_1

    .line 267
    :cond_4
    new-instance v1, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    invoke-direct {v1, v9, v8}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;-><init>(ZZ)V

    .line 268
    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v5

    .line 269
    const v6, 0x7f0c0033

    const-string v7, "EmptyWeddingRegistryContainer"

    invoke-virtual {v5, v6, v1, v7}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 270
    const/4 v1, 0x0

    invoke-virtual {v5, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 271
    invoke-virtual {v5}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_1

    .line 276
    :cond_5
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 130
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->m:Z

    if-eqz v0, :cond_0

    .line 131
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->k:Z

    if-eqz v0, :cond_1

    .line 132
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->c()V

    .line 137
    :cond_0
    :goto_0
    return-void

    .line 134
    :cond_1
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->b()V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 74
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    .line 75
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 76
    if-eqz v0, :cond_0

    .line 77
    const-string v1, "data"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 79
    :cond_0
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    move-object v0, p1

    .line 80
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 81
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->n:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 214
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->b()V

    .line 216
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 85
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 86
    sget-object v0, Llu;->ay:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 87
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 103
    const v0, 0x7f0300e2

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v2, 0x10

    invoke-virtual {v0, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 105
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->j:Landroid/view/View;

    .line 106
    const v0, 0x7f0c0364

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->o:Landroid/widget/RelativeLayout;

    .line 107
    const v0, 0x7f0c012a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a:Landroid/widget/EditText;

    .line 108
    const v0, 0x7f0c0281

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->b:Landroid/widget/EditText;

    .line 109
    const v0, 0x7f0c0371

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->c:Landroid/widget/EditText;

    .line 110
    const v0, 0x7f0c0374

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->g:Landroid/widget/EditText;

    .line 111
    const v0, 0x7f0c0377

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->h:Landroid/widget/Spinner;

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a:Landroid/widget/EditText;

    new-instance v2, Lcy;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Lcy;-><init>(Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 113
    const v0, 0x7f0c0379

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->n:Landroid/widget/RelativeLayout;

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->n:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a:Landroid/widget/EditText;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " & "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCoregistrantFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'s Wedding Registry"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a:Landroid/widget/EditText;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " & "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->i:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCoregistrantFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'s Wedding Registry"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->o:Landroid/widget/RelativeLayout;

    new-instance v2, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions$1;-><init>(Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;)V

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 125
    return-object v1
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 280
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 281
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 283
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 91
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->k:Z

    if-eqz v0, :cond_0

    .line 93
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08017e

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f0802e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 99
    :goto_0
    return-void

    .line 96
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f0800a3

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f08014a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    goto :goto_0
.end method
