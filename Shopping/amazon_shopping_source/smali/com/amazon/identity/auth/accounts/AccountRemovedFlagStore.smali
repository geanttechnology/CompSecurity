.class public Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;
.super Ljava/lang/Object;
.source "AccountRemovedFlagStore.java"


# static fields
.field private static final LOCK:[Ljava/lang/Object;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mFlagStore:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->TAG:Ljava/lang/String;

    .line 23
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->LOCK:[Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->mContext:Landroid/content/Context;

    .line 32
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "account_removed_flag_store"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->mFlagStore:Landroid/content/SharedPreferences;

    .line 33
    return-void
.end method

.method private static getKeyForAccount(Landroid/accounts/Account;)Ljava/lang/String;
    .locals 2
    .param p0, "account"    # Landroid/accounts/Account;

    .prologue
    .line 77
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Account_To_Remove_"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private throwIfNotValidAccount(Landroid/accounts/Account;)V
    .locals 3
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 82
    const-string/jumbo v0, "com.amazon.account"

    iget-object v1, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 84
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Not valid for accounts of type: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p1, Landroid/accounts/Account;->type:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 86
    :cond_0
    return-void
.end method

.method private writeSharedPrefsToDisk(Landroid/content/SharedPreferences$Editor;)Z
    .locals 4
    .param p1, "editor"    # Landroid/content/SharedPreferences$Editor;

    .prologue
    .line 90
    const/4 v1, 0x0

    .line 91
    .local v1, "retry":I
    :goto_0
    const/4 v2, 0x2

    if-gt v1, v2, :cond_1

    .line 93
    invoke-interface {p1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 95
    const/4 v2, 0x1

    .line 112
    :goto_1
    return v2

    .line 98
    :cond_0
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Commit failed retrying"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    const-wide/16 v2, 0xf

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 109
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 104
    :catch_0
    move-exception v0

    .line 106
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Retry sleep interrupted"

    invoke-static {v2, v3, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    .line 112
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method


# virtual methods
.method public setAccountToRemoved(Landroid/accounts/Account;)Z
    .locals 6
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    const/4 v1, 0x1

    .line 37
    sget-object v2, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->LOCK:[Ljava/lang/Object;

    monitor-enter v2

    .line 39
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->throwIfNotValidAccount(Landroid/accounts/Account;)V

    .line 41
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->mFlagStore:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->getKeyForAccount(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 44
    .local v0, "edit":Landroid/content/SharedPreferences$Editor;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->writeSharedPrefsToDisk(Landroid/content/SharedPreferences$Editor;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 46
    sget-object v1, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Could not write account removed flag to disk"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    const/4 v1, 0x0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 50
    :goto_0
    return v1

    :cond_0
    monitor-exit v2

    goto :goto_0

    .line 51
    .end local v0    # "edit":Landroid/content/SharedPreferences$Editor;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public shouldAccountBeRemoved(Landroid/accounts/Account;)Z
    .locals 6
    .param p1, "account"    # Landroid/accounts/Account;

    .prologue
    .line 56
    sget-object v4, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->LOCK:[Ljava/lang/Object;

    monitor-enter v4

    .line 58
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->throwIfNotValidAccount(Landroid/accounts/Account;)V

    .line 60
    invoke-static {p1}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->getKeyForAccount(Landroid/accounts/Account;)Ljava/lang/String;

    move-result-object v0

    .line 62
    .local v0, "accountKey":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->mFlagStore:Landroid/content/SharedPreferences;

    const/4 v5, 0x0

    invoke-interface {v3, v0, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 64
    .local v2, "shouldBeRemoved":Z
    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->mFlagStore:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3, v0}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 66
    .local v1, "edit":Landroid/content/SharedPreferences$Editor;
    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->writeSharedPrefsToDisk(Landroid/content/SharedPreferences$Editor;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 68
    sget-object v3, Lcom/amazon/identity/auth/accounts/AccountRemovedFlagStore;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Could not clear account removed flag to disk"

    invoke-static {v3, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    :cond_0
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return v2

    .line 72
    .end local v0    # "accountKey":Ljava/lang/String;
    .end local v1    # "edit":Landroid/content/SharedPreferences$Editor;
    .end local v2    # "shouldBeRemoved":Z
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3
.end method
