.class Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$1;
.super Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;
.source "XuaJsonInterpreter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;->setupXuaBaseDeserializer(Lcom/fasterxml/jackson/databind/ObjectMapper;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;)V
    .locals 2

    .prologue
    .line 78
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$1;->this$0:Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter;

    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$XuaBaseEventDeserializer;-><init>()V

    .line 79
    const-string v0, "XuaEvent"

    const-class v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    invoke-virtual {p0, v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$1;->registerXuaBaseEvent(Ljava/lang/String;Ljava/lang/Class;)V

    .line 80
    const-string v0, "XuaGenericEvent"

    const-class v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaGenericEvent;

    invoke-virtual {p0, v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$1;->registerXuaBaseEvent(Ljava/lang/String;Ljava/lang/Class;)V

    .line 81
    const-string v0, "XuaHeartbeatEvent"

    const-class v1, Lcom/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent;

    invoke-virtual {p0, v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaJsonInterpreter$1;->registerXuaBaseEvent(Ljava/lang/String;Ljava/lang/Class;)V

    .line 82
    return-void
.end method
