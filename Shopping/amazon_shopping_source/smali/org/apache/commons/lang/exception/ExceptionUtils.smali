.class public Lorg/apache/commons/lang/exception/ExceptionUtils;
.super Ljava/lang/Object;
.source "ExceptionUtils.java"


# static fields
.field private static CAUSE_METHOD_NAMES:[Ljava/lang/String;

.field private static final THROWABLE_CAUSE_METHOD:Ljava/lang/reflect/Method;

.field private static final THROWABLE_INITCAUSE_METHOD:Ljava/lang/reflect/Method;

.field static class$java$lang$Throwable:Ljava/lang/Class;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 62
    const/16 v2, 0xc

    new-array v2, v2, [Ljava/lang/String;

    const-string/jumbo v3, "getCause"

    aput-object v3, v2, v4

    const-string/jumbo v3, "getNextException"

    aput-object v3, v2, v5

    const/4 v3, 0x2

    const-string/jumbo v4, "getTargetException"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    const-string/jumbo v4, "getException"

    aput-object v4, v2, v3

    const/4 v3, 0x4

    const-string/jumbo v4, "getSourceException"

    aput-object v4, v2, v3

    const/4 v3, 0x5

    const-string/jumbo v4, "getRootCause"

    aput-object v4, v2, v3

    const/4 v3, 0x6

    const-string/jumbo v4, "getCausedByException"

    aput-object v4, v2, v3

    const/4 v3, 0x7

    const-string/jumbo v4, "getNested"

    aput-object v4, v2, v3

    const/16 v3, 0x8

    const-string/jumbo v4, "getLinkedException"

    aput-object v4, v2, v3

    const/16 v3, 0x9

    const-string/jumbo v4, "getNestedException"

    aput-object v4, v2, v3

    const/16 v3, 0xa

    const-string/jumbo v4, "getLinkedCause"

    aput-object v4, v2, v3

    const/16 v3, 0xb

    const-string/jumbo v4, "getThrowable"

    aput-object v4, v2, v3

    sput-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->CAUSE_METHOD_NAMES:[Ljava/lang/String;

    .line 90
    :try_start_0
    sget-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;

    if-nez v2, :cond_0

    const-string/jumbo v2, "java.lang.Throwable"

    invoke-static {v2}, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    sput-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;

    :goto_0
    const-string/jumbo v3, "getCause"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 94
    .local v0, "causeMethod":Ljava/lang/reflect/Method;
    :goto_1
    sput-object v0, Lorg/apache/commons/lang/exception/ExceptionUtils;->THROWABLE_CAUSE_METHOD:Ljava/lang/reflect/Method;

    .line 96
    :try_start_1
    sget-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;

    if-nez v2, :cond_1

    const-string/jumbo v2, "java.lang.Throwable"

    invoke-static {v2}, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    sput-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;

    move-object v3, v2

    :goto_2
    const-string/jumbo v4, "initCause"

    const/4 v2, 0x1

    new-array v5, v2, [Ljava/lang/Class;

    const/4 v6, 0x0

    sget-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;

    if-nez v2, :cond_2

    const-string/jumbo v2, "java.lang.Throwable"

    invoke-static {v2}, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    sput-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;

    :goto_3
    aput-object v2, v5, v6

    invoke-virtual {v3, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 100
    :goto_4
    sput-object v0, Lorg/apache/commons/lang/exception/ExceptionUtils;->THROWABLE_INITCAUSE_METHOD:Ljava/lang/reflect/Method;

    .line 101
    return-void

    .line 90
    .end local v0    # "causeMethod":Ljava/lang/reflect/Method;
    :cond_0
    :try_start_2
    sget-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 91
    :catch_0
    move-exception v1

    .line 92
    .local v1, "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    .restart local v0    # "causeMethod":Ljava/lang/reflect/Method;
    goto :goto_1

    .line 96
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_3
    sget-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;

    move-object v3, v2

    goto :goto_2

    :cond_2
    sget-object v2, Lorg/apache/commons/lang/exception/ExceptionUtils;->class$java$lang$Throwable:Ljava/lang/Class;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_3

    .line 97
    :catch_1
    move-exception v1

    .line 98
    .restart local v1    # "e":Ljava/lang/Exception;
    const/4 v0, 0x0

    goto :goto_4
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 110
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 111
    return-void
.end method

.method static class$(Ljava/lang/String;)Ljava/lang/Class;
    .locals 2
    .param p0, "x0"    # Ljava/lang/String;

    .prologue
    .line 90
    :try_start_0
    invoke-static {p0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    return-object v1

    :catch_0
    move-exception v0

    .local v0, "x1":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ljava/lang/NoClassDefFoundError;

    invoke-direct {v1}, Ljava/lang/NoClassDefFoundError;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/NoClassDefFoundError;->initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v1

    throw v1
.end method

.method public static getStackTrace(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 3
    .param p0, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 891
    new-instance v1, Ljava/io/StringWriter;

    invoke-direct {v1}, Ljava/io/StringWriter;-><init>()V

    .line 892
    .local v1, "sw":Ljava/io/StringWriter;
    new-instance v0, Ljava/io/PrintWriter;

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;Z)V

    .line 893
    .local v0, "pw":Ljava/io/PrintWriter;
    invoke-virtual {p0, v0}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 894
    invoke-virtual {v1}, Ljava/io/StringWriter;->getBuffer()Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
