.class Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;
.super Ljava/lang/Object;
.source "DownloadsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 361
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 366
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    invoke-virtual {v3}, Landroid/widget/Button;->getVisibility()I

    move-result v3

    const/16 v4, 0x8

    if-ne v3, v4, :cond_1

    .line 389
    :cond_0
    :goto_0
    return-void

    .line 372
    :cond_1
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v1

    .line 374
    .local v1, "engineStatus":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v2

    .line 376
    .local v2, "status":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v2, v3}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 377
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->pauseDownloading()V

    .line 378
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->tempDisablePauseButton()V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 385
    .end local v1    # "engineStatus":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .end local v2    # "status":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :catch_0
    move-exception v0

    .line 386
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->LOG:Lorg/slf4j/Logger;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 387
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    goto :goto_0

    .line 379
    .end local v0    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    .restart local v1    # "engineStatus":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .restart local v2    # "status":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :cond_2
    :try_start_1
    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v2, v3}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 380
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->resumeDownloading()V

    .line 381
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->tempDisablePauseButton()V
    :try_end_1
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
