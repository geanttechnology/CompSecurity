.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/AdProgressMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;
.source "AdProgressMessage.java"


# direct methods
.method public constructor <init>(JILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 7
    .param p1, "evtTimestamp"    # J
    .param p3, "percentComplete"    # I
    .param p4, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 13
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaAdProgress:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v4

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    move-object v1, p0

    move-wide v2, p1

    move-object v6, p4

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/GenericStringMessage;-><init>(JLjava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 14
    return-void
.end method
