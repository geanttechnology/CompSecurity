.class public Ldy;
.super Landroid/support/v4/view/PagerAdapter;
.source "SourceFile"


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

.field private b:Landroid/view/LayoutInflater;

.field private c:Landroid/app/Activity;

.field private d:Landroid/support/v4/app/Fragment;

.field private e:Ljava/lang/String;

.field private f:Z

.field private g:I

.field private h:Ljava/lang/String;

.field private i:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;",
            "Landroid/support/v4/app/Fragment;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 57
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 41
    const-string v0, ""

    iput-object v0, p0, Ldy;->e:Ljava/lang/String;

    .line 43
    const/16 v0, 0xa

    iput v0, p0, Ldy;->g:I

    .line 44
    const-string v0, ""

    iput-object v0, p0, Ldy;->h:Ljava/lang/String;

    .line 58
    iput-object p2, p0, Ldy;->a:Ljava/util/ArrayList;

    .line 59
    iput-object p1, p0, Ldy;->c:Landroid/app/Activity;

    .line 60
    iput-object p3, p0, Ldy;->d:Landroid/support/v4/app/Fragment;

    .line 61
    iput-boolean p4, p0, Ldy;->f:Z

    .line 62
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldy;->b:Landroid/view/LayoutInflater;

    .line 63
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;",
            "Landroid/support/v4/app/Fragment;",
            "Z",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 66
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 41
    const-string v0, ""

    iput-object v0, p0, Ldy;->e:Ljava/lang/String;

    .line 43
    const/16 v0, 0xa

    iput v0, p0, Ldy;->g:I

    .line 44
    const-string v0, ""

    iput-object v0, p0, Ldy;->h:Ljava/lang/String;

    .line 67
    iput-object p2, p0, Ldy;->a:Ljava/util/ArrayList;

    .line 68
    iput-object p1, p0, Ldy;->c:Landroid/app/Activity;

    .line 69
    iput-object p3, p0, Ldy;->d:Landroid/support/v4/app/Fragment;

    .line 70
    iput-boolean p4, p0, Ldy;->f:Z

    .line 71
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldy;->b:Landroid/view/LayoutInflater;

    .line 72
    iput-object p5, p0, Ldy;->e:Ljava/lang/String;

    .line 73
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;ZLjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;",
            "Landroid/support/v4/app/Fragment;",
            "Z",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 77
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 41
    const-string v0, ""

    iput-object v0, p0, Ldy;->e:Ljava/lang/String;

    .line 43
    const/16 v0, 0xa

    iput v0, p0, Ldy;->g:I

    .line 44
    const-string v0, ""

    iput-object v0, p0, Ldy;->h:Ljava/lang/String;

    .line 78
    iput-object p2, p0, Ldy;->a:Ljava/util/ArrayList;

    .line 79
    iput-object p1, p0, Ldy;->c:Landroid/app/Activity;

    .line 80
    iput-object p3, p0, Ldy;->d:Landroid/support/v4/app/Fragment;

    .line 81
    iput-boolean p4, p0, Ldy;->f:Z

    .line 82
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldy;->b:Landroid/view/LayoutInflater;

    .line 83
    iput-object p5, p0, Ldy;->e:Ljava/lang/String;

    .line 84
    iput-object p6, p0, Ldy;->h:Ljava/lang/String;

    .line 85
    return-void
.end method

.method static synthetic a(Ldy;)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Ldy;->d:Landroid/support/v4/app/Fragment;

    return-object v0
.end method

