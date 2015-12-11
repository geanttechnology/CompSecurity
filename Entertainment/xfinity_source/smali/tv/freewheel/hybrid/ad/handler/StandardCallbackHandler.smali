.class public Ltv/freewheel/hybrid/ad/handler/StandardCallbackHandler;
.super Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.source "StandardCallbackHandler.java"


# direct methods
.method public constructor <init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    .locals 2
    .param p1, "callback"    # Ltv/freewheel/hybrid/ad/EventCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 11
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .line 12
    const-string v0, "et"

    const-string v1, "s"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/StandardCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 13
    return-void
.end method


# virtual methods
.method public send()V
    .locals 0

    .prologue
    .line 17
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->send()V

    .line 18
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/StandardCallbackHandler;->sendTrackingCallback()V

    .line 19
    return-void
.end method
