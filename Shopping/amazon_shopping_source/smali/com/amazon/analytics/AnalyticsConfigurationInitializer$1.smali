.class Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;
.super Ljava/lang/Object;
.source "AnalyticsConfigurationInitializer.java"

# interfaces
.implements Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->init()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field currentReceiver:Landroid/content/BroadcastReceiver;

.field final synthetic this$0:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;


# direct methods
.method constructor <init>(Lcom/amazon/analytics/AnalyticsConfigurationInitializer;)V
    .locals 3

    .prologue
    .line 64
    iput-object p1, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->this$0:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 65
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->this$0:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    iget-object v1, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->this$0:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    # getter for: Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->config:Lcom/amazon/analytics/AnalyticsConfiguration;
    invoke-static {v1}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->access$000(Lcom/amazon/analytics/AnalyticsConfigurationInitializer;)Lcom/amazon/analytics/AnalyticsConfiguration;

    move-result-object v1

    sget-object v2, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->RunningProcessPollInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-interface {v1, v2}, Lcom/amazon/analytics/AnalyticsConfiguration;->getInt(Lcom/amazon/analytics/AnalyticsConfiguration$Setting;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->setUpPackageCheckMonitor(I)Landroid/content/BroadcastReceiver;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->currentReceiver:Landroid/content/BroadcastReceiver;

    return-void
.end method


# virtual methods
.method public onPropertyChanged(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 68
    if-eqz p2, :cond_0

    .line 71
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 77
    .local v1, "pollSeconds":I
    monitor-enter p0

    .line 78
    :try_start_1
    iget-object v2, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->this$0:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    # getter for: Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->context:Landroid/content/Context;
    invoke-static {v2}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->access$200(Lcom/amazon/analytics/AnalyticsConfigurationInitializer;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->currentReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {v2, v3}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 79
    iget-object v2, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->this$0:Lcom/amazon/analytics/AnalyticsConfigurationInitializer;

    invoke-virtual {v2, v1}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->setUpPackageCheckMonitor(I)Landroid/content/BroadcastReceiver;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/analytics/AnalyticsConfigurationInitializer$1;->currentReceiver:Landroid/content/BroadcastReceiver;

    .line 80
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 82
    .end local v1    # "pollSeconds":I
    :cond_0
    :goto_0
    return-void

    .line 72
    :catch_0
    move-exception v0

    .line 73
    .local v0, "ex":Ljava/lang/NumberFormatException;
    # getter for: Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->logger:Lcom/amazon/device/analytics/log/Logger;
    invoke-static {}, Lcom/amazon/analytics/AnalyticsConfigurationInitializer;->access$100()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v2

    const-string/jumbo v3, "RunningProcessPollInterval is not a number"

    invoke-virtual {v2, v3, v0}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 80
    .end local v0    # "ex":Ljava/lang/NumberFormatException;
    .restart local v1    # "pollSeconds":I
    :catchall_0
    move-exception v2

    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method
