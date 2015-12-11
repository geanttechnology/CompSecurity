.class public Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


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
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->displayName:Ljava/lang/String;

    return-object v0
.end method

.method public getPercent0To1()D
    .locals 2

    .prologue
    .line 29
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->percent0To1:D

    return-wide v0
.end method

.method public getPercent0To100()D
    .locals 2

    .prologue
    .line 37
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->percent0To100:D

    return-wide v0
.end method

.method public getRangeMax()I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->rangeMax:I

    return v0
.end method

.method public getScore()D
    .locals 2

    .prologue
    .line 53
    iget-wide v0, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->score:D

    return-wide v0
.end method

.method public setDisplayName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->displayName:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setPercent0To1(D)V
    .locals 1

    .prologue
    .line 33
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->percent0To1:D

    .line 34
    return-void
.end method

.method public setPercent0To100(D)V
    .locals 1

    .prologue
    .line 41
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->percent0To100:D

    .line 42
    return-void
.end method

.method public setRangeMax(I)V
    .locals 0

    .prologue
    .line 49
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->rangeMax:I

    .line 50
    return-void
.end method

.method public setScore(D)V
    .locals 1

    .prologue
    .line 57
    iput-wide p1, p0, Lcom/bestbuy/android/api/lib/models/pdp/BundleAvgFeatureRating;->score:D

    .line 58
    return-void
.end method
