.class public Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private count:I

.field private percent:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        value = "percent0To100"
    .end annotation
.end field

.field private score:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;->count:I

    return v0
.end method

.method public getPercent()I
    .locals 1

    .prologue
    .line 39
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;->percent:I

    return v0
.end method

.method public getScore()I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;->score:I

    return v0
.end method

.method public setCount(I)V
    .locals 0

    .prologue
    .line 53
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;->count:I

    .line 54
    return-void
.end method

.method public setPercent(I)V
    .locals 0

    .prologue
    .line 60
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;->percent:I

    .line 61
    return-void
.end method

.method public setScore(I)V
    .locals 0

    .prologue
    .line 67
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/StarRating;->score:I

    .line 68
    return-void
.end method
