.class public Lcom/xfinity/playerlib/config/DeveloperConfiguration;
.super Lcom/xfinity/playerlib/config/PlayerConfiguration;
.source "DeveloperConfiguration.java"


# instance fields
.field private availableConfigurations:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ">;"
        }
    .end annotation
.end field

.field private defaultConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field private delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field private final sharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Ljava/util/List;Lcom/xfinity/playerlib/config/PlayerConfiguration;Landroid/content/SharedPreferences;)V
    .locals 0
    .param p2, "defaultConfiguration"    # Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .param p3, "sharedPreferences"    # Landroid/content/SharedPreferences;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ">;",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            "Landroid/content/SharedPreferences;",
            ")V"
        }
    .end annotation

    .prologue
    .line 23
    .local p1, "configurations":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/config/PlayerConfiguration;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;-><init>()V

    .line 24
    iput-object p3, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    .line 25
    iput-object p2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->defaultConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 26
    iput-object p1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->availableConfigurations:Ljava/util/List;

    .line 27
    invoke-direct {p0}, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->updateConfiguration()V

    .line 28
    return-void
.end method

.method private updateConfiguration()V
    .locals 5

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->isDeveloperModeEnabled()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 32
    iget-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v3, "configName"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 33
    .local v1, "configurationName":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 34
    iget-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->availableConfigurations:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 35
    .local v0, "configuration":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 36
    iput-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 46
    .end local v0    # "configuration":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .end local v1    # "configurationName":Ljava/lang/String;
    :cond_1
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    if-nez v2, :cond_2

    .line 47
    iget-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->defaultConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    iput-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 49
    :cond_2
    return-void

    .line 42
    :cond_3
    iget-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->defaultConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    iput-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    goto :goto_0
.end method


# virtual methods
.method public getConsumablesHypermediaUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getConsumablesHypermediaUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDataRevalidationIntervalInMillis()J
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getDataRevalidationIntervalInMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDeveloperConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .locals 5

    .prologue
    .line 169
    const/4 v1, 0x0

    .line 172
    .local v1, "configuration":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    iget-object v2, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v3, "configName"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 173
    .local v0, "configName":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 174
    iget-object v1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 177
    :cond_0
    return-object v1
.end method

.method public getEditorialCoversUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEditorialCoversUri()Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public getEditorialVideoUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEditorialVideoUri()Ljava/net/URI;

    move-result-object v0

    return-object v0
.end method

.method public getEntityThumbnailUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEntityThumbnailUri()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFlyinMenuOptions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/view/flyinmenu/FlyinMenuOptions;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 118
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getFlyinMenuOptions()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getHypermediaRevalidationInterval()I
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getHypermediaRevalidationInterval()I

    move-result v0

    return v0
.end method

.method public getMinVersionCheckRevalidationIntervalInMillis()J
    .locals 2

    .prologue
    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getMinVersionCheckRevalidationIntervalInMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method public getRobotoFamilyName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getRobotoFamilyName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSplunkAppName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getSplunkAppName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt()J
    .locals 2

    .prologue
    .line 129
    invoke-virtual {p0}, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->isDeveloperModeEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 130
    const-wide/32 v0, 0x493e0

    .line 132
    :goto_0
    return-wide v0

    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt()J

    move-result-wide v0

    goto :goto_0
.end method

.method public getTveHypermediaUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getTveHypermediaUrl()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserAgentPrefix()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getUserAgentPrefix()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getXfinitySansFamilyName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getXfinitySansFamilyName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getXipUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getXipUri()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isDarkStreamsEnabled()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 181
    invoke-virtual {p0}, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->isDeveloperModeEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v2, "darkStreamsEnabled"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method public isDeveloperModeAllowed()Z
    .locals 1

    .prologue
    .line 143
    const/4 v0, 0x1

    return v0
.end method

.method public isDeveloperModeEnabled()Z
    .locals 3

    .prologue
    .line 138
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string v1, "inDevMode"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public setDarkStreamsEnabled(Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "darkStreamsEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 185
    invoke-virtual {p0}, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->isDeveloperModeEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 186
    iget-object v1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 187
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "darkStreamsEnabled"

    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 188
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 190
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    return-void
.end method

.method public setDeveloperConfiguration(Lcom/xfinity/playerlib/config/PlayerConfiguration;)V
    .locals 3
    .param p1, "configuration"    # Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .prologue
    .line 156
    iget-object v1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 157
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    if-eqz p1, :cond_0

    .line 158
    const-string v1, "configName"

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 162
    :goto_0
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 165
    if-eqz p1, :cond_1

    .end local p1    # "configuration":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    :goto_1
    iput-object p1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 166
    return-void

    .line 160
    .restart local p1    # "configuration":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    :cond_0
    const-string v1, "configName"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0

    .line 165
    :cond_1
    iget-object p1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->defaultConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    goto :goto_1
.end method

.method public setDeveloperModeEnabled(Z)V
    .locals 2
    .param p1, "devMode"    # Z

    .prologue
    .line 148
    iget-object v1, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 149
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "inDevMode"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 150
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 151
    invoke-direct {p0}, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->updateConfiguration()V

    .line 152
    return-void
.end method

.method public shouldSuppressNetworkLogos()Z
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/config/DeveloperConfiguration;->delegate:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->shouldSuppressNetworkLogos()Z

    move-result v0

    return v0
.end method
