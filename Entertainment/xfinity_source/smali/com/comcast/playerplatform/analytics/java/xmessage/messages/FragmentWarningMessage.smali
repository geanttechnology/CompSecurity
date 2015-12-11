.class public Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;
.super Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.source "FragmentWarningMessage.java"


# instance fields
.field private downloadDuration:I

.field private downloadLatency:I

.field private evtTimestamp:J

.field private fragmentDuration:I

.field private fragmentSize:I

.field private fragmentUrl:Ljava/lang/String;

.field private xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;


# direct methods
.method public constructor <init>(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Ljava/lang/String;IIII)V
    .locals 1
    .param p1, "evtTimestamp"    # J
    .param p3, "xuaAsset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .param p4, "fragmentUrl"    # Ljava/lang/String;
    .param p5, "fragmentSize"    # I
    .param p6, "downloadLatency"    # I
    .param p7, "downloadDuration"    # I
    .param p8, "fragmentDuration"    # I

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;-><init>()V

    .line 25
    iput-wide p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->evtTimestamp:J

    .line 26
    iput-object p3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .line 27
    iput-object p4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->fragmentUrl:Ljava/lang/String;

    .line 28
    iput p5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->fragmentSize:I

    .line 29
    iput p6, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->downloadLatency:I

    .line 30
    iput p7, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->downloadDuration:I

    .line 31
    iput p8, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->fragmentDuration:I

    .line 32
    return-void
.end method


# virtual methods
.method public buildXuaEvent()V
    .locals 5

    .prologue
    .line 42
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;

    iget-wide v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->evtTimestamp:J

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaFragmentWarning:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getValue()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;

    move-result-object v4

    invoke-direct {v0, v2, v3, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 43
    .local v0, "event":Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;
    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->xuaAsset:Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEvent;->setAsset(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    .line 44
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setEvent(Lcom/comcast/playerplatform/analytics/java/xua/XuaBaseEvent;)V

    .line 45
    return-void
.end method

.method public buildXuaValue()V
    .locals 6

    .prologue
    .line 36
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;

    iget-object v1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->fragmentUrl:Ljava/lang/String;

    iget v2, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->fragmentSize:I

    iget v3, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->downloadLatency:I

    iget v4, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->downloadDuration:I

    iget v5, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->fragmentDuration:I

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;-><init>(Ljava/lang/String;IIII)V

    .line 37
    .local v0, "value":Lcom/comcast/playerplatform/analytics/java/xua/values/XuaFragmentWarningValue;
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->setValue(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaValue;)V

    .line 38
    return-void
.end method
