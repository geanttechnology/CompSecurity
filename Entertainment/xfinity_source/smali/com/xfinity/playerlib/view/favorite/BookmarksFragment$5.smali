.class Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$5;
.super Ljava/lang/Object;
.source "BookmarksFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


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
    .line 211
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$5;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$5;->val$liveStreamFavorite:Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 214
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$5;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteListener:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$500(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$5;->val$liveStreamFavorite:Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;->playLiveStream(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V

    .line 215
    return-void
.end method
