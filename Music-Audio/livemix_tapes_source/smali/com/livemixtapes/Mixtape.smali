.class public Lcom/livemixtapes/Mixtape;
.super Landroid/app/Fragment;
.source "Mixtape.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field public static final ACTION_DOWNLOAD:I = 0x2

.field public static final ACTION_NONE:I = 0x0

.field public static final ACTION_PLAY:I = 0x1

.field public static final ARG_INITIAL_ACTION:Ljava/lang/String; = "init_action"

.field private static Count:Landroid/os/CountDownTimer; = null

.field private static final DAY:I = 0x5265c00

.field private static final HOUR:I = 0x36ee80

.field private static final MINUTE:I = 0xea60

.field private static final SECOND:I = 0x3e8

.field private static dayValue:J

.field private static hourValue:J

.field private static minuteValue:J

.field private static secondValue:J

.field public static shouldClearPlayListMode:Z

.field private static tempDay:J

.field private static tempHour:J

.field private static tempMinute:J

.field private static tempSecond:J


# instance fields
.field adapter:Lcom/livemixtapes/LazyAdapterTracks;

.field addTracksButton:Landroid/widget/Button;

.field buttonShare:Landroid/widget/LinearLayout;

.field private comments:Landroid/widget/ImageButton;

.field private countText:Landroid/widget/TextView;

.field private cover:Landroid/widget/ImageView;

.field private date:Landroid/widget/TextView;

.field dbHelper:Lcom/livemixtapes/database/DBHelper;

.field private dislike:Landroid/widget/ImageButton;

.field djBadges:Lcom/livemixtapes/ui/widgets/DjBadgesView;

.field private djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

.field private downloadAll:Landroid/widget/ImageButton;

.field private downloadAllProgressBar:Landroid/widget/ProgressBar;

.field downloadManager:Landroid/app/DownloadManager;

.field public downloadProgressList:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field downloadStatus:Landroid/widget/TextView;

.field downloadZip:Landroid/widget/TextView;

.field private favorite:Landroid/widget/ImageButton;

.field private favorited:Ljava/lang/Boolean;

.field private filler:Landroid/view/View;

.field globalTimer:Ljava/util/Timer;

.field handler:Landroid/os/Handler;

.field private header:Landroid/view/View;

.field private id:I

.field private info:Landroid/view/View;

.field private lastValue:I

.field private layout:Landroid/view/ViewGroup;

.field layoutBack:Landroid/widget/LinearLayout;

.field private like:Landroid/widget/ImageButton;

.field public listPosMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field mContext:Landroid/content/Context;

.field private mScrollState:I

.field private mainFrameLayout:Landroid/widget/FrameLayout;

.field private maxCoverSize:I

.field private maxHeaderSize:I

.field private measured:Ljava/lang/Boolean;

.field private minCoverSize:I

.field private minHeaderSize:I

.field mixtape:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private mixtapeBtns:Landroid/view/View;

.field parentActivity:Lcom/livemixtapes/MainActivity;

.field private playAll:Landroid/widget/ImageButton;

.field private playlist:Landroid/widget/ImageButton;

.field public playlistMode:Ljava/lang/Boolean;

.field private release_seconds:J

.field rootView:Landroid/view/View;

.field private score:Landroid/widget/TextView;

.field private scorelabel:Landroid/widget/TextView;

.field public selectedPlayListTracks:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private skipNoise:I

.field textViewBack:Landroid/widget/TextView;

.field textViewTitle:Landroid/widget/TextView;

.field private title:Landroid/widget/TextView;

.field private trackBtns:Landroid/view/View;

.field private tracks:Landroid/widget/ListView;

.field private views:Landroid/widget/TextView;

.field private voted:Ljava/lang/Boolean;

.field private voting:Ljava/lang/Boolean;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const-wide/16 v0, 0x0

    .line 116
    sput-wide v0, Lcom/livemixtapes/Mixtape;->dayValue:J

    .line 117
    sput-wide v0, Lcom/livemixtapes/Mixtape;->hourValue:J

    .line 118
    sput-wide v0, Lcom/livemixtapes/Mixtape;->minuteValue:J

    .line 119
    sput-wide v0, Lcom/livemixtapes/Mixtape;->secondValue:J

    .line 120
    sput-wide v0, Lcom/livemixtapes/Mixtape;->tempDay:J

    .line 121
    sput-wide v0, Lcom/livemixtapes/Mixtape;->tempHour:J

    .line 122
    sput-wide v0, Lcom/livemixtapes/Mixtape;->tempMinute:J

    .line 123
    sput-wide v0, Lcom/livemixtapes/Mixtape;->tempSecond:J

    .line 196
    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 97
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 107
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->measured:Ljava/lang/Boolean;

    .line 109
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->countText:Landroid/widget/TextView;

    .line 152
    iput v1, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    .line 153
    iput v1, p0, Lcom/livemixtapes/Mixtape;->skipNoise:I

    .line 182
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    .line 183
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->listPosMap:Ljava/util/HashMap;

    .line 187
    iput v1, p0, Lcom/livemixtapes/Mixtape;->mScrollState:I

    .line 190
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->favorited:Ljava/lang/Boolean;

    .line 191
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->voted:Ljava/lang/Boolean;

    .line 192
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->voting:Ljava/lang/Boolean;

    .line 193
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->playlistMode:Ljava/lang/Boolean;

    .line 195
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    .line 986
    new-instance v0, Lcom/livemixtapes/Mixtape$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/Mixtape$1;-><init>(Lcom/livemixtapes/Mixtape;)V

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    .line 97
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1522
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->showGuestWarning()V

    return-void
.end method

.method static synthetic access$1(Lcom/livemixtapes/Mixtape;Ljava/lang/String;Landroid/view/View;Landroid/app/AlertDialog;)V
    .locals 0

    .prologue
    .line 1556
    invoke-direct {p0, p1, p2, p3}, Lcom/livemixtapes/Mixtape;->downloadMixtapeZip(Ljava/lang/String;Landroid/view/View;Landroid/app/AlertDialog;)V

    return-void
.end method

.method static synthetic access$10()J
    .locals 2

    .prologue
    .line 116
    sget-wide v0, Lcom/livemixtapes/Mixtape;->dayValue:J

    return-wide v0
.end method

