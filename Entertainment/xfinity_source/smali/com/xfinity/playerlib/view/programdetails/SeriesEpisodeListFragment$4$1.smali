.class Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;
.super Ljava/lang/Object;
.source "SeriesEpisodeListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    .prologue
    .line 380
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 383
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->resetWatchableInfo()V

    .line 384
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->seriesDetailSelected:Z

    .line 386
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->clearEpisodeAdaptersSelections()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    .line 387
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1300(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    move-result-object v0

    invoke-interface {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;->showSeriesDetail()V

    .line 388
    return-void
.end method
