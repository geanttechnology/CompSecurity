.class Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;
.source "PlayNowBrowseProgramsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ProgramAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
        "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Landroid/view/LayoutInflater;)V
    .locals 0
    .param p2, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 489
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .line 490
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 491
    return-void
.end method


# virtual methods
.method protected bindItem(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 13
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    const/4 v0, 0x1

    const/4 v11, 0x0

    const/16 v12, 0x8

    const/4 v7, 0x0

    .line 513
    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v8}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$400(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lorg/slf4j/Logger;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Binding for: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v8, v9}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 514
    const/4 v2, 0x0

    .line 516
    .local v2, "network":Lcom/xfinity/playerlib/model/tags/Network;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v6

    .line 517
    .local v6, "title":Ljava/lang/String;
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->title:Landroid/widget/TextView;

    if-eqz v8, :cond_0

    .line 518
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {v8, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 521
    :cond_0
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    if-eqz v8, :cond_8

    move v5, v0

    .line 523
    .local v5, "placeHolderTitleIsPresent":Z
    :goto_0
    if-eqz v5, :cond_1

    .line 524
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-virtual {v8, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 527
    :cond_1
    new-instance v4, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter$1;

    invoke-direct {v4, p0, v5, p1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;ZLcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;)V

    .line 539
    .local v4, "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v9, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v8, p2, v9, v4}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Lcom/xfinity/playerlib/model/Program;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v1

    .line 542
    .local v1, "loadedFromMemory":Z
    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
    invoke-static {v8}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$500(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    move-result-object v8

    invoke-virtual {v8}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->isFlinging()Z

    move-result v8

    if-eqz v8, :cond_9

    .line 545
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v8, v11}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 546
    if-nez v1, :cond_2

    .line 547
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v8, v11}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 556
    :cond_2
    :goto_1
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isDownloadable()Z

    move-result v8

    if-eqz v8, :cond_a

    .line 557
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->downloadIndicator:Landroid/widget/ImageView;

    invoke-virtual {v8, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 562
    :goto_2
    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->shouldSuppressNetworkLogos:Z
    invoke-static {v8}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$600(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 565
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworks()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->size()I

    move-result v8

    if-ne v8, v0, :cond_3

    .line 566
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getNetworks()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    check-cast v2, Lcom/xfinity/playerlib/model/tags/Network;

    .line 568
    .restart local v2    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_3
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v8, v11}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 569
    if-eqz v2, :cond_b

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v8

    if-eqz v8, :cond_b

    .line 570
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v8, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 571
    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v10

    iget-object v9, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v8, v10, v11, v9}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadNetworkLogoSmall(JLandroid/widget/ImageView;)V

    .line 577
    :cond_4
    :goto_3
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    if-eqz v8, :cond_5

    .line 578
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getReleaseYear()I

    move-result v8

    if-lez v8, :cond_c

    .line 579
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getReleaseYear()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 580
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 586
    :cond_5
    :goto_4
    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v8, p2}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v8

    if-nez v8, :cond_d

    .line 587
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->lockedIndicator:Landroid/view/View;

    invoke-virtual {v8, v7}, Landroid/view/View;->setVisibility(I)V

    .line 592
    :goto_5
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->newIcon:Landroid/widget/ImageView;

    if-eqz v8, :cond_6

    .line 593
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isNew()Z

    move-result v8

    if-eqz v8, :cond_e

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v8

    if-nez v8, :cond_e

    .line 594
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->newIcon:Landroid/widget/ImageView;

    invoke-virtual {v8, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 601
    :cond_6
    :goto_6
    if-eqz v5, :cond_7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->isAccessibilityEnabled:Z
    invoke-static {v8}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$700(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 602
    if-eqz v2, :cond_f

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v8

    if-eqz v8, :cond_f

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v3

    .line 603
    .local v3, "networkName":Ljava/lang/String;
    :goto_7
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->downloadIndicator:Landroid/widget/ImageView;

    invoke-virtual {v8}, Landroid/widget/ImageView;->getVisibility()I

    move-result v8

    if-nez v8, :cond_10

    .line 604
    .local v0, "isAvailableForDownload":Z
    :goto_8
    iget-object v7, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-virtual {p0, v6, v3, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->getContainerDescription(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 606
    .end local v0    # "isAvailableForDownload":Z
    .end local v3    # "networkName":Ljava/lang/String;
    :cond_7
    return-void

    .end local v1    # "loadedFromMemory":Z
    .end local v4    # "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    .end local v5    # "placeHolderTitleIsPresent":Z
    :cond_8
    move v5, v7

    .line 521
    goto/16 :goto_0

    .line 550
    .restart local v1    # "loadedFromMemory":Z
    .restart local v4    # "onLoadListener":Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;
    .restart local v5    # "placeHolderTitleIsPresent":Z
    :cond_9
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v8, v11}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 553
    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v9, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v8, p2, v9, v4}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Lcom/xfinity/playerlib/model/Program;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto/16 :goto_1

    .line 559
    :cond_a
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->downloadIndicator:Landroid/widget/ImageView;

    invoke-virtual {v8, v12}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_2

    .line 573
    :cond_b
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v8, v12}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_3

    .line 582
    :cond_c
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    invoke-virtual {v8, v12}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4

    .line 589
    :cond_d
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->lockedIndicator:Landroid/view/View;

    invoke-virtual {v8, v12}, Landroid/view/View;->setVisibility(I)V

    goto :goto_5

    .line 596
    :cond_e
    iget-object v8, p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->newIcon:Landroid/widget/ImageView;

    invoke-virtual {v8, v12}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_6

    .line 602
    :cond_f
    const-string v3, ""

    goto :goto_7

    .restart local v3    # "networkName":Ljava/lang/String;
    :cond_10
    move v0, v7

    .line 603
    goto :goto_8
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 485
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    check-cast p1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->bindItem(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;
    .locals 2

    .prologue
    .line 495
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;)V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 485
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public getContainerDescription(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 9
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "network"    # Ljava/lang/String;
    .param p3, "isAvailableForDownload"    # Z

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 618
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_entity_list_view_grid:I

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 620
    .local v1, "grid":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_container_for_entity:I

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p1, v4, v6

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .line 623
    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$800(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v5

    aput-object v5, v4, v7

    aput-object v1, v4, v8

    .line 620
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 626
    .local v0, "contentDescription":Ljava/lang/String;
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 627
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_container_for_entity_with_network:I

    new-array v4, v8, [Ljava/lang/Object;

    aput-object v0, v4, v6

    aput-object p2, v4, v7

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 633
    :cond_0
    if-eqz p3, :cond_1

    .line 634
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_container_for_entity_with_available_for_download:I

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v0, v4, v6

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 639
    :cond_1
    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 610
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    sget v0, Lcom/xfinity/playerlib/R$layout;->browse_program_item:I

    return v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;

    .prologue
    .line 500
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    sget v0, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    .line 501
    sget v0, Lcom/xfinity/playerlib/R$id;->network_logo:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    .line 502
    sget v0, Lcom/xfinity/playerlib/R$id;->locked_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->lockedIndicator:Landroid/view/View;

    .line 503
    sget v0, Lcom/xfinity/playerlib/R$id;->download_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->downloadIndicator:Landroid/widget/ImageView;

    .line 504
    sget v0, Lcom/xfinity/playerlib/R$id;->year:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    .line 505
    sget v0, Lcom/xfinity/playerlib/R$id;->title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->title:Landroid/widget/TextView;

    .line 506
    sget v0, Lcom/xfinity/playerlib/R$id;->placeholder_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    .line 507
    sget v0, Lcom/xfinity/playerlib/R$id;->new_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;->newIcon:Landroid/widget/ImageView;

    .line 508
    return-void
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 485
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    check-cast p3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;)V

    return-void
.end method

.method public setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 0
    .param p1, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 614
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.ProgramAdapter;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 615
    return-void
.end method
