.class public Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
.super Ljava/lang/Object;
.source "PlayerUserSettings.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;
.implements Lcom/comcast/cim/model/user/service/UserSettings;


# instance fields
.field private appVersionCodeWhenLastActive:I

.field private audioTrackIndex:I

.field private brightnessValue:I

.field private ccBackgroundColor:I

.field private ccBackgroundOpacity:I

.field private ccEdgeColor:I

.field private ccEdgeType:I

.field private ccFontFamily:I

.field private ccTextColor:I

.field private ccTextSize:I

.field private ccTrackIndex:I

.field private deviceAuthToken:Ljava/lang/String;

.field private deviceRegistration:Lcom/xfinity/playerlib/downloads/DeviceRegistration;

.field private downloadsSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field private filterFactory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;

.field hasSeenCellularEnabledMessage:Z

.field hasSeenHelpScreen:Z

.field hasSeenMenuOptions:Z

.field hasSeenParentalControlsMessage:Z

.field hasSeenUpgradeMessage:Z

.field private hasSeenWearFirstTimeExperience:Z

.field private hasSeenWelcomeDialog:Z

.field private kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

.field private micSensitivity:I

.field private movieCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field private movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

.field private movieSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field private networkFilterMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;>;"
        }
    .end annotation
.end field

.field private previousSessionId:Ljava/lang/String;

.field private seriesCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field private seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

.field private seriesSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field private setTopBoxDeviceId:Ljava/lang/String;

.field private setTopBoxDeviceKey:Ljava/lang/String;

.field private setTopBoxName:Ljava/lang/String;

.field showDownloadsFTU:Z

.field showLastWatched:Z

.field private showVideoOverMobileWarning:Z

.field private useCellularWhenAvailable:Z

.field wantsAdultContent:Z

.field wantsBrightnessControl:Z

.field private wantsClosedCaptions:Z

.field private wantsStaticBitrate:Z

.field wantsVolumeControl:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x1

    const/4 v1, -0x1

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showVideoOverMobileWarning:Z

    .line 27
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showDownloadsFTU:Z

    .line 28
    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenUpgradeMessage:Z

    .line 32
    iput v1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->brightnessValue:I

    .line 35
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 37
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 39
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 40
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->POPULAR:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    .line 42
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->RECENT:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->downloadsSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 49
    iput v1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccTrackIndex:I

    .line 50
    iput v1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->audioTrackIndex:I

    .line 60
    const/16 v0, 0x64

    iput v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccBackgroundOpacity:I

    .line 76
    const/16 v0, 0x258

    iput v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->micSensitivity:I

    .line 80
    return-void
.end method


# virtual methods
.method public declared-synchronized getAppVersionCodeWhenLastActive()I
    .locals 1

    .prologue
    .line 305
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->appVersionCodeWhenLastActive:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getAudioTrackIndex()I
    .locals 1

    .prologue
    .line 290
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->audioTrackIndex:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getBrightnessValue()I
    .locals 1

    .prologue
    .line 358
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->brightnessValue:I

    return v0
.end method

.method public getCCBackgroundColor()I
    .locals 1

    .prologue
    .line 406
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccBackgroundColor:I

    return v0
.end method

.method public getCCBackgroundOpacity()I
    .locals 1

    .prologue
    .line 414
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccBackgroundOpacity:I

    return v0
.end method

.method public getCCEdgeColor()I
    .locals 1

    .prologue
    .line 398
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccEdgeColor:I

    return v0
.end method

.method public getCCEdgeType()I
    .locals 1

    .prologue
    .line 390
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccEdgeType:I

    return v0
.end method

.method public getCCFontFamily()I
    .locals 1

    .prologue
    .line 382
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccFontFamily:I

    return v0
.end method

.method public getCCTextColor()I
    .locals 1

    .prologue
    .line 374
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccTextColor:I

    return v0
.end method

.method public getCCTextSize()I
    .locals 1

    .prologue
    .line 366
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccTextSize:I

    return v0
.end method

.method public declared-synchronized getCCTrackIndex()I
    .locals 1

    .prologue
    .line 282
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccTrackIndex:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDeviceAuthToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->deviceAuthToken:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDeviceRegistration()Lcom/xfinity/playerlib/downloads/DeviceRegistration;
    .locals 1

    .prologue
    .line 294
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->deviceRegistration:Lcom/xfinity/playerlib/downloads/DeviceRegistration;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getDownloadsSort()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 262
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->downloadsSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getHasSeenCellularEnabledMessage()Z
    .locals 1

    .prologue
    .line 120
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenCellularEnabledMessage:Z

    return v0
.end method

