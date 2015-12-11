.class public Lcom/poshmark/triggers/TriggerThresholds;
.super Ljava/lang/Object;
.source "TriggerThresholds.java"


# instance fields
.field public initial_threshold:I

.field public repeat_clicked_threshold:I

.field public repeat_dismissed_threshold:I

.field public repeat_ignored_threshold:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const v0, 0x7fffffff

    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    iput v0, p0, Lcom/poshmark/triggers/TriggerThresholds;->initial_threshold:I

    .line 8
    iput v0, p0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_ignored_threshold:I

    .line 9
    iput v0, p0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_clicked_threshold:I

    .line 10
    iput v0, p0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_dismissed_threshold:I

    return-void
.end method
