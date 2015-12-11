.class public abstract Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;
.super Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;
.source "PlayNowBrowseProgramsFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramViewHolder;,
        Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;,
        Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<RT:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
        ">;",
        "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
        "<",
        "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
        ">;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field protected final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field protected alphaSortButton:Landroid/view/ViewGroup;

.field protected alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field protected bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field protected breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;"
        }
    .end annotation
.end field

.field protected final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private isAccessibilityEnabled:Z

.field private lastSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field protected final networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field protected otherSortButton:Landroid/view/ViewGroup;

.field protected popularityButton:Landroid/view/ViewGroup;

.field private programAdapter:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment",
            "<TRT;>.com/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;"
        }
    .end annotation
.end field

.field protected shouldShowFilterButton:Z

.field private final shouldSuppressNetworkLogos:Z

.field private sortButtonContentDescriptions:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/view/ViewGroup;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field protected final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field protected final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;-><init>()V

    .line 51
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->LOG:Lorg/slf4j/Logger;

    .line 53
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 55
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 56
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 57
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 58
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->shouldSuppressNetworkLogos()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->shouldSuppressNetworkLogos:Z

    .line 67
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .line 68
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->shouldShowFilterButton:Z

    .line 70
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortButtonContentDescriptions:Ljava/util/HashMap;

    .line 73
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 696
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/android/view/flow/FilterRequestObserver;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterRequestObserver:Lcom/comcast/cim/android/view/flow/FilterRequestObserver;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/android/view/flow/FilterRequestObserver;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterRequestObserver:Lcom/comcast/cim/android/view/flow/FilterRequestObserver;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lorg/slf4j/Logger;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->shouldSuppressNetworkLogos:Z

    return v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->isAccessibilityEnabled:Z

    return v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    return-object v0
.end method

.method private getBreadcrumbAdapter()Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 246
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)V

    return-object v0
.end method

