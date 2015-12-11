.class public Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;
.super Ljava/lang/Object;
.source "PlayNowLaunchIntentInterceptor.java"

# interfaces
.implements Lcom/comcast/cim/android/view/launch/LaunchIntentInterceptor;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final context:Landroid/content/Context;

.field private final launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

.field private final scheme:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-class v0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/comcast/cim/android/view/launch/LaunchStrategy;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "launchStrategy"    # Lcom/comcast/cim/android/view/launch/LaunchStrategy;
    .param p3, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p4, "deepLinkingScheme"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput-object p1, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    .line 55
    iput-object p2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    .line 56
    iput-object p3, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 57
    iput-object p4, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->scheme:Ljava/lang/String;

    .line 58
    return-void
.end method

.method private cancelNotificationIfRequested(Landroid/content/Intent;)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/high16 v4, -0x80000000

    .line 102
    const-string v3, "EXTRA_NOTIFICATION_ID_TO_CANCEL"

    invoke-virtual {p1, v3, v4}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    .line 103
    .local v0, "intentNotificationIdExtra":I
    const-string v3, "EXTRA_NOTIFICATION_TAG_TO_CANCEL"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 104
    .local v1, "intentNotificationTagExtra":Ljava/lang/String;
    if-eq v0, v4, :cond_0

    if-eqz v1, :cond_0

    .line 105
    iget-object v3, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-string v4, "notification"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/NotificationManager;

    .line 106
    .local v2, "notificationManager":Landroid/app/NotificationManager;
    invoke-virtual {v2, v1, v0}, Landroid/app/NotificationManager;->cancel(Ljava/lang/String;I)V

    .line 108
    .end local v2    # "notificationManager":Landroid/app/NotificationManager;
    :cond_0
    return-void
.end method

.method private createDefaultScreenState()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 411
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->launchStrategy:Lcom/comcast/cim/android/view/launch/LaunchStrategy;

    invoke-virtual {v2}, Lcom/comcast/cim/android/view/launch/LaunchStrategy;->getDefaultActivityClass()Ljava/lang/Class;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    return-object v0
.end method

.method private createEntityTargetStates(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JZJ)Ljava/util/List;
    .locals 2
    .param p1, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p3, "networkId"    # J
    .param p5, "startPlayback"    # Z
    .param p6, "startPlaybackTimeInMillis"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "JZJ)",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 286
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    .line 288
    .local v0, "namespace":Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 289
    invoke-direct {p0, p2, p5, p6, p7}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createMovieStack(Lcom/xfinity/playerlib/model/MerlinId;ZJ)Ljava/util/List;

    move-result-object v1

    .line 293
    :goto_0
    return-object v1

    .line 290
    :cond_0
    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 291
    invoke-direct/range {p0 .. p7}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createEpisodeStack(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JZJ)Ljava/util/List;

    move-result-object v1

    goto :goto_0

    .line 293
    :cond_1
    invoke-direct {p0, p2, p5, p6, p7}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createSeriesStack(Lcom/xfinity/playerlib/model/MerlinId;ZJ)Ljava/util/List;

    move-result-object v1

    goto :goto_0
.end method

