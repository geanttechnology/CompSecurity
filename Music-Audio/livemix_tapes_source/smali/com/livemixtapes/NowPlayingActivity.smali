.class public Lcom/livemixtapes/NowPlayingActivity;
.super Landroid/app/Activity;
.source "NowPlayingActivity.java"


# static fields
.field public static final MIXTAPE_FLAG:I = 0x1

.field public static final PLAYLIST_FLAG:I = 0x3

.field public static final SEARCH_FLAG:I = 0x2

.field public static artist:Ljava/lang/String;

.field static artistTitle:Landroid/widget/TextView;

.field static currentTime:Landroid/widget/TextView;

.field static currentURL:Ljava/lang/String;

.field static download:Lcom/livemixtapes/ui/FadeImageButton;

.field static downloadId:J

.field public static flag:I

.field static imageLoader:Lcom/livemixtapes/ImageLoader;

.field static mContext:Landroid/content/Context;

.field public static mixtape:Ljava/util/Map;
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

.field private static observer:Lcom/livemixtapes/MediaObserver;

.field public static playList:Ljava/util/Map;
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

.field static playListImage:Landroid/widget/ImageView;

.field static playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

.field private static playing:Ljava/lang/Boolean;

.field public static position:I

.field static previous:Lcom/livemixtapes/ui/FadeImageButton;

.field static repeat:Lcom/livemixtapes/ui/FadeImageButton;

.field public static repeatStatus:Z

.field static savedTracksList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field static seekbar:Landroid/widget/SeekBar;

.field static share:Lcom/livemixtapes/ui/FadeImageButton;

.field static shuffle:Lcom/livemixtapes/ui/FadeImageButton;

.field public static shuffleStatus:Z

.field public static tape:Ljava/lang/String;

.field static tempDuration:Ljava/lang/String;

.field public static thumbURL:Ljava/lang/String;

.field public static title:Ljava/lang/String;

.field static totalTime:Landroid/widget/TextView;

.field public static trackCount:I

.field public static trackDuration:Ljava/lang/String;

.field static trackTitle:Landroid/widget/TextView;

.field static tracksList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public static whichTrack:Ljava/lang/String;


# instance fields
.field mFrameLayout:Landroid/widget/FrameLayout;

.field next:Lcom/livemixtapes/ui/FadeImageButton;

.field touchtracking:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->playing:Ljava/lang/Boolean;

    .line 57
    const/4 v0, 0x0

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    .line 68
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/livemixtapes/NowPlayingActivity;->touchtracking:Z

    .line 33
    return-void
.end method

