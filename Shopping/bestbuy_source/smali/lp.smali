.class public Llp;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static f:Landroid/widget/LinearLayout;

.field private static g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static h:Landroid/widget/ImageView;

.field private static i:Z

.field private static j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private static o:Z

.field private static p:Z

.field private static q:Z

.field private static r:Z

.field private static s:Z

.field private static t:Z

.field private static u:Z

.field private static v:Z

.field private static w:Z

.field private static x:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 42
    sput-boolean v0, Llp;->i:Z

    .line 48
    sput-boolean v0, Llp;->o:Z

    .line 49
    sput-boolean v0, Llp;->p:Z

    .line 50
    sput-boolean v0, Llp;->q:Z

    .line 51
    sput-boolean v0, Llp;->r:Z

    .line 52
    sput-boolean v0, Llp;->s:Z

    .line 53
    sput-boolean v0, Llp;->t:Z

    .line 54
    sput-boolean v0, Llp;->u:Z

    .line 55
    sput-boolean v0, Llp;->v:Z

    .line 56
    sput-boolean v0, Llp;->w:Z

    .line 57
    sput-boolean v0, Llp;->x:Z

    return-void
.end method

.method public static a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;
    .locals 18

    .prologue
    .line 75
    const/4 v2, 0x0

    sput-boolean v2, Llp;->o:Z

    .line 76
    const/4 v2, 0x0

    sput-boolean v2, Llp;->p:Z

    .line 77
    const/4 v2, 0x0

    sput-boolean v2, Llp;->q:Z

    .line 78
    const/4 v2, 0x0

    sput-boolean v2, Llp;->r:Z

    .line 79
    const/4 v2, 0x0

    sput-boolean v2, Llp;->s:Z

    .line 80
    const/4 v2, 0x0

    sput-boolean v2, Llp;->t:Z

    .line 81
    const/4 v2, 0x0

    sput-boolean v2, Llp;->u:Z

    .line 82
    const/4 v2, 0x0

    sput-boolean v2, Llp;->v:Z

    .line 83
    const/4 v2, 0x0

    sput-boolean v2, Llp;->w:Z

    .line 84
    const/4 v2, 0x0

    sput-boolean v2, Llp;->x:Z

    .line 85
    invoke-virtual/range {p1 .. p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v3

    .line 86
    invoke-virtual/range {p1 .. p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v12

    .line 87
    if-eqz v12, :cond_1

    .line 88
    invoke-virtual {v12}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 89
    invoke-virtual/range {p1 .. p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v2

    const-string v4, "refurbished"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 90
    const/4 v2, 0x1

    sput-boolean v2, Llp;->p:Z

    .line 92
    :cond_0
    invoke-virtual {v12}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 93
    invoke-virtual {v12}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v2

    sput-boolean v2, Llp;->o:Z

    .line 95
    :cond_1
    if-eqz v3, :cond_9

    .line 96
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_9

    .line 97
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "onSale"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 98
    const/4 v2, 0x1

    sput-boolean v2, Llp;->q:Z

    .line 99
    :cond_2
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "clearance"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 100
    const/4 v2, 0x1

    sput-boolean v2, Llp;->s:Z

    .line 101
    :cond_3
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "bundle"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 102
    const/4 v2, 0x1

    sput-boolean v2, Llp;->t:Z

    .line 103
    :cond_4
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "ICR-noPrice"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 104
    const/4 v2, 0x1

    sput-boolean v2, Llp;->u:Z

    .line 105
    :cond_5
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "ICR-strikeThrough"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 106
    const/4 v2, 0x1

    sput-boolean v2, Llp;->v:Z

    .line 107
    :cond_6
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "MAP"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 108
    const/4 v2, 0x1

    sput-boolean v2, Llp;->x:Z

    .line 109
    :cond_7
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "ICR-hidePrice"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 110
    const/4 v2, 0x1

    sput-boolean v2, Llp;->w:Z

    .line 111
    :cond_8
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "regular"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 112
    const/4 v2, 0x1

    sput-boolean v2, Llp;->r:Z

    .line 116
    :cond_9
    const/4 v5, 0x0

    .line 117
    const-string v2, ""

    .line 118
    new-instance v6, Ljava/text/DecimalFormat;

    const-string v2, "0.00"

    invoke-direct {v6, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 119
    invoke-virtual/range {p0 .. p0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v2

    .line 120
    const/4 v11, 0x0

    .line 121
    packed-switch p2, :pswitch_data_0

    .line 135
    :goto_0
    if-eqz v3, :cond_b

    invoke-virtual/range {p1 .. p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->isActive()Z

    move-result v2

    if-eqz v2, :cond_a

    sget-boolean v2, Llp;->w:Z

    if-eqz v2, :cond_b

    .line 136
    :cond_a
    const/16 v2, 0x8

    invoke-virtual {v11, v2}, Landroid/view/View;->setVisibility(I)V

    move-object v2, v11

    .line 537
    :goto_1
    return-object v2

    .line 123
    :pswitch_0
    const v4, 0x7f0300c8

    const/4 v7, 0x0

    invoke-virtual {v2, v4, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    goto :goto_0

    .line 126
    :pswitch_1
    const v4, 0x7f0300c7

    const/4 v7, 0x0

    invoke-virtual {v2, v4, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    goto :goto_0

    .line 129
    :pswitch_2
    const v4, 0x7f0300c6

    const/4 v7, 0x0

    invoke-virtual {v2, v4, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    goto :goto_0

    .line 132
    :pswitch_3
    const v4, 0x7f0300c5

    const/4 v7, 0x0

    invoke-virtual {v2, v4, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    goto :goto_0

    .line 139
    :cond_b
    const v2, 0x7f0c00cf

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    sput-object v2, Llp;->f:Landroid/widget/LinearLayout;

    .line 140
    const v2, 0x7f0c0283

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    sput-object v2, Llp;->h:Landroid/widget/ImageView;

    .line 141
    const v2, 0x7f0c0284

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 142
    const v2, 0x7f0c00d8

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 143
    const v2, 0x7f0c031b

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 144
    const v2, 0x7f0c031a

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 145
    const v2, 0x7f0c00d9

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 146
    const v2, 0x7f0c031c

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 147
    const v2, 0x7f0c00d5

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 148
    const v2, 0x7f0c0288

    invoke-virtual {v11, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v2, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 149
    if-eqz p3, :cond_20

    if-eqz p4, :cond_20

    .line 150
    sget-object v2, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v2, :cond_c

    .line 151
    sget-object v2, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 153
    :cond_c
    if-eqz p3, :cond_f

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRPrice()Z

    move-result v2

    if-nez v2, :cond_f

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRStrike()Z

    move-result v2

    if-nez v2, :cond_f

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isMapFlag()Z

    move-result v2

    if-nez v2, :cond_f

    .line 154
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getDnmType()Ljava/lang/String;

    move-result-object v2

    const v4, 0x7f08012a

    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 155
    sget-object v2, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 156
    sget-object v2, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v4, "CLEARANCE"

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 158
    :cond_d
    sget-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 159
    const-string v2, "%.2f"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSaveAmt()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 161
    :try_start_0
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSaveAmt()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    cmpl-double v4, v4, v6

    if-lez v4, :cond_e

    .line 162
    const-string v4, "."

    invoke-virtual {v2, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 163
    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 168
    :cond_e
    :goto_2
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 169
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v4, v4, v6

    if-nez v4, :cond_13

    .line 170
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "$"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 174
    :goto_3
    const/4 v4, 0x1

    move/from16 v0, p2

    if-ne v0, v4, :cond_15

    .line 175
    sget-object v4, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "SAVE $"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v2}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 176
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v2, v4, v6

    if-nez v2, :cond_14

    .line 177
    sget-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Reg. $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 189
    :cond_f
    :goto_4
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRPrice()Z

    move-result v2

    if-nez v2, :cond_10

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRStrike()Z

    move-result v2

    if-eqz v2, :cond_11

    .line 190
    :cond_10
    const-string v2, ""

    .line 192
    const/4 v2, 0x1

    move/from16 v0, p2

    if-ne v0, v2, :cond_17

    .line 193
    const-string v2, "See Details \nin Checkout"

    .line 194
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 202
    :goto_5
    sget-object v4, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 203
    sget-object v2, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 204
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isICRStrike()Z

    move-result v2

    if-eqz v2, :cond_11

    .line 205
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 206
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v2, v4, v6

    if-nez v2, :cond_19

    .line 207
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "$"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 210
    :goto_6
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getPaintFlags()I

    move-result v4

    or-int/lit8 v4, v4, 0x10

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPaintFlags(I)V

    .line 213
    :cond_11
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isMapFlag()Z

    move-result v2

    if-eqz v2, :cond_12

    .line 215
    sget-object v2, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 216
    const-string v2, ""

    .line 217
    const/4 v2, 0x1

    move/from16 v0, p2

    if-ne v0, v2, :cond_1a

    .line 218
    const-string v2, "See price \nin cart"

    .line 219
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 227
    :goto_7
    if-eqz p5, :cond_1e

    const/4 v4, 0x1

    move/from16 v0, p2

    if-ne v0, v4, :cond_1e

    .line 228
    sget-object v2, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 229
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 230
    sget-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 231
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v2, v4, v6

    if-nez v2, :cond_1c

    .line 232
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "$"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 238
    :goto_8
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v2, v4, v6

    if-nez v2, :cond_1d

    .line 239
    sget-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Reg. $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 247
    :goto_9
    sget-object v2, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v2, :cond_12

    .line 248
    sget-object v2, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 249
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v2, v4, v6

    if-nez v2, :cond_1f

    .line 250
    sget-object v2, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Reg.Price: $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 470
    :cond_12
    :goto_a
    sget-object v13, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Llp$1;

    move/from16 v4, p3

    move-object/from16 v5, p4

    move/from16 v6, p2

    move-object/from16 v7, p1

    move-object/from16 v8, p6

    move-object/from16 v9, p0

    move/from16 v10, p5

    invoke-direct/range {v2 .. v10}, Llp$1;-><init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ILcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Landroid/app/Activity;Z)V

    invoke-virtual {v13, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 520
    sget-object v2, Llp;->f:Landroid/widget/LinearLayout;

    new-instance v3, Llp$2;

    move-object/from16 v0, p0

    invoke-direct {v3, v12, v0}, Llp$2;-><init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;Landroid/app/Activity;)V

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    move-object v2, v11

    .line 537
    goto/16 :goto_1

    .line 165
    :catch_0
    move-exception v4

    .line 166
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_2

    .line 172
    :cond_13
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "$"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 179
    :cond_14
    sget-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Reg. $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 181
    :cond_15
    sget-object v4, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 182
    sget-object v4, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "SAVE $"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v2}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 183
    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v2, v4, v6

    if-nez v2, :cond_16

    .line 184
    sget-object v2, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "(Reg. $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 186
    :cond_16
    sget-object v2, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "(Reg. $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 195
    :cond_17
    const/4 v2, 0x4

    move/from16 v0, p2

    if-ne v0, v2, :cond_18

    .line 196
    const v2, 0x7f08035c

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 197
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_5

    .line 199
    :cond_18
    const v2, 0x7f0802af

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 200
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_5

    .line 209
    :cond_19
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "$"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_6

    .line 220
    :cond_1a
    const/4 v2, 0x4

    move/from16 v0, p2

    if-ne v0, v2, :cond_1b

    .line 221
    const v2, 0x7f08035c

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 222
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_7

    .line 224
    :cond_1b
    const-string v2, "See Price in Cart"

    .line 225
    sget-object v4, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_7

    .line 235
    :cond_1c
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "$"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_8

    .line 242
    :cond_1d
    sget-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Reg. $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_9

    .line 245
    :cond_1e
    sget-object v4, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_9

    .line 253
    :cond_1f
    sget-object v2, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Reg.Price: $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {p4 .. p4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 258
    :cond_20
    if-eqz v3, :cond_12

    .line 259
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getSavingsAmount()D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    .line 260
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getSavingsAmount()D

    move-result-wide v8

    const-wide/high16 v14, 0x3ff0000000000000L    # 1.0

    cmpl-double v4, v8, v14

    if-lez v4, :cond_51

    .line 261
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getSavingsAmount()D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Math;->round(D)J

    move-result-wide v8

    invoke-virtual {v2, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object v8, v2

    .line 266
    :goto_b
    const/4 v2, 0x1

    move/from16 v0, p2

    if-ne v0, v2, :cond_21

    .line 267
    sget-object v2, Llp;->h:Landroid/widget/ImageView;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 269
    :cond_21
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getRegularPrice()D

    move-result-wide v14

    invoke-virtual {v6, v14, v15}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    .line 270
    const-string v4, ","

    invoke-virtual {v2, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_22

    .line 271
    const-string v4, ","

    const-string v7, "."

    invoke-virtual {v2, v4, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 273
    :cond_22
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getCurrentPrice()D

    move-result-wide v14

    invoke-virtual {v6, v14, v15}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v4

    .line 274
    const-string v7, ","

    invoke-virtual {v4, v7}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_23

    .line 275
    const-string v7, ","

    const-string v9, "."

    invoke-virtual {v4, v7, v9}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    .line 277
    :cond_23
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getMinimumPriceDisplay()D

    move-result-wide v14

    invoke-virtual {v6, v14, v15}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v7

    .line 278
    sget-boolean v6, Llp;->u:Z

    if-nez v6, :cond_24

    sget-boolean v6, Llp;->v:Z

    if-eqz v6, :cond_26

    .line 279
    :cond_24
    const-string v5, ""

    .line 280
    const/4 v6, 0x1

    .line 281
    const/4 v5, 0x1

    move/from16 v0, p2

    if-ne v0, v5, :cond_34

    .line 282
    const-string v5, "See Details \nin checkout"

    .line 283
    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v10, 0x4

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 291
    :goto_c
    sget-object v9, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v9, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 292
    sget-object v5, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v9, 0x0

    invoke-virtual {v5, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 293
    sget-boolean v5, Llp;->v:Z

    if-eqz v5, :cond_25

    .line 294
    sget-object v5, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v9, 0x0

    invoke-virtual {v5, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 295
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getRegularPrice()D

    move-result-wide v14

    const-wide/high16 v16, 0x3ff0000000000000L    # 1.0

    rem-double v14, v14, v16

    const-wide/16 v16, 0x0

    cmpl-double v5, v14, v16

    if-nez v5, :cond_36

    .line 296
    sget-object v5, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "$"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 301
    :goto_d
    sget-object v5, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getPaintFlags()I

    move-result v9

    or-int/lit8 v9, v9, 0x10

    invoke-virtual {v5, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPaintFlags(I)V

    :cond_25
    move v5, v6

    .line 304
    :cond_26
    sget-boolean v6, Llp;->x:Z

    if-eqz v6, :cond_27

    .line 305
    const/4 v6, 0x1

    .line 306
    sget-object v5, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v9, 0x0

    invoke-virtual {v5, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 307
    const-string v5, ""

    .line 308
    const/4 v5, 0x1

    move/from16 v0, p2

    if-ne v0, v5, :cond_37

    .line 309
    const-string v5, "See price \nin cart"

    .line 310
    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v10, 0x4

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 318
    :goto_e
    sget-object v9, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v9, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 319
    sget-object v5, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v5, :cond_3b

    .line 320
    sget-object v5, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v9, 0x0

    invoke-virtual {v5, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 321
    const-string v5, "NaN"

    invoke-virtual {v7, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_39

    .line 322
    sget-object v5, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Reg.Price: $"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {v7}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move v5, v6

    .line 330
    :cond_27
    :goto_f
    sget-boolean v6, Llp;->o:Z

    if-nez v6, :cond_28

    sget-boolean v6, Llp;->i:Z

    if-nez v6, :cond_28

    sget-boolean v6, Llp;->p:Z

    if-eqz v6, :cond_2d

    .line 331
    :cond_28
    const/4 v7, 0x0

    .line 332
    const/4 v6, -0x1

    .line 333
    sget-boolean v9, Llp;->o:Z

    if-eqz v9, :cond_3c

    sget-boolean v9, Llp;->p:Z

    if-eqz v9, :cond_3c

    .line 334
    const v6, 0x7f080064

    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 335
    const v6, 0x7f020110

    .line 343
    :cond_29
    :goto_10
    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "$"

    invoke-virtual {v10, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-static {v4}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v10, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 344
    sget-boolean v9, Llp;->i:Z

    if-eqz v9, :cond_3e

    .line 345
    sget-object v6, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 346
    sget-object v6, Llp;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v7, 0x7f080039

    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 354
    :cond_2a
    :goto_11
    if-eqz v8, :cond_2b

    invoke-virtual {v8}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_2b

    const-string v6, "NaN"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2b

    const-string v6, "NaN"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2b

    const-string v6, "0.00"

    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2b

    const-string v6, "0.00"

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2b

    .line 356
    sget-object v6, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 357
    const/4 v6, 0x1

    move/from16 v0, p2

    if-ne v0, v6, :cond_40

    .line 358
    sget-object v6, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "SAVE $"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v8}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 359
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getRegularPrice()D

    move-result-wide v6

    const-wide/high16 v14, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v6, v14

    const-wide/16 v14, 0x0

    cmpl-double v6, v6, v14

    if-nez v6, :cond_3f

    .line 360
    sget-object v6, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Reg. $"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 377
    :cond_2b
    :goto_12
    const/4 v6, 0x2

    move/from16 v0, p2

    if-ne v0, v6, :cond_2d

    sget-boolean v6, Llp;->q:Z

    if-nez v6, :cond_2c

    sget-boolean v6, Llp;->t:Z

    if-eqz v6, :cond_2d

    .line 378
    :cond_2c
    sget-object v6, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 382
    :cond_2d
    sget-boolean v6, Llp;->q:Z

    if-nez v6, :cond_2e

    sget-boolean v6, Llp;->s:Z

    if-nez v6, :cond_2e

    sget-boolean v6, Llp;->t:Z

    if-eqz v6, :cond_32

    :cond_2e
    sget-boolean v6, Llp;->p:Z

    if-nez v6, :cond_32

    sget-boolean v6, Llp;->o:Z

    if-nez v6, :cond_32

    if-nez v5, :cond_32

    .line 383
    sget-object v5, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 384
    sget-object v5, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "$"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 385
    sget-object v5, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 386
    sget-boolean v5, Llp;->q:Z

    if-eqz v5, :cond_43

    .line 387
    sget-boolean v5, Llp;->o:Z

    if-nez v5, :cond_2f

    sget-boolean v5, Llp;->p:Z

    if-eqz v5, :cond_42

    .line 388
    :cond_2f
    sget-object v5, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 397
    :goto_13
    if-eqz v8, :cond_30

    invoke-virtual {v8}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_30

    const-string v5, "NaN"

    invoke-virtual {v8, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_30

    const-string v5, "NaN"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_30

    .line 398
    const/4 v5, 0x1

    move/from16 v0, p2

    if-ne v0, v5, :cond_46

    .line 399
    sget-object v5, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "SAVE $"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v8}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 400
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getRegularPrice()D

    move-result-wide v6

    const-wide/high16 v14, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v6, v14

    const-wide/16 v14, 0x0

    cmpl-double v5, v6, v14

    if-nez v5, :cond_45

    .line 401
    sget-object v5, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Reg. $"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 417
    :cond_30
    :goto_14
    const/4 v5, 0x2

    move/from16 v0, p2

    if-ne v0, v5, :cond_32

    sget-boolean v5, Llp;->q:Z

    if-nez v5, :cond_31

    sget-boolean v5, Llp;->t:Z

    if-eqz v5, :cond_32

    .line 418
    :cond_31
    sget-object v5, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 421
    :cond_32
    const/4 v5, 0x0

    .line 422
    invoke-virtual/range {p1 .. p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v6

    if-eqz v6, :cond_33

    invoke-virtual/range {p1 .. p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    move-result-object v6

    if-eqz v6, :cond_33

    .line 423
    invoke-virtual/range {p1 .. p1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->getContractCondition()Ljava/lang/String;

    move-result-object v5

    .line 424
    :cond_33
    if-eqz v5, :cond_4f

    .line 425
    sget-object v6, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 426
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->isIbPricing()Z

    move-result v6

    if-eqz v6, :cond_48

    .line 427
    sget-object v6, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "$"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v4}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, "/mo."

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 430
    :goto_15
    const-string v4, ""

    .line 431
    const-string v4, "2_YEARS_NEW"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4a

    .line 432
    const/4 v4, 0x1

    move/from16 v0, p2

    if-ne v0, v4, :cond_49

    .line 433
    const-string v4, "With 2-yr contract"

    .line 446
    :goto_16
    sget-object v5, Llp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v5, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 447
    sget-object v4, Llp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 448
    sget-boolean v4, Llp;->q:Z

    if-eqz v4, :cond_12

    .line 449
    sget-object v4, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 450
    const/4 v4, 0x1

    move/from16 v0, p2

    if-ne v0, v4, :cond_4d

    .line 451
    sget-object v2, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "SAVE $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v8}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 284
    :cond_34
    const/4 v5, 0x4

    move/from16 v0, p2

    if-ne v0, v5, :cond_35

    .line 285
    const v5, 0x7f08035c

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 286
    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_c

    .line 288
    :cond_35
    const v5, 0x7f0802af

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 289
    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_c

    .line 299
    :cond_36
    sget-object v5, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "$"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v5, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_d

    .line 311
    :cond_37
    const/4 v5, 0x4

    move/from16 v0, p2

    if-ne v0, v5, :cond_38

    .line 312
    const v5, 0x7f08035c

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 313
    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_e

    .line 315
    :cond_38
    const-string v5, "See Price in Cart"

    .line 316
    sget-object v9, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_e

    .line 323
    :cond_39
    const-string v5, "NaN"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3a

    .line 324
    sget-object v5, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Reg.Price: $"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v2}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move v5, v6

    goto/16 :goto_f

    .line 326
    :cond_3a
    sget-object v5, Llp;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v7, 0x8

    invoke-virtual {v5, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    :cond_3b
    move v5, v6

    goto/16 :goto_f

    .line 336
    :cond_3c
    sget-boolean v9, Llp;->o:Z

    if-eqz v9, :cond_3d

    .line 337
    const v6, 0x7f080063

    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 338
    const v6, 0x7f020110

    goto/16 :goto_10

    .line 339
    :cond_3d
    sget-boolean v9, Llp;->p:Z

    if-eqz v9, :cond_29

    .line 340
    const v6, 0x7f080077

    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 341
    const v6, 0x7f020169

    goto/16 :goto_10

    .line 348
    :cond_3e
    const/4 v9, 0x4

    move/from16 v0, p2

    if-eq v0, v9, :cond_2a

    .line 349
    sget-object v9, Llp;->f:Landroid/widget/LinearLayout;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 350
    sget-object v9, Llp;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v9, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 351
    sget-object v7, Llp;->h:Landroid/widget/ImageView;

    invoke-virtual {v7, v6}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_11

    .line 363
    :cond_3f
    sget-object v6, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Reg. $"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_12

    .line 366
    :cond_40
    sget-object v6, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 367
    sget-object v6, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "SAVE $"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v8}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 368
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getRegularPrice()D

    move-result-wide v6

    const-wide/high16 v14, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v6, v14

    const-wide/16 v14, 0x0

    cmpl-double v6, v6, v14

    if-nez v6, :cond_41

    .line 369
    sget-object v6, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "(Reg. $"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v9, ")"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_12

    .line 372
    :cond_41
    sget-object v6, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "(Reg. $"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v9, ")"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_12

    .line 390
    :cond_42
    sget-object v5, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v6, "ON SALE"

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_13

    .line 392
    :cond_43
    sget-boolean v5, Llp;->s:Z

    if-eqz v5, :cond_44

    .line 393
    sget-object v5, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v6, "CLEARANCE"

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_13

    .line 395
    :cond_44
    sget-object v5, Llp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_13

    .line 404
    :cond_45
    sget-object v5, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Reg. $"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_14

    .line 407
    :cond_46
    sget-object v5, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 408
    sget-object v5, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "SAVE $"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v8}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 409
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getRegularPrice()D

    move-result-wide v6

    const-wide/high16 v14, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v6, v14

    const-wide/16 v14, 0x0

    cmpl-double v5, v6, v14

    if-nez v5, :cond_47

    .line 410
    sget-object v5, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "(Reg. $"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ")"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_14

    .line 413
    :cond_47
    sget-object v5, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "(Reg. $"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ")"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_14

    .line 429
    :cond_48
    sget-object v6, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "$"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {v4}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_15

    .line 435
    :cond_49
    const-string v4, "With new 2-year contract"

    goto/16 :goto_16

    .line 437
    :cond_4a
    const-string v4, "2_YEARS_UPGRADE"

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4c

    .line 438
    const/4 v4, 0x1

    move/from16 v0, p2

    if-ne v0, v4, :cond_4b

    .line 439
    const-string v4, "With 2-yr upgrade"

    goto/16 :goto_16

    .line 441
    :cond_4b
    const-string v4, "With 2-year upgrade"

    goto/16 :goto_16

    :cond_4c
    move-object v4, v5

    .line 444
    goto/16 :goto_16

    .line 453
    :cond_4d
    sget-object v4, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 454
    sget-object v4, Llp;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "SAVE $"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v8}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 455
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getRegularPrice()D

    move-result-wide v4

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v4, v6

    const-wide/16 v6, 0x0

    cmpl-double v4, v4, v6

    if-nez v4, :cond_4e

    .line 456
    sget-object v4, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "(Reg. $"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, ")"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 458
    :cond_4e
    sget-object v4, Llp;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "(Reg. $"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, ")"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 462
    :cond_4f
    if-eqz v4, :cond_12

    const-string v2, "NaN"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_12

    .line 463
    invoke-static {v4}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v6

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    rem-double/2addr v6, v8

    const-wide/16 v8, 0x0

    cmpl-double v2, v6, v8

    if-nez v2, :cond_50

    .line 464
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "$"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_a

    .line 466
    :cond_50
    sget-object v2, Llp;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "$"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Llp;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_a

    :cond_51
    move-object v8, v2

    goto/16 :goto_b

    .line 121
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public static a(Landroid/app/Activity;Ljava/util/HashMap;)Landroid/view/View;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    const/16 v7, 0x14

    const/high16 v6, 0x41400000    # 12.0f

    const/high16 v5, 0x41200000    # 10.0f

    const/4 v4, 0x2

    .line 541
    invoke-virtual {p0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 543
    const-string v1, ""

    .line 544
    const v1, 0x7f0300c9

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 545
    const v0, 0x7f0c031e

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v0, Llp;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 546
    const v0, 0x7f0c031f

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v0, Llp;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 547
    const v0, 0x7f0c0320

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sput-object v0, Llp;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 548
    if-eqz p1, :cond_1

    .line 549
    const-string v0, "CurrentPrice"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 550
    sget-object v0, Llp;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v2, "CurrentPrice"

    invoke-virtual {p1, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 552
    :cond_0
    const-string v0, "onSale"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 553
    sget-object v0, Llp;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v2, "ON SALE"

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 557
    :goto_0
    const-string v0, "SavingsAmount"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 558
    const-string v0, "SavingsAmount"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v2, "You Save:"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 559
    const-string v0, "SavingsAmount"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v2, "You Save:"

    const-string v3, "SAVE"

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 560
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-le v2, v7, :cond_3

    .line 561
    sget-object v2, Llp;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 573
    :goto_1
    sget-object v2, Llp;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 576
    :cond_1
    return-object v1

    .line 555
    :cond_2
    sget-object v0, Llp;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0

    .line 563
    :cond_3
    sget-object v2, Llp;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v4, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto :goto_1

    .line 566
    :cond_4
    const-string v0, "SavingsAmount"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 567
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-le v2, v7, :cond_5

    .line 568
    sget-object v2, Llp;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto :goto_1

    .line 570
    :cond_5
    sget-object v2, Llp;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v4, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto :goto_1
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 60
    .line 62
    :try_start_0
    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    .line 63
    const-wide v2, 0x408f400000000000L    # 1000.0

    cmpg-double v2, v0, v2

    if-gez v2, :cond_0

    .line 71
    :goto_0
    return-object p0

    .line 66
    :cond_0
    new-instance v2, Ljava/text/DecimalFormat;

    const-string v3, "###,###,###.##"

    invoke-direct {v2, v3}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 67
    invoke-virtual {v2, v0, v1}, Ljava/text/NumberFormat;->format(D)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    goto :goto_0

    .line 68
    :catch_0
    move-exception v0

    goto :goto_0
.end method
