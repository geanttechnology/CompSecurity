.class public Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private A:Z

.field private B:Z

.field private C:Landroid/widget/LinearLayout;

.field private D:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private E:I

.field private F:Z

.field private G:Ljava/lang/String;

.field private H:Ljava/lang/String;

.field private I:Landroid/text/InputFilter;

.field private a:Landroid/widget/EditText;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/EditText;

.field private g:Landroid/widget/EditText;

.field private h:Landroid/widget/EditText;

.field private i:Landroid/widget/Spinner;

.field private j:Landroid/widget/EditText;

.field private k:Landroid/widget/EditText;

.field private l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private m:Z

.field private n:Lcv;

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Ljava/lang/String;

.field private t:Ljava/lang/String;

.field private u:Landroid/widget/ImageButton;

.field private v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private x:Z

.field private y:Z

.field private z:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 77
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->x:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->y:Z

    .line 67
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->z:Z

    .line 68
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->A:Z

    .line 69
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->B:Z

    .line 73
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->F:Z

    .line 74
    const-string v0, "()-/*#,.+;NPWpw;><?_$%^&@!"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->G:Ljava/lang/String;

    .line 448
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->I:Landroid/text/InputFilter;

    .line 79
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Lcom/bestbuy/android/base/BBYBaseFragment;ZILjava/lang/String;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 87
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->x:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->y:Z

    .line 67
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->z:Z

    .line 68
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->A:Z

    .line 69
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->B:Z

    .line 73
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->F:Z

    .line 74
    const-string v0, "()-/*#,.+;NPWpw;><?_$%^&@!"

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->G:Ljava/lang/String;

    .line 448
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->I:Landroid/text/InputFilter;

    .line 88
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 89
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->D:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 90
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->m:Z

    .line 91
    iput p4, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->E:I

    .line 92
    iput-object p5, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->H:Ljava/lang/String;

    .line 93
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->F:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Landroid/widget/Spinner;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    return-object v0
.end method

