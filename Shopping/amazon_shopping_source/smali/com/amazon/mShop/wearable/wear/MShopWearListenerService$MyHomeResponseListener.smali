.class Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MyHomeResponseListener;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MyHomeResponseListener"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 393
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;

    .prologue
    .line 393
    invoke-direct {p0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MyHomeResponseListener;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 396
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 415
    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMobileState()V
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1200()V

    .line 416
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 400
    const-string/jumbo v0, "WearListenerService"

    const-string/jumbo v1, "Unable to query home info"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 401
    return-void
.end method

.method public receivedCartItems(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 420
    return-void
.end method

.method public receivedCompletedRemembersItemIds(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 424
    .local p1, "arg0":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    return-void
.end method

.method public receivedLoginData(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 405
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginData;->getPrimeOneClickStatus()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;

    move-result-object v0

    .line 406
    .local v0, "primeOneClick":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;
    if-eqz v0, :cond_0

    .line 407
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$700()Lcom/amazon/mShop/wearable/model/MobileState;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickStatus;->getIsOneClickEnabled()Z

    move-result v2

    iput-boolean v2, v1, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickEnabled:Z

    .line 411
    :goto_0
    return-void

    .line 409
    :cond_0
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$700()Lcom/amazon/mShop/wearable/model/MobileState;

    move-result-object v1

    const/4 v2, 0x0

    iput-boolean v2, v1, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickEnabled:Z

    goto :goto_0
.end method

.method public receivedNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 429
    return-void
.end method

.method public receivedPromoSlot0(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 433
    return-void
.end method

.method public receivedPromoSlot1(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 437
    return-void
.end method

.method public receivedShoveler0(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 441
    return-void
.end method

.method public receivedShoveler1(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 445
    return-void
.end method
