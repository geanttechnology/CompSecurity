.class Lcom/comcast/cim/downloads/DownloadServiceManager$15;
.super Landroid/content/BroadcastReceiver;
.source "DownloadServiceManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;->startWatchingExternalStorage()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 664
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$15;, "Lcom/comcast/cim/downloads/DownloadServiceManager$15;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 668
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$15;, "Lcom/comcast/cim/downloads/DownloadServiceManager$15;"
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->isExternalStorageConnected()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 669
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z
    invoke-static {v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1300(Lcom/comcast/cim/downloads/DownloadServiceManager;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 670
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    const/4 v1, 0x1

    # setter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z
    invoke-static {v0, v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1302(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z

    .line 671
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->backgroundExecutor:Ljava/util/concurrent/Executor;

    new-instance v1, Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;

    invoke-direct {v1, p0}, Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$15;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 692
    :cond_0
    :goto_0
    return-void

    .line 690
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    const/4 v1, 0x0

    # setter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z
    invoke-static {v0, v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1302(Lcom/comcast/cim/downloads/DownloadServiceManager;Z)Z

    goto :goto_0
.end method
