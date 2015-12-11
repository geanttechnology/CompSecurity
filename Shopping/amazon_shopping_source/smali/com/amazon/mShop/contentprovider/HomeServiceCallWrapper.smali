.class public Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;
.super Ljava/lang/Object;
.source "HomeServiceCallWrapper.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static volatile sHomeServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->TAG:Ljava/lang/String;

    .line 32
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->sHomeServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 29
    sput-object p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->sHomeServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    return-object p0
.end method

.method public static startHomeCall(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    new-instance v0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;-><init>(Landroid/content/Context;)V

    .line 107
    .local v0, "homeResponseListener":Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;
    const-class v3, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;

    monitor-enter v3

    .line 109
    :try_start_0
    sget-object v2, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->sHomeServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-nez v2, :cond_0

    .line 112
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;-><init>()V

    .line 115
    .local v1, "request":Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setApplicationStarted(Ljava/lang/Boolean;)V

    .line 116
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnCartItems(Ljava/lang/Boolean;)V

    .line 117
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnPromoSlot0(Ljava/lang/Boolean;)V

    .line 118
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnPromoSlot1(Ljava/lang/Boolean;)V

    .line 119
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnShoveler0(Ljava/lang/Boolean;)V

    .line 120
    sget-object v2, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;->setReturnShoveler1(Ljava/lang/Boolean;)V

    .line 123
    const-string/jumbo v2, "home_v38"

    const/4 v4, 0x0

    invoke-static {}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->getAmazonRequestId()Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v4, v5}, Lcom/amazon/mShop/customclientfields/CustomClientFields;->setCustomHeaderFields(Ljava/lang/String;ZLjava/lang/String;)V

    .line 125
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v2

    invoke-interface {v2, v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->home(Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v2

    sput-object v2, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->sHomeServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 127
    .end local v1    # "request":Lcom/amazon/rio/j2me/client/services/mShop/HomeRequest;
    :cond_0
    monitor-exit v3

    .line 128
    return-void

    .line 127
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method
