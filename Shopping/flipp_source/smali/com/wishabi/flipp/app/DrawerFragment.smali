.class public Lcom/wishabi/flipp/app/DrawerFragment;
.super Landroid/app/Fragment;
.source "SourceFile"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Landroid/view/View$OnClickListener;"
    }
.end annotation


# instance fields
.field a:Lcom/wishabi/flipp/app/af;

.field private b:Landroid/content/SharedPreferences;

.field private c:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

.field private d:Landroid/widget/TextView;

.field private e:Landroid/widget/TextView;

.field private f:Landroid/widget/TextView;

.field private g:Landroid/widget/LinearLayout;

.field private final h:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field private i:Landroid/database/Cursor;

.field private final j:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private final k:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private l:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 76
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    .line 81
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->j:Ljava/util/HashMap;

    .line 82
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->k:Ljava/util/HashMap;

    return-void
.end method

.method public static a(Ljava/lang/String;)I
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 87
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 146
    :cond_0
    :goto_0
    return v0

    .line 92
    :cond_1
    const-string v1, "All Flyers"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 93
    const v0, 0x7f0e001b

    goto :goto_0

    .line 95
    :cond_2
    const-string v1, "Favorites"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 96
    const v0, 0x7f0e00b4

    goto :goto_0

    .line 98
    :cond_3
    const-string v1, "Clippings"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 99
    const v0, 0x7f0e0034

    goto :goto_0

    .line 101
    :cond_4
    const-string v1, "Shopping List"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 102
    const v0, 0x7f0e0135

    goto :goto_0

    .line 104
    :cond_5
    const-string v1, "Coupons"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 105
    const v0, 0x7f0e0086

    goto :goto_0

    .line 107
    :cond_6
    const-string v1, "Print Coupons"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 108
    const v0, 0x7f0e0105

    goto :goto_0

    .line 110
    :cond_7
    const-string v1, "Categories"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 111
    const v0, 0x7f0e001a

    goto :goto_0

    .line 113
    :cond_8
    const-string v1, "Automotive"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 114
    const v0, 0x7f0e001c

    goto :goto_0

    .line 116
    :cond_9
    const-string v1, "Baby & Kids"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 117
    const v0, 0x7f0e001d

    goto :goto_0

    .line 119
    :cond_a
    const-string v1, "Electronics"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 120
    const v0, 0x7f0e001e

    goto :goto_0

    .line 122
    :cond_b
    const-string v1, "Fashion"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 123
    const v0, 0x7f0e001f

    goto/16 :goto_0

    .line 125
    :cond_c
    const-string v1, "Groceries"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 126
    const v0, 0x7f0e0020

    goto/16 :goto_0

    .line 128
    :cond_d
    const-string v1, "Health & Pharmacy"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 129
    const v0, 0x7f0e0021

    goto/16 :goto_0

    .line 131
    :cond_e
    const-string v1, "Home & Garden"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 132
    const v0, 0x7f0e0022

    goto/16 :goto_0

    .line 134
    :cond_f
    const-string v1, "Office"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 135
    const v0, 0x7f0e0023

    goto/16 :goto_0

    .line 137
    :cond_10
    const-string v1, "Pets"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 138
    const v0, 0x7f0e0025

    goto/16 :goto_0

    .line 140
    :cond_11
    const-string v1, "Pharmacy"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_12

    .line 141
    const v0, 0x7f0e0026

    goto/16 :goto_0

    .line 143
    :cond_12
    const-string v1, "Sporting Goods"

    invoke-virtual {p0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 144
    const v0, 0x7f0e0027

    goto/16 :goto_0
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/DrawerFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->d:Landroid/widget/TextView;

    return-object v0
.end method

.method private a(Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 446
    .line 447
    invoke-static {p2}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Ljava/lang/String;)I

    move-result v0

    .line 448
    if-eqz v0, :cond_0

    .line 449
    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/DrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 450
    :goto_0
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 452
    invoke-virtual {p1, p2}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 453
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    .line 454
    invoke-virtual {p1, v0, v1, v1, v1}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 456
    const v0, 0x7f09006c

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 457
    invoke-virtual {p1, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 458
    return-void

    :cond_0
    move-object v0, p2

    goto :goto_0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/DrawerFragment;)Lcom/wishabi/flipp/app/af;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->a:Lcom/wishabi/flipp/app/af;

    return-object v0
.end method

.method private b(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 471
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->j:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 472
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 473
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 474
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    goto :goto_0

    .line 478
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->k:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 479
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 480
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 481
    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    goto :goto_1

    .line 484
    :cond_1
    iput-object p1, p0, Lcom/wishabi/flipp/app/DrawerFragment;->l:Ljava/lang/String;

    .line 485
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 462
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 463
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/DrawerFragment;->a:Lcom/wishabi/flipp/app/af;

    if-eqz v1, :cond_0

    .line 464
    iget-object v1, p0, Lcom/wishabi/flipp/app/DrawerFragment;->a:Lcom/wishabi/flipp/app/af;

    invoke-interface {v1, v0}, Lcom/wishabi/flipp/app/af;->a(Ljava/lang/String;)V

    .line 466
    :cond_0
    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/DrawerFragment;->b(Ljava/lang/String;)V

    .line 467
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 347
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 348
    if-nez v1, :cond_0

    .line 362
    :goto_0
    return-object v5

    .line 351
    :cond_0
    packed-switch p1, :pswitch_data_0

    goto :goto_0

    .line 353
    :pswitch_0
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->b:Landroid/net/Uri;

    new-array v3, v7, [Ljava/lang/String;

    const-string v4, "name"

    aput-object v4, v3, v6

    const-string v4, "name <> \'All Flyers\'"

    const-string v6, "name"

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v0

    goto :goto_0

    .line 356
    :pswitch_1
    new-instance v0, Landroid/content/CursorLoader;

    sget-object v2, Lcom/wishabi/flipp/content/i;->q:Landroid/net/Uri;

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/String;

    const-string v4, "_id"

    aput-object v4, v3, v6

    const-string v4, "clipped"

    aput-object v4, v3, v7

    const/4 v4, 0x2

    const-string v6, "sent"

    aput-object v6, v3, v4

    const-string v4, "clipped = 1 AND (sent = 0 OR sent IS NULL) AND deleted = 0"

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v0

    goto :goto_0

    .line 351
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const v7, 0x7f020099

    const/4 v6, 0x0

    const/4 v1, 0x0

    .line 218
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 219
    if-nez v0, :cond_0

    move-object v0, v1

    .line 336
    :goto_0
    return-object v0

    .line 222
    :cond_0
    const v0, 0x7f030022

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 223
    if-nez v2, :cond_1

    move-object v0, v1

    .line 224
    goto :goto_0

    .line 226
    :cond_1
    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->b:Landroid/content/SharedPreferences;

    .line 227
    new-instance v0, Lcom/wishabi/flipp/app/ac;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/ac;-><init>(Lcom/wishabi/flipp/app/DrawerFragment;)V

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->c:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 239
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->b:Landroid/content/SharedPreferences;

    iget-object v3, p0, Lcom/wishabi/flipp/app/DrawerFragment;->c:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v3}, Landroid/content/SharedPreferences;->registerOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 242
    const v0, 0x7f0b009a

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->d:Landroid/widget/TextView;

    .line 243
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->d:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/wishabi/flipp/app/DrawerFragment;->b:Landroid/content/SharedPreferences;

    const-string v4, "postal_code"

    invoke-interface {v3, v4, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 245
    const v0, 0x7f0b00a2

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->e:Landroid/widget/TextView;

    .line 246
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->e:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 247
    const v0, 0x7f0b00a3

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->f:Landroid/widget/TextView;

    .line 248
    const v0, 0x7f0b00a4

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->g:Landroid/widget/LinearLayout;

    .line 251
    const v0, 0x7f0b009b

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 253
    new-instance v3, Lcom/wishabi/flipp/app/ad;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/app/ad;-><init>(Lcom/wishabi/flipp/app/DrawerFragment;)V

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 261
    const v0, 0x7f0b00a1

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 263
    new-instance v3, Lcom/wishabi/flipp/app/ae;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/app/ae;-><init>(Lcom/wishabi/flipp/app/DrawerFragment;)V

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 271
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "All Flyers"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020093

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 273
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Favorites"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020092

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 275
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Clippings"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02008e

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 277
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Shopping List"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02009a

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 279
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Coupons"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02008f

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 281
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Automotive"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02008c

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 283
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Baby & Kids"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02008d

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Electronics"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020090

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 287
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Fashion"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020091

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 289
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Groceries"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020094

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 291
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Health & Pharmacy"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 293
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Home & Garden"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020095

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 295
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Office"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020096

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 297
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Pets"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f020098

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 299
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Pharmacy"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 301
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->h:Ljava/util/Map;

    const-string v3, "Sporting Goods"

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f02009b

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 304
    const v0, 0x7f0b009c

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 305
    const-string v3, "All Flyers"

    invoke-direct {p0, v0, v3}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 306
    iget-object v3, p0, Lcom/wishabi/flipp/app/DrawerFragment;->j:Ljava/util/HashMap;

    const-string v4, "All Flyers"

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    const v0, 0x7f0b009e

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 309
    const-string v3, "Favorites"

    invoke-direct {p0, v0, v3}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 310
    iget-object v3, p0, Lcom/wishabi/flipp/app/DrawerFragment;->j:Ljava/util/HashMap;

    const-string v4, "Favorites"

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 312
    const v0, 0x7f0b009f

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 314
    const-string v3, "Clippings"

    invoke-direct {p0, v0, v3}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 315
    iget-object v3, p0, Lcom/wishabi/flipp/app/DrawerFragment;->j:Ljava/util/HashMap;

    const-string v4, "Clippings"

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 317
    const v0, 0x7f0b00a0

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 319
    const-string v3, "Shopping List"

    invoke-direct {p0, v0, v3}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 320
    iget-object v3, p0, Lcom/wishabi/flipp/app/DrawerFragment;->j:Ljava/util/HashMap;

    const-string v4, "Shopping List"

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 322
    const v0, 0x7f0b009d

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 323
    const-string v3, "Coupons"

    invoke-direct {p0, v0, v3}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 324
    iget-object v3, p0, Lcom/wishabi/flipp/app/DrawerFragment;->j:Ljava/util/HashMap;

    const-string v4, "Coupons"

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 326
    if-eqz p3, :cond_2

    .line 327
    const-string v0, "SAVE_STATE_CATEGORY_SELECTED_KEY"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->l:Ljava/lang/String;

    .line 330
    :cond_2
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 331
    if-eqz v0, :cond_3

    .line 332
    invoke-virtual {v0, v6, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 333
    const/4 v3, 0x1

    invoke-virtual {v0, v3, v1, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    :cond_3
    move-object v0, v2

    .line 336
    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 427
    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    .line 429
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->c:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    if-eqz v0, :cond_0

    .line 430
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->b:Landroid/content/SharedPreferences;

    iget-object v1, p0, Lcom/wishabi/flipp/app/DrawerFragment;->c:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences;->unregisterOnSharedPreferenceChangeListener(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V

    .line 432
    iput-object v2, p0, Lcom/wishabi/flipp/app/DrawerFragment;->c:Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;

    .line 433
    iput-object v2, p0, Lcom/wishabi/flipp/app/DrawerFragment;->b:Landroid/content/SharedPreferences;

    .line 435
    :cond_0
    return-void
.end method

.method public synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 5

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 30
    check-cast p2, Landroid/database/Cursor;

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/DrawerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :cond_0
    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->i:Landroid/database/Cursor;

    if-eq v0, p2, :cond_0

    iput-object p2, p0, Lcom/wishabi/flipp/app/DrawerFragment;->i:Landroid/database/Cursor;

    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->k:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    if-eqz p2, :cond_1

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->f:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->f:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    const-string v0, "name"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    :goto_1
    if-eqz v0, :cond_4

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    const v0, 0x7f030006

    const/4 v4, 0x0

    invoke-static {v1, v0, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-direct {p0, v0, v3}, Lcom/wishabi/flipp/app/DrawerFragment;->a(Landroid/widget/TextView;Ljava/lang/String;)V

    iget-object v4, p0, Lcom/wishabi/flipp/app/DrawerFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    iget-object v4, p0, Lcom/wishabi/flipp/app/DrawerFragment;->k:Ljava/util/HashMap;

    invoke-virtual {v4, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_3
    invoke-interface {p2}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    goto :goto_1

    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->l:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/wishabi/flipp/app/DrawerFragment;->b(Ljava/lang/String;)V

    goto :goto_0

    :pswitch_1
    if-eqz p2, :cond_5

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_6

    :cond_5
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    :cond_6
    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->e:Landroid/widget/TextView;

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->e:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 416
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 419
    :goto_0
    return-void

    .line 418
    :pswitch_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/wishabi/flipp/app/DrawerFragment;->i:Landroid/database/Cursor;

    goto :goto_0

    .line 416
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 341
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 342
    const-string v0, "SAVE_STATE_CATEGORY_SELECTED_KEY"

    iget-object v1, p0, Lcom/wishabi/flipp/app/DrawerFragment;->l:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    return-void
.end method
