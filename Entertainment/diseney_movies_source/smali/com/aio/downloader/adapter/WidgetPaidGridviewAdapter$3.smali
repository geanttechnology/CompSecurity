.class Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;
.super Landroid/os/AsyncTask;
.source "WidgetPaidGridviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
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

.field final synthetic this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

.field url:Ljava/lang/String;

.field private final synthetic val$appserial:I

.field private final synthetic val$icon:Ljava/lang/String;

.field private final synthetic val$id:Ljava/lang/String;

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V
    .locals 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$id:Ljava/lang/String;

    iput-object p6, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$title:Ljava/lang/String;

    iput-object p7, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$icon:Ljava/lang/String;

    iput p8, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$appserial:I

    .line 400
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 401
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 402
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 403
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 404
    const-string v1, "&stamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 405
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 406
    const-string v1, "&time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 407
    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 408
    const-string v1, "&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->url:Ljava/lang/String;

    .line 409
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    .line 410
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 13
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 429
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->default_options:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$5(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    .line 430
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 431
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 432
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 433
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    .line 435
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    const-string v1, "Location"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 436
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->url:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "&debug=1"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->url:Ljava/lang/String;

    .line 437
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 438
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    .line 441
    :cond_0
    const-string v2, ""

    .line 443
    .local v2, "file_url":Ljava/lang/String;
    const-string v0, "aio_swf_download_link: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v10

    .line 444
    .local v10, "p":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    .line 446
    .local v6, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v6}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 447
    const/4 v0, 0x1

    invoke-virtual {v6, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 457
    :cond_1
    :goto_0
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 458
    const-string v9, ""

    .line 459
    .local v9, "mycontent":Ljava/lang/String;
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 460
    .local v8, "msg":Landroid/os/Message;
    const/4 v0, 0x1

    iput v0, v8, Landroid/os/Message;->what:I

    .line 461
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 463
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x64

    if-le v0, v1, :cond_3

    .line 464
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    const/4 v1, 0x0

    const/16 v3, 0x64

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    .line 469
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 470
    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 471
    const-string v1, "&status=fail_get_url&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 472
    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&content="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 469
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 510
    .end local v9    # "mycontent":Ljava/lang/String;
    :goto_2
    const/4 v0, 0x0

    return-object v0

    .line 449
    .end local v8    # "msg":Landroid/os/Message;
    :cond_2
    const-string v0, "Location: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v11

    .line 450
    .local v11, "p2":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    invoke-virtual {v11, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 452
    .local v7, "m2":Ljava/util/regex/Matcher;
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 453
    const/4 v0, 0x1

    invoke-virtual {v7, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 466
    .end local v7    # "m2":Ljava/util/regex/Matcher;
    .end local v11    # "p2":Ljava/util/regex/Pattern;
    .restart local v8    # "msg":Landroid/os/Message;
    .restart local v9    # "mycontent":Ljava/lang/String;
    :cond_3
    iget-object v9, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->content:Ljava/lang/String;

    goto :goto_1

    .line 476
    .end local v8    # "msg":Landroid/os/Message;
    .end local v9    # "mycontent":Ljava/lang/String;
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$7(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "downloadUrl"

    .line 477
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 478
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 476
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 478
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 479
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 480
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v8, Landroid/os/Message;->what:I

    .line 481
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_2

    .line 484
    .end local v8    # "msg":Landroid/os/Message;
    :cond_5
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 485
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 486
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 487
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$id:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 488
    const-string v4, ".apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 484
    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 488
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    .line 490
    .local v12, "path":Ljava/lang/String;
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 491
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v12}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 492
    const-string v0, "fefe"

    invoke-static {v0, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 493
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v1, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 494
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 495
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 496
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 497
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 498
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->val$appserial:I

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 499
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v1, "app"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 500
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 501
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 502
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 503
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 504
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x3

    iput v0, v8, Landroid/os/Message;->what:I

    .line 505
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 506
    iget-object v0, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$1(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;Ljava/lang/Boolean;)V

    goto/16 :goto_2
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 515
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 517
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 518
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$3(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appgvdetail"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 519
    const-string v1, "hidegvappdetail"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 523
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 524
    return-void

    .line 520
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$3(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appgvhome"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 521
    const-string v1, "hidehomeapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 414
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 415
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 416
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$3(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appgvdetail"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 417
    const-string v1, "showgvappdetail"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 422
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 424
    return-void

    .line 418
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$3;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$3(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appgvhome"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 419
    const-string v1, "showhomeapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0
.end method
