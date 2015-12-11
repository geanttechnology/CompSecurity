.class Lcom/adobe/mobile/MobileConfig$8;
.super Landroid/content/BroadcastReceiver;
.source "MobileConfig.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/MobileConfig;->startNotifier()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/adobe/mobile/MobileConfig;


# direct methods
.method constructor <init>(Lcom/adobe/mobile/MobileConfig;)V
    .locals 0
    .param p1, "this$0"    # Lcom/adobe/mobile/MobileConfig;

    .prologue
    .line 1060
    iput-object p1, p0, Lcom/adobe/mobile/MobileConfig$8;->this$0:Lcom/adobe/mobile/MobileConfig;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 1063
    iget-object v0, p0, Lcom/adobe/mobile/MobileConfig$8;->this$0:Lcom/adobe/mobile/MobileConfig;

    iget-object v1, p0, Lcom/adobe/mobile/MobileConfig$8;->this$0:Lcom/adobe/mobile/MobileConfig;

    invoke-virtual {v1, p1}, Lcom/adobe/mobile/MobileConfig;->getNetworkConnectivity(Landroid/content/Context;)Z

    move-result v1

    # setter for: Lcom/adobe/mobile/MobileConfig;->_networkConnectivity:Z
    invoke-static {v0, v1}, Lcom/adobe/mobile/MobileConfig;->access$402(Lcom/adobe/mobile/MobileConfig;Z)Z

    .line 1065
    iget-object v0, p0, Lcom/adobe/mobile/MobileConfig$8;->this$0:Lcom/adobe/mobile/MobileConfig;

    # getter for: Lcom/adobe/mobile/MobileConfig;->_networkConnectivity:Z
    invoke-static {v0}, Lcom/adobe/mobile/MobileConfig;->access$400(Lcom/adobe/mobile/MobileConfig;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1066
    const-string v0, "Analytics - Network status changed (reachable)"

    new-array v1, v2, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 1067
    invoke-static {}, Lcom/adobe/mobile/AnalyticsWorker;->sharedInstance()Lcom/adobe/mobile/AnalyticsWorker;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/adobe/mobile/AnalyticsWorker;->kick(Z)V

    .line 1072
    :goto_0
    return-void

    .line 1070
    :cond_0
    const-string v0, "Analytics - Network status changed (unreachable)"

    new-array v1, v2, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
