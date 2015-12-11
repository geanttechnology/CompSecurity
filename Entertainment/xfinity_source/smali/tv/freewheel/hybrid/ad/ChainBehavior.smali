.class public abstract Ltv/freewheel/hybrid/ad/ChainBehavior;
.super Ljava/lang/Object;
.source "ChainBehavior.java"


# static fields
.field private static playBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

.field private static preloadBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 7
    sput-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->preloadBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    .line 8
    sput-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->playBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getPlayBehavior()Ltv/freewheel/hybrid/ad/ChainBehavior;
    .locals 1

    .prologue
    .line 18
    sget-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->playBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    if-nez v0, :cond_0

    .line 19
    new-instance v0, Ltv/freewheel/hybrid/ad/PlayChainBehavior;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/PlayChainBehavior;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->playBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    .line 22
    :cond_0
    sget-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->playBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    return-object v0
.end method

.method public static getPreloadBehavior()Ltv/freewheel/hybrid/ad/ChainBehavior;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->preloadBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    if-nez v0, :cond_0

    .line 12
    new-instance v0, Ltv/freewheel/hybrid/ad/PreloadChainBehavior;

    invoke-direct {v0}, Ltv/freewheel/hybrid/ad/PreloadChainBehavior;-><init>()V

    sput-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->preloadBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    .line 14
    :cond_0
    sget-object v0, Ltv/freewheel/hybrid/ad/ChainBehavior;->preloadBehavior:Ltv/freewheel/hybrid/ad/ChainBehavior;

    return-object v0
.end method


# virtual methods
.method public abstract isChainStopper(Ltv/freewheel/hybrid/ad/AdInstance;)Z
.end method

.method public abstract isDestState(Ltv/freewheel/hybrid/ad/state/AdState;)Z
.end method

.method public abstract relatedSlotState()Ltv/freewheel/hybrid/ad/state/SlotState;
.end method
