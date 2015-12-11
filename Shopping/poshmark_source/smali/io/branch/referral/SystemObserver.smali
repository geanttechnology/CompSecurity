.class Lio/branch/referral/SystemObserver;
.super Ljava/lang/Object;
.source "SystemObserver.java"


# static fields
.field public static final BLANK:Ljava/lang/String; = "bnc_no_value"

.field private static final STATE_FRESH_INSTALL:I = 0x0

.field private static final STATE_NO_CHANGE:I = 0x1

.field private static final STATE_UPDATE:I = 0x2


# instance fields
.field private context_:Landroid/content/Context;

.field private isRealHardwareId:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    iput-object p1, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    .line 67
    const/4 v0, 0x1

    iput-boolean v0, p0, Lio/branch/referral/SystemObserver;->isRealHardwareId:Z

    .line 68
    return-void
.end method

.method private isLowOnMemory()Z
    .locals 4

    .prologue
    .line 187
    iget-object v2, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    const-string v3, "activity"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 188
    .local v0, "activityManager":Landroid/app/ActivityManager;
    new-instance v1, Landroid/app/ActivityManager$MemoryInfo;

    invoke-direct {v1}, Landroid/app/ActivityManager$MemoryInfo;-><init>()V

    .line 189
    .local v1, "mi":Landroid/app/ActivityManager$MemoryInfo;
    invoke-virtual {v0, v1}, Landroid/app/ActivityManager;->getMemoryInfo(Landroid/app/ActivityManager$MemoryInfo;)V

    .line 190
    iget-boolean v2, v1, Landroid/app/ActivityManager$MemoryInfo;->lowMemory:Z

    return v2
.end method


