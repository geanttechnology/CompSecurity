.class public Ltv/freewheel/hybrid/ad/state/VideoPausedState;
.super Ltv/freewheel/hybrid/ad/state/VideoState;
.source "VideoPausedState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/VideoPausedState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/VideoPausedState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/VideoPausedState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/VideoPausedState;->instance:Ltv/freewheel/hybrid/ad/state/VideoPausedState;

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
    sget-object v0, Ltv/freewheel/hybrid/ad/state/VideoPausedState;->instance:Ltv/freewheel/hybrid/ad/state/VideoPausedState;

    return-object v0
.end method


# virtual methods
.method public play(Ltv/freewheel/hybrid/ad/VideoAsset;)V
    .locals 2
    .param p1, "video"    # Ltv/freewheel/hybrid/ad/VideoAsset;

    .prologue
    .line 13
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/state/VideoPausedState;->logger:Ltv/freewheel/hybrid/utils/Logger;

    const-string v1, "play"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 14
    invoke-static {}, Ltv/freewheel/hybrid/ad/state/VideoPlayingState;->Instance()Ltv/freewheel/hybrid/ad/state/VideoState;

    move-result-object v0

    iput-object v0, p1, Ltv/freewheel/hybrid/ad/VideoAsset;->state:Ltv/freewheel/hybrid/ad/state/VideoState;

    .line 15
    invoke-virtual {p1}, Ltv/freewheel/hybrid/ad/VideoAsset;->onResumePlay()V

    .line 16
    return-void
.end method
