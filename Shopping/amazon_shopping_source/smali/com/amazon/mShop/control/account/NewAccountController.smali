.class public Lcom/amazon/mShop/control/account/NewAccountController;
.super Lcom/amazon/mShop/control/BaseController;
.source "NewAccountController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/NewAccountResponseListener;


# instance fields
.field private newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

.field private final subscriber:Lcom/amazon/mShop/control/account/NewAccountSubscriber;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/account/NewAccountSubscriber;)V
    .locals 1
    .param p1, "subscriber"    # Lcom/amazon/mShop/control/account/NewAccountSubscriber;

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/amazon/mShop/control/BaseController;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/amazon/mShop/control/account/NewAccountController;->subscriber:Lcom/amazon/mShop/control/account/NewAccountSubscriber;

    .line 25
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    .line 26
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/control/account/NewAccountController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/NewAccountController;
    .param p1, "x1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 17
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/control/account/NewAccountController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/account/NewAccountController;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/NewAccountController;

    .prologue
    .line 17
    invoke-virtual {p0}, Lcom/amazon/mShop/control/account/NewAccountController;->serviceCallCompleted()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/account/NewAccountController;)Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/NewAccountController;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/account/NewAccountController;)Lcom/amazon/mShop/control/account/NewAccountSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/account/NewAccountController;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/mShop/control/account/NewAccountController;->subscriber:Lcom/amazon/mShop/control/account/NewAccountSubscriber;

    return-object v0
.end method


# virtual methods
.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 49
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/account/NewAccountController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/account/NewAccountController$1;-><init>(Lcom/amazon/mShop/control/account/NewAccountController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 68
    return-void
.end method

.method public createNewAccount(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/amazon/mShop/control/TaskCallback;)V
    .locals 3
    .param p1, "fullName"    # Ljava/lang/String;
    .param p2, "furigana"    # Ljava/lang/String;
    .param p3, "email"    # Ljava/lang/String;
    .param p4, "password"    # Ljava/lang/String;
    .param p5, "forceMase"    # Z
    .param p6, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 30
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    invoke-virtual {v1, p1}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->setFullName(Ljava/lang/String;)V

    .line 31
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    invoke-virtual {v1, p2}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->setPronunciation(Ljava/lang/String;)V

    .line 32
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    invoke-virtual {v1, p3}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->setEmail(Ljava/lang/String;)V

    .line 33
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    invoke-virtual {v1, p4}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->setPassword(Ljava/lang/String;)V

    .line 34
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    invoke-static {p5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->setForceMase(Ljava/lang/Boolean;)V

    .line 36
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    .line 37
    .local v0, "platform":Lcom/amazon/mShop/platform/Platform;
    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    invoke-interface {v1, v2, p0}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->newAccount(Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;Lcom/amazon/rio/j2me/client/services/mShop/NewAccountResponseListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    invoke-virtual {p0, v1, p6}, Lcom/amazon/mShop/control/account/NewAccountController;->serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 40
    return-void
.end method

.method protected getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/control/account/NewAccountController;->subscriber:Lcom/amazon/mShop/control/account/NewAccountSubscriber;

    return-object v0
.end method

.method public isValidEmail(Ljava/lang/String;)Z
    .locals 10
    .param p1, "email"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x2

    const/4 v5, 0x0

    const/4 v6, 0x1

    .line 71
    const-string/jumbo v7, "@"

    invoke-virtual {p1, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 72
    .local v4, "tokens":[Ljava/lang/String;
    array-length v7, v4

    if-ne v7, v9, :cond_0

    aget-object v7, v4, v5

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v6, :cond_0

    aget-object v7, v4, v6

    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v7

    if-ge v7, v6, :cond_1

    .line 92
    :cond_0
    :goto_0
    return v5

    .line 76
    :cond_1
    aget-object v7, v4, v6

    const-string/jumbo v8, "\\."

    invoke-virtual {v7, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 79
    .local v1, "domainsplit":[Ljava/lang/String;
    array-length v7, v1

    if-lt v7, v9, :cond_0

    .line 83
    const/4 v2, 0x0

    .local v2, "i":I
    array-length v3, v1

    .local v3, "length":I
    :goto_1
    if-ge v2, v3, :cond_2

    .line 85
    aget-object v0, v1, v2

    .line 86
    .local v0, "domain":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v6, :cond_0

    .line 83
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v0    # "domain":Ljava/lang/String;
    :cond_2
    move v5, v6

    .line 92
    goto :goto_0
.end method
