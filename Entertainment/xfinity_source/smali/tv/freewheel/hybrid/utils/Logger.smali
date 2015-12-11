.class public Ltv/freewheel/hybrid/utils/Logger;
.super Ljava/lang/Object;
.source "Logger.java"


# static fields
.field private static logLevel:I


# instance fields
.field protected isAndroid:Z

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

    sput v0, Ltv/freewheel/hybrid/utils/Logger;->logLevel:I

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 6
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logVerboseMethod:Ljava/lang/reflect/Method;

    .line 26
    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logDebugMethod:Ljava/lang/reflect/Method;

    .line 27
    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logInfoMethod:Ljava/lang/reflect/Method;

    .line 28
    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logWarnMethod:Ljava/lang/reflect/Method;

    .line 29
    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logErrorMethod:Ljava/lang/reflect/Method;

    .line 30
    iput-boolean v5, p0, Ltv/freewheel/hybrid/utils/Logger;->textWithThreadIDAsPrefix:Z

    .line 31
    iput-boolean v5, p0, Ltv/freewheel/hybrid/utils/Logger;->isAndroid:Z

    .line 32
    const-string v4, "FW-"

    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->tag:Ljava/lang/String;

    .line 35
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/Logger;->tag:Ljava/lang/String;

    .line 36
    const-class v4, Ltv/freewheel/hybrid/utils/Logger;

    invoke-virtual {v4}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    .line 38
    .local v1, "cl":Ljava/lang/ClassLoader;
    :try_start_0
    const-string v4, "android.util.Log"

    const/4 v5, 0x1

    invoke-static {v4, v5, v1}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v0

    .line 39
    .local v0, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const/4 v4, 0x2

    new-array v3, v4, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-class v5, Ljava/lang/String;

    aput-object v5, v3, v4

    .line 40
    .local v3, "parameterTypes":[Ljava/lang/Class;, "[Ljava/lang/Class<*>;"
    const-string v4, "v"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logVerboseMethod:Ljava/lang/reflect/Method;

    .line 41
    const-string v4, "d"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logDebugMethod:Ljava/lang/reflect/Method;

    .line 42
    const-string v4, "i"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logInfoMethod:Ljava/lang/reflect/Method;

    .line 43
    const-string v4, "w"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logWarnMethod:Ljava/lang/reflect/Method;

    .line 44
    const-string v4, "e"

    invoke-virtual {v0, v4, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/hybrid/utils/Logger;->logErrorMethod:Ljava/lang/reflect/Method;

    .line 45
    const/4 v4, 0x1

    iput-boolean v4, p0, Ltv/freewheel/hybrid/utils/Logger;->isAndroid:Z
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
    .line 95
    iget-boolean v2, p0, Ltv/freewheel/hybrid/utils/Logger;->isAndroid:Z

    if-eqz v2, :cond_0

    sget v2, Ltv/freewheel/hybrid/utils/Logger;->logLevel:I

    if-lt p3, v2, :cond_0

    .line 97
    :try_start_0
    iget-boolean v2, p0, Ltv/freewheel/hybrid/utils/Logger;->textWithThreadIDAsPrefix:Z

    if-eqz v2, :cond_1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ltv/freewheel/hybrid/utils/CommonUtil;->currentThreadIdentifier()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 98
    .local v1, "text":Ljava/lang/String;
    :goto_0
    const/4 v2, 0x2

    new-array v0, v2, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Ltv/freewheel/hybrid/utils/Logger;->tag:Ljava/lang/String;

    aput-object v3, v0, v2

    const/4 v2, 0x1

    aput-object v1, v0, v2

    .line 99
    .local v0, "args":[Ljava/lang/Object;
    const/4 v2, 0x0

    invoke-virtual {p1, v2, v0}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    .end local v0    # "args":[Ljava/lang/Object;
    .end local v1    # "text":Ljava/lang/String;
    :cond_0
    :goto_1
    return-void

    :cond_1
    move-object v1, p2

    .line 97
    goto :goto_0

    .line 100
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method private doSystemOut(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 3
    .param p1, "levelString"    # Ljava/lang/String;
    .param p2, "s"    # Ljava/lang/String;
    .param p3, "level"    # I

    .prologue
    .line 85
    iget-boolean v1, p0, Ltv/freewheel/hybrid/utils/Logger;->isAndroid:Z

    if-nez v1, :cond_1

    sget v1, Ltv/freewheel/hybrid/utils/Logger;->logLevel:I

    if-lt p3, v1, :cond_1

    .line 86
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    .line 87
    .local v0, "ps":Ljava/io/PrintStream;
    const-string v1, "error"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    .line 89
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ltv/freewheel/hybrid/utils/Logger;->now()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Ltv/freewheel/hybrid/utils/Logger;->tag:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 92
    .end local v0    # "ps":Ljava/io/PrintStream;
    :cond_1
    return-void
.end method

.method public static getLogLevel()I
    .locals 1

    .prologue
    .line 132
    sget v0, Ltv/freewheel/hybrid/utils/Logger;->logLevel:I

    return v0
.end method

.method public static getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 71
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;Z)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    return-object v0
.end method

.method public static getLogger(Ljava/lang/Object;Z)Ltv/freewheel/hybrid/utils/Logger;
    .locals 2
    .param p0, "obj"    # Ljava/lang/Object;
    .param p1, "tagWithThreadID"    # Z

    .prologue
    .line 66
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "className":Ljava/lang/String;
    invoke-static {v0, p1}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/String;Z)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    return-object v1
.end method

.method public static getLogger(Ljava/lang/String;)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;

    .prologue
    .line 56
    const/4 v0, 0x0

    invoke-static {p0, v0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/String;Z)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    return-object v0
.end method

.method public static getLogger(Ljava/lang/String;Z)Ltv/freewheel/hybrid/utils/Logger;
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "tagWithThreadID"    # Z

    .prologue
    .line 60
    new-instance v0, Ltv/freewheel/hybrid/utils/Logger;

    invoke-direct {v0, p0}, Ltv/freewheel/hybrid/utils/Logger;-><init>(Ljava/lang/String;)V

    .line 61
    .local v0, "logger":Ltv/freewheel/hybrid/utils/Logger;
    iput-boolean p1, v0, Ltv/freewheel/hybrid/utils/Logger;->textWithThreadIDAsPrefix:Z

    .line 62
    return-object v0
.end method

.method public static now()Ljava/lang/String;
    .locals 3

    .prologue
    .line 79
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 80
    .local v0, "cal":Ljava/util/Calendar;
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "[yyyy-MM-dd HH:mm:ss]"

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 81
    .local v1, "sdf":Ljava/text/SimpleDateFormat;
    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static setLogLevel(I)V
    .locals 0
    .param p0, "level"    # I

    .prologue
    .line 75
    sput p0, Ltv/freewheel/hybrid/utils/Logger;->logLevel:I

    .line 76
    return-void
.end method


# virtual methods
.method public debug(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x3

    .line 112
    const-string v0, "debug"

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doSystemOut(Ljava/lang/String;Ljava/lang/String;I)V

    .line 113
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Logger;->logDebugMethod:Ljava/lang/reflect/Method;

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 114
    return-void
.end method

.method public error(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x6

    .line 127
    const-string v0, "error"

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doSystemOut(Ljava/lang/String;Ljava/lang/String;I)V

    .line 128
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Logger;->logErrorMethod:Ljava/lang/reflect/Method;

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 129
    return-void
.end method

.method public info(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x4

    .line 117
    const-string v0, "info"

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doSystemOut(Ljava/lang/String;Ljava/lang/String;I)V

    .line 118
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Logger;->logInfoMethod:Ljava/lang/reflect/Method;

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 119
    return-void
.end method

.method public verbose(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x2

    .line 107
    const-string v0, "verbose"

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doSystemOut(Ljava/lang/String;Ljava/lang/String;I)V

    .line 108
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Logger;->logVerboseMethod:Ljava/lang/reflect/Method;

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 109
    return-void
.end method

.method public warn(Ljava/lang/String;)V
    .locals 2
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x5

    .line 122
    const-string v0, "warn"

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doSystemOut(Ljava/lang/String;Ljava/lang/String;I)V

    .line 123
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/Logger;->logWarnMethod:Ljava/lang/reflect/Method;

    invoke-direct {p0, v0, p1, v1}, Ltv/freewheel/hybrid/utils/Logger;->doLoggerInvoke(Ljava/lang/reflect/Method;Ljava/lang/String;I)V

    .line 124
    return-void
.end method
