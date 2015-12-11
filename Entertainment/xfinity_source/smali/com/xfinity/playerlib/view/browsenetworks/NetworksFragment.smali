.class public Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
.super Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;
.source "NetworksFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;,
        Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;,
        Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AllNetworksAdapter;,
        Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$PremiumNetworksAdapter;,
        Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment",
        "<",
        "Lcom/xfinity/playerlib/model/tags/Network;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static MISSING_LOGO_TEXT_COLOR:I

.field private static MISSING_LOGO_TEXT_SIZE:F

.field private static final NETWORK_NAME_COMPARATOR:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;


# instance fields
.field private allNetworks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private allNetworksAbsList:Landroid/widget/AbsListView;

.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field private infoMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            "Landroid/widget/AdapterView;",
            ">.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;>;"
        }
    .end annotation
.end field

.field private networkCollectionsBundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

.field private final networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field private noDataSpacer:Landroid/view/View;

.field private premiumNetworks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private premiumNetworksAbsList:Landroid/widget/AbsListView;

.field private premiumNetworksHeader:Landroid/view/View;

.field setOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

.field private tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private tagsAndProviderListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->LOG:Lorg/slf4j/Logger;

    .line 53
    new-instance v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->NETWORK_NAME_COMPARATOR:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;

    .line 56
    const/high16 v0, -0x40800000    # -1.0f

    sput v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->MISSING_LOGO_TEXT_SIZE:F

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;-><init>()V

    .line 58
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 59
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsAndProgramsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 60
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->networkCollectionsBundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    .line 61
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 99
    new-instance v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$1;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->setOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 395
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->initInfoViews()V

    return-void
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->bodyContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworksHeader:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->bodyContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->bodyContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$1400()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/widget/AdapterView;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
    .param p1, "x1"    # Landroid/widget/AdapterView;
    .param p2, "x2"    # I

    .prologue
    .line 50
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->executeOnItemClick(Landroid/widget/AdapterView;I)V

    return-void
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Lcom/xfinity/playerlib/model/tags/Network;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 50
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getNetworkNameDrawable(Lcom/xfinity/playerlib/model/tags/Network;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1800(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object v0
.end method

.method static synthetic access$202(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Lcom/xfinity/playerlib/model/dibic/DibicResource;)Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object p1
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworks:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$302(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworks:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$400()Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->NETWORK_NAME_COMPARATOR:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworks:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$502(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworks:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->noDataSpacer:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/lang/Integer;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
    .param p1, "x1"    # Ljava/lang/Integer;
    .param p2, "x2"    # Ljava/util/List;

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->updateAdapterFromList(Ljava/lang/Integer;Ljava/util/List;)V

    return-void
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/lang/Integer;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
    .param p1, "x1"    # Ljava/lang/Integer;
    .param p2, "x2"    # Ljava/util/List;

    .prologue
    .line 50
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->updateAdapterFromList(Ljava/lang/Integer;Ljava/util/List;)V

    return-void
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->fixScrollYPosition()V

    return-void
.end method

.method private executeOnItemClick(Landroid/widget/AdapterView;I)V
    .locals 3
    .param p2, "position"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;I)V"
        }
    .end annotation

    .prologue
    .line 236
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1, p2}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/Network;

    .line 238
    .local v0, "network":Lcom/xfinity/playerlib/model/tags/Network;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTapNetworkLogo(Ljava/lang/String;)V

    .line 240
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->showApplicableBrowse(Lcom/xfinity/playerlib/model/tags/Network;)V

    .line 241
    return-void
.end method

.method private fixScrollYPosition()V
    .locals 2

    .prologue
    .line 202
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworksHeader:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 203
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->bodyContainer:Landroid/view/ViewGroup;

    new-instance v1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$3;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->post(Ljava/lang/Runnable;)Z

    .line 211
    :cond_0
    return-void
.end method

.method private getNetworkNameDrawable(Lcom/xfinity/playerlib/model/tags/Network;)Landroid/graphics/drawable/Drawable;
    .locals 13
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    const/4 v6, 0x4

    const/4 v7, 0x1

    const/4 v5, 0x0

    .line 264
    const/4 v0, 0x0

    .line 265
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 266
    .local v1, "activity":Landroid/app/Activity;
    if-eqz v1, :cond_1

    .line 267
    sget v2, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->MISSING_LOGO_TEXT_SIZE:F

    const/high16 v3, -0x40800000    # -1.0f

    cmpl-float v2, v2, v3

    if-nez v2, :cond_0

    .line 268
    invoke-virtual {v1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$layout;->network_item_missing_logo_text_style_template:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/view/ViewGroup;

    .line 270
    .local v12, "tvLayout":Landroid/view/ViewGroup;
    sget v2, Lcom/xfinity/playerlib/R$id;->network_gallery_missing_logo_text_style_template:I

    invoke-virtual {v12, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/TextView;

    .line 271
    .local v11, "tv":Landroid/widget/TextView;
    invoke-virtual {v11}, Landroid/widget/TextView;->getCurrentTextColor()I

    move-result v2

    sput v2, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->MISSING_LOGO_TEXT_COLOR:I

    .line 274
    invoke-virtual {v11}, Landroid/widget/TextView;->getTextSize()F

    move-result v2

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    .line 273
    invoke-static {v5, v2, v3}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v2

    sput v2, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->MISSING_LOGO_TEXT_SIZE:F

    .line 276
    .end local v11    # "tv":Landroid/widget/TextView;
    .end local v12    # "tvLayout":Landroid/view/ViewGroup;
    :cond_0
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;

    .line 277
    .end local v0    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->MISSING_LOGO_TEXT_COLOR:I

    sget v4, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->MISSING_LOGO_TEXT_SIZE:F

    const/4 v5, -0x2

    sget-object v10, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    move v8, v6

    move v9, v7

    invoke-direct/range {v0 .. v10}, Lcom/comcast/cim/cmasl/android/util/view/widget/TextDrawable;-><init>(Landroid/content/Context;Ljava/lang/String;IFIIZIZLandroid/text/TextUtils$TruncateAt;)V

    .line 282
    .restart local v0    # "d":Landroid/graphics/drawable/Drawable;
    :cond_1
    return-object v0
.end method

.method private showApplicableBrowse(Lcom/xfinity/playerlib/model/tags/Network;)V
    .locals 5
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 244
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-interface {v3, p1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v2

    .line 247
    .local v2, "programsByGenre":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v3

    const/4 v4, 0x1

    if-le v3, v4, :cond_0

    .line 249
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsActivity;

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 250
    .local v1, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->networkCollectionsBundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    invoke-virtual {v3, p1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;->createBundle(Lcom/xfinity/playerlib/model/tags/Network;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 260
    :goto_0
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->startActivity(Landroid/content/Intent;)V

    .line 261
    return-void

    .line 254
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 256
    .local v0, "categoryId":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity;

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 257
    .restart local v1    # "intent":Landroid/content/Intent;
    invoke-static {p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->createBundle(Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_0
.end method


# virtual methods
.method protected getInfoMap(Landroid/view/LayoutInflater;)Ljava/util/Map;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/LayoutInflater;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            "Landroid/widget/AdapterView;",
            ">.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;>;"
        }
    .end annotation

    .prologue
    .line 304
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->infoMap:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 306
    new-instance v0, Ljava/util/LinkedHashMap;

    const/4 v1, 0x2

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-direct {v0, v1, v2}, Ljava/util/LinkedHashMap;-><init>(IF)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->infoMap:Ljava/util/Map;

    .line 307
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->infoMap:Ljava/util/Map;

    sget v1, Lcom/xfinity/playerlib/R$id;->premium_networks:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;

    new-instance v3, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$PremiumNetworksAdapter;

    invoke-direct {v3, p0, p1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$PremiumNetworksAdapter;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/view/LayoutInflater;)V

    invoke-direct {v2, p0, v3}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;-><init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->infoMap:Ljava/util/Map;

    sget v1, Lcom/xfinity/playerlib/R$id;->all_networks:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;

    new-instance v3, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AllNetworksAdapter;

    invoke-direct {v3, p0, p1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AllNetworksAdapter;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/view/LayoutInflater;)V

    invoke-direct {v2, p0, v3}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;-><init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;)V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 310
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->infoMap:Ljava/util/Map;

    return-object v0
.end method

.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 294
    sget v0, Lcom/xfinity/playerlib/R$layout;->networks_gallery:I

    return v0
.end method

.method protected getOnItemClickListener()Landroid/widget/AdapterView$OnItemClickListener;
    .locals 1

    .prologue
    .line 215
    new-instance v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$4;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$4;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V

    return-object v0
.end method

.method protected getOnItemLongClickListener()Landroid/widget/AdapterView$OnItemLongClickListener;
    .locals 1

    .prologue
    .line 226
    new-instance v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$5;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$5;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V

    return-object v0
.end method

.method protected getShadowImageId()I
    .locals 1

    .prologue
    .line 299
    const/4 v0, 0x0

    return v0
.end method

.method protected loadResources()V
    .locals 2

    .prologue
    .line 129
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->tagsAndProviderListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 181
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;->onAttach(Landroid/app/Activity;)V

    .line 117
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 118
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 82
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 84
    .local v0, "view":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->spacer_if_no_data:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->noDataSpacer:Landroid/view/View;

    .line 85
    sget v1, Lcom/xfinity/playerlib/R$id;->premium_networks_header:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworksHeader:Landroid/view/View;

    .line 86
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->NETWORKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V

    .line 88
    sget v1, Lcom/xfinity/playerlib/R$id;->premium_networks:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/AbsListView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworksAbsList:Landroid/widget/AbsListView;

    .line 89
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworksAbsList:Landroid/widget/AbsListView;

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_premium_networks:I

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/AbsListView;->setTag(Ljava/lang/Object;)V

    .line 90
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworksAbsList:Landroid/widget/AbsListView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->setOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v1, v2}, Landroid/widget/AbsListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 92
    sget v1, Lcom/xfinity/playerlib/R$id;->all_networks:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/AbsListView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworksAbsList:Landroid/widget/AbsListView;

    .line 93
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworksAbsList:Landroid/widget/AbsListView;

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_all_networks:I

    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/AbsListView;->setTag(Ljava/lang/Object;)V

    .line 94
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworksAbsList:Landroid/widget/AbsListView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->setOnScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v1, v2}, Landroid/widget/AbsListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 96
    return-object v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 287
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;->onPause()V

    .line 288
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->tagsAndProviderListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 289
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->purgeJobs()V

    .line 290
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 122
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiAdapterViewFragment;->onStop()V

    .line 124
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->tagsAndProviderListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 125
    return-void
.end method
