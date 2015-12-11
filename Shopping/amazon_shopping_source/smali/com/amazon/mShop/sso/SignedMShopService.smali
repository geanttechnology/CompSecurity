.class public Lcom/amazon/mShop/sso/SignedMShopService;
.super Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;
.source "SignedMShopService.java"


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 25
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;

    new-instance v2, Lcom/amazon/mShop/sso/SignedMShopService$1;

    invoke-direct {v2}, Lcom/amazon/mShop/sso/SignedMShopService$1;-><init>()V

    new-instance v3, Lcom/amazon/mShop/sso/SignedMShopService$2;

    invoke-direct {v3}, Lcom/amazon/mShop/sso/SignedMShopService$2;-><init>()V

    invoke-direct {v1, v2, v3}, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;-><init>(Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;)V

    invoke-static {}, Lcom/amazon/mShop/net/MShopRioEventListener;->getRioEventListener()Lcom/amazon/rio/j2me/client/services/RioEventListener;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/amazon/mShop/sso/SignedMShopService;-><init>(Ljava/lang/String;Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 37
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;Lcom/amazon/rio/j2me/client/services/RioEventListener;)V
    .locals 0
    .param p1, "applicationID"    # Ljava/lang/String;
    .param p2, "invoker"    # Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;
    .param p3, "eventListener"    # Lcom/amazon/rio/j2me/client/services/RioEventListener;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;-><init>(Ljava/lang/String;Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    .line 41
    return-void
.end method