.method public static synthetic b(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->B:Z

    return p1
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->x:Z

    return v0
.end method

.method public static synthetic c(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->x:Z

    return p1
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->y:Z

    return v0
.end method

.method public static synthetic d(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->y:Z

    return p1
.end method

.method public static synthetic e(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->z:Z

    return v0
.end method

.method public static synthetic e(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->z:Z

    return p1
.end method

.method public static synthetic f(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->A:Z

    return v0
.end method

.method public static synthetic f(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Z)Z
    .locals 0

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->A:Z

    return p1
.end method

.method public static synthetic g(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Z
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->F:Z

    return v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->G:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public b()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 304
    new-instance v2, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->H:Ljava/lang/String;

    invoke-direct {v2, v0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Ljava/lang/String;)V

    .line 305
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 306
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 307
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 309
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_1

    .line 310
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v1, v2, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 312
    :cond_1
    return-void
.end method

.method public c()V
    .locals 4

    .prologue
    .line 339
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d()V

    .line 340
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->D:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    if-eqz v0, :cond_0

    .line 341
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->e()V

    .line 342
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->D:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->E:I

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;I)V

    .line 343
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 350
    :goto_0
    return-void

    .line 345
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->e()V

    .line 346
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->D:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    const/4 v2, 0x1

    iget v3, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->E:I

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;ZI)V

    .line 347
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    goto :goto_0
.end method

.method public d()V
    .locals 3

    .prologue
    .line 353
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->o:Ljava/lang/String;

    .line 354
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->p:Ljava/lang/String;

    .line 355
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->h:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->q:Ljava/lang/String;

    .line 356
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 357
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->r:Ljava/lang/String;

    .line 358
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0}, Landroid/widget/Spinner;->getSelectedItemPosition()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->E:I

    .line 360
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->j:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->s:Ljava/lang/String;

    .line 361
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->t:Ljava/lang/String;

    .line 363
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->t:Ljava/lang/String;

    const-string v1, "\\D"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->t:Ljava/lang/String;

    .line 368
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 371
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressFirstName(Ljava/lang/String;)V

    .line 372
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLastName(Ljava/lang/String;)V

    .line 373
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->o:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine1(Ljava/lang/String;)V

    .line 374
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->p:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine2(Ljava/lang/String;)V

    .line 375
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->q:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setZipCode(Ljava/lang/String;)V

    .line 376
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->r:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setState(Ljava/lang/String;)V

    .line 377
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->s:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCity(Ljava/lang/String;)V

    .line 378
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->t:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPhone(Ljava/lang/String;)V

    .line 379
    return-void
.end method

.method public g()V
    .locals 1

    .prologue
    .line 289
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->B:Z

    if-eqz v0, :cond_0

    .line 290
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c()V

    .line 292
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 97
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 98
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    .line 99
    sput-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    move-object v0, p1

    .line 100
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08030c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 101
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "Save"

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 102
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 103
    check-cast p1, Lcv;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->n:Lcv;

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->n:Lcv;

    invoke-interface {v0}, Lcv;->onCreateWishListFragmentLaunch()V

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_0

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 107
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Llu;->P:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 110
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 389
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->C:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    .line 394
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 115
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const/4 v9, 0x6

    const/16 v8, 0x8

    const/4 v7, 0x3

    const/4 v6, 0x1

    const/4 v2, 0x0

    .line 145
    const v0, 0x7f030112

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 147
    const v0, 0x7f0c0076

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->C:Landroid/widget/LinearLayout;

    .line 150
    const v0, 0x7f0c03f1

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 151
    const v0, 0x7f0c00a7

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->a:Landroid/widget/EditText;

    .line 152
    const v0, 0x7f0c00a8

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->b:Landroid/widget/EditText;

    .line 153
    const v0, 0x7f0c03e8

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c:Landroid/widget/EditText;

    .line 154
    const v0, 0x7f0c03e9

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->g:Landroid/widget/EditText;

    .line 155
    const v0, 0x7f0c03ea

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->h:Landroid/widget/EditText;

    .line 156
    const v0, 0x7f0c0377

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    .line 157
    const v0, 0x7f0c0374

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->j:Landroid/widget/EditText;

    .line 158
    const v0, 0x7f0c03eb

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v0, v7}, Landroid/widget/EditText;->setInputType(I)V

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    const/4 v1, 0x2

    new-array v1, v1, [Landroid/text/InputFilter;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->I:Landroid/text/InputFilter;

    aput-object v4, v1, v2

    new-instance v4, Landroid/text/InputFilter$LengthFilter;

    const/16 v5, 0xe

    invoke-direct {v4, v5}, Landroid/text/InputFilter$LengthFilter;-><init>(I)V

    aput-object v4, v1, v6

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setFilters([Landroid/text/InputFilter;)V

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    new-instance v1, Landroid/telephony/PhoneNumberFormattingTextWatcher;

    invoke-direct {v1}, Landroid/telephony/PhoneNumberFormattingTextWatcher;-><init>()V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c:Landroid/widget/EditText;

    new-instance v1, Ldi;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c:Landroid/widget/EditText;

    invoke-direct {v1, p0, v4}, Ldi;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->h:Landroid/widget/EditText;

    new-instance v1, Ldi;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->h:Landroid/widget/EditText;

    invoke-direct {v1, p0, v4}, Ldi;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->j:Landroid/widget/EditText;

    new-instance v1, Ldi;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->j:Landroid/widget/EditText;

    invoke-direct {v1, p0, v4}, Ldi;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    new-instance v1, Ldi;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    invoke-direct {v1, p0, v4}, Ldi;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;Landroid/widget/EditText;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 166
    const v0, 0x7f0c03ec

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->u:Landroid/widget/ImageButton;

    .line 167
    const v0, 0x7f0c03ed

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->C:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->u:Landroid/widget/ImageButton;

    new-instance v1, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    new-instance v1, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    if-eqz v0, :cond_5

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->m:Z

    if-eqz v0, :cond_5

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getRecepient()Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    move-result-object v0

    .line 207
    if-eqz v0, :cond_0

    .line 210
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine1()Ljava/lang/String;

    move-result-object v1

    const-string v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressCity()Ljava/lang/String;

    move-result-object v1

    const-string v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressState()Ljava/lang/String;

    move-result-object v1

    const-string v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressZip()Ljava/lang/String;

    move-result-object v1

    const-string v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getPhoneNumber()Ljava/lang/String;

    move-result-object v1

    const-string v4, ""

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 212
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f080120

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 214
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 220
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c:Landroid/widget/EditText;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 221
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->g:Landroid/widget/EditText;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine2()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 222
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->j:Landroid/widget/EditText;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressCity()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 223
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->h:Landroid/widget/EditText;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressZip()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 224
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getPhoneNumber()Ljava/lang/String;

    move-result-object v1

    .line 225
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1, v2, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ") "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1, v7, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "-"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v5, 0xa

    invoke-virtual {v1, v9, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 227
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v4, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 228
    invoke-static {}, Lju;->a()Ljava/util/HashMap;

    move-result-object v1

    .line 229
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressState()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 230
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v4, 0x7f0a0000

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v4

    move v1, v2

    .line 231
    :goto_0
    array-length v5, v4

    if-ge v1, v5, :cond_0

    .line 232
    aget-object v5, v4, v1

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setSelection(I)V

    .line 274
    :cond_0
    :goto_1
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 275
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 276
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 277
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->a:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 279
    :cond_1
    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 280
    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    .line 281
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v2, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 282
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->b:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 284
    :cond_2
    return-object v3

    .line 231
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 239
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v1, 0x7f08018b

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 244
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v4, 0x7f080120

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->c:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->g:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->j:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->h:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->k:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 259
    invoke-static {}, Lju;->a()Ljava/util/HashMap;

    move-result-object v0

    .line 260
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 261
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v4, 0x7f0a0000

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v4

    move v1, v2

    .line 262
    :goto_2
    array-length v5, v4

    if-ge v1, v5, :cond_0

    .line 263
    aget-object v5, v4, v1

    invoke-virtual {v5, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 264
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->i:Landroid/widget/Spinner;

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setSelection(I)V

    goto/16 :goto_1

    .line 262
    :cond_6
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 270
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v1, 0x7f08018b

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 119
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 123
    return-void
.end method

.method public onDetach()V
    .locals 1

    .prologue
    .line 297
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDetach()V

    .line 298
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->m:Z

    if-nez v0, :cond_0

    .line 299
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->b()V

    .line 301
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 127
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 128
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchVisibility(Landroid/app/Activity;Z)V

    .line 129
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->m:Z

    if-eqz v0, :cond_0

    .line 130
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08017e

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f0802e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 136
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 137
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    .line 138
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->requestFocus()Z

    .line 139
    return-void

    .line 133
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f08030c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "Save"

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    goto :goto_0
.end method
