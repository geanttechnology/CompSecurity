.class public interface abstract Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
.super Ljava/lang/Object;
.source "LiveStreamBookmarkDAO.java"


# virtual methods
.method public abstract addFavorite(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
.end method

.method public abstract deleteFavorite(Ljava/lang/String;)Z
.end method

.method public abstract getBookmarks()Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getFavorites()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
.end method

.method public abstract getOrCreateBookmarkWithLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Z)Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
.end method

.method public abstract getRecentBookmarks()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation
.end method

.method public abstract removeHistoryItem(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z
.end method

.method public abstract saveBookmark(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;Z)Z
.end method
