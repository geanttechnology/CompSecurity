.class public abstract Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
.super Ljava/lang/Object;
.source "SSODeviceInfo.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getBuildName()Ljava/lang/String;
.end method

.method public abstract getBuildNumber()I
.end method

.method public getDeviceSecret()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract getDeviceSerialNumber()Ljava/lang/String;
.end method

.method public abstract getDeviceType()Ljava/lang/String;
.end method

.method public getMacAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSoftwareVersion()Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;
    .locals 2

    .prologue
    .line 12
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getBuildNumber()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/kcpsdk/common/SoftwareVersion;-><init>(Ljava/lang/String;)V

    return-object v0
.end method
