.class public Lcom/amazon/searchapp/retailsearch/entity/MovieEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "MovieEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Movie;


# instance fields
.field private runtime:Ljava/lang/String;

.field private synopsis:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getRuntime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/MovieEntity;->runtime:Ljava/lang/String;

    return-object v0
.end method

.method public getSynopsis()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/MovieEntity;->synopsis:Ljava/lang/String;

    return-object v0
.end method

.method public setRuntime(Ljava/lang/String;)V
    .locals 0
    .param p1, "runtime"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/MovieEntity;->runtime:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setSynopsis(Ljava/lang/String;)V
    .locals 0
    .param p1, "synopsis"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/MovieEntity;->synopsis:Ljava/lang/String;

    .line 35
    return-void
.end method
