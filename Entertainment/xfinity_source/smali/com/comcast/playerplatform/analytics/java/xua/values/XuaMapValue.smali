.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMapValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaMapValue.java"


# instance fields
.field private map:Ljava/util/Map;
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
.method public constructor <init>(Ljava/util/Map;)V
    .locals 0
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
    .line 16
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMapValue;->map:Ljava/util/Map;

    .line 18
    return-void
.end method


# virtual methods
.method public getMap()Ljava/util/Map;
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
    .line 22
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMapValue;->map:Ljava/util/Map;

    return-object v0
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
    .line 27
    .local p1, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaMapValue;->map:Ljava/util/Map;

    .line 28
    return-void
.end method
