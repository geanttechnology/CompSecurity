.class Lcom/xfinity/playerlib/view/search/SearchQueryProvider$1;
.super Lcom/google/common/cache/CacheLoader;
.source "SearchQueryProvider.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchQueryProvider;-><init>(Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/common/cache/CacheLoader",
        "<",
        "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
        "Lcom/xfinity/playerlib/view/search/SearchQuery;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchQueryProvider;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchQueryProvider;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchQueryProvider;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchQueryProvider$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchQueryProvider;

    invoke-direct {p0}, Lcom/google/common/cache/CacheLoader;-><init>()V

    return-void
.end method


# virtual methods
.method public load(Lcom/xfinity/playerlib/model/user/PlayNowUser;)Lcom/xfinity/playerlib/view/search/SearchQuery;
    .locals 1
    .param p1, "key"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 24
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchQuery;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/search/SearchQuery;-><init>()V

    return-object v0
.end method

.method public bridge synthetic load(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 22
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchQueryProvider$1;->load(Lcom/xfinity/playerlib/model/user/PlayNowUser;)Lcom/xfinity/playerlib/view/search/SearchQuery;

    move-result-object v0

    return-object v0
.end method
