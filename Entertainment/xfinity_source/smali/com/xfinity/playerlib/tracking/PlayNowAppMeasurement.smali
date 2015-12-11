.class public Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;
.super Lcom/comcast/cim/tracking/CimAppMeasurement;
.source "PlayNowAppMeasurement.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final applicationName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/PropertyService;Ljava/lang/String;)V
    .locals 1
    .param p1, "application"    # Lcom/xfinity/playerlib/PlayerApplication;
    .param p2, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p3, "propertyService"    # Lcom/comcast/cim/android/PropertyService;
    .param p4, "applicationName"    # Ljava/lang/String;

    .prologue
    .line 16
    invoke-virtual {p1}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionNumber()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2, p3}, Lcom/comcast/cim/tracking/CimAppMeasurement;-><init>(Landroid/app/Application;Ljava/lang/String;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/PropertyService;)V

    .line 17
    iput-object p4, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->applicationName:Ljava/lang/String;

    .line 18
    return-void
.end method


# virtual methods
.method protected configureAppSpecificFields()V
    .locals 2

    .prologue
    .line 22
    const-string v0, "appName"

    iget-object v1, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->applicationName:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 23
    const-string v0, "appName"

    iget-object v1, p0, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->applicationName:Ljava/lang/String;

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 24
    return-void
.end method
