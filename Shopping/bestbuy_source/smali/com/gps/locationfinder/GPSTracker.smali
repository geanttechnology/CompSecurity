.class public Lcom/gps/locationfinder/GPSTracker;
.super Landroid/app/Service;
.source "SourceFile"

# interfaces
.implements Landroid/location/LocationListener;


# static fields
.field private static final MIN_DISTANCE_CHANGE_FOR_UPDATES:J = 0xaL

.field private static final MIN_TIME_BW_UPDATES:J = 0xea60L

.field public static OnChangedLatitude:Ljava/lang/String;

.field public static OnChangedLongitude:Ljava/lang/String;

.field public static location:Landroid/location/Location;

.field public static locationManager:Landroid/location/LocationManager;

.field public static sendChangedLocationToJS:Ljava/lang/String;


# instance fields
.field canGetLocation:Z

.field data:Lorg/json/JSONObject;

.field isGPSEnabled:Z

.field isNetworkEnabled:Z

.field public latitude:D

.field public longitude:D

.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-string v0, "ReceivedLocation"

    sput-object v0, Lcom/gps/locationfinder/GPSTracker;->sendChangedLocationToJS:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 50
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 28
    iput-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isGPSEnabled:Z

    .line 31
    iput-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isNetworkEnabled:Z

    .line 33
    iput-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->canGetLocation:Z

    .line 51
    iput-object p1, p0, Lcom/gps/locationfinder/GPSTracker;->mContext:Landroid/content/Context;

    .line 52
    invoke-virtual {p0}, Lcom/gps/locationfinder/GPSTracker;->getLocation()Landroid/location/Location;

    .line 53
    return-void
.end method


# virtual methods
.method public canGetLocation()Z
    .locals 1

    .prologue
    .line 174
    iget-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->canGetLocation:Z

    return v0
.end method

