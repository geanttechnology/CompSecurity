.class Lcom/aio/downloader/activity/MyDownloaderList$5;
.super Landroid/content/BroadcastReceiver;
.source "MyDownloaderList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyDownloaderList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private pos:I

.field final synthetic this$0:Lcom/aio/downloader/activity/MyDownloaderList;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    .line 303
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyDownloaderList$5;)I
    .locals 1

    .prologue
    .line 305
    iget v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->pos:I

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const v4, 0x7f0b003c

    .line 310
    const-string v0, "position"

    const/4 v1, 0x0

    invoke-virtual {p2, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->pos:I

    .line 312
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 313
    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    const v2, 0x7f0b0034

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    .line 315
    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v0, v4}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 316
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    iget v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->pos:I

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

    .line 315
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 314
    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 317
    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    const v2, 0x7f0b003b

    invoke-virtual {v1, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 318
    new-instance v2, Lcom/aio/downloader/activity/MyDownloaderList$5$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MyDownloaderList$5$1;-><init>(Lcom/aio/downloader/activity/MyDownloaderList$5;)V

    .line 317
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 324
    iget-object v1, p0, Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;

    invoke-virtual {v1, v4}, Lcom/aio/downloader/activity/MyDownloaderList;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 325
    new-instance v2, Lcom/aio/downloader/activity/MyDownloaderList$5$2;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MyDownloaderList$5$2;-><init>(Lcom/aio/downloader/activity/MyDownloaderList$5;)V

    .line 324
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 400
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 402
    return-void
.end method
