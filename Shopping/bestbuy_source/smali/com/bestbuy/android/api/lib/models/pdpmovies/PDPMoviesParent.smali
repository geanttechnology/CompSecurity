.class public Lcom/bestbuy/android/api/lib/models/pdpmovies/PDPMoviesParent;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private si:Lcom/bestbuy/android/api/lib/models/pdpmovies/SIMovies;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getSi()Lcom/bestbuy/android/api/lib/models/pdpmovies/SIMovies;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/PDPMoviesParent;->si:Lcom/bestbuy/android/api/lib/models/pdpmovies/SIMovies;

    return-object v0
.end method

.method public setSi(Lcom/bestbuy/android/api/lib/models/pdpmovies/SIMovies;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/PDPMoviesParent;->si:Lcom/bestbuy/android/api/lib/models/pdpmovies/SIMovies;

    .line 22
    return-void
.end method
