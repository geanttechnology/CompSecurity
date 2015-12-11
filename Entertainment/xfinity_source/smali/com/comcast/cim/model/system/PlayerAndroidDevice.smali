.class public Lcom/comcast/cim/model/system/PlayerAndroidDevice;
.super Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
.source "PlayerAndroidDevice.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/app/Application;Landroid/content/res/Resources;Landroid/telephony/TelephonyManager;Ljava/lang/String;)V
    .locals 0
    .param p1, "application"    # Landroid/app/Application;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "telephonyManager"    # Landroid/telephony/TelephonyManager;
    .param p4, "appId"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;-><init>(Landroid/app/Application;Landroid/content/res/Resources;Landroid/telephony/TelephonyManager;Ljava/lang/String;)V

    .line 21
    return-void
.end method


# virtual methods
.method public hasCellularCapability()Z
    .locals 2

    .prologue
    .line 24
    iget-object v1, p0, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->application:Landroid/app/Application;

    invoke-virtual {v1}, Landroid/app/Application;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 25
    .local v0, "pm":Landroid/content/pm/PackageManager;
    const-string v1, "android.hardware.telephony"

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "com.verizon.hardware.telephony.lte"

    .line 26
    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "com.verizon.hardware.telephony.ehrpd"

    .line 27
    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "com.vzw.hardware.lte"

    .line 28
    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "com.vzw.hardware.ehrpd"

    .line 29
    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->hasSystemFeature(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 30
    :cond_0
    const/4 v1, 0x1

    .line 33
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
