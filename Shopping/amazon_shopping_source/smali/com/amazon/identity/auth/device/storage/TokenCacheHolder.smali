.class public Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;
.super Ljava/lang/Object;
.source "TokenCacheHolder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;


# instance fields
.field private final mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mLock:[Ljava/lang/Object;

.field private final mTokenCacheLookup:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap",
            "<",
            "Landroid/accounts/Account;",
            "Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mLock:[Ljava/lang/Object;

    .line 79
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 81
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v1, "dcp_account_manager"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    .line 83
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mTokenCacheLookup:Ljava/util/WeakHashMap;

    .line 84
    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 88
    const-class v1, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    if-nez v0, :cond_0

    .line 90
    new-instance v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    .line 93
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->sTheOneAndTheOnly:Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 88
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public getTokenCache(Landroid/accounts/Account;)Lcom/amazon/identity/auth/device/token/TokenCache;
    .locals 2
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 98
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 100
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->doesAccountExist(Landroid/accounts/Account;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 102
    sget-object v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->TAG:Ljava/lang/String;

    .line 103
    const/4 v0, 0x0

    monitor-exit v1

    .line 106
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getTokenCacheFromRegisteredAccount(Landroid/accounts/Account;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 107
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public getTokenCacheFromRegisteredAccount(Landroid/accounts/Account;)Lcom/amazon/identity/auth/device/token/TokenCache;
    .locals 4
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 112
    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mLock:[Ljava/lang/Object;

    monitor-enter v2

    .line 114
    :try_start_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mTokenCacheLookup:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p1}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;

    .line 115
    .local v0, "info":Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->isValid()Z

    move-result v1

    if-nez v1, :cond_1

    .line 117
    :cond_0
    new-instance v0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;

    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    invoke-direct {v0, v1, v3, p1}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;-><init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)V

    .line 118
    .restart local v0    # "info":Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->mTokenCacheLookup:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 121
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->getTokenCache()Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v1

    .line 122
    .end local v0    # "info":Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method
