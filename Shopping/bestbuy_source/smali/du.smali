.class public Ldu;
.super Landroid/support/v4/view/PagerAdapter;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/view/LayoutInflater;

.field private c:Landroid/app/Activity;

.field private d:Lcom/bestbuy/android/activities/home/DODHomeCard;

.field private e:Z

.field private f:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private g:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ljava/util/List;Lcom/bestbuy/android/activities/home/DODHomeCard;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;",
            ">;",
            "Lcom/bestbuy/android/activities/home/DODHomeCard;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 49
    iput-object p2, p0, Ldu;->a:Ljava/util/List;

    .line 50
    iput-object p1, p0, Ldu;->c:Landroid/app/Activity;

    .line 51
    iput-object p3, p0, Ldu;->d:Lcom/bestbuy/android/activities/home/DODHomeCard;

    .line 52
    iput-boolean p4, p0, Ldu;->e:Z

    .line 53
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldu;->b:Landroid/view/LayoutInflater;

    .line 54
    return-void
.end method

.method static synthetic a(Ldu;)Ljava/util/List;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    return-object v0
.end method

.method static synthetic b(Ldu;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Ldu;->c:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Ldu;)Z
    .locals 1

    .prologue
    .line 35
    iget-boolean v0, p0, Ldu;->e:Z

    return v0
.end method

