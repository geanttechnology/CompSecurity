.class public Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.super Ljava/lang/Object;
.source "Asset.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;,
        Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;
    }
.end annotation


# instance fields
.field private adData:Lcom/comcast/playerplatform/primetime/android/asset/AdData;

.field private assetInfo:Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

.field public authCookieName:Ljava/lang/String;

.field public authCookieValue:Ljava/lang/String;

.field private channelName:Ljava/lang/String;

.field private disneyEspnTokenDelegate:Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

.field private drmKey:Ljava/lang/String;

.field private drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

.field private eventId:Ljava/lang/String;

.field public manifestUri:Ljava/lang/String;

.field private moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

.field private networkId:Ljava/lang/String;

.field private resumePoint:J

.field private streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

.field private type:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)V
    .locals 2
    .param p1, "builder"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->PRIMETIME:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->type:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 89
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->manifestUrl:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$000(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->manifestUri:Ljava/lang/String;

    .line 90
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->drmKey:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$100(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->drmKey:Ljava/lang/String;

    .line 91
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$200(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 92
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->channelName:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$300(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->channelName:Ljava/lang/String;

    .line 93
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->networkId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$400(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->networkId:Ljava/lang/String;

    .line 94
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->eventId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$500(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->eventId:Ljava/lang/String;

    .line 95
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->disneyEspnTokenDelegate:Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$600(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->disneyEspnTokenDelegate:Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .line 96
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->resumePoint:J
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$700(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->resumePoint:J

    .line 97
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->assetInfo:Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$800(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->assetInfo:Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    .line 98
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->adData:Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$900(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->adData:Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    .line 99
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$1000(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/util/android/MoneyTrace;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .line 100
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->playerType:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$1100(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->type:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 101
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->access$1200(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    .line 102
    return-void
.end method


# virtual methods
.method public buildXuaAsset()Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;
    .locals 1

    .prologue
    .line 212
    invoke-static {p0}, Lcom/comcast/playerplatform/primetime/android/analytics/AnalyticsAssetUtil;->convertPlayerAssetToXuaAsset(Lcom/comcast/playerplatform/primetime/android/asset/Asset;)Lcom/comcast/playerplatform/analytics/java/xua/AbstractXuaAsset;

    move-result-object v0

    return-object v0
.end method

.method public getAdData()Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    .locals 1

    .prologue
    .line 246
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->adData:Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    return-object v0
.end method

.method public getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->assetInfo:Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    return-object v0
.end method

.method public getAssetOptionsAsDictionary()Ljava/util/Map;
    .locals 4
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
    .line 122
    new-instance v1, Ljava/util/Hashtable;

    invoke-direct {v1}, Ljava/util/Hashtable;-><init>()V

    .line 124
    .local v1, "dictionary":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v0

    .line 125
    .local v0, "assetInfo":Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    if-eqz v0, :cond_6

    .line 126
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 127
    const-string v2, "assetId"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    :cond_0
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 131
    const-string v2, "providerId"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    :cond_1
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 135
    const-string v2, "mediaID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 138
    :cond_2
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 139
    const-string v2, "tPID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    :cond_3
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 143
    const-string v2, "recordingID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    :cond_4
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 147
    const-string v2, "streamId"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 150
    :cond_5
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaGuid()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 151
    const-string v2, "MediaGUID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaGuid()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    :cond_6
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_7

    .line 156
    const-string v2, "drmKey"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmKey()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 159
    :cond_7
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmWorkflow()Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    move-result-object v2

    if-eqz v2, :cond_8

    .line 160
    const-string v2, "drmWorkflow"

    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getDrmWorkflow()Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->name()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 163
    :cond_8
    return-object v1
.end method

.method public getChannelName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->channelName:Ljava/lang/String;

    return-object v0
.end method

.method public getDisneyEspnTokenDelegate()Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->disneyEspnTokenDelegate:Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    return-object v0
.end method

.method public getDrmKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->drmKey:Ljava/lang/String;

    return-object v0
.end method

.method public getDrmWorkflow()Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .locals 1

    .prologue
    .line 250
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    return-object v0
.end method

.method public getEventId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->eventId:Ljava/lang/String;

    return-object v0
.end method

.method public getIdMap()Ljava/util/Map;
    .locals 4
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
    .line 171
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 173
    .local v1, "dictionary":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->getAssetInfo()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v0

    .line 174
    .local v0, "assetInfo":Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    if-eqz v0, :cond_6

    .line 175
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 176
    const-string v2, "assetId"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getAssetId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    :cond_0
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 180
    const-string v2, "providerId"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getProviderId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 183
    :cond_1
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 184
    const-string v2, "mediaID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 187
    :cond_2
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 188
    const-string v2, "tPID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->gettId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 191
    :cond_3
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_4

    .line 192
    const-string v2, "recordingID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getRecordingId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 195
    :cond_4
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 196
    const-string v2, "streamId"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getStreamId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 199
    :cond_5
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaGuid()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 200
    const-string v2, "MediaGUID"

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->getMediaGuid()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 204
    :cond_6
    return-object v1
.end method

.method public getManifestUri()Ljava/lang/String;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->manifestUri:Ljava/lang/String;

    return-object v0
.end method

.method public getMoneyTrace()Lcom/comcast/playerplatform/util/android/MoneyTrace;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    return-object v0
.end method

.method public getMoneyTraceId()Lcom/comcast/playerplatform/util/android/MoneyTrace;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    return-object v0
.end method

.method public getNetworkId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 231
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->networkId:Ljava/lang/String;

    return-object v0
.end method

.method public getResumePoint()J
    .locals 2

    .prologue
    .line 242
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->resumePoint:J

    return-wide v0
.end method

.method public getStreamType()Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1

    .prologue
    .line 262
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    return-object v0
.end method

.method public getType()Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->type:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    return-object v0
.end method

.method public setChannelName(Ljava/lang/String;)V
    .locals 0
    .param p1, "channelName"    # Ljava/lang/String;

    .prologue
    .line 278
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->channelName:Ljava/lang/String;

    .line 279
    return-void
.end method

.method public setDrmKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "drmKey"    # Ljava/lang/String;

    .prologue
    .line 224
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->drmKey:Ljava/lang/String;

    .line 225
    return-void
.end method

.method public setDrmWorkflow(Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)V
    .locals 0
    .param p1, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .prologue
    .line 274
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 275
    return-void
.end method

.method public setEventId(Ljava/lang/String;)V
    .locals 0
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 284
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->eventId:Ljava/lang/String;

    .line 285
    return-void
.end method

.method public setManifestUri(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUri"    # Ljava/lang/String;

    .prologue
    .line 270
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->manifestUri:Ljava/lang/String;

    .line 271
    return-void
.end method

.method public setMoneytraceId(Ljava/lang/String;)V
    .locals 1
    .param p1, "moneyTraceId"    # Ljava/lang/String;

    .prologue
    .line 110
    new-instance v0, Lcom/comcast/playerplatform/util/android/MoneyTrace;

    invoke-direct {v0, p1}, Lcom/comcast/playerplatform/util/android/MoneyTrace;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    .line 111
    return-void
.end method

.method public setNetworkId(Ljava/lang/String;)V
    .locals 0
    .param p1, "networkId"    # Ljava/lang/String;

    .prologue
    .line 281
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset;->networkId:Ljava/lang/String;

    return-void
.end method
