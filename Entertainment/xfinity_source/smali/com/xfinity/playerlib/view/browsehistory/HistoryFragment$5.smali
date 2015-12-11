.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;
.super Ljava/lang/Object;
.source "HistoryFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

.field final synthetic val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 201
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;->val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 204
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 205
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$100(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;->val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->removeHistoryItem(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z

    .line 206
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$400(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/xfinity/playerlib/bookmarks/Bookmark;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;->val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->removeItems(Ljava/util/List;)V

    .line 207
    return-void
.end method
