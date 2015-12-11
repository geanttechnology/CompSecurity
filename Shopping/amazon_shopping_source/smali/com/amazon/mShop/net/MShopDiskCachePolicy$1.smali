.class final Lcom/amazon/mShop/net/MShopDiskCachePolicy$1;
.super Ljava/lang/Object;
.source "MShopDiskCachePolicy.java"

# interfaces
.implements Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MShopDiskCachePolicy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor",
        "<",
        "Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public evict(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I
    .locals 1
    .param p1, "lruInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .prologue
    .line 91
    invoke-static {p1}, Lcom/amazon/mShop/net/MShopDiskCache;->deleteCachedFile(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic evict(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 79
    check-cast p1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$1;->evict(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I

    move-result v0

    return v0
.end method

.method public getSize(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I
    .locals 1
    .param p1, "lruInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .prologue
    .line 82
    invoke-static {p1}, Lcom/amazon/mShop/net/MShopDiskCache;->getFileUsedSize(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I

    move-result v0

    return v0
.end method

.method public bridge synthetic getSize(Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 79
    check-cast p1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$1;->getSize(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;)I

    move-result v0

    return v0
.end method

.method public setAccessTime(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;J)V
    .locals 1
    .param p1, "lruInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    .param p2, "time"    # J

    .prologue
    .line 86
    iget-object v0, p1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mFile:Ljava/io/File;

    invoke-virtual {v0, p2, p3}, Ljava/io/File;->setLastModified(J)Z

    .line 87
    iput-wide p2, p1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;->mLastModifiedTime:J

    .line 88
    return-void
.end method

.method public bridge synthetic setAccessTime(Ljava/lang/Object;J)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # J

    .prologue
    .line 79
    check-cast p1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$1;->setAccessTime(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;J)V

    return-void
.end method
