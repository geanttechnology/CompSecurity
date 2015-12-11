.class public Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;
.super Ljava/lang/Object;
.source "PlayNowAppMeasurementProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;",
        ">;"
    }
.end annotation


# instance fields
.field private androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private application:Lcom/xfinity/playerlib/PlayerApplication;

.field private applicationName:Ljava/lang/String;

.field private propertyService:Lcom/comcast/cim/android/PropertyService;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/PropertyService;Ljava/lang/String;)V
    .locals 0
    .param p1, "application"    # Lcom/xfinity/playerlib/PlayerApplication;
    .param p2, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p3, "propertyService"    # Lcom/comcast/cim/android/PropertyService;
    .param p4, "applicationName"    # Ljava/lang/String;

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->application:Lcom/xfinity/playerlib/PlayerApplication;

    .line 17
    iput-object p2, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 18
    iput-object p3, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->propertyService:Lcom/comcast/cim/android/PropertyService;

    .line 19
    iput-object p4, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->applicationName:Ljava/lang/String;

    .line 20
    return-void
.end method


# virtual methods
.method public get()Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
    .locals 5

    .prologue
    .line 23
    new-instance v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    iget-object v1, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->application:Lcom/xfinity/playerlib/PlayerApplication;

    iget-object v2, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    iget-object v3, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->propertyService:Lcom/comcast/cim/android/PropertyService;

    iget-object v4, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->applicationName:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;-><init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/PropertyService;Ljava/lang/String;)V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 8
    invoke-virtual {p0}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurementProvider;->get()Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    move-result-object v0

    return-object v0
.end method
