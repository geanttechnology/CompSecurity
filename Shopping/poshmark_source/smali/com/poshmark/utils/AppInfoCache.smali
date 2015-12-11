.class public Lcom/poshmark/utils/AppInfoCache;
.super Ljava/lang/Object;
.source "AppInfoCache.java"


# instance fields
.field mutex:Ljava/lang/Object;

.field userFeedCacheInfo:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/AppInfoCache;->mutex:Ljava/lang/Object;

    .line 17
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "appInfoCache"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/AppInfoCache;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    .line 20
    return-void
.end method


# virtual methods
.method public getCurrentVersion()Ljava/lang/String;
    .locals 3

    .prologue
    .line 23
    iget-object v0, p0, Lcom/poshmark/utils/AppInfoCache;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    const-string v1, "version"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public isAppUpgraded()Z
    .locals 3

    .prologue
    .line 37
    iget-object v0, p0, Lcom/poshmark/utils/AppInfoCache;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    const-string v1, "version_upgraded"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public setCurrentVersion(Ljava/lang/String;)V
    .locals 2
    .param p1, "version"    # Ljava/lang/String;

    .prologue
    .line 27
    if-eqz p1, :cond_0

    .line 28
    iget-object v0, p0, Lcom/poshmark/utils/AppInfoCache;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "version"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 30
    :cond_0
    return-void
.end method

.method public setUpgradeFlag(Z)V
    .locals 2
    .param p1, "flag"    # Z

    .prologue
    .line 33
    iget-object v0, p0, Lcom/poshmark/utils/AppInfoCache;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "version_upgraded"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 34
    return-void
.end method
