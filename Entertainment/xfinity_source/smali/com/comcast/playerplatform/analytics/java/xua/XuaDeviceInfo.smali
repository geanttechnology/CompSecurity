.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;
.super Ljava/lang/Object;
.source "XuaDeviceInfo.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private deviceId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DEV_ID"
    .end annotation
.end field

.field private deviceName:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DEV_NAME"
    .end annotation
.end field

.field private deviceVersion:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DEV_VER"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceName"    # Ljava/lang/String;
    .param p2, "deviceVersion"    # Ljava/lang/String;
    .param p3, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceName:Ljava/lang/String;

    .line 43
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceVersion:Ljava/lang/String;

    .line 44
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceId:Ljava/lang/String;

    .line 45
    return-void
.end method


# virtual methods
.method public getDeviceId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceVersion()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceVersion:Ljava/lang/String;

    return-object v0
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceId:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setDeviceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceName"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceName:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setDeviceVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceVersion"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;->deviceVersion:Ljava/lang/String;

    .line 72
    return-void
.end method
