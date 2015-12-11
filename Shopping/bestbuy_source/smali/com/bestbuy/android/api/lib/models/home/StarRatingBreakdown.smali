.class public Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x13b2df12e6da2090L


# instance fields
.field private count:Ljava/lang/String;

.field private percent0To100:Ljava/lang/String;

.field private score:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;->count:Ljava/lang/String;

    return-object v0
.end method

.method public getPercent0To100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;->percent0To100:Ljava/lang/String;

    return-object v0
.end method

.method public getScore()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;->score:Ljava/lang/String;

    return-object v0
.end method

.method public setCount(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;->count:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public setPercent0To100(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;->percent0To100:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setScore(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/StarRatingBreakdown;->score:Ljava/lang/String;

    .line 55
    return-void
.end method
