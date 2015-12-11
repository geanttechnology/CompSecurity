.class public Lcom/poshmark/utils/FeedCacheHelper;
.super Ljava/lang/Object;
.source "FeedCacheHelper.java"


# instance fields
.field lastAutoRefreshTime:Ljava/util/Date;

.field lastBubbleDisplayTime:Ljava/util/Date;

.field mutex:Ljava/lang/Object;

.field userFeedCacheInfo:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FeedCacheHelper;->mutex:Ljava/lang/Object;

    .line 24
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "userFeedCacheInfo"

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/FeedCacheHelper;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    .line 27
    return-void
.end method


# virtual methods
.method public clearCachedFeed()V
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/poshmark/utils/FeedCacheHelper;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 68
    return-void
.end method

.method public getCachedFeed()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 49
    iget-object v2, p0, Lcom/poshmark/utils/FeedCacheHelper;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    const-string v3, "FEED"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "cachedFeedJSON":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 53
    .end local v0    # "cachedFeedJSON":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "cachedFeedJSON":Ljava/lang/String;
    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method public getLastCachedDate()Ljava/util/Date;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 58
    iget-object v2, p0, Lcom/poshmark/utils/FeedCacheHelper;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    const-string v3, "FEED_DTM"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 59
    .local v0, "cachedFeedDate":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 60
    invoke-static {v0}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 62
    :cond_0
    return-object v1
.end method

.method public isCachedFeedAvailable()Z
    .locals 4

    .prologue
    .line 30
    iget-object v1, p0, Lcom/poshmark/utils/FeedCacheHelper;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    const-string v2, "FEED"

    const/4 v3, 0x0

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 31
    .local v0, "cachedFeedJSON":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 32
    const/4 v1, 0x1

    .line 34
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public saveFeed(Ljava/lang/String;)V
    .locals 4
    .param p1, "feedJson"    # Ljava/lang/String;

    .prologue
    .line 39
    if-eqz p1, :cond_0

    .line 40
    iget-object v2, p0, Lcom/poshmark/utils/FeedCacheHelper;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "FEED"

    invoke-interface {v2, v3, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 42
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 43
    .local v0, "currentTime":Ljava/util/Date;
    invoke-static {v0}, Lcom/poshmark/utils/DateUtils;->getStringFromUTCDate(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    .line 44
    .local v1, "dateString":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/FeedCacheHelper;->userFeedCacheInfo:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "FEED_DTM"

    invoke-interface {v2, v3, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 46
    .end local v0    # "currentTime":Ljava/util/Date;
    .end local v1    # "dateString":Ljava/lang/String;
    :cond_0
    return-void
.end method
