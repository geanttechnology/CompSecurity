.class public Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;
.super Ljava/lang/Object;
.source "VPGeolocation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$VPLocationRequestListener;
    }
.end annotation


# static fields
.field private static geoLocationManager:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;


# instance fields
.field private _tempLatitude:Ljava/lang/String;

.field private _tempLongitude:Ljava/lang/String;

.field private _tempZipcode:Ljava/lang/String;

.field private configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

.field private currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

.field private expires:Ljava/util/Date;

.field private onLocationRequestListener:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$VPLocationRequestListener;

.field private signal:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 131
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLatitude:Ljava/lang/String;

    .line 132
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLongitude:Ljava/lang/String;

    .line 133
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempZipcode:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$000(Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;)Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    return-object v0
.end method

.method public static getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;
    .locals 1

    .prologue
    .line 39
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->geoLocationManager:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    if-nez v0, :cond_0

    .line 40
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->geoLocationManager:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    .line 42
    :cond_0
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->geoLocationManager:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    return-object v0
.end method

.method private setCurrentGeolocation(Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;)V
    .locals 0
    .param p1, "currentGeolocation"    # Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    .line 127
    return-void
.end method


# virtual methods
.method protected doLBS(Landroid/content/Context;)Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 162
    new-instance v3, Ljava/util/concurrent/CountDownLatch;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->signal:Ljava/util/concurrent/CountDownLatch;

    .line 164
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->onLocationRequestListener:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$VPLocationRequestListener;

    if-eqz v3, :cond_0

    .line 165
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->onLocationRequestListener:Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$VPLocationRequestListener;

    invoke-interface {v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$VPLocationRequestListener;->onLocationRequest()V

    .line 168
    :try_start_0
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->signal:Ljava/util/concurrent/CountDownLatch;

    sget v4, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->LBS_REQUEST_TIMEOUT:I

    int-to-long v4, v4

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v3, v4, v5, v6}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    .line 169
    .local v0, "countDownReachZero":Z
    if-nez v0, :cond_0

    .line 172
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempZipcode:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 174
    iget-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLatitude:Ljava/lang/String;

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLongitude:Ljava/lang/String;

    invoke-virtual {p0, p1, v3, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getPostalCode(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempZipcode:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 183
    .end local v0    # "countDownReachZero":Z
    :cond_0
    :goto_0
    const/4 v2, 0x0

    .line 185
    .local v2, "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    :try_start_1
    invoke-static {}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getGeolocationManager()Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;

    move-result-object v3

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLatitude:Ljava/lang/String;

    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLongitude:Ljava/lang/String;

    iget-object v6, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempZipcode:Ljava/lang/String;

    invoke-virtual {v3, v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    :try_end_1
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v2

    .line 189
    :goto_1
    const-string v3, ""

    iput-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempZipcode:Ljava/lang/String;

    iput-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLongitude:Ljava/lang/String;

    iput-object v3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLatitude:Ljava/lang/String;

    .line 190
    return-object v2

    .line 178
    .end local v2    # "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    :catch_0
    move-exception v1

    .line 179
    .local v1, "e":Ljava/lang/InterruptedException;
    const-string v3, "VPGeolocation"

    const-string v4, "lbs countdown interrupted"

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 186
    .end local v1    # "e":Ljava/lang/InterruptedException;
    .restart local v2    # "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    :catch_1
    move-exception v1

    .line 187
    .local v1, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    const-string v3, "VPGeolocation"

    invoke-virtual {v1}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public getCurrentGeolocation()Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 56
    const-string v0, ""

    const-string v1, ""

    const-string v2, ""

    invoke-virtual {p0, v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->getCurrentGeolocation(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    move-result-object v0

    return-object v0
.end method

.method public getCurrentGeolocation(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .locals 12
    .param p1, "latitude"    # Ljava/lang/String;
    .param p2, "longitude"    # Ljava/lang/String;
    .param p3, "zipcode"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 61
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    if-eqz v9, :cond_0

    .line 63
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->expires:Ljava/util/Date;

    if-eqz v9, :cond_0

    .line 64
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 65
    .local v0, "current":Ljava/util/Date;
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->expires:Ljava/util/Date;

    invoke-virtual {v0, v9}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 67
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    .line 122
    .end local v0    # "current":Ljava/util/Date;
    :goto_0
    return-object v9

    .line 74
    :cond_0
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;

    invoke-direct {v8, p0, p1, p2, p3}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    .local v8, "postParameters":Lorg/springframework/util/MultiValueMap;, "Lorg/springframework/util/MultiValueMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lcom/disney/datg/videoplatforms/sdk/service/GeoAccessor;

    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    move-result-object v9

    const-string v10, "geolocation"

    invoke-virtual {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;->getURLFromWebServiceName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    invoke-direct {v6, v9, v8, v10}, Lcom/disney/datg/videoplatforms/sdk/service/GeoAccessor;-><init>(Ljava/lang/String;Lorg/springframework/util/MultiValueMap;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 86
    .local v6, "geoAccessor":Lcom/disney/datg/videoplatforms/sdk/service/GeoAccessor;
    invoke-virtual {v6}, Lcom/disney/datg/videoplatforms/sdk/service/GeoAccessor;->getServiceAsync()Ljava/util/concurrent/Future;

    move-result-object v4

    .line 90
    .local v4, "futureGeoEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;>;"
    :try_start_0
    sget v9, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    int-to-long v10, v9

    sget-object v9, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v4, v10, v11, v9}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lorg/springframework/http/ResponseEntity;

    .line 91
    .local v7, "geoEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    if-nez v7, :cond_1

    .line 92
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v9
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_5

    .line 109
    .end local v7    # "geoEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    :catch_0
    move-exception v1

    .line 110
    .local v1, "e":Ljava/lang/InterruptedException;
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v9

    .line 94
    .end local v1    # "e":Ljava/lang/InterruptedException;
    .restart local v7    # "geoEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    :cond_1
    :try_start_1
    invoke-virtual {v7}, Lorg/springframework/http/ResponseEntity;->getBody()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    .line 95
    .local v5, "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    if-eqz v5, :cond_3

    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v9

    if-eqz v9, :cond_3

    .line 96
    invoke-virtual {v5}, Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;->getUser()Lcom/disney/datg/videoplatforms/sdk/models/api/User;

    move-result-object v9

    invoke-virtual {v9}, Lcom/disney/datg/videoplatforms/sdk/models/api/User;->getAllowed()Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v9

    if-nez v9, :cond_2

    .line 97
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_OUTSIDE_US:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v9
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_5

    .line 111
    .end local v5    # "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .end local v7    # "geoEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    :catch_1
    move-exception v1

    .line 112
    .local v1, "e":Ljava/util/concurrent/ExecutionException;
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v1}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v9

    .line 99
    .end local v1    # "e":Ljava/util/concurrent/ExecutionException;
    .restart local v5    # "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .restart local v7    # "geoEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    :cond_2
    :try_start_2
    new-instance v9, Ljava/util/Date;

    invoke-direct {v9}, Ljava/util/Date;-><init>()V

    iput-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->expires:Ljava/util/Date;

    .line 100
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->expires:Ljava/util/Date;

    invoke-virtual {v9}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    .line 101
    .local v2, "currentTime":J
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->expires:Ljava/util/Date;

    const-wide/32 v10, 0x493e0

    add-long/2addr v10, v2

    invoke-virtual {v9, v10, v11}, Ljava/util/Date;->setTime(J)V

    .line 103
    invoke-direct {p0, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->setCurrentGeolocation(Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;)V
    :try_end_2
    .catch Ljava/lang/InterruptedException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_2 .. :try_end_2} :catch_4
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_5

    .line 122
    iget-object v9, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    goto/16 :goto_0

    .line 106
    .end local v2    # "currentTime":J
    :cond_3
    :try_start_3
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_SERVICE_IO_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v11, "geo service returned null or user returned null"

    invoke-direct {v9, v10, v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v9
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_5

    .line 113
    .end local v5    # "geo":Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;
    .end local v7    # "geoEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;>;"
    :catch_2
    move-exception v1

    .line 114
    .local v1, "e":Ljava/util/concurrent/TimeoutException;
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_SERVICE_TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v1}, Ljava/util/concurrent/TimeoutException;->getCause()Ljava/lang/Throwable;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v9

    .line 115
    .end local v1    # "e":Ljava/util/concurrent/TimeoutException;
    :catch_3
    move-exception v1

    .line 116
    .local v1, "e":Ljava/util/concurrent/RejectedExecutionException;
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v1}, Ljava/util/concurrent/RejectedExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v9

    .line 117
    .end local v1    # "e":Ljava/util/concurrent/RejectedExecutionException;
    :catch_4
    move-exception v1

    .line 118
    .local v1, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    throw v1

    .line 119
    .end local v1    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :catch_5
    move-exception v1

    .line 120
    .local v1, "e":Ljava/lang/Exception;
    new-instance v9, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v10, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_GEO_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v1}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v11

    invoke-direct {v9, v10, v11}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v9
.end method

.method protected getPostalCode(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "latitude"    # Ljava/lang/String;
    .param p3, "longitude"    # Ljava/lang/String;

    .prologue
    .line 137
    const-string v9, ""

    .line 138
    .local v9, "postalcode":Ljava/lang/String;
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    invoke-static {}, Landroid/location/Geocoder;->isPresent()Z

    move-result v2

    if-eqz v2, :cond_2

    if-eqz p1, :cond_2

    .line 140
    :cond_1
    new-instance v1, Landroid/location/Geocoder;

    invoke-direct {v1, p1}, Landroid/location/Geocoder;-><init>(Landroid/content/Context;)V

    .line 143
    .local v1, "geocoder":Landroid/location/Geocoder;
    :try_start_0
    iget-object v2, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLatitude:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v2

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->_tempLongitude:Ljava/lang/String;

    invoke-static {v4}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    const/4 v6, 0x5

    invoke-virtual/range {v1 .. v6}, Landroid/location/Geocoder;->getFromLocation(DDI)Ljava/util/List;

    move-result-object v7

    .line 144
    .local v7, "addresses":Ljava/util/List;, "Ljava/util/List<Landroid/location/Address;>;"
    if-eqz v7, :cond_2

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_2

    .line 145
    const/4 v2, 0x0

    invoke-interface {v7, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    .line 146
    .local v0, "address":Landroid/location/Address;
    if-eqz v0, :cond_2

    .line 147
    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v9

    .line 157
    .end local v0    # "address":Landroid/location/Address;
    .end local v1    # "geocoder":Landroid/location/Geocoder;
    .end local v7    # "addresses":Ljava/util/List;, "Ljava/util/List<Landroid/location/Address;>;"
    :cond_2
    :goto_0
    return-object v9

    .line 150
    .restart local v1    # "geocoder":Landroid/location/Geocoder;
    :catch_0
    move-exception v8

    .line 151
    .local v8, "e":Ljava/lang/NumberFormatException;
    const-string v2, "VPGeolocation"

    invoke-virtual {v8}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 152
    .end local v8    # "e":Ljava/lang/NumberFormatException;
    :catch_1
    move-exception v8

    .line 153
    .local v8, "e":Ljava/io/IOException;
    const-string v2, "VPGeolocation"

    invoke-virtual {v8}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected setConfiguration(Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    .locals 0
    .param p1, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPGeolocation;->configuration:Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .line 52
    return-void
.end method
