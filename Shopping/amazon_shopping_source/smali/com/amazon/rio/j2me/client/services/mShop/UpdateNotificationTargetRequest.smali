.class public Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;
.super Ljava/lang/Object;
.source "UpdateNotificationTargetRequest.java"


# instance fields
.field private newNotificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

.field private oldNotificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getNewNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->newNotificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    return-object v0
.end method

.method public getOldNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->oldNotificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    return-object v0
.end method

.method public setNewNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->newNotificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 34
    return-void
.end method

.method public setOldNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/UpdateNotificationTargetRequest;->oldNotificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 24
    return-void
.end method
