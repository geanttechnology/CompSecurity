.class public Lcom/exacttarget/etpushsdk/location/b;
.super Lcom/exacttarget/etpushsdk/location/g;
.source "SourceFile"


# direct methods
.method public constructor <init>(Landroid/location/LocationManager;)V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/location/g;-><init>(Landroid/location/LocationManager;)V

    .line 21
    return-void
.end method


# virtual methods
.method public a(JJLandroid/app/PendingIntent;)V
    .locals 7

    .prologue
    .line 28
    const-string v0, "~!lb"

    const-string v1, "requestPassiveLocationUpdates"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 32
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/b;->a:Landroid/location/LocationManager;

    const-string v1, "passive"

    long-to-float v4, p3

    move-wide v2, p1

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/app/PendingIntent;)V

    .line 33
    return-void
.end method
