.class public Lcom/poshmark/config/NewRelicWrapper;
.super Ljava/lang/Object;
.source "NewRelicWrapper.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static initNewRelic(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    new-instance v0, Lcom/newrelic/agent/android/logging/AndroidAgentLog;

    invoke-direct {v0}, Lcom/newrelic/agent/android/logging/AndroidAgentLog;-><init>()V

    .line 21
    .local v0, "log":Lcom/newrelic/agent/android/logging/AndroidAgentLog;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/newrelic/agent/android/logging/AndroidAgentLog;->setLevel(I)V

    .line 22
    invoke-static {v0}, Lcom/newrelic/agent/android/logging/AgentLogManager;->setAgentLog(Lcom/newrelic/agent/android/logging/AgentLog;)V

    .line 23
    const-string v1, "AAa319871d49ffd4ff9af36e15b2c6c6ed2d34ad2c"

    invoke-static {v1}, Lcom/newrelic/agent/android/NewRelic;->withApplicationToken(Ljava/lang/String;)Lcom/newrelic/agent/android/NewRelic;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/newrelic/agent/android/NewRelic;->withCrashReportingEnabled(Z)Lcom/newrelic/agent/android/NewRelic;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/newrelic/agent/android/NewRelic;->start(Landroid/content/Context;)V

    .line 24
    return-void
.end method

.method public static setNewRelicFragmentClassName(Ljava/lang/Class;)V
    .locals 1
    .param p0, "fragmentClass"    # Ljava/lang/Class;

    .prologue
    .line 27
    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/newrelic/agent/android/NewRelic;->setInteractionName(Ljava/lang/String;)V

    .line 28
    return-void
.end method

.method public static startCustomInteraction(Ljava/lang/String;)V
    .locals 0
    .param p0, "interactionName"    # Ljava/lang/String;

    .prologue
    .line 31
    invoke-static {p0}, Lcom/newrelic/agent/android/NewRelic;->startInteraction(Ljava/lang/String;)Ljava/lang/String;

    .line 32
    return-void
.end method

.method public static stopCustomInteraction(Ljava/lang/String;)V
    .locals 0
    .param p0, "interactionName"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-static {p0}, Lcom/newrelic/agent/android/NewRelic;->startInteraction(Ljava/lang/String;)Ljava/lang/String;

    .line 36
    return-void
.end method
