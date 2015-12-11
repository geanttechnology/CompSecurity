.class public Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;
.super Ljava/lang/Object;
.source "MShopDiskCache.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MShopDiskCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FileCacheInf"
.end annotation


# instance fields
.field public mHeaderFields:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public mLruInf:Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;Ljava/util/Map;)V
    .locals 0
    .param p1, "lruInf"    # Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 56
    .local p2, "header":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    iput-object p1, p0, Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;->mLruInf:Lcom/amazon/mShop/net/MShopDiskCachePolicy$FileLruInf;

    .line 58
    iput-object p2, p0, Lcom/amazon/mShop/net/MShopDiskCache$FileCacheInf;->mHeaderFields:Ljava/util/Map;

    .line 59
    return-void
.end method
