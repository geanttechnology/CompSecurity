.class public final Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;
.super Ljava/lang/Object;
.source "AmazonJWTHelper.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    return-void
.end method

.method static deviceInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 3
    .param p0, "deviceType"    # Ljava/lang/String;
    .param p1, "dsn"    # Ljava/lang/String;
    .param p2, "deviceSecret"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 63
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 64
    .local v0, "dev":Lorg/json/JSONObject;
    const-string/jumbo v1, "typ"

    const-string/jumbo v2, "v1"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 65
    const-string/jumbo v1, "dt"

    invoke-virtual {v0, v1, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 66
    const-string/jumbo v1, "dsn"

    invoke-virtual {v0, v1, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 67
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 69
    const-string/jumbo v1, "ds"

    invoke-virtual {v0, v1, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 71
    :cond_0
    const-string/jumbo v1, "cpuid"

    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->getCPUId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 72
    return-object v0
.end method

.method static getCPUId()Ljava/lang/String;
    .locals 8

    .prologue
    .line 85
    const/4 v0, 0x0

    .line 87
    .local v0, "bufferReader":Ljava/io/BufferedReader;
    const/4 v2, 0x0

    .line 91
    .local v2, "cpuId":Ljava/lang/String;
    :try_start_0
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/FileReader;

    const-string/jumbo v6, "/proc/cpuinfo"

    invoke-direct {v5, v6}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 93
    .end local v0    # "bufferReader":Ljava/io/BufferedReader;
    .local v1, "bufferReader":Ljava/io/BufferedReader;
    :cond_0
    :try_start_1
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .local v4, "line":Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 95
    const-string/jumbo v5, "Serial"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 97
    const-string/jumbo v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 98
    const/4 v6, 0x1

    aget-object v5, v5, v6

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v2

    .line 112
    :cond_1
    :try_start_2
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    :goto_0
    move-object v5, v2

    .line 124
    .end local v1    # "bufferReader":Ljava/io/BufferedReader;
    .end local v4    # "line":Ljava/lang/String;
    :goto_1
    return-object v5

    .line 118
    .restart local v1    # "bufferReader":Ljava/io/BufferedReader;
    .restart local v4    # "line":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 120
    .local v3, "e":Ljava/io/IOException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Error closing bufferReader in getCPUId()!"

    invoke-static {v5, v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 105
    .end local v1    # "bufferReader":Ljava/io/BufferedReader;
    .end local v3    # "e":Ljava/io/IOException;
    .end local v4    # "line":Ljava/lang/String;
    .restart local v0    # "bufferReader":Ljava/io/BufferedReader;
    :catch_1
    move-exception v3

    .line 107
    .local v3, "e":Ljava/lang/Exception;
    :goto_2
    :try_start_3
    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "GetCPUInfoFailed:"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->recordErrorMetric(Ljava/lang/String;)V

    .line 108
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Exception thrown when getting the serial number(cpuId)"

    invoke-static {v5, v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 112
    if-eqz v0, :cond_2

    .line 116
    :try_start_4
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 124
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_2
    :goto_3
    const/4 v5, 0x0

    goto :goto_1

    .line 118
    .restart local v3    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v3

    .line 120
    .local v3, "e":Ljava/io/IOException;
    sget-object v5, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Error closing bufferReader in getCPUId()!"

    invoke-static {v5, v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 112
    .end local v3    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v5

    :goto_4
    if-eqz v0, :cond_3

    .line 116
    :try_start_5
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 121
    :cond_3
    :goto_5
    throw v5

    .line 118
    :catch_3
    move-exception v3

    .line 120
    .restart local v3    # "e":Ljava/io/IOException;
    sget-object v6, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Error closing bufferReader in getCPUId()!"

    invoke-static {v6, v7, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_5

    .line 112
    .end local v0    # "bufferReader":Ljava/io/BufferedReader;
    .end local v3    # "e":Ljava/io/IOException;
    .restart local v1    # "bufferReader":Ljava/io/BufferedReader;
    :catchall_1
    move-exception v5

    move-object v0, v1

    .end local v1    # "bufferReader":Ljava/io/BufferedReader;
    .restart local v0    # "bufferReader":Ljava/io/BufferedReader;
    goto :goto_4

    .line 105
    .end local v0    # "bufferReader":Ljava/io/BufferedReader;
    .restart local v1    # "bufferReader":Ljava/io/BufferedReader;
    :catch_4
    move-exception v3

    move-object v0, v1

    .end local v1    # "bufferReader":Ljava/io/BufferedReader;
    .restart local v0    # "bufferReader":Ljava/io/BufferedReader;
    goto :goto_2
.end method

.method static getCurrentUTCTimestamp()Ljava/lang/String;
    .locals 4

    .prologue
    .line 129
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string/jumbo v2, "yyyy-MM-dd\'T\'HH:mm\'Z\'"

    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v0, v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 130
    .local v0, "dateFormatter":Ljava/text/SimpleDateFormat;
    const-string/jumbo v2, "UTC"

    invoke-static {v2}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 131
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    .line 132
    .local v1, "now":Ljava/util/Date;
    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    .line 133
    return-object v2
.end method

.method static getRegistrationPayload(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 4
    .param p0, "deviceInfo"    # Lorg/json/JSONObject;
    .param p1, "custInfo"    # Lorg/json/JSONObject;
    .param p2, "timestamp"    # Ljava/lang/String;

    .prologue
    .line 40
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 41
    .local v1, "payload":Lorg/json/JSONObject;
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 43
    const-string/jumbo v2, "dat"

    invoke-virtual {v1, v2, p2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 49
    :goto_0
    const-string/jumbo v2, "dev"

    invoke-virtual {v1, v2, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 50
    const-string/jumbo v2, "cust"

    invoke-virtual {v1, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 52
    return-object v1

    .line 47
    :cond_0
    const-string/jumbo v2, "dat"

    invoke-static {}, Lcom/amazon/identity/kcpsdk/auth/AmazonJWTHelper;->getCurrentUTCTimestamp()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 54
    .end local v1    # "payload":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 56
    .local v0, "e":Lorg/json/JSONException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-direct {v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method static newCustInfo()Lorg/json/JSONObject;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 78
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 79
    .local v0, "cust":Lorg/json/JSONObject;
    const-string/jumbo v1, "typ"

    const-string/jumbo v2, "v1"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 80
    return-object v0
.end method

.method static recordErrorMetric(Ljava/lang/String;)V
    .locals 2
    .param p0, "errorCode"    # Ljava/lang/String;

    .prologue
    .line 138
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "GenerateJWTFailure:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 139
    return-void
.end method
