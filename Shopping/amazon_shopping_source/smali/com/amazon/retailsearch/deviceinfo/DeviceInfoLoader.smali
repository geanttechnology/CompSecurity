.class public Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
.super Ljava/lang/Object;
.source "DeviceInfoLoader.java"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "UseSparseArrays"
    }
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$1;,
        Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField;,
        Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;
    }
.end annotation


# static fields
.field public static final CONFIGURATION_SCREENLAYOUT_SIZE_XLARGE:I = 0x4

.field public static final DEFAULT_DELAY:I = 0x2ee

.field public static final TELEPHONY_PHONE_TYPE_SIP:I = 0x3

.field private static final THIRD_PARTY_ANDROID:Ljava/lang/String; = "A1MPSLFC7L5AFK"

.field private static volatile loader:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;

.field private static final phoneTypes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final screenFamilies:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private volatile deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

.field private updateLock:Ljava/lang/Object;

.field private version:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x4

    .line 48
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, v3}, Ljava/util/HashMap;-><init>(I)V

    .line 49
    .local v0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Ljava/lang/String;>;"
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "PHONE_TYPE_NONE"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "PHONE_TYPE_GSM"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "PHONE_TYPE_CDMA"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "PHONE_TYPE_SIP"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    sput-object v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->phoneTypes:Ljava/util/Map;

    .line 63
    new-instance v0, Ljava/util/HashMap;

    .end local v0    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Ljava/lang/String;>;"
    invoke-direct {v0, v3}, Ljava/util/HashMap;-><init>(I)V

    .line 64
    .restart local v0    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/Integer;Ljava/lang/String;>;"
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "SCREENLAYOUT_SIZE_XLARGE"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "SCREENLAYOUT_SIZE_LARGE"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "SCREENLAYOUT_SIZE_NORMAL"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    const-string/jumbo v2, "SCREENLAYOUT_SIZE_SMALL"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    sput-object v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->screenFamilies:Ljava/util/Map;

    .line 71
    const-class v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    invoke-static {v1}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v1

    sput-object v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .line 33
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->version:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 34
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->updateLock:Ljava/lang/Object;

    .line 417
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;)Ljava/util/concurrent/atomic/AtomicInteger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->version:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object v0
.end method

.method static synthetic access$100()Lcom/amazon/retailsearch/log/MessageLogger;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-object v0
.end method

