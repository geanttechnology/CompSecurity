.class public Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "PinterestBoardPickerFragment.java"


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;

.field data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

.field disablePinLayout:Landroid/widget/LinearLayout;

.field itemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field lv:Landroid/widget/ListView;

.field mode:I

.field pins:Lcom/poshmark/utils/meta_data/PinterestSettings;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 47
    const/4 v0, -0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->mode:I

    .line 158
    new-instance v0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$3;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->itemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->setFooterView()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->postSelectedBoard()V

    return-void
.end method

.method private postSelectedBoard()V
    .locals 5

    .prologue
    .line 170
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    invoke-virtual {v3}, Lcom/poshmark/utils/meta_data/PinterestBoard;->getBoardHash()Ljava/util/Map;

    move-result-object v0

    .line 171
    .local v0, "boardHash":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 172
    .local v1, "boardType":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/4 v3, 0x2

    iget v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->mode:I

    if-ne v3, v4, :cond_0

    .line 173
    const-string v3, "self_board"

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f060190

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 179
    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iget-object v3, v3, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    invoke-static {v3}, Lcom/poshmark/utils/StringUtils;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 180
    .local v2, "json":Ljava/lang/String;
    new-instance v3, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;

    invoke-direct {v3, p0, v2}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$4;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;Ljava/lang/String;)V

    invoke-static {v1, v3}, Lcom/poshmark/http/api/PMApi;->postPinterestBoardsUpdate(Ljava/util/Map;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 199
    return-void

    .line 175
    .end local v2    # "json":Ljava/lang/String;
    :cond_0
    const-string v3, "others_board"

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private setFooterView()V
    .locals 4

    .prologue
    .line 112
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->disablePinLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0208

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/customviews/PMTextView;

    .line 113
    .local v1, "disablePinText":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->disablePinLayout:Landroid/widget/LinearLayout;

    const v3, 0x7f0c0097

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 114
    .local v0, "checkMark":Landroid/widget/ImageView;
    const v2, 0x7f0600be

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setText(I)V

    .line 115
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->lv:Landroid/widget/ListView;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->disablePinLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 117
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->disablePinLayout:Landroid/widget/LinearLayout;

    new-instance v3, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;

    invoke-direct {v3, p0, v0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$2;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;Landroid/widget/ImageView;)V

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    iget-object v2, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iget-object v2, v2, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    invoke-virtual {v2}, Lcom/poshmark/utils/meta_data/PinterestBoard;->isEnabled()Z

    move-result v2

    if-nez v2, :cond_0

    .line 131
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 132
    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 133
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f09003c

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 135
    :cond_0
    return-void
.end method

.method private setupView()V
    .locals 2

    .prologue
    .line 107
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 108
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->itemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 109
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 75
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 76
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f060190

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 77
    new-instance v0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment$1;-><init>(Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getPinterestBoards(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 103
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->setupView()V

    .line 104
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 51
    new-instance v0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    invoke-direct {v0}, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    .line 52
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "mode"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->mode:I

    .line 53
    const-class v0, Lcom/poshmark/utils/meta_data/PinterestSettings;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/PinterestSettings;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    .line 54
    const/4 v0, 0x2

    iget v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->mode:I

    if-ne v0, v1, :cond_0

    .line 55
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/PinterestSettings;->self_board:Lcom/poshmark/utils/meta_data/PinterestBoard;

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 56
    const-string v0, "my_listings_select_board_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 61
    :goto_0
    return-void

    .line 58
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->pins:Lcom/poshmark/utils/meta_data/PinterestSettings;

    iget-object v1, v1, Lcom/poshmark/utils/meta_data/PinterestSettings;->others_board:Lcom/poshmark/utils/meta_data/PinterestBoard;

    iput-object v1, v0, Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;->currentSelection:Lcom/poshmark/utils/meta_data/PinterestBoard;

    .line 59
    const-string v0, "my_shares_select_board_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 65
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 66
    const v1, 0x7f03009f

    invoke-virtual {p1, v1, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 67
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c025f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->lv:Landroid/widget/ListView;

    .line 68
    new-instance v1, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f03009d

    iget-object v4, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->data:Lcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;

    invoke-direct {v1, v2, v3, v4}, Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;-><init>(Landroid/content/Context;ILcom/poshmark/utils/meta_data/PinterestBoardPickerInfo;)V

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->adapter:Lcom/poshmark/data_model/adapters/PinterestBoardListAdapter;

    .line 69
    const v1, 0x7f03009e

    invoke-virtual {p1, v1, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->disablePinLayout:Landroid/widget/LinearLayout;

    .line 70
    return-object v0
.end method

.method public onPMResume()V
    .locals 0

    .prologue
    .line 144
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 145
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 139
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 140
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 156
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 149
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 150
    const v0, 0x7f06023f

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/PinterestBoardPickerFragment;->setTitle(I)V

    .line 151
    return-void
.end method
