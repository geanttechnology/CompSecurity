.class public final Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;
.super Ljava/lang/Object;
.source "DeviceTypeHelpers.java"


# static fields
.field public static final CANARY_DEVICE_TYPE:Ljava/lang/String; = "A17I2SKGZYX7FH"

.field public static final DEVICE_TYPE_KEY:Ljava/lang/String; = "MAPDeviceType"

.field public static final DEVICE_TYPE_PREFIX:Ljava/lang/String; = "App_Device_Type_For_Central_Device_Type_"

.field public static final GROVER_DEVICE_TYPE:Ljava/lang/String; = "A1PY8QQU9P0WJV"

.field private static final PACKAGE_TO_DEVICETYPE_CACHE:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final TAG:Ljava/lang/String;

.field public static final THIRD_PARTY_DEVICE_TYPE:Ljava/lang/String; = "A1MPSLFC7L5AFK"

.field private static volatile sCentralDeviceType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 75
    const-class v0, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    .line 79
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->sCentralDeviceType:Ljava/lang/String;

    .line 81
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v0, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->PACKAGE_TO_DEVICETYPE_CACHE:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    return-void
.end method

.method public static areAppsWithDeviceTypeUsingDeviceCredentials(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceType"    # Ljava/lang/String;

    .prologue
    .line 221
    sget-object v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public static arePackagesUsingTheSameDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName1"    # Ljava/lang/String;
    .param p2, "packageName2"    # Ljava/lang/String;

    .prologue
    .line 239
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeOfPackage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 240
    .local v0, "deviceType1":Ljava/lang/String;
    invoke-static {p0, p2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeOfPackage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 242
    .local v1, "deviceType2":Ljava/lang/String;
    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    return v2
.end method

.method static calculateCentralDeviceType(Ljava/lang/Integer;Lcom/amazon/identity/platform/setting/PlatformSettings;Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Ljava/lang/String;
    .locals 4
    .param p0, "deviceCode"    # Ljava/lang/Integer;
    .param p1, "settings"    # Lcom/amazon/identity/platform/setting/PlatformSettings;
    .param p2, "wrappedPlatform"    # Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .prologue
    const/4 v1, 0x0

    .line 162
    const/4 v0, 0x0

    .line 164
    .local v0, "deviceType":Ljava/lang/String;
    if-eqz p0, :cond_3

    .line 167
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "com.amazon.imp.dms_string_"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2, v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 169
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    move-object v1, v0

    .line 210
    :goto_0
    return-object v1

    .line 175
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "com.amazon.sso.dms_string_"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2, v1}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 177
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    move-object v1, v0

    .line 179
    goto :goto_0

    .line 182
    :cond_1
    if-eqz p0, :cond_2

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    :cond_2
    move-object v0, v1

    .line 183
    :goto_1
    if-eqz v0, :cond_3

    move-object v1, v0

    .line 185
    goto :goto_0

    .line 182
    :sswitch_0
    const-string/jumbo v0, "A1C8TH2NPKC3A1"

    goto :goto_1

    :sswitch_1
    const-string/jumbo v0, "A2MJ2WHF2K4V21"

    goto :goto_1

    :sswitch_2
    const-string/jumbo v0, "AC5DXSR5G8JPX"

    goto :goto_1

    :sswitch_3
    const-string/jumbo v0, "A2TR7IN2V8NATY"

    goto :goto_1

    :sswitch_4
    const-string/jumbo v0, "AX5Q0TWIKDVK1"

    goto :goto_1

    :sswitch_5
    const-string/jumbo v0, "ANDK8J66NR3L"

    goto :goto_1

    :sswitch_6
    const-string/jumbo v0, "A1CJBQKTERGM4W"

    goto :goto_1

    :sswitch_7
    const-string/jumbo v0, "A831W44HZ8ZX9"

    goto :goto_1

    :sswitch_8
    const-string/jumbo v0, "A3KMUO14KJF686"

    goto :goto_1

    :sswitch_9
    const-string/jumbo v0, "AXWOV4XZMCHP1"

    goto :goto_1

    .line 190
    :cond_3
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->hasCentralApk()Z

    move-result v1

    if-nez v1, :cond_4

    .line 192
    const-string/jumbo v1, "A1MPSLFC7L5AFK"

    goto :goto_0

    .line 194
    :cond_4
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isGroverInstalled()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 196
    sget-object v1, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Device has Grover v1 installed"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    const-string/jumbo v1, "A1PY8QQU9P0WJV"

    goto :goto_0

    .line 199
    :cond_5
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isCanaryInstalled()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 201
    sget-object v1, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Device has Canary installed"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    const-string/jumbo v1, "A17I2SKGZYX7FH"

    goto :goto_0

    .line 204
    :cond_6
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v1

    if-eqz v1, :cond_7

    .line 207
    const-string/jumbo v1, "A1MPSLFC7L5AFK"

    goto/16 :goto_0

    :cond_7
    move-object v1, v0

    .line 210
    goto/16 :goto_0

    .line 182
    :sswitch_data_0
    .sparse-switch
        0x1e -> :sswitch_0
        0x25 -> :sswitch_2
        0x26 -> :sswitch_1
        0x59 -> :sswitch_3
        0xc9 -> :sswitch_4
        0xca -> :sswitch_5
        0xcb -> :sswitch_6
        0xcc -> :sswitch_7
        0xcd -> :sswitch_8
        0xce -> :sswitch_9
    .end sparse-switch
.end method

.method public static getAllMapDeviceTypesAndSoftwareVersion(Landroid/content/Context;Z)Ljava/util/Map;
    .locals 22
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "forceQueryRemote"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Z)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 425
    invoke-static/range {p0 .. p0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v16

    .line 426
    .local v16, "wrappedContext":Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;
    const-string/jumbo v17, "sso_platform"

    invoke-virtual/range {v16 .. v17}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    .line 433
    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;->isThirdPartyDevice()Z

    move-result v17

    if-eqz v17, :cond_1

    .line 435
    sget-object v17, Ljava/util/Collections;->EMPTY_SET:Ljava/util/Set;

    invoke-static/range {v17 .. v17}, Ljava/util/Collections;->unmodifiableCollection(Ljava/util/Collection;)Ljava/util/Collection;

    move-result-object v13

    .line 443
    .local v13, "remoteMapApps":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    :goto_0
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .line 445
    .local v7, "deviceTypeToSoftwareVersionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    const-string/jumbo v17, "dcp_device_info"

    invoke-virtual/range {v16 .. v17}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    .line 448
    .local v5, "deviceInfo":Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
    sget-object v17, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static/range {v16 .. v17}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v2

    .line 450
    .local v2, "centralDeviceType":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;->getBuildNumber()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    .line 451
    .local v4, "centralSoftwareVersion":Ljava/lang/Integer;
    invoke-static/range {p0 .. p0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getCentralSoftwareComponentId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    .line 453
    .local v3, "centralSoftwareComponentId":Ljava/lang/String;
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "Using the central device type: %s, software version: %s, and software component id: %s"

    const/16 v19, 0x3

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v2, v19, v20

    const/16 v20, 0x1

    aput-object v4, v19, v20

    const/16 v20, 0x2

    aput-object v3, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 459
    new-instance v17, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    move-object/from16 v0, v17

    invoke-direct {v0, v4, v3}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;-><init>(Ljava/lang/Integer;Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-interface {v7, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 462
    invoke-interface {v13}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_1
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_7

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    .line 464
    .local v12, "remoteMapApp":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    move/from16 v0, p1

    invoke-virtual {v12, v0}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->setForceQueryRemote(Z)V

    .line 466
    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageVersion()Ljava/lang/Integer;

    move-result-object v15

    .line 467
    .local v15, "softwareVersion":Ljava/lang/Integer;
    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v14

    .line 472
    .local v14, "softwareComponentId":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;

    move-result-object v6

    .line 473
    .local v6, "deviceType":Ljava/lang/String;
    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getOverrideDSN()Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v11

    .line 482
    .local v11, "overrideDSN":Ljava/lang/String;
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v17, "The RemoteMapInfo returns softwareComponentId: %s, deviceType: %s, softwareVersion: %s, overrideDSN: %s"

    const/16 v18, 0x4

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput-object v14, v18, v19

    const/16 v19, 0x1

    aput-object v6, v18, v19

    const/16 v19, 0x2

    aput-object v15, v18, v19

    const/16 v19, 0x3

    aput-object v11, v18, v19

    invoke-static/range {v17 .. v18}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 489
    invoke-static {v11}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_2

    .line 491
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "%s is using override DSN. Skipping it."

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 440
    .end local v2    # "centralDeviceType":Ljava/lang/String;
    .end local v3    # "centralSoftwareComponentId":Ljava/lang/String;
    .end local v4    # "centralSoftwareVersion":Ljava/lang/Integer;
    .end local v5    # "deviceInfo":Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
    .end local v6    # "deviceType":Ljava/lang/String;
    .end local v7    # "deviceTypeToSoftwareVersionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v11    # "overrideDSN":Ljava/lang/String;
    .end local v12    # "remoteMapApp":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .end local v13    # "remoteMapApps":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    .end local v14    # "softwareComponentId":Ljava/lang/String;
    .end local v15    # "softwareVersion":Ljava/lang/Integer;
    :cond_1
    invoke-static/range {v16 .. v16}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAllMapApplication()Ljava/util/Collection;

    move-result-object v13

    .restart local v13    # "remoteMapApps":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;>;"
    goto/16 :goto_0

    .line 475
    .restart local v2    # "centralDeviceType":Ljava/lang/String;
    .restart local v3    # "centralSoftwareComponentId":Ljava/lang/String;
    .restart local v4    # "centralSoftwareVersion":Ljava/lang/Integer;
    .restart local v5    # "deviceInfo":Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
    .restart local v7    # "deviceTypeToSoftwareVersionMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    .restart local v10    # "i$":Ljava/util/Iterator;
    .restart local v12    # "remoteMapApp":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .restart local v14    # "softwareComponentId":Ljava/lang/String;
    .restart local v15    # "softwareVersion":Ljava/lang/Integer;
    :catch_0
    move-exception v8

    .line 477
    .local v8, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-instance v18, Ljava/lang/StringBuilder;

    const-string/jumbo v19, "Failed to query device type/override DSN for "

    invoke-direct/range {v18 .. v19}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, ". Skipping it."

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-static {v0, v1, v8}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1

    .line 495
    .end local v8    # "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    .restart local v6    # "deviceType":Ljava/lang/String;
    .restart local v11    # "overrideDSN":Ljava/lang/String;
    :cond_2
    if-nez v15, :cond_3

    .line 497
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "%s is using null software version. Replacing the null with 0."

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 500
    const/16 v17, 0x0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v15

    .line 504
    :cond_3
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_4

    .line 506
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "%s is using null or empty device type. This should be an integration error."

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 512
    :cond_4
    invoke-static {v6, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v17

    if-eqz v17, :cond_5

    .line 514
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "%s is using central device type."

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual {v12}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 518
    :cond_5
    invoke-interface {v7, v6}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_6

    .line 521
    sget-object v17, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v18, "Multiple apps are using the device type %s. Choosing the app with the greatest software version."

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v6, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 524
    invoke-interface {v7, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareVersion()Ljava/lang/Integer;

    move-result-object v17

    .line 525
    invoke-virtual/range {v17 .. v17}, Ljava/lang/Integer;->intValue()I

    move-result v17

    invoke-virtual {v15}, Ljava/lang/Integer;->intValue()I

    move-result v18

    move/from16 v0, v17

    move/from16 v1, v18

    if-ge v0, v1, :cond_0

    .line 527
    new-instance v17, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    move-object/from16 v0, v17

    invoke-direct {v0, v15, v14}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;-><init>(Ljava/lang/Integer;Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-interface {v7, v6, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1

    .line 533
    :cond_6
    new-instance v17, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    move-object/from16 v0, v17

    invoke-direct {v0, v15, v14}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;-><init>(Ljava/lang/Integer;Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-interface {v7, v6, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1

    .line 537
    .end local v6    # "deviceType":Ljava/lang/String;
    .end local v11    # "overrideDSN":Ljava/lang/String;
    .end local v12    # "remoteMapApp":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    .end local v14    # "softwareComponentId":Ljava/lang/String;
    .end local v15    # "softwareVersion":Ljava/lang/Integer;
    :cond_7
    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v17

    invoke-interface/range {v17 .. v17}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    :goto_2
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_8

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    .line 539
    .local v9, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    sget-object v18, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v19, "Using the deviceType-softwareVersion,softwareComponentId: %s - %s, %s"

    const/16 v17, 0x3

    move/from16 v0, v17

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v20, v0

    const/16 v17, 0x0

    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v21

    aput-object v21, v20, v17

    const/16 v21, 0x1

    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareVersion()Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v20, v21

    const/16 v21, 0x2

    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;->getSoftwareComponentId()Ljava/lang/String;

    move-result-object v17

    aput-object v17, v20, v21

    invoke-static/range {v19 .. v20}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 546
    .end local v9    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/SoftwareInfo;>;"
    :cond_8
    return-object v7
.end method

.method public static getCentralDeviceType(Landroid/content/Context;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x1

    .line 93
    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_0

    new-instance v4, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;

    invoke-direct {v4}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;-><init>()V

    const-string/jumbo v5, "ro.product.config.type"

    invoke-virtual {v4, v5}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 94
    .local v0, "deviceType":Ljava/lang/String;
    :goto_0
    if-eqz v0, :cond_1

    .line 96
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Returning device type from system property: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-object v1, v0

    .line 124
    .end local v0    # "deviceType":Ljava/lang/String;
    .local v1, "deviceType":Ljava/lang/String;
    :goto_1
    return-object v1

    .line 93
    .end local v1    # "deviceType":Ljava/lang/String;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 100
    .restart local v0    # "deviceType":Ljava/lang/String;
    :cond_1
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v4

    if-eqz v4, :cond_3

    :cond_2
    :goto_2
    if-eqz v3, :cond_5

    .line 102
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->sCentralDeviceType:Ljava/lang/String;

    if-eqz v3, :cond_4

    sget-object v0, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->sCentralDeviceType:Ljava/lang/String;

    .line 121
    :goto_3
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 123
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Returning device type: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-object v1, v0

    .line 124
    .end local v0    # "deviceType":Ljava/lang/String;
    .restart local v1    # "deviceType":Ljava/lang/String;
    goto :goto_1

    .line 100
    .end local v1    # "deviceType":Ljava/lang/String;
    .restart local v0    # "deviceType":Ljava/lang/String;
    :cond_3
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CentralApkUtils;->isRunningInCentralApkOrNoCentral(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isPreMergeDevice(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_2

    const/4 v3, 0x0

    goto :goto_2

    .line 102
    :cond_4
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceCodeFromSerialNumber(Landroid/content/Context;)Ljava/lang/Integer;

    move-result-object v3

    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v4

    new-instance v5, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;

    invoke-direct {v5, p0}, Lcom/amazon/identity/auth/device/framework/PlatformWrapper;-><init>(Landroid/content/Context;)V

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->calculateCentralDeviceType(Ljava/lang/Integer;Lcom/amazon/identity/platform/setting/PlatformSettings;Lcom/amazon/identity/auth/device/framework/PlatformWrapper;)Ljava/lang/String;

    move-result-object v0

    .end local v0    # "deviceType":Ljava/lang/String;
    sput-object v0, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->sCentralDeviceType:Ljava/lang/String;

    goto :goto_3

    .line 110
    .restart local v0    # "deviceType":Ljava/lang/String;
    :cond_5
    :try_start_0
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    move-result-object v3

    const-string/jumbo v4, "DeviceType"

    invoke-virtual {v3, v4}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getValue(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/DeviceDataStoreException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_3

    .line 112
    :catch_0
    move-exception v2

    .line 114
    .local v2, "e":Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Could not get central device type"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    new-instance v3, Ljava/lang/RuntimeException;

    const-string/jumbo v4, "Could not get central device type"

    invoke-direct {v3, v4, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 127
    .end local v2    # "e":Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
    :cond_6
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    .line 130
    new-instance v3, Ljava/lang/RuntimeException;

    const-string/jumbo v4, "No central device type found!  This is likely a device configuration issue."

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3
.end method

.method public static getCentralSoftwareComponentId(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 614
    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v1

    sget-object v2, Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;->DeviceGlobal:Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;

    const-string/jumbo v3, "os_package_name"

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Lcom/amazon/identity/platform/setting/PlatformSettings$Namespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 618
    .local v0, "softwareComponentId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 620
    sget-object v1, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Central Software Component Id is null.  DCP setting -device-/os_package_name not set for this device."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 623
    :cond_0
    return-object v0
.end method

.method public static getDeviceCodeFromSerialNumber(Landroid/content/Context;)Ljava/lang/Integer;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 552
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/SerialNumber;->getAmazonSerial(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceCodeFromSerialNumber(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method static getDeviceCodeFromSerialNumber(Ljava/lang/String;)Ljava/lang/Integer;
    .locals 2
    .param p0, "serialNumber"    # Ljava/lang/String;

    .prologue
    .line 557
    if-eqz p0, :cond_0

    const-string/jumbo v0, "[0-9A-F]{4}[0-9A-Z]{12}"

    invoke-virtual {p0, v0}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 561
    const/4 v0, 0x2

    const/4 v1, 0x4

    :try_start_0
    invoke-virtual {p0, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x10

    invoke-static {v0, v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 569
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getDeviceTypeForAPackageFromMetadata(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 300
    sget-object v2, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->PACKAGE_TO_DEVICETYPE_CACHE:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 301
    .local v0, "cachedRes":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/UnitTestUtils;->isRunningInUnitTest()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 312
    .end local v0    # "cachedRes":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 305
    .restart local v0    # "cachedRes":Ljava/lang/String;
    :cond_0
    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v2

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getCentralDeviceType(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceCodeFromSerialNumber(Landroid/content/Context;)Ljava/lang/Integer;

    move-result-object v4

    invoke-static {p0, v2, v3, v4, p1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeForAPackageInner(Landroid/content/Context;Lcom/amazon/identity/platform/setting/PlatformSettings;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 311
    .local v1, "deviceType":Ljava/lang/String;
    sget-object v2, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->PACKAGE_TO_DEVICETYPE_CACHE:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v0, v1

    .line 312
    goto :goto_0
.end method

.method static getDeviceTypeForAPackageInner(Landroid/content/Context;Lcom/amazon/identity/platform/setting/PlatformSettings;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "settings"    # Lcom/amazon/identity/platform/setting/PlatformSettings;
    .param p2, "centralDeviceType"    # Ljava/lang/String;
    .param p3, "deviceCode"    # Ljava/lang/Integer;
    .param p4, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 325
    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "App_Device_Type_For_Central_Device_Type_"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, p4, v3}, Lcom/amazon/identity/auth/device/utils/MetaDataUtils;->getMetaDataForAPackage(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 327
    .local v0, "centralDeviceTypeSpecificAppDeviceType":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 329
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-array v3, v7, [Ljava/lang/Object;

    aput-object p4, v3, v5

    aput-object v0, v3, v6

    .line 360
    .end local v0    # "centralDeviceTypeSpecificAppDeviceType":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 336
    .restart local v0    # "centralDeviceTypeSpecificAppDeviceType":Ljava/lang/String;
    :cond_0
    const/4 v3, 0x0

    invoke-static {p1, p3, p4, v3}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getPackageDeviceTypeFromSettings(Lcom/amazon/identity/platform/setting/PlatformSettings;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 338
    .local v2, "deviceDefaultDeviceType":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 340
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-array v3, v7, [Ljava/lang/Object;

    aput-object p4, v3, v5

    aput-object v2, v3, v6

    move-object v0, v2

    .line 342
    goto :goto_0

    .line 345
    :cond_1
    const-string/jumbo v3, "MAPDeviceType"

    invoke-static {p0, p4, v3}, Lcom/amazon/identity/auth/device/utils/MetaDataUtils;->getMetaDataForAPackage(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 347
    .local v1, "defaultAppDeviceType":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 349
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-array v3, v7, [Ljava/lang/Object;

    aput-object p4, v3, v5

    aput-object v1, v3, v6

    move-object v0, v1

    .line 353
    goto :goto_0

    .line 356
    :cond_2
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-array v3, v7, [Ljava/lang/Object;

    aput-object p4, v3, v5

    aput-object p2, v3, v6

    move-object v0, p2

    .line 360
    goto :goto_0
.end method

.method public static getDeviceTypeForCurrentProcess(Landroid/content/Context;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 283
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeForAPackageFromMetadata(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getDeviceTypeOfPackage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 393
    if-nez p1, :cond_1

    .line 395
    sget-object v2, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {p0, v2}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v2

    .line 411
    :cond_0
    :goto_0
    return-object v2

    .line 398
    :cond_1
    invoke-static {p0}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v3

    invoke-virtual {v3, p1}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v1

    .line 399
    .local v1, "info":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    if-eqz v1, :cond_0

    .line 406
    :try_start_0
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getDeviceType()Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 408
    :catch_0
    move-exception v0

    .line 410
    .local v0, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v3, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Failed to get device type for "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static getLegacySubAuthPackageDeviceType(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;
    .param p2, "defaultDeviceType"    # Ljava/lang/String;

    .prologue
    .line 367
    invoke-static {p0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    move-result-object v0

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceCodeFromSerialNumber(Landroid/content/Context;)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {v0, v1, p1, p2}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getPackageDeviceTypeFromSettings(Lcom/amazon/identity/platform/setting/PlatformSettings;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getPackageDeviceTypeFromSettings(Lcom/amazon/identity/platform/setting/PlatformSettings;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "settings"    # Lcom/amazon/identity/platform/setting/PlatformSettings;
    .param p1, "deviceCode"    # Ljava/lang/Integer;
    .param p2, "packageName"    # Ljava/lang/String;
    .param p3, "defaultDeviceType"    # Ljava/lang/String;

    .prologue
    .line 378
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ".dms_string_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 381
    .local v0, "deviceCodeSpecificDeviceType":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 388
    .end local v0    # "deviceCodeSpecificDeviceType":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 386
    .restart local v0    # "deviceCodeSpecificDeviceType":Ljava/lang/String;
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ".dms_string"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p3}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getSettingString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getSoftwareComponentId(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "deviceType"    # Ljava/lang/String;
    .param p2, "packageName"    # Ljava/lang/String;

    .prologue
    .line 639
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->areAppsWithDeviceTypeUsingDeviceCredentials(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 641
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getCentralSoftwareComponentId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object p2

    .line 643
    .end local p2    # "packageName":Ljava/lang/String;
    :cond_0
    return-object p2
.end method

.method public static isLocalApplicationUsingDeviceCredentials(Landroid/content/Context;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 215
    sget-object v0, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeForCurrentProcess(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public static isPackageUsingCentralDeviceType(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 226
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->getDeviceTypeOfPackage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 227
    .local v0, "deviceType":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 229
    const/4 v1, 0x0

    .line 232
    :goto_0
    return v1

    :cond_0
    invoke-static {p0, v0}, Lcom/amazon/identity/auth/device/utils/DeviceTypeHelpers;->areAppsWithDeviceTypeUsingDeviceCredentials(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method
