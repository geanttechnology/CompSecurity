.class public Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;
.super Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.source "SlotImpressionCallbackHandler.java"


# instance fields
.field private imprSent:Z

.field private slot:Ltv/freewheel/hybrid/ad/slot/Slot;


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    .locals 1
    .param p1, "callback"    # Ltv/freewheel/hybrid/ad/EventCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 14
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .line 11
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->imprSent:Z

    .line 15
    return-void
.end method


# virtual methods
.method public send()V
    .locals 2

    .prologue
    .line 19
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->imprSent:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/ad/slot/Slot;->isPauseMidroll()Z

    move-result v0

    if-nez v0, :cond_0

    .line 20
    const-string v0, "init"

    const-string v1, "2"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    :goto_0
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->send()V

    .line 27
    return-void

    .line 22
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->imprSent:Z

    .line 23
    const-string v0, "init"

    const-string v1, "1"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->sendTrackingCallback()V

    goto :goto_0
.end method

.method public setSlot(Ltv/freewheel/hybrid/ad/slot/Slot;)V
    .locals 0
    .param p1, "slot"    # Ltv/freewheel/hybrid/ad/slot/Slot;

    .prologue
    .line 30
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/handler/SlotImpressionCallbackHandler;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    .line 31
    return-void
.end method
