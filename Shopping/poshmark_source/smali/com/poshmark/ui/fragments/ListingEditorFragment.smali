.class public Lcom/poshmark/ui/fragments/ListingEditorFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ListingEditorFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/ListingEditorFragment$18;,
        Lcom/poshmark/ui/fragments/ListingEditorFragment$NewListingId;,
        Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;
    }
.end annotation


# instance fields
.field DEFAULT_REQUEST_CODE:I

.field commonImageClickListener:Landroid/view/View$OnClickListener;

.field createListingButtonListener:Landroid/view/View$OnClickListener;

.field currentActiveImageIndex:I

.field currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

.field currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

.field deleteButtonClickListener:Lcom/poshmark/utils/RemoveEditListingImageListener;

.field handlingUserTap:Z

.field imageList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Picture;",
            ">;"
        }
    .end annotation
.end field

.field isListingDeleted:Z

.field isNFSEnabled:Z

.field isNewListing:Z

.field listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

.field listingId:Ljava/lang/String;

.field newListing:Lcom/poshmark/data_model/models/NewListing;

.field private otl:Landroid/view/View$OnTouchListener;

.field shareBanner:Ljava/lang/String;

.field storage_path:Ljava/io/File;

.field viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 81
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 83
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    .line 100
    sget-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->LISTING_SETUP_STATE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 102
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    .line 103
    new-instance v0, Lcom/poshmark/data_model/models/NewListing;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/NewListing;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    .line 106
    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingId:Ljava/lang/String;

    .line 107
    iput v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageIndex:I

    .line 108
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    .line 112
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 113
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNFSEnabled:Z

    .line 114
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isListingDeleted:Z

    .line 115
    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->shareBanner:Ljava/lang/String;

    .line 777
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->commonImageClickListener:Landroid/view/View$OnClickListener;

    .line 796
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->createListingButtonListener:Landroid/view/View$OnClickListener;

    .line 826
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$13;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->otl:Landroid/view/View$OnTouchListener;

    .line 917
    new-instance v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$14;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$14;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->deleteButtonClickListener:Lcom/poshmark/utils/RemoveEditListingImageListener;

    .line 1125
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ListingEditorFragment;Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorFragment;
    .param p1, "x1"    # Ljava/math/BigDecimal;

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getSellerEarnings(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ListingEditorFragment;Landroid/content/Intent;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorFragment;
    .param p1, "x1"    # Landroid/content/Intent;

    .prologue
    .line 81
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handleNewState(Landroid/content/Intent;)V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/ListingEditorFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorFragment;

    .prologue
    .line 81
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->validInput()Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorFragment;

    .prologue
    .line 81
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->gotoShareScreen()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorFragment;

    .prologue
    .line 81
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageOrder()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/ListingEditorFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorFragment;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 81
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->launchUrl(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingEditorFragment;

    .prologue
    .line 81
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->deleteListing()V

    return-void
.end method

.method private copyImageSelectorView(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V
    .locals 2
    .param p1, "src"    # Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    .param p2, "dst"    # Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .prologue
    .line 1048
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1049
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getOriginalFileUri()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 1050
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getFileUri()Landroid/net/Uri;

    move-result-object v0

    invoke-direct {p0, p2, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setImageThumbnail(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Landroid/net/Uri;)V

    .line 1053
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 1054
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setRemoteImageInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 1056
    :cond_1
    return-void
.end method

.method private createViewHolder(Landroid/view/View;)V
    .locals 11
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 941
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 942
    .local v5, "oldImageList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;>;"
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    if-eqz v9, :cond_0

    .line 943
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v9

    if-ge v1, v9, :cond_0

    .line 944
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v9, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    invoke-interface {v5, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 943
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 948
    .end local v1    # "i":I
    :cond_0
    new-instance v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    invoke-direct {v9}, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;-><init>()V

    iput-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    .line 949
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c019a

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->picturesSelectorLayout:Landroid/widget/LinearLayout;

    .line 951
    const v9, 0x7f0c01ad

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 952
    .local v4, "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v9

    if-lez v9, :cond_1

    .line 953
    const/4 v9, 0x1

    invoke-virtual {v4, v9}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setCovershotStatus(Z)V

    .line 954
    const/4 v9, 0x0

    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-direct {p0, v9, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->copyImageSelectorView(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V

    .line 957
    :cond_1
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v10, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    const v9, 0x7f0c01ad

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-interface {v10, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 959
    const v9, 0x7f0c01af

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .end local v4    # "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    check-cast v4, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 960
    .restart local v4    # "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v9

    const/4 v10, 0x1

    if-le v9, v10, :cond_2

    .line 961
    const/4 v9, 0x1

    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-direct {p0, v9, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->copyImageSelectorView(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V

    .line 963
    :cond_2
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->deleteButtonClickListener:Lcom/poshmark/utils/RemoveEditListingImageListener;

    invoke-virtual {v4, v9}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setRemoveButtonClickListener(Lcom/poshmark/utils/RemoveEditListingImageListener;)V

    .line 964
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 966
    const v9, 0x7f0c01b0

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .end local v4    # "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    check-cast v4, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 967
    .restart local v4    # "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v9

    const/4 v10, 0x2

    if-le v9, v10, :cond_3

    .line 968
    const/4 v9, 0x2

    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-direct {p0, v9, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->copyImageSelectorView(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V

    .line 970
    :cond_3
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->deleteButtonClickListener:Lcom/poshmark/utils/RemoveEditListingImageListener;

    invoke-virtual {v4, v9}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setRemoveButtonClickListener(Lcom/poshmark/utils/RemoveEditListingImageListener;)V

    .line 971
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 973
    const v9, 0x7f0c01b1

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .end local v4    # "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    check-cast v4, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 974
    .restart local v4    # "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v9

    const/4 v10, 0x3

    if-le v9, v10, :cond_4

    .line 975
    const/4 v9, 0x3

    invoke-interface {v5, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-direct {p0, v9, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->copyImageSelectorView(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;)V

    .line 977
    :cond_4
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->deleteButtonClickListener:Lcom/poshmark/utils/RemoveEditListingImageListener;

    invoke-virtual {v4, v9}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setRemoveButtonClickListener(Lcom/poshmark/utils/RemoveEditListingImageListener;)V

    .line 978
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 980
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c019c

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->titleEditText:Landroid/widget/EditText;

    .line 981
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c019d

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->descriptionEditText:Landroid/widget/EditText;

    .line 982
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c019e

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->categoryEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 983
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c019f

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->sizeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 984
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a0

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->brandEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 985
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a3

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->nwtEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 986
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a4

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 987
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a5

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 988
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a6

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->earningsTextView:Landroid/widget/TextView;

    .line 989
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a2

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/ColorSelectionView;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->colorsContainer:Lcom/poshmark/ui/customviews/ColorSelectionView;

    .line 991
    const v9, 0x7f0c01aa

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Lcom/poshmark/ui/customviews/PMTextView;

    .line 992
    .local v7, "sellerPolicyTextView":Lcom/poshmark/ui/customviews/PMTextView;
    const v9, 0x7f0602c5

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 993
    .local v6, "poshmarkSellerfeePolicyText":Ljava/lang/String;
    new-instance v8, Landroid/text/SpannableStringBuilder;

    invoke-direct {v8, v6}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 994
    .local v8, "ssb":Landroid/text/SpannableStringBuilder;
    const v9, 0x7f060248

    invoke-virtual {p0, v9}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 996
    .local v0, "feePolicyText":Ljava/lang/String;
    invoke-virtual {v6, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 997
    .local v2, "idx1":I
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v9

    add-int v3, v2, v9

    .line 998
    .local v3, "idx2":I
    new-instance v9, Lcom/poshmark/ui/fragments/ListingEditorFragment$15;

    invoke-direct {v9, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$15;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v2, v3, v10}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 1005
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v9

    invoke-virtual {v7, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 1006
    sget-object v9, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {v7, v8, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 1008
    new-instance v9, Lcom/poshmark/ui/fragments/ListingEditorFragment$16;

    invoke-direct {v9, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$16;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-virtual {v7, v9}, Lcom/poshmark/ui/customviews/PMTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1016
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a7

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilitySectionLayout:Landroid/widget/LinearLayout;

    .line 1017
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a8

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 1018
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a1

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/LabelledEditText;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->colorDummyEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 1019
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c01a9

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/LinearLayout;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->deleteButtonSectionLayout:Landroid/widget/LinearLayout;

    .line 1020
    iget-object v10, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    const v9, 0x7f0c0196

    invoke-virtual {p1, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMButton;

    iput-object v9, v10, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->deleteButton:Lcom/poshmark/ui/customviews/PMButton;

    .line 1021
    iget-boolean v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNFSEnabled:Z

    if-eqz v9, :cond_5

    .line 1022
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilitySectionLayout:Landroid/widget/LinearLayout;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1023
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->deleteButtonSectionLayout:Landroid/widget/LinearLayout;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1024
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->deleteButton:Lcom/poshmark/ui/customviews/PMButton;

    new-instance v10, Lcom/poshmark/ui/fragments/ListingEditorFragment$17;

    invoke-direct {v10, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$17;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/customviews/PMButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1043
    :goto_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->prefilListingInfo()V

    .line 1044
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageOrder()V

    .line 1045
    return-void

    .line 1039
    :cond_5
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilitySectionLayout:Landroid/widget/LinearLayout;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1040
    iget-object v9, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v9, v9, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->deleteButtonSectionLayout:Landroid/widget/LinearLayout;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1
.end method

.method private deleteListing()V
    .locals 5

    .prologue
    .line 688
    const v0, 0x7f0600ba

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 689
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "delete_listing"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 690
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingId:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$10;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$10;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->deleteListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 709
    return-void
.end method

.method private fireCameraActivity()V
    .locals 5

    .prologue
    .line 675
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 676
    .local v2, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/poshmark/ui/PMContainerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 677
    .local v1, "intent":Landroid/content/Intent;
    const-string v3, "FRAGMENT"

    const-class v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 678
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 679
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "CREATION_MODE"

    sget v4, Lcom/poshmark/ui/fragments/CameraPreviewFragment;->CREATE_COVERSHOT:I

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 680
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isCovershot()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 681
    const-string v3, "IS_FIRST_IMAGE"

    const/4 v4, 0x1

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 683
    :cond_0
    const-string v3, "FRAGMENT_DATA"

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;

    .line 684
    iget v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    invoke-virtual {p0, v1, v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 685
    return-void
.end method

.method private getSellerEarnings(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    .locals 6
    .param p1, "listingPrice"    # Ljava/math/BigDecimal;

    .prologue
    .line 585
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    move-result-object v2

    .line 586
    .local v2, "listingFeature":Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    if-eqz v2, :cond_1

    .line 587
    invoke-virtual {v2, p1}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->getFeeForListingPrice(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v0

    .line 588
    .local v0, "deductions":Ljava/math/BigDecimal;
    invoke-virtual {p1, v0}, Ljava/math/BigDecimal;->subtract(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v1

    .line 589
    .local v1, "earnings":Ljava/math/BigDecimal;
    sget-object v3, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    invoke-virtual {v1, v3}, Ljava/math/BigDecimal;->compareTo(Ljava/math/BigDecimal;)I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 595
    .end local v0    # "deductions":Ljava/math/BigDecimal;
    .end local v1    # "earnings":Ljava/math/BigDecimal;
    :goto_0
    return-object v1

    .line 592
    .restart local v0    # "deductions":Ljava/math/BigDecimal;
    .restart local v1    # "earnings":Ljava/math/BigDecimal;
    :cond_0
    sget-object v1, Ljava/math/BigDecimal;->ZERO:Ljava/math/BigDecimal;

    goto :goto_0

    .line 595
    .end local v0    # "deductions":Ljava/math/BigDecimal;
    .end local v1    # "earnings":Ljava/math/BigDecimal;
    :cond_1
    const-wide v4, 0x3fe999999999999aL    # 0.8

    invoke-static {v4, v5}, Ljava/math/BigDecimal;->valueOf(D)Ljava/math/BigDecimal;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/math/BigDecimal;->multiply(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v1

    goto :goto_0
.end method

.method private getShareBannerImage()V
    .locals 5

    .prologue
    .line 195
    new-instance v0, Lcom/poshmark/data_model/models/ShareBannerInfo;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/poshmark/data_model/models/ShareBannerInfo;-><init>(Landroid/app/Activity;)V

    .line 196
    .local v0, "bannerInfo":Lcom/poshmark/data_model/models/ShareBannerInfo;
    new-instance v2, Lcom/google/gson/Gson;

    invoke-direct {v2}, Lcom/google/gson/Gson;-><init>()V

    const-class v3, Lcom/poshmark/data_model/models/ShareBannerInfo;

    instance-of v4, v2, Lcom/google/gson/Gson;

    if-nez v4, :cond_0

    invoke-virtual {v2, v0, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    .line 197
    .local v1, "json":Ljava/lang/String;
    :goto_0
    new-instance v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$2;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-static {v1, v2}, Lcom/poshmark/http/api/PMApi;->getShareBannerImage(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 205
    return-void

    .line 196
    .end local v1    # "json":Ljava/lang/String;
    :cond_0
    check-cast v2, Lcom/google/gson/Gson;

    invoke-static {v2, v0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private gotoShareScreen()V
    .locals 6

    .prologue
    .line 763
    sget-object v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->SHARE_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 764
    new-instance v3, Lcom/poshmark/utils/ListingManager;

    invoke-direct {v3}, Lcom/poshmark/utils/ListingManager;-><init>()V

    .line 765
    .local v3, "listingManager":Lcom/poshmark/utils/ListingManager;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-virtual {v3, v2}, Lcom/poshmark/utils/ListingManager;->setImageList(Ljava/util/List;)V

    .line 766
    iget-boolean v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    invoke-virtual {v3, v2}, Lcom/poshmark/utils/ListingManager;->setListingFlag(Z)V

    .line 767
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v3, v2, v4}, Lcom/poshmark/utils/ListingManager;->setListingDetails(Lcom/poshmark/data_model/models/NewListing;Ljava/lang/String;)V

    .line 768
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 769
    .local v1, "b":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->shareBanner:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 770
    const-string v2, "share_banner"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->shareBanner:Ljava/lang/String;

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 772
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 773
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ListingEditorShareFragment;

    iget v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 774
    return-void
.end method

.method private handleEditMode(ILandroid/content/Intent;)V
    .locals 7
    .param p1, "editMode"    # I
    .param p2, "data"    # Landroid/content/Intent;

    .prologue
    .line 712
    packed-switch p1, :pswitch_data_0

    .line 745
    :goto_0
    :pswitch_0
    return-void

    .line 714
    :pswitch_1
    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 715
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->resetImageView()V

    .line 716
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 717
    .local v3, "index":I
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 718
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageOrder()V

    goto :goto_0

    .line 722
    .end local v3    # "index":I
    :pswitch_2
    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 723
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isCovershot()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 724
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 725
    .local v0, "b":Landroid/os/Bundle;
    const-string v5, "ORIGINALFILE"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v4

    check-cast v4, Landroid/net/Uri;

    .line 726
    .local v4, "originalFile":Landroid/net/Uri;
    const-string v5, "FILTEREDFILE"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 727
    .local v1, "filteredFile":Landroid/net/Uri;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->resetImageView()V

    .line 728
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 729
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-direct {p0, v5, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setImageThumbnail(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Landroid/net/Uri;)V

    .line 730
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-direct {p0, v1, v4, v5}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageList(Landroid/net/Uri;Landroid/net/Uri;I)V

    goto :goto_0

    .line 732
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "filteredFile":Landroid/net/Uri;
    .end local v4    # "originalFile":Landroid/net/Uri;
    :cond_0
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->resetImageView()V

    .line 733
    sget-object v5, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 734
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 735
    .restart local v0    # "b":Landroid/os/Bundle;
    const-string v5, "IMAGE_FILE_URI"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    .line 736
    .local v2, "imageFile":Landroid/net/Uri;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-direct {p0, v5, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setImageThumbnail(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Landroid/net/Uri;)V

    .line 737
    const/4 v6, 0x0

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getTag()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-direct {p0, v2, v6, v5}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageList(Landroid/net/Uri;Landroid/net/Uri;I)V

    goto/16 :goto_0

    .line 712
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private handleNewState(Landroid/content/Intent;)V
    .locals 22
    .param p1, "data"    # Landroid/content/Intent;

    .prologue
    .line 247
    const/4 v4, 0x0

    .line 248
    .local v4, "b":Landroid/os/Bundle;
    const/16 v16, 0x0

    .line 251
    .local v16, "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    const/4 v14, 0x0

    .line 254
    .local v14, "newSubCategories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$18;->$SwitchMap$com$poshmark$ui$fragments$ListingEditorFragment$LISTING_STATES:[I

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->ordinal()I

    move-result v18

    aget v17, v17, v18

    packed-switch v17, :pswitch_data_0

    .line 406
    :cond_0
    :goto_0
    return-void

    .line 256
    :pswitch_0
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 257
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    move/from16 v17, v0

    if-eqz v17, :cond_1

    .line 258
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageIndex:I

    move/from16 v18, v0

    invoke-interface/range {v17 .. v18}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 259
    invoke-direct/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->prefilListingInfo()V

    .line 260
    const/16 v17, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handleNewState(Landroid/content/Intent;)V

    .line 261
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v18, v0

    const-string v19, "listing"

    const-string v20, "new_listing_start"

    const/16 v21, 0x0

    invoke-virtual/range {v17 .. v21}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 263
    :cond_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v18, v0

    const-string v19, "listing"

    const-string v20, "edit_listing_start"

    const/16 v21, 0x0

    invoke-virtual/range {v17 .. v21}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 264
    invoke-direct/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupCovershot()V

    .line 265
    invoke-direct/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->initializeImages()V

    .line 266
    invoke-direct/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->prefilListingInfo()V

    goto :goto_0

    .line 270
    :pswitch_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v17

    if-eqz v17, :cond_2

    .line 271
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 272
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isCovershot()Z

    move-result v17

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->launchEditImageFragment(Z)V

    goto/16 :goto_0

    .line 274
    :cond_2
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->NEW_PHOTO:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 275
    invoke-direct/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->fireCameraActivity()V

    goto/16 :goto_0

    .line 279
    :pswitch_2
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 280
    const-string v17, "EDITMODE"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v9

    .line 281
    .local v9, "editMode":I
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v9, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handleEditMode(ILandroid/content/Intent;)V

    goto/16 :goto_0

    .line 284
    .end local v9    # "editMode":I
    :pswitch_3
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 285
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isCovershot()Z

    move-result v17

    if-eqz v17, :cond_3

    .line 286
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 287
    const-string v17, "ORIGINALFILE"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v15

    check-cast v15, Landroid/net/Uri;

    .line 288
    .local v15, "originalFile":Landroid/net/Uri;
    const-string v17, "FILTEREDFILE"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v10

    check-cast v10, Landroid/net/Uri;

    .line 289
    .local v10, "filteredFile":Landroid/net/Uri;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->resetImageView()V

    .line 290
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 291
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v10}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setImageThumbnail(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Landroid/net/Uri;)V

    .line 292
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getTag()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Integer;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-direct {v0, v10, v15, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageList(Landroid/net/Uri;Landroid/net/Uri;I)V

    goto/16 :goto_0

    .line 295
    .end local v10    # "filteredFile":Landroid/net/Uri;
    .end local v15    # "originalFile":Landroid/net/Uri;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->resetImageView()V

    .line 296
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 297
    invoke-virtual/range {p1 .. p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 298
    const-string v17, "IMAGE_FILE_URI"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v11

    check-cast v11, Landroid/net/Uri;

    .line 299
    .local v11, "imageFile":Landroid/net/Uri;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v11}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setImageThumbnail(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Landroid/net/Uri;)V

    .line 300
    const/16 v18, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getTag()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Integer;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move/from16 v2, v17

    invoke-direct {v0, v11, v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageList(Landroid/net/Uri;Landroid/net/Uri;I)V

    goto/16 :goto_0

    .line 304
    .end local v11    # "imageFile":Landroid/net/Uri;
    :pswitch_4
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 305
    const-string v17, "RETURNED_RESULTS"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 306
    const-string v17, "DATA_SELECTED"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 307
    .local v12, "jsonString":Ljava/lang/String;
    if-eqz v12, :cond_4

    .line 308
    const-class v17, Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v0, v17

    invoke-static {v12, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    .end local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v16, Lcom/poshmark/data_model/models/MetaItem;

    .line 310
    .restart local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_4
    if-eqz v16, :cond_0

    .line 311
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/NewListing;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v8

    .line 312
    .local v8, "currentCategory":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v8, :cond_5

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v17

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_5

    .line 314
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->sizeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 315
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    const-string v18, ""

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/data_model/models/NewListing;->setSize(Ljava/lang/String;)V

    .line 317
    :cond_5
    const-string v17, "TAGS_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 318
    .local v3, "arrayListJson":Ljava/lang/String;
    if-eqz v3, :cond_6

    .line 319
    new-instance v13, Lcom/poshmark/ui/fragments/ListingEditorFragment$4;

    move-object/from16 v0, p0

    invoke-direct {v13, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$4;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    .line 320
    .local v13, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v3, v13}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v14

    .end local v14    # "newSubCategories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    check-cast v14, Ljava/util/List;

    .line 322
    .end local v13    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    .restart local v14    # "newSubCategories":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    :cond_6
    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v5

    .line 323
    .local v5, "categoryDisplayString":Ljava/lang/String;
    if-eqz v14, :cond_7

    invoke-interface {v14}, Ljava/util/List;->isEmpty()Z

    move-result v17

    if-nez v17, :cond_7

    .line 324
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, " | "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 325
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-interface {v14, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 326
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v18, v0

    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-interface {v14, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/NewListing;->setSubcategories(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 330
    :goto_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v18, v0

    const-string v19, "listing"

    const-string v20, "listing_set_subcategory"

    const/16 v21, 0x0

    invoke-virtual/range {v17 .. v21}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 331
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/NewListing;->setCategory(Lcom/poshmark/data_model/models/MetaItem;)V

    .line 332
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->categoryEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 328
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/NewListing;->clearSubCategories()V

    goto :goto_1

    .line 336
    .end local v3    # "arrayListJson":Ljava/lang/String;
    .end local v5    # "categoryDisplayString":Ljava/lang/String;
    .end local v8    # "currentCategory":Lcom/poshmark/data_model/models/MetaItem;
    .end local v12    # "jsonString":Ljava/lang/String;
    :pswitch_5
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 337
    const-string v17, "RETURNED_RESULTS"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 338
    const-string v17, "DATA_SELECTED"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 339
    .restart local v12    # "jsonString":Ljava/lang/String;
    if-eqz v12, :cond_8

    .line 340
    const-class v17, Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v0, v17

    invoke-static {v12, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    .end local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v16, Lcom/poshmark/data_model/models/MetaItem;

    .line 342
    .restart local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_8
    if-eqz v16, :cond_0

    .line 343
    if-eqz v16, :cond_0

    .line 344
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->sizeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 345
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/data_model/models/NewListing;->setSize(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 350
    .end local v12    # "jsonString":Ljava/lang/String;
    :pswitch_6
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 351
    const-string v17, "RETURNED_RESULTS"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 352
    const-string v17, "COLOR_CHANGED"

    const/16 v18, 0x1

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v7

    .line 353
    .local v7, "colorsChanged":Z
    if-eqz v7, :cond_0

    .line 354
    const-string v17, "COLOR_LIST"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 355
    .restart local v3    # "arrayListJson":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 356
    new-instance v13, Lcom/poshmark/ui/fragments/ListingEditorFragment$5;

    move-object/from16 v0, p0

    invoke-direct {v13, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$5;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    .line 357
    .restart local v13    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v3, v13}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 358
    .local v6, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v6}, Lcom/poshmark/data_model/models/NewListing;->setColors(Ljava/util/List;)V

    .line 359
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->colorsContainer:Lcom/poshmark/ui/customviews/ColorSelectionView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v6}, Lcom/poshmark/ui/customviews/ColorSelectionView;->addAllColors(Ljava/util/List;)V

    .line 360
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v18, v0

    const-string v19, "listing"

    const-string v20, "listing_set_color"

    const/16 v21, 0x0

    invoke-virtual/range {v17 .. v21}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 365
    .end local v3    # "arrayListJson":Ljava/lang/String;
    .end local v6    # "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v7    # "colorsChanged":Z
    .end local v13    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :pswitch_7
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 366
    const-string v17, "RETURNED_RESULTS"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 367
    const-string v17, "DATA_SELECTED"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 368
    .restart local v12    # "jsonString":Ljava/lang/String;
    if-eqz v12, :cond_9

    .line 369
    const-class v17, Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v0, v17

    invoke-static {v12, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    .end local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v16, Lcom/poshmark/data_model/models/MetaItem;

    .line 371
    .restart local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_9
    if-eqz v16, :cond_0

    .line 372
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->brandEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 373
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/data_model/models/NewListing;->setBrand(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 377
    .end local v12    # "jsonString":Ljava/lang/String;
    :pswitch_8
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 378
    const-string v17, "RETURNED_RESULTS"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 379
    const-string v17, "DATA_SELECTED"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 380
    .restart local v12    # "jsonString":Ljava/lang/String;
    if-eqz v12, :cond_a

    .line 381
    const-class v17, Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v0, v17

    invoke-static {v12, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    .end local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v16, Lcom/poshmark/data_model/models/MetaItem;

    .line 383
    .restart local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_a
    if-eqz v16, :cond_0

    .line 384
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->nwtEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 385
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/data_model/models/NewListing;->setCondition(Ljava/lang/String;)V

    .line 386
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v18, v0

    const-string v19, "listing"

    const-string v20, "listing_set_listing_condition"

    const/16 v21, 0x0

    invoke-virtual/range {v17 .. v21}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 390
    .end local v12    # "jsonString":Ljava/lang/String;
    :pswitch_9
    sget-object v17, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 391
    const-string v17, "RETURNED_RESULTS"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    .line 392
    const-string v17, "DATA_SELECTED"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 393
    .restart local v12    # "jsonString":Ljava/lang/String;
    if-eqz v12, :cond_b

    .line 394
    const-class v17, Lcom/poshmark/data_model/models/MetaItem;

    move-object/from16 v0, v17

    invoke-static {v12, v0}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v16

    .end local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v16, Lcom/poshmark/data_model/models/MetaItem;

    .line 396
    .restart local v16    # "returnedMetaItem":Lcom/poshmark/data_model/models/MetaItem;
    :cond_b
    if-eqz v16, :cond_0

    .line 397
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 398
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/data_model/models/NewListing;->setInventoryStatus(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 403
    .end local v12    # "jsonString":Ljava/lang/String;
    :pswitch_a
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->finishActivity()V

    goto/16 :goto_0

    .line 254
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
    .end packed-switch
.end method

.method private initializeImages()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 463
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v3

    .line 464
    .local v3, "size":I
    const/4 v4, 0x4

    if-le v3, v4, :cond_0

    .line 465
    const/4 v3, 0x4

    .line 467
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_3

    .line 468
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/Picture;

    .line 469
    .local v1, "image":Lcom/poshmark/data_model/models/inner_models/Picture;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 470
    .local v2, "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    if-nez v0, :cond_1

    .line 471
    invoke-virtual {v2, v6}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setCovershotStatus(Z)V

    .line 474
    :cond_1
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->isRemote()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 475
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getPictureUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setRemoteImageInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 481
    :goto_1
    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setAsNextSelector(Z)V

    .line 482
    invoke-virtual {v2, v6}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageAssignedState(Z)V

    .line 467
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 477
    :cond_2
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getPictureFileUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setFileUri(Landroid/net/Uri;)V

    .line 478
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getOriginalPictureFileUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 479
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getPictureFileUri()Landroid/net/Uri;

    move-result-object v4

    invoke-direct {p0, v2, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setImageThumbnail(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Landroid/net/Uri;)V

    goto :goto_1

    .line 484
    .end local v1    # "image":Lcom/poshmark/data_model/models/inner_models/Picture;
    .end local v2    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_3
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageOrder()V

    .line 486
    return-void
.end method

.method private launchEditImageFragment(Z)V
    .locals 7
    .param p1, "isCovershot"    # Z

    .prologue
    .line 665
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/PMActivity;

    .line 666
    .local v6, "parent":Lcom/poshmark/ui/PMActivity;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 667
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "COVERSHOT"

    invoke-virtual {v1, v2, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 668
    const-string v2, "NEWLISTING"

    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 669
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 670
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/EditListingImageFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    iget v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->DEFAULT_REQUEST_CODE:I

    move-object v4, p0

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivityForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 671
    return-void
.end method

.method private launchUrl(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "analyticsPageName"    # Ljava/lang/String;

    .prologue
    .line 1118
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 1119
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1120
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-virtual {v1, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1121
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 1122
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MappPageFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 1123
    return-void
.end method

.method private prefilListingInfo()V
    .locals 9

    .prologue
    .line 1059
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->titleEditText:Landroid/widget/EditText;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/NewListing;->getTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 1060
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->descriptionEditText:Landroid/widget/EditText;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/NewListing;->getDescription()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 1061
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/NewListing;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    .line 1062
    .local v1, "category":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v1, :cond_1

    .line 1063
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/NewListing;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v0

    .line 1064
    .local v0, "catLabel":Ljava/lang/String;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/NewListing;->getFirstSubCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v5

    .line 1065
    .local v5, "subCat":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v5, :cond_0

    .line 1066
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " | "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1068
    :cond_0
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->categoryEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v6, v0}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 1070
    .end local v0    # "catLabel":Ljava/lang/String;
    .end local v5    # "subCat":Lcom/poshmark/data_model/models/MetaItem;
    :cond_1
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->sizeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/NewListing;->getSize()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 1071
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->brandEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/NewListing;->getBrand()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 1072
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->nwtEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/poshmark/data_model/models/NewListing;->getConditionDisplayString(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 1073
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/poshmark/data_model/models/NewListing;->getInventoryStatusDisplayString(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 1075
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/NewListing;->getOriginalPrice()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_2

    .line 1076
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/NewListing;->getOriginalPrice()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 1078
    :cond_2
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/NewListing;->getPrice()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_3

    .line 1079
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/NewListing;->getPrice()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 1081
    :cond_3
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/NewListing;->getColors()Ljava/util/List;

    move-result-object v3

    .line 1082
    .local v3, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    if-eqz v3, :cond_4

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_4

    .line 1083
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 1084
    .local v4, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 1085
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PMColor;

    .line 1086
    .local v2, "color":Lcom/poshmark/data_model/models/PMColor;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->colorsContainer:Lcom/poshmark/ui/customviews/ColorSelectionView;

    invoke-virtual {v6, v2}, Lcom/poshmark/ui/customviews/ColorSelectionView;->addColor(Lcom/poshmark/data_model/models/PMColor;)V

    goto :goto_0

    .line 1089
    .end local v2    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v4    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :cond_4
    return-void
.end method

.method private restoreState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 216
    const-string v2, "NEW_LISTING_FLAG"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    .line 217
    const-string v2, "LISTING_ID"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingId:Ljava/lang/String;

    .line 218
    const-string v2, "CURRENT_STATE"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 219
    const-string v2, "CURRENT_ACTIVE_IMAGE"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageIndex:I

    .line 220
    const-string v2, "IS_NFS_ENABLED"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNFSEnabled:Z

    .line 222
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    iget v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageIndex:I

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 224
    const-string v2, "NEW_LISTING_INFO_JSON"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 225
    .local v0, "json":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 226
    const-class v2, Lcom/poshmark/data_model/models/NewListing;

    invoke-static {v0, v2}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/NewListing;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    .line 229
    :cond_0
    const-string v2, "IMAGE_LIST_JSON"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 230
    if-eqz v0, :cond_1

    .line 231
    new-instance v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$3;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    .line 232
    .local v1, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v0, v1}, Lcom/poshmark/utils/StringUtils;->imageListFromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/util/List;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    .line 234
    .end local v1    # "listOfObject":Lcom/google/gson/reflect/TypeToken;
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->initializeImages()V

    .line 235
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->prefilListingInfo()V

    .line 236
    return-void
.end method

.method private setImageThumbnail(Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;Landroid/net/Uri;)V
    .locals 5
    .param p1, "imageSelectorView"    # Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    .param p2, "imageFile"    # Landroid/net/Uri;

    .prologue
    const/16 v2, 0xc8

    .line 748
    invoke-virtual {p1, p2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setFileUri(Landroid/net/Uri;)V

    .line 749
    if-eqz p2, :cond_0

    .line 750
    invoke-static {v2, v2, p2}, Lcom/poshmark/utils/ImageUtils;->scaleBitmap(IILandroid/net/Uri;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 751
    .local v0, "scaledBmp":Landroid/graphics/Bitmap;
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 752
    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 753
    const/4 v2, 0x1

    invoke-virtual {p1, v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageAssignedState(Z)V

    .line 756
    .end local v0    # "scaledBmp":Landroid/graphics/Bitmap;
    :cond_0
    new-instance v1, Lcom/poshmark/utils/MediaScannerWrapper;

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->storage_path:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    const-string v4, "image/jpeg"

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/utils/MediaScannerWrapper;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 757
    .local v1, "scanner":Lcom/poshmark/utils/MediaScannerWrapper;
    invoke-virtual {v1}, Lcom/poshmark/utils/MediaScannerWrapper;->scan()V

    .line 759
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageOrder()V

    .line 760
    return-void
.end method

.method private setupActionBarNextActionButton()V
    .locals 2

    .prologue
    .line 540
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v0

    .line 541
    .local v0, "nextActionButton":Landroid/widget/Button;
    if-nez v0, :cond_0

    .line 546
    :goto_0
    return-void

    .line 544
    :cond_0
    const v1, 0x7f0601cc

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 545
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->createListingButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method

.method private setupCovershot()V
    .locals 6

    .prologue
    .line 409
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Picture;

    invoke-direct {v0}, Lcom/poshmark/data_model/models/inner_models/Picture;-><init>()V

    .line 410
    .local v0, "covershot":Lcom/poshmark/data_model/models/inner_models/Picture;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingDetails;->getCovershotId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/poshmark/data_model/models/inner_models/Picture;->setId(Ljava/lang/String;)V

    .line 411
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingDetails;->getCovershot()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/poshmark/data_model/models/inner_models/Picture;->setPictureUrl(Ljava/lang/String;)V

    .line 412
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 414
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingDetails;->getPictures()Ljava/util/List;

    move-result-object v2

    .line 415
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Picture;>;"
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v4

    .line 416
    .local v4, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v4, :cond_0

    .line 417
    new-instance v3, Lcom/poshmark/data_model/models/inner_models/Picture;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/poshmark/data_model/models/inner_models/Picture;

    invoke-direct {v3, v5}, Lcom/poshmark/data_model/models/inner_models/Picture;-><init>(Lcom/poshmark/data_model/models/inner_models/Picture;)V

    .line 418
    .local v3, "p":Lcom/poshmark/data_model/models/inner_models/Picture;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 416
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 420
    .end local v3    # "p":Lcom/poshmark/data_model/models/inner_models/Picture;
    :cond_0
    return-void
.end method

.method private setupExistingListing()V
    .locals 2

    .prologue
    .line 489
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/NewListing;->updateFromListingDetails(Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 490
    return-void
.end method

.method private setupImageClickHandlers()V
    .locals 3

    .prologue
    .line 554
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 555
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 556
    .local v1, "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setTag(Ljava/lang/Object;)V

    .line 557
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->commonImageClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 554
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 559
    .end local v1    # "imageSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_0
    return-void
.end method

.method private setupImageList()V
    .locals 2

    .prologue
    .line 549
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setCovershotStatus(Z)V

    .line 550
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupImageClickHandlers()V

    .line 551
    return-void
.end method

.method private setupPriceValidators()V
    .locals 2

    .prologue
    .line 599
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 626
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 662
    return-void
.end method

.method private setupTouchListeners()V
    .locals 2

    .prologue
    .line 562
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->categoryEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 563
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->sizeEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 564
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->brandEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 565
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->nwtEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 566
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 567
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->colorDummyEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->otl:Landroid/view/View$OnTouchListener;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 568
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->colorsContainer:Lcom/poshmark/ui/customviews/ColorSelectionView;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$7;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/ColorSelectionView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 582
    return-void
.end method

.method private updateImageList(Landroid/net/Uri;Landroid/net/Uri;I)V
    .locals 7
    .param p1, "imageFile"    # Landroid/net/Uri;
    .param p2, "originalFile"    # Landroid/net/Uri;
    .param p3, "index"    # I

    .prologue
    .line 423
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    if-eqz v5, :cond_0

    .line 424
    new-instance v3, Lcom/poshmark/data_model/models/inner_models/Picture;

    invoke-direct {v3}, Lcom/poshmark/data_model/models/inner_models/Picture;-><init>()V

    .line 425
    .local v3, "p":Lcom/poshmark/data_model/models/inner_models/Picture;
    const-string v5, ""

    invoke-virtual {v3, v5}, Lcom/poshmark/data_model/models/inner_models/Picture;->setId(Ljava/lang/String;)V

    .line 426
    invoke-virtual {v3, p1}, Lcom/poshmark/data_model/models/inner_models/Picture;->setFileUri(Landroid/net/Uri;)V

    .line 427
    invoke-virtual {v3, p2}, Lcom/poshmark/data_model/models/inner_models/Picture;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 428
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-ge p3, v5, :cond_3

    .line 429
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5, p3, v3}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 436
    .end local v3    # "p":Lcom/poshmark/data_model/models/inner_models/Picture;
    :cond_0
    :goto_0
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v4

    .line 437
    .local v4, "size":I
    const/4 v5, 0x4

    if-le v4, v5, :cond_1

    .line 438
    const/4 v4, 0x4

    .line 440
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v4, :cond_5

    .line 441
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/Picture;

    .line 442
    .local v1, "image":Lcom/poshmark/data_model/models/inner_models/Picture;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v5, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 443
    .local v2, "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    if-nez v0, :cond_2

    .line 444
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setCovershotStatus(Z)V

    .line 447
    :cond_2
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->isRemote()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 448
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getPictureUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setRemoteImageInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 440
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 431
    .end local v0    # "i":I
    .end local v1    # "image":Lcom/poshmark/data_model/models/inner_models/Picture;
    .end local v2    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    .end local v4    # "size":I
    .restart local v3    # "p":Lcom/poshmark/data_model/models/inner_models/Picture;
    :cond_3
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-interface {v5, p3, v3}, Ljava/util/List;->add(ILjava/lang/Object;)V

    goto :goto_0

    .line 450
    .end local v3    # "p":Lcom/poshmark/data_model/models/inner_models/Picture;
    .restart local v0    # "i":I
    .restart local v1    # "image":Lcom/poshmark/data_model/models/inner_models/Picture;
    .restart local v2    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    .restart local v4    # "size":I
    :cond_4
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getPictureFileUri()Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setFileUri(Landroid/net/Uri;)V

    .line 451
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/Picture;->getOriginalPictureFileUri()Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v2, v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setOriginalFileUri(Landroid/net/Uri;)V

    goto :goto_2

    .line 454
    .end local v1    # "image":Lcom/poshmark/data_model/models/inner_models/Picture;
    .end local v2    # "imageView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_5
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->updateImageOrder()V

    .line 456
    return-void
.end method

.method private updateImageOrder()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 1092
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v0, v4, :cond_1

    .line 1093
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 1094
    .local v2, "img1":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    add-int/lit8 v5, v0, 0x1

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 1095
    .local v3, "img2":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-virtual {v2, v6}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setAsNextSelector(Z)V

    .line 1096
    invoke-virtual {v3, v6}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setAsNextSelector(Z)V

    .line 1098
    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1099
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getFileUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setFileUri(Landroid/net/Uri;)V

    .line 1100
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getOriginalFileUri()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setOriginalFileUri(Landroid/net/Uri;)V

    .line 1101
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setRemoteImageInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 1102
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v4

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->imageAssignedState(Z)V

    .line 1103
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getImageBitmap()Landroid/graphics/Bitmap;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 1104
    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->resetImageView()V

    .line 1092
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1108
    .end local v2    # "img1":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    .end local v3    # "img2":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_1
    const/4 v0, 0x0

    :goto_1
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-ge v0, v4, :cond_2

    .line 1109
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v4, v4, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 1110
    .local v1, "img":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v4

    if-nez v4, :cond_3

    .line 1111
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->setAsNextSelector(Z)V

    .line 1115
    .end local v1    # "img":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_2
    return-void

    .line 1108
    .restart local v1    # "img":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method private validInput()Z
    .locals 2

    .prologue
    .line 929
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->titleEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/NewListing;->setTitle(Ljava/lang/String;)V

    .line 930
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->descriptionEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/NewListing;->setDescription(Ljava/lang/String;)V

    .line 931
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/NewListing;->isValidListing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 932
    const v0, 0x7f0600d0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/NewListing;->getInputError()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 933
    const/4 v0, 0x0

    .line 935
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public handleBack()Z
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 494
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isListingDeleted:Z

    if-eqz v1, :cond_0

    .line 495
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->finishActivity()V

    .line 515
    :goto_0
    return v4

    .line 499
    :cond_0
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    if-eqz v1, :cond_1

    const v1, 0x7f060070

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 500
    .local v0, "msg":Ljava/lang/String;
    :goto_1
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v2, 0x1080027

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const v2, 0x7f06006d

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const v2, 0x7f0602cd

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/ListingEditorFragment$6;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$6;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const v2, 0x7f0601ce

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0

    .line 499
    .end local v0    # "msg":Ljava/lang/String;
    :cond_1
    const v1, 0x7f06006f

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public hideKeyboard()V
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->titleEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->clearFocus()V

    .line 209
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->brandEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/LabelledEditText;->clearFocus()V

    .line 210
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/LabelledEditText;->clearFocus()V

    .line 211
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/LabelledEditText;->clearFocus()V

    .line 212
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->hideKeyboard()V

    .line 213
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 143
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 144
    sget-object v0, Landroid/os/Environment;->DIRECTORY_PICTURES:Ljava/lang/String;

    invoke-static {v0}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->storage_path:Ljava/io/File;

    .line 145
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupImageList()V

    .line 146
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupTouchListeners()V

    .line 147
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupPriceValidators()V

    .line 148
    if-eqz p1, :cond_1

    .line 149
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->restoreState(Landroid/os/Bundle;)V

    .line 160
    :goto_0
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    if-eqz v0, :cond_0

    .line 161
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getShareBannerImage()V

    .line 163
    :cond_0
    return-void

    .line 151
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    sget-object v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->LISTING_SETUP_STATE:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    if-ne v0, v1, :cond_3

    .line 152
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    if-nez v0, :cond_2

    .line 153
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupExistingListing()V

    .line 155
    :cond_2
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handleNewState(Landroid/content/Intent;)V

    goto :goto_0

    .line 158
    :cond_3
    sget-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v1, 0x0

    .line 520
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 521
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 522
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 523
    invoke-direct {p0, p3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handleNewState(Landroid/content/Intent;)V

    .line 526
    :cond_0
    if-nez p2, :cond_2

    .line 527
    sget-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    .line 528
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->imageList:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v0

    if-nez v0, :cond_1

    .line 532
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->finishActivity()V

    .line 537
    :cond_1
    :goto_0
    return-void

    .line 535
    :cond_2
    sget-object v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->EDIT_LISTING:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 119
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 120
    if-nez p1, :cond_0

    .line 121
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "NFS_ENABLED"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNFSEnabled:Z

    .line 122
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "NEW_LISTING"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    .line 123
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    if-nez v0, :cond_0

    .line 124
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "ID"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingId:Ljava/lang/String;

    .line 125
    const-class v0, Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingDetails;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    .line 128
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 132
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 133
    const v1, 0x7f03006b

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 135
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f06016c

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setTitle(I)V

    .line 136
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->createViewHolder(Landroid/view/View;)V

    .line 138
    return-object v0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 175
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 178
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    if-eqz v2, :cond_0

    .line 179
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-static {v2}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 180
    .local v0, "json":Ljava/lang/String;
    const-string v2, "NEW_LISTING_INFO_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    .end local v0    # "json":Ljava/lang/String;
    :cond_0
    new-instance v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$1;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment$1;->getType()Ljava/lang/reflect/Type;

    move-result-object v1

    .line 184
    .local v1, "listOfObject":Ljava/lang/reflect/Type;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->imageList:Ljava/util/List;

    invoke-static {v2, v1}, Lcom/poshmark/utils/StringUtils;->imageListToJson(Ljava/util/List;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v0

    .line 185
    .restart local v0    # "json":Ljava/lang/String;
    const-string v2, "IMAGE_LIST_JSON"

    invoke-virtual {p1, v2, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    const-string v2, "NEW_LISTING_FLAG"

    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 188
    const-string v2, "CURRENT_STATE"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentState:Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment$LISTING_STATES;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    const-string v2, "CURRENT_ACTIVE_IMAGE"

    iget v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageIndex:I

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 190
    const-string v2, "LISTING_ID"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->listingId:Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    const-string v2, "IS_NFS_ENABLED"

    iget-boolean v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNFSEnabled:Z

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 192
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 240
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->isNewListing:Z

    if-eqz v0, :cond_0

    .line 241
    const-string v0, "new_listing_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 244
    :goto_0
    return-void

    .line 243
    :cond_0
    const-string v0, "edit_listing_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 167
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 168
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->showRefreshButton(Z)V

    .line 169
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupActionBarNextActionButton()V

    .line 170
    const v0, 0x7f06016c

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->setTitle(I)V

    .line 171
    return-void
.end method
