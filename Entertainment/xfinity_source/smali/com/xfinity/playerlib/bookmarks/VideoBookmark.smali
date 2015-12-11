.class public abstract Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
.super Lcom/xfinity/playerlib/bookmarks/Bookmark;
.source "VideoBookmark.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/Program;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected categories:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;",
            ">;"
        }
    .end annotation
.end field

.field protected episodeNumber:I

.field private id:Lcom/xfinity/playerlib/bookmarks/BookmarkId;

.field protected lastTrackedMilestone:Lcom/xfinity/playerlib/tracking/VideoMilestone;

.field protected merlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field protected parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field protected seasonNumber:I

.field public videoId:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method protected constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    const/4 v1, -0x1

    .line 35
    invoke-direct {p0}, Lcom/xfinity/playerlib/bookmarks/Bookmark;-><init>()V

    .line 26
    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 27
    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 30
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->categories:Ljava/util/List;

    .line 31
    iput v1, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->seasonNumber:I

    .line 32
    iput v1, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->episodeNumber:I

    .line 36
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->categories:Ljava/util/List;

    .line 37
    return-void
.end method


# virtual methods
.method public addCategory(Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;)V
    .locals 1
    .param p1, "category"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->categories:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 76
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->categories:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 78
    :cond_0
    return-void
.end method

.method public getCategories()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark$BookmarkCategory;",
            ">;"
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->categories:Ljava/util/List;

    return-object v0
.end method

.method public getEpisodeNumber()I
    .locals 1

    .prologue
    .line 136
    iget v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->episodeNumber:I

    return v0
.end method

.method public getId()Lcom/xfinity/playerlib/bookmarks/BookmarkId;
    .locals 8

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->id:Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    if-nez v0, :cond_0

    .line 41
    new-instance v0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    iget-object v1, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    iget-wide v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->networkId:J

    iget-wide v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->companyId:J

    iget-wide v6, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->videoId:J

    invoke-direct/range {v0 .. v7}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;-><init>(Lcom/xfinity/playerlib/model/MerlinId;JJJ)V

    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->id:Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    .line 43
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->id:Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    return-object v0
.end method

.method public getLastTrackedMilestone()Lcom/xfinity/playerlib/tracking/VideoMilestone;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->lastTrackedMilestone:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    return-object v0
.end method

.method public getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    return-object v0
.end method

.method public getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getSeasonNumber()I
    .locals 1

    .prologue
    .line 140
    iget v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->seasonNumber:I

    return v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->videoId:J

    return-wide v0
.end method

.method public isMovie()Z
    .locals 2

    .prologue
    .line 48
    invoke-virtual {p0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setLastTrackedMilestone(Lcom/xfinity/playerlib/tracking/VideoMilestone;)V
    .locals 0
    .param p1, "lastTrackedMilestone"    # Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->lastTrackedMilestone:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 149
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 153
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "bookmarkId"

    .line 154
    invoke-virtual {p0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getId()Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "parentMerlinId"

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 155
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "position"

    iget v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->position:I

    .line 156
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;I)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "duration"

    iget v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->duration:I

    .line 157
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;I)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "categories"

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->categories:Ljava/util/List;

    .line 158
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "program type"

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 159
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "expirationDate"

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->expirationDate:Ljava/util/Date;

    .line 160
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "season number"

    iget v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->seasonNumber:I

    .line 161
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;I)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "episode number"

    iget v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->episodeNumber:I

    .line 162
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;I)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "timestamp"

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->timestamp:Ljava/util/Date;

    .line 163
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "lastTrackedMilestone"

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->lastTrackedMilestone:Lcom/xfinity/playerlib/tracking/VideoMilestone;

    .line 164
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 165
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateLegacyNonEpisodeBookmarkWithConsumable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z
    .locals 6
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 121
    const/4 v0, 0x0

    .line 122
    .local v0, "updated":Z
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eq v1, v2, :cond_0

    .line 123
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 124
    const/4 v0, 0x1

    .line 127
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getCompanyId()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v4

    cmp-long v1, v2, v4

    if-eqz v1, :cond_1

    .line 128
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->companyId:J

    .line 129
    const/4 v0, 0x1

    .line 132
    :cond_1
    return v0
.end method

.method public updateWithConsumable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Z
    .locals 8
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 89
    const/4 v1, 0x0

    .line 90
    .local v1, "updated":Z
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 91
    .local v3, "videoTitle":Ljava/lang/String;
    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->title:Ljava/lang/String;

    if-nez v4, :cond_0

    if-nez v3, :cond_2

    :cond_0
    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->title:Ljava/lang/String;

    if-eqz v4, :cond_1

    if-eqz v3, :cond_2

    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->title:Ljava/lang/String;

    if-eqz v4, :cond_3

    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->title:Ljava/lang/String;

    .line 93
    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 94
    :cond_2
    iput-object v3, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->title:Ljava/lang/String;

    .line 95
    const/4 v1, 0x1

    .line 98
    :cond_3
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getExpirationDate()Ljava/util/Date;

    move-result-object v2

    .line 99
    .local v2, "videoDate":Ljava/util/Date;
    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->expirationDate:Ljava/util/Date;

    if-nez v4, :cond_4

    if-nez v2, :cond_6

    :cond_4
    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->expirationDate:Ljava/util/Date;

    if-eqz v4, :cond_5

    if-eqz v2, :cond_6

    :cond_5
    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->expirationDate:Ljava/util/Date;

    if-eqz v4, :cond_7

    iget-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->expirationDate:Ljava/util/Date;

    .line 101
    invoke-virtual {v4, v2}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_7

    .line 102
    :cond_6
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getExpirationDate()Ljava/util/Date;

    move-result-object v4

    iput-object v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->expirationDate:Ljava/util/Date;

    .line 103
    const/4 v1, 0x1

    .line 106
    :cond_7
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v4

    mul-int/lit16 v0, v4, 0x3e8

    .line 107
    .local v0, "duration":I
    iget v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->duration:I

    const/4 v5, -0x1

    if-ne v4, v5, :cond_8

    .line 108
    iput v0, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->duration:I

    .line 109
    const/4 v1, 0x1

    .line 112
    :cond_8
    iget-wide v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->companyId:J

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v6

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v6

    cmp-long v4, v4, v6

    if-eqz v4, :cond_9

    .line 113
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->companyId:J

    .line 114
    const/4 v1, 0x1

    .line 117
    :cond_9
    return v1
.end method
