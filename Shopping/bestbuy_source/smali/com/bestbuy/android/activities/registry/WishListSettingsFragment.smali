.class public Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private A:Landroid/widget/ImageView;

.field private B:Landroid/widget/ImageView;

.field private C:Landroid/widget/ImageView;

.field private D:Ljava/lang/String;

.field private E:I

.field private F:Z

.field a:Ljava/util/Calendar;

.field b:Landroid/app/DatePickerDialog$OnDateSetListener;

.field c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

.field private g:Landroid/widget/TextView;

.field private h:Landroid/widget/TextView;

.field private i:Landroid/widget/TextView;

.field private j:Landroid/widget/TextView;

.field private k:Landroid/widget/EditText;

.field private l:Landroid/widget/EditText;

.field private m:Landroid/widget/EditText;

.field private n:Landroid/widget/EditText;

.field private o:Landroid/widget/Spinner;

.field private p:Landroid/widget/EditText;

.field private q:Landroid/widget/Button;

.field private r:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private s:Landroid/view/View;

.field private t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private u:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private v:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
            ">;"
        }
    .end annotation
.end field

.field private w:Ljava/lang/String;

.field private x:Z

.field private y:Landroid/widget/RelativeLayout;

.field private z:Landroid/widget/RelativeLayout;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 80
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 73
    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a:Ljava/util/Calendar;

    .line 74
    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 82
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 89
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 73
    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a:Ljava/util/Calendar;

    .line 74
    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 90
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->u:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 91
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->r:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 92
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->F:Z

    .line 93
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->q:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->r:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->D:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->p:Landroid/widget/EditText;

    return-object v0
.end method

