.class Lcom/aio/downloader/service/ServiceGallery$4;
.super Ljava/lang/Thread;
.source "ServiceGallery.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceGallery;->onCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ServiceGallery;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceGallery;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceGallery$4;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    .line 362
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 367
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 369
    const-wide/32 v2, 0x1d4c0

    :try_start_0
    invoke-static {v2, v3}, Lcom/aio/downloader/service/ServiceGallery$4;->sleep(J)V

    .line 370
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 371
    .local v1, "message":Landroid/os/Message;
    const/16 v2, 0x1e

    iput v2, v1, Landroid/os/Message;->what:I

    .line 372
    iget-object v2, p0, Lcom/aio/downloader/service/ServiceGallery$4;->this$0:Lcom/aio/downloader/service/ServiceGallery;

    # getter for: Lcom/aio/downloader/service/ServiceGallery;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/aio/downloader/service/ServiceGallery;->access$7(Lcom/aio/downloader/service/ServiceGallery;)Landroid/os/Handler;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 378
    .end local v1    # "message":Landroid/os/Message;
    :goto_0
    return-void

    .line 373
    :catch_0
    move-exception v0

    .line 375
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method
