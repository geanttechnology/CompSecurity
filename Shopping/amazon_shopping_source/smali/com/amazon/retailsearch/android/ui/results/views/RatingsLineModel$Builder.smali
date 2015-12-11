.class public Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;
.super Ljava/lang/Object;
.source "RatingsLineModel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getStarRating(Lcom/amazon/searchapp/retailsearch/model/Ratings;)I
    .locals 4
    .param p1, "ratings"    # Lcom/amazon/searchapp/retailsearch/model/Ratings;

    .prologue
    .line 138
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Ratings;->getRating()D

    move-result-wide v0

    const-wide/high16 v2, 0x4000000000000000L    # 2.0

    mul-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    long-to-int v0, v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getStarsDrawable(Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "rating"    # I

    .prologue
    .line 149
    packed-switch p2, :pswitch_data_0

    .line 169
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_1:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    :goto_0
    return-object v0

    .line 152
    :pswitch_0
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_5:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 154
    :pswitch_1
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_4_5:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 156
    :pswitch_2
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_4:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 158
    :pswitch_3
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_3_5:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 160
    :pswitch_4
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_3:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 162
    :pswitch_5
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_2_5:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 164
    :pswitch_6
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_2:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 166
    :pswitch_7
    sget v0, Lcom/amazon/retailsearch/R$drawable;->stars_1_5:I

    invoke-virtual {p1, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    goto :goto_0

    .line 149
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_7
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/Ratings;Landroid/content/res/Resources;)Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    .locals 8
    .param p1, "ratings"    # Lcom/amazon/searchapp/retailsearch/model/Ratings;
    .param p2, "resources"    # Landroid/content/res/Resources;

    .prologue
    const/4 v5, 0x0

    .line 102
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    :cond_0
    move-object v1, v5

    .line 127
    :goto_0
    return-object v1

    .line 107
    :cond_1
    new-instance v1, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;-><init>()V

    .line 110
    .local v1, "model":Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;->getStarRating(Lcom/amazon/searchapp/retailsearch/model/Ratings;)I

    move-result v3

    .line 111
    .local v3, "starRating":I
    const/16 v6, 0xa

    if-gt v3, v6, :cond_2

    const/4 v6, 0x2

    if-ge v3, v6, :cond_3

    :cond_2
    move-object v1, v5

    .line 114
    goto :goto_0

    .line 116
    :cond_3
    invoke-direct {p0, p2, v3}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel$Builder;->getStarsDrawable(Landroid/content/res/Resources;I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->setStarsDrawable(Landroid/graphics/drawable/Drawable;)V
    invoke-static {v1, v5}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->access$000(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Landroid/graphics/drawable/Drawable;)V

    .line 119
    sget v5, Lcom/amazon/retailsearch/R$plurals;->access_item_view_review_star:I

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Ratings;->getRating()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-int v6, v6

    invoke-virtual {p2, v5, v6}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v4

    .line 121
    .local v4, "starString":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Ratings;->getRating()D

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 122
    .local v0, "accessibilityText":Ljava/lang/String;
    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->setAccessibilityText(Ljava/lang/String;)V
    invoke-static {v1, v0}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Ljava/lang/String;)V

    .line 124
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Ratings;->getCount()I

    move-result v6

    int-to-long v6, v6

    invoke-static {v6, v7}, Lcom/amazon/retailsearch/android/ui/results/ProductUtil;->formatNumber(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 125
    .local v2, "reviewCountText":Ljava/lang/String;
    # invokes: Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->setReviewCountText(Ljava/lang/String;)V
    invoke-static {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;->access$200(Lcom/amazon/retailsearch/android/ui/results/views/RatingsLineModel;Ljava/lang/String;)V

    goto :goto_0
.end method
