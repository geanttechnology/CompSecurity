.class public Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;
.super Landroid/widget/FrameLayout;
.source "FastBrowseBaseView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    }
.end annotation


# static fields
.field private static final BASE_LAYER:I = 0x0

.field private static final BASE_PATH:Ljava/lang/String; = "/s/browse/categories"

.field private static final DRAWER_GRAVITY:I = 0x5

.field private static final S_PREFIX:Ljava/lang/String; = "/s/b"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

.field private final allDepartments:Ljava/lang/String;

.field private browseUrl:Ljava/lang/String;

.field private drawerLayout:Landroid/support/v4/widget/DrawerLayout;

.field private fastBrowseItems:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;",
            ">;"
        }
    .end annotation
.end field

.field private fastBrowseList:Landroid/widget/ListView;

.field private iconLeft:Landroid/view/View;

.field private iconRight:Landroid/view/View;

.field private listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

.field private navMenuIcons:Landroid/content/res/TypedArray;

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private rootView:Landroid/view/ViewGroup;

.field private rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

.field private final shopByDepartments:Ljava/lang/String;

.field private spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

.field private urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 46
    const-class v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->browseUrl:Ljava/lang/String;

    .line 67
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->rs_search_all_departments:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->allDepartments:Ljava/lang/String;

    .line 68
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->rs_shop_by_department_text:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->shopByDepartments:Ljava/lang/String;

    .line 76
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->init()V

    .line 77
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 81
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 60
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->browseUrl:Ljava/lang/String;

    .line 67
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->rs_search_all_departments:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->allDepartments:Ljava/lang/String;

    .line 68
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->rs_shop_by_department_text:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->shopByDepartments:Ljava/lang/String;

    .line 82
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->init()V

    .line 83
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconLeft:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconRight:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseList:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/support/v4/widget/DrawerLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;Lcom/amazon/searchapp/retailsearch/model/SearchResult;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;
    .param p1, "x1"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    return-object p1
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->allDepartments:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Landroid/content/res/TypedArray;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->navMenuIcons:Landroid/content/res/TypedArray;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->shopByDepartments:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->browseUrl:Ljava/lang/String;

    return-object v0
.end method

