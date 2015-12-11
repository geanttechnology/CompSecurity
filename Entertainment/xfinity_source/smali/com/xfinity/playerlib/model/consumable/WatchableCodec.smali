.class public Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
.super Ljava/lang/Object;
.source "WatchableCodec.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    return-void
.end method


# virtual methods
.method public decode(Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 16
    .param p1, "encodedWatchable"    # Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    .prologue
    .line 25
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v3

    .line 26
    .local v3, "key":Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    .line 27
    .local v4, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getVideoId()J

    move-result-wide v8

    .line 29
    .local v8, "videoId":J
    invoke-virtual/range {p1 .. p1}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;->getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v0

    .line 30
    .local v0, "backingEntity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    iget-object v5, v0, Lcom/comcast/cim/cmasl/utils/container/Either;->e1:Ljava/lang/Object;

    check-cast v5, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .line 31
    .local v5, "movieEntity":Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    iget-object v6, v0, Lcom/comcast/cim/cmasl/utils/container/Either;->e2:Ljava/lang/Object;

    check-cast v6, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 34
    .local v6, "tvSeriesEntity":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v2

    .line 35
    .local v2, "idNamespace":Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    sget-object v10, Lcom/xfinity/playerlib/model/consumable/WatchableCodec$1;->$SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace:[I

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->ordinal()I

    move-result v11

    aget v10, v10, v11

    packed-switch v10, :pswitch_data_0

    .line 49
    new-instance v10, Ljava/lang/IllegalStateException;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Unexpected parent Merlin ID namespace: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 37
    :pswitch_0
    new-instance v7, Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-direct {v7, v5}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)V

    .line 51
    .local v7, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :goto_0
    return-object v7

    .line 40
    .end local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :pswitch_1
    invoke-virtual {v6, v8, v9}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->findEpisodeByVideoId(J)Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    move-result-object v1

    .line 41
    .local v1, "episodeEntity":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    if-eqz v1, :cond_0

    .line 42
    new-instance v7, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    invoke-direct {v7, v1, v6}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V

    .restart local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    goto :goto_0

    .line 45
    .end local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_0
    new-instance v10, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    sget-object v11, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v12, "Couldn\'t find video id %s in series with id %s"

    const/4 v13, 0x2

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v15

    aput-object v15, v13, v14

    const/4 v14, 0x1

    aput-object v4, v13, v14

    invoke-static {v11, v12, v13}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 35
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public encode(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
    .locals 3
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 19
    new-instance v1, Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-direct {v1, p1, p2}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;-><init>(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 20
    .local v1, "key":Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v0

    .line 21
    .local v0, "backingEntity":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    invoke-direct {v2, v1, v0}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/comcast/cim/cmasl/utils/container/Either;)V

    return-object v2
.end method
