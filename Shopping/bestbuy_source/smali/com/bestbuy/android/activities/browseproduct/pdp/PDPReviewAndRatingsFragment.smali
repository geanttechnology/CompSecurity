.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private c:Landroid/view/View;

.field private g:Landroid/widget/RatingBar;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private k:Landroid/widget/RelativeLayout;

.field private l:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field private m:D

.field private n:I

.field private o:Landroid/widget/LinearLayout;

.field private p:Landroid/widget/LinearLayout;

.field private q:Landroid/widget/RelativeLayout;

.field private r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

.field private s:Landroid/widget/RelativeLayout;

.field private t:Ljava/lang/String;

.field private u:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->m:D

    .line 47
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->n:I

    .line 57
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V
    .locals 2

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 46
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->m:D

    .line 47
    const/4 v0, 0x0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->n:I

    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 61
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->l:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 62
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 64
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 65
    const-string v1, "product"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 66
    const-string v1, "dnmProduct"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 67
    const-string v1, "pdpOverviewResponse"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 68
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->setArguments(Landroid/os/Bundle;)V

    .line 69
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->t:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->u:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;",
            "Landroid/widget/LinearLayout;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v0, -0x2

    const/4 v2, 0x0

    .line 188
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v3, v0, v0}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 189
    const/16 v0, 0xa

    invoke-virtual {v3, v2, v2, v2, v0}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 190
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v4, v0, [Landroid/widget/TextView;

    .line 191
    new-instance v5, Landroid/widget/TextView;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {v5, v0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 192
    const-string v0, "Cons"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 193
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b000d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 198
    :cond_0
    :goto_0
    invoke-virtual {v5, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 199
    const/high16 v0, 0x41f00000    # 30.0f

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTextSize(F)V

    .line 200
    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 201
    const/16 v0, 0xf

    invoke-virtual {v5, v2, v2, v2, v0}, Landroid/widget/TextView;->setPadding(IIII)V

    move v1, v2

    .line 202
    :goto_1
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_4

    .line 204
    new-instance v0, Landroid/widget/TextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    invoke-virtual {v6}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v0, v6}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    aput-object v0, v4, v1

    .line 205
    aget-object v0, v4, v1

    const/high16 v6, 0x41700000    # 15.0f

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setTextSize(F)V

    .line 206
    aget-object v0, v4, v1

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0b0031

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setTextColor(I)V

    .line 207
    aget-object v0, v4, v1

    const v6, 0x7f0201b1

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 208
    aget-object v0, v4, v1

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 209
    aget-object v0, v4, v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setId(I)V

    .line 210
    const-string v0, "Cons"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 211
    aget-object v6, v4, v1

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getFeature()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, " ("

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getNegativeReviewsMentioned()I

    move-result v0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, ")"

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 215
    :cond_1
    :goto_2
    aget-object v0, v4, v1

    new-instance v6, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;

    invoke-direct {v6, p0, p1, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;Ljava/lang/String;Ljava/util/ArrayList;)V

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 238
    aget-object v0, v4, v1

    invoke-virtual {p3, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 202
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_1

    .line 194
    :cond_2
    const-string v0, "Pros"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 195
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0007

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 212
    :cond_3
    const-string v0, "Pros"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 213
    aget-object v6, v4, v1

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getFeature()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, " ("

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getPositiveReviewsMentioned()I

    move-result v0

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, ")"

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 240
    :cond_4
    invoke-virtual {p3, v5, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 241
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 78
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 79
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a:Landroid/app/Activity;

    .line 75
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 82
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-nez v0, :cond_0

    .line 84
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 85
    if-eqz v1, :cond_0

    .line 86
    const-string v0, "BreadCrumb"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->t:Ljava/lang/String;

    .line 87
    const-string v0, "PDPOverviewResponseRoot"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->u:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    .line 89
    const-string v0, "product"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 90
    const-string v0, "dnmProduct"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->l:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 91
    const-string v0, "pdpOverviewResponse"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 94
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    if-nez v0, :cond_7

    .line 99
    const v0, 0x7f0300af

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    const v1, 0x7f0c00cb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RatingBar;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->g:Landroid/widget/RatingBar;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02b8

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0299

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02b9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    const v1, 0x7f0c00fc

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->q:Landroid/widget/RelativeLayout;

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    const v1, 0x7f0c00fa

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->s:Landroid/widget/RelativeLayout;

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->s:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02b6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->k:Landroid/widget/RelativeLayout;

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->g:Landroid/widget/RatingBar;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setNumStars(I)V

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->l:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_5

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->l:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getCustomerRating()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->m:D

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->l:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getNumberOfReviews()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->n:I

    .line 122
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->g:Landroid/widget/RatingBar;

    iget-wide v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->m:D

    double-to-float v1, v2

    invoke-virtual {v0, v1}, Landroid/widget/RatingBar;->setRating(F)V

    .line 123
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->n:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_6

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->n:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a:Landroid/app/Activity;

    const v3, 0x7f0802df

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 128
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-wide v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->m:D

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    .line 131
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 132
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v0

    .line 133
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getPercent0To100()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "% would recommend this product"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 136
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->k:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 157
    :goto_2
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->m:D

    const-wide/16 v2, 0x0

    cmpg-double v0, v0, v2

    if-gtz v0, :cond_2

    .line 158
    invoke-static {p2}, Lll;->a(Landroid/view/View;)V

    .line 161
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    if-eqz v0, :cond_8

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->s:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 163
    const v0, 0x7f0300d4

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 164
    const v0, 0x7f0c034c

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->o:Landroid/widget/LinearLayout;

    .line 165
    const v0, 0x7f0c034d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->p:Landroid/widget/LinearLayout;

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->q:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getBestFeatures()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getBestFeatures()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 169
    const-string v0, "Pros"

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getBestFeatures()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->o:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;)V

    .line 172
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getWorstFeatures()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getWorstFeatures()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_4

    .line 174
    const-string v0, "Cons"

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->r:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getWorstFeatures()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;)V

    .line 180
    :cond_4
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    return-object v0

    .line 113
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCustomerRatings()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;

    move-result-object v0

    .line 115
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 116
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getAverageRating()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;

    move-result-object v1

    .line 117
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->getScore()D

    move-result-wide v2

    iput-wide v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->m:D

    .line 118
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/CustomerRatings;->getTotalCount()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->n:I

    goto/16 :goto_0

    .line 126
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->n:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->a:Landroid/app/Activity;

    const v3, 0x7f0802e0

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 156
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto/16 :goto_2

    .line 177
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewAndRatingsFragment;->s:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_3
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 184
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 185
    return-void
.end method
