.class public Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# instance fields
.field adapter:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

.field public array:Ljava/util/List;

.field public canScroll:Z

.field endList:Z

.field f:Landroid/view/LayoutInflater;

.field llLoading:Landroid/widget/LinearLayout;

.field lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

.field public title:Ljava/lang/String;

.field public vectorId:Ljava/lang/String;

.field public vectorPageType:I

.field public vectorType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 40
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 44
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorId:Ljava/lang/String;

    .line 45
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorType:Ljava/lang/String;

    .line 46
    iput v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorPageType:I

    .line 47
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->endList:Z

    .line 48
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->title:Ljava/lang/String;

    .line 51
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->canScroll:Z

    .line 354
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 56
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 57
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->f:Landroid/view/LayoutInflater;

    .line 58
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    .line 69
    const v0, 0x7f030038

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 71
    const v0, 0x7f0700aa

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    .line 72
    const v0, 0x7f070071

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->llLoading:Landroid/widget/LinearLayout;

    .line 74
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800dd

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setPullLabel(Ljava/lang/CharSequence;)V

    .line 75
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800b6

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setReleaseLabel(Ljava/lang/CharSequence;)V

    .line 76
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getLoadingLayoutProxy()Lcom/handmark/pulltorefresh/library/ILoadingLayout;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080074

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/handmark/pulltorefresh/library/ILoadingLayout;->setRefreshingLabel(Ljava/lang/CharSequence;)V

    .line 78
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    .line 80
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;

    new-instance v3, Lorg/json/JSONObject;

    const-string v4, "{\"type\":\"divider\",\"title\":\"\"}"

    invoke-direct {v3, v4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;-><init>(Lorg/json/JSONObject;Landroid/content/Context;)V

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 84
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->f:Landroid/view/LayoutInflater;

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-direct {v2, v3, v4, v5}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    invoke-virtual {v0, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 85
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 87
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V

    invoke-virtual {v0, v2}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 174
    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;

    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorPageType:I

    invoke-direct {v2, p0, v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;I)V

    .line 176
    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorPageType:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorPageType:I

    const/4 v3, 0x3

    if-ne v0, v3, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorType:Ljava/lang/String;

    const-string v3, "dj"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 177
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getRefreshableView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 179
    :cond_1
    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorPageType:I

    if-nez v0, :cond_2

    .line 180
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;

    invoke-direct {v3, p0, v2}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;)V

    invoke-virtual {v0, v3}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setOnRefreshListener(Lcom/handmark/pulltorefresh/library/PullToRefreshBase$OnRefreshListener;)V

    .line 248
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 249
    return-object v1

    .line 81
    :catch_0
    move-exception v0

    .line 82
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method public setContent()V
    .locals 5

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 65
    :goto_0
    return-void

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->f:Landroid/view/LayoutInflater;

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->array:Ljava/util/List;

    invoke-direct {v1, v2, v3, v4}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter;-><init>(Landroid/content/Context;Landroid/view/LayoutInflater;Ljava/util/List;)V

    invoke-virtual {v0, v1}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 64
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->onRefreshComplete()V

    goto :goto_0
.end method
