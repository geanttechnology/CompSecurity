.class public Lcom/exacttarget/etpushsdk/event/GeofenceResponse;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field protected static final JF_FENCES:Ljava/lang/String; = "fences"

.field protected static final JF_LATITUDE:Ljava/lang/String; = "latitude"

.field protected static final JF_LONGITUDE:Ljava/lang/String; = "longitude"

.field protected static final JF_REFRESH_CENTER:Ljava/lang/String; = "refreshCenter"

.field protected static final JF_REFRESH_RADIUS:Ljava/lang/String; = "refreshRadius"

.field protected static final JF_REGION_CENTER:Ljava/lang/String; = "center"

.field protected static final JF_REGION_DESC:Ljava/lang/String; = "description"

.field protected static final JF_REGION_ID:Ljava/lang/String; = "id"

.field protected static final JF_REGION_LATITUDE:Ljava/lang/String; = "latitude"

.field protected static final JF_REGION_LONGITUDE:Ljava/lang/String; = "longitude"

.field protected static final JF_REGION_MESSAGES:Ljava/lang/String; = "messages"

.field protected static final JF_REGION_NAME:Ljava/lang/String; = "name"

.field protected static final JF_REGION_RADIUS:Ljava/lang/String; = "radius"

.field protected static final JF_REGION_TYPE:Ljava/lang/String; = "locationType"


# instance fields
.field private fences:Ljava/util/List;

.field private refreshCenter:Lcom/exacttarget/etpushsdk/util/l;

.field private refreshRadius:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getFences()Ljava/util/List;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/GeofenceResponse;->fences:Ljava/util/List;

    return-object v0
.end method

.method public getRefreshCenter()Lcom/exacttarget/etpushsdk/util/l;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/GeofenceResponse;->refreshCenter:Lcom/exacttarget/etpushsdk/util/l;

    return-object v0
.end method

.method public getRefreshRadius()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/GeofenceResponse;->refreshRadius:Ljava/lang/Integer;

    return-object v0
.end method

.method public setFences(Ljava/util/List;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/GeofenceResponse;->fences:Ljava/util/List;

    .line 68
    return-void
.end method

.method public setRefreshCenter(Lcom/exacttarget/etpushsdk/util/l;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/GeofenceResponse;->refreshCenter:Lcom/exacttarget/etpushsdk/util/l;

    .line 52
    return-void
.end method

.method public setRefreshRadius(Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/GeofenceResponse;->refreshRadius:Ljava/lang/Integer;

    .line 60
    return-void
.end method
