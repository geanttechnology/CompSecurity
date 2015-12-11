.class public Lcom/exacttarget/etpushsdk/event/PushStatusEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private isPushEnabled:Z


# direct methods
.method public constructor <init>(Z)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-boolean p1, p0, Lcom/exacttarget/etpushsdk/event/PushStatusEvent;->isPushEnabled:Z

    .line 24
    return-void
.end method


# virtual methods
.method public isPushEnabled()Z
    .locals 1

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/event/PushStatusEvent;->isPushEnabled:Z

    return v0
.end method
