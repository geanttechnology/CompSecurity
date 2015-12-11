.class public Ltv/freewheel/utils/Logger;
.super Ljava/lang/Object;
.source "Logger.java"


# static fields
.field private static forceVerbose:Z

.field private static logLevel:I


# instance fields
.field private logDebugMethod:Ljava/lang/reflect/Method;

.field private logErrorMethod:Ljava/lang/reflect/Method;

.field private logInfoMethod:Ljava/lang/reflect/Method;

.field private logVerboseMethod:Ljava/lang/reflect/Method;

.field private logWarnMethod:Ljava/lang/reflect/Method;

.field private tag:Ljava/lang/String;

.field private textWithThreadIDAsPrefix:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x2

    sput v0, Ltv/freewheel/utils/Logger;->logLevel:I

    .line 25
    const/4 v0, 0x0

    sput-boolean v0, Ltv/freewheel/utils/Logger;->forceVerbose:Z

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logVerboseMethod:Ljava/lang/reflect/Method;

    .line 28
    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logDebugMethod:Ljava/lang/reflect/Method;

    .line 29
    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logInfoMethod:Ljava/lang/reflect/Method;

    .line 30
    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logWarnMethod:Ljava/lang/reflect/Method;

    .line 31
    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logErrorMethod:Ljava/lang/reflect/Method;

    .line 32
    iput-boolean v5, p0, Ltv/freewheel/utils/Logger;->textWithThreadIDAsPrefix:Z

    .line 33
    const-string v4, "FW-"

    iput-object v4, p0, Ltv/freewheel/utils/Logger;->tag:Ljava/lang/String;

    .line 36
    iput-object p1, p0, Ltv/freewheel/utils/Logger;->tag:Ljava/lang/String;

    .line 37
    const-class v4, Ltv/freewheel/utils/Logger;

    invoke-virtual {v4}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    .line 39
    .local v1, "cl":Ljava/lang/ClassLoader;
    :try_start_0
    const-string v4, "android.util.Log"

    const/4 v5, 0x1

    invoke-static {v4, v5, v1}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v0

    .line 40
    .local v0, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v4, 0x2

    new-array v3, v4, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    .line 41
    .local v3, "parameterTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    const-string v4, "v"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logVerboseMethod:Ljava/lang/reflect/Method;

    .line 42
    const-string v4, "d"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logDebugMethod:Ljava/lang/reflect/Method;

    .line 43
    const-string v4, "i"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logInfoMethod:Ljava/lang/reflect/Method;

    .line 44
    const-string v4, "w"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logWarnMethod:Ljava/lang/reflect/Method;

    .line 45
    const-string v4, "e"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/utils/Logger;->logErrorMethod:Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1

    .line 53
    .end local v0    # "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v3    # "parameterTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    :goto_0
    return-void

    .line 48
    :catch_0
    move-exception v2

    .line 49
    .local v2, "e":Ljava/lang/SecurityException;
    invoke-virtual {v2}, Ljava/lang/SecurityException;->printStackTrace()V

    goto :goto_0

    .line 50
    .end local v2    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v2

    .line 51
    .local v2, "e":Ljava/lang/NoSuchMethodException;
    invoke-virtual {v2}, Ljava/lang/NoSuchMethodException;->printStackTrace()V

    goto :goto_0

    .line 46
    .end local v2    # "e":Ljava/lang/NoSuchMethodException;
    :catch_2
    move-exception v4

    goto :goto_0
.end method

