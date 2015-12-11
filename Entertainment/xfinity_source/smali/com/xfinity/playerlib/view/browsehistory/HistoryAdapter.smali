.class public Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;
.super Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
.source "HistoryAdapter.java"

# interfaces
.implements Lcom/comcast/cim/downloads/DownloadServiceListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;,
        Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        "Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;",
        ">;",
        "Lcom/comcast/cim/downloads/DownloadServiceListener",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static final sdf:Lorg/apache/commons/lang3/time/FastDateFormat;


# instance fields
.field private bookmarks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;"
        }
    .end annotation
.end field

.field protected context:Landroid/content/Context;

.field private coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field currentlyPlayingVideoId:Ljava/lang/Long;

.field private dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field private downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private downloadServiceListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;

.field private downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

.field private handler:Landroid/os/Handler;

.field private internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final isTabletDevice:Z

.field itemViewLayoutId:I

.field private liveStreamPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

.field private liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

.field private final scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

.field private videoPlayButtonOnClickListener:Landroid/view/View$OnClickListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    const-class v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->LOG:Lorg/slf4j/Logger;

    .line 47
    const-string v0, "MM/dd/yyyy"

    invoke-static {v0}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->sdf:Lorg/apache/commons/lang3/time/FastDateFormat;

    return-void
.end method

.method public constructor <init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;ILjava/lang/Long;ZLcom/xfinity/playerlib/view/ScrollStateTracker;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V
    .locals 1
    .param p1, "layoutInflater"    # Landroid/view/LayoutInflater;
    .param p2, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p3, "videoPlayButtonOnClickListener"    # Landroid/view/View$OnClickListener;
    .param p4, "liveStreamPlayButtonOnClickListener"    # Landroid/view/View$OnClickListener;
    .param p5, "downloadManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p6, "downloadsItemListener"    # Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;
    .param p7, "itemViewId"    # I
    .param p8, "currentlyPlayingVideoId"    # Ljava/lang/Long;
    .param p9, "isTabletDevice"    # Z
    .param p10, "scrollStateTracker"    # Lcom/xfinity/playerlib/view/ScrollStateTracker;
    .param p11, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .prologue
    .line 82
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->bookmarks:Ljava/util/List;

    .line 56
    sget v0, Lcom/xfinity/playerlib/R$layout;->history_item:I

    iput v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->itemViewLayoutId:I

    .line 65
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->handler:Landroid/os/Handler;

    .line 69
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadServiceListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;

    .line 83
    iput-object p2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 84
    iput-object p3, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->videoPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    .line 85
    iput-object p4, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->liveStreamPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    .line 86
    iput-object p5, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 87
    iput-object p6, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    .line 88
    iput p7, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->itemViewLayoutId:I

    .line 89
    iput-boolean p9, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->isTabletDevice:Z

    .line 90
    iput-object p10, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    .line 91
    iput-object p11, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 93
    iput-object p8, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 95
    invoke-virtual {p1}, Landroid/view/LayoutInflater;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    .line 96
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    return-object v0
.end method

.method private presentEntitledVideo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 9
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    .param p2, "videoBookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    const/4 v8, 0x1

    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 298
    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getPosition()I

    move-result v1

    if-lez v1, :cond_0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isFinished()Z

    move-result v1

    if-nez v1, :cond_0

    .line 299
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    .line 300
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->resume:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v2, v3}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    .line 299
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 302
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_resume_button:I

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 310
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    .line 311
    .local v0, "fileForBookmark":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-eqz v0, :cond_2

    .line 312
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->isDownloadComplete()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 313
    invoke-direct {p0, p1, v0, p2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->showDownloadedInfo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V

    .line 325
    :goto_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->currentlyPlayingVideoId:Ljava/lang/Long;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 326
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {p2}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-nez v1, :cond_3

    .line 328
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 329
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 350
    :goto_2
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    sget v2, Lcom/xfinity/playerlib/R$drawable;->play_button_entitled_graphic:I

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 351
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    sget v2, Lcom/xfinity/playerlib/R$drawable;->play_button_entitled_background:I

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 352
    :goto_3
    return-void

    .line 304
    .end local v0    # "fileForBookmark":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_0
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    .line 305
    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->play:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v2, v3}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    .line 304
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 307
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_play_button:I

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 315
    .restart local v0    # "fileForBookmark":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_1
    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->showInProgressInfo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    goto :goto_3

    .line 319
    :cond_2
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->downloadedLayout:Landroid/view/View;

    invoke-virtual {v1, v7}, Landroid/view/View;->setVisibility(I)V

    .line 320
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-virtual {v1, v7}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 321
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1

    .line 332
    :cond_3
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 333
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 335
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->isEditMode:Z

    if-eqz v1, :cond_4

    .line 336
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 337
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setClickable(Z)V

    goto :goto_2

    .line 339
    :cond_4
    if-eqz v0, :cond_5

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->OVP_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-ne v1, v2, :cond_5

    .line 340
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 341
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setClickable(Z)V

    goto :goto_2

    .line 343
    :cond_5
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v8}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 344
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v8}, Landroid/widget/LinearLayout;->setClickable(Z)V

    goto :goto_2
