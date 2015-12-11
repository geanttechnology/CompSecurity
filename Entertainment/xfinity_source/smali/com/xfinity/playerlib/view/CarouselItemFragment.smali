.class public Lcom/xfinity/playerlib/view/CarouselItemFragment;
.super Landroid/app/Fragment;
.source "CarouselItemFragment.java"


# instance fields
.field private final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private imageHeight:I

.field private imageWidth:I

.field private liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 28
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 34
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedIntanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 40
    if-eqz p1, :cond_1

    .line 41
    const-string v1, "content"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    .line 42
    const-string v1, "imageHeight"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageHeight:I

    .line 43
    const-string v1, "imageWidth"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageWidth:I

    .line 53
    :cond_0
    :goto_0
    return-void

    .line 45
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/CarouselItemFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 47
    .local v0, "args":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 48
    const-string v1, "content"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    .line 49
    const-string v1, "imageHeight"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageHeight:I

    .line 50
    const-string v1, "imageWidth"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageWidth:I

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 22
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 64
    sget v17, Lcom/xfinity/playerlib/R$layout;->carousel_item:I

    const/16 v18, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v17

    move-object/from16 v2, p2

    move/from16 v3, v18

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/view/ViewGroup;

    .line 65
    .local v12, "rootView":Landroid/view/ViewGroup;
    sget v17, Lcom/xfinity/playerlib/R$id;->image:I

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ImageView;

    .line 66
    .local v9, "image":Landroid/widget/ImageView;
    sget v17, Lcom/xfinity/playerlib/R$id;->title:I

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v16

    check-cast v16, Landroid/widget/TextView;

    .line 67
    .local v16, "title":Landroid/widget/TextView;
    sget v17, Lcom/xfinity/playerlib/R$id;->time:I

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 68
    .local v14, "time":Landroid/widget/TextView;
    sget v17, Lcom/xfinity/playerlib/R$id;->subtitle:I

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/TextView;

    .line 69
    .local v13, "subtitle":Landroid/widget/TextView;
    sget v17, Lcom/xfinity/playerlib/R$id;->description:I

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 70
    .local v5, "description":Landroid/widget/TextView;
    sget v17, Lcom/xfinity/playerlib/R$id;->gradient:I

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 72
    .local v7, "gradient":Landroid/view/View;
    invoke-virtual {v9}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v11

    .line 73
    .local v11, "params":Landroid/view/ViewGroup$LayoutParams;
    iget v0, v11, Landroid/view/ViewGroup$LayoutParams;->width:I

    move/from16 v17, v0

    if-gez v17, :cond_0

    .line 74
    new-instance v10, Landroid/util/DisplayMetrics;

    invoke-direct {v10}, Landroid/util/DisplayMetrics;-><init>()V

    .line 75
    .local v10, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/CarouselItemFragment;->getActivity()Landroid/app/Activity;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Landroid/view/Display;->getRealMetrics(Landroid/util/DisplayMetrics;)V

    .line 76
    iget v0, v10, Landroid/util/DisplayMetrics;->widthPixels:I

    move/from16 v17, v0

    div-int/lit8 v17, v17, 0x2

    move/from16 v0, v17

    iput v0, v11, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 79
    iget v0, v11, Landroid/view/ViewGroup$LayoutParams;->height:I

    move/from16 v17, v0

    move/from16 v0, v17

    int-to-double v0, v0

    move-wide/from16 v18, v0

    const-wide/high16 v20, 0x3fe8000000000000L    # 0.75

    div-double v18, v18, v20

    move-wide/from16 v0, v18

    double-to-int v4, v0

    .line 82
    .local v4, "carouselHeight":I
    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    .line 83
    .local v8, "gradientParams":Landroid/view/ViewGroup$LayoutParams;
    int-to-double v0, v4

    move-wide/from16 v18, v0

    const-wide v20, 0x3fe199999999999aL    # 0.55

    mul-double v18, v18, v20

    move-wide/from16 v0, v18

    double-to-int v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    iput v0, v8, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 86
    .end local v4    # "carouselHeight":I
    .end local v8    # "gradientParams":Landroid/view/ViewGroup$LayoutParams;
    .end local v10    # "metrics":Landroid/util/DisplayMetrics;
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageWidth:I

    move/from16 v19, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageHeight:I

    move/from16 v20, v0

    invoke-virtual/range {v18 .. v20}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getExpandedArtworkLink(II)Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v9}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 87
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getTitle()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 90
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getStartDate()Ljava/util/Date;

    move-result-object v17

    if-eqz v17, :cond_1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getEndDate()Ljava/util/Date;

    move-result-object v17

    if-eqz v17, :cond_1

    .line 91
    new-instance v6, Ljava/text/SimpleDateFormat;

    const-string v17, "h:mma"

    move-object/from16 v0, v17

    invoke-direct {v6, v0}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 92
    .local v6, "df":Ljava/text/DateFormat;
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getStartDate()Ljava/util/Date;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, " - "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getEndDate()Ljava/util/Date;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    .line 97
    .end local v6    # "df":Ljava/text/DateFormat;
    .local v15, "timeText":Ljava/lang/String;
    :goto_0
    const-string v17, "AM"

    const-string v18, "a"

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v15, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 98
    const-string v17, "PM"

    const-string v18, "p"

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v15, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 99
    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getSubTitle()Ljava/lang/String;

    move-result-object v17

    if-eqz v17, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getSubTitle()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->length()I

    move-result v17

    if-lez v17, :cond_2

    .line 102
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v13, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 103
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getSubTitle()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 108
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getDescription()Ljava/lang/String;

    move-result-object v17

    if-eqz v17, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getDescription()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->length()I

    move-result v17

    if-lez v17, :cond_3

    .line 109
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 110
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getDescription()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 115
    :goto_2
    return-object v12

    .line 94
    .end local v15    # "timeText":Ljava/lang/String;
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;->getTimeField()Ljava/lang/String;

    move-result-object v15

    .restart local v15    # "timeText":Ljava/lang/String;
    goto/16 :goto_0

    .line 105
    :cond_2
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v13, v0}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 112
    :cond_3
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 57
    const-string v0, "imageWidth"

    iget v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageWidth:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 58
    const-string v0, "imageHeight"

    iget v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->imageHeight:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 59
    const-string v0, "content"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/CarouselItemFragment;->liveFeaturedContent:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 60
    return-void
.end method
