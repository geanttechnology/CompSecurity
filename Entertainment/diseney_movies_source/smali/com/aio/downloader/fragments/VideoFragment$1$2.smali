.class Lcom/aio/downloader/fragments/VideoFragment$1$2;
.super Ljava/lang/Object;
.source "VideoFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/VideoFragment$1;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/fragments/VideoFragment$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/VideoFragment$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 63
    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->this$0:Lcom/aio/downloader/fragments/VideoFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$1(Lcom/aio/downloader/fragments/VideoFragment$1;)Lcom/aio/downloader/fragments/VideoFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment;->access$1(Lcom/aio/downloader/fragments/VideoFragment;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v2

    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->this$0:Lcom/aio/downloader/fragments/VideoFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$1(Lcom/aio/downloader/fragments/VideoFragment$1;)Lcom/aio/downloader/fragments/VideoFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment;->access$0(Lcom/aio/downloader/fragments/VideoFragment;)Ljava/util/List;

    move-result-object v1

    iget-object v3, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->pos:I
    invoke-static {v3}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$0(Lcom/aio/downloader/fragments/VideoFragment$1;)I

    move-result v3

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 64
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v1

    .line 63
    invoke-virtual {v2, v1}, Lcom/aio/downloader/db/TypeDbUtils;->deletefile(Ljava/lang/String;)V

    .line 68
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->this$0:Lcom/aio/downloader/fragments/VideoFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$1(Lcom/aio/downloader/fragments/VideoFragment$1;)Lcom/aio/downloader/fragments/VideoFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment;->access$0(Lcom/aio/downloader/fragments/VideoFragment;)Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$0(Lcom/aio/downloader/fragments/VideoFragment$1;)I

    move-result v2

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 69
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v1

    .line 68
    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 70
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 72
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 75
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->this$0:Lcom/aio/downloader/fragments/VideoFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$1(Lcom/aio/downloader/fragments/VideoFragment$1;)Lcom/aio/downloader/fragments/VideoFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->listdd:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment;->access$0(Lcom/aio/downloader/fragments/VideoFragment;)Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$0(Lcom/aio/downloader/fragments/VideoFragment$1;)I

    move-result v2

    invoke-interface {v1, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 77
    iget-object v1, p0, Lcom/aio/downloader/fragments/VideoFragment$1$2;->this$1:Lcom/aio/downloader/fragments/VideoFragment$1;

    # getter for: Lcom/aio/downloader/fragments/VideoFragment$1;->this$0:Lcom/aio/downloader/fragments/VideoFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment$1;->access$1(Lcom/aio/downloader/fragments/VideoFragment$1;)Lcom/aio/downloader/fragments/VideoFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/VideoFragment;->adapter:Lcom/aio/downloader/adapter/VideoDownloadedAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/VideoFragment;->access$2(Lcom/aio/downloader/fragments/VideoFragment;)Lcom/aio/downloader/adapter/VideoDownloadedAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/adapter/VideoDownloadedAdapter;->notifyDataSetChanged()V

    .line 79
    return-void
.end method
