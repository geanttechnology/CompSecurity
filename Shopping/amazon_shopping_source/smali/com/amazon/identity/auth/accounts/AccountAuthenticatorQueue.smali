.class public Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;
.super Ljava/lang/Object;
.source "AccountAuthenticatorQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;,
        Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAccountAuthenticatorQueue:Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 97
    new-instance v0, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;

    const-string/jumbo v1, "MAP-AccountAuthenticatorQueueThread"

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->getNamedThreadFactory(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;

    move-result-object v1

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;-><init>(Ljava/util/concurrent/ExecutorService;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->mAccountAuthenticatorQueue:Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;

    .line 100
    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->TAG:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public addAccountAuthenticatorTask(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V
    .locals 2
    .param p1, "task"    # Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p3, "operation"    # Ljava/lang/String;

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue;->mAccountAuthenticatorQueue:Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;

    new-instance v1, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;

    invoke-direct {v1, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorAsyncToSyncTask;-><init>(Lcom/amazon/identity/auth/accounts/AccountAuthenticatorQueue$AccountAuthenticatorTask;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/UnitTestSafeExecutorService;->execute(Ljava/lang/Runnable;)V

    .line 107
    return-void
.end method
