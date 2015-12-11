.class public Lcom/aio/downloader/activity/MinigamesSearchResultActivity;
.super Landroid/app/Activity;
.source "MinigamesSearchResultActivity.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/MiniGameModel;",
            ">;"
        }
    .end annotation
.end field

.field private listView:Lcom/aio/downloader/refresh/PullableListView;

.field private next:I

.field private page:I

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private search_view:Lcom/aio/downloader/views/DeletableEditText;

.field private searchfan:Landroid/widget/ImageView;

.field private searchimg:Landroid/widget/ImageView;

.field private searchkeywords:Ljava/lang/String;

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 39
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;

    .line 46
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 47
    iput v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->page:I

    .line 48
    iput v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->next:I

    .line 54
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchkeywords:Ljava/lang/String;

    .line 39
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 214
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseminigamelist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 215
    iget v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->page:I

    if-ne v0, v2, :cond_0

    .line 216
    new-instance v0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    .line 217
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    .line 216
    iput-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    .line 218
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 219
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 220
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 219
    iput-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 221
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 222
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 225
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 226
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 227
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->notifyDataSetChanged()V

    .line 230
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchkeywords:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchkeywords:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)I
    .locals 1

    .prologue
    .line 47
    iget v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->page:I

    return v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 212
    invoke-direct {p0, p1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/refresh/PullableListView;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Lcom/aio/downloader/views/DeletableEditText;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    return-object v0
.end method

.method private buildListener()V
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchfan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 119
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchimg:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 120
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    new-instance v1, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$2;-><init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/DeletableEditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 150
    iget-object v0, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchimg:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$3;-><init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    return-void
.end method

.method private init()V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 69
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "searchkeywords"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchkeywords:Ljava/lang/String;

    .line 70
    const v1, 0x7f0702db

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchfan:Landroid/widget/ImageView;

    .line 71
    const v1, 0x7f0702dc

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/views/DeletableEditText;

    iput-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    .line 72
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchkeywords:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    .line 73
    const v1, 0x7f07015c

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->searchimg:Landroid/widget/ImageView;

    .line 74
    const v1, 0x7f070072

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 75
    const v1, 0x7f07006f

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/refresh/PullableListView;

    iput-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 76
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, p0}, Lcom/aio/downloader/refresh/PullableListView;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;)V

    .line 77
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 78
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    new-instance v2, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$1;-><init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 89
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 90
    const-string v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 88
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 92
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->search_view:Lcom/aio/downloader/views/DeletableEditText;

    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    .line 91
    invoke-virtual {v0, v1, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 93
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 234
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 241
    :goto_0
    return-void

    .line 236
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->finish()V

    goto :goto_0

    .line 234
    :pswitch_data_0
    .packed-switch 0x7f0702db
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 59
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 60
    const v0, 0x7f0300af

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->setContentView(I)V

    .line 61
    invoke-direct {p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->init()V

    .line 62
    invoke-direct {p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->buildListener()V

    .line 63
    new-instance v0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;-><init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 65
    return-void
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 97
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView;

    .prologue
    const/4 v3, 0x0

    .line 102
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 103
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    .line 104
    .local v0, "model":Lcom/aio/downloader/model/MiniGameModel;
    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getNext()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->next:I

    .line 107
    .end local v0    # "model":Lcom/aio/downloader/model/MiniGameModel;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 108
    iget v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->page:I

    .line 109
    new-instance v1, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;-><init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$Mya1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 114
    :goto_0
    return-void

    .line 111
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 252
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 253
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 254
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 245
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 246
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 247
    return-void
.end method
