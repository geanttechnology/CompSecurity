.class public abstract Lcom/amazon/retailsearch/data/search/ResultEvent;
.super Ljava/lang/Object;
.source "ResultEvent.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
.end method

.method public send(Ljava/lang/Iterable;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable",
            "<",
            "Lcom/amazon/retailsearch/data/search/ResultStreamListener;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 7
    .local p1, "listeners":Ljava/lang/Iterable;, "Ljava/lang/Iterable<Lcom/amazon/retailsearch/data/search/ResultStreamListener;>;"
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .line 8
    .local v1, "listener":Lcom/amazon/retailsearch/data/search/ResultStreamListener;
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/data/search/ResultEvent;->send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V

    goto :goto_0

    .line 10
    .end local v1    # "listener":Lcom/amazon/retailsearch/data/search/ResultStreamListener;
    :cond_0
    return-void
.end method
