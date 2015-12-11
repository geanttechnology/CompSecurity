.class public Lcom/exacttarget/etpushsdk/event/PowerStatusChangedEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static final BATTERY_LOW:I = 0x0

.field public static final BATTERY_OK:I = 0x1


# instance fields
.field private status:I


# direct methods
.method public constructor <init>(I)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput p1, p0, Lcom/exacttarget/etpushsdk/event/PowerStatusChangedEvent;->status:I

    .line 29
    return-void
.end method


# virtual methods
.method public getStatus()I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/exacttarget/etpushsdk/event/PowerStatusChangedEvent;->status:I

    return v0
.end method

.method public setStatus(I)V
    .locals 0

    .prologue
    .line 36
    iput p1, p0, Lcom/exacttarget/etpushsdk/event/PowerStatusChangedEvent;->status:I

    .line 37
    return-void
.end method
