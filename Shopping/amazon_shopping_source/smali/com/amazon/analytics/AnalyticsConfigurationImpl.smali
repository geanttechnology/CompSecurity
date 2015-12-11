.class Lcom/amazon/analytics/AnalyticsConfigurationImpl;
.super Ljava/lang/Object;
.source "AnalyticsConfigurationImpl.java"

# interfaces
.implements Lcom/amazon/analytics/AnalyticsConfiguration;


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private volatile featureConfig:Lcom/amazon/mas/client/featureconfig/FeatureConfig;

.field private final featureConfigLocator:Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;

.field private final memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;)V
    .locals 1
    .param p1, "featureConfigLocator"    # Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->featureConfig:Lcom/amazon/mas/client/featureconfig/FeatureConfig;

    .line 41
    new-instance v0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-direct {v0}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;-><init>()V

    iput-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    .line 42
    iput-object p1, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->featureConfigLocator:Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;

    .line 43
    invoke-virtual {p0}, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->refresh()V

    .line 44
    return-void
.end method


# virtual methods
.method public getBoolean(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)Z
    .locals 3
    .param p1, "setting"    # Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .prologue
    .line 88
    iget-object v1, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {p1}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->getKey()Ljava/lang/String;

    move-result-object v2

    const-class v0, Ljava/lang/Boolean;

    invoke-virtual {p1, v0}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->getDefaultValue(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->optBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public getCommaDelimitedStringList(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)Ljava/util/List;
    .locals 6
    .param p1, "setting"    # Lcom/amazon/analytics/AnalyticsConfiguration$Setting;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/analytics/AnalyticsConfiguration$Setting;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 112
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 113
    .local v1, "tokens":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v4, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {p1}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->getKey()Ljava/lang/String;

    move-result-object v5

    const-class v3, Ljava/lang/String;

    invoke-virtual {p1, v3}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->getDefaultValue(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v4, v5, v3}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 114
    .local v2, "values":Ljava/lang/String;
    new-instance v0, Ljava/util/StringTokenizer;

    const-string/jumbo v3, ","

    invoke-direct {v0, v2, v3}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    .local v0, "tokenizer":Ljava/util/StringTokenizer;
    :goto_0
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 117
    invoke-virtual {v0}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 119
    :cond_0
    return-object v1
.end method

.method public getInt(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)I
    .locals 3
    .param p1, "setting"    # Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .prologue
    .line 104
    iget-object v1, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {p1}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->getKey()Ljava/lang/String;

    move-result-object v2

    const-class v0, Ljava/lang/Integer;

    invoke-virtual {p1, v0}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->getDefaultValue(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->optInt(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method getUnderlyingConfig()Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    return-object v0
.end method

.method public refresh()V
    .locals 7

    .prologue
    .line 55
    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {v5}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->refresh()V

    .line 56
    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->featureConfigLocator:Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;

    if-eqz v5, :cond_2

    .line 57
    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->featureConfigLocator:Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;

    const-string/jumbo v6, "analytics"

    invoke-virtual {v5, v6}, Lcom/amazon/mas/client/featureconfig/FeatureConfigLocator;->getFeatureConfig(Ljava/lang/String;)Lcom/amazon/mas/client/featureconfig/FeatureConfig;

    move-result-object v2

    .line 58
    .local v2, "featureConfig":Lcom/amazon/mas/client/featureconfig/FeatureConfig;
    if-eqz v2, :cond_2

    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->featureConfig:Lcom/amazon/mas/client/featureconfig/FeatureConfig;

    if-eq v5, v2, :cond_2

    .line 59
    monitor-enter p0

    .line 60
    :try_start_0
    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->featureConfig:Lcom/amazon/mas/client/featureconfig/FeatureConfig;

    if-eq v5, v2, :cond_1

    .line 61
    invoke-virtual {v2}, Lcom/amazon/mas/client/featureconfig/FeatureConfig;->getConfigurationData()Lorg/json/JSONObject;

    move-result-object v0

    .line 62
    .local v0, "analyticsConfigJson":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 63
    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {v5}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->getAllProperties()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Map;->clear()V

    .line 65
    invoke-virtual {v0}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 66
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 67
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 69
    .local v4, "key":Ljava/lang/String;
    :try_start_1
    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {v0, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v4, v6}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 70
    :catch_0
    move-exception v1

    .line 71
    .local v1, "e":Lorg/json/JSONException;
    :try_start_2
    sget-object v5, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v6, "JSON parse error in refresh"

    invoke-virtual {v5, v6, v1}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 78
    .end local v0    # "analyticsConfigJson":Lorg/json/JSONObject;
    .end local v1    # "e":Lorg/json/JSONException;
    .end local v3    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v4    # "key":Ljava/lang/String;
    :catchall_0
    move-exception v5

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v5

    .line 75
    .restart local v0    # "analyticsConfigJson":Lorg/json/JSONObject;
    :cond_0
    :try_start_3
    iput-object v2, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->featureConfig:Lcom/amazon/mas/client/featureconfig/FeatureConfig;

    .line 76
    iget-object v5, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {v5}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->notifyRefreshListeners()V

    .line 78
    .end local v0    # "analyticsConfigJson":Lorg/json/JSONObject;
    :cond_1
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 81
    .end local v2    # "featureConfig":Lcom/amazon/mas/client/featureconfig/FeatureConfig;
    :cond_2
    return-void
.end method

.method public registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "configurationChangedListener"    # Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationImpl;->memConfig:Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;->registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 129
    return-void
.end method
