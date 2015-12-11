.class public Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;
.super Ljava/lang/Object;
.source "LoginResponse.java"


# instance fields
.field private loginData:Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

.field private notification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getLoginData()Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->loginData:Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    return-object v0
.end method

.method public getNotification()Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->notification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    return-object v0
.end method

.method public setLoginData(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->loginData:Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    .line 27
    return-void
.end method

.method public setNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->notification:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .line 40
    return-void
.end method
