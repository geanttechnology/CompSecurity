.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$25;
.super Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->configurePlayer()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 850
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$25;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;-><init>()V

    return-void
.end method


# virtual methods
.method public configurationFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 859
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationFailed(Ljava/lang/String;)V

    .line 860
    new-instance v0, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    invoke-direct {v0, p1}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public configurationLoaded()V
    .locals 1

    .prologue
    .line 853
    invoke-super {p0}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;->configurationLoaded()V

    .line 854
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$25;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->acquireMediaLicense()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$4100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    .line 855
    return-void
.end method