.end method

.method private presentLiveStream(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;ZZ)V
    .locals 4
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    .param p2, "isAvailable"    # Z
    .param p3, "isEntitled"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    const/16 v1, 0x8

    .line 368
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 369
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 370
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->downloadedLayout:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 371
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 372
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->seriesInfo:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 374
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->isEditMode:Z

    if-eqz v0, :cond_0

    .line 375
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 376
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setClickable(Z)V

    .line 382
    :goto_0
    if-eqz p2, :cond_2

    .line 383
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->play:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 384
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_play_button:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 394
    if-eqz p3, :cond_1

    .line 395
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->play_button_entitled_graphic:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 396
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->play_button_entitled_background:I

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 410
    :goto_1
    return-void

    .line 378
    :cond_0
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setEnabled(Z)V

    .line 379
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setClickable(Z)V

    goto :goto_0

    .line 398
    :cond_1
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_upsell_btn:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 399
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->play_button_unentitled_not_pressed:I

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    goto :goto_1

    .line 402
    :cond_2
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 404
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->no_longer_available:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 405
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->MediumLightGray:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 406
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_play_button_unentitled:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 408
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    goto :goto_1
.end method

.method private presentUnentitledVideo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;)V
    .locals 3
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    .prologue
    const/16 v1, 0x8

    .line 355
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->downloadedLayout:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 356
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 357
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 359
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_upsell_btn:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 361
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->play:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 362
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_play_button_unentitled:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 364
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    sget v1, Lcom/xfinity/playerlib/R$drawable;->play_button_unentitled:I

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 365
    return-void
.end method

