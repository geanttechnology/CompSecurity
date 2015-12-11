.class public Leg;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Landroid/content/Context;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/view/LayoutInflater;

.field private d:Landroid/support/v4/app/Fragment;

.field private e:Landroid/widget/LinearLayout;

.field private f:Landroid/view/View;

.field private g:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/widget/LinearLayout;Landroid/view/View;ILjava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/support/v4/app/Fragment;",
            "Landroid/widget/LinearLayout;",
            "Landroid/view/View;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;",
            "Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;",
            ")V"
        }
    .end annotation

    .prologue
    .line 41
    invoke-direct {p0, p1, p5, p6}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 42
    iput-object p1, p0, Leg;->a:Landroid/content/Context;

    .line 43
    iput-object p2, p0, Leg;->d:Landroid/support/v4/app/Fragment;

    .line 44
    iput-object p6, p0, Leg;->b:Ljava/util/ArrayList;

    .line 45
    iput-object p3, p0, Leg;->e:Landroid/widget/LinearLayout;

    .line 46
    iput-object p4, p0, Leg;->f:Landroid/view/View;

    .line 47
    iput-object p7, p0, Leg;->g:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 48
    if-eqz p1, :cond_0

    .line 49
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Leg;->c:Landroid/view/LayoutInflater;

    .line 50
    :cond_0
    return-void
.end method

.method static synthetic a(Leg;)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Leg;->d:Landroid/support/v4/app/Fragment;

    return-object v0
.end method

