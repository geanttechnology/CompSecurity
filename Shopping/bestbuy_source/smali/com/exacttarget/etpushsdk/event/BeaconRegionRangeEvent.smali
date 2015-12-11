.class public Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private accuracy:D

.field private proximity:I

.field private region:Lcom/exacttarget/etpushsdk/data/Region;

.field private rssi:I


# direct methods
.method public constructor <init>(Lcom/exacttarget/etpushsdk/data/Region;IID)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->region:Lcom/exacttarget/etpushsdk/data/Region;

    .line 27
    iput p2, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->proximity:I

    .line 28
    iput p3, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->rssi:I

    .line 29
    iput-wide p4, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->accuracy:D

    .line 30
    return-void
.end method


# virtual methods
.method public getAccuracy()D
    .locals 2

    .prologue
    .line 57
    iget-wide v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->accuracy:D

    return-wide v0
.end method

.method public getProximity()I
    .locals 1

    .prologue
    .line 41
    iget v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->proximity:I

    return v0
.end method

.method public getRegion()Lcom/exacttarget/etpushsdk/data/Region;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->region:Lcom/exacttarget/etpushsdk/data/Region;

    return-object v0
.end method

.method public getRssi()I
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->rssi:I

    return v0
.end method

.method public setAccuracy(D)V
    .locals 1

    .prologue
    .line 61
    iput-wide p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->accuracy:D

    .line 62
    return-void
.end method

.method public setProximity(I)V
    .locals 0

    .prologue
    .line 45
    iput p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->proximity:I

    .line 46
    return-void
.end method

.method public setRegion(Lcom/exacttarget/etpushsdk/data/Region;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->region:Lcom/exacttarget/etpushsdk/data/Region;

    .line 38
    return-void
.end method

.method public setRssi(I)V
    .locals 0

    .prologue
    .line 53
    iput p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;->rssi:I

    .line 54
    return-void
.end method
