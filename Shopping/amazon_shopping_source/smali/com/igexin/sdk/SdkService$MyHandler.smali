.class Lcom/igexin/sdk/SdkService$MyHandler;
.super Landroid/os/Handler;
.source "SdkService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/igexin/sdk/SdkService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "MyHandler"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 662
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 666
    iget v3, p1, Landroid/os/Message;->what:I

    sget v4, Lcom/igexin/sdk/Consts;->MESSAGE_RECEIVER_INTERNAL:I

    if-ne v3, v4, :cond_1

    .line 667
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/content/Intent;

    .line 668
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v3

    # invokes: Lcom/igexin/sdk/SdkService;->onInternalReceiver(Landroid/content/Intent;)V
    invoke-static {v3, v0}, Lcom/igexin/sdk/SdkService;->access$500(Lcom/igexin/sdk/SdkService;Landroid/content/Intent;)V

    .line 683
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    :goto_0
    return-void

    .line 669
    :cond_1
    iget v3, p1, Landroid/os/Message;->what:I

    const/16 v4, 0x2af8

    if-ne v3, v4, :cond_0

    .line 671
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v3

    # invokes: Lcom/igexin/sdk/SdkService;->getDynamicConfigAndRegister()V
    invoke-static {v3}, Lcom/igexin/sdk/SdkService;->access$600(Lcom/igexin/sdk/SdkService;)V

    .line 672
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Landroid/content/Intent;

    .line 673
    .restart local v0    # "intent":Landroid/content/Intent;
    const-string/jumbo v3, "com.igexin.sdk.payloadreceived"

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 675
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v3

    invoke-virtual {v3}, Lcom/igexin/sdk/SdkService;->getMetricsFactory()Lcom/amazon/client/metrics/MetricsFactory;

    move-result-object v2

    .line 676
    .local v2, "metricsFactory":Lcom/amazon/client/metrics/MetricsFactory;
    const-string/jumbo v3, "MShopAndroidGetuiLib"

    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/amazon/client/metrics/MetricsFactory;->createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v1

    .line 677
    .local v1, "metricEvent":Lcom/amazon/client/metrics/MetricEvent;
    const-string/jumbo v3, "PUSH:GETUI:MessagesReceived"

    const-wide/high16 v4, 0x3ff0000000000000L    # 1.0

    invoke-interface {v1, v3, v4, v5}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 678
    invoke-interface {v2, v1}, Lcom/amazon/client/metrics/MetricsFactory;->record(Lcom/amazon/client/metrics/MetricEvent;)V

    .line 680
    invoke-static {}, Lcom/igexin/sdk/action/PushMessageAction;->getInstance()Lcom/igexin/sdk/action/PushMessageAction;

    move-result-object v3

    invoke-virtual {v3, v0}, Lcom/igexin/sdk/action/PushMessageAction;->doPushMessageAction(Landroid/content/Intent;)V

    goto :goto_0
.end method
