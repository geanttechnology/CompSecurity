.class public Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;
.super Ljava/lang/Object;
.source "MetricsConfigurationParser.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "MetricsConfigurationParser"

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mConfigurationInputStream:Ljava/io/InputStream;

.field private mIsDebuggable:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "MetricsConfigurationParser"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;Landroid/content/pm/ApplicationInfo;)V
    .locals 2
    .param p1, "configurationFileInputStream"    # Ljava/io/InputStream;
    .param p2, "applicationInfo"    # Landroid/content/pm/ApplicationInfo;

    .prologue
    const/4 v0, 0x0

    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    iput-boolean v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mIsDebuggable:Z

    .line 43
    if-nez p1, :cond_0

    .line 44
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Configuration InputStream is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 46
    :cond_0
    if-nez p2, :cond_1

    .line 47
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "ApplicationInfo is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 49
    :cond_1
    iput-object p1, p0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mConfigurationInputStream:Ljava/io/InputStream;

    .line 51
    iget v1, p2, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v1, v1, 0x2

    if-nez v1, :cond_2

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mIsDebuggable:Z

    .line 52
    return-void

    .line 51
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private readConfigurationInputStream()Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 218
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v3, Ljava/io/InputStreamReader;

    iget-object v4, p0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mConfigurationInputStream:Ljava/io/InputStream;

    invoke-direct {v3, v4}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v1, v3}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 220
    .local v1, "reader":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 222
    .local v2, "sb":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    .local v0, "line":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 223
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 227
    .end local v0    # "line":Ljava/lang/String;
    .end local v2    # "sb":Ljava/lang/StringBuilder;
    :catchall_0
    move-exception v3

    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V

    throw v3

    .line 225
    .restart local v0    # "line":Ljava/lang/String;
    .restart local v2    # "sb":Ljava/lang/StringBuilder;
    :cond_0
    :try_start_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v3

    .line 227
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V

    return-object v3
.end method


