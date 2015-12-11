.class public Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset;
.super Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.source "CimLinearAsset.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;)V
    .locals 6
    .param p1, "manifestUri"    # Ljava/lang/String;
    .param p2, "drmKey"    # Ljava/lang/String;
    .param p3, "isAMS"    # Z
    .param p4, "drmWorkflow"    # Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;
    .param p5, "streamId"    # Ljava/lang/String;

    .prologue
    .line 39
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/comcast/playerplatform/primetime/android/asset/CimLinearAsset$Builder;-><init>(Ljava/lang/String;Ljava/lang/String;ZLcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/comcast/playerplatform/primetime/android/asset/Asset;-><init>(Lcom/comcast/playerplatform/primetime/android/asset/Asset$Builder;)V

    .line 40
    return-void
.end method
