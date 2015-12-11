.class public Lcom/auditude/ads/loader/AdRequest;
.super Ljava/lang/Object;
.source "AdRequest.java"


# instance fields
.field private aamSegments:[Ljava/lang/String;

.field private aamUuid:Ljava/lang/String;

.field private data:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private domain:Ljava/lang/String;

.field private mediaId:Ljava/lang/Object;

.field private timeout:I

.field private useSSL:Z

.field private zoneId:I


# direct methods
.method public constructor <init>(Ljava/lang/Object;ILjava/lang/String;Ljava/util/HashMap;I)V
    .locals 1
    .param p1, "mediaId"    # Ljava/lang/Object;
    .param p2, "zoneId"    # I
    .param p3, "domain"    # Ljava/lang/String;
    .param p5, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "I",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 30
    .local p4, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/loader/AdRequest;->useSSL:Z

    .line 32
    iput p2, p0, Lcom/auditude/ads/loader/AdRequest;->zoneId:I

    .line 33
    iput-object p3, p0, Lcom/auditude/ads/loader/AdRequest;->domain:Ljava/lang/String;

    .line 34
    iput-object p1, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    .line 35
    iput-object p4, p0, Lcom/auditude/ads/loader/AdRequest;->data:Ljava/util/HashMap;

    .line 36
    iput p5, p0, Lcom/auditude/ads/loader/AdRequest;->timeout:I

    .line 38
    iget v0, p0, Lcom/auditude/ads/loader/AdRequest;->timeout:I

    if-gez v0, :cond_0

    const/4 p5, 0x0

    .line 39
    :cond_0
    return-void
.end method

.method private getGeoString()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v3, 0x0

    .line 242
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v4

    invoke-virtual {v4}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v0

    .line 243
    .local v0, "adSettings":Lcom/auditude/ads/core/AdSettings;
    const-string v4, "auditudeParamZipCode"

    invoke-virtual {v0, v4}, Lcom/auditude/ads/core/AdSettings;->getCustomParamValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4, v3}, Lcom/auditude/ads/util/ObjectUtil;->convertToString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 244
    .local v2, "zipCode":Ljava/lang/String;
    const-string v4, "auditudeParamCountryCode"

    invoke-virtual {v0, v4}, Lcom/auditude/ads/core/AdSettings;->getCustomParamValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4, v3}, Lcom/auditude/ads/util/ObjectUtil;->convertToString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 246
    .local v1, "countryCode":Ljava/lang/String;
    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-static {v1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 248
    :goto_0
    return-object v3

    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, ";"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ";;;"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ";;"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method private getGroupId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 236
    const-string v0, "1000005"

    return-object v0
.end method

.method private getTimelineString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 211
    iget-object v0, p0, Lcom/auditude/ads/loader/AdRequest;->data:Ljava/util/HashMap;

    .line 213
    .local v0, "customParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz v0, :cond_0

    const-string v1, "auditudeTimeline"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 215
    :cond_0
    const/4 v1, 0x0

    .line 218
    :goto_0
    return-object v1

    :cond_1
    const-string v1, "auditudeTimeline"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public final getAdRequestUrl()Ljava/lang/String;
    .locals 11

    .prologue
    const/4 v5, 0x0

    .line 134
    iget-object v8, p0, Lcom/auditude/ads/loader/AdRequest;->domain:Ljava/lang/String;

    if-eqz v8, :cond_0

    iget-object v8, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    if-eqz v8, :cond_0

    iget v8, p0, Lcom/auditude/ads/loader/AdRequest;->zoneId:I

    if-gtz v8, :cond_1

    .line 206
    :cond_0
    :goto_0
    return-object v5

    .line 139
    :cond_1
    new-instance v7, Ljava/lang/StringBuilder;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v8, "http"

    invoke-direct {v9, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v8, p0, Lcom/auditude/ads/loader/AdRequest;->useSSL:Z

    if-eqz v8, :cond_8

    const-string v8, "s"

    :goto_1
    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "://"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 141
    .local v7, "url":Ljava/lang/StringBuilder;
    const-string v0, ""

    .line 142
    .local v0, "adRequestDomain":Ljava/lang/String;
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v8

    invoke-virtual {v8}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v1

    .line 143
    .local v1, "adSettings":Lcom/auditude/ads/core/AdSettings;
    const-string v8, "adRequestDomain"

    invoke-virtual {v1, v8}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    if-eqz v8, :cond_2

    .line 145
    const-string v8, "adRequestDomain"

    invoke-virtual {v1, v8}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 147
    const-string v8, "adRequestDomain"

    invoke-virtual {v1, v8}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 151
    :cond_2
    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_9

    .line 153
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "/adserver?"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 161
    :goto_2
    iget-object v8, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    instance-of v8, v8, Ljava/lang/Iterable;

    if-eqz v8, :cond_d

    .line 163
    iget-object v8, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    instance-of v8, v8, Ljava/lang/Iterable;

    if-eqz v8, :cond_3

    iget-object v8, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    check-cast v8, Ljava/lang/Iterable;

    move-object v5, v8

    .line 164
    .local v5, "mediaIds":Ljava/lang/Iterable;, "Ljava/lang/Iterable<*>;"
    :cond_3
    const/4 v3, 0x0

    .line 165
    .local v3, "i":I
    invoke-interface {v5}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_4
    :goto_3
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-nez v8, :cond_b

    .line 187
    .end local v3    # "i":I
    .end local v5    # "mediaIds":Ljava/lang/Iterable;, "Ljava/lang/Iterable<*>;"
    :cond_5
    :goto_4
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "&z="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v9, p0, Lcom/auditude/ads/loader/AdRequest;->zoneId:I

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 188
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "&l="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v9, Lcom/auditude/ads/util/AuditudeUtil$LocaltimeTagResult;

    invoke-direct {v9}, Lcom/auditude/ads/util/AuditudeUtil$LocaltimeTagResult;-><init>()V

    invoke-virtual {v9}, Lcom/auditude/ads/util/AuditudeUtil$LocaltimeTagResult;->getResult()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    const-string v8, "&of=1.4"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 190
    const-string v8, "&tm=15"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 191
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "&g="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/auditude/ads/loader/AdRequest;->getGroupId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 193
    invoke-direct {p0}, Lcom/auditude/ads/loader/AdRequest;->getGeoString()Ljava/lang/String;

    move-result-object v2

    .line 194
    .local v2, "geoString":Ljava/lang/String;
    invoke-static {v2}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 196
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "&geo="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v2}, Lcom/auditude/ads/util/URLUtil;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 199
    :cond_6
    invoke-direct {p0}, Lcom/auditude/ads/loader/AdRequest;->getTimelineString()Ljava/lang/String;

    move-result-object v6

    .line 200
    .local v6, "timelineString":Ljava/lang/String;
    invoke-static {v6}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 202
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "&tl="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 206
    :cond_7
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_0

    .line 139
    .end local v0    # "adRequestDomain":Ljava/lang/String;
    .end local v1    # "adSettings":Lcom/auditude/ads/core/AdSettings;
    .end local v2    # "geoString":Ljava/lang/String;
    .end local v6    # "timelineString":Ljava/lang/String;
    .end local v7    # "url":Ljava/lang/StringBuilder;
    :cond_8
    const-string v8, ""

    goto/16 :goto_1

    .line 157
    .restart local v0    # "adRequestDomain":Ljava/lang/String;
    .restart local v1    # "adSettings":Lcom/auditude/ads/core/AdSettings;
    .restart local v7    # "url":Ljava/lang/StringBuilder;
    :cond_9
    iget-object v8, p0, Lcom/auditude/ads/loader/AdRequest;->domain:Ljava/lang/String;

    invoke-static {v8}, Lcom/auditude/ads/util/URLUtil;->isIPAddress(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_a

    const-string v8, "ad."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 158
    :cond_a
    new-instance v8, Ljava/lang/StringBuilder;

    iget-object v9, p0, Lcom/auditude/ads/loader/AdRequest;->domain:Ljava/lang/String;

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "/adserver?"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_2

    .line 165
    .restart local v3    # "i":I
    .restart local v5    # "mediaIds":Ljava/lang/Iterable;, "Ljava/lang/Iterable<*>;"
    :cond_b
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 167
    .local v4, "id":Ljava/lang/Object;
    if-eqz v4, :cond_4

    move-object v8, v4

    .line 169
    check-cast v8, Ljava/lang/String;

    invoke-static {v8}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_4

    .line 174
    if-lez v3, :cond_c

    .line 176
    const-string v8, "&"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 178
    :cond_c
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v10, "u="

    invoke-direct {v8, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    check-cast v4, Ljava/lang/String;

    .end local v4    # "id":Ljava/lang/Object;
    invoke-static {v4}, Lcom/auditude/ads/util/MD5;->GetMd5String(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 179
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_3

    .line 182
    .end local v3    # "i":I
    .end local v5    # "mediaIds":Ljava/lang/Iterable;, "Ljava/lang/Iterable<*>;"
    :cond_d
    iget-object v8, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    invoke-virtual {v8}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    const-class v9, Ljava/lang/String;

    if-ne v8, v9, :cond_5

    .line 184
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "u="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/auditude/ads/util/MD5;->GetMd5String(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_4
.end method

.method public final getKeyValueString()Ljava/lang/String;
    .locals 16

    .prologue
    const/4 v12, 0x0

    .line 63
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/auditude/ads/loader/AdRequest;->data:Ljava/util/HashMap;

    .line 65
    .local v1, "customParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    if-eqz v1, :cond_0

    const-string v11, "userData"

    invoke-virtual {v1, v11}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_1

    .line 67
    :cond_0
    const/4 v11, 0x0

    .line 129
    :goto_0
    return-object v11

    .line 70
    :cond_1
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, ""

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 72
    .local v10, "sb":Ljava/lang/StringBuilder;
    const-string v11, "userData"

    invoke-virtual {v1, v11}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 73
    .local v2, "data":Ljava/lang/Object;
    if-nez v2, :cond_2

    .line 75
    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_0

    .line 78
    :cond_2
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v11

    const-class v13, Ljava/lang/String;

    if-ne v11, v13, :cond_3

    move-object v11, v2

    .line 80
    check-cast v11, Ljava/lang/String;

    const-string v13, ";"

    invoke-virtual {v11, v13}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 82
    .local v8, "pairs":[Ljava/lang/String;
    if-eqz v8, :cond_3

    array-length v11, v8

    if-lez v11, :cond_3

    .line 84
    array-length v13, v8

    move v11, v12

    :goto_1
    if-lt v11, v13, :cond_7

    .line 96
    .end local v8    # "pairs":[Ljava/lang/String;
    :cond_3
    instance-of v11, v2, Ljava/util/Map;

    if-eqz v11, :cond_4

    .line 101
    :try_start_0
    move-object v0, v2

    check-cast v0, Ljava/util/Map;

    move-object v6, v0

    .line 102
    .local v6, "mp":Ljava/util/Map;, "Ljava/util/Map<**>;"
    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 103
    .local v5, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v11

    if-nez v11, :cond_9

    .line 116
    .end local v5    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .end local v6    # "mp":Ljava/util/Map;, "Ljava/util/Map<**>;"
    :cond_4
    :goto_3
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/auditude/ads/loader/AdRequest;->aamSegments:[Ljava/lang/String;

    if-eqz v11, :cond_5

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/auditude/ads/loader/AdRequest;->aamSegments:[Ljava/lang/String;

    array-length v11, v11

    if-lez v11, :cond_5

    .line 118
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_4
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/auditude/ads/loader/AdRequest;->aamSegments:[Ljava/lang/String;

    array-length v11, v11

    if-lt v3, v11, :cond_a

    .line 124
    .end local v3    # "i":I
    :cond_5
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/auditude/ads/loader/AdRequest;->aamUuid:Ljava/lang/String;

    if-eqz v11, :cond_6

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/auditude/ads/loader/AdRequest;->aamUuid:Ljava/lang/String;

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v11

    if-lez v11, :cond_6

    .line 126
    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "aud_aam_uuid="

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/auditude/ads/loader/AdRequest;->aamUuid:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "\n"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 129
    :cond_6
    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto/16 :goto_0

    .line 84
    .restart local v8    # "pairs":[Ljava/lang/String;
    :cond_7
    aget-object v7, v8, v11

    .line 86
    .local v7, "pair":Ljava/lang/String;
    const-string v14, "="

    invoke-virtual {v7, v14}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 87
    .local v4, "idx":I
    if-gtz v4, :cond_8

    .line 84
    :goto_5
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 91
    :cond_8
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-virtual {v7, v12, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Lcom/auditude/ads/util/URLUtil;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v15, "="

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    add-int/lit8 v15, v4, 0x1

    invoke-virtual {v7, v15}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v15

    invoke-static {v15}, Lcom/auditude/ads/util/URLUtil;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string v15, "\n"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v10, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_5

    .line 105
    .end local v4    # "idx":I
    .end local v7    # "pair":Ljava/lang/String;
    .end local v8    # "pairs":[Ljava/lang/String;
    .restart local v5    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .restart local v6    # "mp":Ljava/util/Map;, "Ljava/util/Map<**>;"
    :cond_9
    :try_start_1
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    .line 106
    .local v9, "pairs":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<**>;"
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Lcom/auditude/ads/util/URLUtil;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Lcom/auditude/ads/util/URLUtil;->urlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "\n"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 107
    invoke-interface {v5}, Ljava/util/Iterator;->remove()V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_2

    .line 110
    .end local v5    # "it":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    .end local v6    # "mp":Ljava/util/Map;, "Ljava/util/Map<**>;"
    .end local v9    # "pairs":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<**>;"
    :catch_0
    move-exception v11

    goto/16 :goto_3

    .line 120
    .restart local v3    # "i":I
    :cond_a
    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "aud_aam_segs="

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/auditude/ads/loader/AdRequest;->aamSegments:[Ljava/lang/String;

    aget-object v12, v12, v3

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "\n"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 118
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_4
.end method

.method public final getMediaId()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/auditude/ads/loader/AdRequest;->mediaId:Ljava/lang/Object;

    return-object v0
.end method

.method public final setAamSegments([Ljava/lang/String;)V
    .locals 0
    .param p1, "segmentsValues"    # [Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/auditude/ads/loader/AdRequest;->aamSegments:[Ljava/lang/String;

    .line 48
    return-void
.end method

.method public final setAamUuid(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/auditude/ads/loader/AdRequest;->aamUuid:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public final setUseSSL(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 43
    iput-boolean p1, p0, Lcom/auditude/ads/loader/AdRequest;->useSSL:Z

    return-void
.end method
