.class Lcom/aio/downloader/fragments/BackedUpFragment$2$1;
.super Ljava/lang/Object;
.source "BackedUpFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/BackedUpFragment$2;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field ext:[Ljava/lang/String;

.field file:Ljava/io/File;

.field final synthetic this$1:Lcom/aio/downloader/fragments/BackedUpFragment$2;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpFragment$2;)V
    .locals 3

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$2;

    .line 326
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 327
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, ".apk"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;->ext:[Ljava/lang/String;

    .line 328
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 329
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 330
    const-string v2, "/AIO_BACKUPAPP"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;->file:Ljava/io/File;

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 333
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$2;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$2;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment$2;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$2;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;->file:Ljava/io/File;

    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;->ext:[Ljava/lang/String;

    # invokes: Lcom/aio/downloader/fragments/BackedUpFragment;->search(Ljava/io/File;[Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$6(Lcom/aio/downloader/fragments/BackedUpFragment;Ljava/io/File;[Ljava/lang/String;)V

    .line 334
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$2;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$2;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment$2;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$2;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->hander:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$7(Lcom/aio/downloader/fragments/BackedUpFragment;)Landroid/os/Handler;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 335
    return-void
.end method
