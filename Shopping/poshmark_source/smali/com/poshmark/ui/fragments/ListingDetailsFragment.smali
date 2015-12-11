.class public Lcom/poshmark/ui/fragments/ListingDetailsFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ListingDetailsFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/ListingNotificationHandler;
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field static AVAILABLE:Ljava/lang/String;

.field static NOT_FOR_SALE:Ljava/lang/String;

.field static RESERVED:Ljava/lang/String;

.field static SOLD:Ljava/lang/String;


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

.field bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

.field bannerJson:Ljava/lang/String;

.field deleteButtonListener:Landroid/view/View$OnClickListener;

.field detailsListView:Landroid/widget/ListView;

.field drawerFragment:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

.field drawerListener:Landroid/support/v4/widget/DrawerLayout$DrawerListener;

.field footerView:Landroid/view/View;

.field headerContainerView:Landroid/widget/LinearLayout;

.field isEditListingWithNFSEnabled:Ljava/lang/Boolean;

.field listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

.field listingId:Ljava/lang/String;

.field listingImages:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/ui/customviews/PMListingImageView;",
            ">;"
        }
    .end annotation
.end field

.field listingNoMore:Z

.field menuButton:I

.field textFormatter:Lcom/poshmark/utils/TextFormatter;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 122
    const-string v0, "AVAILABLE"

    sput-object v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->AVAILABLE:Ljava/lang/String;

    .line 123
    const-string v0, "NOT_FOR_SALE"

    sput-object v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->NOT_FOR_SALE:Ljava/lang/String;

    .line 124
    const-string v0, "SOLD"

    sput-object v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->SOLD:Ljava/lang/String;

    .line 125
    const-string v0, "RESERVED"

    sput-object v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->RESERVED:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 111
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    .line 112
    new-instance v0, Lcom/poshmark/utils/TextFormatter;

    invoke-direct {v0}, Lcom/poshmark/utils/TextFormatter;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    .line 113
    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingNoMore:Z

    .line 114
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingImages:Ljava/util/List;

    .line 117
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isEditListingWithNFSEnabled:Ljava/lang/Boolean;

    .line 1078
    new-instance v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->deleteButtonListener:Landroid/view/View$OnClickListener;

    .line 1417
    new-instance v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$24;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$24;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerListener:Landroid/support/v4/widget/DrawerLayout$DrawerListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateCursorData()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setupActionBarNextActionButton()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateView()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->toggleListingLikedButtons()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->shareListing()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .prologue
    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewBundle()V

    return-void
.end method

