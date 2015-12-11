.class public Lamazon/android/dexload/SupplementalDexLoader;
.super Ljava/lang/Object;
.source "SupplementalDexLoader.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;,
        Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;,
        Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;,
        Lamazon/android/dexload/SupplementalDexLoader$SingletonHolder;
    }
.end annotation


# static fields
.field private static final JARLIST_TXT_FILENAME:Ljava/lang/String;


# instance fields
.field private mClassLoader:Ldalvik/system/PathClassLoader;

.field private final mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

.field private final mIsLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mIsRunningTestInstrumentation:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mLoadedJars:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 53
    const-string/jumbo v0, "%s/%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string/jumbo v3, "dex"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string/jumbo v3, "jarlist.txt"

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lamazon/android/dexload/SupplementalDexLoader;->JARLIST_TXT_FILENAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader;->mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

    .line 59
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader;->mIsLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 62
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader;->mIsRunningTestInstrumentation:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 66
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader;->mLoadedJars:Ljava/util/List;

    .line 545
    return-void
.end method

.method static synthetic access$000(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;)V
    .locals 0
    .param p0, "x0"    # I
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # [Ljava/lang/String;
    .param p3, "x3"    # [Ljava/io/File;
    .param p4, "x4"    # [Ljava/util/zip/ZipFile;
    .param p5, "x5"    # [Ldalvik/system/DexFile;
    .param p6, "x6"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 45
    invoke-static/range {p0 .. p6}, Lamazon/android/dexload/SupplementalDexLoader;->loadSingleDexPreICS(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;)V

    return-void
.end method

.method static synthetic access$100(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;I)V
    .locals 0
    .param p0, "x0"    # Landroid/content/Context;
    .param p1, "x1"    # Lamazon/android/dexload/compatibility/DexElementCompatibility;
    .param p2, "x2"    # Ljava/lang/Object;
    .param p3, "x3"    # Ljava/lang/String;
    .param p4, "x4"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/zip/ZipException;,
            Ljava/io/IOException;,
            Ljava/lang/ArrayIndexOutOfBoundsException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/InstantiationException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .prologue
    .line 45
    invoke-static {p0, p1, p2, p3, p4}, Lamazon/android/dexload/SupplementalDexLoader;->optimizeAndAddToArray(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;I)V

    return-void
.end method

.method private static appIsUpdated(Landroid/content/Context;)Z
    .locals 14
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 638
    :try_start_0
    const-string/jumbo v11, "app_dex_update"

    const/4 v12, 0x0

    invoke-virtual {p0, v11, v12}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v8

    .line 639
    .local v8, "prefs":Landroid/content/SharedPreferences;
    const-string/jumbo v11, "lastUpdate"

    const-wide/16 v12, 0x0

    invoke-interface {v8, v11, v12, v13}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v5

    .line 640
    .local v5, "lastUpdated":J
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    .line 641
    .local v7, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x0

    invoke-virtual {v7, v11, v12}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 642
    .local v1, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v0, v1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 643
    .local v0, "appFile":Ljava/lang/String;
    new-instance v11, Ljava/io/File;

    invoke-direct {v11, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11}, Ljava/io/File;->lastModified()J
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v3

    .line 645
    .local v3, "installed":J
    cmp-long v11, v3, v5

    if-lez v11, :cond_0

    .line 650
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

    .line 645
    goto :goto_0

    .line 646
    .end local v0    # "appFile":Ljava/lang/String;
    .end local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v3    # "installed":J
    .end local v5    # "lastUpdated":J
    .end local v7    # "pm":Landroid/content/pm/PackageManager;
    .end local v8    # "prefs":Landroid/content/SharedPreferences;
    :catch_0
    move-exception v2

    .line 650
    .local v2, "e":Ljava/lang/Exception;
    goto :goto_0
.end method

