.class public Lcom/exacttarget/etpushsdk/event/BeaconRegionExitEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private region:Lcom/exacttarget/etpushsdk/data/Region;


# direct methods
.method public constructor <init>(Lcom/exacttarget/etpushsdk/data/Region;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionExitEvent;->region:Lcom/exacttarget/etpushsdk/data/Region;

    .line 24
    return-void
.end method


# virtual methods
.method public getRegion()Lcom/exacttarget/etpushsdk/data/Region;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionExitEvent;->region:Lcom/exacttarget/etpushsdk/data/Region;

    return-object v0
.end method

.method public setRegion(Lcom/exacttarget/etpushsdk/data/Region;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRegionExitEvent;->region:Lcom/exacttarget/etpushsdk/data/Region;

    .line 32
    return-void
.end method
