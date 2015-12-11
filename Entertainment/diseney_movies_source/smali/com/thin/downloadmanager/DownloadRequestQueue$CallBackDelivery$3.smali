.class Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;
.super Ljava/lang/Object;
.source "DownloadRequestQueue.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;->postDownloadFailed(Lcom/thin/downloadmanager/DownloadRequest;ILjava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

.field final synthetic val$errorCode:I

.field final synthetic val$errorMsg:Ljava/lang/String;

.field final synthetic val$request:Lcom/thin/downloadmanager/DownloadRequest;


# direct methods
.method constructor <init>(Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;Lcom/thin/downloadmanager/DownloadRequest;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->this$1:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    iput-object p2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->val$request:Lcom/thin/downloadmanager/DownloadRequest;

    iput p3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->val$errorCode:I

    iput-object p4, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->val$errorMsg:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 65
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->val$request:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadListener()Lcom/thin/downloadmanager/DownloadStatusListener;

    move-result-object v0

    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->val$request:Lcom/thin/downloadmanager/DownloadRequest;

    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v1

    iget v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->val$errorCode:I

    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$3;->val$errorMsg:Ljava/lang/String;

    invoke-interface {v0, v1, v2, v3}, Lcom/thin/downloadmanager/DownloadStatusListener;->onDownloadFailed(IILjava/lang/String;)V

    .line 66
    return-void
.end method