.method static synthetic access$11(Lcom/livemixtapes/Mixtape;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 109
    iput-object p1, p0, Lcom/livemixtapes/Mixtape;->countText:Landroid/widget/TextView;

    return-void
.end method

.method static synthetic access$12(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->countText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$13(J)V
    .locals 0

    .prologue
    .line 116
    sput-wide p0, Lcom/livemixtapes/Mixtape;->dayValue:J

    return-void
.end method

.method static synthetic access$14()J
    .locals 2

    .prologue
    .line 117
    sget-wide v0, Lcom/livemixtapes/Mixtape;->hourValue:J

    return-wide v0
.end method

.method static synthetic access$15(J)V
    .locals 0

    .prologue
    .line 117
    sput-wide p0, Lcom/livemixtapes/Mixtape;->hourValue:J

    return-void
.end method

.method static synthetic access$16()J
    .locals 2

    .prologue
    .line 118
    sget-wide v0, Lcom/livemixtapes/Mixtape;->minuteValue:J

    return-wide v0
.end method

.method static synthetic access$17(J)V
    .locals 0

    .prologue
    .line 118
    sput-wide p0, Lcom/livemixtapes/Mixtape;->minuteValue:J

    return-void
.end method

.method static synthetic access$18()J
    .locals 2

    .prologue
    .line 119
    sget-wide v0, Lcom/livemixtapes/Mixtape;->secondValue:J

    return-wide v0
.end method

.method static synthetic access$19(J)V
    .locals 0

    .prologue
    .line 119
    sput-wide p0, Lcom/livemixtapes/Mixtape;->secondValue:J

    return-void
.end method

.method static synthetic access$2(J)V
    .locals 0

    .prologue
    .line 120
    sput-wide p0, Lcom/livemixtapes/Mixtape;->tempDay:J

    return-void
.end method

.method static synthetic access$20(Lcom/livemixtapes/Mixtape;)Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->measured:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$21(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->views:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$22(Lcom/livemixtapes/Mixtape;)J
    .locals 2

    .prologue
    .line 105
    iget-wide v0, p0, Lcom/livemixtapes/Mixtape;->release_seconds:J

    return-wide v0
.end method

.method static synthetic access$23(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->date:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$24(Lcom/livemixtapes/Mixtape;)Landroid/view/View;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->mixtapeBtns:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$25(Lcom/livemixtapes/Mixtape;)I
    .locals 1

    .prologue
    .line 100
    iget v0, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    return v0
.end method

.method static synthetic access$26(Lcom/livemixtapes/Mixtape;)I
    .locals 1

    .prologue
    .line 101
    iget v0, p0, Lcom/livemixtapes/Mixtape;->minCoverSize:I

    return v0
.end method

.method static synthetic access$27(Lcom/livemixtapes/Mixtape;)I
    .locals 1

    .prologue
    .line 102
    iget v0, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    return v0
.end method

.method static synthetic access$28(Lcom/livemixtapes/Mixtape;)I
    .locals 1

    .prologue
    .line 103
    iget v0, p0, Lcom/livemixtapes/Mixtape;->minHeaderSize:I

    return v0
.end method

.method static synthetic access$29(Lcom/livemixtapes/Mixtape;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$3()J
    .locals 2

    .prologue
    .line 120
    sget-wide v0, Lcom/livemixtapes/Mixtape;->tempDay:J

    return-wide v0
.end method

.method static synthetic access$30(Lcom/livemixtapes/Mixtape;)Landroid/view/View;
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->header:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$31(Lcom/livemixtapes/Mixtape;I)V
    .locals 0

    .prologue
    .line 187
    iput p1, p0, Lcom/livemixtapes/Mixtape;->mScrollState:I

    return-void
.end method

.method static synthetic access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$33(Lcom/livemixtapes/Mixtape;Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 2024
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/Mixtape;->shake(Landroid/view/View;Ljava/lang/Runnable;)V

    return-void
.end method

.method static synthetic access$34(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1476
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->disableVoteButtons()V

    return-void
.end method

.method static synthetic access$35(Lcom/livemixtapes/Mixtape;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/livemixtapes/Mixtape;->voted:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$36(Lcom/livemixtapes/Mixtape;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->score:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$37(Lcom/livemixtapes/Mixtape;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 192
    iput-object p1, p0, Lcom/livemixtapes/Mixtape;->voting:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$38(Lcom/livemixtapes/Mixtape;)I
    .locals 1

    .prologue
    .line 189
    iget v0, p0, Lcom/livemixtapes/Mixtape;->id:I

    return v0
.end method

.method static synthetic access$39(Lcom/livemixtapes/Mixtape;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1983
    invoke-direct {p0, p1}, Lcom/livemixtapes/Mixtape;->scanMedia(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$4(J)V
    .locals 0

    .prologue
    .line 121
    sput-wide p0, Lcom/livemixtapes/Mixtape;->tempHour:J

    return-void
.end method

.method static synthetic access$40(Lcom/livemixtapes/Mixtape;)Landroid/widget/ImageButton;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->favorite:Landroid/widget/ImageButton;

    return-object v0
.end method

.method static synthetic access$41(Lcom/livemixtapes/Mixtape;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 190
    iput-object p1, p0, Lcom/livemixtapes/Mixtape;->favorited:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$42(Lcom/livemixtapes/Mixtape;)I
    .locals 1

    .prologue
    .line 187
    iget v0, p0, Lcom/livemixtapes/Mixtape;->mScrollState:I

    return v0
.end method

.method static synthetic access$5()J
    .locals 2

    .prologue
    .line 121
    sget-wide v0, Lcom/livemixtapes/Mixtape;->tempHour:J

    return-wide v0
.end method

.method static synthetic access$6(J)V
    .locals 0

    .prologue
    .line 122
    sput-wide p0, Lcom/livemixtapes/Mixtape;->tempMinute:J

    return-void
.end method

.method static synthetic access$7()J
    .locals 2

    .prologue
    .line 122
    sget-wide v0, Lcom/livemixtapes/Mixtape;->tempMinute:J

    return-wide v0
.end method

.method static synthetic access$8(J)V
    .locals 0

    .prologue
    .line 123
    sput-wide p0, Lcom/livemixtapes/Mixtape;->tempSecond:J

    return-void
.end method

.method static synthetic access$9()J
    .locals 2

    .prologue
    .line 123
    sget-wide v0, Lcom/livemixtapes/Mixtape;->tempSecond:J

    return-wide v0
.end method

.method private disableVoteButtons()V
    .locals 3

    .prologue
    const v2, 0x3e99999a    # 0.3f

    const/4 v1, 0x0

    .line 1477
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setAlpha(F)V

    .line 1478
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 1479
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setClickable(Z)V

    .line 1481
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setAlpha(F)V

    .line 1482
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 1483
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setClickable(Z)V

    .line 1484
    return-void
.end method

.method private dislikeMixtape()V
    .locals 6

    .prologue
    .line 1402
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->voted:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->voting:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1436
    :cond_0
    :goto_0
    return-void

    .line 1404
    :cond_1
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->markMixtape()V

    .line 1406
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const-string v3, "Disliking ..."

    const-string v4, "Disliking ..."

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v0

    .line 1408
    .local v0, "dialog":Landroid/app/ProgressDialog;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1409
    .local v1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "id"

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1410
    const-string v2, "auth"

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1412
    new-instance v2, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v2}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    const-string v3, "https://api.livemixtapes.com/api/vote/down"

    .line 1413
    new-instance v4, Lcom/livemixtapes/Mixtape$18;

    invoke-direct {v4, p0, v0}, Lcom/livemixtapes/Mixtape$18;-><init>(Lcom/livemixtapes/Mixtape;Landroid/app/ProgressDialog;)V

    .line 1412
    invoke-virtual {v2, v3, v1, v4}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    goto :goto_0
.end method

.method private downloadMixtapeZip(Ljava/lang/String;Landroid/view/View;Landroid/app/AlertDialog;)V
    .locals 4
    .param p1, "mixtapeID"    # Ljava/lang/String;
    .param p2, "downloadZipView"    # Landroid/view/View;
    .param p3, "alert"    # Landroid/app/AlertDialog;

    .prologue
    .line 1559
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1562
    .local v0, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v1, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v1}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "https://api.livemixtapes.com/api/download/mixtape?id="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&auth="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1563
    new-instance v3, Lcom/livemixtapes/Mixtape$22;

    invoke-direct {v3, p0, p2}, Lcom/livemixtapes/Mixtape$22;-><init>(Lcom/livemixtapes/Mixtape;Landroid/view/View;)V

    .line 1562
    invoke-virtual {v1, v2, v0, v3}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 1855
    return-void
.end method

.method private enableVoteButtons()V
    .locals 3

    .prologue
    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x1

    .line 1487
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setAlpha(F)V

    .line 1488
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 1489
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setClickable(Z)V

    .line 1491
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setAlpha(F)V

    .line 1492
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 1493
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setClickable(Z)V

    .line 1494
    return-void
.end method

.method private enterPlaylistMode()V
    .locals 2

    .prologue
    .line 1510
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->playlistMode:Ljava/lang/Boolean;

    .line 1511
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->adapter:Lcom/livemixtapes/LazyAdapterTracks;

    invoke-virtual {v0}, Lcom/livemixtapes/LazyAdapterTracks;->notifyDataSetChanged()V

    .line 1512
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->addTracksButton:Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 1513
    return-void
.end method

.method private exitPlaylistMode()V
    .locals 2

    .prologue
    .line 1516
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->playlistMode:Ljava/lang/Boolean;

    .line 1517
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 1518
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->adapter:Lcom/livemixtapes/LazyAdapterTracks;

    invoke-virtual {v0}, Lcom/livemixtapes/LazyAdapterTracks;->notifyDataSetChanged()V

    .line 1519
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->addTracksButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 1520
    return-void
.end method

.method private favoriteMixtape()V
    .locals 6

    .prologue
    .line 1859
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const-string v3, "Saving ..."

    const-string v4, "Saving ..."

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v0

    .line 1861
    .local v0, "dialog":Landroid/app/ProgressDialog;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1862
    .local v1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "album_id"

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1864
    new-instance v2, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v2}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://api.livemixtapes.com/api/favorites/add?auth="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1865
    new-instance v4, Lcom/livemixtapes/Mixtape$23;

    invoke-direct {v4, p0, v0}, Lcom/livemixtapes/Mixtape$23;-><init>(Lcom/livemixtapes/Mixtape;Landroid/app/ProgressDialog;)V

    .line 1864
    invoke-virtual {v2, v3, v1, v4}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 1885
    return-void
.end method

.method private getMixtapeInfo()V
    .locals 4

    .prologue
    .line 1440
    new-instance v0, Lcom/livemixtapes/Mixtape$19;

    invoke-direct {v0, p0}, Lcom/livemixtapes/Mixtape$19;-><init>(Lcom/livemixtapes/Mixtape;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    .line 1472
    const-string v3, ""

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/Mixtape$19;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1474
    return-void
.end method

.method private likeMixtape()V
    .locals 6

    .prologue
    .line 1359
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->voted:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->voting:Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1399
    :cond_0
    :goto_0
    return-void

    .line 1361
    :cond_1
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->markMixtape()V

    .line 1363
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const-string v3, "Liking ..."

    const-string v4, "Liking ..."

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v0

    .line 1365
    .local v0, "dialog":Landroid/app/ProgressDialog;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1368
    .local v1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "id"

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1372
    const-string v2, "auth"

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1375
    new-instance v2, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v2}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    const-string v3, "https://api.livemixtapes.com/api/vote/up"

    .line 1376
    new-instance v4, Lcom/livemixtapes/Mixtape$17;

    invoke-direct {v4, p0, v0}, Lcom/livemixtapes/Mixtape$17;-><init>(Lcom/livemixtapes/Mixtape;Landroid/app/ProgressDialog;)V

    .line 1375
    invoke-virtual {v2, v3, v1, v4}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    goto :goto_0
.end method

.method private scanMedia(Ljava/lang/String;)V
    .locals 13
    .param p1, "scanPath"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 1986
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 1989
    .local v6, "toBeScanned":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v3, Ljava/io/File;

    new-instance v7, Ljava/lang/StringBuilder;

    .line 1990
    sget-object v9, Landroid/os/Environment;->DIRECTORY_MUSIC:Ljava/lang/String;

    invoke-static {v9}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v9

    invoke-virtual {v9}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v7, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "/"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 1989
    invoke-direct {v3, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1991
    .local v3, "folder_file":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v2

    .line 1992
    .local v2, "files":[Ljava/io/File;
    if-eqz v2, :cond_0

    .line 1993
    array-length v9, v2

    move v7, v8

    :goto_0
    if-lt v7, v9, :cond_1

    .line 2021
    :cond_0
    return-void

    .line 1993
    :cond_1
    aget-object v1, v2, v7

    .line 1995
    .local v1, "file":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->isFile()Z

    move-result v10

    if-eqz v10, :cond_2

    .line 1996
    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    .line 1998
    .local v5, "path":Ljava/lang/String;
    const-string v10, "."

    invoke-virtual {v5, v10}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v10

    add-int/lit8 v10, v10, 0x1

    invoke-virtual {v5, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 2000
    .local v0, "extension":Ljava/lang/String;
    const-string v10, "mp3"

    invoke-virtual {v0, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_2

    .line 2003
    :try_start_0
    new-instance v4, Landroid/content/Intent;

    const-string v10, "android.intent.action.MEDIA_SCANNER_SCAN_FILE"

    invoke-direct {v4, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 2004
    .local v4, "intent":Landroid/content/Intent;
    invoke-static {v1}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v10

    invoke-virtual {v4, v10}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 2005
    iget-object v10, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-virtual {v10, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2007
    .end local v4    # "intent":Landroid/content/Intent;
    :goto_1
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    .line 2011
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, " is a media file "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v10, v8

    invoke-static {v10}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1993
    .end local v0    # "extension":Ljava/lang/String;
    .end local v5    # "path":Ljava/lang/String;
    :cond_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 2007
    .restart local v0    # "extension":Ljava/lang/String;
    .restart local v5    # "path":Ljava/lang/String;
    :catch_0
    move-exception v10

    goto :goto_1
.end method

.method private shake(Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "callback"    # Ljava/lang/Runnable;

    .prologue
    .line 2025
    iget-object v1, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const v2, 0x7f04000c

    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 2027
    .local v0, "anim":Landroid/view/animation/Animation;
    new-instance v1, Lcom/livemixtapes/Mixtape$25;

    invoke-direct {v1, p0, p2}, Lcom/livemixtapes/Mixtape$25;-><init>(Lcom/livemixtapes/Mixtape;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 2045
    invoke-virtual {p1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 2046
    return-void
.end method

.method private showGuestWarning()V
    .locals 3

    .prologue
    .line 1523
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 1525
    const-string v1, "Account Required"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1526
    const-string v1, "Sign up to create playlists, vote, comment and more!\nIt\'s free!"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1527
    const-string v1, "Not Now"

    new-instance v2, Lcom/livemixtapes/Mixtape$20;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtape$20;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1532
    const-string v1, "Sign Up"

    new-instance v2, Lcom/livemixtapes/Mixtape$21;

    invoke-direct {v2, p0}, Lcom/livemixtapes/Mixtape$21;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1538
    const v1, 0x108009b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1539
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 1540
    return-void
.end method

.method private toggleFavorite()V
    .locals 1

    .prologue
    .line 1543
    invoke-static {}, Lcom/livemixtapes/User;->isGuest()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1544
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->showGuestWarning()V

    .line 1553
    :goto_0
    return-void

    .line 1548
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->favorited:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1549
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->unfavoriteMixtape()V

    goto :goto_0

    .line 1551
    :cond_1
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->favoriteMixtape()V

    goto :goto_0
.end method

.method private togglePlaylistMode()V
    .locals 1

    .prologue
    .line 1497
    invoke-static {}, Lcom/livemixtapes/User;->isGuest()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1498
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->showGuestWarning()V

    .line 1507
    :goto_0
    return-void

    .line 1502
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->playlistMode:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1503
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->exitPlaylistMode()V

    goto :goto_0

    .line 1505
    :cond_1
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->enterPlaylistMode()V

    goto :goto_0
.end method

.method private unfavoriteMixtape()V
    .locals 6

    .prologue
    .line 1888
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const-string v3, "Saving ..."

    const-string v4, "Saving ..."

    const/4 v5, 0x1

    invoke-static {v2, v3, v4, v5}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v0

    .line 1890
    .local v0, "dialog":Landroid/app/ProgressDialog;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1891
    .local v1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "album_id"

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1893
    new-instance v2, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v2}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "https://api.livemixtapes.com/api/favorites/remove?auth="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 1894
    new-instance v4, Lcom/livemixtapes/Mixtape$24;

    invoke-direct {v4, p0, v0}, Lcom/livemixtapes/Mixtape$24;-><init>(Lcom/livemixtapes/Mixtape;Landroid/app/ProgressDialog;)V

    .line 1893
    invoke-virtual {v2, v3, v1, v4}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 1914
    return-void
.end method


# virtual methods
.method public calcMeasurements()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 872
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->measured:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 920
    :goto_0
    return-void

    .line 875
    :cond_0
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;

    invoke-virtual {v5}, Landroid/widget/ImageView;->getWidth()I

    move-result v5

    iput v5, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    .line 876
    iget v5, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    int-to-double v5, v5

    const-wide/high16 v7, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v5, v7

    double-to-int v5, v5

    iput v5, p0, Lcom/livemixtapes/Mixtape;->minCoverSize:I

    .line 878
    iget v5, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    int-to-double v5, v5

    const-wide v7, 0x3fd147ae147ae148L    # 0.27

    mul-double/2addr v5, v7

    double-to-int v0, v5

    .line 880
    .local v0, "btnHeight":I
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->mixtapeBtns:Landroid/view/View;

    .line 881
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 880
    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 882
    .local v1, "btnParams":Landroid/view/ViewGroup$MarginLayoutParams;
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->info:Landroid/view/View;

    .line 883
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    .line 882
    check-cast v4, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 885
    .local v4, "infoParams":Landroid/view/ViewGroup$MarginLayoutParams;
    iput v0, v1, Landroid/view/ViewGroup$MarginLayoutParams;->height:I

    .line 887
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->mixtapeBtns:Landroid/view/View;

    invoke-virtual {v5, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 888
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->trackBtns:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    iput v0, v5, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 890
    iget v5, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    mul-int/lit8 v6, v0, 0x2

    add-int/2addr v5, v6

    iput v5, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    .line 891
    iget v5, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    iget v6, v1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    mul-int/lit8 v6, v6, 0x2

    add-int/2addr v5, v6

    iput v5, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    .line 892
    iget v5, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    iget v6, v4, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    add-int/2addr v5, v6

    iput v5, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    .line 894
    iget v5, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    iget v6, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    iget v7, p0, Lcom/livemixtapes/Mixtape;->minCoverSize:I

    sub-int/2addr v6, v7

    sub-int/2addr v5, v6

    .line 895
    sub-int/2addr v5, v0

    .line 894
    iput v5, p0, Lcom/livemixtapes/Mixtape;->minHeaderSize:I

    .line 897
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    .line 898
    iget v5, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    iget v6, p0, Lcom/livemixtapes/Mixtape;->maxCoverSize:I

    .line 897
    invoke-direct {v2, v5, v6}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 899
    .local v2, "coverParams":Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, 0x0

    iput v5, v2, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 900
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;

    invoke-virtual {v5, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 902
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;

    .line 903
    const/4 v5, -0x1

    iget v6, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    .line 902
    invoke-direct {v3, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 904
    .local v3, "headerParams":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->header:Landroid/view/View;

    invoke-virtual {v5, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 906
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v5

    const v6, 0x7f030020

    iget-object v7, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    invoke-virtual {v5, v6, v7, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v5

    iput-object v5, p0, Lcom/livemixtapes/Mixtape;->filler:Landroid/view/View;

    .line 908
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->filler:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    iget v6, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    add-int/lit8 v6, v6, -0x1

    iput v6, v5, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 909
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    iget-object v6, p0, Lcom/livemixtapes/Mixtape;->filler:Landroid/view/View;

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7, v9}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 911
    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->filler:Landroid/view/View;

    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    iget v6, p0, Lcom/livemixtapes/Mixtape;->maxHeaderSize:I

    add-int/lit8 v6, v6, -0x1

    iput v6, v5, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 919
    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    iput-object v5, p0, Lcom/livemixtapes/Mixtape;->measured:Ljava/lang/Boolean;

    goto/16 :goto_0
.end method

.method changeImageButtonImage(IZ)V
    .locals 2
    .param p1, "pos"    # I
    .param p2, "isDownload"    # Z

    .prologue
    .line 1267
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/livemixtapes/Mixtape$16;

    invoke-direct {v1, p0, p1, p2}, Lcom/livemixtapes/Mixtape$16;-><init>(Lcom/livemixtapes/Mixtape;IZ)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1284
    return-void
.end method

.method checkIfMixtapeNotVoted()Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 1336
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-string v4, "LiveMixTapes"

    invoke-virtual {v3, v4, v2}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 1337
    .local v0, "prefs":Landroid/content/SharedPreferences;
    const-string v3, "votedMixtapes"

    const-string v4, ""

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1338
    .local v1, "savedStr":Ljava/lang/String;
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 1339
    const/4 v2, 0x1

    .line 1340
    :cond_0
    return v2
.end method

.method checkIfTimerOn()V
    .locals 6

    .prologue
    .line 2100
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 2051
    const-string v2, "CHECKING TIMER"

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 2053
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->globalTimer:Ljava/util/Timer;

    if-nez v0, :cond_0

    .line 2054
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/Mixtape;->globalTimer:Ljava/util/Timer;

    .line 2056
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->globalTimer:Ljava/util/Timer;

    new-instance v1, Lcom/livemixtapes/Mixtape$26;

    invoke-direct {v1, p0}, Lcom/livemixtapes/Mixtape$26;-><init>(Lcom/livemixtapes/Mixtape;)V

    .line 2098
    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x1f4

    .line 2056
    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    :cond_0
    return-void
.end method

.method download(I)V
    .locals 14
    .param p1, "pos"    # I
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    const/4 v13, 0x0

    .line 1107
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v0

    add-int v10, p1, v0

    .line 1112
    .local v10, "position":I
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    .line 1113
    const-string v2, "tracks"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Ljava/util/HashMap;

    .line 1115
    .local v12, "selectedTrack":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v0, "track_id"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1116
    .local v1, "trackId":Ljava/lang/String;
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-static {v0, v1}, Lcom/livemixtapes/Utils;->isFileExists(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1201
    :cond_0
    :goto_0
    return-void

    .line 1119
    :cond_1
    const-string v0, "download_url"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_2

    const-string v0, "download_url"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_3

    .line 1124
    :cond_2
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v0, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 1125
    const-string v2, "Download Disabled"

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1126
    const-string v2, "This track cannot be downloaded."

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1127
    const-string v2, "OK"

    new-instance v3, Lcom/livemixtapes/Mixtape$12;

    invoke-direct {v3, p0}, Lcom/livemixtapes/Mixtape$12;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v0, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1142
    const v2, 0x1080027

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 1143
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0

    .line 1146
    :cond_3
    new-array v2, v7, [Ljava/lang/Object;

    .line 1148
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v3, "INSERTING DOWNLOAD: "

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ","

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v0, "track_title"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v13

    invoke-static {v2}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1149
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    const-string v2, "track_title"

    invoke-virtual {v12, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v5, "title"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v6, "cover"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v6, "track_duration"

    invoke-virtual {v12, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual/range {v0 .. v7}, Lcom/livemixtapes/database/DBHelper;->insertDownload(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z

    .line 1163
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1164
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->downloadManager:Landroid/app/DownloadManager;

    new-array v3, v7, [J

    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    aput-wide v4, v3, v13

    invoke-virtual {v2, v3}, Landroid/app/DownloadManager;->remove([J)I

    .line 1165
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1166
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->listPosMap:Ljava/util/HashMap;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1167
    invoke-virtual {p0, v10, v13}, Lcom/livemixtapes/Mixtape;->setProgressOnUiThreadWithPos(II)V

    .line 1168
    invoke-virtual {p0, v10, v7}, Lcom/livemixtapes/Mixtape;->changeImageButtonImage(IZ)V

    .line 1169
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/database/DBHelper;->deleteDownload(Ljava/lang/String;)I

    goto/16 :goto_0

    .line 1174
    :cond_4
    const-string v0, "download_url"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v0, "download_url"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    .line 1177
    invoke-virtual {p0, v10, v13}, Lcom/livemixtapes/Mixtape;->changeImageButtonImage(IZ)V

    .line 1178
    new-instance v11, Landroid/app/DownloadManager$Request;

    .line 1179
    const-string v0, "download_url"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1178
    invoke-direct {v11, v0}, Landroid/app/DownloadManager$Request;-><init>(Landroid/net/Uri;)V

    .line 1180
    .local v11, "request":Landroid/app/DownloadManager$Request;
    const-string v0, "track_title"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v11, v0}, Landroid/app/DownloadManager$Request;->setDescription(Ljava/lang/CharSequence;)Landroid/app/DownloadManager$Request;

    .line 1181
    const-string v0, "track_title"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v11, v0}, Landroid/app/DownloadManager$Request;->setTitle(Ljava/lang/CharSequence;)Landroid/app/DownloadManager$Request;

    .line 1182
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v0, v2, :cond_5

    .line 1183
    invoke-virtual {v11}, Landroid/app/DownloadManager$Request;->allowScanningByMediaScanner()V

    .line 1184
    invoke-virtual {v11, v13}, Landroid/app/DownloadManager$Request;->setNotificationVisibility(I)Landroid/app/DownloadManager$Request;

    .line 1186
    :cond_5
    const/4 v0, 0x3

    invoke-virtual {v11, v0}, Landroid/app/DownloadManager$Request;->setAllowedNetworkTypes(I)Landroid/app/DownloadManager$Request;

    .line 1189
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-string v0, "track_id"

    invoke-virtual {v12, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v2, v0}, Lcom/livemixtapes/Utils;->getLivemixtapesFolder(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v11, v0}, Landroid/app/DownloadManager$Request;->setDestinationUri(Landroid/net/Uri;)Landroid/app/DownloadManager$Request;

    .line 1193
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->downloadManager:Landroid/app/DownloadManager;

    invoke-virtual {v0, v11}, Landroid/app/DownloadManager;->enqueue(Landroid/app/DownloadManager$Request;)J

    move-result-wide v8

    .line 1194
    .local v8, "downloadId":J
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1195
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->listPosMap:Ljava/util/HashMap;

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1199
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->checkIfTimerOn()V

    goto/16 :goto_0
.end method

.method downloadAll()V
    .locals 4

    .prologue
    .line 1066
    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    .line 1067
    const-string v3, "tracks"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 1068
    .local v1, "tracksList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    if-nez v1, :cond_1

    .line 1102
    :cond_0
    return-void

    .line 1070
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 1073
    invoke-virtual {p0, v0}, Lcom/livemixtapes/Mixtape;->download(I)V

    .line 1070
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public getAbsoluteHeight(Landroid/view/View;)I
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 859
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 861
    .local v1, "params":Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v0

    .line 862
    .local v0, "height":I
    const-string v2, "height"

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 863
    invoke-virtual {p1}, Landroid/view/View;->getPaddingTop()I

    move-result v2

    invoke-virtual {p1}, Landroid/view/View;->getPaddingBottom()I

    move-result v3

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 864
    const-string v2, "height"

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 865
    iget v2, v1, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    iget v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;->bottomMargin:I

    add-int/2addr v2, v3

    add-int/2addr v0, v2

    .line 866
    const-string v2, "height"

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 868
    return v0
.end method

.method getAllFilesDownloadPercentage()I
    .locals 8

    .prologue
    .line 1287
    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    .line 1288
    const-string v5, "tracks"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    .line 1289
    .local v3, "tracksList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 1290
    .local v1, "totalCount":I
    const/4 v0, 0x0

    .line 1291
    .local v0, "completedCount":I
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 1297
    if-lez v1, :cond_2

    .line 1298
    int-to-long v4, v0

    const-wide/16 v6, 0x64

    mul-long/2addr v4, v6

    int-to-long v6, v1

    div-long/2addr v4, v6

    long-to-int v4, v4

    .line 1299
    :goto_1
    return v4

    .line 1291
    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/HashMap;

    .line 1292
    .local v2, "track":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const-string v4, "track_id"

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 1293
    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 1292
    invoke-static {v6, v4}, Lcom/livemixtapes/Utils;->isFileExists(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    .line 1293
    if-eqz v4, :cond_0

    .line 1294
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1299
    .end local v2    # "track":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public getFakeTap(FFI)Landroid/view/MotionEvent;
    .locals 11
    .param p1, "x"    # F
    .param p2, "y"    # F
    .param p3, "action"    # I

    .prologue
    .line 994
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    .line 995
    .local v0, "downTime":J
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v4

    const-wide/16 v9, 0x64

    add-long v2, v4, v9

    .line 999
    .local v2, "eventTime":J
    const/4 v7, 0x0

    .local v7, "metaState":I
    move v4, p3

    move v5, p1

    move v6, p2

    .line 1000
    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v8

    .line 1003
    .local v8, "motionEvent":Landroid/view/MotionEvent;
    return-object v8
.end method

.method getIndividualFileProgress(Ljava/lang/String;)I
    .locals 12
    .param p1, "trackId"    # Ljava/lang/String;

    .prologue
    const/16 v7, 0x64

    const/4 v3, 0x0

    .line 1304
    :try_start_0
    new-instance v5, Landroid/app/DownloadManager$Query;

    invoke-direct {v5}, Landroid/app/DownloadManager$Query;-><init>()V

    .line 1305
    .local v5, "q":Landroid/app/DownloadManager$Query;
    const/4 v6, 0x1

    new-array v8, v6, [J

    const/4 v9, 0x0

    iget-object v6, p0, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v6, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Long;

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    aput-wide v10, v8, v9

    invoke-virtual {v5, v8}, Landroid/app/DownloadManager$Query;->setFilterById([J)Landroid/app/DownloadManager$Query;

    .line 1307
    iget-object v6, p0, Lcom/livemixtapes/Mixtape;->downloadManager:Landroid/app/DownloadManager;

    invoke-virtual {v6, v5}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;

    move-result-object v2

    .line 1308
    .local v2, "cursor":Landroid/database/Cursor;
    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-nez v6, :cond_1

    .line 1330
    .end local v2    # "cursor":Landroid/database/Cursor;
    .end local v5    # "q":Landroid/app/DownloadManager$Query;
    :cond_0
    :goto_0
    return v3

    .line 1313
    .restart local v2    # "cursor":Landroid/database/Cursor;
    .restart local v5    # "q":Landroid/app/DownloadManager$Query;
    :cond_1
    const-string v6, "bytes_so_far"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 1312
    invoke-interface {v2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 1315
    .local v0, "bytes_downloaded":I
    const-string v6, "total_size"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 1314
    invoke-interface {v2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 1317
    .local v1, "bytes_total":I
    const-string v6, "status"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    const/16 v8, 0x8

    if-ne v6, v8, :cond_2

    .line 1318
    iget-object v6, p0, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v6, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1319
    iget-object v6, p0, Lcom/livemixtapes/Mixtape;->listPosMap:Ljava/util/HashMap;

    invoke-virtual {v6, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1320
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    move v3, v7

    .line 1321
    goto :goto_0

    .line 1324
    :cond_2
    int-to-long v8, v0

    const-wide/16 v10, 0x64

    mul-long/2addr v8, v10

    int-to-long v10, v1

    div-long/2addr v8, v10

    long-to-int v3, v8

    .line 1325
    .local v3, "dl_progress":I
    invoke-interface {v2}, Landroid/database/Cursor;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1328
    .end local v0    # "bytes_downloaded":I
    .end local v1    # "bytes_total":I
    .end local v2    # "cursor":Landroid/database/Cursor;
    .end local v3    # "dl_progress":I
    .end local v5    # "q":Landroid/app/DownloadManager$Query;
    :catch_0
    move-exception v4

    .local v4, "e":Ljava/lang/Exception;
    move v3, v7

    .line 1330
    goto :goto_0
.end method

.method public getLocalUriFromBitmap(Landroid/graphics/Bitmap;)Landroid/net/Uri;
    .locals 8
    .param p1, "bmp"    # Landroid/graphics/Bitmap;

    .prologue
    .line 1008
    const/4 v0, 0x0

    .line 1010
    .local v0, "bmpUri":Landroid/net/Uri;
    :try_start_0
    new-instance v2, Ljava/io/File;

    .line 1012
    sget-object v4, Landroid/os/Environment;->DIRECTORY_DOWNLOADS:Ljava/lang/String;

    invoke-static {v4}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    .line 1013
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "share_image_"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ".png"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 1010
    invoke-direct {v2, v4, v5}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 1014
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v4

    invoke-virtual {v4}, Ljava/io/File;->mkdirs()Z

    .line 1015
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-direct {v3, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 1016
    .local v3, "out":Ljava/io/FileOutputStream;
    sget-object v4, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v5, 0x5a

    invoke-virtual {p1, v4, v5, v3}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 1017
    invoke-virtual {v3}, Ljava/io/FileOutputStream;->close()V

    .line 1018
    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1022
    .end local v2    # "file":Ljava/io/File;
    .end local v3    # "out":Ljava/io/FileOutputStream;
    :goto_0
    return-object v0

    .line 1019
    :catch_0
    move-exception v1

    .line 1020
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public getMixtape()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "*>;"
        }
    .end annotation

    .prologue
    .line 789
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    return-object v0
.end method

.method public getScrollY()I
    .locals 10

    .prologue
    const/4 v6, 0x0

    .line 794
    iget-object v7, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    invoke-virtual {v7, v6}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 796
    .local v0, "c":Landroid/view/View;
    if-nez v0, :cond_0

    .line 849
    :goto_0
    return v6

    .line 800
    :cond_0
    iget-object v7, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    invoke-virtual {v7}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v7

    iget-object v8, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    invoke-virtual {v8}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v8

    sub-int v2, v7, v8

    .line 801
    .local v2, "firstVisiblePosition":I
    invoke-virtual {v0}, Landroid/view/View;->getTop()I

    move-result v7

    mul-int/lit8 v5, v7, 0x2

    .line 805
    .local v5, "top":I
    const/4 v3, 0x0

    .line 811
    .local v3, "headerHeight":I
    invoke-virtual {v0}, Landroid/view/View;->getHeight()I

    move-result v4

    .line 817
    .local v4, "height":I
    const-string v7, "Nithin"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "--"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "--"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "--"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    .line 818
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "LAST VALUE: "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v9, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v6

    invoke-static {v7}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 820
    iget v7, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    if-nez v7, :cond_1

    .line 822
    neg-int v6, v5

    mul-int v7, v2, v4

    add-int/2addr v6, v7

    sub-int/2addr v6, v3

    iput v6, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    .line 849
    :goto_1
    neg-int v6, v5

    mul-int v7, v2, v4

    add-int/2addr v6, v7

    sub-int/2addr v6, v3

    goto :goto_0

    .line 826
    :cond_1
    neg-int v7, v5

    mul-int v8, v2, v4

    add-int/2addr v7, v8

    sub-int v1, v7, v3

    .line 827
    .local v1, "curValue":I
    iget v7, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    sub-int/2addr v7, v1

    const/16 v8, 0x12c

    if-gt v7, v8, :cond_2

    iget v7, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    sub-int/2addr v7, v1

    const/16 v8, -0x12c

    if-ge v7, v8, :cond_4

    .line 829
    :cond_2
    iget v7, p0, Lcom/livemixtapes/Mixtape;->skipNoise:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/livemixtapes/Mixtape;->skipNoise:I

    .line 830
    iget v7, p0, Lcom/livemixtapes/Mixtape;->skipNoise:I

    const/16 v8, 0x32

    if-le v7, v8, :cond_3

    .line 832
    iput v6, p0, Lcom/livemixtapes/Mixtape;->skipNoise:I

    .line 834
    iput v1, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    goto :goto_1

    .line 840
    :cond_3
    iget v6, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    goto/16 :goto_0

    .line 845
    :cond_4
    iput v1, p0, Lcom/livemixtapes/Mixtape;->lastValue:I

    goto :goto_1
.end method

.method hideProgressAndDownloadButtons(I)V
    .locals 2
    .param p1, "pos"    # I

    .prologue
    .line 1222
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/livemixtapes/Mixtape$14;

    invoke-direct {v1, p0, p1}, Lcom/livemixtapes/Mixtape$14;-><init>(Lcom/livemixtapes/Mixtape;I)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1237
    return-void
.end method

.method loadDjList(Ljava/lang/String;)V
    .locals 5
    .param p1, "selectedDj"    # Ljava/lang/String;

    .prologue
    .line 2161
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v3, Lcom/livemixtapes/ui/BaseActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/ui/BaseActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 2162
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/MixtapeList;

    invoke-direct {v2}, Lcom/livemixtapes/MixtapeList;-><init>()V

    .line 2163
    .local v2, "mixtapeListFragment":Lcom/livemixtapes/MixtapeList;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2164
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "title"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2165
    const-string v3, "dj"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2166
    invoke-virtual {v2, v0}, Lcom/livemixtapes/MixtapeList;->setArguments(Landroid/os/Bundle;)V

    .line 2167
    const v3, 0x7f0800cc

    const-string v4, "MIXTAPELIST"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 2168
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 2169
    return-void
.end method

.method markMixtape()V
    .locals 7

    .prologue
    .line 1345
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-string v4, "LiveMixTapes"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 1346
    .local v1, "prefs":Landroid/content/SharedPreferences;
    const-string v3, "votedMixtapes"

    const-string v4, ""

    invoke-interface {v1, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1347
    .local v2, "savedStr":Ljava/lang/String;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 1348
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    if-nez v3, :cond_0

    .line 1349
    const-string v3, "votedMixtapes"

    new-instance v4, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v6, "id"

    invoke-interface {v5, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 1355
    :goto_0
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1356
    return-void

    .line 1352
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v5, "id"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1353
    const-string v3, "votedMixtapes"

    invoke-interface {v0, v3, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x1

    .line 2104
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    .line 2145
    :cond_0
    :goto_0
    return-void

    .line 2107
    :sswitch_0
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->togglePlaylistMode()V

    goto :goto_0

    .line 2111
    :sswitch_1
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->toggleFavorite()V

    goto :goto_0

    .line 2115
    :sswitch_2
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->likeMixtape()V

    goto :goto_0

    .line 2119
    :sswitch_3
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->dislikeMixtape()V

    goto :goto_0

    .line 2123
    :sswitch_4
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->downloadAll()V

    goto :goto_0

    .line 2126
    :sswitch_5
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->playAll()V

    goto :goto_0

    .line 2130
    :sswitch_6
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 2132
    const/4 v3, 0x0

    sput-boolean v3, Lcom/livemixtapes/Mixtape;->shouldClearPlayListMode:Z

    .line 2133
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 2134
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {v2}, Lcom/livemixtapes/profile/SeeAllList;-><init>()V

    .line 2135
    .local v2, "seeAllFragment":Lcom/livemixtapes/profile/SeeAllList;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 2136
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "flag"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2137
    const-string v3, "isAddTrackToPlaylist"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 2138
    const-string v3, "tracks"

    const-string v4, ","

    iget-object v5, p0, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-static {v4, v5}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 2139
    invoke-virtual {v2, v0}, Lcom/livemixtapes/profile/SeeAllList;->setArguments(Landroid/os/Bundle;)V

    .line 2140
    const v3, 0x7f0800cc

    const-string v4, "SEEALL"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 2141
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 2104
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f08009c -> :sswitch_6
        0x7f0800ac -> :sswitch_2
        0x7f0800b0 -> :sswitch_3
        0x7f0800b1 -> :sswitch_5
        0x7f0800b3 -> :sswitch_4
        0x7f0800b6 -> :sswitch_0
        0x7f0800b7 -> :sswitch_1
    .end sparse-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 18
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 786
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 204
    const-string v5, "LOGGING MIXTAPE VIEW"

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 205
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v9

    check-cast v9, Lcom/livemixtapes/App;

    .line 207
    .local v9, "application":Lcom/livemixtapes/App;
    invoke-virtual {v9}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v3

    const-string v4, "Image~Mixtape"

    invoke-virtual {v3, v4}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 210
    invoke-virtual {v9}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v3

    new-instance v4, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v4}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v4}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 212
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    if-nez v3, :cond_4

    .line 214
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    .line 217
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-static {v3}, Lcom/livemixtapes/utils/Utility;->hideKeyboard(Landroid/app/Activity;)V

    .line 219
    const/4 v3, 0x0

    sput-boolean v3, Lcom/livemixtapes/Mixtape;->shouldClearPlayListMode:Z

    .line 221
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->handler:Landroid/os/Handler;

    .line 222
    const v3, 0x7f030025

    const/4 v4, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v3, v1, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    .line 224
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/Mixtape;->getArguments()Landroid/os/Bundle;

    move-result-object v11

    .line 225
    .local v11, "bundle":Landroid/os/Bundle;
    const-string v10, "Recent"

    .line 226
    .local v10, "backScreenTitle":Ljava/lang/String;
    if-eqz v11, :cond_1

    .line 227
    const-string v3, "mixtapeData"

    invoke-virtual {v11, v3}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v3

    check-cast v3, Ljava/util/Map;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    .line 228
    const-string v3, "backScreenTitle"

    invoke-virtual {v11, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 229
    if-eqz v10, :cond_0

    const-string v3, ""

    invoke-virtual {v10, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 230
    :cond_0
    const-string v10, "Recent"

    .line 234
    :cond_1
    const/4 v3, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/livemixtapes/Mixtape;->setHasOptionsMenu(Z)V

    .line 236
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f080098

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/FrameLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->mainFrameLayout:Landroid/widget/FrameLayout;

    .line 237
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->mainFrameLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v3}, Landroid/widget/FrameLayout;->getForeground()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 239
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08009b

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->layout:Landroid/view/ViewGroup;

    .line 240
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08009e

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->header:Landroid/view/View;

    .line 241
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800a0

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->info:Landroid/view/View;

    .line 242
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800a1

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;

    .line 243
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08009d

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ListView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    .line 244
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800aa

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->mixtapeBtns:Landroid/view/View;

    .line 245
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b4

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->trackBtns:Landroid/view/View;

    .line 247
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08004e

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->title:Landroid/widget/TextView;

    .line 248
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800a9

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->views:Landroid/widget/TextView;

    .line 249
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f080075

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->date:Landroid/widget/TextView;

    .line 250
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800af

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->score:Landroid/widget/TextView;

    .line 251
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800ae

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->scorelabel:Landroid/widget/TextView;

    .line 252
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b8

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->comments:Landroid/widget/ImageButton;

    .line 254
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b1

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->playAll:Landroid/widget/ImageButton;

    .line 255
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b3

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->downloadAll:Landroid/widget/ImageButton;

    .line 256
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b7

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->favorite:Landroid/widget/ImageButton;

    .line 257
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b6

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->playlist:Landroid/widget/ImageButton;

    .line 259
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800ac

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    .line 260
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b0

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    .line 262
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800b2

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ProgressBar;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->downloadAllProgressBar:Landroid/widget/ProgressBar;

    .line 263
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800a3

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/livemixtapes/ui/widgets/DjBadgesView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->djBadges:Lcom/livemixtapes/ui/widgets/DjBadgesView;

    .line 265
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08006d

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->layoutBack:Landroid/widget/LinearLayout;

    .line 266
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08006f

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->textViewBack:Landroid/widget/TextView;

    .line 267
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f080099

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->buttonShare:Landroid/widget/LinearLayout;

    .line 268
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08006c

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->textViewTitle:Landroid/widget/TextView;

    .line 270
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->layoutBack:Landroid/widget/LinearLayout;

    new-instance v4, Lcom/livemixtapes/Mixtape$2;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/livemixtapes/Mixtape$2;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 279
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->textViewBack:Landroid/widget/TextView;

    invoke-virtual {v3, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 281
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "artist"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v17

    .line 282
    .local v17, "title":Ljava/lang/String;
    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0xc

    if-le v3, v4, :cond_2

    .line 283
    new-instance v3, Ljava/lang/StringBuilder;

    const/4 v4, 0x0

    const/16 v5, 0xc

    move-object/from16 v0, v17

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "..."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    .line 285
    :cond_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->textViewTitle:Landroid/widget/TextView;

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 287
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->buttonShare:Landroid/widget/LinearLayout;

    new-instance v4, Lcom/livemixtapes/Mixtape$3;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/livemixtapes/Mixtape$3;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 310
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const-string v4, "download"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/DownloadManager;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->downloadManager:Landroid/app/DownloadManager;

    .line 312
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->downloadAll:Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 313
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->playAll:Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 314
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->playlist:Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 315
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->favorite:Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 316
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 317
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 319
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f08009c

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->addTracksButton:Landroid/widget/Button;

    .line 320
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->addTracksButton:Landroid/widget/Button;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 321
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->addTracksButton:Landroid/widget/Button;

    move-object/from16 v0, p0

    invoke-virtual {v3, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 326
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "tracks"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/util/ArrayList;

    .line 327
    .local v16, "temp_tracklist":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-virtual/range {v16 .. v16}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_6

    .line 332
    sget-object v3, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-string v4, "layout_inflater"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/view/LayoutInflater;

    const v4, 0x7f03001e

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v15

    .line 333
    .local v15, "footerView":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    invoke-virtual {v3, v15}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 340
    const v3, 0x7f080076

    invoke-virtual {v15, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/TextView;

    .line 341
    .local v13, "downloadZip":Landroid/widget/TextView;
    new-instance v3, Lcom/livemixtapes/Mixtape$4;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/livemixtapes/Mixtape$4;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v13, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 452
    sget-object v3, Lcom/livemixtapes/App;->didLoad:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-nez v3, :cond_3

    .line 454
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    sput-object v3, Lcom/livemixtapes/App;->didLoad:Ljava/lang/Boolean;

    .line 455
    const/4 v3, 0x1

    sput-boolean v3, Lcom/livemixtapes/MainActivity;->firstLoad:Z

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 456
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "MIXTAPE DATA: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 457
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    sput-object v3, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 458
    const/4 v3, 0x0

    sput-object v3, Lcom/livemixtapes/NowPlayingActivity;->playList:Ljava/util/Map;

    .line 459
    const/4 v3, 0x0

    sput v3, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 460
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "tracks"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    sput-object v3, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    .line 461
    const/4 v3, 0x1

    sput v3, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 463
    new-instance v3, Landroid/content/Intent;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    const-class v5, Lcom/livemixtapes/NowPlayingActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lcom/livemixtapes/Mixtape;->startActivity(Landroid/content/Intent;)V

    .line 586
    .end local v13    # "downloadZip":Landroid/widget/TextView;
    .end local v15    # "footerView":Landroid/view/View;
    :cond_3
    :goto_0
    const/16 v16, 0x0

    .line 589
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->comments:Landroid/widget/ImageButton;

    new-instance v4, Lcom/livemixtapes/Mixtape$6;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/livemixtapes/Mixtape$6;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 598
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f030020

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    .line 599
    const/4 v6, 0x0

    .line 598
    invoke-virtual {v3, v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/livemixtapes/Mixtape;->filler:Landroid/view/View;

    .line 600
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/livemixtapes/Mixtape;->filler:Landroid/view/View;

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v5, v6}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 602
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/Mixtape;->setData()V

    .line 603
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->layout:Landroid/view/ViewGroup;

    invoke-static {v3}, Lcom/livemixtapes/App;->scaleViewGroup(Landroid/view/ViewGroup;)V

    .line 605
    new-instance v3, Lcom/livemixtapes/Mixtape$7;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/livemixtapes/Mixtape;->layout:Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v4}, Lcom/livemixtapes/Mixtape$7;-><init>(Lcom/livemixtapes/Mixtape;Landroid/view/ViewGroup;)V

    .line 612
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    new-instance v4, Lcom/livemixtapes/Mixtape$8;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/livemixtapes/Mixtape$8;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 680
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    new-instance v4, Lcom/livemixtapes/Mixtape$9;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/livemixtapes/Mixtape$9;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 759
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->header:Landroid/view/View;

    new-instance v4, Lcom/livemixtapes/Mixtape$10;

    move-object/from16 v0, p0

    invoke-direct {v4, v0}, Lcom/livemixtapes/Mixtape$10;-><init>(Lcom/livemixtapes/Mixtape;)V

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 770
    .end local v10    # "backScreenTitle":Ljava/lang/String;
    .end local v11    # "bundle":Landroid/os/Bundle;
    .end local v16    # "temp_tracklist":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    .end local v17    # "title":Ljava/lang/String;
    :cond_4
    if-nez p3, :cond_5

    .line 771
    invoke-virtual/range {p0 .. p0}, Lcom/livemixtapes/Mixtape;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    const-string v4, "init_action"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v8

    .line 773
    .local v8, "action":I
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    new-instance v4, Lcom/livemixtapes/Mixtape$11;

    move-object/from16 v0, p0

    invoke-direct {v4, v0, v8}, Lcom/livemixtapes/Mixtape$11;-><init>(Lcom/livemixtapes/Mixtape;I)V

    .line 782
    const-wide/16 v5, 0x1

    .line 773
    invoke-virtual {v3, v4, v5, v6}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 785
    .end local v8    # "action":I
    :cond_5
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    return-object v3

    .line 468
    .restart local v10    # "backScreenTitle":Ljava/lang/String;
    .restart local v11    # "bundle":Landroid/os/Bundle;
    .restart local v16    # "temp_tracklist":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    .restart local v17    # "title":Ljava/lang/String;
    :cond_6
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->playAll:Landroid/widget/ImageButton;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 469
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->downloadAll:Landroid/widget/ImageButton;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 470
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->downloadAllProgressBar:Landroid/widget/ProgressBar;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 471
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->like:Landroid/widget/ImageButton;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 472
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->dislike:Landroid/widget/ImageButton;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 473
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->date:Landroid/widget/TextView;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 474
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->score:Landroid/widget/TextView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 475
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->scorelabel:Landroid/widget/TextView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 479
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "releaseseconds"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    move-object/from16 v0, p0

    iput-wide v3, v0, Lcom/livemixtapes/Mixtape;->release_seconds:J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 483
    :goto_1
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    .line 485
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "RELEASE SECONDS: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-wide v6, v0, Lcom/livemixtapes/Mixtape;->release_seconds:J

    invoke-virtual {v5, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v3}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 486
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/livemixtapes/Mixtape;->rootView:Landroid/view/View;

    const v4, 0x7f0800a4

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/LinearLayout;

    .line 489
    .local v12, "countdown_layout":Landroid/widget/LinearLayout;
    move-object/from16 v0, p0

    iget-wide v3, v0, Lcom/livemixtapes/Mixtape;->release_seconds:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    .line 492
    const/4 v3, 0x0

    invoke-virtual {v12, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 494
    new-instance v2, Lcom/livemixtapes/Mixtape$5;

    move-object/from16 v0, p0

    iget-wide v3, v0, Lcom/livemixtapes/Mixtape;->release_seconds:J

    const-wide/16 v5, 0x3e8

    mul-long v4, v3, v5

    const-wide/16 v6, 0x3e8

    move-object/from16 v3, p0

    invoke-direct/range {v2 .. v7}, Lcom/livemixtapes/Mixtape$5;-><init>(Lcom/livemixtapes/Mixtape;JJ)V

    .line 572
    .local v2, "Count":Landroid/os/CountDownTimer;
    invoke-virtual {v2}, Landroid/os/CountDownTimer;->start()Landroid/os/CountDownTimer;

    goto/16 :goto_0

    .line 481
    .end local v2    # "Count":Landroid/os/CountDownTimer;
    .end local v12    # "countdown_layout":Landroid/widget/LinearLayout;
    :catch_0
    move-exception v14

    .line 483
    .local v14, "e":Ljava/lang/Exception;
    const-wide/16 v3, 0x0

    move-object/from16 v0, p0

    iput-wide v3, v0, Lcom/livemixtapes/Mixtape;->release_seconds:J

    goto :goto_1
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 2150
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 2152
    sget-boolean v0, Lcom/livemixtapes/Mixtape;->shouldClearPlayListMode:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->playlistMode:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2154
    const/4 v0, 0x0

    sput-boolean v0, Lcom/livemixtapes/Mixtape;->shouldClearPlayListMode:Z

    .line 2155
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->exitPlaylistMode()V

    .line 2157
    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 1973
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 1974
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->getMixtapeInfo()V

    .line 1975
    return-void
.end method

.method playAll()V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 1917
    const/4 v0, 0x0

    .line 1918
    .local v0, "position":I
    iget-object v1, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v2, "tracks"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    sput-object v1, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    .line 1919
    iget-object v1, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    sput-object v1, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 1920
    sput v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 1921
    sput v3, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 1922
    sput-boolean v3, Lcom/livemixtapes/MainActivity;->isPlaying:Z

    .line 1923
    sget-object v1, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    const v2, 0x7f0200f8

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1924
    sget-object v1, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lcom/livemixtapes/Mixtape;->shake(Landroid/view/View;Ljava/lang/Runnable;)V

    .line 1926
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->initializeAndReload()V

    .line 1968
    return-void
.end method

.method public setData()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 923
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/livemixtapes/database/DBHelper;->sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;

    move-result-object v3

    iput-object v3, p0, Lcom/livemixtapes/Mixtape;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    .line 925
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iput v3, p0, Lcom/livemixtapes/Mixtape;->id:I

    .line 927
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->djBadges:Lcom/livemixtapes/ui/widgets/DjBadgesView;

    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->setOnDjClickListener(Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;)V

    .line 928
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->djBadges:Lcom/livemixtapes/ui/widgets/DjBadgesView;

    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v5, "DJ"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v7}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->loadDjs([Ljava/lang/String;Z)V

    .line 930
    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->title:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v5, "title"

    invoke-interface {v3, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 931
    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->views:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v3, "Mixtape Views: <b>"

    invoke-direct {v5, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v6, "views"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Lcom/livemixtapes/Utils;->formatWithCommas(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, "</b>"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 933
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "releasedate"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 934
    .local v0, "dateString":Ljava/lang/String;
    invoke-static {v0}, Lcom/livemixtapes/utils/Utility;->parseApiDate(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    .line 936
    .local v2, "releaseDate":Ljava/util/Date;
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->date:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Uploaded: <b>"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lcom/livemixtapes/utils/Utility;->formatDateShort(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "</b>"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 937
    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->score:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v5, "score"

    invoke-interface {v3, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Lcom/livemixtapes/Utils;->formatWithCommas(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 939
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/livemixtapes/Mixtape;->favorited:Ljava/lang/Boolean;

    .line 940
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/livemixtapes/Mixtape;->voted:Ljava/lang/Boolean;

    .line 941
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/livemixtapes/Mixtape;->voting:Ljava/lang/Boolean;

    .line 943
    invoke-static {}, Lcom/livemixtapes/User;->isGuest()Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 944
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->disableVoteButtons()V

    .line 960
    :goto_0
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->favorited:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 961
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->favorite:Landroid/widget/ImageButton;

    const v4, 0x7f0200ff

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 966
    :goto_1
    new-instance v1, Lcom/livemixtapes/ImageLoader;

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-direct {v1, v3}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    .line 967
    .local v1, "imageLoader":Lcom/livemixtapes/ImageLoader;
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v4, "cover"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;

    invoke-virtual {v1, v3, v4}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 969
    new-instance v4, Lcom/livemixtapes/LazyAdapterTracks;

    .line 970
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v5, "tracks"

    invoke-interface {v3, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    invoke-direct {v4, p0, v3}, Lcom/livemixtapes/LazyAdapterTracks;-><init>(Lcom/livemixtapes/Mixtape;Ljava/util/ArrayList;)V

    .line 969
    iput-object v4, p0, Lcom/livemixtapes/Mixtape;->adapter:Lcom/livemixtapes/LazyAdapterTracks;

    .line 971
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;

    iget-object v4, p0, Lcom/livemixtapes/Mixtape;->adapter:Lcom/livemixtapes/LazyAdapterTracks;

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 972
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->downloadAllProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v3, v7}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 976
    const-string v3, "mixtape"

    const-string v4, "setData"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 984
    return-void

    .line 946
    .end local v1    # "imageLoader":Lcom/livemixtapes/ImageLoader;
    :cond_0
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v3

    iget-object v3, v3, Lcom/livemixtapes/User$UserData;->favoriteMixtapeIds:Ljava/util/Set;

    iget v4, p0, Lcom/livemixtapes/Mixtape;->id:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    iput-object v3, p0, Lcom/livemixtapes/Mixtape;->favorited:Ljava/lang/Boolean;

    .line 954
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->checkIfMixtapeNotVoted()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 955
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->enableVoteButtons()V

    goto :goto_0

    .line 957
    :cond_1
    invoke-direct {p0}, Lcom/livemixtapes/Mixtape;->disableVoteButtons()V

    goto :goto_0

    .line 963
    :cond_2
    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->favorite:Landroid/widget/ImageButton;

    const v4, 0x7f0200eb

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_1
.end method

.method setProgressOnUiThreadWithPos(II)V
    .locals 2
    .param p1, "pos"    # I
    .param p2, "progress"    # I

    .prologue
    .line 1205
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/livemixtapes/Mixtape$13;

    invoke-direct {v1, p0, p1, p2}, Lcom/livemixtapes/Mixtape$13;-><init>(Lcom/livemixtapes/Mixtape;II)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1218
    return-void
.end method

.method shareSocialNetworks(Ljava/lang/String;)V
    .locals 11
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 1026
    new-instance v7, Landroid/content/Intent;

    const-string v8, "android.intent.action.SEND"

    invoke-direct {v7, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1027
    .local v7, "shareIntent":Landroid/content/Intent;
    const-string v8, "text/plain"

    invoke-virtual {v7, v8}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 1028
    const-string v8, "com.instagram.android"

    invoke-virtual {p1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 1029
    const-string v8, "image/*"

    invoke-virtual {v7, v8}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 1030
    :cond_0
    const-string v9, "android.intent.extra.TEXT"

    .line 1031
    iget-object v8, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v10, "sharetext"

    invoke-interface {v8, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    .line 1030
    invoke-virtual {v7, v9, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1032
    new-instance v4, Lcom/livemixtapes/ImageLoader;

    iget-object v8, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    invoke-direct {v4, v8}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    .line 1033
    .local v4, "imageLoader":Lcom/livemixtapes/ImageLoader;
    iget-object v8, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v9, "cover"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v4, v8}, Lcom/livemixtapes/ImageLoader;->getBitmap(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v3

    .line 1034
    .local v3, "bt":Landroid/graphics/Bitmap;
    const-string v8, "android.intent.extra.STREAM"

    invoke-virtual {p0, v3}, Lcom/livemixtapes/Mixtape;->getLocalUriFromBitmap(Landroid/graphics/Bitmap;)Landroid/net/Uri;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 1036
    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v8

    invoke-virtual {v8}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 1038
    .local v6, "pm":Landroid/content/pm/PackageManager;
    const/4 v8, 0x0

    .line 1037
    invoke-virtual {v6, v7, v8}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 1039
    .local v1, "activityList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-nez v9, :cond_2

    .line 1052
    :goto_0
    return-void

    .line 1039
    :cond_2
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/pm/ResolveInfo;

    .line 1040
    .local v2, "app":Landroid/content/pm/ResolveInfo;
    iget-object v9, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v9, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 1041
    iget-object v0, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 1042
    .local v0, "activity":Landroid/content/pm/ActivityInfo;
    new-instance v5, Landroid/content/ComponentName;

    .line 1043
    iget-object v8, v0, Landroid/content/pm/ActivityInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    iget-object v9, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    .line 1042
    invoke-direct {v5, v8, v9}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 1044
    .local v5, "name":Landroid/content/ComponentName;
    const-string v8, "android.intent.category.LAUNCHER"

    invoke-virtual {v7, v8}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 1045
    const/high16 v8, 0x10200000

    invoke-virtual {v7, v8}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 1047
    invoke-virtual {v7, v5}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 1048
    invoke-virtual {p0, v7}, Lcom/livemixtapes/Mixtape;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public showCommentPopup()V
    .locals 4

    .prologue
    .line 853
    new-instance v0, Lcom/livemixtapes/CommentsPopup;

    invoke-virtual {p0}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    invoke-direct {v0, v1, v2, v3}, Lcom/livemixtapes/CommentsPopup;-><init>(Landroid/app/Activity;Landroid/content/Context;Ljava/util/Map;)V

    .line 854
    .local v0, "popup":Lcom/livemixtapes/CommentsPopup;
    iget-object v1, p0, Lcom/livemixtapes/Mixtape;->mainFrameLayout:Landroid/widget/FrameLayout;

    iget-object v2, p0, Lcom/livemixtapes/Mixtape;->comments:Landroid/widget/ImageButton;

    invoke-virtual {v0, v1, v2}, Lcom/livemixtapes/CommentsPopup;->showPopup(Landroid/widget/FrameLayout;Landroid/widget/ImageButton;)V

    .line 855
    return-void
.end method

.method updatePlayListSelectionBackground(IZ)V
    .locals 2
    .param p1, "pos"    # I
    .param p2, "isSelected"    # Z

    .prologue
    .line 1242
    iget-object v0, p0, Lcom/livemixtapes/Mixtape;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/livemixtapes/Mixtape$15;

    invoke-direct {v1, p0, p1, p2}, Lcom/livemixtapes/Mixtape$15;-><init>(Lcom/livemixtapes/Mixtape;IZ)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1263
    return-void
.end method
