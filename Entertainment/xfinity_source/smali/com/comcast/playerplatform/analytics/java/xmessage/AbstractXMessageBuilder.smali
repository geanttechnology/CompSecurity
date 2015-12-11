.class public abstract Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;
.super Ljava/lang/Object;
.source "AbstractXMessageBuilder.java"


# instance fields
.field private message:Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public buildNewMessage()V
    .locals 1

    .prologue
    .line 22
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    invoke-direct {v0}, Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;->message:Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    .line 23
    return-void
.end method

.method public buildXuaAsset()V
    .locals 0

    .prologue
    .line 33
    return-void
.end method

.method public buildXuaEvent()V
    .locals 0

    .prologue
    .line 38
    return-void
.end method

.method public buildXuaValue()V
    .locals 0

    .prologue
    .line 28
    return-void
.end method

.method public getMessage()Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;->message:Lcom/comcast/playerplatform/analytics/java/xmessage/XMessage;

    return-object v0
.end method
