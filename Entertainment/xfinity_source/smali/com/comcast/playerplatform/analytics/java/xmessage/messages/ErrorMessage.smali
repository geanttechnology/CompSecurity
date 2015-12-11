.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "ErrorMessage.java"


# instance fields
.field private code:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private errorClass:Ljava/lang/String;

.field private evtTimestamp:J

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

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "code"    # Ljava/lang/String;
    .param p4, "errorClass"    # Ljava/lang/String;
    .param p5, "description"    # Ljava/lang/String;
    .param p7, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;",
            ")V"
        }
    .end annotation

    .prologue
    .line 28
    .local p6, "otherValues":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 29
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->evtTimestamp:J

    .line 30
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->code:Ljava/lang/String;

    .line 31
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->errorClass:Ljava/lang/String;

    .line 32
    iput-object p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->description:Ljava/lang/String;

    .line 33
    iput-object p7, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 34
    iput-object p6, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->otherValues:Ljava/util/Map;

    .line 35
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 45
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaError:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 46
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 47
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 48
    return-void
.end method

.method public buildXuaValue()V
    .locals 5

    .prologue
    .line 39
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->code:Ljava/lang/String;

    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->errorClass:Ljava/lang/String;

    iget-object v3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->description:Ljava/lang/String;

    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->otherValues:Ljava/util/Map;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaErrorValue;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    .line 40
    .local v0, "value":Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 41
    return-void
.end method
