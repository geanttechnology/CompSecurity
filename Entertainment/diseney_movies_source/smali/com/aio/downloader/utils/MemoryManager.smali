.class public Lcom/aio/downloader/utils/MemoryManager;
.super Ljava/lang/Object;
.source "MemoryManager.java"


# instance fields
.field private context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/aio/downloader/utils/MemoryManager;->context:Landroid/content/Context;

    .line 19
    return-void
.end method

.method private getFreeSize(Ljava/lang/String;)J
    .locals 6
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 72
    new-instance v3, Landroid/os/StatFs;

    invoke-direct {v3, p1}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 73
    .local v3, "statFs":Landroid/os/StatFs;
    invoke-virtual {v3}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v4

    int-to-long v0, v4

    .line 74
    .local v0, "count":J
    invoke-virtual {v3}, Landroid/os/StatFs;->getBlockSize()I

    move-result v2

    .line 75
    .local v2, "size":I
    int-to-long v4, v2

    mul-long/2addr v4, v0

    return-wide v4
.end method

.method private getTotalSize(Ljava/lang/String;)J
    .locals 6
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 65
    new-instance v3, Landroid/os/StatFs;

    invoke-direct {v3, p1}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 66
    .local v3, "statFs":Landroid/os/StatFs;
    invoke-virtual {v3}, Landroid/os/StatFs;->getBlockCount()I

    move-result v4

    int-to-long v0, v4

    .line 67
    .local v0, "count":J
    invoke-virtual {v3}, Landroid/os/StatFs;->getBlockSize()I

    move-result v2

    .line 68
    .local v2, "size":I
    int-to-long v4, v2

    mul-long/2addr v4, v0

    return-wide v4
.end method


# virtual methods
.method public clearMemory()I
    .locals 7

    .prologue
    .line 52
    const/4 v2, 0x0

    .line 53
    .local v2, "count":I
    iget-object v4, p0, Lcom/aio/downloader/utils/MemoryManager;->context:Landroid/content/Context;

    const-string v5, "activity"

    invoke-virtual {v4, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 54
    .local v0, "am":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v3

    .line 55
    .local v3, "list":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_1

    .line 61
    return v2

    .line 55
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 56
    .local v1, "app":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v5, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v6, 0x12c

    if-lt v5, v6, :cond_0

    .line 57
    iget-object v5, v1, Landroid/app/ActivityManager$RunningAppProcessInfo;->processName:Ljava/lang/String;

    invoke-virtual {v0, v5}, Landroid/app/ActivityManager;->killBackgroundProcesses(Ljava/lang/String;)V

    .line 58
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public getAvailMemory()J
    .locals 4

    .prologue
    .line 44
    iget-object v2, p0, Lcom/aio/downloader/utils/MemoryManager;->context:Landroid/content/Context;

    const-string v3, "activity"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 45
    .local v0, "am":Landroid/app/ActivityManager;
    new-instance v1, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v1}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 46
    .local v1, "outInfo":Landroid/app/ActivityManager$MemoryInfo;
    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 47
    iget-wide v2, v1, Landroid/app/ActivityManager$MemoryInfo;->availMem:J

    return-wide v2
.end method

.method public getPhoneFreeSize()J
    .locals 3

    .prologue
    .line 89
    invoke-static {}, Landroid/os/Environment;->getRootDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 90
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/aio/downloader/utils/MemoryManager;->getFreeSize(Ljava/lang/String;)J

    move-result-wide v1

    return-wide v1
.end method

.method public getPhoneTotalSize()J
    .locals 7

    .prologue
    .line 80
    invoke-static {}, Landroid/os/Environment;->getRootDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "path":Ljava/lang/String;
    invoke-static {}, Landroid/os/Environment;->getDataDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    .line 84
    .local v1, "path2":Ljava/lang/String;
    invoke-static {}, Landroid/os/Environment;->getDownloadCacheDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    .line 85
    .local v2, "path3":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/aio/downloader/utils/MemoryManager;->getTotalSize(Ljava/lang/String;)J

    move-result-wide v3

    invoke-direct {p0, v1}, Lcom/aio/downloader/utils/MemoryManager;->getTotalSize(Ljava/lang/String;)J

    move-result-wide v5

    add-long/2addr v3, v5

    invoke-direct {p0, v2}, Lcom/aio/downloader/utils/MemoryManager;->getTotalSize(Ljava/lang/String;)J

    move-result-wide v5

    add-long/2addr v3, v5

    return-wide v3
.end method

