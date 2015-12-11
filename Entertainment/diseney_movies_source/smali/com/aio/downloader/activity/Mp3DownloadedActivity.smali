.class public Lcom/aio/downloader/activity/Mp3DownloadedActivity;
.super Landroid/app/Activity;
.source "Mp3DownloadedActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

.field private champ3:Landroid/widget/ImageView;

.field currenttime:Landroid/widget/TextView;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private filemoremp3:Landroid/widget/ImageView;

.field handler:Landroid/os/Handler;

.field private istag:Ljava/lang/Boolean;

.field private l1:Landroid/widget/RelativeLayout;

.field private l2:Landroid/widget/RelativeLayout;

.field private l3:Landroid/widget/RelativeLayout;

.field private l4:Landroid/widget/RelativeLayout;

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

.field private mWindow:Landroid/widget/PopupWindow;

.field private mp3_lv:Landroid/widget/ListView;

.field private mp3fan:Landroid/widget/ImageView;

.field private mp3notice:Landroid/widget/TextView;

.field private mp3play:Landroid/content/BroadcastReceiver;

.field private mp3successful:Landroid/content/BroadcastReceiver;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ShowToast"
        }
    .end annotation
.end field

.field private musicProgress:Landroid/widget/SeekBar;

.field private playbarmp3:Landroid/widget/RelativeLayout;

.field private player:Lcom/aio/downloader/utils/Player;

.field private playpausemp3:Landroid/widget/ImageView;

.field showBroadcast:Landroid/content/BroadcastReceiver;

.field private stopmp3:Landroid/content/BroadcastReceiver;

.field private task:Ljava/util/TimerTask;

.field private timer:Ljava/util/Timer;

.field title:Landroid/widget/TextView;

.field totaltime:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 44
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 47
    new-instance v0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    .line 97
    new-instance v0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$2;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->handler:Landroid/os/Handler;

    .line 118
    new-instance v0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$3;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3successful:Landroid/content/BroadcastReceiver;

    .line 129
    new-instance v0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$4;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->showBroadcast:Landroid/content/BroadcastReceiver;

    .line 147
    new-instance v0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$5;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3play:Landroid/content/BroadcastReceiver;

    .line 185
    new-instance v0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$6;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->stopmp3:Landroid/content/BroadcastReceiver;

    .line 197
    iput-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    .line 198
    iput-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 207
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->istag:Ljava/lang/Boolean;

    .line 44
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->champ3:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->istag:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->playpausemp3:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 207
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->istag:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;
    .locals 1

    .prologue
    .line 197
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Lcom/aio/downloader/utils/Player;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 196
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3_lv:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->playbarmp3:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->timer:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Ljava/util/TimerTask;)V
    .locals 0

    .prologue
    .line 213
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->task:Ljava/util/TimerTask;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->timer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/util/TimerTask;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->task:Ljava/util/TimerTask;

    return-object v0
.end method

