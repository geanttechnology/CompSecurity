.class public Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;
.super Ljava/lang/Object;
.source "LoginRequest.java"


# instance fields
.field private email:Ljava/lang/String;

.field private notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

.field private oneClickDeviceName:Ljava/lang/String;

.field private password:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getNotificationTarget()Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    return-object v0
.end method

.method public getOneClickDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->oneClickDeviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->password:Ljava/lang/String;

    return-object v0
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->email:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public setNotificationTarget(Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->notificationTarget:Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    .line 62
    return-void
.end method

.method public setOneClickDeviceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->oneClickDeviceName:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->password:Ljava/lang/String;

    .line 36
    return-void
.end method
