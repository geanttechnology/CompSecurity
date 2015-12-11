.class public abstract Lcom/xfinity/playerlib/PlayerApplication;
.super Landroid/app/Application;
.source "PlayerApplication.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field private static instance:Lcom/xfinity/playerlib/PlayerApplication;


# instance fields
.field private installId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/xfinity/playerlib/PlayerApplication;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/PlayerApplication;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/app/Application;-><init>()V

    .line 152
    return-void
.end method

.method private createInstallId(Landroid/content/SharedPreferences;)Ljava/lang/String;
    .locals 3
    .param p1, "preferences"    # Landroid/content/SharedPreferences;

    .prologue
    .line 147
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 148
    .local v0, "uuid":Ljava/lang/String;
    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "AppInstallId"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 149
    return-object v0
.end method

.method public static getInstance()Lcom/xfinity/playerlib/PlayerApplication;
    .locals 1

    .prologue
    .line 116
    sget-object v0, Lcom/xfinity/playerlib/PlayerApplication;->instance:Lcom/xfinity/playerlib/PlayerApplication;

    return-object v0
.end method

.method private readInstallId(Landroid/content/SharedPreferences;)Ljava/lang/String;
    .locals 2
    .param p1, "preferences"    # Landroid/content/SharedPreferences;

    .prologue
    .line 143
    const-string v0, "AppInstallId"

    const/4 v1, 0x0

    invoke-interface {p1, v0, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public configureLogging()V
    .locals 4

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget v3, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v3, v3, 0x2

    iput v3, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    if-eqz v3, :cond_0

    const/4 v1, 0x1

    .line 107
    .local v1, "isDebuggable":Z
    :goto_0
    if-eqz v1, :cond_1

    .line 108
    const-class v2, Lcom/xfinity/playerlib/PlayNowLog4JConfigurator;

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->getNewInstanceOfOverrideableClass(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;

    .line 112
    .local v0, "configurator":Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;
    :goto_1
    invoke-interface {v0}, Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;->configureLogging()V

    .line 113
    return-void

    .line 106
    .end local v0    # "configurator":Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;
    .end local v1    # "isDebuggable":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 110
    .restart local v1    # "isDebuggable":Z
    :cond_1
    const-class v2, Lcom/xfinity/playerlib/PlayNowLog4JConfiguratorProduction;

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->getNewInstanceOfOverrideableClass(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;

    .restart local v0    # "configurator":Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;
    goto :goto_1
.end method

.method public getCurrentlyRunningProcessName(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 93
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    .line 94
    .local v1, "pid":I
    const-string v3, "activity"

    invoke-virtual {p1, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 95
    .local v0, "activityManager":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 96
    .local v2, "runningAppProcessInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v4, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-ne v4, v1, :cond_0

    .line 97
    iget-object v3, v2, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    .line 100
    .end local v2    # "runningAppProcessInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    :goto_0
    return-object v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public getInstallId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 139
    iget-object v0, p0, Lcom/xfinity/playerlib/PlayerApplication;->installId:Ljava/lang/String;

    return-object v0
.end method

.method public getVersionCode()I
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 131
    :try_start_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    iget v1, v2, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    :goto_0
    return v1

    .line 132
    :catch_0
    move-exception v0

    .line 133
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v2, Lcom/xfinity/playerlib/PlayerApplication;->LOG:Lorg/slf4j/Logger;

    const-string v3, "failed retrieving package info"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getVersionNumber()Ljava/lang/String;
    .locals 4

    .prologue
    .line 121
    :try_start_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 125
    :goto_0
    return-object v1

    .line 123
    :catch_0
    move-exception v0

    .line 124
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v1, Lcom/xfinity/playerlib/PlayerApplication;->LOG:Lorg/slf4j/Logger;

    const-string v2, "failed retrieving package info"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 125
    const-string v1, ""

    goto :goto_0
.end method

.method public abstract initializeContainer(Lcom/xfinity/playerlib/PlayerApplication;)V
.end method

.method public isMainProcess()Z
    .locals 2

    .prologue
    .line 89
    invoke-virtual {p0, p0}, Lcom/xfinity/playerlib/PlayerApplication;->getCurrentlyRunningProcessName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 34
    invoke-super {p0}, Landroid/app/Application;->onCreate()V

    .line 35
    sput-object p0, Lcom/xfinity/playerlib/PlayerApplication;->instance:Lcom/xfinity/playerlib/PlayerApplication;

    .line 37
    new-instance v0, Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;-><init>(Lcom/xfinity/playerlib/PlayerApplication;)V

    invoke-static {v0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 39
    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->reset()V

    .line 40
    return-void
.end method

.method public reset()V
    .locals 6

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->isMainProcess()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 56
    new-instance v2, Lorg/apache/commons/lang3/time/StopWatch;

    invoke-direct {v2}, Lorg/apache/commons/lang3/time/StopWatch;-><init>()V

    .line 57
    .local v2, "timer":Lorg/apache/commons/lang3/time/StopWatch;
    invoke-virtual {v2}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 59
    invoke-virtual {p0, p0}, Lcom/xfinity/playerlib/PlayerApplication;->initializeContainer(Lcom/xfinity/playerlib/PlayerApplication;)V

    .line 61
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    .line 63
    .local v1, "playerContainer":Lcom/comcast/cim/container/PlayerContainer;
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getSplunkLogger()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->startService()V

    .line 65
    invoke-virtual {v2}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 68
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "PlayerContainer initialized in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 70
    .local v0, "containerInitLogMsg":Ljava/lang/String;
    invoke-virtual {v2}, Lorg/apache/commons/lang3/time/StopWatch;->reset()V

    .line 71
    invoke-virtual {v2}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 72
    invoke-virtual {p0}, Lcom/xfinity/playerlib/PlayerApplication;->configureLogging()V

    .line 73
    invoke-virtual {v2}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 74
    sget-object v3, Lcom/xfinity/playerlib/PlayerApplication;->LOG:Lorg/slf4j/Logger;

    invoke-interface {v3, v0}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 75
    sget-object v3, Lcom/xfinity/playerlib/PlayerApplication;->LOG:Lorg/slf4j/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Logging initialized in "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 77
    iget-object v3, p0, Lcom/xfinity/playerlib/PlayerApplication;->installId:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 78
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/PlayerApplication;->readInstallId(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/PlayerApplication;->installId:Ljava/lang/String;

    .line 79
    iget-object v3, p0, Lcom/xfinity/playerlib/PlayerApplication;->installId:Ljava/lang/String;

    if-nez v3, :cond_0

    .line 80
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getSharedPreferences()Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/PlayerApplication;->createInstallId(Landroid/content/SharedPreferences;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/PlayerApplication;->installId:Ljava/lang/String;

    .line 84
    .end local v0    # "containerInitLogMsg":Ljava/lang/String;
    .end local v1    # "playerContainer":Lcom/comcast/cim/container/PlayerContainer;
    .end local v2    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    :cond_0
    return-void
.end method
