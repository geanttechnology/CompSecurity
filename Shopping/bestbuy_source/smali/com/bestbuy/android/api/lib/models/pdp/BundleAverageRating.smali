.class public Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private percent0To1:D

.field private percent0To100:D

.field private rangeMax:I

.field private score:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 20
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()D
    .locals 2

    .prologue
    .line 28
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->percent0To100:D

    return-wide v0
.end method

.method public getRangeMax()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->rangeMax:I

    return v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 44
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->score:D

    return-wide v0
.end method

.method public setPercent0To1(D)V
    .locals 1

    .prologue
    .line 24
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->percent0To1:D

    .line 25
    return-void
.end method

.method public setPercent0To100(D)V
    .locals 1

    .prologue
    .line 32
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->percent0To100:D

    .line 33
    return-void
.end method

.method public setRangeMax(I)V
    .locals 0

    .prologue
    .line 40
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->rangeMax:I

    .line 41
    return-void
.end method

.method public setScore(D)V
    .locals 1

    .prologue
    .line 48
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAverageRating;->score:D

    .line 49
    return-void
.end method
