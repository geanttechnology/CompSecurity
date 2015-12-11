.class public Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;
.super Ljava/lang/Object;
.source "SlideMenuClickListener.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;
    }
.end annotation


# static fields
.field private static final BASE_PATH:Ljava/lang/String; = "/s/browse/categories"

.field private static final DRAWER_GRAVITY:I = 0x5

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

.field private allDepartments:Ljava/lang/String;

.field private browseUrl:Ljava/lang/String;

.field private context:Landroid/content/Context;

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

.field private iconRight:Landroid/view/View;

.field private final listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;

.field private navMenuIcons:Landroid/content/res/TypedArray;

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private position:I

.field private rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

.field private shopByDepartments:Ljava/lang/String;

.field private spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const-class v0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/View;Landroid/support/v4/widget/DrawerLayout;Ljava/util/ArrayList;Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;Lcom/amazon/searchapp/retailsearch/model/SearchResult;Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;Landroid/widget/ListView;Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "iconRight"    # Landroid/view/View;
    .param p3, "drawerLayout"    # Landroid/support/v4/widget/DrawerLayout;
    .param p5, "adapter"    # Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    .param p6, "rst"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .param p7, "spinnerList"    # Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    .param p8, "fastBrowseList"    # Landroid/widget/ListView;
    .param p9, "listener"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/view/View;",
            "Landroid/support/v4/widget/DrawerLayout;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;",
            ">;",
            "Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;",
            "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
            "Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;",
            "Landroid/widget/ListView;",
            "Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 69
    .local p4, "fastBrowseItems":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->browseUrl:Ljava/lang/String;

    .line 70
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->context:Landroid/content/Context;

    .line 71
    iput-object p4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;

    .line 72
    iput-object p5, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    .line 73
    iput-object p3, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    .line 74
    iput-object p6, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .line 75
    iput-object p7, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    .line 76
    iput-object p9, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;

    .line 77
    iput-object p2, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;

    .line 78
    iput-object p8, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseList:Landroid/widget/ListView;

    .line 79
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->rs_search_all_departments:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->allDepartments:Ljava/lang/String;

    .line 80
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$string;->rs_shop_by_department_text:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->shopByDepartments:Ljava/lang/String;

    .line 81
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 82
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/content/res/TypedArray;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->navMenuIcons:Landroid/content/res/TypedArray;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->position:I

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;Lcom/amazon/searchapp/retailsearch/model/SearchResult;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;
    .param p1, "x1"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    return-object p1
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->allDepartments:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->shopByDepartments:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->browseUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseList:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public fetchRefinements()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 136
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$1;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 200
    .local v0, "t1":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 201
    return-void
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 8
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v7, 0x2

    const/4 v6, 0x5

    .line 88
    iput p3, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->position:I

    .line 90
    if-eqz p3, :cond_0

    .line 92
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    const/4 v5, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 93
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 99
    :goto_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/retailsearch/R$array;->nav_drawer_icons:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->obtainTypedArray(I)Landroid/content/res/TypedArray;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->navMenuIcons:Landroid/content/res/TypedArray;

    .line 100
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseItems:Ljava/util/ArrayList;

    invoke-virtual {v4, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseItem;->getBrowseUrl()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->browseUrl:Ljava/lang/String;

    .line 102
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->browseUrl:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 103
    .local v3, "uri":Landroid/net/Uri;
    invoke-static {v3}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->buildCategoryBrowseLink(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v1

    .line 104
    .local v1, "link":Ljava/lang/String;
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    const-string/jumbo v5, "node"

    invoke-virtual {v4, v5}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 106
    .local v2, "node":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->shouldLaunchAIVBrowse(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 108
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v4, v7, v6}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 109
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;

    invoke-interface {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;->onReturnAIV()V

    .line 131
    :goto_1
    return-void

    .line 96
    .end local v1    # "link":Ljava/lang/String;
    .end local v2    # "node":Ljava/lang/String;
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v4, v7, v6}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    goto :goto_0

    .line 113
    .restart local v1    # "link":Ljava/lang/String;
    .restart local v2    # "node":Ljava/lang/String;
    .restart local v3    # "uri":Landroid/net/Uri;
    :cond_1
    invoke-static {v2}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->shouldLaunchAppStoreBrowse(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 115
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->drawerLayout:Landroid/support/v4/widget/DrawerLayout;

    invoke-virtual {v4, v7, v6}, Landroid/support/v4/widget/DrawerLayout;->setDrawerLockMode(II)V

    .line 116
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;

    invoke-interface {v4}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;->onReturnAPP()V

    goto :goto_1

    .line 120
    :cond_2
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->show()V

    .line 121
    iget-object v4, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->listener:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->browseUrl:Ljava/lang/String;

    invoke-interface {v4, v5}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$OnReturnListener;->onReturn(Ljava/lang/String;)V

    .line 125
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fetchRefinements()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 126
    :catch_0
    move-exception v0

    .line 128
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v4, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v5, "Could not fetch refinements"

    invoke-interface {v4, v5, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method protected onRefresh()V
    .locals 2

    .prologue
    .line 208
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v1, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 235
    return-void
.end method
