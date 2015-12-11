.class public abstract Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;
.super Landroid/os/AsyncTask;
.source "RetryableAsyncTask.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Params:",
        "Ljava/lang/Object;",
        "Progress:",
        "Ljava/lang/Object;",
        "Result:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/os/AsyncTask",
        "<TParams;TProgress;TResult;>;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private activityWeakReference:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation
.end field

.field private errorDialogCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field protected final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private exception:Ljava/lang/Exception;

.field private internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private originalParams:[Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "[TParams;"
        }
    .end annotation
.end field

.field private requiresNetworkConnectivity:Z

.field private uiUtil:Lcom/comcast/cim/utils/UIUtil;


# direct methods
.method protected constructor <init>(Landroid/app/Activity;ZLcom/comcast/cim/cmasl/android/util/system/InternetConnection;Landroid/content/DialogInterface$OnCancelListener;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "requiresNetworkConnectivity"    # Z
    .param p3, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p4, "errorDialogCancelListener"    # Landroid/content/DialogInterface$OnCancelListener;
    .param p5, "errorDialogFactory"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .prologue
    .line 50
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask<TParams;TProgress;TResult;>;"
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 29
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->LOG:Lorg/slf4j/Logger;

    .line 33
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->requiresNetworkConnectivity:Z

    .line 51
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    invoke-static {p4}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->setActivity(Landroid/app/Activity;)V

    .line 54
    iput-boolean p2, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->requiresNetworkConnectivity:Z

    .line 55
    iput-object p4, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->errorDialogCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 56
    iput-object p3, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 57
    if-eqz p3, :cond_0

    .line 58
    new-instance v0, Lcom/comcast/cim/utils/UIUtil;

    invoke-direct {v0, p3}, Lcom/comcast/cim/utils/UIUtil;-><init>(Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    iput-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    .line 60
    :cond_0
    iput-object p5, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 61
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;)Ljava/lang/Exception;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->exception:Ljava/lang/Exception;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;)[Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->originalParams:[Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;)Landroid/content/DialogInterface$OnCancelListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->errorDialogCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    return-object v0
.end method

.method private setActivity(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 150
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask<TParams;TProgress;TResult;>;"
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->activityWeakReference:Ljava/lang/ref/WeakReference;

    .line 151
    return-void
.end method


# virtual methods
.method protected final varargs doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TParams;)TResult;"
        }
    .end annotation

    .prologue
    .line 67
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask<TParams;TProgress;TResult;>;"
    .local p1, "params":[Ljava/lang/Object;, "[TParams;"
    iput-object p1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->originalParams:[Ljava/lang/Object;

    .line 69
    :try_start_0
    iget-boolean v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->requiresNetworkConnectivity:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v1

    if-nez v1, :cond_0

    .line 70
    new-instance v1, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v2, "network not available; present retry dialog"

    invoke-direct {v1, v2}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 75
    :catch_0
    move-exception v0

    .line 76
    .local v0, "e":Ljava/lang/Exception;
    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->LOG:Lorg/slf4j/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Exception during background operation of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 77
    iput-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->exception:Ljava/lang/Exception;

    .line 78
    const/4 v1, 0x0

    .end local v0    # "e":Ljava/lang/Exception;
    :goto_0
    return-object v1

    .line 73
    :cond_0
    :try_start_1
    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->doInBackgroundWrapped([Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v1

    goto :goto_0
.end method

.method protected abstract doInBackgroundWrapped([Ljava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([TParams;)TResult;"
        }
    .end annotation
.end method

.method protected getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 154
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask<TParams;TProgress;TResult;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->activityWeakReference:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    return-object v0
.end method

.method protected getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .locals 1

    .prologue
    .line 158
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask<TParams;TProgress;TResult;>;"
    iget-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    return-object v0
.end method

.method protected abstract getNewInstance(Landroid/app/Activity;)Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;
.end method

.method protected final onPostExecute(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation

    .prologue
    .line 86
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask<TParams;TProgress;TResult;>;"
    .local p1, "result":Ljava/lang/Object;, "TResult;"
    invoke-virtual {p0}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 88
    .local v0, "activity":Landroid/app/Activity;
    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->isCancelled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 111
    :cond_0
    :goto_0
    return-void

    .line 92
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->exception:Ljava/lang/Exception;

    if-eqz v1, :cond_2

    .line 93
    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->exception:Ljava/lang/Exception;

    invoke-virtual {p0, v1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->retryOnException(Ljava/lang/Exception;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    if-eqz v1, :cond_0

    .line 94
    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    new-instance v2, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;

    invoke-direct {v2, p0, v0}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;-><init>(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;Landroid/app/Activity;)V

    invoke-virtual {v1, v2}, Lcom/comcast/cim/utils/UIUtil;->tryToShowDialog(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 109
    :cond_2
    invoke-virtual {p0, p1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->onPostExecuteWrapped(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method protected abstract onPostExecuteWrapped(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TResult;)V"
        }
    .end annotation
.end method

.method protected abstract retryOnException(Ljava/lang/Exception;)Z
.end method
