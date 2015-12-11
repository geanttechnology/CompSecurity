.class public Lcom/amazon/rio/j2me/client/codec/UpdateNotificationTargetRequestDefaultEncoder;
.super Ljava/lang/Object;
.source "UpdateNotificationTargetRequestDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;Ljava/io/DataOutputStream;)V
    .locals 3
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;
    .param p2, "dos"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 20
    move-object v0, p1

    .line 24
    .local v0, "record":Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;
    new-instance v1, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;-><init>()V

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->getOldNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v2

    invoke-virtual {v1, v2, p2}, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Ljava/io/DataOutputStream;)V

    .line 29
    new-instance v1, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;-><init>()V

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->getNewNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v2

    invoke-virtual {v1, v2, p2}, Lcom/amazon/rio/j2me/client/codec/NotificationTargetDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;Ljava/io/DataOutputStream;)V

    .line 31
    return-void
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/UpdateNotificationTargetRequestDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;Ljava/io/DataOutputStream;)V

    return-void
.end method
