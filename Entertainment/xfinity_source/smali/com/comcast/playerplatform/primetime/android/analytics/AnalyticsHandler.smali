.class public Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;
.super Ljava/lang/Object;
.source "AnalyticsHandler.java"

# interfaces
.implements Lcom/comcast/playerplatform/primetime/android/analytics/PlayerAnalytics;


# instance fields
.field private adProgressFlags:[Z

.field private final analyticsProvider:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;)V
    .locals 1
    .param p1, "provider"    # Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    const/4 v0, 0x5

    new-array v0, v0, [Z

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->adProgressFlags:[Z

    .line 51
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->analyticsProvider:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    .line 52
    return-void
.end method

.method static synthetic access$000(Landroid/content/Context;)Landroid/graphics/Point;
    .locals 1
    .param p0, "x0"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;)J
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;
    .param p1, "x1"    # Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    return-void
.end method

.method private static getDisplaySize(Landroid/content/Context;)Landroid/graphics/Point;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 232
    const-string v2, "window"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .line 233
    .local v1, "wm":Landroid/view/WindowManager;
    new-instance v0, Landroid/graphics/Point;

    invoke-direct {v0}, Landroid/graphics/Point;-><init>()V

    .line 234
    .local v0, "size":Landroid/graphics/Point;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 235
    return-object v0
.end method

.method private now()J
    .locals 2

    .prologue
    .line 240
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method

.method private resetAdProgressFlags()V
    .locals 3

    .prologue
    .line 189
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    const/4 v1, 0x5

    if-ge v0, v1, :cond_0

    .line 190
    iget-object v1, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->adProgressFlags:[Z

    const/4 v2, 0x0

    aput-boolean v2, v1, v0

    .line 189
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 192
    :cond_0
    return-void
.end method

.method private sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V
    .locals 1
    .param p1, "message"    # Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->analyticsProvider:Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/analytics/java/AnalyticsProvider;->buildMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 245
    return-void
.end method


# virtual methods
.method public adProgress(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 6
    .param p1, "percentComplete"    # I
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 173
    div-int/lit8 v0, p1, 0x19

    .line 174
    .local v0, "adProgressFlagIndex":I
    mul-int/lit8 v1, v0, 0x19

    .line 177
    .local v1, "adProgressTarget":I
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->adProgressFlags:[Z

    aget-boolean v2, v2, v0

    if-nez v2, :cond_0

    if-lt p1, v1, :cond_0

    .line 178
    new-instance v2, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/AdProgressMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v4

    invoke-direct {v2, v4, v5, v1, p2}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/AdProgressMessage;-><init>(JILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v2}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 179
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->adProgressFlags:[Z

    const/4 v3, 0x1

    aput-boolean v3, v2, v0

    .line 183
    :cond_0
    const/16 v2, 0x64

    if-ne p1, v2, :cond_1

    .line 184
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->resetAdProgressFlags()V

    .line 186
    :cond_1
    return-void
.end method

.method public bitrateChanged(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 7
    .param p1, "bitrate"    # J
    .param p3, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 153
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    move-wide v4, p1

    move-object v6, p3

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/BitrateChangedMessage;-><init>(JJLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 154
    return-void
.end method

.method public fragmentWarning(IIILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 10
    .param p1, "downloadDuration"    # I
    .param p2, "fragmentDuration"    # I
    .param p3, "fragmentSize"    # I
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 221
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    const/4 v7, 0x0

    move-object v4, p5

    move-object v5, p4

    move v6, p3

    move v8, p1

    move v9, p2

    invoke-direct/range {v1 .. v9}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/FragmentWarningMessage;-><init>(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Ljava/lang/String;IIII)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 222
    return-void
.end method

.method public heartBeat(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;)V
    .locals 11
    .param p1, "currentPosition"    # Ljava/lang/Long;
    .param p2, "bitrate"    # Ljava/lang/Long;
    .param p3, "fps"    # Ljava/lang/Integer;
    .param p4, "cc"    # Ljava/lang/String;
    .param p5, "sap"    # Ljava/lang/String;
    .param p6, "millisecondsBuffered"    # Ljava/lang/Long;
    .param p7, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .param p8, "fragmentInfo"    # Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;

    .prologue
    .line 85
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v10

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;

    move-object v1, p0

    move-object/from16 v2, p6

    move-object/from16 v3, p8

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    move-object/from16 v8, p5

    move-object/from16 v9, p7

    invoke-direct/range {v0 .. v9}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$2;-><init>(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;Ljava/lang/Long;Lcom/comcast/playerplatform/primetime/android/util/FragmentInfo;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-virtual {v10, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 124
    return-void
.end method

.method public mediaEnded(Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 4
    .param p1, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 148
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    invoke-direct {v0, v2, v3, p1}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaEndedMessage;-><init>(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 149
    return-void
.end method

.method public mediaFailed(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 10
    .param p1, "manifestUrl"    # Ljava/lang/String;
    .param p2, "currentPosition"    # J
    .param p4, "code"    # Ljava/lang/String;
    .param p5, "description"    # Ljava/lang/String;
    .param p6, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 138
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    move-object v4, p4

    move-object v5, p5

    move-wide v6, p2

    move-object v8, p1

    move-object/from16 v9, p6

    invoke-direct/range {v1 .. v9}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaFailedMessage;-><init>(JLjava/lang/String;Ljava/lang/String;JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 139
    return-void
.end method

.method public mediaInfo(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 7
    .param p1, "position"    # I
    .param p2, "description"    # Ljava/lang/String;
    .param p3, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 143
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    move v4, p1

    move-object v5, p2

    move-object v6, p3

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaInfoMessage;-><init>(JILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 144
    return-void
.end method

.method public mediaOpened(Ljava/lang/String;JLjava/lang/Long;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 8
    .param p1, "manifestUrl"    # Ljava/lang/String;
    .param p2, "currentPosition"    # J
    .param p4, "latency"    # Ljava/lang/Long;
    .param p5, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 133
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v1

    move-object v3, p4

    move-wide v4, p2

    move-object v6, p1

    move-object v7, p5

    invoke-direct/range {v0 .. v7}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/MediaOpenedMessage;-><init>(JLjava/lang/Long;JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 134
    return-void
.end method

.method public openingMedia(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 4
    .param p1, "manifestUrl"    # Ljava/lang/String;
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 128
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    invoke-direct {v0, v2, v3, p2, p1}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/OpeningMediaMessage;-><init>(JLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 129
    return-void
.end method

.method public playStateChanged(Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 4
    .param p1, "status"    # Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 163
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->name()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v2, v3, v1, p2}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 164
    return-void
.end method

.method public playStateChanged(Ljava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 4
    .param p1, "status"    # Ljava/lang/String;
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 168
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    invoke-direct {v0, v2, v3, p1, p2}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/PlayStateChangedMessage;-><init>(JLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 169
    return-void
.end method

.method public pluginInitialized(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 57
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;

    invoke-direct {v1, p0, p1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler$1;-><init>(Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 79
    return-void
.end method

.method public retryAttempt(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 9
    .param p1, "code"    # Ljava/lang/String;
    .param p2, "errorClass"    # Ljava/lang/String;
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "retryCount"    # I
    .param p5, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 226
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .line 227
    .local v7, "retryMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v0, "RETRY"

    invoke-static {p4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v7, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 228
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v8, p5

    invoke-direct/range {v1 .. v8}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ErrorMessage;-><init>(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 229
    return-void
.end method

.method public scrubEnded(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 7
    .param p1, "position"    # I
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 206
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ScrubMessageEnded;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    int-to-long v4, p1

    move-object v6, p2

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ScrubMessageEnded;-><init>(JJLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 207
    return-void
.end method

.method public scrubStarted(ILcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 7
    .param p1, "position"    # I
    .param p2, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 201
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ScrubMessageStarted;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    int-to-long v4, p1

    move-object v6, p2

    invoke-direct/range {v1 .. v6}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/ScrubMessageStarted;-><init>(JJLcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 202
    return-void
.end method

.method public trickPlay(ILjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V
    .locals 8
    .param p1, "currentPosition"    # I
    .param p2, "type"    # Ljava/lang/String;
    .param p3, "asset"    # Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    .prologue
    .line 196
    new-instance v1, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;

    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->now()J

    move-result-wide v2

    int-to-long v4, p1

    move-object v6, p2

    move-object v7, p3

    invoke-direct/range {v1 .. v7}, Lcom/comcast/playerplatform/analytics/java/xmessage/messages/TrickPlayMessage;-><init>(JJLjava/lang/String;Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;)V

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsHandler;->sendAnalyticsMessage(Lcom/comcast/playerplatform/analytics/java/xmessage/AbstractXMessageBuilder;)V

    .line 197
    return-void
.end method
