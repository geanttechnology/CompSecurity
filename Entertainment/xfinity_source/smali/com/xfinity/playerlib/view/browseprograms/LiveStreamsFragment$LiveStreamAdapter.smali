.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;
.source "LiveStreamsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LiveStreamAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
        "Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Landroid/view/LayoutInflater;)V
    .locals 0
    .param p2, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 631
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .line 632
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 633
    return-void
.end method


# virtual methods
.method protected bindItem(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 10
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;
    .param p2, "stream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    const/4 v6, 0x0

    const/4 v9, 0x0

    .line 658
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v4

    .line 659
    .local v4, "title":Ljava/lang/String;
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->placeholderTitle:Landroid/widget/TextView;

    if-eqz v5, :cond_3

    const/4 v2, 0x1

    .line 661
    .local v2, "placeHolderTitleIsPresent":Z
    :goto_0
    if-eqz v2, :cond_0

    .line 662
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 665
    :cond_0
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;

    invoke-direct {v1, p0, v2, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;ZLcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;)V

    .line 677
    .local v1, "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2500(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v5

    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageWidth:I
    invoke-static {v7}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I

    move-result v7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageHeight:I
    invoke-static {v8}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I

    move-result v8

    invoke-virtual {p2, v7, v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getExpandedArtworkLink(II)Ljava/lang/String;

    move-result-object v7

    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v5, v7, v9, v8, v1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v0

    .line 680
    .local v0, "loadedFromMemory":Z
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 683
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v5, v9}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 684
    if-nez v0, :cond_1

    .line 685
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v5, v9}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 695
    :cond_1
    :goto_1
    if-eqz v2, :cond_2

    .line 696
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 699
    :cond_2
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v3

    .line 700
    .local v3, "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1500(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v7

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    new-array v5, v5, [Ljava/lang/String;

    invoke-interface {v3, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Ljava/lang/String;

    invoke-virtual {v7, v5}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 701
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 706
    :goto_2
    return-void

    .end local v0    # "loadedFromMemory":Z
    .end local v1    # "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    .end local v2    # "placeHolderTitleIsPresent":Z
    .end local v3    # "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_3
    move v2, v6

    .line 659
    goto :goto_0

    .line 688
    .restart local v0    # "loadedFromMemory":Z
    .restart local v1    # "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    .restart local v2    # "placeHolderTitleIsPresent":Z
    :cond_4
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v5, v9}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 691
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2500(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v5

    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageWidth:I
    invoke-static {v7}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I

    move-result v7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageHeight:I
    invoke-static {v8}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I

    move-result v8

    invoke-virtual {p2, v7, v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getExpandedArtworkLink(II)Ljava/lang/String;

    move-result-object v7

    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v5, v7, v8, v1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto :goto_1

    .line 703
    .restart local v3    # "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_5
    iget-object v5, p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 630
    check-cast p1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->bindItem(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;
    .locals 2

    .prologue
    .line 637
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;)V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 630
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 710
    sget v0, Lcom/xfinity/playerlib/R$layout;->browse_live_stream_grid_item:I

    return v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

    .prologue
    .line 642
    sget v2, Lcom/xfinity/playerlib/R$id;->program_cover:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/widget/ProgramCover;

    .line 643
    .local v1, "programCover":Lcom/xfinity/playerlib/view/widget/ProgramCover;
    sget v2, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/widget/ProgramCover;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p3, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->coverArt:Landroid/widget/ImageView;

    .line 644
    sget v2, Lcom/xfinity/playerlib/R$id;->placeholder_title:I

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/widget/ProgramCover;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p3, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->placeholderTitle:Landroid/widget/TextView;

    .line 645
    sget v2, Lcom/xfinity/playerlib/R$id;->locked_indicator:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, p3, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    .line 647
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/widget/ProgramCover;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 648
    .local v0, "params":Landroid/view/ViewGroup$LayoutParams;
    iget v2, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 649
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2100(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I

    move-result v2

    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 652
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewHeight:I
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I

    move-result v2

    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 653
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/widget/ProgramCover;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 654
    return-void
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 630
    check-cast p3, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;)V

    return-void
.end method
