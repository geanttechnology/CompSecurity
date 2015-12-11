.class public Lcom/poshmark/ui/fragments/AllPartiesFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "AllPartiesFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field public static bIsFetchingFeedOnScroll:Z


# instance fields
.field private adapter:Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

.field eventListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

.field touchListener:Landroid/view/View$OnTouchListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    sput-boolean v0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->bIsFetchingFeedOnScroll:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 33
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->adapter:Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

    .line 90
    new-instance v0, Lcom/poshmark/ui/fragments/AllPartiesFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment$1;-><init>(Lcom/poshmark/ui/fragments/AllPartiesFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->touchListener:Landroid/view/View$OnTouchListener;

    return-void
.end method

.method private setListScrollHandler()V
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->eventListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    new-instance v1, Lcom/poshmark/ui/fragments/AllPartiesFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment$3;-><init>(Lcom/poshmark/ui/fragments/AllPartiesFragment;)V

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 168
    return-void
.end method

.method private setupPartyList()V
    .locals 2

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->updateList()V

    .line 108
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->eventListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    new-instance v1, Lcom/poshmark/ui/fragments/AllPartiesFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment$2;-><init>(Lcom/poshmark/ui/fragments/AllPartiesFragment;)V

    invoke-virtual {v0, v1}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 134
    return-void
.end method

.method private updateList()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 138
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->getUserVisibleHint()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 139
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/controllers/GlobalPartiesController;->isModelPopulated()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 140
    new-instance v0, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    sget-object v2, Lcom/poshmark/data_model/models/PMData;->ID_COL:Ljava/lang/String;

    aput-object v2, v1, v4

    const/4 v2, 0x1

    sget-object v3, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;-><init>([Ljava/lang/String;)V

    .line 141
    .local v0, "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/poshmark/controllers/GlobalPartiesController;->fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V

    .line 142
    iget-object v1, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->adapter:Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

    invoke-virtual {v1, v0}, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 143
    iget-object v1, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->adapter:Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

    invoke-virtual {v1}, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->notifyDataSetChanged()V

    .line 144
    sput-boolean v4, Lcom/poshmark/ui/fragments/AllPartiesFragment;->bIsFetchingFeedOnScroll:Z

    .line 147
    .end local v0    # "cursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    :cond_0
    return-void
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 172
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.EVENTS_FETCH_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 173
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->updateList()V

    .line 179
    :cond_0
    :goto_0
    return-void

    .line 174
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_END"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 175
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->updateList()V

    goto :goto_0

    .line 176
    :cond_2
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_START"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->updateList()V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 66
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 67
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 38
    new-instance v0, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, v2, v3}, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->adapter:Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

    .line 39
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.EVENTS_FETCH_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 40
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_END"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 41
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.PARTY_EVENT_START"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 42
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 53
    const v1, 0x7f03000e

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 54
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c005c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->eventListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    .line 55
    iget-object v1, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->eventListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->adapter:Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

    invoke-virtual {v1, v2}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 56
    iget-object v1, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->eventListView:Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView;->setOnHeaderClickListener(Lcom/emilsjolander/components/stickylistheaders/StickyListHeadersListView$OnHeaderClickListener;)V

    .line 60
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->setListScrollHandler()V

    .line 61
    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 46
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroy()V

    .line 47
    return-void
.end method

.method public onPMResume()V
    .locals 0

    .prologue
    .line 71
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 72
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->setupPartyList()V

    .line 74
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 85
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onStop()V

    .line 87
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->adapter:Lcom/poshmark/data_model/adapters/AllPartiesAdapter;

    invoke-virtual {v0}, Lcom/poshmark/data_model/adapters/AllPartiesAdapter;->clearImageList()V

    .line 88
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 102
    const-string v0, "parties_home_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AllPartiesFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setupActionBar()V
    .locals 1

    .prologue
    .line 78
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 79
    const v0, 0x7f0601eb

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->setTitle(I)V

    .line 80
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/AllPartiesFragment;->showRefreshButton(Z)V

    .line 81
    return-void
.end method
