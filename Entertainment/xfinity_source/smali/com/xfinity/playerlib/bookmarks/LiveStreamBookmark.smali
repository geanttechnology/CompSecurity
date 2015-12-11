.class public Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
.super Lcom/xfinity/playerlib/bookmarks/Bookmark;
.source "LiveStreamBookmark.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field public artworkUrl:Ljava/lang/String;

.field protected createdTime:Ljava/util/Date;

.field public isAdultContent:Z

.field public isFavorite:Z

.field public streamId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    const-class v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/xfinity/playerlib/bookmarks/Bookmark;-><init>()V

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->createdTime:Ljava/util/Date;

    return-void
.end method


# virtual methods
.method public getArtworkUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->artworkUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getCreatedTime()Ljava/util/Date;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->createdTime:Ljava/util/Date;

    return-object v0
.end method

.method public getStreamId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->streamId:Ljava/lang/String;

    return-object v0
.end method

.method public isAdultContent()Z
    .locals 1

    .prologue
    .line 34
    iget-boolean v0, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isAdultContent:Z

    return v0
.end method

.method public isFavorite()Z
    .locals 1

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isFavorite:Z

    return v0
.end method

.method public setAdultContent(Z)V
    .locals 0
    .param p1, "adultContent"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isAdultContent:Z

    .line 39
    return-void
.end method

.method public setCreatedTime(Ljava/util/Date;)V
    .locals 0
    .param p1, "createdTime"    # Ljava/util/Date;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->createdTime:Ljava/util/Date;

    .line 47
    return-void
.end method

.method public setIsFavorite(Z)V
    .locals 0
    .param p1, "isFavorite"    # Z

    .prologue
    .line 26
    iput-boolean p1, p0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isFavorite:Z

    .line 27
    return-void
.end method
