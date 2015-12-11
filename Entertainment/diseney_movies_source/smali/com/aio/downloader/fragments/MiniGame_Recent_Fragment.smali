.class public Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;
.super Landroid/support/v4/app/Fragment;
.source "MiniGame_Recent_Fragment.java"

# interfaces
.implements Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;
.implements Lcom/haarman/listviewanimations/itemmanipulation/OnDismissCallback;
.implements Lcom/aio/downloader/mydownload/ContentValue;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ValidFragment",
        "HandlerLeak"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;
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

.field private swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 36
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 41
    iput v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->page:I

    .line 42
    iput v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->next:I

    .line 44
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;

    .line 36
    return-void
.end method

.method private ApppopulistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 157
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 158
    invoke-virtual {v1}, Lcom/aio/downloader/refresh/PullableListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 157
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 160
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 161
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/refresh/PullableListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 163
    return-void
.end method

.method private ShowResult(Ljava/lang/String;)V
    .locals 4
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    .line 121
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/aio/downloader/utils/Myutils;->parseminigamelist(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 122
    iget v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->page:I

    if-ne v0, v3, :cond_0

    .line 123
    new-instance v0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/adapter/MinigameListviewAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    .line 124
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 125
    new-instance v0, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 126
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-direct {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;-><init>(Landroid/widget/BaseAdapter;)V

    .line 125
    iput-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    .line 127
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v1}, Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;->setListView(Landroid/widget/ListView;)V

    .line 128
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->swingBottomInAnimationAdapter:Lcom/haarman/listviewanimations/swinginadapters/prepared/SwingBottomInAnimationAdapter;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 131
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 132
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 133
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->adapter:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->notifyDataSetChanged()V

    .line 134
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)I
    .locals 1

    .prologue
    .line 41
    iget v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->page:I

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 119
    invoke-direct {p0, p1}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->ShowResult(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method private init(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 68
    const v0, 0x7f070072

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 69
    const v0, 0x7f07006f

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/refresh/PullableListView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    .line 70
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v0, p0}, Lcom/aio/downloader/refresh/PullableListView;->setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView$OnLoadListener;)V

    .line 71
    iget-object v0, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    .line 72
    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 49
    const v1, 0x7f030012

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 50
    .local v0, "view":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->init(Landroid/view/View;)V

    .line 51
    new-instance v1, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;-><init>(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 52
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    new-instance v2, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$1;-><init>(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)V

    invoke-virtual {v1, v2}, Lcom/aio/downloader/refresh/PullableListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 63
    return-object v0
.end method

.method public onDismiss(Landroid/widget/ListView;[I)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;
    .param p2, "reverseSortedPositions"    # [I

    .prologue
    .line 138
    return-void
.end method

.method public onLoad(Lcom/aio/downloader/refresh/PullableListView;)V
    .locals 4
    .param p1, "pullableListView"    # Lcom/aio/downloader/refresh/PullableListView;

    .prologue
    const/4 v3, 0x0

    .line 143
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 144
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    .line 145
    .local v0, "model":Lcom/aio/downloader/model/MiniGameModel;
    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getNext()I

    move-result v1

    iput v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->next:I

    .line 148
    .end local v0    # "model":Lcom/aio/downloader/model/MiniGameModel;
    :cond_0
    iget v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->next:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1

    .line 149
    iget v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->page:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->page:I

    .line 150
    new-instance v1, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;-><init>(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)V

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$MinigameRecentAs;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 155
    :goto_0
    return-void

    .line 152
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->listView:Lcom/aio/downloader/refresh/PullableListView;

    invoke-virtual {v1, v3}, Lcom/aio/downloader/refresh/PullableListView;->setHasMoreData(Z)V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 174
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 175
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 176
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 167
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 168
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 169
    return-void
.end method
