.class public Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;
.super Ljava/lang/Object;
.source "XuaNetworkInfo.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonInclude;
    value = .enum Lcom/fasterxml/jackson/annotation/JsonInclude$Include;->NON_NULL:Lcom/fasterxml/jackson/annotation/JsonInclude$Include;
.end annotation


# instance fields
.field private inHomeState:Ljava/lang/String;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "IHS"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "inHomeState"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaNetworkInfo;->inHomeState:Ljava/lang/String;

    .line 18
    return-void
.end method
