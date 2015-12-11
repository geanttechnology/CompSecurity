.class Lcom/aio/downloader/activity/MyMainActivity$40;
.super Landroid/os/AsyncTask;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MyMainActivity;->MydownloadApk3(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
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

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V
    .locals 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$id:Ljava/lang/String;

    iput-object p6, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$title:Ljava/lang/String;

    iput-object p7, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$icon:Ljava/lang/String;

    iput p8, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$appserial:I

    .line 3797
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 3798
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 3799
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3800
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3801
    const-string v1, "&stamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3802
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3803
    const-string v1, "&time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3804
    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 3805
    const-string v1, "&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->url:Ljava/lang/String;

    .line 3806
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    .line 3807
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->content:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$40;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

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

    .line 3820
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->default_options:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$92(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    .line 3821
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    const-string v1, "show_header"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3822
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3823
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3824
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->content:Ljava/lang/String;

    .line 3826
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->content:Ljava/lang/String;

    const-string v1, "Location"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3827
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->url:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "&debug=1"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->url:Ljava/lang/String;

    .line 3828
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3829
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->content:Ljava/lang/String;

    .line 3832
    :cond_0
    const-string v2, ""

    .line 3834
    .local v2, "file_url":Ljava/lang/String;
    const-string v0, "aio_swf_download_link: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v9

    .line 3835
    .local v9, "p":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->content:Ljava/lang/String;

    invoke-virtual {v9, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    .line 3836
    .local v6, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v6}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 3837
    invoke-virtual {v6, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 3845
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

    .line 3849
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$8(Lcom/aio/downloader/activity/MyMainActivity;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "downloadUrl"

    .line 3850
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 3851
    const-string v4, "downloadtask2"

    .line 3849
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 3851
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 3853
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 3854
    .local v8, "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v8, Landroid/os/Message;->what:I

    .line 3855
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 3883
    :goto_1
    return-object v5

    .line 3839
    .end local v8    # "msg":Landroid/os/Message;
    :cond_2
    const-string v0, "Location: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v10

    .line 3840
    .local v10, "p2":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->content:Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 3841
    .local v7, "m2":Ljava/util/regex/Matcher;
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3842
    invoke-virtual {v7, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 3858
    .end local v7    # "m2":Ljava/util/regex/Matcher;
    .end local v10    # "p2":Ljava/util/regex/Pattern;
    :cond_3
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 3859
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 3860
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3861
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 3862
    iget-object v3, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyMainActivity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$id:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3863
    const-string v4, ".apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 3858
    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 3863
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v11

    .line 3865
    .local v11, "path":Ljava/lang/String;
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->acquire_url_start:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/MyMainActivity;->access$93(Lcom/aio/downloader/activity/MyMainActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 3866
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v11}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 3868
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 3869
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 3870
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 3871
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 3872
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v1, "app"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 3873
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 3874
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->val$appserial:I

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 3875
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 3876
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/MyMainActivity;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 3877
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v1, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3878
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 3879
    .restart local v8    # "msg":Landroid/os/Message;
    iput v13, v8, Landroid/os/Message;->what:I

    .line 3880
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    iget-object v0, v0, Lcom/aio/downloader/activity/MyMainActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/MyMainActivity$40;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 3889
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 3891
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 3893
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 3811
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 3813
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$40;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/MyMainActivity;->access$13(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 3815
    return-void
.end method
