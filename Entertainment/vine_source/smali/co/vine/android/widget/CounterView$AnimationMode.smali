.class public Lco/vine/android/widget/CounterView$AnimationMode;
.super Ljava/lang/Object;
.source "CounterView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/widget/CounterView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AnimationMode"
.end annotation


# instance fields
.field public final alphaAnimation:Z

.field public final continuousAnimation:Z

.field public final pedometerAnimation:Z


# direct methods
.method public constructor <init>(ZZZ)V
    .locals 0
    .param p1, "continuousAnimation"    # Z
    .param p2, "pedometerAnimation"    # Z
    .param p3, "alphaAnimation"    # Z

    .prologue
    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    iput-boolean p1, p0, Lco/vine/android/widget/CounterView$AnimationMode;->continuousAnimation:Z

    .line 77
    iput-boolean p2, p0, Lco/vine/android/widget/CounterView$AnimationMode;->pedometerAnimation:Z

    .line 78
    iput-boolean p3, p0, Lco/vine/android/widget/CounterView$AnimationMode;->alphaAnimation:Z

    .line 79
    return-void
.end method
