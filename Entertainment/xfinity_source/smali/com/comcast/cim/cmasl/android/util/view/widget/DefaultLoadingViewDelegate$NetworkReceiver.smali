.class public Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;
.super Landroid/content/BroadcastReceiver;
.source "DefaultLoadingViewDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "NetworkReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x4

    const/4 v3, 0x0

    .line 53
    const-string v1, "noConnectivity"

    invoke-virtual {p2, v1, v3}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    .line 56
    .local v0, "isNetworkDown":Z
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-boolean v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->firstTimeLoadStarted:Z

    if-nez v1, :cond_1

    .line 57
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->firstTimeLoadStarted:Z

    .line 58
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 59
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 60
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingRetryButton:Landroid/widget/Button;

    invoke-virtual {v1, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 61
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->startLoading()V

    .line 70
    :cond_0
    :goto_0
    return-void

    .line 62
    :cond_1
    if-eqz v0, :cond_2

    .line 63
    # getter for: Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->access$000()Lorg/slf4j/Logger;

    move-result-object v1

    const-string v2, "onReceive: NOT connected"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 64
    :cond_2
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-boolean v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded:Z

    if-nez v1, :cond_0

    .line 65
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 66
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 67
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    iget-object v1, v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->loadingRetryButton:Landroid/widget/Button;

    invoke-virtual {v1, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 68
    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$NetworkReceiver;->this$0:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->startLoading()V

    goto :goto_0
.end method
