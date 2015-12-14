.class Lcom/livemixtapes/Mixtape$22$2;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape$22;->success(Ljava/lang/String;Ljava/lang/String;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/Mixtape$22;

.field private final synthetic val$unzip_filename:Ljava/lang/String;

.field private final synthetic val$zipdownloadid:J


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape$22;JLjava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    iput-wide p2, p0, Lcom/livemixtapes/Mixtape$22$2;->val$zipdownloadid:J

    iput-object p4, p0, Lcom/livemixtapes/Mixtape$22$2;->val$unzip_filename:Ljava/lang/String;

    .line 1669
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/Mixtape$22$2;)Lcom/livemixtapes/Mixtape$22;
    .locals 1

    .prologue
    .line 1669
    iget-object v0, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 15

    .prologue
    .line 1674
    const/4 v4, 0x1

    .line 1676
    .local v4, "downloading":Z
    :goto_0
    if-nez v4, :cond_0

    .line 1833
    return-void

    .line 1678
    :cond_0
    new-instance v6, Landroid/app/DownloadManager$Query;

    invoke-direct {v6}, Landroid/app/DownloadManager$Query;-><init>()V

    .line 1679
    .local v6, "q":Landroid/app/DownloadManager$Query;
    const/4 v11, 0x1

    new-array v11, v11, [J

    const/4 v12, 0x0

    iget-wide v13, p0, Lcom/livemixtapes/Mixtape$22$2;->val$zipdownloadid:J

    aput-wide v13, v11, v12

    invoke-virtual {v6, v11}, Landroid/app/DownloadManager$Query;->setFilterById([J)Landroid/app/DownloadManager$Query;

    .line 1681
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    # getter for: Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v11}, Lcom/livemixtapes/Mixtape$22;->access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;

    move-result-object v11

    iget-object v11, v11, Lcom/livemixtapes/Mixtape;->downloadManager:Landroid/app/DownloadManager;

    invoke-virtual {v11, v6}, Landroid/app/DownloadManager;->query(Landroid/app/DownloadManager$Query;)Landroid/database/Cursor;

    move-result-object v2

    .line 1682
    .local v2, "cursor":Landroid/database/Cursor;
    invoke-interface {v2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 1684
    const-string v11, "bytes_so_far"

    invoke-interface {v2, v11}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    .line 1683
    invoke-interface {v2, v11}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 1685
    .local v0, "bytes_downloaded":I
    const-string v11, "total_size"

    invoke-interface {v2, v11}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    invoke-interface {v2, v11}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    .line 1687
    .local v1, "bytes_total":I
    const-string v11, "status"

    invoke-interface {v2, v11}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    invoke-interface {v2, v11}, Landroid/database/Cursor;->getInt(I)I

    move-result v11

    const/16 v12, 0x8

    if-ne v11, v12, :cond_1

    .line 1688
    const/4 v4, 0x0

    .line 1692
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    # getter for: Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v11}, Lcom/livemixtapes/Mixtape$22;->access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;

    move-result-object v11

    iget-object v11, v11, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v11, Lcom/livemixtapes/ui/BaseActivity;

    new-instance v12, Lcom/livemixtapes/Mixtape$22$2$1;

    invoke-direct {v12, p0}, Lcom/livemixtapes/Mixtape$22$2$1;-><init>(Lcom/livemixtapes/Mixtape$22$2;)V

    invoke-virtual {v11, v12}, Lcom/livemixtapes/ui/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    .line 1703
    new-instance v13, Ljava/lang/StringBuilder;

    const-string v14, "UNZIPPING: "

    invoke-direct {v13, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v14, p0, Lcom/livemixtapes/Mixtape$22$2;->val$unzip_filename:Ljava/lang/String;

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v11}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 1707
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    # getter for: Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v11}, Lcom/livemixtapes/Mixtape$22;->access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;

    move-result-object v11

    iget-object v11, v11, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v11, Lcom/livemixtapes/ui/BaseActivity;

    new-instance v12, Lcom/livemixtapes/Mixtape$22$2$2;

    invoke-direct {v12, p0}, Lcom/livemixtapes/Mixtape$22$2$2;-><init>(Lcom/livemixtapes/Mixtape$22$2;)V

    invoke-virtual {v11, v12}, Lcom/livemixtapes/ui/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 1736
    sget-object v11, Landroid/os/Environment;->DIRECTORY_MUSIC:Ljava/lang/String;

    invoke-static {v11}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v11

    invoke-virtual {v11}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v8

    .line 1740
    .local v8, "zip_destination":Ljava/lang/String;
    :try_start_0
    new-instance v7, Lnet/lingala/zip4j/core/ZipFile;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "/"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget-object v12, p0, Lcom/livemixtapes/Mixtape$22$2;->val$unzip_filename:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v7, v11}, Lnet/lingala/zip4j/core/ZipFile;-><init>(Ljava/lang/String;)V

    .line 1741
    .local v7, "zipFile":Lnet/lingala/zip4j/core/ZipFile;
    invoke-virtual {v7}, Lnet/lingala/zip4j/core/ZipFile;->isEncrypted()Z

    .line 1744
    invoke-virtual {v7, v8}, Lnet/lingala/zip4j/core/ZipFile;->extractAll(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 1751
    :try_start_1
    new-instance v10, Ljava/io/File;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "/"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget-object v12, p0, Lcom/livemixtapes/Mixtape$22$2;->val$unzip_filename:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1752
    .local v10, "zip_remove":Ljava/io/File;
    invoke-virtual {v10}, Ljava/io/File;->delete()Z

    .line 1755
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22$2;->val$unzip_filename:Ljava/lang/String;

    const-string v12, ".zip"

    const-string v13, ""

    invoke-virtual {v11, v12, v13}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v9

    .line 1756
    .local v9, "zip_folder":Ljava/lang/String;
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    # getter for: Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v11}, Lcom/livemixtapes/Mixtape$22;->access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;

    move-result-object v11

    # invokes: Lcom/livemixtapes/Mixtape;->scanMedia(Ljava/lang/String;)V
    invoke-static {v11, v9}, Lcom/livemixtapes/Mixtape;->access$39(Lcom/livemixtapes/Mixtape;Ljava/lang/String;)V

    .line 1759
    const/4 v11, 0x0

    sput-boolean v11, Lcom/livemixtapes/App;->isUnzipping:Z

    .line 1767
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    # getter for: Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v11}, Lcom/livemixtapes/Mixtape$22;->access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;

    move-result-object v11

    iget-object v11, v11, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v11, Lcom/livemixtapes/ui/BaseActivity;

    new-instance v12, Lcom/livemixtapes/Mixtape$22$2$3;

    invoke-direct {v12, p0}, Lcom/livemixtapes/Mixtape$22$2$3;-><init>(Lcom/livemixtapes/Mixtape$22$2;)V

    invoke-virtual {v11, v12}, Lcom/livemixtapes/ui/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 1816
    .end local v7    # "zipFile":Lnet/lingala/zip4j/core/ZipFile;
    .end local v8    # "zip_destination":Ljava/lang/String;
    .end local v9    # "zip_folder":Ljava/lang/String;
    .end local v10    # "zip_remove":Ljava/io/File;
    :cond_1
    :goto_1
    int-to-long v11, v0

    const-wide/16 v13, 0x64

    mul-long/2addr v11, v13

    int-to-long v13, v1

    div-long/2addr v11, v13

    long-to-int v3, v11

    .line 1818
    .local v3, "dl_progress":I
    iget-object v11, p0, Lcom/livemixtapes/Mixtape$22$2;->this$1:Lcom/livemixtapes/Mixtape$22;

    # getter for: Lcom/livemixtapes/Mixtape$22;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v11}, Lcom/livemixtapes/Mixtape$22;->access$0(Lcom/livemixtapes/Mixtape$22;)Lcom/livemixtapes/Mixtape;

    move-result-object v11

    iget-object v11, v11, Lcom/livemixtapes/Mixtape;->mContext:Landroid/content/Context;

    check-cast v11, Lcom/livemixtapes/ui/BaseActivity;

    new-instance v12, Lcom/livemixtapes/Mixtape$22$2$4;

    invoke-direct {v12, p0}, Lcom/livemixtapes/Mixtape$22$2$4;-><init>(Lcom/livemixtapes/Mixtape$22$2;)V

    invoke-virtual {v11, v12}, Lcom/livemixtapes/ui/BaseActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 1830
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    goto/16 :goto_0

    .line 1798
    .end local v3    # "dl_progress":I
    .restart local v7    # "zipFile":Lnet/lingala/zip4j/core/ZipFile;
    .restart local v8    # "zip_destination":Ljava/lang/String;
    :catch_0
    move-exception v5

    .line 1800
    .local v5, "e":Ljava/lang/Exception;
    :try_start_2
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_1

    .line 1805
    .end local v5    # "e":Ljava/lang/Exception;
    .end local v7    # "zipFile":Lnet/lingala/zip4j/core/ZipFile;
    :catch_1
    move-exception v5

    .line 1807
    .restart local v5    # "e":Ljava/lang/Exception;
    invoke-virtual {v5}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1
.end method
