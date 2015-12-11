.class Lcom/amazon/device/ads/AdUtils;
.super Ljava/lang/Object;
.source "AdUtils.java"


# static fields
.field public static final LOG_TAG:Ljava/lang/String;

.field public static final REQUIRED_ACTIVITY:Ljava/lang/String; = "com.amazon.device.ads.AdActivity"

.field private static final requiredActivities:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 27
    const-class v0, Lcom/amazon/device/ads/AdUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/AdUtils;->LOG_TAG:Ljava/lang/String;

    .line 34
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/AdUtils;->requiredActivities:Ljava/util/HashSet;

    .line 35
    sget-object v0, Lcom/amazon/device/ads/AdUtils;->requiredActivities:Ljava/util/HashSet;

    const-string/jumbo v1, "com.amazon.device.ads.AdActivity"

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 36
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkDefinedActivities(Landroid/content/Context;)Z
    .locals 10
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v8, 0x1

    .line 104
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 111
    .local v1, "activities":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    const/16 v9, 0x8

    :try_start_0
    invoke-static {v9}, Lcom/amazon/device/ads/Utils;->isAtLeastAndroidAPI(I)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 113
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils;->getPackageCodePath(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    .line 115
    .local v7, "path":Ljava/lang/String;
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 116
    .local v6, "pManager":Landroid/content/pm/PackageManager;
    const/4 v9, 0x1

    invoke-virtual {v6, v7, v9}, Landroid/content/pm/PackageManager;->getPackageArchiveInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v4

    .line 117
    .local v4, "info":Landroid/content/pm/PackageInfo;
    iget-object v2, v4, Landroid/content/pm/PackageInfo;->activities:[Landroid/content/pm/ActivityInfo;

    .local v2, "arr$":[Landroid/content/pm/ActivityInfo;
    array-length v5, v2

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v5, :cond_0

    aget-object v0, v2, v3

    .line 118
    .local v0, "a":Landroid/content/pm/ActivityInfo;
    iget-object v9, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v1, v9}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 117
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 120
    .end local v0    # "a":Landroid/content/pm/ActivityInfo;
    :cond_0
    sget-object v9, Lcom/amazon/device/ads/AdUtils;->requiredActivities:Ljava/util/HashSet;

    invoke-virtual {v1, v9}, Ljava/util/HashSet;->containsAll(Ljava/util/Collection;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v8

    .line 128
    .end local v2    # "arr$":[Landroid/content/pm/ActivityInfo;
    .end local v3    # "i$":I
    .end local v4    # "info":Landroid/content/pm/PackageInfo;
    .end local v5    # "len$":I
    .end local v6    # "pManager":Landroid/content/pm/PackageManager;
    .end local v7    # "path":Ljava/lang/String;
    :cond_1
    :goto_1
    return v8

    .line 123
    :catch_0
    move-exception v9

    goto :goto_1
.end method

.method public static encloseHtml(Ljava/lang/String;Z)Ljava/lang/String;
    .locals 3
    .param p0, "html"    # Ljava/lang/String;
    .param p1, "isHTML5"    # Z

    .prologue
    const/4 v2, -0x1

    .line 82
    if-eqz p0, :cond_1

    .line 84
    const-string/jumbo v0, "<html>"

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 86
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "<html>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "</html>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 88
    :cond_0
    if-eqz p1, :cond_1

    const-string/jumbo v0, "<!DOCTYPE html>"

    invoke-virtual {p0, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    if-ne v0, v2, :cond_1

    .line 90
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "<!DOCTYPE html>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p0

    .line 93
    :cond_1
    return-object p0
.end method

.method public static getViewportInitialScale(D)D
    .locals 1
    .param p0, "defaultScale"    # D

    .prologue
    .line 163
    const/16 v0, 0x13

    invoke-static {v0}, Lcom/amazon/device/ads/Utils;->isAtLeastAndroidAPI(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const-wide/high16 p0, 0x3ff0000000000000L    # 1.0

    .end local p0    # "defaultScale":D
    :cond_0
    return-wide p0
.end method

.method public static launchActivityForIntentLink(Ljava/lang/String;Landroid/content/Context;)Z
    .locals 9
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 52
    if-eqz p0, :cond_0

    const-string/jumbo v3, ""

    invoke-virtual {p0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 54
    :cond_0
    const-string/jumbo p0, "about:blank"

    .line 56
    :cond_1
    sget-object v3, Lcom/amazon/device/ads/AdUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Launch Intent: %s"

    new-array v7, v4, [Ljava/lang/Object;

    aput-object p0, v7, v5

    invoke-static {v3, v6, v7}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 57
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v3, "android.intent.action.VIEW"

    invoke-static {p0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    invoke-direct {v1, v3, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 58
    .local v1, "actionIntent":Landroid/content/Intent;
    const/high16 v3, 0x10000000

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 61
    :try_start_0
    invoke-virtual {p1, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move v3, v4

    .line 70
    :goto_0
    return v3

    .line 64
    :catch_0
    move-exception v2

    .line 66
    .local v2, "e":Landroid/content/ActivityNotFoundException;
    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "action":Ljava/lang/String;
    sget-object v6, Lcom/amazon/device/ads/AdUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v7, "Could not handle %s action: %s"

    const/4 v3, 0x2

    new-array v8, v3, [Ljava/lang/Object;

    const-string/jumbo v3, "market://"

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    const-string/jumbo v3, "market"

    :goto_1
    aput-object v3, v8, v5

    aput-object v0, v8, v4

    invoke-static {v6, v7, v8}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    move v3, v5

    .line 70
    goto :goto_0

    .line 67
    :cond_2
    const-string/jumbo v3, "intent"

    goto :goto_1
.end method

.method public static setConnectionMetrics(Lcom/amazon/device/ads/AdData;)V
    .locals 5
    .param p0, "adData"    # Lcom/amazon/device/ads/AdData;

    .prologue
    .line 136
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdData;->getConnectionType()Ljava/lang/String;

    move-result-object v0

    .line 137
    .local v0, "connectionType":Ljava/lang/String;
    const-string/jumbo v2, "Wifi"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 139
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->WIFI_PRESENT:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3}, Lcom/amazon/device/ads/MetricsCollector;->incrementMetric(Lcom/amazon/device/ads/Metrics$MetricType;)V

    .line 146
    :goto_0
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/device/ads/IInternalAdRegistration;->getDeviceInfo()Lcom/amazon/device/ads/DeviceInfo;

    move-result-object v1

    .line 147
    .local v1, "deviceInfo":Lcom/amazon/device/ads/DeviceInfo;
    invoke-virtual {v1}, Lcom/amazon/device/ads/DeviceInfo;->getCarrier()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 149
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->CARRIER_NAME:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v1}, Lcom/amazon/device/ads/DeviceInfo;->getCarrier()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/amazon/device/ads/MetricsCollector;->setMetricString(Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/String;)V

    .line 151
    :cond_0
    return-void

    .line 143
    .end local v1    # "deviceInfo":Lcom/amazon/device/ads/DeviceInfo;
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/AdData;->getMetricsCollector()Lcom/amazon/device/ads/MetricsCollector;

    move-result-object v2

    sget-object v3, Lcom/amazon/device/ads/Metrics$MetricType;->CONNECTION_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v2, v3, v0}, Lcom/amazon/device/ads/MetricsCollector;->setMetricString(Lcom/amazon/device/ads/Metrics$MetricType;Ljava/lang/String;)V

    goto :goto_0
.end method
