.class public Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
.super Ljava/lang/Object;
.source "FeaturedResource.java"


# instance fields
.field private final movieAndSeriesResource:Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

.field private final videoCoverResource:Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;)V
    .locals 0
    .param p1, "movieAndSeriesResource"    # Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;
    .param p2, "videoCoverResource"    # Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->movieAndSeriesResource:Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    .line 20
    iput-object p2, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->videoCoverResource:Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    .line 21
    return-void
.end method


# virtual methods
.method public getCoverVideoCollectionTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->videoCoverResource:Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;->getCollectionTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCoverVideos()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/CoverVideo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->videoCoverResource:Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;->getPrograms()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getMovieCollectionTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->movieAndSeriesResource:Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->getMovieCollectionTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMovies()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialMovie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->movieAndSeriesResource:Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->getMovies()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSeries()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialTVSeries;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->movieAndSeriesResource:Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->getSeries()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSeriesCollectionTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->movieAndSeriesResource:Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->getSeriesCollectionTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
