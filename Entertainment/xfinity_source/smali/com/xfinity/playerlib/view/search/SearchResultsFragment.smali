.class public Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.super Landroid/app/Fragment;
.source "SearchResultsFragment.java"

# interfaces
.implements Landroid/view/MenuItem$OnActionExpandListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$UpdateSearchRunnable;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;,
        Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HostingActivity;
    }
.end annotation


# static fields
.field public static final EMPTY_SEARCH_RESULTS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation
.end field

.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private activity:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HostingActivity;

.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private final alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

.field private dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field private dropDownEnabled:Z

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private genreFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private final genreMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher",
            "<",
            "Lcom/xfinity/playerlib/model/tags/OrderedTag;",
            ">;"
        }
    .end annotation
.end field

.field private handler:Landroid/os/Handler;

.field private ignoreSearchOnResume:Z

.field private layoutInflater:Landroid/view/LayoutInflater;

.field private menuItemExpanded:Z

.field private networkFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private final networkMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private noResultsView:Landroid/view/View;

.field private numResultsAsOfLastListUpdate:I

.field private optionsMenuCreated:Z

.field private playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

.field private popupWindow:Landroid/widget/PopupWindow;

.field private searchEditText:Landroid/widget/EditText;

.field private searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field private searchResultsAdapter:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;

.field private searchResultsAdapterAccessible:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;

.field private searchResultsListView:Landroid/widget/ListView;

.field private searchResultsListViewAccessible:Landroid/widget/ListView;

.field private searchingView:Landroid/view/View;

.field protected sharedResults:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation
.end field

.field private speakResultsRunnable:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

.field private speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

.field private tagBreadcrumbBottomDivider:Landroid/view/View;

.field private tagBreadcrumbContainer:Landroid/view/ViewGroup;

.field private tagBreadcrumbOuterContainer:Landroid/view/View;

.field private tagCallout:Landroid/widget/TextView;

.field private tagCalloutBottomDivider:Landroid/view/View;

.field private tagCalloutContainer:Landroid/view/View;