.method private static assetMatchesCache(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "file"    # Ljava/io/File;
    .param p2, "assetName"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 682
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v5

    invoke-virtual {v5, p2}, Landroid/content/res/AssetManager;->openFd(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v0

    .line 683
    .local v0, "asset":Landroid/content/res/AssetFileDescriptor;
    invoke-virtual {v0}, Landroid/content/res/AssetFileDescriptor;->getLength()J

    move-result-wide v1

    .line 684
    .local v1, "assetSize":J
    invoke-virtual {v0}, Landroid/content/res/AssetFileDescriptor;->close()V

    .line 686
    invoke-virtual {p1}, Ljava/io/File;->length()J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v5

    cmp-long v5, v5, v1

    if-nez v5, :cond_0

    const/4 v4, 0x1

    .line 689
    .end local v0    # "asset":Landroid/content/res/AssetFileDescriptor;
    .end local v1    # "assetSize":J
    :cond_0
    :goto_0
    return v4

    .line 687
    :catch_0
    move-exception v3

    .line 688
    .local v3, "e":Ljava/io/IOException;
    const-string/jumbo v5, "DexLoad"

    const-string/jumbo v6, "Could not compare File and asset length."

    invoke-static {v5, v6, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private static copyJar(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    .locals 13
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    const/4 v12, 0x0

    .line 703
    new-instance v3, Ljava/io/File;

    const-string/jumbo v9, "dex"

    invoke-virtual {p0, v9, v12}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v9

    invoke-direct {v3, v9, p1}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 705
    .local v3, "dexOut":Ljava/io/File;
    const-string/jumbo v9, "%s/%s"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const-string/jumbo v11, "dex"

    aput-object v11, v10, v12

    const/4 v11, 0x1

    aput-object p1, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    .line 707
    .local v8, "relativePath":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-static {p0, v3, v8}, Lamazon/android/dexload/SupplementalDexLoader;->assetMatchesCache(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    invoke-static {p0}, Lamazon/android/dexload/SupplementalDexLoader;->appIsUpdated(Landroid/content/Context;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 711
    :cond_0
    const/4 v0, 0x0

    .line 712
    .local v0, "bis":Ljava/io/BufferedInputStream;
    const/4 v4, 0x0

    .line 714
    .local v4, "dexWriter":Ljava/io/BufferedOutputStream;
    :try_start_0
    new-instance v1, Ljava/io/BufferedInputStream;

    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v9

    invoke-virtual {v9, v8}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v9

    invoke-direct {v1, v9}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_5
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 715
    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .local v1, "bis":Ljava/io/BufferedInputStream;
    :try_start_1
    new-instance v5, Ljava/io/BufferedOutputStream;

    new-instance v9, Ljava/io/FileOutputStream;

    invoke-direct {v9, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v5, v9}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_6
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 716
    .end local v4    # "dexWriter":Ljava/io/BufferedOutputStream;
    .local v5, "dexWriter":Ljava/io/BufferedOutputStream;
    const/16 v9, 0x2000

    :try_start_2
    new-array v2, v9, [B

    .line 718
    .local v2, "buf":[B
    :goto_0
    const/4 v9, 0x0

    const/16 v10, 0x2000

    invoke-virtual {v1, v2, v9, v10}, Ljava/io/BufferedInputStream;->read([BII)I

    move-result v7

    .local v7, "len":I
    if-lez v7, :cond_3

    .line 719
    const/4 v9, 0x0

    invoke-virtual {v5, v2, v9, v7}, Ljava/io/BufferedOutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_0

    .line 721
    .end local v2    # "buf":[B
    .end local v7    # "len":I
    :catch_0
    move-exception v6

    move-object v4, v5

    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v4    # "dexWriter":Ljava/io/BufferedOutputStream;
    move-object v0, v1

    .line 722
    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    .local v6, "e":Ljava/io/IOException;
    :goto_1
    :try_start_3
    const-string/jumbo v9, "DexLoad"

    const-string/jumbo v10, "Could not copy .dex from APK to data directory"

    invoke-static {v9, v10, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 723
    new-instance v9, Ljava/lang/IllegalStateException;

    const-string/jumbo v10, "Could not copy .dex from APK to data directory"

    invoke-direct {v9, v10, v6}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v9
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 726
    .end local v6    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v9

    :goto_2
    if-eqz v4, :cond_1

    .line 728
    :try_start_4
    invoke-virtual {v4}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_3

    .line 733
    :cond_1
    :goto_3
    if-eqz v0, :cond_2

    .line 735
    :try_start_5
    invoke-virtual {v0}, Ljava/io/BufferedInputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_4

    .line 738
    :cond_2
    :goto_4
    throw v9

    .line 726
    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .end local v4    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v2    # "buf":[B
    .restart local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v7    # "len":I
    :cond_3
    if-eqz v5, :cond_4

    .line 728
    :try_start_6
    invoke-virtual {v5}, Ljava/io/BufferedOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_1

    .line 733
    :cond_4
    :goto_5
    if-eqz v1, :cond_5

    .line 735
    :try_start_7
    invoke-virtual {v1}, Ljava/io/BufferedInputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_2

    .line 743
    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .end local v2    # "buf":[B
    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .end local v7    # "len":I
    :cond_5
    :goto_6
    return-object v3

    .line 729
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v2    # "buf":[B
    .restart local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v7    # "len":I
    :catch_1
    move-exception v9

    goto :goto_5

    .line 736
    :catch_2
    move-exception v9

    goto :goto_6

    .line 729
    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .end local v2    # "buf":[B
    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .end local v7    # "len":I
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    .restart local v4    # "dexWriter":Ljava/io/BufferedOutputStream;
    :catch_3
    move-exception v10

    goto :goto_3

    .line 736
    :catch_4
    move-exception v10

    goto :goto_4

    .line 726
    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    :catchall_1
    move-exception v9

    move-object v0, v1

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_2

    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .end local v4    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    :catchall_2
    move-exception v9

    move-object v4, v5

    .end local v5    # "dexWriter":Ljava/io/BufferedOutputStream;
    .restart local v4    # "dexWriter":Ljava/io/BufferedOutputStream;
    move-object v0, v1

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_2

    .line 721
    :catch_5
    move-exception v6

    goto :goto_1

    .end local v0    # "bis":Ljava/io/BufferedInputStream;
    .restart local v1    # "bis":Ljava/io/BufferedInputStream;
    :catch_6
    move-exception v6

    move-object v0, v1

    .end local v1    # "bis":Ljava/io/BufferedInputStream;
    .restart local v0    # "bis":Ljava/io/BufferedInputStream;
    goto :goto_1
.end method

.method private filterJarList(Ljava/util/List;)Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 820
    .local p1, "requestJarList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0, p1}, Ljava/util/LinkedList;-><init>(Ljava/util/Collection;)V

    .line 821
    .local v0, "necessaryFileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v1, p0, Lamazon/android/dexload/SupplementalDexLoader;->mLoadedJars:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 822
    return-object v0
.end method

.method private static getClassLoader(Landroid/content/Context;)Ldalvik/system/PathClassLoader;
    .locals 1
    .param p0, "c"    # Landroid/content/Context;

    .prologue
    .line 754
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    check-cast v0, Ldalvik/system/PathClassLoader;

    return-object v0
.end method

.method private static getDexFilesFromAssets(Landroid/content/Context;)Ljava/util/List;
    .locals 4
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
    .line 767
    :try_start_0
    invoke-static {p0}, Lamazon/android/dexload/SupplementalDexLoader;->getDexListFromFile(Landroid/content/Context;)Ljava/util/List;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 772
    .local v1, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :goto_0
    return-object v1

    .line 768
    .end local v1    # "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_0
    move-exception v0

    .line 769
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v2

    const-string/jumbo v3, "dex"

    invoke-virtual {v2, v3}, Landroid/content/res/AssetManager;->list(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    .restart local v1    # "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    goto :goto_0
.end method

.method private static getDexListFromFile(Landroid/content/Context;)Ljava/util/List;
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
    .line 784
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    .line 786
    .local v0, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v4

    sget-object v5, Lamazon/android/dexload/SupplementalDexLoader;->JARLIST_TXT_FILENAME:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v2

    .line 787
    .local v2, "jarlistStream":Ljava/io/InputStream;
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v4, Ljava/io/InputStreamReader;

    invoke-direct {v4, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v1, v4}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 790
    .local v1, "jarList":Ljava/io/BufferedReader;
    const/4 v3, 0x0

    .line 791
    .local v3, "line":Ljava/lang/String;
    :goto_0
    :try_start_0
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 792
    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 795
    :catchall_0
    move-exception v4

    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V

    throw v4

    :cond_0
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V

    .line 798
    return-object v0
.end method

.method public static getInstance()Lamazon/android/dexload/SupplementalDexLoader;
    .locals 1

    .prologue
    .line 78
    sget-object v0, Lamazon/android/dexload/SupplementalDexLoader$SingletonHolder;->INSTANCE:Lamazon/android/dexload/SupplementalDexLoader;

    return-object v0
.end method

.method private static getOutputPath(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "currentApplication"    # Landroid/content/Context;
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 805
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "dexopt"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static loadSingleDexPreICS(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;)V
    .locals 5
    .param p0, "indexElement"    # I
    .param p1, "fileName"    # Ljava/lang/String;
    .param p2, "newPaths"    # [Ljava/lang/String;
    .param p3, "newFiles"    # [Ljava/io/File;
    .param p4, "newZips"    # [Ljava/util/zip/ZipFile;
    .param p5, "newDexs"    # [Ldalvik/system/DexFile;
    .param p6, "currentApplication"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 418
    invoke-static {p6, p1}, Lamazon/android/dexload/SupplementalDexLoader;->getOutputPath(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 419
    .local v1, "outPath":Ljava/lang/String;
    invoke-static {p6, p1}, Lamazon/android/dexload/SupplementalDexLoader;->copyJar(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 420
    .local v2, "pathFile":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v1, v4}, Ldalvik/system/DexFile;->loadDex(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;

    move-result-object v0

    .line 422
    .local v0, "newDex":Ldalvik/system/DexFile;
    aput-object v1, p2, p0

    .line 423
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    aput-object v3, p3, p0

    .line 424
    new-instance v3, Ljava/util/zip/ZipFile;

    invoke-direct {v3, v2}, Ljava/util/zip/ZipFile;-><init>(Ljava/io/File;)V

    aput-object v3, p4, p0

    .line 425
    aput-object v0, p5, p0

    .line 426
    return-void
.end method

.method private static optimizeAndAddToArray(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;I)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dexElementCompatibility"    # Lamazon/android/dexload/compatibility/DexElementCompatibility;
    .param p2, "classLoaderArray"    # Ljava/lang/Object;
    .param p3, "fileName"    # Ljava/lang/String;
    .param p4, "idx"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/zip/ZipException;,
            Ljava/io/IOException;,
            Ljava/lang/ArrayIndexOutOfBoundsException;,
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/InstantiationException;,
            Ljava/lang/IllegalAccessException;,
            Ljava/lang/reflect/InvocationTargetException;
        }
    .end annotation

    .prologue
    .line 621
    invoke-static {p0, p3}, Lamazon/android/dexload/SupplementalDexLoader;->getOutputPath(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 622
    .local v1, "outPath":Ljava/lang/String;
    invoke-static {p0, p3}, Lamazon/android/dexload/SupplementalDexLoader;->copyJar(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 623
    .local v2, "pathFile":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-static {v3, v1, v4}, Ldalvik/system/DexFile;->loadDex(Ljava/lang/String;Ljava/lang/String;I)Ldalvik/system/DexFile;

    move-result-object v0

    .line 626
    .local v0, "newDex":Ldalvik/system/DexFile;
    invoke-virtual {p1, v2, v0}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->newInstance(Ljava/io/File;Ldalvik/system/DexFile;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {p2, p4, v3}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 627
    return-void
.end method

.method private recordLastDexModification(Landroid/content/Context;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 661
    :try_start_0
    const-string/jumbo v6, "app_dex_update"

    const/4 v7, 0x0

    invoke-virtual {p1, v6, v7}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v5

    .line 662
    .local v5, "prefs":Landroid/content/SharedPreferences;
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 663
    .local v4, "pm":Landroid/content/pm/PackageManager;
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v4, v6, v7}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    .line 664
    .local v1, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v0, v1, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 665
    .local v0, "appFile":Ljava/lang/String;
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/File;->lastModified()J

    move-result-wide v2

    .line 666
    .local v2, "installed":J
    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    const-string/jumbo v7, "lastUpdate"

    invoke-interface {v6, v7, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v6

    invoke-interface {v6}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 670
    .end local v0    # "appFile":Ljava/lang/String;
    .end local v1    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "installed":J
    .end local v4    # "pm":Landroid/content/pm/PackageManager;
    .end local v5    # "prefs":Landroid/content/SharedPreferences;
    :goto_0
    return-void

    .line 667
    :catch_0
    move-exception v6

    goto :goto_0
.end method

.method private updateClassLoader(Landroid/content/Context;Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;Ljava/util/List;Z)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "multiThreaded"    # Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;
    .param p4, "isFinalUpdate"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .local p3, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .line 171
    iget-object v2, p0, Lamazon/android/dexload/SupplementalDexLoader;->mIsLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2, v0, p4}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v2

    if-nez v2, :cond_2

    .line 173
    iget-object v2, p0, Lamazon/android/dexload/SupplementalDexLoader;->mIsRunningTestInstrumentation:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 174
    const-string/jumbo v2, "DexLoad"

    const-string/jumbo v3, "ClassLoader already updated, ignoring."

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 197
    :cond_0
    :goto_0
    return-void

    .line 177
    :cond_1
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "updateClassLoader is finalized, should not bee called again."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 181
    :cond_2
    invoke-direct {p0, p3}, Lamazon/android/dexload/SupplementalDexLoader;->filterJarList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    .line 184
    .local v1, "jarListToAdd":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_4

    .line 185
    sget-object v2, Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;->YES:Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    if-ne v2, p2, :cond_3

    const/4 v0, 0x1

    .line 186
    .local v0, "isMultiThreadLoading":Z
    :cond_3
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xe

    if-ge v2, v3, :cond_5

    .line 187
    invoke-direct {p0, p1, v0, v1}, Lamazon/android/dexload/SupplementalDexLoader;->updatePreICSClassLoader(Landroid/content/Context;ZLjava/util/List;)V

    .line 193
    .end local v0    # "isMultiThreadLoading":Z
    :cond_4
    :goto_1
    if-eqz p4, :cond_0

    .line 194
    iget-object v2, p0, Lamazon/android/dexload/SupplementalDexLoader;->mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_0

    .line 189
    .restart local v0    # "isMultiThreadLoading":Z
    :cond_5
    invoke-direct {p0, p1, v0, v1}, Lamazon/android/dexload/SupplementalDexLoader;->updateICSClassLoader(Landroid/content/Context;ZLjava/util/List;)V

    goto :goto_1
.end method

.method private updateICSClassLoader(Landroid/content/Context;ZLjava/util/List;)V
    .locals 23
    .param p1, "currentApplication"    # Landroid/content/Context;
    .param p2, "multiThreadLoad"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Z",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 463
    .local p3, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :try_start_0
    invoke-static/range {p1 .. p1}, Lamazon/android/dexload/SupplementalDexLoader;->getClassLoader(Landroid/content/Context;)Ldalvik/system/PathClassLoader;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    .line 467
    const-class v2, Ldalvik/system/PathClassLoader;

    invoke-virtual {v2}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object v2

    const-string/jumbo v3, "pathList"

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v20

    .line 468
    .local v20, "pathListField":Ljava/lang/reflect/Field;
    const/4 v2, 0x1

    move-object/from16 v0, v20

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 469
    move-object/from16 v0, p0

    iget-object v2, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    move-object/from16 v0, v20

    invoke-virtual {v0, v2}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    .line 473
    .local v13, "dexPathList":Ljava/lang/Object;
    invoke-virtual {v13}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    const-string/jumbo v3, "dexElements"

    invoke-virtual {v2, v3}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v12

    .line 474
    .local v12, "dexElementsField":Ljava/lang/reflect/Field;
    const/4 v2, 0x1

    invoke-virtual {v12, v2}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 475
    invoke-virtual {v12, v13}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Ljava/lang/Object;

    move-object v0, v2

    check-cast v0, [Ljava/lang/Object;

    move-object v11, v0

    .line 480
    .local v11, "dexElements":[Ljava/lang/Object;
    invoke-virtual {v12}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v9

    .line 481
    .local v9, "arrayClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-virtual {v9}, Ljava/lang/Class;->getComponentType()Ljava/lang/Class;

    move-result-object v10

    .line 484
    .local v10, "dexElementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v8, Ljava/util/concurrent/CountDownLatch;

    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v2

    invoke-direct {v8, v2}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 488
    .local v8, "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    array-length v2, v11

    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v3

    add-int v19, v2, v3

    .line 489
    .local v19, "length":I
    move/from16 v0, v19

    invoke-static {v10, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;I)Ljava/lang/Object;

    move-result-object v5

    .line 493
    .local v5, "newDexElementsArray":Ljava/lang/Object;
    const/16 v16, 0x0

    .local v16, "i":I
    :goto_0
    array-length v2, v11

    move/from16 v0, v16

    if-ge v0, v2, :cond_0

    .line 494
    aget-object v2, v11, v16

    move/from16 v0, v16

    invoke-static {v5, v0, v2}, Ljava/lang/reflect/Array;->set(Ljava/lang/Object;ILjava/lang/Object;)V

    .line 493
    add-int/lit8 v16, v16, 0x1

    goto :goto_0

    .line 497
    :cond_0
    array-length v7, v11

    .line 499
    .local v7, "idx":I
    invoke-static {v10}, Lamazon/android/dexload/compatibility/DexElementCompatibility;->getDexElementCompatibility(Ljava/lang/Class;)Lamazon/android/dexload/compatibility/DexElementCompatibility;

    move-result-object v4

    .line 502
    .local v4, "dexElementCompatibility":Lamazon/android/dexload/compatibility/DexElementCompatibility;
    if-eqz p2, :cond_2

    .line 504
    new-instance v22, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct/range {v22 .. v22}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    .line 505
    .local v22, "workingQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v2

    move-object/from16 v0, v22

    invoke-static {v0, v2}, Lamazon/android/dexload/ThreadUtil;->createExector(Ljava/util/concurrent/BlockingQueue;I)Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v15

    .line 506
    .local v15, "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v17

    .local v17, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 507
    .local v6, "singleDexFileName":Ljava/lang/String;
    new-instance v2, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;

    move-object/from16 v3, p1

    invoke-direct/range {v2 .. v8}, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskICS;-><init>(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;ILjava/util/concurrent/CountDownLatch;)V

    invoke-virtual {v15, v2}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 514
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 518
    .end local v6    # "singleDexFileName":Ljava/lang/String;
    :cond_1
    invoke-virtual {v8}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 528
    .end local v15    # "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    .end local v22    # "workingQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    :goto_2
    invoke-virtual {v12, v13, v5}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 529
    invoke-direct/range {p0 .. p1}, Lamazon/android/dexload/SupplementalDexLoader;->recordLastDexModification(Landroid/content/Context;)V

    .line 531
    move-object/from16 v0, p0

    iget-object v2, v0, Lamazon/android/dexload/SupplementalDexLoader;->mLoadedJars:Ljava/util/List;

    move-object/from16 v0, p3

    invoke-interface {v2, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 539
    return-void

    .line 520
    .end local v17    # "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v17

    .restart local v17    # "i$":Ljava/util/Iterator;
    move/from16 v18, v7

    .end local v7    # "idx":I
    .local v18, "idx":I
    :goto_3
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 521
    .restart local v6    # "singleDexFileName":Ljava/lang/String;
    add-int/lit8 v7, v18, 0x1

    .end local v18    # "idx":I
    .restart local v7    # "idx":I
    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-static {v0, v4, v5, v6, v1}, Lamazon/android/dexload/SupplementalDexLoader;->optimizeAndAddToArray(Landroid/content/Context;Lamazon/android/dexload/compatibility/DexElementCompatibility;Ljava/lang/Object;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move/from16 v18, v7

    .end local v7    # "idx":I
    .restart local v18    # "idx":I
    goto :goto_3

    .line 532
    .end local v4    # "dexElementCompatibility":Lamazon/android/dexload/compatibility/DexElementCompatibility;
    .end local v5    # "newDexElementsArray":Ljava/lang/Object;
    .end local v6    # "singleDexFileName":Ljava/lang/String;
    .end local v8    # "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    .end local v9    # "arrayClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v10    # "dexElementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v11    # "dexElements":[Ljava/lang/Object;
    .end local v12    # "dexElementsField":Ljava/lang/reflect/Field;
    .end local v13    # "dexPathList":Ljava/lang/Object;
    .end local v16    # "i":I
    .end local v17    # "i$":Ljava/util/Iterator;
    .end local v18    # "idx":I
    .end local v19    # "length":I
    .end local v20    # "pathListField":Ljava/lang/reflect/Field;
    :catch_0
    move-exception v21

    .line 533
    .local v21, "re":Ljava/lang/RuntimeException;
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "Failed to modify classloader with supplementary .dex files."

    move-object/from16 v0, v21

    invoke-direct {v2, v3, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .line 534
    .end local v21    # "re":Ljava/lang/RuntimeException;
    :catch_1
    move-exception v14

    .line 537
    .local v14, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string/jumbo v3, "Failed to modify classloader with supplementary .dex files."

    invoke-direct {v2, v3, v14}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2

    .end local v14    # "e":Ljava/lang/Exception;
    .restart local v4    # "dexElementCompatibility":Lamazon/android/dexload/compatibility/DexElementCompatibility;
    .restart local v5    # "newDexElementsArray":Ljava/lang/Object;
    .restart local v8    # "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    .restart local v9    # "arrayClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v10    # "dexElementClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v11    # "dexElements":[Ljava/lang/Object;
    .restart local v12    # "dexElementsField":Ljava/lang/reflect/Field;
    .restart local v13    # "dexPathList":Ljava/lang/Object;
    .restart local v16    # "i":I
    .restart local v17    # "i$":Ljava/util/Iterator;
    .restart local v18    # "idx":I
    .restart local v19    # "length":I
    .restart local v20    # "pathListField":Ljava/lang/reflect/Field;
    :cond_3
    move/from16 v7, v18

    .end local v18    # "idx":I
    .restart local v7    # "idx":I
    goto :goto_2
.end method

.method private updatePreICSClassLoader(Landroid/content/Context;ZLjava/util/List;)V
    .locals 23
    .param p1, "currentApplication"    # Landroid/content/Context;
    .param p2, "multiThreadLoad"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Z",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 284
    .local p3, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :try_start_0
    invoke-static/range {p1 .. p1}, Lamazon/android/dexload/SupplementalDexLoader;->getClassLoader(Landroid/content/Context;)Ldalvik/system/PathClassLoader;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    .line 287
    const-class v1, Ldalvik/system/PathClassLoader;

    const-string/jumbo v8, "mPaths"

    invoke-virtual {v1, v8}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v20

    .line 288
    .local v20, "pathsField":Ljava/lang/reflect/Field;
    const/4 v1, 0x1

    move-object/from16 v0, v20

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 289
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    move-object/from16 v0, v20

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    move-object v0, v1

    check-cast v0, [Ljava/lang/String;

    move-object/from16 v18, v0

    .line 291
    .local v18, "oldPaths":[Ljava/lang/String;
    const-class v1, Ldalvik/system/PathClassLoader;

    const-string/jumbo v8, "mFiles"

    invoke-virtual {v1, v8}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v13

    .line 292
    .local v13, "filesField":Ljava/lang/reflect/Field;
    const/4 v1, 0x1

    invoke-virtual {v13, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 293
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    invoke-virtual {v13, v1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/io/File;

    move-object v0, v1

    check-cast v0, [Ljava/io/File;

    move-object/from16 v17, v0

    .line 295
    .local v17, "oldFiles":[Ljava/io/File;
    const-class v1, Ldalvik/system/PathClassLoader;

    const-string/jumbo v8, "mZips"

    invoke-virtual {v1, v8}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v22

    .line 296
    .local v22, "zipsField":Ljava/lang/reflect/Field;
    const/4 v1, 0x1

    move-object/from16 v0, v22

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 297
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    move-object/from16 v0, v22

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/util/zip/ZipFile;

    move-object v0, v1

    check-cast v0, [Ljava/util/zip/ZipFile;

    move-object/from16 v19, v0

    .line 299
    .local v19, "oldZips":[Ljava/util/zip/ZipFile;
    const-class v1, Ldalvik/system/PathClassLoader;

    const-string/jumbo v8, "mDexs"

    invoke-virtual {v1, v8}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v10

    .line 300
    .local v10, "dexsField":Ljava/lang/reflect/Field;
    const/4 v1, 0x1

    invoke-virtual {v10, v1}, Ljava/lang/reflect/Field;->setAccessible(Z)V

    .line 301
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    invoke-virtual {v10, v1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ldalvik/system/DexFile;

    move-object v0, v1

    check-cast v0, [Ldalvik/system/DexFile;

    move-object v15, v0

    .line 304
    .local v15, "oldDexs":[Ldalvik/system/DexFile;
    new-instance v9, Ljava/util/concurrent/CountDownLatch;

    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v9, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    .line 307
    .local v9, "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    move-object/from16 v0, v18

    array-length v0, v0

    move/from16 v16, v0

    .line 308
    .local v16, "oldFileSize":I
    move-object/from16 v0, v18

    array-length v1, v0

    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v8

    add-int v14, v1, v8

    .line 309
    .local v14, "length":I
    new-array v4, v14, [Ljava/lang/String;

    .line 310
    .local v4, "newPaths":[Ljava/lang/String;
    new-array v5, v14, [Ljava/io/File;

    .line 311
    .local v5, "newFiles":[Ljava/io/File;
    new-array v6, v14, [Ljava/util/zip/ZipFile;

    .line 312
    .local v6, "newZips":[Ljava/util/zip/ZipFile;
    new-array v7, v14, [Ldalvik/system/DexFile;

    .line 315
    .local v7, "newDexs":[Ldalvik/system/DexFile;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    move/from16 v0, v16

    if-ge v2, v0, :cond_0

    .line 316
    aget-object v1, v18, v2

    aput-object v1, v4, v2

    .line 317
    aget-object v1, v17, v2

    aput-object v1, v5, v2

    .line 318
    aget-object v1, v19, v2

    aput-object v1, v6, v2

    .line 319
    aget-object v1, v15, v2

    aput-object v1, v7, v2

    .line 315
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 322
    :cond_0
    if-eqz p2, :cond_3

    .line 323
    new-instance v21, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct/range {v21 .. v21}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    .line 324
    .local v21, "workingQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v1

    move-object/from16 v0, v21

    invoke-static {v0, v1}, Lamazon/android/dexload/ThreadUtil;->createExector(Ljava/util/concurrent/BlockingQueue;I)Ljava/util/concurrent/ThreadPoolExecutor;

    move-result-object v12

    .line 325
    .local v12, "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    move/from16 v2, v16

    :goto_1
    if-ge v2, v14, :cond_1

    .line 326
    sub-int v1, v2, v16

    move-object/from16 v0, p3

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 327
    .local v3, "fileName":Ljava/lang/String;
    new-instance v1, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;

    move-object/from16 v8, p1

    invoke-direct/range {v1 .. v9}, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;-><init>(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;Ljava/util/concurrent/CountDownLatch;)V

    invoke-virtual {v12, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    .line 325
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 338
    .end local v3    # "fileName":Ljava/lang/String;
    :cond_1
    invoke-virtual {v9}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 350
    .end local v12    # "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    .end local v21    # "workingQueue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    :cond_2
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    invoke-virtual {v10, v1, v7}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 351
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    move-object/from16 v0, v22

    invoke-virtual {v0, v1, v6}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 352
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    move-object/from16 v0, v20

    invoke-virtual {v0, v1, v4}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 353
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    invoke-virtual {v13, v1, v5}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 355
    move-object/from16 v0, p0

    iget-object v1, v0, Lamazon/android/dexload/SupplementalDexLoader;->mLoadedJars:Ljava/util/List;

    move-object/from16 v0, p3

    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 361
    return-void

    .line 340
    :cond_3
    move/from16 v2, v16

    :goto_2
    if-ge v2, v14, :cond_2

    .line 341
    sub-int v1, v2, v16

    move-object/from16 v0, p3

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .restart local v3    # "fileName":Ljava/lang/String;
    move-object/from16 v8, p1

    .line 342
    invoke-static/range {v2 .. v8}, Lamazon/android/dexload/SupplementalDexLoader;->loadSingleDexPreICS(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 340
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 356
    .end local v2    # "i":I
    .end local v3    # "fileName":Ljava/lang/String;
    .end local v4    # "newPaths":[Ljava/lang/String;
    .end local v5    # "newFiles":[Ljava/io/File;
    .end local v6    # "newZips":[Ljava/util/zip/ZipFile;
    .end local v7    # "newDexs":[Ldalvik/system/DexFile;
    .end local v9    # "loadingLatch":Ljava/util/concurrent/CountDownLatch;
    .end local v10    # "dexsField":Ljava/lang/reflect/Field;
    .end local v13    # "filesField":Ljava/lang/reflect/Field;
    .end local v14    # "length":I
    .end local v15    # "oldDexs":[Ldalvik/system/DexFile;
    .end local v16    # "oldFileSize":I
    .end local v17    # "oldFiles":[Ljava/io/File;
    .end local v18    # "oldPaths":[Ljava/lang/String;
    .end local v19    # "oldZips":[Ljava/util/zip/ZipFile;
    .end local v20    # "pathsField":Ljava/lang/reflect/Field;
    .end local v22    # "zipsField":Ljava/lang/reflect/Field;
    :catch_0
    move-exception v11

    .line 359
    .local v11, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v8, "Failed to modify classloader with supplementary .dex files."

    invoke-direct {v1, v8, v11}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public loadClass(Ljava/lang/String;)Ljava/lang/Class;
    .locals 1
    .param p1, "className"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 221
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lamazon/android/dexload/SupplementalDexLoader;->loadClass(Ljava/lang/String;Z)Ljava/lang/Class;

    move-result-object v0

    return-object v0
.end method

.method public loadClass(Ljava/lang/String;Z)Ljava/lang/Class;
    .locals 2
    .param p1, "className"    # Ljava/lang/String;
    .param p2, "needWaitingForLoad"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 225
    if-eqz p2, :cond_0

    .line 226
    invoke-virtual {p0}, Lamazon/android/dexload/SupplementalDexLoader;->waitForLoad()V

    .line 229
    :cond_0
    :try_start_0
    iget-object v1, p0, Lamazon/android/dexload/SupplementalDexLoader;->mClassLoader:Ldalvik/system/PathClassLoader;

    invoke-virtual {v1, p1}, Ldalvik/system/PathClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 231
    :goto_0
    return-object v1

    .line 230
    :catch_0
    move-exception v0

    .line 231
    .local v0, "ce":Ljava/lang/ClassNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setRunningFromTestInstrumentation(Z)V
    .locals 1
    .param p1, "isTesting"    # Z

    .prologue
    .line 253
    iget-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader;->mIsRunningTestInstrumentation:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 254
    return-void
.end method

.method public updateClassLoader(Landroid/content/Context;Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "multiThreaded"    # Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;

    .prologue
    .line 122
    :try_start_0
    invoke-static {p1}, Lamazon/android/dexload/SupplementalDexLoader;->getDexFilesFromAssets(Landroid/content/Context;)Ljava/util/List;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {p0, p1, p2, v1, v2}, Lamazon/android/dexload/SupplementalDexLoader;->updateClassLoader(Landroid/content/Context;Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;Ljava/util/List;Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 129
    return-void

    .line 126
    :catch_0
    move-exception v0

    .line 127
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Can\'t complete the dex loading request"

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public updateClassLoader(Landroid/content/Context;Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;Ljava/util/List;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "multiThreaded"    # Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 146
    .local p3, "fileList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lamazon/android/dexload/SupplementalDexLoader;->updateClassLoader(Landroid/content/Context;Lamazon/android/dexload/SupplementalDexLoader$MultiThreaded;Ljava/util/List;Z)V

    .line 147
    return-void
.end method

.method public waitForLoad()V
    .locals 3

    .prologue
    .line 206
    :try_start_0
    iget-object v1, p0, Lamazon/android/dexload/SupplementalDexLoader;->mDexPathUpdatedLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 211
    return-void

    .line 207
    :catch_0
    move-exception v0

    .line 208
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    .line 209
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string/jumbo v2, "Interrupted during supplemental classload. Cannot recover."

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
