.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$4;
.super Ljava/lang/Object;
.source "HistoryFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 181
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 184
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 185
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$4;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    invoke-static {v1, v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$700(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    .line 186
    return-void
.end method
