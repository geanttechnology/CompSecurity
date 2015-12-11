.class Lcom/amazon/device/analytics/log/Logging$1;
.super Ljava/lang/Object;
.source "Logging.java"

# interfaces
.implements Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/analytics/log/Logging;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/analytics/log/Logging;


# direct methods
.method constructor <init>(Lcom/amazon/device/analytics/log/Logging;)V
    .locals 0

    .prologue
    .line 48
    iput-object p1, p0, Lcom/amazon/device/analytics/log/Logging$1;->this$0:Lcom/amazon/device/analytics/log/Logging;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPropertyChanged(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 3
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 52
    iget-object v2, p0, Lcom/amazon/device/analytics/log/Logging$1;->this$0:Lcom/amazon/device/analytics/log/Logging;

    # getter for: Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;
    invoke-static {v2}, Lcom/amazon/device/analytics/log/Logging;->access$000(Lcom/amazon/device/analytics/log/Logging;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/device/analytics/log/Logger;

    .line 54
    .local v1, "logger":Lcom/amazon/device/analytics/log/Logger;
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->valueOf(Ljava/lang/String;)Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v2

    # setter for: Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;
    invoke-static {v2}, Lcom/amazon/device/analytics/log/Logging;->access$102(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 55
    # getter for: Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->access$100()Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/device/analytics/log/Logger;->setGlobalLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 56
    :catch_0
    move-exception v2

    goto :goto_0

    .line 59
    .end local v1    # "logger":Lcom/amazon/device/analytics/log/Logger;
    :cond_0
    return-void
.end method
