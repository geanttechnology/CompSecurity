.class public Lcom/xfinity/playerlib/model/LiveStreamFavorite;
.super Lcom/xfinity/playerlib/model/Favorite;
.source "LiveStreamFavorite.java"


# instance fields
.field private artworkUrl:Ljava/lang/String;

.field private streamId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 3
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 10
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isAdultContent()Z

    move-result v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getCreatedTime()Ljava/util/Date;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/xfinity/playerlib/model/Favorite;-><init>(Ljava/lang/String;ZLjava/util/Date;)V

    .line 11
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->streamId:Ljava/lang/String;

    .line 12
    iget-object v0, p1, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->artworkUrl:Ljava/lang/String;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->artworkUrl:Ljava/lang/String;

    .line 13
    return-void
.end method


# virtual methods
.method public getArtworkUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->artworkUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getStreamId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->streamId:Ljava/lang/String;

    return-object v0
.end method
