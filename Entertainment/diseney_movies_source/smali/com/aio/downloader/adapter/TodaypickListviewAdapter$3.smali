.class Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;
.super Landroid/os/AsyncTask;
.source "TodaypickListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field content:Ljava/lang/String;

.field d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field options:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

.field url:Ljava/lang/String;

.field private final synthetic val$appserial:I

.field private final synthetic val$icon:Ljava/lang/String;

.field private final synthetic val$id:Ljava/lang/String;

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V
    .locals 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$id:Ljava/lang/String;

    iput-object p6, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$title:Ljava/lang/String;

    iput-object p7, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$icon:Ljava/lang/String;

    iput p8, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$appserial:I

    .line 440
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 441
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 442
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 443
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 444
    const-string v1, "&stamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 445
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 446
    const-string v1, "&time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 447
    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 448
    const-string v1, "&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->url:Ljava/lang/String;

    .line 449
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    .line 450
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 13
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 473
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->default_options:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$8(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    .line 474
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 475
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 476
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 477
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    .line 479
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    const-string v1, "Location"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 480
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->url:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "&debug=1"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->url:Ljava/lang/String;

    .line 481
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 482
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    .line 485
    :cond_0
    const-string v2, ""

    .line 487
    .local v2, "file_url":Ljava/lang/String;
    const-string v0, "aio_swf_download_link: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v10

    .line 488
    .local v10, "p":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    .line 490
    .local v6, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v6}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 491
    const/4 v0, 0x1

    invoke-virtual {v6, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 500
    :cond_1
    :goto_0
    const-string v0, "rfrf"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "22222"

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 501
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 502
    const-string v9, ""

    .line 503
    .local v9, "mycontent":Ljava/lang/String;
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 504
    .local v8, "msg":Landroid/os/Message;
    const/4 v0, 0x1

    iput v0, v8, Landroid/os/Message;->what:I

    .line 505
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 507
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x64

    if-le v0, v1, :cond_3

    .line 508
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    const/4 v1, 0x0

    const/16 v3, 0x64

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    .line 512
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 513
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 514
    const-string v1, "&status=fail_get_url&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&content="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 512
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 561
    .end local v9    # "mycontent":Ljava/lang/String;
    :goto_2
    const/4 v0, 0x0

    return-object v0

    .line 493
    .end local v8    # "msg":Landroid/os/Message;
    :cond_2
    const-string v0, "Location: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v11

    .line 494
    .local v11, "p2":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    invoke-virtual {v11, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 495
    .local v7, "m2":Ljava/util/regex/Matcher;
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 496
    const/4 v0, 0x1

    invoke-virtual {v7, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 510
    .end local v7    # "m2":Ljava/util/regex/Matcher;
    .end local v11    # "p2":Ljava/util/regex/Pattern;
    .restart local v8    # "msg":Landroid/os/Message;
    .restart local v9    # "mycontent":Ljava/lang/String;
    :cond_3
    iget-object v9, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->content:Ljava/lang/String;

    goto :goto_1

    .line 525
    .end local v8    # "msg":Landroid/os/Message;
    .end local v9    # "mycontent":Ljava/lang/String;
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$10(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "downloadUrl"

    .line 526
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 527
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 525
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 527
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 528
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 529
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v8, Landroid/os/Message;->what:I

    .line 530
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_2

    .line 533
    .end local v8    # "msg":Landroid/os/Message;
    :cond_5
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 534
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 535
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 536
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$id:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 537
    const-string v4, ".apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 533
    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 537
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    .line 539
    .local v12, "path":Ljava/lang/String;
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 540
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v12}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 541
    const-string v0, "fefe"

    invoke-static {v0, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 542
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v1, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 543
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 544
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 545
    const-string v0, "rtrt"

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$icon:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "///"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 547
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 548
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 549
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->val$appserial:I

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 550
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v1, "app"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 551
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 552
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 553
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 554
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 555
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x3

    iput v0, v8, Landroid/os/Message;->what:I

    .line 556
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 557
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$2(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Ljava/lang/Boolean;)V

    goto/16 :goto_2
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 566
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 568
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 569
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$7(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "todaypick"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 570
    const-string v1, "hidetodayapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 572
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 573
    return-void
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 457
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 458
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 459
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$7(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "todaypick"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 460
    const-string v1, "showtodayapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 462
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 468
    return-void
.end method
