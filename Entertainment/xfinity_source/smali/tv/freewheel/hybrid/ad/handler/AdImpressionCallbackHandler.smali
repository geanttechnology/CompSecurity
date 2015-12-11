.class public Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;
.super Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.source "AdImpressionCallbackHandler.java"


# instance fields
.field private endImpressionSent:Z


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

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->endImpressionSent:Z

    .line 15
    return-void
.end method


# virtual methods
.method public send(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "info"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    .line 18
    const-string v4, "endAck"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 19
    .local v2, "endAck":Z
    const-string v4, "metr"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 20
    .local v3, "metr":I
    const-string v4, "metr"

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 21
    if-eqz v2, :cond_3

    .line 22
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/ad/slot/Slot;->getType()I

    move-result v4

    if-eqz v4, :cond_0

    .line 58
    :goto_0
    return-void

    .line 28
    :cond_0
    const-string v4, "init"

    const-string v5, "0"

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    const-string v4, "last"

    const-string v5, "1"

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    const-string v4, "ct"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 31
    .local v0, "ctValue":J
    const-string v4, "ct"

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    .end local v0    # "ctValue":J
    :goto_1
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-boolean v4, v4, Ltv/freewheel/hybrid/ad/AdInstance;->imprSent:Z

    if-eqz v4, :cond_5

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/ad/slot/Slot;->isPauseMidroll()Z

    move-result v4

    if-nez v4, :cond_5

    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-boolean v4, v4, Ltv/freewheel/hybrid/ad/AdInstance;->isCompanionAdOfPauseAd:Z

    if-nez v4, :cond_5

    .line 43
    if-eqz v2, :cond_1

    iget-boolean v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->endImpressionSent:Z

    if-eqz v4, :cond_2

    .line 44
    :cond_1
    const-string v4, "init"

    const-string v5, "2"

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    :cond_2
    :goto_2
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->send()V

    .line 52
    if-eqz v2, :cond_6

    .line 53
    iput-boolean v6, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->endImpressionSent:Z

    .line 54
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    const-string v5, "adEnd"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto :goto_0

    .line 33
    :cond_3
    const-string v4, "init"

    const-string v5, "1"

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 34
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v4, v4, Ltv/freewheel/hybrid/ad/AdInstance;->slot:Ltv/freewheel/hybrid/ad/slot/Slot;

    invoke-virtual {v4}, Ltv/freewheel/hybrid/ad/slot/Slot;->getType()I

    move-result v4

    if-nez v4, :cond_4

    .line 35
    const-string v4, "last"

    const-string v5, "0"

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 36
    const-string v4, "ct"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 37
    .restart local v0    # "ctValue":J
    const-string v4, "ct"

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 39
    .end local v0    # "ctValue":J
    :cond_4
    const-string v4, "last"

    const-string v5, "1"

    invoke-virtual {p0, v4, v5}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 46
    :cond_5
    if-nez v2, :cond_2

    .line 48
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->sendTrackingCallback()V

    .line 49
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    iput-boolean v6, v4, Ltv/freewheel/hybrid/ad/AdInstance;->imprSent:Z

    goto :goto_2

    .line 56
    :cond_6
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/AdImpressionCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    const-string v5, "defaultImpression"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
