.class public Lcom/xfinity/playerlib/downloads/DeviceRegistration;
.super Ljava/lang/Object;
.source "DeviceRegistration.java"


# instance fields
.field private deviceAuthorizationToken:Ljava/lang/String;

.field private deviceId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDeviceAuthorizationToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/DeviceRegistration;->deviceAuthorizationToken:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/DeviceRegistration;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 21
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "deviceAuthorizationToken"

    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/DeviceRegistration;->deviceAuthorizationToken:Ljava/lang/String;

    .line 22
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "deviceId"

    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/DeviceRegistration;->deviceId:Ljava/lang/String;

    .line 23
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    .line 24
    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