.method private createEpisodeStack(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JZJ)Ljava/util/List;
    .locals 9
    .param p1, "seriesId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "episodeId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p3, "companyId"    # J
    .param p5, "startPlayback"    # Z
    .param p6, "playbackStartTimeInMillis"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "JZJ)",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 367
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v8

    .line 369
    .local v8, "states":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    if-eqz p5, :cond_0

    .line 370
    new-instance v7, Landroid/content/Intent;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .local v7, "intent":Landroid/content/Intent;
    move-object v0, p2

    move-object v1, p1

    move-wide v2, p3

    move-wide v4, p6

    .line 371
    invoke-static/range {v0 .. v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundle(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JJ)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 372
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 393
    :goto_0
    return-object v8

    .line 375
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v0

    if-nez v0, :cond_1

    .line 376
    new-instance v7, Landroid/content/Intent;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v1, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 377
    .restart local v7    # "intent":Landroid/content/Intent;
    new-instance v6, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v6}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    .line 378
    .local v6, "instanceState":Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;
    invoke-virtual {v6, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 379
    invoke-virtual {v6, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 380
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v6, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 381
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 383
    .end local v6    # "instanceState":Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createDefaultScreenState()Landroid/content/Intent;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 385
    new-instance v7, Landroid/content/Intent;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v1, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 386
    .restart local v7    # "intent":Landroid/content/Intent;
    new-instance v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    invoke-direct {v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;-><init>()V

    .line 387
    .local v6, "instanceState":Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;
    invoke-virtual {v6, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 388
    invoke-virtual {v6, p2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->setEpisodeId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 389
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v6, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 390
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private createLiveStreamPlaybackStack(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 4
    .param p1, "streamName"    # Ljava/lang/String;
    .param p2, "eventId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 397
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 399
    .local v1, "states":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 400
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p2, :cond_0

    .line 401
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 405
    :goto_0
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 407
    return-object v1

    .line 403
    :cond_0
    invoke-static {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    goto :goto_0
.end method

.method private createLiveStreamTargetStates(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "streamName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 298
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createLiveStreamPlaybackStack(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private createLiveStreamTargetStates(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "streamName"    # Ljava/lang/String;
    .param p2, "eventId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 302
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createLiveStreamPlaybackStack(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private createMovieStack(Lcom/xfinity/playerlib/model/MerlinId;ZJ)Ljava/util/List;
    .locals 9
    .param p1, "movieId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "startPlayback"    # Z
    .param p3, "playbackStartTimeInMillis"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "ZJ)",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .prologue
    .line 346
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v8

    .line 348
    .local v8, "states":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    if-eqz p2, :cond_0

    .line 349
    new-instance v7, Landroid/content/Intent;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 350
    .local v7, "intent":Landroid/content/Intent;
    const-wide/16 v2, 0x0

    move-object v0, p1

    move-object v1, p1

    move-wide v4, p3

    invoke-static/range {v0 .. v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundle(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JJ)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 351
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 363
    :goto_0
    return-object v8

    .line 354
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 355
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createDefaultScreenState()Landroid/content/Intent;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 357
    :cond_1
    new-instance v7, Landroid/content/Intent;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v1, Lcom/xfinity/playerlib/view/programdetails/MovieDetailActivity;

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 358
    .restart local v7    # "intent":Landroid/content/Intent;
    new-instance v6, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v6}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    .line 359
    .local v6, "instanceState":Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;
    invoke-virtual {v6, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->setMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 360
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v6, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 361
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private createSeriesStack(Lcom/xfinity/playerlib/model/MerlinId;ZJ)Ljava/util/List;
    .locals 9
    .param p1, "seriesId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "startPlayback"    # Z
    .param p3, "playbackStartTimeInMillis"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "ZJ)",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 325
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v8

    .line 327
    .local v8, "states":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    if-eqz p2, :cond_0

    .line 328
    new-instance v7, Landroid/content/Intent;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 329
    .local v7, "intent":Landroid/content/Intent;
    const-wide/16 v2, 0x0

    move-object v0, p1

    move-object v1, p1

    move-wide v4, p3

    invoke-static/range {v0 .. v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundle(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JJ)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 330
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 342
    :goto_0
    return-object v8

    .line 332
    .end local v7    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 333
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createDefaultScreenState()Landroid/content/Intent;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 335
    :cond_1
    new-instance v7, Landroid/content/Intent;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v1, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-direct {v7, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 336
    .restart local v7    # "intent":Landroid/content/Intent;
    new-instance v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    invoke-direct {v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;-><init>()V

    .line 337
    .local v6, "instanceState":Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;
    invoke-virtual {v6, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->setSeriesId(Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 338
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    invoke-virtual {v6, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 339
    invoke-interface {v8, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private createTargetStates(Landroid/net/Uri;)Ljava/util/List;
    .locals 26
    .param p1, "data"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 174
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v21

    .line 175
    .local v21, "scheme":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v16

    .line 176
    .local v16, "host":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v19

    .line 178
    .local v19, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string v2, "entity"

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "playback"

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    const-string v2, "xfinitytv.comcast.net"

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 179
    :cond_0
    const/4 v7, 0x0

    .line 180
    .local v7, "startPlayback":Z
    const/16 v22, 0x0

    .line 182
    .local v22, "startPlaybackTimeInMillis":I
    const-string v2, "playback"

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 183
    const/4 v7, 0x1

    .line 186
    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getFragment()Ljava/lang/String;

    move-result-object v14

    .line 187
    .local v14, "fragment":Ljava/lang/String;
    if-eqz v14, :cond_1

    .line 189
    :try_start_0
    const-string v2, "="

    invoke-virtual {v14, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v15

    .line 190
    .local v15, "fragmentParts":[Ljava/lang/String;
    array-length v2, v15

    const/4 v8, 0x2

    if-ne v2, v8, :cond_1

    const/4 v2, 0x0

    aget-object v2, v15, v2

    const-string v8, "t"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 191
    const/4 v2, 0x1

    aget-object v2, v15, v2

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->parseTimeStringToMillis(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v22

    .line 201
    .end local v14    # "fragment":Ljava/lang/String;
    .end local v15    # "fragmentParts":[Ljava/lang/String;
    :cond_1
    :goto_0
    const/4 v3, 0x0

    .line 202
    .local v3, "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    const/4 v4, 0x0

    .line 204
    .local v4, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    const-wide/16 v5, 0x0

    .line 207
    .local v5, "networkId":J
    const-string v2, "xfinitytvplaynow"

    move-object/from16 v0, v21

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 208
    new-instance v3, Lcom/xfinity/playerlib/model/MerlinId;

    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    const/4 v2, 0x0

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {v3, v2}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Ljava/lang/String;)V

    .line 210
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    sget-object v2, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor$1;->$SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace:[I

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v8

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->ordinal()I

    move-result v8

    aget v2, v2, v8

    packed-switch v2, :pswitch_data_0

    .line 222
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Was not expecting "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v2, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 194
    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v5    # "networkId":J
    .restart local v14    # "fragment":Ljava/lang/String;
    :catch_0
    move-exception v10

    .line 195
    .local v10, "e":Ljava/lang/IllegalArgumentException;
    sget-object v2, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    const-string v8, "Failed to parse the time from the playback deeplink"

    invoke-interface {v2, v8, v10}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 212
    .end local v10    # "e":Ljava/lang/IllegalArgumentException;
    .end local v14    # "fragment":Ljava/lang/String;
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v5    # "networkId":J
    :pswitch_0
    move-object v4, v3

    .line 225
    :goto_1
    move/from16 v0, v22

    int-to-long v8, v0

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v9}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createEntityTargetStates(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JZJ)Ljava/util/List;

    move-result-object v2

    .line 281
    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v5    # "networkId":J
    .end local v7    # "startPlayback":Z
    .end local v22    # "startPlaybackTimeInMillis":I
    :goto_2
    return-object v2

    .line 215
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v5    # "networkId":J
    .restart local v7    # "startPlayback":Z
    .restart local v22    # "startPlaybackTimeInMillis":I
    :pswitch_1
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->size()I

    move-result v2

    const/4 v8, 0x1

    if-le v2, v8, :cond_2

    .line 216
    new-instance v4, Lcom/xfinity/playerlib/model/MerlinId;

    .end local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    const/4 v2, 0x1

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {v4, v2}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Ljava/lang/String;)V

    .restart local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    goto :goto_1

    .line 218
    :cond_2
    move-object v4, v3

    .line 220
    goto :goto_1

    .line 226
    :cond_3
    const-string v2, "http"

    move-object/from16 v0, v21

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 228
    :try_start_1
    const-string v2, "programId"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v20

    .line 229
    .local v20, "programId":Ljava/lang/Long;
    const-string v2, "episodeId"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 230
    .local v12, "episodeIdString":Ljava/lang/String;
    if-eqz v12, :cond_4

    .line 231
    invoke-static {v12}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    .line 232
    .local v11, "episodeId":Ljava/lang/Long;
    new-instance v18, Lcom/xfinity/playerlib/model/MerlinId;

    sget-object v2, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-direct {v0, v2, v1}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    .line 233
    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .local v18, "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :try_start_2
    new-instance v4, Lcom/xfinity/playerlib/model/MerlinId;

    .end local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    sget-object v2, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-direct {v4, v2, v11}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V
    :try_end_2
    .catch Ljava/lang/NumberFormatException; {:try_start_2 .. :try_end_2} :catch_2

    .restart local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    move-object/from16 v3, v18

    .line 242
    .end local v11    # "episodeId":Ljava/lang/Long;
    .end local v18    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :goto_3
    move/from16 v0, v22

    int-to-long v8, v0

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v9}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createEntityTargetStates(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JZJ)Ljava/util/List;

    move-result-object v2

    goto :goto_2

    .line 235
    :cond_4
    :try_start_3
    new-instance v18, Lcom/xfinity/playerlib/model/MerlinId;

    sget-object v2, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    invoke-direct {v0, v2, v1}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V
    :try_end_3
    .catch Ljava/lang/NumberFormatException; {:try_start_3 .. :try_end_3} :catch_1

    .line 236
    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v18    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    move-object/from16 v4, v18

    move-object/from16 v3, v18

    .end local v18    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    goto :goto_3

    .line 238
    .end local v12    # "episodeIdString":Ljava/lang/String;
    .end local v20    # "programId":Ljava/lang/Long;
    :catch_1
    move-exception v10

    .line 239
    .end local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .local v10, "e":Ljava/lang/NumberFormatException;
    :goto_4
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Invalid web link path: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v2, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 244
    .end local v10    # "e":Ljava/lang/NumberFormatException;
    .restart local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :cond_5
    const/4 v2, 0x0

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v8, "0"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 245
    new-instance v3, Lcom/xfinity/playerlib/model/MerlinId;

    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    sget-object v8, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    const/4 v2, 0x1

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v24

    invoke-static/range {v24 .. v25}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {v3, v8, v2}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    .line 247
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->size()I

    move-result v2

    const/4 v8, 0x3

    if-lt v2, v8, :cond_7

    .line 248
    new-instance v4, Lcom/xfinity/playerlib/model/MerlinId;

    .end local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    sget-object v8, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    const/4 v2, 0x2

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v24

    invoke-static/range {v24 .. v25}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {v4, v8, v2}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    .line 250
    .restart local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->size()I

    move-result v2

    const/4 v8, 0x3

    if-le v2, v8, :cond_6

    .line 251
    const/4 v2, 0x3

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v5

    .line 257
    :cond_6
    :goto_5
    move/from16 v0, v22

    int-to-long v8, v0

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v9}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createEntityTargetStates(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JZJ)Ljava/util/List;

    move-result-object v2

    goto/16 :goto_2

    .line 254
    :cond_7
    move-object v4, v3

    goto :goto_5

    .line 258
    :cond_8
    const/4 v2, 0x0

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v8, "1"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 259
    new-instance v3, Lcom/xfinity/playerlib/model/MerlinId;

    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    sget-object v8, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    const/4 v2, 0x1

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v24

    invoke-static/range {v24 .. v25}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {v3, v8, v2}, Lcom/xfinity/playerlib/model/MerlinId;-><init>(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Ljava/lang/Long;)V

    .line 260
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    move-object v4, v3

    .line 262
    move/from16 v0, v22

    int-to-long v8, v0

    move-object/from16 v2, p0

    invoke-direct/range {v2 .. v9}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createEntityTargetStates(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JZJ)Ljava/util/List;

    move-result-object v2

    goto/16 :goto_2

    .line 263
    :cond_9
    const/4 v2, 0x0

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v8, "2"

    invoke-virtual {v2, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 264
    const/4 v2, 0x1

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/String;

    .line 265
    .local v17, "liveStreamName":Ljava/lang/String;
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->size()I

    move-result v2

    const/4 v8, 0x2

    if-ne v2, v8, :cond_a

    .line 266
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createLiveStreamTargetStates(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    goto/16 :goto_2

    .line 267
    :cond_a
    invoke-interface/range {v19 .. v19}, Ljava/util/List;->size()I

    move-result v2

    const/4 v8, 0x3

    if-ne v2, v8, :cond_d

    .line 268
    const/4 v2, 0x2

    move-object/from16 v0, v19

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 269
    .local v13, "eventId":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1, v13}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createLiveStreamTargetStates(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    goto/16 :goto_2

    .line 272
    .end local v13    # "eventId":Ljava/lang/String;
    .end local v17    # "liveStreamName":Ljava/lang/String;
    :cond_b
    new-instance v2, Ljava/lang/IllegalArgumentException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Invalid path: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual/range {p1 .. p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v2, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 275
    .end local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v4    # "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .end local v5    # "networkId":J
    .end local v7    # "startPlayback":Z
    .end local v22    # "startPlaybackTimeInMillis":I
    :cond_c
    const-string v2, "discovery"

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 277
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createTopLevelScreenStack(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    goto/16 :goto_2

    .line 281
    :cond_d
    const/4 v2, 0x0

    goto/16 :goto_2

    .line 238
    .restart local v5    # "networkId":J
    .restart local v7    # "startPlayback":Z
    .restart local v11    # "episodeId":Ljava/lang/Long;
    .restart local v12    # "episodeIdString":Ljava/lang/String;
    .restart local v18    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v20    # "programId":Ljava/lang/Long;
    .restart local v22    # "startPlaybackTimeInMillis":I
    :catch_2
    move-exception v10

    move-object/from16 v3, v18

    .end local v18    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    .restart local v3    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    goto/16 :goto_4

    .line 210
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private createTopLevelScreenStack(Ljava/util/List;)Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .prologue
    .local p1, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 418
    invoke-interface {p1, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 420
    .local v1, "screen":Ljava/lang/String;
    const-string v2, "featured"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 421
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/featured/FeaturedActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 460
    .local v0, "browseState":Landroid/content/Intent;
    :cond_0
    :goto_0
    new-array v2, v4, [Landroid/content/Intent;

    aput-object v0, v2, v5

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v2

    return-object v2

    .line 423
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_1
    const-string v2, "networks"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 424
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/browsenetworks/NetworksActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto :goto_0

    .line 426
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_2
    const-string v2, "movies"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 427
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/browseprograms/MoviesActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto :goto_0

    .line 429
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_3
    const-string v2, "tv"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 430
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/browseprograms/SeriesActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto :goto_0

    .line 432
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_4
    const-string v2, "live"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 433
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto :goto_0

    .line 435
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_5
    const-string v2, "downloads"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 436
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/downloads/DownloadsActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto :goto_0

    .line 438
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_6
    const-string v2, "flagged"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 439
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/favorite/BookmarksActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto :goto_0

    .line 441
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_7
    const-string v2, "history"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 442
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/browsehistory/HistoryActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto/16 :goto_0

    .line 444
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_8
    const-string v2, "search"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 446
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createDefaultScreenState()Landroid/content/Intent;

    move-result-object v0

    .restart local v0    # "browseState":Landroid/content/Intent;
    goto/16 :goto_0

    .line 447
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_9
    const-string v2, "settings"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 449
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->context:Landroid/content/Context;

    const-class v3, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 450
    .restart local v0    # "browseState":Landroid/content/Intent;
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-le v2, v4, :cond_a

    invoke-interface {p1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v3, "dm"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 451
    const-string v2, "resource"

    const-string v3, "manage_devices_prefs"

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 452
    :cond_a
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-le v2, v4, :cond_0

    invoke-interface {p1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v3, "cd"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 453
    const-string v2, "resource"

    const-string v3, "use_cellular_prefs"

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 457
    .end local v0    # "browseState":Landroid/content/Intent;
    :cond_b
    new-instance v2, Ljava/lang/IllegalArgumentException;

    invoke-direct {v2}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v2
.end method

.method private isInputValid(Landroid/content/Intent;)Z
    .locals 11
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v10, 0x4

    const/4 v5, 0x1

    const/4 v9, 0x2

    const/4 v4, 0x0

    .line 112
    if-nez p1, :cond_1

    .line 113
    sget-object v5, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    const-string v6, "intent is null; returning false"

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 170
    :cond_0
    :goto_0
    return v4

    .line 117
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v3

    .line 118
    .local v3, "uri":Landroid/net/Uri;
    sget-object v6, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "uri="

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 120
    if-nez v3, :cond_2

    .line 121
    sget-object v5, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    const-string v6, "uri is null; returning false"

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 125
    :cond_2
    const-string v6, "xfinitytvplaynow"

    invoke-virtual {v3}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    iget-object v6, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->scheme:Ljava/lang/String;

    invoke-virtual {v3}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    const-string v6, "http"

    invoke-virtual {v3}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 126
    sget-object v5, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    const-string v6, "invalid scheme; returning false"

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 131
    :cond_3
    invoke-virtual {v3}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 132
    .local v0, "host":Ljava/lang/String;
    const-string v6, "entity"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    const-string v6, "playback"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    const-string v6, "discovery"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    const-string v6, "xfinitytv.comcast.net"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 134
    sget-object v5, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "invalid host: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 138
    :cond_4
    invoke-virtual {v3}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v1

    .line 140
    .local v1, "pathSegments":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez v1, :cond_5

    .line 141
    sget-object v5, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    const-string v6, "pathSegments is null; returning false"

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 145
    :cond_5
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    .line 147
    .local v2, "pathSegmentsSize":I
    const-string v6, "xfinitytvplaynow"

    invoke-virtual {v3}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 148
    if-eq v2, v5, :cond_7

    if-eq v2, v9, :cond_7

    .line 149
    sget-object v5, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "path size invalid xfinityplaynow scheme"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "; returning false"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 152
    :cond_6
    const-string v6, "http"

    invoke-virtual {v3}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 153
    const-string v6, "xfinitytv.comcast.net"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_7

    if-lt v2, v9, :cond_0

    :cond_7
    :goto_1
    move v4, v5

    .line 170
    goto/16 :goto_0

    .line 158
    :cond_8
    const-string v6, "entity"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    if-lt v2, v9, :cond_0

    if-gt v2, v10, :cond_0

    .line 160
    :cond_9
    const-string v6, "playback"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_a

    if-ge v2, v9, :cond_a

    if-gt v2, v10, :cond_0

    .line 162
    :cond_a
    const-string v6, "discovery"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_b

    if-eq v2, v5, :cond_b

    if-ne v2, v9, :cond_0

    .line 165
    :cond_b
    sget-object v4, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "path size invalid xplay scheme"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "; returning false"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private parseTimeStringToMillis(Ljava/lang/String;)I
    .locals 6
    .param p1, "timeValue"    # Ljava/lang/String;

    .prologue
    .line 308
    const/16 v3, 0x3a

    invoke-static {p1, v3}, Lorg/apache/commons/lang3/StringUtils;->split(Ljava/lang/String;C)[Ljava/lang/String;

    move-result-object v2

    .line 309
    .local v2, "timeSegments":[Ljava/lang/String;
    array-length v3, v2

    const/4 v4, 0x3

    if-eq v3, v4, :cond_0

    .line 310
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unsupported time format: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 314
    :cond_0
    const/4 v3, 0x0

    :try_start_0
    aget-object v3, v2, v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    mul-int/lit16 v1, v3, 0xe10

    .line 315
    .local v1, "seconds":I
    const/4 v3, 0x1

    aget-object v3, v2, v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    mul-int/lit8 v3, v3, 0x3c

    add-int/2addr v1, v3

    .line 316
    const/4 v3, 0x2

    aget-object v3, v2, v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    add-int/2addr v1, v3

    .line 321
    mul-int/lit16 v3, v1, 0x3e8

    return v3

    .line 317
    .end local v1    # "seconds":I
    :catch_0
    move-exception v0

    .line 318
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v3, Ljava/lang/IllegalArgumentException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unsupported time format: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method


# virtual methods
.method getScheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->scheme:Ljava/lang/String;

    return-object v0
.end method

.method public intercept(Landroid/content/Intent;)Ljava/util/List;
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Intent;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/content/Intent;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 83
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->isInputValid(Landroid/content/Intent;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 84
    const/4 v1, 0x0

    .line 98
    :goto_0
    return-object v1

    .line 87
    :cond_0
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->cancelNotificationIfRequested(Landroid/content/Intent;)V

    .line 92
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->createTargetStates(Landroid/net/Uri;)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .local v1, "targetStack":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    goto :goto_0

    .line 93
    .end local v1    # "targetStack":Ljava/util/List;, "Ljava/util/List<Landroid/content/Intent;>;"
    :catch_0
    move-exception v0

    .line 94
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor;->LOG:Lorg/slf4j/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Caught exception creating target intent uri "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 95
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method
