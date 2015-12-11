.class public Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader;
.super Ljava/lang/Object;
.source "SimpleHttpDownloader.java"

# interfaces
.implements Lnet/tsz/afinal/bitmap/download/Downloader;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    }
.end annotation


# static fields
.field private static final IO_BUFFER_SIZE:I = 0x2000

.field private static final TAG:Ljava/lang/String; = "BitmapDownloader"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public downloadToLocalStreamByUrl(Ljava/lang/String;Ljava/io/OutputStream;)Z
    .locals 12
    .param p1, "urlString"    # Ljava/lang/String;
    .param p2, "outputStream"    # Ljava/io/OutputStream;

    .prologue
    .line 43
    const/4 v8, 0x0

    .line 44
    .local v8, "urlConnection":Ljava/net/HttpURLConnection;
    const/4 v5, 0x0

    .line 45
    .local v5, "out":Ljava/io/BufferedOutputStream;
    const/4 v3, 0x0

    .line 48
    .local v3, "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    :try_start_0
    new-instance v7, Ljava/net/URL;

    invoke-direct {v7, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 49
    .local v7, "url":Ljava/net/URL;
    invoke-virtual {v7}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v9

    move-object v0, v9

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v8, v0

    .line 50
    new-instance v4, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;

    new-instance v9, Ljava/io/BufferedInputStream;

    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v10

    const/16 v11, 0x2000

    invoke-direct {v9, v10, v11}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    invoke-direct {v4, p0, v9}, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;-><init>(Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader;Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 51
    .end local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .local v4, "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    :try_start_1
    new-instance v6, Ljava/io/BufferedOutputStream;

    const/16 v9, 0x2000

    invoke-direct {v6, p2, v9}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 54
    .end local v5    # "out":Ljava/io/BufferedOutputStream;
    .local v6, "out":Ljava/io/BufferedOutputStream;
    :goto_0
    :try_start_2
    invoke-virtual {v4}, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;->read()I
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result v1

    .local v1, "b":I
    const/4 v9, -0x1

    if-ne v1, v9, :cond_3

    .line 61
    if-eqz v8, :cond_0

    .line 62
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 65
    :cond_0
    if-eqz v6, :cond_1

    .line 66
    :try_start_3
    invoke-virtual {v6}, Ljava/io/BufferedOutputStream;->close()V

    .line 68
    :cond_1
    if-eqz v4, :cond_2

    .line 69
    invoke-virtual {v4}, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_5

    .line 57
    :cond_2
    :goto_1
    const/4 v9, 0x1

    move-object v3, v4

    .end local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    move-object v5, v6

    .line 73
    .end local v1    # "b":I
    .end local v6    # "out":Ljava/io/BufferedOutputStream;
    .end local v7    # "url":Ljava/net/URL;
    .restart local v5    # "out":Ljava/io/BufferedOutputStream;
    :goto_2
    return v9

    .line 55
    .end local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .end local v5    # "out":Ljava/io/BufferedOutputStream;
    .restart local v1    # "b":I
    .restart local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v6    # "out":Ljava/io/BufferedOutputStream;
    .restart local v7    # "url":Ljava/net/URL;
    :cond_3
    :try_start_4
    invoke-virtual {v6, v1}, Ljava/io/BufferedOutputStream;->write(I)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    goto :goto_0

    .line 58
    .end local v1    # "b":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .end local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    move-object v5, v6

    .line 59
    .end local v6    # "out":Ljava/io/BufferedOutputStream;
    .end local v7    # "url":Ljava/net/URL;
    .local v2, "e":Ljava/io/IOException;
    .restart local v5    # "out":Ljava/io/BufferedOutputStream;
    :goto_3
    :try_start_5
    const-string v9, "BitmapDownloader"

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Error in downloadBitmap - "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, " : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 61
    if-eqz v8, :cond_4

    .line 62
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 65
    :cond_4
    if-eqz v5, :cond_5

    .line 66
    :try_start_6
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->close()V

    .line 68
    :cond_5
    if-eqz v3, :cond_6

    .line 69
    invoke-virtual {v3}, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    .line 73
    :cond_6
    :goto_4
    const/4 v9, 0x0

    goto :goto_2

    .line 60
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v9

    .line 61
    :goto_5
    if-eqz v8, :cond_7

    .line 62
    invoke-virtual {v8}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 65
    :cond_7
    if-eqz v5, :cond_8

    .line 66
    :try_start_7
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->close()V

    .line 68
    :cond_8
    if-eqz v3, :cond_9

    .line 69
    invoke-virtual {v3}, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1

    .line 72
    :cond_9
    :goto_6
    throw v9

    .line 71
    :catch_1
    move-exception v10

    goto :goto_6

    .line 60
    .end local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v7    # "url":Ljava/net/URL;
    :catchall_1
    move-exception v9

    move-object v3, v4

    .end local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    goto :goto_5

    .end local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .end local v5    # "out":Ljava/io/BufferedOutputStream;
    .restart local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v6    # "out":Ljava/io/BufferedOutputStream;
    :catchall_2
    move-exception v9

    move-object v3, v4

    .end local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    move-object v5, v6

    .end local v6    # "out":Ljava/io/BufferedOutputStream;
    .restart local v5    # "out":Ljava/io/BufferedOutputStream;
    goto :goto_5

    .line 71
    .end local v7    # "url":Ljava/net/URL;
    .restart local v2    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v9

    goto :goto_4

    .line 58
    .end local v2    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v2

    goto :goto_3

    .end local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v7    # "url":Ljava/net/URL;
    :catch_4
    move-exception v2

    move-object v3, v4

    .end local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    goto :goto_3

    .line 71
    .end local v3    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .end local v5    # "out":Ljava/io/BufferedOutputStream;
    .restart local v1    # "b":I
    .restart local v4    # "in":Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream;
    .restart local v6    # "out":Ljava/io/BufferedOutputStream;
    :catch_5
    move-exception v9

    goto :goto_1
.end method
