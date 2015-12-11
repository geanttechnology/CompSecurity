.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$5;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;Landroid/widget/ProgressBar;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

.field final synthetic val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 318
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$5;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$5;->val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 321
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$5;->val$liveStreamBookmark:Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 322
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$5;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->startActivity(Landroid/content/Intent;)V

    .line 323
    return-void
.end method