.method private showDownloadedInfo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V
    .locals 7
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    .param p2, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p3, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .prologue
    const/16 v4, 0x8

    const/4 v6, 0x0

    const/4 v3, 0x0

    .line 413
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->downloadedLayout:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 414
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    invoke-virtual {v0, v4}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 415
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 416
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 418
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 419
    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getPosition()I

    move-result v0

    if-lez v0, :cond_0

    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    sget v0, Lcom/xfinity/playerlib/R$string;->resume:I

    .line 418
    :goto_0
    invoke-virtual {v2, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    .line 419
    invoke-virtual {v0, v2}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 418
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 421
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->AAW_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-ne v0, v1, :cond_1

    .line 422
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 423
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->MediumLightGray:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 424
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->unavailable:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 425
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 434
    :goto_1
    return-void

    .line 419
    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$string;->play:I

    goto :goto_0

    .line 426
    :cond_1
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDaysLeft(Ljava/util/Date;)I

    move-result v0

    const/16 v1, 0xe

    if-ge v0, v1, :cond_2

    .line 427
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 428
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->MediumLightGray:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 429
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->available_until:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    sget-object v4, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->sdf:Lorg/apache/commons/lang3/time/FastDateFormat;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAssetExpirationDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v4, v5}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 430
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 432
    :cond_2
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method private showInProgressInfo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 3
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    .param p2, "playerDownloadFile"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    const/16 v2, 0x8

    .line 437
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 438
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->downloadedLayout:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 439
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 440
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 442
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v0, p2, v1, v2}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setProgress(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    .line 444
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    new-instance v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;

    invoke-direct {v1, p0, p2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setOnCancelListener(Landroid/view/View$OnClickListener;)V

    .line 451
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    new-instance v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$2;

    invoke-direct {v1, p0, p2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$2;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setOnHotwireDownloadClickListener(Landroid/view/View$OnClickListener;)V

    .line 458
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    new-instance v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$3;

    invoke-direct {v1, p0, p2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$3;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setOnRetryDownloadClickListener(Landroid/view/View$OnClickListener;)V

    .line 465
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadServiceListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->add(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 466
    return-void
.end method


# virtual methods
.method protected bindItem(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V
    .locals 22
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    .param p2, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .prologue
    .line 145
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v14

    .line 146
    .local v14, "title":Ljava/lang/String;
    const/4 v12, 0x0

    .line 148
    .local v12, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    const/4 v7, 0x0

    .line 150
    .local v7, "isSeries":Z
    move-object/from16 v0, p2

    instance-of v0, v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    move/from16 v17, v0

    if-eqz v17, :cond_a

    move-object/from16 v16, p2

    .line 151
    check-cast v16, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 152
    .local v16, "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->videoPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 153
    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v11

    .line 155
    .local v11, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v17, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v11, v1, v2}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v10

    .line 158
    .local v10, "loadedFromMemory":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Lcom/xfinity/playerlib/view/ScrollStateTracker;->isFlinging()Z

    move-result v17

    if-eqz v17, :cond_5

    .line 161
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 162
    if-nez v10, :cond_0

    .line 163
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 172
    :cond_0
    :goto_0
    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isMovie()Z

    move-result v17

    if-nez v17, :cond_1

    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getSeasonNumber()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    .line 173
    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getEpisodeNumber()I

    move-result v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    .line 172
    invoke-static/range {v17 .. v18}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSeriesString(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;

    move-result-object v17

    .line 173
    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->isEmpty()Z

    move-result v17

    if-eqz v17, :cond_6

    .line 174
    :cond_1
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->seriesInfo:Landroid/widget/TextView;

    move-object/from16 v17, v0

    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setVisibility(I)V

    .line 192
    :goto_1
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setVisibility(I)V

    .line 194
    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isMovie()Z

    move-result v17

    if-eqz v17, :cond_7

    .line 195
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v18

    invoke-interface/range {v17 .. v18}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v12

    .line 204
    :cond_2
    :goto_2
    if-nez v12, :cond_8

    .line 205
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->downloadedLayout:Landroid/view/View;

    move-object/from16 v17, v0

    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->setVisibility(I)V

    .line 206
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    move-object/from16 v17, v0

    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;->setVisibility(I)V

    .line 207
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    move-object/from16 v17, v0

    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 208
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 209
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setVisibility(I)V

    .line 211
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    sget v19, Lcom/xfinity/playerlib/R$string;->no_longer_available:I

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v18

    sget-object v19, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual/range {v18 .. v19}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 212
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    sget v19, Lcom/xfinity/playerlib/R$color;->MediumLightGray:I

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getColor(I)I

    move-result v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setTextColor(I)V

    .line 213
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    sget v19, Lcom/xfinity/playerlib/R$string;->content_description_play_button_unentitled:I

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 215
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 267
    .end local v11    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v16    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_3
    :goto_3
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    if-eqz v17, :cond_4

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Landroid/widget/TextView;->getVisibility()I

    move-result v17

    if-nez v17, :cond_4

    .line 269
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getDuration()I

    move-result v19

    .line 270
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getPosition()I

    move-result v20

    .line 269
    invoke-static/range {v18 .. v20}, Lcom/comcast/cim/utils/UIPresentationUtil;->getRemainingTime(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 272
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->isFinished()Z

    move-result v17

    if-eqz v17, :cond_10

    .line 273
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v18, v0

    .line 274
    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    sget v19, Lcom/xfinity/playerlib/R$string;->finished:I

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v18

    .line 273
    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 284
    :cond_4
    :goto_4
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    .line 286
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->isTabletDevice:Z

    move/from16 v17, v0

    if-nez v17, :cond_11

    if-eqz v7, :cond_11

    .line 287
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->title:Landroid/widget/TextView;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, ": "

    .line 288
    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    .line 289
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 287
    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 294
    :goto_5
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->title:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v14}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 295
    return-void

    .line 166
    .restart local v11    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v16    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_5
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 169
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v17, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v11, v1, v2}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto/16 :goto_0

    .line 177
    :cond_6
    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getSeasonNumber()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    .line 178
    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getEpisodeNumber()I

    move-result v18

    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v18

    .line 177
    invoke-static/range {v17 .. v18}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSeriesString(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;

    move-result-object v13

    .line 180
    .local v13, "seriesString":Ljava/lang/String;
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->seriesInfo:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 182
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->title:Landroid/widget/TextView;

    move-object/from16 v17, v0

    .line 183
    invoke-virtual/range {v17 .. v17}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    sget v18, Lcom/xfinity/playerlib/R$string;->content_description_season:I

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->title:Landroid/widget/TextView;

    move-object/from16 v18, v0

    .line 185
    invoke-virtual/range {v18 .. v18}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    sget v19, Lcom/xfinity/playerlib/R$string;->content_description_episode:I

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v18

    .line 182
    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-static {v13, v0, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSeriesStringSpoken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 188
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->seriesInfo:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 189
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->seriesInfo:Landroid/widget/TextView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 197
    .end local v13    # "seriesString":Ljava/lang/String;
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v16}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v18

    invoke-interface/range {v17 .. v18}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v12

    .line 198
    const/4 v7, 0x1

    .line 199
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->isTabletDevice:Z

    move/from16 v17, v0

    if-nez v17, :cond_2

    if-eqz v12, :cond_2

    .line 200
    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v14

    goto/16 :goto_2

    .line 217
    :cond_8
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 218
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    sget v19, Lcom/xfinity/playerlib/R$color;->white:I

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getColor(I)I

    move-result v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setTextColor(I)V

    .line 219
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v12}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v6

    .line 221
    .local v6, "isEntitled":Z
    if-eqz v6, :cond_9

    .line 222
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, v16

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->presentEntitledVideo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    goto/16 :goto_3

    .line 224
    :cond_9
    invoke-direct/range {p0 .. p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->presentUnentitledVideo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;)V

    goto/16 :goto_3

    .end local v6    # "isEntitled":Z
    .end local v10    # "loadedFromMemory":Z
    .end local v11    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v16    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_a
    move-object/from16 v9, p2

    .line 229
    check-cast v9, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 230
    .local v9, "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->liveStreamPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 232
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    sget v18, Lcom/xfinity/playerlib/R$dimen;->cover_art_src_width:I

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 233
    .local v4, "imageWidth":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    sget v18, Lcom/xfinity/playerlib/R$dimen;->cover_art_src_height:I

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 234
    .local v3, "imageHeight":I
    invoke-virtual {v9}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getArtworkUrl()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-static {v0, v4, v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getArtworkUrl(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v15

    .line 236
    .local v15, "url":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v19, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v15, v1, v2}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)Z

    move-result v10

    .line 239
    .restart local v10    # "loadedFromMemory":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Lcom/xfinity/playerlib/view/ScrollStateTracker;->isFlinging()Z

    move-result v17

    if-eqz v17, :cond_d

    .line 242
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 243
    if-nez v10, :cond_b

    .line 244
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 253
    :cond_b
    :goto_6
    const/4 v6, 0x0

    .line 254
    .restart local v6    # "isEntitled":Z
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    move-object/from16 v17, v0

    invoke-virtual {v9}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->getLiveStream(Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v8

    .line 255
    .local v8, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    if-eqz v8, :cond_e

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v17

    if-eqz v17, :cond_e

    const/4 v5, 0x1

    .line 256
    .local v5, "isAvailable":Z
    :goto_7
    if-eqz v5, :cond_c

    .line 257
    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v17

    if-eqz v17, :cond_f

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-object/from16 v18, v0

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v17

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Ljava/util/List;->size()I

    move-result v19

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v19, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v17

    check-cast v17, [Ljava/lang/String;

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_f

    const/4 v6, 0x1

    .line 260
    :cond_c
    :goto_8
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v5, v6}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->presentLiveStream(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;ZZ)V

    .line 262
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    if-eqz v17, :cond_3

    .line 263
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    const/16 v18, 0x8

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    .line 247
    .end local v5    # "isAvailable":Z
    .end local v6    # "isEntitled":Z
    .end local v8    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    :cond_d
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 250
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v17, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v0, v15, v1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto/16 :goto_6

    .line 255
    .restart local v6    # "isEntitled":Z
    .restart local v8    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    :cond_e
    const/4 v5, 0x0

    goto :goto_7

    .line 257
    .restart local v5    # "isAvailable":Z
    :cond_f
    const/4 v6, 0x0

    goto :goto_8

    .line 276
    .end local v3    # "imageHeight":I
    .end local v4    # "imageWidth":I
    .end local v5    # "isAvailable":Z
    .end local v6    # "isEntitled":Z
    .end local v8    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .end local v9    # "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .end local v15    # "url":Ljava/lang/String;
    :cond_10
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    move-object/from16 v17, v0

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v19, v0

    .line 278
    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getDuration()I

    move-result v20

    invoke-virtual/range {p2 .. p2}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getPosition()I

    move-result v21

    sub-int v20, v20, v21

    move/from16 v0, v20

    div-int/lit16 v0, v0, 0x3e8

    move/from16 v20, v0

    .line 277
    invoke-static/range {v19 .. v20}, Lcom/comcast/cim/utils/UIPresentationUtil;->getTimeForPlayer(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    move-object/from16 v19, v0

    sget v20, Lcom/xfinity/playerlib/R$string;->content_description_remaining:I

    .line 279
    invoke-virtual/range {v19 .. v20}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    .line 276
    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto/16 :goto_4

    .line 291
    :cond_11
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->title:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v14}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto/16 :goto_5
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->bindItem(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;
    .locals 1

    .prologue
    .line 480
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;-><init>()V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 470
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->bookmarks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getData()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 118
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->bookmarks:Ljava/util/List;

    return-object v0
.end method

.method public getItem(I)Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 475
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->bookmarks:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->getItem(I)Lcom/xfinity/playerlib/bookmarks/Bookmark;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 485
    iget v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->itemViewLayoutId:I

    return v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    .prologue
    .line 124
    invoke-virtual {p1}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableLinearLayout;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->itemContainerLayout:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableLinearLayout;

    .line 126
    sget v0, Lcom/xfinity/playerlib/R$id;->title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->title:Landroid/widget/TextView;

    .line 127
    sget v0, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    .line 128
    sget v0, Lcom/xfinity/playerlib/R$id;->series_info:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->seriesInfo:Landroid/widget/TextView;

    .line 129
    sget v0, Lcom/xfinity/playerlib/R$id;->progressIndicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->progressIndicator:Landroid/widget/TextView;

    .line 130
    sget v0, Lcom/xfinity/playerlib/R$id;->expiration_text:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->expirationText:Landroid/widget/TextView;

    .line 132
    sget v0, Lcom/xfinity/playerlib/R$id;->play_button:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->button:Landroid/widget/LinearLayout;

    .line 133
    sget v0, Lcom/xfinity/playerlib/R$id;->button_caption:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonCaption:Landroid/widget/TextView;

    .line 134
    sget v0, Lcom/xfinity/playerlib/R$id;->button_art:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->buttonArt:Landroid/widget/ImageView;

    .line 136
    sget v0, Lcom/xfinity/playerlib/R$id;->on_now_button:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->watchingButton:Landroid/widget/LinearLayout;

    .line 138
    sget v0, Lcom/xfinity/playerlib/R$id;->in_progress_layout:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->inProgressLayout:Lcom/xfinity/playerlib/view/widget/DownloadProgressBar;

    .line 140
    sget v0, Lcom/xfinity/playerlib/R$id;->downloaded_layout:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;->downloadedLayout:Landroid/view/View;

    .line 141
    return-void
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 43
    check-cast p3, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;)V

    return-void
.end method

.method public onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 1
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 506
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadServiceListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    .line 507
    return-void
.end method

.method public onDownloadServiceConnected()V
    .locals 2

    .prologue
    .line 496
    sget-object v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Connected to the download Service!!!"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 497
    return-void
.end method

.method public bridge synthetic onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->onFileDownloadError(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadError(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 517
    return-void
.end method

.method public bridge synthetic onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 527
    return-void
.end method

.method public bridge synthetic onFileDownloadStarted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 522
    return-void
.end method

.method public onFileListUpdated()V
    .locals 0

    .prologue
    .line 502
    return-void
.end method

.method public bridge synthetic onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 1
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 511
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadServiceListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$DownloadServiceListener;->onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 512
    return-void
.end method

.method public removeItems(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 490
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->bookmarks:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 491
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->notifyDataSetChanged()V

    .line 492
    return-void
.end method

.method public setData(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 100
    .local p1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->bookmarks:Ljava/util/List;

    .line 101
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->notifyDataSetChanged()V

    .line 102
    return-void
.end method

.method public setDibicResource(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V
    .locals 0
    .param p1, "dibicResource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 110
    return-void
.end method

.method public setLiveStreamResource(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;)V
    .locals 0
    .param p1, "liveStreamResource"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 114
    return-void
.end method

.method public setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 0
    .param p1, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 106
    return-void
.end method
