.class public Les;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/app/Activity;

.field private c:Landroid/view/LayoutInflater;

.field private d:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private e:Ljava/lang/String;

.field private f:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 49
    iput-object p4, p0, Les;->a:Ljava/util/ArrayList;

    .line 50
    iput-object p1, p0, Les;->b:Landroid/app/Activity;

    .line 51
    iput-object p2, p0, Les;->d:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 52
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Les;->c:Landroid/view/LayoutInflater;

    .line 53
    return-void
.end method

.method static synthetic a(Les;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Les;->b:Landroid/app/Activity;

    return-object v0
.end method

.method private b(Ljava/lang/String;)I
    .locals 2

    .prologue
    const v1, 0x7f0b0006

    .line 227
    const-string v0, "Pick up Today"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 228
    iget-object v0, p0, Les;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0007

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    .line 236
    :goto_0
    return v0

    .line 229
    :cond_0
    const-string v0, "Pick up in 3-5 days"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 230
    iget-object v0, p0, Les;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    goto :goto_0

    .line 231
    :cond_1
    const-string v0, "Not available for pickup"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 232
    iget-object v0, p0, Les;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b000d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    goto :goto_0

    .line 233
    :cond_2
    const-string v0, "See details for store pickup"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 234
    iget-object v0, p0, Les;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0002

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    goto :goto_0

    .line 236
    :cond_3
    iget-object v0, p0, Les;->b:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    goto :goto_0
.end method

.method static synthetic b(Les;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Les;->d:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Les;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Les;->e:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 60
    iput-boolean p1, p0, Les;->f:Z

    .line 61
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Les;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 65
    const/4 v0, 0x0

    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 36
    check-cast p1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {p0, p1}, Les;->a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 17

    .prologue
    .line 87
    if-nez p2, :cond_5

    .line 88
    new-instance v3, Let;

    invoke-direct {v3}, Let;-><init>()V

    .line 89
    move-object/from16 v0, p0

    iget-object v2, v0, Les;->c:Landroid/view/LayoutInflater;

    const v4, 0x7f0300bb

    const/4 v5, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v2, v4, v0, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 90
    const v2, 0x7f0c00c9

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v3, Let;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 91
    const v2, 0x7f0c00c8

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v3, Let;->b:Landroid/widget/ImageView;

    .line 92
    const v2, 0x7f0c00cb

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RatingBar;

    iput-object v2, v3, Let;->c:Landroid/widget/RatingBar;

    .line 93
    const v2, 0x7f0c00cc

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v3, Let;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 94
    const v2, 0x7f0c00cd

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Let;->e:Landroid/widget/LinearLayout;

    .line 95
    const v2, 0x7f0c0301

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Let;->f:Landroid/widget/LinearLayout;

    .line 96
    const v2, 0x7f0c0300

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Let;->g:Landroid/widget/LinearLayout;

    .line 97
    const v2, 0x7f0c02ff

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v3, Let;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 98
    const v2, 0x7f0c02fe

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/FrameLayout;

    iput-object v2, v3, Let;->j:Landroid/widget/FrameLayout;

    .line 99
    const v2, 0x7f0c02fa

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, v3, Let;->h:Landroid/widget/LinearLayout;

    .line 100
    const v2, 0x7f0c02fc

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v2, v3, Let;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 101
    const v2, 0x7f0c02fd

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, v3, Let;->l:Landroid/view/View;

    .line 102
    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v9, v3

    .line 106
    :goto_0
    iget-object v2, v9, Let;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 107
    iget-object v2, v9, Let;->f:Landroid/widget/LinearLayout;

    invoke-virtual {v2}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 108
    move-object/from16 v0, p0

    iget-object v2, v0, Les;->a:Ljava/util/ArrayList;

    move/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 109
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v14

    .line 110
    if-eqz v3, :cond_13

    .line 111
    const/4 v13, 0x0

    .line 112
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v15

    .line 113
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v4

    .line 115
    :try_start_0
    move-object/from16 v0, p0

    iget-object v2, v0, Les;->b:Landroid/app/Activity;

    iget-object v5, v9, Let;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v6, 0x3e8

    const v7, 0x7f080024

    invoke-static {v2, v5, v4, v6, v7}, Llt;->a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 121
    :goto_1
    iget-object v2, v9, Let;->c:Landroid/widget/RatingBar;

    const/4 v4, 0x5

    invoke-virtual {v2, v4}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 122
    const/4 v2, 0x0

    .line 123
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 124
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v4

    double-to-float v2, v4

    .line 125
    :cond_0
    iget-object v4, v9, Let;->c:Landroid/widget/RatingBar;

    invoke-virtual {v4, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 126
    const/4 v4, 0x0

    cmpl-float v2, v2, v4

    if-eqz v2, :cond_8

    .line 127
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v2

    .line 128
    const/4 v4, 0x1

    if-ne v2, v4, :cond_6

    .line 129
    iget-object v4, v9, Let;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v5, v0, Les;->b:Landroid/app/Activity;

    const v6, 0x7f0802df

    invoke-virtual {v5, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 138
    :goto_2
    if-eqz v15, :cond_16

    .line 139
    const/4 v12, 0x0

    .line 140
    const-wide/16 v10, 0x0

    .line 141
    iget-object v2, v9, Let;->e:Landroid/widget/LinearLayout;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 142
    move-object/from16 v0, p0

    iget-object v2, v0, Les;->b:Landroid/app/Activity;

    const/4 v4, 0x3

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    const-string v8, ""

    invoke-static/range {v2 .. v8}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v2

    .line 143
    if-eqz v2, :cond_1

    .line 144
    iget-object v4, v9, Let;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 146
    :cond_1
    invoke-virtual {v15}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v2

    .line 147
    if-eqz v2, :cond_b

    .line 148
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;->getMultipleSellers()Ljava/util/ArrayList;

    move-result-object v16

    .line 149
    if-eqz v16, :cond_b

    invoke-virtual/range {v16 .. v16}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_b

    .line 150
    const/4 v2, 0x0

    move v4, v2

    move-wide v6, v10

    move v5, v12

    move v8, v13

    :goto_3
    invoke-virtual/range {v16 .. v16}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v4, v2, :cond_a

    .line 151
    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;

    .line 152
    if-eqz v2, :cond_4

    .line 153
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->getCondition()Ljava/lang/String;

    move-result-object v10

    .line 154
    const-string v11, "openBox"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_4

    .line 155
    if-nez v5, :cond_9

    .line 156
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getCurrentPrice()D

    move-result-wide v6

    .line 162
    :cond_2
    :goto_4
    const/4 v5, 0x1

    .line 163
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v2

    .line 164
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    .line 165
    const-wide/16 v10, 0x0

    cmpl-double v10, v6, v10

    if-eqz v10, :cond_3

    const-string v10, "ICR-noPrice"

    invoke-virtual {v2, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_3

    const-string v10, "ICR-strikeThrough"

    invoke-virtual {v2, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_3

    const-string v10, "MAP"

    invoke-virtual {v2, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-nez v10, :cond_3

    const-string v10, "ICR-hidePrice"

    invoke-virtual {v2, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 166
    :cond_3
    const/4 v8, 0x1

    .line 150
    :cond_4
    add-int/lit8 v2, v4, 0x1

    move v4, v2

    goto :goto_3

    .line 104
    :cond_5
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Let;

    move-object v9, v2

    goto/16 :goto_0

    .line 117
    :catch_0
    move-exception v2

    .line 118
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 119
    iget-object v2, v9, Let;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 130
    :cond_6
    if-nez v2, :cond_7

    .line 131
    iget-object v2, v9, Let;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v0, p0

    iget-object v4, v0, Les;->b:Landroid/app/Activity;

    const v5, 0x7f080394

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 133
    :cond_7
    iget-object v4, v9, Let;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, " "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v5, v0, Les;->b:Landroid/app/Activity;

    const v6, 0x7f0802e0

    invoke-virtual {v5, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 136
    :cond_8
    iget-object v2, v9, Let;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v0, p0

    iget-object v4, v0, Les;->b:Landroid/app/Activity;

    const v5, 0x7f080394

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 158
    :cond_9
    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MultipleSellers;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getCurrentPrice()D

    move-result-wide v10

    .line 159
    cmpl-double v5, v6, v10

    if-lez v5, :cond_2

    move-wide v6, v10

    .line 160
    goto/16 :goto_4

    :cond_a
    move-wide v10, v6

    move v12, v5

    move v13, v8

    .line 173
    :cond_b
    if-eqz v12, :cond_15

    .line 174
    invoke-virtual {v15}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v2

    .line 175
    if-nez v13, :cond_c

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v4

    const-string v5, "ICR-noPrice"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_c

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v4

    const-string v5, "ICR-strikeThrough"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_c

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v4

    const-string v5, "MAP"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_c

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v2

    const-string v4, "ICR-hidePrice"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_14

    .line 176
    :cond_c
    iget-object v2, v9, Let;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v4, "Open-Box Available"

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 180
    :goto_5
    iget-object v2, v9, Let;->j:Landroid/widget/FrameLayout;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 181
    iget-object v2, v9, Let;->l:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 182
    iget-object v2, v9, Let;->j:Landroid/widget/FrameLayout;

    new-instance v4, Les$1;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v3}, Les$1;-><init>(Les;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    invoke-virtual {v2, v4}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 201
    :goto_6
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    move-result-object v2

    if-eqz v2, :cond_d

    move-object/from16 v0, p0

    iget-boolean v2, v0, Les;->f:Z

    if-eqz v2, :cond_d

    .line 202
    iget-object v2, v9, Let;->h:Landroid/widget/LinearLayout;

    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 203
    iget-object v2, v9, Let;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;->getAvailabilityDisplayMessage()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Les;->b(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 204
    iget-object v2, v9, Let;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;->getAvailabilityDisplayMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "<br/>"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Les;->e:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 207
    :cond_d
    const-string v2, ""

    .line 208
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v3

    if-eqz v3, :cond_12

    .line 209
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v3

    if-eqz v3, :cond_e

    .line 210
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 211
    :cond_e
    if-eqz v2, :cond_10

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_f

    move-object/from16 v0, p0

    iget-object v3, v0, Les;->b:Landroid/app/Activity;

    const v4, 0x7f080068

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_10

    .line 212
    :cond_f
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v3

    if-eqz v3, :cond_10

    .line 213
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 215
    :cond_10
    if-eqz v2, :cond_12

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_11

    move-object/from16 v0, p0

    iget-object v3, v0, Les;->b:Landroid/app/Activity;

    const v4, 0x7f080068

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_12

    .line 216
    :cond_11
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v3

    if-eqz v3, :cond_12

    .line 217
    invoke-virtual {v14}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 220
    :cond_12
    iget-object v3, v9, Let;->b:Landroid/widget/ImageView;

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 222
    :cond_13
    return-object p2

    .line 178
    :cond_14
    iget-object v2, v9, Let;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Open-Box from: $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v10, v11}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_5

    .line 194
    :cond_15
    iget-object v2, v9, Let;->j:Landroid/widget/FrameLayout;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 195
    iget-object v2, v9, Let;->l:Landroid/view/View;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_6

    .line 198
    :cond_16
    iget-object v2, v9, Let;->e:Landroid/widget/LinearLayout;

    const/16 v4, 0x8

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_6
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 70
    const/4 v0, 0x2

    return v0
.end method
