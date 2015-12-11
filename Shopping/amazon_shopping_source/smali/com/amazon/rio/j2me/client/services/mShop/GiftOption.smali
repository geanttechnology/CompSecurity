.class public Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;
.super Ljava/lang/Object;
.source "GiftOption.java"


# instance fields
.field private desc:Ljava/lang/String;

.field private giftOptionKey:Ljava/lang/String;

.field private selected:Ljava/lang/Boolean;

.field private unitCharge:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setDesc(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;->desc:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setGiftOptionKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;->giftOptionKey:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setSelected(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;->selected:Ljava/lang/Boolean;

    .line 55
    return-void
.end method

.method public setUnitCharge(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/GiftOption;->unitCharge:Ljava/lang/String;

    .line 68
    return-void
.end method