.method private makeSortButtonAccessible(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    const/4 v1, 0x1

    .line 686
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0, p1, v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 687
    invoke-virtual {p1, v1}, Landroid/view/View;->setFocusable(Z)V

    .line 688
    invoke-virtual {p1, v1}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    .line 689
    return-void
.end method

.method private setApplicableBreadcrumbContainerVisibility(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 5
    .param p1, "filterValue"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 116
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortBar:Landroid/view/View;

    if-eqz v3, :cond_0

    .line 117
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->getVisibility()I

    move-result v1

    .line 118
    .local v1, "prevVisibility":I
    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->empty()Z

    move-result v3

    if-eqz v3, :cond_1

    const/16 v2, 0x8

    .line 120
    .local v2, "visibility":I
    :goto_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    invoke-virtual {v3, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->setVisibility(I)V

    .line 122
    if-eq v1, v2, :cond_0

    .line 123
    if-nez v2, :cond_2

    const/4 v0, 0x1

    .line 124
    .local v0, "adjustmentMultiplier":I
    :goto_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$dimen;->breadcrumb_container_height:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    mul-int/2addr v3, v0

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->adjustQuickReturnView(I)V

    .line 126
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->layout:Landroid/view/ViewGroup;

    invoke-virtual {v3}, Landroid/view/ViewGroup;->requestLayout()V

    .line 129
    .end local v0    # "adjustmentMultiplier":I
    .end local v1    # "prevVisibility":I
    .end local v2    # "visibility":I
    :cond_0
    return-void

    .line 118
    .restart local v1    # "prevVisibility":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_0

    .line 123
    .restart local v2    # "visibility":I
    :cond_2
    const/4 v0, -0x1

    goto :goto_1
.end method

.method private updateBreadcrumbs(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 1
    .param p1, "filterValue"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 155
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->update(Ljava/lang/Object;)V

    .line 157
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->setApplicableBreadcrumbContainerVisibility(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 158
    return-void
.end method


# virtual methods
.method protected applyFilter()V
    .locals 2

    .prologue
    .line 174
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "applyFilter: Start"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 175
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingStarted()V

    .line 176
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 177
    return-void
.end method

.method protected displayPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 8
    .param p2, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ")V"
        }
    .end annotation

    .prologue
    .line 182
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    move-result-object v3

    .line 184
    .local v3, "sortPolicy":Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;, "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortComparator()Ljava/util/Comparator;

    move-result-object v2

    .line 185
    .local v2, "sortComparator":Ljava/util/Comparator;, "Ljava/util/Comparator<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-eqz v2, :cond_0

    .line 186
    invoke-static {p1}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v0

    .line 187
    .local v0, "copy":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortComparator()Ljava/util/Comparator;

    move-result-object v5

    invoke-static {v0, v5}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 188
    move-object p1, v0

    .line 191
    .end local v0    # "copy":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v5

    invoke-virtual {v5, p1, p2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getFilteredPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Ljava/util/List;

    move-result-object v1

    .line 192
    .local v1, "filteredPrograms":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->programAdapter:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;

    invoke-virtual {v5, v1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->setEntities(Ljava/util/List;)V

    .line 193
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->programAdapter:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;

    invoke-virtual {v5, p2}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;->setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 196
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-result-object v4

    .line 197
    .local v4, "sortType":Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->lastSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    if-eqz v5, :cond_1

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->lastSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 198
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->update()V

    .line 202
    :goto_0
    iput-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->lastSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 204
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->LOG:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "displayPrograms() programs.size()="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 205
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 207
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->hideSortButtons()V

    .line 214
    :goto_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 215
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->enableFilterButton()V

    .line 216
    return-void

    .line 200
    :cond_2
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->reset()V

    goto :goto_0

    .line 208
    :cond_3
    sget-object v5, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    if-eq v4, v5, :cond_4

    .line 209
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->showSortButtons()V

    goto :goto_1

    .line 211
    :cond_4
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->hideSortButtons()V

    goto :goto_1
.end method

.method protected getBodyContainerId()I
    .locals 1

    .prologue
    .line 449
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v0, Lcom/xfinity/playerlib/R$id;->body_container:I

    return v0
.end method

.method protected abstract getContentDescriptionForAccessibility()Ljava/lang/CharSequence;
.end method

.method protected abstract getFilterBundle()Landroid/os/Bundle;
.end method

.method protected getFilterButtonId()I
    .locals 1

    .prologue
    .line 459
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v0, Lcom/xfinity/playerlib/R$id;->filter_btn:I

    return v0
.end method

.method protected getFilterButtonOnClickListener()Landroid/view/View$OnClickListener;
    .locals 1

    .prologue
    .line 225
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)V

    return-object v0
.end method

.method protected abstract getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
.end method

.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 474
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v0, Lcom/xfinity/playerlib/R$layout;->browse:I

    return v0
.end method

.method protected getListViewHeaderId()I
    .locals 1

    .prologue
    .line 444
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v0, Lcom/xfinity/playerlib/R$id;->sort_bar:I

    return v0
.end method

.method protected getListViewId()I
    .locals 1

    .prologue
    .line 439
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v0, Lcom/xfinity/playerlib/R$id;->listView:I

    return v0
.end method

.method protected getLoadingIndicatorId()I
    .locals 1

    .prologue
    .line 454
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v0, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    return v0
.end method

.method protected getProgramAdapter(Landroid/view/LayoutInflater;)Landroid/widget/BaseAdapter;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;

    .prologue
    .line 238
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->programAdapter:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;

    if-nez v0, :cond_0

    .line 239
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;

    invoke-direct {v0, p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Landroid/view/LayoutInflater;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->programAdapter:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;

    .line 242
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->programAdapter:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$ProgramAdapter;

    return-object v0
.end method

.method protected getQuickReturnView(Landroid/view/View;)Landroid/view/View;
    .locals 2
    .param p1, "layout"    # Landroid/view/View;

    .prologue
    .line 464
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v1, Lcom/xfinity/playerlib/R$id;->sort_bar:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 465
    .local v0, "view":Landroid/view/View;
    if-nez v0, :cond_0

    .line 466
    sget v1, Lcom/xfinity/playerlib/R$id;->FilterSubNavBar:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 469
    :cond_0
    return-object v0
.end method

.method protected abstract getSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end method

.method protected abstract getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TRT;>;"
        }
    .end annotation
.end method

.method protected abstract getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TRT;>;"
        }
    .end annotation
.end method

.method protected getTopScrollingShadowId()I
    .locals 1

    .prologue
    .line 434
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v0, Lcom/xfinity/playerlib/R$id;->topScrollingShadow:I

    return v0
.end method

.method protected abstract hideSortButtons()V
.end method

.method protected isSortable()Z
    .locals 1

    .prologue
    .line 479
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    const/4 v0, 0x1

    return v0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 110
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onAttach(Landroid/app/Activity;)V

    .line 112
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 113
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 79
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onCreate(Landroid/os/Bundle;)V

    .line 80
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 370
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 372
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->searchable:Lcom/comcast/cim/android/view/common/Searchable;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->searchable:Lcom/comcast/cim/android/view/common/Searchable;

    invoke-interface {v1}, Lcom/comcast/cim/android/view/common/Searchable;->isSearching()Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$bool;->actionbar_show_filter_item:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->shouldShowFilterButton:Z

    if-eqz v1, :cond_1

    .line 373
    sget v1, Lcom/xfinity/playerlib/R$menu;->filter_menu:I

    invoke-virtual {p2, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 375
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_item_filter:I

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 377
    .local v0, "filterMenuItem":Landroid/view/MenuItem;
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)V

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    .line 386
    .end local v0    # "filterMenuItem":Landroid/view/MenuItem;
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 84
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 85
    .local v0, "layout":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->breadcrumb_container:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    .line 86
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getBreadcrumbAdapter()Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->setAdapter(Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;)V

    .line 87
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 88
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getContentDescriptionForAccessibility()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 90
    :cond_0
    return-object v0
.end method

.method public onFilterChange(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 0
    .param p1, "filterValue"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 150
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->updateBreadcrumbs(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 151
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->applyFilter()V

    .line 152
    return-void
.end method

.method public bridge synthetic onFilterChange(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 50
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    check-cast p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->onFilterChange(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    return-void
.end method

.method public onPause()V
    .locals 4

    .prologue
    .line 133
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onPause()V

    .line 134
    const/4 v0, 0x0

    .line 137
    .local v0, "filterValue":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_start_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 142
    :goto_0
    if-eqz v0, :cond_0

    .line 143
    invoke-virtual {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->unregisterOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 144
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->unregisterOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 146
    :cond_0
    return-void

    .line 138
    :catch_0
    move-exception v1

    .line 139
    .local v1, "ise":Ljava/lang/IllegalStateException;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->LOG:Lorg/slf4j/Logger;

    const-string v3, "userSettings is null when I don\'t expect it to be."

    invoke-interface {v2, v3, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)V
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 390
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_item_filter:I

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 391
    .local v0, "filterMenuItem":Landroid/view/MenuItem;
    if-eqz v0, :cond_0

    .line 392
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v1

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 394
    :cond_0
    return-void
.end method

.method public onResumeInternal()V
    .locals 3

    .prologue
    .line 95
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onResumeInternal()V

    .line 97
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    .line 98
    .local v0, "filterValue":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    invoke-virtual {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 99
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->breadcrumbContainer:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 100
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->onFilterChange(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 102
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 104
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->isAccessibilityEnabled:Z

    .line 105
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->isAccessibilityEnabled:Z

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setAccessibilityEnabled(Z)V

    .line 106
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 162
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onStop()V

    .line 167
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 168
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->purgeJobs()V

    .line 169
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->purgeJobs()V

    .line 170
    return-void
.end method

.method protected select(Landroid/view/ViewGroup;)V
    .locals 1
    .param p1, "button"    # Landroid/view/ViewGroup;

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    const/4 v0, 0x1

    .line 343
    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->setSelected(Z)V

    .line 344
    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->updateButtonStateContentDescription(Landroid/view/ViewGroup;Z)V

    .line 346
    return-void
.end method

.method protected setupOtherButton(Landroid/view/ViewGroup;Landroid/widget/Button;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "otherButton"    # Landroid/widget/Button;
    .param p3, "caption"    # Ljava/lang/String;
    .param p4, "speech"    # Ljava/lang/String;

    .prologue
    .line 644
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    invoke-virtual {p2, p3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 645
    invoke-virtual {p2, p4}, Landroid/widget/Button;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 647
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortButtonContentDescriptions:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 648
    invoke-virtual {p1}, Landroid/view/ViewGroup;->isSelected()Z

    move-result v0

    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->updateButtonStateContentDescription(Landroid/view/ViewGroup;Z)V

    .line 650
    return-void
.end method

.method protected setupSortButtons(Landroid/view/ViewGroup;Ljava/util/List;)V
    .locals 5
    .param p1, "layout"    # Landroid/view/ViewGroup;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    .local p2, "sortTypes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;>;"
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 654
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortBar:Landroid/view/View;

    if-nez v0, :cond_2

    .line 655
    sget v0, Lcom/xfinity/playerlib/R$id;->popularitySort:I

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    .line 656
    sget v0, Lcom/xfinity/playerlib/R$id;->otherSort:I

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    .line 657
    sget v0, Lcom/xfinity/playerlib/R$id;->alphabetSort:I

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    .line 672
    :cond_0
    :goto_0
    if-eqz p2, :cond_1

    .line 673
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-interface {p2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 674
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-direct {v2, p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 675
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;

    invoke-interface {p2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-direct {v2, p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 676
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;

    const/4 v0, 0x2

    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-direct {v2, p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 683
    :cond_1
    :goto_1
    return-void

    .line 659
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortBar:Landroid/view/View;

    sget v1, Lcom/xfinity/playerlib/R$id;->popularitySort:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    .line 660
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortBar:Landroid/view/View;

    sget v1, Lcom/xfinity/playerlib/R$id;->otherSort:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    .line 661
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortBar:Landroid/view/View;

    sget v1, Lcom/xfinity/playerlib/R$id;->alphabetSort:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    .line 663
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 664
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-interface {p2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 665
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->makeSortButtonAccessible(Landroid/view/View;)V

    .line 667
    :cond_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->makeSortButtonAccessible(Landroid/view/View;)V

    .line 668
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->makeSortButtonAccessible(Landroid/view/View;)V

    goto :goto_0

    .line 678
    :cond_4
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 679
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;

    invoke-interface {p2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-direct {v2, p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 680
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;

    invoke-interface {p2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-direct {v2, p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    goto :goto_1
.end method

.method protected showFilterButton()V
    .locals 2

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    const/4 v1, 0x1

    .line 423
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->shouldShowFilterButton:Z

    .line 425
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterButton:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 426
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterButton:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 430
    :goto_0
    return-void

    .line 428
    :cond_0
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->setHasOptionsMenu(Z)V

    goto :goto_0
.end method

.method protected abstract showSortButtons()V
.end method

.method protected unselect(Landroid/view/ViewGroup;)V
    .locals 1
    .param p1, "button"    # Landroid/view/ViewGroup;

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    const/4 v0, 0x0

    .line 348
    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->setSelected(Z)V

    .line 349
    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->updateButtonStateContentDescription(Landroid/view/ViewGroup;Z)V

    .line 350
    return-void
.end method

.method protected updateButtonStateContentDescription(Landroid/view/ViewGroup;Z)V
    .locals 5
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "stateIsSelected"    # Z

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>;"
    const/4 v4, 0x0

    .line 354
    invoke-virtual {p1, v4}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 356
    .local v0, "button":Landroid/widget/Button;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortButtonContentDescriptions:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 357
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortButtonContentDescriptions:Ljava/util/HashMap;

    invoke-virtual {v0}, Landroid/widget/Button;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, p1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 360
    :cond_0
    if-eqz p2, :cond_1

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_button_state_selected:I

    .line 364
    .local v1, "stateResString":I
    :goto_0
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->sortButtonContentDescriptions:Ljava/util/HashMap;

    .line 365
    invoke-virtual {v3, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 364
    invoke-virtual {v0, v2}, Landroid/widget/Button;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 366
    return-void

    .line 360
    .end local v1    # "stateResString":I
    :cond_1
    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_button_state_not_selected:I

    goto :goto_0
.end method

.method protected abstract updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
.end method
