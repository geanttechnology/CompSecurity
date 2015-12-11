.class public Lcom/amazon/mShop/control/smile/SmileController;
.super Lcom/amazon/mShop/control/BaseController;
.source "SmileController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponseListener;


# static fields
.field private static sInstance:Lcom/amazon/mShop/control/smile/SmileController;


# instance fields
.field private mSmileRequest:Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;

.field private mSubscribe:Lcom/amazon/mShop/control/GenericSubscriber;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    new-instance v0, Lcom/amazon/mShop/control/smile/SmileController;

    invoke-direct {v0}, Lcom/amazon/mShop/control/smile/SmileController;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/smile/SmileController;->sInstance:Lcom/amazon/mShop/control/smile/SmileController;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 22
    new-instance v0, Lcom/amazon/mShop/control/smile/SmileController$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/smile/SmileController$1;-><init>(Lcom/amazon/mShop/control/smile/SmileController;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/smile/SmileController;->mSubscribe:Lcom/amazon/mShop/control/GenericSubscriber;

    .line 31
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/smile/SmileController;->mSmileRequest:Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;

    .line 32
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/smile/SmileController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/smile/SmileController;

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/mShop/control/smile/SmileController;->serviceCallCompleted()V

    return-void
.end method

.method public static getInstance()Lcom/amazon/mShop/control/smile/SmileController;
    .locals 1

    .prologue
    .line 35
    sget-object v0, Lcom/amazon/mShop/control/smile/SmileController;->sInstance:Lcom/amazon/mShop/control/smile/SmileController;

    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 49
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/smile/SmileController$2;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/control/smile/SmileController$2;-><init>(Lcom/amazon/mShop/control/smile/SmileController;Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 56
    return-void
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/control/smile/SmileController;->mSubscribe:Lcom/amazon/mShop/control/GenericSubscriber;

    return-object v0
.end method

.method public syncSmileInfo()V
    .locals 2

    .prologue
    .line 39
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v0

    .line 40
    .local v0, "mShopService":Lcom/amazon/rio/j2me/client/services/mShop/MShopService;
    iget-object v1, p0, Lcom/amazon/mShop/control/smile/SmileController;->mSmileRequest:Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;

    invoke-interface {v0, v1, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->smileInfo(Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoRequest;Lcom/amazon/rio/j2me/client/services/mShop/SmileInfoResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 41
    return-void
.end method
