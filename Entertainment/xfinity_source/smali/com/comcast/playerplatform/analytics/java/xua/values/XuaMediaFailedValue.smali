.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaMediaFailedValue.java"


# instance fields
.field private code:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CODE"
    .end annotation
.end field

.field private description:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "DESCR"
    .end annotation
.end field

.field private manifestUrl:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "MANIF"
    .end annotation
.end field

.field private pos:J
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "POS"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V
    .locals 1
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "pos"    # J
    .param p5, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->code:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->description:Ljava/lang/String;

    .line 38
    iput-wide p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->pos:J

    .line 39
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->manifestUrl:Ljava/lang/String;

    .line 40
    return-void
.end method


# virtual methods
.method public getCode()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 44
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->code:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getManifestUrl()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getPos()J
    .locals 2
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 62
    iget-wide v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->pos:J

    return-wide v0
.end method

.method public setCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->code:Ljava/lang/String;

    .line 49
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->description:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setManifestUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->manifestUrl:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setPos(J)V
    .locals 1
    .param p1, "pos"    # J

    .prologue
    .line 66
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMediaFailedValue;->pos:J

    .line 67
    return-void
.end method