# virtual methods
.method public getAdvertisingId()Ljava/lang/String;
    .locals 11

    .prologue
    .line 627
    const/4 v3, 0x0

    .line 630
    .local v3, "advertisingId":Ljava/lang/String;
    :try_start_0
    const-string v7, "com.google.android.gms.ads.identifier.AdvertisingIdClient"

    invoke-static {v7}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 631
    .local v1, "AdvertisingIdClientClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v7, "getAdvertisingIdInfo"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Class;

    const/4 v9, 0x0

    const-class v10, Landroid/content/Context;

    aput-object v10, v8, v9

    invoke-virtual {v1, v7, v8}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v5

    .line 632
    .local v5, "getAdvertisingIdInfoMethod":Ljava/lang/reflect/Method;
    const/4 v7, 0x0

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    aput-object v10, v8, v9

    invoke-virtual {v5, v7, v8}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 633
    .local v2, "adInfoObj":Ljava/lang/Object;
    invoke-virtual {v2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    const-string v8, "getId"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Class;

    invoke-virtual {v7, v8, v9}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    .line 634
    .local v6, "getIdMethod":Ljava/lang/reflect/Method;
    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v6, v2, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/lang/String;

    move-object v3, v0
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 640
    .end local v1    # "AdvertisingIdClientClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v2    # "adInfoObj":Ljava/lang/Object;
    .end local v5    # "getAdvertisingIdInfoMethod":Ljava/lang/reflect/Method;
    .end local v6    # "getIdMethod":Ljava/lang/reflect/Method;
    :goto_0
    return-object v3

    .line 635
    :catch_0
    move-exception v4

    .line 636
    .local v4, "ex":Ljava/lang/IllegalStateException;
    invoke-virtual {v4}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_0

    .line 637
    .end local v4    # "ex":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v7

    goto :goto_0
.end method

.method public getAppVersion()Ljava/lang/String;
    .locals 4

    .prologue
    .line 279
    :try_start_0
    iget-object v1, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    iget-object v2, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 280
    .local v0, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v1, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 281
    iget-object v1, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 286
    .end local v0    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return-object v1

    .line 283
    .restart local v0    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    const-string v1, "bnc_no_value"
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 284
    .end local v0    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v1

    .line 286
    const-string v1, "bnc_no_value"

    goto :goto_0
.end method

.method public getBluetoothPresent()Z
    .locals 2

    .prologue
    .line 326
    :try_start_0
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    .line 327
    .local v0, "bluetoothAdapter":Landroid/bluetooth/BluetoothAdapter;
    if-eqz v0, :cond_0

    .line 328
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 332
    .end local v0    # "bluetoothAdapter":Landroid/bluetooth/BluetoothAdapter;
    :goto_0
    return v1

    .line 330
    :catch_0
    move-exception v1

    .line 332
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getBluetoothVersion()Ljava/lang/String;
    .locals 2

    .prologue
    .line 356
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_1

    .line 357
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x12

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.hardware.bluetooth_le"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 359
    const-string v0, "ble"

    .line 364
    :goto_0
    return-object v0

    .line 360
    :cond_0
    iget-object v0, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.hardware.bluetooth"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 361
    const-string v0, "classic"

    goto :goto_0

    .line 364
    :cond_1
    const-string v0, "bnc_no_value"

    goto :goto_0
.end method

.method public getCarrier()Ljava/lang/String;
    .locals 4

    .prologue
    .line 299
    iget-object v2, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    const-string v3, "phone"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/telephony/TelephonyManager;

    .line 300
    .local v1, "telephonyManager":Landroid/telephony/TelephonyManager;
    if-eqz v1, :cond_0

    .line 301
    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v0

    .line 302
    .local v0, "ret":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 305
    .end local v0    # "ret":Ljava/lang/String;
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "bnc_no_value"

    goto :goto_0
.end method

.method public getLATValue()I
    .locals 12

    .prologue
    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 655
    const/4 v5, 0x0

    .line 657
    .local v5, "latVal":I
    :try_start_0
    const-string v6, "com.google.android.gms.ads.identifier.AdvertisingIdClient"

    invoke-static {v6}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 658
    .local v0, "AdvertisingIdClientClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v6, "getAdvertisingIdInfo"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Class;

    const/4 v10, 0x0

    const-class v11, Landroid/content/Context;

    aput-object v11, v9, v10

    invoke-virtual {v0, v6, v9}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v3

    .line 659
    .local v3, "getAdvertisingIdInfoMethod":Ljava/lang/reflect/Method;
    const/4 v6, 0x0

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-object v11, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    aput-object v11, v9, v10

    invoke-virtual {v3, v6, v9}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 660
    .local v1, "adInfoObj":Ljava/lang/Object;
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    const-string v9, "isLimitAdTrackingEnabled"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Class;

    invoke-virtual {v6, v9, v10}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 662
    .local v4, "getLatMethod":Ljava/lang/reflect/Method;
    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v4, v1, v6}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v6

    if-eqz v6, :cond_0

    move v5, v7

    .line 667
    .end local v0    # "AdvertisingIdClientClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "adInfoObj":Ljava/lang/Object;
    .end local v3    # "getAdvertisingIdInfoMethod":Ljava/lang/reflect/Method;
    .end local v4    # "getLatMethod":Ljava/lang/reflect/Method;
    :goto_0
    return v5

    .restart local v0    # "AdvertisingIdClientClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .restart local v1    # "adInfoObj":Ljava/lang/Object;
    .restart local v3    # "getAdvertisingIdInfoMethod":Ljava/lang/reflect/Method;
    .restart local v4    # "getLatMethod":Ljava/lang/reflect/Method;
    :cond_0
    move v5, v8

    .line 662
    goto :goto_0

    .line 663
    .end local v0    # "AdvertisingIdClientClass":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v1    # "adInfoObj":Ljava/lang/Object;
    .end local v3    # "getAdvertisingIdInfoMethod":Ljava/lang/reflect/Method;
    .end local v4    # "getLatMethod":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v2

    .line 664
    .local v2, "ex":Ljava/lang/IllegalStateException;
    invoke-virtual {v2}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_0

    .line 665
    .end local v2    # "ex":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v6

    goto :goto_0
.end method

