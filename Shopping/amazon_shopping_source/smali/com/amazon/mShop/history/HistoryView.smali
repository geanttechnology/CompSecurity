.class public Lcom/amazon/mShop/history/HistoryView;
.super Landroid/widget/RelativeLayout;
.source "HistoryView.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
.implements Lcom/amazon/mShop/history/ObjectDeletingObserver;
.implements Lcom/amazon/mShop/model/auth/UserListener;
.implements Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

.field private mAsinToDelete:Ljava/lang/String;

.field private mAsinsDeleted:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

.field private mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

.field private mEmptyGroup:Landroid/view/View;

.field private mFooter:Landroid/view/View;

.field private mIndexToDelete:I

.field private mListGroup:Landroid/view/View;

.field private mListView:Landroid/widget/ListView;

.field private mProgress:Landroid/widget/ProgressBar;

.field private mStatus:Landroid/widget/TextView;

.field private mVisitDateList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/Date;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const-class v0, Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/history/HistoryView;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 75
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 68
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mVisitDateList:Ljava/util/List;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinsDeleted:Ljava/util/List;

    .line 72
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    .line 76
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->history_list_view:I

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 77
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->items_list:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/history/HistoryView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mListView:Landroid/widget/ListView;

    .line 78
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mListView:Landroid/widget/ListView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setItemsCanFocus(Z)V

    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 81
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->history_list_group:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/history/HistoryView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mListGroup:Landroid/view/View;

    .line 82
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->history_empty_group:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/history/HistoryView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mEmptyGroup:Landroid/view/View;

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mEmptyGroup:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->history_search_link:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/history/HistoryView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/history/HistoryView$1;-><init>(Lcom/amazon/mShop/history/HistoryView;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mEmptyGroup:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->shop_by_department_link:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/history/HistoryView$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/history/HistoryView$2;-><init>(Lcom/amazon/mShop/history/HistoryView;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->search_results_footer:I

    invoke-static {p1, v0, v3}, Lcom/amazon/mShop/history/HistoryView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mFooter:Landroid/view/View;

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mFooter:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_results_progress:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mProgress:Landroid/widget/ProgressBar;

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mFooter:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_results_status:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mStatus:Landroid/widget/TextView;

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mFooter:Landroid/view/View;

    invoke-virtual {v0, v1, v3, v2}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 107
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->bottom_tool_bar:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/history/HistoryView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/BottomToolBar;

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    .line 108
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarParent(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;)V

    .line 109
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->initToolBar()V

    .line 111
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->getDatas()V

    .line 113
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/history/HistoryView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryView;

    .prologue
    .line 50
    iget v0, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/history/HistoryView;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryView;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mVisitDateList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/history/HistoryView;)Lcom/amazon/mShop/ui/BottomToolBar;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryView;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/history/HistoryView;)Lcom/amazon/mShop/control/history/HistoryBrowser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryView;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/history/HistoryView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryView;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->showLoadingStatus()V

    return-void
.end method

