.class public Lcom/poshmark/ui/fragments/ShopFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ShopFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;
    }
.end annotation


# static fields
.field protected static final GET_BRAND:I = 0x2

.field protected static final GET_CATEGORY:I = 0x1

.field protected static final GET_COLOR:I = 0x3


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/ShowroomListAdapter;

.field brandsButton:Landroid/widget/Button;

.field categoriesButton:Landroid/widget/Button;

.field currentPartyTag:Lcom/poshmark/ui/customviews/PMTextView;

.field headerView:Landroid/view/View;

.field listener:Landroid/view/View$OnClickListener;

.field myLikesButton:Landroid/widget/Button;

.field partiesLayout:Landroid/view/ViewGroup;

.field searchKeyword:Ljava/lang/String;

.field searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

.field showRecentSearchesDropDown:Ljava/lang/Boolean;

.field showroomListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 64
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showRecentSearchesDropDown:Ljava/lang/Boolean;

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->adapter:Lcom/poshmark/data_model/adapters/ShowroomListAdapter;

    .line 412
    new-instance v0, Lcom/poshmark/ui/fragments/ShopFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ShopFragment$7;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->listener:Landroid/view/View$OnClickListener;

    .line 435
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ShopFragment;Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShopFragment;
    .param p1, "x1"    # Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShopFragment;->launchUrl(Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;)V

    return-void
.end method

.method private launchUrl(Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;)V
    .locals 4
    .param p1, "info"    # Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;

    .prologue
    .line 408
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 409
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    iget-object v1, p1, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->fragmentData:Landroid/os/Bundle;

    iget-object v2, p1, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->fragmentToLaunch:Ljava/lang/Class;

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 410
    return-void
.end method

