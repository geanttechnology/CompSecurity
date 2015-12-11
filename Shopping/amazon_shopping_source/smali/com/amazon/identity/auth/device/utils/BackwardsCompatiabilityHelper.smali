.class public final Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
.super Ljava/lang/Object;
.source "BackwardsCompatiabilityHelper.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public static addAccountManagerSuccessInformation(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "result"    # Landroid/os/Bundle;

    .prologue
    .line 164
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getUserName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 165
    invoke-static {v0, p1, p2}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->addAccountManagerSuccessInformation(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method public static addAccountManagerSuccessInformation(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 2
    .param p0, "userName"    # Ljava/lang/String;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "result"    # Landroid/os/Bundle;

    .prologue
    .line 172
    const-string/jumbo v0, "authAccount"

    invoke-virtual {p2, v0, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 173
    const-string/jumbo v0, "accountType"

    const-string/jumbo v1, "com.amazon.account"

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    const-string/jumbo v0, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p2, v0, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    return-object p2
.end method

.method public static expireTokenValue(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "tokenValue"    # Ljava/lang/String;

    .prologue
    .line 239
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 240
    .local v0, "account":Landroid/accounts/Account;
    if-nez v0, :cond_1

    .line 257
    :cond_0
    :goto_0
    return-void

    .line 245
    :cond_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v2

    .line 247
    const-string/jumbo v3, "dcp_token_cache_holder"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;

    .line 250
    invoke-virtual {v2, v0}, Lcom/amazon/identity/auth/device/storage/TokenCacheHolder;->getTokenCache(Landroid/accounts/Account;)Lcom/amazon/identity/auth/device/token/TokenCache;

    move-result-object v1

    .line 251
    .local v1, "cache":Lcom/amazon/identity/auth/device/token/TokenCache;
    if-eqz v1, :cond_0

    .line 256
    invoke-virtual {v1, p2}, Lcom/amazon/identity/auth/device/token/TokenCache;->invalidateAuthToken(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static declared-synchronized fromDirectedIdToArrayListAccounts(Landroid/content/Context;Ljava/util/Collection;)Ljava/util/ArrayList;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/accounts/Account;",
            ">;"
        }
    .end annotation

    .prologue
    .line 119
    .local p1, "directedIds":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    const-class v6, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;

    monitor-enter v6

    if-nez p1, :cond_1

    .line 121
    const/4 v0, 0x0

    .line 136
    :cond_0
    monitor-exit v6

    return-object v0

    .line 124
    :cond_1
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountManagerWrapper(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedIdToAccountLookup(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;)Ljava/util/Map;

    move-result-object v4

    .line 126
    .local v4, "lookup":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/accounts/Account;>;"
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 127
    .local v0, "accounts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/accounts/Account;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 129
    .local v2, "directedId":Ljava/lang/String;
    invoke-interface {v4, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accounts/Account;

    .line 130
    .local v1, "curAccount":Landroid/accounts/Account;
    if-eqz v1, :cond_2

    .line 132
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 119
    .end local v0    # "accounts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/accounts/Account;>;"
    .end local v1    # "curAccount":Landroid/accounts/Account;
    .end local v2    # "directedId":Ljava/lang/String;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "lookup":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/accounts/Account;>;"
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5
.end method

.method private static getAccountManagerWrapper(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 233
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    .line 234
    const-string/jumbo v1, "dcp_account_manager"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    return-object v0
.end method

.method public static declared-synchronized getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 144
    const-class v1, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountManagerWrapper(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Ljava/lang/String;)Landroid/accounts/Account;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getAccountWithDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Ljava/lang/String;)Landroid/accounts/Account;
    .locals 2
    .param p0, "acctMan"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 150
    const-class v1, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;

    monitor-enter v1

    if-nez p1, :cond_0

    .line 152
    const/4 v0, 0x0

    .line 157
    :goto_0
    monitor-exit v1

    return-object v0

    .line 155
    :cond_0
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedIdToAccountLookup(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;)Ljava/util/Map;

    move-result-object v0

    .line 157
    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/Account;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 150
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getDirectedId(Landroid/content/Context;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 70
    const-class v1, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountManagerWrapper(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getDirectedId(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accountType"    # Ljava/lang/String;
    .param p2, "accountName"    # Ljava/lang/String;

    .prologue
    .line 59
    const-class v2, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;

    monitor-enter v2

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 61
    :cond_0
    const/4 v1, 0x0

    .line 65
    :goto_0
    monitor-exit v2

    return-object v1

    .line 64
    :cond_1
    :try_start_0
    new-instance v0, Landroid/accounts/Account;

    invoke-direct {v0, p2, p1}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 65
    .local v0, "account":Landroid/accounts/Account;
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountManagerWrapper(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    goto :goto_0

    .line 59
    .end local v0    # "account":Landroid/accounts/Account;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static getDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 1
    .param p0, "acctMan"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 75
    if-eqz p1, :cond_0

    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->doesAccountExist(Landroid/accounts/Account;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 77
    :cond_0
    const/4 v0, 0x0

    .line 80
    :goto_0
    return-object v0

    :cond_1
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedIdFromExistingAcconunt(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static getDirectedIdFromExistingAcconunt(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;
    .locals 2
    .param p0, "acctMan"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 103
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->unprotectedGetUserData(Landroid/accounts/Account;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 104
    .local v0, "directedId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 109
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 110
    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.acctId"

    invoke-virtual {p0, p1, v1, v0}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->setUserData(Landroid/accounts/Account;Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :cond_0
    return-object v0
.end method

.method private static getDirectedIdToAccountLookup(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;)Ljava/util/Map;
    .locals 7
    .param p0, "acctMan"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/accounts/Account;",
            ">;"
        }
    .end annotation

    .prologue
    .line 218
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 220
    .local v5, "lookup":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/accounts/Account;>;"
    const-string/jumbo v6, "com.amazon.account"

    invoke-virtual {p0, v6}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v1

    .line 222
    .local v1, "arr$":[Landroid/accounts/Account;
    array-length v4, v1

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v0, v1, v3

    .line 224
    .local v0, "account":Landroid/accounts/Account;
    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v2

    .line 225
    .local v2, "curDirectedId":Ljava/lang/String;
    invoke-interface {v5, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 228
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v2    # "curDirectedId":Ljava/lang/String;
    :cond_0
    return-object v5
.end method

.method public static getDirectedIdToAccountMapping(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;)Ljava/util/Map;
    .locals 8
    .param p0, "acctMan"    # Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/accounts/Account;",
            ">;"
        }
    .end annotation

    .prologue
    .line 85
    const-string/jumbo v7, "com.amazon.account"

    invoke-virtual {p0, v7}, Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v2

    .line 87
    .local v2, "accounts":[Landroid/accounts/Account;
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 89
    .local v1, "accountDirectedIds":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Landroid/accounts/Account;>;"
    move-object v3, v2

    .local v3, "arr$":[Landroid/accounts/Account;
    array-length v6, v2

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_0

    aget-object v0, v3, v5

    .line 91
    .local v0, "account":Landroid/accounts/Account;
    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedIdFromExistingAcconunt(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v4

    .line 92
    .local v4, "directedId":Ljava/lang/String;
    invoke-interface {v1, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 95
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v4    # "directedId":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method public static declared-synchronized getDirectedIdsFromAndroidAccounts(Landroid/content/Context;Ljava/util/Collection;)Ljava/util/Set;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Landroid/accounts/Account;",
            ">;)",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 40
    .local p1, "accounts":Ljava/util/Collection;, "Ljava/util/Collection<Landroid/accounts/Account;>;"
    const-class v6, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;

    monitor-enter v6

    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountManagerWrapper(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;

    move-result-object v1

    .line 41
    .local v1, "acctMan":Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 42
    .local v3, "directedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/accounts/Account;

    .line 44
    .local v0, "account":Landroid/accounts/Account;
    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedId(Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "directedId":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 48
    invoke-interface {v3, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 40
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "acctMan":Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .end local v2    # "directedId":Ljava/lang/String;
    .end local v3    # "directedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v4    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v5

    monitor-exit v6

    throw v5

    .line 52
    .restart local v1    # "acctMan":Lcom/amazon/identity/auth/device/utils/AccountManagerWrapper;
    .restart local v3    # "directedIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v4    # "i$":Ljava/util/Iterator;
    :cond_1
    monitor-exit v6

    return-object v3
.end method

.method public static declared-synchronized getDirectedIdsFromAndroidAccounts(Landroid/content/Context;[Landroid/accounts/Account;)Ljava/util/Set;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "accounts"    # [Landroid/accounts/Account;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "[",
            "Landroid/accounts/Account;",
            ")",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    const-class v1, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;

    monitor-enter v1

    :try_start_0
    invoke-static {p1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getDirectedIdsFromAndroidAccounts(Landroid/content/Context;Ljava/util/Collection;)Ljava/util/Set;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getUniqueAccountName(Lcom/amazon/identity/auth/device/storage/DataStorage;Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;
    .param p1, "baseName"    # Ljava/lang/String;

    .prologue
    .line 188
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getAccountNames()Ljava/util/Set;

    move-result-object v0

    .line 189
    .local v0, "currentAccountNames":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    move-object v2, p1

    .line 190
    .local v2, "uniqueAccountName":Ljava/lang/String;
    const/4 v1, 0x1

    .line 191
    .local v1, "num":I
    :goto_0
    invoke-interface {v0, v2}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 193
    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string/jumbo v4, "%s %d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p1, v5, v6

    const/4 v6, 0x1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 196
    :cond_0
    return-object v2
.end method

.method public static getUserName(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 201
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->getAccountWithDirectedId(Landroid/content/Context;Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v0

    .line 202
    .local v0, "account":Landroid/accounts/Account;
    if-nez v0, :cond_0

    .line 204
    const/4 v1, 0x0

    .line 207
    :goto_0
    return-object v1

    :cond_0
    iget-object v1, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    goto :goto_0
.end method

.method public static isADcpOnlyToken(Ljava/lang/String;)Z
    .locals 1
    .param p0, "authTokenType"    # Ljava/lang/String;

    .prologue
    .line 274
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.adptoken"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.privatekey"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.credentialsmap"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isEncryptedTokenInUserData(Ljava/lang/String;)Z
    .locals 2
    .param p0, "authTokenType"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 261
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;->isADcpOnlyToken(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 265
    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string/jumbo v1, "com.amazon.dcp.sso.token.cookie.xmain"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string/jumbo v1, "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string/jumbo v1, "com.amazon.dcp.sso.token.device"

    invoke-virtual {p0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string/jumbo v1, "com.amazon.dcp.sso.property.account.extratokens"

    invoke-virtual {p0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string/jumbo v1, "com.amazon.identity.cookies.xfsn"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method
