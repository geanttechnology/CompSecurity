.class Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeOneClickSubscriber;
.super Ljava/lang/Object;
.source "PrimeUpsellHelper.java"

# interfaces
.implements Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "PrimeOneClickSubscriber"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 290
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$1;

    .prologue
    .line 290
    invoke-direct {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeOneClickSubscriber;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 293
    # invokes: Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->refreshUserInfo()V
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->access$100()V

    .line 294
    return-void
.end method

.method public onReceiveOneClickAddresses(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 314
    .local p1, "oneClickAddresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;>;"
    return-void
.end method

.method public onReceiveOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V
    .locals 0
    .param p1, "oneClickConfigResponse"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    .prologue
    .line 309
    return-void
.end method

.method public onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 299
    return-void
.end method

.method public onSaveOneClickStatus(Z)V
    .locals 0
    .param p1, "oneClickEnabled"    # Z

    .prologue
    .line 303
    # invokes: Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->refreshUserInfo()V
    invoke-static {}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->access$100()V

    .line 304
    return-void
.end method
