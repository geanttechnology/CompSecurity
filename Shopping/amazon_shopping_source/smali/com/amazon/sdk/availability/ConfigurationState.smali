.class public Lcom/amazon/sdk/availability/ConfigurationState;
.super Ljava/lang/Object;
.source "ConfigurationState.java"


# instance fields
.field private configurationExpiry:Ljava/lang/Long;

.field private configurationNextRefresh:Ljava/lang/Long;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v3, Lcom/amazon/sdk/availability/Preferences;

    invoke-direct {v3, p1}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 36
    .local v3, "preferences":Lcom/amazon/sdk/availability/Preferences;
    const-string/jumbo v4, "configurationExpiry"

    invoke-virtual {v3, v4}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 37
    .local v1, "expiryString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 39
    :try_start_0
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationExpiry:Ljava/lang/Long;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 45
    :cond_0
    :goto_0
    const-string/jumbo v4, "configurationNextRefresh"

    invoke-virtual {v3, v4}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "nextRefreshString":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 48
    :try_start_1
    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationNextRefresh:Ljava/lang/Long;
    :try_end_1
    .catch Ljava/lang/NumberFormatException; {:try_start_1 .. :try_end_1} :catch_1

    .line 53
    :cond_1
    :goto_1
    return-void

    .line 40
    .end local v2    # "nextRefreshString":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 41
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "error parsing configuration expiry: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 49
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    .restart local v2    # "nextRefreshString":Ljava/lang/String;
    :catch_1
    move-exception v0

    .line 50
    .restart local v0    # "e":Ljava/lang/NumberFormatException;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "error parsing configuration refresh: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v0}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method


# virtual methods
.method public getConfigurationExpiry()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationExpiry:Ljava/lang/Long;

    return-object v0
.end method

.method public getConfigurationNextRefresh()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationNextRefresh:Ljava/lang/Long;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 119
    const-string/jumbo v0, "{\n\t\"configurationExpiry\" : %s,\n\t\"nextRefresh\" : %s\n}"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/ConfigurationState;->getConfigurationExpiry()Ljava/lang/Long;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/StringUtil;->dateToString(Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/ConfigurationState;->getConfigurationNextRefresh()Ljava/lang/Long;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/StringUtil;->dateToString(Ljava/lang/Long;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateSchedule(Landroid/content/Context;Lcom/amazon/sdk/availability/Configuration;)Lcom/amazon/sdk/availability/ConfigurationState;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/amazon/sdk/availability/Configuration;

    .prologue
    const/4 v5, 0x0

    .line 83
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 85
    .local v1, "now":J
    new-instance v3, Lcom/amazon/sdk/availability/Preferences;

    invoke-direct {v3, p1}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 87
    .local v3, "preferences":Lcom/amazon/sdk/availability/Preferences;
    iput-object v5, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationExpiry:Ljava/lang/Long;

    .line 88
    iput-object v5, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationNextRefresh:Ljava/lang/Long;

    .line 90
    invoke-virtual {p2}, Lcom/amazon/sdk/availability/Configuration;->getStateExpiry()Ljava/lang/Long;

    move-result-object v0

    .line 91
    .local v0, "expiryDelta":Ljava/lang/Long;
    if-eqz v0, :cond_0

    .line 92
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    add-long/2addr v5, v1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationExpiry:Ljava/lang/Long;

    .line 95
    :cond_0
    iget-object v5, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationExpiry:Ljava/lang/Long;

    if-eqz v5, :cond_2

    .line 96
    const-string/jumbo v5, "configurationExpiry"

    iget-object v6, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationExpiry:Ljava/lang/Long;

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    :goto_0
    invoke-virtual {p2}, Lcom/amazon/sdk/availability/Configuration;->getStateNextRefresh()Ljava/lang/Long;

    move-result-object v4

    .line 102
    .local v4, "refreshDelta":Ljava/lang/Long;
    if-eqz v4, :cond_1

    .line 103
    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    add-long/2addr v5, v1

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationNextRefresh:Ljava/lang/Long;

    .line 106
    :cond_1
    if-eqz v4, :cond_3

    .line 107
    const-string/jumbo v5, "configurationNextRefresh"

    iget-object v6, p0, Lcom/amazon/sdk/availability/ConfigurationState;->configurationNextRefresh:Ljava/lang/Long;

    invoke-virtual {v6}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 111
    :goto_1
    return-object p0

    .line 98
    .end local v4    # "refreshDelta":Ljava/lang/Long;
    :cond_2
    const-string/jumbo v5, "configurationExpiry"

    invoke-virtual {v3, v5}, Lcom/amazon/sdk/availability/Preferences;->remove(Ljava/lang/String;)V

    goto :goto_0

    .line 109
    .restart local v4    # "refreshDelta":Ljava/lang/Long;
    :cond_3
    const-string/jumbo v5, "configurationNextRefresh"

    invoke-virtual {v3, v5}, Lcom/amazon/sdk/availability/Preferences;->remove(Ljava/lang/String;)V

    goto :goto_1
.end method
