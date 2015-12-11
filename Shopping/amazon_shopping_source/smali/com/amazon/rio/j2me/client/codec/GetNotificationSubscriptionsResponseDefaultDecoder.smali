.class public Lcom/amazon/rio/j2me/client/codec/GetNotificationSubscriptionsResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "GetNotificationSubscriptionsResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;
    .locals 7
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 21
    new-instance v4, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;

    invoke-direct {v4}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;-><init>()V

    .line 27
    .local v4, "record":Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/PushNotificationSubscriptionGroupDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/PushNotificationSubscriptionGroupDefaultDecoder;-><init>()V

    invoke-static {v5}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/List;

    .line 28
    .local v2, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;>;"
    invoke-virtual {v4, v2}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->setSubscriptionGroups(Ljava/util/List;)V

    .line 32
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/PushNotificationSubscriptionDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/PushNotificationSubscriptionDefaultDecoder;-><init>()V

    invoke-static {v5}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v5

    invoke-interface {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 33
    .local v1, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;>;"
    invoke-virtual {v4, v1}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->setSubscriptions(Ljava/util/List;)V

    .line 36
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 37
    .local v3, "isAbsent":Z
    if-nez v3, :cond_0

    .line 39
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;-><init>()V

    invoke-virtual {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v0

    .line 40
    .local v0, "data":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    invoke-virtual {v4, v0}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->setMessage(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V

    .line 43
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    :cond_0
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readBoolean()Z

    move-result v3

    .line 44
    if-nez v3, :cond_1

    .line 46
    new-instance v5, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;

    invoke-direct {v5}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;-><init>()V

    invoke-virtual {v5, p1, v6}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v0

    .line 47
    .restart local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    invoke-virtual {v4, v0}, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->setHelpLink(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V

    .line 49
    .end local v0    # "data":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    :cond_1
    return-object v4
.end method

.method public bridge synthetic decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/DataInputStream;
    .param p2, "x1"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/GetNotificationSubscriptionsResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;

    move-result-object v0

    return-object v0
.end method
