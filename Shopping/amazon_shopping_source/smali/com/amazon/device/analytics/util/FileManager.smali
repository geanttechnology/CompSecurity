.class public Lcom/amazon/device/analytics/util/FileManager;
.super Ljava/lang/Object;
.source "FileManager.java"


# static fields
.field private static instance:Lcom/amazon/device/analytics/util/FileManager;

.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/amazon/device/analytics/util/FileManager;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/util/FileManager;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/device/analytics/util/FileManager;
    .locals 2

    .prologue
    .line 29
    const-class v1, Lcom/amazon/device/analytics/util/FileManager;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/device/analytics/util/FileManager;->instance:Lcom/amazon/device/analytics/util/FileManager;

    if-nez v0, :cond_0

    .line 30
    new-instance v0, Lcom/amazon/device/analytics/util/FileManager;

    invoke-direct {v0}, Lcom/amazon/device/analytics/util/FileManager;-><init>()V

    sput-object v0, Lcom/amazon/device/analytics/util/FileManager;->instance:Lcom/amazon/device/analytics/util/FileManager;

    .line 33
    :cond_0
    sget-object v0, Lcom/amazon/device/analytics/util/FileManager;->instance:Lcom/amazon/device/analytics/util/FileManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method


# virtual methods
.method public createFile(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    .locals 6
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "filename"    # Ljava/lang/String;

    .prologue
    .line 70
    const/4 v2, 0x0

    .line 72
    .local v2, "file":Ljava/io/File;
    :try_start_0
    new-instance v0, Ljava/io/File;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    invoke-direct {v0, v4, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 73
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 74
    :cond_0
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v0, p2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v2    # "file":Ljava/io/File;
    .local v3, "file":Ljava/io/File;
    move-object v2, v3

    .line 79
    .end local v0    # "dir":Ljava/io/File;
    .end local v3    # "file":Ljava/io/File;
    .restart local v2    # "file":Ljava/io/File;
    :cond_1
    :goto_0
    return-object v2

    .line 76
    :catch_0
    move-exception v1

    .line 77
    .local v1, "ex":Ljava/lang/Exception;
    sget-object v4, Lcom/amazon/device/analytics/util/FileManager;->logger:Lcom/amazon/device/analytics/log/Logger;

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v1}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public isExternalStoragePresent()Z
    .locals 2

    .prologue
    .line 113
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    .line 114
    .local v0, "state":Ljava/lang/String;
    const-string/jumbo v1, "mounted"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "mounted_ro"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 116
    :cond_0
    const/4 v1, 0x1

    .line 119
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isExternalStorageWritable()Z
    .locals 2

    .prologue
    .line 123
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    .line 124
    .local v0, "state":Ljava/lang/String;
    const-string/jumbo v1, "mounted"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 126
    const/4 v1, 0x1

    .line 128
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public readFileContents(Ljava/io/File;)Ljava/lang/String;
    .locals 10
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 37
    if-nez p1, :cond_1

    .line 38
    const/4 v3, 0x0

    .line 66
    :cond_0
    :goto_0
    return-object v3

    .line 41
    :cond_1
    const/4 v0, 0x0

    .line 42
    .local v0, "bufferedReader":Ljava/io/BufferedReader;
    const/4 v3, 0x0

    .line 44
    .local v3, "contents":Ljava/lang/String;
    :try_start_0
    new-instance v5, Ljava/io/FileReader;

    invoke-direct {v5, p1}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    .line 45
    .local v5, "fReader":Ljava/io/FileReader;
    new-instance v1, Ljava/io/BufferedReader;

    invoke-direct {v1, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 48
    .end local v0    # "bufferedReader":Ljava/io/BufferedReader;
    .local v1, "bufferedReader":Ljava/io/BufferedReader;
    :try_start_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 49
    .local v2, "builder":Ljava/lang/StringBuilder;
    :goto_1
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v6

    .local v6, "readLine":Ljava/lang/String;
    if-eqz v6, :cond_2

    .line 50
    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    .line 54
    .end local v2    # "builder":Ljava/lang/StringBuilder;
    .end local v6    # "readLine":Ljava/lang/String;
    :catch_0
    move-exception v4

    move-object v0, v1

    .line 55
    .end local v1    # "bufferedReader":Ljava/io/BufferedReader;
    .end local v5    # "fReader":Ljava/io/FileReader;
    .restart local v0    # "bufferedReader":Ljava/io/BufferedReader;
    .local v4, "e":Ljava/lang/Exception;
    :goto_2
    :try_start_2
    sget-object v7, Lcom/amazon/device/analytics/util/FileManager;->logger:Lcom/amazon/device/analytics/log/Logger;

    invoke-virtual {v4}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 58
    if-eqz v0, :cond_0

    .line 59
    :try_start_3
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 61
    :catch_1
    move-exception v4

    .line 62
    .local v4, "e":Ljava/io/IOException;
    sget-object v7, Lcom/amazon/device/analytics/util/FileManager;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v8, "Error closing bufferedReader"

    invoke-virtual {v7, v8, v4}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 53
    .end local v0    # "bufferedReader":Ljava/io/BufferedReader;
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v1    # "bufferedReader":Ljava/io/BufferedReader;
    .restart local v2    # "builder":Ljava/lang/StringBuilder;
    .restart local v5    # "fReader":Ljava/io/FileReader;
    .restart local v6    # "readLine":Ljava/lang/String;
    :cond_2
    :try_start_4
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result-object v3

    .line 58
    if-eqz v1, :cond_3

    .line 59
    :try_start_5
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_2

    :cond_3
    move-object v0, v1

    .line 63
    .end local v1    # "bufferedReader":Ljava/io/BufferedReader;
    .restart local v0    # "bufferedReader":Ljava/io/BufferedReader;
    goto :goto_0

    .line 61
    .end local v0    # "bufferedReader":Ljava/io/BufferedReader;
    .restart local v1    # "bufferedReader":Ljava/io/BufferedReader;
    :catch_2
    move-exception v4

    .line 62
    .restart local v4    # "e":Ljava/io/IOException;
    sget-object v7, Lcom/amazon/device/analytics/util/FileManager;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v8, "Error closing bufferedReader"

    invoke-virtual {v7, v8, v4}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v0, v1

    .line 64
    .end local v1    # "bufferedReader":Ljava/io/BufferedReader;
    .restart local v0    # "bufferedReader":Ljava/io/BufferedReader;
    goto :goto_0

    .line 57
    .end local v2    # "builder":Ljava/lang/StringBuilder;
    .end local v4    # "e":Ljava/io/IOException;
    .end local v5    # "fReader":Ljava/io/FileReader;
    .end local v6    # "readLine":Ljava/lang/String;
    :catchall_0
    move-exception v7

    .line 58
    :goto_3
    if-eqz v0, :cond_4

    .line 59
    :try_start_6
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_3

    .line 63
    :cond_4
    :goto_4
    throw v7

    .line 61
    :catch_3
    move-exception v4

    .line 62
    .restart local v4    # "e":Ljava/io/IOException;
    sget-object v8, Lcom/amazon/device/analytics/util/FileManager;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v9, "Error closing bufferedReader"

    invoke-virtual {v8, v9, v4}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4

    .line 57
    .end local v0    # "bufferedReader":Ljava/io/BufferedReader;
    .end local v4    # "e":Ljava/io/IOException;
    .restart local v1    # "bufferedReader":Ljava/io/BufferedReader;
    .restart local v5    # "fReader":Ljava/io/FileReader;
    :catchall_1
    move-exception v7

    move-object v0, v1

    .end local v1    # "bufferedReader":Ljava/io/BufferedReader;
    .restart local v0    # "bufferedReader":Ljava/io/BufferedReader;
    goto :goto_3

    .line 54
    .end local v5    # "fReader":Ljava/io/FileReader;
    :catch_4
    move-exception v4

    goto :goto_2
.end method

.method public writeFileContents(Ljava/io/File;Ljava/lang/String;)Z
    .locals 7
    .param p1, "file"    # Ljava/io/File;
    .param p2, "contents"    # Ljava/lang/String;

    .prologue
    .line 83
    if-nez p1, :cond_1

    .line 84
    const/4 v4, 0x0

    .line 108
    :cond_0
    :goto_0
    return v4

    .line 87
    :cond_1
    const/4 v0, 0x0

    .line 88
    .local v0, "bufferedWriter":Ljava/io/BufferedWriter;
    const/4 v4, 0x0

    .line 90
    .local v4, "success":Z
    :try_start_0
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v5

    if-nez v5, :cond_2

    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 91
    :cond_2
    new-instance v3, Ljava/io/FileWriter;

    invoke-direct {v3, p1}, Ljava/io/FileWriter;-><init>(Ljava/io/File;)V

    .line 92
    .local v3, "fWriter":Ljava/io/FileWriter;
    new-instance v1, Ljava/io/BufferedWriter;

    invoke-direct {v1, v3}, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 93
    .end local v0    # "bufferedWriter":Ljava/io/BufferedWriter;
    .local v1, "bufferedWriter":Ljava/io/BufferedWriter;
    :try_start_1
    invoke-virtual {v1, p2}, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 94
    const/4 v4, 0x1

    move-object v0, v1

    .line 100
    .end local v1    # "bufferedWriter":Ljava/io/BufferedWriter;
    .end local v3    # "fWriter":Ljava/io/FileWriter;
    .restart local v0    # "bufferedWriter":Ljava/io/BufferedWriter;
    :cond_3
    if-eqz v0, :cond_0

    .line 101
    :try_start_2
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 103
    :catch_0
    move-exception v5

    goto :goto_0

    .line 96
    :catch_1
    move-exception v2

    .line 97
    .local v2, "e":Ljava/lang/Exception;
    :goto_1
    :try_start_3
    sget-object v5, Lcom/amazon/device/analytics/util/FileManager;->logger:Lcom/amazon/device/analytics/log/Logger;

    invoke-virtual {v2}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 100
    if-eqz v0, :cond_0

    .line 101
    :try_start_4
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_0

    .line 103
    :catch_2
    move-exception v5

    goto :goto_0

    .line 99
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    .line 100
    :goto_2
    if-eqz v0, :cond_4

    .line 101
    :try_start_5
    invoke-virtual {v0}, Ljava/io/BufferedWriter;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 105
    :cond_4
    :goto_3
    throw v5

    .line 103
    :catch_3
    move-exception v6

    goto :goto_3

    .line 99
    .end local v0    # "bufferedWriter":Ljava/io/BufferedWriter;
    .restart local v1    # "bufferedWriter":Ljava/io/BufferedWriter;
    .restart local v3    # "fWriter":Ljava/io/FileWriter;
    :catchall_1
    move-exception v5

    move-object v0, v1

    .end local v1    # "bufferedWriter":Ljava/io/BufferedWriter;
    .restart local v0    # "bufferedWriter":Ljava/io/BufferedWriter;
    goto :goto_2

    .line 96
    .end local v0    # "bufferedWriter":Ljava/io/BufferedWriter;
    .restart local v1    # "bufferedWriter":Ljava/io/BufferedWriter;
    :catch_4
    move-exception v2

    move-object v0, v1

    .end local v1    # "bufferedWriter":Ljava/io/BufferedWriter;
    .restart local v0    # "bufferedWriter":Ljava/io/BufferedWriter;
    goto :goto_1
.end method
