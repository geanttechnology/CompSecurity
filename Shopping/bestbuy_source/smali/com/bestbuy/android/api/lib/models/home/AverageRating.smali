.class public Lcom/bestbuy/android/api/lib/models/home/AverageRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x5acf97d57d95221fL


# instance fields
.field private percent0To1:D

.field private percent0To100:D

.field private rangeMax:D

.field private score:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 26
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()D
    .locals 2

    .prologue
    .line 32
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->percent0To100:D

    return-wide v0
.end method

.method public getRangeMax()D
    .locals 2

    .prologue
    .line 38
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->rangeMax:D

    return-wide v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 44
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->score:D

    return-wide v0
.end method

.method public setPercent0To1(D)V
    .locals 1

    .prologue
    .line 50
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->percent0To1:D

    .line 51
    return-void
.end method

.method public setPercent0To100(D)V
    .locals 1

    .prologue
    .line 56
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->percent0To100:D

    .line 57
    return-void
.end method

.method public setRangeMax(D)V
    .locals 1

    .prologue
    .line 62
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->rangeMax:D

    .line 63
    return-void
.end method

.method public setScore(D)V
    .locals 1

    .prologue
    .line 68
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/home/AverageRating;->score:D

    .line 69
    return-void
.end method
