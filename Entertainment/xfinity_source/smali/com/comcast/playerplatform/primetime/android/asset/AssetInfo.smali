.class public Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
.super Ljava/lang/Object;
.source "AssetInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$1;,
        Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;
    }
.end annotation


# instance fields
.field private assetId:Ljava/lang/String;

.field private channel:Ljava/lang/String;

.field private episode:Ljava/lang/String;

.field private mediaGuid:Ljava/lang/String;

.field private mediaId:Ljava/lang/String;

.field private moneyTraceId:Ljava/lang/String;

.field private namespace:Ljava/lang/String;

.field private program:Ljava/lang/String;

.field private providerId:Ljava/lang/String;

.field private recordingId:Ljava/lang/String;

.field private streamId:Ljava/lang/String;

.field private tId:Ljava/lang/String;


# direct methods
.method private constructor <init>(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)V
    .locals 1
    .param p1, "builder"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->assetId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$000(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->assetId:Ljava/lang/String;

    .line 23
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->providerId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$100(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->providerId:Ljava/lang/String;

    .line 24
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->recordingId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$200(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->recordingId:Ljava/lang/String;

    .line 25
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->streamId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$300(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->streamId:Ljava/lang/String;

    .line 26
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->moneyTraceId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$400(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->moneyTraceId:Ljava/lang/String;

    .line 27
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->namespace:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$500(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->namespace:Ljava/lang/String;

    .line 28
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->program:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$600(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->program:Ljava/lang/String;

    .line 29
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->episode:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$700(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->episode:Ljava/lang/String;

    .line 30
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->channel:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$800(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->channel:Ljava/lang/String;

    .line 31
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->mediaId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$900(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->mediaId:Ljava/lang/String;

    .line 32
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->moneyTraceId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$400(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->moneyTraceId:Ljava/lang/String;

    .line 33
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->tId:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$1000(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->tId:Ljava/lang/String;

    .line 34
    # getter for: Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->mediaGuid:Ljava/lang/String;
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->access$1100(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->mediaGuid:Ljava/lang/String;

    .line 35
    return-void
.end method

.method synthetic constructor <init>(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;
    .param p2, "x1"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$1;

    .prologue
    .line 6
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;-><init>(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)V

    return-void
.end method


# virtual methods
.method public getAssetId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->assetId:Ljava/lang/String;

    return-object v0
.end method

.method public getChannel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->channel:Ljava/lang/String;

    return-object v0
.end method

.method public getEpisode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->episode:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaGuid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->mediaGuid:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->mediaId:Ljava/lang/String;

    return-object v0
.end method

.method public getMoneyTraceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->moneyTraceId:Ljava/lang/String;

    return-object v0
.end method

.method public getNamespace()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->namespace:Ljava/lang/String;

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->program:Ljava/lang/String;

    return-object v0
.end method

.method public getProviderId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->providerId:Ljava/lang/String;

    return-object v0
.end method

.method public getRecordingId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->recordingId:Ljava/lang/String;

    return-object v0
.end method

.method public getStreamId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->streamId:Ljava/lang/String;

    return-object v0
.end method

.method public gettId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;->tId:Ljava/lang/String;

    return-object v0
.end method
