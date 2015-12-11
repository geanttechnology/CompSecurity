.class public Lcom/exacttarget/etpushsdk/event/BeaconRequest;
.super Lcom/exacttarget/etpushsdk/util/g;
.source "SourceFile"


# instance fields
.field private deviceId:Ljava/lang/String;

.field private id:Ljava/lang/Integer;

.field private latitude:Ljava/lang/Double;

.field private longitude:Ljava/lang/Double;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/util/g;-><init>()V

    .line 28
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->uniqueDeviceIdentifier(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->deviceId:Ljava/lang/String;

    .line 29
    return-void
.end method


# virtual methods
.method public getDeviceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->deviceId:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->id:Ljava/lang/Integer;

    return-object v0
.end method

.method public getLatitude()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->latitude:Ljava/lang/Double;

    return-object v0
.end method

.method public getLongitude()Ljava/lang/Double;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->longitude:Ljava/lang/Double;

    return-object v0
.end method

.method public setDeviceId(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->deviceId:Ljava/lang/String;

    .line 45
    return-void
.end method

.method public setId(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->id:Ljava/lang/Integer;

    .line 37
    return-void
.end method

.method public setLatitude(Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->latitude:Ljava/lang/Double;

    .line 53
    return-void
.end method

.method public setLongitude(Ljava/lang/Double;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->longitude:Ljava/lang/Double;

    .line 61
    return-void
.end method
