.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;
.super Ljava/lang/Object;
.source "HistoryFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getItemClickListener()Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 351
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClicked(Lcom/xfinity/playerlib/bookmarks/Bookmark;)V
    .locals 2
    .param p1, "item"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .prologue
    .line 354
    instance-of v0, p1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v0, :cond_0

    .line 355
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$800(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;

    move-result-object v0

    check-cast p1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .end local p1    # "item":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->currentlyPlayingVideoId:Ljava/lang/Long;

    invoke-interface {v0, p1, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;->showDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/Long;)V

    .line 360
    :goto_0
    return-void

    .line 358
    .restart local p1    # "item":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    check-cast p1, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .end local p1    # "item":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    # invokes: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$700(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    goto :goto_0
.end method

.method public bridge synthetic onItemClicked(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 351
    check-cast p1, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;->onItemClicked(Lcom/xfinity/playerlib/bookmarks/Bookmark;)V

    return-void
.end method
