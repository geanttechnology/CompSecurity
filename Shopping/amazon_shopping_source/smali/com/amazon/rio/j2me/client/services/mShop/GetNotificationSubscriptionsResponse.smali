.class public Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;
.super Ljava/lang/Object;
.source "GetNotificationSubscriptionsResponse.java"


# instance fields
.field private helpLink:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

.field private message:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

.field private subscriptionGroups:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;",
            ">;"
        }
    .end annotation
.end field

.field private subscriptions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getHelpLink()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->helpLink:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    return-object v0
.end method

.method public getMessage()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->message:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    return-object v0
.end method

.method public getSubscriptionGroups()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->subscriptionGroups:Ljava/util/List;

    return-object v0
.end method

.method public getSubscriptions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->subscriptions:Ljava/util/List;

    return-object v0
.end method

.method public setHelpLink(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->helpLink:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 62
    return-void
.end method

.method public setMessage(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->message:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 49
    return-void
.end method

.method public setSubscriptionGroups(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 25
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->subscriptionGroups:Ljava/util/List;

    .line 26
    return-void
.end method

.method public setSubscriptions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 35
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsResponse;->subscriptions:Ljava/util/List;

    .line 36
    return-void
.end method
