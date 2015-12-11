.class public final Lcom/adobe/adms/measurement/ADMS_Churn;
.super Lcom/adobe/adms/measurement/ADMS_ChurnBase;
.source "ADMS_Churn.java"


# instance fields
.field private _appRunning:Z

.field private context:Landroid/content/Context;

.field private measurement:Lcom/adobe/adms/measurement/ADMS_Measurement;


# direct methods
.method protected constructor <init>(Lcom/adobe/adms/measurement/ADMS_Measurement;)V
    .locals 1
    .param p1, "measurementObj"    # Lcom/adobe/adms/measurement/ADMS_Measurement;

    .prologue
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0, p1}, Lcom/adobe/adms/measurement/ADMS_ChurnBase;-><init>(Lcom/adobe/adms/measurement/ADMS_MeasurementBase;)V

    .line 16
    iput-object v0, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->measurement:Lcom/adobe/adms/measurement/ADMS_Measurement;

    .line 17
    iput-object v0, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->context:Landroid/content/Context;

    .line 18
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->_appRunning:Z

    .line 33
    iput-object p1, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->measurement:Lcom/adobe/adms/measurement/ADMS_Measurement;

    .line 34
    return-void
.end method


# virtual methods
.method protected getApplicationName()Ljava/lang/String;
    .locals 5

    .prologue
    .line 175
    :try_start_0
    iget-object v3, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->measurement:Lcom/adobe/adms/measurement/ADMS_Measurement;

    iget-object v3, v3, Lcom/adobe/adms/measurement/ADMS_Measurement;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 176
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    iget-object v3, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->measurement:Lcom/adobe/adms/measurement/ADMS_Measurement;

    iget-object v3, v3, Lcom/adobe/adms/measurement/ADMS_Measurement;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 177
    .local v0, "applicationInfo":Landroid/content/pm/ApplicationInfo;
    invoke-virtual {v2, v0}, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;

    move-result-object v3

    check-cast v3, Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 181
    .end local v0    # "applicationInfo":Landroid/content/pm/ApplicationInfo;
    .end local v2    # "packageManager":Landroid/content/pm/PackageManager;
    :goto_0
    return-object v3

    .line 178
    :catch_0
    move-exception v1

    .line 179
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 181
    const/4 v3, 0x0

    goto :goto_0
.end method

.method protected getApplicationVersion()Ljava/lang/String;
    .locals 5

    .prologue
    .line 163
    :try_start_0
    iget-object v3, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->measurement:Lcom/adobe/adms/measurement/ADMS_Measurement;

    iget-object v3, v3, Lcom/adobe/adms/measurement/ADMS_Measurement;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 164
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    iget-object v3, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->measurement:Lcom/adobe/adms/measurement/ADMS_Measurement;

    iget-object v3, v3, Lcom/adobe/adms/measurement/ADMS_Measurement;->context:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 165
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v3, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 169
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v2    # "packageManager":Landroid/content/pm/PackageManager;
    :goto_0
    return-object v3

    .line 166
    :catch_0
    move-exception v0

    .line 167
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 169
    const-string v3, ""

    goto :goto_0
.end method

