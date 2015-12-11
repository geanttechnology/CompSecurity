.class public Lcom/auditude/ads/response/AudienceManager;
.super Ljava/lang/Object;
.source "AudienceManager.java"

# interfaces
.implements Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;
    }
.end annotation


# instance fields
.field private aamUrl:Ljava/lang/String;

.field private dataLoader:Lcom/auditude/ads/loader/DataLoader;

.field private listener:Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;

.field private segmentsValues:[Ljava/lang/String;

.field private timeout:I

.field private uuid:Ljava/lang/String;


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "timeout"    # I

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput p1, p0, Lcom/auditude/ads/response/AudienceManager;->timeout:I

    .line 35
    return-void
.end method

.method private loadData()Ljava/lang/Boolean;
    .locals 15

    .prologue
    const/4 v14, 0x0

    .line 143
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v9

    invoke-virtual {v9}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v9

    const-string v10, "applicationContext"

    invoke-virtual {v9, v10}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 144
    .local v0, "appContext":Landroid/content/Context;
    if-eqz v0, :cond_3

    .line 148
    :try_start_0
    const-string v9, "aud_aam_segs"

    const/4 v10, 0x0

    invoke-virtual {v0, v9, v10}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 149
    .local v1, "data":Landroid/content/SharedPreferences;
    const-string v9, "aud_aam_segs_expire"

    const/4 v10, 0x0

    invoke-interface {v1, v9, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 150
    .local v3, "dateString":Ljava/lang/String;
    const-string v9, "aamUrl"

    const/4 v10, 0x0

    invoke-interface {v1, v9, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 151
    .local v6, "nUrl":Ljava/lang/String;
    if-eqz v3, :cond_2

    .line 153
    new-instance v2, Ljava/util/Date;

    invoke-direct {v2, v3}, Ljava/util/Date;-><init>(Ljava/lang/String;)V

    .line 154
    .local v2, "date":Ljava/util/Date;
    new-instance v7, Ljava/util/Date;

    invoke-direct {v7}, Ljava/util/Date;-><init>()V

    .line 155
    .local v7, "now":Ljava/util/Date;
    invoke-virtual {v7}, Ljava/util/Date;->getTime()J

    move-result-wide v10

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    sub-long/2addr v10, v12

    long-to-int v4, v10

    .line 156
    .local v4, "dif":I
    const v9, 0x5265c00

    if-ge v4, v9, :cond_1

    iget-object v9, p0, Lcom/auditude/ads/response/AudienceManager;->aamUrl:Ljava/lang/String;

    invoke-virtual {v6, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 158
    const-string v9, "aud_aam_segs"

    const/4 v10, 0x0

    invoke-interface {v1, v9, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 159
    .local v8, "segString":Ljava/lang/String;
    if-eqz v8, :cond_0

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v9

    if-lez v9, :cond_0

    .line 161
    const-string v9, ","

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v9

    iput-object v9, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;

    .line 163
    :cond_0
    const-string v9, "aud_aam_uuid"

    const/4 v10, 0x0

    invoke-interface {v1, v9, v10}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    iput-object v9, p0, Lcom/auditude/ads/response/AudienceManager;->uuid:Ljava/lang/String;

    .line 164
    const/4 v9, 0x1

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    .line 183
    .end local v1    # "data":Landroid/content/SharedPreferences;
    .end local v2    # "date":Ljava/util/Date;
    .end local v3    # "dateString":Ljava/lang/String;
    .end local v4    # "dif":I
    .end local v6    # "nUrl":Ljava/lang/String;
    .end local v7    # "now":Ljava/util/Date;
    .end local v8    # "segString":Ljava/lang/String;
    :goto_0
    return-object v9

    .line 168
    .restart local v1    # "data":Landroid/content/SharedPreferences;
    .restart local v2    # "date":Ljava/util/Date;
    .restart local v3    # "dateString":Ljava/lang/String;
    .restart local v4    # "dif":I
    .restart local v6    # "nUrl":Ljava/lang/String;
    .restart local v7    # "now":Ljava/util/Date;
    :cond_1
    const/4 v9, 0x0

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    goto :goto_0

    .line 173
    .end local v2    # "date":Ljava/util/Date;
    .end local v4    # "dif":I
    .end local v7    # "now":Ljava/util/Date;
    :cond_2
    const/4 v9, 0x0

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v9

    goto :goto_0

    .line 176
    .end local v1    # "data":Landroid/content/SharedPreferences;
    .end local v3    # "dateString":Ljava/lang/String;
    .end local v6    # "nUrl":Ljava/lang/String;
    :catch_0
    move-exception v5

    .line 178
    .local v5, "e":Ljava/lang/Exception;
    invoke-static {v14}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    goto :goto_0

    .line 183
    .end local v5    # "e":Ljava/lang/Exception;
    :cond_3
    invoke-static {v14}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    goto :goto_0
.end method

.method private saveData()V
    .locals 8

    .prologue
    .line 110
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v6

    invoke-virtual {v6}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v6

    const-string v7, "applicationContext"

    invoke-virtual {v6, v7}, Lcom/auditude/ads/core/AdSettings;->getProperty(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 111
    .local v0, "appContext":Landroid/content/Context;
    if-eqz v0, :cond_2

    .line 115
    :try_start_0
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    .line 116
    .local v4, "now":Ljava/util/Date;
    const-string v6, "aud_aam_segs"

    const/4 v7, 0x0

    invoke-virtual {v0, v6, v7}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 117
    .local v1, "data":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 118
    .local v2, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    .line 119
    const-string v6, "aud_aam_segs_expire"

    invoke-virtual {v4}, Ljava/util/Date;->toGMTString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 120
    const-string v6, "aamUrl"

    iget-object v7, p0, Lcom/auditude/ads/response/AudienceManager;->aamUrl:Ljava/lang/String;

    invoke-interface {v2, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 121
    iget-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->uuid:Ljava/lang/String;

    if-eqz v6, :cond_0

    const-string v6, "aud_aam_uuid"

    iget-object v7, p0, Lcom/auditude/ads/response/AudienceManager;->uuid:Ljava/lang/String;

    invoke-interface {v2, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 123
    :cond_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 124
    .local v5, "sb":Ljava/lang/StringBuilder;
    iget-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;

    if-eqz v6, :cond_1

    iget-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;

    array-length v6, v6

    if-lez v6, :cond_1

    .line 126
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    iget-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;

    array-length v6, v6

    if-lt v3, v6, :cond_3

    .line 130
    const-string v6, "aud_aam_segs"

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v6, v7}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 132
    .end local v3    # "i":I
    :cond_1
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 139
    .end local v1    # "data":Landroid/content/SharedPreferences;
    .end local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v4    # "now":Ljava/util/Date;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    :cond_2
    :goto_1
    return-void

    .line 128
    .restart local v1    # "data":Landroid/content/SharedPreferences;
    .restart local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    .restart local v3    # "i":I
    .restart local v4    # "now":Ljava/util/Date;
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    :cond_3
    new-instance v6, Ljava/lang/StringBuilder;

    iget-object v7, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;

    aget-object v7, v7, v3

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, ","

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 126
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 134
    .end local v1    # "data":Landroid/content/SharedPreferences;
    .end local v2    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v3    # "i":I
    .end local v4    # "now":Ljava/util/Date;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    :catch_0
    move-exception v6

    goto :goto_1
.end method


# virtual methods
.method public getSegmentsValues()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;

    return-object v0
.end method

.method public getUuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/auditude/ads/response/AudienceManager;->uuid:Ljava/lang/String;

    return-object v0
.end method

.method public loadSegmentData(Ljava/lang/String;)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 39
    iput-object p1, p0, Lcom/auditude/ads/response/AudienceManager;->aamUrl:Ljava/lang/String;

    .line 40
    iput-object v3, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;

    .line 41
    iput-object v3, p0, Lcom/auditude/ads/response/AudienceManager;->uuid:Ljava/lang/String;

    .line 43
    invoke-direct {p0}, Lcom/auditude/ads/response/AudienceManager;->loadData()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/auditude/ads/response/AudienceManager;->listener:Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;

    invoke-interface {v0}, Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;->onAudienceManagerComplete()V

    .line 53
    :goto_0
    return-void

    .line 49
    :cond_0
    new-instance v0, Lcom/auditude/ads/loader/DataLoader;

    invoke-direct {v0}, Lcom/auditude/ads/loader/DataLoader;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/response/AudienceManager;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    .line 50
    iget-object v0, p0, Lcom/auditude/ads/response/AudienceManager;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    invoke-virtual {v0, p0}, Lcom/auditude/ads/loader/DataLoader;->setDataLoaderListener(Lcom/auditude/ads/loader/DataLoader$DataLoaderListener;)V

    .line 51
    iget-object v0, p0, Lcom/auditude/ads/response/AudienceManager;->dataLoader:Lcom/auditude/ads/loader/DataLoader;

    iget-object v1, p0, Lcom/auditude/ads/response/AudienceManager;->aamUrl:Ljava/lang/String;

    iget v2, p0, Lcom/auditude/ads/response/AudienceManager;->timeout:I

    invoke-virtual {v0, v1, v3, v2}, Lcom/auditude/ads/loader/DataLoader;->load(Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public onRequestComplete(Ljava/lang/String;)V
    .locals 9
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    .line 61
    :try_start_0
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 62
    .local v4, "jResponse":Lorg/json/JSONObject;
    const-string v6, "uuid"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->uuid:Ljava/lang/String;

    .line 63
    const-string v6, "stuff"

    invoke-virtual {v4, v6}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    .line 65
    .local v2, "jArray":Lorg/json/JSONArray;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-lt v1, v6, :cond_0

    .line 78
    invoke-direct {p0}, Lcom/auditude/ads/response/AudienceManager;->saveData()V

    .line 79
    iget-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->listener:Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;

    invoke-interface {v6}, Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;->onAudienceManagerComplete()V

    .line 85
    .end local v1    # "i":I
    .end local v2    # "jArray":Lorg/json/JSONArray;
    .end local v4    # "jResponse":Lorg/json/JSONObject;
    :goto_1
    return-void

    .line 67
    .restart local v1    # "i":I
    .restart local v2    # "jArray":Lorg/json/JSONArray;
    .restart local v4    # "jResponse":Lorg/json/JSONObject;
    :cond_0
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 69
    .local v3, "jNode":Lorg/json/JSONObject;
    const-string v6, "cn"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    const-string v7, "aud"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    const-string v6, "cv"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 71
    const-string v6, "cv"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 72
    .local v5, "kvArray":[Ljava/lang/String;
    if-eqz v5, :cond_1

    array-length v6, v5

    if-le v6, v8, :cond_1

    const/4 v6, 0x0

    aget-object v6, v5, v6

    const-string v7, "segs"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    const/4 v6, 0x1

    aget-object v6, v5, v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_1

    .line 74
    const/4 v6, 0x1

    aget-object v6, v5, v6

    const-string v7, ","

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->segmentsValues:[Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    .end local v5    # "kvArray":[Ljava/lang/String;
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 81
    .end local v1    # "i":I
    .end local v2    # "jArray":Lorg/json/JSONArray;
    .end local v3    # "jNode":Lorg/json/JSONObject;
    .end local v4    # "jResponse":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 83
    .local v0, "e":Ljava/lang/Exception;
    iget-object v6, p0, Lcom/auditude/ads/response/AudienceManager;->listener:Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;

    invoke-interface {v6, v0}, Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;->onAudienceManagerFailed(Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public onRequestFailed(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 89
    iget-object v0, p0, Lcom/auditude/ads/response/AudienceManager;->listener:Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;

    invoke-interface {v0, p1}, Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;->onAudienceManagerFailed(Ljava/lang/Throwable;)V

    .line 90
    return-void
.end method

.method public setAudienceManagerListener(Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/auditude/ads/response/AudienceManager;->listener:Lcom/auditude/ads/response/AudienceManager$AudienceManagerListener;

    return-void
.end method
