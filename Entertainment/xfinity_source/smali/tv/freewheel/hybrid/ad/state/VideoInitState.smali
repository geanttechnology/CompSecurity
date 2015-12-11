.class public Ltv/freewheel/hybrid/ad/state/VideoInitState;
.super Ltv/freewheel/hybrid/ad/state/VideoState;
.source "VideoInitState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/VideoInitState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/VideoInitState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/VideoInitState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/VideoInitState;->instance:Ltv/freewheel/hybrid/ad/state/VideoInitState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/state/VideoState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/hybrid/ad/state/VideoState;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Ltv/freewheel/hybrid/ad/state/VideoInitState;->instance:Ltv/freewheel/hybrid/ad/state/VideoInitState;

    return-object v0
.end method


# virtual methods
.method public play(Ltv/freewheel/hybrid/ad/VideoAsset;)V
    .locals 2
    .param p1, "video"    # Ltv/freewheel/hybrid/ad/VideoAsset;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/VideoInitState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "play"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/VideoAsset;->isReadyToStart()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 15
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/VideoPlayingState;->Instance()Ltv/freewheel/hybrid/ad/state/VideoState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    .line 16
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/VideoAsset;->onStartPlay()V

    .line 20
    :goto_0
    return-void

    .line 18
    :cond_0
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/VideoPendingState;->Instance()Ltv/freewheel/hybrid/ad/state/VideoState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    goto :goto_0
.end method