.method protected handleFBReferrer()V
    .locals 9

    .prologue
    const/4 v3, 0x0

    .line 70
    iget-object v4, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->context:Landroid/content/Context;

    if-nez v4, :cond_1

    .line 85
    :cond_0
    :goto_0
    return-void

    .line 73
    :cond_1
    const-string v4, "content://com.facebook.katana.provider.AttributionIdProvider"

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 74
    .local v1, "ATTRIBUTION_ID_CONTENT_URI":Landroid/net/Uri;
    const-string v6, "aid"

    .line 76
    .local v6, "ATTRIBUTION_ID_COLUMN_NAME":Ljava/lang/String;
    iget-object v4, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->context:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 78
    .local v0, "contentResolver":Landroid/content/ContentResolver;
    const/4 v4, 0x1

    new-array v2, v4, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v6, v2, v4

    .local v2, "projection":[Ljava/lang/String;
    move-object v4, v3

    move-object v5, v3

    .line 79
    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v8

    .line 80
    .local v8, "c":Landroid/database/Cursor;
    if-eqz v8, :cond_0

    invoke-interface {v8}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 83
    invoke-interface {v8, v6}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v8, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 84
    .local v7, "attributionId":Ljava/lang/String;
    const-string v3, "a.fb.attrib"

    invoke-virtual {p0, v7, v3}, Lcom/adobe/adms/measurement/ADMS_Churn;->setContextDataValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected handleGPReferrer()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 90
    const-string v5, "ADMS_ReferrerProcessed"

    const/4 v6, 0x0

    invoke-virtual {p0, v5, v6}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsGetBool(Ljava/lang/String;Z)Z

    move-result v5

    if-nez v5, :cond_0

    .line 91
    const-string v5, "utm_source"

    invoke-virtual {p0, v5, v7}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsGetString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 92
    .local v3, "source":Ljava/lang/String;
    const-string v5, "utm_medium"

    invoke-virtual {p0, v5, v7}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsGetString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 93
    .local v2, "medium":Ljava/lang/String;
    const-string v5, "utm_term"

    invoke-virtual {p0, v5, v7}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsGetString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 94
    .local v4, "term":Ljava/lang/String;
    const-string v5, "utm_content"

    invoke-virtual {p0, v5, v7}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsGetString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 95
    .local v1, "content":Ljava/lang/String;
    const-string v5, "utm_campaign"

    invoke-virtual {p0, v5, v7}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsGetString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 97
    .local v0, "campaign":Ljava/lang/String;
    if-eqz v3, :cond_0

    if-eqz v2, :cond_0

    if-eqz v0, :cond_0

    .line 99
    const-string v5, "a.referrer.campaign.source"

    invoke-virtual {p0, v3, v5}, Lcom/adobe/adms/measurement/ADMS_Churn;->setContextDataValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    const-string v5, "a.referrer.campaign.medium"

    invoke-virtual {p0, v2, v5}, Lcom/adobe/adms/measurement/ADMS_Churn;->setContextDataValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string v5, "a.referrer.campaign.term"

    invoke-virtual {p0, v4, v5}, Lcom/adobe/adms/measurement/ADMS_Churn;->setContextDataValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    const-string v5, "a.referrer.campaign.content"

    invoke-virtual {p0, v1, v5}, Lcom/adobe/adms/measurement/ADMS_Churn;->setContextDataValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 103
    const-string v5, "a.referrer.campaign.name"

    invoke-virtual {p0, v0, v5}, Lcom/adobe/adms/measurement/ADMS_Churn;->setContextDataValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    const-string v5, "ADMS_ReferrerProcessed"

    const/4 v6, 0x1

    invoke-virtual {p0, v5, v6}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsPutBool(Ljava/lang/String;Z)V

    .line 107
    .end local v0    # "campaign":Ljava/lang/String;
    .end local v1    # "content":Ljava/lang/String;
    .end local v2    # "medium":Ljava/lang/String;
    .end local v3    # "source":Ljava/lang/String;
    .end local v4    # "term":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method protected handleReferrers()V
    .locals 0

    .prologue
    .line 193
    invoke-virtual {p0}, Lcom/adobe/adms/measurement/ADMS_Churn;->handleGPReferrer()V

    .line 194
    return-void
.end method

.method protected prefsContains(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 157
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method protected prefsGetBool(Ljava/lang/String;Z)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Z

    .prologue
    .line 135
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method protected prefsGetInt(Ljava/lang/String;I)I
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 113
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method protected prefsGetLong(Ljava/lang/String;J)J
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 124
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method protected prefsGetString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 146
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->prefs:Landroid/content/SharedPreferences;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected prefsPutBool(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Z

    .prologue
    .line 140
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 141
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 142
    return-void
.end method

.method protected prefsPutInt(Ljava/lang/String;I)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # I

    .prologue
    .line 118
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 119
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 120
    return-void
.end method

.method protected prefsPutLong(Ljava/lang/String;J)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # J

    .prologue
    .line 129
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 130
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 131
    return-void
.end method

.method protected prefsPutString(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 151
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 152
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 153
    return-void
.end method

.method protected removeObjectFromPrefsWithKey(Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 186
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0, p1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 187
    sget-object v0, Lcom/adobe/adms/measurement/ADMS_Measurement;->editor:Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 188
    return-void
.end method

.method protected setGenericVariables()V
    .locals 2

    .prologue
    .line 63
    invoke-super {p0}, Lcom/adobe/adms/measurement/ADMS_ChurnBase;->setGenericVariables()V

    .line 65
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Android "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/adobe/adms/measurement/ADMS_Measurement;->getAndroidVersion()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->appEnvironmentEvar:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/adobe/adms/measurement/ADMS_Churn;->setContextDataValue(Ljava/lang/String;Ljava/lang/String;)V

    .line 66
    return-void
.end method

.method protected startActivity(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 37
    iput-object p1, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->context:Landroid/content/Context;

    .line 39
    iget-boolean v1, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->_appRunning:Z

    if-nez v1, :cond_1

    .line 40
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "open"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 41
    .local v0, "appOpenKey":Ljava/lang/String;
    invoke-virtual {p0, v0, v3}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsGetBool(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 42
    const-string v1, "ADMS_SuccessfulClose"

    invoke-virtual {p0, v1, v3}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsPutBool(Ljava/lang/String;Z)V

    .line 44
    :cond_0
    invoke-virtual {p0, v0, v4}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsPutBool(Ljava/lang/String;Z)V

    .line 45
    invoke-virtual {p0}, Lcom/adobe/adms/measurement/ADMS_Churn;->startSession()V

    .line 47
    .end local v0    # "appOpenKey":Ljava/lang/String;
    :cond_1
    iput-boolean v4, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->_appRunning:Z

    .line 48
    return-void
.end method

.method protected stopActivity(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    .line 51
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "open"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 52
    .local v0, "appOpenKey":Ljava/lang/String;
    invoke-virtual {p0, v0, v3}, Lcom/adobe/adms/measurement/ADMS_Churn;->prefsPutBool(Ljava/lang/String;Z)V

    .line 54
    invoke-virtual {p0}, Lcom/adobe/adms/measurement/ADMS_Churn;->stopSession()V

    .line 56
    iput-boolean v3, p0, Lcom/adobe/adms/measurement/ADMS_Churn;->_appRunning:Z

    .line 57
    return-void
.end method
