.class public Lcom/amazon/rio/j2me/client/codec/PushNotificationSubscriptionDefaultEncoder;
.super Ljava/lang/Object;
.source "PushNotificationSubscriptionDefaultEncoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Encoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Encoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;",
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
.method public encode(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/io/DataOutputStream;)V
    .locals 6
    .param p1, "o"    # Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
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

    .line 25
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscriptionId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 29
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_4

    move v0, v2

    .line 30
    .local v0, "isAbsent":Z
    :goto_0
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 31
    if-nez v0, :cond_0

    .line 33
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getGroupId()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 37
    :cond_0
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getTitle()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_5

    move v0, v2

    .line 38
    :goto_1
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 39
    if-nez v0, :cond_1

    .line 41
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getStringInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 46
    :cond_1
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v5

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getSubscribed()Z

    move-result v4

    if-eqz v4, :cond_6

    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    :goto_2
    invoke-interface {v5, v4, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 50
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getRequiresUserRecognized()Ljava/lang/Boolean;

    move-result-object v4

    if-nez v4, :cond_7

    move v0, v2

    .line 51
    :goto_3
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 52
    if-nez v0, :cond_2

    .line 54
    invoke-static {}, Lcom/amazon/rio/j2me/client/codec/DefaultEncoder;->getBooleanInstance()Lcom/amazon/rio/j2me/client/codec/Encoder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getRequiresUserRecognized()Ljava/lang/Boolean;

    move-result-object v5

    invoke-interface {v4, v5, p2}, Lcom/amazon/rio/j2me/client/codec/Encoder;->encode(Ljava/lang/Object;Ljava/io/DataOutputStream;)V

    .line 58
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v4

    if-nez v4, :cond_8

    move v0, v2

    .line 59
    :goto_4
    invoke-virtual {p2, v0}, Ljava/io/DataOutputStream;->writeBoolean(Z)V

    .line 60
    if-nez v0, :cond_3

    .line 62
    new-instance v2, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultEncoder;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultEncoder;-><init>()V

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    move-result-object v3

    invoke-virtual {v2, v3, p2}, Lcom/amazon/rio/j2me/client/codec/HyperTextDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;Ljava/io/DataOutputStream;)V

    .line 64
    :cond_3
    return-void

    .end local v0    # "isAbsent":Z
    :cond_4
    move v0, v3

    .line 29
    goto :goto_0

    .restart local v0    # "isAbsent":Z
    :cond_5
    move v0, v3

    .line 37
    goto :goto_1

    .line 46
    :cond_6
    sget-object v4, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_2

    :cond_7
    move v0, v3

    .line 50
    goto :goto_3

    :cond_8
    move v0, v3

    .line 58
    goto :goto_4
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
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/PushNotificationSubscriptionDefaultEncoder;->encode(Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;Ljava/io/DataOutputStream;)V

    return-void
.end method
