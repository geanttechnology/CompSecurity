.class public Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Landroid/widget/LinearLayout;

.field private b:Landroid/widget/LinearLayout;

.field private c:Landroid/widget/ImageButton;

.field private g:Landroid/widget/ImageButton;

.field private h:Landroid/widget/Button;

.field private i:Landroid/widget/Button;

.field private j:Landroid/widget/LinearLayout;

.field private k:Landroid/widget/EditText;

.field private l:Landroid/widget/EditText;

.field private m:Landroid/widget/EditText;

.field private n:Ljava/lang/String;

.field private o:Z

.field private p:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 61
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->p:Ljava/util/ArrayList;

    .line 67
    return-void
.end method

.method private b()V
    .locals 2

    .prologue
    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->h:Landroid/widget/Button;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setSelected(Z)V

    .line 175
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->i:Landroid/widget/Button;

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/Button;->setSelected(Z)V

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->m:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 179
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->n:Ljava/lang/String;

    .line 180
    return-void

    .line 175
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(Z)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 316
    if-eqz p1, :cond_1

    .line 319
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 320
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08028b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080283

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$2;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080242

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$1;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 341
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 342
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 343
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 344
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 377
    :cond_0
    :goto_0
    return-void

    .line 371
    :cond_1
    new-instance v1, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;-><init>()V

    .line 372
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 373
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 374
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "CreateWeddingRegistry"

    invoke-virtual {v0, v1, v3, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_0
.end method

.method public g()V
    .locals 0

    .prologue
    .line 171
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 75
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 76
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    .line 77
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 78
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "profile,lifeEvents,dashboard"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "LE"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    sget-object v1, Llu;->A:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 81
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const v7, 0x7f040005

    const/16 v6, 0x1ed2

    const/4 v3, 0x2

    const/4 v4, 0x0

    const/4 v5, 0x1

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->a:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_2

    .line 185
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 189
    new-instance v1, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;-><init>()V

    .line 190
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 191
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 192
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "CreateWishListFragment"

    invoke-virtual {v0, v1, v5, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 291
    :cond_0
    :goto_0
    return-void

    .line 196
    :cond_1
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const-string v1, "WishList"

    invoke-virtual {v0, v1}, Lnb;->j(Ljava/lang/String;)V

    .line 197
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 198
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1, v0, v6}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    const v1, 0x7f04000e

    invoke-virtual {v0, v1, v7}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0

    .line 201
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->b:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_4

    .line 202
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 206
    new-instance v0, Ljo;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, p0, v2, v3}, Ljo;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljo;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 208
    :cond_3
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const-string v1, "Registry"

    invoke-virtual {v0, v1}, Lnb;->j(Ljava/lang/String;)V

    .line 209
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 210
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1, v0, v6}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    const v1, 0x7f04000e

    invoke-virtual {v0, v1, v7}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0

    .line 213
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->c:Landroid/widget/ImageButton;

    if-ne p1, v0, :cond_b

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 215
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->c:Landroid/widget/ImageButton;

    invoke-virtual {v1}, Landroid/widget/ImageButton;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 217
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->l:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 219
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_7

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_7

    .line 221
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->n:Ljava/lang/String;

    .line 227
    :cond_5
    :goto_1
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    if-eqz v2, :cond_9

    .line 228
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2, v5}, Lnb;->n(Z)V

    .line 233
    :goto_2
    new-instance v2, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->n:Ljava/lang/String;

    iget-boolean v4, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v3, v4, v0, v1}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;-><init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V

    .line 234
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 235
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v1, :cond_6

    .line 236
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v2, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 238
    :cond_6
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    if-eqz v0, :cond_a

    .line 239
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 240
    const-string v1, "Search Details"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->n:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 241
    sget-object v1, Llu;->X:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 222
    :cond_7
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_8

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_8

    .line 223
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->n:Ljava/lang/String;

    goto :goto_1

    .line 224
    :cond_8
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    .line 225
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->n:Ljava/lang/String;

    goto :goto_1

    .line 230
    :cond_9
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v2

    invoke-virtual {v2, v4}, Lnb;->n(Z)V

    goto :goto_2

    .line 243
    :cond_a
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 244
    const-string v1, "Search Details"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->n:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 245
    sget-object v1, Llu;->aG:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 250
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->h:Landroid/widget/Button;

    if-ne p1, v0, :cond_c

    .line 251
    iput-boolean v5, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->m:Landroid/widget/EditText;

    const-string v1, "Search Using List ID"

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 253
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->b()V

    goto/16 :goto_0

    .line 254
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->i:Landroid/widget/Button;

    if-ne p1, v0, :cond_d

    .line 255
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->m:Landroid/widget/EditText;

    const-string v1, "Search Using Registry ID"

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 257
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->b()V

    goto/16 :goto_0

    .line 258
    :cond_d
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->g:Landroid/widget/ImageButton;

    if-ne p1, v0, :cond_0

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->m:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 262
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->g:Landroid/widget/ImageButton;

    invoke-virtual {v2}, Landroid/widget/ImageButton;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 263
    new-instance v2, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    invoke-direct {v2, v0, v1}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;-><init>(ZLjava/lang/String;)V

    .line 264
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 265
    instance-of v3, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v3, :cond_e

    .line 266
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v2, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 268
    :cond_e
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    if-eqz v0, :cond_f

    .line 269
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v5}, Lnb;->n(Z)V

    .line 273
    :goto_3
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    if-eqz v0, :cond_10

    .line 274
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 275
    const-string v2, "Wish List ID"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 276
    sget-object v1, Llu;->W:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 271
    :cond_f
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v4}, Lnb;->n(Z)V

    goto :goto_3

    .line 278
    :cond_10
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 279
    const-string v2, "Registry List ID"

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    sget-object v1, Llu;->aF:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 85
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 86
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const v5, 0x7f0c0392

    const v4, 0x7f0c038b

    .line 121
    const v0, 0x7f0300e6

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v2, 0x10

    invoke-virtual {v0, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 124
    const v0, 0x7f0c0391

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->k:Landroid/widget/EditText;

    .line 125
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->l:Landroid/widget/EditText;

    .line 126
    const v0, 0x7f0c0394

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->m:Landroid/widget/EditText;

    .line 128
    const v0, 0x7f0c038d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->a:Landroid/widget/LinearLayout;

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->a:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    const v0, 0x7f0c038c

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->b:Landroid/widget/LinearLayout;

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->b:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 134
    const v0, 0x7f0c0390

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->c:Landroid/widget/ImageButton;

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->c:Landroid/widget/ImageButton;

    invoke-virtual {v0, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 137
    const v0, 0x7f0c0395

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->g:Landroid/widget/ImageButton;

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->g:Landroid/widget/ImageButton;

    invoke-virtual {v0, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    const v0, 0x7f0c038f

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->h:Landroid/widget/Button;

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->h:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 143
    const v0, 0x7f0c038e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->i:Landroid/widget/Button;

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->i:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->j:Landroid/widget/LinearLayout;

    .line 150
    new-instance v0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;-><init>()V

    .line 151
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    .line 152
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    .line 153
    const-string v3, "LEBannerHomeCard"

    invoke-virtual {v2, v4, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 154
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 155
    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->l:Landroid/widget/EditText;

    .line 156
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->aa()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->o:Z

    .line 157
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->b()V

    .line 158
    return-object v1
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 164
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 165
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->n(Z)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 167
    return-void
.end method

.method public onResume()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 89
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Registry, Gifts & Lists"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 93
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchVisibility(Landroid/app/Activity;Z)V

    .line 95
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->Y()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->Y()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Registry"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 96
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lnb;->j(Ljava/lang/String;)V

    .line 97
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 101
    new-instance v0, Ljo;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, p0, v2, v3}, Ljo;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljo;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 118
    :cond_0
    :goto_0
    return-void

    .line 104
    :cond_1
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->Y()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->Y()Ljava/lang/String;

    move-result-object v0

    const-string v1, "WishList"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 105
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lnb;->j(Ljava/lang/String;)V

    .line 106
    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 110
    new-instance v1, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;-><init>()V

    .line 111
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 112
    instance-of v2, v0, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 113
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x1

    const-string v3, "CreateWishListFragment"

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto :goto_0
.end method
