.class public Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;
.super Ljava/lang/Object;
.source "XuaHeartbeatEvent.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "HeartbeatEnvironment"
.end annotation


# instance fields
.field private bufferSize:Ljava/lang/Long;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "BSZ"
    .end annotation
.end field

.field private clientCpu:Ljava/lang/Float;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SCPU"
    .end annotation
.end field

.field private clientMem:Ljava/lang/Float;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "MEM"
    .end annotation
.end field

.field private clientNet:Ljava/lang/Float;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "NET"
    .end annotation
.end field

.field private playerCpu:Ljava/lang/Float;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PCPU"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Long;)V
    .locals 0
    .param p1, "clientCpu"    # Ljava/lang/Float;
    .param p2, "playerCpu"    # Ljava/lang/Float;
    .param p3, "clientNet"    # Ljava/lang/Float;
    .param p4, "clientMem"    # Ljava/lang/Float;
    .param p5, "bufferSize"    # Ljava/lang/Long;

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 83
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientCpu:Ljava/lang/Float;

    .line 84
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->playerCpu:Ljava/lang/Float;

    .line 85
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientNet:Ljava/lang/Float;

    .line 86
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientMem:Ljava/lang/Float;

    .line 87
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->bufferSize:Ljava/lang/Long;

    .line 88
    return-void
.end method


# virtual methods
.method public getBufferSize()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->bufferSize:Ljava/lang/Long;

    return-object v0
.end method

.method public getClientCpu()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientCpu:Ljava/lang/Float;

    return-object v0
.end method

.method public getClientMem()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientMem:Ljava/lang/Float;

    return-object v0
.end method

.method public getClientNet()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientNet:Ljava/lang/Float;

    return-object v0
.end method

.method public getPlayerCpu()Ljava/lang/Float;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->playerCpu:Ljava/lang/Float;

    return-object v0
.end method

.method public setBufferSize(Ljava/lang/Long;)V
    .locals 0
    .param p1, "bufferSize"    # Ljava/lang/Long;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->bufferSize:Ljava/lang/Long;

    .line 128
    return-void
.end method

.method public setClientCpu(Ljava/lang/Float;)V
    .locals 0
    .param p1, "clientCpu"    # Ljava/lang/Float;

    .prologue
    .line 95
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientCpu:Ljava/lang/Float;

    .line 96
    return-void
.end method

.method public setClientMem(Ljava/lang/Float;)V
    .locals 0
    .param p1, "clientMem"    # Ljava/lang/Float;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientMem:Ljava/lang/Float;

    .line 120
    return-void
.end method

.method public setClientNet(Ljava/lang/Float;)V
    .locals 0
    .param p1, "clientNet"    # Ljava/lang/Float;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->clientNet:Ljava/lang/Float;

    .line 112
    return-void
.end method

.method public setPlayerCpu(Ljava/lang/Float;)V
    .locals 0
    .param p1, "playerCpu"    # Ljava/lang/Float;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;->playerCpu:Ljava/lang/Float;

    .line 104
    return-void
.end method
