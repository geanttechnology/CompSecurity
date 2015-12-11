.class Ltv/freewheel/hybrid/ad/AdInstance$2;
.super Landroid/os/Handler;
.source "AdInstance.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/ad/AdInstance;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/ad/AdInstance;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/ad/AdInstance;Landroid/os/Looper;)V
    .locals 0
    .param p2, "x0"    # Landroid/os/Looper;

    .prologue
    .line 705
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdInstance$2;->this$0:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 707
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "CODE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 708
    .local v1, "returnCode":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "MSG"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 709
    .local v0, "message":Ljava/lang/String;
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance$2;->this$0:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/AdInstance;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "renderer load complete code:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " msg:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 710
    const-string v2, "ERROR"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 711
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance$2;->this$0:Ltv/freewheel/hybrid/ad/AdInstance;

    # setter for: Ltv/freewheel/hybrid/ad/AdInstance;->additionalErrorInfo:Ljava/lang/String;
    invoke-static {v2, v0}, Ltv/freewheel/hybrid/ad/AdInstance;->access$102(Ltv/freewheel/hybrid/ad/AdInstance;Ljava/lang/String;)Ljava/lang/String;

    .line 713
    :cond_0
    iget-object v2, p0, Ltv/freewheel/hybrid/ad/AdInstance$2;->this$0:Ltv/freewheel/hybrid/ad/AdInstance;

    iget-object v2, v2, Ltv/freewheel/hybrid/ad/AdInstance;->state:Ltv/freewheel/hybrid/ad/state/AdState;

    iget-object v3, p0, Ltv/freewheel/hybrid/ad/AdInstance$2;->this$0:Ltv/freewheel/hybrid/ad/AdInstance;

    invoke-virtual {v2, v3}, Ltv/freewheel/hybrid/ad/state/AdState;->notifyRendererModuleLoaded(Ltv/freewheel/hybrid/ad/AdInstance;)V

    .line 714
    return-void
.end method
