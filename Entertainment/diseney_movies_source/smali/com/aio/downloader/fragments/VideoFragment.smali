.class public Lcom/aio/downloader/fragments/VideoFragment;
.super Landroid/support/v4/app/Fragment;
.source "VideoFragment.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "ValidFragment"
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

.field private appnotice:Landroid/widget/TextView;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private listdd:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

.field private video_lv:Landroid/widget/ListView;

.field private videosuccessful:Landroid/content/BroadcastReceiver;

.field private view:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 33
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 35
    new-instance v0, Lcom/aio/downloader/fragments/VideoFragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/VideoFragment$1;-><init>(Lcom/aio/downloader/fragments/VideoFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    .line 87
    new-instance v0, Lcom/aio/downloader/fragments/VideoFragment$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/VideoFragment$2;-><init>(Lcom/aio/downloader/fragments/VideoFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->videosuccessful:Landroid/content/BroadcastReceiver;

    .line 100
    iput-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    .line 101
    iput-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 33
    return-void
.end method

.method private ApppopulistViewbottom()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 203
    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;

    .line 204
    invoke-virtual {v1}, Landroid/widget/ListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 203
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 206
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42480000    # 50.0f

    invoke-static {v1, v2}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    invoke-virtual {v0, v3, v3, v3, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 207
    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 209
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/VideoFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/VideoFragment;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/VideoFragment;)Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/VideoFragment;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;

    return-object v0
.end method

.method private init(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 130
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 131
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 135
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "video"

    const-string v2, "timesort"

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    .line 136
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 138
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    .line 140
    :cond_1
    const v0, 0x7f0703f6

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->appnotice:Landroid/widget/TextView;

    .line 141
    const v0, 0x7f0703f5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;

    .line 142
    new-instance v0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    .line 143
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 145
    return-void
.end method


# virtual methods
.method public VideoSort(Ljava/lang/String;)V
    .locals 3
    .param p1, "sort"    # Ljava/lang/String;

    .prologue
    .line 170
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 171
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 175
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "video"

    invoke-virtual {v0, v1, p1}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    .line 176
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 178
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    .line 180
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->view:Landroid/view/View;

    const v1, 0x7f0703f5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;

    .line 181
    new-instance v0, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    invoke-direct {v0, v1, v2}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    .line 182
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->video_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 184
    return-void
.end method

.method public Videodeletall()V
    .locals 4

    .prologue
    .line 150
    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v3, "video"

    invoke-virtual {v2, v3}, Lcom/aio/downloader/db/TypeDbUtils;->deleteallfile(Ljava/lang/String;)V

    .line 153
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_0

    .line 163
    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    iget-object v3, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 165
    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v2}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->notifyDataSetChanged()V

    .line 166
    return-void

    .line 154
    :cond_0
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 155
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 157
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 153
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 109
    const v2, 0x7f0300bc

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->view:Landroid/view/View;

    .line 111
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 112
    .local v0, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v2, "videodelete"

    invoke-virtual {v0, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 113
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/fragments/VideoFragment;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    invoke-virtual {v2, v3, v0}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 117
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 118
    .local v1, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v2, "videosuccessful"

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 119
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/fragments/VideoFragment;->videosuccessful:Landroid/content/BroadcastReceiver;

    invoke-virtual {v2, v3, v1}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 123
    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->view:Landroid/view/View;

    invoke-direct {p0, v2}, Lcom/aio/downloader/fragments/VideoFragment;->init(Landroid/view/View;)V

    .line 124
    invoke-direct {p0}, Lcom/aio/downloader/fragments/VideoFragment;->ApppopulistViewbottom()V

    .line 125
    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment;->view:Landroid/view/View;

    return-object v2
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 199
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 200
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 201
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 188
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 189
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 190
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->appnotice:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 192
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->notifyDataSetChanged()V

    .line 193
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/VideoFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 194
    return-void
.end method
