.class Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;
.super Landroid/content/BroadcastReceiver;
.source "SeriesEntityActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x0

    .line 77
    const-string v1, "noConnectivity"

    invoke-virtual {p2, v1, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    .line 82
    .local v0, "isNetworkDown":Z
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$200()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Network change, isNetworkDown {}"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 83
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->waitingForInternet:Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$300(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Z

    move-result v1

    if-eqz v1, :cond_0

    if-nez v0, :cond_0

    .line 84
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$200()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "Internet connect reestablished, triggering loading"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 85
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->waitingForInternet:Z
    invoke-static {v1, v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$302(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;Z)Z

    .line 86
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->triggerLoading()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    .line 88
    :cond_0
    return-void
.end method
