.class public Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;
.super Ljava/lang/Object;
.source "GetNotificationSubscriptionsRequest.java"


# instance fields
.field private notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;


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
    .line 17
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    return-object v0
.end method

.method public setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GetNotificationSubscriptionsRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 23
    return-void
.end method
