.class public Lcom/comcast/cim/model/hal/FilteringHalMovieFactory;
.super Lcom/comcast/cim/model/hal/HalMovieFactory;
.source "FilteringHalMovieFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/model/hal/HalMovieFactory",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final videoFilter:Lcom/comcast/cim/model/hal/HalVideoFilter;


# virtual methods
.method public bridge synthetic createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;
    .locals 1

    .prologue
    .line 7
    .local p0, "this":Lcom/comcast/cim/model/hal/FilteringHalMovieFactory;, "Lcom/comcast/cim/model/hal/FilteringHalMovieFactory<TT;>;"
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/model/hal/FilteringHalMovieFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    move-result-object v0

    return-object v0
.end method

.method public createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;)",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;"
        }
    .end annotation

    .prologue
    .line 16
    .local p0, "this":Lcom/comcast/cim/model/hal/FilteringHalMovieFactory;, "Lcom/comcast/cim/model/hal/FilteringHalMovieFactory<TT;>;"
    .local p2, "halHttpClient":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/model/hal/HalMovieFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .line 18
    .local v0, "halObject":Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    iget-object v1, p0, Lcom/comcast/cim/model/hal/FilteringHalMovieFactory;->videoFilter:Lcom/comcast/cim/model/hal/HalVideoFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getVideos()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/model/hal/HalVideoFilter;->filter(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->setVideos(Ljava/util/List;)V

    .line 19
    return-object v0
.end method
