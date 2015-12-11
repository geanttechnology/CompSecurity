.class public Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
.super Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/ScrollStateTracker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;,
        Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
        ">;",
        "Lcom/xfinity/playerlib/view/ScrollStateTracker;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field public static final RESERVED_RESOURCE_IDS:[I


# instance fields
.field private actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

.field protected bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field private bundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

.field private categoryList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private categoryToProgramsMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation
.end field

.field private companyId:J

.field private final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private entitlementListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private network:Lcom/xfinity/playerlib/model/tags/Network;

.field private final networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field private rowContainer:Landroid/view/ViewGroup;

.field private rowViewArray:[Landroid/view/ViewGroup;

.field private savedSelections:[I

.field private scrollState:I

.field private showFilterButton:Z

.field private tagsAndProgramsFetchListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
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

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

.field private viewInfoMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            "Lit/sephiroth/android/library/widget/AdapterView;",
            ">.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 56
    const-class v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->LOG:Lorg/slf4j/Logger;

    .line 59
    invoke-static {}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getReservedResourceIds()[I

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->RESERVED_RESOURCE_IDS:[I

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;-><init>()V

    .line 63
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsAndProgramsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 65
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 66
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 67
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 69
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .line 71
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->bundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    .line 81
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->viewInfoMap:Ljava/util/Map;

    .line 421
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
    .param p1, "x1"    # Lit/sephiroth/android/library/widget/HListView;
    .param p2, "x2"    # Landroid/widget/ImageView;
    .param p3, "x3"    # Landroid/widget/ImageView;

    .prologue
    .line 54
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->adjustScrollShadows(Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    return-void
.end method

.method static synthetic access$102(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
    .param p1, "x1"    # I

    .prologue
    .line 54
    iput p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->scrollState:I

    return p1
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    return-object v0
.end method

.method static synthetic access$200()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object v0
.end method

.method static synthetic access$302(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object p1
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->displayScreenProgramsIfReady()V

    return-void
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    return-object v0
.end method

.method static synthetic access$502(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/Network;)Lcom/xfinity/playerlib/model/tags/Network;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    return-object p1
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)J
    .locals 2
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->companyId:J

    return-wide v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$702(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryToProgramsMap:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$802(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Ljava/util/Map;)Ljava/util/Map;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;
    .param p1, "x1"    # Ljava/util/Map;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryToProgramsMap:Ljava/util/Map;

    return-object p1
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 54
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->showFilterButton:Z

    return v0
.end method

.method private adjustScrollShadows(Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    .locals 6
    .param p1, "hScrollView"    # Lit/sephiroth/android/library/widget/HListView;
    .param p2, "leftShadow"    # Landroid/widget/ImageView;
    .param p3, "rightShadow"    # Landroid/widget/ImageView;

    .prologue
    const/4 v5, 0x4

    const/4 v4, 0x0

    .line 387
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v1

    .line 388
    .local v1, "scrollXPos":I
    if-lez v1, :cond_0

    .line 389
    invoke-virtual {p2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 390
    invoke-virtual {p2}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    invoke-virtual {p2}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    invoke-static {v1, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 395
    :goto_0
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/HListView;->getMaxScrollAmount()I

    move-result v0

    .line 396
    .local v0, "scrollMaxX":I
    if-ge v1, v0, :cond_1

    .line 397
    invoke-virtual {p3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 398
    invoke-virtual {p3}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    sub-int v3, v0, v1

    invoke-virtual {p3}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 402
    :goto_1
    return-void

    .line 392
    .end local v0    # "scrollMaxX":I
    :cond_0
    invoke-virtual {p2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 400
    .restart local v0    # "scrollMaxX":I
    :cond_1
    invoke-virtual {p3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1
.end method

.method private createGallery(Landroid/view/ViewGroup;I)I
    .locals 5
    .param p1, "rowView"    # Landroid/view/ViewGroup;
    .param p2, "categoryIndex"    # I

    .prologue
    .line 123
    sget v4, Lcom/xfinity/playerlib/R$id;->net_coll_gallery:I

    invoke-virtual {p1, v4}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lit/sephiroth/android/library/widget/HListView;

    .line 124
    .local v2, "gallery":Lit/sephiroth/android/library/widget/HListView;
    sget-object v4, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->RESERVED_RESOURCE_IDS:[I

    aget v3, v4, p2

    .line 125
    .local v3, "galleryId":I
    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setId(I)V

    .line 127
    new-instance v4, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;

    invoke-direct {v4, p0, v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$1;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lit/sephiroth/android/library/widget/HListView;)V

    invoke-virtual {v2, v4}, Lit/sephiroth/android/library/widget/HListView;->setOnItemSelectedListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemSelectedListener;)V

    .line 150
    sget v4, Lcom/xfinity/playerlib/R$id;->net_coll_shadow_left:I

    invoke-virtual {p1, v4}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 151
    .local v0, "collectionShadowLeft":Landroid/widget/ImageView;
    sget v4, Lcom/xfinity/playerlib/R$id;->net_coll_shadow_right:I

    invoke-virtual {p1, v4}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 153
    .local v1, "collectionShadowRight":Landroid/widget/ImageView;
    new-instance v4, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;

    invoke-direct {v4, p0, v2, v0, v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$2;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    invoke-virtual {v2, v4}, Lit/sephiroth/android/library/widget/HListView;->setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V

    .line 173
    return v3
.end method

.method private displayScreenProgramsIfReady()V
    .locals 21

    .prologue
    .line 241
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryToProgramsMap:Ljava/util/Map;

    move-object/from16 v17, v0

    if-eqz v17, :cond_7

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-object/from16 v17, v0

    if-eqz v17, :cond_7

    .line 244
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowContainer:Landroid/view/ViewGroup;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->viewInfoMap:Ljava/util/Map;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/Map;->clear()V

    .line 250
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v10

    .line 253
    .local v10, "numCategories":I
    sget-object v17, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->RESERVED_RESOURCE_IDS:[I

    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    if-le v10, v0, :cond_0

    .line 254
    new-instance v17, Ljava/util/ArrayList;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    move-object/from16 v18, v0

    invoke-direct/range {v17 .. v18}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    .line 255
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    move-object/from16 v17, v0

    sget-object v18, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->RESERVED_RESOURCE_IDS:[I

    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v18, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move/from16 v2, v18

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->removeExcessElements(Ljava/util/List;I)Z

    .line 256
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Ljava/util/List;->size()I

    move-result v10

    .line 259
    :cond_0
    new-array v0, v10, [Landroid/view/ViewGroup;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowViewArray:[Landroid/view/ViewGroup;

    .line 260
    new-array v0, v10, [I

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->savedSelections:[I

    .line 262
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    move-object/from16 v17, v0

    if-eqz v17, :cond_1

    .line 263
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    move-object/from16 v18, v0

    invoke-interface/range {v17 .. v18}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;->loadNetworkLogo(Lcom/xfinity/playerlib/model/tags/Network;)V

    .line 268
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v9

    .line 270
    .local v9, "inflater":Landroid/view/LayoutInflater;
    const/4 v8, 0x0

    .local v8, "i1":I
    :goto_0
    if-ge v8, v10, :cond_2

    .line 271
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 272
    .local v4, "category1":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    sget v17, Lcom/xfinity/playerlib/R$layout;->network_collection_row:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowContainer:Landroid/view/ViewGroup;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move/from16 v0, v17

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v9, v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/view/ViewGroup;

    .line 273
    .local v14, "rowView":Landroid/view/ViewGroup;
    new-instance v17, Landroid/view/ViewGroup$LayoutParams;

    const/16 v18, -0x2

    const/16 v19, -0x1

    invoke-direct/range {v17 .. v19}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    move-object/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/view/ViewGroup;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 274
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowContainer:Landroid/view/ViewGroup;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v14}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 275
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowViewArray:[Landroid/view/ViewGroup;

    move-object/from16 v17, v0

    aput-object v14, v17, v8

    .line 277
    sget v17, Lcom/xfinity/playerlib/R$id;->net_coll_name:I

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 278
    .local v5, "categoryNameTextView":Landroid/widget/TextView;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getName()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 280
    move-object/from16 v0, p0

    invoke-direct {v0, v14, v8}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->createGallery(Landroid/view/ViewGroup;I)I

    move-result v6

    .line 282
    .local v6, "galleryId":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->viewInfoMap:Ljava/util/Map;

    move-object/from16 v17, v0

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    new-instance v19, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;

    new-instance v20, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v9}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Landroid/view/LayoutInflater;)V

    move-object/from16 v0, v19

    move-object/from16 v1, p0

    move-object/from16 v2, v20

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;-><init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;)V

    invoke-interface/range {v17 .. v19}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 270
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_0

    .line 285
    .end local v4    # "category1":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .end local v5    # "categoryNameTextView":Landroid/widget/TextView;
    .end local v6    # "galleryId":I
    .end local v14    # "rowView":Landroid/view/ViewGroup;
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->initInfoViews()V

    .line 287
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    sget v18, Lcom/xfinity/playerlib/R$string;->network_collections_view_all_link:I

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v16

    .line 291
    .local v16, "viewAllString":Ljava/lang/String;
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowViewArray:[Landroid/view/ViewGroup;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v7, v0, :cond_6

    .line 292
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowViewArray:[Landroid/view/ViewGroup;

    move-object/from16 v17, v0

    aget-object v14, v17, v7

    .line 293
    .restart local v14    # "rowView":Landroid/view/ViewGroup;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 294
    .local v3, "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryToProgramsMap:Ljava/util/Map;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/List;

    .line 297
    .local v12, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-eqz v12, :cond_3

    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v17

    if-nez v17, :cond_4

    .line 298
    :cond_3
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 291
    :goto_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 300
    :cond_4
    invoke-interface {v12}, Ljava/util/List;->size()I

    move-result v11

    .line 303
    .local v11, "originalNumPrograms":I
    const/16 v17, 0x18

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-direct {v0, v12, v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->removeExcessElements(Ljava/util/List;I)Z

    move-result v17

    if-eqz v17, :cond_5

    .line 305
    sget v17, Lcom/xfinity/playerlib/R$id;->net_coll_view_all_link:I

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/TextView;

    .line 306
    .local v15, "textView":Landroid/widget/TextView;
    sget-object v17, Ljava/util/Locale;->US:Ljava/util/Locale;

    const/16 v18, 0x2

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v20

    aput-object v20, v18, v19

    const/16 v19, 0x1

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getName()Ljava/lang/String;

    move-result-object v20

    aput-object v20, v18, v19

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    move-object/from16 v2, v18

    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 307
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 308
    new-instance v17, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$6;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/OrderedTag;)V

    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 319
    .end local v15    # "textView":Landroid/widget/TextView;
    :cond_5
    sget-object v17, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->RESERVED_RESOURCE_IDS:[I

    aget v13, v17, v7

    .line 321
    .local v13, "rowResourceId":I
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v12}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->updateAdapterFromList(Ljava/lang/Integer;Ljava/util/List;)V

    goto :goto_2

    .line 325
    .end local v3    # "category":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .end local v11    # "originalNumPrograms":I
    .end local v12    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v13    # "rowResourceId":I
    .end local v14    # "rowView":Landroid/view/ViewGroup;
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 326
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v17

    sget v18, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface/range {v17 .. v18}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 328
    .end local v7    # "i":I
    .end local v8    # "i1":I
    .end local v9    # "inflater":Landroid/view/LayoutInflater;
    .end local v10    # "numCategories":I
    .end local v16    # "viewAllString":Ljava/lang/String;
    :cond_7
    return-void
.end method

.method public static final getReservedResourceIds()[I
    .locals 11

    .prologue
    .line 547
    invoke-static {}, Lcom/xfinity/playerlib/PlayerApplication;->getInstance()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    .line 548
    .local v0, "app":Landroid/app/Application;
    invoke-virtual {v0}, Landroid/app/Application;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    .line 549
    .local v5, "res":Landroid/content/res/Resources;
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "reserved_id_"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 550
    .local v7, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    .line 551
    .local v4, "prefixLength":I
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 552
    .local v3, "ids":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v1, 0x1

    .line 553
    .local v1, "i":I
    :goto_0
    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->setLength(I)V

    .line 554
    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 555
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "id"

    invoke-virtual {v0}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v8, v9, v10}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 556
    .local v2, "id":I
    if-nez v2, :cond_0

    .line 561
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v8

    new-array v6, v8, [I

    .line 562
    .local v6, "result":[I
    array-length v1, v6

    :goto_1
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_1

    .line 563
    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Integer;

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    aput v8, v6, v1

    goto :goto_1

    .line 559
    .end local v6    # "result":[I
    :cond_0
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-interface {v3, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 552
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 565
    .restart local v6    # "result":[I
    :cond_1
    return-object v6
.end method

.method private removeExcessElements(Ljava/util/List;I)Z
    .locals 2
    .param p2, "maxAllowed"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<*>;I)Z"
        }
    .end annotation

    .prologue
    .line 331
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<*>;"
    const/4 v0, 0x0

    .line 332
    .local v0, "excessFound":Z
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    .local v1, "i":I
    :goto_0
    add-int/lit8 v1, v1, -0x1

    if-lt v1, p2, :cond_0

    .line 333
    invoke-interface {p1, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 334
    const/4 v0, 0x1

    goto :goto_0

    .line 336
    :cond_0
    return v0
.end method


# virtual methods
.method protected getInfoMap(Landroid/view/LayoutInflater;)Ljava/util/Map;
    .locals 1
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
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            "Lit/sephiroth/android/library/widget/AdapterView;",
            ">.com/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;>;"
        }
    .end annotation

    .prologue
    .line 538
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->viewInfoMap:Ljava/util/Map;

    return-object v0
.end method

.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 533
    sget v0, Lcom/xfinity/playerlib/R$layout;->network_collections_tablet:I

    return v0
.end method

.method protected getOnItemClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;
    .locals 1

    .prologue
    .line 357
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$7;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$7;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V

    return-object v0
.end method

.method protected getOnItemLongClickListener()Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;
    .locals 1

    .prologue
    .line 375
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$8;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$8;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V

    return-object v0
.end method

.method protected getShadowImageId()I
    .locals 1

    .prologue
    .line 543
    sget v0, Lcom/xfinity/playerlib/R$id;->topScrollingShadow:I

    return v0
.end method

.method public isFlinging()Z
    .locals 2

    .prologue
    .line 406
    iget v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->scrollState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected loadResources()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 193
    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 194
    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryToProgramsMap:Ljava/util/Map;

    .line 196
    new-instance v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$3;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$3;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V

    .line 202
    .local v0, "cancelListener":Landroid/content/DialogInterface$OnCancelListener;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->entitlementListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 215
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->tagsAndProgramsFetchListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 238
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 95
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->onAttach(Landroid/app/Activity;)V

    .line 96
    instance-of v1, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    if-eqz v1, :cond_0

    .line 97
    check-cast p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    .line 100
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 101
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "showFilterButton"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->showFilterButton:Z

    .line 102
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->bundleCodec:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsBundleCodec;->getNetworkCompanyId(Landroid/os/Bundle;)J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->companyId:J

    .line 103
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 107
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->onCreate(Landroid/os/Bundle;)V

    .line 108
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 112
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 113
    .local v0, "layout":Landroid/view/ViewGroup;
    sget v1, Lcom/xfinity/playerlib/R$id;->network_collections_row_container:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->rowContainer:Landroid/view/ViewGroup;

    .line 115
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->setupLoadingViewDelegate(Landroid/view/ViewGroup;)V

    .line 116
    return-object v0
.end method

.method public onStartInternal()V
    .locals 0

    .prologue
    .line 188
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->onStartInternal()V

    .line 189
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 178
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/AbstractMultiHorizontalAdapterViewFragment;->onStop()V

    .line 180
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->entitlementListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 181
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->tagsAndProgramsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->tagsAndProgramsFetchListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 183
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->purgeJobs()V

    .line 184
    return-void
.end method
