.class Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager$15;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$15;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager$15;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/downloads/DownloadServiceManager$15;

    .prologue
    .line 671
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$15;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 676
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;"
    const-wide/16 v0, 0x1388

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V

    .line 679
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$15;

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->externalStorageAvailable:Z
    invoke-static {v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1300(Lcom/comcast/cim/downloads/DownloadServiceManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 680
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$15;

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # invokes: Lcom/comcast/cim/downloads/DownloadServiceManager;->resetFilesWithSDCardError()V
    invoke-static {v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1400(Lcom/comcast/cim/downloads/DownloadServiceManager;)V

    .line 681
    iget-object v0, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$15$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$15;

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$15;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # invokes: Lcom/comcast/cim/downloads/DownloadServiceManager;->forceRetryDownloads()V
    invoke-static {v0}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1500(Lcom/comcast/cim/downloads/DownloadServiceManager;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 686
    :cond_0
    :goto_0
    return-void

    .line 683
    :catch_0
    move-exception v0

    goto :goto_0
.end method
