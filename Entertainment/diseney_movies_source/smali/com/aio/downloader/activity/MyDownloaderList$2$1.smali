.class Lcom/aio/downloader/activity/MyDownloaderList$2$1;
.super Ljava/lang/Object;
.source "MyDownloaderList.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyDownloaderList$2;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

.field private final synthetic val$mp3position:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList$2;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->val$mp3position:Ljava/lang/String;

    .line 154
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyDownloaderList$2$1;)Lcom/aio/downloader/activity/MyDownloaderList$2;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 159
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 160
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$2;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$2;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->player:Lcom/aio/downloader/utils/Player;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$8(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/utils/Player;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->val$mp3position:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/Player;->playUrl(Ljava/lang/String;)V

    .line 161
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$2;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$2;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$10(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/Timer;)V

    .line 162
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$2;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$2;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/activity/MyDownloaderList$2$1$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MyDownloaderList$2$1$1;-><init>(Lcom/aio/downloader/activity/MyDownloaderList$2$1;)V

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$11(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/TimerTask;)V

    .line 173
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$2;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$2;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->timer:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$12(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/Timer;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$2$1;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$2;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$2;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList$2;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$2;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->task:Ljava/util/TimerTask;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyDownloaderList;->access$13(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/TimerTask;

    move-result-object v1

    const-wide/16 v2, 0x0

    const-wide/16 v4, 0x3e8

    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 175
    return-void
.end method
