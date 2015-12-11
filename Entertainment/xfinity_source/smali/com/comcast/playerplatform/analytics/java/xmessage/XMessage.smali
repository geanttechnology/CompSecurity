.class public Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;
.super Ljava/lang/Object;
.source "XMessage.java"


# instance fields
.field private applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

.field private asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

.field private deviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

.field private event:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

.field private protocol:Ljava/lang/String;

.field private sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

.field private value:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getApplicationInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    return-object v0
.end method

.method public getAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    return-object v0
.end method

.method public getDeviceInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->deviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    return-object v0
.end method

.method public getEvent()Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->event:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    return-object v0
.end method

.method public getFormattedMessage()Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    .locals 6

    .prologue
    .line 25
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->protocol:Ljava/lang/String;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    iget-object v3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->deviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    iget-object v5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->event:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;-><init>(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    return-object v0
.end method

.method public getSessionInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    return-object v0
.end method

.method public getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->value:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    return-object v0
.end method

.method public setApplicationInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;)V
    .locals 0
    .param p1, "applicationInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    .line 64
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 0
    .param p1, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->asset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 40
    return-void
.end method

.method public setDeviceInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;)V
    .locals 0
    .param p1, "deviceInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->deviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    .line 80
    return-void
.end method

.method public setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V
    .locals 0
    .param p1, "event"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->event:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    .line 48
    return-void
.end method

.method public setProtocol(Ljava/lang/String;)V
    .locals 0
    .param p1, "protocol"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->protocol:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setSessionInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;)V
    .locals 0
    .param p1, "sessionInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    .line 72
    return-void
.end method

.method public setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V
    .locals 0
    .param p1, "value"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->value:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .line 56
    return-void
.end method
