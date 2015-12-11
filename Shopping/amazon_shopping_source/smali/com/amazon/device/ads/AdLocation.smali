.class Lcom/amazon/device/ads/AdLocation;
.super Ljava/lang/Object;
.source "AdLocation.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdLocation$LocationAwareness;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "AdLocation"

.field private static final MAX_DISTANCE_IN_KILOMETERS:F = 3.0f


# instance fields
.field private arcminutePrecision:I

.field private locationAwareness:Lcom/amazon/device/ads/AdLocation$LocationAwareness;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    sget-object v0, Lcom/amazon/device/ads/AdLocation$LocationAwareness;->LOCATION_AWARENESS_TRUNCATED:Lcom/amazon/device/ads/AdLocation$LocationAwareness;

    iput-object v0, p0, Lcom/amazon/device/ads/AdLocation;->locationAwareness:Lcom/amazon/device/ads/AdLocation$LocationAwareness;

    .line 25
    const/4 v0, 0x6

    iput v0, p0, Lcom/amazon/device/ads/AdLocation;->arcminutePrecision:I

    .line 26
    return-void
.end method

.method private static roundToArcminutes(D)D
    .locals 4
    .param p0, "coordinate"    # D

    .prologue
    const-wide/high16 v2, 0x404e000000000000L    # 60.0

    .line 42
    mul-double v0, p0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->round(D)J

    move-result-wide v0

    long-to-double v0, v0

    div-double/2addr v0, v2

    return-wide v0
.end method


