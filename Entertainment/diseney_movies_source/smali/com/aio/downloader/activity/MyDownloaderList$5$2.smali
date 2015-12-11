.class Lcom/aio/downloader/activity/MyDownloaderList$5$2;
.super Ljava/lang/Object;
.source "MyDownloaderList.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyDownloaderList$5;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyDownloaderList$5;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    .line 325
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 13
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    const/4 v1, 0x0

    const/16 v12, 0x6e

    .line 331
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$16(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v2

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    iget-object v3, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->pos:I
    invoke-static {v3}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$5;)I

    move-result v3

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 332
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFile_id()Ljava/lang/String;

    move-result-object v0

    .line 331
    invoke-virtual {v2, v0}, Lcom/aio/downloader/db/TypeDbUtils;->deletefile(Ljava/lang/String;)V

    .line 336
    new-instance v6, Ljava/io/File;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$5;)I

    move-result v2

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 337
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v0

    .line 336
    invoke-direct {v6, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 338
    .local v6, "df":Ljava/io/File;
    const-string v2, "www"

    .line 339
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v0, "listdd.get(pos).getFilePath()="

    invoke-direct {v3, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 340
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    iget-object v4, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->pos:I
    invoke-static {v4}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$5;)I

    move-result v4

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 341
    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getFilePath()Ljava/lang/String;

    move-result-object v0

    .line 340
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 339
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 338
    invoke-static {v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 342
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 344
    invoke-virtual {v6}, Ljava/io/File;->delete()Z

    .line 347
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->pos:I
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$0(Lcom/aio/downloader/activity/MyDownloaderList$5;)I

    move-result v2

    invoke-interface {v0, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 349
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->adapter:Lcom/aio/downloader/adapter/AppDownloadedAdapter;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$18(Lcom/aio/downloader/activity/MyDownloaderList;)Lcom/aio/downloader/adapter/AppDownloadedAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/adapter/AppDownloadedAdapter;->notifyDataSetChanged()V

    .line 351
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    .line 352
    const-string v2, "notification"

    invoke-virtual {v0, v2}, Lcom/aio/downloader/activity/MyDownloaderList;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 351
    check-cast v0, Landroid/app/NotificationManager;

    sput-object v0, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    .line 353
    new-instance v8, Landroid/app/Notification;

    invoke-direct {v8}, Landroid/app/Notification;-><init>()V

    .line 354
    .local v8, "notification":Landroid/app/Notification;
    const/16 v0, 0x10

    iput v0, v8, Landroid/app/Notification;->flags:I

    .line 355
    const v0, 0x7f0200eb

    iput v0, v8, Landroid/app/Notification;->icon:I

    .line 356
    new-instance v7, Landroid/content/Intent;

    .line 357
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    .line 358
    const-class v2, Lcom/aio/downloader/activity/DownloadAppManager;

    .line 356
    invoke-direct {v7, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 359
    .local v7, "intent1":Landroid/content/Intent;
    const/high16 v0, 0x10000000

    invoke-virtual {v7, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 363
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    .line 366
    const/high16 v2, 0x8000000

    .line 362
    invoke-static {v0, v12, v7, v2}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v9

    .line 367
    .local v9, "pendingIntent":Landroid/app/PendingIntent;
    iput-object v9, v8, Landroid/app/Notification;->contentIntent:Landroid/app/PendingIntent;

    .line 368
    new-instance v10, Landroid/widget/RemoteViews;

    .line 369
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    .line 370
    invoke-virtual {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 371
    const v2, 0x7f030090

    .line 368
    invoke-direct {v10, v0, v2}, Landroid/widget/RemoteViews;-><init>(Ljava/lang/String;I)V

    .line 372
    .local v10, "rv":Landroid/widget/RemoteViews;
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v11

    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$0(Lcom/aio/downloader/activity/MyDownloaderList;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    .line 373
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 374
    const-string v4, "downloadtask2"

    move-object v2, v1

    move-object v5, v1

    .line 372
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v11, v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$1(Lcom/aio/downloader/activity/MyDownloaderList;Ljava/util/List;)V

    .line 375
    const v0, 0x7f07031c

    .line 376
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Downloading("

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v2

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 377
    const-string v2, ") & Completed"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 378
    iget-object v2, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v2

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->listdd:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/MyDownloaderList;->access$5(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 376
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 375
    invoke-virtual {v10, v0, v1}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 380
    const v0, 0x7f07031b

    .line 381
    const-string v1, "kk:mm"

    .line 382
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 381
    invoke-static {v1, v2, v3}, Landroid/text/format/DateFormat;->format(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;

    move-result-object v1

    .line 379
    invoke-virtual {v10, v0, v1}, Landroid/widget/RemoteViews;->setTextViewText(ILjava/lang/CharSequence;)V

    .line 383
    iput-object v10, v8, Landroid/app/Notification;->contentView:Landroid/widget/RemoteViews;

    .line 384
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 385
    sget-object v0, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    invoke-virtual {v0, v12, v8}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 390
    :cond_1
    :try_start_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MyDownloaderList$5$2;->this$1:Lcom/aio/downloader/activity/MyDownloaderList$5;

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList$5;->this$0:Lcom/aio/downloader/activity/MyDownloaderList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList$5;->access$1(Lcom/aio/downloader/activity/MyDownloaderList$5;)Lcom/aio/downloader/activity/MyDownloaderList;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/MyDownloaderList;->ds:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyDownloaderList;->access$2(Lcom/aio/downloader/activity/MyDownloaderList;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_2

    .line 391
    sget-object v0, Lcom/aio/downloader/activity/MyDownloaderList;->mNotificationManager:Landroid/app/NotificationManager;

    const/16 v1, 0x6e

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 398
    :cond_2
    :goto_0
    return-void

    .line 394
    :catch_0
    move-exception v0

    goto :goto_0
.end method
