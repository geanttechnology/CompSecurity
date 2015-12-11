.class public Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;
.super Ljava/lang/Object;
.source "XMessageComposer.java"


# instance fields
.field private messageBuilder:Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public constructMessage()V
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->messageBuilder:Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;->buildNewMessage()V

    .line 35
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->messageBuilder:Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;->buildXuaValue()V

    .line 36
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->messageBuilder:Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;->buildXuaAsset()V

    .line 37
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->messageBuilder:Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;->buildXuaEvent()V

    .line 38
    return-void
.end method

.method public getFormattedMessage()Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;
    .locals 1

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;->getFormattedMessage()Lcom/comcast/playerplatform/analytics/java/xua/XuaMessage;

    move-result-object v0

    return-object v0
.end method

.method public getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->messageBuilder:Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;->getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    move-result-object v0

    return-object v0
.end method

.method public setMessageBuilder(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V
    .locals 0
    .param p1, "messageBuilder"    # Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessageComposer;->messageBuilder:Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    .line 20
    return-void
.end method
