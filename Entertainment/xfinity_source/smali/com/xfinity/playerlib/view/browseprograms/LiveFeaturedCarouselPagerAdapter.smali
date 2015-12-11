.class public Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "LiveFeaturedCarouselPagerAdapter.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$HalLiveFeaturedContentContainer;


# instance fields
.field private final activity:Landroid/app/Activity;

.field private final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private final imageHeight:I

.field private final imageWidth:I

.field private final inflater:Landroid/view/LayoutInflater;

.field private liveFeaturedContentList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Ljava/util/List;II)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p4, "imageWidth"    # I
    .param p5, "imageHeight"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/xfinity/playerlib/image/CoverArtImageLoader;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;II)V"
        }
    .end annotation

    .prologue
    .line 33
    .local p3, "liveFeaturedContentList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;>;"
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->activity:Landroid/app/Activity;

    .line 36
    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 37
    iput-object p3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->liveFeaturedContentList:Ljava/util/List;

    .line 38
    iput p4, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->imageWidth:I

    .line 39
    iput p5, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->imageHeight:I

    .line 41
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 42
    return-void
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 0
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 105
    check-cast p3, Landroid/view/View;

    .end local p3    # "object":Ljava/lang/Object;
    invoke-virtual {p1, p3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 106
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->liveFeaturedContentList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->liveFeaturedContentList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 114
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 22
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    .line 46
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->liveFeaturedContentList:Ljava/util/List;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    move/from16 v1, p2

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    .line 48
    .local v10, "liveFeaturedContent":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->inflater:Landroid/view/LayoutInflater;

    move-object/from16 v18, v0

    sget v19, Lcom/xfinity/playerlib/R$layout;->carousel_item:I

    const/16 v20, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v19

    move-object/from16 v2, p1

    move/from16 v3, v20

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/view/ViewGroup;

    .line 49
    .local v13, "rootView":Landroid/view/ViewGroup;
    sget v18, Lcom/xfinity/playerlib/R$id;->image:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ImageView;

    .line 50
    .local v9, "image":Landroid/widget/ImageView;
    sget v18, Lcom/xfinity/playerlib/R$id;->title:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/TextView;

    .line 51
    .local v17, "title":Landroid/widget/TextView;
    sget v18, Lcom/xfinity/playerlib/R$id;->time:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/TextView;

    .line 52
    .local v15, "time":Landroid/widget/TextView;
    sget v18, Lcom/xfinity/playerlib/R$id;->subtitle:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 53
    .local v14, "subtitle":Landroid/widget/TextView;
    sget v18, Lcom/xfinity/playerlib/R$id;->description:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 54
    .local v5, "description":Landroid/widget/TextView;
    sget v18, Lcom/xfinity/playerlib/R$id;->gradient:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 56
    .local v7, "gradient":Landroid/view/View;
    invoke-virtual {v9}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v12

    .line 57
    .local v12, "params":Landroid/view/ViewGroup$LayoutParams;
    iget v0, v12, Landroid/view/ViewGroup$LayoutParams;->width:I

    move/from16 v18, v0

    if-gez v18, :cond_0

    .line 58
    new-instance v11, Landroid/util/DisplayMetrics;

    invoke-direct {v11}, Landroid/util/DisplayMetrics;-><init>()V

    .line 59
    .local v11, "metrics":Landroid/util/DisplayMetrics;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->activity:Landroid/app/Activity;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v11}, Landroid/view/Display;->getRealMetrics(Landroid/util/DisplayMetrics;)V

    .line 60
    iget v0, v11, Landroid/util/DisplayMetrics;->widthPixels:I

    move/from16 v18, v0

    div-int/lit8 v18, v18, 0x2

    move/from16 v0, v18

    iput v0, v12, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 63
    iget v0, v12, Landroid/view/ViewGroup$LayoutParams;->height:I

    move/from16 v18, v0

    move/from16 v0, v18

    int-to-double v0, v0

    move-wide/from16 v18, v0

    const-wide/high16 v20, 0x3fe8000000000000L    # 0.75

    div-double v18, v18, v20

    move-wide/from16 v0, v18

    double-to-int v4, v0

    .line 66
    .local v4, "carouselHeight":I
    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    .line 67
    .local v8, "gradientParams":Landroid/view/ViewGroup$LayoutParams;
    int-to-double v0, v4

    move-wide/from16 v18, v0

    const-wide v20, 0x3fe199999999999aL    # 0.55

    mul-double v18, v18, v20

    move-wide/from16 v0, v18

    double-to-int v0, v0

    move/from16 v18, v0

    move/from16 v0, v18

    iput v0, v8, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 70
    .end local v4    # "carouselHeight":I
    .end local v8    # "gradientParams":Landroid/view/ViewGroup$LayoutParams;
    .end local v11    # "metrics":Landroid/util/DisplayMetrics;
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->imageWidth:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->imageHeight:I

    move/from16 v20, v0

    move/from16 v0, v19

    move/from16 v1, v20

    invoke-virtual {v10, v0, v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getExpandedArtworkLink(II)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v0, v1, v9}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 71
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getTitle()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getStartDate()Ljava/util/Date;

    move-result-object v18

    if-eqz v18, :cond_1

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getEndDate()Ljava/util/Date;

    move-result-object v18

    if-eqz v18, :cond_1

    .line 75
    new-instance v6, Ljava/text/SimpleDateFormat;

    const-string v18, "h:mma"

    move-object/from16 v0, v18

    invoke-direct {v6, v0}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 76
    .local v6, "df":Ljava/text/DateFormat;
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getStartDate()Ljava/util/Date;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " - "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getEndDate()Ljava/util/Date;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 81
    .end local v6    # "df":Ljava/text/DateFormat;
    .local v16, "timeText":Ljava/lang/String;
    :goto_0
    const-string v18, "AM"

    const-string v19, "a"

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 82
    const-string v18, "PM"

    const-string v19, "p"

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 83
    invoke-virtual/range {v15 .. v16}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 85
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getSubTitle()Ljava/lang/String;

    move-result-object v18

    if-eqz v18, :cond_2

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getSubTitle()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v18

    if-lez v18, :cond_2

    .line 86
    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 87
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getSubTitle()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    :goto_1
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getDescription()Ljava/lang/String;

    move-result-object v18

    if-eqz v18, :cond_3

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getDescription()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v18

    if-lez v18, :cond_3

    .line 93
    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 94
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getDescription()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 99
    :goto_2
    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 100
    return-object v13

    .line 78
    .end local v16    # "timeText":Ljava/lang/String;
    :cond_1
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getTimeField()Ljava/lang/String;

    move-result-object v16

    .restart local v16    # "timeText":Ljava/lang/String;
    goto :goto_0

    .line 89
    :cond_2
    const/16 v18, 0x8

    move/from16 v0, v18

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 96
    :cond_3
    const/16 v18, 0x8

    move/from16 v0, v18

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "o"    # Ljava/lang/Object;

    .prologue
    .line 119
    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setLiveFeaturedContentList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 124
    .local p1, "liveFeaturedContentList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;->liveFeaturedContentList:Ljava/util/List;

    .line 125
    return-void
.end method
