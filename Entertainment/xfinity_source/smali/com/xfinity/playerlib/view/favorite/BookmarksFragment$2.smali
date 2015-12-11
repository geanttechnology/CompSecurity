.class Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$2;
.super Ljava/lang/Object;
.source "BookmarksFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getItemClickListener()Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;
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
        "Lcom/xfinity/playerlib/model/Favorite;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 135
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$2;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClicked(Lcom/xfinity/playerlib/model/Favorite;)V
    .locals 1
    .param p1, "item"    # Lcom/xfinity/playerlib/model/Favorite;

    .prologue
    .line 138
    instance-of v0, p1, Lcom/xfinity/playerlib/model/VideoFavorite;

    if-eqz v0, :cond_0

    .line 139
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$2;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteListener:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$500(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;

    move-result-object v0

    check-cast p1, Lcom/xfinity/playerlib/model/VideoFavorite;

    .end local p1    # "item":Lcom/xfinity/playerlib/model/Favorite;
    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;->showDetail(Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 143
    :goto_0
    return-void

    .line 141
    .restart local p1    # "item":Lcom/xfinity/playerlib/model/Favorite;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$2;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    check-cast p1, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .end local p1    # "item":Lcom/xfinity/playerlib/model/Favorite;
    # invokes: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$600(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V

    goto :goto_0
.end method

.method public bridge synthetic onItemClicked(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 135
    check-cast p1, Lcom/xfinity/playerlib/model/Favorite;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$2;->onItemClicked(Lcom/xfinity/playerlib/model/Favorite;)V

    return-void
.end method