.method private a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)Landroid/widget/LinearLayout;
    .locals 8

    .prologue
    const v7, 0x7f0802af

    const/4 v5, 0x0

    const/16 v6, 0x8

    .line 224
    iget-object v0, p0, Leg;->c:Landroid/view/LayoutInflater;

    const v1, 0x7f03008c

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 225
    const v1, 0x7f0c00d4

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 226
    const v2, 0x7f0c0223

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 227
    invoke-virtual {v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getPaintFlags()I

    move-result v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPaintFlags(I)V

    .line 228
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 229
    invoke-static {}, Lfr;->j()Ljava/lang/String;

    move-result-object v3

    .line 230
    if-eqz v3, :cond_1

    const-string v4, "10130"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 232
    invoke-virtual {v2, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 233
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "$"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getCurrentPrice()D

    move-result-wide v4

    invoke-direct {p0, v4, v5}, Leg;->a(D)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 234
    invoke-virtual {v1, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 264
    :goto_0
    new-instance v2, Leg$3;

    invoke-direct {v2, p0, p1}, Leg$3;-><init>(Leg;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)V

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 280
    :cond_0
    return-object v0

    .line 237
    :cond_1
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "regular"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 238
    invoke-virtual {v2, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 239
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "$"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getTotalPrice()D

    move-result-wide v4

    invoke-direct {p0, v4, v5}, Leg;->a(D)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 240
    invoke-virtual {v1, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0

    .line 241
    :cond_2
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "MAP"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 242
    const-string v3, "See Price in Cart"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 243
    invoke-virtual {v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 244
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0

    .line 245
    :cond_3
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "ICR-noPrice"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 246
    iget-object v3, p0, Leg;->a:Landroid/content/Context;

    invoke-virtual {v3, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 247
    invoke-virtual {v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 248
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0

    .line 249
    :cond_4
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "ICR-strikeThrough"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 250
    iget-object v3, p0, Leg;->a:Landroid/content/Context;

    invoke-virtual {v3, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 251
    invoke-virtual {v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 252
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "$"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getRegularPrice()D

    move-result-wide v4

    invoke-direct {p0, v4, v5}, Leg;->a(D)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 253
    invoke-virtual {v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getPaintFlags()I

    move-result v3

    or-int/lit8 v3, v3, 0x10

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPaintFlags(I)V

    goto/16 :goto_0

    .line 254
    :cond_5
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v3

    const-string v4, "ICR-hidePrice"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 255
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 256
    invoke-virtual {v1, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 258
    :cond_6
    invoke-virtual {v2, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 260
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "$"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getCurrentPrice()D

    move-result-wide v4

    invoke-direct {p0, v4, v5}, Leg;->a(D)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 261
    invoke-virtual {v1, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_0
.end method

.method private a(D)Ljava/lang/String;
    .locals 7

    .prologue
    .line 304
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    .line 305
    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    rem-double v2, p1, v2

    const-wide/16 v4, 0x0

    cmpl-double v1, v2, v4

    if-nez v1, :cond_0

    .line 306
    const-string v0, "%.2f"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1, p2}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 314
    :goto_0
    return-object v0

    .line 309
    :cond_0
    :try_start_0
    new-instance v1, Ljava/text/DecimalFormat;

    const-string v2, "###,###,###.##"

    invoke-direct {v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 310
    invoke-virtual {v1, p1, p2}, Ljava/text/NumberFormat;->format(D)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    .line 311
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method static synthetic b(Leg;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Leg;->g:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method

.method static synthetic c(Leg;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Leg;->a:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Leg;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 54
    const/4 v0, 0x0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11

    .prologue
    const/4 v10, 0x1

    const/16 v9, 0x8

    const/4 v8, 0x0

    .line 71
    if-nez p2, :cond_4

    .line 72
    iget-object v0, p0, Leg;->c:Landroid/view/LayoutInflater;

    const v1, 0x7f03008b

    invoke-virtual {v0, v1, p3, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 73
    new-instance v1, Leh;

    invoke-direct {v1}, Leh;-><init>()V

    .line 74
    const v0, 0x7f0c0212

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Leh;->a:Landroid/widget/LinearLayout;

    .line 75
    const v0, 0x7f0c0213

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 76
    const v0, 0x7f0c0214

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Leh;->b:Landroid/widget/LinearLayout;

    .line 77
    const v0, 0x7f0c0215

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 78
    const v0, 0x7f0c0216

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 79
    const v0, 0x7f0c01ff

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Leh;->c:Landroid/widget/LinearLayout;

    .line 80
    const v0, 0x7f0c0219

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 81
    const v0, 0x7f0c021a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Leh;->e:Landroid/widget/LinearLayout;

    .line 82
    const v0, 0x7f0c021b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 83
    const v0, 0x7f0c021d

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Leh;->d:Landroid/widget/LinearLayout;

    .line 84
    const v0, 0x7f0c021e

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 85
    const v0, 0x7f0c021f

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 86
    const v0, 0x7f0c021c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Leh;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 87
    const v0, 0x7f0c0220

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Leh;->n:Landroid/widget/RelativeLayout;

    .line 88
    const v0, 0x7f0c0217

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Leh;->o:Landroid/widget/ImageView;

    .line 89
    const v0, 0x7f0c0221

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Leh;->p:Landroid/widget/RelativeLayout;

    .line 90
    const v0, 0x7f0c00cd

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Leh;->q:Landroid/widget/RelativeLayout;

    .line 91
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v2, v1

    .line 95
    :goto_0
    iget-object v0, p0, Leg;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    .line 96
    if-eqz v0, :cond_3

    .line 97
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getCondition()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 98
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getCondition()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    .line 99
    const-string v3, "openbox"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 100
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->isDisplayCertifiedLogo()Z

    .line 101
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getDisplayCondition()Ljava/lang/String;

    move-result-object v1

    const-string v3, "Open-Box"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 108
    :goto_1
    iget-object v3, v2, Leh;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 110
    :cond_0
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    if-eqz v1, :cond_6

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getSellerName()Ljava/lang/String;

    move-result-object v1

    const-string v3, "BestBuy"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 111
    iget-object v1, v2, Leh;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 112
    iget-object v1, v2, Leh;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 118
    :goto_2
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getImages()Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_7

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getImages()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->getUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_7

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getImages()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_7

    .line 120
    iget-object v1, v2, Leh;->o:Landroid/widget/ImageView;

    invoke-virtual {v1, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 121
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getImages()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerImages;->getUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v3, v2, Leh;->o:Landroid/widget/ImageView;

    invoke-static {v1, v3, v8}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 125
    :goto_3
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    if-eqz v1, :cond_8

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getShip()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;

    move-result-object v1

    if-eqz v1, :cond_8

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getShip()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_8

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getShip()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_8

    .line 127
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getShip()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/ShipAvailability;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    .line 128
    const-string v3, "<b>Shipping:</b>"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string v3, "<b>Shipping</b>:"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 129
    const-string v3, "Delivery:"

    invoke-virtual {v1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 130
    const-string v3, "<b>"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v3, "</b>"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v3, "</b>:"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 131
    :cond_1
    iget-object v3, v2, Leh;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 135
    :goto_4
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    if-eqz v1, :cond_b

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    if-eqz v1, :cond_b

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_b

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_b

    .line 137
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->getDisplayMessage()Ljava/lang/String;

    move-result-object v1

    .line 138
    const-string v3, "<b>Store Pickup:</b>"

    const-string v4, ""

    invoke-virtual {v1, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 139
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_9

    .line 140
    iget-object v1, v2, Leh;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->getDisplayMessage()Ljava/lang/String;

    move-result-object v3

    const-string v4, "<b>Store Pickup:</b>"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 155
    :goto_5
    iget-object v1, v2, Leh;->q:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->removeAllViews()V

    .line 156
    iget-object v1, v2, Leh;->q:Landroid/widget/RelativeLayout;

    invoke-direct {p0, v0}, Leg;->a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 157
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    if-eqz v1, :cond_11

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    const-string v3, "ICR-noPrice"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_11

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    const-string v3, "MAP"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_11

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    const-string v3, "ICR-hidePrice"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_11

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    const-string v3, "ICR-strikeThrough"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_11

    .line 160
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getShippingCost()D

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmpl-double v1, v4, v6

    if-lez v1, :cond_d

    .line 161
    iget-object v1, v2, Leh;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 162
    const-string v1, "%.2f"

    new-array v3, v10, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getShippingCost()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    aput-object v4, v3, v8

    invoke-static {v1, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 163
    iget-object v3, v2, Leh;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Includes shipping:$"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 167
    :goto_6
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 168
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_10

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_10

    .line 169
    iget-object v1, v2, Leh;->d:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 170
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v1

    const-string v3, "freeShipping"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 186
    :cond_2
    :goto_7
    iget-object v1, v2, Leh;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v9}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 187
    iget-object v1, v2, Leh;->n:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v8}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 197
    iget-object v1, v2, Leh;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Leg$1;

    invoke-direct {v3, p0, v0}, Leg$1;-><init>(Leg;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)V

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 207
    iget-object v1, v2, Leh;->n:Landroid/widget/RelativeLayout;

    new-instance v2, Leg$2;

    invoke-direct {v2, p0, v0}, Leg$2;-><init>(Leg;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 220
    :cond_3
    return-object p2

    .line 93
    :cond_4
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Leh;

    move-object v2, v0

    goto/16 :goto_0

    .line 106
    :cond_5
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v8}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_1

    .line 114
    :cond_6
    iget-object v1, v2, Leh;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 115
    iget-object v1, v2, Leh;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 116
    iget-object v1, v2, Leh;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/SellerInfo;->getSellerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 124
    :cond_7
    iget-object v1, v2, Leh;->o:Landroid/widget/ImageView;

    invoke-virtual {v1, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_3

    .line 133
    :cond_8
    iget-object v1, v2, Leh;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v3, "Not Available"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 142
    :cond_9
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    if-eqz v1, :cond_a

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    if-eqz v1, :cond_a

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_a

    .line 144
    iget-object v1, v2, Leh;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v3, "Available"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 146
    :cond_a
    iget-object v1, v2, Leh;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v3, "Not Available"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 149
    :cond_b
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    if-eqz v1, :cond_c

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    if-eqz v1, :cond_c

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getAvailability()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Availability;->getPickup()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/PickUpAvailability;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_c

    .line 151
    iget-object v1, v2, Leh;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v3, "Available"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 153
    :cond_c
    iget-object v1, v2, Leh;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v3, "Not Available"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 165
    :cond_d
    iget-object v1, v2, Leh;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_6

    .line 171
    :cond_e
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v1

    const-string v3, "freeShipping35"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 172
    iget-object v1, v2, Leh;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 173
    iget-object v1, v2, Leh;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v3, "on Orders $35 and Up"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 174
    :cond_f
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getProperties()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Properties;->getFreeShippingCode()Ljava/lang/String;

    move-result-object v1

    const-string v3, "freeShipping25"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 175
    iget-object v1, v2, Leh;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 176
    iget-object v1, v2, Leh;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v3, "on Orders $25 and Up"

    invoke-virtual {v1, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_7

    .line 179
    :cond_10
    iget-object v1, v2, Leh;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_7

    .line 183
    :cond_11
    iget-object v1, v2, Leh;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 184
    iget-object v1, v2, Leh;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_7
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x2

    return v0
.end method
