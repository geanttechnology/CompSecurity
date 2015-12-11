.class public abstract Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;
.super Ljava/lang/Object;
.source "AnalyticsEventBuilder.java"

# interfaces
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$AppAsinView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$AppVersionView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$BaseAnalyticsBuilder;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$ContentIdView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$FinallyRecord;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$MASVersionView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$MarketplaceIdView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$PackageNameView;
.implements Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$TimestampView;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;
    }
.end annotation


# static fields
.field private static final eventTypeMapping:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<+",
            "Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;",
            ">;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field appAsin:Ljava/lang/String;

.field appVersion:Ljava/lang/String;

.field config:Lcom/amazon/analytics/AnalyticsConfiguration;

.field contentId:Ljava/lang/String;

.field execService:Ljava/util/concurrent/ExecutorService;

.field initializer:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

.field marketplaceId:Ljava/lang/String;

.field masVersion:Ljava/lang/String;

.field packageName:Ljava/lang/String;

.field queue:Lcom/amazon/analytics/session/PriorityQueue;

.field recorder:Lcom/amazon/device/analytics/events/EventRecorder;

.field timestamp:J


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 55
    const-class v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;

    invoke-static {v1}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v1

    sput-object v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 60
    .local v0, "buildingTypeMapping":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Class<+Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;>;Ljava/lang/String;>;"
    const-class v1, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$InstallBuilder;

    const-string/jumbo v2, "com.amazon.developer.app.install"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 61
    const-class v1, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UninstallBuilder;

    const-string/jumbo v2, "com.amazon.developer.app.uninstall"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    const-class v1, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UpgradeBuilder;

    const-string/jumbo v2, "com.amazon.developer.app.upgrade"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    const-class v1, Lcom/amazon/analytics/eventbuilder/IAPEventTypeBuilder$IAPBuilder;

    const-string/jumbo v2, "com.amazon.developer.app.iap"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    const-class v1, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnResumeBuilder;

    const-string/jumbo v2, "com.amazon.analytics.session.start"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    const-class v1, Lcom/amazon/analytics/eventbuilder/SessionEventTypeBuilder$OnPauseBuilder;

    const-string/jumbo v2, "com.amazon.analytics.session.stop"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 67
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v1

    sput-object v1, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->eventTypeMapping:Ljava/util/Map;

    .line 68
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    return-void
.end method


# virtual methods
.method abstract getType()Ljava/lang/String;
.end method

.method processEvent(Lcom/amazon/device/analytics/events/Event;)V
    .locals 3
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 199
    iget-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->recorder:Lcom/amazon/device/analytics/events/EventRecorder;

    invoke-interface {v0, p1}, Lcom/amazon/device/analytics/events/EventRecorder;->recordEvent(Lcom/amazon/device/analytics/events/Event;)V

    .line 200
    sget-object v0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "EventRecorder recording event with type "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/analytics/log/Logger;->d(Ljava/lang/String;)V

    .line 201
    return-void
.end method

