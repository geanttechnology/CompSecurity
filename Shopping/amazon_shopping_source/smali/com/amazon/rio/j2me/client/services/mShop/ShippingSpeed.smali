.class public Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;
.super Ljava/lang/Object;
.source "ShippingSpeed.java"


# instance fields
.field private deliveryInstructionRemarkSupported:Ljava/lang/Boolean;

.field private deliveryTimePreference:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private earliestDate:Ljava/lang/Integer;

.field private latestDate:Ljava/lang/Integer;

.field private selected:Ljava/lang/Integer;

.field private shipSpeedKey:Ljava/lang/String;

.field private shipSpeedText:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public setDeliveryInstructionRemarkSupported(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;->deliveryInstructionRemarkSupported:Ljava/lang/Boolean;

    .line 104
    return-void
.end method

.method public setDeliveryTimePreference(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 90
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;->deliveryTimePreference:Ljava/util/List;

    .line 91
    return-void
.end method

.method public setEarliestDate(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;->earliestDate:Ljava/lang/Integer;

    .line 65
    return-void
.end method

.method public setLatestDate(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;->latestDate:Ljava/lang/Integer;

    .line 78
    return-void
.end method

.method public setSelected(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;->selected:Ljava/lang/Integer;

    .line 52
    return-void
.end method

.method public setShipSpeedKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;->shipSpeedKey:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setShipSpeedText(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ShippingSpeed;->shipSpeedText:Ljava/lang/String;

    .line 29
    return-void
.end method
