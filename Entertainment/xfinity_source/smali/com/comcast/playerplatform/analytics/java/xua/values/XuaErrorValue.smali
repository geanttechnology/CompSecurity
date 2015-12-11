.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaErrorValue.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


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

.field private errorClass:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "CLASS"
    .end annotation
.end field

.field private otherValues:Ljava/util/Map;
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
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "errorClass"    # Ljava/lang/String;
    .param p3, "description"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p4, "otherValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->code:Ljava/lang/String;

    .line 33
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->errorClass:Ljava/lang/String;

    .line 34
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->description:Ljava/lang/String;

    .line 35
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->otherValues:Ljava/util/Map;

    .line 36
    return-void
.end method


# virtual methods
.method public getCode()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 40
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->code:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorClass()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->errorClass:Ljava/lang/String;

    return-object v0
.end method

.method public getOtherValues()Ljava/util/Map;
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
    .line 67
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->otherValues:Ljava/util/Map;

    return-object v0
.end method

.method public setCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "code"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->code:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->description:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setErrorClass(Ljava/lang/String;)V
    .locals 0
    .param p1, "errorClass"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->errorClass:Ljava/lang/String;

    .line 54
    return-void
.end method

.method public setMap(Ljava/util/Map;)V
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
    .line 72
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;->otherValues:Ljava/util/Map;

    .line 73
    return-void
.end method
