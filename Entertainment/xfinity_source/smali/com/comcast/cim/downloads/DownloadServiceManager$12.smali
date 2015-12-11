.class Lcom/comcast/cim/downloads/DownloadServiceManager$12;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;->onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

.field final synthetic val$file:Lcom/comcast/cim/downloads/DownloadFile;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 545
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$12;, "Lcom/comcast/cim/downloads/DownloadServiceManager$12;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$12;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$12;->val$file:Lcom/comcast/cim/downloads/DownloadFile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 547
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$12;, "Lcom/comcast/cim/downloads/DownloadServiceManager$12;"
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$12;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->listeners:Ljava/util/Set;
    invoke-static {v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1200(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Set;

    move-result-object v2

    monitor-enter v2

    .line 548
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$12;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->listeners:Ljava/util/Set;
    invoke-static {v1}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$1200(Lcom/comcast/cim/downloads/DownloadServiceManager;)Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadServiceListener;

    .line 549
    .local v0, "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<TD;>;"
    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$12;->val$file:Lcom/comcast/cim/downloads/DownloadFile;

    invoke-interface {v0, v3}, Lcom/comcast/cim/downloads/DownloadServiceListener;->onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V

    goto :goto_0

    .line 551
    .end local v0    # "listener":Lcom/comcast/cim/downloads/DownloadServiceListener;, "Lcom/comcast/cim/downloads/DownloadServiceListener<TD;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_0
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 552
    return-void
.end method
