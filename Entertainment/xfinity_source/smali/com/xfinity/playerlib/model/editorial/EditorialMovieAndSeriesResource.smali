.class public Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;
.super Ljava/lang/Object;
.source "EditorialMovieAndSeriesResource.java"


# instance fields
.field private final movieCollectionTitle:Ljava/lang/String;

.field private final movies:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialMovie;",
            ">;"
        }
    .end annotation
.end field

.field private final series:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialTVSeries;",
            ">;"
        }
    .end annotation
.end field

.field private final seriesCollectionTitle:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V
    .locals 0
    .param p2, "movieCollectionTitle"    # Ljava/lang/String;
    .param p4, "seriesCollectionTitle"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialMovie;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/EditorialTVSeries;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 14
    .local p1, "movies":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/EditorialMovie;>;"
    .local p3, "series":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/EditorialTVSeries;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->movies:Ljava/util/List;

    .line 16
    iput-object p2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->movieCollectionTitle:Ljava/lang/String;

    .line 17
    iput-object p3, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->series:Ljava/util/List;

    .line 18
    iput-object p4, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->seriesCollectionTitle:Ljava/lang/String;

    .line 19
    return-void
.end method


# virtual methods
.method public getMovieCollectionTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->movieCollectionTitle:Ljava/lang/String;

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
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->movies:Ljava/util/List;

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
    .line 30
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->series:Ljava/util/List;

    return-object v0
.end method

.method public getSeriesCollectionTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;->seriesCollectionTitle:Ljava/lang/String;

    return-object v0
.end method
