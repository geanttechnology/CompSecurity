.class public Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;
.super Landroid/os/HandlerThread;
.source "ImageFetcherThread.java"


# static fields
.field private static final WEAR_STYLE_CODE_CROP:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

.field private static final WEAR_STYLE_CODE_SIZE:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;


# instance fields
.field private final mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

.field private final mHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    const-string/jumbo v1, "AC"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->WEAR_STYLE_CODE_CROP:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    .line 21
    new-instance v0, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    const-string/jumbo v1, "SR"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->WEAR_STYLE_CODE_SIZE:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/common/api/GoogleApiClient;)V
    .locals 2
    .param p1, "googleApiClient"    # Lcom/google/android/gms/common/api/GoogleApiClient;

    .prologue
    .line 34
    const-string/jumbo v0, "RetailImageFetcherThread"

    invoke-direct {p0, v0}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    .line 35
    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->start()V

    .line 36
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->mHandler:Landroid/os/Handler;

    .line 37
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    .line 38
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->syncImage(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private syncImage(Ljava/lang/String;Ljava/lang/String;)V
    .locals 10
    .param p1, "node"    # Ljava/lang/String;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 54
    :try_start_0
    invoke-static {p2}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 55
    invoke-static {p2}, Lcom/amazon/mShop/util/ImageUtil;->getImageId(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 56
    .local v4, "physicalId":Ljava/lang/String;
    sget-object v6, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->WEAR_STYLE_CODE_SIZE:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    const-string/jumbo v7, "300,160"

    invoke-virtual {v6, p2, v7}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;->appendTo(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 57
    sget-object v6, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->WEAR_STYLE_CODE_CROP:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    invoke-virtual {v6, p2}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;->appendTo(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 58
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, p2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 59
    .local v5, "url":Ljava/net/URL;
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 60
    .local v0, "conn":Ljava/net/HttpURLConnection;
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/MShopIOUtils;->getByteArray(Ljava/io/InputStream;)[B

    move-result-object v2

    .line 61
    .local v2, "imageBytes":[B
    iget-object v6, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v6}, Lcom/google/android/gms/common/api/GoogleApiClient;->isConnected()Z

    move-result v6

    if-nez v6, :cond_0

    .line 62
    iget-object v6, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    invoke-interface {v6}, Lcom/google/android/gms/common/api/GoogleApiClient;->blockingConnect()Lcom/google/android/gms/common/ConnectionResult;

    .line 65
    :cond_0
    new-instance v6, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;

    const/4 v7, 0x0

    invoke-direct {v6, v7, v2}, Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;-><init>(Ljava/lang/String;[B)V

    invoke-static {v6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->toBytes(Lcom/amazon/mShop/wearable/wear/shared/StampedMessage;)[B

    move-result-object v3

    .line 66
    .local v3, "messageData":[B
    sget-object v6, Lcom/google/android/gms/wearable/Wearable;->MessageApi:Lcom/google/android/gms/wearable/MessageApi;

    iget-object v7, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->mGoogleApiClient:Lcom/google/android/gms/common/api/GoogleApiClient;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "/image/"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v7, p1, v8, v3}, Lcom/google/android/gms/wearable/MessageApi;->sendMessage(Lcom/google/android/gms/common/api/GoogleApiClient;Ljava/lang/String;Ljava/lang/String;[B)Lcom/google/android/gms/common/api/PendingResult;

    move-result-object v6

    invoke-interface {v6}, Lcom/google/android/gms/common/api/PendingResult;->await()Lcom/google/android/gms/common/api/Result;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 71
    .end local v0    # "conn":Ljava/net/HttpURLConnection;
    .end local v2    # "imageBytes":[B
    .end local v3    # "messageData":[B
    .end local v4    # "physicalId":Ljava/lang/String;
    .end local v5    # "url":Ljava/net/URL;
    :goto_0
    return-void

    .line 68
    :catch_0
    move-exception v1

    .line 69
    .local v1, "e":Ljava/io/IOException;
    const-string/jumbo v6, "WearImageFetcherThread"

    const-string/jumbo v7, "IOException thrown while fetching image"

    invoke-static {v6, v7, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method


# virtual methods
.method public fetchImage(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "node"    # Ljava/lang/String;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 41
    const-string/jumbo v0, "WearImageFetcherThread"

    const-string/jumbo v1, "Fetching image for url: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 42
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/amazon/mShop/wearable/wear/ImageFetcherThread$1;-><init>(Lcom/amazon/mShop/wearable/wear/ImageFetcherThread;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 48
    return-void
.end method
