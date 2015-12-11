.class Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$OneClickBasicInfoResponseListener;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "OneClickBasicInfoResponseListener"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 372
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$1;

    .prologue
    .line 372
    invoke-direct {p0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$OneClickBasicInfoResponseListener;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 380
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 384
    if-eqz p1, :cond_0

    .line 385
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$700()Lcom/amazon/mShop/wearable/model/MobileState;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;->getCity()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickCity:Ljava/lang/String;

    .line 386
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$700()Lcom/amazon/mShop/wearable/model/MobileState;

    move-result-object v0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/GetOneClickBasicInfoResponse;->getFullName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickName:Ljava/lang/String;

    .line 388
    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMobileState()V
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1200()V

    .line 390
    :cond_0
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 375
    const-string/jumbo v0, "WearListenerService"

    const-string/jumbo v1, "Unable to query one click info"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 376
    return-void
.end method
