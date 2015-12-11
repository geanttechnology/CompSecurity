.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
.super Ljava/lang/Object;
.source "XuaMessage.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private analyticsEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "EVT"
    .end annotation
.end field

.field private applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "APP"
    .end annotation
.end field

.field private protocolVersion:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "APV"
    .end annotation
.end field

.field private sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SES"
    .end annotation
.end field

.field private xuaDeviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DEV"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V
    .locals 0
    .param p1, "protocolVersion"    # Ljava/lang/String;
    .param p2, "appInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;
    .param p3, "deviceInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;
    .param p4, "sessionInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;
    .param p5, "analyticsEvent"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->protocolVersion:Ljava/lang/String;

    .line 41
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    .line 42
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->xuaDeviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    .line 43
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    .line 44
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->analyticsEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    .line 45
    return-void
.end method


# virtual methods
.method public getAnalyticsEvent()Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->analyticsEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    return-object v0
.end method

.method public getApplicationInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    return-object v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->analyticsEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;->getEventName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getProtocolVersion()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->protocolVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getSessionInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    return-object v0
.end method

.method public getXuaDeviceInfo()Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->xuaDeviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    return-object v0
.end method

.method public setAnalyticsEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V
    .locals 0
    .param p1, "analyticsEvent"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->analyticsEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;

    .line 94
    return-void
.end method

.method public setApplicationInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;)V
    .locals 0
    .param p1, "applicationInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->applicationInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaApplicationInfo;

    .line 65
    return-void
.end method

.method public setProtocolVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "protocolVersion"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->protocolVersion:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setSessionInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;)V
    .locals 0
    .param p1, "sessionInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->sessionInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaSessionInfo;

    .line 83
    return-void
.end method

.method public setXuaDeviceInfo(Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;)V
    .locals 0
    .param p1, "xuaDeviceInfo"    # Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;->xuaDeviceInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaDeviceInfo;

    .line 74
    return-void
.end method
