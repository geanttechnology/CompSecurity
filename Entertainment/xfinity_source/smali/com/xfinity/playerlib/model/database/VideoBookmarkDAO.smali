.class public interface abstract Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;
.super Ljava/lang/Object;
.source "VideoBookmarkDAO.java"


# virtual methods
.method public abstract deleteBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Z
.end method

.method public abstract getLastWatchedBookmark()Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
.end method

.method public abstract getOrCreateBookmarkWithVideo(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
.end method

.method public abstract getRecentBookmarks()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;"
        }
    .end annotation
.end method

.method public abstract saveBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
.end method

.method public abstract updateLastTrackedMilestones()V
.end method
