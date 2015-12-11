.class public Lcom/aio/downloader/utils/AndroidRunable;
.super Ljava/lang/Object;
.source "AndroidRunable.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field socket:Ljava/net/Socket;


# direct methods
.method public constructor <init>(Ljava/net/Socket;)V
    .locals 1
    .param p1, "socket"    # Ljava/net/Socket;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/utils/AndroidRunable;->socket:Ljava/net/Socket;

    .line 18
    iput-object p1, p0, Lcom/aio/downloader/utils/AndroidRunable;->socket:Ljava/net/Socket;

    .line 19
    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 24
    const/4 v3, 0x0

    .line 27
    .local v3, "line":Ljava/lang/String;
    const-string v5, "aio"

    .line 30
    .local v5, "str":Ljava/lang/String;
    :try_start_0
    iget-object v6, p0, Lcom/aio/downloader/utils/AndroidRunable;->socket:Ljava/net/Socket;

    invoke-virtual {v6}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v4

    .line 31
    .local v4, "output":Ljava/io/OutputStream;
    iget-object v6, p0, Lcom/aio/downloader/utils/AndroidRunable;->socket:Ljava/net/Socket;

    invoke-virtual {v6}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    .line 32
    .local v2, "input":Ljava/io/InputStream;
    new-instance v0, Ljava/io/BufferedReader;

    .line 33
    new-instance v6, Ljava/io/InputStreamReader;

    invoke-direct {v6, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 32
    invoke-direct {v0, v6}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 34
    .local v0, "bff":Ljava/io/BufferedReader;
    const-string v6, "gbk"

    invoke-virtual {v5, v6}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/io/OutputStream;->write([B)V

    .line 35
    invoke-virtual {v4}, Ljava/io/OutputStream;->flush()V

    .line 37
    iget-object v6, p0, Lcom/aio/downloader/utils/AndroidRunable;->socket:Ljava/net/Socket;

    invoke-virtual {v6}, Ljava/net/Socket;->shutdownOutput()V

    .line 39
    :goto_0
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_0

    .line 44
    invoke-virtual {v4}, Ljava/io/OutputStream;->close()V

    .line 45
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 46
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V

    .line 47
    iget-object v6, p0, Lcom/aio/downloader/utils/AndroidRunable;->socket:Ljava/net/Socket;

    invoke-virtual {v6}, Ljava/net/Socket;->close()V

    .line 52
    .end local v0    # "bff":Ljava/io/BufferedReader;
    .end local v2    # "input":Ljava/io/InputStream;
    .end local v4    # "output":Ljava/io/OutputStream;
    :goto_1
    return-void

    .line 40
    .restart local v0    # "bff":Ljava/io/BufferedReader;
    .restart local v2    # "input":Ljava/io/InputStream;
    .restart local v4    # "output":Ljava/io/OutputStream;
    :cond_0
    sget-object v6, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v6, v3}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 41
    const-string v6, "gak"

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "socket="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 49
    .end local v0    # "bff":Ljava/io/BufferedReader;
    .end local v2    # "input":Ljava/io/InputStream;
    .end local v4    # "output":Ljava/io/OutputStream;
    :catch_0
    move-exception v1

    .line 50
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1
.end method
