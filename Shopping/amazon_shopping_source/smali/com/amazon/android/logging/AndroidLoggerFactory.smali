.class public Lcom/amazon/android/logging/AndroidLoggerFactory;
.super Ljava/lang/Object;
.source "AndroidLoggerFactory.java"

# interfaces
.implements Lcom/amazon/logging/LoggerFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    return-void
.end method

.method public static logTag(Ljava/lang/Class;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "AmazonAppstore."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static logTag(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/String;
    .locals 2
    .param p0, "group"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 36
    .local p1, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "AmazonAppstore."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static setBuildType(Lcom/amazon/mas/client/BuildType;)V
    .locals 1
    .param p0, "bt"    # Lcom/amazon/mas/client/BuildType;

    .prologue
    .line 43
    sget-object v0, Lcom/amazon/mas/client/BuildType;->RELEASE:Lcom/amazon/mas/client/BuildType;

    if-eq p0, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/amazon/android/logging/AndroidLogger;->setIsDebugBuild(Z)V

    .line 44
    return-void

    .line 43
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public createLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/logging/Logger;"
        }
    .end annotation

    .prologue
    .line 56
    .local p1, "tag":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger;

    invoke-static {p1}, Lcom/amazon/android/logging/AndroidLoggerFactory;->logTag(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/android/logging/AndroidLogger;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public createLogger(Ljava/lang/String;Ljava/lang/Class;)Lcom/amazon/logging/Logger;
    .locals 2
    .param p1, "category"    # Ljava/lang/String;
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
    .line 62
    .local p2, "tag":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/android/logging/AndroidLogger;

    invoke-static {p1, p2}, Lcom/amazon/android/logging/AndroidLoggerFactory;->logTag(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/android/logging/AndroidLogger;-><init>(Ljava/lang/String;)V

    return-object v0
.end method