.method public final record()V
    .locals 6

    .prologue
    .line 148
    invoke-static {p0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint;->inject(Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;)V

    .line 150
    iget-object v3, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    sget-object v4, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->Enabled:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-interface {v3, v4}, Lcom/amazon/analytics/AnalyticsConfiguration;->getBoolean(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 151
    const-string/jumbo v3, "tailwind.enable"

    invoke-static {v3}, Lcom/amazon/device/analytics/util/StringUtil;->getSysProp(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 152
    .local v1, "debugSwitch":Ljava/lang/String;
    const-string/jumbo v3, "TRUE"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 153
    sget-object v3, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v4, "Global switch is off, don\'t use any event collection"

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/log/Logger;->w(Ljava/lang/String;)V

    .line 175
    .end local v1    # "debugSwitch":Ljava/lang/String;
    :goto_0
    return-void

    .line 158
    :cond_0
    iget-object v3, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->config:Lcom/amazon/analytics/AnalyticsConfiguration;

    sget-object v4, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->NeverCollectForPackageNames:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-interface {v3, v4}, Lcom/amazon/analytics/AnalyticsConfiguration;->getCommaDelimitedStringList(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)Ljava/util/List;

    move-result-object v0

    .line 159
    .local v0, "blacklistedPackages":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->packageName:Ljava/lang/String;

    invoke-interface {v0, v3}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 160
    sget-object v3, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Not collecting event for blacklisted package "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/log/Logger;->w(Ljava/lang/String;)V

    goto :goto_0

    .line 164
    :cond_1
    iget-object v3, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->initializer:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    invoke-virtual {v3}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->init()V

    .line 166
    iget-object v4, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->recorder:Lcom/amazon/device/analytics/events/EventRecorder;

    sget-object v3, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->eventTypeMapping:Ljava/util/Map;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v4, v3}, Lcom/amazon/device/analytics/events/EventRecorder;->createEvent(Ljava/lang/String;)Lcom/amazon/device/analytics/events/Event;

    move-result-object v2

    .line 167
    .local v2, "event":Lcom/amazon/device/analytics/events/Event;
    invoke-virtual {p0, v2}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V

    .line 169
    iget-object v3, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->execService:Ljava/util/concurrent/ExecutorService;

    new-instance v4, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$1;

    invoke-direct {v4, p0, v2}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder$1;-><init>(Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;Lcom/amazon/device/analytics/events/Event;)V

    invoke-interface {v3, v4}, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V
    .locals 3
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 178
    const-string/jumbo v0, "os"

    sget-object v1, Landroid/os/Build$VERSION;->CODENAME:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    const-string/jumbo v0, "ov"

    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    const-string/jumbo v0, "mo"

    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 181
    const-string/jumbo v0, "bo"

    sget-object v1, Landroid/os/Build;->BOARD:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    const-string/jumbo v0, "br"

    sget-object v1, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    const-string/jumbo v0, "ma"

    sget-object v1, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    const-string/jumbo v0, "cp"

    sget-object v1, Landroid/os/Build;->CPU_ABI:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    const-string/jumbo v0, "pr"

    sget-object v1, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    const-string/jumbo v0, "pn"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->packageName:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    const-string/jumbo v0, "masver"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->masVersion:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 189
    const-string/jumbo v0, "aa"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->appAsin:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 190
    const-string/jumbo v0, "av"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->appVersion:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    const-string/jumbo v0, "ci"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->contentId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    const-string/jumbo v0, "mp"

    iget-object v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->marketplaceId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 193
    const-string/jumbo v0, "TimeStamp"

    iget-wide v1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->timestamp:J

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/amazon/device/analytics/events/Event;->addMetric(Ljava/lang/String;Ljava/lang/Number;)V

    .line 194
    return-void
.end method

.method public withAppAsin(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$AppVersionView;
    .locals 1
    .param p1, "appAsin"    # Ljava/lang/String;

    .prologue
    .line 98
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->appAsin:Ljava/lang/String;

    .line 99
    return-object p0
.end method

.method public withAppVersion(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$ContentIdView;
    .locals 1
    .param p1, "appVersion"    # Ljava/lang/String;

    .prologue
    .line 104
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->appVersion:Ljava/lang/String;

    .line 105
    return-object p0
.end method

.method public withContentId(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$MarketplaceIdView;
    .locals 1
    .param p1, "contentId"    # Ljava/lang/String;

    .prologue
    .line 110
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->contentId:Ljava/lang/String;

    .line 111
    return-object p0
.end method

.method public withMASVersion(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$AppAsinView;
    .locals 1
    .param p1, "masVersion"    # Ljava/lang/String;

    .prologue
    .line 92
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->masVersion:Ljava/lang/String;

    .line 93
    return-object p0
.end method

.method public withMarketplaceId(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$TimestampView;
    .locals 1
    .param p1, "marketplaceId"    # Ljava/lang/String;

    .prologue
    .line 116
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->marketplaceId:Ljava/lang/String;

    .line 117
    return-object p0
.end method

.method public withPackageName(Ljava/lang/String;)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$MASVersionView;
    .locals 1
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-static {p1}, Lcom/amazon/analytics/util/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->packageName:Ljava/lang/String;

    .line 87
    return-object p0
.end method

.method public withTimestamp(J)Lcom/amazon/analytics/eventbuilder/AnalyticsBuilderInterfaces$FinallyRecord;
    .locals 0
    .param p1, "timestamp"    # J

    .prologue
    .line 122
    iput-wide p1, p0, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->timestamp:J

    .line 123
    return-object p0
.end method
