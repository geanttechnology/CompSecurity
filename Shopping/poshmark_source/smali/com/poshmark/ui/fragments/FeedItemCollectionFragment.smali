.class public Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "FeedItemCollectionFragment.java"


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

.field private collection:Lcom/poshmark/data_model/models/FeedItemCollection;

.field private collectionListView:Lcom/poshmark/ui/customviews/PMListView;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 34
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 36
    new-instance v0, Ljava/lang/String;

    const-string v1, ""

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->title:Ljava/lang/String;

    return-void
.end method

.method private setupClosetList()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 79
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0118

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collectionListView:Lcom/poshmark/ui/customviews/PMListView;

    .line 80
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collectionListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {v0, v1, v2, v2, v2}, Lcom/poshmark/ui/customviews/PMListView;->setup(Landroid/widget/CursorAdapter;Landroid/view/View;Landroid/view/View;Lcom/poshmark/ui/customviews/PMListView$LoadMoreItemsListener;)V

    .line 81
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collectionListView:Lcom/poshmark/ui/customviews/PMListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collection:Lcom/poshmark/data_model/models/FeedItemCollection;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMListView;->setListData(Lcom/poshmark/data_model/models/PMData;)V

    .line 82
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collectionListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 83
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 62
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 63
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->setupClosetList()V

    .line 64
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 43
    new-instance v1, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const/4 v3, 0x0

    const/high16 v4, -0x80000000

    invoke-direct {v1, v2, p0, v3, v4}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Landroid/database/Cursor;I)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    .line 45
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "TITLE"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->title:Ljava/lang/String;

    .line 46
    new-instance v1, Lcom/poshmark/data_model/models/FeedItemCollection;

    invoke-direct {v1}, Lcom/poshmark/data_model/models/FeedItemCollection;-><init>()V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collection:Lcom/poshmark/data_model/models/FeedItemCollection;

    .line 47
    const-class v1, Ljava/util/List;

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 48
    .local v0, "data":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ListingSummary;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collection:Lcom/poshmark/data_model/models/FeedItemCollection;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/models/FeedItemCollection;->setData(Ljava/util/List;)V

    .line 49
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 53
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 54
    const v1, 0x7f030040

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 57
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onPMResume()V
    .locals 1

    .prologue
    .line 74
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 75
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->collectionListView:Lcom/poshmark/ui/customviews/PMListView;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMListView;->updateList()V

    .line 76
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 68
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onStop()V

    .line 69
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->adapter:Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/ListingSummaryAdapter;->clearImageList()V

    .line 70
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 88
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 93
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 94
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->title:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/FeedItemCollectionFragment;->setTitle(Ljava/lang/String;)V

    .line 95
    return-void
.end method
