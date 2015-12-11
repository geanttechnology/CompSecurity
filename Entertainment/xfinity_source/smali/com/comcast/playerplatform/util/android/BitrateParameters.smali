.class public Lcom/comcast/playerplatform/util/android/BitrateParameters;
.super Ljava/lang/Object;
.source "BitrateParameters.java"


# instance fields
.field private initial:I

.field private max:I

.field private min:I


# direct methods
.method public constructor <init>(III)V
    .locals 0
    .param p1, "initialBitrate"    # I
    .param p2, "minimumBitrate"    # I
    .param p3, "maximumBitrate"    # I

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput p1, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->initial:I

    .line 17
    iput p2, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->min:I

    .line 18
    iput p3, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->max:I

    .line 19
    return-void
.end method


# virtual methods
.method public getInitialBitrate()I
    .locals 1

    .prologue
    .line 22
    iget v0, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->initial:I

    return v0
.end method

.method public getMaximumBitrate()I
    .locals 1

    .prologue
    .line 38
    iget v0, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->max:I

    return v0
.end method

.method public getMinimumBitrate()I
    .locals 1

    .prologue
    .line 30
    iget v0, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->min:I

    return v0
.end method

.method public setInitialBitrate(I)V
    .locals 0
    .param p1, "initialBitrate"    # I

    .prologue
    .line 26
    iput p1, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->initial:I

    .line 27
    return-void
.end method

.method public setMaximumBitrate(I)V
    .locals 0
    .param p1, "maximumBitrate"    # I

    .prologue
    .line 42
    iput p1, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->max:I

    .line 43
    return-void
.end method

.method public setMinimumBitrate(I)V
    .locals 0
    .param p1, "minimumBitrate"    # I

    .prologue
    .line 34
    iput p1, p0, Lcom/comcast/playerplatform/util/android/BitrateParameters;->min:I

    .line 35
    return-void
.end method
