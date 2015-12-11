.class public Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
.super Landroid/support/v4/app/Fragment;
.source "BackedUpNoRootFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;
    }
.end annotation


# instance fields
.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

.field private handler:Landroid/os/Handler;

.field private listdd:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/BackupModel;",
            ">;"
        }
    .end annotation
.end field

.field private ll_downnull:Landroid/widget/LinearLayout;

.field private lv_uninstall:Landroid/widget/ListView;

.field private musicListAdapter:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

    .line 45
    new-instance v0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$1;-><init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->handler:Landroid/os/Handler;

    .line 38
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/db/TypeDbUtilsBackup;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->musicListAdapter:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->lv_uninstall:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->musicListAdapter:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->ll_downnull:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/os/Handler;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method public static stringtoBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 5
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 275
    const/4 v0, 0x0

    .line 278
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    const/4 v3, 0x0

    :try_start_0
    invoke-static {p0, v3}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v1

    .line 279
    .local v1, "bitmapArray":[B
    const/4 v3, 0x0

    .line 280
    array-length v4, v1

    .line 279
    invoke-static {v1, v3, v4}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 285
    .end local v1    # "bitmapArray":[B
    :goto_0
    return-object v0

    .line 281
    :catch_0
    move-exception v2

    .line 282
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method bitmap2Drawable(Landroid/graphics/Bitmap;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 289
    new-instance v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v5, 0x8

    .line 79
    const v2, 0x7f0300b6

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-virtual {p1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v9

    .line 81
    .local v9, "view":Landroid/view/View;
    const v2, 0x7f0703d8

    invoke-virtual {v9, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 80
    check-cast v7, Landroid/widget/LinearLayout;

    .line 82
    .local v7, "ll_top_backup":Landroid/widget/LinearLayout;
    invoke-virtual {v7, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 83
    const v2, 0x7f0703da

    invoke-virtual {v9, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->lv_uninstall:Landroid/widget/ListView;

    .line 84
    const v2, 0x7f07018b

    invoke-virtual {v9, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->ll_downnull:Landroid/widget/LinearLayout;

    .line 85
    const v2, 0x7f0703db

    invoke-virtual {v9, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 86
    .local v8, "tv_feelling":Landroid/widget/TextView;
    const v2, 0x7f07018d

    invoke-virtual {v9, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageView;

    .line 87
    .local v6, "iv_ioio1":Landroid/widget/ImageView;
    invoke-virtual {v8, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 88
    invoke-virtual {v6, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 90
    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

    if-nez v2, :cond_0

    .line 91
    new-instance v2, Lcom/aio/downloader/db/TypeDbUtilsBackup;

    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/aio/downloader/db/TypeDbUtilsBackup;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

    .line 94
    :cond_0
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    .line 95
    .local v0, "time":Ljava/util/Timer;
    new-instance v1, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$2;-><init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)V

    .line 106
    .local v1, "task":Ljava/util/TimerTask;
    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 108
    return-object v9
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 122
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 123
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 124
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 114
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 115
    invoke-virtual {p0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 117
    return-void
.end method
