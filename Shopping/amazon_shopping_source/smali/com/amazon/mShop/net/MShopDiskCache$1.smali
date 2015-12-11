.class final Lcom/amazon/mShop/net/MShopDiskCache$1;
.super Ljava/lang/Object;
.source "MShopDiskCache.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/net/MShopDiskCache;->writeCacheFile(Ljava/lang/String;[BLjava/net/HttpURLConnection;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$contentType:Ljava/lang/String;

.field final synthetic val$header:Ljava/util/Map;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$receiveTimeMillis:J

.field final synthetic val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

.field final synthetic val$sendTimeMillis:J

.field final synthetic val$value:[B


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ[BLjava/lang/String;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$key:Ljava/lang/String;

    iput-object p2, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$header:Ljava/util/Map;

    iput-object p3, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    iput-wide p4, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$sendTimeMillis:J

    iput-wide p6, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$receiveTimeMillis:J

    iput-object p8, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$value:[B

    iput-object p9, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$contentType:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$key:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$header:Ljava/util/Map;

    iget-object v2, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    iget-wide v3, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$sendTimeMillis:J

    iget-wide v5, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$receiveTimeMillis:J

    invoke-static/range {v0 .. v6}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->writeHeaderInf(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)Z

    move-result v8

    .line 88
    .local v8, "success":Z
    if-eqz v8, :cond_0

    .line 89
    const/4 v7, 0x0

    .line 90
    .local v7, "f":Ljava/io/File;
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$key:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$value:[B

    iget-object v2, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$contentType:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/net/MShopDiskCache;->writeFileContent(Ljava/lang/String;[BLjava/lang/String;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Ljava/io/File;

    move-result-object v7

    .line 91
    if-eqz v7, :cond_0

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$key:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/net/MShopDiskCache$1;->val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0, v7, v1}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->addFileJournal(Ljava/lang/String;Ljava/io/File;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;)Z

    .line 95
    .end local v7    # "f":Ljava/io/File;
    :cond_0
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 96
    return-void
.end method
