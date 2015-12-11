.class Ltv/freewheel/hybrid/StreamStitcherHelper$5;
.super Ljava/lang/Object;
.source "StreamStitcherHelper.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/StreamStitcherHelper;->resetCuePointSlotsInTimeline(Ltv/freewheel/hybrid/ad/interfaces/ISlot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Ltv/freewheel/hybrid/ad/interfaces/ISlot;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/StreamStitcherHelper;)V
    .locals 0

    .prologue
    .line 505
    iput-object p1, p0, Ltv/freewheel/hybrid/StreamStitcherHelper$5;->this$0:Ltv/freewheel/hybrid/StreamStitcherHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 505
    check-cast p1, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Ltv/freewheel/hybrid/StreamStitcherHelper$5;->compare(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/ISlot;)I

    move-result v0

    return v0
.end method

.method public compare(Ltv/freewheel/hybrid/ad/interfaces/ISlot;Ltv/freewheel/hybrid/ad/interfaces/ISlot;)I
    .locals 4
    .param p1, "slot1"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;
    .param p2, "slot2"    # Ltv/freewheel/hybrid/ad/interfaces/ISlot;

    .prologue
    .line 507
    invoke-interface {p1}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    invoke-interface {p2}, Ltv/freewheel/hybrid/ad/interfaces/ISlot;->getTimePosition()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Double;->compareTo(Ljava/lang/Double;)I

    move-result v0

    return v0
.end method
