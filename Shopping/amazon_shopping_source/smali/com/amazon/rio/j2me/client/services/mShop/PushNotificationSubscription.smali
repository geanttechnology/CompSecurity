.class public Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;
.super Ljava/lang/Object;
.source "PushNotificationSubscription.java"


# instance fields
.field private details:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

.field private groupId:Ljava/lang/String;

.field private requiresUserRecognized:Ljava/lang/Boolean;

.field private subscribed:Z

.field private subscriptionId:Ljava/lang/String;

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDetails()Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->details:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    return-object v0
.end method

.method public getGroupId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->groupId:Ljava/lang/String;

    return-object v0
.end method

.method public getRequiresUserRecognized()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->requiresUserRecognized:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getSubscribed()Z
    .locals 1

    .prologue
    .line 58
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->subscribed:Z

    return v0
.end method

.method public getSubscriptionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->subscriptionId:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setDetails(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->details:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 90
    return-void
.end method

.method public setGroupId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->groupId:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setRequiresUserRecognized(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->requiresUserRecognized:Ljava/lang/Boolean;

    .line 77
    return-void
.end method

.method public setSubscribed(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 63
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->subscribed:Z

    .line 64
    return-void
.end method

.method public setSubscriptionId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->subscriptionId:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscription;->title:Ljava/lang/String;

    .line 54
    return-void
.end method
