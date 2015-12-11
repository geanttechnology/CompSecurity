.class public Lcom/amazon/identity/auth/device/token/TokenCache;
.super Ljava/lang/Object;
.source "TokenCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;,
        Lcom/amazon/identity/auth/device/token/TokenCache$Listener;
    }
.end annotation


# static fields
.field public static final TAG:Ljava/lang/String;

.field private static sThreadQueue:Ljava/util/concurrent/ExecutorService;


# instance fields
.field private mAccount:Landroid/accounts/Account;

.field private mAccountManager:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

.field private mContext:Landroid/content/Context;

.field private mEncryptor:Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

.field private mPackageName:Ljava/lang/String;

.field private mTokens:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    const-class v0, Lcom/amazon/identity/auth/device/token/TokenCache;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    .line 41
    const-string/jumbo v0, "MAP-TokenCacheThread"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->getNamedThreadFactory(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/NamedThreadFactory;

    move-result-object v0

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/TokenCache;->sThreadQueue:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 152
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 153
    return-void
.end method

.method constructor <init>(Landroid/accounts/Account;)V
    .locals 1
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 142
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 143
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    .line 144
    const-string/jumbo v0, "test"

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    .line 145
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    .line 146
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/accounts/Account;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Landroid/accounts/Account;

    .prologue
    .line 120
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 121
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 123
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "One or more arguments are null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 126
    :cond_1
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mContext:Landroid/content/Context;

    .line 128
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    .line 129
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " created a new Token Cache"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 131
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_account_manager"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccountManager:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    .line 133
    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    .line 134
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p2}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;-><init>(Landroid/content/Context;Landroid/accounts/Account;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mEncryptor:Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    .line 135
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    .line 136
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/token/TokenCache;)Ljava/util/HashMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenCache;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenCache;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->cacheToken(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/token/TokenCache;)Landroid/accounts/Account;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenCache;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/token/TokenCache;Landroid/accounts/Account;Ljava/util/Stack;Landroid/accounts/AccountManagerCallback;)Z
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenCache;
    .param p1, "x1"    # Landroid/accounts/Account;
    .param p2, "x2"    # Ljava/util/Stack;
    .param p3, "x3"    # Landroid/accounts/AccountManagerCallback;

    .prologue
    .line 38
    invoke-virtual {p2}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    invoke-virtual {p2}, Ljava/util/Stack;->size()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {p2}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0, v1, v0, p3}, Lcom/amazon/identity/auth/device/token/TokenCache;->fetchToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/accounts/AccountManagerCallback;)Landroid/accounts/AccountManagerFuture;

    const/4 v0, 0x1

    goto :goto_0
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/device/token/TokenCache;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/token/TokenCache;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$500()Ljava/util/concurrent/ExecutorService;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/amazon/identity/auth/device/token/TokenCache;->sThreadQueue:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method