.method public getAddressLine(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 205
    invoke-virtual {p0, p1}, Lcom/gps/locationfinder/GPSTracker;->getGeocoderAddress(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    .line 206
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 207
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    .line 208
    new-instance v1, Ljava/lang/StringBuilder;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/location/Address;->getAddressLine(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 209
    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Landroid/location/Address;->getAddressLine(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 210
    const/4 v2, 0x3

    invoke-virtual {v0, v2}, Landroid/location/Address;->getAddressLine(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 208
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 214
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCountryName(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 258
    invoke-virtual {p0, p1}, Lcom/gps/locationfinder/GPSTracker;->getGeocoderAddress(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    .line 259
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 260
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    .line 261
    invoke-virtual {v0}, Landroid/location/Address;->getCountryName()Ljava/lang/String;

    move-result-object v0

    .line 264
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getGeocoderAddress(Landroid/content/Context;)Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/List",
            "<",
            "Landroid/location/Address;",
            ">;"
        }
    .end annotation

    .prologue
    .line 183
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    if-eqz v0, :cond_0

    .line 184
    new-instance v1, Landroid/location/Geocoder;

    sget-object v0, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v1, p1, v0}, Landroid/location/Geocoder;-><init>(Landroid/content/Context;Ljava/util/Locale;)V

    .line 186
    :try_start_0
    iget-wide v2, p0, Lcom/gps/locationfinder/GPSTracker;->latitude:D

    .line 187
    iget-wide v4, p0, Lcom/gps/locationfinder/GPSTracker;->longitude:D

    const/4 v6, 0x1

    .line 186
    invoke-virtual/range {v1 .. v6}, Landroid/location/Geocoder;->getFromLocation(DDI)Ljava/util/List;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 196
    :goto_0
    return-object v0

    .line 189
    :catch_0
    move-exception v0

    .line 190
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 192
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 191
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 196
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLatitude()D
    .locals 2

    .prologue
    .line 152
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    if-eqz v0, :cond_0

    .line 153
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/gps/locationfinder/GPSTracker;->latitude:D

    .line 156
    :cond_0
    iget-wide v0, p0, Lcom/gps/locationfinder/GPSTracker;->latitude:D

    return-wide v0
.end method

.method public getLocality(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 224
    invoke-virtual {p0, p1}, Lcom/gps/locationfinder/GPSTracker;->getGeocoderAddress(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    .line 225
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 226
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    .line 227
    invoke-virtual {v0}, Landroid/location/Address;->getLocality()Ljava/lang/String;

    move-result-object v0

    .line 231
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLocation()Landroid/location/Location;
    .locals 6

    .prologue
    .line 69
    :try_start_0
    iget-object v0, p0, Lcom/gps/locationfinder/GPSTracker;->mContext:Landroid/content/Context;

    .line 70
    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 69
    check-cast v0, Landroid/location/LocationManager;

    sput-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    .line 73
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    .line 74
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 73
    iput-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isGPSEnabled:Z

    .line 77
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    .line 78
    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    .line 77
    iput-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isNetworkEnabled:Z

    .line 80
    iget-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isGPSEnabled:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isNetworkEnabled:Z

    if-eqz v0, :cond_2

    .line 83
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->canGetLocation:Z

    .line 86
    iget-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isNetworkEnabled:Z

    if-eqz v0, :cond_1

    .line 87
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    .line 88
    const-string v1, "network"

    .line 89
    const-wide/32 v2, 0xea60

    .line 90
    const/high16 v4, 0x41200000    # 10.0f

    move-object v5, p0

    .line 87
    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    .line 92
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    if-eqz v0, :cond_1

    .line 93
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    .line 94
    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0

    .line 93
    sput-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    .line 97
    invoke-virtual {p0}, Lcom/gps/locationfinder/GPSTracker;->updateGPSCoordinates()V

    .line 102
    :cond_1
    iget-boolean v0, p0, Lcom/gps/locationfinder/GPSTracker;->isGPSEnabled:Z

    if-eqz v0, :cond_2

    .line 103
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    if-nez v0, :cond_2

    .line 104
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    .line 105
    const-string v1, "gps"

    .line 106
    const-wide/32 v2, 0xea60

    .line 107
    const/high16 v4, 0x41200000    # 10.0f

    move-object v5, p0

    .line 104
    invoke-virtual/range {v0 .. v5}, Landroid/location/LocationManager;->requestLocationUpdates(Ljava/lang/String;JFLandroid/location/LocationListener;)V

    .line 109
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    if-eqz v0, :cond_2

    .line 112
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    .line 113
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0

    .line 112
    sput-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    .line 114
    invoke-virtual {p0}, Lcom/gps/locationfinder/GPSTracker;->updateGPSCoordinates()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 126
    :cond_2
    :goto_0
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    return-object v0

    .line 120
    :catch_0
    move-exception v0

    .line 121
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 123
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 122
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getLongitude()D
    .locals 2

    .prologue
    .line 163
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    if-eqz v0, :cond_0

    .line 164
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/gps/locationfinder/GPSTracker;->longitude:D

    .line 167
    :cond_0
    iget-wide v0, p0, Lcom/gps/locationfinder/GPSTracker;->longitude:D

    return-wide v0
.end method

.method public getPostalCode(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 241
    invoke-virtual {p0, p1}, Lcom/gps/locationfinder/GPSTracker;->getGeocoderAddress(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    .line 242
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 243
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Address;

    .line 244
    invoke-virtual {v0}, Landroid/location/Address;->getPostalCode()Ljava/lang/String;

    move-result-object v0

    .line 248
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    .prologue
    .line 335
    const/4 v0, 0x0

    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 63
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 65
    return-void
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 3

    .prologue
    .line 288
    :try_start_0
    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/gps/locationfinder/GPSTracker;->OnChangedLongitude:Ljava/lang/String;

    .line 289
    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/gps/locationfinder/GPSTracker;->OnChangedLatitude:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 313
    :goto_0
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->sendChangedLocationToJS:Ljava/lang/String;

    .line 314
    sget-object v1, Lcom/gps/locationfinder/GPSTracker;->OnChangedLongitude:Ljava/lang/String;

    sget-object v2, Lcom/gps/locationfinder/GPSTracker;->OnChangedLatitude:Ljava/lang/String;

    .line 313
    invoke-static {v0, v1, v2}, Lcom/inc247/ChatSDKUtil;->sendLocation(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 316
    sget-object v1, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    if-eqz v1, :cond_0

    .line 317
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    .line 319
    :try_start_1
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    const-string v1, "longitude : "

    .line 320
    sget-object v2, Lcom/gps/locationfinder/GPSTracker;->OnChangedLongitude:Ljava/lang/String;

    .line 319
    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 321
    sget-object v0, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->data:Lorg/json/JSONObject;

    const-string v1, "latitude : "

    .line 322
    sget-object v2, Lcom/gps/locationfinder/GPSTracker;->OnChangedLatitude:Ljava/lang/String;

    .line 321
    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 330
    :cond_0
    :goto_1
    return-void

    .line 290
    :catch_0
    move-exception v0

    .line 291
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 293
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 292
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_0

    .line 323
    :catch_1
    move-exception v0

    .line 324
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 326
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "{\'Error\':\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\'}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/inc247/ChatSDKUtil;->createExecJSString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 325
    invoke-static {v0}, Lcom/inc247/bridge/ChatSDKNativeToJSBridge;->executeJS(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public onProviderDisabled(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 270
    return-void
.end method

.method public onProviderEnabled(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 274
    return-void
.end method

.method public onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 278
    return-void
.end method

.method public stopUsingGPS()V
    .locals 1

    .prologue
    .line 143
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    if-eqz v0, :cond_0

    .line 144
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->locationManager:Landroid/location/LocationManager;

    invoke-virtual {v0, p0}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 146
    :cond_0
    return-void
.end method

.method public updateGPSCoordinates()V
    .locals 2

    .prologue
    .line 130
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    if-eqz v0, :cond_0

    .line 131
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/gps/locationfinder/GPSTracker;->latitude:D

    .line 132
    sget-object v0, Lcom/gps/locationfinder/GPSTracker;->location:Landroid/location/Location;

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/gps/locationfinder/GPSTracker;->longitude:D

    .line 135
    :cond_0
    return-void
.end method
