.class public Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;
.super Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
.source "XuaHeartbeatEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;,
        Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;
    }
.end annotation


# instance fields
.field private environment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "ENV"
    .end annotation
.end field

.field private fragment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonProperty;
        value = "FRAGMENT"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>()V

    .line 23
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V
    .locals 1
    .param p1, "timestamp"    # J
    .param p3, "eventName"    # Ljava/lang/String;
    .param p4, "xuaValue"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 27
    return-void
.end method


# virtual methods
.method public getEnvironment()Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;->environment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;

    return-object v0
.end method

.method public getFragment()Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;->fragment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

    return-object v0
.end method

.method public setEnvironment(Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;)V
    .locals 0
    .param p1, "environment"    # Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;->environment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatEnvironment;

    .line 35
    return-void
.end method

.method public setFragment(Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;)V
    .locals 0
    .param p1, "fragment"    # Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;->fragment:Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent$HeartbeatFragment;

    .line 43
    return-void
.end method
