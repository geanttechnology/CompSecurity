.class final Lcom/amazon/mShop/android/platform/dex/DexUtils$1;
.super Ljava/lang/Object;
.source "DexUtils.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/android/platform/dex/DexUtils;->copyJarsToAppPrivateFolder(Landroid/content/Context;Ljava/util/concurrent/ThreadPoolExecutor;)Ljava/lang/String;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$destFileList:Ljava/util/List;

.field final synthetic val$loadingLatch:Ljava/util/concurrent/CountDownLatch;

.field final synthetic val$singleDexFileName:Ljava/lang/String;


# direct methods
.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Ljava/util/concurrent/CountDownLatch;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$context:Landroid/content/Context;

    iput-object p2, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$singleDexFileName:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$destFileList:Ljava/util/List;

    iput-object p4, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$loadingLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 63
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$context:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$singleDexFileName:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/amazon/mShop/android/platform/dex/DexUtils;->copyJarAndOptimize(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    .line 64
    .local v0, "destFile":Ljava/io/File;
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$destFileList:Ljava/util/List;

    invoke-static {v1}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 65
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/dex/DexUtils$1;->val$loadingLatch:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 66
    return-void
.end method
