.class interface abstract Lcom/amazon/device/ads/IInternalAdRegistration;
.super Ljava/lang/Object;
.source "InternalAdRegistration.java"


# virtual methods
.method public abstract contextReceived(Landroid/content/Context;)V
.end method

.method public abstract getAppInfo()Lcom/amazon/device/ads/AppInfo;
.end method

.method public abstract getApplicationContext()Landroid/content/Context;
.end method

.method public abstract getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;
.end method

.method public abstract getFilesDir()Ljava/io/File;
.end method

.method public abstract getIsAppDisabled()Z
.end method

.method public abstract getNoRetryTtlRemainingMillis()I
.end method

.method public abstract getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;
.end method

.method public abstract isRegistered()Z
.end method

.method public abstract register()V
.end method

.method public abstract setIsAppDisabled(Z)V
.end method

.method public abstract setNoRetryTtl(I)V
.end method
