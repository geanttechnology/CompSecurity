.class Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$1;
.super Landroid/os/Handler;
.source "LocalWifiMonitor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->SetupHandler()V
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
    iput-object p1, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$1;->this$0:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    .line 88
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 91
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 98
    # getter for: Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$1()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "c[] Wrong message "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    :goto_0
    return-void

    .line 94
    :pswitch_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$1;->this$0:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    # invokes: Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->handleAlarm()V
    invoke-static {v0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->access$0(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;)V

    goto :goto_0

    .line 91
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
