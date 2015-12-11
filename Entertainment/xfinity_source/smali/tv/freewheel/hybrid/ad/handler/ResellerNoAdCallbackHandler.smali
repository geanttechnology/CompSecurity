.class public Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;
.super Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.source "ResellerNoAdCallbackHandler.java"


# instance fields
.field private imprSent:Z


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
    .line 14
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .line 10
    const/4 v0, 0x0

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;->imprSent:Z

    .line 15
    const-string v0, "et"

    const-string v1, "i"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 16
    const-string v0, "cn"

    const-string v1, "resellerNoAd"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    return-void
.end method


# virtual methods
.method public send()V
    .locals 1

    .prologue
    .line 21
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;->imprSent:Z

    if-eqz v0, :cond_0

    .line 26
    :goto_0
    return-void

    .line 24
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/ResellerNoAdCallbackHandler;->imprSent:Z

    .line 25
    invoke-super {p0}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;->send()V

    goto :goto_0
.end method
