.class public Lcom/comcast/playerplatform/util/android/Range;
.super Ljava/lang/Object;
.source "Range.java"


# instance fields
.field private max:I

.field private min:I


# direct methods
.method public constructor <init>(II)V
    .locals 0
    .param p1, "min"    # I
    .param p2, "max"    # I

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput p1, p0, Lcom/comcast/playerplatform/util/android/Range;->min:I

    .line 17
    iput p2, p0, Lcom/comcast/playerplatform/util/android/Range;->max:I

    .line 18
    return-void
.end method


# virtual methods
.method public getMax()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lcom/comcast/playerplatform/util/android/Range;->max:I

    return v0
.end method

.method public getMin()I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lcom/comcast/playerplatform/util/android/Range;->min:I

    return v0
.end method

.method public setMax(I)V
    .locals 0
    .param p1, "max"    # I

    .prologue
    .line 33
    iput p1, p0, Lcom/comcast/playerplatform/util/android/Range;->max:I

    .line 34
    return-void
.end method

.method public setMin(I)V
    .locals 0
    .param p1, "min"    # I

    .prologue
    .line 25
    iput p1, p0, Lcom/comcast/playerplatform/util/android/Range;->min:I

    .line 26
    return-void
.end method
