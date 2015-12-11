.class public Ltv/freewheel/ad/handler/QuartileCallbackHandler;
.super Ltv/freewheel/ad/handler/EventCallbackHandler;
.source "QuartileCallbackHandler.java"


# instance fields
.field public imprSent:Z


# direct methods
.method public constructor <init>(Ltv/freewheel/ad/EventCallback;)V
    .locals 2
    .param p1, "callback"    # Ltv/freewheel/ad/EventCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 14
    invoke-direct {p0, p1}, Ltv/freewheel/ad/handler/EventCallbackHandler;-><init>(Ltv/freewheel/ad/EventCallback;)V

    .line 11
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->imprSent:Z

    .line 15
    const-string v0, "et"

    const-string v1, "i"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 16
    return-void
.end method


# virtual methods
.method public send(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "info"    # Landroid/os/Bundle;

    .prologue
    .line 19
    iget-boolean v3, p0, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->imprSent:Z

    if-eqz v3, :cond_0

    .line 29
    :goto_0
    return-void

    .line 22
    :cond_0
    const/4 v3, 0x1

    iput-boolean v3, p0, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->imprSent:Z

    .line 23
    const-string v3, "ct"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v0

    .line 24
    .local v0, "ct":J
    const-string v3, "metr"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 25
    .local v2, "metr":I
    const-string v3, "ct"

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    const-string v3, "metr"

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    invoke-virtual {p0}, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->send()V

    .line 28
    invoke-virtual {p0}, Ltv/freewheel/ad/handler/QuartileCallbackHandler;->sendTrackingCallback()V

    goto :goto_0
.end method
