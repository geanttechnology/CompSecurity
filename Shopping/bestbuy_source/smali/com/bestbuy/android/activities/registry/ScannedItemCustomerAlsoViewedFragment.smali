.class public Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Landroid/view/View;

.field private c:Landroid/view/View;

.field private g:Ljava/lang/String;

.field private h:Lhe;

.field private i:Lhd;

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private k:Landroid/view/View;

.field private l:Landroid/widget/LinearLayout;

.field private m:Landroid/view/LayoutInflater;

.field private n:Z

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:Lcom/bestbuy/android/base/BBYBaseFragment;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    .line 52
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 1

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    .line 65
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->g:Ljava/lang/String;

    .line 66
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->o:Ljava/lang/String;

    .line 67
    iput-object p5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->p:Ljava/lang/String;

    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 69
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->n:Z

    .line 70
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->p:Ljava/lang/String;

    return-object v0
.end method

.method private a(I)V
    .locals 10

    .prologue
    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->m:Landroid/view/LayoutInflater;

    const v1, 0x7f0300d5

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    const v1, 0x7f0c00c9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 162
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    const v2, 0x7f0c00c8

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v7, v1

    check-cast v7, Landroid/widget/ImageView;

    .line 163
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    const v2, 0x7f0c00cb

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RatingBar;

    .line 164
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    const v3, 0x7f0c00cc

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 165
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    const v4, 0x7f0c00cd

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    move-object v8, v3

    check-cast v8, Landroid/widget/LinearLayout;

    .line 167
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    const v4, 0x7f0c034f

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 168
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    const v5, 0x7f0c034e

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 169
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 170
    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setVisibility(I)V

    .line 171
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 172
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v9

    .line 174
    new-instance v6, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;

    invoke-direct {v6, p0, v5}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    invoke-virtual {v3, v6}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 195
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_0

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v5

    const-string v6, "openBox"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    :cond_0
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v5

    if-eqz v5, :cond_2

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 196
    :cond_1
    const/16 v5, 0x8

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setVisibility(I)V

    .line 197
    const/16 v3, 0x8

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 200
    :cond_2
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    invoke-virtual {v3, p1}, Landroid/view/View;->setId(I)V

    .line 201
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 202
    invoke-virtual {v8}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 203
    const/4 v0, 0x5

    invoke-virtual {v1, v0}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 204
    const/4 v0, 0x0

    .line 205
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 206
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v4

    double-to-float v0, v4

    .line 207
    invoke-virtual {v1, v0}, Landroid/widget/RatingBar;->setRating(F)V

    .line 210
    :cond_3
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_a

    .line 211
    const/4 v0, 0x2

    const/high16 v1, 0x41300000    # 11.0f

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 212
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "("

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " reviews)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 219
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    const/4 v2, 0x1

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, ""

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 220
    if-eqz v0, :cond_4

    .line 221
    invoke-virtual {v8, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 222
    :cond_4
    const-string v0, ""

    .line 223
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 224
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 225
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 226
    :cond_5
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_6

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    const v2, 0x7f080068

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 227
    :cond_6
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 228
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 230
    :cond_7
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_8

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    const v2, 0x7f080068

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 231
    :cond_8
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 232
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 235
    :cond_9
    const/4 v1, 0x0

    invoke-static {v0, v7, v1}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->l:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 237
    return-void

    .line 215
    :cond_a
    const/4 v0, 0x2

    const/high16 v1, 0x41200000    # 10.0f

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    const v1, 0x7f08027c

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->o:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x5

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 127
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v0, v2, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    :goto_1
    if-ge v1, v0, :cond_1

    .line 128
    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(I)V

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->k:Landroid/view/View;

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 127
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_0
    move v0, v2

    goto :goto_1

    .line 131
    :cond_1
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    const-string v1, "Item Added"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a(Ljava/lang/String;)V

    .line 242
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    .line 243
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->p:Ljava/lang/String;

    const-string v2, "weddingregistrylists"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 244
    invoke-virtual {v0, v3}, Lnb;->l(Z)V

    .line 248
    :goto_0
    invoke-virtual {v0, v3}, Lnb;->k(Z)V

    .line 249
    return-void

    .line 246
    :cond_0
    invoke-virtual {v0, v3}, Lnb;->j(Z)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 111
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 112
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 75
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    .line 76
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    .line 135
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->j:Ljava/util/ArrayList;

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v3, v0

    check-cast v3, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 141
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const v2, 0x7f0c0362

    const/4 v4, 0x0

    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->m:Landroid/view/LayoutInflater;

    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    if-nez v0, :cond_1

    .line 83
    const v0, 0x7f0300df

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    const v1, 0x7f0c012c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->b:Landroid/view/View;

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0363

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->l:Landroid/widget/LinearLayout;

    .line 87
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->n:Z

    if-nez v0, :cond_0

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "CUSTOMERS ALSO VIEWED"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 89
    new-instance v0, Lhe;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->b:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->g:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Lhe;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->h:Lhe;

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->h:Lhe;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhe;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 100
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    return-object v0

    .line 92
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "CUSTOMERS ALSO BOUGHT"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 93
    new-instance v0, Lhd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->b:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->g:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Lhd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->i:Lhd;

    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->i:Lhd;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 99
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 144
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->h:Lhe;

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->h:Lhe;

    invoke-virtual {v0, v1}, Lhe;->cancel(Z)Z

    .line 148
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->i:Lhd;

    if-eqz v0, :cond_1

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->i:Lhd;

    invoke-virtual {v0, v1}, Lhd;->cancel(Z)Z

    .line 152
    :cond_1
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 115
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 116
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 117
    new-instance v0, Lhe;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->b:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->g:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Lhe;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->h:Lhe;

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->h:Lhe;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhe;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 120
    :cond_0
    return-void
.end method
