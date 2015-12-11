.class public Lcom/disney/datg/videoplatforms/sdk/media/Configuration;
.super Ljava/lang/Object;
.source "Configuration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;
    }
.end annotation


# static fields
.field public static ANALYTICS_ENABLED:Z

.field public static AUTHZ_TIMEOUT:I

.field public static LBS_REQUEST_TIMEOUT:I

.field public static LIVE_STREAM_AUTHZ_INTERVAL:I

.field public static SERVICE_TIMEOUT:I

.field public static SLOGGER_ENABLED:Z

.field public static networks:Ljava/util/Map;
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

.field protected static partners:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public static version:Ljava/lang/String;


# instance fields
.field private currentApiKey:Ljava/lang/String;

.field private currentConfig:Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

.field private currentEnvironment:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

.field private currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

.field private currentNetwork:Ljava/lang/String;

.field private currentPartnerCode:Ljava/lang/String;

.field private currentPartnerName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/16 v2, 0xa

    const/4 v1, 0x1

    .line 30
    const-string v0, "1.0.0.9"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->version:Ljava/lang/String;

    .line 32
    sput v2, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->AUTHZ_TIMEOUT:I

    .line 34
    sput v2, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    .line 36
    const/16 v0, 0x1e

    sput v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->LBS_REQUEST_TIMEOUT:I

    .line 38
    const/16 v0, 0x5460

    sput v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->LIVE_STREAM_AUTHZ_INTERVAL:I

    .line 40
    sput-boolean v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->ANALYTICS_ENABLED:Z

    .line 42
    sput-boolean v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SLOGGER_ENABLED:Z

    .line 46
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$1;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->networks:Ljava/util/Map;

    .line 60
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$2;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->partners:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 130
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentNetwork:Ljava/lang/String;

    .line 131
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerName:Ljava/lang/String;

    .line 132
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerCode:Ljava/lang/String;

    .line 133
    const-string v0, ""

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentApiKey:Ljava/lang/String;

    .line 134
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->PRODUCTION:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentEnvironment:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    .line 135
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentConfig:Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    .line 136
    iput-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    return-void
.end method

.method private setCurrentApiKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "currentApiKey"    # Ljava/lang/String;

    .prologue
    .line 271
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentApiKey:Ljava/lang/String;

    .line 272
    return-void
.end method

.method private setCurrentEnvironment(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;)V
    .locals 0
    .param p1, "currentEnvironment"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    .prologue
    .line 279
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentEnvironment:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    .line 280
    return-void
.end method

.method private setCurrentNetwork(Ljava/lang/String;)V
    .locals 0
    .param p1, "currentNetwork"    # Ljava/lang/String;

    .prologue
    .line 247
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentNetwork:Ljava/lang/String;

    .line 248
    return-void
.end method

.method private setCurrentPartnerCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "currentPartnerCode"    # Ljava/lang/String;

    .prologue
    .line 263
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerCode:Ljava/lang/String;

    .line 264
    return-void
.end method

.method private setCurrentPartnerName(Ljava/lang/String;)V
    .locals 0
    .param p1, "currentPartnerName"    # Ljava/lang/String;

    .prologue
    .line 255
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerName:Ljava/lang/String;

    .line 256
    return-void
.end method


# virtual methods
.method public getCurrentConfig()Lcom/disney/datg/videoplatforms/sdk/models/api/Config;
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentConfig:Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    return-object v0
.end method

.method public getCurrentNetwork()Ljava/lang/String;
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentNetwork:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentPartnerCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 259
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerCode:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentPartnerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 251
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerName:Ljava/lang/String;

    return-object v0
.end method

