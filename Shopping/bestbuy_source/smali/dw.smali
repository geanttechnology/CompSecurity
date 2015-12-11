.class public Ldw;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
        ">;"
    }
.end annotation


# instance fields
.field private a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/app/Activity;

.field private c:Landroid/view/LayoutInflater;

.field private d:Ljava/util/HashMap;
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

.field private e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private f:Lcom/bestbuy/android/base/BBYBaseFragment;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "I",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 42
    iput-object p4, p0, Ldw;->a:Ljava/util/List;

    .line 43
    iput-object p1, p0, Ldw;->b:Landroid/app/Activity;

    .line 44
    iput-object p2, p0, Ldw;->f:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 45
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Ldw;->c:Landroid/view/LayoutInflater;

    .line 46
    return-void
.end method

.method static synthetic a(Ldw;)Ljava/util/List;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    return-object v0
.end method

.method static synthetic b(Ldw;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Ldw;->b:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Ldw;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Ldw;->f:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItemViewType(I)I
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Product"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9

    .prologue
    .line 66
    iget-object v0, p0, Ldw;->c:Landroid/view/LayoutInflater;

    const v1, 0x7f0300bb

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 67
    new-instance v8, Ldx;

    invoke-direct {v8}, Ldx;-><init>()V

    .line 68
    const v0, 0x7f0c00c9

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v8, Ldx;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 69
    const v0, 0x7f0c00c8

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v8, Ldx;->b:Landroid/widget/ImageView;

    .line 70
    const v0, 0x7f0c00cb

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    .line 71
    const v0, 0x7f0c00cc

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 72
    const v0, 0x7f0c00cd

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v8, Ldx;->e:Landroid/widget/LinearLayout;

    .line 75
    iget-object v0, v8, Ldx;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 76
    new-instance v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;-><init>()V

    iput-object v0, p0, Ldw;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 78
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    if-eqz v0, :cond_4

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4

    .line 79
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "customOffer"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 80
    iget-object v1, v8, Ldx;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 81
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ldw;->d:Ljava/util/HashMap;

    .line 82
    iget-object v1, p0, Ldw;->d:Ljava/util/HashMap;

    const-string v2, "CurrentPrice"

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/Price;->getCurrentPrice()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    iget-object v1, p0, Ldw;->d:Ljava/util/HashMap;

    const-string v2, "onSale"

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/Price;->isOnSale()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    iget-object v1, p0, Ldw;->d:Ljava/util/HashMap;

    const-string v2, "SavingsAmount"

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getPrice()Lcom/bestbuy/android/api/lib/models/home/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/Price;->getSavingsAmount()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    iget-object v0, p0, Ldw;->b:Landroid/app/Activity;

    iget-object v1, p0, Ldw;->d:Ljava/util/HashMap;

    invoke-static {v0, v1}, Llp;->a(Landroid/app/Activity;Ljava/util/HashMap;)Landroid/view/View;

    move-result-object v0

    .line 86
    if-eqz v0, :cond_0

    .line 87
    iget-object v1, v8, Ldx;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 89
    :cond_0
    const-string v1, ""

    .line 90
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferImage()Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 91
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferImage()Lcom/bestbuy/android/api/lib/models/home/OfferImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/OfferImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 93
    :goto_0
    iget-object v1, v8, Ldx;->b:Landroid/widget/ImageView;

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 96
    iget-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 97
    iget-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 128
    :cond_1
    :goto_1
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_2

    .line 130
    iget-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 131
    iget-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 132
    iget-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 133
    iget-object v1, v8, Ldx;->c:Landroid/widget/RatingBar;

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    double-to-float v0, v2

    invoke-virtual {v1, v0}, Landroid/widget/RatingBar;->setRating(F)V

    .line 134
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    .line 135
    const/4 v1, 0x1

    if-ne v0, v1, :cond_9

    .line 136
    iget-object v1, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Ldw;->b:Landroid/app/Activity;

    const v3, 0x7f0802df

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 137
    iget-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 142
    :goto_2
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    const/16 v1, 0x3e7

    if-le v0, v1, :cond_a

    .line 143
    iget-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x2

    const/high16 v2, 0x41200000    # 10.0f

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 147
    :cond_2
    :goto_3
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    .line 148
    if-eqz v0, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_4

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ldw;->b:Landroid/app/Activity;

    const v2, 0x7f08002e

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareToIgnoreCase(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_4

    .line 150
    const v0, 0x7f0c0350

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 151
    if-eqz v0, :cond_3

    .line 152
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 153
    new-instance v1, Ldw$1;

    invoke-direct {v1, p0, p1}, Ldw$1;-><init>(Ldw;I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 160
    :cond_3
    const v0, 0x7f0c0351

    invoke-virtual {v7, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 161
    if-eqz v0, :cond_4

    .line 162
    iget-object v1, p0, Ldw;->b:Landroid/app/Activity;

    const v2, 0x7f080328

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 167
    :cond_4
    new-instance v0, Ldw$2;

    invoke-direct {v0, p0, p1}, Ldw$2;-><init>(Ldw;I)V

    invoke-virtual {v7, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 179
    return-object v7

    .line 99
    :cond_5
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getOfferType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "product"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 100
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    .line 101
    iget-object v0, p0, Ldw;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 102
    iget-object v2, p0, Ldw;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V

    .line 103
    iget-object v2, v8, Ldx;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 104
    if-eqz v1, :cond_6

    .line 105
    iget-object v0, p0, Ldw;->b:Landroid/app/Activity;

    iget-object v1, p0, Ldw;->e:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    const/4 v2, 0x3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, ""

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 106
    if-eqz v0, :cond_6

    .line 107
    iget-object v1, v8, Ldx;->e:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 111
    :cond_6
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 112
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 113
    iget-object v1, v8, Ldx;->b:Landroid/widget/ImageView;

    const/4 v2, 0x1

    invoke-static {v0, v1, v2}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    .line 115
    :cond_7
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bundle"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 116
    iget-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setVisibility(I)V

    .line 117
    iget-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 119
    :cond_8
    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ldw;->a:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpl-double v0, v0, v2

    if-nez v0, :cond_1

    .line 121
    iget-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setRating(F)V

    .line 122
    iget-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x2

    const/high16 v2, 0x41300000    # 11.0f

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 123
    iget-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Ldw;->b:Landroid/app/Activity;

    const v2, 0x7f080394

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 139
    :cond_9
    iget-object v1, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Ldw;->b:Landroid/app/Activity;

    const v3, 0x7f0802e0

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 140
    iget-object v0, v8, Ldx;->c:Landroid/widget/RatingBar;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setNumStars(I)V

    goto/16 :goto_2

    .line 145
    :cond_a
    iget-object v0, v8, Ldx;->d:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v1, 0x2

    const/high16 v2, 0x41300000    # 11.0f

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    goto/16 :goto_3

    :cond_b
    move-object v0, v1

    goto/16 :goto_0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 60
    const/4 v0, 0x2

    return v0
.end method
