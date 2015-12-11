.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "HistoryFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 91
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;->execute()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 94
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 95
    .local v1, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$000(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->getRecentBookmarks()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 96
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 99
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$100(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v2

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getRecentBookmarks()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 101
    .restart local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$200(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z

    move-result v2

    if-nez v2, :cond_2

    move-object v2, v0

    check-cast v2, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->isAdultContent()Z

    move-result v2

    if-nez v2, :cond_1

    .line 102
    :cond_2
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 106
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_3
    new-instance v2, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1$1;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;)V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 113
    return-object v1
.end method
