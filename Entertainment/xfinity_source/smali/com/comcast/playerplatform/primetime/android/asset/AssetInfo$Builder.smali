.class public Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;
.super Ljava/lang/Object;
.source "AssetInfo.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
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
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 100
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 102
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->assetId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->providerId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->tId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->mediaGuid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->recordingId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->streamId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->moneyTraceId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->namespace:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->program:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->episode:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->channel:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$900(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->mediaId:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public build()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    .locals 2

    .prologue
    .line 166
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;-><init>(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$1;)V

    return-object v0
.end method

.method public withMediaId(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;
    .locals 0
    .param p1, "mediaId"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->mediaId:Ljava/lang/String;

    .line 152
    return-object p0
.end method

.method public withStreamId(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;
    .locals 0
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->streamId:Ljava/lang/String;

    .line 122
    return-object p0
.end method

.method public withTid(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;
    .locals 0
    .param p1, "tId"    # Ljava/lang/String;

    .prologue
    .line 156
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->tId:Ljava/lang/String;

    .line 157
    return-object p0
.end method