.method private createAllViews(Landroid/view/View;)V
    .locals 7
    .param p1, "rootView"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x4

    const/4 v4, 0x0

    .line 499
    const v2, 0x7f0c0181

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->detailsListView:Landroid/widget/ListView;

    .line 500
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->detailsListView:Landroid/widget/ListView;

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->setParentListView(Landroid/widget/ListView;)V

    .line 502
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 503
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f030064

    invoke-virtual {v0, v2, v4, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    .line 504
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->detailsListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 506
    const v2, 0x7f030068

    invoke-virtual {v0, v2, v4, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->footerView:Landroid/view/View;

    .line 507
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->footerView:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 508
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->detailsListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->footerView:Landroid/view/View;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 511
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->detailsListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 514
    const v2, 0x7f030074

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 515
    .local v1, "v":Landroid/view/View;
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 516
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x2

    invoke-virtual {v2, v1, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 518
    const v2, 0x7f030067

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 519
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 520
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v1, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 526
    const v2, 0x7f030062

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 527
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 528
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v1, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 530
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FeatureManager;->isAddToBundleButtonFeatureEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 531
    const v2, 0x7f030009

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 532
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 533
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v1, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 537
    :cond_0
    const v2, 0x7f030077

    invoke-virtual {v0, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 538
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 539
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->headerContainerView:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v2, v1, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 540
    return-void
.end method

.method private fetchListingDetails()V
    .locals 3

    .prologue
    .line 260
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060190

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 261
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "vw_l"

    invoke-static {v1, v2}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 262
    .local v0, "trackingJSON":Ljava/lang/String;
    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->postGoalTrackingInfo(Ljava/lang/String;)V

    .line 263
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$2;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-static {v1, v2}, Lcom/poshmark/http/api/PMApi;->getListingDetails(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 285
    return-void
.end method

.method private insertListingImages(Landroid/widget/LinearLayout;)V
    .locals 14
    .param p1, "containerView"    # Landroid/widget/LinearLayout;

    .prologue
    const/4 v13, 0x0

    const/4 v12, -0x1

    const/4 v11, -0x2

    const/4 v10, 0x0

    .line 677
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-virtual {v8}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v8

    const/high16 v9, 0x40000000    # 2.0f

    invoke-static {v8, v9}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v8

    float-to-int v5, v8

    .line 679
    .local v5, "margin":I
    const v8, 0x7f0c018f

    invoke-virtual {p1, v8}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 680
    .local v0, "imagesLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViewsInLayout()V

    .line 683
    new-instance v3, Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-direct {v3, v8, v13}, Lcom/poshmark/ui/customviews/PMListingImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 684
    .local v3, "iv":Lcom/poshmark/ui/customviews/PMListingImageView;
    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 685
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingImages:Ljava/util/List;

    invoke-interface {v8, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 687
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v4, v12, v11}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 688
    .local v4, "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v3, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 689
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingDetails;->getCovershot()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 692
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingDetails;->getPictures()Ljava/util/List;

    move-result-object v7

    .line 693
    .local v7, "picArray":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Picture;>;"
    if-eqz v7, :cond_0

    .line 694
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 695
    .local v2, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/Picture;>;"
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 696
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/data_model/models/inner_models/Picture;

    .line 698
    .local v6, "pic":Lcom/poshmark/data_model/models/inner_models/Picture;
    new-instance v1, Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-direct {v1, v8, v13}, Lcom/poshmark/ui/customviews/PMListingImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 699
    .local v1, "img":Lcom/poshmark/ui/customviews/PMListingImageView;
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 700
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingImages:Ljava/util/List;

    invoke-interface {v8, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 702
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    .end local v4    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct {v4, v12, v11}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 703
    .restart local v4    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v4, v10, v5, v10, v10}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 704
    invoke-virtual {v1, v4}, Lcom/poshmark/ui/customviews/PMListingImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 706
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/Picture;->getPictureUrl()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v8}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    goto :goto_0

    .line 709
    .end local v1    # "img":Lcom/poshmark/ui/customviews/PMListingImageView;
    .end local v2    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/inner_models/Picture;>;"
    .end local v6    # "pic":Lcom/poshmark/data_model/models/inner_models/Picture;
    :cond_0
    return-void
.end method

.method private setActionBarLikeButtonState(Z)V
    .locals 5
    .param p1, "liked"    # Z

    .prologue
    .line 1037
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 1038
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 1039
    .local v1, "customView":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 1040
    const v4, 0x7f0c0045

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageButton;

    .line 1041
    .local v2, "likeButton":Landroid/widget/ImageButton;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 1042
    .local v3, "resources":Landroid/content/res/Resources;
    if-eqz p1, :cond_1

    .line 1043
    const v4, 0x7f0200a0

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/ImageButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1048
    .end local v2    # "likeButton":Landroid/widget/ImageButton;
    .end local v3    # "resources":Landroid/content/res/Resources;
    :cond_0
    :goto_0
    return-void

    .line 1045
    .restart local v2    # "likeButton":Landroid/widget/ImageButton;
    .restart local v3    # "resources":Landroid/content/res/Resources;
    :cond_1
    const v4, 0x7f02009e

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/ImageButton;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method private setLikeButtonState(Landroid/widget/Button;Z)V
    .locals 3
    .param p1, "likeButton"    # Landroid/widget/Button;
    .param p2, "liked"    # Z

    .prologue
    const/4 v2, 0x0

    .line 1066
    if-eqz p1, :cond_0

    .line 1067
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 1068
    .local v0, "resources":Landroid/content/res/Resources;
    if-eqz p2, :cond_1

    .line 1069
    const v1, 0x7f020017

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1070
    const v1, 0x7f020095

    invoke-virtual {p1, v1, v2, v2, v2}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 1076
    .end local v0    # "resources":Landroid/content/res/Resources;
    :cond_0
    :goto_0
    return-void

    .line 1072
    .restart local v0    # "resources":Landroid/content/res/Resources;
    :cond_1
    const v1, 0x7f020016

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1073
    const v1, 0x7f020093

    invoke-virtual {p1, v1, v2, v2, v2}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    goto :goto_0
.end method

.method private setLikeButtonState(Landroid/widget/ImageView;Z)V
    .locals 4
    .param p1, "likeButton"    # Landroid/widget/ImageView;
    .param p2, "liked"    # Z

    .prologue
    const v3, 0x7f0c018a

    .line 1051
    if-eqz p1, :cond_0

    .line 1052
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 1053
    .local v0, "resources":Landroid/content/res/Resources;
    if-eqz p2, :cond_1

    .line 1054
    const v2, 0x7f0200a0

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1055
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 1056
    .local v1, "text":Lcom/poshmark/ui/customviews/PMTextView;
    const v2, 0x7f060164

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 1063
    .end local v0    # "resources":Landroid/content/res/Resources;
    .end local v1    # "text":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_0
    :goto_0
    return-void

    .line 1058
    .restart local v0    # "resources":Landroid/content/res/Resources;
    :cond_1
    const v2, 0x7f02009e

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1059
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 1060
    .restart local v1    # "text":Lcom/poshmark/ui/customviews/PMTextView;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const v3, 0x7f060163

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method private setupActionBarNextActionButton()V
    .locals 12

    .prologue
    const v11, 0x7f0c0043

    const v10, 0x7f0c003e

    .line 330
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v8

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v9

    invoke-virtual {v9}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 331
    iput v10, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->menuButton:I

    .line 333
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-virtual {v8}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 334
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 335
    .local v2, "customView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 336
    invoke-virtual {v2, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout;

    .line 337
    .local v1, "buttonContainer":Landroid/widget/FrameLayout;
    const/4 v8, 0x0

    invoke-virtual {v1, v8}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 339
    const v8, 0x7f0c0045

    invoke-virtual {v2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    .line 340
    .local v3, "likeButton":Landroid/widget/ImageButton;
    new-instance v8, Lcom/poshmark/ui/fragments/ListingDetailsFragment$3;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$3;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v3, v8}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 347
    const v8, 0x7f0c0046

    invoke-virtual {v2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageButton;

    .line 348
    .local v7, "shareButton":Landroid/widget/ImageButton;
    new-instance v8, Lcom/poshmark/ui/fragments/ListingDetailsFragment$4;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$4;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v7, v8}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 355
    invoke-virtual {v2, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageButton;

    .line 356
    .local v4, "menuButton":Landroid/widget/ImageButton;
    new-instance v8, Lcom/poshmark/ui/fragments/ListingDetailsFragment$5;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$5;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v4, v8}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 395
    .end local v1    # "buttonContainer":Landroid/widget/FrameLayout;
    .end local v3    # "likeButton":Landroid/widget/ImageButton;
    .end local v4    # "menuButton":Landroid/widget/ImageButton;
    .end local v7    # "shareButton":Landroid/widget/ImageButton;
    :cond_0
    :goto_0
    return-void

    .line 364
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v2    # "customView":Landroid/view/View;
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-virtual {v8}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 365
    .restart local v0    # "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 366
    .restart local v2    # "customView":Landroid/view/View;
    if-eqz v2, :cond_2

    .line 367
    invoke-virtual {v2, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout;

    .line 368
    .restart local v1    # "buttonContainer":Landroid/widget/FrameLayout;
    const/4 v8, 0x4

    invoke-virtual {v1, v8}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 370
    .end local v1    # "buttonContainer":Landroid/widget/FrameLayout;
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getNextActionButton()Landroid/widget/Button;

    move-result-object v5

    .line 371
    .local v5, "nextActionButton":Landroid/widget/Button;
    if-eqz v5, :cond_3

    .line 372
    invoke-virtual {v5}, Landroid/widget/Button;->getId()I

    move-result v8

    iput v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->menuButton:I

    .line 373
    const v8, 0x7f0600c3

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 374
    const v8, 0x7f06016c

    invoke-virtual {p0, v8}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setTitle(I)V

    .line 377
    :cond_3
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isEditListingWithNFSEnabled:Ljava/lang/Boolean;

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-eqz v8, :cond_4

    if-eqz v5, :cond_4

    .line 378
    new-instance v8, Lcom/poshmark/ui/fragments/ListingDetailsFragment$6;

    invoke-direct {v8, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$6;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v5, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 386
    :cond_4
    const-class v8, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    iget v9, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->menuButton:I

    invoke-virtual {p0, v8, p0, v9, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setDrawerActionButton(Ljava/lang/Class;Lcom/poshmark/ui/fragments/PMFragment;ILjava/lang/Object;)Lcom/poshmark/ui/fragments/PMFragment;

    move-result-object v8

    check-cast v8, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    iput-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerFragment:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    .line 387
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerFragment:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    if-eqz v8, :cond_0

    .line 388
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    check-cast v6, Lcom/poshmark/ui/PMContainerActivity;

    .line 389
    .local v6, "parent":Lcom/poshmark/ui/PMContainerActivity;
    if-eqz v6, :cond_0

    .line 390
    iget-object v8, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerListener:Landroid/support/v4/widget/DrawerLayout$DrawerListener;

    invoke-virtual {v6, v8}, Lcom/poshmark/ui/PMContainerActivity;->setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V

    goto :goto_0
.end method

.method private setupBottomBar()V
    .locals 19

    .prologue
    .line 1121
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v17

    const v18, 0x7f0c00ab

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v15

    .line 1122
    .local v15, "v":Landroid/view/View;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->setVisibility(I)V

    .line 1131
    const v17, 0x7f0c0186

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 1132
    .local v2, "buyButton":Landroid/widget/Button;
    const v17, 0x7f0c0185

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v16

    check-cast v16, Landroid/widget/Button;

    .line 1133
    .local v16, "viewOfferButton":Landroid/widget/Button;
    const v17, 0x7f0c0184

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/Button;

    .line 1134
    .local v11, "makeOfferButton":Landroid/widget/Button;
    const v17, 0x7f0c0127

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Lcom/poshmark/ui/customviews/ListingStatusView;

    .line 1136
    .local v14, "statusView":Lcom/poshmark/ui/customviews/ListingStatusView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v10

    .line 1137
    .local v10, "listingStatus":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    .line 1140
    .local v3, "currentUserId":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    .line 1141
    .local v7, "isMyListing":Z
    const/4 v6, 0x0

    .line 1142
    .local v6, "isAnyOfferButtonVisible":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->hasOffers()Z

    move-result v4

    .line 1143
    .local v4, "hasOffers":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->haveIOffered()Z

    move-result v5

    .line 1144
    .local v5, "iHaveOffered":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->isPriceValidForOffer()Z

    move-result v8

    .line 1146
    .local v8, "isPriceValidForOffer":Z
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/FeatureManager;->isMakeAnOfferEnabled()Z

    move-result v17

    if-eqz v17, :cond_0

    if-eqz v8, :cond_0

    sget-object v17, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-object/from16 v0, v17

    if-ne v10, v0, :cond_0

    .line 1147
    if-eqz v7, :cond_5

    .line 1148
    if-eqz v4, :cond_0

    .line 1149
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 1150
    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setVisibility(I)V

    .line 1151
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->getOfferCount()I

    move-result v17

    const/16 v18, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-le v0, v1, :cond_4

    .line 1152
    const v17, 0x7f0602c0

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 1156
    :goto_0
    const/4 v6, 0x1

    .line 1157
    new-instance v17, Lcom/poshmark/ui/fragments/ListingDetailsFragment$19;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$19;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1209
    :cond_0
    :goto_1
    sget-object v17, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-object/from16 v0, v17

    if-ne v10, v0, :cond_7

    if-nez v7, :cond_7

    .line 1210
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v2, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 1211
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    .line 1213
    if-nez v6, :cond_1

    .line 1214
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 1215
    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setVisibility(I)V

    .line 1218
    :cond_1
    new-instance v17, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$22;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1240
    :cond_2
    :goto_2
    const v17, 0x7f0c0187

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Lcom/poshmark/ui/customviews/PMPriceLayout;

    .line 1241
    .local v13, "priceLayout":Lcom/poshmark/ui/customviews/PMPriceLayout;
    if-eqz v13, :cond_3

    .line 1242
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/ListingDetails;->getPrice()Ljava/math/BigDecimal;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 1243
    .local v9, "listingPrice":Ljava/lang/String;
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lcom/poshmark/data_model/models/ListingDetails;->getOriginalPrice()Ljava/math/BigDecimal;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 1244
    .local v12, "originalPrice":Ljava/lang/String;
    invoke-virtual {v13, v9, v12}, Lcom/poshmark/ui/customviews/PMPriceLayout;->setListingPrices(Ljava/lang/String;Ljava/lang/String;)V

    .line 1246
    .end local v9    # "listingPrice":Ljava/lang/String;
    .end local v12    # "originalPrice":Ljava/lang/String;
    :cond_3
    return-void

    .line 1154
    .end local v13    # "priceLayout":Lcom/poshmark/ui/customviews/PMPriceLayout;
    :cond_4
    const v17, 0x7f0602c6

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 1173
    :cond_5
    if-eqz v5, :cond_6

    .line 1174
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 1175
    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setVisibility(I)V

    .line 1176
    const/4 v6, 0x1

    .line 1177
    new-instance v17, Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$20;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_1

    .line 1192
    :cond_6
    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setVisibility(I)V

    .line 1193
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 1194
    const/4 v6, 0x1

    .line 1195
    new-instance v17, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$21;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_1

    .line 1230
    :cond_7
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v2, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 1231
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Lcom/poshmark/ui/customviews/ListingStatusView;->setVisibility(I)V

    .line 1232
    invoke-virtual {v14, v10}, Lcom/poshmark/ui/customviews/ListingStatusView;->setListingStatus(Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;)V

    .line 1233
    if-nez v6, :cond_2

    .line 1234
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/widget/Button;->setVisibility(I)V

    .line 1235
    const/16 v17, 0x8

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method private setupListItemClickListener()V
    .locals 2

    .prologue
    .line 185
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isUserAdmin()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->detailsListView:Landroid/widget/ListView;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 221
    :cond_0
    return-void
.end method

.method private shareListing()V
    .locals 5

    .prologue
    .line 978
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "share_button_tapped"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 980
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->getCovershot()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$17;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$17;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 1015
    return-void
.end method

.method private toggleListingLikedButtons()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 1018
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingDetails;->getListingLikeStatus()Z

    move-result v3

    if-nez v3, :cond_0

    const/4 v1, 0x1

    .line 1022
    .local v1, "newLikeState":Z
    :goto_0
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingLikedMessage(Ljava/lang/String;Z)V

    .line 1023
    if-eqz v1, :cond_1

    .line 1024
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    check-cast v3, Landroid/app/Activity;

    const-string v4, "lk"

    invoke-static {v3, v4}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1025
    .local v2, "trackingJSON":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listing_details_screen"

    const-string v5, "listing"

    const-string v6, "like"

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1026
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-static {v3}, Lcom/poshmark/utils/FBDPAHelper;->trackListingLike(Lcom/poshmark/data_model/models/ListingSummary;)V

    .line 1027
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v2, v7}, Lcom/poshmark/http/api/PMApi;->like(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1028
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v0

    .line 1029
    .local v0, "logger":Lcom/facebook/appevents/AppEventsLogger;
    const-string v3, "like"

    invoke-virtual {v0, v3}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;)V

    .line 1034
    .end local v0    # "logger":Lcom/facebook/appevents/AppEventsLogger;
    .end local v2    # "trackingJSON":Ljava/lang/String;
    :goto_1
    return-void

    .line 1018
    .end local v1    # "newLikeState":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 1031
    .restart local v1    # "newLikeState":Z
    :cond_1
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "listing_details_screen"

    const-string v5, "listing"

    const-string v6, "unlike"

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1032
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3, v7}, Lcom/poshmark/http/api/PMApi;->unLike(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_1
.end method

.method private updateActionButtons(Landroid/widget/LinearLayout;)V
    .locals 10
    .param p1, "containerView"    # Landroid/widget/LinearLayout;

    .prologue
    const/4 v9, 0x0

    .line 869
    const v7, 0x7f0c0167

    invoke-virtual {p1, v7}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 870
    .local v6, "v":Landroid/view/View;
    invoke-virtual {v6, v9}, Landroid/view/View;->setVisibility(I)V

    .line 872
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ListingDetails;->getListingLikeStatus()Z

    move-result v7

    invoke-direct {p0, v7}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setActionBarLikeButtonState(Z)V

    .line 873
    const v7, 0x7f0c004e

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 874
    .local v1, "likeButton":Landroid/widget/ImageView;
    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ListingDetails;->getListingLikeStatus()Z

    move-result v7

    invoke-direct {p0, v1, v7}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setLikeButtonState(Landroid/widget/ImageView;Z)V

    .line 875
    const v7, 0x7f0c0189

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 876
    .local v2, "likeButtonLayout":Landroid/widget/LinearLayout;
    new-instance v7, Lcom/poshmark/ui/fragments/ListingDetailsFragment$13;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$13;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v2, v7}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 884
    const v7, 0x7f0c0174

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 885
    .local v0, "commentButton":Landroid/widget/LinearLayout;
    new-instance v7, Lcom/poshmark/ui/fragments/ListingDetailsFragment$14;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$14;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 896
    const v7, 0x7f0c018c

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/LinearLayout;

    .line 897
    .local v5, "shareButton":Landroid/widget/LinearLayout;
    new-instance v7, Lcom/poshmark/ui/fragments/ListingDetailsFragment$15;

    invoke-direct {v7, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$15;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v5, v7}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 905
    invoke-virtual {v6}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout$LayoutParams;

    .line 906
    .local v4, "params":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-virtual {v7}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const/high16 v8, 0x41400000    # 12.0f

    invoke-static {v7, v8}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v7

    float-to-int v3, v7

    .line 907
    .local v3, "margin":I
    invoke-virtual {v4, v9, v3, v9, v9}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 908
    invoke-virtual {v6, v4}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 909
    return-void
.end method

.method private updateAddToBundleButton(Landroid/widget/LinearLayout;)V
    .locals 4
    .param p1, "containerView"    # Landroid/widget/LinearLayout;

    .prologue
    .line 912
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->isAddToBundleButtonFeatureEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 913
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->getAddToBundleButtonFeature()Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;

    move-result-object v1

    .line 914
    .local v1, "feature":Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;
    const v3, 0x7f0c004c

    invoke-virtual {p1, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 915
    .local v2, "v":Landroid/view/View;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 916
    const v3, 0x7f0c004f

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTextView;

    .line 917
    .local v0, "btnLabel":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 919
    new-instance v3, Lcom/poshmark/ui/fragments/ListingDetailsFragment$16;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$16;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 927
    .end local v0    # "btnLabel":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v1    # "feature":Lcom/poshmark/data_model/models/inner_models/AddToBundleButtonFeature;
    .end local v2    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method private updateCategoryAndColorsInfo(Landroid/widget/LinearLayout;)V
    .locals 16
    .param p1, "containerView"    # Landroid/widget/LinearLayout;

    .prologue
    .line 825
    const v14, 0x7f0c0169

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/LinearLayout;

    .line 826
    .local v10, "section":Landroid/widget/LinearLayout;
    const/4 v14, 0x0

    invoke-virtual {v10, v14}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 828
    const v14, 0x7f0c016a

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 829
    .local v2, "categoryText":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v14}, Lcom/poshmark/data_model/models/ListingDetails;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v1

    .line 830
    .local v1, "category":Lcom/poshmark/data_model/models/MetaItem;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v2, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 831
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v2, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 832
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    invoke-virtual {v2, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 834
    const v14, 0x7f0c016b

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 835
    .local v11, "subCategoryText":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v14}, Lcom/poshmark/data_model/models/ListingDetails;->getSubCategoryList()Ljava/util/List;

    move-result-object v12

    .line 836
    .local v12, "subCats":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    if-eqz v12, :cond_0

    invoke-interface {v12}, Ljava/util/List;->isEmpty()Z

    move-result v14

    if-nez v14, :cond_0

    .line 837
    const/4 v14, 0x0

    invoke-virtual {v11, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    .line 838
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 839
    invoke-virtual {v11, v12}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 840
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    invoke-virtual {v11, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 841
    const/4 v14, 0x0

    invoke-interface {v12, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/poshmark/data_model/models/MetaItem;

    invoke-virtual {v14}, Lcom/poshmark/data_model/models/MetaItem;->getDisplay()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 847
    :goto_0
    const v14, 0x7f0c016c

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 848
    .local v4, "colorSectionContainer":Landroid/widget/LinearLayout;
    const/16 v14, 0x8

    invoke-virtual {v4, v14}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 849
    const v14, 0x7f0c016d

    move-object/from16 v0, p1

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lorg/apmem/tools/layouts/FlowLayout;

    .line 850
    .local v6, "individualColorContainer":Lorg/apmem/tools/layouts/FlowLayout;
    invoke-virtual {v6}, Lorg/apmem/tools/layouts/FlowLayout;->removeAllViews()V

    .line 851
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v14}, Lcom/poshmark/data_model/models/ListingDetails;->getColorList()Ljava/util/List;

    move-result-object v5

    .line 852
    .local v5, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    if-eqz v5, :cond_1

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v14

    if-nez v14, :cond_1

    .line 853
    const/4 v14, 0x0

    invoke-virtual {v4, v14}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 854
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v14

    invoke-static {v14}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v7

    .line 855
    .local v7, "inflater":Landroid/view/LayoutInflater;
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .line 856
    .local v8, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v14

    if-eqz v14, :cond_1

    .line 857
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/poshmark/data_model/models/PMColor;

    .line 858
    .local v3, "color":Lcom/poshmark/data_model/models/PMColor;
    const v14, 0x7f030063

    const/4 v15, 0x0

    invoke-virtual {v7, v14, v15}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v13

    check-cast v13, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;

    .line 859
    .local v13, "v":Lcom/poshmark/ui/customviews/ListingDetailsColorItem;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v14, -0x2

    const/4 v15, -0x2

    invoke-direct {v9, v14, v15}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 860
    .local v9, "lp":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v6, v13}, Lorg/apmem/tools/layouts/FlowLayout;->addView(Landroid/view/View;)V

    .line 861
    invoke-virtual {v13, v3}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->setColor(Lcom/poshmark/data_model/models/PMColor;)V

    .line 862
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    invoke-virtual {v13, v14}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 863
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v14}, Lcom/poshmark/data_model/models/ListingDetails;->getCategoryId()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Lcom/poshmark/ui/customviews/ListingDetailsColorItem;->setCategory(Ljava/lang/String;)V

    goto :goto_1

    .line 843
    .end local v3    # "color":Lcom/poshmark/data_model/models/PMColor;
    .end local v4    # "colorSectionContainer":Landroid/widget/LinearLayout;
    .end local v5    # "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v6    # "individualColorContainer":Lorg/apmem/tools/layouts/FlowLayout;
    .end local v7    # "inflater":Landroid/view/LayoutInflater;
    .end local v8    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PMColor;>;"
    .end local v9    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v13    # "v":Lcom/poshmark/ui/customviews/ListingDetailsColorItem;
    :cond_0
    const/4 v14, 0x4

    invoke-virtual {v11, v14}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    goto :goto_0

    .line 866
    .restart local v4    # "colorSectionContainer":Landroid/widget/LinearLayout;
    .restart local v5    # "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    .restart local v6    # "individualColorContainer":Lorg/apmem/tools/layouts/FlowLayout;
    :cond_1
    return-void
.end method

.method private updateCursorData()V
    .locals 4

    .prologue
    .line 571
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getUserVisibleHint()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-eqz v1, :cond_0

    .line 572
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 573
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/ListingDetails;->fillCursorForComments(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 574
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 575
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->notifyDataSetChanged()V

    .line 577
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method

.method private updateListingFooter()V
    .locals 0

    .prologue
    .line 975
    return-void
.end method

.method private updateListingHeader(Landroid/widget/LinearLayout;)V
    .locals 19
    .param p1, "containerView"    # Landroid/widget/LinearLayout;

    .prologue
    .line 581
    const v17, 0x7f0c011f

    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v16

    .line 582
    .local v16, "v":Landroid/view/View;
    const/16 v17, 0x0

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->setVisibility(I)V

    .line 584
    const v17, 0x7f0c011b

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 585
    .local v3, "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v8

    .line 586
    .local v8, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->getAvataar()Ljava/lang/String;

    move-result-object v17

    if-eqz v17, :cond_5

    .line 587
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->getAvataar()Ljava/lang/String;

    move-result-object v17

    iget-object v0, v3, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v8, v0, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 592
    :goto_0
    const v17, 0x7f0c01cd

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Lcom/poshmark/ui/customviews/PMTextView;

    .line 593
    .local v15, "usernameView":Lcom/poshmark/ui/customviews/PMTextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->getUserName()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setUserName(Ljava/lang/String;)V

    .line 595
    const v17, 0x7f0c011c

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 596
    .local v2, "attributionView":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->textFormatter:Lcom/poshmark/utils/TextFormatter;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v18}, Lcom/poshmark/utils/TextFormatter;->getPublishedAtMessageString(Lcom/poshmark/data_model/models/ListingSocial;)Ljava/lang/String;

    move-result-object v14

    .line 597
    .local v14, "sharedMsgString":Ljava/lang/String;
    invoke-virtual {v2, v14}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 600
    const v17, 0x7f0c01ce

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/ImageView;

    .line 601
    .local v10, "priceDropButton":Landroid/widget/ImageView;
    const v17, 0x7f0c01cf

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Lcom/poshmark/ui/customviews/PMTextView;

    .line 602
    .local v11, "priceDropTextView":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/utils/FeatureManager;->isListingDetailsPriceDropEnabled()Z

    move-result v17

    if-eqz v17, :cond_0

    .line 603
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/poshmark/data_model/models/ListingDetails;->getPriceDropPercentage()I

    move-result v7

    .line 604
    .local v7, "dropPercentage":I
    if-lez v7, :cond_6

    .line 605
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    .line 606
    .local v12, "resources":Landroid/content/res/Resources;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v10, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 607
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 608
    const v17, 0x7f0200fd

    move/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v10, v0}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 609
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {v7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "%"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 617
    .end local v7    # "dropPercentage":I
    .end local v12    # "resources":Landroid/content/res/Resources;
    :cond_0
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    if-eqz v17, :cond_4

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->message:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_4

    .line 618
    const v17, 0x7f0c01c8

    invoke-virtual/range {v16 .. v17}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/RelativeLayout;

    .line 619
    .local v4, "bannerLayout":Landroid/widget/RelativeLayout;
    if-eqz v4, :cond_4

    .line 620
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 622
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->image_url:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_1

    .line 623
    const v17, 0x7f0c01c9

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ImageView;

    .line 624
    .local v9, "leftIcon":Landroid/widget/ImageView;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v8

    .line 625
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->image_url:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v8, v0, v9}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 629
    .end local v9    # "leftIcon":Landroid/widget/ImageView;
    :cond_1
    const v17, 0x7f0c01cb

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/ImageView;

    .line 630
    .local v13, "rightIcon":Landroid/widget/ImageView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->right_image_url:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_7

    .line 631
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v8

    .line 632
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->right_image_url:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v8, v0, v13}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 638
    :goto_2
    const v17, 0x7f0c01ca

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 640
    .local v5, "bannerText":Lcom/poshmark/ui/customviews/PMTextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->message:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 641
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->text_color:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_2

    .line 642
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x7f090040

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v17

    check-cast v17, Landroid/graphics/drawable/ColorDrawable;

    check-cast v17, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual/range {v17 .. v17}, Landroid/graphics/drawable/ColorDrawable;->getColor()I

    move-result v6

    .line 643
    .local v6, "defaultColor":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->text_color:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-static {v0, v6}, Lcom/poshmark/utils/ColorConverter;->getColorValueFromHexString(Ljava/lang/String;I)I

    move-result v17

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 646
    .end local v6    # "defaultColor":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->background_color:Ljava/lang/String;

    move-object/from16 v17, v0

    if-eqz v17, :cond_3

    .line 647
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x7f090007

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v17

    check-cast v17, Landroid/graphics/drawable/ColorDrawable;

    check-cast v17, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual/range {v17 .. v17}, Landroid/graphics/drawable/ColorDrawable;->getColor()I

    move-result v6

    .line 648
    .restart local v6    # "defaultColor":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/poshmark/data_model/models/BannerInfo;->background_color:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-static {v0, v6}, Lcom/poshmark/utils/ColorConverter;->getColorValueFromHexString(Ljava/lang/String;I)I

    move-result v17

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/RelativeLayout;->setBackgroundColor(I)V

    .line 652
    .end local v6    # "defaultColor":I
    :cond_3
    new-instance v17, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$11;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 674
    .end local v4    # "bannerLayout":Landroid/widget/RelativeLayout;
    .end local v5    # "bannerText":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v13    # "rightIcon":Landroid/widget/ImageView;
    :cond_4
    return-void

    .line 589
    .end local v2    # "attributionView":Landroid/widget/TextView;
    .end local v10    # "priceDropButton":Landroid/widget/ImageView;
    .end local v11    # "priceDropTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v14    # "sharedMsgString":Ljava/lang/String;
    .end local v15    # "usernameView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_5
    const v17, 0x7f0200d4

    move/from16 v0, v17

    invoke-virtual {v3, v0}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap(I)V

    goto/16 :goto_0

    .line 611
    .restart local v2    # "attributionView":Landroid/widget/TextView;
    .restart local v7    # "dropPercentage":I
    .restart local v10    # "priceDropButton":Landroid/widget/ImageView;
    .restart local v11    # "priceDropTextView":Lcom/poshmark/ui/customviews/PMTextView;
    .restart local v14    # "sharedMsgString":Ljava/lang/String;
    .restart local v15    # "usernameView":Lcom/poshmark/ui/customviews/PMTextView;
    :cond_6
    const/16 v17, 0x4

    move/from16 v0, v17

    invoke-virtual {v10, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 612
    const/16 v17, 0x4

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 634
    .end local v7    # "dropPercentage":I
    .restart local v4    # "bannerLayout":Landroid/widget/RelativeLayout;
    .restart local v13    # "rightIcon":Landroid/widget/ImageView;
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x7f0200a6

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_2
.end method

.method private updateListingInfo(Landroid/widget/LinearLayout;)V
    .locals 34
    .param p1, "containerView"    # Landroid/widget/LinearLayout;

    .prologue
    .line 712
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v31

    const/high16 v32, 0x41800000    # 16.0f

    invoke-static/range {v31 .. v32}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v31

    move/from16 v0, v31

    float-to-int v13, v0

    .line 713
    .local v13, "margin":I
    const v31, 0x7f0c00b6

    move-object/from16 v0, p1

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v30

    check-cast v30, Landroid/widget/LinearLayout;

    .line 714
    .local v30, "v":Landroid/widget/LinearLayout;
    const/16 v31, 0x0

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 716
    invoke-virtual/range {v30 .. v30}, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v18

    check-cast v18, Landroid/widget/LinearLayout$LayoutParams;

    .line 717
    .local v18, "params":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v31, 0x0

    const/16 v32, 0x0

    move-object/from16 v0, v18

    move/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v13, v1, v13, v2}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 718
    move-object/from16 v0, v30

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 720
    const v31, 0x7f0c0130

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v29

    check-cast v29, Landroid/widget/TextView;

    .line 721
    .local v29, "titleView":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getTitle()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v29

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 723
    const v31, 0x7f0c007d

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v16

    check-cast v16, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 724
    .local v16, "nwtTextView":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    const/16 v31, 0x2

    const/high16 v32, 0x41200000    # 10.0f

    move-object/from16 v0, v16

    move/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 725
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getCategoryId()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 726
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getSubCategoryList()Ljava/util/List;

    move-result-object v31

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 727
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 729
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->isNWT()Z

    move-result v31

    if-eqz v31, :cond_1

    .line 730
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v31

    const v32, 0x7f0601d6

    invoke-virtual/range {v31 .. v32}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 731
    const/16 v31, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    .line 732
    const/16 v31, 0x1

    invoke-static/range {v31 .. v31}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v31

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setNWTConditionFlag(Ljava/lang/Boolean;)V

    .line 742
    :goto_0
    const v31, 0x7f0c007f

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v19

    check-cast v19, Landroid/widget/TextView;

    .line 743
    .local v19, "priceView":Landroid/widget/TextView;
    new-instance v31, Ljava/lang/StringBuilder;

    invoke-direct/range {v31 .. v31}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v31

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v32, v0

    invoke-virtual/range {v32 .. v32}, Lcom/poshmark/data_model/models/ListingDetails;->getPrice()Ljava/math/BigDecimal;

    move-result-object v32

    invoke-static/range {v32 .. v32}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v19

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 745
    const v31, 0x7f0c0080

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/TextView;

    .line 746
    .local v17, "originalPriceView":Landroid/widget/TextView;
    invoke-virtual/range {v17 .. v17}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v31

    or-int/lit8 v31, v31, 0x10

    move-object/from16 v0, v17

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 747
    new-instance v31, Ljava/lang/StringBuilder;

    invoke-direct/range {v31 .. v31}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v31

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v32, v0

    invoke-virtual/range {v32 .. v32}, Lcom/poshmark/data_model/models/ListingDetails;->getOriginalPrice()Ljava/math/BigDecimal;

    move-result-object v32

    invoke-static/range {v32 .. v32}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsWholeNumber(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v17

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 749
    const v31, 0x7f0c0132

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    .line 750
    .local v5, "categoryImageView":Landroid/widget/ImageView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getCategoryId()Ljava/lang/String;

    move-result-object v4

    .line 751
    .local v4, "category":Ljava/lang/String;
    invoke-static {v4}, Lcom/poshmark/utils/ListingUtils;->getDrawableIconForCategory(Ljava/lang/String;)I

    move-result v10

    .line 752
    .local v10, "id":I
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v31

    move-object/from16 v0, v31

    invoke-virtual {v0, v10}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    .line 753
    .local v6, "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 755
    const v31, 0x7f0c0081

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v23

    check-cast v23, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 756
    .local v23, "sizeView":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    const/16 v31, 0x2

    const/high16 v32, 0x41500000    # 13.0f

    move-object/from16 v0, v23

    move/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 757
    new-instance v31, Ljava/lang/StringBuilder;

    invoke-direct/range {v31 .. v31}, Ljava/lang/StringBuilder;-><init>()V

    const v32, 0x7f060281

    move-object/from16 v0, p0

    move/from16 v1, v32

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v31

    const-string v32, " "

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v31

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v32, v0

    invoke-virtual/range {v32 .. v32}, Lcom/poshmark/data_model/models/ListingDetails;->getSize()Ljava/lang/CharSequence;

    move-result-object v32

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 758
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getCategoryId()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setCategory(Ljava/lang/String;)V

    .line 759
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getSubCategoryList()Ljava/util/List;

    move-result-object v31

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSubCategoryList(Ljava/util/List;)V

    .line 760
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getSize()Ljava/lang/CharSequence;

    move-result-object v31

    invoke-interface/range {v31 .. v31}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setSize(Ljava/lang/String;)V

    .line 761
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, v23

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 763
    const v31, 0x7f0c0134

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/SearchFilterTextView;

    .line 764
    .local v3, "brandView":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    const/16 v31, 0x2

    const/high16 v32, 0x41500000    # 13.0f

    move/from16 v0, v31

    move/from16 v1, v32

    invoke-virtual {v3, v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 765
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getBrand()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v31

    invoke-virtual {v3, v0}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 766
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getBrand()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v31

    invoke-virtual {v3, v0}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setBrand(Ljava/lang/String;)V

    .line 767
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, v31

    invoke-virtual {v3, v0}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setParentScreenNameForAnalytics(Ljava/lang/String;)V

    .line 769
    const v31, 0x7f0c0135

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 770
    .local v7, "descriptionView":Landroid/widget/TextView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getDescription()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v31

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 773
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    .line 774
    .local v20, "resources":Landroid/content/res/Resources;
    const v31, 0x7f0c0197

    invoke-virtual/range {v30 .. v31}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/LinearLayout;

    .line 775
    .local v15, "msgContainer":Landroid/widget/LinearLayout;
    if-eqz v15, :cond_4

    .line 776
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v31

    invoke-static/range {v31 .. v31}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v11

    .line 777
    .local v11, "inflater":Landroid/view/LayoutInflater;
    invoke-virtual {v15}, Landroid/widget/LinearLayout;->removeAllViewsInLayout()V

    .line 778
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->getSystemMessages()Ljava/util/List;

    move-result-object v26

    .line 779
    .local v26, "systemMessages":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/SystemMessage;>;"
    invoke-interface/range {v26 .. v26}, Ljava/util/List;->size()I

    move-result v22

    .line 780
    .local v22, "size":I
    if-lez v22, :cond_0

    .line 782
    const v31, 0x7f03006a

    const/16 v32, 0x0

    const/16 v33, 0x0

    move/from16 v0, v31

    move-object/from16 v1, v32

    move/from16 v2, v33

    invoke-virtual {v11, v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v25

    check-cast v25, Landroid/widget/LinearLayout;

    .line 783
    .local v25, "sys_msg_header":Landroid/widget/LinearLayout;
    const v31, 0x7f0c0198

    move-object/from16 v0, v25

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v28

    check-cast v28, Landroid/widget/TextView;

    .line 784
    .local v28, "titleLabel":Landroid/widget/TextView;
    const/16 v31, 0x0

    move-object/from16 v0, v28

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 785
    const v31, 0x7f0c0199

    move-object/from16 v0, v25

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v27

    .line 786
    .local v27, "titleBorder":Landroid/view/View;
    const/16 v31, 0x0

    move-object/from16 v0, v27

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 787
    move-object/from16 v0, v25

    invoke-virtual {v15, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 789
    .end local v25    # "sys_msg_header":Landroid/widget/LinearLayout;
    .end local v27    # "titleBorder":Landroid/view/View;
    .end local v28    # "titleLabel":Landroid/widget/TextView;
    :cond_0
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    move/from16 v0, v22

    if-ge v8, v0, :cond_4

    .line 793
    const v31, 0x7f03007b

    const/16 v32, 0x0

    const/16 v33, 0x0

    move/from16 v0, v31

    move-object/from16 v1, v32

    move/from16 v2, v33

    invoke-virtual {v11, v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v24

    check-cast v24, Landroid/widget/LinearLayout;

    .line 794
    .local v24, "sys_msg":Landroid/widget/LinearLayout;
    const v31, 0x7f0c01da

    move-object/from16 v0, v24

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 795
    .local v9, "icon":Lcom/poshmark/ui/customviews/PMListingImageView;
    const v31, 0x7f0c01cb

    move-object/from16 v0, v24

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 796
    .local v21, "rightIcon":Lcom/poshmark/ui/customviews/PMListingImageView;
    const v31, 0x7f0c01db

    move-object/from16 v0, v24

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/TextView;

    .line 797
    .local v12, "infoDesc":Landroid/widget/TextView;
    const/16 v31, 0x0

    move-object/from16 v0, v24

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 799
    move-object/from16 v0, v24

    invoke-virtual {v15, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 800
    move-object/from16 v0, v26

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/poshmark/data_model/models/inner_models/SystemMessage;

    .line 801
    .local v14, "msg":Lcom/poshmark/data_model/models/inner_models/SystemMessage;
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->getImageUrl()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v31

    invoke-virtual {v9, v0}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 802
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->getRightImageUrl()Ljava/lang/String;

    move-result-object v31

    if-eqz v31, :cond_3

    invoke-virtual {v14}, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->getRightImageUrl()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Ljava/lang/String;->length()I

    move-result v31

    if-lez v31, :cond_3

    .line 803
    const/16 v31, 0x0

    move-object/from16 v0, v21

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    .line 804
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->getRightImageUrl()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v21

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->loadImage(Ljava/lang/String;)V

    .line 809
    :goto_2
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->getMessageText()Ljava/lang/String;

    move-result-object v31

    invoke-static/range {v31 .. v31}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v31

    move-object/from16 v0, v31

    invoke-virtual {v12, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 810
    new-instance v31, Lcom/poshmark/ui/fragments/ListingDetailsFragment$12;

    move-object/from16 v0, v31

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v14}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$12;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;Lcom/poshmark/data_model/models/inner_models/SystemMessage;)V

    move-object/from16 v0, v24

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 789
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_1

    .line 733
    .end local v3    # "brandView":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    .end local v4    # "category":Ljava/lang/String;
    .end local v5    # "categoryImageView":Landroid/widget/ImageView;
    .end local v6    # "d":Landroid/graphics/drawable/Drawable;
    .end local v7    # "descriptionView":Landroid/widget/TextView;
    .end local v8    # "i":I
    .end local v9    # "icon":Lcom/poshmark/ui/customviews/PMListingImageView;
    .end local v10    # "id":I
    .end local v11    # "inflater":Landroid/view/LayoutInflater;
    .end local v12    # "infoDesc":Landroid/widget/TextView;
    .end local v14    # "msg":Lcom/poshmark/data_model/models/inner_models/SystemMessage;
    .end local v15    # "msgContainer":Landroid/widget/LinearLayout;
    .end local v17    # "originalPriceView":Landroid/widget/TextView;
    .end local v19    # "priceView":Landroid/widget/TextView;
    .end local v20    # "resources":Landroid/content/res/Resources;
    .end local v21    # "rightIcon":Lcom/poshmark/ui/customviews/PMListingImageView;
    .end local v22    # "size":I
    .end local v23    # "sizeView":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    .end local v24    # "sys_msg":Landroid/widget/LinearLayout;
    .end local v26    # "systemMessages":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/SystemMessage;>;"
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    move-object/from16 v31, v0

    invoke-virtual/range {v31 .. v31}, Lcom/poshmark/data_model/models/ListingDetails;->isRetail()Z

    move-result v31

    if-eqz v31, :cond_2

    .line 734
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v31

    const v32, 0x7f0601d9

    invoke-virtual/range {v31 .. v32}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v31 .. v31}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v31

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setText(Ljava/lang/CharSequence;)V

    .line 735
    const/16 v31, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    .line 736
    const/16 v31, 0x1

    invoke-static/range {v31 .. v31}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v31

    move-object/from16 v0, v16

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setRetailConditionFlag(Ljava/lang/Boolean;)V

    goto/16 :goto_0

    .line 739
    :cond_2
    const/16 v31, 0x8

    move-object/from16 v0, v16

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 807
    .restart local v3    # "brandView":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    .restart local v4    # "category":Ljava/lang/String;
    .restart local v5    # "categoryImageView":Landroid/widget/ImageView;
    .restart local v6    # "d":Landroid/graphics/drawable/Drawable;
    .restart local v7    # "descriptionView":Landroid/widget/TextView;
    .restart local v8    # "i":I
    .restart local v9    # "icon":Lcom/poshmark/ui/customviews/PMListingImageView;
    .restart local v10    # "id":I
    .restart local v11    # "inflater":Landroid/view/LayoutInflater;
    .restart local v12    # "infoDesc":Landroid/widget/TextView;
    .restart local v14    # "msg":Lcom/poshmark/data_model/models/inner_models/SystemMessage;
    .restart local v15    # "msgContainer":Landroid/widget/LinearLayout;
    .restart local v17    # "originalPriceView":Landroid/widget/TextView;
    .restart local v19    # "priceView":Landroid/widget/TextView;
    .restart local v20    # "resources":Landroid/content/res/Resources;
    .restart local v21    # "rightIcon":Lcom/poshmark/ui/customviews/PMListingImageView;
    .restart local v22    # "size":I
    .restart local v23    # "sizeView":Lcom/poshmark/ui/customviews/SearchFilterTextView;
    .restart local v24    # "sys_msg":Landroid/widget/LinearLayout;
    .restart local v26    # "systemMessages":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/SystemMessage;>;"
    :cond_3
    const/16 v31, 0x8

    move-object/from16 v0, v21

    move/from16 v1, v31

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListingImageView;->setVisibility(I)V

    goto :goto_2

    .line 822
    .end local v8    # "i":I
    .end local v9    # "icon":Lcom/poshmark/ui/customviews/PMListingImageView;
    .end local v11    # "inflater":Landroid/view/LayoutInflater;
    .end local v12    # "infoDesc":Landroid/widget/TextView;
    .end local v14    # "msg":Lcom/poshmark/data_model/models/inner_models/SystemMessage;
    .end local v21    # "rightIcon":Lcom/poshmark/ui/customviews/PMListingImageView;
    .end local v22    # "size":I
    .end local v24    # "sys_msg":Landroid/widget/LinearLayout;
    .end local v26    # "systemMessages":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/SystemMessage;>;"
    :cond_4
    return-void
.end method

.method private updateListingLikes(Landroid/widget/LinearLayout;)V
    .locals 9
    .param p1, "containerView"    # Landroid/widget/LinearLayout;

    .prologue
    const/4 v8, 0x0

    .line 930
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v6

    const/high16 v7, 0x41200000    # 10.0f

    invoke-static {v6, v7}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v6

    float-to-int v3, v6

    .line 931
    .local v3, "margin":I
    const v6, 0x7f0c0136

    invoke-virtual {p1, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 932
    .local v5, "v":Landroid/view/View;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingDetails;->getLikes()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    if-nez v6, :cond_1

    .line 934
    if-eqz v5, :cond_0

    .line 936
    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    .line 964
    :cond_0
    :goto_0
    return-void

    .line 942
    :cond_1
    if-nez v5, :cond_2

    .line 943
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    invoke-static {v6}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 944
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v6, 0x7f030076

    const/4 v7, 0x0

    invoke-virtual {v1, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 945
    invoke-virtual {p1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v6

    add-int/lit8 v6, v6, -0x3

    invoke-virtual {p1, v5, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 948
    .end local v1    # "inflater":Landroid/view/LayoutInflater;
    :cond_2
    invoke-virtual {v5, v8}, Landroid/view/View;->setVisibility(I)V

    .line 951
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/utils/FeatureManager;->isAddToBundleButtonFeatureEnabled()Z

    move-result v6

    if-nez v6, :cond_3

    .line 952
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout$LayoutParams;

    .line 953
    .local v4, "params":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v4, v8, v3, v8, v8}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 954
    invoke-virtual {v5, v4}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 957
    const v6, 0x7f0c01d0

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 958
    .local v0, "divider":Landroid/view/View;
    if-eqz v0, :cond_3

    .line 959
    invoke-virtual {v0, v8}, Landroid/view/View;->setVisibility(I)V

    .line 962
    .end local v0    # "divider":Landroid/view/View;
    .end local v4    # "params":Landroid/widget/LinearLayout$LayoutParams;
    :cond_3
    const v6, 0x7f0c01d2

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    .line 963
    .local v2, "likesView":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingDetails;->getLikes()Ljava/util/List;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v2, v6, v7}, Lcom/poshmark/ui/customviews/PMTextView;->setLikesMessage(Ljava/util/List;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private updateView()V
    .locals 3

    .prologue
    .line 543
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v1

    if-nez v1, :cond_1

    .line 568
    :cond_0
    :goto_0
    return-void

    .line 546
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getUserVisibleHint()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-eqz v1, :cond_0

    .line 547
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c018e

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 548
    .local v0, "containerView":Landroid/widget/LinearLayout;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 550
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateListingHeader(Landroid/widget/LinearLayout;)V

    .line 552
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->insertListingImages(Landroid/widget/LinearLayout;)V

    .line 554
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateListingInfo(Landroid/widget/LinearLayout;)V

    .line 556
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateCategoryAndColorsInfo(Landroid/widget/LinearLayout;)V

    .line 558
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateActionButtons(Landroid/widget/LinearLayout;)V

    .line 560
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateAddToBundleButton(Landroid/widget/LinearLayout;)V

    .line 562
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateListingLikes(Landroid/widget/LinearLayout;)V

    .line 564
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateListingFooter()V

    .line 566
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setupBottomBar()V

    goto :goto_0
.end method

.method private viewBundle()V
    .locals 5

    .prologue
    .line 1249
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 1250
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/poshmark/ui/PMActivity;->isActivityInForeground()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1251
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1252
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "ID"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1253
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const-string v4, "bnd_add"

    invoke-static {v3, v4}, Lcom/poshmark/utils/MetricsTrackingUtils;->getTrackingJson(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1254
    .local v2, "trackingJSON":Ljava/lang/String;
    invoke-static {v2}, Lcom/poshmark/http/api/PMApi;->postGoalTrackingInfo(Ljava/lang/String;)V

    .line 1255
    const-class v3, Lcom/poshmark/ui/fragments/ViewBundleFragment;

    const/4 v4, 0x0

    invoke-virtual {v1, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 1257
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v2    # "trackingJSON":Ljava/lang/String;
    :cond_0
    return-void
.end method


# virtual methods
.method public addCommentToListing(Ljava/lang/String;Lcom/poshmark/data_model/models/inner_models/Comment;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "comment"    # Lcom/poshmark/data_model/models/inner_models/Comment;

    .prologue
    .line 1307
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-eqz v0, :cond_0

    .line 1308
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1309
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0, p2}, Lcom/poshmark/data_model/models/ListingDetails;->addComment(Lcom/poshmark/data_model/models/inner_models/Comment;)V

    .line 1310
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateCursorData()V

    .line 1313
    :cond_0
    return-void
.end method

.method addListingToBundle()V
    .locals 3

    .prologue
    .line 1260
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingDetails;->isAvailableForPurchase()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1262
    const-string v0, ""

    const v1, 0x7f060066

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 1286
    :goto_0
    return-void

    .line 1266
    :cond_0
    const v0, 0x7f060038

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 1267
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$23;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->addListingToBundle(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public deleteListing()V
    .locals 5

    .prologue
    .line 456
    const v0, 0x7f0600b7

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 457
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "delete_listing"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 458
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$9;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$9;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->deleteListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 476
    return-void
.end method

.method public deleteListing(Ljava/lang/String;)V
    .locals 1
    .param p1, "listingId"    # Ljava/lang/String;

    .prologue
    .line 1339
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-eqz v0, :cond_0

    .line 1340
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1341
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingNoMore:Z

    .line 1342
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateView()V

    .line 1345
    :cond_0
    return-void
.end method

.method public editListing()V
    .locals 4

    .prologue
    .line 401
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingDetails;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v2

    sget-object v3, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v2, v3, :cond_0

    .line 402
    const-string v2, ""

    const v3, 0x7f06016e

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v2, v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 412
    :goto_0
    return-void

    .line 406
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 407
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "NEW_LISTING"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 408
    const-string v2, "ID"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 409
    const-string v2, "NFS_ENABLED"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isEditListingWithNFSEnabled:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 410
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 411
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 295
    const-string v0, "ld"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 10
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v9, 0x0

    .line 1354
    const-string v5, "RESULT"

    invoke-virtual {p1, v5}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 1355
    .local v1, "b":Landroid/os/Bundle;
    const-string v5, "PARENT_ID"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v4

    check-cast v4, Landroid/os/ParcelUuid;

    .line 1358
    .local v4, "uuidParcel":Landroid/os/ParcelUuid;
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.VIEW_BUNDLE_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 1359
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 1360
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v7, "bundle"

    const-string v8, "view_bundle_tapped"

    invoke-virtual {v5, v6, v7, v8, v9}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1361
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 1362
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1363
    .local v0, "args":Landroid/os/Bundle;
    const-string v5, "ID"

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1364
    const-class v5, Lcom/poshmark/ui/fragments/ViewBundleFragment;

    invoke-virtual {v2, v0, v5, v9}, Lcom/poshmark/ui/PMActivity;->launchFragment(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 1369
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v2    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.ADD_TO_BUNDLE_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1370
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 1371
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v7, "bundle"

    const-string v8, "add_listing_to_bundle_tapped"

    invoke-virtual {v5, v6, v7, v8, v9}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1372
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->addListingToBundle()V

    .line 1377
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.REPORT_LISTING_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 1378
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 1379
    const-string v5, "REPORT_REASON"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1380
    .local v3, "reason":Ljava/lang/String;
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->reportListing(Ljava/lang/String;)V

    .line 1385
    .end local v3    # "reason":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.REPORT_LISTING_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1386
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1387
    const-string v5, "REPORT_REASON"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 1388
    .restart local v3    # "reason":Ljava/lang/String;
    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->reportListing(Ljava/lang/String;)V

    .line 1392
    .end local v3    # "reason":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.EDIT_LISTING_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 1393
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 1394
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->editListing()V

    .line 1398
    :cond_4
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.NOT_FOR_SALE_LISTING_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 1399
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 1400
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->markAsNotForSale()V

    .line 1404
    :cond_5
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.MAKE_AVAILABLE_LISTING_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 1405
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 1406
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->markForSale()V

    .line 1410
    :cond_6
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v5

    const-string v6, "com.poshmark.intents.DELETE_LISTING_ACTION"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1411
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentId:Ljava/util/UUID;

    invoke-virtual {v4}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1412
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->deleteListing()V

    .line 1415
    :cond_7
    return-void
.end method

.method public likeListing(Ljava/lang/String;Z)V
    .locals 4
    .param p1, "listingId"    # Ljava/lang/String;
    .param p2, "likeStatus"    # Z

    .prologue
    .line 1317
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-eqz v2, :cond_0

    .line 1318
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1319
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v2, p2}, Lcom/poshmark/data_model/models/ListingDetails;->setListingLikeStatus(Z)V

    .line 1320
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0c004e

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 1321
    .local v1, "likeButton":Landroid/widget/ImageView;
    invoke-direct {p0, v1, p2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setLikeButtonState(Landroid/widget/ImageView;Z)V

    .line 1322
    invoke-direct {p0, p2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setActionBarLikeButtonState(Z)V

    .line 1324
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v2

    if-nez v2, :cond_1

    .line 1335
    .end local v1    # "likeButton":Landroid/widget/ImageView;
    :cond_0
    :goto_0
    return-void

    .line 1327
    .restart local v1    # "likeButton":Landroid/widget/ImageView;
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getUserVisibleHint()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-eqz v2, :cond_0

    .line 1328
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0c018e

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 1329
    .local v0, "containerView":Landroid/widget/LinearLayout;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1331
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateListingLikes(Landroid/widget/LinearLayout;)V

    goto :goto_0
.end method

.method public markAsNotForSale()V
    .locals 3

    .prologue
    .line 416
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    sget-object v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->NOT_FOR_SALE:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$7;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$7;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->updateListingStatus(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 431
    const v0, 0x7f06016c

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setTitle(I)V

    .line 432
    return-void
.end method

.method public markForSale()V
    .locals 3

    .prologue
    .line 435
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    sget-object v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->AVAILABLE:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$8;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->updateListingStatus(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 450
    return-void
.end method

.method public newListingCreated()V
    .locals 0

    .prologue
    .line 1350
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 163
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 164
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setupListItemClickListener()V

    .line 165
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 129
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 130
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "ID"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    .line 131
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "banner_json"

    invoke-virtual {v2, v3, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerJson:Ljava/lang/String;

    .line 132
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerJson:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 133
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 134
    .local v0, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v0}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 136
    .local v1, "gson":Lcom/google/gson/Gson;
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerJson:Ljava/lang/String;

    const-class v3, Lcom/poshmark/data_model/models/BannerInfo;

    instance-of v4, v1, Lcom/google/gson/Gson;

    if-nez v4, :cond_1

    invoke-virtual {v1, v2, v3}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    .end local v1    # "gson":Lcom/google/gson/Gson;
    :goto_0
    check-cast v2, Lcom/poshmark/data_model/models/BannerInfo;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->bannerInfo:Lcom/poshmark/data_model/models/BannerInfo;
    :try_end_0
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 141
    .end local v0    # "b":Lcom/google/gson/GsonBuilder;
    :cond_0
    :goto_1
    new-instance v2, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const/high16 v4, -0x80000000

    invoke-direct {v2, v3, p0, v5, v4}, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/ListingDetailsFragment;Landroid/database/Cursor;I)V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;

    .line 142
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/poshmark/notifications/ListingNotificationManager;->registerListingMessageHandler(Lcom/poshmark/notifications/ListingNotificationHandler;)V

    .line 143
    sget-object v2, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->HAS_DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 144
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/utils/FeatureManager;->isEditListingWithNFSEnable()Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isEditListingWithNFSEnabled:Ljava/lang/Boolean;

    .line 147
    sget-object v2, Lcom/poshmark/utils/NewRelicCustomInteractions;->LISTING_DETAILS:Ljava/lang/String;

    invoke-static {v2}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 148
    return-void

    .line 136
    .restart local v0    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_1
    :try_start_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v2, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_1
    .catch Lcom/google/gson/JsonSyntaxException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v2

    goto :goto_0

    .line 137
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 152
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 153
    const v1, 0x7f06016c

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setTitle(I)V

    .line 156
    const v1, 0x7f030061

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 157
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->createAllViews(Landroid/view/View;)V

    .line 158
    return-object v0
.end method

.method public onPMResume()V
    .locals 3

    .prologue
    .line 231
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 232
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingNoMore:Z

    if-eqz v1, :cond_0

    .line 236
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 237
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->onBackPressed()V

    .line 247
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :goto_0
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.VIEW_BUNDLE_ACTION"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 248
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.ADD_TO_BUNDLE_ACTION"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 249
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.REPORT_LISTING_ACTION"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 250
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.EDIT_LISTING_ACTION"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 251
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.NOT_FOR_SALE_LISTING_ACTION"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 252
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.MAKE_AVAILABLE_LISTING_ACTION"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 253
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v1

    const-string v2, "com.poshmark.intents.DELETE_LISTING_ACTION"

    invoke-virtual {v1, v2, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 254
    return-void

    .line 239
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-nez v1, :cond_1

    .line 240
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->fetchListingDetails()V

    goto :goto_0

    .line 242
    :cond_1
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setupActionBarNextActionButton()V

    .line 243
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateView()V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 289
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 290
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 291
    return-void
.end method

.method public onStop()V
    .locals 3

    .prologue
    .line 300
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onStop()V

    .line 301
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingImages:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 302
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/ui/customviews/PMListingImageView;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 303
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListingImageView;

    .line 304
    .local v0, "img":Lcom/poshmark/ui/customviews/PMListingImageView;
    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListingImageView;->releaseInternalBitmap()V

    goto :goto_0

    .line 306
    .end local v0    # "img":Lcom/poshmark/ui/customviews/PMListingImageView;
    :cond_0
    return-void
.end method

.method public replyToComment(Ljava/lang/String;)V
    .locals 5
    .param p1, "replyToCommentorHandle"    # Ljava/lang/String;

    .prologue
    .line 309
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 310
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 311
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "ID"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 313
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 314
    const-string v2, "REPLY_TO_HANDLE"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "@"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 316
    :cond_0
    const-class v2, Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 317
    return-void
.end method

.method public reportListing(Ljava/lang/String;)V
    .locals 2
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 479
    const-string v0, "Reporting..."

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 480
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$10;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    invoke-static {v0, p1, v1}, Lcom/poshmark/http/api/PMApi;->reportListing(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 496
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 320
    const-string v0, "listing_details_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 321
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 225
    const v0, 0x7f030004

    invoke-super {p0, v0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar(I)V

    .line 226
    const v0, 0x7f06016d

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->setTitle(I)V

    .line 227
    return-void
.end method

.method public showPopupMenu(Landroid/view/View;)V
    .locals 2
    .param p1, "anchorView"    # Landroid/view/View;

    .prologue
    .line 324
    new-instance v0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    invoke-direct {v0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;-><init>()V

    .line 325
    .local v0, "popupWindow":Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->setup(Lcom/poshmark/data_model/models/ListingDetails;Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    .line 326
    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->showPopup(Landroid/view/View;)V

    .line 327
    return-void
.end method

.method public updateListing(Lcom/poshmark/data_model/models/ListingDetails;)V
    .locals 2
    .param p1, "newListingDetail"    # Lcom/poshmark/data_model/models/ListingDetails;

    .prologue
    .line 1291
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    if-eqz v0, :cond_0

    .line 1292
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->getIdAsString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1293
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    .line 1294
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1295
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateCursorData()V

    .line 1296
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateView()V

    .line 1297
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerFragment:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    if-eqz v0, :cond_0

    .line 1298
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->drawerFragment:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->updateDrawer(Z)V

    .line 1303
    :cond_0
    return-void
.end method
