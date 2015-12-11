.class Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "SeriesDetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->loadScreenInfo()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 104
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->onLoadingFailed()V

    .line 144
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V
    .locals 7
    .param p1, "resource"    # Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .prologue
    .line 113
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->errorText:Landroid/widget/TextView;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Landroid/widget/TextView;

    move-result-object v5

    const/16 v6, 0x8

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->safeSetVisibility(Landroid/view/View;I)V
    invoke-static {v4, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;Landroid/view/View;I)V

    .line 114
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->detailArtView:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Landroid/widget/ImageView;

    move-result-object v5

    const/4 v6, 0x0

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->safeSetVisibility(Landroid/view/View;I)V
    invoke-static {v4, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;Landroid/view/View;I)V

    .line 116
    iget-object v3, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .line 117
    .local v3, "tvSeriesFacade":Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    iget-object v0, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 119
    .local v0, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->detailArtView:Landroid/widget/ImageView;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Landroid/widget/ImageView;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadDetailProgramArt(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;)V

    .line 121
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->lastSeenResource:Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    move-result-object v4

    invoke-virtual {p1, v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 123
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-interface {v0, v4}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v1

    .line 125
    .local v1, "dibicSeries":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    if-eqz v1, :cond_1

    .line 126
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getTitle()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesTitleText:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Landroid/widget/TextView;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V

    .line 127
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->setDescription(Ljava/lang/String;)V

    .line 129
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->lastSeenResource:Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    invoke-static {v4, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->access$702(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .line 135
    .end local v1    # "dibicSeries":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_0
    :goto_0
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getReviews()Ljava/util/List;

    move-result-object v2

    .line 136
    .local v2, "reviews":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalReview;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    invoke-virtual {v4, v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->presentReviews(Ljava/util/List;)V

    .line 138
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->onLoadingFinished()V

    .line 139
    return-void

    .line 131
    .end local v2    # "reviews":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalReview;>;"
    .restart local v1    # "dibicSeries":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 104
    check-cast p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 108
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 109
    return-void
.end method
