.class public Lcom/amazon/mShop/control/locale/LocaleController;
.super Lcom/amazon/mShop/control/BaseController;
.source "LocaleController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponseListener;


# instance fields
.field private final mSubscriber:Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;

.field private mTaskCallback:Lcom/amazon/mShop/control/TaskCallback;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;)V
    .locals 0
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 22
    iput-object p1, p0, Lcom/amazon/mShop/control/locale/LocaleController;->mSubscriber:Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;

    .line 23
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/locale/LocaleController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/locale/LocaleController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 17
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/locale/LocaleController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/locale/LocaleController;)Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/locale/LocaleController;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/mShop/control/locale/LocaleController;->mSubscriber:Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/locale/LocaleController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/locale/LocaleController;

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/mShop/control/locale/LocaleController;->serviceCallCompleted()V

    return-void
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 40
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/locale/LocaleController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/locale/LocaleController$1;-><init>(Lcom/amazon/mShop/control/locale/LocaleController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 49
    return-void
.end method

.method protected bridge synthetic getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/mShop/control/locale/LocaleController;->getSubscriber()Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;

    move-result-object v0

    return-object v0
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/control/locale/LocaleController;->mSubscriber:Lcom/amazon/mShop/control/locale/LocaleSwitchSubscriber;

    return-object v0
.end method

.method public switchLanguage(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "localeName"    # Ljava/lang/String;
    .param p2, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 31
    iput-object p2, p0, Lcom/amazon/mShop/control/locale/LocaleController;->mTaskCallback:Lcom/amazon/mShop/control/TaskCallback;

    .line 32
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;-><init>()V

    .line 33
    .local v0, "request":Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;
    invoke-virtual {v0, p1}, Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;->setCode(Ljava/lang/String;)V

    .line 35
    invoke-static {}, Lcom/amazon/mShop/control/ServiceController;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    invoke-interface {v1, v0, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->locale(Lcom/amazon/rio/j2me/client/services/mShop/LocaleRequest;Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/control/locale/LocaleController;->mTaskCallback:Lcom/amazon/mShop/control/TaskCallback;

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/control/locale/LocaleController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 36
    return-void
.end method
