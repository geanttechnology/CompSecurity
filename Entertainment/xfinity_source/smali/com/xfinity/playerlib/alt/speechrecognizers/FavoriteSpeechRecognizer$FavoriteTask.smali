.class Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "FavoriteSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FavoriteTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/model/Favorite;",
        ">;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;
    .param p2, "x1"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 102
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 103
    .local v2, "favorites":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;
    invoke-static {v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->access$300(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->getAllFavorite()Ljava/util/List;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 105
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    invoke-static {v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->access$400(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v5

    invoke-interface {v5}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getFavorites()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 106
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    new-instance v6, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-direct {v6, v0}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;-><init>(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 109
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_0
    new-instance v5, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;)V

    invoke-static {v2, v5}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 116
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->access$500(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 117
    .local v1, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->access$600(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 118
    .local v4, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->access$700(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v5

    invoke-interface {v5}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 120
    .local v3, "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    new-instance v5, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-direct {v5, v2, v1, v4, v3}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v5
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 97
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method
