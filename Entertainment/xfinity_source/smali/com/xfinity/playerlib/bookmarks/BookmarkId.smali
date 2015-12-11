.class public Lcom/xfinity/playerlib/bookmarks/BookmarkId;
.super Ljava/lang/Object;
.source "BookmarkId.java"


# instance fields
.field private final companyId:J

.field private final networkId:J

.field private final programId:Lcom/xfinity/playerlib/model/MerlinId;

.field private videoId:J


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/MerlinId;JJJ)V
    .locals 0
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "networkId"    # J
    .param p4, "companyId"    # J
    .param p6, "videoId"    # J

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 16
    iput-object p1, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 17
    iput-wide p2, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->networkId:J

    .line 18
    iput-wide p4, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->companyId:J

    .line 19
    iput-wide p6, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->videoId:J

    .line 20
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 8
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 23
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getNetworkId()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v4

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v6

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lcom/xfinity/playerlib/bookmarks/BookmarkId;-><init>(Lcom/xfinity/playerlib/model/MerlinId;JJJ)V

    .line 24
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 40
    if-ne p0, p1, :cond_1

    .line 59
    :cond_0
    :goto_0
    return v1

    .line 43
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 44
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 47
    check-cast v0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;

    .line 49
    .local v0, "that":Lcom/xfinity/playerlib/bookmarks/BookmarkId;
    iget-wide v4, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->companyId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->companyId:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_4

    move v1, v2

    .line 50
    goto :goto_0

    .line 52
    :cond_4
    iget-wide v4, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->videoId:J

    iget-wide v6, v0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->videoId:J

    cmp-long v3, v4, v6

    if-eqz v3, :cond_5

    move v1, v2

    .line 53
    goto :goto_0

    .line 55
    :cond_5
    iget-object v3, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v4, v0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 56
    goto :goto_0
.end method

.method public getCompanyId()J
    .locals 2

    .prologue
    .line 35
    iget-wide v0, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->companyId:J

    return-wide v0
.end method

.method public getNetworkId()J
    .locals 2

    .prologue
    .line 31
    iget-wide v0, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->networkId:J

    return-wide v0
.end method

.method public getProgramId()Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method public getVideoId()J
    .locals 2

    .prologue
    .line 80
    iget-wide v0, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->videoId:J

    return-wide v0
.end method

.method public hashCode()I
    .locals 7

    .prologue
    const/16 v6, 0x20

    .line 64
    iget-wide v2, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->companyId:J

    iget-wide v4, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->companyId:J

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v0, v2

    .line 65
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->hashCode()I

    move-result v2

    add-int v0, v1, v2

    .line 66
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->videoId:J

    iget-wide v4, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->videoId:J

    ushr-long/2addr v4, v6

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 67
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 72
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "BookmarkId{companyId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->companyId:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", programId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->programId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", videoId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v2, p0, Lcom/xfinity/playerlib/bookmarks/BookmarkId;->videoId:J

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
