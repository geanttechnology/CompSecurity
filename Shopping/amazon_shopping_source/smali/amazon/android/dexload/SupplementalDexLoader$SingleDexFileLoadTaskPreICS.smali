.class Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;
.super Ljava/lang/Object;
.source "SupplementalDexLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lamazon/android/dexload/SupplementalDexLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SingleDexFileLoadTaskPreICS"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mFileName:Ljava/lang/String;

.field private final mIndex:I

.field private final mLoadingLatch:Ljava/util/concurrent/CountDownLatch;

.field private final mNewDexs:[Ldalvik/system/DexFile;

.field private final mNewFiles:[Ljava/io/File;

.field private final mNewPaths:[Ljava/lang/String;

.field private final mNewZips:[Ljava/util/zip/ZipFile;


# direct methods
.method public constructor <init>(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;Ljava/util/concurrent/CountDownLatch;)V
    .locals 0
    .param p1, "indexElement"    # I
    .param p2, "fileName"    # Ljava/lang/String;
    .param p3, "newPaths"    # [Ljava/lang/String;
    .param p4, "newFiles"    # [Ljava/io/File;
    .param p5, "newZips"    # [Ljava/util/zip/ZipFile;
    .param p6, "newDexs"    # [Ldalvik/system/DexFile;
    .param p7, "currentApplication"    # Landroid/content/Context;
    .param p8, "loadingLatch"    # Ljava/util/concurrent/CountDownLatch;

    .prologue
    .line 375
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 376
    iput p1, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mIndex:I

    .line 377
    iput-object p2, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mFileName:Ljava/lang/String;

    .line 378
    iput-object p3, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewPaths:[Ljava/lang/String;

    .line 379
    iput-object p4, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewFiles:[Ljava/io/File;

    .line 380
    iput-object p5, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewZips:[Ljava/util/zip/ZipFile;

    .line 381
    iput-object p6, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewDexs:[Ldalvik/system/DexFile;

    .line 382
    iput-object p7, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mContext:Landroid/content/Context;

    .line 383
    iput-object p8, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    .line 384
    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 389
    :try_start_0
    iget v0, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mIndex:I

    iget-object v1, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mFileName:Ljava/lang/String;

    iget-object v2, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewPaths:[Ljava/lang/String;

    iget-object v3, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewFiles:[Ljava/io/File;

    iget-object v4, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewZips:[Ljava/util/zip/ZipFile;

    iget-object v5, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mNewDexs:[Ldalvik/system/DexFile;

    iget-object v6, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mContext:Landroid/content/Context;

    # invokes: Lamazon/android/dexload/SupplementalDexLoader;->loadSingleDexPreICS(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;)V
    invoke-static/range {v0 .. v6}, Lamazon/android/dexload/SupplementalDexLoader;->access$000(ILjava/lang/String;[Ljava/lang/String;[Ljava/io/File;[Ljava/util/zip/ZipFile;[Ldalvik/system/DexFile;Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 394
    :goto_0
    iget-object v0, p0, Lamazon/android/dexload/SupplementalDexLoader$SingleDexFileLoadTaskPreICS;->mLoadingLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 395
    return-void

    .line 390
    :catch_0
    move-exception v0

    goto :goto_0
.end method
