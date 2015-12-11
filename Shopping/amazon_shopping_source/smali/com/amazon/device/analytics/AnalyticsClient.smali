.class public final Lcom/amazon/device/analytics/AnalyticsClient;
.super Ljava/lang/Object;
.source "AnalyticsClient.java"

# interfaces
.implements Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;


# static fields
.field public static final PREFS_NAME:Ljava/lang/String;

.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private config:Lcom/amazon/device/analytics/configuration/Configuration;

.field private context:Landroid/content/Context;

.field private measurementManager:Lcom/amazon/sdk/availability/MeasurementManager;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 25
    const-class v0, Lcom/amazon/device/analytics/AnalyticsClient;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/AnalyticsClient;->logger:Lcom/amazon/device/analytics/log/Logger;

    .line 27
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-class v1, Lcom/amazon/device/analytics/AnalyticsClient;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".configuration"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/AnalyticsClient;->PREFS_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    if-eqz p1, :cond_1

    .line 58
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/device/analytics/AnalyticsClient;->context:Landroid/content/Context;

    .line 60
    if-nez p2, :cond_0

    .line 61
    new-instance p2, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    .end local p2    # "config":Lcom/amazon/device/analytics/configuration/Configuration;
    invoke-direct {p2}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;-><init>()V

    .line 63
    .restart local p2    # "config":Lcom/amazon/device/analytics/configuration/Configuration;
    :cond_0
    iput-object p2, p0, Lcom/amazon/device/analytics/AnalyticsClient;->config:Lcom/amazon/device/analytics/configuration/Configuration;

    .line 65
    iget-object v1, p0, Lcom/amazon/device/analytics/AnalyticsClient;->context:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/device/analytics/events/UniqueIdService;->initialize(Landroid/content/Context;)V

    .line 67
    iget-object v1, p0, Lcom/amazon/device/analytics/AnalyticsClient;->config:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-static {v1}, Lcom/amazon/device/analytics/log/Logging;->setConfiguration(Lcom/amazon/device/analytics/configuration/Configuration;)V

    .line 69
    iget-object v1, p0, Lcom/amazon/device/analytics/AnalyticsClient;->config:Lcom/amazon/device/analytics/configuration/Configuration;

    const-string/jumbo v2, "useAvailabilityLogAppender"

    invoke-interface {v1, v2, p0}, Lcom/amazon/device/analytics/configuration/Configuration;->registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 70
    const-string/jumbo v1, "useAvailabilityLogAppender"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {p2, v1, v2}, Lcom/amazon/device/analytics/configuration/Configuration;->optBoolean(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 71
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;

    iget-object v1, p0, Lcom/amazon/device/analytics/AnalyticsClient;->config:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-direct {v0, p1, v1}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;-><init>(Landroid/content/Context;Lcom/amazon/device/analytics/configuration/Configuration;)V

    .line 72
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->attachLogAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V

    .line 75
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    :cond_1
    return-void
.end method

.method public static newInstance(Landroid/content/Context;Lcom/amazon/device/analytics/configuration/Configuration;)Lcom/amazon/device/analytics/AnalyticsClient;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 49
    new-instance v0, Lcom/amazon/device/analytics/AnalyticsClient;

    invoke-direct {v0, p0, p1}, Lcom/amazon/device/analytics/AnalyticsClient;-><init>(Landroid/content/Context;Lcom/amazon/device/analytics/configuration/Configuration;)V

    return-object v0
.end method


# virtual methods
.method public newEventRecorder(Ljava/lang/String;)Lcom/amazon/device/analytics/events/EventRecorder;
    .locals 6
    .param p1, "applicationKey"    # Ljava/lang/String;

    .prologue
    .line 83
    new-instance v2, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;

    invoke-direct {v2}, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;-><init>()V

    invoke-virtual {v2, p1}, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->withApplicationKey(Ljava/lang/String;)Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;

    move-result-object v0

    .line 86
    .local v0, "builder":Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;
    iget-object v2, p0, Lcom/amazon/device/analytics/AnalyticsClient;->context:Landroid/content/Context;

    if-eqz v2, :cond_0

    .line 87
    invoke-static {}, Lcom/amazon/sdk/availability/MeasurementManagerFactory;->getMeasurementManager()Lcom/amazon/sdk/availability/MeasurementManager;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/device/analytics/AnalyticsClient;->measurementManager:Lcom/amazon/sdk/availability/MeasurementManager;

    .line 88
    new-instance v2, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;

    iget-object v3, p0, Lcom/amazon/device/analytics/AnalyticsClient;->context:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/device/analytics/AnalyticsClient;->measurementManager:Lcom/amazon/sdk/availability/MeasurementManager;

    iget-object v5, p0, Lcom/amazon/device/analytics/AnalyticsClient;->config:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-direct {v2, v3, v4, v5}, Lcom/amazon/device/analytics/events/observers/MeasurementManagerObserver;-><init>(Landroid/content/Context;Lcom/amazon/sdk/availability/MeasurementManager;Lcom/amazon/device/analytics/configuration/Configuration;)V

    invoke-virtual {v0, v2}, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->withObserver(Lcom/amazon/device/analytics/events/observers/EventObserver;)Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;

    .line 91
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->build()Lcom/amazon/device/analytics/events/EventRecorder;

    move-result-object v1

    .line 92
    .local v1, "recorder":Lcom/amazon/device/analytics/events/EventRecorder;
    sget-object v2, Lcom/amazon/device/analytics/AnalyticsClient;->logger:Lcom/amazon/device/analytics/log/Logger;

    sget-object v3, Lcom/amazon/device/analytics/log/Logging$LogLevel;->VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 93
    sget-object v2, Lcom/amazon/device/analytics/AnalyticsClient;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "Created new EventRecorder."

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 94
    sget-object v2, Lcom/amazon/device/analytics/AnalyticsClient;->logger:Lcom/amazon/device/analytics/log/Logger;

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 96
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->build()Lcom/amazon/device/analytics/events/EventRecorder;

    move-result-object v2

    return-object v2
.end method

.method public onPropertyChanged(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 5
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 101
    const-string/jumbo v3, "useAvailabilityLogAppender"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 121
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v2

    .line 107
    .local v2, "useAvailabilityAppender":Z
    if-eqz v2, :cond_2

    .line 108
    iget-object v3, p0, Lcom/amazon/device/analytics/AnalyticsClient;->context:Landroid/content/Context;

    if-eqz v3, :cond_0

    .line 109
    new-instance v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;

    iget-object v3, p0, Lcom/amazon/device/analytics/AnalyticsClient;->context:Landroid/content/Context;

    iget-object v4, p0, Lcom/amazon/device/analytics/AnalyticsClient;->config:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-direct {v0, v3, v4}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;-><init>(Landroid/content/Context;Lcom/amazon/device/analytics/configuration/Configuration;)V

    .line 110
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->attachLogAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V

    goto :goto_0

    .line 119
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v2    # "useAvailabilityAppender":Z
    :catch_0
    move-exception v3

    goto :goto_0

    .line 113
    .restart local v2    # "useAvailabilityAppender":Z
    :cond_2
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->getLogAppenders()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 114
    .restart local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    instance-of v3, v0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;

    if-eqz v3, :cond_3

    .line 115
    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->detachLogAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    new-instance v0, Lcom/amazon/device/analytics/util/JSONBuilder;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0}, Lcom/amazon/device/analytics/util/JSONBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
