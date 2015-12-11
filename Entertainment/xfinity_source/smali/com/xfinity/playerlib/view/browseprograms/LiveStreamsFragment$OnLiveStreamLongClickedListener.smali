.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "OnLiveStreamLongClickedListener"
.end annotation


# instance fields
.field private fragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p2, "fragment"    # Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    .prologue
    .line 733
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 734
    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;->fragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    .line 735
    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 8
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 740
    .local p1, "adapter":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 741
    .local v2, "item":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    const/4 v1, 0x0

    .line 743
    .local v1, "isFavorite":Z
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarks:Ljava/util/List;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 744
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 745
    const/4 v1, 0x1

    .line 750
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;->fragment:Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;

    new-instance v5, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    const/4 v7, 0x0

    invoke-direct {v5, v6, v7}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;)V

    invoke-virtual {v3, v4, v2, v1, v5}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;ZLcom/xfinity/playerlib/view/favorite/BookmarkEventListener;)V

    .line 751
    const/4 v3, 0x1

    return v3
.end method
