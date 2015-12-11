.class Lcom/amazon/device/ads/GooglePlayServicesAdapter;
.super Ljava/lang/Object;
.source "GooglePlayServicesAdapter.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/device/ads/GooglePlayServicesAdapter;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/GooglePlayServicesAdapter;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected createAdvertisingIdClient()Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;

    invoke-direct {v0}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;-><init>()V

    return-object v0
.end method

.method public getAdvertisingIdentifierInfo()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;
    .locals 7

    .prologue
    .line 36
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 40
    .local v1, "context":Landroid/content/Context;
    :try_start_0
    invoke-static {v1}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient;->getAdvertisingIdInfo(Landroid/content/Context;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lcom/google/android/gms/common/GooglePlayServicesNotAvailableException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Lcom/google/android/gms/common/GooglePlayServicesRepairableException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v3

    .line 69
    .local v3, "info":Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    sget-object v5, Lcom/amazon/device/ads/GooglePlayServicesAdapter;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "The Google Play Services Advertising Identifier was successfully retrieved."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    invoke-virtual {v3}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;->getId()Ljava/lang/String;

    move-result-object v0

    .line 72
    .local v0, "advertisingId":Ljava/lang/String;
    invoke-virtual {v3}, Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;->isLimitAdTrackingEnabled()Z

    move-result v4

    .line 74
    .local v4, "limitAdTrackingEnabled":Z
    new-instance v5, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    invoke-direct {v5}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;-><init>()V

    invoke-virtual {v5, v0}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->setAdvertisingIdentifier(Ljava/lang/String;)Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v5

    invoke-virtual {v5, v4}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->setLimitAdTrackingEnabled(Z)Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v5

    .end local v0    # "advertisingId":Ljava/lang/String;
    .end local v3    # "info":Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
    .end local v4    # "limitAdTrackingEnabled":Z
    :goto_0
    return-object v5

    .line 42
    :catch_0
    move-exception v2

    .line 46
    .local v2, "e":Ljava/lang/IllegalStateException;
    sget-object v5, Lcom/amazon/device/ads/GooglePlayServicesAdapter;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "The Google Play Services Advertising Id API was called from a non-background thread."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    new-instance v5, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    invoke-direct {v5}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;-><init>()V

    goto :goto_0

    .line 49
    .end local v2    # "e":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v2

    .line 52
    .local v2, "e":Ljava/io/IOException;
    sget-object v5, Lcom/amazon/device/ads/GooglePlayServicesAdapter;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Retrieving the Google Play Services Advertising Identifier caused an IOException."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    new-instance v5, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    invoke-direct {v5}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;-><init>()V

    goto :goto_0

    .line 55
    .end local v2    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v2

    .line 57
    .local v2, "e":Lcom/google/android/gms/common/GooglePlayServicesNotAvailableException;
    sget-object v5, Lcom/amazon/device/ads/GooglePlayServicesAdapter;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesNotAvailableException."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    invoke-static {}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;->createNotAvailable()Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    move-result-object v5

    goto :goto_0

    .line 60
    .end local v2    # "e":Lcom/google/android/gms/common/GooglePlayServicesNotAvailableException;
    :catch_3
    move-exception v2

    .line 65
    .local v2, "e":Lcom/google/android/gms/common/GooglePlayServicesRepairableException;
    sget-object v5, Lcom/amazon/device/ads/GooglePlayServicesAdapter;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Retrieving the Google Play Services Advertising Identifier caused a GooglePlayServicesRepairableException."

    invoke-static {v5, v6}, Lcom/amazon/device/ads/Log;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    new-instance v5, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;

    invoke-direct {v5}, Lcom/amazon/device/ads/GooglePlayServices$AdvertisingInfo;-><init>()V

    goto :goto_0
.end method
