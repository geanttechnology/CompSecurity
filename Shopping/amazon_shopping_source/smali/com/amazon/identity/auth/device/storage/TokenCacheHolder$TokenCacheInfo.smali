.class Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;
.super Ljava/lang/Object;
.source "TokenCacheHolder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "TokenCacheInfo"
.end annotation


# instance fields
.field private final mAccount:Landroid/accounts/Account;

.field private final mAccountValidator:Ljava/lang/String;

.field private final mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

.field private final mCache:Lcom/amazon/identity/auth/device/token/TokenCache;

.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "acctMan"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .param p3, "account"    # Landroid/accounts/Account;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mContext:Landroid/content/Context;

    .line 37
    iput-object p3, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAccount:Landroid/accounts/Account;

    .line 39
    new-instance v0, Lcom/amazon/identity/auth/device/token/TokenCache;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAccount:Landroid/accounts/Account;

    invoke-direct {v0, v1, v2}, Lcom/amazon/identity/auth/device/token/TokenCache;-><init>(Landroid/content/Context;Landroid/accounts/Account;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mCache:Lcom/amazon/identity/auth/device/token/TokenCache;

    .line 41
    iput-object p2, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    .line 42
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAccount:Landroid/accounts/Account;

    const-string/jumbo v2, "com.amazon.dcp.sso.property.account.UUID"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAccountValidator:Ljava/lang/String;

    .line 43
    return-void
.end method


# virtual methods
.method public getTokenCache()Lcom/amazon/identity/auth/device/token/TokenCache;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mCache:Lcom/amazon/identity/auth/device/token/TokenCache;

    return-object v0
.end method

.method public isValid()Z
    .locals 4

    .prologue
    .line 50
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAcctMan:Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAccount:Landroid/accounts/Account;

    const-string/jumbo v3, "com.amazon.dcp.sso.property.account.UUID"

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->getUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 51
    .local v0, "newAccountValidator":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 53
    const/4 v1, 0x0

    .line 56
    :goto_0
    return v1

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder$TokenCacheInfo;->mAccountValidator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method
