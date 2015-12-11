.class public final Lcom/amazon/identity/auth/device/api/MAPInit;
.super Ljava/lang/Object;
.source "MAPInit.java"


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sIsRunningInFunctionalTest:Z

.field private static sTheOneAndOnly:Lcom/amazon/identity/auth/device/api/MAPInit;


# instance fields
.field private final mApplicationContext:Landroid/content/Context;

.field private mInitialized:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPInit;->TAG:Ljava/lang/String;

    .line 25
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/identity/auth/device/api/MAPInit;->sIsRunningInFunctionalTest:Z

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/api/MAPInit;)V
    .locals 3
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPInit;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->setPackageName(Ljava/lang/String;)V

    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPInit;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Initializing MAP ("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/BuildInfo;->getBuildInfo()Lcom/amazon/identity/auth/device/utils/BuildInfo;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ") for app "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPInit;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/api/MAPInit;)V
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPInit;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v0

    new-instance v1, Lcom/amazon/identity/auth/device/api/MAPInit$2;

    invoke-direct {v1, p0}, Lcom/amazon/identity/auth/device/api/MAPInit$2;-><init>(Lcom/amazon/identity/auth/device/api/MAPInit;)V

    invoke-virtual {v0, v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;->addListener(Lcom/amazon/identity/platform/setting/PlatformSettings$Listener;)V

    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPInit;->toggleSettings()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/api/MAPInit;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPInit;

    .prologue
    .line 22
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPInit$3;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/api/MAPInit$3;-><init>(Lcom/amazon/identity/auth/device/api/MAPInit;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPInit;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/device/api/MAPInit;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPInit;

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPInit;->toggleSettings()V

    return-void
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    const-class v2, Lcom/amazon/identity/auth/device/api/MAPInit;

    monitor-enter v2

    :try_start_0
    const-string/jumbo v1, "context"

    invoke-static {p0, v1}, Lcom/amazon/identity/auth/device/utils/MAPArgContracts;->throwIfNull(Ljava/lang/Object;Ljava/lang/String;)V

    .line 45
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPInit;->sTheOneAndOnly:Lcom/amazon/identity/auth/device/api/MAPInit;

    if-eqz v1, :cond_0

    .line 47
    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPInit;->sTheOneAndOnly:Lcom/amazon/identity/auth/device/api/MAPInit;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 61
    :goto_0
    monitor-exit v2

    return-object v1

    .line 50
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 55
    .local v0, "applicationContext":Landroid/content/Context;
    if-nez v0, :cond_1

    .line 57
    new-instance v1, Lcom/amazon/identity/auth/device/api/MAPInit;

    const/4 v3, 0x0

    invoke-direct {v1, v3}, Lcom/amazon/identity/auth/device/api/MAPInit;-><init>(Landroid/content/Context;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 43
    .end local v0    # "applicationContext":Landroid/content/Context;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1

    .line 60
    .restart local v0    # "applicationContext":Landroid/content/Context;
    :cond_1
    :try_start_2
    new-instance v1, Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-direct {v1, v0}, Lcom/amazon/identity/auth/device/api/MAPInit;-><init>(Landroid/content/Context;)V

    .line 61
    sput-object v1, Lcom/amazon/identity/auth/device/api/MAPInit;->sTheOneAndOnly:Lcom/amazon/identity/auth/device/api/MAPInit;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public static isRunningInFunctionalTest()Z
    .locals 1

    .prologue
    .line 127
    sget-boolean v0, Lcom/amazon/identity/auth/device/api/MAPInit;->sIsRunningInFunctionalTest:Z

    return v0
.end method

.method public static setIsRunningInFunctionalTest(Z)V
    .locals 0
    .param p0, "isRunningInFunctionalTest"    # Z

    .prologue
    .line 121
    sput-boolean p0, Lcom/amazon/identity/auth/device/api/MAPInit;->sIsRunningInFunctionalTest:Z

    .line 122
    return-void
.end method

.method private toggleSettings()V
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->toggleEnvironment(Landroid/content/Context;)V

    .line 157
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/DebugHelpers;->toggleDebugLogsEnabled(Landroid/content/Context;)V

    .line 158
    return-void
.end method


# virtual methods
.method public declared-synchronized initialize()V
    .locals 1

    .prologue
    .line 73
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_1

    .line 116
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 78
    :cond_1
    :try_start_1
    iget-boolean v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mInitialized:Z

    if-nez v0, :cond_0

    .line 83
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit;->mInitialized:Z

    .line 85
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPInit$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/api/MAPInit$1;-><init>(Lcom/amazon/identity/auth/device/api/MAPInit;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->runOffMainThread(Ljava/lang/Runnable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 73
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
