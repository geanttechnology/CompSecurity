.class public abstract Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;
.super Ljava/lang/Object;
.source "PlayerAppUpgradeHelper.java"

# interfaces
.implements Lcom/comcast/cim/android/application/AppUpgradeHelper;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final bookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

.field private final downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private final persistentCaptionsCache:Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

.field private final persistentEntityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

.field private final playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;

.field private final sharedPrefs:Landroid/content/SharedPreferences;

.field private final userManager:Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/model/user/UserManager;Landroid/content/SharedPreferences;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;)V
    .locals 0
    .param p1, "playNowApplication"    # Lcom/xfinity/playerlib/PlayerApplication;
    .param p3, "sharedPrefs"    # Landroid/content/SharedPreferences;
    .param p4, "downloadsManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p5, "persistentEntityCache"    # Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;
    .param p6, "persistentCaptionsCache"    # Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;
    .param p7, "bookmarkDAO"    # Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/PlayerApplication;",
            "Lcom/comcast/cim/model/user/UserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;",
            "Landroid/content/SharedPreferences;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;",
            "Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;",
            "Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;",
            "Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;",
            ")V"
        }
    .end annotation

    .prologue
    .line 50
    .local p2, "userManager":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    iput-object p1, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;

    .line 52
    iput-object p2, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 53
    iput-object p3, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->sharedPrefs:Landroid/content/SharedPreferences;

    .line 54
    iput-object p4, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 55
    iput-object p5, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->persistentEntityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    .line 56
    iput-object p6, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->persistentCaptionsCache:Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    .line 57
    iput-object p7, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    .line 58
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;)Lcom/xfinity/playerlib/PlayerApplication;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;

    return-object v0
.end method

