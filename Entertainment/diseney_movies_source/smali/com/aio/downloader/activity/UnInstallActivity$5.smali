.class Lcom/aio/downloader/activity/UnInstallActivity$5;
.super Landroid/os/AsyncTask;
.source "UnInstallActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/UnInstallActivity;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
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

.field final synthetic this$0:Lcom/aio/downloader/activity/UnInstallActivity;

.field url:Ljava/lang/String;

.field private final synthetic val$appserial:I

.field private final synthetic val$icon:Ljava/lang/String;

.field private final synthetic val$id:Ljava/lang/String;

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/UnInstallActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V
    .locals 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$id:Ljava/lang/String;

    iput-object p6, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$title:Ljava/lang/String;

    iput-object p7, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$icon:Ljava/lang/String;

    iput p8, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$appserial:I

    .line 311
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 312
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 313
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 314
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 315
    const-string v1, "&stamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 316
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 317
    const-string v1, "&time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 318
    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 319
    const-string v1, "&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->url:Ljava/lang/String;

    .line 320
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    .line 321
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/UnInstallActivity$5;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 13
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 341
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # getter for: Lcom/aio/downloader/activity/UnInstallActivity;->default_options:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/aio/downloader/activity/UnInstallActivity;->access$5(Lcom/aio/downloader/activity/UnInstallActivity;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    .line 342
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 343
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 344
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    .line 347
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    const-string v1, "Location"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 348
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->url:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "&debug=1"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->url:Ljava/lang/String;

    .line 349
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 350
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    .line 353
    :cond_0
    const-string v2, ""

    .line 355
    .local v2, "file_url":Ljava/lang/String;
    const-string v0, "aio_swf_download_link: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v10

    .line 356
    .local v10, "p":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    .line 357
    .local v6, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v6}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 358
    const/4 v0, 0x1

    invoke-virtual {v6, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 367
    :cond_1
    :goto_0
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 369
    const-string v9, ""

    .line 370
    .local v9, "mycontent":Ljava/lang/String;
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 371
    .local v8, "msg":Landroid/os/Message;
    const/4 v0, 0x1

    iput v0, v8, Landroid/os/Message;->what:I

    .line 372
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/UnInstallActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 374
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x64

    if-le v0, v1, :cond_3

    .line 375
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    const/4 v1, 0x0

    const/16 v3, 0x64

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    .line 379
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 380
    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 381
    const-string v1, "&status=fail_get_url&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 382
    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&content="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 379
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 427
    .end local v9    # "mycontent":Ljava/lang/String;
    :goto_2
    const/4 v0, 0x0

    return-object v0

    .line 360
    .end local v8    # "msg":Landroid/os/Message;
    :cond_2
    const-string v0, "Location: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v11

    .line 361
    .local v11, "p2":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    invoke-virtual {v11, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 362
    .local v7, "m2":Ljava/util/regex/Matcher;
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 363
    const/4 v0, 0x1

    invoke-virtual {v7, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 377
    .end local v7    # "m2":Ljava/util/regex/Matcher;
    .end local v11    # "p2":Ljava/util/regex/Pattern;
    .restart local v8    # "msg":Landroid/os/Message;
    .restart local v9    # "mycontent":Ljava/lang/String;
    :cond_3
    iget-object v9, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->content:Ljava/lang/String;

    goto :goto_1

    .line 386
    .end local v8    # "msg":Landroid/os/Message;
    .end local v9    # "mycontent":Ljava/lang/String;
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # getter for: Lcom/aio/downloader/activity/UnInstallActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/UnInstallActivity;->access$7(Lcom/aio/downloader/activity/UnInstallActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "downloadUrl"

    .line 387
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 388
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 386
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 388
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 390
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 391
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v8, Landroid/os/Message;->what:I

    .line 392
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/UnInstallActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_2

    .line 395
    .end local v8    # "msg":Landroid/os/Message;
    :cond_5
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 396
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 397
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 398
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 399
    iget-object v3, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/UnInstallActivity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 400
    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$id:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, ".apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 395
    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 400
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    .line 408
    .local v12, "path":Ljava/lang/String;
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 409
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v12}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 411
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v1, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 412
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 413
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 414
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 415
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v1, "app"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 416
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 417
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->val$appserial:I

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 418
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 419
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/UnInstallActivity;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 420
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 421
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 422
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x3

    iput v0, v8, Landroid/os/Message;->what:I

    .line 423
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/UnInstallActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_2
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/UnInstallActivity$5;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 433
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 435
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # getter for: Lcom/aio/downloader/activity/UnInstallActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/UnInstallActivity;->access$4(Lcom/aio/downloader/activity/UnInstallActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 436
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 327
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 331
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity$5;->this$0:Lcom/aio/downloader/activity/UnInstallActivity;

    # getter for: Lcom/aio/downloader/activity/UnInstallActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/UnInstallActivity;->access$4(Lcom/aio/downloader/activity/UnInstallActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 336
    return-void
.end method
