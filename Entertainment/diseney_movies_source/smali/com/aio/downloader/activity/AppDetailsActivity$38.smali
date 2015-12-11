.class Lcom/aio/downloader/activity/AppDetailsActivity$38;
.super Landroid/os/AsyncTask;
.source "AppDetailsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/AppDetailsActivity;->MydownloadApk_Update(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V
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

.field final synthetic this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

.field url:Ljava/lang/String;

.field private final synthetic val$appserial:I

.field private final synthetic val$icon:Ljava/lang/String;

.field private final synthetic val$id:Ljava/lang/String;

.field private final synthetic val$mIcon:Landroid/graphics/Bitmap;

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILandroid/graphics/Bitmap;)V
    .locals 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$id:Ljava/lang/String;

    iput-object p6, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$title:Ljava/lang/String;

    iput-object p7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$icon:Ljava/lang/String;

    iput p8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$appserial:I

    iput-object p9, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$mIcon:Landroid/graphics/Bitmap;

    .line 2748
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 2749
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 2750
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2751
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 2752
    const-string v1, "&stamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 2753
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 2754
    const-string v1, "&time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 2755
    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 2756
    const-string v1, "&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->url:Ljava/lang/String;

    .line 2757
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    .line 2758
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->content:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/AppDetailsActivity$38;)Lcom/aio/downloader/activity/AppDetailsActivity;
    .locals 1

    .prologue
    .line 2748
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    return-object v0
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 12
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    const/4 v11, 0x0

    const/4 v10, 0x1

    .line 2771
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->default_options:Ljava/util/HashMap;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$86(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/HashMap;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    .line 2772
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    const-string v8, "show_header"

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2773
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    const-string v8, "redirect"

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2774
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    const-string v8, "send_cookie"

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2775
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->url:Ljava/lang/String;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    invoke-static {v7, v8}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->content:Ljava/lang/String;

    .line 2777
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->content:Ljava/lang/String;

    const-string v8, "Location"

    invoke-virtual {v7, v8}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 2778
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->url:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v8, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "&debug=1"

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->url:Ljava/lang/String;

    .line 2779
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    const-string v8, "redirect"

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2780
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->url:Ljava/lang/String;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->options:Ljava/util/HashMap;

    invoke-static {v7, v8}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->content:Ljava/lang/String;

    .line 2783
    :cond_0
    const-string v0, ""

    .line 2785
    .local v0, "file_url":Ljava/lang/String;
    const-string v7, "aio_swf_download_link: ([^\n\r\t]+)"

    invoke-static {v7}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v4

    .line 2786
    .local v4, "p":Ljava/util/regex/Pattern;
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->content:Ljava/lang/String;

    invoke-virtual {v4, v7}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 2787
    .local v1, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 2788
    invoke-virtual {v1, v10}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    .line 2796
    :cond_1
    :goto_0
    const-string v7, "bbbb"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "*****"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 2800
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    invoke-static {v7}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$26(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/db/TypeDbUtils;

    move-result-object v7

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$id:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/db/TypeDbUtils;->queryfile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    if-eqz v7, :cond_3

    .line 2802
    new-instance v3, Landroid/os/Message;

    invoke-direct {v3}, Landroid/os/Message;-><init>()V

    .line 2803
    .local v3, "msg":Landroid/os/Message;
    const/4 v7, 0x2

    iput v7, v3, Landroid/os/Message;->what:I

    .line 2804
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v7, v7, Lcom/aio/downloader/activity/AppDetailsActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v7, v3}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 2835
    :goto_1
    const/4 v7, 0x0

    return-object v7

    .line 2790
    .end local v3    # "msg":Landroid/os/Message;
    :cond_2
    const-string v7, "Location: ([^\n\r\t]+)"

    invoke-static {v7}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v5

    .line 2791
    .local v5, "p2":Ljava/util/regex/Pattern;
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->content:Ljava/lang/String;

    invoke-virtual {v5, v7}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 2792
    .local v2, "m2":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->find()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 2793
    invoke-virtual {v2, v10}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 2807
    .end local v2    # "m2":Ljava/util/regex/Matcher;
    .end local v5    # "p2":Ljava/util/regex/Pattern;
    :cond_3
    new-instance v7, Ljava/io/File;

    new-instance v8, Ljava/lang/StringBuilder;

    .line 2808
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v9

    .line 2809
    invoke-virtual {v9}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2810
    sget-object v9, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    .line 2811
    iget-object v9, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    invoke-virtual {v9}, Lcom/aio/downloader/activity/AppDetailsActivity;->getPackageName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    iget-object v10, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$id:Ljava/lang/String;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 2812
    const-string v10, ".apk"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 2807
    invoke-direct {v7, v8, v9}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 2812
    invoke-virtual {v7}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v6

    .line 2814
    .local v6, "path":Ljava/lang/String;
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->linkurl1:Ljava/lang/String;
    invoke-static {v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$83(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 2815
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$id:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setId(Ljava/lang/String;)V

    .line 2816
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7, v6}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 2818
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v8, 0x4

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 2819
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 2820
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$icon:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 2821
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$id:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 2822
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v8, "app"

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 2823
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v8, "app"

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCat(Ljava/lang/String;)V

    .line 2824
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$title:Ljava/lang/String;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 2825
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$appserial:I

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 2826
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 2827
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->val$mIcon:Landroid/graphics/Bitmap;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImage(Landroid/graphics/Bitmap;)V

    .line 2828
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v7, v8}, Lcom/aio/downloader/activity/AppDetailsActivity;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 2829
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v7, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v8, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v7, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 2830
    new-instance v3, Landroid/os/Message;

    invoke-direct {v3}, Landroid/os/Message;-><init>()V

    .line 2831
    .restart local v3    # "msg":Landroid/os/Message;
    const/4 v7, 0x3

    iput v7, v3, Landroid/os/Message;->what:I

    .line 2832
    iget-object v7, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    iget-object v7, v7, Lcom/aio/downloader/activity/AppDetailsActivity;->handler:Landroid/os/Handler;

    invoke-virtual {v7, v3}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto/16 :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/activity/AppDetailsActivity$38;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 6
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    const/16 v2, 0x8

    .line 2841
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 2843
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 2845
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtopre2:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$5(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2846
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->detailtoprel:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$6(Lcom/aio/downloader/activity/AppDetailsActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2848
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$77(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/Timer;)V

    .line 2849
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$77(Lcom/aio/downloader/activity/AppDetailsActivity;Ljava/util/Timer;)V

    .line 2850
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->timer2:Ljava/util/Timer;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$7(Lcom/aio/downloader/activity/AppDetailsActivity;)Ljava/util/Timer;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/AppDetailsActivity$38$1;-><init>(Lcom/aio/downloader/activity/AppDetailsActivity$38;)V

    .line 2869
    const-wide/16 v2, 0x3e8

    const-wide/16 v4, 0x258

    .line 2850
    invoke-virtual/range {v0 .. v5}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    .line 2871
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 2762
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 2764
    iget-object v0, p0, Lcom/aio/downloader/activity/AppDetailsActivity$38;->this$0:Lcom/aio/downloader/activity/AppDetailsActivity;

    # getter for: Lcom/aio/downloader/activity/AppDetailsActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;
    invoke-static {v0}, Lcom/aio/downloader/activity/AppDetailsActivity;->access$0(Lcom/aio/downloader/activity/AppDetailsActivity;)Lcom/aio/downloader/utils/ProgressWheel;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/utils/ProgressWheel;->setVisibility(I)V

    .line 2766
    return-void
.end method
