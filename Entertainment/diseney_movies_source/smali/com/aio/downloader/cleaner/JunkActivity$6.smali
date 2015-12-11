.class Lcom/aio/downloader/cleaner/JunkActivity$6;
.super Ljava/lang/Object;
.source "JunkActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/JunkActivity;->AsncyApk()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field ext:[Ljava/lang/String;

.field fi:Ljava/io/File;

.field final synthetic this$0:Lcom/aio/downloader/cleaner/JunkActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/JunkActivity;)V
    .locals 3

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$6;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 361
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 362
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, ".apk"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$6;->ext:[Ljava/lang/String;

    .line 363
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$6;->fi:Ljava/io/File;

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 366
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$6;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    iget-object v1, p0, Lcom/aio/downloader/cleaner/JunkActivity$6;->fi:Ljava/io/File;

    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$6;->ext:[Ljava/lang/String;

    # invokes: Lcom/aio/downloader/cleaner/JunkActivity;->search(Ljava/io/File;[Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$58(Lcom/aio/downloader/cleaner/JunkActivity;Ljava/io/File;[Ljava/lang/String;)V

    .line 367
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$6;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$55(Lcom/aio/downloader/cleaner/JunkActivity;)Landroid/os/Handler;

    move-result-object v0

    const/16 v1, 0x3ba

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 368
    return-void
.end method