.method public declared-synchronized getHasSeenHelpScreen()Z
    .locals 1

    .prologue
    .line 88
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenHelpScreen:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getHasSeenMenuOptions()Z
    .locals 1

    .prologue
    .line 112
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenMenuOptions:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getHasSeenParentalControlsMessage()Z
    .locals 1

    .prologue
    .line 96
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenParentalControlsMessage:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getHasSeenUpgradeMessage()Z
    .locals 1

    .prologue
    .line 104
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenUpgradeMessage:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getHasSeenWearFirstTimeExperience()Z
    .locals 1

    .prologue
    .line 471
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenWearFirstTimeExperience:Z

    return v0
.end method

.method public getHasSeenWelcomeDialog()Z
    .locals 1

    .prologue
    .line 455
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenWelcomeDialog:Z

    return v0
.end method

.method public declared-synchronized getKidsFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 1

    .prologue
    .line 175
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    if-nez v0, :cond_0

    .line 176
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->filterFactory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;

    invoke-interface {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;->createDefaultFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 178
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 175
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getMicSensitivity()I
    .locals 1

    .prologue
    .line 463
    iget v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->micSensitivity:I

    return v0
.end method

.method public declared-synchronized getMovieCollectionSort()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 194
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMovieFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 1

    .prologue
    .line 168
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    if-nez v0, :cond_0

    .line 169
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->filterFactory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;

    invoke-interface {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;->createDefaultFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 171
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 168
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getMovieSort()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 182
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getNetworkFilterMap()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 338
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    return-object v0
.end method

.method public declared-synchronized getNetworkProgramsFilter(JLjava/lang/String;)Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 5
    .param p1, "companyId"    # J
    .param p3, "categoryId"    # Ljava/lang/String;

    .prologue
    .line 229
    monitor-enter p0

    :try_start_0
    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    .line 230
    .local v0, "companyIdString":Ljava/lang/String;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 231
    iget-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 234
    :cond_0
    const-string v1, "no_category"

    .line 235
    .local v1, "id":Ljava/lang/String;
    if-eqz p3, :cond_1

    const-string v2, ""

    invoke-virtual {p3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 236
    move-object v1, p3

    .line 239
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 240
    iget-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->filterFactory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;

    invoke-interface {v3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;->createNetworkFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 242
    :cond_2
    iget-object v2, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v2

    .line 229
    .end local v0    # "companyIdString":Ljava/lang/String;
    .end local v1    # "id":Ljava/lang/String;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized getPreviousSessionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 160
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->previousSessionId:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSeriesCollectionSort()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 221
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSeriesFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 1

    .prologue
    .line 210
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    if-nez v0, :cond_0

    .line 211
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->filterFactory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;

    invoke-interface {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;->createDefaultFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 213
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 210
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getSeriesSort()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    .locals 1

    .prologue
    .line 206
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getSetTopBoxDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 431
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setTopBoxDeviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getSetTopBoxDeviceKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 439
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setTopBoxDeviceKey:Ljava/lang/String;

    return-object v0
.end method

.method public getSetTopBoxName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 447
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setTopBoxName:Ljava/lang/String;

    return-object v0
.end method

.method public declared-synchronized getShowDownloadsFTU()Z
    .locals 1

    .prologue
    .line 128
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showDownloadsFTU:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getShowLastWatched()Z
    .locals 1

    .prologue
    .line 144
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showLastWatched:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getShowVideoOverMobileWarning()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 250
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showVideoOverMobileWarning:Z

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getUseCellularWhenAvailable()Z
    .locals 1

    .prologue
    .line 258
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->useCellularWhenAvailable:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getWantsAdultContent()Z
    .locals 1

    .prologue
    .line 136
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsAdultContent:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getWantsBrightnessControl()Z
    .locals 1

    .prologue
    .line 350
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsBrightnessControl:Z

    return v0
.end method

.method public declared-synchronized getWantsClosedCaptions()Z
    .locals 1

    .prologue
    .line 274
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsClosedCaptions:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getWantsStaticBitrate()Z
    .locals 1

    .prologue
    .line 422
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsStaticBitrate:Z

    return v0
.end method

.method public getWantsVolumeControl()Z
    .locals 1

    .prologue
    .line 342
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsVolumeControl:Z

    return v0
.end method

.method public resetFilters()V
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 314
    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 315
    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 316
    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .line 317
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    .line 318
    return-void
.end method

.method public resetNetworkFilters()V
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 322
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->networkFilterMap:Ljava/util/Map;

    .line 324
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 325
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 328
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 329
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 332
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 333
    iget-object v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->kidsFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 335
    :cond_2
    return-void
.end method

.method public declared-synchronized setAppVersionCodeWhenLastActive(I)V
    .locals 1
    .param p1, "versionCode"    # I

    .prologue
    .line 309
    monitor-enter p0

    :try_start_0
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->appVersionCodeWhenLastActive:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 310
    monitor-exit p0

    return-void

    .line 309
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAudioTrackIndex(I)V
    .locals 1
    .param p1, "audioTrackIndex"    # I

    .prologue
    .line 286
    monitor-enter p0

    :try_start_0
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->audioTrackIndex:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 287
    monitor-exit p0

    return-void

    .line 286
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setBrightnessValue(I)V
    .locals 0
    .param p1, "brightnessValue"    # I

    .prologue
    .line 362
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->brightnessValue:I

    .line 363
    return-void
.end method

.method public setCCBackgroundColor(I)V
    .locals 0
    .param p1, "ccBackgroundColor"    # I

    .prologue
    .line 410
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccBackgroundColor:I

    .line 411
    return-void
.end method

.method public setCCBackgroundOpacity(I)V
    .locals 0
    .param p1, "ccBackgroundOpacity"    # I

    .prologue
    .line 418
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccBackgroundOpacity:I

    .line 419
    return-void
.end method

.method public setCCEdgeColor(I)V
    .locals 0
    .param p1, "ccEdgeColor"    # I

    .prologue
    .line 402
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccEdgeColor:I

    .line 403
    return-void
.end method

.method public setCCEdgeType(I)V
    .locals 0
    .param p1, "ccEdgeType"    # I

    .prologue
    .line 394
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccEdgeType:I

    .line 395
    return-void
.end method

.method public setCCFontFamily(I)V
    .locals 0
    .param p1, "ccFontFamily"    # I

    .prologue
    .line 386
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccFontFamily:I

    .line 387
    return-void
.end method

.method public setCCTextColor(I)V
    .locals 0
    .param p1, "ccTextColor"    # I

    .prologue
    .line 378
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccTextColor:I

    .line 379
    return-void
.end method

.method public setCCTextSize(I)V
    .locals 0
    .param p1, "ccTextSize"    # I

    .prologue
    .line 370
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccTextSize:I

    .line 371
    return-void
.end method

.method public declared-synchronized setCCTrackIndex(I)V
    .locals 1
    .param p1, "ccTrackIndex"    # I

    .prologue
    .line 278
    monitor-enter p0

    :try_start_0
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->ccTrackIndex:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 279
    monitor-exit p0

    return-void

    .line 278
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDeviceAuthToken(Ljava/lang/String;)V
    .locals 1
    .param p1, "deviceAuthToken"    # Ljava/lang/String;

    .prologue
    .line 156
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->deviceAuthToken:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 157
    monitor-exit p0

    return-void

    .line 156
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDeviceRegistration(Lcom/xfinity/playerlib/downloads/DeviceRegistration;)V
    .locals 1
    .param p1, "deviceRegistration"    # Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    .prologue
    .line 298
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->deviceRegistration:Lcom/xfinity/playerlib/downloads/DeviceRegistration;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 299
    monitor-exit p0

    return-void

    .line 298
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setDownloadsSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 1
    .param p1, "downloadsSort"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 266
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->downloadsSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 267
    monitor-exit p0

    return-void

    .line 266
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setFilterFactory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;)V
    .locals 0
    .param p1, "filterFactory"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 84
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->filterFactory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;

    .line 85
    return-void
.end method

.method public setHasSeenCellularEnabledMessage(Z)V
    .locals 0
    .param p1, "hasSeenCellularEnabledMessage"    # Z

    .prologue
    .line 124
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenCellularEnabledMessage:Z

    .line 125
    return-void
.end method

.method public declared-synchronized setHasSeenHelpScreen(Z)V
    .locals 1
    .param p1, "hasSeenHelpScreen"    # Z

    .prologue
    .line 92
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenHelpScreen:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 93
    monitor-exit p0

    return-void

    .line 92
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setHasSeenMenuOptions(Z)V
    .locals 1
    .param p1, "hasSeenMenuOptions"    # Z

    .prologue
    .line 116
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenMenuOptions:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 117
    monitor-exit p0

    return-void

    .line 116
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setHasSeenParentalControlsMessage(Z)V
    .locals 1
    .param p1, "hasSeenParentalControlsMessage"    # Z

    .prologue
    .line 100
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenParentalControlsMessage:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 101
    monitor-exit p0

    return-void

    .line 100
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setHasSeenUpgradeMessage(Z)V
    .locals 1
    .param p1, "hasSeenUpgradeMessage"    # Z

    .prologue
    .line 108
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenUpgradeMessage:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 109
    monitor-exit p0

    return-void

    .line 108
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setHasSeenWearFirstTimeExperience(Z)V
    .locals 0
    .param p1, "hasSeenWearFirstTimeExperience"    # Z

    .prologue
    .line 475
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenWearFirstTimeExperience:Z

    .line 476
    return-void
.end method

.method public setHasSeenWelcomeDialog(Z)V
    .locals 0
    .param p1, "hasSeenWelcomeDialog"    # Z

    .prologue
    .line 459
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->hasSeenWelcomeDialog:Z

    .line 460
    return-void
.end method

.method public setMicSensitivity(I)V
    .locals 0
    .param p1, "micSensitivity"    # I

    .prologue
    .line 467
    iput p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->micSensitivity:I

    .line 468
    return-void
.end method

.method public declared-synchronized setMovieCollectionSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 1
    .param p1, "movieCollectionSort"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 198
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 199
    monitor-exit p0

    return-void

    .line 198
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setMovieFilter(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 1
    .param p1, "movieFilter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 190
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 191
    monitor-exit p0

    return-void

    .line 190
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setMovieSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 1
    .param p1, "movieSort"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 186
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->movieSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 187
    monitor-exit p0

    return-void

    .line 186
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setPreviousSessionId(Ljava/lang/String;)V
    .locals 1
    .param p1, "previousSessionId"    # Ljava/lang/String;

    .prologue
    .line 164
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->previousSessionId:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 165
    monitor-exit p0

    return-void

    .line 164
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setSeriesCollectionSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 1
    .param p1, "seriesCollectionSort"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 225
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesCollectionSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 226
    monitor-exit p0

    return-void

    .line 225
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setSeriesFilter(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 1
    .param p1, "seriesFilter"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 217
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesFilter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 218
    monitor-exit p0

    return-void

    .line 217
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setSeriesSort(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 1
    .param p1, "sortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 202
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->seriesSort:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 203
    monitor-exit p0

    return-void

    .line 202
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setSetTopBoxDeviceId(Ljava/lang/String;)V
    .locals 0
    .param p1, "setTopBoxDeviceId"    # Ljava/lang/String;

    .prologue
    .line 435
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setTopBoxDeviceId:Ljava/lang/String;

    .line 436
    return-void
.end method

.method public setSetTopBoxDeviceKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "setTopBoxDeviceKey"    # Ljava/lang/String;

    .prologue
    .line 443
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setTopBoxDeviceKey:Ljava/lang/String;

    .line 444
    return-void
.end method

.method public setSetTopBoxName(Ljava/lang/String;)V
    .locals 0
    .param p1, "setTopBoxName"    # Ljava/lang/String;

    .prologue
    .line 451
    iput-object p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setTopBoxName:Ljava/lang/String;

    .line 452
    return-void
.end method

.method public declared-synchronized setShowDownloadsFTU(Z)V
    .locals 1
    .param p1, "showDownloadsFTU"    # Z

    .prologue
    .line 132
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showDownloadsFTU:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 133
    monitor-exit p0

    return-void

    .line 132
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setShowLastWatched(Z)V
    .locals 1
    .param p1, "showLastWatched"    # Z

    .prologue
    .line 148
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showLastWatched:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 149
    monitor-exit p0

    return-void

    .line 148
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setShowVideoOverMobileWarning(Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "v"    # Ljava/lang/Boolean;

    .prologue
    .line 246
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->showVideoOverMobileWarning:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 247
    monitor-exit p0

    return-void

    .line 246
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setUseCellularWhenAvailable(Z)V
    .locals 1
    .param p1, "useCellularWhenAvailable"    # Z

    .prologue
    .line 254
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->useCellularWhenAvailable:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 255
    monitor-exit p0

    return-void

    .line 254
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setWantsAdultContent(Z)V
    .locals 1
    .param p1, "wantsAdultContent"    # Z

    .prologue
    .line 140
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsAdultContent:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 141
    monitor-exit p0

    return-void

    .line 140
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setWantsBrightnessControl(Z)V
    .locals 0
    .param p1, "wantsBrightnessControl"    # Z

    .prologue
    .line 354
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsBrightnessControl:Z

    .line 355
    return-void
.end method

.method public declared-synchronized setWantsClosedCaptions(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 270
    monitor-enter p0

    :try_start_0
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsClosedCaptions:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 271
    monitor-exit p0

    return-void

    .line 270
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setWantsStaticBitrate(Z)V
    .locals 0
    .param p1, "wantsStaticBitrate"    # Z

    .prologue
    .line 426
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsStaticBitrate:Z

    .line 427
    return-void
.end method

.method public setWantsVolumeControl(Z)V
    .locals 0
    .param p1, "wantsVolumeControl"    # Z

    .prologue
    .line 346
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->wantsVolumeControl:Z

    .line 347
    return-void
.end method
