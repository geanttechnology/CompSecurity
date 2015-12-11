.class public Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset;
.super Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.source "CimVodAsset.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "isAms"    # Z
    .param p4, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .param p5, "tId"    # Ljava/lang/String;
    .param p6, "mediaId"    # Ljava/lang/String;

    .prologue
    .line 28
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/primetime/android/asset/CimVodAsset$Builder;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;-><init>(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)V

    .line 34
    return-void
.end method
