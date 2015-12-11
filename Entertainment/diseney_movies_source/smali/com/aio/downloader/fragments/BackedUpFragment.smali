.class public Lcom/aio/downloader/fragments/BackedUpFragment;
.super Landroid/support/v4/app/Fragment;
.source "BackedUpFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;
    }
.end annotation


# static fields
.field protected static final SEARCH_MUSIC_SUCCESS:I


# instance fields
.field private final BACKUP:Ljava/lang/String;

.field private hander:Landroid/os/Handler;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private ll_downnull:Landroid/widget/LinearLayout;

.field private lv_uninstall:Landroid/widget/ListView;

.field private ma:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

.field onClickReceiver:Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 50
    new-instance v0, Lcom/aio/downloader/fragments/BackedUpFragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/BackedUpFragment$1;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->hander:Landroid/os/Handler;

    .line 82
    const-string v0, "backup"

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->BACKUP:Ljava/lang/String;

    .line 310
    new-instance v0, Lcom/aio/downloader/fragments/BackedUpFragment$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/BackedUpFragment$2;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->onClickReceiver:Landroid/content/BroadcastReceiver;

    .line 43
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/BackedUpFragment;Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->ma:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->lv_uninstall:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/BackedUpFragment;)Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->ma:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 346
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->ll_downnull:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/fragments/BackedUpFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/fragments/BackedUpFragment;Ljava/io/File;[Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 147
    invoke-direct {p0, p1, p2}, Lcom/aio/downloader/fragments/BackedUpFragment;->search(Ljava/io/File;[Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->hander:Landroid/os/Handler;

    return-object v0
.end method

.method private search(Ljava/io/File;[Ljava/lang/String;)V
    .locals 4
    .param p1, "file"    # Ljava/io/File;
    .param p2, "ext"    # [Ljava/lang/String;

    .prologue
    .line 148
    if-eqz p1, :cond_0

    .line 149
    invoke-virtual {p1}, Ljava/io/File;->isDirectory()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 150
    invoke-virtual {p1}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 151
    .local v2, "listFile":[Ljava/io/File;
    if-eqz v2, :cond_0

    .line 152
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v3, v2

    if-lt v1, v3, :cond_1

    .line 166
    .end local v1    # "i":I
    .end local v2    # "listFile":[Ljava/io/File;
    :cond_0
    :goto_1
    return-void

    .line 153
    .restart local v1    # "i":I
    .restart local v2    # "listFile":[Ljava/io/File;
    :cond_1
    aget-object v3, v2, v1

    invoke-direct {p0, v3, p2}, Lcom/aio/downloader/fragments/BackedUpFragment;->search(Ljava/io/File;[Ljava/lang/String;)V

    .line 152
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 157
    .end local v1    # "i":I
    .end local v2    # "listFile":[Ljava/io/File;
    :cond_2
    invoke-virtual {p1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 158
    .local v0, "filename":Ljava/lang/String;
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_2
    array-length v3, p2

    if-ge v1, v3, :cond_0

    .line 159
    aget-object v3, p2, v1

    invoke-virtual {v0, v3}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 160
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 158
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_2
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 11
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v5, 0x8

    .line 88
    const v2, 0x7f0300b6

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v10

    .line 90
    .local v10, "view":Landroid/view/View;
    const v2, 0x7f0703d8

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 89
    check-cast v8, Landroid/widget/LinearLayout;

    .line 91
    .local v8, "ll_top_backup":Landroid/widget/LinearLayout;
    invoke-virtual {v8, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 92
    const v2, 0x7f0703da

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->lv_uninstall:Landroid/widget/ListView;

    .line 93
    const v2, 0x7f07018b

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->ll_downnull:Landroid/widget/LinearLayout;

    .line 94
    const v2, 0x7f0703db

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 95
    .local v9, "tv_feelling":Landroid/widget/TextView;
    const v2, 0x7f07018d

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    .line 96
    .local v7, "iv_ioio1":Landroid/widget/ImageView;
    invoke-virtual {v9, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 97
    invoke-virtual {v7, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 98
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;

    .line 100
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 101
    .local v0, "time":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/fragments/BackedUpFragment$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/BackedUpFragment$3;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V

    .line 112
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 114
    new-instance v6, Landroid/content/IntentFilter;

    invoke-direct {v6}, Landroid/content/IntentFilter;-><init>()V

    .line 115
    .local v6, "filter":Landroid/content/IntentFilter;
    const-string v2, "backup"

    invoke-virtual {v6, v2}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 116
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->onClickReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v2, v3, v6}, Landroid/support/v4/app/FragmentActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 118
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v2

    .line 119
    const-string v3, "mounted"

    .line 118
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 119
    if-eqz v2, :cond_1

    .line 120
    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_0

    .line 125
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/aio/downloader/fragments/BackedUpFragment$4;

    invoke-direct {v3, p0}, Lcom/aio/downloader/fragments/BackedUpFragment$4;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 135
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 143
    :cond_0
    :goto_0
    return-object v10

    .line 138
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 139
    const-string v3, "Please insert an external storage device.."

    .line 140
    const/4 v4, 0x1

    .line 138
    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 140
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 358
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 359
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 360
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 351
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 352
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 353
    return-void
.end method
