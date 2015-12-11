.class public Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
.super Landroid/app/Activity;
.source "RingtoneDownloadedActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;
    }
.end annotation


# instance fields
.field private adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

.field private charingtone:Landroid/widget/ImageView;

.field currenttime:Landroid/widget/TextView;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private filemoreringtone:Landroid/widget/ImageView;

.field handler:Landroid/os/Handler;

.field isAlarm:Z

.field isMusic:Z

.field isNotification:Z

.field isRingtone:Z

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

.field private musicProgress:Landroid/widget/SeekBar;

.field private playbarringtone:Landroid/widget/RelativeLayout;

.field private player:Lcom/aio/downloader/utils/Player;

.field private playpauseringtone:Landroid/widget/ImageView;

.field private ringtone_lv:Landroid/widget/ListView;

.field private ringtonefan:Landroid/widget/ImageView;

.field private ringtonenotice:Landroid/widget/TextView;

.field private ringtoneplay:Landroid/content/BroadcastReceiver;

.field private ringtonesuccessful:Landroid/content/BroadcastReceiver;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "ShowToast"
        }
    .end annotation
.end field

.field showBroadcast:Landroid/content/BroadcastReceiver;

.field private stopringtone:Landroid/content/BroadcastReceiver;

.field private task:Ljava/util/TimerTask;

.field private timer:Ljava/util/Timer;

.field title:Landroid/widget/TextView;

.field totaltime:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 48
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 50
    new-instance v0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    .line 100
    new-instance v0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$2;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->handler:Landroid/os/Handler;

    .line 123
    new-instance v0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$3;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtonesuccessful:Landroid/content/BroadcastReceiver;

    .line 135
    new-instance v0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$4;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$4;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->showBroadcast:Landroid/content/BroadcastReceiver;

    .line 149
    new-instance v0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$5;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtoneplay:Landroid/content/BroadcastReceiver;

    .line 190
    new-instance v0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$6;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$6;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->stopringtone:Landroid/content/BroadcastReceiver;

    .line 202
    iput-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    .line 203
    iput-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 212
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->istag:Ljava/lang/Boolean;

    .line 221
    iput-boolean v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isRingtone:Z

    iput-boolean v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isNotification:Z

    iput-boolean v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isAlarm:Z

    .line 222
    iput-boolean v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isMusic:Z

    .line 48
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/util/List;
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/db/TypeDbUtils;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    return-object v0
.end method

