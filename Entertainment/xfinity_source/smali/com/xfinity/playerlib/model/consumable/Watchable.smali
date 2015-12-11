.class public interface abstract Lcom/xfinity/playerlib/model/consumable/Watchable;
.super Ljava/lang/Object;
.source "Watchable.java"

# interfaces
.implements Ljava/io/Serializable;


# virtual methods
.method public abstract findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;
.end method

.method public abstract getBackingEntity()Lcom/comcast/cim/cmasl/utils/container/Either;
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
.end method

.method public abstract getCast()Ljava/lang/String;
.end method

.method public abstract getDescription()Ljava/lang/String;
.end method

.method public abstract getDisplayTitle()Ljava/lang/String;
.end method

.method public abstract getEntityDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;
.end method

.method public abstract getExpiresDate()Ljava/util/Date;
.end method

.method public abstract getLanguageCodes()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
.end method

.method public abstract getNextItemDisplayTitle()Ljava/lang/String;
.end method

.method public abstract getNextVideoItem(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)Lcom/comcast/cim/cmasl/utils/container/Tuple;
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
.end method

.method public abstract getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
.end method

.method public abstract getPlaybackDeeplinkUri(Ljava/lang/String;)Landroid/net/Uri;
.end method

.method public abstract getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
.end method

.method public abstract getSortTitle()Ljava/lang/String;
.end method

.method public abstract getTitle()Ljava/lang/String;
.end method

.method public abstract getVideoRating()Lcom/comcast/cim/model/Rating;
.end method

.method public abstract getVideoSubRatings()Ljava/lang/String;
.end method

.method public abstract getVideos()Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;"
        }
    .end annotation
.end method

.method public abstract hasDownloadableVideo()Z
.end method

.method public abstract isNew()Z
.end method