.method protected initialize(Ljava/lang/String;Ljava/lang/String;)V
    .locals 12
    .param p1, "partner"    # Ljava/lang/String;
    .param p2, "network"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x0

    .line 143
    sget v8, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v9, 0xf

    if-ge v8, v9, :cond_0

    .line 144
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_UNSUPPORTED_APILEVEL_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "API version of this device is not supported"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 147
    :cond_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 148
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "invalid partner"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 152
    :cond_1
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->partners:Ljava/util/Map;

    invoke-interface {v8, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 154
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "009_"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->partners:Ljava/util/Map;

    invoke-interface {v8, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map;

    const-string v10, "partnerCode"

    invoke-interface {v8, v10}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {p0, v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentPartnerCode(Ljava/lang/String;)V

    .line 155
    invoke-direct {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentPartnerName(Ljava/lang/String;)V

    .line 156
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->partners:Ljava/util/Map;

    invoke-interface {v8, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map;

    const-string v9, "apiKey"

    invoke-interface {v8, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-direct {p0, v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentApiKey(Ljava/lang/String;)V

    .line 160
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v8

    add-int/lit8 v8, v8, -0x3

    invoke-static {v11, v8}, Ljava/lang/Math;->max(II)I

    move-result v8

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {p1, v8, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    const-string v9, "_qa"

    invoke-virtual {v8, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 161
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->QA:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    invoke-direct {p0, v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentEnvironment(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;)V

    .line 162
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v8

    add-int/lit8 v8, v8, -0x3

    invoke-static {v11, v8}, Ljava/lang/Math;->max(II)I

    move-result v8

    invoke-virtual {p1, v11, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 172
    :goto_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_8

    .line 174
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->networks:Ljava/util/Map;

    invoke-interface {v8, p2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    .line 176
    invoke-direct {p0, p2}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentNetwork(Ljava/lang/String;)V

    .line 200
    :cond_2
    :goto_1
    iget-object v8, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentEnvironment:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    invoke-virtual {v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->getService()Ljava/lang/String;

    move-result-object v8

    const-string v9, "%BRAND%"

    iget-object v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentNetwork:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    const-string v9, "%PARTNER%"

    iget-object v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerCode:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    const-string v9, "%APIKEY%"

    iget-object v10, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentApiKey:Ljava/lang/String;

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 205
    .local v2, "configUrl":Ljava/lang/String;
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;

    const/4 v8, 0x0

    invoke-direct {v0, v2, v8}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 210
    .local v0, "configAccessor":Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;
    :try_start_0
    invoke-virtual {v0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;->getServiceAsync()Ljava/util/concurrent/Future;

    move-result-object v5

    .line 212
    .local v5, "futureConfigEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;>;"
    sget v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->SERVICE_TIMEOUT:I

    int-to-long v8, v8

    sget-object v10, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v5, v8, v9, v10}, Ljava/util/concurrent/Future;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/springframework/http/ResponseEntity;

    .line 213
    .local v1, "configEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    if-nez v1, :cond_9

    .line 214
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CONFIG_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v8
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_5

    .line 218
    .end local v1    # "configEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    .end local v5    # "futureConfigEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;>;"
    :catch_0
    move-exception v4

    .line 219
    .local v4, "e1":Ljava/lang/InterruptedException;
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CONFIG_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-direct {v8, v9}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;)V

    throw v8

    .line 164
    .end local v0    # "configAccessor":Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;
    .end local v2    # "configUrl":Ljava/lang/String;
    .end local v4    # "e1":Ljava/lang/InterruptedException;
    :cond_3
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;->PRODUCTION:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    invoke-direct {p0, v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentEnvironment(Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;)V

    goto :goto_0

    .line 168
    :cond_4
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "invalid partner"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 178
    :cond_5
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->networks:Ljava/util/Map;

    invoke-interface {v8, p2}, Ljava/util/Map;->containsValue(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 180
    sget-object v8, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->networks:Ljava/util/Map;

    invoke-interface {v8}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_6
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map$Entry;

    .line 182
    .local v7, "keys":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v7}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v8, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 184
    invoke-interface {v7}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/String;

    invoke-direct {p0, v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentNetwork(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 192
    .end local v6    # "i$":Ljava/util/Iterator;
    .end local v7    # "keys":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_7
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "invalid network"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 196
    :cond_8
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CATALOG_MANAGER_CREATION_EXCEPTION:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    const-string v10, "invalid network"

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v8

    .line 216
    .restart local v0    # "configAccessor":Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;
    .restart local v1    # "configEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    .restart local v2    # "configUrl":Ljava/lang/String;
    .restart local v5    # "futureConfigEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;>;"
    :cond_9
    :try_start_1
    invoke-virtual {v1}, Lorg/springframework/http/ResponseEntity;->getBody()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    invoke-virtual {p0, v8}, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->setCurrentConfig(Lcom/disney/datg/videoplatforms/sdk/models/api/Config;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_5

    .line 232
    return-void

    .line 220
    .end local v1    # "configEntity":Lorg/springframework/http/ResponseEntity;, "Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    .end local v5    # "futureConfigEntity":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;>;"
    :catch_1
    move-exception v3

    .line 221
    .local v3, "e":Ljava/util/concurrent/ExecutionException;
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CONFIG_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v3}, Ljava/util/concurrent/ExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v8

    .line 222
    .end local v3    # "e":Ljava/util/concurrent/ExecutionException;
    :catch_2
    move-exception v3

    .line 223
    .local v3, "e":Ljava/util/concurrent/RejectedExecutionException;
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CONFIG_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v3}, Ljava/util/concurrent/RejectedExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v8

    .line 224
    .end local v3    # "e":Ljava/util/concurrent/RejectedExecutionException;
    :catch_3
    move-exception v3

    .line 225
    .local v3, "e":Ljava/util/concurrent/TimeoutException;
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CONFIG_SERVICE_TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v3}, Ljava/util/concurrent/TimeoutException;->getCause()Ljava/lang/Throwable;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v8

    .line 226
    .end local v3    # "e":Ljava/util/concurrent/TimeoutException;
    :catch_4
    move-exception v3

    .line 227
    .local v3, "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    throw v3

    .line 228
    .end local v3    # "e":Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
    :catch_5
    move-exception v3

    .line 229
    .local v3, "e":Ljava/lang/Exception;
    new-instance v8, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v9, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_CONFIG_SERVICE_ERROR:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v3}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/Throwable;)V

    throw v8
.end method

.method protected setCurrentConfig(Lcom/disney/datg/videoplatforms/sdk/models/api/Config;)V
    .locals 0
    .param p1, "currentConfig"    # Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    .prologue
    .line 239
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentConfig:Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    .line 240
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 283
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "sdk: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->version:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", env: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentEnvironment:Lcom/disney/datg/videoplatforms/sdk/media/Configuration$Environment;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", network: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentNetwork:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", partner : "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentPartnerName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", apikey: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentApiKey:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", geo: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/disney/datg/videoplatforms/sdk/media/Configuration;->currentGeolocation:Lcom/disney/datg/videoplatforms/sdk/models/api/GeoLocation;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
