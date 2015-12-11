.class public interface abstract Lcom/amazon/mShop/platform/Platform;
.super Ljava/lang/Object;
.source "Platform.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/platform/Platform$Factory;
    }
.end annotation


# virtual methods
.method public abstract getAppStartCountForAllLocales()I
.end method

.method public abstract getApplicationContext()Ljava/lang/Object;
.end method

.method public abstract getApplicationId()Ljava/lang/String;
.end method

.method public abstract getApplicationVersion()Ljava/lang/String;
.end method

.method public abstract getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;
.end method

.method public abstract getDeviceName()Ljava/lang/String;
.end method

.method public abstract getLogger(Ljava/lang/Class;)Lcom/amazon/rio/j2me/client/util/Logger;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/amazon/rio/j2me/client/util/Logger;"
        }
    .end annotation
.end method

.method public abstract getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;
.end method

.method public abstract getResources()Lcom/amazon/mShop/platform/Resources;
.end method

.method public abstract invokeLater(Ljava/lang/Runnable;)V
.end method

.method public abstract invokeLater(Ljava/lang/Runnable;J)V
.end method

.method public abstract isAmazonAppStoreSupported()Z
.end method

.method public abstract isAmazonKindleSupported()Z
.end method

.method public abstract isAmazonMp3Supported()Z
.end method

.method public abstract isAmazonVideoSupported()Z
.end method

.method public abstract resetApplicationId()V
.end method

.method public abstract runOnUiThread(Ljava/lang/Runnable;)V
.end method
