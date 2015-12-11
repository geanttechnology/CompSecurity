.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaSearchValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaSearchValue.java"


# instance fields
.field private query:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "QUERY"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaSearchValue;->query:Ljava/lang/String;

    .line 18
    return-void
.end method


# virtual methods
.method public getQuery()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 22
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaSearchValue;->query:Ljava/lang/String;

    return-object v0
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaSearchValue;->query:Ljava/lang/String;

    .line 27
    return-void
.end method
