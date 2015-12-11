.class public Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemClickListener;


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/widget/LinearLayout;

.field private c:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private i:Landroid/view/LayoutInflater;

.field private j:Landroid/widget/FrameLayout;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Lcom/bestbuy/android/base/BBYBaseFragment;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    .line 61
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    .line 64
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->k:Ljava/lang/String;

    .line 65
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 52
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    .line 69
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->k:Ljava/lang/String;

    .line 70
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    .line 71
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->m:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 72
    iput-object p4, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    .line 73
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    return-object v0
.end method

.method private a(I)V
    .locals 11

    .prologue
    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->i:Landroid/view/LayoutInflater;

    const v1, 0x7f0300d5

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    const v1, 0x7f0c00c9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 185
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    const v2, 0x7f0c00c8

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v7, v1

    check-cast v7, Landroid/widget/ImageView;

    .line 186
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    const v2, 0x7f0c00cb

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RatingBar;

    .line 187
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    const v3, 0x7f0c00cc

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 188
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    const v4, 0x7f0c00cd

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    move-object v8, v3

    check-cast v8, Landroid/widget/LinearLayout;

    .line 189
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    const v4, 0x7f0c034f

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 190
    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    const v5, 0x7f0c034e

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 191
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 192
    const/4 v5, 0x0

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setVisibility(I)V

    .line 193
    new-instance v5, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;

    invoke-direct {v5, p0, p1}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;-><init>(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;I)V

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 213
    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 214
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v9

    .line 216
    if-eqz v9, :cond_2

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_0

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v6

    const-string v10, "openBox"

    invoke-virtual {v6, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    :cond_0
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v6

    if-eqz v6, :cond_2

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v6

    if-eqz v6, :cond_2

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v5

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 217
    :cond_1
    const/16 v5, 0x8

    invoke-virtual {v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setVisibility(I)V

    .line 218
    const/16 v3, 0x8

    invoke-virtual {v4, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 220
    :cond_2
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    invoke-virtual {v3, p1}, Landroid/view/View;->setId(I)V

    .line 221
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 222
    invoke-virtual {v8}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 223
    const/4 v0, 0x5

    invoke-virtual {v1, v0}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 224
    const/4 v0, 0x0

    .line 225
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v3

    if-eqz v3, :cond_3

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v3

    if-eqz v3, :cond_3

    .line 226
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v4

    double-to-float v0, v4

    .line 227
    invoke-virtual {v1, v0}, Landroid/widget/RatingBar;->setRating(F)V

    .line 230
    :cond_3
    const/high16 v1, 0x3f800000    # 1.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_a

    .line 231
    const/4 v0, 0x2

    const/high16 v1, 0x41300000    # 11.0f

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 232
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

    .line 238
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

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

    .line 239
    if-eqz v0, :cond_4

    .line 240
    invoke-virtual {v8, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 241
    :cond_4
    const-string v0, ""

    .line 242
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 243
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 244
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 245
    :cond_5
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_6

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    const v2, 0x7f080068

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 246
    :cond_6
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 247
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 249
    :cond_7
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_8

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    const v2, 0x7f080068

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 250
    :cond_8
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 251
    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 254
    :cond_9
    const/4 v1, 0x0

    invoke-static {v0, v7, v1}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 256
    return-void

    .line 235
    :cond_a
    const/4 v0, 0x2

    const/high16 v1, 0x41200000    # 10.0f

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    const v1, 0x7f08027c

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private b(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 166
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 167
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 168
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 169
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 170
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-eq v1, v0, :cond_0

    .line 171
    const/16 v0, 0x2c

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 168
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 175
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->k:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 6
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
    const/4 v3, 0x5

    const/4 v2, 0x0

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 145
    if-eqz p1, :cond_0

    if-eqz p1, :cond_3

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 146
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b()V

    .line 161
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->c:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->c:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 163
    :cond_2
    return-void

    .line 148
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    move v1, v2

    .line 150
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v0, v3, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    :goto_2
    if-ge v1, v0, :cond_5

    .line 151
    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(I)V

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->g:Landroid/view/View;

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 150
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_4
    move v0, v3

    goto :goto_2

    .line 155
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    const-string v1, "weddingregistrylists"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v3, "wishlistloadrecentlyviewed"

    const-string v4, "LE"

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v5

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v3, v4, v5, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_0

    .line 157
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    const-string v1, "weddingregistrylists"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v3, "registryloadrecentlyviewed"

    const-string v4, "WR"

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v5

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v3, v4, v5, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 141
    :cond_0
    return-void
.end method

.method public c()V
    .locals 3

    .prologue
    .line 304
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    .line 305
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 306
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;

    if-eqz v1, :cond_1

    .line 307
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lnb;->k(Z)V

    .line 308
    check-cast v0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;

    const-string v1, "Item Added"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;->a(Ljava/lang/String;)V

    .line 319
    :cond_0
    :goto_0
    return-void

    .line 309
    :cond_1
    if-eqz v0, :cond_2

    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    if-eqz v1, :cond_2

    .line 310
    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b()V

    goto :goto_0

    .line 311
    :cond_2
    if-eqz v0, :cond_0

    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v1, :cond_0

    .line 312
    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->c()V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 100
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 101
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 82
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    .line 83
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const/4 v4, 0x1

    .line 115
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    .line 117
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 119
    const-string v0, "sku"

    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 120
    const-string v0, "productId"

    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;

    if-eqz v0, :cond_1

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;

    const/4 v2, -0x1

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->setResult(ILandroid/content/Intent;)V

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;->finish()V

    .line 135
    :cond_0
    :goto_0
    return-void

    .line 124
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_0

    .line 125
    const-string v6, ""

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    const-string v1, "weddingregistrylists"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 127
    const-string v6, "Life Events - WishList"

    .line 131
    :cond_2
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v7}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    move v5, v4

    invoke-virtual/range {v0 .. v7}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_0

    .line 128
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    const-string v1, "weddingregistrylists"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 129
    const-string v6, "Life Events - WeddingRegistry"

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 77
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->i:Landroid/view/LayoutInflater;

    .line 88
    const v0, 0x7f0300df

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    const v1, 0x7f0c0065

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->c:Landroid/view/View;

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    const v1, 0x7f0c0363

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b:Landroid/widget/LinearLayout;

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->j:Landroid/widget/FrameLayout;

    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->j:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v3}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 93
    new-instance v0, Lhl;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->c:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Lhl;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 94
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhl;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a:Landroid/view/View;

    return-object v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 262
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v2

    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->h:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 264
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getUrl()Ljava/lang/String;

    move-result-object v3

    .line 265
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    const-string v4, "weddingregistrylists"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 266
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v4, "wishlistclickrecentlyviewed"

    const-string v5, "LE"

    invoke-virtual {v1, v4, v5, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    .line 270
    :cond_0
    :goto_0
    if-eqz v3, :cond_1

    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_1

    .line 271
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>()V

    .line 272
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 273
    const-string v4, "mDotURL"

    invoke-virtual {v1, v4, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 275
    const v1, 0x7f0c0033

    const-string v3, "MdotWebFragment"

    invoke-virtual {v2, v1, v0, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 276
    const/4 v0, 0x0

    invoke-virtual {v2, v0}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 277
    invoke-virtual {v2}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 279
    :cond_1
    return-void

    .line 267
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->l:Ljava/lang/String;

    const-string v4, "weddingregistrylists"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 268
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    check-cast v1, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v4, "registryclickrecentlyviewed"

    const-string v5, "WR"

    invoke-virtual {v1, v4, v5, v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->sendRecommendations(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 110
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 111
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 105
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 106
    return-void
.end method
