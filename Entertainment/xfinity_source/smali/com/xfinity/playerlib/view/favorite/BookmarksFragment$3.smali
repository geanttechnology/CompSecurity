.class Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;
.super Ljava/lang/Object;
.source "BookmarksFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

.field final synthetic val$liveStreamFavorite:Lcom/xfinity/playerlib/model/LiveStreamFavorite;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 189
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;->val$liveStreamFavorite:Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 192
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 193
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$100(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;->val$liveStreamFavorite:Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->deleteFavorite(Ljava/lang/String;)Z

    .line 194
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$700(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    const/4 v1, 0x1

    new-array v1, v1, [Lcom/xfinity/playerlib/model/Favorite;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;->val$liveStreamFavorite:Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->removeItems(Ljava/util/List;)V

    .line 195
    return-void
.end method
