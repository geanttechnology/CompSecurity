.class public Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
.super Ljava/lang/Object;
.source "AndroidDevice.java"


# static fields
.field private static final DEBUG_DN:Ljavax/security/auth/x500/X500Principal;

.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final appId:Ljava/lang/String;

.field protected final application:Landroid/app/Application;

.field protected final resources:Landroid/content/res/Resources;

.field protected final telephonyManager:Landroid/telephony/TelephonyManager;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 30
    const-class v0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->LOG:Lorg/slf4j/Logger;

    .line 32
    new-instance v0, Ljavax/security/auth/x500/X500Principal;

    const-string v1, "CN=Android Debug,O=Android,C=US"

    invoke-direct {v0, v1}, Ljavax/security/auth/x500/X500Principal;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->DEBUG_DN:Ljavax/security/auth/x500/X500Principal;

    return-void
.end method

.method public constructor <init>(Landroid/app/Application;Landroid/content/res/Resources;Landroid/telephony/TelephonyManager;Ljava/lang/String;)V
    .locals 0
    .param p1, "application"    # Landroid/app/Application;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "telephonyManager"    # Landroid/telephony/TelephonyManager;
    .param p4, "appId"    # Ljava/lang/String;

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->application:Landroid/app/Application;

    .line 48
    iput-object p2, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->resources:Landroid/content/res/Resources;

    .line 49
    iput-object p3, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->telephonyManager:Landroid/telephony/TelephonyManager;

    .line 50
    iput-object p4, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->appId:Ljava/lang/String;

    .line 51
    return-void
.end method

.method private static getBrandDeviceAndModelDescription()Ljava/lang/String;
    .locals 2

    .prologue
    .line 81
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 82
    .local v0, "brandDeviceModel":Ljava/lang/StringBuilder;
    sget-object v1, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 83
    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 84
    sget-object v1, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 85
    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 86
    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 88
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public getAndroidPrefixedBuildVersionRelease()Ljava/lang/String;
    .locals 2

    .prologue
    .line 108
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Android "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getBuildVersionRelease()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAppId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getBuildVersionRelease()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    return-object v0
.end method

.method public getCarrier()Ljava/lang/String;
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->telephonyManager:Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDensity()F
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->resources:Landroid/content/res/Resources;

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    return v0
.end method

