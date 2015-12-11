.class public Lcom/exacttarget/etpushsdk/event/BeaconResponse;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field protected static final JF_BEACONS:Ljava/lang/String; = "beacons"

.field protected static final JF_REGION_BEACON_UUID:Ljava/lang/String; = "proximityUuid"

.field protected static final JF_REGION_CENTER:Ljava/lang/String; = "center"

.field protected static final JF_REGION_DESC:Ljava/lang/String; = "description"

.field protected static final JF_REGION_ID:Ljava/lang/String; = "id"

.field protected static final JF_REGION_LATITUDE:Ljava/lang/String; = "latitude"

.field protected static final JF_REGION_LONGITUDE:Ljava/lang/String; = "longitude"

.field protected static final JF_REGION_MAJOR:Ljava/lang/String; = "major"

.field protected static final JF_REGION_MESSAGES:Ljava/lang/String; = "messages"

.field protected static final JF_REGION_MINOR:Ljava/lang/String; = "minor"

.field protected static final JF_REGION_NAME:Ljava/lang/String; = "name"

.field protected static final JF_REGION_TYPE:Ljava/lang/String; = "locationType"


# instance fields
.field private beacons:Ljava/util/List;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getBeacons()Ljava/util/List;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/BeaconResponse;->beacons:Ljava/util/List;

    return-object v0
.end method

.method public setBeacons(Ljava/util/List;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/BeaconResponse;->beacons:Ljava/util/List;

    .line 47
    return-void
.end method
