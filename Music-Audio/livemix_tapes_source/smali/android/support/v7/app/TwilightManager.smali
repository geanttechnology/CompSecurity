.class Landroid/support/v7/app/TwilightManager;
.super Ljava/lang/Object;
.source "TwilightManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/TwilightManager$1;,
        Landroid/support/v7/app/TwilightManager$TwilightState;
    }
.end annotation


# static fields
.field private static final SUNRISE:I = 0x6

.field private static final SUNSET:I = 0x16

.field private static final TAG:Ljava/lang/String; = "TwilightManager"

.field private static final sTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mLocationManager:Landroid/location/LocationManager;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 40
    new-instance v0, Landroid/support/v7/app/TwilightManager$TwilightState;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Landroid/support/v7/app/TwilightManager$TwilightState;-><init>(Landroid/support/v7/app/TwilightManager$1;)V

    sput-object v0, Landroid/support/v7/app/TwilightManager;->sTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Landroid/support/v7/app/TwilightManager;->mContext:Landroid/content/Context;

    .line 47
    const-string v0, "location"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    iput-object v0, p0, Landroid/support/v7/app/TwilightManager;->mLocationManager:Landroid/location/LocationManager;

    .line 48
    return-void
.end method

.method private getLastKnownLocation()Landroid/location/Location;
    .locals 7

    .prologue
    .line 82
    const/4 v0, 0x0

    .line 83
    .local v0, "coarseLocation":Landroid/location/Location;
    const/4 v1, 0x0

    .line 85
    .local v1, "fineLocation":Landroid/location/Location;
    iget-object v3, p0, Landroid/support/v7/app/TwilightManager;->mContext:Landroid/content/Context;

    const-string v4, "android.permission.ACCESS_FINE_LOCATION"

    invoke-static {v3, v4}, Landroid/support/v4/content/PermissionChecker;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 87
    .local v2, "permission":I
    if-nez v2, :cond_0

    .line 88
    const-string v3, "network"

    invoke-direct {p0, v3}, Landroid/support/v7/app/TwilightManager;->getLastKnownLocationForProvider(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v0

    .line 91
    :cond_0
    iget-object v3, p0, Landroid/support/v7/app/TwilightManager;->mContext:Landroid/content/Context;

    const-string v4, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-static {v3, v4}, Landroid/support/v4/content/PermissionChecker;->checkSelfPermission(Landroid/content/Context;Ljava/lang/String;)I

    move-result v2

    .line 93
    if-nez v2, :cond_1

    .line 94
    const-string v3, "gps"

    invoke-direct {p0, v3}, Landroid/support/v7/app/TwilightManager;->getLastKnownLocationForProvider(Ljava/lang/String;)Landroid/location/Location;

    move-result-object v1

    .line 97
    :cond_1
    if-eqz v0, :cond_4

    if-eqz v1, :cond_4

    .line 99
    invoke-virtual {v1}, Landroid/location/Location;->getTime()J

    move-result-wide v3

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-lez v3, :cond_3

    .line 106
    .end local v1    # "fineLocation":Landroid/location/Location;
    :cond_2
    :goto_0
    return-object v1

    .restart local v1    # "fineLocation":Landroid/location/Location;
    :cond_3
    move-object v1, v0

    .line 102
    goto :goto_0

    .line 106
    :cond_4
    if-nez v1, :cond_2

    move-object v1, v0

    goto :goto_0
.end method

.method private getLastKnownLocationForProvider(Ljava/lang/String;)Landroid/location/Location;
    .locals 3
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 111
    iget-object v1, p0, Landroid/support/v7/app/TwilightManager;->mLocationManager:Landroid/location/LocationManager;

    if-eqz v1, :cond_0

    .line 113
    :try_start_0
    iget-object v1, p0, Landroid/support/v7/app/TwilightManager;->mLocationManager:Landroid/location/LocationManager;

    invoke-virtual {v1, p1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 114
    iget-object v1, p0, Landroid/support/v7/app/TwilightManager;->mLocationManager:Landroid/location/LocationManager;

    invoke-virtual {v1, p1}, Landroid/location/LocationManager;->getLastKnownLocation(Ljava/lang/String;)Landroid/location/Location;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 120
    :goto_0
    return-object v1

    .line 116
    :catch_0
    move-exception v0

    .line 117
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "TwilightManager"

    const-string v2, "Failed to get last known location"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 120
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isStateValid(Landroid/support/v7/app/TwilightManager$TwilightState;)Z
    .locals 4
    .param p1, "state"    # Landroid/support/v7/app/TwilightManager$TwilightState;

    .prologue
    .line 124
    if-eqz p1, :cond_0

    iget-wide v0, p1, Landroid/support/v7/app/TwilightManager$TwilightState;->nextUpdate:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private updateState(Landroid/location/Location;)V
    .locals 23
    .param p1, "location"    # Landroid/location/Location;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    .line 128
    sget-object v14, Landroid/support/v7/app/TwilightManager;->sTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;

    .line 129
    .local v14, "state":Landroid/support/v7/app/TwilightManager$TwilightState;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    .line 130
    .local v12, "now":J
    invoke-static {}, Landroid/support/v7/app/TwilightCalculator;->getInstance()Landroid/support/v7/app/TwilightCalculator;

    move-result-object v2

    .line 133
    .local v2, "calculator":Landroid/support/v7/app/TwilightCalculator;
    const-wide/32 v3, 0x5265c00

    sub-long v3, v12, v3

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v7

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/TwilightCalculator;->calculateTwilight(JDD)V

    .line 135
    iget-wide v0, v2, Landroid/support/v7/app/TwilightCalculator;->sunset:J

    move-wide/from16 v21, v0

    .line 138
    .local v21, "yesterdaySunset":J
    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v7

    move-wide v3, v12

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/TwilightCalculator;->calculateTwilight(JDD)V

    .line 139
    iget v3, v2, Landroid/support/v7/app/TwilightCalculator;->state:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1

    const/4 v9, 0x1

    .line 140
    .local v9, "isNight":Z
    :goto_0
    iget-wide v15, v2, Landroid/support/v7/app/TwilightCalculator;->sunrise:J

    .line 141
    .local v15, "todaySunrise":J
    iget-wide v0, v2, Landroid/support/v7/app/TwilightCalculator;->sunset:J

    move-wide/from16 v17, v0

    .line 144
    .local v17, "todaySunset":J
    const-wide/32 v3, 0x5265c00

    add-long/2addr v3, v12

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v5

    invoke-virtual/range {p1 .. p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v7

    invoke-virtual/range {v2 .. v8}, Landroid/support/v7/app/TwilightCalculator;->calculateTwilight(JDD)V

    .line 146
    iget-wide v0, v2, Landroid/support/v7/app/TwilightCalculator;->sunrise:J

    move-wide/from16 v19, v0

    .line 149
    .local v19, "tomorrowSunrise":J
    const-wide/16 v10, 0x0

    .line 150
    .local v10, "nextUpdate":J
    const-wide/16 v3, -0x1

    cmp-long v3, v15, v3

    if-eqz v3, :cond_0

    const-wide/16 v3, -0x1

    cmp-long v3, v17, v3

    if-nez v3, :cond_2

    .line 152
    :cond_0
    const-wide/32 v3, 0x2932e00

    add-long v10, v12, v3

    .line 166
    :goto_1
    iput-boolean v9, v14, Landroid/support/v7/app/TwilightManager$TwilightState;->isNight:Z

    .line 167
    move-wide/from16 v0, v21

    iput-wide v0, v14, Landroid/support/v7/app/TwilightManager$TwilightState;->yesterdaySunset:J

    .line 168
    iput-wide v15, v14, Landroid/support/v7/app/TwilightManager$TwilightState;->todaySunrise:J

    .line 169
    move-wide/from16 v0, v17

    iput-wide v0, v14, Landroid/support/v7/app/TwilightManager$TwilightState;->todaySunset:J

    .line 170
    move-wide/from16 v0, v19

    iput-wide v0, v14, Landroid/support/v7/app/TwilightManager$TwilightState;->tomorrowSunrise:J

    .line 171
    iput-wide v10, v14, Landroid/support/v7/app/TwilightManager$TwilightState;->nextUpdate:J

    .line 172
    return-void

    .line 139
    .end local v9    # "isNight":Z
    .end local v10    # "nextUpdate":J
    .end local v15    # "todaySunrise":J
    .end local v17    # "todaySunset":J
    .end local v19    # "tomorrowSunrise":J
    :cond_1
    const/4 v9, 0x0

    goto :goto_0

    .line 154
    .restart local v9    # "isNight":Z
    .restart local v10    # "nextUpdate":J
    .restart local v15    # "todaySunrise":J
    .restart local v17    # "todaySunset":J
    .restart local v19    # "tomorrowSunrise":J
    :cond_2
    cmp-long v3, v12, v17

    if-lez v3, :cond_3

    .line 155
    add-long v10, v10, v19

    .line 162
    :goto_2
    const-wide/32 v3, 0xea60

    add-long/2addr v10, v3

    goto :goto_1

    .line 156
    :cond_3
    cmp-long v3, v12, v15

    if-lez v3, :cond_4

    .line 157
    add-long v10, v10, v17

    goto :goto_2

    .line 159
    :cond_4
    add-long/2addr v10, v15

    goto :goto_2
.end method


# virtual methods
.method isNight()Z
    .locals 6

    .prologue
    .line 56
    sget-object v3, Landroid/support/v7/app/TwilightManager;->sTwilightState:Landroid/support/v7/app/TwilightManager$TwilightState;

    .line 58
    .local v3, "state":Landroid/support/v7/app/TwilightManager$TwilightState;
    invoke-direct {p0, v3}, Landroid/support/v7/app/TwilightManager;->isStateValid(Landroid/support/v7/app/TwilightManager$TwilightState;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 60
    iget-boolean v4, v3, Landroid/support/v7/app/TwilightManager$TwilightState;->isNight:Z

    .line 78
    :goto_0
    return v4

    .line 64
    :cond_0
    invoke-direct {p0}, Landroid/support/v7/app/TwilightManager;->getLastKnownLocation()Landroid/location/Location;

    move-result-object v2

    .line 65
    .local v2, "location":Landroid/location/Location;
    if-eqz v2, :cond_1

    .line 66
    invoke-direct {p0, v2}, Landroid/support/v7/app/TwilightManager;->updateState(Landroid/location/Location;)V

    .line 67
    iget-boolean v4, v3, Landroid/support/v7/app/TwilightManager$TwilightState;->isNight:Z

    goto :goto_0

    .line 70
    :cond_1
    const-string v4, "TwilightManager"

    const-string v5, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values."

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 76
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 77
    .local v0, "calendar":Ljava/util/Calendar;
    const/16 v4, 0xb

    invoke-virtual {v0, v4}, Ljava/util/Calendar;->get(I)I

    move-result v1

    .line 78
    .local v1, "hour":I
    const/4 v4, 0x6

    if-lt v1, v4, :cond_2

    const/16 v4, 0x16

    if-lt v1, v4, :cond_3

    :cond_2
    const/4 v4, 0x1

    goto :goto_0

    :cond_3
    const/4 v4, 0x0

    goto :goto_0
.end method
