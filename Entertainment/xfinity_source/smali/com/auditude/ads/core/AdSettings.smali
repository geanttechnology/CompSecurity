.class public Lcom/auditude/ads/core/AdSettings;
.super Ljava/lang/Object;
.source "AdSettings.java"


# instance fields
.field private aamSegments:[Ljava/lang/String;

.field private aamUuid:Ljava/lang/String;

.field private adProperties:Ljava/util/HashMap;
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

.field private customParams:Ljava/util/HashMap;
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

.field pcs:Ljava/beans/PropertyChangeSupport;

.field private zoneId:I


# direct methods
.method public constructor <init>()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/high16 v3, 0x3f400000    # 0.75f

    const/4 v2, 0x0

    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/core/AdSettings;->adProperties:Ljava/util/HashMap;

    .line 25
    new-instance v0, Ljava/beans/PropertyChangeSupport;

    invoke-direct {v0, p0}, Ljava/beans/PropertyChangeSupport;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/auditude/ads/core/AdSettings;->pcs:Ljava/beans/PropertyChangeSupport;

    .line 29
    const-string v0, "bitrate"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 30
    const-string v0, "leftVolume"

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 31
    const-string v0, "rightVolume"

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 32
    const-string v0, "width"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 33
    const-string v0, "height"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 34
    const-string v0, "auditudeHandlesChapterBreaks"

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 35
    const-string v0, "auditudeHandlesLinearVideoAds"

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 36
    const-string v0, "userAgent"

    const-string v1, ""

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 37
    const-string v0, "useSSL"

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 38
    return-void
.end method


# virtual methods
.method public final getBitRate()I
    .locals 1

    .prologue
    .line 114
    const-string v0, "bitrate"

    invoke-virtual {p0, v0}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getCustomParamValue(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 142
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/core/AdSettings;->customParams:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    .line 144
    iget-object v0, p0, Lcom/auditude/ads/core/AdSettings;->customParams:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 147
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/auditude/ads/core/AdSettings;->domain:Ljava/lang/String;

    return-object v0
.end method

.method public final getPassThroughParams()Ljava/util/HashMap;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v9, 0x0

    .line 153
    const/4 v6, 0x0

    .line 154
    .local v6, "passThroughParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->customParams:Ljava/util/HashMap;

    if-eqz v8, :cond_6

    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->customParams:Ljava/util/HashMap;

    const-string v10, "auditudePassThroughParams"

    invoke-virtual {v8, v10}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->customParams:Ljava/util/HashMap;

    const-string v10, "auditudePassThroughParams"

    invoke-virtual {v8, v10}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 155
    .local v1, "data":Ljava/lang/Object;
    :goto_0
    if-eqz v1, :cond_9

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v8

    const-class v10, Ljava/lang/String;

    if-ne v8, v10, :cond_9

    .line 157
    new-instance v6, Ljava/util/HashMap;

    .end local v6    # "passThroughParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 158
    .restart local v6    # "passThroughParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    check-cast v1, Ljava/lang/String;

    .end local v1    # "data":Ljava/lang/Object;
    const-string v8, ";"

    invoke-virtual {v1, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 159
    .local v5, "pairs":[Ljava/lang/String;
    if-eqz v5, :cond_0

    array-length v8, v5

    if-lez v8, :cond_0

    .line 161
    array-length v10, v5

    move v8, v9

    :goto_1
    if-lt v8, v10, :cond_7

    .line 182
    .end local v5    # "pairs":[Ljava/lang/String;
    :cond_0
    :goto_2
    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamSegments:[Ljava/lang/String;

    if-eqz v8, :cond_1

    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamSegments:[Ljava/lang/String;

    array-length v8, v8

    if-gtz v8, :cond_2

    :cond_1
    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamUuid:Ljava/lang/String;

    if-eqz v8, :cond_5

    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamUuid:Ljava/lang/String;

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_5

    .line 184
    :cond_2
    if-nez v6, :cond_3

    new-instance v6, Ljava/util/HashMap;

    .end local v6    # "passThroughParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v6}, Ljava/util/HashMap;-><init>()V

    .line 185
    .restart local v6    # "passThroughParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 187
    .local v7, "sb":Ljava/lang/StringBuilder;
    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamSegments:[Ljava/lang/String;

    if-eqz v8, :cond_4

    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamSegments:[Ljava/lang/String;

    array-length v8, v8

    if-lez v8, :cond_4

    .line 189
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_3
    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamSegments:[Ljava/lang/String;

    array-length v8, v8

    if-lt v2, v8, :cond_a

    .line 193
    const-string v8, "aud_aam_segs"

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 195
    .end local v2    # "i":I
    :cond_4
    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamUuid:Ljava/lang/String;

    if-eqz v8, :cond_5

    iget-object v8, p0, Lcom/auditude/ads/core/AdSettings;->aamUuid:Ljava/lang/String;

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_5

    .line 197
    const-string v8, "aud_aam_uuid"

    iget-object v9, p0, Lcom/auditude/ads/core/AdSettings;->aamUuid:Ljava/lang/String;

    invoke-virtual {v6, v8, v9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    .end local v7    # "sb":Ljava/lang/StringBuilder;
    :cond_5
    return-object v6

    .line 154
    :cond_6
    const/4 v1, 0x0

    goto :goto_0

    .line 161
    .restart local v5    # "pairs":[Ljava/lang/String;
    :cond_7
    aget-object v4, v5, v8

    .line 163
    .local v4, "pair":Ljava/lang/String;
    const-string v11, "="

    invoke-virtual {v4, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 164
    .local v3, "idx":I
    if-gtz v3, :cond_8

    .line 161
    :goto_4
    add-int/lit8 v8, v8, 0x1

    goto :goto_1

    .line 168
    :cond_8
    invoke-virtual {v4, v9, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v11

    add-int/lit8 v12, v3, 0x1

    invoke-virtual {v4, v12}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v6, v11, v12}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    .line 172
    .end local v3    # "idx":I
    .end local v4    # "pair":Ljava/lang/String;
    .end local v5    # "pairs":[Ljava/lang/String;
    .restart local v1    # "data":Ljava/lang/Object;
    :cond_9
    instance-of v8, v1, Ljava/util/HashMap;

    if-eqz v8, :cond_0

    .line 176
    :try_start_0
    move-object v0, v1

    check-cast v0, Ljava/util/HashMap;

    move-object v6, v0
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 191
    .end local v1    # "data":Ljava/lang/Object;
    .restart local v2    # "i":I
    .restart local v7    # "sb":Ljava/lang/StringBuilder;
    :cond_a
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "aud_aam_segs="

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/auditude/ads/core/AdSettings;->aamSegments:[Ljava/lang/String;

    aget-object v9, v9, v2

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ";"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 189
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 178
    .end local v2    # "i":I
    .end local v7    # "sb":Ljava/lang/StringBuilder;
    .restart local v1    # "data":Ljava/lang/Object;
    :catch_0
    move-exception v8

    goto/16 :goto_2
.end method

.method public final getProperty(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 235
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/core/AdSettings;->adProperties:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 237
    iget-object v0, p0, Lcom/auditude/ads/core/AdSettings;->adProperties:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 240
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getUserAgent()Ljava/lang/String;
    .locals 2

    .prologue
    .line 89
    const-string v0, "userAgent"

    invoke-virtual {p0, v0}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    const-string v1, ""

    invoke-static {v0, v1}, Lcom/auditude/ads/util/ObjectUtil;->convertToString(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final getZoneId()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/auditude/ads/core/AdSettings;->zoneId:I

    return v0
.end method

.method public final hasProperty(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 259
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/core/AdSettings;->adProperties:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final setAamSegments([Ljava/lang/String;)V
    .locals 0
    .param p1, "segmentsValues"    # [Ljava/lang/String;

    .prologue
    .line 132
    iput-object p1, p0, Lcom/auditude/ads/core/AdSettings;->aamSegments:[Ljava/lang/String;

    .line 133
    return-void
.end method

.method public final setAamUuid(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 137
    iput-object p1, p0, Lcom/auditude/ads/core/AdSettings;->aamUuid:Ljava/lang/String;

    .line 138
    return-void
.end method

.method public final setCustomParams(Ljava/util/HashMap;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 128
    .local p1, "value":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iput-object p1, p0, Lcom/auditude/ads/core/AdSettings;->customParams:Ljava/util/HashMap;

    .line 129
    return-void
.end method

.method public final setDomain(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/auditude/ads/core/AdSettings;->domain:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public final setProperty(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 210
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/auditude/ads/core/AdSettings;->setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 211
    return-void
.end method

.method public final setProperty(Ljava/lang/String;Ljava/lang/Object;Z)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .param p3, "notify"    # Z

    .prologue
    .line 215
    if-nez p1, :cond_1

    .line 231
    :cond_0
    :goto_0
    return-void

    .line 220
    :cond_1
    invoke-virtual {p0, p1}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 221
    .local v0, "oldValue":Ljava/lang/Object;
    iget-object v1, p0, Lcom/auditude/ads/core/AdSettings;->adProperties:Ljava/util/HashMap;

    invoke-virtual {v1, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    if-eq p2, v0, :cond_0

    .line 226
    if-eqz p3, :cond_0

    .line 228
    iget-object v1, p0, Lcom/auditude/ads/core/AdSettings;->pcs:Ljava/beans/PropertyChangeSupport;

    invoke-virtual {v1, p1, v0, p2}, Ljava/beans/PropertyChangeSupport;->firePropertyChange(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public final setZoneId(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 66
    iput p1, p0, Lcom/auditude/ads/core/AdSettings;->zoneId:I

    .line 67
    return-void
.end method
