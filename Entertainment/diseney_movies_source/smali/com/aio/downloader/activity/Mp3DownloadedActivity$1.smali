.class Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;
.super Landroid/content/BroadcastReceiver;
.source "Mp3DownloadedActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/Mp3DownloadedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private pos:I

.field final synthetic this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    .line 47
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;)I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->pos:I

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;)Lcom/aio/downloader/activity/Mp3DownloadedActivity;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const v4, 0x7f0b003c

    .line 54
    const-string v0, "position"

    const/4 v1, 0x0

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->pos:I

    .line 56
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 57
    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    .line 59
    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 60
    iget-object v0, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    # getter for: Lcom/aio/downloader/activity/Mp3DownloadedActivity;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->access$0(Lcom/aio/downloader/activity/Mp3DownloadedActivity;)Ljava/util/List;

    move-result-object v0

    iget v3, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->pos:I

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "?"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 59
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 58
    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 61
    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    const v2, 0x7f0b003b

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 62
    new-instance v2, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1$1;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;)V

    .line 61
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 68
    iget-object v1, p0, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;->this$0:Lcom/aio/downloader/activity/Mp3DownloadedActivity;

    invoke-virtual {v1, v4}, Lcom/aio/downloader/activity/Mp3DownloadedActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 69
    new-instance v2, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1$2;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/Mp3DownloadedActivity$1$2;-><init>(Lcom/aio/downloader/activity/Mp3DownloadedActivity$1;)V

    .line 68
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 93
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 95
    return-void
.end method