.method static synthetic a(Ldy;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Ldy;->i:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic b(Ldy;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Ldy;->c:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Ldy;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Ldy;->e:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Ldy;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Ldy;->h:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 215
    check-cast p1, Landroid/support/v4/view/ViewPager;

    check-cast p3, Landroid/widget/FrameLayout;

    invoke-virtual {p1, p3}, Landroid/support/v4/view/ViewPager;->removeView(Landroid/view/View;)V

    .line 216
    return-void
.end method

.method public getCount()I
    .locals 2

    .prologue
    .line 220
    iget-object v0, p0, Ldy;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget v1, p0, Ldy;->g:I

    if-ge v0, v1, :cond_0

    .line 221
    iget-object v0, p0, Ldy;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 223
    :goto_0
    return v0

    :cond_0
    iget v0, p0, Ldy;->g:I

    goto :goto_0
.end method

.method public getItemPosition(Ljava/lang/Object;)I
    .locals 1

    .prologue
    .line 236
    const/4 v0, -0x2

    return v0
.end method

.method public getPageWidth(I)F
    .locals 1

    .prologue
    .line 232
    const v0, 0x3f5eb852    # 0.87f

    return v0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 11

    .prologue
    .line 89
    iget-object v0, p0, Ldy;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 90
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v9

    .line 91
    iget-object v0, p0, Ldy;->b:Landroid/view/LayoutInflater;

    const v2, 0x7f0300d7

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v10

    .line 92
    const v0, 0x7f0c00c9

    invoke-virtual {v10, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 93
    const v2, 0x7f0c00c8

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    move-object v7, v2

    check-cast v7, Landroid/widget/ImageView;

    .line 94
    const v2, 0x7f0c00cb

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RatingBar;

    .line 95
    const v3, 0x7f0c00cc

    invoke-virtual {v10, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 96
    const v4, 0x7f0c00cd

    invoke-virtual {v10, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    move-object v8, v4

    check-cast v8, Landroid/widget/LinearLayout;

    .line 97
    invoke-virtual {v8}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 98
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 99
    const/4 v0, 0x5

    invoke-virtual {v2, v0}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 100
    const/4 v0, 0x0

    .line 101
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 102
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v4

    double-to-float v0, v4

    .line 103
    :cond_0
    invoke-virtual {v2, v0}, Landroid/widget/RatingBar;->setRating(F)V

    .line 104
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductType()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_7

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductType()Ljava/lang/String;

    move-result-object v4

    const-string v5, "bundle"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 105
    const/16 v0, 0x8

    invoke-virtual {v2, v0}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 106
    const/16 v0, 0x8

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 125
    :goto_0
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 126
    iget-object v0, p0, Ldy;->c:Landroid/app/Activity;

    const/4 v2, 0x2

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, ""

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 127
    if-eqz v0, :cond_1

    .line 128
    invoke-virtual {v8, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 131
    :cond_1
    const-string v0, ""

    .line 132
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 133
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 134
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 135
    :cond_2
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, p0, Ldy;->c:Landroid/app/Activity;

    const v3, 0x7f080068

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 136
    :cond_3
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 137
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 139
    :cond_4
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    iget-object v2, p0, Ldy;->c:Landroid/app/Activity;

    const v3, 0x7f080068

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 140
    :cond_5
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 141
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 144
    :cond_6
    const/4 v2, 0x1

    invoke-static {v0, v7, v2}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 146
    new-instance v0, Ldy$1;

    invoke-direct {v0, p0, v9, v1}, Ldy$1;-><init>(Ldy;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    invoke-virtual {v10, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 209
    check-cast p1, Landroid/support/v4/view/ViewPager;

    const/4 v0, 0x0

    invoke-virtual {p1, v10, v0}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;I)V

    .line 210
    return-object v10

    .line 108
    :cond_7
    const/4 v2, 0x0

    cmpl-float v0, v0, v2

    if-lez v0, :cond_a

    .line 109
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    .line 110
    const/4 v2, 0x1

    if-ne v0, v2, :cond_8

    .line 111
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v4, p0, Ldy;->c:Landroid/app/Activity;

    const v5, 0x7f0802df

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 115
    :goto_1
    const/16 v2, 0x3e7

    if-le v0, v2, :cond_9

    .line 116
    const/4 v0, 0x2

    const/high16 v2, 0x41200000    # 10.0f

    invoke-virtual {v3, v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto/16 :goto_0

    .line 113
    :cond_8
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v4, p0, Ldy;->c:Landroid/app/Activity;

    const v5, 0x7f0802e0

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 118
    :cond_9
    const/4 v0, 0x2

    const/high16 v2, 0x41300000    # 11.0f

    invoke-virtual {v3, v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto/16 :goto_0

    .line 121
    :cond_a
    const/4 v0, 0x2

    const/high16 v2, 0x41200000    # 10.0f

    invoke-virtual {v3, v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 122
    iget-object v0, p0, Ldy;->c:Landroid/app/Activity;

    const v2, 0x7f080394

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 228
    check-cast p2, Landroid/view/View;

    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