.method private init()V
    .locals 3

    .prologue
    .line 87
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 88
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$layout;->rs_right_sliding_menu:I

    invoke-static {v0, v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rootView:Landroid/view/ViewGroup;

    .line 89
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rootView:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/retailsearch/R$id;->right_drawer_layout:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/widget/DrawerLayout;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    .line 90
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x1

    const/4 v2, 0x5

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 91
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rootView:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/retailsearch/R$id;->right_drawer_list:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseList:Landroid/widget/ListView;

    .line 92
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rootView:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/retailsearch/R$id;->right_drawer_icon_in:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconRight:Landroid/view/View;

    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rootView:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/retailsearch/R$id;->right_drawer_icon_out:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconLeft:Landroid/view/View;

    .line 94
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rootView:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/retailsearch/R$id;->refinements_menu_list_spinner:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    .line 95
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->onCreateListView()V

    .line 96
    return-void
.end method


# virtual methods
.method public backOne(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 480
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    monitor-enter v1

    .line 482
    :try_start_0
    const-string/jumbo v0, "/s/b"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 484
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->getBrowseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->updateListView(Ljava/lang/String;)V

    .line 485
    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->getBrowseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onReturn(Ljava/lang/String;)V

    .line 486
    monitor-exit v1

    .line 508
    :goto_0
    return-void

    .line 489
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v0

    if-nez v0, :cond_1

    .line 491
    monitor-exit v1

    goto :goto_0

    .line 507
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 494
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    if-eqz v0, :cond_2

    .line 497
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v0

    if-ne v0, v2, :cond_3

    .line 499
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->updateListView(Ljava/lang/String;)V

    .line 505
    :goto_1
    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->getBrowseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;->onReturn(Ljava/lang/String;)V

    .line 507
    :cond_2
    monitor-exit v1

    goto :goto_0

    .line 502
    :cond_3
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->getBrowseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->updateListView(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method

.method public config()V
    .locals 3

    .prologue
    .line 515
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    sget v1, Lcom/amazon/retailsearch/R$drawable;->drawer_shadow:I

    const/4 v2, 0x5

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerShadow(II)V

    .line 516
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconRight:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 517
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->setIconListner()V

    .line 518
    return-void
.end method

.method public fetchAfterInit()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 250
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$4;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 311
    .local v0, "t1":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 312
    return-void
.end method

.method public fetchRefinements()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 215
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 239
    .local v0, "t1":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 240
    return-void
.end method

.method public isListRoot()Z
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 467
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    if-eqz v1, :cond_0

    .line 469
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->getCurrentLayer()I

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    .line 471
    :cond_0
    return v0
.end method

.method public isRightMenuLock()Z
    .locals 2

    .prologue
    .line 432
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->getDrawerLockMode(I)I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isRightMenuOpen()Z
    .locals 2

    .prologue
    .line 427
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->isDrawerOpen(I)Z

    move-result v0

    return v0
.end method

.method public isRightMenuUnLock()Z
    .locals 2

    .prologue
    .line 437
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->getDrawerLockMode(I)I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public load()V
    .locals 3

    .prologue
    .line 104
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fetchRefinements()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 109
    :goto_0
    return-void

    .line 105
    :catch_0
    move-exception v0

    .line 107
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v2, "Could not fetch refinements"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onCreateListView()V
    .locals 10

    .prologue
    const/4 v8, 0x0

    .line 118
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 119
    .local v1, "context":Landroid/content/Context;
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v2, Lcom/amazon/retailsearch/R$array;->nav_drawer_icons:I

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->obtainTypedArray(I)Landroid/content/res/TypedArray;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->navMenuIcons:Landroid/content/res/TypedArray;

    .line 120
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    .line 123
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    new-instance v2, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->shopByDepartments:Ljava/lang/String;

    const-string/jumbo v4, "/s/browse/categories"

    const-string/jumbo v5, "/s/browse/categories"

    iget-object v6, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->navMenuIcons:Landroid/content/res/TypedArray;

    const/4 v7, -0x1

    invoke-virtual {v6, v8, v7}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v6

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 126
    new-instance v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v8}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;-><init>(Landroid/content/Context;Ljava/util/ArrayList;I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    .line 127
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseList:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 130
    new-instance v0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconRight:Landroid/view/View;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseItems:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    iget-object v7, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    iget-object v8, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseList:Landroid/widget/ListView;

    new-instance v9, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;

    invoke-direct {v9, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$1;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-direct/range {v0 .. v9}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;-><init>(Landroid/content/Context;Landroid/view/View;Landroid/support/v4/widget/DrawerLayout;Ljava/util/ArrayList;Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;Lcom/amazon/searchapp/retailsearch/model/SearchResult;Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;Landroid/widget/ListView;Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .line 154
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fastBrowseList:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 159
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    new-instance v2, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;

    invoke-direct {v2, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$2;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerListener(Landroid/support/v4/widget/DrawerLayout$DrawerListener;)V

    .line 192
    return-void
.end method

.method protected onRefresh()V
    .locals 2

    .prologue
    .line 320
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$5;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 352
    return-void
.end method

.method protected onRefreshAfterInit()V
    .locals 2

    .prologue
    .line 359
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$6;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 378
    return-void
.end method

.method public openAndLockRightMenu()V
    .locals 3

    .prologue
    const/4 v2, 0x5

    .line 421
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    .line 422
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 423
    return-void
.end method

.method public setIconListner()V
    .locals 2

    .prologue
    .line 442
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconLeft:Landroid/view/View;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$7;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$7;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 453
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->iconRight:Landroid/view/View;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$8;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$8;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 463
    return-void
.end method

.method public unlockAndCloseRightMenu()V
    .locals 3

    .prologue
    const/4 v2, 0x5

    .line 415
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 416
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v0, v2}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 417
    return-void
.end method

.method public updateListView(Ljava/lang/String;)V
    .locals 3
    .param p1, "browseUrl"    # Ljava/lang/String;

    .prologue
    .line 404
    :try_start_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->show()V

    .line 405
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->browseUrl:Ljava/lang/String;

    .line 406
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->fetchAfterInit()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 411
    :goto_0
    return-void

    .line 407
    :catch_0
    move-exception v0

    .line 409
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v1, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v2, "Failed to update list view"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public useListener(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;)V
    .locals 0
    .param p1, "urlListener"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->urlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    .line 114
    return-void
.end method

.method public useView(Landroid/view/View;)V
    .locals 2
    .param p1, "webViewContainer"    # Landroid/view/View;

    .prologue
    .line 201
    if-eqz p1, :cond_0

    .line 203
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rootView:Landroid/view/ViewGroup;

    sget v1, Lcom/amazon/retailsearch/R$id;->web_content_frame:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 206
    :cond_0
    return-void
.end method