# virtual methods
.method public getLocation()Landroid/location/Location;
    .locals 26

    .prologue
    .line 52
    const/4 v15, 0x0

    .line 53
    .local v15, "result":Landroid/location/Location;
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Lcom/amazon/device/ads/IInternalAdRegistration;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 55
    .local v2, "context":Landroid/content/Context;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLocation;->locationAwareness:Lcom/amazon/device/ads/AdLocation$LocationAwareness;

    move-object/from16 v20, v0

    sget-object v21, Lcom/amazon/device/ads/AdLocation$LocationAwareness;->LOCATION_AWARENESS_DISABLED:Lcom/amazon/device/ads/AdLocation$LocationAwareness;

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    if-ne v0, v1, :cond_0

    const/16 v20, 0x0

    .line 163
    :goto_0
    return-object v20

    .line 57
    :cond_0
    const-string/jumbo v20, "location"

    move-object/from16 v0, v20

    invoke-virtual {v2, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Landroid/location/LocationManager;

    .line 58
    .local v10, "lm":Landroid/location/LocationManager;
    const/4 v6, 0x0

    .line 61
    .local v6, "gpsLocation":Landroid/location/Location;
    :try_start_0
    const-string/jumbo v20, "gps"

    move-object/from16 v0, v20

    invoke-virtual {v10, v0}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v6

    .line 72
    :goto_1
    const/4 v13, 0x0

    .line 75
    .local v13, "networkLocation":Landroid/location/Location;
    :try_start_1
    const-string/jumbo v20, "network"

    move-object/from16 v0, v20

    invoke-virtual {v10, v0}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_3

    move-result-object v13

    .line 86
    :goto_2
    if-nez v6, :cond_1

    if-nez v13, :cond_1

    .line 87
    const/16 v20, 0x0

    goto :goto_0

    .line 63
    .end local v13    # "networkLocation":Landroid/location/Location;
    :catch_0
    move-exception v5

    .line 65
    .local v5, "e":Ljava/lang/SecurityException;
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Failed to retrieve GPS location: No permissions to access GPS"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 67
    .end local v5    # "e":Ljava/lang/SecurityException;
    :catch_1
    move-exception v5

    .line 69
    .local v5, "e":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Failed to retrieve GPS location: No GPS found"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 77
    .end local v5    # "e":Ljava/lang/IllegalArgumentException;
    .restart local v13    # "networkLocation":Landroid/location/Location;
    :catch_2
    move-exception v5

    .line 79
    .local v5, "e":Ljava/lang/SecurityException;
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Failed to retrieve network location: No permissions to access network location"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 81
    .end local v5    # "e":Ljava/lang/SecurityException;
    :catch_3
    move-exception v5

    .line 83
    .local v5, "e":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Failed to retrieve network location: No network provider found"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 88
    .end local v5    # "e":Ljava/lang/IllegalArgumentException;
    :cond_1
    if-eqz v6, :cond_8

    if-eqz v13, :cond_8

    .line 99
    invoke-virtual {v6, v13}, Landroid/location/Location;->distanceTo(Landroid/location/Location;)F

    move-result v4

    .line 100
    .local v4, "distanceInMeters":F
    const/high16 v20, 0x447a0000    # 1000.0f

    div-float v3, v4, v20

    .line 102
    .local v3, "distanceInKilometers":F
    const/high16 v20, 0x40400000    # 3.0f

    cmpg-float v20, v3, v20

    if-gtz v20, :cond_6

    .line 108
    invoke-virtual {v6}, Landroid/location/Location;->hasAccuracy()Z

    move-result v20

    if-eqz v20, :cond_3

    invoke-virtual {v6}, Landroid/location/Location;->getAccuracy()F

    move-result v7

    .line 110
    .local v7, "gpsLocationAccuracy":F
    :goto_3
    invoke-virtual {v13}, Landroid/location/Location;->hasAccuracy()Z

    move-result v20

    if-eqz v20, :cond_4

    invoke-virtual {v13}, Landroid/location/Location;->getAccuracy()F

    move-result v14

    .line 114
    .local v14, "networkLocationAccuracy":F
    :goto_4
    cmpg-float v20, v7, v14

    if-gez v20, :cond_5

    .line 116
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Setting lat/long using GPS determined by distance"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    move-object v15, v6

    .line 150
    .end local v3    # "distanceInKilometers":F
    .end local v4    # "distanceInMeters":F
    .end local v7    # "gpsLocationAccuracy":F
    .end local v14    # "networkLocationAccuracy":F
    :goto_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/ads/AdLocation;->locationAwareness:Lcom/amazon/device/ads/AdLocation$LocationAwareness;

    move-object/from16 v20, v0

    sget-object v21, Lcom/amazon/device/ads/AdLocation$LocationAwareness;->LOCATION_AWARENESS_TRUNCATED:Lcom/amazon/device/ads/AdLocation$LocationAwareness;

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    if-ne v0, v1, :cond_2

    .line 152
    invoke-virtual {v15}, Landroid/location/Location;->getLatitude()D

    move-result-wide v20

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/AdLocation;->roundToArcminutes(D)D

    move-result-wide v8

    .line 153
    .local v8, "lat":D
    const-wide/high16 v20, 0x4024000000000000L    # 10.0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/device/ads/AdLocation;->arcminutePrecision:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    invoke-static/range {v20 .. v23}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v20

    mul-double v20, v20, v8

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->round(D)J

    move-result-wide v20

    move-wide/from16 v0, v20

    long-to-double v0, v0

    move-wide/from16 v20, v0

    const-wide/high16 v22, 0x4024000000000000L    # 10.0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/device/ads/AdLocation;->arcminutePrecision:I

    move/from16 v24, v0

    move/from16 v0, v24

    int-to-double v0, v0

    move-wide/from16 v24, v0

    invoke-static/range {v22 .. v25}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v22

    div-double v16, v20, v22

    .line 155
    .local v16, "truncatedLat":D
    invoke-virtual/range {v15 .. v17}, Landroid/location/Location;->setLatitude(D)V

    .line 157
    invoke-virtual {v15}, Landroid/location/Location;->getLongitude()D

    move-result-wide v20

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/AdLocation;->roundToArcminutes(D)D

    move-result-wide v11

    .line 158
    .local v11, "lon":D
    const-wide/high16 v20, 0x4024000000000000L    # 10.0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/device/ads/AdLocation;->arcminutePrecision:I

    move/from16 v22, v0

    move/from16 v0, v22

    int-to-double v0, v0

    move-wide/from16 v22, v0

    invoke-static/range {v20 .. v23}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v20

    mul-double v20, v20, v11

    invoke-static/range {v20 .. v21}, Ljava/lang/Math;->round(D)J

    move-result-wide v20

    move-wide/from16 v0, v20

    long-to-double v0, v0

    move-wide/from16 v20, v0

    const-wide/high16 v22, 0x4024000000000000L    # 10.0

    move-object/from16 v0, p0

    iget v0, v0, Lcom/amazon/device/ads/AdLocation;->arcminutePrecision:I

    move/from16 v24, v0

    move/from16 v0, v24

    int-to-double v0, v0

    move-wide/from16 v24, v0

    invoke-static/range {v22 .. v25}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v22

    div-double v18, v20, v22

    .line 160
    .local v18, "truncatedLon":D
    move-wide/from16 v0, v18

    invoke-virtual {v15, v0, v1}, Landroid/location/Location;->setLongitude(D)V

    .end local v8    # "lat":D
    .end local v11    # "lon":D
    .end local v16    # "truncatedLat":D
    .end local v18    # "truncatedLon":D
    :cond_2
    move-object/from16 v20, v15

    .line 163
    goto/16 :goto_0

    .line 108
    .restart local v3    # "distanceInKilometers":F
    .restart local v4    # "distanceInMeters":F
    :cond_3
    const v7, 0x7f7fffff    # Float.MAX_VALUE

    goto/16 :goto_3

    .line 110
    .restart local v7    # "gpsLocationAccuracy":F
    :cond_4
    const v14, 0x7f7fffff    # Float.MAX_VALUE

    goto/16 :goto_4

    .line 121
    .restart local v14    # "networkLocationAccuracy":F
    :cond_5
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Setting lat/long using network determined by distance"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    move-object v15, v13

    goto/16 :goto_5

    .line 127
    .end local v7    # "gpsLocationAccuracy":F
    .end local v14    # "networkLocationAccuracy":F
    :cond_6
    invoke-virtual {v6}, Landroid/location/Location;->getTime()J

    move-result-wide v20

    invoke-virtual {v13}, Landroid/location/Location;->getTime()J

    move-result-wide v22

    cmp-long v20, v20, v22

    if-lez v20, :cond_7

    .line 129
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Setting lat/long using GPS"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    move-object v15, v6

    goto/16 :goto_5

    .line 134
    :cond_7
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Setting lat/long using network"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    move-object v15, v13

    goto/16 :goto_5

    .line 139
    .end local v3    # "distanceInKilometers":F
    .end local v4    # "distanceInMeters":F
    :cond_8
    if-eqz v6, :cond_9

    .line 141
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Setting lat/long using GPS, not network"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    move-object v15, v6

    goto/16 :goto_5

    .line 146
    :cond_9
    const-string/jumbo v20, "AdLocation"

    const-string/jumbo v21, "Setting lat/long using network location, not GPS"

    invoke-static/range {v20 .. v21}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    move-object v15, v13

    goto/16 :goto_5
.end method
