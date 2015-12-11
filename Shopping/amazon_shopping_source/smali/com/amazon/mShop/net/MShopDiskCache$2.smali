.class final Lcom/amazon/mShop/net/MShopDiskCache$2;
.super Ljava/lang/Object;
.source "MShopDiskCache.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/net/MShopDiskCache;->updateHeaderInf(Ljava/lang/String;Ljava/net/HttpURLConnection;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$header:Ljava/util/Map;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$receiveTimeMillis:J

.field final synthetic val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

.field final synthetic val$sendTimeMillis:J


# direct methods
.method constructor <init>(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJ)V
    .locals 0

    .prologue
    .line 108
    iput-object p1, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$key:Ljava/lang/String;

    iput-object p2, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$header:Ljava/util/Map;

    iput-object p3, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    iput-wide p4, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$sendTimeMillis:J

    iput-wide p6, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$receiveTimeMillis:J

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$key:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$header:Ljava/util/Map;

    iget-object v2, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$residencePriority:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    iget-wide v3, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$sendTimeMillis:J

    iget-wide v5, p0, Lcom/amazon/mShop/net/MShopDiskCache$2;->val$receiveTimeMillis:J

    const/4 v7, 0x0

    invoke-static/range {v0 .. v7}, Lcom/amazon/mShop/net/MShopHttpHeaderHelper;->writeHeaderInf(Ljava/lang/String;Ljava/util/Map;Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;JJZ)Z

    .line 112
    return-void
.end method
