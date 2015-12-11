.class public abstract Lcom/comcast/cim/tracking/TrackingService;
.super Ljava/lang/Object;
.source "TrackingService.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<AM:",
        "Lcom/comcast/cim/tracking/CimAppMeasurement;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field protected final appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TAM;>;"
        }
    .end annotation
.end field

.field protected final applicationVersion:Ljava/lang/String;

.field protected final userManager:Lcom/comcast/cim/model/user/UserManager;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/model/user/UserManager;Ljava/lang/String;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V
    .locals 0
    .param p1, "userManager"    # Lcom/comcast/cim/model/user/UserManager;
    .param p2, "applicationVersion"    # Ljava/lang/String;
    .param p3, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/UserManager;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TAM;>;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p0, "this":Lcom/comcast/cim/tracking/TrackingService;, "Lcom/comcast/cim/tracking/TrackingService<TAM;>;"
    .local p4, "appMeasurementProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<TAM;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/comcast/cim/tracking/TrackingService;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 24
    iput-object p2, p0, Lcom/comcast/cim/tracking/TrackingService;->applicationVersion:Ljava/lang/String;

    .line 25
    iput-object p3, p0, Lcom/comcast/cim/tracking/TrackingService;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 26
    iput-object p4, p0, Lcom/comcast/cim/tracking/TrackingService;->appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 27
    return-void
.end method


# virtual methods
.method protected getAppMeasurement(Ljava/lang/String;)Lcom/comcast/cim/tracking/CimAppMeasurement;
    .locals 3
    .param p1, "events"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TAM;"
        }
    .end annotation

    .prologue
    .line 30
    .local p0, "this":Lcom/comcast/cim/tracking/TrackingService;, "Lcom/comcast/cim/tracking/TrackingService<TAM;>;"
    iget-object v1, p0, Lcom/comcast/cim/tracking/TrackingService;->appMeasurementProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/tracking/CimAppMeasurement;

    .line 31
    .local v0, "appMeasurement":Lcom/comcast/cim/tracking/CimAppMeasurement;, "TAM;"
    const-string v1, "events"

    invoke-virtual {v0, v1, p1}, Lcom/comcast/cim/tracking/CimAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 32
    const-string v1, "appName"

    const-string v2, "xfinityplayer app"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/tracking/CimAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 33
    const-string v1, "hashedGUID"

    iget-object v2, p0, Lcom/comcast/cim/tracking/TrackingService;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v2}, Lcom/comcast/cim/model/user/UserManager;->getHashedOmnitureGuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/tracking/CimAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 34
    const-string v1, "cellularCarrier"

    iget-object v2, p0, Lcom/comcast/cim/tracking/TrackingService;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getCarrier()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/tracking/CimAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 36
    return-object v0
.end method
