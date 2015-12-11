.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;
.source "NetworkCollectionsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
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
        "Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Landroid/view/LayoutInflater;)V
    .locals 0
    .param p2, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 423
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .line 424
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 425
    return-void
.end method


# virtual methods
.method protected bindItem(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 9
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    const/16 v8, 0x8

    const/4 v7, 0x0

    const/4 v3, 0x0

    .line 447
    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$200()Lorg/slf4j/Logger;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Binding for: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 449
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v2

    .line 450
    .local v2, "title":Ljava/lang/String;
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->title:Landroid/widget/TextView;

    if-eqz v4, :cond_0

    .line 451
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 454
    :cond_0
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isDownloadable()Z

    move-result v4

    if-eqz v4, :cond_5

    .line 455
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->downloadIndicator:Landroid/widget/ImageView;

    invoke-virtual {v4, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 460
    :goto_0
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    if-eqz v4, :cond_6

    const/4 v1, 0x1

    .line 461
    .local v1, "placeHolderTitleIsPresent":Z
    :goto_1
    if-eqz v1, :cond_1

    .line 462
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 465
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$1100(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v4

    iget-object v5, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v4, p2, v5}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Lcom/xfinity/playerlib/model/Program;Landroid/widget/ImageView;)Z

    move-result v0

    .line 467
    .local v0, "loadedFromMemory":Z
    if-nez v0, :cond_8

    .line 469
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->isFlinging()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 472
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 473
    if-nez v0, :cond_2

    .line 474
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 498
    :cond_2
    :goto_2
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$300(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v4

    invoke-virtual {v4, p2}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v4

    if-nez v4, :cond_9

    .line 499
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->lockedIndicator:Landroid/view/View;

    invoke-virtual {v4, v3}, Landroid/view/View;->setVisibility(I)V

    .line 500
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v4, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 506
    :goto_3
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 507
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v4

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 508
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v4, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 509
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$1200(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v6

    iget-object v5, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    invoke-virtual {v4, v6, v7, v5}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadNetworkLogoSmall(JLandroid/widget/ImageView;)V

    .line 514
    :cond_3
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    if-eqz v4, :cond_4

    .line 515
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getReleaseYear()I

    move-result v4

    if-lez v4, :cond_a

    .line 516
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getReleaseYear()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 517
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 523
    :cond_4
    :goto_4
    return-void

    .line 457
    .end local v0    # "loadedFromMemory":Z
    .end local v1    # "placeHolderTitleIsPresent":Z
    :cond_5
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->downloadIndicator:Landroid/widget/ImageView;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    :cond_6
    move v1, v3

    .line 460
    goto/16 :goto_1

    .line 477
    .restart local v0    # "loadedFromMemory":Z
    .restart local v1    # "placeHolderTitleIsPresent":Z
    :cond_7
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 480
    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$1100(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v4

    iget-object v5, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    new-instance v6, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;

    invoke-direct {v6, p0, v1, p1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;ZLcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;)V

    invoke-virtual {v4, p2, v5, v6}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Lcom/xfinity/playerlib/model/Program;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto/16 :goto_2

    .line 493
    :cond_8
    if-eqz v1, :cond_2

    .line 494
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 502
    :cond_9
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->lockedIndicator:Landroid/view/View;

    invoke-virtual {v4, v8}, Landroid/view/View;->setVisibility(I)V

    .line 503
    iget-object v4, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    new-instance v5, Landroid/graphics/drawable/ColorDrawable;

    sget v6, Lcom/xfinity/playerlib/R$color;->transparent:I

    invoke-direct {v5, v6}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_3

    .line 519
    :cond_a
    iget-object v3, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 421
    check-cast p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->bindItem(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;
    .locals 2

    .prologue
    .line 429
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;)V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 421
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 527
    sget v0, Lcom/xfinity/playerlib/R$layout;->browse_program_item:I

    return v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

    .prologue
    .line 434
    sget v0, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->coverArt:Landroid/widget/ImageView;

    .line 435
    sget v0, Lcom/xfinity/playerlib/R$id;->network_logo:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->networkLogo:Landroid/widget/ImageView;

    .line 436
    sget v0, Lcom/xfinity/playerlib/R$id;->locked_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->lockedIndicator:Landroid/view/View;

    .line 437
    sget v0, Lcom/xfinity/playerlib/R$id;->year:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->year:Landroid/widget/TextView;

    .line 438
    sget v0, Lcom/xfinity/playerlib/R$id;->download_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->downloadIndicator:Landroid/widget/ImageView;

    .line 439
    sget v0, Lcom/xfinity/playerlib/R$id;->title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->title:Landroid/widget/TextView;

    .line 440
    sget v0, Lcom/xfinity/playerlib/R$id;->placeholder_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    .line 442
    check-cast p2, Lit/sephiroth/android/library/widget/HListView;

    .end local p2    # "viewGroup":Landroid/view/ViewGroup;
    iput-object p2, p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->carousel:Lit/sephiroth/android/library/widget/HListView;

    .line 443
    return-void
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 421
    check-cast p3, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;)V

    return-void
.end method
