.class Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
.super Ljava/lang/Object;
.source "CentralAccountManagerDataStorage.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/utils/PublicCloneable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AccountInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/device/utils/PublicCloneable",
        "<",
        "Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;",
        ">;"
    }
.end annotation


# instance fields
.field public final account:Landroid/accounts/Account;

.field public final directedId:Ljava/lang/String;

.field private mCache:Lcom/amazon/identity/auth/device/token/TokenCache;

.field private final mLock:[Ljava/lang/Object;

.field public final tokens:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public final userData:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/accounts/Account;)V
    .locals 2
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenAccount"    # Landroid/accounts/Account;

    .prologue
    .line 53
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    new-instance v1, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;-><init>(Ljava/lang/String;Landroid/accounts/Account;Ljava/util/Map;Ljava/util/Map;)V

    .line 57
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Landroid/accounts/Account;Ljava/util/Map;Ljava/util/Map;)V
    .locals 1
    .param p1, "givenDirectedId"    # Ljava/lang/String;
    .param p2, "givenAccount"    # Landroid/accounts/Account;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/accounts/Account;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/framework/Value",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 63
    .local p3, "givenUserData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;>;"
    .local p4, "givenTokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Value<Ljava/lang/String;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->mLock:[Ljava/lang/Object;

    .line 64
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->directedId:Ljava/lang/String;

    .line 65
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    .line 67
    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->userData:Ljava/util/Map;

    .line 68
    iput-object p4, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->tokens:Ljava/util/Map;

    .line 69
    return-void
.end method


# virtual methods
.method public cloneObject()Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;
    .locals 5

    .prologue
    .line 77
    new-instance v0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->userData:Ljava/util/Map;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->cloneMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->tokens:Ljava/util/Map;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->cloneMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;-><init>(Ljava/lang/String;Landroid/accounts/Account;Ljava/util/Map;Ljava/util/Map;)V

    return-object v0
.end method

.method public bridge synthetic cloneObject()Lcom/amazon/identity/auth/device/utils/PublicCloneable;
    .locals 1

    .prologue
    .line 39
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->cloneObject()Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;

    move-result-object v0

    return-object v0
.end method

.method public getTokenCache(Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;)Lcom/amazon/identity/auth/device/token/TokenCache;
    .locals 2
    .param p1, "cacheHolder"    # Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    .prologue
    .line 82
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 84
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->mCache:Lcom/amazon/identity/auth/device/token/TokenCache;

    if-nez v0, :cond_0

    .line 86
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->account:Landroid/accounts/Account;

    invoke-virtual {p1, v0}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getTokenCacheFromRegisteredAccount(Landroid/accounts/Account;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->mCache:Lcom/amazon/identity/auth/device/token/TokenCache;

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage$AccountInfo;->mCache:Lcom/amazon/identity/auth/device/token/TokenCache;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v0

    .line 90
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
