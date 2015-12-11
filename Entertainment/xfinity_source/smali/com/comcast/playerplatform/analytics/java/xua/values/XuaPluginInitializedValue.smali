.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaPluginInitializedValue.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private cpuCore:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CPU_CORE"
    .end annotation
.end field

.field private cpuFamily:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CPU_FAMILY"
    .end annotation
.end field

.field private cpuSpeed:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CPU_SPEED"
    .end annotation
.end field

.field private frameworkId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "FRMWK_ID"
    .end annotation
.end field

.field private frameworkVersion:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "FRMWK_VER"
    .end annotation
.end field

.field private isNative:Ljava/lang/Boolean;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "NATIVE"
    .end annotation
.end field

.field private memAmount:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "MEM_AMT"
    .end annotation
.end field

.field private memType:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "MEM_TYPE"
    .end annotation
.end field

.field private network:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "NETWORK"
    .end annotation
.end field

.field private organization:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "ORGANIZATION"
    .end annotation
.end field

.field private osArchitecture:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "OS_ARCH"
    .end annotation
.end field

.field private osId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "OS_ID"
    .end annotation
.end field

.field private osVersion:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "OS_VER"
    .end annotation
.end field

.field private playerId:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PLAYER_ID"
    .end annotation
.end field

.field private playerVersion:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "PLAYER_VER"
    .end annotation
.end field

.field private screenHeight:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SCREEN_HEIGHT"
    .end annotation
.end field

.field private screenWidth:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SCREEN_WIDTH"
    .end annotation
.end field

.field private supportCdvr:Ljava/lang/Boolean;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SUPPORT_CDVR"
    .end annotation
.end field

.field private supportLinear:Ljava/lang/Boolean;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SUPPORT_LINEAR"
    .end annotation
.end field

.field private supportVod:Ljava/lang/Boolean;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "SUPPORT_VOD"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    return-void
.end method


# virtual methods
.method public getCpuCore()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 191
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->cpuCore:Ljava/lang/String;

    return-object v0
.end method

.method public getCpuFamily()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 182
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->cpuFamily:Ljava/lang/String;

    return-object v0
.end method

.method public getCpuSpeed()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 200
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->cpuSpeed:Ljava/lang/String;

    return-object v0
.end method

.method public getFrameworkId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->frameworkId:Ljava/lang/String;

    return-object v0
.end method

.method public getFrameworkVersion()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 114
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->frameworkVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getMemAmount()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 218
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->memAmount:Ljava/lang/String;

    return-object v0
.end method

.method public getMemType()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 209
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->memType:Ljava/lang/String;

    return-object v0
.end method

.method public getNetwork()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 227
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->network:Ljava/lang/String;

    return-object v0
.end method

.method public getOrganization()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->organization:Ljava/lang/String;

    return-object v0
.end method

.method public getOsArchitecture()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 173
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->osArchitecture:Ljava/lang/String;

    return-object v0
.end method

.method public getOsId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 155
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->osId:Ljava/lang/String;

    return-object v0
.end method

.method public getOsVersion()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 164
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->osVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getPlayerId()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->playerId:Ljava/lang/String;

    return-object v0
.end method

.method public getPlayerVersion()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->playerVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getScreenHeight()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 245
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->screenHeight:Ljava/lang/String;

    return-object v0
.end method

.method public getScreenWidth()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 236
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->screenWidth:Ljava/lang/String;

    return-object v0
.end method

.method public setCpuCore(Ljava/lang/String;)V
    .locals 0
    .param p1, "cpuCore"    # Ljava/lang/String;

    .prologue
    .line 195
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->cpuCore:Ljava/lang/String;

    .line 196
    return-void
.end method

.method public setCpuFamily(Ljava/lang/String;)V
    .locals 0
    .param p1, "cpuFamily"    # Ljava/lang/String;

    .prologue
    .line 186
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->cpuFamily:Ljava/lang/String;

    .line 187
    return-void
.end method

.method public setCpuSpeed(Ljava/lang/String;)V
    .locals 0
    .param p1, "cpuSpeed"    # Ljava/lang/String;

    .prologue
    .line 204
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->cpuSpeed:Ljava/lang/String;

    .line 205
    return-void
.end method

.method public setFrameworkId(Ljava/lang/String;)V
    .locals 0
    .param p1, "frameworkId"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->frameworkId:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setFrameworkVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "frameworkVersion"    # Ljava/lang/String;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->frameworkVersion:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public setMemAmount(Ljava/lang/String;)V
    .locals 0
    .param p1, "memAmount"    # Ljava/lang/String;

    .prologue
    .line 222
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->memAmount:Ljava/lang/String;

    .line 223
    return-void
.end method

.method public setMemType(Ljava/lang/String;)V
    .locals 0
    .param p1, "memType"    # Ljava/lang/String;

    .prologue
    .line 213
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->memType:Ljava/lang/String;

    .line 214
    return-void
.end method

.method public setNative(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "isNative"    # Ljava/lang/Boolean;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->isNative:Ljava/lang/Boolean;

    .line 127
    return-void
.end method

.method public setNetwork(Ljava/lang/String;)V
    .locals 0
    .param p1, "network"    # Ljava/lang/String;

    .prologue
    .line 231
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->network:Ljava/lang/String;

    .line 232
    return-void
.end method

.method public setOrganization(Ljava/lang/String;)V
    .locals 0
    .param p1, "organization"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->organization:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setOsArchitecture(Ljava/lang/String;)V
    .locals 0
    .param p1, "osArchitecture"    # Ljava/lang/String;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->osArchitecture:Ljava/lang/String;

    .line 178
    return-void
.end method

.method public setOsId(Ljava/lang/String;)V
    .locals 0
    .param p1, "osId"    # Ljava/lang/String;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->osId:Ljava/lang/String;

    .line 160
    return-void
.end method

.method public setOsVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "osVersion"    # Ljava/lang/String;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->osVersion:Ljava/lang/String;

    .line 169
    return-void
.end method

.method public setPlayerId(Ljava/lang/String;)V
    .locals 0
    .param p1, "playerId"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->playerId:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setPlayerVersion(Ljava/lang/String;)V
    .locals 0
    .param p1, "playerVersion"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->playerVersion:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setScreenHeight(Ljava/lang/String;)V
    .locals 0
    .param p1, "screenHeight"    # Ljava/lang/String;

    .prologue
    .line 249
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->screenHeight:Ljava/lang/String;

    .line 250
    return-void
.end method

.method public setScreenWidth(Ljava/lang/String;)V
    .locals 0
    .param p1, "screenWidth"    # Ljava/lang/String;

    .prologue
    .line 240
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->screenWidth:Ljava/lang/String;

    .line 241
    return-void
.end method

.method public setSupportCdvr(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "supportCdvr"    # Ljava/lang/Boolean;

    .prologue
    .line 150
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->supportCdvr:Ljava/lang/Boolean;

    .line 151
    return-void
.end method

.method public setSupportLinear(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "supportLinear"    # Ljava/lang/Boolean;

    .prologue
    .line 142
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->supportLinear:Ljava/lang/Boolean;

    .line 143
    return-void
.end method

.method public setSupportVod(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "supportVod"    # Ljava/lang/Boolean;

    .prologue
    .line 134
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaPluginInitializedValue;->supportVod:Ljava/lang/Boolean;

    .line 135
    return-void
.end method
