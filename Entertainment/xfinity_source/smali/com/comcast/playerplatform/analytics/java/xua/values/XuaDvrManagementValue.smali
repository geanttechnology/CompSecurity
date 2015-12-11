.class public Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;
.super Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
.source "XuaDvrManagementValue.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private count:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "COUNT"
    .end annotation
.end field

.field private type:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "TYPE"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "count"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;->count:Ljava/lang/String;

    .line 24
    iput-object p2, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;->type:Ljava/lang/String;

    .line 25
    return-void
.end method


# virtual methods
.method public getCount()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 29
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;->count:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setCount(Ljava/lang/String;)V
    .locals 0
    .param p1, "count"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;->count:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaDvrManagementValue;->type:Ljava/lang/String;

    .line 43
    return-void
.end method
