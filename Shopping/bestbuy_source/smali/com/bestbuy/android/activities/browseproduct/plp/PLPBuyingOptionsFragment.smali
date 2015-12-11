.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private A:Landroid/widget/LinearLayout;

.field private B:Landroid/view/View;

.field private C:Landroid/widget/LinearLayout;

.field private D:Landroid/widget/LinearLayout;

.field private E:Landroid/widget/LinearLayout;

.field private F:Landroid/widget/LinearLayout;

.field private G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field public a:I

.field public b:I

.field public c:I

.field private g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

.field private h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private i:Landroid/app/Activity;

.field private j:Landroid/view/View;

.field private k:Landroid/widget/ImageView;

.field private l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private n:Landroid/widget/RatingBar;

.field private o:Landroid/widget/RelativeLayout;

.field private p:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private q:Ljava/lang/String;

.field private r:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private s:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private t:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private u:Lcom/bestbuy/android/activities/stores/DialogSpinner;

.field private v:Landroid/widget/ListView;

.field private w:Leq;

.field private x:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private y:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 75
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a:I

    .line 56
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b:I

    .line 57
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->c:I

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->r:Ljava/util/ArrayList;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->s:Ljava/util/ArrayList;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->t:Ljava/util/ArrayList;

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    .line 76
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 78
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a:I

    .line 56
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b:I

    .line 57
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->c:I

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->r:Ljava/util/ArrayList;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->s:Ljava/util/ArrayList;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->t:Ljava/util/ArrayList;

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 80
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->x:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->r:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->s:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->t:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)Leq;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->w:Leq;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V
    .locals 8

    .prologue
    const v7, 0x7f0802e0

    const v6, 0x7f0802df

    const/4 v3, 0x5

    const/4 v5, 0x1

    const/4 v0, 0x0

    .line 165
    if-eqz p1, :cond_f

    .line 166
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    .line 167
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    if-eqz v1, :cond_f

    .line 168
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v1, :cond_4

    .line 169
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->k:Landroid/widget/ImageView;

    invoke-static {v1, v2, v0}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 170
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->n:Landroid/widget/RatingBar;

    invoke-virtual {v1, v3}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 171
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 172
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 173
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->n:Landroid/widget/RatingBar;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    double-to-float v2, v2

    invoke-virtual {v1, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 174
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v1

    .line 175
    if-ne v1, v5, :cond_3

    .line 176
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    invoke-virtual {v3, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 196
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->getNames()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;->getShortName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 197
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->getBuyingOptions()Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->p:Ljava/util/ArrayList;

    .line 198
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->p:Ljava/util/ArrayList;

    if-eqz v1, :cond_f

    move v1, v0

    .line 199
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_a

    .line 200
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getCondition()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->q:Ljava/lang/String;

    .line 201
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->q:Ljava/lang/String;

    const-string v2, "new"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 202
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->r:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 203
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a:I

    .line 199
    :cond_2
    :goto_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 178
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    invoke-virtual {v3, v7}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0

    .line 181
    :cond_4
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 182
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 183
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->k:Landroid/widget/ImageView;

    invoke-static {v1, v2, v0}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 184
    :cond_5
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->n:Landroid/widget/RatingBar;

    invoke-virtual {v1, v3}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 185
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v1

    if-eqz v1, :cond_6

    .line 186
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->n:Landroid/widget/RatingBar;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    double-to-float v2, v2

    invoke-virtual {v1, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 188
    :cond_6
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    if-eqz v1, :cond_13

    .line 189
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v1

    .line 190
    :goto_3
    if-ne v1, v5, :cond_7

    .line 191
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    invoke-virtual {v3, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 193
    :cond_7
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    invoke-virtual {v3, v7}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 204
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->q:Ljava/lang/String;

    const-string v2, "openBox"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->s:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 206
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b:I

    goto/16 :goto_2

    .line 207
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->q:Ljava/lang/String;

    const-string v2, "refurbished"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->t:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 209
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->c:I

    goto/16 :goto_2

    .line 213
    :cond_a
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->x:Ljava/util/ArrayList;

    .line 214
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b:I

    if-lez v0, :cond_b

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->x:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Show: Open-Box Condition("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->b:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 216
    :cond_b
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a:I

    if-lez v0, :cond_c

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->x:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Show: New Condition("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 218
    :cond_c
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->c:I

    if-lez v0, :cond_d

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->x:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Show: Refurbished Condition("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->c:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 220
    :cond_d
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->x:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v5, :cond_10

    .line 222
    new-instance v0, Landroid/widget/ArrayAdapter;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    const v2, 0x7f03002c

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->x:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 223
    const v1, 0x1090009

    invoke-virtual {v0, v1}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 224
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->u:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 228
    :goto_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_11

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 234
    :cond_e
    :goto_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->w:Leq;

    invoke-virtual {v0}, Leq;->notifyDataSetChanged()V

    .line 238
    :cond_f
    return-void

    .line 226
    :cond_10
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->E:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_4

    .line 230
    :cond_11
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->r:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_12

    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->r:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_5

    .line 232
    :cond_12
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_e

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_5

    :cond_13
    move v1, v0

    goto/16 :goto_3
.end method

.method public a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 241
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 242
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 243
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 244
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 246
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const-string v1, "Seller Information"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->a(Ljava/lang/String;)V

    .line 248
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 94
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchVisibility(Landroid/app/Activity;Z)V

    .line 97
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 89
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 90
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    .line 91
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 286
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 100
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 101
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    if-nez v0, :cond_1

    .line 115
    const v0, 0x7f0300ab

    invoke-virtual {p1, v0, p2, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0297

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->o:Landroid/widget/RelativeLayout;

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c004a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->A:Landroid/widget/LinearLayout;

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->B:Landroid/view/View;

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->B:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->setBackgroundColor(I)V

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c022b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->k:Landroid/widget/ImageView;

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0298

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->F:Landroid/widget/LinearLayout;

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->F:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->F:Landroid/widget/LinearLayout;

    const v1, 0x7f0c00cb

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->n:Landroid/widget/RatingBar;

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->F:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0299

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c029a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c00bd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->E:Landroid/widget/LinearLayout;

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c029b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->u:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c029c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->v:Landroid/widget/ListView;

    .line 129
    new-instance v0, Leq;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->A:Landroid/widget/LinearLayout;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->B:Landroid/view/View;

    const v5, 0x7f03008b

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->y:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v7

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Leq;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/widget/LinearLayout;Landroid/view/View;ILjava/util/ArrayList;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->w:Leq;

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->v:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->w:Leq;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0080

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->C:Landroid/widget/LinearLayout;

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0082

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->D:Landroid/widget/LinearLayout;

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V

    .line 141
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->u:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 161
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    return-object v0

    .line 137
    :cond_0
    new-instance v0, Lim;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->i:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->B:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->G:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v1, p0, v2, v3}, Lim;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lim;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 139
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->j:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 110
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 111
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 104
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 105
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBuyingOptionsFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const-string v1, "Product Availability "

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->a(Ljava/lang/String;)V

    .line 107
    return-void
.end method
