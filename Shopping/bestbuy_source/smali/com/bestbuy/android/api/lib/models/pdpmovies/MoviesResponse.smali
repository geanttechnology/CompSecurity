.class public Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private movieDetails:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

.field private names:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieNames;

.field private productType:Ljava/lang/String;

.field private skuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMovieDetails()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->movieDetails:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    return-object v0
.end method

.method public getNames()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieNames;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->names:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieNames;

    return-object v0
.end method

.method public getProductType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->productType:Ljava/lang/String;

    return-object v0
.end method

.method public getSkuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->skuId:Ljava/lang/String;

    return-object v0
.end method

.method public setMovieDetails(Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;)V
    .locals 0

    .prologue
    .line 24
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->movieDetails:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieDetails;

    .line 25
    return-void
.end method

.method public setNames(Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieNames;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->names:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieNames;

    .line 33
    return-void
.end method

.method public setProductType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->productType:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setSkuId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MoviesResponse;->skuId:Ljava/lang/String;

    .line 49
    return-void
.end method
