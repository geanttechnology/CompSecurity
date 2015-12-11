.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# instance fields
.field private displayName:Ljava/lang/String;

.field private percent0To1:D

.field private percent0To100:D

.field private rangeMax:I

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
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 30
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()D
    .locals 2

    .prologue
    .line 38
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->percent0To100:D

    return-wide v0
.end method

.method public getRangeMax()I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->rangeMax:I

    return v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 54
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->score:D

    return-wide v0
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->displayName:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public setPercent0To1(D)V
    .locals 1

    .prologue
    .line 34
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->percent0To1:D

    .line 35
    return-void
.end method

.method public setPercent0To100(D)V
    .locals 1

    .prologue
    .line 42
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->percent0To100:D

    .line 43
    return-void
.end method

.method public setRangeMax(I)V
    .locals 0

    .prologue
    .line 50
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->rangeMax:I

    .line 51
    return-void
.end method

.method public setScore(D)V
    .locals 1

    .prologue
    .line 58
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/AverageFeatureRating;->score:D

    .line 59
    return-void
.end method
