.class public Lcom/xfinity/playerlib/view/search/SearchQueryProvider;
.super Ljava/lang/Object;
.source "SearchQueryProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/xfinity/playerlib/view/search/SearchQuery;",
        ">;"
    }
.end annotation


# instance fields
.field private final perUserQueryCache:Lcom/google/common/cache/LoadingCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/cache/LoadingCache",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/view/search/SearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 2
    .param p1, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchQueryProvider;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 20
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    .line 21
    invoke-static {}, Lcom/google/common/cache/CacheBuilder;->newBuilder()Lcom/google/common/cache/CacheBuilder;

    move-result-object v0

    .line 22
    .local v0, "cacheBuilder":Lcom/google/common/cache/CacheBuilder;, "Lcom/google/common/cache/CacheBuilder<Ljava/lang/Object;Ljava/lang/Object;>;"
    new-instance v1, Lcom/xfinity/playerlib/view/search/SearchQueryProvider$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/search/SearchQueryProvider$1;-><init>(Lcom/xfinity/playerlib/view/search/SearchQueryProvider;)V

    invoke-virtual {v0, v1}, Lcom/google/common/cache/CacheBuilder;->build(Lcom/google/common/cache/CacheLoader;)Lcom/google/common/cache/LoadingCache;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchQueryProvider;->perUserQueryCache:Lcom/google/common/cache/LoadingCache;

    .line 27
    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/view/search/SearchQuery;
    .locals 3

    .prologue
    .line 31
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchQueryProvider;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 32
    .local v0, "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    if-nez v0, :cond_0

    .line 33
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "This method should not be called while there is no user signed in"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 35
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchQueryProvider;->perUserQueryCache:Lcom/google/common/cache/LoadingCache;

    invoke-interface {v1, v0}, Lcom/google/common/cache/LoadingCache;->getUnchecked(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/search/SearchQuery;

    return-object v1
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 14
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchQueryProvider;->get()Lcom/xfinity/playerlib/view/search/SearchQuery;

    move-result-object v0

    return-object v0
.end method
