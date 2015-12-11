.class public interface abstract Lcom/amazon/mShop/pushnotification/NotificationProvider;
.super Ljava/lang/Object;
.source "NotificationProvider.java"


# virtual methods
.method public abstract constructNotificationParams(Landroid/content/Intent;)Lcom/amazon/mShop/pushnotification/NotificationParams;
.end method

.method public abstract getCurrentMShopRegistrationToken()Ljava/lang/String;
.end method

.method public abstract getCurrentPushNotificationErrorId()Ljava/lang/String;
.end method

.method public abstract getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
.end method

.method public abstract getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
.end method

.method public abstract getProviderName()Ljava/lang/String;
.end method

.method public abstract handleClickActionOnErrorButton(Landroid/app/Activity;Ljava/lang/String;)V
.end method

.method public abstract isAvailable(Landroid/content/Context;)Z
.end method

.method public abstract onMainActivityDestroyed(Landroid/content/Context;)V
.end method

.method public abstract setCurrentMShopRegistrationToken(Ljava/lang/String;)V
.end method

.method public abstract setCurrentPushNotificationErrorId(Ljava/lang/String;)V
.end method

.method public abstract startRegister(Landroid/content/Context;)V
.end method
