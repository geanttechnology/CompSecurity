.class Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$2;
.super Ljava/lang/Object;
.source "SeriesEpisodeListFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 207
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReady()V
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadScreenInfo()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    .line 211
    return-void
.end method
