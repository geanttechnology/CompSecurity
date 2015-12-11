.class Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;
.super Ljava/lang/Exception;
.source "DownloadEngineClientManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "QueueException"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;


# direct methods
.method public constructor <init>(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V
    .locals 0
    .param p2, "aMessage"    # Ljava/lang/String;

    .prologue
    .line 782
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;->this$0:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    .line 783
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 784
    return-void
.end method
