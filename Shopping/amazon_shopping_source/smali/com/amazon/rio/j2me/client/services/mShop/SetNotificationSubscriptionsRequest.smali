.class public Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;
.super Ljava/lang/Object;
.source "SetNotificationSubscriptionsRequest.java"


# instance fields
.field private notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

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
.method public getNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

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
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;->subscriptions:Ljava/util/List;

    return-object v0
.end method

.method public setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 24
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
    .line 33
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/SetNotificationSubscriptionsRequest;->subscriptions:Ljava/util/List;

    .line 34
    return-void
.end method