.method public getDeviceDisplayName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 92
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 93
    .local v0, "deviceDisplayName":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 66
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->telephonyManager:Landroid/telephony/TelephonyManager;

    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 67
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->telephonyManager:Landroid/telephony/TelephonyManager;

    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    .line 76
    :cond_0
    :goto_0
    return-object v0

    .line 70
    :cond_1
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->application:Landroid/app/Application;

    invoke-virtual {v1}, Landroid/app/Application;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "android_id"

    invoke-static {v1, v2}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 71
    .local v0, "deviceId":Ljava/lang/String;
    if-eqz v0, :cond_2

    const-string v1, "0123456789"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 73
    :cond_2
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->application:Landroid/app/Application;

    invoke-static {v1}, Lcom/comcast/cim/cmasl/android/util/system/Installation;->id(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDevicePhysicalSize()I
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->resources:Landroid/content/res/Resources;

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v0, v0, 0xf

    return v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    invoke-static {}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getBrandDeviceAndModelDescription()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLandscapeOrientation()I
    .locals 1

    .prologue
    .line 138
    const/4 v0, 0x6

    return v0
.end method

.method public getPortraitOrientation()I
    .locals 1

    .prologue
    .line 128
    const/4 v0, 0x7

    return v0
.end method

.method public getPropertyOsVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 112
    const-string v0, "os.version"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getScreenWidth()I
    .locals 3

    .prologue
    .line 98
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->resources:Landroid/content/res/Resources;

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 100
    .local v0, "mainDisplayMetrics":Landroid/util/DisplayMetrics;
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v2, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    if-le v1, v2, :cond_0

    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    :goto_0
    return v1

    :cond_0
    iget v1, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    goto :goto_0
.end method

.method public isDebuggable()Z
    .locals 10

    .prologue
    .line 192
    const/4 v2, 0x0

    .line 195
    .local v2, "debuggable":Z
    :try_start_0
    iget-object v7, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->application:Landroid/app/Application;

    invoke-virtual {v7}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v7

    iget-object v8, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->application:Landroid/app/Application;

    invoke-virtual {v8}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v8

    const/16 v9, 0x40

    invoke-virtual {v7, v8, v9}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 196
    .local v4, "pinfo":Landroid/content/pm/PackageInfo;
    iget-object v5, v4, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    .line 198
    .local v5, "signatures":[Landroid/content/pm/Signature;
    const-string v7, "X.509"

    invoke-static {v7}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v1

    .line 200
    .local v1, "cf":Ljava/security/cert/CertificateFactory;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v7, v5

    if-ge v3, v7, :cond_0

    .line 201
    new-instance v6, Ljava/io/ByteArrayInputStream;

    aget-object v7, v5, v3

    invoke-virtual {v7}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 202
    .local v6, "stream":Ljava/io/ByteArrayInputStream;
    invoke-virtual {v1, v6}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v0

    check-cast v0, Ljava/security/cert/X509Certificate;

    .line 203
    .local v0, "cert":Ljava/security/cert/X509Certificate;
    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->getSubjectX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v7

    sget-object v8, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->DEBUG_DN:Ljavax/security/auth/x500/X500Principal;

    invoke-virtual {v7, v8}, Ljavax/security/auth/x500/X500Principal;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/cert/CertificateException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 204
    if-eqz v2, :cond_1

    .line 213
    .end local v0    # "cert":Ljava/security/cert/X509Certificate;
    .end local v1    # "cf":Ljava/security/cert/CertificateFactory;
    .end local v3    # "i":I
    .end local v4    # "pinfo":Landroid/content/pm/PackageInfo;
    .end local v5    # "signatures":[Landroid/content/pm/Signature;
    .end local v6    # "stream":Ljava/io/ByteArrayInputStream;
    :cond_0
    :goto_1
    return v2

    .line 200
    .restart local v0    # "cert":Ljava/security/cert/X509Certificate;
    .restart local v1    # "cf":Ljava/security/cert/CertificateFactory;
    .restart local v3    # "i":I
    .restart local v4    # "pinfo":Landroid/content/pm/PackageInfo;
    .restart local v5    # "signatures":[Landroid/content/pm/Signature;
    .restart local v6    # "stream":Ljava/io/ByteArrayInputStream;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 210
    .end local v0    # "cert":Ljava/security/cert/X509Certificate;
    .end local v1    # "cf":Ljava/security/cert/CertificateFactory;
    .end local v3    # "i":I
    .end local v4    # "pinfo":Landroid/content/pm/PackageInfo;
    .end local v5    # "signatures":[Landroid/content/pm/Signature;
    .end local v6    # "stream":Ljava/io/ByteArrayInputStream;
    :catch_0
    move-exception v7

    goto :goto_1

    .line 208
    :catch_1
    move-exception v7

    goto :goto_1
.end method

.method public isKindle()Z
    .locals 2

    .prologue
    .line 166
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    const-string v1, "amazon"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public isKindleOrFromAmazonStore()Z
    .locals 4

    .prologue
    .line 155
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindle()Z

    move-result v1

    .line 157
    .local v1, "isAmazon":Z
    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->application:Landroid/app/Application;

    invoke-virtual {v2}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->application:Landroid/app/Application;

    invoke-virtual {v3}, Landroid/app/Application;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/pm/PackageManager;->getInstallerPackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 158
    .local v0, "installerName":Ljava/lang/String;
    if-nez v1, :cond_0

    if-eqz v0, :cond_0

    .line 159
    const-string v2, "com.amazon.venezia"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    .line 162
    :cond_0
    return v1
.end method

.method public isTabletDevice()Z
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->resources:Landroid/content/res/Resources;

    sget v1, Lcom/comcast/cim/cmasl/android/util/R$bool;->isTablet:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v0

    return v0
.end method

.method public wantsStaticBitrate()Z
    .locals 2

    .prologue
    .line 173
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "KFJWI"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "KFJWA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    const-string v1, "Transformer TF101"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
