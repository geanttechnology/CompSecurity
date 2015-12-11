.class public Lcom/exacttarget/etpushsdk/event/PushReceivedEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private payload:Landroid/os/Bundle;


# direct methods
.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/PushReceivedEvent;->payload:Landroid/os/Bundle;

    .line 30
    return-void
.end method


# virtual methods
.method public getPayload()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/PushReceivedEvent;->payload:Landroid/os/Bundle;

    return-object v0
.end method

.method public setPayload(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/PushReceivedEvent;->payload:Landroid/os/Bundle;

    .line 38
    return-void
.end method
