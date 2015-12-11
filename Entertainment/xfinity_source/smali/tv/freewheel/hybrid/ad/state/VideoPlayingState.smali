.class public Ltv/freewheel/hybrid/ad/state/VideoPlayingState;
.super Ltv/freewheel/hybrid/ad/state/VideoState;
.source "VideoPlayingState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/VideoPlayingState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    new-instance v0, Ltv/freewheel/hybrid/ad/state/VideoPlayingState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/VideoPlayingState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/VideoPlayingState;->instance:Ltv/freewheel/hybrid/ad/state/VideoPlayingState;

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
    sget-object v0, Ltv/freewheel/hybrid/ad/state/VideoPlayingState;->instance:Ltv/freewheel/hybrid/ad/state/VideoPlayingState;

    return-object v0
.end method
