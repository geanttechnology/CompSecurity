.class public Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;
.super Lcom/xfinity/playerlib/view/featured/FeaturedFragment;
.source "PhoneFeaturedFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;,
        Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;,
        Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$EntityTabFactory;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private final configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field private pagerAdapter:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;

.field private tabHost:Landroid/widget/TabHost;

.field private viewPager:Landroid/support/v4/view/ViewPager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;-><init>()V

    .line 45
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 262
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Landroid/widget/TabHost;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)Landroid/support/v4/view/ViewPager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->viewPager:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Ljava/util/List;Ljava/lang/String;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;
    .param p1, "x1"    # Landroid/view/ViewGroup;
    .param p2, "x2"    # Lcom/xfinity/playerlib/view/featured/FeaturedSection;
    .param p3, "x3"    # Ljava/util/List;
    .param p4, "x4"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->buildCoverView(Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Ljava/util/List;Ljava/lang/String;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private buildCoverView(Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Ljava/util/List;Ljava/lang/String;)Landroid/view/View;
    .locals 8
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "featuredSection"    # Lcom/xfinity/playerlib/view/featured/FeaturedSection;
    .param p4, "listHeadingForAccessibility"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/ViewGroup;",
            "Lcom/xfinity/playerlib/view/featured/FeaturedSection;",
            "Ljava/util/List",
            "<+",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Landroid/view/View;"
        }
    .end annotation

    .prologue
    .line 151
    .local p3, "programs":Ljava/util/List;, "Ljava/util/List<+Lcom/xfinity/playerlib/model/EditorialProgram;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$layout;->featured_cover:I

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 152
    .local v7, "layout":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->coverList:I

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ListView;

    .line 154
    .local v6, "gallery":Landroid/widget/ListView;
    invoke-virtual {p0, v6, p4}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->setupAccessibleScrollListener(Landroid/widget/AbsListView;Ljava/lang/String;)V

    .line 156
    new-instance v0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->layoutInflator:Landroid/view/LayoutInflater;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Lcom/xfinity/playerlib/config/PlayerConfiguration;Ljava/lang/String;)V

    .line 158
    .local v0, "adapter":Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    sget-object v2, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->premiumNetworks:Ljava/util/Map;

    invoke-virtual {v0, p3, v1, v2}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->setData(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map;)V

    .line 159
    invoke-virtual {v6, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 161
    new-instance v1, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$3;

    invoke-direct {v1, p0, p2, v6}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$3;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Landroid/widget/ListView;)V

    invoke-virtual {v6, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 176
    new-instance v1, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;

    invoke-direct {v1, p0, p2, v6}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Landroid/widget/ListView;)V

    invoke-virtual {v6, v1}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 210
    invoke-virtual {p1, v7}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 211
    return-object v7
.end method

.method private prepareTabHost(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 97
    .local p1, "tabList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v3}, Landroid/widget/TabHost;->clearAllTabs()V

    .line 98
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 99
    .local v0, "tabName":Ljava/lang/String;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v5, v0}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v5

    invoke-virtual {v5, v0}, Landroid/widget/TabHost$TabSpec;->setIndicator(Ljava/lang/CharSequence;)Landroid/widget/TabHost$TabSpec;

    move-result-object v5

    new-instance v6, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$EntityTabFactory;

    const/4 v7, 0x0

    invoke-direct {v6, p0, v7}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$EntityTabFactory;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;)V

    invoke-virtual {v5, v6}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/widget/TabHost$TabContentFactory;)Landroid/widget/TabHost$TabSpec;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    goto :goto_0

    .line 102
    .end local v0    # "tabName":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    new-instance v4, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$2;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$2;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V

    invoke-virtual {v3, v4}, Landroid/widget/TabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 111
    const/4 v2, 0x0

    .local v2, "x":I
    :goto_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_1

    .line 112
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v3}, Landroid/widget/TabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/widget/TabWidget;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    const v4, 0x1020016

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 113
    .local v1, "tv":Landroid/widget/TextView;
    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setAllCaps(Z)V

    .line 111
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 115
    .end local v1    # "tv":Landroid/widget/TextView;
    :cond_1
    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 119
    sget v0, Lcom/xfinity/playerlib/R$layout;->new_featured:I

    return v0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 86
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onAttach(Landroid/app/Activity;)V

    .line 87
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 88
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 53
    .local v0, "layout":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->pager:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/v4/view/ViewPager;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->viewPager:Landroid/support/v4/view/ViewPager;

    .line 54
    sget v1, Lcom/xfinity/playerlib/R$id;->tabs:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TabHost;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    .line 55
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v1}, Landroid/widget/TabHost;->setup()V

    .line 57
    new-instance v1, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->pagerAdapter:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;

    .line 58
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->viewPager:Landroid/support/v4/view/ViewPager;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->pagerAdapter:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;

    invoke-virtual {v1, v2}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 59
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->viewPager:Landroid/support/v4/view/ViewPager;

    new-instance v2, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$1;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V

    invoke-virtual {v1, v2}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 80
    return-object v0
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 92
    invoke-super {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onResumeInternal()V

    .line 93
    return-void
.end method

.method protected postOnResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 138
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/editorial/FeaturedResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/comcast/cim/cmasl/utils/container/Option<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;>;"
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    .line 139
    .local v0, "featuredResource":Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->pagerAdapter:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;

    invoke-virtual {v2, v0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->setData(Lcom/xfinity/playerlib/model/editorial/FeaturedResource;)V

    .line 141
    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getCoverVideoCollectionTitle()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 142
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getSeriesCollectionTitle()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    .line 143
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getMovieCollectionTitle()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 141
    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v1

    .line 145
    .local v1, "labels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->prepareTabHost(Ljava/util/List;)V

    .line 146
    return-void
.end method

.method protected setupAccessibleScrollListener(Landroid/widget/AbsListView;Ljava/lang/String;)V
    .locals 1
    .param p1, "gallery"    # Landroid/widget/AbsListView;
    .param p2, "description"    # Ljava/lang/String;

    .prologue
    .line 257
    new-instance v0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;-><init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V

    .line 258
    .local v0, "availableScrollListener":Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;
    invoke-virtual {v0, p2}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$AccessibleOnScrollListener;->setDescription(Ljava/lang/String;)V

    .line 259
    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 260
    return-void
.end method
