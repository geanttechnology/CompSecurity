.class public Ltv/freewheel/hybrid/ad/state/RendererFailedState;
.super Ltv/freewheel/hybrid/ad/state/RendererState;
.source "RendererFailedState.java"


# static fields
.field private static final instance:Ltv/freewheel/hybrid/ad/state/RendererFailedState;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 4
    new-instance v0, Ltv/freewheel/hybrid/ad/state/RendererFailedState;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/state/RendererFailedState;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/state/RendererFailedState;->instance:Ltv/freewheel/hybrid/ad/state/RendererFailedState;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ltv/freewheel/hybrid/ad/state/RendererState;-><init>()V

    return-void
.end method

.method public static Instance()Ltv/freewheel/hybrid/ad/state/RendererState;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Ltv/freewheel/hybrid/ad/state/RendererFailedState;->instance:Ltv/freewheel/hybrid/ad/state/RendererFailedState;

    return-object v0
.end method
