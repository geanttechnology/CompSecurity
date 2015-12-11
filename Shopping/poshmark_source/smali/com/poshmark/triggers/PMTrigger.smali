.class public abstract Lcom/poshmark/triggers/PMTrigger;
.super Ljava/lang/Object;
.source "PMTrigger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/triggers/PMTrigger$TriggerState;
    }
.end annotation


# instance fields
.field currentCount:I

.field currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

.field savedTriggers:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    sget-object v0, Lcom/poshmark/triggers/PMTrigger$TriggerState;->INITIAL:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    iput-object v0, p0, Lcom/poshmark/triggers/PMTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    .line 17
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/triggers/PMTrigger;->currentCount:I

    return-void
.end method


# virtual methods
.method public abstract fetchTriggerFromPrefs()V
.end method

.method public getCurrentState()Lcom/poshmark/triggers/PMTrigger$TriggerState;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/poshmark/triggers/PMTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    return-object v0
.end method

.method public abstract getThresholdForState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)I
.end method

.method public incrementViewCount()V
    .locals 2

    .prologue
    .line 60
    iget-object v1, p0, Lcom/poshmark/triggers/PMTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {p0, v1}, Lcom/poshmark/triggers/PMTrigger;->getThresholdForState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)I

    move-result v0

    .line 61
    .local v0, "thresholdVal":I
    iget v1, p0, Lcom/poshmark/triggers/PMTrigger;->currentCount:I

    add-int/lit8 v1, v1, 0x1

    if-gt v1, v0, :cond_0

    .line 62
    iget v1, p0, Lcom/poshmark/triggers/PMTrigger;->currentCount:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/poshmark/triggers/PMTrigger;->currentCount:I

    .line 64
    :cond_0
    return-void
.end method

.method protected initPrefsObject()V
    .locals 4

    .prologue
    .line 50
    iget-object v1, p0, Lcom/poshmark/triggers/PMTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    if-nez v1, :cond_0

    .line 51
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 52
    .local v0, "userId":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 53
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "_Triggers"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/triggers/PMTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    .line 57
    .end local v0    # "userId":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public abstract isValid()Z
.end method

.method protected saveTrigger()V
    .locals 6

    .prologue
    .line 36
    iget-object v3, p0, Lcom/poshmark/triggers/PMTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    if-eqz v3, :cond_0

    .line 37
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->toString()Ljava/lang/String;

    move-result-object v1

    .line 38
    .local v1, "key":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/triggers/PMTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 39
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_count"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iget v4, p0, Lcom/poshmark/triggers/PMTrigger;->currentCount:I

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 40
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "_state"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/triggers/PMTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v4}, Lcom/poshmark/triggers/PMTrigger$TriggerState;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 41
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 42
    iget-object v3, p0, Lcom/poshmark/triggers/PMTrigger;->savedTriggers:Landroid/content/SharedPreferences;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "_state"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 43
    .local v2, "state":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 44
    const-string v3, "Saved TRigger"

    invoke-static {v3, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 47
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "state":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V
    .locals 1
    .param p1, "state"    # Lcom/poshmark/triggers/PMTrigger$TriggerState;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/poshmark/triggers/PMTrigger;->currentState:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    .line 27
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/triggers/PMTrigger;->currentCount:I

    .line 28
    invoke-virtual {p0}, Lcom/poshmark/triggers/PMTrigger;->saveTrigger()V

    .line 29
    return-void
.end method

.method public abstract shouldFireTrigger()Z
.end method
