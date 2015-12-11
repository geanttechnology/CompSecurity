.class public Lcom/comcast/playerplatform/drm/java/service/ProvisionService;
.super Ljava/lang/Object;
.source "ProvisionService.java"


# instance fields
.field private clientSessionRequest:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;


# virtual methods
.method public getXact()V
    .locals 1

    .prologue
    .line 134
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/drm/java/service/ProvisionService;->getXact(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 135
    return-void
.end method

.method public getXact(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V
    .locals 1
    .param p1, "moneyTrace"    # Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/comcast/playerplatform/drm/java/service/ProvisionService;->clientSessionRequest:Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/drm/java/request/ClientSessionRequest;->getXactToken(Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    .line 144
    return-void
.end method
