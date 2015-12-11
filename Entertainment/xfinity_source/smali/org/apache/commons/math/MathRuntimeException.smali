.class public Lorg/apache/commons/math/MathRuntimeException;
.super Ljava/lang/RuntimeException;
.source "MathRuntimeException.java"


# instance fields
.field private final arguments:[Ljava/lang/Object;

.field private final pattern:Ljava/lang/String;


# direct methods
.method static synthetic access$000(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ljava/util/Locale;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # [Ljava/lang/Object;

    .prologue
    .line 37
    invoke-static {p0, p1, p2}, Lorg/apache/commons/math/MathRuntimeException;->buildMessage(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static varargs buildMessage(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    .locals 2
    .param p0, "locale"    # Ljava/util/Locale;
    .param p1, "pattern"    # Ljava/lang/String;
    .param p2, "arguments"    # [Ljava/lang/Object;

    .prologue
    .line 87
    if-nez p1, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/text/MessageFormat;

    invoke-static {p1, p0}, Lorg/apache/commons/math/MathRuntimeException;->translate(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Ljava/text/MessageFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    invoke-virtual {v0, p2}, Ljava/text/MessageFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static varargs createIllegalArgumentException(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/IllegalArgumentException;
    .locals 2
    .param p0, "pattern"    # Ljava/lang/String;
    .param p1, "arguments"    # [Ljava/lang/Object;

    .prologue
    .line 282
    new-instance v0, Lorg/apache/commons/math/MathRuntimeException$4;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-static {v1, p0, p1}, Lorg/apache/commons/math/MathRuntimeException;->buildMessage(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1, p0, p1}, Lorg/apache/commons/math/MathRuntimeException$4;-><init>(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    return-object v0
.end method

.method private static translate(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;
    .locals 3
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "locale"    # Ljava/util/Locale;

    .prologue
    .line 61
    :try_start_0
    const-string v1, "org.apache.commons.math.MessagesResources"

    invoke-static {v1, p1}, Ljava/util/ResourceBundle;->getBundle(Ljava/lang/String;Ljava/util/Locale;)Ljava/util/ResourceBundle;

    move-result-object v0

    .line 63
    .local v0, "bundle":Ljava/util/ResourceBundle;
    invoke-virtual {v0}, Ljava/util/ResourceBundle;->getLocale()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 65
    invoke-virtual {v0, p0}, Ljava/util/ResourceBundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/util/MissingResourceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p0

    .line 74
    .end local v0    # "bundle":Ljava/util/ResourceBundle;
    .end local p0    # "s":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p0

    .line 68
    .restart local p0    # "s":Ljava/lang/String;
    :catch_0
    move-exception v1

    goto :goto_0
.end method


# virtual methods
.method public getLocalizedMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 161
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p0, v0}, Lorg/apache/commons/math/MathRuntimeException;->getMessage(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMessage(Ljava/util/Locale;)Ljava/lang/String;
    .locals 2
    .param p1, "locale"    # Ljava/util/Locale;

    .prologue
    .line 155
    iget-object v0, p0, Lorg/apache/commons/math/MathRuntimeException;->pattern:Ljava/lang/String;

    iget-object v1, p0, Lorg/apache/commons/math/MathRuntimeException;->arguments:[Ljava/lang/Object;

    invoke-static {p1, v0, v1}, Lorg/apache/commons/math/MathRuntimeException;->buildMessage(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public printStackTrace()V
    .locals 1

    .prologue
    .line 169
    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-virtual {p0, v0}, Lorg/apache/commons/math/MathRuntimeException;->printStackTrace(Ljava/io/PrintStream;)V

    .line 170
    return-void
.end method

.method public printStackTrace(Ljava/io/PrintStream;)V
    .locals 2
    .param p1, "out"    # Ljava/io/PrintStream;

    .prologue
    .line 179
    monitor-enter p1

    .line 180
    :try_start_0
    new-instance v0, Ljava/io/PrintWriter;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Ljava/io/PrintWriter;-><init>(Ljava/io/OutputStream;Z)V

    .line 181
    .local v0, "pw":Ljava/io/PrintWriter;
    invoke-virtual {p0, v0}, Lorg/apache/commons/math/MathRuntimeException;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 183
    invoke-virtual {v0}, Ljava/io/PrintWriter;->flush()V

    .line 184
    monitor-exit p1

    .line 185
    return-void

    .line 184
    .end local v0    # "pw":Ljava/io/PrintWriter;
    :catchall_0
    move-exception v1

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method
