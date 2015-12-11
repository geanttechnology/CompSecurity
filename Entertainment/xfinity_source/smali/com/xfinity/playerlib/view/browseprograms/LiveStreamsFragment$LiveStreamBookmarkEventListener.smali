.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/favorite/BookmarkEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "LiveStreamBookmarkEventListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0

    .prologue
    .line 765
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;

    .prologue
    .line 765
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    return-void
.end method


# virtual methods
.method public onLiveStreamBookmarkAdded(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 1
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 769
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarks:Ljava/util/List;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 770
    return-void
.end method

.method public onLiveStreamBookmarkDeleted(Ljava/lang/String;)V
    .locals 3
    .param p1, "liveStreamId"    # Ljava/lang/String;

    .prologue
    .line 775
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarks:Ljava/util/List;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 777
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 778
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 779
    .local v1, "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 780
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 784
    .end local v1    # "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_1
    return-void
.end method