.method static synthetic access$10(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->charingtone:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$11(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->istag:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$12(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 207
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playpauseringtone:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$13(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->istag:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/utils/Player;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtone_lv:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playbarringtone:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;Ljava/util/Timer;)V
    .locals 0

    .prologue
    .line 218
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->timer:Ljava/util/Timer;

    return-void
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;Ljava/util/TimerTask;)V
    .locals 0

    .prologue
    .line 219
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->task:Ljava/util/TimerTask;

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/util/Timer;
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->timer:Ljava/util/Timer;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/util/TimerTask;
    .locals 1

    .prologue
    .line 219
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->task:Ljava/util/TimerTask;

    return-object v0
.end method

.method private buildLister()V
    .locals 2

    .prologue
    .line 308
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtonefan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 309
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->filemoreringtone:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 310
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->musicProgress:Landroid/widget/SeekBar;

    new-instance v1, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$SeekBarChangeEvent;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 312
    new-instance v0, Lcom/aio/downloader/utils/Player;

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->musicProgress:Landroid/widget/SeekBar;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/utils/Player;-><init>(Landroid/content/Context;Landroid/widget/SeekBar;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    .line 313
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playpauseringtone:Landroid/widget/ImageView;

    .line 314
    new-instance v1, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$7;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$7;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 334
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->charingtone:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$8;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 352
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 277
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 278
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 281
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "ringtone"

    const-string v2, "timesort"

    invoke-virtual {v0, v1, v2}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    .line 282
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 284
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    .line 286
    :cond_1
    const v0, 0x7f070397

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtonefan:Landroid/widget/ImageView;

    .line 287
    const v0, 0x7f070398

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->filemoreringtone:Landroid/widget/ImageView;

    .line 288
    const v0, 0x7f07039a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtonenotice:Landroid/widget/TextView;

    .line 289
    const v0, 0x7f070399

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtone_lv:Landroid/widget/ListView;

    .line 290
    new-instance v0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    .line 291
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtone_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 295
    const v0, 0x7f07039c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playpauseringtone:Landroid/widget/ImageView;

    .line 296
    const v0, 0x7f07039d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->charingtone:Landroid/widget/ImageView;

    .line 298
    const v0, 0x7f07039b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->playbarringtone:Landroid/widget/RelativeLayout;

    .line 299
    const v0, 0x7f0700ec

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->totaltime:Landroid/widget/TextView;

    .line 300
    const v0, 0x7f0700ea

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->currenttime:Landroid/widget/TextView;

    .line 301
    const v0, 0x7f0700e7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->title:Landroid/widget/TextView;

    .line 302
    const v0, 0x7f0700eb

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->musicProgress:Landroid/widget/SeekBar;

    .line 304
    return-void
.end method

.method private popuWindow()V
    .locals 7

    .prologue
    .line 506
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 507
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f030041

    const/4 v6, 0x0

    invoke-virtual {v2, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 508
    .local v3, "view":Landroid/view/View;
    const v5, 0x7f070191

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l1:Landroid/widget/RelativeLayout;

    .line 509
    const v5, 0x7f070192

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l2:Landroid/widget/RelativeLayout;

    .line 510
    const v5, 0x7f070193

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l3:Landroid/widget/RelativeLayout;

    .line 511
    const v5, 0x7f0701ac

    invoke-virtual {v3, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout;

    iput-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l4:Landroid/widget/RelativeLayout;

    .line 513
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l1:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 514
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l2:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 515
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l3:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 516
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->l4:Landroid/widget/RelativeLayout;

    invoke-virtual {v5, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 518
    new-instance v5, Landroid/widget/PopupWindow;

    invoke-direct {v5, v3}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;)V

    iput-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    .line 519
    invoke-virtual {p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v5

    .line 520
    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getHeight()I

    move-result v1

    .line 521
    .local v1, "h":I
    invoke-virtual {p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v5

    .line 522
    invoke-interface {v5}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/Display;->getWidth()I

    move-result v4

    .line 523
    .local v4, "w":I
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    div-int/lit8 v6, v4, 0x2

    add-int/lit8 v6, v6, 0x32

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 524
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const/4 v6, -0x2

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 525
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 526
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    const v6, 0x7f0c0011

    invoke-virtual {v5, v6}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 527
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    const/4 v5, 0x0

    invoke-direct {v0, v5}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 528
    .local v0, "dw":Landroid/graphics/drawable/ColorDrawable;
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v5, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 530
    return-void
.end method


# virtual methods
.method public RingtoneSort(Ljava/lang/String;)V
    .locals 2
    .param p1, "sort"    # Ljava/lang/String;

    .prologue
    .line 377
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 378
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 381
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v1, "ringtone"

    invoke-virtual {v0, v1, p1}, Lcom/aio/downloader/db/TypeDbUtils;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    .line 382
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    if-nez v0, :cond_1

    .line 384
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    .line 386
    :cond_1
    const v0, 0x7f070399

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtone_lv:Landroid/widget/ListView;

    .line 387
    new-instance v0, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;-><init>(Landroid/content/Context;Ljava/util/List;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    .line 388
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtone_lv:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 390
    return-void
.end method

.method public Ringtonedeletall()V
    .locals 4

    .prologue
    .line 357
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    const-string v3, "ringtone"

    invoke-virtual {v2, v3}, Lcom/aio/downloader/db/TypeDbUtils;->deleteallfile(Ljava/lang/String;)V

    .line 360
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_0

    .line 370
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    iget-object v3, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2, v3}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 372
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    invoke-virtual {v2}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->notifyDataSetChanged()V

    .line 373
    return-void

    .line 361
    :cond_0
    new-instance v0, Ljava/io/File;

    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 362
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 364
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 360
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 534
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 597
    :goto_0
    return-void

    .line 536
    :sswitch_0
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->moveTaskToBack(Z)Z

    goto :goto_0

    .line 539
    :sswitch_1
    invoke-direct {p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->popuWindow()V

    .line 540
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2, p1}, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View;)V

    goto :goto_0

    .line 543
    :sswitch_2
    const-string v2, "timesort"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->RingtoneSort(Ljava/lang/String;)V

    .line 544
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 547
    :sswitch_3
    const-string v2, "zimusort"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->RingtoneSort(Ljava/lang/String;)V

    .line 548
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 551
    :sswitch_4
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-direct {v2, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 552
    const v3, 0x7f0b0034

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 553
    const v3, 0x7f0b0043

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 555
    const v3, 0x7f0b003c

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 556
    new-instance v4, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$9;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$9;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    .line 554
    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 565
    const v3, 0x7f0b003b

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 566
    new-instance v4, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$10;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$10;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)V

    .line 564
    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    .line 573
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 574
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto :goto_0

    .line 577
    :sswitch_5
    new-instance v0, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;

    .line 578
    const v2, 0x7f0c000e

    .line 577
    invoke-direct {v0, p0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;-><init>(Landroid/content/Context;I)V

    .line 579
    .local v0, "downloadpathCustomDialog":Lcom/aio/downloader/dialog/DownloadpathCustomDialog;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->setCanceledOnTouchOutside(Z)V

    .line 580
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->show()V

    .line 582
    const v2, 0x7f070194

    invoke-virtual {v0, v2}, Lcom/aio/downloader/dialog/DownloadpathCustomDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 581
    check-cast v1, Landroid/widget/Button;

    .line 584
    .local v1, "downloadpathCustomDialogok":Landroid/widget/Button;
    new-instance v2, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$11;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$11;-><init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;Lcom/aio/downloader/dialog/DownloadpathCustomDialog;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 592
    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v2}, Landroid/widget/PopupWindow;->dismiss()V

    goto/16 :goto_0

    .line 534
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f070191 -> :sswitch_2
        0x7f070192 -> :sswitch_3
        0x7f070193 -> :sswitch_4
        0x7f0701ac -> :sswitch_5
        0x7f070397 -> :sswitch_0
        0x7f070398 -> :sswitch_1
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 232
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 233
    const v5, 0x7f0300aa

    invoke-virtual {p0, v5}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->setContentView(I)V

    .line 236
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 237
    .local v0, "myIntentFilter":Landroid/content/IntentFilter;
    const-string v5, "ringtonedelete"

    invoke-virtual {v0, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 239
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->mBroadcastReceiver_delete:Landroid/content/BroadcastReceiver;

    .line 238
    invoke-virtual {p0, v5, v0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 242
    new-instance v1, Landroid/content/IntentFilter;

    invoke-direct {v1}, Landroid/content/IntentFilter;-><init>()V

    .line 243
    .local v1, "myIntentFilter2":Landroid/content/IntentFilter;
    const-string v5, "ringtonesuccessful"

    invoke-virtual {v1, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 244
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtonesuccessful:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 248
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    .line 249
    .local v2, "myIntentFilter3":Landroid/content/IntentFilter;
    const-string v5, "ringtoneplay"

    invoke-virtual {v2, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 250
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtoneplay:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v2}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 254
    new-instance v3, Landroid/content/IntentFilter;

    invoke-direct {v3}, Landroid/content/IntentFilter;-><init>()V

    .line 255
    .local v3, "showIntentFilter4":Landroid/content/IntentFilter;
    const-string v5, "show"

    invoke-virtual {v3, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 256
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->showBroadcast:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v3}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 259
    new-instance v4, Landroid/content/IntentFilter;

    invoke-direct {v4}, Landroid/content/IntentFilter;-><init>()V

    .line 260
    .local v4, "showIntentFilter5":Landroid/content/IntentFilter;
    const-string v5, "mp3play"

    invoke-virtual {v4, v5}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 261
    iget-object v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->stopringtone:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v5, v4}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 264
    invoke-direct {p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->init()V

    .line 265
    invoke-direct {p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->buildLister()V

    .line 273
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 434
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 436
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 438
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 439
    iput-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->timer:Ljava/util/Timer;

    .line 441
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->task:Ljava/util/TimerTask;

    if-eqz v0, :cond_1

    .line 442
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->task:Ljava/util/TimerTask;

    invoke-virtual {v0}, Ljava/util/TimerTask;->cancel()Z

    .line 443
    iput-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->task:Ljava/util/TimerTask;

    .line 445
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    iget-object v0, v0, Lcom/aio/downloader/utils/Player;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 446
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->pause()V

    .line 447
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    invoke-virtual {v0}, Lcom/aio/downloader/utils/Player;->stop()V

    .line 449
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    if-eqz v0, :cond_3

    .line 451
    iput-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->player:Lcom/aio/downloader/utils/Player;

    .line 453
    :cond_3
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 458
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 459
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 460
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 421
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 422
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 423
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtonenotice:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 427
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->notifyDataSetChanged()V

    .line 428
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 429
    return-void

    .line 425
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->ringtonenotice:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setRingtone(ILjava/lang/String;)V
    .locals 6
    .param p1, "ringType"    # I
    .param p2, "file_path"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    .line 463
    packed-switch p1, :pswitch_data_0

    .line 477
    :goto_0
    :pswitch_0
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 478
    .local v2, "values":Landroid/content/ContentValues;
    const-string v3, "_data"

    invoke-virtual {v2, v3, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 479
    const-string v3, "mime_type"

    const-string v4, "audio/*"

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 480
    const-string v3, "is_ringtone"

    iget-boolean v4, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isRingtone:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 481
    const-string v3, "is_notification"

    iget-boolean v4, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isNotification:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 482
    const-string v3, "is_alarm"

    iget-boolean v4, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isAlarm:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 483
    const-string v3, "is_music"

    iget-boolean v4, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isMusic:Z

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 484
    invoke-static {p2}, Landroid/provider/MediaStore$Audio$Media;->getContentUriForPath(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 486
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {p0}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 487
    invoke-virtual {v3, v1, v2}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    .line 488
    .local v0, "newUri":Landroid/net/Uri;
    invoke-static {p0, v5, v0}, Landroid/media/RingtoneManager;->setActualDefaultRingtoneUri(Landroid/content/Context;ILandroid/net/Uri;)V

    .line 492
    return-void

    .line 465
    .end local v0    # "newUri":Landroid/net/Uri;
    .end local v1    # "uri":Landroid/net/Uri;
    .end local v2    # "values":Landroid/content/ContentValues;
    :pswitch_1
    iput-boolean v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isAlarm:Z

    goto :goto_0

    .line 468
    :pswitch_2
    iput-boolean v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isNotification:Z

    goto :goto_0

    .line 471
    :pswitch_3
    iput-boolean v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isRingtone:Z

    .line 473
    :pswitch_4
    iput-boolean v5, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->isMusic:Z

    goto :goto_0

    .line 463
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method
