.class public Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;
.super Ljava/lang/Object;
.source "PushNotificationSubscriptionGroup.java"


# instance fields
.field private details:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

.field private groupId:Ljava/lang/String;

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
    .line 42
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->details:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    return-object v0
.end method

.method public getGroupId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->groupId:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setDetails(Lcom/amazon/rio/j2me/client/services/mShop/HyperText;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->details:Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 48
    return-void
.end method

.method public setGroupId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->groupId:Ljava/lang/String;

    .line 25
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/PushNotificationSubscriptionGroup;->title:Ljava/lang/String;

    .line 35
    return-void
.end method