.method static synthetic access$200(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .locals 1
    .param p0, "x0"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-static {p0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->createDefaultDeviceInfo(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->updateLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$402(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
    .param p1, "x1"    # Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    return-object p1
.end method

.method private static createDefaultDeviceInfo(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 168
    new-instance v0, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    invoke-direct {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;-><init>()V

    .line 172
    .local v0, "dib":Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    :try_start_0
    invoke-static {p0}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getSimOperatorName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setCarrier(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 179
    :goto_0
    sget-object v3, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setManufacturer(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .line 180
    sget-object v3, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setModel(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .line 181
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getDefaultDeviceType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setDeviceType(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .line 182
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setOsVersion(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .line 186
    :try_start_1
    invoke-static {p0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getDisplayMetrics(Landroid/content/Context;)Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 188
    .local v1, "displayMetrics":Landroid/util/DisplayMetrics;
    if-eqz v1, :cond_0

    .line 190
    iget v3, v1, Landroid/util/DisplayMetrics;->densityDpi:I

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setDeviceDensityClassification(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 200
    .end local v1    # "displayMetrics":Landroid/util/DisplayMetrics;
    :cond_0
    :goto_1
    :try_start_2
    invoke-static {p0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->getScreenFamily(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setDeviceScreenLayout(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 207
    :goto_2
    invoke-static {}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getSerial()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setSerial(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .line 208
    sget-object v3, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setBuildProduct(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .line 209
    sget-object v3, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setBuildFingerprint(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;

    .line 213
    :try_start_3
    invoke-static {p0}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getSimOperator(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setSimOperator(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 222
    :goto_3
    :try_start_4
    sget-object v3, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->phoneTypes:Ljava/util/Map;

    invoke-static {p0}, Lcom/amazon/retailsearch/deviceinfo/DeviceProfile;->getPhoneType(Landroid/content/Context;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {v0, v3}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->setPhoneType(Ljava/lang/String;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 229
    :goto_4
    invoke-virtual {v0}, Lcom/amazon/searchapp/retailsearch/client/DeviceInformation$Builder;->build()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    move-result-object v3

    return-object v3

    .line 174
    :catch_0
    move-exception v2

    .line 176
    .local v2, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "SIM operator name"

    invoke-interface {v3, v4, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 193
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v2

    .line 195
    .restart local v2    # "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "Density classification"

    invoke-interface {v3, v4, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 202
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v2

    .line 204
    .restart local v2    # "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "Screen layout"

    invoke-interface {v3, v4, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2

    .line 215
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v2

    .line 217
    .restart local v2    # "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "SIM operator"

    invoke-interface {v3, v4, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 224
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_4
    move-exception v2

    .line 226
    .restart local v2    # "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "Phone type"

    invoke-interface {v3, v4, v2}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_4
.end method

.method private static getDefaultDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 234
    const-string/jumbo v0, "A1MPSLFC7L5AFK"

    return-object v0
.end method

.method private static getDisplayMetrics(Landroid/content/Context;)Landroid/util/DisplayMetrics;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 239
    const-string/jumbo v2, "window"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .line 240
    .local v1, "windowManager":Landroid/view/WindowManager;
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 241
    .local v0, "metrics":Landroid/util/DisplayMetrics;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 242
    return-object v0
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
    .locals 2

    .prologue
    .line 75
    const-class v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->loader:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    if-nez v0, :cond_0

    .line 77
    new-instance v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    invoke-direct {v0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->loader:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;

    .line 80
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->loader:Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 75
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private static getScreenFamily(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 247
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    iget v1, v1, Landroid/content/res/Configuration;->screenLayout:I

    and-int/lit8 v0, v1, 0xf

    .line 249
    .local v0, "size":I
    sget-object v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->screenFamilies:Ljava/util/Map;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    return-object v1
.end method


# virtual methods
.method public getDeviceInfo()Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    return-object v0
.end method

.method public load(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 110
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->load(Landroid/content/Context;I)V

    .line 111
    return-void
.end method

.method public load(Landroid/content/Context;I)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "delay"    # I

    .prologue
    .line 117
    :try_start_0
    new-instance v2, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;

    invoke-direct {v2, p0, p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;-><init>(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;Landroid/content/Context;)V

    .line 118
    .local v2, "task":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;
    new-instance v1, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const/4 v3, 0x1

    invoke-direct {v1, v3}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;-><init>(I)V

    .line 119
    .local v1, "executor":Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    int-to-long v3, p2

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4, v5}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 125
    .end local v1    # "executor":Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    .end local v2    # "task":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;
    :goto_0
    return-void

    .line 121
    :catch_0
    move-exception v0

    .line 123
    .local v0, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v4, "Device info load"

    invoke-interface {v3, v4, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public loadDefaults(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 90
    const/4 v0, 0x0

    .line 94
    .local v0, "di":Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    :try_start_0
    invoke-static {p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->createDefaultDeviceInfo(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 102
    iput-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .line 105
    :goto_0
    return-object v0

    .line 96
    :catch_0
    move-exception v1

    .line 98
    .local v1, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v2, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v3, "Default device info"

    invoke-interface {v2, v3, v1}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 102
    iput-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    goto :goto_0

    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    iput-object v0, p0, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->deviceInfo:Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    throw v2
.end method

.method public loadSync(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 151
    :try_start_0
    new-instance v1, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;

    invoke-direct {v1, p0, p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;-><init>(Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;Landroid/content/Context;)V

    .line 152
    .local v1, "task":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;
    invoke-virtual {v1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;->run()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 158
    .end local v1    # "task":Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader$DeviceInfoTask;
    :goto_0
    return-void

    .line 154
    :catch_0
    move-exception v0

    .line 156
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v3, "Device info load"

    invoke-interface {v2, v3, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public refresh(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 132
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->refresh(Landroid/content/Context;I)V

    .line 133
    return-void
.end method

.method public refresh(Landroid/content/Context;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "delay"    # I

    .prologue
    .line 140
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->loadDefaults(Landroid/content/Context;)Lcom/amazon/searchapp/retailsearch/client/DeviceInformation;

    .line 141
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/deviceinfo/DeviceInfoLoader;->load(Landroid/content/Context;I)V

    .line 142
    return-void
.end method
