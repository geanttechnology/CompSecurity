.class public abstract Lcom/xfinity/playerlib/bookmarks/Bookmark;
.super Ljava/lang/Object;
.source "Bookmark.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field public companyId:J

.field protected duration:I

.field protected expirationDate:Ljava/util/Date;

.field public networkId:J

.field protected position:I

.field protected timestamp:Ljava/util/Date;

.field protected title:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, -0x1

    const/4 v0, 0x0

    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->title:Ljava/lang/String;

    .line 15
    iput v1, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->position:I

    .line 16
    iput v1, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->duration:I

    .line 17
    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->expirationDate:Ljava/util/Date;

    .line 18
    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->timestamp:Ljava/util/Date;

    return-void
.end method


# virtual methods
.method public getCompanyId()J
    .locals 2

    .prologue
    .line 25
    iget-wide v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->companyId:J

    return-wide v0
.end method

.method public getDuration()I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->duration:I

    return v0
.end method

.method public getExpirationDate()Ljava/util/Date;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->expirationDate:Ljava/util/Date;

    return-object v0
.end method

.method public getNetworkId()J
    .locals 2

    .prologue
    .line 21
    iget-wide v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->networkId:J

    return-wide v0
.end method

.method public getPercentWatched()I
    .locals 4

    .prologue
    .line 66
    iget v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->duration:I

    if-nez v0, :cond_0

    .line 67
    const/4 v0, 0x0

    .line 70
    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->position:I

    int-to-double v0, v0

    iget v2, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->duration:I

    int-to-double v2, v2

    div-double/2addr v0, v2

    const-wide/high16 v2, 0x4059000000000000L    # 100.0

    mul-double/2addr v0, v2

    double-to-int v0, v0

    goto :goto_0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 33
    iget v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->position:I

    return v0
.end method

.method public getTimestamp()Ljava/util/Date;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->timestamp:Ljava/util/Date;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->title:Ljava/lang/String;

    return-object v0
.end method

.method public isFinished()Z
    .locals 6

    .prologue
    .line 49
    iget v0, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->position:I

    int-to-double v0, v0

    const-wide v2, 0x3fef5c28f5c28f5cL    # 0.98

    iget v4, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->duration:I

    int-to-double v4, v4

    mul-double/2addr v2, v4

    cmpl-double v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setDuration(I)V
    .locals 0
    .param p1, "duration"    # I

    .prologue
    .line 41
    iput p1, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->duration:I

    .line 42
    return-void
.end method

.method public setPosition(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 37
    iput p1, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->position:I

    .line 38
    return-void
.end method

.method public setTimestamp(Ljava/util/Date;)V
    .locals 0
    .param p1, "timestamp"    # Ljava/util/Date;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/xfinity/playerlib/bookmarks/Bookmark;->timestamp:Ljava/util/Date;

    .line 62
    return-void
.end method
