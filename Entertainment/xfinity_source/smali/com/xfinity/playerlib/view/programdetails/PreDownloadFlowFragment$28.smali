.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Lcom/google/common/util/concurrent/FutureCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->submitDownload()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/common/util/concurrent/FutureCallback",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 915
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 924
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Download submission failed"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 925
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->isResumed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 926
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlow()V

    .line 942
    :goto_0
    return-void

    .line 929
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;

    invoke-direct {v1, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;Ljava/lang/Throwable;)V

    const-string v2, "submitDownload"

    const/4 v3, 0x0

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V
    invoke-static {v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$3200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 915
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->onSuccess(Ljava/lang/Void;)V

    return-void
.end method

.method public onSuccess(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 918
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Download submitted, completing flow"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 919
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->completeFlow()V

    .line 920
    return-void
.end method
