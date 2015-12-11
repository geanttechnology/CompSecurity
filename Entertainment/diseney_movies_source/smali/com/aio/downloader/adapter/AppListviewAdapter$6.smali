.class Lcom/aio/downloader/adapter/AppListviewAdapter$6;
.super Landroid/os/AsyncTask;
.source "AppListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter;->MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
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

.field final synthetic this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

.field url:Ljava/lang/String;

.field private final synthetic val$appserial:I

.field private final synthetic val$icon:Ljava/lang/String;

.field private final synthetic val$id:Ljava/lang/String;

.field private final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V
    .locals 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$id:Ljava/lang/String;

    iput-object p6, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$title:Ljava/lang/String;

    iput-object p7, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$icon:Ljava/lang/String;

    iput p8, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$appserial:I

    .line 715
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 716
    new-instance v0, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 717
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 718
    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 719
    const-string v1, "&stamp="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 720
    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 721
    const-string v1, "&time="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 722
    invoke-virtual {v0, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 723
    const-string v1, "&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->url:Ljava/lang/String;

    .line 727
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    .line 728
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 13
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 798
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->default_options:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$12(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    .line 799
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    const-string v1, "show_header"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 800
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 801
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 802
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    .line 804
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    const-string v1, "Location"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 805
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->url:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v0, "&debug=1"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->url:Ljava/lang/String;

    .line 806
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 807
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->url:Ljava/lang/String;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->options:Ljava/util/HashMap;

    invoke-static {v0, v1}, Lcom/aio/downloader/utils/publicTools;->getDataFromURL(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    .line 812
    :cond_0
    const-string v2, ""

    .line 814
    .local v2, "file_url":Ljava/lang/String;
    const-string v0, "aio_swf_download_link: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v10

    .line 815
    .local v10, "p":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    invoke-virtual {v10, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v6

    .line 817
    .local v6, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v6}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 818
    const/4 v0, 0x1

    invoke-virtual {v6, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    .line 827
    :cond_1
    :goto_0
    const-string v0, "rtyu"

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "*******"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 828
    const-string v0, "rfrf"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "22222"

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 829
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 830
    const-string v9, ""

    .line 831
    .local v9, "mycontent":Ljava/lang/String;
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 832
    .local v8, "msg":Landroid/os/Message;
    const/4 v0, 0x1

    iput v0, v8, Landroid/os/Message;->what:I

    .line 833
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/AppListviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 835
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x64

    if-le v0, v1, :cond_3

    .line 836
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    const/4 v1, 0x0

    const/16 v3, 0x64

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v9

    .line 840
    :goto_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 841
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 842
    const-string v1, "&status=fail_get_url&version="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 843
    const-string v1, "3.3.9"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&content="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 840
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 887
    .end local v9    # "mycontent":Ljava/lang/String;
    :goto_2
    const/4 v0, 0x0

    return-object v0

    .line 820
    .end local v8    # "msg":Landroid/os/Message;
    :cond_2
    const-string v0, "Location: ([^\n\r\t]+)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v11

    .line 821
    .local v11, "p2":Ljava/util/regex/Pattern;
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    invoke-virtual {v11, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    .line 822
    .local v7, "m2":Ljava/util/regex/Matcher;
    invoke-virtual {v7}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 823
    const/4 v0, 0x1

    invoke-virtual {v7, v0}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 838
    .end local v7    # "m2":Ljava/util/regex/Matcher;
    .end local v11    # "p2":Ljava/util/regex/Pattern;
    .restart local v8    # "msg":Landroid/os/Message;
    .restart local v9    # "mycontent":Ljava/lang/String;
    :cond_3
    iget-object v9, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->content:Ljava/lang/String;

    goto :goto_1

    .line 853
    .end local v8    # "msg":Landroid/os/Message;
    .end local v9    # "mycontent":Ljava/lang/String;
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->db:Lnet/tsz/afinal/FinalDBChen;
    invoke-static {v0}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$14(Lcom/aio/downloader/adapter/AppListviewAdapter;)Lnet/tsz/afinal/FinalDBChen;

    move-result-object v0

    const-string v1, "downloadUrl"

    .line 854
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 855
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 853
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 855
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 856
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 857
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x2

    iput v0, v8, Landroid/os/Message;->what:I

    .line 858
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/AppListviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    goto :goto_2

    .line 861
    .end local v8    # "msg":Landroid/os/Message;
    :cond_5
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 862
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 863
    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 864
    sget-object v3, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$id:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 865
    const-string v4, ".apk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 861
    invoke-direct {v0, v1, v3}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 865
    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    .line 867
    .local v12, "path":Ljava/lang/String;
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadUrl(Ljava/lang/String;)V

    .line 868
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v12}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFilePath(Ljava/lang/String;)V

    .line 869
    const-string v0, "fefe"

    invoke-static {v0, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 870
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const/4 v1, 0x4

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 871
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieName(Ljava/lang/String;)V

    .line 872
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setMovieHeadImagePath(Ljava/lang/String;)V

    .line 873
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setFile_id(Ljava/lang/String;)V

    .line 874
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setTitle(Ljava/lang/String;)V

    .line 875
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    iget v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->val$appserial:I

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setSerial(I)V

    .line 876
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v1, "app"

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setType(Ljava/lang/String;)V

    .line 877
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setCreate_time(Ljava/lang/Long;)V

    .line 878
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 879
    invoke-static {}, Lcom/aio/downloader/utils/Myutils;->getInstance()Lcom/aio/downloader/utils/Myutils;

    sget-object v0, Lcom/aio/downloader/utils/Myutils;->list:Ljava/util/List;

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->d:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 880
    new-instance v8, Landroid/os/Message;

    invoke-direct {v8}, Landroid/os/Message;-><init>()V

    .line 881
    .restart local v8    # "msg":Landroid/os/Message;
    const/4 v0, 0x3

    iput v0, v8, Landroid/os/Message;->what:I

    .line 882
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    iget-object v0, v0, Lcom/aio/downloader/adapter/AppListviewAdapter;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v8}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 883
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$2(Lcom/aio/downloader/adapter/AppListviewAdapter;Ljava/lang/Boolean;)V

    goto/16 :goto_2
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 892
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 893
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 894
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 895
    const-string v1, "hideapp1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 906
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 907
    const-string v1, "hidegame1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 918
    :cond_1
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 919
    const-string v1, "hidepaid1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 930
    :cond_2
    :goto_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 931
    const-string v1, "hideadult1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 946
    :cond_3
    :goto_3
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 947
    return-void

    .line 896
    :cond_4
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 897
    const-string v1, "hideapp2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 898
    :cond_5
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 899
    const-string v1, "hideapp3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 900
    :cond_6
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 901
    const-string v1, "hideapp4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 902
    :cond_7
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 903
    const-string v1, "hideapp5"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 908
    :cond_8
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 909
    const-string v1, "hidegame2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 910
    :cond_9
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 911
    const-string v1, "hidegame3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 912
    :cond_a
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 913
    const-string v1, "hidegame4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 914
    :cond_b
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 915
    const-string v1, "hidegame5"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 920
    :cond_c
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 921
    const-string v1, "hidepaid2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 922
    :cond_d
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 923
    const-string v1, "hidepaid3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 924
    :cond_e
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 925
    const-string v1, "hidepaid4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 926
    :cond_f
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 927
    const-string v1, "hidepaid5"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 932
    :cond_10
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 933
    const-string v1, "hideadult2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 934
    :cond_11
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_12

    .line 935
    const-string v1, "hideadult3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 936
    :cond_12
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_13

    .line 937
    const-string v1, "hideadult4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 940
    :cond_13
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "homeapp"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_14

    .line 941
    const-string v1, "hidehomeapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 943
    :cond_14
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appsearch"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 944
    const-string v1, "hideappsearch"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 732
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 733
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 735
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 736
    const-string v1, "showapp1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 747
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 748
    const-string v1, "showgame1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 759
    :cond_1
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_c

    .line 760
    const-string v1, "showpaid1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 771
    :cond_2
    :goto_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 772
    const-string v1, "showadult1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 787
    :cond_3
    :goto_3
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 793
    return-void

    .line 737
    :cond_4
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 738
    const-string v1, "showapp2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 739
    :cond_5
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 740
    const-string v1, "showapp3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 741
    :cond_6
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7

    .line 742
    const-string v1, "showapp4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 743
    :cond_7
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 744
    const-string v1, "showapp5"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_0

    .line 749
    :cond_8
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 750
    const-string v1, "showgame2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 751
    :cond_9
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_a

    .line 752
    const-string v1, "showgame3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 753
    :cond_a
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 754
    const-string v1, "showgame4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 755
    :cond_b
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 756
    const-string v1, "showgame5"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 761
    :cond_c
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_d

    .line 762
    const-string v1, "showpaid2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 763
    :cond_d
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_e

    .line 764
    const-string v1, "showpaid3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 765
    :cond_e
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 766
    const-string v1, "showpaid4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 767
    :cond_f
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 768
    const-string v1, "showpaid5"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_2

    .line 773
    :cond_10
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 774
    const-string v1, "showadult2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 775
    :cond_11
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_12

    .line 776
    const-string v1, "showadult3"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 777
    :cond_12
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_13

    .line 778
    const-string v1, "showadult4"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 781
    :cond_13
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "homeapp"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_14

    .line 782
    const-string v1, "showhomeapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3

    .line 783
    :cond_14
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$6;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appsearch"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 784
    const-string v1, "showappsearch"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_3
.end method
