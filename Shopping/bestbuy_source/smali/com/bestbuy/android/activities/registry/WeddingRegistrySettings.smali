.class public Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private A:Z

.field private B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private C:Ljava/lang/String;

.field private D:Landroid/widget/RelativeLayout;

.field private E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private G:I

.field private H:Z

.field private I:Z

.field a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

.field private b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private j:Landroid/widget/RelativeLayout;

.field private k:Ljava/lang/String;

.field private l:Landroid/widget/EditText;

.field private m:Landroid/widget/EditText;

.field private n:Landroid/widget/EditText;

.field private o:Landroid/widget/EditText;

.field private p:Landroid/widget/Spinner;

.field private q:Landroid/os/Bundle;

.field private r:Lct;

.field private s:Landroid/view/View;

.field private t:Landroid/widget/RelativeLayout;

.field private u:Landroid/widget/RelativeLayout;

.field private v:Landroid/widget/RelativeLayout;

.field private w:Ljava/util/Calendar;

.field private x:Landroid/app/DatePickerDialog$OnDateSetListener;

.field private y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private z:Landroid/support/v4/app/Fragment;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 93
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 83
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 94
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Landroid/support/v4/app/Fragment;Z)V
    .locals 1

    .prologue
    .line 101
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 83
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 102
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 103
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->z:Landroid/support/v4/app/Fragment;

    .line 104
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->H:Z

    .line 105
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/util/Calendar;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->w:Ljava/util/Calendar;

    return-object v0
.end method

