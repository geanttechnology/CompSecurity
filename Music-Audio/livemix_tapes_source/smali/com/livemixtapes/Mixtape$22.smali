.class Lcom/livemixtapes/Mixtape$22;
.super Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;
.source "Mixtape.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->downloadMixtapeZip(Ljava/lang/String;Landroid/view/View;Landroid/app/AlertDialog;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;

.field private final synthetic val$downloadZipView:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;

    iput-object p2, p0, Lcom/livemixtapes/Mixtape$22;->val$downloadZipView:Landroid/view/View;

    .line 1563
    invoke-direct {p0}, Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;
    .locals 1

    .prologue
    .line 1563
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;

    return-object v0
.end method


# virtual methods
.method protected always()V
    .locals 0

    .prologue
    .line 1852
    return-void
.end method

.method protected exception(Ljava/lang/Exception;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 1847
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    .line 1846
    aput-object p1, v0, v1

    invoke-static {v0}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    return-void
.end method

.method protected success(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 14
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "reasonPhrase"    # Ljava/lang/String;
    .param p3, "statusCode"    # I

    .prologue
    .line 1840
    const/4 v10, 0x4

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    .line 1566
    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "download response: "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v13, p0, Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->id:I
    invoke-static {v13}, Lcom/livemixtapes/Mixtape;->access$38(Lcom/livemixtapes/Mixtape;)I

    move-result v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    aput-object p1, v10, v11

    const/4 v11, 0x2

    aput-object p2, v10, v11

    const/4 v11, 0x3

    invoke-static/range {p3 .. p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v10}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1568
    const-string v7, "download unavailable"

    .line 1569
    .local v7, "zip_url":Ljava/lang/String;
    const-string v6, "file.zip"

    .line 1573
    .local v6, "zip_filename":Ljava/lang/String;
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 1574
    .local v0, "jObj":Lorg/json/JSONObject;
    const-string v10, "download_url"

    invoke-virtual {v0, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    .line 1575
    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "zip url: "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v10}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1581
    const-string v10, "/"

    invoke-virtual {v7, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 1582
    .local v3, "separated_url":[Ljava/lang/String;
    array-length v10, v3

    add-int/lit8 v10, v10, -0x1

    aget-object v6, v3, v10
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1595
    .end local v0    # "jObj":Lorg/json/JSONObject;
    .end local v3    # "separated_url":[Ljava/lang/String;
    :goto_0
    const-string v10, "download unavailable"

    invoke-virtual {v7, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 1600
    iget-object v10, p0, Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v10, v10, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v10, Lcom/livemixtapes/ui/BaseActivity;

    new-instance v11, Lcom/livemixtapes/Mixtape$22$1;

    invoke-direct {v11, p0}, Lcom/livemixtapes/Mixtape$22$1;-><init>(Lcom/livemixtapes/Mixtape$22;)V

    invoke-virtual {v10, v11}, Lcom/livemixtapes/ui/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 1834
    :goto_1
    return-void

    .line 1632
    :cond_0
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v10, p0, Lcom/livemixtapes/Mixtape$22;->val$downloadZipView:Landroid/view/View;

    const v12, 0x7f080077

    invoke-virtual {v10, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/TextView;

    iput-object v10, v11, Lcom/livemixtapes/Mixtape;->downloadStatus:Landroid/widget/TextView;

    .line 1636
    new-instance v2, Landroid/app/DownloadManager$Request;

    invoke-static {v7}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v10

    invoke-direct {v2, v10}, Landroid/app/DownloadManager$Request;-><init>(Landroid/net/Uri;)V

    .line 1638
    .local v2, "req":Landroid/app/DownloadManager$Request;
    const/4 v10, 0x3

    invoke-virtual {v2, v10}, Landroid/app/DownloadManager$Request;->setAllowedNetworkTypes(I)Landroid/app/DownloadManager$Request;

    move-result-object v10

    .line 1640
    const/4 v11, 0x0

    invoke-virtual {v10, v11}, Landroid/app/DownloadManager$Request;->setAllowedOverRoaming(Z)Landroid/app/DownloadManager$Request;

    move-result-object v11

    .line 1641
    iget-object v10, p0, Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v10, v10, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    const-string v12, "title"

    invoke-interface {v10, v12}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    invoke-virtual {v11, v10}, Landroid/app/DownloadManager$Request;->setTitle(Ljava/lang/CharSequence;)Landroid/app/DownloadManager$Request;

    move-result-object v10

    .line 1642
    const-string v11, "Downloading mixtape zip file..."

    invoke-virtual {v10, v11}, Landroid/app/DownloadManager$Request;->setDescription(Ljava/lang/CharSequence;)Landroid/app/DownloadManager$Request;

    move-result-object v10

    .line 1643
    sget-object v11, Landroid/os/Environment;->DIRECTORY_MUSIC:Ljava/lang/String;

    invoke-virtual {v10, v11, v6}, Landroid/app/DownloadManager$Request;->setDestinationInExternalPublicDir(Ljava/lang/String;Ljava/lang/String;)Landroid/app/DownloadManager$Request;

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    .line 1646
    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "DOWNLOADING: "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v10}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1652
    iget-object v10, p0, Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v10, v10, Lcom/livemixtapes/Mixtape;->downloadManager:Landroid/app/DownloadManager;

    invoke-virtual {v10, v2}, Landroid/app/DownloadManager;->enqueue(Landroid/app/DownloadManager$Request;)J

    move-result-wide v8

    .line 1654
    .local v8, "zipdownloadid":J
    move-object v4, v6

    .line 1656
    .local v4, "temp_filename":Ljava/lang/String;
    const-string v10, "?"

    invoke-virtual {v6, v10}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v10

    if-eqz v10, :cond_1

    .line 1658
    const-string v10, "\\?"

    invoke-virtual {v6, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 1659
    .local v1, "parts":[Ljava/lang/String;
    const/4 v10, 0x0

    aget-object v4, v1, v10

    .line 1665
    .end local v1    # "parts":[Ljava/lang/String;
    :goto_2
    move-object v5, v4

    .line 1669
    .local v5, "unzip_filename":Ljava/lang/String;
    new-instance v10, Ljava/lang/Thread;

    new-instance v11, Lcom/livemixtapes/Mixtape$22$2;

    invoke-direct {v11, p0, v8, v9, v5}, Lcom/livemixtapes/Mixtape$22$2;-><init>(Lcom/livemixtapes/Mixtape$22;JLjava/lang/String;)V

    invoke-direct {v10, v11}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1834
    invoke-virtual {v10}, Ljava/lang/Thread;->start()V

    goto :goto_1

    .line 1663
    .end local v5    # "unzip_filename":Ljava/lang/String;
    :cond_1
    move-object v4, v6

    goto :goto_2

    .line 1588
    .end local v2    # "req":Landroid/app/DownloadManager$Request;
    .end local v4    # "temp_filename":Ljava/lang/String;
    .end local v8    # "zipdownloadid":J
    :catch_0
    move-exception v10

    goto/16 :goto_0
.end method