.method private setUpButtons()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 328
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 329
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v3, 0x7f0300b8

    invoke-virtual {v2, v3, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    .line 332
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c02cb

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->myLikesButton:Landroid/widget/Button;

    .line 333
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->myLikesButton:Landroid/widget/Button;

    const v4, 0x7f0601b2

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ShopFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 334
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->myLikesButton:Landroid/widget/Button;

    const v4, 0x7f0200a9

    invoke-virtual {v3, v4, v5, v5, v5}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 335
    new-instance v0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    .line 336
    .local v0, "buttonInfo":Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;
    const-class v3, Lcom/poshmark/ui/fragments/MyLikesFragment;

    iput-object v3, v0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 337
    iput-object v6, v0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->fragmentData:Landroid/os/Bundle;

    .line 338
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->myLikesButton:Landroid/widget/Button;

    invoke-virtual {v3, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 339
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->myLikesButton:Landroid/widget/Button;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShopFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 342
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c02cc

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->brandsButton:Landroid/widget/Button;

    .line 343
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->brandsButton:Landroid/widget/Button;

    const v4, 0x7f060061

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ShopFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 344
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->brandsButton:Landroid/widget/Button;

    const v4, 0x7f02006b

    invoke-virtual {v3, v4, v5, v5, v5}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 345
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->brandsButton:Landroid/widget/Button;

    new-instance v4, Lcom/poshmark/ui/fragments/ShopFragment$4;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ShopFragment$4;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 360
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c02cd

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->categoriesButton:Landroid/widget/Button;

    .line 361
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->categoriesButton:Landroid/widget/Button;

    const v4, 0x7f060073

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ShopFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 362
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->categoriesButton:Landroid/widget/Button;

    const v4, 0x7f0200f4

    invoke-virtual {v3, v4, v5, v5, v5}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 363
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->categoriesButton:Landroid/widget/Button;

    new-instance v4, Lcom/poshmark/ui/fragments/ShopFragment$5;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ShopFragment$5;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 377
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c02ce

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 378
    .local v1, "colorButton":Landroid/widget/Button;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f06008b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 379
    const v3, 0x7f0200ef

    invoke-virtual {v1, v3, v5, v5, v5}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 380
    new-instance v3, Lcom/poshmark/ui/fragments/ShopFragment$6;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ShopFragment$6;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 394
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c02cf

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->partiesLayout:Landroid/view/ViewGroup;

    .line 395
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->partiesLayout:Landroid/view/ViewGroup;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShopFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 396
    new-instance v0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    .line 397
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;
    const-class v3, Lcom/poshmark/ui/fragments/AllPartiesFragment;

    iput-object v3, v0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 398
    iput-object v6, v0, Lcom/poshmark/ui/fragments/ShopFragment$ButtonActionInfo;->fragmentData:Landroid/os/Bundle;

    .line 399
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->partiesLayout:Landroid/view/ViewGroup;

    invoke-virtual {v3, v0}, Landroid/view/ViewGroup;->setTag(Ljava/lang/Object;)V

    .line 401
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    const v4, 0x7f0c02d1

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->currentPartyTag:Lcom/poshmark/ui/customviews/PMTextView;

    .line 402
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->updatePartyRow()V

    .line 404
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showroomListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShopFragment;->headerView:Landroid/view/View;

    invoke-virtual {v3, v4}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->addHeaderView(Landroid/view/View;)V

    .line 405
    return-void
.end method

.method private setupShowroomList()V
    .locals 2

    .prologue
    .line 266
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->updateList()V

    .line 268
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showroomListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    new-instance v1, Lcom/poshmark/ui/fragments/ShopFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShopFragment$3;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 286
    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 310
    const v0, 0x7f0c025a

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showroomListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    .line 311
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->setUpButtons()V

    .line 312
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showroomListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->adapter:Lcom/poshmark/data_model/adapters/ShowroomListAdapter;

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 313
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showroomListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setOnHeaderClickListener(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;)V

    .line 314
    return-void
.end method

.method private showSearchResults(ILandroid/content/Intent;)V
    .locals 15
    .param p1, "requestCode"    # I
    .param p2, "data"    # Landroid/content/Intent;

    .prologue
    .line 189
    const/4 v1, 0x0

    .line 191
    .local v1, "b":Landroid/os/Bundle;
    const/4 v8, 0x0

    .line 192
    .local v8, "jsonString":Ljava/lang/String;
    packed-switch p1, :pswitch_data_0

    .line 263
    :cond_0
    :goto_0
    return-void

    .line 194
    :pswitch_0
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 195
    const/4 v3, 0x0

    .line 196
    .local v3, "categoryItem":Lcom/poshmark/data_model/models/MetaItem;
    const-string v13, "DATA_SELECTED"

    invoke-virtual {v1, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 197
    if-eqz v8, :cond_0

    .line 198
    const-class v13, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v8, v13}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .end local v3    # "categoryItem":Lcom/poshmark/data_model/models/MetaItem;
    check-cast v3, Lcom/poshmark/data_model/models/MetaItem;

    .line 199
    .restart local v3    # "categoryItem":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v10, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v10}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 200
    .local v10, "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v13, "available"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 202
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v13

    invoke-virtual {v13}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v12

    .line 203
    .local v12, "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v12, :cond_1

    iget-object v13, v12, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v13

    if-eqz v13, :cond_1

    .line 204
    const/4 v13, 0x1

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 206
    :cond_1
    const-string v13, "ct"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 207
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setCategory(Ljava/lang/String;)V

    .line 208
    const-string v13, "brand"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 209
    const-string v13, "size"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 210
    const-string v13, "color"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 211
    new-instance v11, Landroid/os/Bundle;

    invoke-direct {v11}, Landroid/os/Bundle;-><init>()V

    .line 212
    .local v11, "searchTrigger":Landroid/os/Bundle;
    const-string v13, "SEARCH_TRIGGER"

    const-string v14, "ct"

    invoke-virtual {v11, v13, v14}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 213
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 214
    .local v0, "activity":Lcom/poshmark/ui/PMContainerActivity;
    const-class v13, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v0, v11, v13, v10}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto :goto_0

    .line 218
    .end local v0    # "activity":Lcom/poshmark/ui/PMContainerActivity;
    .end local v3    # "categoryItem":Lcom/poshmark/data_model/models/MetaItem;
    .end local v10    # "model":Lcom/poshmark/utils/SearchFilterModel;
    .end local v11    # "searchTrigger":Landroid/os/Bundle;
    .end local v12    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    :pswitch_1
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 219
    const-string v13, "DATA_SELECTED"

    invoke-virtual {v1, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 220
    if-eqz v8, :cond_0

    .line 221
    const-class v13, Lcom/poshmark/data_model/models/MetaItem;

    invoke-static {v8, v13}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/MetaItem;

    .line 222
    .local v2, "brandItem":Lcom/poshmark/data_model/models/MetaItem;
    new-instance v11, Landroid/os/Bundle;

    invoke-direct {v11}, Landroid/os/Bundle;-><init>()V

    .line 223
    .restart local v11    # "searchTrigger":Landroid/os/Bundle;
    const-string v13, "NAME"

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v13, v14}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 224
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 225
    .restart local v0    # "activity":Lcom/poshmark/ui/PMContainerActivity;
    const-class v13, Lcom/poshmark/ui/fragments/BrandFragment;

    const/4 v14, 0x0

    invoke-virtual {v0, v11, v13, v14}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 229
    .end local v0    # "activity":Lcom/poshmark/ui/PMContainerActivity;
    .end local v2    # "brandItem":Lcom/poshmark/data_model/models/MetaItem;
    .end local v11    # "searchTrigger":Landroid/os/Bundle;
    :pswitch_2
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 230
    const-string v13, "COLOR_CHANGED"

    invoke-virtual {v1, v13}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 231
    .local v7, "isDataChanged":Z
    if-eqz v7, :cond_0

    .line 232
    const-string v13, "COLOR_LIST"

    invoke-virtual {v1, v13}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 233
    .local v5, "colorJson":Ljava/lang/String;
    if-eqz v5, :cond_0

    .line 234
    new-instance v9, Lcom/poshmark/ui/fragments/ShopFragment$2;

    invoke-direct {v9, p0}, Lcom/poshmark/ui/fragments/ShopFragment$2;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    .line 236
    .local v9, "listOfObject":Lcom/google/gson/reflect/TypeToken;
    invoke-static {v5, v9}, Lcom/poshmark/utils/StringUtils;->fromJson(Ljava/lang/String;Lcom/google/gson/reflect/TypeToken;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 237
    .local v6, "colors":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PMColor;>;"
    if-eqz v6, :cond_0

    invoke-interface {v6}, Ljava/util/List;->isEmpty()Z

    move-result v13

    if-nez v13, :cond_0

    .line 238
    new-instance v10, Lcom/poshmark/utils/SearchFilterModel;

    invoke-direct {v10}, Lcom/poshmark/utils/SearchFilterModel;-><init>()V

    .line 239
    .restart local v10    # "model":Lcom/poshmark/utils/SearchFilterModel;
    const-string v13, "available"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setAvailability(Ljava/lang/String;)V

    .line 241
    invoke-static {}, Lcom/poshmark/controllers/UserStateSummaryController;->getGlobalInteractionsController()Lcom/poshmark/controllers/UserStateSummaryController;

    move-result-object v13

    invoke-virtual {v13}, Lcom/poshmark/controllers/UserStateSummaryController;->getUserStateSummary()Lcom/poshmark/data_model/models/UserStateSummary;

    move-result-object v12

    .line 242
    .restart local v12    # "userStateSummary":Lcom/poshmark/data_model/models/UserStateSummary;
    if-eqz v12, :cond_2

    iget-object v13, v12, Lcom/poshmark/data_model/models/UserStateSummary;->user_info:Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/UserStateSummary$UserInfo;->isMySizeAvailable()Z

    move-result v13

    if-eqz v13, :cond_2

    .line 243
    const/4 v13, 0x1

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->enableMySizeFilter(Z)V

    .line 245
    :cond_2
    const-string v13, "clr"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setSearchTrigger(Ljava/lang/String;)V

    .line 246
    const-string v13, "brand"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 247
    const-string v13, "category_v2"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 248
    const-string v13, "category_feature"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 249
    const-string v13, "size"

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->setFacet(Ljava/lang/String;)V

    .line 251
    const/4 v13, 0x0

    invoke-interface {v6, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/PMColor;

    .line 252
    .local v4, "color":Lcom/poshmark/data_model/models/PMColor;
    iget-object v13, v4, Lcom/poshmark/data_model/models/PMColor;->name:Ljava/lang/String;

    invoke-virtual {v10, v13}, Lcom/poshmark/utils/SearchFilterModel;->addColor(Ljava/lang/String;)V

    .line 253
    new-instance v11, Landroid/os/Bundle;

    invoke-direct {v11}, Landroid/os/Bundle;-><init>()V

    .line 254
    .restart local v11    # "searchTrigger":Landroid/os/Bundle;
    const-string v13, "SEARCH_TRIGGER"

    const-string v14, "clr"

    invoke-virtual {v11, v13, v14}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 256
    .restart local v0    # "activity":Lcom/poshmark/ui/PMContainerActivity;
    const-class v13, Lcom/poshmark/ui/fragments/SearchResultsFragment;

    invoke-virtual {v0, v11, v13, v10}, Lcom/poshmark/ui/PMContainerActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 192
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private updateList()V
    .locals 4

    .prologue
    .line 289
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getUserVisibleHint()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 290
    invoke-static {}, Lcom/poshmark/controllers/ShowroomsController;->getGlobalShowroomsController()Lcom/poshmark/controllers/ShowroomsController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/controllers/ShowroomsController;->isModelPopulated()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 291
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

    .line 292
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-static {}, Lcom/poshmark/controllers/ShowroomsController;->getGlobalShowroomsController()Lcom/poshmark/controllers/ShowroomsController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/poshmark/controllers/ShowroomsController;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 293
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->adapter:Lcom/poshmark/data_model/adapters/ShowroomListAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 294
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->adapter:Lcom/poshmark/data_model/adapters/ShowroomListAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;->notifyDataSetChanged()V

    .line 297
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method

.method private updatePartyRow()V
    .locals 3

    .prologue
    .line 300
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v0

    .line 301
    .local v0, "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    invoke-virtual {v0}, Lcom/poshmark/controllers/GlobalPartiesController;->getCurrentPartiesCount()I

    move-result v1

    if-lez v1, :cond_0

    .line 302
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->currentPartyTag:Lcom/poshmark/ui/customviews/PMTextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 307
    :goto_0
    return-void

    .line 305
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->currentPartyTag:Lcom/poshmark/ui/customviews/PMTextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public getTrackingLabel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 181
    const-string v0, "shp"

    return-object v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 424
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.EVENTS_FETCH_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 425
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->updatePartyRow()V

    .line 433
    :cond_0
    :goto_0
    return-void

    .line 426
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_END"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 427
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->updatePartyRow()V

    goto :goto_0

    .line 428
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_START"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 429
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->updatePartyRow()V

    goto :goto_0

    .line 430
    :cond_3
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SHOWROOMS_FETCH_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 431
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->updateList()V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 95
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 96
    if-eqz p1, :cond_0

    .line 97
    const-string v0, "SAVED_SEARCH_KEYWORD"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchKeyword:Ljava/lang/String;

    .line 99
    :cond_0
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 149
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 150
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 151
    invoke-direct {p0, p1, p3}, Lcom/poshmark/ui/fragments/ShopFragment;->showSearchResults(ILandroid/content/Intent;)V

    .line 153
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 77
    sget-object v0, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->REGULAR:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 78
    new-instance v0, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/data_model/adapters/ShowroomListAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->adapter:Lcom/poshmark/data_model/adapters/ShowroomListAdapter;

    .line 79
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.EVENTS_FETCH_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 80
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_END"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 81
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_START"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 82
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SHOWROOMS_FETCH_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 83
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 87
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 88
    const v1, 0x7f0300b7

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 89
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ShopFragment;->setupView(Landroid/view/View;)V

    .line 90
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 175
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 176
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->saveSearchesInActionBar()V

    .line 177
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 157
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 158
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchKeyword:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchKeyword:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showRecentSearchesDropDown:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 160
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchKeyword:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setText(Ljava/lang/String;)V

    .line 169
    :cond_0
    :goto_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->setupShowroomList()V

    .line 170
    return-void

    .line 162
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchKeyword:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setSilentText(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 103
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 104
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    if-eqz v1, :cond_0

    .line 105
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->getUserInput()Ljava/lang/String;

    move-result-object v0

    .line 106
    .local v0, "keyword":Ljava/lang/String;
    const-string v1, "SAVED_SEARCH_KEYWORD"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    .end local v0    # "keyword":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method protected saveSearchesInActionBar()V
    .locals 3

    .prologue
    .line 317
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 318
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 319
    .local v1, "customView":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 322
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 185
    const-string v0, "shop_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShopFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 186
    return-void
.end method

.method public setupActionBar()V
    .locals 4

    .prologue
    .line 113
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getUserVisibleHint()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 114
    const v2, 0x7f030006

    invoke-super {p0, v2}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar(I)V

    .line 115
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShopFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 116
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 117
    .local v1, "customView":Landroid/view/View;
    if-eqz v1, :cond_0

    .line 118
    const v2, 0x7f0c0041

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    .line 119
    sget-object v2, Lcom/poshmark/ui/MainActivity;->SHOP_TAB_SEARCH_FLAG_KEY:Ljava/util/UUID;

    invoke-static {v2}, Lcom/poshmark/utils/ObjectPickupDropOff;->pickupDataObject(Ljava/util/UUID;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showRecentSearchesDropDown:Ljava/lang/Boolean;

    .line 120
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showRecentSearchesDropDown:Ljava/lang/Boolean;

    if-eqz v2, :cond_1

    .line 121
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showRecentSearchesDropDown:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->showRecentsAsDefaults(Z)V

    .line 125
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment;->searchView:Lcom/poshmark/ui/customviews/PMCustomSearchWidget;

    new-instance v3, Lcom/poshmark/ui/fragments/ShopFragment$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/ShopFragment$1;-><init>(Lcom/poshmark/ui/fragments/ShopFragment;)V

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/PMCustomSearchWidget;->setParentListener(Lcom/poshmark/utils/PMSearchViewListener;)V

    .line 145
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v1    # "customView":Landroid/view/View;
    :cond_0
    return-void

    .line 123
    .restart local v0    # "actionBar":Landroid/app/ActionBar;
    .restart local v1    # "customView":Landroid/view/View;
    :cond_1
    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShopFragment;->showRecentSearchesDropDown:Ljava/lang/Boolean;

    goto :goto_0
.end method
