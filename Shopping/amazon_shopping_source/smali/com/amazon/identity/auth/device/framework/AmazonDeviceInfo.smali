.class public Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;
.super Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;
.source "AmazonDeviceInfo.java"


# static fields
.field private static final BUILD_NUMBER:I

.field private static final SYSTEM_PROPERTIES:Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 25
    const-class v0, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    .line 27
    new-instance v0, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;-><init>()V

    .line 28
    sput-object v0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->SYSTEM_PROPERTIES:Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;

    const-string/jumbo v1, "ro.build.version.number"

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/framework/SystemPropertiesWrapper;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/StringConversionHelpers;->toInt(Ljava/lang/String;I)I

    move-result v0

    sput v0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->BUILD_NUMBER:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/SSODeviceInfo;-><init>()V

    .line 35
    new-instance v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    invoke-direct {v0}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    .line 39
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    .line 40
    return-void
.end method

.method public static getBuildConfiguration(Landroid/content/Context;)Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 207
    invoke-static {p0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 209
    const/4 v1, 0x0

    .line 220
    :goto_0
    return-object v1

    .line 211
    :cond_0
    sget-object v0, Landroid/os/Build;->TYPE:Ljava/lang/String;

    .line 214
    .local v0, "buildType":Ljava/lang/String;
    :try_start_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->fromString(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/BuildConfiguration;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/InvalidEnumValueException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 218
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Unable to determine the build type : "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    sget-object v1, Lcom/amazon/identity/auth/device/utils/BuildConfiguration;->User:Lcom/amazon/identity/auth/device/utils/BuildConfiguration;

    goto :goto_0
.end method


# virtual methods
.method public getBuildName()Ljava/lang/String;
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 120
    sget-object v0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Amazon Platform is of product name: "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 121
    sget-object v0, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    .line 124
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "Third Party Build"

    goto :goto_0
.end method

.method public getBuildNumber()I
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 79
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/amazon/identity/platform/util/PlatformUtils;->isAmazonDevice(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 81
    sget-object v3, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Amazon Platform is of version: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v4, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->BUILD_NUMBER:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 82
    sget v3, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->BUILD_NUMBER:I

    .line 111
    :goto_0
    return v3

    .line 95
    :cond_0
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    .line 96
    .local v2, "packageName":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;

    move-result-object v4

    invoke-virtual {v4, v2}, Lcom/amazon/identity/auth/device/framework/MAPApplicationInformationQueryer;->getAppInfo(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;

    move-result-object v1

    .line 98
    .local v1, "mapInfo":Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;
    if-nez v1, :cond_1

    .line 100
    sget-object v4, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Could not get the build number for this build/app"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 106
    :cond_1
    :try_start_0
    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getSWVersion()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/framework/RemoteMAPException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    goto :goto_0

    .line 108
    :catch_0
    move-exception v0

    .line 110
    .local v0, "e":Lcom/amazon/identity/auth/device/framework/RemoteMAPException;
    sget-object v4, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Could not get the build number from "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/RemoteMapInfo;->getPackageName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getDeviceSecret()Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v4, 0x0

    .line 130
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const-string/jumbo v5, "com.lab126.idme.Idme"

    invoke-virtual {v3, v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getHiddenClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 131
    .local v1, "idmeClass":Ljava/lang/Class;
    if-nez v1, :cond_0

    .line 133
    sget-object v3, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Class: com.lab126.idme.Idme does not exist"

    invoke-static {v3, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    .line 156
    :goto_0
    return-object v3

    .line 137
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const-string/jumbo v5, "readSecret"

    invoke-virtual {v3, v1, v5}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getHiddenMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;

    move-result-object v2

    .line 138
    .local v2, "readSecret":Ljava/lang/reflect/Method;
    if-nez v2, :cond_1

    .line 140
    sget-object v3, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Method: readSecret deos not exist"

    invoke-static {v3, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    .line 141
    goto :goto_0

    .line 146
    :cond_1
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const/4 v5, 0x0

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    aput-object v8, v6, v7

    invoke-virtual {v3, v2, v5, v6}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 148
    :catch_0
    move-exception v0

    .line 150
    .local v0, "e":Ljava/lang/IllegalAccessException;
    sget-object v3, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Failed to retrieve the device secret"

    invoke-static {v3, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v3, v4

    .line 151
    goto :goto_0

    .line 153
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v0

    .line 155
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    sget-object v3, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Failed to retrieve the device secret"

    invoke-static {v3, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v3, v4

    .line 156
    goto :goto_0
.end method

.method public getDeviceSerialNumber()Ljava/lang/String;
    .locals 3

    .prologue
    .line 45
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/SerialNumber;->getAmazonSerial(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "serialNumber":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->isValidSerialNumber(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 49
    sget-object v1, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Device does not have a valid Amazon serial number. If this is an Amazon Device set Build.SERIAL to the serial number and set Build.MANUFACTURER to \'Amazon\'."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/CommonInfoGetter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->getDsn()Ljava/lang/String;

    move-result-object v0

    .line 59
    :cond_0
    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 2

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mContext:Landroid/content/Context;

    sget-object v1, Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;->CentralDeviceType:Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/Platform;->getDeviceAttribute(Landroid/content/Context;Lcom/amazon/identity/auth/device/attribute/DeviceAttribute;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMacAddress()Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v4, 0x0

    .line 166
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const-string/jumbo v6, "com.lab126.idme.Idme"

    invoke-virtual {v5, v6}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getHiddenClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    .line 168
    .local v2, "idmeClass":Ljava/lang/Class;
    if-nez v2, :cond_0

    .line 170
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Class: com.lab126.idme.Idme does not exist"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    .line 201
    :goto_0
    return-object v3

    .line 174
    :cond_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const-string/jumbo v6, "getMacAddress"

    invoke-virtual {v5, v2, v6}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->getHiddenMethod(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 175
    .local v1, "getMacAddress":Ljava/lang/reflect/Method;
    if-nez v1, :cond_1

    .line 177
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Method: getMacAddress does not exist. Check to see if com.lab126.idme.Idme exists on the device and contains method getMacAddress."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object v3, v4

    .line 179
    goto :goto_0

    .line 184
    :cond_1
    :try_start_0
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    .line 185
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->mReflectionHelper:Lcom/amazon/identity/auth/device/utils/ReflectionHelper;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v5, v1, v6, v7}, Lcom/amazon/identity/auth/device/utils/ReflectionHelper;->invoke(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 186
    .local v3, "macAddress":Ljava/lang/String;
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Returning MAC Address: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 189
    .end local v3    # "macAddress":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 191
    .local v0, "e":Ljava/lang/IllegalAccessException;
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Failed to retrieve the device mac address. Check with the platform team to see com.lab126.idme.Idme is properly setup."

    invoke-static {v5, v6, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v3, v4

    .line 194
    goto :goto_0

    .line 196
    .end local v0    # "e":Ljava/lang/IllegalAccessException;
    :catch_1
    move-exception v0

    .line 198
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    sget-object v5, Lcom/amazon/identity/auth/device/framework/AmazonDeviceInfo;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Failed to retrieve the device mac address. Check with the platform team to see com.lab126.idme.Idme is properly setup."

    invoke-static {v5, v6, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    move-object v3, v4

    .line 201
    goto :goto_0
.end method

.method public isValidSerialNumber(Ljava/lang/String;)Z
    .locals 2
    .param p1, "serialNumber"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "unknown"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
