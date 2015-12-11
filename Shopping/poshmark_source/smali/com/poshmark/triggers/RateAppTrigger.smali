.class public Lcom/poshmark/triggers/RateAppTrigger;
.super Lcom/poshmark/triggers/PMTrigger;
.source "RateAppTrigger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/triggers/RateAppTrigger$1;
    }
.end annotation


# instance fields
.field appVersion:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/poshmark/triggers/PMTrigger;-><init>()V

    .line 18
    invoke-virtual {p0}, Lcom/poshmark/triggers/RateAppTrigger;->fetchTriggerFromPrefs()V

    .line 19
    return-void
.end method


# virtual methods
.method public fetchTriggerFromPrefs()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 68
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    .line 69
    .local v2, "userId":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 70
    invoke-virtual {p0}, Lcom/poshmark/triggers/RateAppTrigger;->initPrefsObject()V

    .line 71
    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    if-eqz v3, :cond_0

    .line 72
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->toString()Ljava/lang/String;

    move-result-object v0

    .line 73
    .local v0, "key":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_state"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 74
    .local v1, "state":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 75
    invoke-static {v1}, Lcom/poshmark/triggers/PMTrigger$TriggerState;->valueOf(Ljava/lang/String;)Lcom/poshmark/triggers/PMTrigger$TriggerState;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    .line 76
    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_count"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v3

    iput v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->currentCount:I

    .line 77
    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_version"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v6}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->appVersion:Ljava/lang/String;

    .line 81
    .end local v0    # "key":Ljava/lang/String;
    .end local v1    # "state":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public getThresholdForState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)I
    .locals 3
    .param p1, "state"    # Lcom/poshmark/triggers/PMTrigger$TriggerState;

    .prologue
    .line 51
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->getRateAppTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;

    move-result-object v0

    .line 52
    .local v0, "thresholds":Lcom/poshmark/triggers/TriggerThresholds;
    if-eqz v0, :cond_0

    .line 53
    sget-object v1, Lcom/poshmark/triggers/RateAppTrigger$1;->$SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState:[I

    invoke-virtual {p1}, Lcom/poshmark/triggers/PMTrigger$TriggerState;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 64
    :cond_0
    const v1, 0x7fffffff

    :goto_0
    return v1

    .line 55
    :pswitch_0
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->initial_threshold:I

    goto :goto_0

    .line 57
    :pswitch_1
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_ignored_threshold:I

    goto :goto_0

    .line 59
    :pswitch_2
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_clicked_threshold:I

    goto :goto_0

    .line 61
    :pswitch_3
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_dismissed_threshold:I

    goto :goto_0

    .line 53
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public isValid()Z
    .locals 2

    .prologue
    .line 23
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->getRateAppTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;

    move-result-object v0

    .line 24
    .local v0, "rateAppThresholds":Lcom/poshmark/triggers/TriggerThresholds;
    if-nez v0, :cond_0

    .line 25
    const/4 v1, 0x0

    .line 27
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public saveTrigger()V
    .locals 4

    .prologue
    .line 85
    invoke-super {p0}, Lcom/poshmark/triggers/PMTrigger;->saveTrigger()V

    .line 86
    iget-object v2, p0, Lcom/poshmark/triggers/RateAppTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    if-eqz v2, :cond_0

    .line 87
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->toString()Ljava/lang/String;

    move-result-object v1

    .line 88
    .local v1, "key":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/triggers/RateAppTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 89
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    iput-object v2, p0, Lcom/poshmark/triggers/RateAppTrigger;->appVersion:Ljava/lang/String;

    .line 90
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_version"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->appVersion:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 91
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 93
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "key":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public shouldFireTrigger()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 33
    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {p0, v3}, Lcom/poshmark/triggers/RateAppTrigger;->getThresholdForState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)I

    move-result v0

    .line 34
    .local v0, "thresholdVal":I
    iget v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->currentCount:I

    if-lt v3, v0, :cond_2

    .line 36
    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    sget-object v4, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INTERACTED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    if-ne v3, v4, :cond_0

    .line 37
    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->appVersion:Ljava/lang/String;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/triggers/RateAppTrigger;->appVersion:Ljava/lang/String;

    invoke-static {}, Lcom/poshmark/application/AppInfo;->getInstance()Lcom/poshmark/application/AppInfo;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/application/AppInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 46
    :cond_0
    :goto_0
    return v1

    :cond_1
    move v1, v2

    .line 40
    goto :goto_0

    :cond_2
    move v1, v2

    .line 46
    goto :goto_0
.end method
