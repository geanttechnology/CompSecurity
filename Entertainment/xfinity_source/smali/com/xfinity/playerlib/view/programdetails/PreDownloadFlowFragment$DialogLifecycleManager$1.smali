.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;
.super Ljava/lang/Object;
.source "PreDownloadFlowFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    .prologue
    .line 1009
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 1017
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->isDismissingFromOnPause:Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->access$4800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1018
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    const/4 v1, 0x0

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->isDismissingFromOnPause:Z
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->access$4802(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;Z)Z

    .line 1029
    :goto_0
    return-void

    .line 1019
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    if-ne v0, v1, :cond_1

    .line 1020
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "From onDismiss, nulling out lifecycle manager for {}"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->getDialogId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 1021
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    const/4 v1, 0x0

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4902(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;)Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    goto :goto_0

    .line 1027
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "dialogLifecycleManager reference has been updated since we were dismissed, not clearing reference"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->info(Ljava/lang/String;)V

    goto :goto_0
.end method