# virtual methods
.method public parseConfiguration()Lcom/amazon/client/metrics/configuration/MetricsConfiguration;
    .locals 47
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;
        }
    .end annotation

    .prologue
    .line 63
    :try_start_0
    invoke-direct/range {p0 .. p0}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->readConfigurationInputStream()Ljava/lang/String;

    move-result-object v27

    .line 65
    .local v27, "configurationFileContents":Ljava/lang/String;
    new-instance v36, Lorg/json/JSONObject;

    move-object/from16 v0, v36

    move-object/from16 v1, v27

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 68
    .local v36, "metricsJSON":Lorg/json/JSONObject;
    sget-object v5, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->DEVO:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    invoke-virtual {v5}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->getName()Ljava/lang/String;

    move-result-object v28

    .line 69
    .local v28, "devo":Ljava/lang/String;
    sget-object v5, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->MASTER:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    invoke-virtual {v5}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->getName()Ljava/lang/String;

    move-result-object v34

    .line 70
    .local v34, "master":Ljava/lang/String;
    sget-object v5, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->PROD:Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;

    invoke-virtual {v5}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration$Domain;->getName()Ljava/lang/String;

    move-result-object v45

    .line 76
    .local v45, "prod":Ljava/lang/String;
    move-object/from16 v0, v36

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    sget-object v5, Landroid/os/Build;->TYPE:Ljava/lang/String;

    const-string/jumbo v7, "eng"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mIsDebuggable:Z

    if-eqz v5, :cond_2

    .line 77
    :cond_0
    move-object/from16 v0, v36

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v35

    .line 78
    .local v35, "metricsConfigJson":Lorg/json/JSONObject;
    sget-object v5, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "MetricsConfigurationParser"

    const-string/jumbo v8, "Picking configuration"

    const/4 v9, 0x6

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string/jumbo v11, "Domain"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    const-string/jumbo v11, "devo"

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string/jumbo v11, "Build"

    aput-object v11, v9, v10

    const/4 v10, 0x3

    sget-object v11, Landroid/os/Build;->TYPE:Ljava/lang/String;

    aput-object v11, v9, v10

    const/4 v10, 0x4

    const-string/jumbo v11, "isDebuggable"

    aput-object v11, v9, v10

    const/4 v10, 0x5

    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mIsDebuggable:Z

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-virtual {v5, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 88
    :goto_0
    const-string/jumbo v5, "TransportType"

    move-object/from16 v0, v35

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/client/metrics/configuration/TransportType;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/TransportType;

    move-result-object v46

    .line 95
    .local v46, "transportType":Lcom/amazon/client/metrics/configuration/TransportType;
    const-string/jumbo v5, "BatchQueueConfiguration"

    move-object/from16 v0, v35

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v23

    .line 96
    .local v23, "batchQueueConfigurationJson":Lorg/json/JSONObject;
    const/16 v22, 0x0

    .line 97
    .local v22, "batchQueueConfiguration":Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
    if-eqz v23, :cond_1

    .line 99
    new-instance v22, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;

    .end local v22    # "batchQueueConfiguration":Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
    const-string/jumbo v5, "Type"

    move-object/from16 v0, v23

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/client/metrics/configuration/BatchQueueType;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v5

    const-string/jumbo v7, "DirectoryPrefix"

    move-object/from16 v0, v23

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v22

    invoke-direct {v0, v5, v7}, Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;)V

    .line 106
    .restart local v22    # "batchQueueConfiguration":Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
    :cond_1
    new-instance v38, Ljava/util/HashSet;

    invoke-direct/range {v38 .. v38}, Ljava/util/HashSet;-><init>()V

    .line 107
    .local v38, "networkTypes":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/client/metrics/configuration/NetworkType;>;"
    const-string/jumbo v5, "NetworkTypes"

    move-object/from16 v0, v35

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v39

    .line 108
    .local v39, "networkTypesJson":Lorg/json/JSONArray;
    const/16 v32, 0x0

    .local v32, "i":I
    :goto_1
    invoke-virtual/range {v39 .. v39}, Lorg/json/JSONArray;->length()I

    move-result v5

    move/from16 v0, v32

    if-ge v0, v5, :cond_4

    .line 109
    move-object/from16 v0, v39

    move/from16 v1, v32

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/client/metrics/configuration/NetworkType;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/NetworkType;

    move-result-object v5

    move-object/from16 v0, v38

    invoke-interface {v0, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 108
    add-int/lit8 v32, v32, 0x1

    goto :goto_1

    .line 79
    .end local v22    # "batchQueueConfiguration":Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
    .end local v23    # "batchQueueConfigurationJson":Lorg/json/JSONObject;
    .end local v32    # "i":I
    .end local v35    # "metricsConfigJson":Lorg/json/JSONObject;
    .end local v38    # "networkTypes":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/client/metrics/configuration/NetworkType;>;"
    .end local v39    # "networkTypesJson":Lorg/json/JSONArray;
    .end local v46    # "transportType":Lcom/amazon/client/metrics/configuration/TransportType;
    :cond_2
    move-object/from16 v0, v36

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    sget-object v5, Landroid/os/Build;->TYPE:Ljava/lang/String;

    const-string/jumbo v7, "userdebug"

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 80
    move-object/from16 v0, v36

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v35

    .line 81
    .restart local v35    # "metricsConfigJson":Lorg/json/JSONObject;
    sget-object v5, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "MetricsConfigurationParser"

    const-string/jumbo v8, "Picking configuration"

    const/4 v9, 0x6

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string/jumbo v11, "Domain"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    const-string/jumbo v11, "master"

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string/jumbo v11, "Build"

    aput-object v11, v9, v10

    const/4 v10, 0x3

    sget-object v11, Landroid/os/Build;->TYPE:Ljava/lang/String;

    aput-object v11, v9, v10

    const/4 v10, 0x4

    const-string/jumbo v11, "isDebuggable"

    aput-object v11, v9, v10

    const/4 v10, 0x5

    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mIsDebuggable:Z

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-virtual {v5, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    goto/16 :goto_0

    .line 207
    .end local v27    # "configurationFileContents":Ljava/lang/String;
    .end local v28    # "devo":Ljava/lang/String;
    .end local v34    # "master":Ljava/lang/String;
    .end local v35    # "metricsConfigJson":Lorg/json/JSONObject;
    .end local v36    # "metricsJSON":Lorg/json/JSONObject;
    .end local v45    # "prod":Ljava/lang/String;
    :catch_0
    move-exception v29

    .line 208
    .local v29, "e":Ljava/io/IOException;
    new-instance v5, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v7, "An IOException was throw was parsing the metrics configuration file"

    move-object/from16 v0, v29

    invoke-direct {v5, v7, v0}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 83
    .end local v29    # "e":Ljava/io/IOException;
    .restart local v27    # "configurationFileContents":Ljava/lang/String;
    .restart local v28    # "devo":Ljava/lang/String;
    .restart local v34    # "master":Ljava/lang/String;
    .restart local v36    # "metricsJSON":Lorg/json/JSONObject;
    .restart local v45    # "prod":Ljava/lang/String;
    :cond_3
    :try_start_1
    move-object/from16 v0, v36

    move-object/from16 v1, v45

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v35

    .line 84
    .restart local v35    # "metricsConfigJson":Lorg/json/JSONObject;
    sget-object v5, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "MetricsConfigurationParser"

    const-string/jumbo v8, "Picking configuration"

    const/4 v9, 0x6

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    const-string/jumbo v11, "Domain"

    aput-object v11, v9, v10

    const/4 v10, 0x1

    const-string/jumbo v11, "prod"

    aput-object v11, v9, v10

    const/4 v10, 0x2

    const-string/jumbo v11, "Build"

    aput-object v11, v9, v10

    const/4 v10, 0x3

    sget-object v11, Landroid/os/Build;->TYPE:Ljava/lang/String;

    aput-object v11, v9, v10

    const/4 v10, 0x4

    const-string/jumbo v11, "isDebuggable"

    aput-object v11, v9, v10

    const/4 v10, 0x5

    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/amazon/client/metrics/configuration/MetricsConfigurationParser;->mIsDebuggable:Z

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-virtual {v5, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 210
    .end local v27    # "configurationFileContents":Ljava/lang/String;
    .end local v28    # "devo":Ljava/lang/String;
    .end local v34    # "master":Ljava/lang/String;
    .end local v35    # "metricsConfigJson":Lorg/json/JSONObject;
    .end local v36    # "metricsJSON":Lorg/json/JSONObject;
    .end local v45    # "prod":Ljava/lang/String;
    :catch_1
    move-exception v29

    .line 211
    .local v29, "e":Lorg/json/JSONException;
    new-instance v5, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;

    const-string/jumbo v7, "An JSONException was throw was parsing the metrics configuration file"

    move-object/from16 v0, v29

    invoke-direct {v5, v7, v0}, Lcom/amazon/client/metrics/configuration/MetricsConfigurationException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v5

    .line 114
    .end local v29    # "e":Lorg/json/JSONException;
    .restart local v22    # "batchQueueConfiguration":Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;
    .restart local v23    # "batchQueueConfigurationJson":Lorg/json/JSONObject;
    .restart local v27    # "configurationFileContents":Ljava/lang/String;
    .restart local v28    # "devo":Ljava/lang/String;
    .restart local v32    # "i":I
    .restart local v34    # "master":Ljava/lang/String;
    .restart local v35    # "metricsConfigJson":Lorg/json/JSONObject;
    .restart local v36    # "metricsJSON":Lorg/json/JSONObject;
    .restart local v38    # "networkTypes":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/client/metrics/configuration/NetworkType;>;"
    .restart local v39    # "networkTypesJson":Lorg/json/JSONArray;
    .restart local v45    # "prod":Ljava/lang/String;
    .restart local v46    # "transportType":Lcom/amazon/client/metrics/configuration/TransportType;
    :cond_4
    :try_start_2
    new-instance v37, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;

    move-object/from16 v0, v37

    move-object/from16 v1, v46

    move-object/from16 v2, v38

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/configuration/MetricsNetworkConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/TransportType;Ljava/util/Set;)V

    .line 117
    .local v37, "networkConfiguration":Lcom/amazon/client/metrics/configuration/NetworkConfiguration;
    const-string/jumbo v5, "CodecConfiguration"

    move-object/from16 v0, v35

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v26

    .line 118
    .local v26, "codecConfigurationJson":Lorg/json/JSONObject;
    new-instance v25, Lcom/amazon/client/metrics/configuration/CodecConfiguration;

    const-string/jumbo v5, "Type"

    move-object/from16 v0, v26

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/client/metrics/configuration/CodecType;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/CodecType;

    move-result-object v5

    const-string/jumbo v7, "Version"

    move-object/from16 v0, v26

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    move-object/from16 v0, v25

    invoke-direct {v0, v5, v7}, Lcom/amazon/client/metrics/configuration/CodecConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/CodecType;Ljava/lang/String;)V

    .line 123
    .local v25, "codecConfiguration":Lcom/amazon/client/metrics/configuration/CodecConfiguration;
    const-string/jumbo v5, "HttpConfiguration"

    move-object/from16 v0, v35

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v31

    .line 125
    .local v31, "httpConfigurationJson":Lorg/json/JSONObject;
    if-eqz v31, :cond_6

    .line 126
    new-instance v30, Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    const-string/jumbo v5, "RequestSignerType"

    move-object/from16 v0, v31

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    move-result-object v5

    const-string/jumbo v7, "UrlEndpoint"

    move-object/from16 v0, v31

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    const-string/jumbo v8, "StaticCredentialUrlEndpoint"

    move-object/from16 v0, v31

    invoke-virtual {v0, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    move-object/from16 v0, v30

    invoke-direct {v0, v5, v7, v8}, Lcom/amazon/client/metrics/configuration/HttpConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    .local v30, "httpConfiguration":Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    :goto_2
    new-instance v43, Ljava/util/HashMap;

    invoke-direct/range {v43 .. v43}, Ljava/util/HashMap;-><init>()V

    .line 139
    .local v43, "priorityMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/client/metrics/Priority;>;"
    const-string/jumbo v5, "NormalPriority"

    sget-object v7, Lcom/amazon/client/metrics/Priority;->NORMAL:Lcom/amazon/client/metrics/Priority;

    move-object/from16 v0, v43

    invoke-interface {v0, v5, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 140
    const-string/jumbo v5, "HighPriority"

    sget-object v7, Lcom/amazon/client/metrics/Priority;->HIGH:Lcom/amazon/client/metrics/Priority;

    move-object/from16 v0, v43

    invoke-interface {v0, v5, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 141
    const-string/jumbo v5, "ReservedForLocationServicePriority"

    sget-object v7, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_LOCATION_SERVICE:Lcom/amazon/client/metrics/Priority;

    move-object/from16 v0, v43

    invoke-interface {v0, v5, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    const-string/jumbo v5, "ReservedForNonAnonymousMetricsPriority"

    sget-object v7, Lcom/amazon/client/metrics/Priority;->RESERVED_FOR_NON_ANONYMOUS_METRICS:Lcom/amazon/client/metrics/Priority;

    move-object/from16 v0, v43

    invoke-interface {v0, v5, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    const-string/jumbo v5, "PipelineConfiguration"

    move-object/from16 v0, v35

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v40

    .line 145
    .local v40, "pipelineConfigurationJson":Lorg/json/JSONObject;
    new-instance v41, Ljava/util/HashMap;

    invoke-direct/range {v41 .. v41}, Ljava/util/HashMap;-><init>()V

    .line 148
    .local v41, "pipelineConfigurationMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;>;"
    invoke-interface/range {v43 .. v43}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v33

    .local v33, "i$":Ljava/util/Iterator;
    :cond_5
    :goto_3
    invoke-interface/range {v33 .. v33}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_a

    invoke-interface/range {v33 .. v33}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v44

    check-cast v44, Ljava/util/Map$Entry;

    .line 149
    .local v44, "priorityMapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/client/metrics/Priority;>;"
    invoke-interface/range {v44 .. v44}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    move-object/from16 v0, v40

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v42

    .line 153
    .local v42, "pipelinePriorityConfigurationJson":Lorg/json/JSONObject;
    if-eqz v42, :cond_5

    .line 157
    const-string/jumbo v5, "BatchQueueType"

    move-object/from16 v0, v42

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 158
    .local v24, "batchQueueTypeString":Ljava/lang/String;
    const-string/jumbo v5, "BatchQueueDirectoryPrefix"

    move-object/from16 v0, v42

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 159
    .local v6, "batchQueueDirectoryPrefixString":Ljava/lang/String;
    const-string/jumbo v5, ""

    move-object/from16 v0, v24

    if-ne v0, v5, :cond_9

    .line 160
    if-nez v23, :cond_8

    .line 162
    new-instance v5, Lorg/json/JSONException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Missing Batch Queue type for priority: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {v44 .. v44}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 131
    .end local v6    # "batchQueueDirectoryPrefixString":Ljava/lang/String;
    .end local v24    # "batchQueueTypeString":Ljava/lang/String;
    .end local v30    # "httpConfiguration":Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    .end local v33    # "i$":Ljava/util/Iterator;
    .end local v40    # "pipelineConfigurationJson":Lorg/json/JSONObject;
    .end local v41    # "pipelineConfigurationMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;>;"
    .end local v42    # "pipelinePriorityConfigurationJson":Lorg/json/JSONObject;
    .end local v43    # "priorityMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/client/metrics/Priority;>;"
    .end local v44    # "priorityMapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/client/metrics/Priority;>;"
    :cond_6
    new-instance v30, Lcom/amazon/client/metrics/configuration/HttpConfiguration;

    sget-object v7, Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;->OAUTH:Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;

    sget-object v5, Landroid/os/Build;->TYPE:Ljava/lang/String;

    const-string/jumbo v8, "eng"

    invoke-virtual {v5, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    const-string/jumbo v5, "https://dp-mont.integ.amazon.com:443"

    :goto_4
    const-string/jumbo v8, "https://device-metrics-us-2.amazon.com:443"

    move-object/from16 v0, v30

    invoke-direct {v0, v7, v5, v8}, Lcom/amazon/client/metrics/configuration/HttpConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/HttpRequestSignerType;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v30    # "httpConfiguration":Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    goto/16 :goto_2

    .end local v30    # "httpConfiguration":Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    :cond_7
    const-string/jumbo v5, "https://device-metrics-us.amazon.com:443"

    goto :goto_4

    .line 167
    .restart local v6    # "batchQueueDirectoryPrefixString":Ljava/lang/String;
    .restart local v24    # "batchQueueTypeString":Ljava/lang/String;
    .restart local v30    # "httpConfiguration":Lcom/amazon/client/metrics/configuration/HttpConfiguration;
    .restart local v33    # "i$":Ljava/util/Iterator;
    .restart local v40    # "pipelineConfigurationJson":Lorg/json/JSONObject;
    .restart local v41    # "pipelineConfigurationMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/client/metrics/Priority;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;>;"
    .restart local v42    # "pipelinePriorityConfigurationJson":Lorg/json/JSONObject;
    .restart local v43    # "priorityMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/client/metrics/Priority;>;"
    .restart local v44    # "priorityMapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/client/metrics/Priority;>;"
    :cond_8
    const-string/jumbo v5, "Type"

    move-object/from16 v0, v23

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    .line 168
    const-string/jumbo v5, "DirectoryPrefix"

    move-object/from16 v0, v23

    invoke-virtual {v0, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 172
    :cond_9
    new-instance v4, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;

    invoke-static/range {v24 .. v24}, Lcom/amazon/client/metrics/configuration/BatchQueueType;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/BatchQueueType;

    move-result-object v5

    const-string/jumbo v7, "MaxBatchOpenTimeMillis"

    move-object/from16 v0, v42

    invoke-virtual {v0, v7}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v7

    const-string/jumbo v9, "CheckBatchOpenTimeMillis"

    move-object/from16 v0, v42

    invoke-virtual {v0, v9}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v9

    const-string/jumbo v11, "MaxBatchEntries"

    move-object/from16 v0, v42

    invoke-virtual {v0, v11}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v11

    const-string/jumbo v12, "MaxBatchSizeBytes"

    move-object/from16 v0, v42

    invoke-virtual {v0, v12}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v12

    const-string/jumbo v13, "MaxBatchQueueCapacityBytes"

    move-object/from16 v0, v42

    invoke-virtual {v0, v13}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v13

    const-string/jumbo v14, "MaxBatchQueueEntries"

    move-object/from16 v0, v42

    invoke-virtual {v0, v14}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v14

    const-string/jumbo v15, "ExpiryTimeMillis"

    move-object/from16 v0, v42

    invoke-virtual {v0, v15}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v15

    const-string/jumbo v17, "PurgePeriodMillis"

    move-object/from16 v0, v42

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v17

    const-string/jumbo v19, "TransmissionPeriodMillis"

    move-object/from16 v0, v42

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getLong(Ljava/lang/String;)J

    move-result-wide v19

    const-string/jumbo v21, "BatchTransmitterType"

    move-object/from16 v0, v42

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Lcom/amazon/client/metrics/configuration/BatchTransmitterType;->fromString(Ljava/lang/String;)Lcom/amazon/client/metrics/configuration/BatchTransmitterType;

    move-result-object v21

    invoke-direct/range {v4 .. v21}, Lcom/amazon/client/metrics/configuration/MetricsBatchPipelineConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/BatchQueueType;Ljava/lang/String;JJIIIIJJJLcom/amazon/client/metrics/configuration/BatchTransmitterType;)V

    .line 187
    .local v4, "pipelineConfiguration":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    invoke-interface/range {v44 .. v44}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    move-object/from16 v0, v41

    invoke-interface {v0, v5, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 193
    .end local v4    # "pipelineConfiguration":Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .end local v6    # "batchQueueDirectoryPrefixString":Ljava/lang/String;
    .end local v24    # "batchQueueTypeString":Ljava/lang/String;
    .end local v42    # "pipelinePriorityConfigurationJson":Lorg/json/JSONObject;
    .end local v44    # "priorityMapEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/client/metrics/Priority;>;"
    :cond_a
    if-eqz v23, :cond_b

    .line 194
    new-instance v7, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    move-object/from16 v8, v37

    move-object/from16 v9, v22

    move-object/from16 v10, v25

    move-object/from16 v11, v30

    move-object/from16 v12, v41

    invoke-direct/range {v7 .. v12}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/NetworkConfiguration;Lcom/amazon/client/metrics/configuration/BatchQueueConfiguration;Lcom/amazon/client/metrics/configuration/CodecConfiguration;Lcom/amazon/client/metrics/configuration/HttpConfiguration;Ljava/util/Map;)V

    .line 201
    :goto_5
    return-object v7

    :cond_b
    new-instance v7, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;

    move-object/from16 v0, v37

    move-object/from16 v1, v25

    move-object/from16 v2, v30

    move-object/from16 v3, v41

    invoke-direct {v7, v0, v1, v2, v3}, Lcom/amazon/client/metrics/configuration/MetricsConfiguration;-><init>(Lcom/amazon/client/metrics/configuration/NetworkConfiguration;Lcom/amazon/client/metrics/configuration/CodecConfiguration;Lcom/amazon/client/metrics/configuration/HttpConfiguration;Ljava/util/Map;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_5
.end method
