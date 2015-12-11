.class public Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$NetworkReceiver;
.super Landroid/content/BroadcastReceiver;
.source "DownloadsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "NetworkReceiver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$NetworkReceiver;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 162
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$NetworkReceiver;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$NetworkReceiver;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # invokes: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showOfflineWarningIfNecessary()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$100(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    .line 165
    :cond_0
    return-void
.end method
