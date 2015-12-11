.class public Lcom/conviva/utils/Utils;
.super Lcom/conviva/utils/PlatformUtils;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/conviva/utils/Utils$HTTPTask;
    }
.end annotation


# static fields
.field private static _appContext:Landroid/content/Context;

.field private static _platformMetadata:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static _traceOverride:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x0

    sput-object v1, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const/4 v0, 0x0

    sput-boolean v0, Lcom/conviva/utils/Utils;->_traceOverride:Z

    sput-object v1, Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;

    return-void
.end method

.method private constructor <init>(Lcom/conviva/utils/Settings;Landroid/content/Context;)V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/conviva/utils/PlatformUtils;-><init>(Lcom/conviva/utils/Settings;)V

    sput-object p2, Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;

    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    iput-object v0, p0, Lcom/conviva/utils/Utils;->_PLATFORM_VER:Ljava/lang/String;

    return-void
.end method

.method public static CreateUtils(Ljava/util/Map;Landroid/content/Context;)Lcom/conviva/utils/PlatformUtils;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Landroid/content/Context;",
            ")",
            "Lcom/conviva/utils/PlatformUtils;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    sget-object v0, Lcom/conviva/utils/Utils;->_instance:Lcom/conviva/utils/PlatformUtils;

    if-nez v0, :cond_0

    new-instance v0, Lcom/conviva/utils/Settings;

    invoke-direct {v0}, Lcom/conviva/utils/Settings;-><init>()V

    invoke-virtual {v0, p0}, Lcom/conviva/utils/Settings;->changeSettings(Ljava/util/Map;)V

    new-instance v1, Lcom/conviva/utils/Utils;

    invoke-direct {v1, v0, p1}, Lcom/conviva/utils/Utils;-><init>(Lcom/conviva/utils/Settings;Landroid/content/Context;)V

    sput-object v1, Lcom/conviva/utils/Utils;->_instance:Lcom/conviva/utils/PlatformUtils;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/conviva_debug.txt"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/io/File;

    invoke-direct {v1, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v0

    sput-boolean v0, Lcom/conviva/utils/Utils;->_traceOverride:Z

    sget-object v0, Lcom/conviva/utils/Utils;->_instance:Lcom/conviva/utils/PlatformUtils;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lcom/conviva/utils/Utils;->_instance:Lcom/conviva/utils/PlatformUtils;

    invoke-virtual {v0}, Lcom/conviva/utils/PlatformUtils;->getSettings()Lcom/conviva/utils/Settings;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/conviva/utils/Settings;->changeSettings(Ljava/util/Map;)V

    sget-object v0, Lcom/conviva/utils/Utils;->_instance:Lcom/conviva/utils/PlatformUtils;

    iget v1, v0, Lcom/conviva/utils/PlatformUtils;->_referenceCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/conviva/utils/PlatformUtils;->_referenceCount:I

    sget-object v0, Lcom/conviva/utils/Utils;->_instance:Lcom/conviva/utils/PlatformUtils;

    goto :goto_0
.end method

.method static synthetic access$000()Landroid/content/Context;
    .locals 1

    sget-object v0, Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;

    return-object v0
.end method

.method private writeClientId()V
    .locals 3

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    const-string v1, "clId"

    iget-object v2, p0, Lcom/conviva/utils/Utils;->clientId:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-instance v1, Lcom/conviva/utils/Utils$1;

    invoke-direct {v1, p0}, Lcom/conviva/utils/Utils$1;-><init>(Lcom/conviva/utils/Utils;)V

    invoke-virtual {p0, v0, v1}, Lcom/conviva/utils/Utils;->jsonEncode(Ljava/util/Map;Lcom/conviva/utils/CallableWithParameters$With1;)V

    return-void
.end method


# virtual methods
.method public getPlatformMetadata()Ljava/util/Map;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const-string v1, "sch"

    const-string v2, "and1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :try_start_0
    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const-string v1, "dv"

    const-string v2, "android"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const-string v1, "dvt"

    const-string v2, "Mobile"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const-string v1, "os"

    const-string v2, "AND"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const-string v1, "osv"

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const-string v1, "manu"

    sget-object v2, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    const-string v1, "mod"

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    sget-object v0, Lcom/conviva/utils/Utils;->_platformMetadata:Ljava/util/Map;

    return-object v0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public httpRequest(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/conviva/utils/CallableWithParameters$With1;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Boolean;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/conviva/utils/CallableWithParameters$With1",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    new-instance v0, Lcom/conviva/utils/Utils$HTTPTask;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/conviva/utils/Utils$HTTPTask;-><init>(Lcom/conviva/utils/Utils;Lcom/conviva/utils/Utils$1;)V

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/conviva/utils/Utils$HTTPTask;->setState(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/conviva/utils/CallableWithParameters$With1;)V

    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    :cond_0
    return-void
.end method

.method public inSleepingMode()Ljava/lang/Boolean;
    .locals 2

    sget-object v0, Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;

    const-string v1, "power"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    invoke-virtual {v0}, Landroid/os/PowerManager;->isScreenOn()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isVisible()Ljava/lang/Boolean;
    .locals 6

    const/4 v5, 0x1

    const/4 v2, 0x0

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v3

    sget-object v0, Lcom/conviva/utils/Utils;->_appContext:Landroid/content/Context;

    const-string v1, "activity"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v4

    if-nez v4, :cond_0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    move v1, v2

    :goto_1
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager$RunningAppProcessInfo;

    iget v0, v0, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-ne v0, v3, :cond_2

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager$RunningAppProcessInfo;

    iget v0, v0, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v1, 0xc8

    if-gt v0, v1, :cond_1

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0

    :cond_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_3
    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public logConsole(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/conviva/utils/Utils;->_settings:Lcom/conviva/utils/Settings;

    iget-boolean v0, v0, Lcom/conviva/utils/Settings;->enableLogging:Z

    if-nez v0, :cond_0

    sget-boolean v0, Lcom/conviva/utils/Utils;->_traceOverride:Z

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, "ERROR:"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "CONVIVA"

    invoke-static {v0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    :cond_1
    :goto_0
    return-void

    :cond_2
    const-string v0, "CONVIVA"

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public setClientIdFromServer(Ljava/lang/String;)V
    .locals 2

    iget-object v0, p0, Lcom/conviva/utils/Utils;->clientId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iput-object p1, p0, Lcom/conviva/utils/Utils;->clientId:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Setting the client id to "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " (from server)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/conviva/utils/Utils;->log(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/conviva/utils/Utils;->writeClientId()V

    :cond_0
    return-void
.end method

.method public startFetchClientId()V
    .locals 2

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/conviva/utils/Utils$1LoadDataTask;

    invoke-direct {v1, p0}, Lcom/conviva/utils/Utils$1LoadDataTask;-><init>(Lcom/conviva/utils/Utils;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    :cond_0
    return-void
.end method
