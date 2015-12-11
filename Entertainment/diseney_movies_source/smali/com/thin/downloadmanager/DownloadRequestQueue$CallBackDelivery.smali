.class Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;
.super Ljava/lang/Object;
.source "DownloadRequestQueue.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/thin/downloadmanager/DownloadRequestQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CallBackDelivery"
.end annotation


# instance fields
.field private final mCallBackExecutor:Ljava/util/concurrent/Executor;

.field final synthetic this$0:Lcom/thin/downloadmanager/DownloadRequestQueue;


# direct methods
.method public constructor <init>(Lcom/thin/downloadmanager/DownloadRequestQueue;Landroid/os/Handler;)V
    .locals 1
    .param p2, "handler"    # Landroid/os/Handler;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->this$0:Lcom/thin/downloadmanager/DownloadRequestQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1;-><init>(Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;Lcom/thin/downloadmanager/DownloadRequestQueue;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->mCallBackExecutor:Ljava/util/concurrent/Executor;

    .line 52
    return-void
.end method


# virtual methods
.method public postDownloadComplete(Lcom/thin/downloadmanager/DownloadRequest;)V
    .locals 2
    .param p1, "request"    # Lcom/thin/downloadmanager/DownloadRequest;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->mCallBackExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$2;

    invoke-direct {v1, p0, p1}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$2;-><init>(Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;Lcom/thin/downloadmanager/DownloadRequest;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 60
    return-void
.end method

.method public postDownloadFailed(Lcom/thin/downloadmanager/DownloadRequest;ILjava/lang/String;)V
    .locals 2
    .param p1, "request"    # Lcom/thin/downloadmanager/DownloadRequest;
    .param p2, "errorCode"    # I
    .param p3, "errorMsg"    # Ljava/lang/String;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->mCallBackExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;-><init>(Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;Lcom/thin/downloadmanager/DownloadRequest;ILjava/lang/String;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 68
    return-void
.end method

.method public postProgressUpdate(Lcom/thin/downloadmanager/DownloadRequest;JJI)V
    .locals 9
    .param p1, "request"    # Lcom/thin/downloadmanager/DownloadRequest;
    .param p2, "totalBytes"    # J
    .param p4, "downloadedBytes"    # J
    .param p6, "progress"    # I

    .prologue
    .line 71
    iget-object v8, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->mCallBackExecutor:Ljava/util/concurrent/Executor;

    new-instance v0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;

    move-object v1, p0

    move-object v2, p1

    move-wide v3, p2

    move-wide v5, p4

    move v7, p6

    invoke-direct/range {v0 .. v7}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;-><init>(Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;Lcom/thin/downloadmanager/DownloadRequest;JJI)V

    invoke-interface {v8, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 76
    return-void
.end method
