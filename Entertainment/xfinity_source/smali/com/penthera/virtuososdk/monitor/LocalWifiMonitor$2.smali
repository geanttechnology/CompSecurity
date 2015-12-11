.class Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$2;
.super Ljava/lang/Object;
.source "LocalWifiMonitor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleAlarm()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$2;->this$0:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    .line 235
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 239
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$2;->this$0:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    # getter for: Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->PING_URL:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$2()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->pingWifi(Ljava/lang/String;)Z
    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$3(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;Ljava/lang/String;)Z

    move-result v0

    .line 241
    .local v0, "wifiOkay":Z
    if-nez v0, :cond_0

    .line 242
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$2;->this$0:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    # invokes: Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->disconnectWifi()V
    invoke-static {v1}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$4(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;)V

    .line 244
    :cond_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$2;->this$0:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    # invokes: Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->notifyObservers(Z)V
    invoke-static {v1, v0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$5(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;Z)V

    .line 245
    invoke-static {v3}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$6(I)V

    .line 246
    invoke-static {v3}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$7(Z)V

    .line 247
    return-void
.end method
