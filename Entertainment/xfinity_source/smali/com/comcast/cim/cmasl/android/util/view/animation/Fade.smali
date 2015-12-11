.class public Lcom/comcast/cim/cmasl/android/util/view/animation/Fade;
.super Ljava/lang/Object;
.source "Fade.java"


# instance fields
.field private mDuration:J

.field private mDurationSet:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/Fade;->mDurationSet:Z

    .line 16
    const-wide/16 v0, 0x12c

    iput-wide v0, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/Fade;->mDuration:J

    return-void
.end method


# virtual methods
.method public setDuration(J)V
    .locals 3
    .param p1, "duration"    # J

    .prologue
    .line 24
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 25
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/Fade;->mDurationSet:Z

    .line 26
    iput-wide p1, p0, Lcom/comcast/cim/cmasl/android/util/view/animation/Fade;->mDuration:J

    .line 28
    :cond_0
    return-void
.end method
