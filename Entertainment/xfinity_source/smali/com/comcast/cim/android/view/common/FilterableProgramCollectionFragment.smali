.class public abstract Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;
.super Lcom/comcast/cim/android/view/common/SearchableFragment;
.source "FilterableProgramCollectionFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/android/view/common/SearchableFragment;"
    }
.end annotation


# instance fields
.field protected bodyContainer:Landroid/view/ViewGroup;

.field protected entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

.field protected filterButton:Landroid/view/View;

.field protected filterRequestObserver:Lcom/comcast/cim/android/view/flow/FilterRequestObserver;

.field private header:Landroid/view/View;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field protected layout:Landroid/view/ViewGroup;

.field loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

.field protected positionOfLastClickedItem:I

.field private quickReturnOnScrollChangedListener:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment",
            "<TT;>.com/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChanged",
            "Listener;"
        }
    .end annotation
.end field

.field protected sortBar:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/SearchableFragment;-><init>()V

    .line 27
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 226
    return-void
.end method

.method private buildHeaderView()V
    .locals 5

    .prologue
    .line 125
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    new-instance v0, Landroid/view/View;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->header:Landroid/view/View;

    .line 126
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->header:Landroid/view/View;

    new-instance v1, Landroid/widget/AbsListView$LayoutParams;

    const/4 v2, -0x1

    .line 128
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/comcast/cim/android/R$dimen;->grid_header_height:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-direct {v1, v2, v3}, Landroid/widget/AbsListView$LayoutParams;-><init>(II)V

    .line 126
    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 129
    return-void
.end method

.method private getOnProgramClickListener()Landroid/widget/AdapterView$OnItemClickListener;
    .locals 1

    .prologue
    .line 146
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    new-instance v0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;-><init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;)V

    return-object v0
.end method

.method private getOnProgramLongClickListener()Landroid/widget/AdapterView$OnItemLongClickListener;
    .locals 1

    .prologue
    .line 160
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    new-instance v0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;-><init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;)V

    return-object v0
.end method


# virtual methods
.method protected adjustQuickReturnView(I)V
    .locals 1
    .param p1, "adjustment"    # I

    .prologue
    .line 216
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->quickReturnOnScrollChangedListener:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    if-eqz v0, :cond_0

    .line 217
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->quickReturnOnScrollChangedListener:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;->adjustReferenceRectVerticals(I)V

    .line 219
    :cond_0
    return-void
.end method

.method protected abstract applyFilter()V
.end method

.method protected enableFilterButton()V
    .locals 2

    .prologue
    .line 181
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 182
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterButton:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 183
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterButton:Landroid/view/View;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 188
    :cond_0
    :goto_0
    return-void

    .line 185
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->invalidateOptionsMenu()V

    goto :goto_0
.end method

.method protected abstract getBodyContainerId()I
.end method

.method protected abstract getFilterButtonId()I
.end method

.method protected abstract getFilterButtonOnClickListener()Landroid/view/View$OnClickListener;
.end method

.method protected abstract getLayoutId()I
.end method

.method protected abstract getListViewHeaderId()I
.end method

.method protected abstract getListViewId()I
.end method

.method protected abstract getLoadingIndicatorId()I
.end method

.method public getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    .locals 1

    .prologue
    .line 173
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    return-object v0
.end method

.method protected abstract getProgramAdapter(Landroid/view/LayoutInflater;)Landroid/widget/BaseAdapter;
.end method

.method protected abstract getQuickReturnView(Landroid/view/View;)Landroid/view/View;
.end method

.method protected abstract getTopScrollingShadowId()I
.end method

.method protected abstract isSortable()Z
.end method

.method protected abstract itemClicked(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method protected abstract itemLongClicked(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 0
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 119
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 121
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->applyFilter()V

    .line 122
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 45
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onAttach(Landroid/app/Activity;)V

    .line 46
    check-cast p1, Lcom/comcast/cim/android/view/flow/FilterRequestObserver;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterRequestObserver:Lcom/comcast/cim/android/view/flow/FilterRequestObserver;

    .line 47
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getLayoutId()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    .line 53
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getFilterButtonId()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterButton:Landroid/view/View;

    .line 55
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterButton:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterButton:Landroid/view/View;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getFilterButtonOnClickListener()Landroid/view/View$OnClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getBodyContainerId()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->bodyContainer:Landroid/view/ViewGroup;

    .line 61
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getListViewId()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    .line 62
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getListViewHeaderId()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->sortBar:Landroid/view/View;

    .line 64
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getTopScrollingShadowId()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 65
    .local v8, "scrollingShadow":Landroid/view/View;
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v0, v8}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setScrollingShadow(Landroid/view/View;)V

    .line 67
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->isSortable()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 69
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->buildHeaderView()V

    .line 70
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->header:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->addHeaderView(Landroid/view/View;)V

    .line 72
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getQuickReturnView(Landroid/view/View;)Landroid/view/View;

    move-result-object v7

    .line 73
    .local v7, "quickReturnBar":Landroid/view/View;
    new-instance v0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    invoke-direct {v0, p0, v7}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;-><init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->quickReturnOnScrollChangedListener:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    .line 74
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->quickReturnOnScrollChangedListener:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setOnScrollChangedListener(Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$OnScrollChangedListener;)V

    .line 77
    .end local v7    # "quickReturnBar":Landroid/view/View;
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getProgramAdapter(Landroid/view/LayoutInflater;)Landroid/widget/BaseAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->initialize(Landroid/widget/ListAdapter;)V

    .line 78
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getOnProgramClickListener()Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 79
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getOnProgramLongClickListener()Landroid/widget/AdapterView$OnItemLongClickListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 81
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    const v1, 0x1020004

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 82
    .local v6, "emptyView":Landroid/view/View;
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v0, v6}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setEmptyView(Landroid/view/View;)V

    .line 84
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    sget v1, Lcom/comcast/cim/android/R$id;->body_container:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 85
    .local v2, "bodyContainer":Landroid/view/ViewGroup;
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    sget v1, Lcom/comcast/cim/android/R$id;->loading_indicator:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    .line 86
    .local v3, "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v4, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    new-instance v5, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;

    invoke-direct {v5, p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;-><init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;)V

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;-><init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    .line 93
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->layout:Landroid/view/ViewGroup;

    return-object v0
.end method

.method protected onHideSortBar()V
    .locals 2

    .prologue
    .line 132
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->header:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getHeaderViewCount()I

    move-result v0

    if-lez v0, :cond_0

    .line 133
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->header:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->removeHeaderView(Landroid/view/View;)Z

    .line 135
    :cond_0
    return-void
.end method

.method public onResumeInternal()V
    .locals 2

    .prologue
    .line 98
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onResumeInternal()V

    .line 100
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterButton:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->filterButton:Landroid/view/View;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setEnabled(Z)V

    .line 103
    :cond_0
    return-void
.end method

.method protected onShowSortBar()V
    .locals 2

    .prologue
    .line 138
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->header:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getHeaderViewCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 139
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->buildHeaderView()V

    .line 140
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->header:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->addHeaderView(Landroid/view/View;)V

    .line 143
    :cond_0
    return-void
.end method

.method public onStartInternal()V
    .locals 1

    .prologue
    .line 107
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onStartInternal()V

    .line 108
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStart()V

    .line 109
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 113
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment<TT;>;"
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/SearchableFragment;->onStop()V

    .line 114
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStop()V

    .line 115
    return-void
.end method
