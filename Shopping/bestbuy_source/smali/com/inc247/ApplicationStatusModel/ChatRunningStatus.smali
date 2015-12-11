.class public Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static isChatRunning:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getChatRunning()Z
    .locals 1

    .prologue
    .line 18
    sget-boolean v0, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->isChatRunning:Z

    return v0
.end method

.method public static setChatRunning(Z)V
    .locals 0

    .prologue
    .line 27
    sput-boolean p0, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->isChatRunning:Z

    .line 28
    return-void
.end method
