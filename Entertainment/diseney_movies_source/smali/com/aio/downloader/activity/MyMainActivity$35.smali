.class Lcom/aio/downloader/activity/MyMainActivity$35;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk_Update(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V
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

.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;

.field url:Ljava/lang/String;

.field private final synthetic val$appserial:I

.field private final synthetic val$icon:Ljava/lang/String;

.field private final synthetic val$id:Ljava/lang/String;

.field private final synthetic val$mIcon:Landroid/graphics/Bitmap;

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V
    .locals 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$id:Ljava/lang/String;

    iput-object p6, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$title:Ljava/lang/String;

    iput-object p7, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$icon:Ljava/lang/String;

    iput p8, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$appserial:I

    iput-object p9, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$mIcon:Landroid/graphics/Bitmap;

    .line 3239
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 3240
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 3241
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3242
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3243
    const-string v1, "&stamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3244
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3245
    const-string v1, "&time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3246
    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3247
    const-string v1, "&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->url:Ljava/lang/String;

    .line 3248
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    .line 3249
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->content:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$35;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 14
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    const/4 v5, 0x0

    const/4 v13, 0x4

    const/4 v12, 0x0

    const/4 v4, 0x1

    .line 3262
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$92(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    .line 3263
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    const-string v1, "show_header"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3264
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3265
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3266
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->content:Ljava/lang/String;

    .line 3268
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->content:Ljava/lang/String;

    const-string v1, "Location"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3269
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->url:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "&debug=1"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->url:Ljava/lang/String;

    .line 3270
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3271
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->content:Ljava/lang/String;

    .line 3274
    :cond_0
    const-string v2, ""

    .line 3276
    .local v2, "file_url":Ljava/lang/String;
    const-string v0, "aio_swf_download_link: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v9

    .line 3277
    .local v9, "p":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->content:Ljava/lang/String;

    invoke-virtual {v9, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    .line 3278
    .local v6, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v6}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 3279
    invoke-virtual {v6, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 3287
    :cond_1
    :goto_0
    const-string v0, "bbbb"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "*****"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 3291
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$8(Lcom/aio/downloader/activity/MyMainActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "downloadUrl"

    .line 3292
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 3293
    const-string v4, "downloadtask2"

    .line 3291
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 3293
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 3295
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 3296
    .local v8, "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v8, Landroid/os/Message;->what:I

    .line 3297
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 3326
    :goto_1
    return-object v5

    .line 3281
    .end local v8    # "msg":Landroid/os/Message;
    :cond_2
    const-string v0, "Location: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v10

    .line 3282
    .local v10, "p2":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->content:Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 3283
    .local v7, "m2":Ljava/util/regex/Matcher;
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3284
    invoke-virtual {v7, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 3300
    .end local v7    # "m2":Ljava/util/regex/Matcher;
    .end local v10    # "p2":Ljava/util/regex/Pattern;
    :cond_3
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 3301
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 3302
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3303
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 3304
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$id:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3305
    const-string v4, ".apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 3300
    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 3305
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v11

    .line 3307
    .local v11, "path":Ljava/lang/String;
    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->list_update:Ljava/util/ArrayList;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$39(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/ArrayList;

    move-result-object v0

    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->showup:I
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$42(Lcom/aio/downloader/activity/MyMainActivity;)I

    move-result v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getLink_url()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 3308
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 3310
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 3311
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 3312
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 3313
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 3314
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v1, "app"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 3315
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 3316
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$appserial:I

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 3317
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 3318
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->val$mIcon:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImage(Landroid/graphics/Bitmap;)V

    .line 3319
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 3320
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3321
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 3322
    .restart local v8    # "msg":Landroid/os/Message;
    iput v13, v8, Landroid/os/Message;->what:I

    .line 3323
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$35;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 3332
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 3334
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 3336
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 3253
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 3255
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$35;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 3257
    return-void
.end method
