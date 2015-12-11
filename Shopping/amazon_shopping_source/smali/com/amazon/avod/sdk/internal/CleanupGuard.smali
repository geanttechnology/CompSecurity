.class public Lcom/amazon/avod/sdk/internal/CleanupGuard;
.super Ljava/lang/Object;
.source "CleanupGuard.java"


# instance fields
.field private volatile mResourceAllocationSource:Ljava/lang/Throwable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public close()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/avod/sdk/internal/CleanupGuard;->mResourceAllocationSource:Ljava/lang/Throwable;

    .line 33
    return-void
.end method

.method public isOpen()Z
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/CleanupGuard;->mResourceAllocationSource:Ljava/lang/Throwable;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public open(Ljava/lang/String;)V
    .locals 3
    .param p1, "resource"    # Ljava/lang/String;

    .prologue
    .line 19
    if-nez p1, :cond_0

    .line 20
    new-instance v1, Ljava/lang/NullPointerException;

    const-string/jumbo v2, "Need a resource"

    invoke-direct {v1, v2}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 23
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Cleanup method \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "\' not called"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 24
    .local v0, "message":Ljava/lang/String;
    new-instance v1, Ljava/lang/Throwable;

    invoke-direct {v1, v0}, Ljava/lang/Throwable;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/amazon/avod/sdk/internal/CleanupGuard;->mResourceAllocationSource:Ljava/lang/Throwable;

    .line 25
    return-void
.end method

.method public warnIfOpen()V
    .locals 3

    .prologue
    .line 36
    invoke-virtual {p0}, Lcom/amazon/avod/sdk/internal/CleanupGuard;->isOpen()Z

    move-result v0

    if-nez v0, :cond_0

    .line 42
    :goto_0
    return-void

    .line 40
    :cond_0
    const-string/jumbo v0, "AmazonInstantVideoSDK"

    const-string/jumbo v1, "Resources were acquired by AmazonInstantVideo but never released, see stacktrace for details"

    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/CleanupGuard;->mResourceAllocationSource:Ljava/lang/Throwable;

    invoke-static {v0, v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
