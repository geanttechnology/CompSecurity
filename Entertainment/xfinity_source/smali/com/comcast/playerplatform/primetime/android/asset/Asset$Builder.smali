.class public Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
.super Ljava/lang/Object;
.source "Asset.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private adData:Lcom/comcast/playerplatform/primetime/android/asset/AdData;

.field private assetInfo:Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

.field private channelName:Ljava/lang/String;

.field private disneyEspnTokenDelegate:Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

.field private drmKey:Ljava/lang/String;

.field private drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

.field private eventId:Ljava/lang/String;

.field private manifestUrl:Ljava/lang/String;

.field private moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

.field private networkId:Ljava/lang/String;

.field private playerType:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

.field private resumePoint:J

.field private streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 312
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 297
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->resumePoint:J

    .line 298
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->VOD:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    .line 300
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->PRIMETIME:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->playerType:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 301
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 314
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->drmKey:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/util/android/MoneyTrace;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->moneyTrace:Lcom/comcast/playerplatform/util/android/MoneyTrace;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->playerType:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/enums/StreamType;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->channelName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->networkId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->eventId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->disneyEspnTokenDelegate:Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)J
    .locals 2
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-wide v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->resumePoint:J

    return-wide v0
.end method

.method static synthetic access$800(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->assetInfo:Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    return-object v0
.end method

.method static synthetic access$900(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)Lcom/comcast/playerplatform/primetime/android/asset/AdData;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .prologue
    .line 294
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->adData:Lcom/comcast/playerplatform/primetime/android/asset/AdData;

    return-object v0
.end method


# virtual methods
.method public asStreamType(Lcom/comcast/playerplatform/primetime/android/enums/StreamType;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 0
    .param p1, "streamType"    # Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    .prologue
    .line 366
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->streamType:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    .line 367
    return-object p0
.end method

.method public forDisney(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 1
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "networkId"    # Ljava/lang/String;

    .prologue
    .line 339
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->channelName:Ljava/lang/String;

    .line 340
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->networkId:Ljava/lang/String;

    .line 341
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->DISNEY:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->playerType:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 342
    return-object p0
.end method

.method public forEspn(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 1
    .param p1, "channelName"    # Ljava/lang/String;
    .param p2, "eventId"    # Ljava/lang/String;

    .prologue
    .line 332
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->channelName:Ljava/lang/String;

    .line 333
    iput-object p2, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->eventId:Ljava/lang/String;

    .line 334
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->ESPN:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    iput-object v0, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->playerType:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 335
    return-object p0
.end method

.method public withAssetInfo(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 0
    .param p1, "assetInfo"    # Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    .prologue
    .line 356
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->assetInfo:Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    .line 357
    return-object p0
.end method

.method public withCustomDRMKey(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 0
    .param p1, "drmKey"    # Ljava/lang/String;

    .prologue
    .line 322
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->drmKey:Ljava/lang/String;

    .line 323
    return-object p0
.end method

.method public withDisneyEspnTokenDelegate(Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 0
    .param p1, "disneyEspnTokenDelegate"    # Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .prologue
    .line 346
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->disneyEspnTokenDelegate:Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;

    .line 347
    return-object p0
.end method

.method public withDrmWorkflow(Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 0
    .param p1, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .prologue
    .line 327
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->drmWorkflow:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    .line 328
    return-object p0
.end method

.method public withManifest(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
    .locals 0
    .param p1, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 317
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;->manifestUrl:Ljava/lang/String;

    .line 318
    return-object p0
.end method