.method private doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V
    .locals 4
    .param p1, "m"    # Ljava/lang/reflect/Method;
    .param p2, "s"    # Ljava/lang/String;
    .param p3, "level"    # I

    .prologue
    .line 90
    sget v2, Ltv/freewheel/utils/Logger;->logLevel:I

    if-lt p3, v2, :cond_0

    .line 92
    :try_start_0
    iget-boolean v2, p0, Ltv/freewheel/utils/Logger;->textWithThreadIDAsPrefix:Z

    if-eqz v2, :cond_1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ltv/freewheel/utils/CommonUtil;->currentThreadIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 93
    .local v1, "text":Ljava/lang/String;
    :goto_0
    const/4 v2, 0x2

    new-array v0, v2, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Ltv/freewheel/utils/Logger;->tag:Ljava/lang/String;

    aput-object v3, v0, v2

    const/4 v2, 0x1

    aput-object v1, v0, v2

    .line 94
    .local v0, "args":[Ljava/lang/Object;
    const/4 v2, 0x0

    invoke-virtual {p1, v2, v0}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    .end local v0    # "args":[Ljava/lang/Object;
    .end local v1    # "text":Ljava/lang/String;
    :cond_0
    :goto_1
    return-void

    :cond_1
    move-object v1, p2

    .line 92
    goto :goto_0

    .line 95
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method public static getLogLevel()I
    .locals 1

    .prologue
    .line 122
    sget v0, Ltv/freewheel/utils/Logger;->logLevel:I

    return v0
.end method

.method public static getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 80
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    return-object v0
.end method

.method public static getLogger(Ljava/lang/Object;Z)Ltv/freewheel/utils/Logger;
    .locals 2
    .param p0, "obj"    # Ljava/lang/Object;
    .param p1, "tagWithThreadID"    # Z

    .prologue
    .line 75
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    .line 76
    .local v0, "className":Ljava/lang/String;
    invoke-static {v0, p1}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/String;Z)Ltv/freewheel/utils/Logger;

    move-result-object v1

    return-object v1
.end method

.method public static getLogger(Ljava/lang/String;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;

    .prologue
    .line 65
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/String;Z)Ltv/freewheel/utils/Logger;

    move-result-object v0

    return-object v0
.end method

.method public static getLogger(Ljava/lang/String;Z)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "tagWithThreadID"    # Z

    .prologue
    .line 69
    new-instance v0, Ltv/freewheel/utils/Logger;

    invoke-direct {v0, p0}, Ltv/freewheel/utils/Logger;-><init>(Ljava/lang/String;)V

    .line 70
    .local v0, "logger":Ltv/freewheel/utils/Logger;
    iput-boolean p1, v0, Ltv/freewheel/utils/Logger;->textWithThreadIDAsPrefix:Z

    .line 71
    return-object v0
.end method

.method public static overrideLogLevel(Landroid/app/Activity;)V
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 56
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const-string v2, "fwdbg://"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 58
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/high16 v2, 0x10000

    invoke-virtual {v1, v0, v2}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 59
    const/4 v1, 0x1

    sput-boolean v1, Ltv/freewheel/utils/Logger;->forceVerbose:Z

    .line 60
    const/4 v1, 0x2

    sput v1, Ltv/freewheel/utils/Logger;->logLevel:I

    .line 62
    :cond_0
    return-void
.end method

.method public static setLogLevel(I)V
    .locals 1
    .param p0, "level"    # I

    .prologue
    .line 84
    sget-boolean v0, Ltv/freewheel/utils/Logger;->forceVerbose:Z

    if-nez v0, :cond_0

    .line 85
    sput p0, Ltv/freewheel/utils/Logger;->logLevel:I

    .line 87
    :cond_0
    return-void
.end method


# virtual methods
.method public debug(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 106
    iget-object v0, p0, Ltv/freewheel/utils/Logger;->logDebugMethod:Ljava/lang/reflect/Method;

    const/4 v1, 0x3

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 107
    return-void
.end method

.method public error(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 118
    iget-object v0, p0, Ltv/freewheel/utils/Logger;->logErrorMethod:Ljava/lang/reflect/Method;

    const/4 v1, 0x6

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 119
    return-void
.end method

.method public info(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 110
    iget-object v0, p0, Ltv/freewheel/utils/Logger;->logInfoMethod:Ljava/lang/reflect/Method;

    const/4 v1, 0x4

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 111
    return-void
.end method

.method public verbose(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 102
    iget-object v0, p0, Ltv/freewheel/utils/Logger;->logVerboseMethod:Ljava/lang/reflect/Method;

    const/4 v1, 0x2

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 103
    return-void
.end method

.method public warn(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 114
    iget-object v0, p0, Ltv/freewheel/utils/Logger;->logWarnMethod:Ljava/lang/reflect/Method;

    const/4 v1, 0x5

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 115
    return-void
.end method
