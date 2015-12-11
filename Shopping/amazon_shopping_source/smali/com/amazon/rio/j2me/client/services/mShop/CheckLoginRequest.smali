.class public Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;
.super Ljava/lang/Object;
.source "CheckLoginRequest.java"


# instance fields
.field private notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

.field private oneClickDeviceName:Ljava/lang/String;


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
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    return-object v0
.end method

.method public getOneClickDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->oneClickDeviceName:Ljava/lang/String;

    return-object v0
.end method

.method public setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 40
    return-void
.end method

.method public setOneClickDeviceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/CheckLoginRequest;->oneClickDeviceName:Ljava/lang/String;

    .line 27
    return-void
.end method
