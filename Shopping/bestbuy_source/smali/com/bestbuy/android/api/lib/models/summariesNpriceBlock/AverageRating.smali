.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private percent0To1:D

.field private percent0To100:J

.field private rangeMax:I

.field private score:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 20
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()J
    .locals 2

    .prologue
    .line 28
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->percent0To100:J

    return-wide v0
.end method

.method public getRangeMax()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->rangeMax:I

    return v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 44
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->score:D

    return-wide v0
.end method

.method public setPercent0To1(D)V
    .locals 1

    .prologue
    .line 24
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->percent0To1:D

    .line 25
    return-void
.end method

.method public setPercent0To100(J)V
    .locals 1

    .prologue
    .line 32
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->percent0To100:J

    .line 33
    return-void
.end method

.method public setRangeMax(I)V
    .locals 0

    .prologue
    .line 40
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->rangeMax:I

    .line 41
    return-void
.end method

.method public setScore(D)V
    .locals 1

    .prologue
    .line 48
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageRating;->score:D

    .line 49
    return-void
.end method
