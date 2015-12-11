.class public Lcom/amazon/mShop/android/platform/dex/DexUtils;
.super Ljava/lang/Object;
.source "DexUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static appIsUpdated(Landroid/content/Context;)Z
    .locals 14
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 209
    :try_start_0
    const-string/jumbo v11, "app_dependencies_update"

    const/4 v12, 0x0

    invoke-virtual {p0, v11, v12}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v8

    .line 210
    .local v8, "prefs":Landroid/content/SharedPreferences;
    const-string/jumbo v11, "lastUpdate"

    const-wide/16 v12, 0x0

    invoke-interface {v8, v11, v12, v13}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v5

    .line 211
    .local v5, "lastUpdated":J
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    .line 212
    .local v7, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x0

    invoke-virtual {v7, v11, v12}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 213
    .local v1, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v0, v1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 214
    .local v0, "appFile":Ljava/lang/String;
    new-instance v11, Ljava/io/File;

    invoke-direct {v11, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11}, Ljava/io/File;->lastModified()J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v3

    .line 216
    .local v3, "installed":J
    cmp-long v11, v3, v5

    if-lez v11, :cond_0

    .line 221
    .end local v0    # "appFile":Ljava/lang/String;
    .end local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v3    # "installed":J
    .end local v5    # "lastUpdated":J
    .end local v7    # "pm":Landroid/content/pm/PackageManager;
    .end local v8    # "prefs":Landroid/content/SharedPreferences;
    :goto_0
    return v9

    .restart local v0    # "appFile":Ljava/lang/String;
    .restart local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v3    # "installed":J
    .restart local v5    # "lastUpdated":J
    .restart local v7    # "pm":Landroid/content/pm/PackageManager;
    .restart local v8    # "prefs":Landroid/content/SharedPreferences;
    :cond_0
    move v9, v10

    .line 216
    goto :goto_0

    .line 217
    .end local v0    # "appFile":Ljava/lang/String;
    .end local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v3    # "installed":J
    .end local v5    # "lastUpdated":J
    .end local v7    # "pm":Landroid/content/pm/PackageManager;
    .end local v8    # "prefs":Landroid/content/SharedPreferences;
    :catch_0
    move-exception v2

    .line 221
    .local v2, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public static copyJarAndOptimize(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 16
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 141
    new-instance v4, Ljava/io/File;

    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->getDexOutputDir(Landroid/content/Context;)Ljava/io/File;

    move-result-object v12

    move-object/from16 v0, p1

    invoke-direct {v4, v12, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 142
    .local v4, "dexOut":Ljava/io/File;
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v13, "dependencies/"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 144
    .local v11, "relativePath":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v12

    if-eqz v12, :cond_0

    move-object/from16 v0, p0

    invoke-static {v0, v4, v11}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->differentLength(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_0

    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->appIsUpdated(Landroid/content/Context;)Z

    move-result v12

    if-eqz v12, :cond_5

    .line 147
    :cond_0
    const/4 v1, 0x0

    .line 148
    .local v1, "bis":Ljava/io/BufferedInputStream;
    const/4 v5, 0x0

    .line 150
    .local v5, "dexWriter":Ljava/io/BufferedOutputStream;
    :try_start_0
    new-instance v2, Ljava/io/BufferedInputStream;

    invoke-virtual/range {p0 .. p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v12

    invoke-virtual {v12, v11}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v12

    invoke-direct {v2, v12}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_6
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 151
    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .local v2, "bis":Ljava/io/BufferedInputStream;
    :try_start_1
    new-instance v6, Ljava/io/BufferedOutputStream;

    new-instance v12, Ljava/io/FileOutputStream;

    invoke-direct {v12, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v6, v12}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_7
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 152
    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .local v6, "dexWriter":Ljava/io/BufferedOutputStream;
    const/16 v12, 0x2000

    :try_start_2
    new-array v3, v12, [B

    .line 154
    .local v3, "buf":[B
    :goto_0
    const/4 v12, 0x0

    const/16 v13, 0x2000

    invoke-virtual {v2, v3, v12, v13}, Ljava/io/BufferedInputStream;->read([BII)I

    move-result v8

    .local v8, "len":I
    if-lez v8, :cond_3

    .line 155
    const/4 v12, 0x0

    invoke-virtual {v6, v3, v12, v8}, Ljava/io/BufferedOutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_0

    .line 157
    .end local v3    # "buf":[B
    .end local v8    # "len":I
    :catch_0
    move-exception v7

    move-object v5, v6

    .end local v6    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .line 158
    .end local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    .local v7, "e":Ljava/io/IOException;
    :goto_1
    :try_start_3
    new-instance v12, Ljava/lang/IllegalStateException;

    const-string/jumbo v13, "Could not copy .dex from APK to data directory"

    invoke-direct {v12, v13, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v12
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 161
    .end local v7    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v12

    :goto_2
    if-eqz v5, :cond_1

    .line 163
    :try_start_4
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 168
    :cond_1
    :goto_3
    if-eqz v1, :cond_2

    .line 170
    :try_start_5
    invoke-virtual {v1}, Ljava/io/BufferedInputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_4

    .line 173
    :cond_2
    :goto_4
    throw v12

    .line 161
    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v3    # "buf":[B
    .restart local v6    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v8    # "len":I
    :cond_3
    if-eqz v6, :cond_4

    .line 163
    :try_start_6
    invoke-virtual {v6}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1

    .line 168
    :cond_4
    :goto_5
    if-eqz v2, :cond_5

    .line 170
    :try_start_7
    invoke-virtual {v2}, Ljava/io/BufferedInputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_2

    .line 182
    .end local v2    # "bis":Ljava/io/BufferedInputStream;
    .end local v3    # "buf":[B
    .end local v6    # "dexWriter":Ljava/io/BufferedOutputStream;
    .end local v8    # "len":I
    :cond_5
    :goto_6
    invoke-virtual {v4}, Ljava/io/File;->length()J

    move-result-wide v12

    const-wide/16 v14, 0x0

    cmp-long v12, v12, v14

    if-lez v12, :cond_7

    .line 184
    :try_start_8
    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->getPrivateDexCache(Landroid/content/Context;)Ljava/io/File;

    move-result-object v12

    invoke-static {v4, v12}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->optimizedPathFor(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;

    move-result-object v10

    .line 187
    .local v10, "outputFilename":Ljava/lang/String;
    new-instance v9, Ljava/io/File;

    invoke-direct {v9, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 188
    .local v9, "optFile":Ljava/io/File;
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v12

    if-eqz v12, :cond_6

    .line 189
    invoke-virtual {v9}, Ljava/io/File;->delete()Z

    .line 192
    :cond_6
    invoke-virtual {v4}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    const/4 v13, 0x0

    invoke-static {v12, v10, v13}, Ldalvik/system/DexFile;->loadDex(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5

    .line 197
    .end local v9    # "optFile":Ljava/io/File;
    .end local v10    # "outputFilename":Ljava/lang/String;
    :cond_7
    :goto_7
    return-object v4

    .line 164
    .restart local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v3    # "buf":[B
    .restart local v6    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v8    # "len":I
    :catch_1
    move-exception v12

    goto :goto_5

    .line 171
    :catch_2
    move-exception v12

    goto :goto_6

    .line 164
    .end local v2    # "bis":Ljava/io/BufferedInputStream;
    .end local v3    # "buf":[B
    .end local v6    # "dexWriter":Ljava/io/BufferedOutputStream;
    .end local v8    # "len":I
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    :catch_3
    move-exception v13

    goto :goto_3

    .line 171
    :catch_4
    move-exception v13

    goto :goto_4

    .line 193
    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    :catch_5
    move-exception v12

    goto :goto_7

    .line 161
    .restart local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    :catchall_1
    move-exception v12

    move-object v1, v2

    .end local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_2

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v6    # "dexWriter":Ljava/io/BufferedOutputStream;
    :catchall_2
    move-exception v12

    move-object v5, v6

    .end local v6    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    move-object v1, v2

    .end local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_2

    .line 157
    :catch_6
    move-exception v7

    goto :goto_1

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v2    # "bis":Ljava/io/BufferedInputStream;
    :catch_7
    move-exception v7

    move-object v1, v2

    .end local v2    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_1
.end method

.method public static copyJarsToAppPrivateFolder(Landroid/content/Context;Ljava/util/concurrent/ThreadPoolExecutor;)Ljava/lang/String;
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "executor"    # Ljava/util/concurrent/ThreadPoolExecutor;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 51
    invoke-static {p0}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->getDexFileListFromAssets(Landroid/content/Context;)Ljava/util/List;

    move-result-object v3

    .line 52
    .local v3, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 53
    .local v1, "destFileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const-string/jumbo v8, "dependencies-cache"

    const/4 v9, 0x0

    invoke-virtual {p0, v8, v9}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v6

    .line 54
    .local v6, "optDirFile":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->mkdirs()Z

    .line 56
    if-eqz p1, :cond_2

    .line 57
    new-instance v5, Ljava/util/concurrent/CountDownLatch;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v8

    invoke-direct {v5, v8}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 59
    .local v5, "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 60
    .local v7, "singleDexFileName":Ljava/lang/String;
    new-instance v8, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;

    invoke-direct {v8, p0, v7, v1, v5}, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/concurrent/CountDownLatch;)V

    invoke-virtual {p1, v8}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 74
    .end local v7    # "singleDexFileName":Ljava/lang/String;
    :cond_0
    :try_start_0
    invoke-virtual {v5}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 85
    .end local v5    # "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    :cond_1
    :goto_1
    invoke-static {p0}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->recordLastDexModification(Landroid/content/Context;)V

    .line 87
    sget-object v8, Ljava/io/File;->pathSeparator:Ljava/lang/String;

    invoke-static {v8, v1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 75
    .restart local v5    # "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    :catch_0
    move-exception v2

    .line 76
    .local v2, "e":Ljava/lang/InterruptedException;
    const-string/jumbo v8, "SecondDexEntry"

    const-string/jumbo v9, "Dex copying and optimize interrupted"

    invoke-static {v8, v9, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 79
    .end local v2    # "e":Ljava/lang/InterruptedException;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    :cond_2
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .restart local v4    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 80
    .restart local v7    # "singleDexFileName":Ljava/lang/String;
    invoke-static {p0, v7}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->copyJarAndOptimize(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 81
    .local v0, "destFile":Ljava/io/File;
    invoke-static {v1}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v8

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2
.end method

.method private static differentLength(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "file"    # Ljava/io/File;
    .param p2, "assetName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 244
    :try_start_0
    invoke-virtual {p1}, Ljava/io/File;->length()J

    move-result-wide v2

    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v4

    invoke-virtual {v4, p2}, Landroid/content/res/AssetManager;->openFd(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/AssetFileDescriptor;->getLength()J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v4

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    .line 249
    :goto_0
    return v1

    .line 244
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 246
    :catch_0
    move-exception v0

    .line 249
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method public static getAppPrivateNativeLibsPath(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x9
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 104
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x400

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->nativeLibraryDir:Ljava/lang/String;

    return-object v0
.end method

.method public static getDexFileListFromAssets(Landroid/content/Context;)Ljava/util/List;
    .locals 6
    .param p0, "currentApplication"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 115
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v4

    const-string/jumbo v5, "dependencies/jarlist.txt"

    invoke-virtual {v4, v5}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v1, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 118
    .local v1, "jarList":Ljava/io/BufferedReader;
    const/4 v2, 0x0

    .line 119
    .local v2, "line":Ljava/lang/String;
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 121
    .local v0, "fileList":Ljava/util/LinkedList;, "Ljava/util/LinkedList<Ljava/lang/String;>;"
    :goto_0
    :try_start_0
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 122
    invoke-virtual {v0, v2}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 125
    :catchall_0
    move-exception v3

    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V

    throw v3

    :cond_0
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V

    .line 128
    return-object v0
.end method

.method private static getDexOutputDir(Landroid/content/Context;)Ljava/io/File;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 99
    const-string/jumbo v0, "dependencies"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method private static getPrivateDexCache(Landroid/content/Context;)Ljava/io/File;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 95
    const-string/jumbo v0, "dependencies-cache"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method public static getPrivateDexCachePath(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 91
    invoke-static {p0}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->getPrivateDexCache(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static optimizedPathFor(Ljava/io/File;Ljava/io/File;)Ljava/lang/String;
    .locals 6
    .param p0, "path"    # Ljava/io/File;
    .param p1, "optimizedDirectory"    # Ljava/io/File;

    .prologue
    .line 270
    invoke-virtual {p0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v0

    .line 271
    .local v0, "fileName":Ljava/lang/String;
    const-string/jumbo v4, ".dex"

    invoke-virtual {v0, v4}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 272
    const-string/jumbo v4, "."

    invoke-virtual {v0, v4}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    .line 273
    .local v1, "lastDot":I
    if-gez v1, :cond_1

    .line 274
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ".dex"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 282
    .end local v1    # "lastDot":I
    :cond_0
    :goto_0
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p1, v0}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 283
    .local v2, "result":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    return-object v4

    .line 276
    .end local v2    # "result":Ljava/io/File;
    .restart local v1    # "lastDot":I
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    add-int/lit8 v4, v1, 0x4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 277
    .local v3, "sb":Ljava/lang/StringBuilder;
    const/4 v4, 0x0

    invoke-virtual {v3, v0, v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;II)Ljava/lang/StringBuilder;

    .line 278
    const-string/jumbo v4, ".dex"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 279
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static recordLastDexModification(Landroid/content/Context;)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 231
    :try_start_0
    const-string/jumbo v6, "app_dependencies_update"

    const/4 v7, 0x0

    invoke-virtual {p0, v6, v7}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v5

    .line 232
    .local v5, "prefs":Landroid/content/SharedPreferences;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 233
    .local v4, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v4, v6, v7}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 234
    .local v1, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v0, v1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 235
    .local v0, "appFile":Ljava/lang/String;
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/File;->lastModified()J

    move-result-wide v2

    .line 236
    .local v2, "installed":J
    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string/jumbo v7, "lastUpdate"

    invoke-interface {v6, v7, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 240
    .end local v0    # "appFile":Ljava/lang/String;
    .end local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "installed":J
    .end local v4    # "pm":Landroid/content/pm/PackageManager;
    .end local v5    # "prefs":Landroid/content/SharedPreferences;
    :goto_0
    return-void

    .line 237
    :catch_0
    move-exception v6

    goto :goto_0
.end method
