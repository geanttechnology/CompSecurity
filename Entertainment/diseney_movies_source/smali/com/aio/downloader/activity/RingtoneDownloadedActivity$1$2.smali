.class Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;
.super Ljava/lang/Object;
.source "RingtoneDownloadedActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    .line 72
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 78
    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$1(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$1(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v2

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$1(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/util/List;

    move-result-object v1

    iget-object v3, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->pos:I
    invoke-static {v3}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)I

    move-result v3

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 79
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v1

    .line 78
    invoke-virtual {v2, v1}, Lcom/aio/downloader/db/TypeDbUtils;->deletefile(Ljava/lang/String;)V

    .line 83
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$1(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)I

    move-result v2

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 84
    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v1

    .line 83
    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 85
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 87
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 90
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$1(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->listdd:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$0(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)I

    move-result v2

    invoke-interface {v1, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 92
    iget-object v1, p0, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1$2;->this$1:Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/RingtoneDownloadedActivity;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;->access$1(Lcom/aio/downloader/activity/RingtoneDownloadedActivity$1;)Lcom/aio/downloader/activity/RingtoneDownloadedActivity;

    move-result-object v1

    # getter for: Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->adapter:Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;
    invoke-static {v1}, Lcom/aio/downloader/activity/RingtoneDownloadedActivity;->access$2(Lcom/aio/downloader/activity/RingtoneDownloadedActivity;)Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/adapter/RingtoneDownloadedAdapter;->notifyDataSetChanged()V

    .line 94
    return-void
.end method