.method private e()V
    .locals 4

    .prologue
    .line 279
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 280
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802e6

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800e9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$6;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$6;-><init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802e7

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$5;-><init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 343
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 344
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 345
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 346
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 347
    return-void
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->h:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->k:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->l:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->m:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->n:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/widget/Spinner;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->o:Landroid/widget/Spinner;

    return-object v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->s:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 14

    .prologue
    const/4 v13, 0x2

    const/4 v3, 0x0

    const/4 v11, 0x1

    .line 350
    if-eqz p1, :cond_5

    .line 351
    const-string v0, ""

    .line 352
    const-string v0, ""

    .line 353
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v4

    .line 354
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v5

    .line 355
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v6

    .line 356
    iput-object v6, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->D:Ljava/lang/String;

    .line 357
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getRecipient()Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    .line 358
    const-string v2, ""

    .line 359
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCity()Ljava/lang/String;

    move-result-object v7

    .line 360
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getState()Ljava/lang/String;

    move-result-object v8

    .line 361
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getLocation()Ljava/lang/String;

    move-result-object v0

    .line 362
    if-eqz v0, :cond_c

    .line 363
    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 364
    array-length v0, v1

    if-nez v0, :cond_6

    .line 365
    const-string v0, ""

    move-object v1, v0

    .line 379
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    if-eqz v0, :cond_0

    .line 380
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine1()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine2()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressCity()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressState()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressZip()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v2, v0

    .line 384
    :cond_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPersonalizedMessage()Ljava/lang/String;

    move-result-object v9

    .line 385
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getOccasionDate()Ljava/lang/String;

    move-result-object v10

    .line 386
    const-string v0, "school"

    invoke-virtual {v4, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 387
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->j:Landroid/widget/TextView;

    iget-object v11, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    const v12, 0x7f0802ec

    invoke-virtual {v11, v12}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 391
    :goto_1
    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Ljava/lang/String;)V

    .line 392
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->h:Landroid/widget/TextView;

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 393
    iput-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->w:Ljava/lang/String;

    .line 394
    const-string v0, "public"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 395
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i:Landroid/widget/TextView;

    const-string v11, "Public"

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 398
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 399
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->l:Landroid/widget/EditText;

    invoke-virtual {v0, v9}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 400
    if-eqz v1, :cond_1

    const-string v0, "null"

    invoke-virtual {v1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 401
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->m:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 402
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->p:Landroid/widget/EditText;

    invoke-virtual {v0, v10}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 403
    if-eqz v7, :cond_2

    invoke-virtual {v7}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 404
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->n:Landroid/widget/EditText;

    invoke-virtual {v0, v7}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 405
    :cond_2
    if-eqz v8, :cond_4

    invoke-virtual {v8}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 406
    const-string v0, ""

    .line 407
    invoke-static {}, Lju;->a()Ljava/util/HashMap;

    move-result-object v11

    .line 408
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v12

    if-lez v12, :cond_3

    .line 409
    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    .line 410
    invoke-virtual {v8, v3, v13}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 411
    invoke-virtual {v11, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 413
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const/high16 v12, 0x7f0a0000

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v11

    .line 414
    :goto_3
    array-length v12, v11

    if-ge v3, v12, :cond_4

    .line 415
    aget-object v12, v11, v3

    invoke-virtual {v12, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_b

    .line 416
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->o:Landroid/widget/Spinner;

    invoke-virtual {v0, v3}, Landroid/widget/Spinner;->setSelection(I)V

    .line 423
    :cond_4
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 425
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setListType(Ljava/lang/String;)V

    .line 426
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRegistryName(Ljava/lang/String;)V

    .line 427
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPrivacySetting(Ljava/lang/String;)V

    .line 428
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setShippingAddress(Ljava/lang/String;)V

    .line 429
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v9}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddDescription(Ljava/lang/String;)V

    .line 430
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventLocation(Ljava/lang/String;)V

    .line 431
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventCity(Ljava/lang/String;)V

    .line 432
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v8}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventState(Ljava/lang/String;)V

    .line 433
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v0, v10}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventDate(Ljava/lang/String;)V

    .line 434
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRecepient(Lcom/bestbuy/android/api/lib/models/registry/Recipient;)V

    .line 435
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setUuid(Ljava/lang/String;)V

    .line 437
    :cond_5
    return-void

    .line 367
    :cond_6
    aget-object v0, v1, v3

    .line 368
    array-length v9, v1

    if-ne v9, v13, :cond_8

    .line 369
    aget-object v9, v1, v11

    const-string v10, "-"

    invoke-virtual {v9, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_7

    .line 370
    aget-object v1, v1, v11

    move-object v1, v0

    goto/16 :goto_0

    .line 372
    :cond_7
    aget-object v1, v1, v11

    move-object v1, v0

    goto/16 :goto_0

    .line 373
    :cond_8
    array-length v9, v1

    const/4 v10, 0x3

    if-ne v9, v10, :cond_c

    .line 374
    aget-object v9, v1, v11

    .line 375
    aget-object v1, v1, v13

    move-object v1, v0

    goto/16 :goto_0

    .line 389
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->j:Landroid/widget/TextView;

    iget-object v11, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    const v12, 0x7f080216

    invoke-virtual {v11, v12}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 397
    :cond_a
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i:Landroid/widget/TextView;

    const-string v11, "Private"

    invoke-virtual {v0, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 414
    :cond_b
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_3

    :cond_c
    move-object v1, v0

    goto/16 :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V
    .locals 13

    .prologue
    const/4 v12, 0x6

    const/4 v11, 0x2

    const/4 v10, 0x3

    const/4 v2, 0x0

    .line 440
    if-eqz p1, :cond_3

    .line 441
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v1

    .line 442
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getRegistryName()Ljava/lang/String;

    move-result-object v3

    .line 443
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPrivacySetting()Ljava/lang/String;

    move-result-object v4

    .line 444
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventLocation()Ljava/lang/String;

    move-result-object v5

    .line 445
    const-string v0, ""

    .line 446
    const-string v0, ""

    .line 447
    if-eqz v5, :cond_4

    .line 448
    const-string v6, ", "

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 449
    array-length v7, v6

    if-lt v7, v10, :cond_0

    .line 450
    const/4 v0, 0x1

    aget-object v0, v6, v0

    .line 451
    aget-object v0, v6, v11

    .line 457
    :cond_0
    :goto_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddDescription()Ljava/lang/String;

    move-result-object v6

    .line 458
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 460
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v7

    .line 461
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "("

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v7, v2, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ") "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v7, v10, v12}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "-"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const/16 v9, 0xa

    invoke-virtual {v7, v12, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 463
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ", "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ", "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ", "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ", "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 465
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v8, v7}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 466
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine1(Ljava/lang/String;)V

    .line 467
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine2(Ljava/lang/String;)V

    .line 468
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCity(Ljava/lang/String;)V

    .line 469
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPhone(Ljava/lang/String;)V

    .line 470
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setState(Ljava/lang/String;)V

    .line 471
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setZipCode(Ljava/lang/String;)V

    .line 472
    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v8, v7}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setShippingAddress(Ljava/lang/String;)V

    .line 473
    new-instance v7, Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-direct {v7}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;-><init>()V

    iput-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    .line 474
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine1()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressLine1(Ljava/lang/String;)V

    .line 475
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getAddressLine2()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressLine2(Ljava/lang/String;)V

    .line 476
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getCity()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressCity(Ljava/lang/String;)V

    .line 477
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getState()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressState(Ljava/lang/String;)V

    .line 478
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getZipCode()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressZip(Ljava/lang/String;)V

    .line 479
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getPhone()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setPhoneNumber(Ljava/lang/String;)V

    .line 480
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v7, v8}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRecepient(Lcom/bestbuy/android/api/lib/models/registry/Recipient;)V

    .line 482
    :cond_1
    const-string v7, "school"

    invoke-virtual {v1, v7}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 483
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->j:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    const v9, 0x7f0802ec

    invoke-virtual {v8, v9}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 488
    :goto_1
    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Ljava/lang/String;)V

    .line 489
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->h:Landroid/widget/TextView;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 490
    const-string v1, "public"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 491
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i:Landroid/widget/TextView;

    const-string v7, "Public"

    invoke-virtual {v1, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 495
    :goto_2
    iput-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->D:Ljava/lang/String;

    .line 496
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->l:Landroid/widget/EditText;

    invoke-virtual {v1, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 497
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->m:Landroid/widget/EditText;

    invoke-virtual {v1, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 498
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->n:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventCity()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 499
    const-string v1, ""

    .line 500
    invoke-static {}, Lju;->a()Ljava/util/HashMap;

    move-result-object v4

    .line 501
    if-eqz v0, :cond_8

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_8

    .line 502
    invoke-virtual {v0, v2, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 503
    invoke-virtual {v4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 505
    :goto_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v4, 0x7f0a0000

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v4

    move v1, v2

    .line 506
    :goto_4
    array-length v2, v4

    if-ge v1, v2, :cond_2

    .line 507
    aget-object v2, v4, v1

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 508
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->o:Landroid/widget/Spinner;

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setSelection(I)V

    .line 513
    :cond_2
    iput-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->w:Ljava/lang/String;

    .line 515
    :cond_3
    return-void

    .line 454
    :cond_4
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventCity()Ljava/lang/String;

    .line 455
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getEventState()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 485
    :cond_5
    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->j:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    const v9, 0x7f080216

    invoke-virtual {v8, v9}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 493
    :cond_6
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i:Landroid/widget/TextView;

    const-string v7, "Private"

    invoke-virtual {v1, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 506
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_8
    move-object v0, v1

    goto :goto_3
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;ZI)V
    .locals 3

    .prologue
    .line 518
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 519
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->x:Z

    .line 520
    if-eqz p2, :cond_0

    .line 521
    iput p3, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->E:I

    .line 522
    new-instance v0, Ljp;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p0, v2, p1}, Ljp;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljp;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 524
    :cond_0
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    if-eqz v0, :cond_8

    .line 247
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_8

    .line 248
    const-string v0, "weddingregistrys"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "weddingregistry"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 249
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->g:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " List"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020198

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 252
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 253
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->g:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getDescription()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " List"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "backtoschoollists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020191

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 247
    :cond_1
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    .line 256
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "holidaylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020196

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 258
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "graduationlists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020195

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 260
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "anniversarylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020190

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 262
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "birthdaylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020192

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 264
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/ListTypes;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v2, "movinglists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 265
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020197

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 267
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    const v2, 0x7f020193

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_1

    .line 271
    :cond_8
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 550
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->v:Ljava/util/ArrayList;

    .line 552
    return-void
.end method

.method public b()V
    .locals 0

    .prologue
    .line 528
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 531
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->q:Landroid/widget/Button;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    .line 532
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 535
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 536
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v2

    .line 537
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->F:Z

    if-nez v1, :cond_1

    .line 538
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v1, v0

    .line 539
    :goto_0
    if-ltz v1, :cond_2

    .line 540
    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    .line 541
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v0

    const-string v3, "MyWishListsFragment"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 542
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 539
    :cond_0
    add-int/lit8 v0, v1, -0x1

    move v1, v0

    goto :goto_0

    .line 545
    :cond_1
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    .line 547
    :cond_2
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 275
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->e()V

    .line 276
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 103
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 104
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 97
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 98
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 99
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const/4 v3, 0x1

    .line 556
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->A:Landroid/widget/ImageView;

    if-eq p1, v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->k:Landroid/widget/EditText;

    if-ne p1, v0, :cond_2

    .line 557
    :cond_0
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget v4, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->E:I

    const/4 v5, 0x0

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/WishlistAddressFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;Lcom/bestbuy/android/base/BBYBaseFragment;ZILjava/lang/String;)V

    .line 558
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 559
    instance-of v1, v2, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v1, :cond_1

    move-object v1, v2

    .line 560
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v4, "WishlistAddressFragment"

    invoke-virtual {v1, v0, v3, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 562
    :cond_1
    instance-of v1, v2, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v1, :cond_2

    .line 563
    check-cast v2, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v1, "WishlistAddressFragment"

    invoke-virtual {v2, v0, v3, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 566
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->B:Landroid/widget/ImageView;

    if-eq p1, v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->p:Landroid/widget/EditText;

    if-eq p1, v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->z:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_4

    .line 569
    :cond_3
    new-instance v0, Landroid/app/DatePickerDialog;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b:Landroid/app/DatePickerDialog$OnDateSetListener;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a:Ljava/util/Calendar;

    invoke-virtual {v4, v3}, Ljava/util/Calendar;->get(I)I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a:Ljava/util/Calendar;

    const/4 v5, 0x2

    invoke-virtual {v4, v5}, Ljava/util/Calendar;->get(I)I

    move-result v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a:Ljava/util/Calendar;

    const/4 v6, 0x5

    invoke-virtual {v5, v6}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-direct/range {v0 .. v5}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;Landroid/app/DatePickerDialog$OnDateSetListener;III)V

    .line 572
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    sub-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Landroid/widget/DatePicker;->setMinDate(J)V

    .line 573
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide v4, 0x757b12c00L

    add-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Landroid/widget/DatePicker;->setMaxDate(J)V

    .line 574
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->show()V

    .line 576
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->y:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_5

    .line 579
    :cond_5
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 108
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 109
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 143
    const v0, 0x7f03011e

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v2, 0x10

    invoke-virtual {v0, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 145
    const v0, 0x7f0c0076

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->y:Landroid/widget/RelativeLayout;

    .line 146
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->s:Landroid/view/View;

    .line 147
    const v0, 0x7f0c040d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->g:Landroid/widget/TextView;

    .line 148
    const v0, 0x7f0c0435

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->C:Landroid/widget/ImageView;

    .line 149
    const v0, 0x7f0c0436

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->h:Landroid/widget/TextView;

    .line 150
    const v0, 0x7f0c0437

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i:Landroid/widget/TextView;

    .line 151
    const v0, 0x7f0c0411

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->A:Landroid/widget/ImageView;

    .line 152
    const v0, 0x7f0c0410

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->k:Landroid/widget/EditText;

    .line 153
    const v0, 0x7f0c0413

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->l:Landroid/widget/EditText;

    .line 154
    const v0, 0x7f0c0415

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->j:Landroid/widget/TextView;

    .line 155
    const v0, 0x7f0c0416

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->m:Landroid/widget/EditText;

    .line 156
    const v0, 0x7f0c0374

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->n:Landroid/widget/EditText;

    .line 157
    const v0, 0x7f0c0377

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->o:Landroid/widget/Spinner;

    .line 158
    const v0, 0x7f0c0438

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->p:Landroid/widget/EditText;

    .line 159
    const v0, 0x7f0c0439

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->B:Landroid/widget/ImageView;

    .line 160
    const v0, 0x7f0c041b

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->z:Landroid/widget/RelativeLayout;

    .line 161
    const v0, 0x7f0c043a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->q:Landroid/widget/Button;

    .line 162
    new-instance v0, Lje;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-direct {v0, v2, p0, v3}, Lje;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v2, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v3, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v2, v3}, Lje;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->A:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->k:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->p:Landroid/widget/EditText;

    invoke-virtual {v0, p0}, Landroid/widget/EditText;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->B:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->y:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->z:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->q:Landroid/widget/Button;

    new-instance v2, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->h:Landroid/widget/TextView;

    new-instance v2, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->i:Landroid/widget/TextView;

    new-instance v2, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$3;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 210
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a:Ljava/util/Calendar;

    .line 212
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->r:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getOccasionDate()Ljava/lang/String;

    move-result-object v0

    .line 213
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 214
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v3, "MM/dd/yy"

    invoke-direct {v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 216
    invoke-virtual {v2, v0}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 217
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v3, "MM/dd/yyyy"

    invoke-direct {v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 218
    invoke-virtual {v2, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 219
    const-string v2, "/"

    invoke-static {v0, v2}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 220
    const/4 v2, 0x0

    aget-object v2, v0, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    .line 221
    const/4 v3, 0x1

    aget-object v3, v0, v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    .line 222
    const/4 v4, 0x2

    aget-object v0, v0, v4

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 223
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a:Ljava/util/Calendar;

    invoke-virtual {v4, v0, v2, v3}, Ljava/util/Calendar;->set(III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 228
    :cond_0
    :goto_0
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$4;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$4;-><init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->b:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 242
    return-object v1

    .line 225
    :catch_0
    move-exception v0

    .line 226
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 135
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 139
    return-void
.end method

.method public onResume()V
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v6, 0x0

    .line 113
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 114
    sput-boolean v2, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 115
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "List Settings"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v6}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v6}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v1, 0x7f0802e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 121
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->x:Z

    if-eqz v0, :cond_1

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->t:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    .line 123
    iput-boolean v6, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->x:Z

    .line 131
    :cond_0
    :goto_0
    return-void

    .line 125
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->r:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_0

    .line 126
    new-instance v0, Ljk;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->s:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->r:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->r:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