.method private a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 192
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->w:Ljava/util/Calendar;

    .line 194
    :try_start_0
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "MM/dd/yy"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 196
    invoke-virtual {v0, p1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 197
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "MM/dd/yyyy"

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 198
    invoke-virtual {v1, v0}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 199
    const-string v1, "/"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 200
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    .line 201
    const/4 v2, 0x1

    aget-object v2, v0, v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 202
    const/4 v3, 0x2

    aget-object v0, v0, v3

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 203
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->w:Ljava/util/Calendar;

    invoke-virtual {v3, v0, v1, v2}, Ljava/util/Calendar;->set(III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 207
    :goto_0
    return-void

    .line 204
    :catch_0
    move-exception v0

    .line 205
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Z)Z
    .locals 0

    .prologue
    .line 54
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->I:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->m:Landroid/widget/EditText;

    return-object v0
.end method

.method private d()V
    .locals 4

    .prologue
    .line 228
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 229
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

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

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800e9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$3;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$3;-><init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0802e7

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$2;-><init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 309
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 310
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 311
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 312
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 313
    return-void
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->n:Landroid/widget/EditText;

    return-object v0
.end method

.method private e()V
    .locals 19

    .prologue
    .line 330
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getRecipient()Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    .line 331
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    if-eqz v1, :cond_2

    .line 332
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getFirstName()Ljava/lang/String;

    move-result-object v1

    .line 333
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getLastName()Ljava/lang/String;

    move-result-object v2

    .line 334
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCoregistrantFirstName()Ljava/lang/String;

    move-result-object v3

    .line 335
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCoregistrantLastName()Ljava/lang/String;

    move-result-object v4

    .line 337
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getPrivacySetting()Ljava/lang/String;

    move-result-object v5

    .line 338
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 339
    if-eqz v5, :cond_3

    const-string v6, "public"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_3

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-eqz v6, :cond_3

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-nez v6, :cond_3

    .line 340
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "BestBuy.com, Best Buy Stores, TheKnot.com"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 360
    :cond_0
    :goto_0
    move-object/from16 v0, p0

    iput-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->C:Ljava/lang/String;

    .line 362
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getEventDate()Ljava/lang/String;

    move-result-object v5

    .line 363
    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Ljava/lang/String;)V

    .line 364
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 365
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->m:Landroid/widget/EditText;

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 366
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->n:Landroid/widget/EditText;

    invoke-virtual {v8}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    .line 368
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressFirstName()Ljava/lang/String;

    move-result-object v9

    .line 369
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v10}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressLastName()Ljava/lang/String;

    move-result-object v10

    .line 370
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v11}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressLine1()Ljava/lang/String;

    move-result-object v11

    .line 371
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v12}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressLine2()Ljava/lang/String;

    move-result-object v12

    .line 372
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v13}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getZipCode()Ljava/lang/String;

    move-result-object v13

    .line 373
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getState()Ljava/lang/String;

    move-result-object v14

    .line 374
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v15}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCity()Ljava/lang/String;

    move-result-object v15

    .line 375
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getPhone()Ljava/lang/String;

    move-result-object v16

    .line 376
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v17

    .line 377
    if-eqz v17, :cond_1

    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->isEmpty()Z

    move-result v17

    if-nez v17, :cond_1

    .line 378
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getPrivacySetting()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setPrivacySetting(Ljava/lang/String;)V

    .line 379
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v18

    invoke-virtual/range {v17 .. v18}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setTheKnot(Z)V

    .line 380
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v18

    invoke-virtual/range {v17 .. v18}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setMyRegistry(Z)V

    .line 382
    :cond_1
    if-eqz v5, :cond_a

    invoke-virtual {v5}, Ljava/lang/String;->isEmpty()Z

    move-result v17

    if-nez v17, :cond_a

    .line 383
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 387
    :goto_1
    if-eqz v6, :cond_b

    invoke-virtual {v6}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_b

    .line 388
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 389
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 395
    :goto_2
    if-eqz v1, :cond_c

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_c

    if-eqz v2, :cond_c

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_c

    if-eqz v3, :cond_c

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_c

    if-eqz v4, :cond_c

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_c

    .line 399
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v17, " "

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v17, " & "

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v17, " "

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 400
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v5, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setFirstName(Ljava/lang/String;)V

    .line 401
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v5, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setLastName(Ljava/lang/String;)V

    .line 402
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v5, v3}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantFirstName(Ljava/lang/String;)V

    .line 403
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v5, v4}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantLastName(Ljava/lang/String;)V

    .line 405
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v5, v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setFirstName(Ljava/lang/String;)V

    .line 406
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setLastName(Ljava/lang/String;)V

    .line 407
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setCoRegistrantFirstName(Ljava/lang/String;)V

    .line 408
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setCoRegistrantLastName(Ljava/lang/String;)V

    .line 418
    :goto_3
    if-eqz v7, :cond_d

    invoke-virtual {v7}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_d

    .line 419
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->m:Landroid/widget/EditText;

    invoke-virtual {v1, v7}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 422
    :goto_4
    if-eqz v8, :cond_e

    invoke-virtual {v8}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_e

    .line 425
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->n:Landroid/widget/EditText;

    invoke-virtual {v1, v8}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 429
    :goto_5
    if-eqz v9, :cond_f

    invoke-virtual {v9}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_f

    if-eqz v10, :cond_f

    invoke-virtual {v10}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_f

    .line 430
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 431
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v9}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressFirstName(Ljava/lang/String;)V

    .line 432
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v10}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLastName(Ljava/lang/String;)V

    .line 439
    :goto_6
    if-eqz v11, :cond_10

    invoke-virtual {v11}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10

    if-eqz v15, :cond_10

    invoke-virtual {v15}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10

    if-eqz v14, :cond_10

    invoke-virtual {v14}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10

    if-eqz v13, :cond_10

    invoke-virtual {v13}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10

    if-eqz v16, :cond_10

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10

    .line 445
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x3

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x3

    const/4 v3, 0x6

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x6

    const/16 v3, 0xa

    move-object/from16 v0, v16

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 447
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 450
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v11}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLine1(Ljava/lang/String;)V

    .line 451
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v12}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLine2(Ljava/lang/String;)V

    .line 452
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v15}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCity(Ljava/lang/String;)V

    .line 453
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v14}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setState(Ljava/lang/String;)V

    .line 454
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1, v13}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setZipCode(Ljava/lang/String;)V

    .line 455
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPhone(Ljava/lang/String;)V

    .line 457
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1, v11}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressLine1(Ljava/lang/String;)V

    .line 458
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1, v12}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressLine2(Ljava/lang/String;)V

    .line 459
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1, v15}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressCity(Ljava/lang/String;)V

    .line 460
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1, v14}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressState(Ljava/lang/String;)V

    .line 461
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1, v13}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setAddressZip(Ljava/lang/String;)V

    .line 462
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->setPhoneNumber(Ljava/lang/String;)V

    .line 463
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->setRecipient(Lcom/bestbuy/android/api/lib/models/registry/Recipient;)V

    .line 480
    :cond_2
    :goto_7
    return-void

    .line 341
    :cond_3
    if-eqz v5, :cond_4

    const-string v6, "public"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-nez v6, :cond_4

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 342
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "BestBuy.com, Best Buy Stores, MyRegistry.com"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 343
    :cond_4
    if-eqz v5, :cond_5

    const-string v6, "public"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-eqz v6, :cond_5

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-eqz v6, :cond_5

    .line 344
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "BestBuy.com, Best Buy Stores, TheKnot.com, MyRegistry.com"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 345
    :cond_5
    if-eqz v5, :cond_6

    const-string v6, "public"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-nez v6, :cond_6

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-nez v6, :cond_6

    .line 346
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "BestBuy.com, Best Buy Stores"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 347
    :cond_6
    if-eqz v5, :cond_7

    const-string v6, "private"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-eqz v6, :cond_7

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-nez v6, :cond_7

    .line 348
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "TheKnot.com"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 349
    :cond_7
    if-eqz v5, :cond_8

    const-string v6, "private"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-nez v6, :cond_8

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-eqz v6, :cond_8

    .line 350
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "MyRegistry.com"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 351
    :cond_8
    if-eqz v5, :cond_9

    const-string v6, "private"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-eqz v6, :cond_9

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-eqz v6, :cond_9

    .line 352
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "TheKnot.com, MyRegistry.com"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 353
    :cond_9
    if-eqz v5, :cond_0

    const-string v6, "private"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isTheKnot()Z

    move-result v6

    if-nez v6, :cond_0

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->isMyregistry()Z

    move-result v6

    if-nez v6, :cond_0

    .line 354
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v7, "Private Registry"

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 355
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 385
    :cond_a
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getOccasionDate()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 391
    :cond_b
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddDescription()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 392
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddDescription()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 411
    :cond_c
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " & "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantLastName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 413
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setFirstName(Ljava/lang/String;)V

    .line 414
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setLastName(Ljava/lang/String;)V

    .line 415
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantFirstName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantFirstName(Ljava/lang/String;)V

    .line 416
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantLastName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCoregistrantLastName(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 421
    :cond_d
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->m:Landroid/widget/EditText;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getPersonalized_message()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 428
    :cond_e
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->n:Landroid/widget/EditText;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getEventLocation()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_5

    .line 435
    :cond_f
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 436
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressFirstName(Ljava/lang/String;)V

    .line 437
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLastName(Ljava/lang/String;)V

    goto/16 :goto_6

    .line 466
    :cond_10
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getPhoneNumber()Ljava/lang/String;

    move-result-object v1

    .line 467
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x3

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ") "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x3

    const/4 v4, 0x6

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "-"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/4 v3, 0x6

    const/16 v4, 0xa

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 469
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine2()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressCity()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressState()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressZip()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 472
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine1()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLine1(Ljava/lang/String;)V

    .line 473
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine2()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setAddressLine2(Ljava/lang/String;)V

    .line 474
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressCity()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCity(Ljava/lang/String;)V

    .line 475
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressState()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setState(Ljava/lang/String;)V

    .line 476
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressZip()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setZipCode(Ljava/lang/String;)V

    .line 477
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getPhoneNumber()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setPhone(Ljava/lang/String;)V

    goto/16 :goto_7
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->o:Landroid/widget/EditText;

    return-object v0
.end method

.method private f()V
    .locals 3

    .prologue
    .line 651
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 652
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800ba

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 653
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080391

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$4;-><init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 669
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800e9

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$5;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$5;-><init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 676
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    .line 677
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 678
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 679
    return-void
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/widget/Spinner;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->p:Landroid/widget/Spinner;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)Landroid/view/View;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->s:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public a(Landroid/os/Bundle;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;ZI)V
    .locals 4

    .prologue
    .line 316
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 317
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->q:Landroid/os/Bundle;

    .line 318
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->A:Z

    .line 319
    if-eqz p3, :cond_0

    .line 320
    invoke-virtual {p0, p2}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->b(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 321
    iput p4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->G:I

    .line 322
    new-instance v0, Ljp;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0, v1, p0, v2, v3}, Ljp;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljp;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 324
    :cond_0
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 7

    .prologue
    const/16 v6, 0xa

    const/4 v5, 0x6

    const/4 v4, 0x3

    const/4 v2, 0x0

    .line 483
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 484
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Registry Settings"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 485
    if-eqz p1, :cond_6

    .line 486
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getOccasionDate()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Ljava/lang/String;)V

    .line 487
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getRecipient()Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    .line 488
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->C:Ljava/lang/String;

    .line 489
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getOccasionDate()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 490
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    if-eqz v0, :cond_1

    .line 491
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getPhoneNumber()Ljava/lang/String;

    move-result-object v0

    .line 492
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-le v1, v6, :cond_0

    .line 493
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "("

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0, v2, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ") "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "-"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 496
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " & "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantFirstName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCoRegistrantLastName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 497
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getFirstName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getLastName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 498
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine1()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressLine2()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressCity()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressState()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a:Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/Recipient;->getAddressZip()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 502
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 503
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 504
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->m:Landroid/widget/EditText;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPersonalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 505
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getCity()Ljava/lang/String;

    move-result-object v0

    .line 506
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getState()Ljava/lang/String;

    move-result-object v1

    .line 507
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getLocation()Ljava/lang/String;

    move-result-object v3

    .line 508
    if-eqz v3, :cond_5

    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_5

    .line 509
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->n:Landroid/widget/EditText;

    invoke-virtual {v4, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 510
    if-eqz v3, :cond_2

    .line 511
    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 512
    array-length v4, v3

    const/4 v5, 0x1

    if-le v4, v5, :cond_2

    .line 513
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->n:Landroid/widget/EditText;

    aget-object v3, v3, v2

    invoke-virtual {v4, v3}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 515
    :cond_2
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_3

    .line 516
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->o:Landroid/widget/EditText;

    invoke-virtual {v3, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 517
    :cond_3
    if-eqz v1, :cond_5

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 518
    const-string v0, ""

    .line 519
    invoke-static {}, Lju;->a()Ljava/util/HashMap;

    move-result-object v3

    .line 520
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_4

    .line 521
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    .line 522
    const/4 v0, 0x2

    invoke-virtual {v1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 523
    invoke-virtual {v3, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 525
    :cond_4
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v3, 0x7f0a0000

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v3

    move v1, v2

    .line 526
    :goto_0
    array-length v4, v3

    if-ge v1, v4, :cond_5

    .line 527
    aget-object v4, v3, v1

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 528
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->p:Landroid/widget/Spinner;

    invoke-virtual {v0, v1}, Landroid/widget/Spinner;->setSelection(I)V

    .line 540
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 541
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "public"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-nez v0, :cond_8

    .line 542
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "BestBuy.com, Best Buy Stores, TheKnot.com"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 560
    :cond_6
    :goto_1
    return-void

    .line 526
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 543
    :cond_8
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_9

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "public"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-nez v0, :cond_9

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 544
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "BestBuy.com, Best Buy Stores, MyRegistry.com"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 545
    :cond_9
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "public"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 546
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "BestBuy.com, Best Buy Stores, TheKnot.com, MyRegistry.com"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 547
    :cond_a
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_b

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "public"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-nez v0, :cond_b

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-nez v0, :cond_b

    .line 548
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "BestBuy.com, Best Buy Stores"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 549
    :cond_b
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_c

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "private"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-nez v0, :cond_c

    .line 550
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "TheKnot.com"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 551
    :cond_c
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_d

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "private"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-nez v0, :cond_d

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 552
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "MyRegistry.com"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 553
    :cond_d
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_e

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "private"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-eqz v0, :cond_e

    .line 554
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "TheKnot.com, MyRegistry.com"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 555
    :cond_e
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getPrivacySetting()Ljava/lang/String;

    move-result-object v0

    const-string v1, "private"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isTheKnot()Z

    move-result v0

    if-nez v0, :cond_6

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->isMyRegistry()Z

    move-result v0

    if-nez v0, :cond_6

    .line 556
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 557
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Private Registry"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V
    .locals 2

    .prologue
    .line 563
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->f:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->c(Z)V

    .line 564
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 565
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getRegistryName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lfr;->b(Ljava/lang/String;)Z

    .line 566
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->refreshHomeCard()V

    .line 568
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->z:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v0, :cond_1

    .line 569
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->z:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    .line 574
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 575
    return-void

    .line 571
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->z:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_0

    .line 572
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->z:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    goto :goto_0
.end method

.method public b(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;
    .locals 2

    .prologue
    .line 578
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 579
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddDescription(Ljava/lang/String;)V

    .line 580
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressFirstName(Ljava/lang/String;)V

    .line 581
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLastName(Ljava/lang/String;)V

    .line 582
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressLine1()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine1(Ljava/lang/String;)V

    .line 583
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getAddressLine2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setAddressLine2(Ljava/lang/String;)V

    .line 584
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCity(Ljava/lang/String;)V

    .line 585
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCoregistrantFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCoregistrantFirstName(Ljava/lang/String;)V

    .line 586
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCoregistrantLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCoregistrantLastName(Ljava/lang/String;)V

    .line 587
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getCreatedBy()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setCreatedBy(Ljava/lang/String;)V

    .line 588
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getEventDate()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventDate(Ljava/lang/String;)V

    .line 589
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getEventLocation()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventLocation(Ljava/lang/String;)V

    .line 590
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getFirstName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setFirstName(Ljava/lang/String;)V

    .line 591
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getLastModifiedBy()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setLastModifiedBy(Ljava/lang/String;)V

    .line 592
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getLastName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setLastName(Ljava/lang/String;)V

    .line 593
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setListType(Ljava/lang/String;)V

    .line 594
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getModified()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setModified(Ljava/lang/String;)V

    .line 595
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getModifiedDetails()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setModifiedDetails(Ljava/lang/String;)V

    .line 596
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getEventDate()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setEventDate(Ljava/lang/String;)V

    .line 597
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getPersonalized_message()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPersonalized_message(Ljava/lang/String;)V

    .line 598
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getPhone()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPhone(Ljava/lang/String;)V

    .line 599
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getPrivacySetting()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setPrivacySetting(Ljava/lang/String;)V

    .line 600
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getRecepient()Lcom/bestbuy/android/api/lib/models/registry/Recipient;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRecepient(Lcom/bestbuy/android/api/lib/models/registry/Recipient;)V

    .line 601
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getRecepientUuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRecepientUuid(Ljava/lang/String;)V

    .line 602
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getRegistryName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setRegistryName(Ljava/lang/String;)V

    .line 603
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getShippingAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setShippingAddress(Ljava/lang/String;)V

    .line 604
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setState(Ljava/lang/String;)V

    .line 605
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setUuid(Ljava/lang/String;)V

    .line 606
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getZipCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->setZipCode(Ljava/lang/String;)V

    .line 607
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->B:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    return-object v0
.end method

.method public b()V
    .locals 0

    .prologue
    .line 327
    return-void
.end method

.method public c()V
    .locals 6

    .prologue
    .line 704
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 705
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->H:Z

    if-nez v1, :cond_3

    .line 706
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getFragments()Ljava/util/List;

    move-result-object v3

    .line 707
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    move v2, v1

    .line 708
    :goto_0
    if-ltz v2, :cond_1

    .line 709
    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/Fragment;

    .line 710
    instance-of v4, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v4, :cond_0

    .line 711
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v4

    const-string v5, "MyRegistryDetailsFragment"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v4

    const-string v5, "RegistryAndGiftsFragment"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getTag()Ljava/lang/String;

    move-result-object v1

    const-string v4, "HomeTabFragment"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 712
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 708
    :cond_0
    add-int/lit8 v1, v2, -0x1

    move v2, v1

    goto :goto_0

    .line 715
    :cond_1
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 717
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStackImmediate()Z

    .line 723
    :cond_2
    :goto_1
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lfr;->a(Ljava/lang/String;)Z

    .line 724
    const-string v0, ""

    invoke-static {v0}, Lfr;->b(Ljava/lang/String;)Z

    .line 725
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 726
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->refreshHomeCard()V

    .line 728
    return-void

    .line 720
    :cond_3
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1
.end method

.method public g()V
    .locals 1

    .prologue
    .line 222
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->I:Z

    if-eqz v0, :cond_0

    .line 223
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d()V

    .line 225
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 210
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 212
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->A:Z

    if-eqz v0, :cond_0

    .line 213
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->e()V

    .line 218
    :goto_0
    return-void

    .line 215
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k:Ljava/lang/String;

    .line 216
    new-instance v0, Ljm;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->s:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->k:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Ljm;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljm;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 109
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 110
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 111
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 112
    check-cast p1, Lct;

    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->r:Lct;

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->r:Lct;

    invoke-interface {v0}, Lct;->onCreateMyEmptyRegistryFragmentLaunch()V

    .line 114
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v4, 0x1

    .line 612
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->u:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_1

    .line 613
    new-instance v1, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, p0, v4, v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;-><init>(Landroid/support/v4/app/Fragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 614
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 615
    instance-of v2, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v2, :cond_0

    .line 616
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 648
    :cond_0
    :goto_0
    return-void

    .line 618
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->t:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_2

    .line 619
    new-instance v1, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, p0, v4, v0}, Lcom/bestbuy/android/activities/registry/CreateWeddingRegistry;-><init>(Landroid/support/v4/app/Fragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 620
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 621
    instance-of v2, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v2, :cond_0

    .line 622
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 624
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->v:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_3

    .line 625
    new-instance v0, Landroid/app/DatePickerDialog;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->x:Landroid/app/DatePickerDialog$OnDateSetListener;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->w:Ljava/util/Calendar;

    invoke-virtual {v3, v4}, Ljava/util/Calendar;->get(I)I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->w:Ljava/util/Calendar;

    invoke-virtual {v4, v7}, Ljava/util/Calendar;->get(I)I

    move-result v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->w:Ljava/util/Calendar;

    const/4 v6, 0x5

    invoke-virtual {v5, v6}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-direct/range {v0 .. v5}, Landroid/app/DatePickerDialog;-><init>(Landroid/content/Context;Landroid/app/DatePickerDialog$OnDateSetListener;III)V

    .line 628
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    const-wide/16 v4, 0x3e8

    sub-long/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Landroid/widget/DatePicker;->setMinDate(J)V

    .line 629
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 630
    const/16 v2, 0x12

    invoke-virtual {v1, v7, v2}, Ljava/util/Calendar;->add(II)V

    .line 631
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->getDatePicker()Landroid/widget/DatePicker;

    move-result-object v2

    invoke-virtual {v1}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Landroid/widget/DatePicker;->setMaxDate(J)V

    .line 632
    invoke-virtual {v0}, Landroid/app/DatePickerDialog;->show()V

    goto :goto_0

    .line 633
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_4

    .line 634
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->f()V

    goto :goto_0

    .line 635
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->D:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 641
    new-instance v1, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->i:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, p0, v4, v0}, Lcom/bestbuy/android/activities/registry/RegistryPrivacySetting;-><init>(Landroid/support/v4/app/Fragment;ZLcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 642
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 643
    instance-of v2, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v2, :cond_0

    .line 644
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v2, "RegistryPrivacySetting"

    invoke-virtual {v0, v1, v4, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 118
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 119
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 120
    sget-object v0, Llu;->az:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 122
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 141
    const v0, 0x7f030114

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v2, 0x10

    invoke-virtual {v0, v2}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 143
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->s:Landroid/view/View;

    .line 144
    const v0, 0x7f0c03f6

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 145
    const v0, 0x7f0c03fb

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 146
    const v0, 0x7f0c03fc

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 147
    const v0, 0x7f0c03f5

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->t:Landroid/widget/RelativeLayout;

    .line 148
    const v0, 0x7f0c03fa

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->u:Landroid/widget/RelativeLayout;

    .line 149
    const v0, 0x7f0c03f8

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->v:Landroid/widget/RelativeLayout;

    .line 152
    const v0, 0x7f0c03fd

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->D:Landroid/widget/RelativeLayout;

    .line 153
    const v0, 0x7f0c03ff

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 154
    const v0, 0x7f0c03fe

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->D:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->u:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->t:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->v:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 161
    const v0, 0x7f0c0371

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->n:Landroid/widget/EditText;

    .line 162
    const v0, 0x7f0c0374

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->o:Landroid/widget/EditText;

    .line 163
    const v0, 0x7f0c0377

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Spinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->p:Landroid/widget/Spinner;

    .line 164
    const v0, 0x7f0c0404

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->m:Landroid/widget/EditText;

    .line 165
    const v0, 0x7f0c012a

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    new-instance v2, Ldd;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->l:Landroid/widget/EditText;

    invoke-direct {v2, p0, v3}, Ldd;-><init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Landroid/widget/EditText;)V

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 167
    const v0, 0x7f0c03f9

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 168
    new-instance v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings$1;-><init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->x:Landroid/app/DatePickerDialog$OnDateSetListener;

    .line 186
    const v0, 0x7f0c040b

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j:Landroid/widget/RelativeLayout;

    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 188
    return-object v1
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 730
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 731
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 732
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->f:Lnb;

    invoke-virtual {v0}, Lnb;->E()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 733
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->y:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getRegistryName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 734
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 126
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 127
    sput-boolean v3, Lcom/bestbuy/android/activities/home/HomeActivity;->inLifeEventsFragment:Z

    .line 128
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 129
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Registry Settings"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 134
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, "Save"

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 137
    :cond_0
    return-void
.end method
