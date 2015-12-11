.class Lcom/aio/downloader/activity/MyDownloaderList$7;
.super Ljava/util/TimerTask;
.source "MyDownloaderList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyDownloaderList;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$7;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 514
    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 519
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 520
    .local v0, "msg":Landroid/os/Message;
    const/16 v1, 0x64

    iput v1, v0, Landroid/os/Message;->what:I

    .line 521
    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$7;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    iget-object v1, v1, Lcom/aio/downloader/activity/MyDownloaderList;->handler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 523
    return-void
.end method
