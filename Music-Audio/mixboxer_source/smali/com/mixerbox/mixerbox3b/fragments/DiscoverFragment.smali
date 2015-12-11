.class public Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# instance fields
.field f:Landroid/view/LayoutInflater;

.field locale:Ljava/lang/String;

.field lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field tabHost:Landroid/widget/TabHost;

.field v:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method


# virtual methods
.method public loadContent()V
    .locals 5

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 54
    :goto_0
    return-void

    .line 52
    :cond_0
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->f:Landroid/view/LayoutInflater;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-direct {v2, v3, v4, v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    invoke-virtual {v1, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 53
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 44
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 45
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->locale:Ljava/lang/String;

    .line 46
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->f:Landroid/view/LayoutInflater;

    .line 47
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    .line 58
    const v0, 0x7f03002c

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->v:Landroid/view/View;

    .line 60
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    if-nez v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->v:Landroid/view/View;

    .line 130
    :goto_0
    return-object v0

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->v:Landroid/view/View;

    const v1, 0x7f070066

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 64
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800dd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 65
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800b6

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 66
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080074

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 68
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->f:Landroid/view/LayoutInflater;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-direct {v2, v3, v4, v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    invoke-virtual {v1, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 69
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-gt v0, v1, :cond_1

    .line 70
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 72
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 85
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->lvSystemList:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnRefreshListener(Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;)V

    .line 130
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;->v:Landroid/view/View;

    goto/16 :goto_0
.end method
