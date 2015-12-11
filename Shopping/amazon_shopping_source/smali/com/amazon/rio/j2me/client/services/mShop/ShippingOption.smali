.class public Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;
.super Ljava/lang/Object;
.source "ShippingOption.java"


# instance fields
.field private selected:Ljava/lang/Integer;

.field private shipSplitPreferenceKey:Ljava/lang/String;

.field private shipSplitPreferenceText:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setSelected(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;->selected:Ljava/lang/Integer;

    .line 48
    return-void
.end method

.method public setShipSplitPreferenceKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;->shipSplitPreferenceKey:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setShipSplitPreferenceText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOption;->shipSplitPreferenceText:Ljava/lang/String;

    .line 25
    return-void
.end method
