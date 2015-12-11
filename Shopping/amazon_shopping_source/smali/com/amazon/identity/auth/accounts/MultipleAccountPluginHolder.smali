.class public final Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;
.super Ljava/lang/Object;
.source "MultipleAccountPluginHolder.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    return-void
.end method

.method public static declared-synchronized getMultipleAccountPlugin(Landroid/content/Context;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    const-class v2, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;

    monitor-enter v2

    :try_start_0
    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->sMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    if-eqz v1, :cond_0

    .line 25
    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->sMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 40
    :goto_0
    monitor-exit v2

    return-object v1

    .line 28
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    .line 29
    .local v0, "wrappedContext":Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    const-string/jumbo v1, "sso_platform"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 32
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->shouldUseProfiles()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 34
    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Returning Profile multiple profile settings"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 35
    new-instance v1, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/accounts/ProfileMultipleAccountPlugin;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 23
    .end local v0    # "wrappedContext":Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 39
    .restart local v0    # "wrappedContext":Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    :cond_1
    :try_start_2
    sget-object v1, Lcom/amazon/identity/auth/accounts/MultipleAccountPluginHolder;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Returning Default multiple profile settings"

    invoke-static {v1, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 40
    new-instance v1, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/accounts/DefaultMultipleAccountPlugin;-><init>(Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method
