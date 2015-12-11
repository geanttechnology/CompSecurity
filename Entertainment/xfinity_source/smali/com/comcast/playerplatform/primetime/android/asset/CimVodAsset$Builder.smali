.class public Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;
.super Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
.source "CimVodAsset.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "isAms"    # Z
    .param p4, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .param p5, "tId"    # Ljava/lang/String;
    .param p6, "mediaId"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;-><init>()V

    .line 38
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;->withManifest(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 39
    invoke-virtual {p0, p4}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;->withDrmWorkflow(Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 40
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;-><init>()V

    invoke-virtual {v0, p6}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->withMediaId(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    move-result-object v0

    invoke-virtual {v0, p5}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->withTid(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->build()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;->withAssetInfo(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 43
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->VOD:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;->asStreamType(Lcom/comcast/playerplatform/primetime/android/enums/StreamType;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 44
    invoke-virtual {p0, p2}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;->withCustomDRMKey(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 45
    return-void
.end method
