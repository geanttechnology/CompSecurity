.class public Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# instance fields
.field public adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

.field public canScroll:Z

.field endList:Z

.field f:Landroid/view/LayoutInflater;

.field llLoading:Landroid/widget/LinearLayout;

.field public lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field v:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 39
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 41
    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->endList:Z

    .line 47
    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->canScroll:Z

    .line 213
    return-void
.end method


# virtual methods
.method public loadContent()V
    .locals 3

    .prologue
    .line 58
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;-><init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;)V

    .line 59
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 61
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$1;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;)V

    invoke-virtual {v0, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 74
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;

    invoke-direct {v2, p0, v1}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;)V

    invoke-virtual {v0, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnRefreshListener(Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;)V

    .line 155
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 52
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 53
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->f:Landroid/view/LayoutInflater;

    .line 54
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    .line 159
    const v0, 0x7f03002f

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->v:Landroid/view/View;

    .line 160
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->v:Landroid/view/View;

    const v1, 0x7f070071

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->llLoading:Landroid/widget/LinearLayout;

    .line 162
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    if-nez v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->v:Landroid/view/View;

    .line 175
    :goto_0
    return-object v0

    .line 164
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->v:Landroid/view/View;

    const v1, 0x7f070072

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 166
    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->f:Landroid/view/LayoutInflater;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    invoke-direct {v1, v2, v3, v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    .line 167
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 169
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800dd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 170
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800b6

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 171
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080074

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 173
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->lvNewsfeed:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 175
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->v:Landroid/view/View;

    goto :goto_0
.end method
