.class Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1;
.super Ljava/lang/Object;
.source "DownloadRequestQueue.java"

# interfaces
.implements Ljava/util/concurrent/Executor;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;-><init>(Lcom/thin/downloadmanager/DownloadRequestQueue;Landroid/os/Handler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

.field final synthetic val$handler:Landroid/os/Handler;

.field final synthetic val$this$0:Lcom/thin/downloadmanager/DownloadRequestQueue;


# direct methods
.method constructor <init>(Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;Lcom/thin/downloadmanager/DownloadRequestQueue;Landroid/os/Handler;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1;->this$1:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    iput-object p2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1;->val$this$0:Lcom/thin/downloadmanager/DownloadRequestQueue;

    iput-object p3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1;->val$handler:Landroid/os/Handler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "command"    # Ljava/lang/Runnable;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery$1;->val$handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 50
    return-void
.end method
