.class public abstract Lcom/amazon/logging/Logger;
.super Ljava/lang/Object;
.source "Logger.java"


# static fields
.field private static factory:Lcom/amazon/logging/LoggerFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    new-instance v0, Lcom/amazon/logging/NullLoggerFactory;

    invoke-direct {v0}, Lcom/amazon/logging/NullLoggerFactory;-><init>()V

    sput-object v0, Lcom/amazon/logging/Logger;->factory:Lcom/amazon/logging/LoggerFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/logging/Logger;"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "loggedClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v0, Lcom/amazon/logging/Logger;->factory:Lcom/amazon/logging/LoggerFactory;

    invoke-interface {v0, p0}, Lcom/amazon/logging/LoggerFactory;->createLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    return-object v0
.end method

.method public static getLogger(Ljava/lang/String;Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .locals 1
    .param p0, "category"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/logging/Logger;"
        }
    .end annotation

    .prologue
    .line 27
    .local p1, "loggedClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    sget-object v0, Lcom/amazon/logging/Logger;->factory:Lcom/amazon/logging/LoggerFactory;

    invoke-interface {v0, p0, p1}, Lcom/amazon/logging/LoggerFactory;->createLogger(Ljava/lang/String;Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    return-object v0
.end method

.method public static setLoggerFactory(Lcom/amazon/logging/LoggerFactory;)V
    .locals 0
    .param p0, "newFactory"    # Lcom/amazon/logging/LoggerFactory;

    .prologue
    .line 35
    sput-object p0, Lcom/amazon/logging/Logger;->factory:Lcom/amazon/logging/LoggerFactory;

    .line 36
    return-void
.end method


# virtual methods
.method public abstract d(Ljava/lang/String;)V
.end method

.method public abstract d(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public varargs d(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 105
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    array-length v0, p2

    if-nez v0, :cond_1

    .line 112
    :cond_0
    :goto_0
    return-void

    .line 109
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/logging/Logger;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    invoke-static {p1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public abstract e(Ljava/lang/String;)V
.end method

.method public abstract e(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract i(Ljava/lang/String;)V
.end method

.method public abstract i(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public abstract isDebugEnabled()Z
.end method

.method public abstract isVerboseEnabled()Z
.end method

.method public abstract v(Ljava/lang/String;)V
.end method

.method public abstract v(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method

.method public varargs v(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 67
    if-eqz p1, :cond_0

    if-eqz p2, :cond_0

    array-length v0, p2

    if-nez v0, :cond_1

    .line 74
    :cond_0
    :goto_0
    return-void

    .line 71
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/logging/Logger;->isVerboseEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 72
    invoke-static {p1, p2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public abstract w(Ljava/lang/String;)V
.end method

.method public abstract w(Ljava/lang/String;Ljava/lang/Throwable;)V
.end method
