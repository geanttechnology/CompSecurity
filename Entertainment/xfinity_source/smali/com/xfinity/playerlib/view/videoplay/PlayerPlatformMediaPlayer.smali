.class public Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;
.super Ljava/lang/Object;
.source "PlayerPlatformMediaPlayer.java"


# instance fields
.field private mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-direct {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;-><init>(Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    .line 38
    return-void
.end method

.method private static convertClosedCaptionsColor(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .locals 18
    .param p0, "color"    # I

    .prologue
    .line 103
    invoke-static/range {p0 .. p0}, Landroid/graphics/Color;->red(I)I

    move-result v8

    .line 104
    .local v8, "r":I
    invoke-static/range {p0 .. p0}, Landroid/graphics/Color;->green(I)I

    move-result v4

    .line 105
    .local v4, "g":I
    invoke-static/range {p0 .. p0}, Landroid/graphics/Color;->blue(I)I

    move-result v0

    .line 107
    .local v0, "b":I
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 111
    .local v1, "diffs":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v5, 0x1

    .local v5, "i":I
    :goto_0
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v14

    array-length v14, v14

    if-ge v5, v14, :cond_0

    .line 112
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v14

    aget-object v12, v14, v5

    .line 114
    .local v12, "supportedColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    const-string v14, "ff"

    invoke-static {v12, v14}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference;->convertColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;Ljava/lang/String;)I

    move-result v13

    .line 116
    .local v13, "testColor":I
    invoke-static {v13}, Landroid/graphics/Color;->red(I)I

    move-result v14

    sub-int v14, v8, v14

    int-to-double v14, v14

    const-wide/high16 v16, 0x4000000000000000L    # 2.0

    invoke-static/range {v14 .. v17}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v10

    .line 117
    .local v10, "rDiff":D
    invoke-static {v13}, Landroid/graphics/Color;->green(I)I

    move-result v14

    sub-int v14, v4, v14

    int-to-double v14, v14

    const-wide/high16 v16, 0x4000000000000000L    # 2.0

    invoke-static/range {v14 .. v17}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v6

    .line 118
    .local v6, "gDiff":D
    invoke-static {v13}, Landroid/graphics/Color;->blue(I)I

    move-result v14

    sub-int v14, v0, v14

    int-to-double v14, v14

    const-wide/high16 v16, 0x4000000000000000L    # 2.0

    invoke-static/range {v14 .. v17}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v2

    .line 119
    .local v2, "bDiff":D
    add-double v14, v10, v6

    add-double/2addr v14, v2

    invoke-static {v14, v15}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v14

    invoke-static {v14, v15}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v9

    .line 120
    .local v9, "result":Ljava/lang/Double;
    invoke-virtual {v9}, Ljava/lang/Double;->intValue()I

    move-result v14

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    invoke-interface {v1, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 111
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 124
    .end local v2    # "bDiff":D
    .end local v6    # "gDiff":D
    .end local v9    # "result":Ljava/lang/Double;
    .end local v10    # "rDiff":D
    .end local v12    # "supportedColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    .end local v13    # "testColor":I
    :cond_0
    invoke-static {v1}, Ljava/util/Collections;->min(Ljava/util/Collection;)Ljava/lang/Object;

    move-result-object v14

    invoke-interface {v1, v14}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v5

    .line 125
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->values()[Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v14

    add-int/lit8 v15, v5, 0x1

    aget-object v14, v14, v15

    return-object v14
.end method

.method private convertClosedCaptionsEdgeType(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    .locals 1
    .param p1, "edgeType"    # I

    .prologue
    .line 143
    if-nez p1, :cond_0

    .line 144
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->NONE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    .line 151
    :goto_0
    return-object v0

    .line 145
    :cond_0
    const/4 v0, 0x2

    if-ne p1, v0, :cond_1

    .line 146
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DROP_SHADOW_RIGHT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    goto :goto_0

    .line 147
    :cond_1
    const/4 v0, 0x1

    if-ne p1, v0, :cond_2

    .line 148
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->UNIFORM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    goto :goto_0

    .line 151
    :cond_2
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    goto :goto_0
.end method

.method private convertClosedCaptionsFontScale(F)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;
    .locals 6
    .param p1, "fontScale"    # F

    .prologue
    const-wide/high16 v4, 0x3ff8000000000000L    # 1.5

    const-wide/high16 v2, 0x3fe0000000000000L    # 0.5

    .line 155
    float-to-double v0, p1

    cmpg-double v0, v0, v2

    if-gtz v0, :cond_0

    .line 156
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->SMALL:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    .line 163
    :goto_0
    return-object v0

    .line 157
    :cond_0
    float-to-double v0, p1

    cmpl-double v0, v0, v2

    if-lez v0, :cond_1

    float-to-double v0, p1

    cmpg-double v0, v0, v4

    if-gez v0, :cond_1

    .line 158
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->MEDIUM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    goto :goto_0

    .line 159
    :cond_1
    float-to-double v0, p1

    cmpl-double v0, v0, v4

    if-ltz v0, :cond_2

    .line 160
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->LARGE:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    goto :goto_0

    .line 163
    :cond_2
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    goto :goto_0
.end method

.method private convertClosedCaptionsTypeface(Landroid/graphics/Typeface;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
    .locals 1
    .param p1, "typeFace"    # Landroid/graphics/Typeface;

    .prologue
    .line 129
    if-eqz p1, :cond_2

    .line 130
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    invoke-virtual {p1, v0}, Landroid/graphics/Typeface;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITHOUT_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    .line 139
    :goto_0
    return-object v0

    .line 132
    :cond_0
    sget-object v0, Landroid/graphics/Typeface;->SERIF:Landroid/graphics/Typeface;

    invoke-virtual {p1, v0}, Landroid/graphics/Typeface;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 133
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->PROPORTIONAL_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    goto :goto_0

    .line 134
    :cond_1
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    invoke-virtual {p1, v0}, Landroid/graphics/Typeface;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 135
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->MONOSPACED_WITH_SERIFS:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    goto :goto_0

    .line 139
    :cond_2
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->DEFAULT:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    goto :goto_0
.end method

.method private getCCFormatBuilderForCaptionStyle(Landroid/view/accessibility/CaptioningManager$CaptionStyle;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    .locals 8
    .param p1, "captionStyle"    # Landroid/view/accessibility/CaptioningManager$CaptionStyle;
    .annotation build Landroid/annotation/TargetApi;
        value = 0x13
    .end annotation

    .prologue
    .line 64
    iget v7, p1, Landroid/view/accessibility/CaptioningManager$CaptionStyle;->backgroundColor:I

    invoke-static {v7}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->convertClosedCaptionsColor(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v4

    .line 65
    .local v4, "newBackgroundColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    iget v7, p1, Landroid/view/accessibility/CaptioningManager$CaptionStyle;->foregroundColor:I

    invoke-static {v7}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->convertClosedCaptionsColor(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v6

    .line 66
    .local v6, "newFontColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    iget v7, p1, Landroid/view/accessibility/CaptioningManager$CaptionStyle;->edgeColor:I

    invoke-static {v7}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->convertClosedCaptionsColor(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v5

    .line 67
    .local v5, "newEdgeColor":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;
    invoke-virtual {p1}, Landroid/view/accessibility/CaptioningManager$CaptionStyle;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v7

    invoke-direct {p0, v7}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->convertClosedCaptionsTypeface(Landroid/graphics/Typeface;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v2

    .line 68
    .local v2, "font":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;
    iget v7, p1, Landroid/view/accessibility/CaptioningManager$CaptionStyle;->edgeType:I

    invoke-direct {p0, v7}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->convertClosedCaptionsEdgeType(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v3

    .line 70
    .local v3, "fontEdge":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    iget v7, p1, Landroid/view/accessibility/CaptioningManager$CaptionStyle;->backgroundColor:I

    invoke-static {v7}, Landroid/graphics/Color;->alpha(I)I

    move-result v0

    .line 71
    .local v0, "alpha":I
    mul-int/lit8 v7, v0, 0x64

    div-int/lit16 v1, v7, 0xff

    .line 73
    .local v1, "alphaPercentage":I
    new-instance v7, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    invoke-direct {v7}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;-><init>()V

    .line 74
    invoke-virtual {v7, v4}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setBackgroundColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v7

    .line 75
    invoke-virtual {v7, v6}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setFontColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v7

    .line 76
    invoke-virtual {v7, v5}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setEdgeColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v7

    .line 77
    invoke-virtual {v7, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setFont(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v7

    .line 78
    invoke-virtual {v7, v3}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setFontEdge(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v7

    .line 79
    invoke-virtual {v7, v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setBackgroundOpacity(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v7

    return-object v7
.end method


# virtual methods
.method public addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 42
    return-void
.end method

.method public configureAnalytics(Lcom/comcast/playerplatform/analytics/java/util/HostInfo;)V
    .locals 1
    .param p1, "hostInfo"    # Lcom/comcast/playerplatform/analytics/java/util/HostInfo;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->configureAnalytics(Lcom/comcast/playerplatform/analytics/java/util/HostInfo;)V

    .line 184
    return-void
.end method

.method public configureAuditudeAds()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->configureAuditudeAds()V

    .line 180
    return-void
.end method

.method public configureC3Ads(Ljava/util/List;)V
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
    .line 175
    .local p1, "adBreaks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->configureC3Ads(Ljava/util/List;)V

    .line 176
    return-void
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 288
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->destroy()V

    .line 289
    return-void
.end method

.method public getAutoPlay()Z
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAutoPlay()Z

    move-result v0

    return v0
.end method

.method public getAvailableBitrates()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 256
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAvailableBitrates()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getAvailableLanguages()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 242
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAvailableAudioLanguages()Ljava/util/List;

    move-result-object v0

    .line 243
    .local v0, "audioTracks":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;>;"
    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 244
    .local v1, "languageList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    .line 245
    .local v2, "track":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 248
    .end local v2    # "track":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;
    :cond_0
    return-object v1
.end method

.method public getCurrentAdDuration()J
    .locals 2

    .prologue
    .line 260
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->getDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 226
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getLanguage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAudioTrack()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;->getLanguage()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    return-object v0
.end method

.method public getPosition()J
    .locals 2

    .prologue
    .line 195
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentPosition()J

    move-result-wide v0

    return-wide v0
.end method

.method public getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v0

    return-object v0
.end method

.method public getView()Landroid/view/View;
    .locals 1

    .prologue
    .line 187
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getView()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public hasCC()Z
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->hasCC()Z

    move-result v0

    return v0
.end method

.method public isAdPlaying()Z
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isAdPlaying()Z

    move-result v0

    return v0
.end method

.method public isCurrentAdClickable()Z
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->isAdPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getCurrentAd()Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/ads/VideoAd;->isClickable()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public pause()V
    .locals 1

    .prologue
    .line 280
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->pause()V

    .line 281
    return-void
.end method

.method public play()V
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->play()V

    .line 277
    return-void
.end method

.method public prepare(Lcom/comcast/playerplatform/primetime/android/asset/Asset;Ljava/lang/Long;)V
    .locals 0
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "startPosition"    # Ljava/lang/Long;

    .prologue
    .line 272
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;Ljava/lang/Long;)V

    .line 273
    return-void
.end method

.method public removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V
    .locals 1
    .param p1, "videoEventListener"    # Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 46
    return-void
.end method

.method public setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;Ljava/lang/Long;)V
    .locals 4
    .param p1, "asset"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .param p2, "startPosition"    # Ljava/lang/Long;

    .prologue
    .line 171
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {p2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v0, p1, v2, v3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;J)V

    .line 172
    return-void
.end method

.method public setAutoPlay(Z)V
    .locals 2
    .param p1, "flag"    # Z

    .prologue
    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setAutoPlay(Ljava/lang/Boolean;)V

    .line 54
    return-void
.end method

.method public setBitrateParameters(Lcom/comcast/playerplatform/util/android/BitrateParameters;)V
    .locals 1
    .param p1, "bitrateParameters"    # Lcom/comcast/playerplatform/util/android/BitrateParameters;

    .prologue
    .line 252
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setBitrateParameters(Lcom/comcast/playerplatform/util/android/BitrateParameters;)V

    .line 253
    return-void
.end method

.method public setCCEnabled(Z)V
    .locals 4
    .param p1, "enable"    # Z

    .prologue
    const/4 v2, 0x0

    .line 214
    if-eqz p1, :cond_2

    .line 215
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAvailableClosedCaptionTracks()Ljava/util/List;

    move-result-object v0

    .line 216
    .local v0, "ccTrackList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    invoke-virtual {v3, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setClosedCaptionsEnabled(Z)V

    .line 217
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 218
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;

    invoke-virtual {v3, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setClosedCaptionsTrack(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;)V

    .line 223
    .end local v0    # "ccTrackList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    :cond_0
    :goto_1
    return-void

    .restart local v0    # "ccTrackList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    :cond_1
    move v1, v2

    .line 216
    goto :goto_0

    .line 221
    .end local v0    # "ccTrackList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerClosedCaptionsTrack;>;"
    :cond_2
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v1, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setClosedCaptionsEnabled(Z)V

    goto :goto_1
.end method

.method public setDimensionsOfVideo(II)V
    .locals 1
    .param p1, "widthPixels"    # I
    .param p2, "heightPixels"    # I

    .prologue
    .line 284
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1, p2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setDimensionsOfVideo(II)V

    .line 285
    return-void
.end method

.method public setLanguage(I)V
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 199
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->getAvailableAudioLanguages()Ljava/util/List;

    move-result-object v0

    .line 200
    .local v0, "languageList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-le v1, p1, :cond_0

    .line 201
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setPreferredAudioLanguage(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerAudioTrack;)V

    .line 203
    :cond_0
    return-void
.end method

.method public setPlayerAdBreakPolicies(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;)V
    .locals 1
    .param p1, "playerAdBreakPolicies"    # Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setPlayerAdBreakPolicies(Lcom/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies;)V

    .line 50
    return-void
.end method

.method public setPlayerStatus(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;)V
    .locals 0
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .prologue
    .line 231
    return-void
.end method

.method public setPosition(JZ)V
    .locals 1
    .param p1, "seconds"    # J
    .param p3, "skipAds"    # Z

    .prologue
    .line 191
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setPosition(JZ)V

    .line 192
    return-void
.end method

.method public styleClosedCaptions(Landroid/view/accessibility/CaptioningManager;)V
    .locals 2
    .param p1, "captioningManager"    # Landroid/view/accessibility/CaptioningManager;

    .prologue
    .line 57
    invoke-virtual {p1}, Landroid/view/accessibility/CaptioningManager;->getUserStyle()Landroid/view/accessibility/CaptioningManager$CaptionStyle;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getCCFormatBuilderForCaptionStyle(Landroid/view/accessibility/CaptioningManager$CaptionStyle;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v0

    .line 58
    .local v0, "options":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    invoke-virtual {p1}, Landroid/view/accessibility/CaptioningManager;->getFontScale()F

    move-result v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->convertClosedCaptionsFontScale(F)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setSize(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    .line 59
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setClosedCaptionsOptions(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;)V

    .line 60
    return-void
.end method

.method public styleClosedCaptions(Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 3
    .param p1, "userSettings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 90
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    invoke-direct {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;-><init>()V

    .line 91
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getCCTextColor()I

    move-result v2

    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setFontColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v1

    .line 92
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getCCEdgeColor()I

    move-result v2

    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setEdgeColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v1

    .line 93
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getCCFontFamily()I

    move-result v2

    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setFont(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v1

    .line 94
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getCCTextSize()I

    move-result v2

    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setSize(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v1

    .line 95
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getCCEdgeType()I

    move-result v2

    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setFontEdge(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v1

    .line 96
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getCCBackgroundColor()I

    move-result v2

    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;->valueOfOrdinal(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setBackgroundColor(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color;)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v1

    .line 97
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getCCBackgroundOpacity()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;->setBackgroundOpacity(I)Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;

    move-result-object v0

    .line 99
    .local v0, "options":Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->mediaPlayer:Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    invoke-virtual {v1, v0}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;->setClosedCaptionsOptions(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionFormatBuilder;)V

    .line 100
    return-void
.end method
