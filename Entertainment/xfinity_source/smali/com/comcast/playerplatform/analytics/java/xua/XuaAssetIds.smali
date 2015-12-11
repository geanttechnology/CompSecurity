.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;
.super Ljava/lang/Object;
.source "XuaAssetIds.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/databind/annotation/JsonSerialize;
    include = .enum Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;->NON_NULL:Lcom/fasterxml/jackson/databind/annotation/JsonSerialize$Inclusion;
.end annotation


# instance fields
.field private AID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private LID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private MediaGUID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private NAME:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private NS:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private PID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private RECID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private RID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private STRID:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private URL:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
    .end annotation
.end field

.field private otherIds:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->AID:Ljava/lang/String;

    return-object v0
.end method

.method public getLID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->LID:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaGUID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 132
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->MediaGUID:Ljava/lang/String;

    return-object v0
.end method

.method public getNAME()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 96
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->NAME:Ljava/lang/String;

    return-object v0
.end method

.method public getNS()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 123
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->NS:Ljava/lang/String;

    return-object v0
.end method

.method public getOtherIds()Ljava/util/Map;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonAnyGetter;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->otherIds:Ljava/util/Map;

    return-object v0
.end method

.method public getPID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 87
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->PID:Ljava/lang/String;

    return-object v0
.end method

.method public getRECID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 114
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->RECID:Ljava/lang/String;

    return-object v0
.end method

.method public getRID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->RID:Ljava/lang/String;

    return-object v0
.end method

.method public getSTRID()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->STRID:Ljava/lang/String;

    return-object v0
.end method

.method public getURL()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->URL:Ljava/lang/String;

    return-object v0
.end method

.method public setAID(Ljava/lang/String;)V
    .locals 0
    .param p1, "AID"    # Ljava/lang/String;

    .prologue
    .line 82
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->AID:Ljava/lang/String;

    .line 83
    return-void
.end method

.method public setLID(Ljava/lang/String;)V
    .locals 0
    .param p1, "LID"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->LID:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setMediaGUID(Ljava/lang/String;)V
    .locals 0
    .param p1, "mediaGUID"    # Ljava/lang/String;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->MediaGUID:Ljava/lang/String;

    .line 137
    return-void
.end method

.method public setNAME(Ljava/lang/String;)V
    .locals 0
    .param p1, "NAME"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->NAME:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setNS(Ljava/lang/String;)V
    .locals 0
    .param p1, "NS"    # Ljava/lang/String;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->NS:Ljava/lang/String;

    .line 128
    return-void
.end method

.method public setOtherIds(Ljava/util/Map;)V
    .locals 0
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonAnySetter;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 146
    .local p1, "otherIds":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->otherIds:Ljava/util/Map;

    .line 147
    return-void
.end method

.method public setPID(Ljava/lang/String;)V
    .locals 0
    .param p1, "PID"    # Ljava/lang/String;

    .prologue
    .line 91
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->PID:Ljava/lang/String;

    .line 92
    return-void
.end method

.method public setRECID(Ljava/lang/String;)V
    .locals 0
    .param p1, "RECID"    # Ljava/lang/String;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->RECID:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public setRID(Ljava/lang/String;)V
    .locals 0
    .param p1, "RID"    # Ljava/lang/String;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->RID:Ljava/lang/String;

    .line 65
    return-void
.end method

.method public setSTRID(Ljava/lang/String;)V
    .locals 0
    .param p1, "STRID"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->STRID:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "URL"    # Ljava/lang/String;

    .prologue
    .line 73
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaAssetIds;->URL:Ljava/lang/String;

    .line 74
    return-void
.end method