.method public getListOfApps()Lorg/json/JSONArray;
    .locals 18
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 221
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3}, Lorg/json/JSONArray;-><init>()V

    .line 222
    .local v3, "arr":Lorg/json/JSONArray;
    move-object/from16 v0, p0

    iget-object v15, v0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v15}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v12

    .line 224
    .local v12, "pm":Landroid/content/pm/PackageManager;
    const/16 v15, 0x80

    invoke-virtual {v12, v15}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v11

    .line 225
    .local v11, "packages":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    if-eqz v11, :cond_8

    .line 226
    invoke-interface {v11}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v15

    if-eqz v15, :cond_8

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/pm/ApplicationInfo;

    .line 227
    .local v2, "appInfo":Landroid/content/pm/ApplicationInfo;
    iget v15, v2, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/lit8 v15, v15, 0x1

    const/16 v16, 0x1

    move/from16 v0, v16

    if-eq v15, v0, :cond_0

    .line 228
    new-instance v10, Lorg/json/JSONObject;

    invoke-direct {v10}, Lorg/json/JSONObject;-><init>()V

    .line 230
    .local v10, "packObj":Lorg/json/JSONObject;
    :try_start_0
    invoke-virtual {v2, v12}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v6

    .line 231
    .local v6, "labelCs":Ljava/lang/CharSequence;
    if-nez v6, :cond_7

    const/4 v5, 0x0

    .line 232
    .local v5, "label":Ljava/lang/String;
    :goto_1
    if-eqz v5, :cond_1

    .line 233
    const-string v15, "name"

    invoke-virtual {v10, v15, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 234
    :cond_1
    iget-object v9, v2, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    .line 235
    .local v9, "packName":Ljava/lang/String;
    if-eqz v9, :cond_2

    .line 236
    sget-object v15, Lio/branch/referral/Defines$Jsonkey;->AppIdentifier:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v15}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v10, v15, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 237
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lio/branch/referral/SystemObserver;->getURIScheme(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 238
    .local v14, "uriScheme":Ljava/lang/String;
    const-string v15, "bnc_no_value"

    invoke-virtual {v14, v15}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v15

    if-nez v15, :cond_2

    .line 239
    sget-object v15, Lio/branch/referral/Defines$Jsonkey;->URIScheme:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v15}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v10, v15, v14}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 241
    .end local v14    # "uriScheme":Ljava/lang/String;
    :cond_2
    iget-object v7, v2, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    .line 242
    .local v7, "pSourceDir":Ljava/lang/String;
    if-eqz v7, :cond_3

    .line 243
    const-string v15, "public_source_dir"

    invoke-virtual {v10, v15, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 244
    :cond_3
    iget-object v13, v2, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    .line 245
    .local v13, "sourceDir":Ljava/lang/String;
    if-eqz v13, :cond_4

    .line 246
    const-string v15, "source_dir"

    invoke-virtual {v10, v15, v13}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 248
    :cond_4
    iget-object v15, v2, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const/16 v16, 0x1000

    move/from16 v0, v16

    invoke-virtual {v12, v15, v0}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v8

    .line 249
    .local v8, "packInfo":Landroid/content/pm/PackageInfo;
    if-eqz v8, :cond_6

    .line 250
    iget v15, v8, Landroid/content/pm/PackageInfo;->versionCode:I

    const/16 v16, 0x9

    move/from16 v0, v16

    if-lt v15, v0, :cond_5

    .line 251
    const-string v15, "install_date"

    iget-wide v0, v8, Landroid/content/pm/PackageInfo;->firstInstallTime:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v10, v15, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 252
    const-string v15, "last_update_date"

    iget-wide v0, v8, Landroid/content/pm/PackageInfo;->lastUpdateTime:J

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-virtual {v10, v15, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 254
    :cond_5
    const-string v15, "version_code"

    iget v0, v8, Landroid/content/pm/PackageInfo;->versionCode:I

    move/from16 v16, v0

    move/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    .line 255
    iget-object v15, v8, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    if-eqz v15, :cond_6

    .line 256
    const-string v15, "version_name"

    iget-object v0, v8, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 258
    :cond_6
    sget-object v15, Lio/branch/referral/Defines$Jsonkey;->OS:Lio/branch/referral/Defines$Jsonkey;

    invoke-virtual {v15}, Lio/branch/referral/Defines$Jsonkey;->getKey()Ljava/lang/String;

    move-result-object v15

    invoke-virtual/range {p0 .. p0}, Lio/branch/referral/SystemObserver;->getOS()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v10, v15, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 260
    invoke-virtual {v3, v10}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto/16 :goto_0

    .line 261
    .end local v5    # "label":Ljava/lang/String;
    .end local v6    # "labelCs":Ljava/lang/CharSequence;
    .end local v7    # "pSourceDir":Ljava/lang/String;
    .end local v8    # "packInfo":Landroid/content/pm/PackageInfo;
    .end local v9    # "packName":Ljava/lang/String;
    .end local v13    # "sourceDir":Ljava/lang/String;
    :catch_0
    move-exception v15

    goto/16 :goto_0

    .line 231
    .restart local v6    # "labelCs":Ljava/lang/CharSequence;
    :cond_7
    invoke-interface {v6}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v5

    goto/16 :goto_1

    .line 267
    .end local v2    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v6    # "labelCs":Ljava/lang/CharSequence;
    .end local v10    # "packObj":Lorg/json/JSONObject;
    :cond_8
    return-object v3

    .line 262
    .restart local v2    # "appInfo":Landroid/content/pm/ApplicationInfo;
    .restart local v4    # "i$":Ljava/util/Iterator;
    .restart local v10    # "packObj":Lorg/json/JSONObject;
    :catch_1
    move-exception v15

    goto/16 :goto_0
.end method

.method public getNFCPresent()Z
    .locals 2

    .prologue
    .line 381
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.hardware.nfc"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 384
    :goto_0
    return v0

    .line 382
    :catch_0
    move-exception v0

    .line 384
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getOS()Ljava/lang/String;
    .locals 1

    .prologue
    .line 447
    const-string v0, "Android"

    return-object v0
.end method

.method public getOSVersion()I
    .locals 1

    .prologue
    .line 472
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    return v0
.end method

.method public getPhoneBrand()Ljava/lang/String;
    .locals 1

    .prologue
    .line 421
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    return-object v0
.end method

.method public getPhoneModel()Ljava/lang/String;
    .locals 1

    .prologue
    .line 435
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    return-object v0
.end method

.method public getScreenDisplay()Landroid/util/DisplayMetrics;
    .locals 4

    .prologue
    .line 580
    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    .line 581
    .local v1, "displayMetrics":Landroid/util/DisplayMetrics;
    iget-object v2, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    const-string v3, "window"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/WindowManager;

    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 582
    .local v0, "display":Landroid/view/Display;
    invoke-virtual {v0, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 583
    return-object v1
.end method

.method public getTelephonePresent()Z
    .locals 2

    .prologue
    .line 404
    :try_start_0
    iget-object v0, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const-string v1, "android.hardware.telephony"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 407
    :goto_0
    return v0

    .line 405
    :catch_0
    move-exception v0

    .line 407
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getURIScheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lio/branch/referral/SystemObserver;->getURIScheme(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getURIScheme(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 136
    const-string v5, "bnc_no_value"

    .line 137
    .local v5, "scheme":Ljava/lang/String;
    invoke-direct {p0}, Lio/branch/referral/SystemObserver;->isLowOnMemory()Z

    move-result v8

    if-nez v8, :cond_1

    .line 138
    iget-object v8, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 140
    .local v4, "pm":Landroid/content/pm/PackageManager;
    const/4 v8, 0x0

    :try_start_0
    invoke-virtual {v4, p1, v8}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 141
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    iget-object v6, v0, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_3

    .line 142
    .local v6, "sourceApk":Ljava/lang/String;
    const/4 v2, 0x0

    .line 143
    .local v2, "jf":Ljava/util/jar/JarFile;
    const/4 v1, 0x0

    .line 144
    .local v1, "is":Ljava/io/InputStream;
    const/4 v7, 0x0

    .line 146
    .local v7, "xml":[B
    :try_start_1
    new-instance v3, Ljava/util/jar/JarFile;

    invoke-direct {v3, v6}, Ljava/util/jar/JarFile;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/OutOfMemoryError; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 147
    .end local v2    # "jf":Ljava/util/jar/JarFile;
    .local v3, "jf":Ljava/util/jar/JarFile;
    :try_start_2
    const-string v8, "AndroidManifest.xml"

    invoke-virtual {v3, v8}, Ljava/util/jar/JarFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;

    move-result-object v8

    invoke-virtual {v3, v8}, Ljava/util/jar/JarFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;

    move-result-object v1

    .line 148
    invoke-virtual {v1}, Ljava/io/InputStream;->available()I

    move-result v8

    new-array v7, v8, [B

    .line 150
    invoke-virtual {v1, v7}, Ljava/io/InputStream;->read([B)I

    .line 151
    new-instance v8, Lio/branch/referral/ApkParser;

    invoke-direct {v8}, Lio/branch/referral/ApkParser;-><init>()V

    invoke-virtual {v8, v7}, Lio/branch/referral/ApkParser;->decompressXML([B)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_8
    .catch Ljava/lang/OutOfMemoryError; {:try_start_2 .. :try_end_2} :catch_6
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-object v5

    .line 155
    const/4 v7, 0x0

    .line 157
    if-eqz v1, :cond_0

    .line 158
    :try_start_3
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 159
    const/4 v1, 0x0

    .line 161
    :cond_0
    if-eqz v3, :cond_6

    .line 162
    invoke-virtual {v3}, Ljava/util/jar/JarFile;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_3

    .line 163
    const/4 v2, 0x0

    .line 170
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v1    # "is":Ljava/io/InputStream;
    .end local v3    # "jf":Ljava/util/jar/JarFile;
    .end local v4    # "pm":Landroid/content/pm/PackageManager;
    .end local v6    # "sourceApk":Ljava/lang/String;
    .end local v7    # "xml":[B
    :cond_1
    :goto_0
    return-object v5

    .line 165
    .restart local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .restart local v1    # "is":Ljava/io/InputStream;
    .restart local v3    # "jf":Ljava/util/jar/JarFile;
    .restart local v4    # "pm":Landroid/content/pm/PackageManager;
    .restart local v6    # "sourceApk":Ljava/lang/String;
    .restart local v7    # "xml":[B
    :catch_0
    move-exception v8

    move-object v2, v3

    .line 166
    .end local v3    # "jf":Ljava/util/jar/JarFile;
    .restart local v2    # "jf":Ljava/util/jar/JarFile;
    goto :goto_0

    .line 152
    :catch_1
    move-exception v8

    .line 155
    :goto_1
    const/4 v7, 0x0

    .line 157
    if-eqz v1, :cond_2

    .line 158
    :try_start_4
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 159
    const/4 v1, 0x0

    .line 161
    :cond_2
    if-eqz v2, :cond_1

    .line 162
    invoke-virtual {v2}, Ljava/util/jar/JarFile;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_3

    .line 163
    const/4 v2, 0x0

    goto :goto_0

    .line 153
    :catch_2
    move-exception v8

    .line 155
    :goto_2
    const/4 v7, 0x0

    .line 157
    if-eqz v1, :cond_3

    .line 158
    :try_start_5
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 159
    const/4 v1, 0x0

    .line 161
    :cond_3
    if-eqz v2, :cond_1

    .line 162
    invoke-virtual {v2}, Ljava/util/jar/JarFile;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_5
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_5 .. :try_end_5} :catch_3

    .line 163
    const/4 v2, 0x0

    goto :goto_0

    .line 155
    :catchall_0
    move-exception v8

    :goto_3
    const/4 v7, 0x0

    .line 157
    if-eqz v1, :cond_4

    .line 158
    :try_start_6
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 159
    const/4 v1, 0x0

    .line 161
    :cond_4
    if-eqz v2, :cond_5

    .line 162
    invoke-virtual {v2}, Ljava/util/jar/JarFile;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_6 .. :try_end_6} :catch_3

    .line 163
    const/4 v2, 0x0

    .line 165
    :cond_5
    :goto_4
    :try_start_7
    throw v8
    :try_end_7
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_7 .. :try_end_7} :catch_3

    .line 167
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v1    # "is":Ljava/io/InputStream;
    .end local v2    # "jf":Ljava/util/jar/JarFile;
    .end local v6    # "sourceApk":Ljava/lang/String;
    .end local v7    # "xml":[B
    :catch_3
    move-exception v8

    goto :goto_0

    .line 165
    .restart local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .restart local v1    # "is":Ljava/io/InputStream;
    .restart local v2    # "jf":Ljava/util/jar/JarFile;
    .restart local v6    # "sourceApk":Ljava/lang/String;
    .restart local v7    # "xml":[B
    :catch_4
    move-exception v9

    goto :goto_4

    .line 155
    .end local v2    # "jf":Ljava/util/jar/JarFile;
    .restart local v3    # "jf":Ljava/util/jar/JarFile;
    :catchall_1
    move-exception v8

    move-object v2, v3

    .end local v3    # "jf":Ljava/util/jar/JarFile;
    .restart local v2    # "jf":Ljava/util/jar/JarFile;
    goto :goto_3

    .line 165
    :catch_5
    move-exception v8

    goto :goto_0

    .line 153
    .end local v2    # "jf":Ljava/util/jar/JarFile;
    .restart local v3    # "jf":Ljava/util/jar/JarFile;
    :catch_6
    move-exception v8

    move-object v2, v3

    .end local v3    # "jf":Ljava/util/jar/JarFile;
    .restart local v2    # "jf":Ljava/util/jar/JarFile;
    goto :goto_2

    .line 165
    :catch_7
    move-exception v8

    goto :goto_0

    .line 152
    .end local v2    # "jf":Ljava/util/jar/JarFile;
    .restart local v3    # "jf":Ljava/util/jar/JarFile;
    :catch_8
    move-exception v8

    move-object v2, v3

    .end local v3    # "jf":Ljava/util/jar/JarFile;
    .restart local v2    # "jf":Ljava/util/jar/JarFile;
    goto :goto_1

    .end local v2    # "jf":Ljava/util/jar/JarFile;
    .restart local v3    # "jf":Ljava/util/jar/JarFile;
    :cond_6
    move-object v2, v3

    .end local v3    # "jf":Ljava/util/jar/JarFile;
    .restart local v2    # "jf":Ljava/util/jar/JarFile;
    goto :goto_0
.end method

.method public getUniqueID(Z)Ljava/lang/String;
    .locals 3
    .param p1, "debug"    # Z

    .prologue
    .line 85
    iget-object v1, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    if-eqz v1, :cond_2

    .line 86
    const/4 v0, 0x0

    .line 87
    .local v0, "androidID":Ljava/lang/String;
    if-nez p1, :cond_0

    .line 88
    iget-object v1, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "android_id"

    invoke-static {v1, v2}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 90
    :cond_0
    if-nez v0, :cond_1

    .line 91
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 92
    const/4 v1, 0x0

    iput-boolean v1, p0, Lio/branch/referral/SystemObserver;->isRealHardwareId:Z

    .line 96
    .end local v0    # "androidID":Ljava/lang/String;
    :cond_1
    :goto_0
    return-object v0

    :cond_2
    const-string v0, "bnc_no_value"

    goto :goto_0
.end method

.method public getUpdateState(Z)I
    .locals 10
    .param p1, "updatePrefs"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v3, 0x2

    const/4 v4, 0x0

    .line 535
    iget-object v5, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-static {v5}, Lio/branch/referral/PrefHelper;->getInstance(Landroid/content/Context;)Lio/branch/referral/PrefHelper;

    move-result-object v1

    .line 536
    .local v1, "pHelper":Lio/branch/referral/PrefHelper;
    invoke-virtual {p0}, Lio/branch/referral/SystemObserver;->getAppVersion()Ljava/lang/String;

    move-result-object v0

    .line 537
    .local v0, "currAppVersion":Ljava/lang/String;
    const-string v5, "bnc_no_value"

    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getAppVersion()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 539
    if-eqz p1, :cond_0

    .line 540
    invoke-virtual {v1, v0}, Lio/branch/referral/PrefHelper;->setAppVersion(Ljava/lang/String;)V

    .line 542
    :cond_0
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x9

    if-lt v5, v6, :cond_3

    .line 545
    :try_start_0
    iget-object v5, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    iget-object v6, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    invoke-virtual {v6}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    .line 546
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-wide v6, v2, Landroid/content/pm/PackageInfo;->lastUpdateTime:J

    iget-wide v8, v2, Landroid/content/pm/PackageInfo;->firstInstallTime:J
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    cmp-long v5, v6, v8

    if-eqz v5, :cond_2

    .line 562
    .end local v2    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_1
    :goto_0
    return v3

    .restart local v2    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_2
    move v3, v4

    .line 549
    goto :goto_0

    .line 550
    .end local v2    # "packageInfo":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v3

    :cond_3
    move v3, v4

    .line 553
    goto :goto_0

    .line 554
    :cond_4
    invoke-virtual {v1}, Lio/branch/referral/PrefHelper;->getAppVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_5

    .line 556
    if-eqz p1, :cond_1

    .line 557
    invoke-virtual {v1, v0}, Lio/branch/referral/PrefHelper;->setAppVersion(Ljava/lang/String;)V

    goto :goto_0

    .line 562
    :cond_5
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public getWifiConnected()Z
    .locals 4

    .prologue
    .line 604
    iget-object v2, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    const-string v3, "android.permission.ACCESS_NETWORK_STATE"

    invoke-virtual {v2, v3}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_0

    .line 605
    iget-object v2, p0, Lio/branch/referral/SystemObserver;->context_:Landroid/content/Context;

    const-string v3, "connectivity"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 606
    .local v0, "connManager":Landroid/net/ConnectivityManager;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v1

    .line 607
    .local v1, "wifiInfo":Landroid/net/NetworkInfo;
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v2

    .line 609
    .end local v0    # "connManager":Landroid/net/ConnectivityManager;
    .end local v1    # "wifiInfo":Landroid/net/NetworkInfo;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public hasRealHardwareId()Z
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lio/branch/referral/SystemObserver;->isRealHardwareId:Z

    return v0
.end method

.method public isSimulator()Z
    .locals 2

    .prologue
    .line 500
    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    const-string v1, "generic"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method
