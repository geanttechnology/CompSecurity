.class public Lcom/amazon/client/metrics/MetricsBroadcastReceiver;
.super Landroid/content/BroadcastReceiver;
.source "MetricsBroadcastReceiver.java"


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;

.field private static sUploadIntentListenerList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/UploadIntentListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 32
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "MetricsBroadcastReceiver"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->log:Lcom/amazon/dp/logger/DPLogger;

    .line 33
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->sUploadIntentListenerList:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method protected static addUploadIntentListener(Lcom/amazon/client/metrics/UploadIntentListener;)V
    .locals 1
    .param p0, "uploadIntentListener"    # Lcom/amazon/client/metrics/UploadIntentListener;

    .prologue
    .line 54
    sget-object v0, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->sUploadIntentListenerList:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 55
    return-void
.end method

.method public static shutdown()V
    .locals 1

    .prologue
    .line 61
    sget-object v0, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->sUploadIntentListenerList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 62
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v8, 0x0

    .line 37
    if-nez p2, :cond_1

    const/4 v0, 0x0

    .line 38
    .local v0, "action":Ljava/lang/String;
    :goto_0
    const-string/jumbo v3, "com.amazon.intent.action.UPLOAD_METRICS"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 39
    const-string/jumbo v3, "amazon.permission.UPLOAD_METRICS"

    invoke-virtual {p1, v3}, Landroid/content/Context;->checkCallingOrSelfPermission(Ljava/lang/String;)I

    move-result v3

    const/4 v4, -0x1

    if-ne v3, v4, :cond_2

    .line 40
    sget-object v3, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "onReceive"

    const-string/jumbo v5, "Metrics upload permission denied."

    new-array v6, v8, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 51
    :cond_0
    :goto_1
    return-void

    .line 37
    .end local v0    # "action":Ljava/lang/String;
    :cond_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 44
    .restart local v0    # "action":Ljava/lang/String;
    :cond_2
    sget-object v3, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "onReceive"

    const-string/jumbo v5, "Upload metrics intent received. Notifying listeners."

    new-array v6, v8, [Ljava/lang/Object;

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 45
    sget-object v3, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->sUploadIntentListenerList:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/client/metrics/UploadIntentListener;

    .line 46
    .local v2, "uploadIntentListener":Lcom/amazon/client/metrics/UploadIntentListener;
    invoke-interface {v2}, Lcom/amazon/client/metrics/UploadIntentListener;->onUploadIntentReceived()V

    goto :goto_2

    .line 49
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "uploadIntentListener":Lcom/amazon/client/metrics/UploadIntentListener;
    :cond_3
    sget-object v3, Lcom/amazon/client/metrics/MetricsBroadcastReceiver;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "onReceive"

    const-string/jumbo v5, "Received unexpected intent."

    const/4 v6, 0x4

    new-array v6, v6, [Ljava/lang/Object;

    const-string/jumbo v7, " intent: "

    aput-object v7, v6, v8

    const/4 v7, 0x1

    aput-object p2, v6, v7

    const/4 v7, 0x2

    const-string/jumbo v8, " action: "

    aput-object v8, v6, v7

    const/4 v7, 0x3

    aput-object v0, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1
.end method
