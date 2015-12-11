.class public Lcom/amazon/rio/j2me/client/codec/CheckLoginRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "CheckLoginRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Ljava/io/DataOutputStream;)V
    .locals 6
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 20
    move-object v1, p1

    .line 24
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->getOneClickDeviceName()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_2

    move v0, v2

    .line 25
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 26
    if-nez v0, :cond_0

    .line 28
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->getOneClickDeviceName()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 32
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->getNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v4

    if-nez v4, :cond_3

    move v0, v2

    .line 33
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 34
    if-nez v0, :cond_1

    .line 36
    new-instance v2, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;-><init>()V

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->getNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v3

    invoke-virtual {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Ljava/io/DataOutputStream;)V

    .line 38
    :cond_1
    return-void

    .end local v0    # "isAbsent":Z
    :cond_2
    move v0, v3

    .line 24
    goto :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_3
    move v0, v3

    .line 32
    goto :goto_1
.end method

.method public bridge synthetic encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 16
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/CheckLoginRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
