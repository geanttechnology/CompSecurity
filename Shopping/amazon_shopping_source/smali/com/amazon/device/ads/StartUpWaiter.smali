.class abstract Lcom/amazon/device/ads/StartUpWaiter;
.super Ljava/lang/Object;
.source "StartUpWaiter.java"

# interfaces
.implements Lcom/amazon/device/ads/Configuration$ConfigurationListener;
.implements Lcom/amazon/device/ads/Settings$SettingsListener;


# static fields
.field static final CALLBACK_ON_MAIN_THREAD:I = 0x0

.field static final DEFAULT:I = 0x1

.field private static final executors:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private callbackType:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 25
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/StartUpWaiter;->executors:Landroid/util/SparseArray;

    .line 29
    const/4 v0, 0x0

    new-instance v1, Lcom/amazon/device/ads/ThreadUtils$MainThreadRunnableExecutor;

    invoke-direct {v1}, Lcom/amazon/device/ads/ThreadUtils$MainThreadRunnableExecutor;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/device/ads/StartUpWaiter;->putRunnableExecutor(ILcom/amazon/device/ads/ThreadUtils$RunnableExecutor;)V

    .line 30
    const/4 v0, 0x1

    new-instance v1, Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;

    invoke-direct {v1}, Lcom/amazon/device/ads/ThreadUtils$ThreadPoolRunnableExecutor;-><init>()V

    invoke-static {v0, v1}, Lcom/amazon/device/ads/StartUpWaiter;->putRunnableExecutor(ILcom/amazon/device/ads/ThreadUtils$RunnableExecutor;)V

    .line 31
    return-void
.end method

.method constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    const/4 v0, 0x1

    iput v0, p0, Lcom/amazon/device/ads/StartUpWaiter;->callbackType:I

    return-void
.end method

.method private static getExecutor(I)Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;
    .locals 3
    .param p0, "callbackType"    # I

    .prologue
    .line 96
    sget-object v0, Lcom/amazon/device/ads/StartUpWaiter;->executors:Landroid/util/SparseArray;

    sget-object v1, Lcom/amazon/device/ads/StartUpWaiter;->executors:Landroid/util/SparseArray;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Landroid/util/SparseArray;->get(ILjava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;

    return-object v0
.end method

.method private onFinished(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "proc"    # Ljava/lang/Runnable;

    .prologue
    .line 84
    iget v0, p0, Lcom/amazon/device/ads/StartUpWaiter;->callbackType:I

    invoke-static {v0}, Lcom/amazon/device/ads/StartUpWaiter;->getExecutor(I)Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;->execute(Ljava/lang/Runnable;)V

    .line 85
    return-void
.end method

.method static putRunnableExecutor(ILcom/amazon/device/ads/ThreadUtils$RunnableExecutor;)V
    .locals 1
    .param p0, "callbackType"    # I
    .param p1, "executor"    # Lcom/amazon/device/ads/ThreadUtils$RunnableExecutor;

    .prologue
    .line 115
    if-nez p1, :cond_0

    .line 117
    sget-object v0, Lcom/amazon/device/ads/StartUpWaiter;->executors:Landroid/util/SparseArray;

    invoke-virtual {v0, p0}, Landroid/util/SparseArray;->remove(I)V

    .line 123
    :goto_0
    return-void

    .line 121
    :cond_0
    sget-object v0, Lcom/amazon/device/ads/StartUpWaiter;->executors:Landroid/util/SparseArray;

    invoke-virtual {v0, p0, p1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_0
.end method


# virtual methods
.method public onConfigurationFailure()V
    .locals 1

    .prologue
    .line 71
    new-instance v0, Lcom/amazon/device/ads/StartUpWaiter$2;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/StartUpWaiter$2;-><init>(Lcom/amazon/device/ads/StartUpWaiter;)V

    .line 79
    .local v0, "proc":Ljava/lang/Runnable;
    invoke-direct {p0, v0}, Lcom/amazon/device/ads/StartUpWaiter;->onFinished(Ljava/lang/Runnable;)V

    .line 80
    return-void
.end method

.method public onConfigurationReady()V
    .locals 1

    .prologue
    .line 57
    new-instance v0, Lcom/amazon/device/ads/StartUpWaiter$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/StartUpWaiter$1;-><init>(Lcom/amazon/device/ads/StartUpWaiter;)V

    .line 65
    .local v0, "proc":Ljava/lang/Runnable;
    invoke-direct {p0, v0}, Lcom/amazon/device/ads/StartUpWaiter;->onFinished(Ljava/lang/Runnable;)V

    .line 66
    return-void
.end method

.method public settingsLoaded()V
    .locals 1

    .prologue
    .line 51
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/device/ads/Configuration;->queueConfigurationListener(Lcom/amazon/device/ads/Configuration$ConfigurationListener;)V

    .line 52
    return-void
.end method

.method public start()V
    .locals 1

    .prologue
    .line 40
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/device/ads/Settings;->listenForSettings(Lcom/amazon/device/ads/Settings$SettingsListener;)V

    .line 41
    return-void
.end method

.method public startAndCallbackOnMainThread()V
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/device/ads/StartUpWaiter;->callbackType:I

    .line 45
    invoke-virtual {p0}, Lcom/amazon/device/ads/StartUpWaiter;->start()V

    .line 46
    return-void
.end method

.method protected abstract startUpFailed()V
.end method

.method protected abstract startUpReady()V
.end method