.method private cacheToken(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    .locals 2
    .param p1, "tokenType"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;

    .prologue
    .line 394
    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    invoke-direct {v0, p0, p2}, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;-><init>(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;)V

    .line 395
    .local v0, "info":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 396
    return-object v0
.end method

.method private tryRetrievingTokenFromAccountManager(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "tokenType"    # Ljava/lang/String;

    .prologue
    .line 428
    if-nez p1, :cond_0

    .line 430
    const/4 v0, 0x0

    .line 439
    :goto_0
    return-object v0

    .line 433
    :cond_0
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.extratokens"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 435
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {p0, v0, p1}, Lcom/amazon/identity/auth/device/token/TokenCache;->getUserdata(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 439
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {p0, v0, p1}, Lcom/amazon/identity/auth/device/token/TokenCache;->peekAuthToken(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private updateTokenCache(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    .locals 3
    .param p1, "tokenType"    # Ljava/lang/String;
    .param p2, "curToken"    # Ljava/lang/String;

    .prologue
    .line 314
    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    monitor-enter v2

    .line 316
    if-nez p2, :cond_0

    .line 320
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 321
    const/4 v0, 0x0

    monitor-exit v2

    .line 343
    :goto_0
    return-object v0

    .line 324
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 328
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->cacheToken(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    move-result-object v0

    .line 329
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 344
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 332
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    .line 334
    .local v0, "cachedTokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->getEncryptedToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 338
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->cacheToken(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    move-result-object v0

    .line 339
    .end local v0    # "cachedTokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 343
    .restart local v0    # "cachedTokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    :cond_2
    monitor-exit v2

    goto :goto_0
.end method


# virtual methods
.method public blockingFetchToken(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "tokenType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/accounts/OperationCanceledException;,
            Landroid/accounts/AuthenticatorException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 254
    sget-object v4, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ": blockingFetchToken: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {p0, v4, p1, v3}, Lcom/amazon/identity/auth/device/token/TokenCache;->fetchToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/accounts/AccountManagerCallback;)Landroid/accounts/AccountManagerFuture;

    move-result-object v4

    .line 258
    invoke-interface {v4}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .line 259
    .local v1, "tokenBundle":Landroid/os/Bundle;
    if-nez v1, :cond_1

    .line 267
    :cond_0
    :goto_0
    return-object v3

    .line 264
    :cond_1
    const-string/jumbo v4, "authtoken"

    invoke-virtual {v1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 266
    .local v0, "curToken":Ljava/lang/String;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->updateTokenCache(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    move-result-object v2

    .line 267
    .local v2, "tokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->getDecryptedToken()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method protected decryptToken(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 423
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mEncryptor:Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->decryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected encryptToken(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 417
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mEncryptor:Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/framework/AccountTokenEncryptor;->encryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected fetchToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/accounts/AccountManagerCallback;)Landroid/accounts/AccountManagerFuture;
    .locals 7
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "tokenType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/Account;",
            "Ljava/lang/String;",
            "Landroid/accounts/AccountManagerCallback",
            "<",
            "Landroid/os/Bundle;",
            ">;)",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .local p3, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    const/4 v3, 0x0

    .line 474
    const/4 v5, 0x0

    .line 476
    .local v5, "callbackWrapper":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    if-eqz p3, :cond_0

    .line 478
    new-instance v5, Lcom/amazon/identity/auth/device/token/TokenCache$2;

    .end local v5    # "callbackWrapper":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    invoke-direct {v5, p0, p3}, Lcom/amazon/identity/auth/device/token/TokenCache$2;-><init>(Lcom/amazon/identity/auth/device/token/TokenCache;Landroid/accounts/AccountManagerCallback;)V

    .line 495
    .restart local v5    # "callbackWrapper":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccountManager:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    move-object v2, p2

    move-object v4, v3

    move-object v6, v3

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->getAuthToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v0

    return-object v0
.end method

.method public fetchTokens([Ljava/lang/String;Lcom/amazon/identity/auth/device/token/TokenCache$Listener;)V
    .locals 5
    .param p1, "tokenTypes"    # [Ljava/lang/String;
    .param p2, "listener"    # Lcom/amazon/identity/auth/device/token/TokenCache$Listener;

    .prologue
    .line 164
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 166
    :cond_0
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "One or more arguments are null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 169
    :cond_1
    sget-object v2, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ": fetchTokens: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ","

    invoke-static {v4, p1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    array-length v2, p1

    if-nez v2, :cond_2

    .line 173
    invoke-interface {p2}, Lcom/amazon/identity/auth/device/token/TokenCache$Listener;->success()V

    .line 243
    :goto_0
    return-void

    .line 177
    :cond_2
    new-instance v1, Ljava/util/Stack;

    invoke-direct {v1}, Ljava/util/Stack;-><init>()V

    .line 178
    .local v1, "tokenTypeStack":Ljava/util/Stack;, "Ljava/util/Stack<Ljava/lang/String;>;"
    invoke-static {p1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/Stack;->addAll(Ljava/util/Collection;)Z

    .line 180
    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenCache$1;

    invoke-direct {v0, p0, v1, p2}, Lcom/amazon/identity/auth/device/token/TokenCache$1;-><init>(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/util/Stack;Lcom/amazon/identity/auth/device/token/TokenCache$Listener;)V

    .line 242
    .local v0, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<Landroid/os/Bundle;>;"
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {v1}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {p0, v3, v2, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->fetchToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/accounts/AccountManagerCallback;)Landroid/accounts/AccountManagerFuture;

    goto :goto_0
.end method

.method public getToken(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p1, "tokenType"    # Ljava/lang/String;

    .prologue
    .line 278
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    monitor-enter v3

    .line 280
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/token/TokenCache;->tryRetrievingTokenFromAccountManager(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 282
    .local v0, "curToken":Ljava/lang/String;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->updateTokenCache(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    move-result-object v1

    .line 283
    .local v1, "tokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->getDecryptedToken()Ljava/lang/String;

    move-result-object v2

    :goto_0
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 284
    .end local v0    # "curToken":Ljava/lang/String;
    .end local v1    # "tokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public getTokenAsRSAPrivateKey(Ljava/lang/String;)Ljava/security/PrivateKey;
    .locals 4
    .param p1, "tokenType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/spec/InvalidKeySpecException;
        }
    .end annotation

    .prologue
    .line 289
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    monitor-enter v3

    .line 291
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/token/TokenCache;->tryRetrievingTokenFromAccountManager(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 293
    .local v0, "curToken":Ljava/lang/String;
    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->updateTokenCache(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    move-result-object v1

    .line 294
    .local v1, "tokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;->getTokenAsRSAPrivateKey()Ljava/security/PrivateKey;

    move-result-object v2

    :goto_0
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 295
    .end local v0    # "curToken":Ljava/lang/String;
    .end local v1    # "tokenInfo":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method protected getUserdata(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "acct"    # Landroid/accounts/Account;
    .param p2, "tokenType"    # Ljava/lang/String;

    .prologue
    .line 446
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccountManager:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public invalidateAuthToken(Ljava/lang/String;)V
    .locals 4
    .param p1, "authToken"    # Ljava/lang/String;

    .prologue
    .line 353
    sget-object v1, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ": invalidateAuthToken"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/token/TokenCache;->encryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 360
    .local v0, "encryptedAuthToken":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {p0, v1, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->invalidateAuthTokenInAccountManager(Landroid/accounts/Account;Ljava/lang/String;)V

    .line 361
    return-void
.end method

.method public invalidateAuthTokenByType(Ljava/lang/String;)V
    .locals 4
    .param p1, "tokenType"    # Ljava/lang/String;

    .prologue
    .line 369
    sget-object v1, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ": invalidateAuthTokenByType: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 371
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/token/TokenCache;->tryRetrievingTokenFromAccountManager(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 372
    .local v0, "authToken":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {p0, v1, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->invalidateAuthTokenInAccountManager(Landroid/accounts/Account;Ljava/lang/String;)V

    .line 373
    return-void
.end method

.method protected invalidateAuthTokenInAccountManager(Landroid/accounts/Account;Ljava/lang/String;)V
    .locals 2
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "authToken"    # Ljava/lang/String;

    .prologue
    .line 458
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccountManager:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iget-object v1, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v0, v1, p2}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->invalidateAuthToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 459
    return-void
.end method

.method public parseRSAPrivateKey(Ljava/lang/String;)Ljava/security/PrivateKey;
    .locals 4
    .param p1, "keyString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/spec/InvalidKeySpecException;
        }
    .end annotation

    .prologue
    .line 300
    new-instance v1, Ljava/security/spec/PKCS8EncodedKeySpec;

    const/4 v2, 0x0

    invoke-static {p1, v2}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/security/spec/PKCS8EncodedKeySpec;-><init>([B)V

    .line 303
    .local v1, "spec":Ljava/security/spec/PKCS8EncodedKeySpec;
    const-string/jumbo v2, "RSA"

    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/KeyFactoryUtils;->getKeyFactoryForAlgorithm(Ljava/lang/String;)Ljava/security/KeyFactory;

    move-result-object v0

    .line 304
    .local v0, "factory":Ljava/security/KeyFactory;
    if-nez v0, :cond_0

    .line 306
    new-instance v2, Ljava/lang/UnsupportedOperationException;

    const-string/jumbo v3, "Could not generate KeyFactory."

    invoke-direct {v2, v3}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 309
    :cond_0
    invoke-virtual {v0, v1}, Ljava/security/KeyFactory;->generatePrivate(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;

    move-result-object v2

    return-object v2
.end method

.method protected peekAuthToken(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "acct"    # Landroid/accounts/Account;
    .param p2, "tokenType"    # Ljava/lang/String;

    .prologue
    .line 452
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccountManager:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->peekAuthToken(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setAuthToken(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "authTokenType"    # Ljava/lang/String;
    .param p2, "authToken"    # Ljava/lang/String;

    .prologue
    .line 379
    sget-object v2, Lcom/amazon/identity/auth/device/token/TokenCache;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mPackageName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ": setAuthToken: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    monitor-enter v3

    .line 383
    :try_start_0
    invoke-virtual {p0, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->encryptToken(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 385
    .local v0, "encryptedToken":Ljava/lang/String;
    new-instance v1, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;

    invoke-direct {v1, p0, v0, p2}, Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;-><init>(Lcom/amazon/identity/auth/device/token/TokenCache;Ljava/lang/String;Ljava/lang/String;)V

    .line 386
    .local v1, "info":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mTokens:Ljava/util/HashMap;

    invoke-virtual {v2, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 388
    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccount:Landroid/accounts/Account;

    invoke-virtual {p0, v2, p1, v0}, Lcom/amazon/identity/auth/device/token/TokenCache;->setAuthTokenInAccountManager(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 389
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    .end local v0    # "encryptedToken":Ljava/lang/String;
    .end local v1    # "info":Lcom/amazon/identity/auth/device/token/TokenCache$TokenInfo;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method protected setAuthTokenInAccountManager(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "account"    # Landroid/accounts/Account;
    .param p2, "authTokenType"    # Ljava/lang/String;
    .param p3, "encryptedToken"    # Ljava/lang/String;

    .prologue
    .line 466
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenCache;->mAccountManager:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->setAuthToken(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 467
    return-void
.end method
