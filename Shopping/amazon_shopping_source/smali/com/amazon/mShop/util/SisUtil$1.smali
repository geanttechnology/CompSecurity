.class final Lcom/amazon/mShop/util/SisUtil$1;
.super Ljava/lang/Object;
.source "SisUtil.java"

# interfaces
.implements Lcom/amazon/mShop/control/home/HomeSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/SisUtil;->reset(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAvailableCountReceived(I)V
    .locals 0
    .param p1, "availableCount"    # I

    .prologue
    .line 92
    return-void
.end method

.method public onCancelled()V
    .locals 0

    .prologue
    .line 98
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 114
    return-void
.end method

.method public onHomeCallStarted()V
    .locals 0

    .prologue
    .line 116
    return-void
.end method

.method public onHomeShoveler0Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 0
    .param p1, "homeShoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 124
    return-void
.end method

.method public onHomeShoveler1Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 0
    .param p1, "homeShoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 126
    return-void
.end method

.method public onNotificationReceived(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 118
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 0
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 94
    return-void
.end method

.method public onObjectsReceived()V
    .locals 0

    .prologue
    .line 96
    return-void
.end method

.method public onPageComplete()V
    .locals 0

    .prologue
    .line 110
    invoke-static {}, Lcom/amazon/mShop/util/SisUtil;->identify()V

    .line 111
    return-void
.end method

.method public onPromoSlot0Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 120
    return-void
.end method

.method public onPromoSlot1Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 122
    return-void
.end method

.method public preHomeCallStarted()V
    .locals 0

    .prologue
    .line 90
    return-void
.end method
