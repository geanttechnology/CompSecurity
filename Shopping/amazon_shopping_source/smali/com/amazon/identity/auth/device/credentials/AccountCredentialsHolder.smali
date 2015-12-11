.class public final Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;
.super Ljava/lang/Object;
.source "AccountCredentialsHolder.java"


# static fields
.field private static final NULL_CREDENTIALS:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

.field private static sMainCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

.field private static sSecondaryCredentials:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/credentials/AccountCredentials;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    new-instance v0, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder$1;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder$1;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->NULL_CREDENTIALS:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .line 37
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sMainCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .line 38
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sSecondaryCredentials:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    return-void
.end method

.method public static declared-synchronized getCredentialsForAccount(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 66
    const-class v4, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;

    monitor-enter v4

    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;-><init>(Landroid/content/Context;)V

    .line 67
    .local v0, "acctMan":Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    if-eqz p1, :cond_0

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isDevicePrimaryAmazonAccount(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 69
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 87
    :cond_1
    :goto_0
    monitor-exit v4

    return-object v2

    .line 72
    :cond_2
    :try_start_1
    sget-object v3, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sSecondaryCredentials:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .line 73
    .local v2, "creds":Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 75
    .local v1, "appContext":Landroid/content/Context;
    invoke-static {v2, v1}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->validCredentials(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 80
    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->createFromContextForAccount(Landroid/content/Context;Ljava/lang/String;)Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;

    move-result-object v2

    .line 81
    if-nez v2, :cond_3

    .line 83
    sget-object v2, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->NULL_CREDENTIALS:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    goto :goto_0

    .line 86
    :cond_3
    sget-object v3, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sSecondaryCredentials:Ljava/util/Map;

    invoke-interface {v3, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 66
    .end local v0    # "acctMan":Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .end local v1    # "appContext":Landroid/content/Context;
    .end local v2    # "creds":Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 46
    const-class v2, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;

    monitor-enter v2

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 48
    .local v0, "appContext":Landroid/content/Context;
    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sMainCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->validCredentials(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 50
    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sMainCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 60
    :goto_0
    monitor-exit v2

    return-object v1

    .line 53
    :cond_0
    :try_start_1
    invoke-static {v0}, Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;->createFromContext(Landroid/content/Context;)Lcom/amazon/identity/auth/device/credentials/AmazonAccountCredentials;

    move-result-object v1

    .line 54
    sput-object v1, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sMainCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    if-nez v1, :cond_1

    .line 56
    new-instance v1, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;-><init>(Landroid/content/Context;)V

    .line 57
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/storage/AnonymousCredentialsStore;->getCredentials()Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    move-result-object v1

    sput-object v1, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sMainCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;

    .line 60
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/credentials/AccountCredentialsHolder;->sMainCredentials:Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 46
    .end local v0    # "appContext":Landroid/content/Context;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method private static validCredentials(Lcom/amazon/identity/auth/device/credentials/AccountCredentials;Landroid/content/Context;)Z
    .locals 1
    .param p0, "creds"    # Lcom/amazon/identity/auth/device/credentials/AccountCredentials;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 92
    if-eqz p0, :cond_0

    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/credentials/AccountCredentials;->isStale(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
