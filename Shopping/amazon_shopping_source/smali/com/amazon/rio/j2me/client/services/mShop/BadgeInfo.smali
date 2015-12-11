.class public Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
.super Ljava/lang/Object;
.source "BadgeInfo.java"


# instance fields
.field private badge:Lcom/amazon/rio/j2me/client/services/mShop/Badge;

.field private detailedMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

.field private prominentMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->badge:Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    return-object v0
.end method

.method public getDetailedMessage()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->detailedMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    return-object v0
.end method

.method public getProminentMessage()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->prominentMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    return-object v0
.end method

.method public setBadge(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->badge:Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .line 54
    return-void
.end method

.method public setDetailedMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->detailedMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .line 41
    return-void
.end method

.method public setProminentMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->prominentMessage:Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .line 28
    return-void
.end method
