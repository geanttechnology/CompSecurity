.class public Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;
.super Ljava/lang/Object;
.source "ToggleMarketplaceNotificationsRequest.java"


# instance fields
.field private enableNotifications:Ljava/lang/Boolean;

.field private notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

.field private recognizedRequiredOnly:Ljava/lang/Boolean;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getEnableNotifications()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;->enableNotifications:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    return-object v0
.end method

.method public getRecognizedRequiredOnly()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;->recognizedRequiredOnly:Ljava/lang/Boolean;

    return-object v0
.end method

.method public setEnableNotifications(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;->enableNotifications:Ljava/lang/Boolean;

    .line 28
    return-void
.end method

.method public setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ToggleMarketplaceNotificationsRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 41
    return-void
.end method
