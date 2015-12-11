.class public Lcom/amazon/device/crashmanager/AmazonPackageLookup;
.super Ljava/lang/Object;
.source "AmazonPackageLookup.java"


# static fields
.field private static final PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;
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

.field public static final SYSTEM_PACKAGES:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mMyPackageName:Ljava/lang/String;

.field private final mPackageManager:Landroid/content/pm/PackageManager;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 21
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "AmazonPackageLookup"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->log:Lcom/amazon/dp/logger/DPLogger;

    .line 27
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->SYSTEM_PACKAGES:Ljava/util/Set;

    .line 29
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->SYSTEM_PACKAGES:Ljava/util/Set;

    const-string/jumbo v1, "system_server"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 30
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->SYSTEM_PACKAGES:Ljava/util/Set;

    const-string/jumbo v1, "zygote"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 31
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->SYSTEM_PACKAGES:Ljava/util/Set;

    const-string/jumbo v1, "ath6kl"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 36
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    .line 39
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.adc"

    const-string/jumbo v2, "ADC"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.venezia"

    const-string/jumbo v2, "AmazonAppStore"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.avod"

    const-string/jumbo v2, "AmazonVideo"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.mp3"

    const-string/jumbo v2, "AmazonMp3"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.imdb.mobile"

    const-string/jumbo v2, "IMDB"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.kindle"

    const-string/jumbo v2, "Kindle"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.dcp"

    const-string/jumbo v2, "DCP"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.kindle.otter"

    const-string/jumbo v2, "Launcher"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 47
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.lab126.otter"

    const-string/jumbo v2, "QuickSettings"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 48
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.gardemanger"

    const-string/jumbo v2, "AppManager"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.kindle.otter.oobe"

    const-string/jumbo v2, "OOBE"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.otter.tutorial"

    const-string/jumbo v2, "Tutorial"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.kindle.otter.settings"

    const-string/jumbo v2, "Settings"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.csapp"

    const-string/jumbo v2, "CSApp"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.windowshop"

    const-string/jumbo v2, "Shop"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.cloud9"

    const-string/jumbo v2, "Silk"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.cloud9[AdobeFlash]"

    const-string/jumbo v2, "SilkFlash"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.cloud9[WebKit]"

    const-string/jumbo v2, "SilkWebkit"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.alphonso.pulse"

    const-string/jumbo v2, "Pulse"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.email"

    const-string/jumbo v2, "Email"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.kindle.facebook"

    const-string/jumbo v2, "Facebook"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "system_server"

    const-string/jumbo v2, "SystemServer"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "/system/bin/mediaserver"

    const-string/jumbo v2, "MediaServer"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.android.calendar"

    const-string/jumbo v2, "com.android.calendar"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.android.contacts"

    const-string/jumbo v2, "com.android.contacts"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.android.email"

    const-string/jumbo v2, "com.android.email"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.android.exchange"

    const-string/jumbo v2, "com.android.exchange"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.android.providers.contacts"

    const-string/jumbo v2, "com.android.providers.contacts"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.android.systemui"

    const-string/jumbo v2, "com.android.systemui"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    sget-object v0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->PACKAGE_NAME_TO_FRIENDLY_NAME:Ljava/util/Map;

    const-string/jumbo v1, "com.amazon.kindle.unifiedSearch"

    const-string/jumbo v2, "com.amazon.kindle.unifiedSearch"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    if-nez p1, :cond_0

    .line 80
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 82
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->mPackageManager:Landroid/content/pm/PackageManager;

    .line 83
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->mMyPackageName:Ljava/lang/String;

    .line 84
    return-void
.end method

.method private canonicalizePackageName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 178
    if-nez p1, :cond_1

    .line 188
    .end local p1    # "packageName":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object p1

    .line 182
    .restart local p1    # "packageName":Ljava/lang/String;
    :cond_1
    const-string/jumbo v1, ":"

    invoke-virtual {p1, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 183
    const-string/jumbo v1, ":"

    invoke-virtual {p1, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 184
    .local v0, "tokenizedPackageName":[Ljava/lang/String;
    array-length v1, v0

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    .line 185
    const/4 v1, 0x0

    aget-object p1, v0, v1

    goto :goto_0
.end method

.method private getUidForPackage(Ljava/lang/String;)I
    .locals 3
    .param p1, "packageName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/content/pm/PackageManager$NameNotFoundException;
        }
    .end annotation

    .prologue
    .line 163
    iget-object v1, p0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->mPackageManager:Landroid/content/pm/PackageManager;

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 164
    .local v0, "appInfo":Landroid/content/pm/ApplicationInfo;
    if-nez v0, :cond_0

    .line 165
    new-instance v1, Landroid/content/pm/PackageManager$NameNotFoundException;

    invoke-direct {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;-><init>()V

    throw v1

    .line 168
    :cond_0
    iget v1, v0, Landroid/content/pm/ApplicationInfo;->uid:I

    return v1
.end method


# virtual methods
.method public generateFriendlyName(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 155
    invoke-virtual {p0, p1}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->isTrustedPackage(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    .end local p1    # "packageName":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "packageName":Ljava/lang/String;
    :cond_0
    const-string/jumbo p1, "ThirdPartyApp"

    goto :goto_0
.end method

.method public isAmazonPackage(Ljava/lang/String;)Z
    .locals 4
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 114
    if-nez p1, :cond_1

    .line 119
    :cond_0
    :goto_0
    return v1

    .line 118
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->canonicalizePackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 119
    .local v0, "canonicalPackageName":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->mPackageManager:Landroid/content/pm/PackageManager;

    iget-object v3, p0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->mMyPackageName:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Landroid/content/pm/PackageManager;->checkSignatures(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isSystemPackage(Ljava/lang/String;)Z
    .locals 9
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 126
    if-nez p1, :cond_0

    .line 145
    :goto_0
    return v5

    .line 132
    :cond_0
    const-string/jumbo v6, "/system/"

    invoke-virtual {p1, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    sget-object v6, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->SYSTEM_PACKAGES:Ljava/util/Set;

    invoke-interface {v6, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    :cond_1
    move v5, v4

    .line 133
    goto :goto_0

    .line 137
    :cond_2
    const/16 v3, 0x3e8

    .line 139
    .local v3, "systemUid":I
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->canonicalizePackageName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 140
    .local v0, "canonicalPackageName":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->getUidForPackage(Ljava/lang/String;)I

    move-result v2

    .line 142
    .local v2, "packageUid":I
    iget-object v6, p0, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->mPackageManager:Landroid/content/pm/PackageManager;

    const/16 v7, 0x3e8

    invoke-virtual {v6, v7, v2}, Landroid/content/pm/PackageManager;->checkSignatures(II)I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    if-nez v6, :cond_3

    :goto_1
    move v5, v4

    goto :goto_0

    :cond_3
    move v4, v5

    goto :goto_1

    .line 143
    .end local v0    # "canonicalPackageName":Ljava/lang/String;
    .end local v2    # "packageUid":I
    :catch_0
    move-exception v1

    .line 144
    .local v1, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    sget-object v4, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v6, "isSystemPackage"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Name not found for package: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    new-array v8, v5, [Ljava/lang/Object;

    invoke-virtual {v4, v6, v7, v8}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public isTrustedPackage(Ljava/lang/String;)Z
    .locals 1
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 107
    invoke-virtual {p0, p1}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->isAmazonPackage(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0, p1}, Lcom/amazon/device/crashmanager/AmazonPackageLookup;->isSystemPackage(Ljava/lang/String;)Z

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
