.class public Ltv/freewheel/ad/state/VideoState;
.super Ljava/lang/Object;
.source "VideoState.java"


# instance fields
.field protected logger:Ltv/freewheel/utils/Logger;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/ad/state/VideoState;->logger:Ltv/freewheel/utils/Logger;

    return-void
.end method


# virtual methods
.method public play(Ltv/freewheel/ad/VideoAsset;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/ad/VideoAsset;

    .prologue
    .line 9
    iget-object v0, p0, Ltv/freewheel/ad/state/VideoState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "invalid action: play"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 10
    return-void
.end method

.method public stop(Ltv/freewheel/ad/VideoAsset;)V
    .locals 2
    .param p1, "slot"    # Ltv/freewheel/ad/VideoAsset;

    .prologue
    .line 15
    iget-object v0, p0, Ltv/freewheel/ad/state/VideoState;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "invalid action: stop"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    .line 16
    return-void
.end method