.method static synthetic d(Ldu;)Lcom/bestbuy/android/activities/home/DODHomeCard;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Ldu;->d:Lcom/bestbuy/android/activities/home/DODHomeCard;

    return-object v0
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 0

    .prologue
    .line 218
    check-cast p1, Landroid/support/v4/view/ViewPager;

    check-cast p3, Landroid/widget/FrameLayout;

    invoke-virtual {p1, p3}, Landroid/support/v4/view/ViewPager;->removeView(Landroid/view/View;)V

    .line 219
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 223
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getPageWidth(I)F
    .locals 1

    .prologue
    .line 233
    const v0, 0x3f5eb852    # 0.87f

    return v0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 12

    .prologue
    const/4 v11, 0x5

    const/4 v10, 0x1

    const/16 v9, 0x8

    const/4 v2, 0x2

    const/4 v3, 0x0

    .line 59
    iget-object v0, p0, Ldu;->b:Landroid/view/LayoutInflater;

    const v1, 0x7f0300d7

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 60
    new-instance v8, Ldv;

    invoke-direct {v8}, Ldv;-><init>()V

    .line 61
    const v0, 0x7f0c00c9

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v8, Ldv;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 62
    const v0, 0x7f0c00c8

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v8, Ldv;->b:Landroid/widget/ImageView;

    .line 63
    const v0, 0x7f0c00cb

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    .line 64
    const v0, 0x7f0c00cc

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 65
    const v0, 0x7f0c00cd

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v8, Ldv;->e:Landroid/widget/LinearLayout;

    .line 82
    iget-object v0, v8, Ldv;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 83
    new-instance v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;-><init>()V

    iput-object v0, p0, Ldu;->f:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 85
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    if-eqz v0, :cond_3

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 86
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "customOffer"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 87
    iget-object v1, v8, Ldv;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferTitle()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 88
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ldu;->g:Ljava/util/HashMap;

    .line 90
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 91
    iget-object v1, p0, Ldu;->g:Ljava/util/HashMap;

    const-string v4, "CurrentPrice"

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/Price;->getCurrentPrice()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    iget-object v1, p0, Ldu;->g:Ljava/util/HashMap;

    const-string v4, "onSale"

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/Price;->isOnSale()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v1, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    iget-object v1, p0, Ldu;->g:Ljava/util/HashMap;

    const-string v4, "SavingsAmount"

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/Price;->getSavingsAmount()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    iget-object v0, p0, Ldu;->c:Landroid/app/Activity;

    iget-object v1, p0, Ldu;->g:Ljava/util/HashMap;

    invoke-static {v0, v1}, Llp;->a(Landroid/app/Activity;Ljava/util/HashMap;)Landroid/view/View;

    move-result-object v0

    .line 95
    if-eqz v0, :cond_0

    .line 96
    iget-object v1, v8, Ldv;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 100
    :cond_0
    const-string v1, ""

    .line 101
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferImage()Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 102
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferImage()Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 104
    :goto_0
    iget-object v1, v8, Ldv;->b:Landroid/widget/ImageView;

    invoke-static {v0, v1, v10}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 107
    iget-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    invoke-virtual {v0, v9}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 108
    iget-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 142
    :cond_1
    :goto_1
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v0

    const-wide/16 v4, 0x0

    cmpl-double v0, v0, v4

    if-eqz v0, :cond_2

    .line 144
    iget-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    invoke-virtual {v0, v3}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 145
    iget-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 146
    iget-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    invoke-virtual {v0, v11}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 147
    iget-object v1, v8, Ldv;->c:Landroid/widget/RatingBar;

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v4

    double-to-float v0, v4

    invoke-virtual {v1, v0}, Landroid/widget/RatingBar;->setRating(F)V

    .line 148
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    .line 149
    if-ne v0, v10, :cond_9

    .line 150
    iget-object v1, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, p0, Ldu;->c:Landroid/app/Activity;

    const v5, 0x7f0802df

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 151
    iget-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    invoke-virtual {v0, v11}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 156
    :goto_2
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    const/16 v1, 0x3e7

    if-le v0, v1, :cond_a

    .line 157
    iget-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v1, 0x41200000    # 10.0f

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 161
    :cond_2
    :goto_3
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    .line 162
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ldu;->d:Lcom/bestbuy/android/activities/home/DODHomeCard;

    const v2, 0x7f08002e

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/home/DODHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_3

    .line 164
    const v0, 0x7f0c0350

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 165
    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 166
    new-instance v1, Ldu$1;

    invoke-direct {v1, p0, p2}, Ldu$1;-><init>(Ldu;I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 172
    const v0, 0x7f0c0351

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 173
    iget-object v1, p0, Ldu;->c:Landroid/app/Activity;

    const v2, 0x7f080328

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 177
    :cond_3
    new-instance v0, Ldu$2;

    invoke-direct {v0, p0, p2}, Ldu$2;-><init>(Ldu;I)V

    invoke-virtual {v7, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    check-cast p1, Landroid/support/v4/view/ViewPager;

    invoke-virtual {p1, v7, v3}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;I)V

    .line 213
    return-object v7

    .line 110
    :cond_4
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "product"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 111
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    .line 112
    iget-object v0, p0, Ldu;->f:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 113
    iget-object v4, p0, Ldu;->f:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V

    .line 114
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 115
    iget-object v4, v8, Ldv;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 116
    :cond_5
    if-eqz v1, :cond_6

    .line 117
    iget-object v0, p0, Ldu;->c:Landroid/app/Activity;

    iget-object v1, p0, Ldu;->f:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    const/4 v4, 0x0

    const-string v6, ""

    move v5, v3

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 118
    if-eqz v0, :cond_6

    .line 119
    iget-object v1, v8, Ldv;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 123
    :cond_6
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 125
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 126
    iget-object v1, v8, Ldv;->b:Landroid/widget/ImageView;

    invoke-static {v0, v1, v10}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 128
    :cond_7
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    if-eqz v0, :cond_8

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_8

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bundle"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 130
    iget-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    invoke-virtual {v0, v9}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 131
    iget-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 133
    :cond_8
    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldu;->a:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v0

    const-wide/16 v4, 0x0

    cmpl-double v0, v0, v4

    if-nez v0, :cond_1

    .line 135
    iget-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setRating(F)V

    .line 136
    iget-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v1, 0x41300000    # 11.0f

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 137
    iget-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Ldu;->c:Landroid/app/Activity;

    const v4, 0x7f080394

    invoke-virtual {v1, v4}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 153
    :cond_9
    iget-object v1, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v4, p0, Ldu;->c:Landroid/app/Activity;

    const v5, 0x7f0802e0

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 154
    iget-object v0, v8, Ldv;->c:Landroid/widget/RatingBar;

    invoke-virtual {v0, v11}, Landroid/widget/RatingBar;->setNumStars(I)V

    goto/16 :goto_2

    .line 159
    :cond_a
    iget-object v0, v8, Ldv;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v1, 0x41300000    # 11.0f

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto/16 :goto_3

    :cond_b
    move-object v0, v1

    goto/16 :goto_0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1

    .prologue
    .line 229
    check-cast p2, Landroid/view/View;

    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
