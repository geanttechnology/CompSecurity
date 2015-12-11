.class public Lcom/exacttarget/etpushsdk/event/BackgroundEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private inBackground:Z

.field private timeWentInBackground:J


# direct methods
.method public constructor <init>(Z)V
    .locals 2

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-boolean p1, p0, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->inBackground:Z

    .line 24
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->timeWentInBackground:J

    .line 25
    return-void
.end method

.method public constructor <init>(ZJ)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-boolean p1, p0, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->inBackground:Z

    .line 30
    iput-wide p2, p0, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->timeWentInBackground:J

    .line 31
    return-void
.end method


# virtual methods
.method public getTimeWentInBackground()J
    .locals 2

    .prologue
    .line 38
    iget-wide v0, p0, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->timeWentInBackground:J

    return-wide v0
.end method

.method public isInBackground()Z
    .locals 1

    .prologue
    .line 34
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->inBackground:Z

    return v0
.end method
