.class Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$7;
.super Ljava/lang/Thread;
.source "ShowCleanActivity_Rub.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$7;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    .line 251
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 256
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 258
    const-wide/16 v2, 0x7d0

    :try_start_0
    invoke-static {v2, v3}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$7;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 263
    :goto_0
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 264
    .local v1, "msg":Landroid/os/Message;
    iget-object v2, p0, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub$7;->this$0:Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;

    # getter for: Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->handlerdonghua:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;->access$11(Lcom/aio/downloader/cleaner/ShowCleanActivity_Rub;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 265
    return-void

    .line 259
    .end local v1    # "msg":Landroid/os/Message;
    :catch_0
    move-exception v0

    .line 261
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method