.field private tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
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

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
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


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 67
    const-class v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->LOG:Lorg/slf4j/Logger;

    .line 71
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->EMPTY_SEARCH_RESULTS:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 65
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 73
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 74
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAlternateInterfaceUtil()Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    .line 76
    new-instance v0, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    .line 78
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->ignoreSearchOnResume:Z

    .line 86
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsAndProgramsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 88
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSearchQueryProvider()Lcom/comcast/cim/cmasl/utils/provider/Provider;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 89
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 123
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->handler:Landroid/os/Handler;

    .line 129
    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->sharedResults:Ljava/util/List;

    .line 132
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;

    invoke-direct {v0, p0, v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsFragmentSpeechListener;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    .line 420
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$5;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$5;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->networkMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;

    .line 426
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$6;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$6;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->genreMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;

    .line 935
    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->performSearchIfReady()V

    return-void
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->networkMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Ljava/util/Set;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p2, "x2"    # Ljava/util/Set;
    .param p3, "x3"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->programMatchesAny(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Ljava/util/Set;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->genreMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;

    return-object v0
.end method

.method static synthetic access$1300()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 65
    sget-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showResults(Ljava/util/List;)V

    return-void
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speakResultsRunnable:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

    return-object v0
.end method

.method static synthetic access$1502(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speakResultsRunnable:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

    return-object p1
.end method

.method static synthetic access$1600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/PopupWindow;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getDesiredPopupWindowWidth()I

    move-result v0

    return v0
.end method

.method static synthetic access$1900(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getDesiredPopupWindowHeight()I

    move-result v0

    return v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showNoResults()V

    return-void
.end method

.method static synthetic access$2000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    return-object v0
.end method

.method static synthetic access$2602(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;)Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->playNowSearchTalkHelper:Lcom/xfinity/playerlib/alt/PlayerSearchTalkListHelper;

    return-object p1
.end method

.method static synthetic access$2700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    return-object v0
.end method

.method static synthetic access$2800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$2902(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 65
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->ignoreSearchOnResume:Z

    return p1
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    return-object v0
.end method

.method static synthetic access$302(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    return-object p1
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->genreFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    return-object v0
.end method

.method static synthetic access$402(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->genreFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    return-object p1
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->networkFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    return-object v0
.end method

.method static synthetic access$502(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->networkFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    return-object p1
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object v0
.end method

.method static synthetic access$602(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/dibic/DibicResource;)Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object p1
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;Ljava/util/Set;)Lcom/xfinity/playerlib/model/tags/Tag;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    .param p3, "x3"    # Ljava/util/Set;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->findMostRelevantEmbeddedTag(Ljava/lang/String;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;Ljava/util/Set;)Lcom/xfinity/playerlib/model/tags/Tag;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/Tag;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/Tag;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;

    .prologue
    .line 65
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->setUpTagCallout(Lcom/xfinity/playerlib/model/tags/Tag;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;)V

    return-void
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutContainer:Landroid/view/View;

    return-object v0
.end method

.method private addBreadcrumbView(Lcom/xfinity/playerlib/model/tags/Tag;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;)V
    .locals 5
    .param p1, "tag"    # Lcom/xfinity/playerlib/model/tags/Tag;
    .param p2, "clickListener"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;

    .prologue
    .line 756
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->layoutInflater:Landroid/view/LayoutInflater;

    sget v2, Lcom/xfinity/playerlib/R$layout;->search_results_breadcrumb:I

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbContainer:Landroid/view/ViewGroup;

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 757
    .local v0, "breadcrumbView":Landroid/widget/TextView;
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/tags/Tag;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 758
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 759
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 760
    return-void
.end method

.method private varargs anyAreVisible([Landroid/view/View;)Z
    .locals 5
    .param p1, "views"    # [Landroid/view/View;

    .prologue
    const/4 v1, 0x0

    .line 533
    array-length v3, p1

    move v2, v1

    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v0, p1, v2

    .line 534
    .local v0, "view":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v4

    if-nez v4, :cond_1

    .line 535
    const/4 v1, 0x1

    .line 538
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    return v1

    .line 533
    .restart local v0    # "view":Landroid/view/View;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private clearViews()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 459
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchingView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 460
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->noResultsView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 461
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListView:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 462
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 463
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->updateSectionDividerVisibilities()V

    .line 464
    return-void
.end method

.method private findMostRelevantEmbeddedTag(Ljava/lang/String;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;Ljava/util/Set;)Lcom/xfinity/playerlib/model/tags/Tag;
    .locals 3
    .param p1, "titleQuery"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/xfinity/playerlib/model/tags/Tag;",
            ">(",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder",
            "<TT;>;",
            "Ljava/util/Set",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 408
    .local p2, "finder":Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;, "Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder<TT;>;"
    .local p3, "filters":Ljava/util/Set;, "Ljava/util/Set<TT;>;"
    invoke-virtual {p2, p1}, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;->getResults(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/Tag;

    .line 409
    .local v0, "tag":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    invoke-interface {p3, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 413
    .end local v0    # "tag":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getDesiredPopupWindowHeight()I
    .locals 1

    .prologue
    .line 619
    const/4 v0, -0x2

    return v0
.end method

.method private getDesiredPopupWindowWidth()I
    .locals 2

    .prologue
    .line 615
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$bool;->search_drop_down_is_full_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getWidth()I

    move-result v0

    goto :goto_0
.end method

.method private isReadyToPerformSearch()Z
    .locals 1

    .prologue
    .line 404
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->isResumed()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->optionsMenuCreated:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->menuItemExpanded:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private performSearchIfReady()V
    .locals 9

    .prologue
    .line 259
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->isReadyToPerformSearch()Z

    move-result v0

    if-nez v0, :cond_0

    .line 392
    :goto_0
    return-void

    .line 263
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v7

    .line 264
    .local v7, "titleQuery":Ljava/lang/String;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/view/search/SearchQuery;

    .line 265
    .local v6, "searchQuery":Lcom/xfinity/playerlib/view/search/SearchQuery;
    invoke-virtual {v6, v7}, Lcom/xfinity/playerlib/view/search/SearchQuery;->setTitleFilter(Ljava/lang/String;)V

    .line 266
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 268
    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/search/SearchQuery;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 269
    sget-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Query is empty, clearing results and dismissing dropdown"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 271
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapter:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapterAccessible:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;

    if-eqz v0, :cond_2

    .line 272
    :cond_1
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->clearViews()V

    .line 275
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dismissDropDownIfApplicable()V

    goto :goto_0

    .line 281
    :cond_3
    sget-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Showing progress indicator before fetching tags and dibic data"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 282
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showDropDownIfApplicable()V

    .line 283
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->updateBreadcrumbViews()V

    .line 284
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showSearching()V

    .line 286
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->speech_search_for_x:I

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v7, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 288
    new-instance v5, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$3;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$3;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    .line 294
    .local v5, "cancelListener":Landroid/content/DialogInterface$OnCancelListener;
    iget-object v8, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;Lcom/xfinity/playerlib/view/search/SearchQuery;Ljava/lang/String;)V

    invoke-interface {v8, v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method private programMatchesAny(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Ljava/util/Set;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;)Z
    .locals 3
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/xfinity/playerlib/model/tags/Tag;",
            ">(",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            "Ljava/util/Set",
            "<TT;>;",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .line 433
    .local p2, "tags":Ljava/util/Set;, "Ljava/util/Set<TT;>;"
    .local p3, "matcher":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher<TT;>;"
    invoke-interface {p2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/Tag;

    .line 434
    .local v0, "tag":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    invoke-interface {p3, p1, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;->programMatchesTag(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/tags/Tag;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 435
    const/4 v1, 0x1

    .line 438
    .end local v0    # "tag":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private setUpTagCallout(Lcom/xfinity/playerlib/model/tags/Tag;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;)V
    .locals 5
    .param p2, "calloutTextTemplate"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Lcom/xfinity/playerlib/model/tags/Tag;",
            ">(TT;",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .local p1, "tagMatch":Lcom/xfinity/playerlib/model/tags/Tag;, "TT;"
    .local p3, "clickListener":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener<TT;>;"
    const/4 v4, 0x0

    .line 522
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCallout:Landroid/widget/TextView;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/tags/Tag;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, p2, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 523
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCallout:Landroid/widget/TextView;

    invoke-virtual {v0, p3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 524
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutContainer:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 525
    return-void
.end method

.method private showNoResults()V
    .locals 1

    .prologue
    .line 467
    sget-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->EMPTY_SEARCH_RESULTS:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showResults(Ljava/util/List;)V

    .line 468
    return-void
.end method

.method private showResults(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .local p1, "results":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    const/16 v2, 0x8

    const/4 v3, 0x0

    .line 472
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->sharedResults:Ljava/util/List;

    .line 474
    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchingView:Landroid/view/View;

    invoke-virtual {v4, v2}, Landroid/view/View;->setVisibility(I)V

    .line 475
    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->noResultsView:Landroid/view/View;

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_0

    move v2, v3

    :cond_0
    invoke-virtual {v4, v2}, Landroid/view/View;->setVisibility(I)V

    .line 477
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapterAccessible:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;

    invoke-virtual {v2, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->setSearchResults(Ljava/util/List;)V

    .line 478
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapterAccessible:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->notifyDataSetChanged()V

    .line 480
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapter:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;

    invoke-virtual {v2, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->setSearchResults(Ljava/util/List;)V

    .line 481
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapter:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->notifyDataSetChanged()V

    .line 487
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    .line 488
    .local v0, "numResults":I
    iget v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->numResultsAsOfLastListUpdate:I

    if-eq v0, v2, :cond_1

    .line 489
    iput v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->numResultsAsOfLastListUpdate:I

    .line 490
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListView:Landroid/widget/ListView;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setSelection(I)V

    .line 493
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 494
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v4, Lcom/xfinity/playerlib/R$string;->content_description_search_results:I

    invoke-virtual {v2, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 495
    .local v1, "searchResultsDescription":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setVisibility(I)V

    .line 496
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    invoke-virtual {v2, v3, v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setupAccessibleScrollListener(Landroid/widget/AbsListView;Ljava/lang/String;)V

    .line 497
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setTag(Ljava/lang/Object;)V

    .line 499
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    new-instance v3, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$7;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$7;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAccessibilityDelegate(Landroid/view/View$AccessibilityDelegate;)V

    .line 510
    .end local v1    # "searchResultsDescription":Ljava/lang/String;
    :goto_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->updateSectionDividerVisibilities()V

    .line 511
    return-void

    .line 507
    :cond_2
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListView:Landroid/widget/ListView;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setVisibility(I)V

    goto :goto_0
.end method

.method private showSearching()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 514
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchingView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 515
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->noResultsView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 516
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListView:Landroid/widget/ListView;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 517
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 518
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->updateSectionDividerVisibilities()V

    .line 519
    return-void
.end method

.method private updateBreadcrumbViews()V
    .locals 6

    .prologue
    .line 734
    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbContainer:Landroid/view/ViewGroup;

    invoke-virtual {v4}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 735
    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/view/search/SearchQuery;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getNetworkFilters()Ljava/util/Set;

    move-result-object v3

    .line 736
    .local v3, "networkFilters":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/tags/Network;

    .line 737
    .local v2, "networkFilter":Lcom/xfinity/playerlib/model/tags/Network;
    new-instance v5, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;

    invoke-direct {v5, p0, v3, v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$9;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/util/Set;Lcom/xfinity/playerlib/model/tags/Network;)V

    invoke-direct {p0, v2, v5}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->addBreadcrumbView(Lcom/xfinity/playerlib/model/tags/Tag;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;)V

    goto :goto_0

    .line 743
    .end local v2    # "networkFilter":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/view/search/SearchQuery;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getGenreFilters()Ljava/util/Set;

    move-result-object v1

    .line 744
    .local v1, "genreFilters":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 745
    .local v0, "genreFilter":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    new-instance v5, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$10;

    invoke-direct {v5, p0, v1, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$10;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/util/Set;Lcom/xfinity/playerlib/model/tags/OrderedTag;)V

    invoke-direct {p0, v0, v5}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->addBreadcrumbView(Lcom/xfinity/playerlib/model/tags/Tag;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagBreadcrumbClickListener;)V

    goto :goto_1

    .line 751
    .end local v0    # "genreFilter":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbOuterContainer:Landroid/view/View;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/view/search/SearchQuery;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getTagFilters()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_2

    const/16 v4, 0x8

    :goto_2
    invoke-virtual {v5, v4}, Landroid/view/View;->setVisibility(I)V

    .line 752
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->updateSectionDividerVisibilities()V

    .line 753
    return-void

    .line 751
    :cond_2
    const/4 v4, 0x0

    goto :goto_2
.end method

.method private updateSectionDividerVisibilities()V
    .locals 7

    .prologue
    const/16 v2, 0x8

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v1, 0x0

    .line 528
    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutBottomDivider:Landroid/view/View;

    const/4 v0, 0x3

    new-array v0, v0, [Landroid/view/View;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbOuterContainer:Landroid/view/View;

    aput-object v4, v0, v1

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->noResultsView:Landroid/view/View;

    aput-object v4, v0, v5

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchingView:Landroid/view/View;

    aput-object v4, v0, v6

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->anyAreVisible([Landroid/view/View;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 529
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbBottomDivider:Landroid/view/View;

    new-array v3, v6, [Landroid/view/View;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->noResultsView:Landroid/view/View;

    aput-object v4, v3, v1

    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchingView:Landroid/view/View;

    aput-object v4, v3, v5

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->anyAreVisible([Landroid/view/View;)Z

    move-result v3

    if-eqz v3, :cond_1

    :goto_1
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 530
    return-void

    :cond_0
    move v0, v2

    .line 528
    goto :goto_0

    :cond_1
    move v1, v2

    .line 529
    goto :goto_1
.end method


# virtual methods
.method public clearSearchQuery()V
    .locals 2

    .prologue
    .line 629
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/search/SearchQuery;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/search/SearchQuery;->clear()V

    .line 630
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 631
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setTag(Ljava/lang/Object;)V

    .line 632
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->updateBreadcrumbViews()V

    .line 633
    return-void
.end method

.method public dismissDropDownIfApplicable()V
    .locals 1

    .prologue
    .line 623
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dropDownEnabled:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    .line 624
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    .line 626
    :cond_0
    return-void
.end method

.method public getFullResults()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 770
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->sharedResults:Ljava/util/List;

    return-object v0
.end method

.method public getVideoContentDescription(Lcom/comcast/cim/cmasl/utils/container/Tuple;II)Ljava/lang/String;
    .locals 9
    .param p2, "position"    # I
    .param p3, "count"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;II)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 882
    .local p1, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v2, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 884
    .local v2, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    sget-object v5, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->NEW:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 885
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_new_indicator:I

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 887
    .local v1, "newIndicator":Ljava/lang/String;
    :goto_0
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 888
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_video_item_movie:I

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 891
    .local v3, "videoType":Ljava/lang/String;
    :goto_1
    add-int/lit8 v4, p3, -0x1

    if-ne p2, v4, :cond_2

    .line 892
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_video_item_last_list_announce:I

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 894
    .local v0, "announceLastItem":Ljava/lang/String;
    :goto_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_search_video_list_item:I

    const/4 v6, 0x5

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    add-int/lit8 v8, p2, 0x1

    .line 895
    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x1

    aput-object v1, v6, v7

    const/4 v7, 0x2

    aput-object v3, v6, v7

    const/4 v7, 0x3

    .line 898
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x4

    aput-object v0, v6, v7

    .line 894
    invoke-virtual {v4, v5, v6}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 885
    .end local v0    # "announceLastItem":Ljava/lang/String;
    .end local v1    # "newIndicator":Ljava/lang/String;
    .end local v3    # "videoType":Ljava/lang/String;
    :cond_0
    const-string v1, ""

    goto :goto_0

    .line 889
    .restart local v1    # "newIndicator":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_video_item_tv_series:I

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 892
    .restart local v3    # "videoType":Ljava/lang/String;
    :cond_2
    const-string v0, ""

    goto :goto_2
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 220
    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 222
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 223
    .local v0, "view":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    if-nez v1, :cond_0

    .line 224
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dropDownEnabled:Z

    .line 226
    new-instance v1, Landroid/widget/PopupWindow;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const/4 v3, 0x0

    sget v4, Lcom/xfinity/playerlib/R$style;->xfinity_remote_theme:I

    invoke-direct {v1, v2, v3, v4}, Landroid/widget/PopupWindow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    iput-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;

    .line 227
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;

    const/16 v2, 0x10

    invoke-virtual {v1, v2}, Landroid/widget/PopupWindow;->setSoftInputMode(I)V

    .line 228
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v1, v0}, Landroid/widget/PopupWindow;->setContentView(Landroid/view/View;)V

    .line 231
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 232
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 136
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 137
    check-cast v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HostingActivity;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->activity:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HostingActivity;

    .line 138
    invoke-virtual {p1}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->layoutInflater:Landroid/view/LayoutInflater;

    .line 140
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 141
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 151
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 152
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->setHasOptionsMenu(Z)V

    .line 153
    if-eqz p1, :cond_0

    .line 154
    const-string v0, "EXTRA_NUM_RESULTS_AS_OF_LAST_LIST_UPDATE"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->numResultsAsOfLastListUpdate:I

    .line 156
    :cond_0
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 236
    invoke-super {p0, p1, p2}, Landroid/app/Fragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 238
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->activity:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HostingActivity;

    invoke-interface {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HostingActivity;->getSearchEditText()Landroid/widget/EditText;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    .line 239
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    new-instance v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$2;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 254
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->optionsMenuCreated:Z

    .line 255
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->resumeSearchIfReady()V

    .line 256
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 169
    sget v2, Lcom/xfinity/playerlib/R$layout;->search_results:I

    const/4 v3, 0x0

    invoke-virtual {p1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 171
    .local v0, "layout":Landroid/view/ViewGroup;
    new-instance v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    .line 180
    .local v1, "onItemClickListener":Landroid/widget/AdapterView$OnItemClickListener;
    sget v2, Lcom/xfinity/playerlib/R$id;->search_results_list_accessible:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    .line 181
    new-instance v2, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Landroid/content/Context;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapterAccessible:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;

    .line 182
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 183
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListViewAccessible:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapterAccessible:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 185
    sget v2, Lcom/xfinity/playerlib/R$id;->search_results_list:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListView:Landroid/widget/ListView;

    .line 186
    new-instance v2, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapter:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;

    .line 187
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListView:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 188
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchResultsAdapter:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 190
    sget v2, Lcom/xfinity/playerlib/R$id;->no_results:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->noResultsView:Landroid/view/View;

    .line 191
    sget v2, Lcom/xfinity/playerlib/R$id;->searching:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchingView:Landroid/view/View;

    .line 193
    sget v2, Lcom/xfinity/playerlib/R$id;->tag_callout_container:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutContainer:Landroid/view/View;

    .line 194
    sget v2, Lcom/xfinity/playerlib/R$id;->tag_callout:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCallout:Landroid/widget/TextView;

    .line 195
    sget v2, Lcom/xfinity/playerlib/R$id;->tag_callout_bottom_divider:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutBottomDivider:Landroid/view/View;

    .line 197
    sget v2, Lcom/xfinity/playerlib/R$id;->tag_breadcrumb_outer_container:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbOuterContainer:Landroid/view/View;

    .line 198
    sget v2, Lcom/xfinity/playerlib/R$id;->tag_breadcrumb_container:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbContainer:Landroid/view/ViewGroup;

    .line 199
    sget v2, Lcom/xfinity/playerlib/R$id;->tag_breadcrumb_bottom_divider:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagBreadcrumbBottomDivider:Landroid/view/View;

    .line 201
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    sget v3, Lcom/xfinity/playerlib/R$id;->touchy_parent:I

    invoke-interface {v2, v0, v3}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->setupPassiveGestureDetector(Landroid/view/View;I)V

    .line 203
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 573
    invoke-super {p0}, Landroid/app/Fragment;->onDestroyView()V

    .line 574
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dismissDropDownIfApplicable()V

    .line 575
    return-void
.end method

.method public onDetach()V
    .locals 2

    .prologue
    .line 145
    invoke-super {p0}, Landroid/app/Fragment;->onDetach()V

    .line 146
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 147
    return-void
.end method

.method public onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 451
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->menuItemExpanded:Z

    .line 453
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->clearViews()V

    .line 454
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dismissDropDownIfApplicable()V

    .line 455
    const/4 v0, 0x1

    return v0
.end method

.method public onMenuItemActionExpand(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v0, 0x1

    .line 443
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->menuItemExpanded:Z

    .line 445
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->resumeSearchIfReady()V

    .line 446
    return v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 543
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 544
    sget-object v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onPause(): cancelling any in-progress search"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 545
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 546
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 549
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speakResultsRunnable:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 550
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 554
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 555
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->resumeSearchIfReady()V

    .line 556
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 160
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 161
    iget v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->numResultsAsOfLastListUpdate:I

    if-eqz v0, :cond_0

    .line 162
    const-string v0, "EXTRA_NUM_RESULTS_AS_OF_LAST_LIST_UPDATE"

    iget v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->numResultsAsOfLastListUpdate:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 164
    :cond_0
    return-void
.end method

.method public onSpeechSwiped()V
    .locals 1

    .prologue
    .line 903
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->ignoreSearchOnResume:Z

    .line 904
    return-void
.end method

.method public resumeSearchIfReady()V
    .locals 3

    .prologue
    .line 560
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->ignoreSearchOnResume:Z

    if-eqz v1, :cond_1

    .line 569
    :cond_0
    :goto_0
    return-void

    .line 564
    :cond_1
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->isReadyToPerformSearch()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 565
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/search/SearchQuery;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getTitleFilter()Ljava/lang/String;

    move-result-object v0

    .line 566
    .local v0, "titleFilter":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 567
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setSelection(I)V

    goto :goto_0
.end method

.method public showDropDownIfApplicable()V
    .locals 2

    .prologue
    .line 578
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dropDownEnabled:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->popupWindow:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    .line 581
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$8;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 612
    :cond_0
    return-void
.end method

.method public showProgramDetail(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 3
    .param p1, "dibicProgram"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 208
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 211
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 212
    const-string v1, "KEY_ANNOUNCE_EPISODES"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 215
    :cond_0
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->startActivity(Landroid/content/Intent;)V

    .line 216
    return-void
.end method
