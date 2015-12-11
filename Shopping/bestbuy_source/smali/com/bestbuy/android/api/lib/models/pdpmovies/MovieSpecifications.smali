.class public Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private displayName:Ljava/lang/String;

.field private link:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->link:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->value:Ljava/lang/String;

    return-object v0
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->displayName:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setLink(Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->link:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;

    .line 40
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->value:Ljava/lang/String;

    .line 32
    return-void
.end method
