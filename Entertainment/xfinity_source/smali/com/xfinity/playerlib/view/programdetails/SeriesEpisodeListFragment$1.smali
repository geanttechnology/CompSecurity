.class Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$1;
.super Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;
.source "SeriesEpisodeListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-direct {p0}, Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onFileListUpdated()V
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$000(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->firstTimeLoadStarted()Z

    move-result v0

    if-nez v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadScreenInfo()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    .line 91
    :cond_0
    return-void
.end method
