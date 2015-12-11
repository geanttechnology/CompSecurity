.class Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2$1;
.super Ljava/lang/Object;
.source "SeriesEpisodeListFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;->create(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;)V
    .locals 0
    .param p1, "this$2"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;

    .prologue
    .line 393
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2$1;->this$2:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;I)V
    .locals 2
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p2, "position"    # I

    .prologue
    .line 396
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2$1;->this$2:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->resetWatchableInfo()V

    .line 397
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2$1;->this$2:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    iput-object v1, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 398
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2$1;->this$2:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1300(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;->showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 399
    return-void
.end method
