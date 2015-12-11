.class public Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private count:I

.field private percent0To100:D

.field private score:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;->count:I

    return v0
.end method

.method public getPercent0To100()D
    .locals 2

    .prologue
    .line 27
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;->percent0To100:D

    return-wide v0
.end method

.method public getScore()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;->score:I

    return v0
.end method

.method public setCount(I)V
    .locals 0

    .prologue
    .line 23
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;->count:I

    .line 24
    return-void
.end method

.method public setPercent0To100(D)V
    .locals 1

    .prologue
    .line 31
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;->percent0To100:D

    .line 32
    return-void
.end method

.method public setScore(I)V
    .locals 0

    .prologue
    .line 39
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleStarRating;->score:I

    .line 40
    return-void
.end method
