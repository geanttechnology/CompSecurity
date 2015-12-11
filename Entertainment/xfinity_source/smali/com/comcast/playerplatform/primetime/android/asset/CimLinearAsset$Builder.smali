.class public Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;
.super Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;
.source "CimLinearAsset.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;)V
    .locals 1
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "isAMS"    # Z
    .param p4, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .param p5, "streamId"    # Ljava/lang/String;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;-><init>()V

    .line 60
    invoke-virtual {p0, p1}, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;->withManifest(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 61
    invoke-virtual {p0, p4}, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;->withDrmWorkflow(Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 62
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    invoke-direct {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;-><init>()V

    invoke-virtual {v0, p5}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->withStreamId(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo$Builder;->build()Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;->withAssetInfo(Lcom/comcast/playerplatform/primetime/android/asset/AssetInfo;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 65
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/StreamType;->LINEAR:Lcom/comcast/playerplatform/primetime/android/enums/StreamType;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;->asStreamType(Lcom/comcast/playerplatform/primetime/android/enums/StreamType;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 67
    if-eqz p3, :cond_0

    .line 68
    invoke-virtual {p0, p2}, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;->withCustomDRMKey(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;

    .line 70
    :cond_0
    return-void
.end method
