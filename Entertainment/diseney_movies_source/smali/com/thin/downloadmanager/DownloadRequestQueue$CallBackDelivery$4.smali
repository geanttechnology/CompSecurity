.class Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;
.super Ljava/lang/Object;
.source "DownloadRequestQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->postProgressUpdate(Lcom/thin/downloadmanager/DownloadRequest;JJI)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

.field final synthetic val$downloadedBytes:J

.field final synthetic val$progress:I

.field final synthetic val$request:Lcom/thin/downloadmanager/DownloadRequest;

.field final synthetic val$totalBytes:J


# direct methods
.method constructor <init>(Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;Lcom/thin/downloadmanager/DownloadRequest;JJI)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->this$1:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    iput-object p2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$request:Lcom/thin/downloadmanager/DownloadRequest;

    iput-wide p3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$totalBytes:J

    iput-wide p5, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$downloadedBytes:J

    iput p7, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$progress:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 73
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$request:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadListener()Lcom/thin/downloadmanager/DownloadStatusListener;

    move-result-object v0

    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$request:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v1

    iget-wide v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$totalBytes:J

    iget-wide v4, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$downloadedBytes:J

    iget v6, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$4;->val$progress:I

    invoke-interface/range {v0 .. v6}, Lcom/thin/downloadmanager/DownloadStatusListener;->onProgress(IJJI)V

    .line 74
    return-void
.end method
