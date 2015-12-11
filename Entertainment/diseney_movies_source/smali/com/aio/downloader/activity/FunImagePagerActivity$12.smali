.class Lcom/aio/downloader/activity/FunImagePagerActivity$12;
.super Ljava/lang/Object;
.source "FunImagePagerActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;->getImage(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

.field private final synthetic val$uri:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    iput-object p2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->val$uri:Ljava/lang/String;

    .line 704
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 16

    .prologue
    .line 707
    const/4 v11, 0x0

    .line 709
    .local v11, "url":Ljava/net/URL;
    :try_start_0
    new-instance v12, Ljava/net/URL;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->val$uri:Ljava/lang/String;

    invoke-direct {v12, v13}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v11    # "url":Ljava/net/URL;
    .local v12, "url":Ljava/net/URL;
    move-object v11, v12

    .line 716
    .end local v12    # "url":Ljava/net/URL;
    .restart local v11    # "url":Ljava/net/URL;
    :goto_0
    const/4 v3, 0x0

    .line 717
    .local v3, "conn":Ljava/net/HttpURLConnection;
    const/4 v8, 0x0

    .line 718
    .local v8, "is":Ljava/io/InputStream;
    :try_start_1
    invoke-virtual {v11}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v13

    move-object v0, v13

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v3, v0

    .line 719
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->connect()V

    .line 720
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    .line 721
    new-instance v1, Ljava/io/File;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    .line 722
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    .line 723
    const-string v14, "/"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    .line 724
    const-string v14, "AIO_PICTURE"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "/"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->picture_name:Ljava/lang/String;
    invoke-static {v14}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ".jpg"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 721
    invoke-direct {v1, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 725
    .local v1, "bufFile":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v13

    invoke-virtual {v13}, Ljava/io/File;->exists()Z

    move-result v13

    if-nez v13, :cond_0

    .line 726
    invoke-virtual {v1}, Ljava/io/File;->getParentFile()Ljava/io/File;

    move-result-object v13

    invoke-virtual {v13}, Ljava/io/File;->mkdirs()Z

    .line 727
    :cond_0
    invoke-virtual {v1}, Ljava/io/File;->exists()Z
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    move-result v13

    if-nez v13, :cond_1

    .line 729
    :try_start_2
    invoke-virtual {v1}, Ljava/io/File;->createNewFile()Z
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 738
    :cond_1
    :goto_1
    :try_start_3
    new-instance v7, Ljava/io/FileOutputStream;

    invoke-direct {v7, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 739
    .local v7, "fos":Ljava/io/FileOutputStream;
    const/16 v13, 0x400

    new-array v2, v13, [B

    .line 740
    .local v2, "buffer":[B
    const/4 v4, 0x0

    .line 741
    .local v4, "count":I
    :goto_2
    invoke-virtual {v8, v2}, Ljava/io/InputStream;->read([B)I

    move-result v4

    if-gtz v4, :cond_3

    .line 745
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->flush()V

    .line 746
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V

    .line 747
    invoke-virtual {v8}, Ljava/io/InputStream;->close()V

    .line 748
    invoke-virtual {v3}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 749
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 750
    .local v6, "fis":Ljava/io/FileInputStream;
    new-instance v10, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v10}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 751
    .local v10, "options":Landroid/graphics/BitmapFactory$Options;
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-static {v6}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v14

    invoke-static {v13, v14}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$20(Lcom/aio/downloader/activity/FunImagePagerActivity;Landroid/graphics/Bitmap;)V

    .line 752
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V

    .line 754
    new-instance v9, Landroid/os/Message;

    invoke-direct {v9}, Landroid/os/Message;-><init>()V

    .line 755
    .local v9, "msg":Landroid/os/Message;
    const/4 v13, 0x1

    iput v13, v9, Landroid/os/Message;->what:I

    .line 756
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->handler:Landroid/os/Handler;
    invoke-static {v13}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$21(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/os/Handler;

    move-result-object v13

    invoke-virtual {v13, v9}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z
    :try_end_3
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4

    .line 774
    .end local v1    # "bufFile":Ljava/io/File;
    .end local v2    # "buffer":[B
    .end local v4    # "count":I
    .end local v6    # "fis":Ljava/io/FileInputStream;
    .end local v7    # "fos":Ljava/io/FileOutputStream;
    .end local v9    # "msg":Landroid/os/Message;
    .end local v10    # "options":Landroid/graphics/BitmapFactory$Options;
    :cond_2
    :goto_3
    return-void

    .line 710
    .end local v3    # "conn":Ljava/net/HttpURLConnection;
    .end local v8    # "is":Ljava/io/InputStream;
    :catch_0
    move-exception v5

    .line 711
    .local v5, "e":Ljava/net/MalformedURLException;
    invoke-virtual {v5}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto/16 :goto_0

    .line 730
    .end local v5    # "e":Ljava/net/MalformedURLException;
    .restart local v1    # "bufFile":Ljava/io/File;
    .restart local v3    # "conn":Ljava/net/HttpURLConnection;
    .restart local v8    # "is":Ljava/io/InputStream;
    :catch_1
    move-exception v5

    .line 734
    .local v5, "e":Ljava/io/IOException;
    :try_start_4
    invoke-virtual {v5}, Ljava/io/IOException;->printStackTrace()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_1

    .line 768
    .end local v1    # "bufFile":Ljava/io/File;
    .end local v5    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v5

    .line 770
    .restart local v5    # "e":Ljava/io/IOException;
    invoke-virtual {v5}, Ljava/io/IOException;->printStackTrace()V

    .line 771
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->handler:Landroid/os/Handler;
    invoke-static {v13}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$21(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/os/Handler;

    move-result-object v13

    const/4 v14, 0x3

    invoke-virtual {v13, v14}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_3

    .line 742
    .end local v5    # "e":Ljava/io/IOException;
    .restart local v1    # "bufFile":Ljava/io/File;
    .restart local v2    # "buffer":[B
    .restart local v4    # "count":I
    .restart local v7    # "fos":Ljava/io/FileOutputStream;
    :cond_3
    :try_start_5
    sget-object v13, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v14, Ljava/lang/StringBuilder;

    const-string v15, "ffd "

    invoke-direct {v14, v15}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v14, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 743
    const/4 v13, 0x0

    invoke-virtual {v7, v2, v13, v4}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_5
    .catch Ljava/io/FileNotFoundException; {:try_start_5 .. :try_end_5} :catch_3
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_4

    goto :goto_2

    .line 757
    .end local v2    # "buffer":[B
    .end local v4    # "count":I
    .end local v7    # "fos":Ljava/io/FileOutputStream;
    :catch_3
    move-exception v5

    .line 759
    .local v5, "e":Ljava/io/FileNotFoundException;
    :try_start_6
    invoke-virtual {v5}, Ljava/io/FileNotFoundException;->printStackTrace()V

    .line 760
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/aio/downloader/activity/FunImagePagerActivity$12;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->handler:Landroid/os/Handler;
    invoke-static {v13}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$21(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/os/Handler;

    move-result-object v13

    const/4 v14, 0x2

    invoke-virtual {v13, v14}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_3

    .line 761
    .end local v5    # "e":Ljava/io/FileNotFoundException;
    :catch_4
    move-exception v5

    .line 762
    .local v5, "e":Ljava/io/IOException;
    invoke-virtual {v5}, Ljava/io/IOException;->printStackTrace()V

    .line 765
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v13

    if-eqz v13, :cond_2

    .line 766
    invoke-virtual {v1}, Ljava/io/File;->delete()Z
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    goto :goto_3
.end method