.method public getSDFreeSize()J
    .locals 3

    .prologue
    .line 103
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    const-string v2, "mounted"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 104
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/aio/downloader/utils/MemoryManager;->getFreeSize(Ljava/lang/String;)J

    move-result-wide v1

    .line 107
    .end local v0    # "path":Ljava/lang/String;
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public getSDTotalSize()J
    .locals 3

    .prologue
    .line 94
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v1

    const-string v2, "mounted"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 95
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    .line 96
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/aio/downloader/utils/MemoryManager;->getTotalSize(Ljava/lang/String;)J

    move-result-wide v1

    .line 98
    .end local v0    # "path":Ljava/lang/String;
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public getSecondSDFreeSize()J
    .locals 6

    .prologue
    .line 123
    invoke-static {}, Ljava/lang/System;->getenv()Ljava/util/Map;

    move-result-object v0

    .line 124
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "SECONDARY_STORAGE"

    invoke-interface {v0, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 125
    const-string v4, "SECONDARY_STORAGE"

    invoke-interface {v0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 126
    .local v2, "value":Ljava/lang/String;
    const-string v4, ":"

    invoke-virtual {v2, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 127
    .local v3, "values":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v1, v3, v4

    .line 128
    .local v1, "path":Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/aio/downloader/utils/MemoryManager;->getFreeSize(Ljava/lang/String;)J

    move-result-wide v4

    .line 130
    .end local v1    # "path":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    .end local v3    # "values":[Ljava/lang/String;
    :goto_0
    return-wide v4

    :cond_0
    const-wide/16 v4, 0x0

    goto :goto_0
.end method

.method public getSecondSDTotalSize()J
    .locals 6

    .prologue
    .line 112
    invoke-static {}, Ljava/lang/System;->getenv()Ljava/util/Map;

    move-result-object v0

    .line 113
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "SECONDARY_STORAGE"

    invoke-interface {v0, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 114
    const-string v4, "SECONDARY_STORAGE"

    invoke-interface {v0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 115
    .local v2, "value":Ljava/lang/String;
    const-string v4, ":"

    invoke-virtual {v2, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 116
    .local v3, "values":[Ljava/lang/String;
    const/4 v4, 0x0

    aget-object v1, v3, v4

    .line 117
    .local v1, "path":Ljava/lang/String;
    invoke-direct {p0, v1}, Lcom/aio/downloader/utils/MemoryManager;->getTotalSize(Ljava/lang/String;)J

    move-result-wide v4

    .line 119
    .end local v1    # "path":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    .end local v3    # "values":[Ljava/lang/String;
    :goto_0
    return-wide v4

    :cond_0
    const-wide/16 v4, 0x0

    goto :goto_0
.end method

.method public totalMemory()J
    .locals 8

    .prologue
    .line 22
    const/4 v0, 0x0

    .line 24
    .local v0, "bf":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v3, Ljava/io/FileReader;

    const-string v6, "/proc/meminfo"

    invoke-direct {v3, v6}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    .line 25
    .local v3, "r":Ljava/io/FileReader;
    new-instance v1, Ljava/io/BufferedReader;

    invoke-direct {v1, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 26
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .local v1, "bf":Ljava/io/BufferedReader;
    :try_start_1
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .line 27
    .local v4, "re":Ljava/lang/String;
    const-string v6, "\\s+"

    invoke-virtual {v4, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 28
    .local v5, "res":[Ljava/lang/String;
    const/4 v6, 0x1

    aget-object v6, v5, v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result v6

    mul-int/lit16 v6, v6, 0x400

    int-to-long v6, v6

    .line 32
    if-eqz v1, :cond_0

    .line 34
    :try_start_2
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    :cond_0
    :goto_0
    move-object v0, v1

    .line 40
    .end local v1    # "bf":Ljava/io/BufferedReader;
    .end local v3    # "r":Ljava/io/FileReader;
    .end local v4    # "re":Ljava/lang/String;
    .end local v5    # "res":[Ljava/lang/String;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    :goto_1
    return-wide v6

    .line 35
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .restart local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v3    # "r":Ljava/io/FileReader;
    .restart local v4    # "re":Ljava/lang/String;
    .restart local v5    # "res":[Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 36
    .local v2, "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 29
    .end local v1    # "bf":Ljava/io/BufferedReader;
    .end local v2    # "e":Ljava/io/IOException;
    .end local v3    # "r":Ljava/io/FileReader;
    .end local v4    # "re":Ljava/lang/String;
    .end local v5    # "res":[Ljava/lang/String;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    :catch_1
    move-exception v2

    .line 30
    .restart local v2    # "e":Ljava/io/IOException;
    :goto_2
    :try_start_3
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 32
    if-eqz v0, :cond_1

    .line 34
    :try_start_4
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 40
    :cond_1
    :goto_3
    const-wide/16 v6, 0x0

    goto :goto_1

    .line 35
    :catch_2
    move-exception v2

    .line 36
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_3

    .line 31
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v6

    .line 32
    :goto_4
    if-eqz v0, :cond_2

    .line 34
    :try_start_5
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 39
    :cond_2
    :goto_5
    throw v6

    .line 35
    :catch_3
    move-exception v2

    .line 36
    .restart local v2    # "e":Ljava/io/IOException;
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_5

    .line 31
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .end local v2    # "e":Ljava/io/IOException;
    .restart local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v3    # "r":Ljava/io/FileReader;
    :catchall_1
    move-exception v6

    move-object v0, v1

    .end local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    goto :goto_4

    .line 29
    .end local v0    # "bf":Ljava/io/BufferedReader;
    .restart local v1    # "bf":Ljava/io/BufferedReader;
    :catch_4
    move-exception v2

    move-object v0, v1

    .end local v1    # "bf":Ljava/io/BufferedReader;
    .restart local v0    # "bf":Ljava/io/BufferedReader;
    goto :goto_2
.end method
