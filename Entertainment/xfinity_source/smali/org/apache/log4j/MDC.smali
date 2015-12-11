.class public Lorg/apache/log4j/MDC;
.super Ljava/lang/Object;
.source "MDC.java"


# static fields
.field static final mdc:Lorg/apache/log4j/MDC;


# instance fields
.field java1:Z

.field tlm:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    new-instance v0, Lorg/apache/log4j/MDC;

    invoke-direct {v0}, Lorg/apache/log4j/MDC;-><init>()V

    sput-object v0, Lorg/apache/log4j/MDC;->mdc:Lorg/apache/log4j/MDC;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 55
    invoke-static {}, Lorg/apache/log4j/helpers/Loader;->isJava1()Z

    move-result v0

    iput-boolean v0, p0, Lorg/apache/log4j/MDC;->java1:Z

    .line 56
    iget-boolean v0, p0, Lorg/apache/log4j/MDC;->java1:Z

    if-nez v0, :cond_0

    .line 57
    new-instance v0, Lorg/apache/log4j/helpers/ThreadLocalMap;

    invoke-direct {v0}, Lorg/apache/log4j/helpers/ThreadLocalMap;-><init>()V

    iput-object v0, p0, Lorg/apache/log4j/MDC;->tlm:Ljava/lang/Object;

    .line 59
    :cond_0
    return-void
.end method

.method public static get(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 86
    sget-object v0, Lorg/apache/log4j/MDC;->mdc:Lorg/apache/log4j/MDC;

    if-eqz v0, :cond_0

    .line 87
    sget-object v0, Lorg/apache/log4j/MDC;->mdc:Lorg/apache/log4j/MDC;

    invoke-direct {v0, p0}, Lorg/apache/log4j/MDC;->get0(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 89
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private get0(Ljava/lang/String;)Ljava/lang/Object;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 145
    iget-boolean v1, p0, Lorg/apache/log4j/MDC;->java1:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lorg/apache/log4j/MDC;->tlm:Ljava/lang/Object;

    if-nez v1, :cond_1

    :cond_0
    move-object v1, v2

    .line 152
    :goto_0
    return-object v1

    .line 148
    :cond_1
    iget-object v1, p0, Lorg/apache/log4j/MDC;->tlm:Ljava/lang/Object;

    check-cast v1, Lorg/apache/log4j/helpers/ThreadLocalMap;

    invoke-virtual {v1}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Hashtable;

    .line 149
    .local v0, "ht":Ljava/util/Hashtable;
    if-eqz v0, :cond_2

    if-eqz p1, :cond_2

    .line 150
    invoke-virtual {v0, p1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    :cond_2
    move-object v1, v2

    .line 152
    goto :goto_0
.end method

.method public static getContext()Ljava/util/Hashtable;
    .locals 1

    .prologue
    .line 111
    sget-object v0, Lorg/apache/log4j/MDC;->mdc:Lorg/apache/log4j/MDC;

    if-eqz v0, :cond_0

    .line 112
    sget-object v0, Lorg/apache/log4j/MDC;->mdc:Lorg/apache/log4j/MDC;

    invoke-direct {v0}, Lorg/apache/log4j/MDC;->getContext0()Ljava/util/Hashtable;

    move-result-object v0

    .line 114
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getContext0()Ljava/util/Hashtable;
    .locals 1

    .prologue
    .line 170
    iget-boolean v0, p0, Lorg/apache/log4j/MDC;->java1:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lorg/apache/log4j/MDC;->tlm:Ljava/lang/Object;

    if-nez v0, :cond_1

    .line 171
    :cond_0
    const/4 v0, 0x0

    .line 173
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lorg/apache/log4j/MDC;->tlm:Ljava/lang/Object;

    check-cast v0, Lorg/apache/log4j/helpers/ThreadLocalMap;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Hashtable;

    goto :goto_0
.end method