.method static synthetic access$0()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->playing:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic access$1(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 52
    sput-object p0, Lcom/livemixtapes/NowPlayingActivity;->playing:Ljava/lang/Boolean;

    return-void
.end method

.method static synthetic access$2()Lcom/livemixtapes/MediaObserver;
    .locals 1

    .prologue
    .line 57
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    return-object v0
.end method

.method public static formatDuration(D)Ljava/lang/String;
    .locals 13
    .param p0, "seconds"    # D

    .prologue
    const/4 v12, 0x1

    const/4 v11, 0x0

    const-wide v9, 0x40ac200000000000L    # 3600.0

    const-wide/high16 v7, 0x404e000000000000L    # 60.0

    .line 332
    const-string v0, ""

    .line 335
    .local v0, "format":Ljava/lang/String;
    div-double v5, p0, v9

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v1

    .line 336
    .local v1, "hours":D
    rem-double/2addr p0, v9

    .line 338
    div-double v5, p0, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->floor(D)D

    move-result-wide v3

    .line 339
    .local v3, "minutes":D
    rem-double/2addr p0, v7

    .line 341
    const-wide/16 v5, 0x0

    cmpl-double v5, v1, v5

    if-lez v5, :cond_0

    .line 342
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    double-to-int v6, v1

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 343
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "%02d"

    new-array v7, v12, [Ljava/lang/Object;

    double-to-int v8, v3

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 348
    :goto_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "%02d"

    new-array v7, v12, [Ljava/lang/Object;

    double-to-int v8, p0

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 350
    return-object v0

    .line 345
    :cond_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    double-to-int v6, v3

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ":"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static initializeAndReload()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 86
    sget v0, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    if-ne v0, v2, :cond_1

    .line 87
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 88
    const-string v1, "tracks"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 87
    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    .line 92
    :cond_0
    :goto_0
    new-instance v0, Ljava/util/ArrayList;

    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->savedTracksList:Ljava/util/ArrayList;

    .line 93
    invoke-static {v2}, Lcom/livemixtapes/NowPlayingActivity;->reloadData(Z)V

    .line 94
    return-void

    .line 89
    :cond_1
    sget v0, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    .line 90
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->playList:Ljava/util/Map;

    .line 91
    const-string v1, "tracks"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 90
    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    goto :goto_0
.end method

.method public static nextTrack()V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 397
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    .line 386
    const-string v1, "NEXT TRACK CALLED"

    aput-object v1, v0, v2

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 387
    sget-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->repeatStatus:Z

    if-nez v0, :cond_0

    sget v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    sget v1, Lcom/livemixtapes/NowPlayingActivity;->trackCount:I

    add-int/lit8 v1, v1, -0x1

    if-ne v0, v1, :cond_0

    .line 396
    :goto_0
    return-void

    .line 389
    :cond_0
    sget v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    sget v1, Lcom/livemixtapes/NowPlayingActivity;->trackCount:I

    add-int/lit8 v1, v1, -0x1

    if-ne v0, v1, :cond_2

    .line 391
    sget-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->repeatStatus:Z

    if-eqz v0, :cond_1

    .line 392
    sput v2, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 396
    :cond_1
    :goto_1
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->reloadTrackInfo()V

    goto :goto_0

    .line 395
    :cond_2
    sget v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    goto :goto_1
.end method

.method public static pause()V
    .locals 3

    .prologue
    .line 364
    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    const v2, 0x7f02008f

    invoke-virtual {v1, v2}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    .line 365
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.livemixtapes.action.PAUSE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 366
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "com.livemixtapes"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 367
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 368
    return-void
.end method

.method public static play()V
    .locals 3

    .prologue
    .line 355
    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    const v2, 0x7f02008e

    invoke-virtual {v1, v2}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    .line 357
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.livemixtapes.action.PLAY"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 358
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "com.livemixtapes"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 359
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 361
    return-void
.end method

.method public static playpause()V
    .locals 2

    .prologue
    .line 379
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.livemixtapes.action.TOGGLE_PLAYBACK"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 380
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "com.livemixtapes"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 381
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 382
    return-void
.end method

.method public static previousTrack()V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 409
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 401
    const-string v2, "PREVIOUS TRACKED CALLED"

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 402
    sget-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->repeatStatus:Z

    if-nez v0, :cond_0

    sget v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    if-nez v0, :cond_0

    .line 408
    :goto_0
    return-void

    .line 404
    :cond_0
    sget v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    if-nez v0, :cond_1

    .line 405
    sget v0, Lcom/livemixtapes/NowPlayingActivity;->trackCount:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 408
    :goto_1
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->reloadTrackInfo()V

    goto :goto_0

    .line 407
    :cond_1
    sget v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    add-int/lit8 v0, v0, -0x1

    sput v0, Lcom/livemixtapes/NowPlayingActivity;->position:I

    goto :goto_1
.end method

.method static reloadData()V
    .locals 1

    .prologue
    .line 98
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/livemixtapes/NowPlayingActivity;->reloadData(Z)V

    .line 99
    return-void
.end method

.method static reloadData(Z)V
    .locals 10
    .param p0, "shouldPlay"    # Z

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 103
    sget v4, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    if-eq v4, v8, :cond_0

    sget v4, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    const/4 v5, 0x2

    if-ne v4, v5, :cond_5

    .line 104
    :cond_0
    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->artistTitle:Landroid/widget/TextView;

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    const-string v6, "title"

    invoke-interface {v4, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    const-string v5, "cover"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    .line 107
    :try_start_0
    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->imageLoader:Lcom/livemixtapes/ImageLoader;

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    const-string v6, "cover"

    invoke-interface {v4, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 108
    sget-object v6, Lcom/livemixtapes/NowPlayingActivity;->playListImage:Landroid/widget/ImageView;

    .line 107
    invoke-virtual {v5, v4, v6}, Lcom/livemixtapes/ImageLoader;->DisplayImageWithoutCache(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 109
    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->trackTitle:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v7, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    const-string v7, "track_artist"

    invoke-virtual {v4, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " - "

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v7, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    const-string v7, "track_title"

    invoke-virtual {v4, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 116
    :goto_0
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    const-string v5, "title"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->tape:Ljava/lang/String;

    .line 117
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 118
    const-string v5, "track_title"

    .line 117
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 118
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 117
    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    .line 120
    :try_start_1
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 121
    const-string v5, "track_artist"

    .line 120
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 121
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 120
    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 167
    :cond_1
    :goto_1
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    sput v4, Lcom/livemixtapes/NowPlayingActivity;->trackCount:I

    .line 169
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 170
    const-string v5, "track_id"

    .line 169
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 170
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 169
    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->whichTrack:Ljava/lang/String;

    .line 171
    sget-object v4, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->whichTrack:Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/livemixtapes/Utils;->isFileExists(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_6

    new-array v4, v8, [Ljava/lang/Object;

    .line 172
    const-string v5, "TRACK IS DOWNLOADED"

    aput-object v5, v4, v9

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 173
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v4, "file://"

    invoke-direct {v5, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v6, Lcom/livemixtapes/NowPlayingActivity;->mContext:Landroid/content/Context;

    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v7, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v7}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 174
    const-string v7, "track_id"

    .line 173
    invoke-virtual {v4, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 174
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 173
    invoke-static {v6, v4}, Lcom/livemixtapes/Utils;->getLivemixtapesFolder(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v4

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->currentURL:Ljava/lang/String;

    new-array v4, v8, [Ljava/lang/Object;

    .line 179
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "TRACK URL IS: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v6, Lcom/livemixtapes/NowPlayingActivity;->currentURL:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v9

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 180
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->download:Lcom/livemixtapes/ui/FadeImageButton;

    const/4 v5, 0x4

    invoke-virtual {v4, v5}, Lcom/livemixtapes/ui/FadeImageButton;->setVisibility(I)V

    .line 194
    :goto_2
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 195
    const-string v5, "track_duration"

    .line 194
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 195
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 194
    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->tempDuration:Ljava/lang/String;

    .line 196
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tempDuration:Ljava/lang/String;

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->trackDuration:Ljava/lang/String;

    .line 197
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->totalTime:Landroid/widget/TextView;

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->tempDuration:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v5

    invoke-static {v5, v6}, Lcom/livemixtapes/NowPlayingActivity;->formatDuration(D)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 198
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->currentTime:Landroid/widget/TextView;

    const-string v5, "0:00"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 200
    if-eqz p0, :cond_2

    .line 202
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->playing:Ljava/lang/Boolean;

    .line 203
    new-instance v1, Landroid/content/Intent;

    const-string v4, "com.livemixtapes.action.URL"

    invoke-direct {v1, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 204
    .local v1, "i":Landroid/content/Intent;
    const-string v4, "com.livemixtapes"

    invoke-virtual {v1, v4}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 205
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->currentURL:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 206
    .local v3, "uri":Landroid/net/Uri;
    invoke-virtual {v1, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 207
    sget-object v4, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v4, v1}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 209
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    const v5, 0x7f02008e

    invoke-virtual {v4, v5}, Lcom/livemixtapes/ui/FadeImageButton;->setBackgroundResource(I)V

    .line 211
    .end local v1    # "i":Landroid/content/Intent;
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_2
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    if-eqz v4, :cond_3

    .line 212
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    invoke-virtual {v4}, Lcom/livemixtapes/MediaObserver;->stop()V

    .line 218
    :cond_3
    :try_start_2
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    invoke-virtual {v4}, Lcom/livemixtapes/MediaObserver;->unstop()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_4

    .line 224
    :goto_3
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->playListImage:Landroid/widget/ImageView;

    invoke-static {v4, v5}, Lcom/livemixtapes/App;->showNotification(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 225
    return-void

    .line 111
    :catch_0
    move-exception v0

    .line 113
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto/16 :goto_0

    .line 123
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 125
    .restart local v0    # "e":Ljava/lang/Exception;
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    const-string v5, "artist"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 127
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    const-string v5, "artist"

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    goto/16 :goto_1

    .line 131
    :cond_4
    const-string v4, ""

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    goto/16 :goto_1

    .line 134
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_5
    sget v4, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    const/4 v5, 0x3

    if-ne v4, v5, :cond_1

    .line 135
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/HashMap;

    .line 137
    .local v2, "temp":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_3
    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->artistTitle:Landroid/widget/TextView;

    const-string v4, "track_artist"

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/CharSequence;

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_6

    .line 144
    :goto_4
    const-string v4, "track_mixtape_thumb"

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    const-string v5, "tn_"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    .line 146
    :try_start_4
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->imageLoader:Lcom/livemixtapes/ImageLoader;

    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->thumbURL:Ljava/lang/String;

    sget-object v6, Lcom/livemixtapes/NowPlayingActivity;->playListImage:Landroid/widget/ImageView;

    invoke-virtual {v4, v5, v6}, Lcom/livemixtapes/ImageLoader;->DisplayImageWithoutCache(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 147
    sget-object v5, Lcom/livemixtapes/NowPlayingActivity;->trackTitle:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v4, "track_artist"

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v6, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " - "

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v4, "track_title"

    invoke-virtual {v2, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    .line 153
    :goto_5
    const-string v4, "Playlist"

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->tape:Ljava/lang/String;

    .line 154
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 155
    const-string v5, "track_title"

    .line 154
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 155
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 154
    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->title:Ljava/lang/String;

    .line 158
    :try_start_5
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 159
    const-string v5, "track_artist"

    .line 158
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 159
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 158
    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2

    goto/16 :goto_1

    .line 161
    :catch_2
    move-exception v0

    .line 163
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v4, ""

    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->artist:Ljava/lang/String;

    goto/16 :goto_1

    .line 149
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v0

    .line 151
    .restart local v0    # "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_5

    .line 181
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v2    # "temp":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_6
    new-array v4, v8, [Ljava/lang/Object;

    .line 182
    const-string v5, "TRACK IS NOT DOWNLOADED"

    aput-object v5, v4, v9

    invoke-static {v4}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 184
    :try_start_6
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    sget v5, Lcom/livemixtapes/NowPlayingActivity;->position:I

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/HashMap;

    .line 185
    const-string v5, "download_url"

    .line 184
    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 185
    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 184
    sput-object v4, Lcom/livemixtapes/NowPlayingActivity;->currentURL:Ljava/lang/String;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_5

    .line 191
    :goto_6
    sget-object v4, Lcom/livemixtapes/NowPlayingActivity;->download:Lcom/livemixtapes/ui/FadeImageButton;

    invoke-virtual {v4, v9}, Lcom/livemixtapes/ui/FadeImageButton;->setVisibility(I)V

    goto/16 :goto_2

    .line 219
    :catch_4
    move-exception v4

    goto/16 :goto_3

    .line 187
    :catch_5
    move-exception v4

    goto :goto_6

    .line 139
    .restart local v2    # "temp":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_6
    move-exception v4

    goto/16 :goto_4
.end method

.method public static reloadTrackInfo()V
    .locals 0

    .prologue
    .line 413
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->reloadData()V

    .line 414
    return-void
.end method

.method private setListeners()V
    .locals 5

    .prologue
    .line 532
    new-instance v1, Lcom/livemixtapes/NowPlayingActivity$2;

    invoke-direct {v1, p0}, Lcom/livemixtapes/NowPlayingActivity$2;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    .line 564
    .local v1, "playBtnListener":Landroid/view/View$OnClickListener;
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    invoke-virtual {v3, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 566
    new-instance v0, Lcom/livemixtapes/NowPlayingActivity$3;

    invoke-direct {v0, p0}, Lcom/livemixtapes/NowPlayingActivity$3;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    .line 580
    .local v0, "nextBtnListener":Landroid/view/View$OnClickListener;
    iget-object v3, p0, Lcom/livemixtapes/NowPlayingActivity;->next:Lcom/livemixtapes/ui/FadeImageButton;

    invoke-virtual {v3, v0}, Lcom/livemixtapes/ui/FadeImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 582
    new-instance v2, Lcom/livemixtapes/NowPlayingActivity$4;

    invoke-direct {v2, p0}, Lcom/livemixtapes/NowPlayingActivity$4;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    .line 596
    .local v2, "prevBtnListener":Landroid/view/View$OnClickListener;
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->previous:Lcom/livemixtapes/ui/FadeImageButton;

    invoke-virtual {v3, v2}, Lcom/livemixtapes/ui/FadeImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 598
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->shuffle:Lcom/livemixtapes/ui/FadeImageButton;

    new-instance v4, Lcom/livemixtapes/NowPlayingActivity$5;

    invoke-direct {v4, p0}, Lcom/livemixtapes/NowPlayingActivity$5;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ui/FadeImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 622
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->repeat:Lcom/livemixtapes/ui/FadeImageButton;

    new-instance v4, Lcom/livemixtapes/NowPlayingActivity$6;

    invoke-direct {v4, p0}, Lcom/livemixtapes/NowPlayingActivity$6;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ui/FadeImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 633
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->seekbar:Landroid/widget/SeekBar;

    new-instance v4, Lcom/livemixtapes/NowPlayingActivity$7;

    invoke-direct {v4, p0}, Lcom/livemixtapes/NowPlayingActivity$7;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    invoke-virtual {v3, v4}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 680
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->download:Lcom/livemixtapes/ui/FadeImageButton;

    new-instance v4, Lcom/livemixtapes/NowPlayingActivity$8;

    invoke-direct {v4, p0}, Lcom/livemixtapes/NowPlayingActivity$8;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    invoke-virtual {v3, v4}, Lcom/livemixtapes/ui/FadeImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 713
    return-void
.end method

.method public static setTrack(I)V
    .locals 0
    .param p0, "index"    # I

    .prologue
    .line 504
    return-void
.end method

.method public static stop()V
    .locals 3

    .prologue
    .line 371
    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    const v2, 0x7f02008f

    invoke-virtual {v1, v2}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    .line 372
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.livemixtapes.action.PAUSE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 373
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "com.livemixtapes"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 375
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 376
    return-void
.end method

.method public static updatePosition()V
    .locals 7

    .prologue
    .line 508
    sget-object v3, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v3}, Landroid/media/MediaPlayer;->isPlaying()Z

    .line 518
    sget-object v3, Lcom/livemixtapes/LMTService;->mPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v3}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v3

    div-int/lit16 v0, v3, 0x3e8

    .line 520
    .local v0, "tempDuration":I
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->trackDuration:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 522
    .local v1, "tempMax":I
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->currentTime:Landroid/widget/TextView;

    int-to-double v4, v0

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-static {v4, v5}, Lcom/livemixtapes/NowPlayingActivity;->formatDuration(D)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 524
    int-to-double v3, v0

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v3

    .line 525
    int-to-double v5, v1

    invoke-static {v5, v6}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v5

    .line 524
    div-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    .line 526
    .local v2, "tempSet":Ljava/lang/Double;
    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v3

    const-wide/high16 v5, 0x4059000000000000L    # 100.0

    mul-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    .line 528
    sget-object v3, Lcom/livemixtapes/NowPlayingActivity;->seekbar:Landroid/widget/SeekBar;

    invoke-virtual {v2}, Ljava/lang/Double;->intValue()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 529
    return-void
.end method


# virtual methods
.method getIndividualFileProgress(J)I
    .locals 10
    .param p1, "downloadId"    # J

    .prologue
    const/4 v3, 0x0

    .line 716
    sget-object v6, Lcom/livemixtapes/NowPlayingActivity;->mContext:Landroid/content/Context;

    .line 717
    const-string v7, "download"

    invoke-virtual {v6, v7}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    .line 716
    check-cast v4, Landroid/app/DownloadManager;

    .line 718
    .local v4, "downloadManager":Landroid/app/DownloadManager;
    new-instance v5, Landroid/app/DownloadManager$Query;

    invoke-direct {v5}, Landroid/app/DownloadManager$Query;-><init>()V

    .line 719
    .local v5, "q":Landroid/app/DownloadManager$Query;
    const/4 v6, 0x1

    new-array v6, v6, [J

    aput-wide p1, v6, v3

    invoke-virtual {v5, v6}, Landroid/app/DownloadManager$Query;->setFilterById([J)Landroid/app/DownloadManager$Query;

    .line 721
    invoke-virtual {v4, v5}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;

    move-result-object v2

    .line 722
    .local v2, "cursor":Landroid/database/Cursor;
    if-eqz v2, :cond_0

    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v6

    if-nez v6, :cond_1

    .line 740
    :cond_0
    :goto_0
    return v3

    .line 727
    :cond_1
    const-string v6, "bytes_so_far"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 726
    invoke-interface {v2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 729
    .local v0, "bytes_downloaded":I
    const-string v6, "total_size"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 728
    invoke-interface {v2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 731
    .local v1, "bytes_total":I
    const-string v6, "status"

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    invoke-interface {v2, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v6

    const/16 v7, 0x8

    if-ne v6, v7, :cond_2

    .line 734
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 735
    const/16 v3, 0x64

    goto :goto_0

    .line 738
    :cond_2
    int-to-long v6, v0

    const-wide/16 v8, 0x64

    mul-long/2addr v6, v8

    int-to-long v8, v1

    div-long/2addr v6, v8

    long-to-int v3, v6

    .line 739
    .local v3, "dl_progress":I
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 229
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 230
    const v0, 0x7f03002d

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->setContentView(I)V

    .line 232
    sput-object p0, Lcom/livemixtapes/NowPlayingActivity;->mContext:Landroid/content/Context;

    .line 233
    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 235
    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 236
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 237
    const v3, 0x106000d

    .line 236
    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 235
    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 239
    const v0, 0x7f0800d1

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->trackTitle:Landroid/widget/TextView;

    .line 240
    const v0, 0x7f0800d6

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->artistTitle:Landroid/widget/TextView;

    .line 241
    const v0, 0x7f0800d7

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->playListImage:Landroid/widget/ImageView;

    .line 242
    const v0, 0x7f0800da

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->seekbar:Landroid/widget/SeekBar;

    .line 243
    const v0, 0x7f0800db

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->currentTime:Landroid/widget/TextView;

    .line 244
    const v0, 0x7f0800dc

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->totalTime:Landroid/widget/TextView;

    .line 245
    const v0, 0x7f0800de

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/ui/FadeImageButton;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->share:Lcom/livemixtapes/ui/FadeImageButton;

    .line 246
    const v0, 0x7f0800df

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/ui/FadeImageButton;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->download:Lcom/livemixtapes/ui/FadeImageButton;

    .line 247
    const v0, 0x7f0800e2

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/ui/FadeImageButton;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    .line 248
    const v0, 0x7f0800e3

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/ui/FadeImageButton;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->previous:Lcom/livemixtapes/ui/FadeImageButton;

    .line 249
    const v0, 0x7f0800e4

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/ui/FadeImageButton;

    iput-object v0, p0, Lcom/livemixtapes/NowPlayingActivity;->next:Lcom/livemixtapes/ui/FadeImageButton;

    .line 250
    const v0, 0x7f0800e0

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/ui/FadeImageButton;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->shuffle:Lcom/livemixtapes/ui/FadeImageButton;

    .line 251
    const v0, 0x7f0800e1

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/ui/FadeImageButton;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->repeat:Lcom/livemixtapes/ui/FadeImageButton;

    .line 253
    sput-boolean v4, Lcom/livemixtapes/NowPlayingActivity;->shuffleStatus:Z

    .line 254
    sput-boolean v5, Lcom/livemixtapes/NowPlayingActivity;->repeatStatus:Z

    .line 256
    const v0, 0x7f0800d5

    invoke-virtual {p0, v0}, Lcom/livemixtapes/NowPlayingActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/livemixtapes/NowPlayingActivity;->mFrameLayout:Landroid/widget/FrameLayout;

    .line 257
    iget-object v0, p0, Lcom/livemixtapes/NowPlayingActivity;->mFrameLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getForeground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 258
    new-instance v0, Lcom/livemixtapes/ImageLoader;

    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 260
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    if-nez v0, :cond_0

    .line 261
    new-instance v0, Lcom/livemixtapes/MediaObserver;

    invoke-direct {v0, p0}, Lcom/livemixtapes/MediaObserver;-><init>(Landroid/app/Activity;)V

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    .line 262
    new-instance v0, Ljava/lang/Thread;

    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 264
    :cond_0
    sget-boolean v0, Lcom/livemixtapes/MainActivity;->firstLoad:Z

    if-eqz v0, :cond_1

    .line 265
    sput-boolean v5, Lcom/livemixtapes/MainActivity;->fromWidget:Z

    .line 266
    sput-boolean v4, Lcom/livemixtapes/MainActivity;->firstLoad:Z

    .line 267
    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->finish()V

    .line 270
    :cond_1
    sget-boolean v0, Lcom/livemixtapes/MainActivity;->fromWidget:Z

    if-eqz v0, :cond_2

    .line 271
    sput-boolean v4, Lcom/livemixtapes/MainActivity;->fromWidget:Z

    .line 281
    :cond_2
    invoke-static {v4}, Lcom/livemixtapes/NowPlayingActivity;->reloadData(Z)V

    .line 291
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->share:Lcom/livemixtapes/ui/FadeImageButton;

    new-instance v1, Lcom/livemixtapes/NowPlayingActivity$1;

    invoke-direct {v1, p0}, Lcom/livemixtapes/NowPlayingActivity$1;-><init>(Lcom/livemixtapes/NowPlayingActivity;)V

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 302
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->observer:Lcom/livemixtapes/MediaObserver;

    invoke-virtual {v0}, Lcom/livemixtapes/MediaObserver;->unstop()V

    .line 303
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    const v1, 0x7f02008e

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    .line 304
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->playing:Ljava/lang/Boolean;

    .line 305
    invoke-direct {p0}, Lcom/livemixtapes/NowPlayingActivity;->setListeners()V

    .line 306
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 311
    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 312
    .local v0, "inflater":Landroid/view/MenuInflater;
    const v1, 0x7f100001

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 313
    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    const-string v2, "Now Playing"

    invoke-virtual {v1, v2}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 314
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v1

    return v1
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 320
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 327
    invoke-super {p0, p1}, Landroid/app/Activity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 323
    :pswitch_0
    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->finish()V

    .line 324
    const/4 v0, 0x1

    goto :goto_0

    .line 320
    nop

    :pswitch_data_0
    .packed-switch 0x7f08013d
        :pswitch_0
    .end packed-switch
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 72
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 74
    const-string v3, "LOGGING NOW PLAYING ACTIVITY"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 75
    invoke-virtual {p0}, Lcom/livemixtapes/NowPlayingActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    .line 77
    .local v0, "application":Lcom/livemixtapes/App;
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    .line 78
    const-string v2, "Image~NowPlayingActivity"

    .line 77
    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 80
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    .line 81
    new-instance v2, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v2

    .line 80
    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 82
    return-void
.end method