.method static synthetic access$500(Lcom/amazon/mShop/history/HistoryView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/history/HistoryView;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->hideStatus()V

    return-void
.end method

.method private getAllViewedItems()Ljava/util/List;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 164
    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    .line 165
    .local v10, "items":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v8, 0x0

    .line 168
    .local v8, "cursor":Landroid/database/Cursor;
    :try_start_0
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/history/HistoryContentProvider;->PRODUCT_URI:Landroid/net/Uri;

    sget-object v3, Lcom/amazon/mShop/history/HistoryEntity;->HISTORY_PROJECTION:[Ljava/lang/String;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string/jumbo v6, "visit_date DESC"

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 169
    .local v0, "cursorLoader":Landroid/support/v4/content/CursorLoader;
    invoke-virtual {v0}, Landroid/support/v4/content/CursorLoader;->loadInBackground()Landroid/database/Cursor;

    move-result-object v8

    .line 170
    if-eqz v8, :cond_1

    invoke-interface {v8}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_1

    .line 171
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mVisitDateList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 172
    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    .line 175
    :cond_0
    const-string/jumbo v1, "asin"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 176
    .local v7, "asin":Ljava/lang/String;
    invoke-interface {v10, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 178
    const-string/jumbo v1, "visit_date"

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v12

    .line 179
    .local v12, "visitDateTime":J
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v11

    .line 180
    .local v11, "visitDate":Ljava/util/Date;
    invoke-virtual {v11, v12, v13}, Ljava/util/Date;->setTime(J)V

    .line 181
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mVisitDateList:Ljava/util/List;

    invoke-interface {v1, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 182
    const/4 v1, 0x1

    invoke-interface {v8, v1}, Landroid/database/Cursor;->move(I)Z
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 187
    .end local v7    # "asin":Ljava/lang/String;
    .end local v11    # "visitDate":Ljava/util/Date;
    .end local v12    # "visitDateTime":J
    :cond_1
    if-eqz v8, :cond_2

    .line 188
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    .line 191
    .end local v0    # "cursorLoader":Landroid/support/v4/content/CursorLoader;
    :cond_2
    :goto_0
    return-object v10

    .line 184
    :catch_0
    move-exception v9

    .line 185
    .local v9, "e":Lcom/amazon/mShop/util/DBException;
    :try_start_1
    sget-object v1, Lcom/amazon/mShop/history/HistoryView;->TAG:Ljava/lang/String;

    invoke-virtual {v9}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 187
    if-eqz v8, :cond_2

    .line 188
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 187
    .end local v9    # "e":Lcom/amazon/mShop/util/DBException;
    :catchall_0
    move-exception v1

    if-eqz v8, :cond_3

    .line 188
    invoke-interface {v8}, Landroid/database/Cursor;->close()V

    :cond_3
    throw v1
.end method

.method private getDatas()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    .line 124
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->getAllViewedItems()Ljava/util/List;

    move-result-object v0

    .line 125
    .local v0, "items":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_0

    .line 126
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->hideStatus()V

    .line 127
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mEmptyGroup:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 128
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mListGroup:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 136
    :goto_0
    return-void

    .line 130
    :cond_0
    new-instance v1, Lcom/amazon/mShop/control/history/HistoryBrowser;

    const/4 v2, 0x3

    invoke-direct {v1, v3, v2, v0, p0}, Lcom/amazon/mShop/control/history/HistoryBrowser;-><init>(IILjava/util/List;Lcom/amazon/mShop/control/home/BasicProductsSubscriber;)V

    iput-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

    .line 131
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/control/history/HistoryBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    .line 132
    new-instance v2, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->history_item_row:I

    invoke-direct {v2, p0, v1, v3}, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;-><init>(Lcom/amazon/mShop/history/HistoryView;Lcom/amazon/mShop/AmazonActivity;I)V

    iput-object v2, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    .line 133
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 134
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryView;->mListView:Landroid/widget/ListView;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->setListView(Landroid/widget/ListView;)V

    goto :goto_0
.end method

.method private hideStatus()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 161
    return-void
.end method

.method private initToolBar()V
    .locals 5

    .prologue
    .line 116
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 117
    .local v1, "toolBarItemsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;>;"
    new-instance v0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->history_clear_all:I

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->history_clear_all:I

    const/4 v4, 0x1

    invoke-direct {v0, v2, v3, v4}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;-><init>(IIZ)V

    .line 118
    .local v0, "clearAllButton":Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 119
    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/ui/BottomToolBar;->init(Ljava/util/List;)V

    .line 120
    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarEnabled(Z)V

    .line 121
    return-void
.end method

.method private showLoadingStatus()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 153
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mProgress:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 154
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mStatus:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 155
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 156
    return-void
.end method


# virtual methods
.method protected deleteAsinsFromDB()Z
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 354
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinToDelete:Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 355
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinsDeleted:Ljava/util/List;

    iget-object v5, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinToDelete:Ljava/lang/String;

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 356
    iput-object v6, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinToDelete:Ljava/lang/String;

    .line 357
    const/4 v4, -0x1

    iput v4, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    .line 359
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinsDeleted:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    .line 360
    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "asin in ("

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 361
    .local v3, "where":Ljava/lang/StringBuilder;
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinsDeleted:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 362
    .local v0, "asin":Ljava/lang/String;
    const-string/jumbo v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "\""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 364
    .end local v0    # "asin":Ljava/lang/String;
    :cond_1
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    .line 365
    const-string/jumbo v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 367
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    sget-object v5, Lcom/amazon/mShop/history/HistoryContentProvider;->PRODUCT_URI:Landroid/net/Uri;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v4, v5, v6, v7}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 371
    :goto_1
    iget-object v4, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinsDeleted:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->clear()V

    .line 372
    const/4 v4, 0x1

    .line 374
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "where":Ljava/lang/StringBuilder;
    :goto_2
    return v4

    .line 368
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v3    # "where":Ljava/lang/StringBuilder;
    :catch_0
    move-exception v1

    .line 369
    .local v1, "e":Lcom/amazon/mShop/util/DBException;
    sget-object v4, Lcom/amazon/mShop/history/HistoryView;->TAG:Ljava/lang/String;

    invoke-virtual {v1}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 374
    .end local v1    # "e":Lcom/amazon/mShop/util/DBException;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "where":Ljava/lang/StringBuilder;
    :cond_2
    const/4 v4, 0x0

    goto :goto_2
.end method

.method public deleteObjectInIndex(I)Z
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 308
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/control/history/HistoryBrowser;->getObjectAtIndex(I)Ljava/lang/Object;

    move-result-object v0

    .line 309
    .local v0, "object":Ljava/lang/Object;
    if-eqz v0, :cond_2

    .line 311
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinToDelete:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 312
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinsDeleted:Ljava/util/List;

    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinToDelete:Ljava/lang/String;

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 313
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

    iget v2, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/history/HistoryBrowser;->deleteObject(I)Z

    .line 314
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mVisitDateList:Ljava/util/List;

    iget v2, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    invoke-interface {v1, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 315
    iget v1, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    if-gt v1, p1, :cond_0

    .line 316
    add-int/lit8 p1, p1, -0x1

    .line 318
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    invoke-virtual {v1}, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->notifyDataSetChanged()V

    .line 320
    :cond_1
    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .end local v0    # "object":Ljava/lang/Object;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinToDelete:Ljava/lang/String;

    .line 321
    iput p1, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    .line 322
    const/4 v1, 0x1

    .line 324
    :goto_0
    return v1

    .restart local v0    # "object":Ljava/lang/Object;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 300
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->history_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected onAttachedToWindow()V
    .locals 0

    .prologue
    .line 336
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onAttachedToWindow()V

    .line 337
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 338
    return-void
.end method

.method public onBasicProductsReceived(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V
    .locals 1
    .param p1, "response"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    .prologue
    .line 295
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->notifyDataSetChanged()V

    .line 296
    return-void
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 406
    packed-switch p2, :pswitch_data_0

    .line 418
    :goto_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 419
    return-void

    .line 409
    :pswitch_0
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/history/HistoryContentProvider;->PRODUCT_URI:Landroid/net/Uri;

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 410
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->refresh()V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 411
    :catch_0
    move-exception v0

    .line 412
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    sget-object v1, Lcom/amazon/mShop/history/HistoryView;->TAG:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 406
    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
    .end packed-switch
.end method

.method protected onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 342
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onDetachedFromWindow()V

    .line 343
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 344
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->deleteAsinsFromDB()Z

    .line 345
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 275
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->hideStatus()V

    .line 276
    new-instance v0, Lcom/amazon/mShop/history/HistoryView$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/history/HistoryView$3;-><init>(Lcom/amazon/mShop/history/HistoryView;)V

    .line 290
    .local v0, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v1, v0, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 291
    return-void
.end method

.method public onToolBarItemSelected(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V
    .locals 2
    .param p1, "toolBarItem"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .prologue
    .line 396
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 397
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->history_confirm_clear_all:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 398
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->yes:I

    invoke-virtual {v0, v1, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 399
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->no:I

    invoke-virtual {v0, v1, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 400
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 401
    return-void
.end method

.method protected refresh()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 139
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->getAllViewedItems()Ljava/util/List;

    move-result-object v0

    .line 140
    .local v0, "items":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_0

    .line 141
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mEmptyGroup:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 142
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mListGroup:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 150
    :goto_0
    return-void

    .line 144
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mEmptyGroup:Landroid/view/View;

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 145
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mListGroup:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 146
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Lcom/amazon/mShop/control/history/HistoryBrowser;->startFirstPageRequest(Ljava/util/List;Ljava/util/List;)Z

    .line 147
    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    invoke-virtual {v1}, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->notifyDataSetChanged()V

    .line 148
    invoke-direct {p0}, Lcom/amazon/mShop/history/HistoryView;->showLoadingStatus()V

    goto :goto_0
.end method

.method public undoDelete(I)V
    .locals 1
    .param p1, "mIndex"    # I

    .prologue
    .line 329
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/history/HistoryView;->mIndexToDelete:I

    .line 330
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mAsinToDelete:Ljava/lang/String;

    .line 331
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView;->mAdapter:Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryView$HistoryPagedItemAdapter;->notifyDataSetChanged()V

    .line 332
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 1
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 386
    invoke-virtual {p0}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 387
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 392
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 380
    return-void
.end method
