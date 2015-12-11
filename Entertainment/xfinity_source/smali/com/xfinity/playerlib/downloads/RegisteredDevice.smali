.class public Lcom/xfinity/playerlib/downloads/RegisteredDevice;
.super Ljava/lang/Object;
.source "RegisteredDevice.java"


# instance fields
.field private authorizedBy:Ljava/lang/String;

.field private deviceId:Ljava/lang/String;

.field private deviceName:Ljava/lang/String;

.field private registeredDate:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAuthorizedBy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 10
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->authorizedBy:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getRegisteredDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->registeredDate:Ljava/lang/String;

    return-object v0
.end method
