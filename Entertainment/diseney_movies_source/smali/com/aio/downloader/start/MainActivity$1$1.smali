.class Lcom/aio/downloader/start/MainActivity$1$1;
.super Ljava/lang/Thread;
.source "MainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/start/MainActivity$1;->onPostExecute(Ljava/lang/Void;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/start/MainActivity$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/start/MainActivity$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/start/MainActivity$1$1;->this$1:Lcom/aio/downloader/start/MainActivity$1;

    .line 131
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 136
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 137
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity$1$1;->this$1:Lcom/aio/downloader/start/MainActivity$1;

    # getter for: Lcom/aio/downloader/start/MainActivity$1;->this$0:Lcom/aio/downloader/start/MainActivity;
    invoke-static {v0}, Lcom/aio/downloader/start/MainActivity$1;->access$2(Lcom/aio/downloader/start/MainActivity$1;)Lcom/aio/downloader/start/MainActivity;

    move-result-object v0

    # invokes: Lcom/aio/downloader/start/MainActivity;->getAssetFile()Ljava/io/File;
    invoke-static {v0}, Lcom/aio/downloader/start/MainActivity;->access$2(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;

    .line 138
    iget-object v0, p0, Lcom/aio/downloader/start/MainActivity$1$1;->this$1:Lcom/aio/downloader/start/MainActivity$1;

    # getter for: Lcom/aio/downloader/start/MainActivity$1;->this$0:Lcom/aio/downloader/start/MainActivity;
    invoke-static {v0}, Lcom/aio/downloader/start/MainActivity$1;->access$2(Lcom/aio/downloader/start/MainActivity$1;)Lcom/aio/downloader/start/MainActivity;

    move-result-object v0

    # invokes: Lcom/aio/downloader/start/MainActivity;->getAssetFile_swf()Ljava/io/File;
    invoke-static {v0}, Lcom/aio/downloader/start/MainActivity;->access$3(Lcom/aio/downloader/start/MainActivity;)Ljava/io/File;

    .line 140
    return-void
.end method
