.class public Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;
.super Lcom/xfinity/playerlib/model/consumable/BaseWatchable;
.source "EpisodeFacade.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

.field private seasonEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

.field private seriesSortTitle:Ljava/lang/String;

.field private tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

.field private final videos:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V
    .locals 1
    .param p1, "episodeEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .param p2, "tvSeriesEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;-><init>()V

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seriesSortTitle:Ljava/lang/String;

    .line 40
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    iput-object p2, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 44
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 45
    invoke-virtual {p2, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->findSeasonForEpisode(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;)Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seasonEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 47
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->buildVideosFromSeriesAndEpisode(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    .line 49
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->initFromVideos()V

    .line 50
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 1
    .param p1, "tvSeriesEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    .param p2, "episodeMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;-><init>()V

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seriesSortTitle:Ljava/lang/String;

    .line 53
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 57
    invoke-virtual {p1, p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->findEpisodeByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->findSeasonForEpisode(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;)Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seasonEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-direct {p0, v0, p1}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->buildVideosFromSeriesAndEpisode(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)Ljava/util/Set;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    .line 62
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->initFromVideos()V

    .line 64
    return-void
.end method

.method private buildVideosFromSeriesAndEpisode(Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)Ljava/util/Set;
    .locals 6
    .param p1, "episodeEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    .param p2, "seriesEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ")",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 69
    .local v1, "videos":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getVideos()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;

    .line 70
    .local v0, "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    new-instance v3, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    invoke-direct {v3, v0, v4, v5}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    invoke-interface {v1, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 72
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/hal/HalVideo;
    :cond_0
    return-object v1
.end method

.method private getVideoOnSameNetworkIfAvail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .locals 12
    .param p1, "nextWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p2, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "language"    # Ljava/lang/String;

    .prologue
    .line 235
    invoke-static {p3}, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->getLocaleByLanguageCode(Ljava/lang/String;)Ljava/util/Locale;

    move-result-object v0

    .line 237
    .local v0, "languageCodeIn":Ljava/util/Locale;
    if-nez v0, :cond_0

    .line 238
    const-string v6, "en"

    invoke-static {v6}, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->getLocaleByLanguageCode(Ljava/lang/String;)Ljava/util/Locale;

    move-result-object v0

    .line 241
    :cond_0
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getVideos()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 243
    .local v1, "nextVideoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v7

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v8

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v7

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v10

    cmp-long v7, v8, v10

    if-nez v7, :cond_1

    .line 245
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v5

    .line 246
    .local v5, "videoRating":Lcom/comcast/cim/model/Rating;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v2

    .line 248
    .local v2, "nextVideoRating":Lcom/comcast/cim/model/Rating;
    if-eqz v5, :cond_2

    invoke-virtual {v5, v2}, Lcom/comcast/cim/model/Rating;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_3

    :cond_2
    if-nez v5, :cond_1

    if-nez v2, :cond_1

    .line 255
    :cond_3
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLanguageCodes()Ljava/util/List;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 257
    .local v3, "testLanguageCode":Ljava/lang/String;
    invoke-static {v3}, Lcom/comcast/cim/cmasl/utils/i18n/Iso629Util;->getLocaleByLanguageCode(Ljava/lang/String;)Ljava/util/Locale;

    move-result-object v4

    .line 259
    .local v4, "testLanguageCodeLocale":Ljava/util/Locale;
    invoke-virtual {v0}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v4}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 267
    .end local v1    # "nextVideoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v2    # "nextVideoRating":Lcom/comcast/cim/model/Rating;
    .end local v3    # "testLanguageCode":Ljava/lang/String;
    .end local v4    # "testLanguageCodeLocale":Ljava/util/Locale;
    .end local v5    # "videoRating":Lcom/comcast/cim/model/Rating;
    :goto_0
    return-object v1

    :cond_5
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 272
    if-ne p0, p1, :cond_1

    .line 292
    :cond_0
    :goto_0
    return v1

    .line 275
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 276
    goto :goto_0

    .line 278
    :cond_3
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4

    move v1, v2

    .line 279
    goto :goto_0

    :cond_4
    move-object v0, p1

    .line 281
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    .line 282
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    if-eqz v3, :cond_6

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_7

    :cond_5
    move v1, v2

    .line 283
    goto :goto_0

    .line 282
    :cond_6
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    if-nez v3, :cond_5

    .line 285
    :cond_7
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    if-eqz v3, :cond_9

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    :cond_8
    move v1, v2

    .line 286
    goto :goto_0

    .line 285
    :cond_9
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    if-nez v3, :cond_8

    .line 289
    :cond_a
    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    invoke-interface {v3, v4}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 290
    goto :goto_0

    .line 289
    :cond_b
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Either",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 203
    new-instance v0, Lcom/comcast/cim/cmasl/utils/container/RightEither;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-direct {v0, v1}, Lcom/comcast/cim/cmasl/utils/container/RightEither;-><init>(Ljava/lang/Object;)V

    return-object v0
.end method

.method public getCast()Ljava/lang/String;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->castListAsString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getDescription()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDisplayTitle()Ljava/lang/String;
    .locals 3

    .prologue
    .line 112
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getEpisodeTitle()Ljava/lang/String;

    move-result-object v0

    .line 113
    .local v0, "title":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 114
    :cond_0
    const/4 v1, 0x1

    invoke-static {v1}, Lorg/apache/commons/lang3/time/FastDateFormat;->getDateInstance(I)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 116
    :cond_1
    return-object v0
.end method

.method public getEntityDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p1, "deepLinkingScheme"    # Ljava/lang/String;

    .prologue
    .line 306
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "://entity/0/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public getEpisodeId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getEpisodeNumber()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getEpisodeNumber()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getEpisodeTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 82
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getEpisodeId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    return-object v0
.end method

.method public getNextItemDisplayTitle()Ljava/lang/String;
    .locals 4

    .prologue
    .line 191
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 193
    .local v0, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getSeriesTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ". "

    .line 194
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 195
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSeriesString(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 197
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getNextVideoItem(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 8
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "language"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Ljava/lang/String;",
            ")",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 209
    new-instance v4, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-direct {v4, v6}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V

    .line 211
    .local v4, "tvSeriesFacade":Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    add-int/lit8 v0, v6, -0x1

    .local v0, "i":I
    :goto_0
    if-lez v0, :cond_0

    .line 213
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 215
    .local v3, "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-interface {v3}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 217
    invoke-interface {v3}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    if-gez v6, :cond_1

    .line 230
    .end local v3    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_0
    :goto_1
    return-object v5

    .line 221
    .restart local v3    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_1
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v6

    add-int/lit8 v7, v0, -0x1

    invoke-interface {v6, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 222
    .local v2, "nextWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-direct {p0, v2, p1, p2}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getVideoOnSameNetworkIfAvail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    .line 224
    .local v1, "nextVideoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    if-eqz v1, :cond_2

    .line 225
    new-instance v5, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-direct {v5, v1, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_1

    .line 211
    .end local v1    # "nextVideoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v2    # "nextWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_2
    add-int/lit8 v0, v0, -0x1

    goto :goto_0
.end method

.method public getOriginalAirdate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v0

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    return-object v0
.end method

.method public getPlaybackDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;
    .locals 2
    .param p1, "deepLinkingScheme"    # Ljava/lang/String;

    .prologue
    .line 311
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "://playback/0/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public getSeasonNumber()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seasonEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getSeasonNumber()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    .locals 0

    .prologue
    .line 159
    return-object p0
.end method

.method public getSeriesSortTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seriesSortTitle:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 100
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getSeriesTitle()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSortStringFromTitle(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seriesSortTitle:Ljava/lang/String;

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->seriesSortTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getSeriesTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->getEpisodeTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getVideos()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;"
        }
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 297
    invoke-super {p0}, Lcom/xfinity/playerlib/model/consumable/BaseWatchable;->hashCode()I

    move-result v0

    .line 298
    .local v0, "result":I
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->videos:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->hashCode()I

    move-result v1

    :goto_0
    add-int v0, v3, v1

    .line 299
    mul-int/lit8 v3, v0, 0x1f

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->hashCode()I

    move-result v1

    :goto_1
    add-int v0, v3, v1

    .line 300
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    if-eqz v3, :cond_0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->tvSeriesEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->hashCode()I

    move-result v2

    :cond_0
    add-int v0, v1, v2

    .line 301
    return v0

    :cond_1
    move v1, v2

    .line 298
    goto :goto_0

    :cond_2
    move v1, v2

    .line 299
    goto :goto_1
.end method

.method public isNew()Z
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;->episodeEntity:Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->isNew()Z

    move-result v0

    return v0
.end method
