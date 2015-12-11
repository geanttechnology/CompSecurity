.class public Lcom/poshmark/triggers/BrandShareTrigger;
.super Lcom/poshmark/triggers/PMTrigger;
.source "BrandShareTrigger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/triggers/BrandShareTrigger$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/poshmark/triggers/PMTrigger;-><init>()V

    .line 15
    invoke-virtual {p0}, Lcom/poshmark/triggers/BrandShareTrigger;->fetchTriggerFromPrefs()V

    .line 16
    return-void
.end method


# virtual methods
.method public fetchTriggerFromPrefs()V
    .locals 6

    .prologue
    .line 56
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    .line 57
    .local v2, "userId":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 58
    invoke-virtual {p0}, Lcom/poshmark/triggers/BrandShareTrigger;->initPrefsObject()V

    .line 59
    iget-object v3, p0, Lcom/poshmark/triggers/BrandShareTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    if-eqz v3, :cond_0

    .line 60
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->toString()Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "key":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/triggers/BrandShareTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_state"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 62
    .local v1, "state":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 63
    invoke-static {v1}, Lcom/poshmark/triggers/PMTrigger$TriggerState;->valueOf(Ljava/lang/String;)Lcom/poshmark/triggers/PMTrigger$TriggerState;

    move-result-object v3

    iput-object v3, p0, Lcom/poshmark/triggers/BrandShareTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    .line 64
    iget-object v3, p0, Lcom/poshmark/triggers/BrandShareTrigger;->savedTriggers:Landroid/content/SharedPreferences;

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

    iput v3, p0, Lcom/poshmark/triggers/BrandShareTrigger;->currentCount:I

    .line 68
    .end local v0    # "key":Ljava/lang/String;
    .end local v1    # "state":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public getThresholdForState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)I
    .locals 3
    .param p1, "state"    # Lcom/poshmark/triggers/PMTrigger$TriggerState;

    .prologue
    .line 39
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->getBrandShareTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;

    move-result-object v0

    .line 40
    .local v0, "thresholds":Lcom/poshmark/triggers/TriggerThresholds;
    if-eqz v0, :cond_0

    .line 41
    sget-object v1, Lcom/poshmark/triggers/BrandShareTrigger$1;->$SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState:[I

    invoke-virtual {p1}, Lcom/poshmark/triggers/PMTrigger$TriggerState;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 52
    :cond_0
    const v1, 0x7fffffff

    :goto_0
    return v1

    .line 43
    :pswitch_0
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->initial_threshold:I

    goto :goto_0

    .line 45
    :pswitch_1
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_ignored_threshold:I

    goto :goto_0

    .line 47
    :pswitch_2
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_clicked_threshold:I

    goto :goto_0

    .line 49
    :pswitch_3
    iget v1, v0, Lcom/poshmark/triggers/TriggerThresholds;->repeat_dismissed_threshold:I

    goto :goto_0

    .line 41
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
    .line 20
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/utils/FeatureManager;->getBrandShareTriggerFeature()Lcom/poshmark/triggers/TriggerThresholds;

    move-result-object v0

    .line 21
    .local v0, "brandShareThresholds":Lcom/poshmark/triggers/TriggerThresholds;
    if-nez v0, :cond_0

    .line 22
    const/4 v1, 0x0

    .line 24
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public shouldFireTrigger()Z
    .locals 2

    .prologue
    .line 30
    iget-object v1, p0, Lcom/poshmark/triggers/BrandShareTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {p0, v1}, Lcom/poshmark/triggers/BrandShareTrigger;->getThresholdForState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)I

    move-result v0

    .line 31
    .local v0, "thresholdVal":I
    iget v1, p0, Lcom/poshmark/triggers/BrandShareTrigger;->currentCount:I

    if-lt v1, v0, :cond_0

    .line 32
    const/4 v1, 0x1

    .line 34
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
