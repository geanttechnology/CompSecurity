.class Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$2;
.super Ljava/util/TimerTask;
.source "DownloadEngineClientManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doGetRetryErrorsTask(Ljava/lang/String;)Ljava/util/TimerTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final client:Ljava/lang/String;

.field final synthetic this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$2;->this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    .line 723
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    .line 724
    iput-object p2, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$2;->client:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 727
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$2;->this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$2;->client:Ljava/lang/String;

    # invokes: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->performRetryErrorQueue(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$6(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V

    .line 728
    return-void
.end method