.method private buildLister()V
    .locals 2

    .prologue
    .line 294
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3fan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 295
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->filemoremp3:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 297
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->musicProgress:Landroid/widget/SeekBar;

    new-instance v1, Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$SeekBarChangeEvent;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 299
    new-instance v0, Lcom/aio/downloader/utils/Player;

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->musicProgress:Landroid/widget/SeekBar;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/utils/Player;-><init>(Landroid/content/Context;Landroid/widget/SeekBar;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    .line 300
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->playpausemp3:Landroid/widget/ImageView;

    .line 301
    new-instance v1, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$7;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 321
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->champ3:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/Mp3DownloadedActivity$8;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$8;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 339
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 263
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 264
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 267
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "mp3"

    const-string v2, "timesort"

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    .line 268
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 270
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    .line 272
    :cond_1
    const v0, 0x7f0702f3

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3fan:Landroid/widget/ImageView;

    .line 273
    const v0, 0x7f0702f4

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->filemoremp3:Landroid/widget/ImageView;

    .line 274
    const v0, 0x7f0702f5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3_lv:Landroid/widget/ListView;

    .line 275
    const v0, 0x7f0702f6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3notice:Landroid/widget/TextView;

    .line 276
    new-instance v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    .line 277
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 281
    const v0, 0x7f07018f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->playpausemp3:Landroid/widget/ImageView;

    .line 282
    const v0, 0x7f070190

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->champ3:Landroid/widget/ImageView;

    .line 284
    const v0, 0x7f07018e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->playbarmp3:Landroid/widget/RelativeLayout;

    .line 285
    const v0, 0x7f0700ec

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->totaltime:Landroid/widget/TextView;

    .line 286
    const v0, 0x7f0700ea

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->currenttime:Landroid/widget/TextView;

    .line 287
    const v0, 0x7f0700e7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->title:Landroid/widget/TextView;

    .line 288
    const v0, 0x7f0700eb

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->musicProgress:Landroid/widget/SeekBar;

    .line 290
    return-void
.end method

.method private popuWindow()V
    .locals 7

    .prologue
    .line 443
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 444
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f030041

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 445
    .local v3, "view":Landroid/view/View;
    const v5, 0x7f070191

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l1:Landroid/widget/RelativeLayout;

    .line 446
    const v5, 0x7f070192

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l2:Landroid/widget/RelativeLayout;

    .line 447
    const v5, 0x7f070193

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l3:Landroid/widget/RelativeLayout;

    .line 448
    const v5, 0x7f0701ac

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l4:Landroid/widget/RelativeLayout;

    .line 450
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l1:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 451
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l2:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 452
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l3:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 453
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->l4:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 455
    new-instance v5, Landroid/widget/PopupWindow;

    invoke-direct {v5, v3}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    .line 456
    invoke-virtual {p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v5

    .line 457
    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 458
    .local v1, "h":I
    invoke-virtual {p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v5

    .line 459
    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getWidth()I

    move-result v4

    .line 460
    .local v4, "w":I
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    div-int/lit8 v6, v4, 0x2

    add-int/lit8 v6, v6, 0x32

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 461
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const/4 v6, -0x2

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 462
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 463
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const v6, 0x7f0c0011

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 464
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    const/4 v5, 0x0

    invoke-direct {v0, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 465
    .local v0, "dw":Landroid/graphics/drawable/ColorDrawable;
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v5, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 467
    return-void
.end method


# virtual methods
.method public Mp3Sort(Ljava/lang/String;)V
    .locals 2
    .param p1, "sort"    # Ljava/lang/String;

    .prologue
    .line 364
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 365
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 368
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "mp3"

    invoke-virtual {v0, v1, p1}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    .line 369
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 371
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    .line 373
    :cond_1
    const v0, 0x7f0702f5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3_lv:Landroid/widget/ListView;

    .line 374
    new-instance v0, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    .line 375
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 377
    return-void
.end method

.method public Mp3deletall()V
    .locals 4

    .prologue
    .line 344
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v3, "mp3"

    invoke-virtual {v2, v3}, Lcom/aio/downloader/db/TypeDbUtils;->deleteallfile(Ljava/lang/String;)V

    .line 347
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_0

    .line 357
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    iget-object v3, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 359
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    invoke-virtual {v2}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->notifyDataSetChanged()V

    .line 360
    return-void

    .line 348
    :cond_0
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 349
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 351
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 347
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 471
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 534
    :goto_0
    return-void

    .line 473
    :sswitch_0
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->moveTaskToBack(Z)Z

    goto :goto_0

    .line 476
    :sswitch_1
    invoke-direct {p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->popuWindow()V

    .line 477
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2, p1}, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View;)V

    goto :goto_0

    .line 480
    :sswitch_2
    const-string v2, "timesort"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->Mp3Sort(Ljava/lang/String;)V

    .line 481
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 484
    :sswitch_3
    const-string v2, "zimusort"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->Mp3Sort(Ljava/lang/String;)V

    .line 485
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 488
    :sswitch_4
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 489
    const v3, 0x7f0b0034

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 490
    const v3, 0x7f0b0042

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 492
    const v3, 0x7f0b003c

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 493
    new-instance v4, Lcom/aio/downloader/activity/Mp3DownloadedActivity$9;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$9;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    .line 491
    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 502
    const v3, 0x7f0b003b

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 503
    new-instance v4, Lcom/aio/downloader/activity/Mp3DownloadedActivity$10;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$10;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V

    .line 501
    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 510
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 511
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 514
    :sswitch_5
    new-instance v0, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    .line 515
    const v2, 0x7f0c000e

    .line 514
    invoke-direct {v0, p0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;-><init>(Landroid/content/Context;I)V

    .line 516
    .local v0, "downloadpathCustomDialog":Lcom/aio/downloader/dialog/DownloadpathCustomDialog;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->setCanceledOnTouchOutside(Z)V

    .line 517
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->show()V

    .line 519
    const v2, 0x7f070194

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 518
    check-cast v1, Landroid/widget/Button;

    .line 521
    .local v1, "downloadpathCustomDialogok":Landroid/widget/Button;
    new-instance v2, Lcom/aio/downloader/activity/Mp3DownloadedActivity$11;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$11;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;Lcom/aio/downloader/dialog/DownloadpathCustomDialog;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 529
    iget-object v2, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto/16 :goto_0

    .line 471
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f070191 -> :sswitch_2
        0x7f070192 -> :sswitch_3
        0x7f070193 -> :sswitch_4
        0x7f0701ac -> :sswitch_5
        0x7f0702f3 -> :sswitch_0
        0x7f0702f4 -> :sswitch_1
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 223
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 224
    const v5, 0x7f03007d

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->setContentView(I)V

    .line 227
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 228
    .local v0, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v5, "mp3delete"

    invoke-virtual {v0, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 229
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 233
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 234
    .local v1, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v5, "mp3successful"

    invoke-virtual {v1, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 235
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3successful:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v1}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 238
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    .line 239
    .local v2, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v5, "mp3play"

    invoke-virtual {v2, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 240
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3play:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v2}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 243
    new-instance v3, Landroid/content/IntentFilter;

    invoke-direct {v3}, Landroid/content/IntentFilter;-><init>()V

    .line 244
    .local v3, "showIntentFilter4":Landroid/content/IntentFilter;
    const-string v5, "show"

    invoke-virtual {v3, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 245
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->showBroadcast:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v3}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 247
    new-instance v4, Landroid/content/IntentFilter;

    invoke-direct {v4}, Landroid/content/IntentFilter;-><init>()V

    .line 248
    .local v4, "showIntentFilter5":Landroid/content/IntentFilter;
    const-string v5, "ringtoneplay"

    invoke-virtual {v4, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 249
    iget-object v5, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->stopmp3:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v4}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 251
    invoke-direct {p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->init()V

    .line 252
    invoke-direct {p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->buildLister()V

    .line 259
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 420
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 422
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 424
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 425
    iput-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->timer:Ljava/util/Timer;

    .line 427
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->task:Ljava/util/TimerTask;

    if-eqz v0, :cond_1

    .line 428
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->task:Ljava/util/TimerTask;

    invoke-virtual {v0}, Ljava/util/TimerTask;->cancel()Z

    .line 429
    iput-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->task:Ljava/util/TimerTask;

    .line 431
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 432
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 433
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->stop()V

    .line 435
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    if-eqz v0, :cond_3

    .line 437
    iput-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    .line 439
    :cond_3
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 540
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 541
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 542
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 408
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 410
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 411
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->mp3notice:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 413
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->adapter:Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/Mp3DownloadedAdapter;->notifyDataSetChanged()V

    .line 414
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 415
    return-void
.end method
