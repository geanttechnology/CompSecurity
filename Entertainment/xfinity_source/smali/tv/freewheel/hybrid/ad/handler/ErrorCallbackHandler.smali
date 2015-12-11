.class public Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;
.super Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.source "ErrorCallbackHandler.java"


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

    .line 15
    const-string v0, "et"

    const-string v1, "e"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 16
    return-void
.end method


# virtual methods
.method public send(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "info"    # Landroid/os/Bundle;

    .prologue
    .line 19
    const-string v4, "errorCode"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 20
    .local v1, "errorCode":Ljava/lang/String;
    const-string v4, "errorInfo"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 21
    .local v0, "additional":Ljava/lang/String;
    const-string v4, "errorModule"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 22
    .local v2, "renderer":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "renderer"

    invoke-static {v5}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 23
    .local v3, "value":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "&"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "additional"

    invoke-static {v5}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v0}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 24
    const-string v4, "cn"

    invoke-virtual {p0, v4, v1}, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    const-string v4, "kv"

    invoke-virtual {p0, v4, v3}, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;->send()V

    .line 28
    iget-object v4, p0, Ltv/freewheel/hybrid/ad/handler/ErrorCallbackHandler;->adInstance:Ltv/freewheel/hybrid/ad/AdInstance;

    const-string v5, "_e_unknown"

    invoke-virtual {v4, v5}, Ltv/freewheel/hybrid/ad/AdInstance;->dispatchAdEvent(Ljava/lang/String;)V

    .line 29
    return-void
.end method
