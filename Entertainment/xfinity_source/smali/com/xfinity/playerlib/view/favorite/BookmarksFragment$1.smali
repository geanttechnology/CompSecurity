.class Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "BookmarksFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/model/Favorite;",
        ">;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 57
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 58
    .local v1, "favorites":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$000(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->getAllFavorite()Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 60
    iget-object v2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$100(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v2

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getFavorites()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 61
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    new-instance v3, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;-><init>(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 64
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_0
    new-instance v2, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1$1;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;)V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 71
    new-instance v2, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$200(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$300(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    # getter for: Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->access$400(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5, v1}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v2
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method
