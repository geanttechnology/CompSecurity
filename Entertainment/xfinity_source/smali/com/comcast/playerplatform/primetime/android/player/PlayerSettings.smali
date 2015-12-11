.class public Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
.super Ljava/lang/Object;
.source "PlayerSettings.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;
    }
.end annotation


# instance fields
.field private adBreakPolicies:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

.field private adType:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

.field private authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

.field private autoplay:Z

.field private bitRange:Lcom/comcast/playerplatform/util/android/Range;

.field private c3ads:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation
.end field

.field private captionFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

.field private ccEnabled:Z

.field private clientState:Lcom/comcast/playerplatform/drm/java/client/ClientState;

.field private closedCaptionsTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

.field private comscoreEnabled:Z

.field private deviceId:Ljava/lang/String;

.field private height:I

.field private initialBitrate:I

.field private listeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;",
            ">;"
        }
    .end annotation
.end field

.field private logFactory:Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

.field private loggerVerbosity:Lcom/adobe/mediacore/logging/Logger$Verbosity;

.field private preferredAudioLanguage:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

.field private targetingParameters:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private updateInterval:I

.field private volume:I

.field private width:I

.field private zoomSetting:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->width:I

    .line 46
    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->height:I

    .line 51
    const/16 v0, 0x3e8

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->updateInterval:I

    .line 52
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->autoplay:Z

    .line 53
    const/16 v0, 0x64

    iput v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->volume:I

    .line 54
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;->None:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->zoomSetting:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    .line 55
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/AdType;->NONE:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->adType:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .line 68
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->listeners:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public addListener(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 72
    return-void
.end method

.method public getAdBreakPolicies()Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->adBreakPolicies:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    return-object v0
.end method

.method public getAdType()Lcom/comcast/playerplatform/primetime/android/enums/AdType;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->adType:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    return-object v0
.end method

.method public getAuthDelegate()Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    return-object v0
.end method

.method public getBitRange()Lcom/comcast/playerplatform/util/android/Range;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->bitRange:Lcom/comcast/playerplatform/util/android/Range;

    return-object v0
.end method

.method public getC3Ads()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation

    .prologue
    .line 186
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->c3ads:Ljava/util/List;

    return-object v0
.end method

.method public getCaptionFormat()Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->captionFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    return-object v0
.end method

.method public getClientState()Lcom/comcast/playerplatform/drm/java/client/ClientState;
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientState;

    return-object v0
.end method

.method public getClosedCaptionsEnabled()Z
    .locals 1

    .prologue
    .line 229
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->ccEnabled:Z

    return v0
.end method

.method public getClosedCaptionsTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->closedCaptionsTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 215
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 96
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->height:I

    return v0
.end method

.method public getInitialBitrate()I
    .locals 1

    .prologue
    .line 202
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->initialBitrate:I

    return v0
.end method

.method public getLogFactory()Lcom/comcast/playerplatform/primetime/android/util/LogFactory;
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->logFactory:Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    return-object v0
.end method

.method public getLoggerVerbosity()Lcom/adobe/mediacore/logging/Logger$Verbosity;
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->loggerVerbosity:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    return-object v0
.end method

.method public getPreferredAudioLanguage()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->preferredAudioLanguage:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    return-object v0
.end method

.method public getTargetingParameters()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 272
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->targetingParameters:Ljava/util/Map;

    return-object v0
.end method

.method public getUpdateInterval()I
    .locals 1

    .prologue
    .line 141
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->updateInterval:I

    return v0
.end method

.method public getVolume()I
    .locals 1

    .prologue
    .line 159
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->volume:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 87
    iget v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->width:I

    return v0
.end method

.method public getZoomSetting()Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->zoomSetting:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    return-object v0
.end method

.method public isAutoplay()Z
    .locals 1

    .prologue
    .line 150
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->autoplay:Z

    return v0
.end method

.method public isComscoreEnabled()Z
    .locals 1

    .prologue
    .line 264
    iget-boolean v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->comscoreEnabled:Z

    return v0
.end method

.method public removeListener(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;

    .prologue
    .line 75
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->listeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 76
    return-void
.end method

.method public setAdBreakPolicies(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;)V
    .locals 1
    .param p1, "adBreakPolicies"    # Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->adBreakPolicies:Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    .line 119
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AD_BREAK_POLICIES:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 120
    return-void
.end method

.method public setAdType(Lcom/comcast/playerplatform/primetime/android/enums/AdType;)V
    .locals 1
    .param p1, "adType"    # Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->adType:Lcom/comcast/playerplatform/primetime/android/enums/AdType;

    .line 178
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AD_TYPE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 179
    return-void
.end method

.method public setAuthDelegate(Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;)V
    .locals 0
    .param p1, "authDelegate"    # Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->authDelegate:Lcom/comcast/playerplatform/drm/java/util/AuthenticationDelegate;

    .line 80
    return-void
.end method

.method public setAutoplay(Z)V
    .locals 1
    .param p1, "autoplay"    # Z

    .prologue
    .line 154
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->autoplay:Z

    .line 155
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AUTOPLAY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 156
    return-void
.end method

.method public setBitRange(Lcom/comcast/playerplatform/util/android/Range;)V
    .locals 1
    .param p1, "bitRange"    # Lcom/comcast/playerplatform/util/android/Range;

    .prologue
    .line 206
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->bitRange:Lcom/comcast/playerplatform/util/android/Range;

    .line 207
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->BITRATE_RANGE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 208
    return-void
.end method

.method public setC3Ads(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 190
    .local p1, "adBreaks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->c3ads:Ljava/util/List;

    .line 191
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->C3_ADS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 192
    return-void
.end method

.method public setCaptionFormat(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;)V
    .locals 1
    .param p1, "captionFormat"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->captionFormat:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    .line 110
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTION_FORMAT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 111
    return-void
.end method

.method public setClosedCaptionsEnabled(Z)V
    .locals 1
    .param p1, "flag"    # Z

    .prologue
    .line 224
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->ccEnabled:Z

    .line 225
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_ENABLED:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 226
    return-void
.end method

.method public setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V
    .locals 1
    .param p1, "closedCaptionsTrack"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    .prologue
    .line 233
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->closedCaptionsTrack:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    .line 234
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 236
    return-void
.end method

.method public setComscoreEnabled(Z)V
    .locals 0
    .param p1, "comscoreEnabled"    # Z

    .prologue
    .line 260
    iput-boolean p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->comscoreEnabled:Z

    .line 261
    return-void
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 1
    .param p1, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->deviceId:Ljava/lang/String;

    .line 220
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->DEVICE_ID:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 221
    return-void
.end method

.method public setHeight(I)V
    .locals 1
    .param p1, "height"    # I

    .prologue
    .line 100
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->height:I

    .line 101
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->HEIGHT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 102
    return-void
.end method

.method public setInitialBitrate(I)V
    .locals 1
    .param p1, "initialBitrate"    # I

    .prologue
    .line 196
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->initialBitrate:I

    .line 198
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->INITIAL_BITRATE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 199
    return-void
.end method

.method public setLogFactory(Lcom/comcast/playerplatform/primetime/android/util/LogFactory;)V
    .locals 1
    .param p1, "logFactory"    # Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .prologue
    .line 136
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->logFactory:Lcom/comcast/playerplatform/primetime/android/util/LogFactory;

    .line 137
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->LOG_FACTORY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 138
    return-void
.end method

.method public setLoggerVerbosity(Lcom/adobe/mediacore/logging/Logger$Verbosity;)V
    .locals 1
    .param p1, "loggerVerbosity"    # Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->loggerVerbosity:Lcom/adobe/mediacore/logging/Logger$Verbosity;

    .line 128
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->LOGGER_VERBOSITY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 129
    return-void
.end method

.method public setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V
    .locals 1
    .param p1, "preferredAudioLanguage"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .prologue
    .line 243
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->preferredAudioLanguage:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .line 244
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AUDIO_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 245
    return-void
.end method

.method public setTargetingParameters(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 268
    .local p1, "targetingParameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->targetingParameters:Ljava/util/Map;

    .line 269
    return-void
.end method

.method public setUpdateInterval(I)V
    .locals 1
    .param p1, "updateInterval"    # I

    .prologue
    .line 145
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->updateInterval:I

    .line 146
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->UPDATE_INTERVAL:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 147
    return-void
.end method

.method public setVolume(I)V
    .locals 1
    .param p1, "volume"    # I

    .prologue
    .line 163
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->volume:I

    .line 164
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->VOLUME:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 165
    return-void
.end method

.method public setWidth(I)V
    .locals 1
    .param p1, "width"    # I

    .prologue
    .line 91
    iput p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->width:I

    .line 92
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->WIDTH:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 93
    return-void
.end method

.method public setZoomSetting(Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;)V
    .locals 1
    .param p1, "zoomSetting"    # Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    .prologue
    .line 172
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->zoomSetting:Lcom/comcast/playerplatform/primetime/android/enums/ZoomSetting;

    .line 173
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ZOOM_SETTING:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    .line 174
    return-void
.end method

.method public setclientState(Lcom/comcast/playerplatform/drm/java/client/ClientState;)V
    .locals 0
    .param p1, "clientState"    # Lcom/comcast/playerplatform/drm/java/client/ClientState;

    .prologue
    .line 252
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->clientState:Lcom/comcast/playerplatform/drm/java/client/ClientState;

    .line 253
    return-void
.end method

.method public settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V
    .locals 3
    .param p1, "setting"    # Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .prologue
    .line 276
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;->listeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;

    .line 277
    .local v1, "listener":Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;
    invoke-interface {v1, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;->settingUpdated(Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;)V

    goto :goto_0

    .line 279
    .end local v1    # "listener":Lcom/comcast/playerplatform/primetime/android/player/PlayerSettingsListener;
    :cond_0
    return-void
.end method
