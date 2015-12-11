.class public Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "UnavailableBundleItemsFragment.java"

# interfaces
.implements Lcom/poshmark/utils/BundleItemRemoveClickListener;


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

.field bundleListView:Landroid/widget/ListView;

.field countChanged:Z

.field sellerUsername:Ljava/lang/String;

.field unavailableBundleData:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ListingSummary;",
            ">;"
        }
    .end annotation
.end field

.field userName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->countChanged:Z

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;
    .param p1, "x1"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    return-void
.end method

.method private createAllViews(Landroid/view/View;)V
    .locals 5
    .param p1, "rootView"    # Landroid/view/View;

    .prologue
    .line 107
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 108
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f0c030b

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->bundleListView:Landroid/widget/ListView;

    .line 109
    const v2, 0x7f0300c5

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 110
    .local v1, "listFooterView":Landroid/view/View;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->bundleListView:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 112
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->bundleListView:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 113
    return-void
.end method

.method private fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 5
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    const/4 v4, 0x0

    .line 124
    if-eqz p1, :cond_0

    .line 125
    iget-object v2, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 126
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 127
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/ListingSummary;

    .line 128
    .local v1, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    const/4 v3, 0x1

    aput-object v1, v2, v3

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 131
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/ListingSummary;>;"
    .end local v1    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_0
    return-void
.end method

.method private updateView()V
    .locals 4

    .prologue
    .line 116
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x1

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 117
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 118
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 119
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/BundleListAdapter;->notifyDataSetChanged()V

    .line 121
    return-void
.end method


# virtual methods
.method public handleBack()Z
    .locals 5

    .prologue
    .line 96
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 97
    .local v1, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    if-eqz v1, :cond_0

    .line 98
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getTargetRequestCode()I

    move-result v2

    .line 99
    .local v2, "requestCode":I
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 100
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "UNAVAILABLE_ITEMS_COUNT_CHANGED"

    iget-boolean v4, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->countChanged:Z

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 101
    invoke-virtual {v1, v0, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 103
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v2    # "requestCode":I
    :cond_0
    const/4 v3, 0x0

    return v3
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 81
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 39
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 40
    if-nez p1, :cond_0

    .line 41
    const-class v0, Ljava/util/List;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->unavailableBundleData:Ljava/util/List;

    .line 44
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "NAME"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 45
    .local v8, "uName":Ljava/lang/String;
    if-eqz v8, :cond_1

    .line 46
    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\n"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->userName:Ljava/lang/String;

    .line 49
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SELLER_USER_NAME"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 50
    .local v7, "sName":Ljava/lang/String;
    if-eqz v7, :cond_2

    .line 51
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\n"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->sellerUsername:Ljava/lang/String;

    .line 55
    :cond_2
    new-instance v0, Lcom/poshmark/data_model/adapters/BundleListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v4, Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;->VIEW_UNAVAILABLE_ITEMS:Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;

    const/4 v5, 0x0

    const/high16 v6, -0x80000000

    move-object v2, p0

    move-object v3, p0

    invoke-direct/range {v0 .. v6}, Lcom/poshmark/data_model/adapters/BundleListAdapter;-><init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/PMFragment;Lcom/poshmark/utils/BundleItemRemoveClickListener;Lcom/poshmark/data_model/adapters/BundleListAdapter$MODE;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->adapter:Lcom/poshmark/data_model/adapters/BundleListAdapter;

    .line 56
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 60
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 61
    const v1, 0x7f0300ce

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 62
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->createAllViews(Landroid/view/View;)V

    .line 63
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 68
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 69
    return-void
.end method

.method public onPMResume()V
    .locals 0

    .prologue
    .line 73
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 74
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->updateView()V

    .line 76
    return-void
.end method

.method public removeItemFromBundle(I)V
    .locals 6
    .param p1, "position"    # I

    .prologue
    .line 135
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->unavailableBundleData:Ljava/util/List;

    if-eqz v1, :cond_0

    .line 136
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ge p1, v1, :cond_0

    .line 137
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "bundle"

    const-string v4, "remove_listing_from_bundle_tapped"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->unavailableBundleData:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSummary;

    .line 139
    .local v0, "listing":Lcom/poshmark/data_model/models/ListingSummary;
    const v1, 0x7f060224

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 140
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummary;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;

    invoke-direct {v3, p0, p1}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment$1;-><init>(Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;I)V

    invoke-static {v1, v2, v3}, Lcom/poshmark/http/api/PMApi;->removeListingFromBundle(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 156
    .end local v0    # "listing":Lcom/poshmark/data_model/models/ListingSummary;
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 91
    const-string v0, "bundle_unavailable_items_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setupActionBar()V
    .locals 4

    .prologue
    .line 85
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 86
    const v0, 0x7f0602a3

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->sellerUsername:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UnavailableBundleItemsFragment;->setTitle(Ljava/lang/String;)V

    .line 87
    return-void
.end method
