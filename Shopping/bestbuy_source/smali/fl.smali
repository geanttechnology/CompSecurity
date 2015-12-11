.class public Lfl;
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

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/content/Context;

.field private d:Landroid/view/LayoutInflater;

.field private e:Lnb;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILjava/util/ArrayList;Ljava/util/ArrayList;Lnb;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;",
            "Lnb;",
            ")V"
        }
    .end annotation

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 41
    iput-object p3, p0, Lfl;->a:Ljava/util/ArrayList;

    .line 42
    iput-object p4, p0, Lfl;->b:Ljava/util/ArrayList;

    .line 43
    iput-object p1, p0, Lfl;->c:Landroid/content/Context;

    .line 44
    iput-object p5, p0, Lfl;->e:Lnb;

    .line 45
    if-eqz p1, :cond_0

    .line 46
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lfl;->d:Landroid/view/LayoutInflater;

    .line 47
    :cond_0
    return-void
.end method

.method static synthetic a(Lfl;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lfl;->c:Landroid/content/Context;

    return-object v0
.end method

.method private a(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 200
    .line 202
    :try_start_0
    invoke-static {p1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    .line 203
    new-instance v1, Ljava/text/DecimalFormat;

    const-string v2, "###,###,###.##"

    invoke-direct {v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 204
    invoke-virtual {v1, v0}, Ljava/text/NumberFormat;->format(Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 208
    :goto_0
    return-object p1

    .line 205
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private a(Landroid/net/Uri;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 195
    new-instance v0, Lkw;

    iget-object v1, p0, Lfl;->c:Landroid/content/Context;

    invoke-direct {v0, v1, p1, p2}, Lkw;-><init>(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)V

    .line 196
    invoke-virtual {v0}, Lkw;->show()V

    .line 197
    return-void
.end method

.method static synthetic a(Lfl;Landroid/net/Uri;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lfl;->a(Landroid/net/Uri;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic b(Lfl;)Lnb;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lfl;->e:Lnb;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lfl;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->indexOf(Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lfl;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 1

    .prologue
    .line 51
    const/4 v0, 0x0

    return v0
.end method

.method public synthetic getPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 30
    check-cast p1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {p0, p1}, Lfl;->a(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12

    .prologue
    const v11, 0x7f0802af

    const v10, 0x7f020134

    const/16 v9, 0x8

    const/4 v8, 0x0

    .line 73
    if-nez p2, :cond_1

    .line 74
    iget-object v0, p0, Lfl;->d:Landroid/view/LayoutInflater;

    const v1, 0x7f030035

    invoke-virtual {v0, v1, p3, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 75
    new-instance v1, Lfm;

    invoke-direct {v1}, Lfm;-><init>()V

    .line 77
    const v0, 0x7f0c00e1

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfm;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 78
    const v0, 0x7f0c00e0

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lfm;->b:Landroid/widget/ImageView;

    .line 79
    const v0, 0x7f0c00d2

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfm;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 80
    const v0, 0x7f0c0024

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfm;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 81
    const v0, 0x7f0c00d8

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfm;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 82
    const v0, 0x7f0c00d9

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfm;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 83
    const v0, 0x7f0c00d4

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 84
    const v0, 0x7f0c00d6

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lfm;->i:Landroid/widget/LinearLayout;

    .line 85
    const v0, 0x7f0c00d5

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v1, Lfm;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 86
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v2, v1

    .line 90
    :goto_0
    new-instance v4, Ljava/text/DecimalFormat;

    const-string v0, "0.00"

    invoke-direct {v4, v0}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 91
    iget-object v0, p0, Lfl;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 92
    iget-object v1, p0, Lfl;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 93
    if-eqz v0, :cond_0

    .line 94
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxCondition()Ljava/lang/String;

    move-result-object v3

    iget-object v5, p0, Lfl;->c:Landroid/content/Context;

    const v6, 0x7f080068

    invoke-virtual {v5, v6}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 95
    iget-object v3, v2, Lfm;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 96
    iget-object v3, v2, Lfm;->b:Landroid/widget/ImageView;

    invoke-virtual {v3, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 100
    :goto_1
    iget-object v3, v2, Lfm;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getStoreName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 101
    iget-object v3, v2, Lfm;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getDistance()D

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " Miles Away"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 102
    iget-object v3, v2, Lfm;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Lfl$1;

    invoke-direct {v5, p0, v1}, Lfl$1;-><init>(Lfl;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;)V

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isMapFlag()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 114
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 115
    iget-object v3, v2, Lfm;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 116
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v4, "See Price in Cart"

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 117
    iget-object v3, v2, Lfm;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 118
    iget-object v3, v2, Lfm;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Reg.Price: $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lfl;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 156
    :goto_2
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Lfl$2;

    invoke-direct {v4, p0, v1, v0}, Lfl$2;-><init>(Lfl;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 185
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getDnmType()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lfl;->c:Landroid/content/Context;

    const v3, 0x7f08012a

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 186
    iget-object v0, v2, Lfm;->b:Landroid/widget/ImageView;

    invoke-virtual {v0, v10}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 191
    :cond_0
    :goto_3
    return-object p2

    .line 88
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lfm;

    move-object v2, v0

    goto/16 :goto_0

    .line 98
    :cond_2
    iget-object v3, v2, Lfm;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxCondition()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " Condition"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 120
    :cond_3
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getIcrMapPriceValue()Ljava/lang/String;

    move-result-object v3

    const-string v5, "1"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 121
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 122
    iget-object v3, v2, Lfm;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 123
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v4, p0, Lfl;->c:Landroid/content/Context;

    invoke-virtual {v4, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_2

    .line 124
    :cond_4
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getIcrMapPriceValue()Ljava/lang/String;

    move-result-object v3

    const-string v5, "2"

    invoke-virtual {v3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 125
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 126
    iget-object v3, v2, Lfm;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "$"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lfl;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 127
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v4, p0, Lfl;->c:Landroid/content/Context;

    invoke-virtual {v4, v11}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 128
    iget-object v3, v2, Lfm;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v4, v2, Lfm;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getPaintFlags()I

    move-result v4

    or-int/lit8 v4, v4, 0x10

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPaintFlags(I)V

    .line 129
    iget-object v3, v2, Lfm;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_2

    .line 131
    :cond_5
    iget-object v3, v2, Lfm;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 132
    iget-object v3, v2, Lfm;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 133
    iget-object v3, v2, Lfm;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v8}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 134
    iget-object v3, v2, Lfm;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v5, v2, Lfm;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getPaintFlags()I

    move-result v5

    and-int/lit8 v5, v5, -0x11

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPaintFlags(I)V

    .line 136
    iget-object v3, v2, Lfm;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "$"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getClearancePrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6}, Lfl;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 137
    const-string v3, "%.2f"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSaveAmt()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v3, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 139
    :try_start_0
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSaveAmt()D

    move-result-wide v6

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    cmpl-double v5, v6, v8

    if-lez v5, :cond_6

    .line 140
    const-string v5, "."

    invoke-virtual {v3, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v3, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 141
    const-string v6, ""

    invoke-virtual {v3, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 146
    :cond_6
    :goto_4
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuPermRegPrice()D

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v3

    .line 147
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSaveAmt()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Math;->round(D)J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 148
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "<span class=\'bold\'>SAVE $"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-direct {p0, v4}, Lfl;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "</span> (Reg. $"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-direct {p0, v3}, Lfl;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 150
    :try_start_1
    iget-object v4, p0, Lfl;->c:Landroid/content/Context;

    iget-object v5, v2, Lfm;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v6, 0x12c

    const/16 v7, 0xd8

    const/16 v8, 0x25

    const/16 v9, 0x26

    invoke-static {v7, v8, v9}, Landroid/graphics/Color;->rgb(III)I

    move-result v7

    invoke-static {v4, v5, v3, v6, v7}, Llt;->a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;II)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_2

    .line 151
    :catch_0
    move-exception v3

    .line 152
    const-string v4, ""

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Error Text: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v3}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4, v3}, Lkf;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 143
    :catch_1
    move-exception v3

    .line 144
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_4

    .line 188
    :cond_7
    iget-object v0, v2, Lfm;->b:Landroid/widget/ImageView;

    invoke-virtual {v0, v10}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_3
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x2

    return v0
.end method