.method private clearPreAdobifyData()Z
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/downloads/DownloadServiceException;
        }
    .end annotation

    .prologue
    .line 167
    iget-object v0, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    const-wide/16 v2, 0x1388

    invoke-virtual {v0, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->waitForInitialization(J)V

    .line 170
    iget-object v0, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->hasOldFiles()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 171
    iget-object v0, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteAllContentForUpgrade()V

    .line 172
    iget-object v0, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->persistentEntityCache:Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PersistentEntityCache;->clear()V

    .line 173
    iget-object v0, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->persistentCaptionsCache:Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/captions/PersistentCaptionsCache;->clear()V

    .line 174
    const/4 v0, 0x1

    .line 177
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized onLaunch()V
    .locals 5

    .prologue
    .line 151
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->sharedPrefs:Landroid/content/SharedPreferences;

    const-string v3, "versionCodeLastSuccessfulLaunch"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 153
    .local v1, "versionCodeLastLaunch":I
    iget-object v2, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionCode()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 156
    iget-object v2, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->sharedPrefs:Landroid/content/SharedPreferences;

    const-string v3, "UpgradeSignoutKey"

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->upgradeRequiresSignout(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 157
    iget-object v2, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v2}, Lcom/comcast/cim/model/user/UserManager;->signOutUser()V

    .line 159
    iget-object v2, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->sharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 160
    .local v0, "spEditor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "versionCodeLastSuccessfulLaunch"

    iget-object v3, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionCode()I

    move-result v3

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 161
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 164
    .end local v0    # "spEditor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    monitor-exit p0

    return-void

    .line 151
    .end local v1    # "versionCodeLastLaunch":I
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized onUserLoadedOrSignedIn()V
    .locals 14

    .prologue
    .line 62
    monitor-enter p0

    :try_start_0
    iget-object v11, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->playNowApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v11}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionCode()I

    move-result v7

    .line 63
    .local v7, "newVersion":I
    iget-object v11, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v11}, Lcom/comcast/cim/model/user/UserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v10

    check-cast v10, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 64
    .local v10, "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getAppVersionCodeWhenLastActive()I

    move-result v8

    .line 66
    .local v8, "oldVersion":I
    if-ge v8, v7, :cond_b

    .line 68
    invoke-virtual {p0, v8}, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->upgradeRequiresFilterReset(I)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 69
    sget-object v11, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->LOG:Lorg/slf4j/Logger;

    const-string v12, "Resetting filters because the user hasn\'t been active since (we realized) the format changed"

    invoke-interface {v11, v12}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    .line 70
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->resetFilters()V

    .line 73
    :cond_0
    const/16 v11, 0xbe5

    if-ge v8, v11, :cond_2

    .line 76
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getKidsFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v11

    invoke-virtual {v11}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentProgramTypeFilters()Ljava/util/HashMap;

    move-result-object v0

    .line 77
    .local v0, "currentProgramTypeFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 78
    .local v5, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_1
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_2

    .line 79
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/String;

    .line 80
    .local v9, "programTypeKey":Ljava/lang/String;
    const-string v11, "movies"

    invoke-virtual {v9, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_1

    const-string v11, "tvseries"

    invoke-virtual {v9, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_1

    .line 81
    sget-object v11, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->LOG:Lorg/slf4j/Logger;

    const-string v12, "Removing invalid program type filter with id {} and label {}"

    invoke-interface {v0, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v13

    invoke-interface {v11, v12, v9, v13}, Lorg/slf4j/Logger;->info(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 82
    invoke-interface {v5}, Ljava/util/Iterator;->remove()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 62
    .end local v0    # "currentProgramTypeFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v5    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v7    # "newVersion":I
    .end local v8    # "oldVersion":I
    .end local v9    # "programTypeKey":Ljava/lang/String;
    .end local v10    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :catchall_0
    move-exception v11

    monitor-exit p0

    throw v11

    .line 87
    .restart local v7    # "newVersion":I
    .restart local v8    # "oldVersion":I
    .restart local v10    # "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :cond_2
    const/16 v11, 0x1580

    if-ge v8, v11, :cond_3

    .line 88
    :try_start_1
    new-instance v11, Ljava/lang/Thread;

    new-instance v12, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper$1;

    invoke-direct {v12, p0}, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper$1;-><init>(Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;)V

    invoke-direct {v11, v12}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 96
    invoke-virtual {v11}, Ljava/lang/Thread;->start()V

    .line 100
    :cond_3
    const/16 v11, 0x16ad

    if-ge v8, v11, :cond_6

    .line 103
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getNetworkFilterMap()Ljava/util/Map;

    move-result-object v6

    .line 104
    .local v6, "networkFilterMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;>;"
    invoke-interface {v6}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_4
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_5

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 105
    .local v2, "entry1":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/util/Map;

    invoke-interface {v11}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_4

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 106
    .local v3, "entry2":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 107
    .local v4, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    const/4 v13, 0x0

    invoke-virtual {v4, v13}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setHideLockOn(Z)V

    .line 108
    sget-object v13, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->NETWORK:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v4, v13}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->clearFiltersForCategory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    goto :goto_1

    .line 112
    .end local v2    # "entry1":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;>;"
    .end local v3    # "entry2":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;"
    .end local v4    # "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :cond_5
    sget-object v11, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v10, v11}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setMovieSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 113
    sget-object v11, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v10, v11}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setSeriesSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 114
    sget-object v11, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v10, v11}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setSeriesCollectionSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 115
    sget-object v11, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v10, v11}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setMovieCollectionSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 118
    .end local v6    # "networkFilterMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;>;>;"
    :cond_6
    const/16 v11, 0x1717

    if-ge v8, v11, :cond_7

    .line 124
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->resetNetworkFilters()V

    .line 127
    :cond_7
    const/16 v11, 0x1711

    if-ge v8, v11, :cond_8

    .line 128
    iget-object v11, p0, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    invoke-interface {v11}, Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;->updateLastTrackedMilestones()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 132
    :cond_8
    const/16 v11, 0xbb8

    if-ge v8, v11, :cond_a

    .line 133
    :try_start_2
    invoke-direct {p0}, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->clearPreAdobifyData()Z

    move-result v11

    if-eqz v11, :cond_9

    .line 134
    const/4 v11, 0x0

    invoke-virtual {v10, v11}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setHasSeenUpgradeMessage(Z)V

    .line 138
    :cond_9
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->resetFilters()V

    .line 141
    :cond_a
    invoke-virtual {v10, v7}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setAppVersionCodeWhenLastActive(I)V
    :try_end_2
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 147
    :cond_b
    monitor-exit p0

    return-void

    .line 142
    :catch_0
    move-exception v1

    .line 143
    .local v1, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :try_start_3
    sget-object v11, Lcom/xfinity/playerlib/PlayerAppUpgradeHelper;->LOG:Lorg/slf4j/Logger;

    const-string v12, "DownloadServiceManager failed to initialize in time"

    invoke-interface {v11, v12, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 144
    new-instance v11, Lcom/comcast/cim/exception/CimUpgradeException;

    const-string v12, "Failed to Upgrade User: "

    invoke-direct {v11, v12, v1}, Lcom/comcast/cim/exception/CimUpgradeException;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v11
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0
.end method

.method protected abstract upgradeRequiresFilterReset(I)Z
.end method

.method protected abstract upgradeRequiresSignout(I)Z
.end method
