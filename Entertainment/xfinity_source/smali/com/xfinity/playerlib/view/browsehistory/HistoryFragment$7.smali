.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;
.super Ljava/lang/Object;
.source "HistoryFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


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

.field final synthetic val$liveStreamPlayOrResumePressedListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 225
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;->val$liveStreamPlayOrResumePressedListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;->val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 228
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;->val$liveStreamPlayOrResumePressedListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;->val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;->onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V

    .line 229
    return-void
.end method
