.class public Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private location:Landroid/location/Location;


# direct methods
.method public constructor <init>(Landroid/location/Location;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->location:Landroid/location/Location;

    .line 28
    return-void
.end method


# virtual methods
.method public getLocation()Landroid/location/Location;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->location:Landroid/location/Location;

    return-object v0
.end method

.method public setLocation(Landroid/location/Location;)V
    .locals 0

    .prologue
    .line 35
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->location:Landroid/location/Location;

    .line 36
    return-void
.end method
