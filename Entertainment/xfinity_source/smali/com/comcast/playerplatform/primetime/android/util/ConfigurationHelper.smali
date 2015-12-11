.class public Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;
.super Ljava/lang/Object;
.source "ConfigurationHelper.java"


# instance fields
.field private appContext:Landroid/content/Context;

.field private configurationManager:Lcom/comcast/playerplatform/util/android/ConfigurationManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->configurationManager:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    if-nez v0, :cond_0

    .line 24
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->configurationManager:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    .line 26
    :cond_0
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->appContext:Landroid/content/Context;

    .line 31
    return-void
.end method

.method private parseConfigString(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/Metadata;
    .locals 10
    .param p1, "metadataBase"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 101
    const/4 v5, 0x0

    .line 102
    .local v5, "metadata":Lcom/adobe/mediacore/metadata/MetadataNode;
    invoke-static {p1}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 103
    new-instance v5, Lcom/adobe/mediacore/metadata/MetadataNode;

    .end local v5    # "metadata":Lcom/adobe/mediacore/metadata/MetadataNode;
    invoke-direct {v5}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    .line 104
    .restart local v5    # "metadata":Lcom/adobe/mediacore/metadata/MetadataNode;
    const-string v7, ";"

    invoke-virtual {p1, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 105
    .local v6, "splitString":[Ljava/lang/String;
    move-object v0, v6

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_3

    aget-object v2, v0, v1

    .line 106
    .local v2, "item":Ljava/lang/String;
    const-string v7, "="

    invoke-virtual {v2, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 107
    .local v3, "itemSplit":[Ljava/lang/String;
    array-length v7, v3

    const/4 v8, 0x2

    if-ne v7, v8, :cond_0

    aget-object v7, v3, v9

    invoke-static {v7}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 108
    aget-object v7, v3, v9

    const-string v8, "device"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->appContext:Landroid/content/Context;

    if-eqz v7, :cond_2

    .line 109
    iget-object v7, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->appContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/comcast/playerplatform/primetime/android/R$bool;->isTablet:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 110
    aget-object v7, v3, v9

    const-string v8, "androidtablet"

    invoke-virtual {v5, v7, v8}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 112
    :cond_1
    aget-object v7, v3, v9

    const-string v8, "android"

    invoke-virtual {v5, v7, v8}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 115
    :cond_2
    aget-object v7, v3, v9

    const/4 v8, 0x1

    aget-object v8, v3, v8

    invoke-virtual {v5, v7, v8}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 121
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "i$":I
    .end local v2    # "item":Ljava/lang/String;
    .end local v3    # "itemSplit":[Ljava/lang/String;
    .end local v4    # "len$":I
    .end local v6    # "splitString":[Ljava/lang/String;
    :cond_3
    return-object v5
.end method


# virtual methods
.method public getAbrPolicy()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    const-string v0, "AbrPolicy"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAlertPollingInterval()J
    .locals 2

    .prologue
    .line 55
    const-string v0, "EasUpdateInterval"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method public getAlertServiceURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    const-string v0, "AlertServiceEndPoint"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAuditudeDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    const-string v0, "DomainId"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAuditudeParameters()Lcom/adobe/mediacore/metadata/Metadata;
    .locals 2

    .prologue
    .line 93
    const-string v1, "CustomParams"

    invoke-virtual {p0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 95
    .local v0, "nonParsedValue":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->parseConfigString(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v1

    return-object v1
.end method

.method public getAuditudeZone()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    const-string v0, "ZoneId"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getComscoreParameters()Ljava/util/Map;
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v10, 0x0

    .line 142
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 144
    .local v5, "metadata":Ljava/util/Map;
    const-string v8, "ComscoreParams"

    invoke-virtual {p0, v8}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 145
    .local v6, "nonParsedValue":Ljava/lang/String;
    invoke-static {v6}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 146
    const-string v8, ";"

    invoke-virtual {v6, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    .line 147
    .local v7, "splitString":[Ljava/lang/String;
    move-object v0, v7

    .local v0, "arr$":[Ljava/lang/String;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v4, :cond_1

    aget-object v2, v0, v1

    .line 148
    .local v2, "item":Ljava/lang/String;
    const-string v8, "="

    invoke-virtual {v2, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 149
    .local v3, "itemSplit":[Ljava/lang/String;
    array-length v8, v3

    const/4 v9, 0x2

    if-ne v8, v9, :cond_0

    aget-object v8, v3, v10

    invoke-static {v8}, Lcom/comcast/playerplatform/util/android/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 150
    aget-object v8, v3, v10

    const/4 v9, 0x1

    aget-object v9, v3, v9

    invoke-interface {v5, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 155
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "i$":I
    .end local v2    # "item":Ljava/lang/String;
    .end local v3    # "itemSplit":[Ljava/lang/String;
    .end local v4    # "len$":I
    .end local v7    # "splitString":[Ljava/lang/String;
    :cond_1
    return-object v5
.end method

.method public getHeartBeatInterval()I
    .locals 1

    .prologue
    .line 81
    const-string v0, "HeartbeatInterval"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getInitialBitrate()I
    .locals 1

    .prologue
    .line 69
    const-string v0, "InitialBitrate"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getInitialBuffer()J
    .locals 2

    .prologue
    .line 133
    const-string v0, "InitialBuffer"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method public getLinearBuffer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    const-string v0, "PlayingLinearBufferTime"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMaxBitrate()I
    .locals 1

    .prologue
    .line 73
    const-string v0, "MaximumBitrate"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getMinBitrate()I
    .locals 1

    .prologue
    .line 77
    const-string v0, "MinimumBitrate"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getPartnerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    const-string v0, "PartnerId"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPlaybackBuffer()J
    .locals 2

    .prologue
    .line 137
    const-string v0, "PlaybackBuffer"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method public getValue(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->configurationManager:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->configurationManager:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->configurationManager:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getConfigValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 63
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getZipsToFipsURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    const-string v0, "ZipToFipsEndPoint"

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isEspnReady()Z
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/util/ConfigurationHelper;->configurationManager:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isEspnReady()Z

    move-result v0

    return v0
.end method
