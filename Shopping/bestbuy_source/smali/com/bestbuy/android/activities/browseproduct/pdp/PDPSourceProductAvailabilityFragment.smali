.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;
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

.field private G:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

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

.field private w:Leg;

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

    .line 70
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 50
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a:I

    .line 51
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b:I

    .line 52
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->c:I

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->r:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->s:Ljava/util/ArrayList;

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->t:Ljava/util/ArrayList;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    .line 71
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Landroid/support/v4/app/Fragment;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 73
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 50
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a:I

    .line 51
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b:I

    .line 52
    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->c:I

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->r:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->s:Ljava/util/ArrayList;

    .line 55
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->t:Ljava/util/ArrayList;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 75
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    .line 76
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->G:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 77
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->x:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->r:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->s:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->t:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)Leg;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->w:Leg;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v0, 0x0

    .line 155
    if-eqz p1, :cond_b

    .line 156
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    .line 157
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    if-eqz v1, :cond_b

    .line 158
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->k:Landroid/widget/ImageView;

    invoke-static {v1, v2, v0}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 159
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->n:Landroid/widget/RatingBar;

    const/4 v2, 0x5

    invoke-virtual {v1, v2}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 160
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 161
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 162
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->n:Landroid/widget/RatingBar;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    double-to-float v2, v2

    invoke-virtual {v1, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 163
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v1

    .line 164
    if-ne v1, v5, :cond_3

    .line 165
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

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

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    const v4, 0x7f0802df

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 170
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->getNames()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Names;->getShortName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 171
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->getBuyingOptions()Ljava/util/ArrayList;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->p:Ljava/util/ArrayList;

    .line 172
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->p:Ljava/util/ArrayList;

    if-eqz v1, :cond_b

    move v1, v0

    .line 173
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_6

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getCondition()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->q:Ljava/lang/String;

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->q:Ljava/lang/String;

    const-string v2, "new"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->r:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 177
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a:I

    .line 173
    :cond_2
    :goto_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 167
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

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

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    const v4, 0x7f0802e0

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0

    .line 178
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->q:Ljava/lang/String;

    const-string v2, "openBox"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->s:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 180
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b:I

    goto :goto_2

    .line 181
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->q:Ljava/lang/String;

    const-string v2, "refurbished"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->t:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 183
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->c:I

    goto :goto_2

    .line 187
    :cond_6
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->x:Ljava/util/ArrayList;

    .line 188
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a:I

    if-lez v0, :cond_7

    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->x:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Show: New Condition("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 190
    :cond_7
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b:I

    if-lez v0, :cond_8

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->x:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Show: Open-Box Condition("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->b:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 192
    :cond_8
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->c:I

    if-lez v0, :cond_9

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->x:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Show: Refurbished Condition("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->c:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 194
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->x:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v5, :cond_c

    .line 196
    new-instance v0, Landroid/widget/ArrayAdapter;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    const v2, 0x7f03002c

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->x:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 197
    const v1, 0x1090009

    invoke-virtual {v0, v1}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 198
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->u:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 202
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->r:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_d

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->r:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 208
    :cond_a
    :goto_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->w:Leg;

    invoke-virtual {v0}, Leg;->notifyDataSetChanged()V

    .line 212
    :cond_b
    return-void

    .line 200
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->E:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_3

    .line 204
    :cond_d
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_e

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_4

    .line 206
    :cond_e
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_4
.end method

.method public a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 215
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(Z)V

    .line 216
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 217
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 218
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 220
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const-string v1, "Seller Information"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->a(Ljava/lang/String;)V

    .line 222
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->C:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 240
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0082

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->D:Landroid/widget/LinearLayout;

    .line 244
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 245
    :cond_0
    const v0, 0x7f08009e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 246
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->D:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0083

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->D:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 248
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 86
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchVisibility(Landroid/app/Activity;Z)V

    .line 89
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 82
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    .line 83
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 252
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->F:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    if-lt v0, v4, :cond_0

    .line 255
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->G:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V

    .line 257
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    invoke-virtual {v1, v0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 263
    :cond_0
    :goto_0
    return-void

    .line 260
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->o:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->e()Z

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 92
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 93
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    if-nez v0, :cond_1

    .line 107
    const v0, 0x7f0300ab

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0297

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->o:Landroid/widget/RelativeLayout;

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c004a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->A:Landroid/widget/LinearLayout;

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->B:Landroid/view/View;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->B:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c022b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->k:Landroid/widget/ImageView;

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0298

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->F:Landroid/widget/LinearLayout;

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->F:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->F:Landroid/widget/LinearLayout;

    const v1, 0x7f0c00cb

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->n:Landroid/widget/RatingBar;

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->F:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0299

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c029a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c00bd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->E:Landroid/widget/LinearLayout;

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c029b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->u:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c029c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->v:Landroid/widget/ListView;

    .line 121
    new-instance v0, Leg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->i:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->A:Landroid/widget/LinearLayout;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->B:Landroid/view/View;

    const v5, 0x7f03008b

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->y:Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->h:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Leg;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/widget/LinearLayout;Landroid/view/View;ILjava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->w:Leg;

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->v:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->w:Leg;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0080

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->C:Landroid/widget/LinearLayout;

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    const v1, 0x7f0c0082

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->D:Landroid/widget/LinearLayout;

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->g:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V

    .line 131
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->u:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    return-object v0

    .line 129
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->j:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 102
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 103
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 96
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 97
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;->z:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const-string v1, "Product Availability "

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;->a(Ljava/lang/String;)V

    .line 99
    return-void
.end method
