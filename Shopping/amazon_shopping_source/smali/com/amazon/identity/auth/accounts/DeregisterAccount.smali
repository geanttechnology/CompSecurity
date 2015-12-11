.class public Lcom/amazon/identity/auth/accounts/DeregisterAccount;
.super Ljava/lang/Object;
.source "DeregisterAccount.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousAccountRegistrarDeregistration;,
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthDeregistration;,
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$SynchronousSubAuthConnector;,
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;,
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;,
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$DefaultConnectionFactory;,
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;,
        Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;
    }
.end annotation


# static fields
.field static final KEY_HAS_NOTIFIED_SERVER_OF_DEREGISTER:Ljava/lang/String; = "has.notified.server.of.deregister"

.field private static final TAG:Ljava/lang/String;

.field private static final THREAD_POOL:Ljava/util/concurrent/ExecutorService;


# instance fields
.field private final mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private final mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

.field private final mContext:Landroid/content/Context;

.field private final mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

.field private final mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 41
    const-class v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;

    .line 43
    const/16 v0, 0xa

    const-string/jumbo v1, "MAP-DeregisterThreadPool"

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->getNamedThreadFactory(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;

    move-result-object v1

    invoke-static {v0, v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(ILjava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->THREAD_POOL:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$1;-><init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    .line 112
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mContext:Landroid/content/Context;

    .line 114
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    .line 116
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_amazon_account_man"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 118
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    .line 119
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400()Ljava/util/concurrent/ExecutorService;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->THREAD_POOL:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method

.method public static haveWeNotifiedServerOfDeregister(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)Z
    .locals 1
    .param p0, "amznAcctMan"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 758
    const-string/jumbo v0, "has.notified.server.of.deregister"

    invoke-virtual {p0, p1, v0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->getUserData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static setHasDeregisteredAccount(Lcom/amazon/identity/auth/accounts/AmazonAccountManager;Ljava/lang/String;)V
    .locals 2
    .param p0, "amznAcctMan"    # Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 751
    const-string/jumbo v0, "has.notified.server.of.deregister"

    const-string/jumbo v1, "true"

    invoke-virtual {p0, p1, v0, v1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 752
    return-void
.end method


# virtual methods
.method protected createAccountRegistrar()Lcom/amazon/identity/auth/accounts/AccountRegistrar;
    .locals 2

    .prologue
    .line 159
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountRegistrar;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountRegistrar;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method protected createSubAuthConnection(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;)Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;
    .locals 2
    .param p1, "description"    # Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;

    .prologue
    .line 164
    new-instance v0, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mContext:Landroid/content/Context;

    invoke-direct {v0, p1, v1}, Lcom/amazon/identity/auth/accounts/SubAuthenticatorConnection;-><init>(Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;Landroid/content/Context;)V

    return-object v0
.end method

.method public startDeregister(Ljava/util/List;Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 6
    .param p2, "responseListener"    # Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;
    .param p3, "directedId"    # Ljava/lang/String;
    .param p4, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;",
            ">;",
            "Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")V"
        }
    .end annotation

    .prologue
    .line 126
    .local p1, "subAuths":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/accounts/SubAuthenticatorDescription;>;"
    sget-object v1, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Starting deregister request"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 128
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mAmznAcctMan:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    sget-object v2, Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;->Deregistering:Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;

    invoke-virtual {v1, p3, v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->setAccountRegistrationStatus(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/AmazonAccountManager$AccountRegistrationStatus;)V

    .line 130
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    invoke-virtual {v1, p3}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->onDeregister(Ljava/lang/String;)V

    .line 132
    new-instance v0, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mRegistrarAuthenticator:Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;

    move-object v2, p3

    move-object v3, p1

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/Collection;Lcom/amazon/identity/auth/accounts/AccountRegistrarAuthenticator;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    new-instance v1, Lcom/amazon/identity/auth/accounts/DeregisterAccount$2;

    invoke-direct {v1, p0, p2}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$2;-><init>(Lcom/amazon/identity/auth/accounts/DeregisterAccount;Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;)V

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->setResponseListener(Lcom/amazon/identity/auth/accounts/DeregisterAccount$ResponseListener;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->mConnectionFactory:Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;->setConnectionFactory(Lcom/amazon/identity/auth/accounts/DeregisterAccount$ConnectionFactory;)V

    .line 133
    .local v0, "request":Lcom/amazon/identity/auth/accounts/DeregisterAccount$DeregisterRequest;
    sget-object v1, Lcom/amazon/identity/auth/accounts/DeregisterAccount;->THREAD_POOL:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v1, v0}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 134
    return-void
.end method
