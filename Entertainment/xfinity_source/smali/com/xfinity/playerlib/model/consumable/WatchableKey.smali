.class public Lcom/xfinity/playerlib/model/consumable/WatchableKey;
.super Ljava/lang/Object;
.source "WatchableKey.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field private final parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field private final videoId:J


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/MerlinId;J)V
    .locals 0
    .param p1, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "parentMerlinId"
        .end annotation
    .end param
    .param p2, "videoId"    # J
        .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
            value = "videoId"
        .end annotation
    .end param
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonCreator;
    .end annotation

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 30
    iput-wide p2, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->videoId:J

    .line 31
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 2
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 22
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->videoId:J

    .line 23
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 48
    if-ne p0, p1, :cond_1

    .line 55
    :cond_0
    :goto_0
    return v1

    .line 51
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 52
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 54
    check-cast v0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .line 55
    .local v0, "that":Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->videoId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->videoId:J

    cmp-long v3, v4, v6

    if-nez v3, :cond_4

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v4, v0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0

    :cond_5
    iget-object v3, v0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    if-nez v3, :cond_4

    goto :goto_0
.end method

.method public getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->videoId:J

    return-wide v0
.end method

.method public hashCode()I
    .locals 7

    .prologue
    .line 60
    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId;->hashCode()I

    move-result v0

    .line 61
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->videoId:J

    iget-wide v4, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->videoId:J

    const/16 v6, 0x20

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 62
    return v0

    .line 60
    .end local v0    # "result":I
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isMovie()Z
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 35
    iget-object v0, p0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method
