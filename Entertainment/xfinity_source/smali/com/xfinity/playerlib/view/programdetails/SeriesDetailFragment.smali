.class public Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;
.super Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.source "SeriesDetailFragment.java"


# instance fields
.field private descriptionText:Landroid/widget/TextView;

.field private detailArtView:Landroid/widget/ImageView;

.field private errorText:Landroid/widget/TextView;

.field private lastSeenResource:Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

.field private premiumChannelLogo:Landroid/widget/ImageView;

.field private seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

.field private seriesId:Lcom/xfinity/playerlib/model/MerlinId;

.field private seriesTitleText:Landroid/widget/TextView;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;-><init>()V

    .line 38
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 39
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCombinedTaskExecutorFactory()Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->errorText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;Landroid/view/View;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # I

    .prologue
    .line 37
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->safeSetVisibility(Landroid/view/View;I)V

    return-void
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->detailArtView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;Landroid/view/View;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;
    .param p1, "x1"    # Landroid/view/View;
    .param p2, "x2"    # I

    .prologue
    .line 37
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->safeSetVisibility(Landroid/view/View;I)V

    return-void
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->lastSeenResource:Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    return-object v0
.end method

.method static synthetic access$702(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)Lcom/xfinity/playerlib/view/programdetails/SeriesResource;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->lastSeenResource:Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    return-object p1
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesTitleText:Landroid/widget/TextView;

    return-object v0
.end method

.method public static createBundle(Lcom/xfinity/playerlib/model/MerlinId;)Landroid/os/Bundle;
    .locals 2
    .param p0, "seriesId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 186
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 187
    .local v0, "bundle":Landroid/os/Bundle;
    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->getBundleKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 188
    return-object v0
.end method

.method public static createBundle(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)Landroid/os/Bundle;
    .locals 2
    .param p0, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 192
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 193
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "extra_watchable_key"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 194
    return-object v0
.end method


# virtual methods
.method public extractDataFromBundle(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 177
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->getBundleKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/MerlinId;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 178
    const-string v0, "extra_watchable_key"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .line 179
    return-void
.end method

.method public getDetailLayoutId()I
    .locals 1

    .prologue
    .line 158
    sget v0, Lcom/xfinity/playerlib/R$layout;->series_detail:I

    return v0
.end method

.method public getVideoItemViewContainer()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 164
    const/4 v0, 0x0

    return-object v0
.end method

.method public loadScreenInfo()V
    .locals 4

    .prologue
    .line 79
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v2, :cond_0

    .line 80
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)V

    .line 97
    .local v1, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :goto_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 98
    .local v0, "activity":Landroid/app/Activity;
    instance-of v2, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    if-eqz v2, :cond_1

    .line 99
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 104
    :goto_1
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 147
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 148
    return-void

    .line 95
    .end local v1    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    .restart local v1    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    goto :goto_0

    .line 101
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 56
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 57
    .local v0, "view":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->detail_image:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->detailArtView:Landroid/widget/ImageView;

    .line 58
    sget v1, Lcom/xfinity/playerlib/R$id;->premium_channel_logo:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->premiumChannelLogo:Landroid/widget/ImageView;

    .line 59
    sget v1, Lcom/xfinity/playerlib/R$id;->description:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->descriptionText:Landroid/widget/TextView;

    .line 60
    sget v1, Lcom/xfinity/playerlib/R$id;->series_title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->seriesTitleText:Landroid/widget/TextView;

    .line 61
    sget v1, Lcom/xfinity/playerlib/R$id;->series_detail_error_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->errorText:Landroid/widget/TextView;

    .line 63
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->setupReviews(Landroid/view/View;)V

    .line 65
    return-object v0
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 70
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onStop()V

    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 75
    :cond_0
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 1
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 151
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->descriptionText:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->descriptionText:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 154
    :cond_0
    return-void
.end method

.method public showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    .prologue
    .line 168
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->onLoadingFinished()V

    .line 170
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->bodyContainer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->safeSetVisibility(Landroid/view/View;I)V

    .line 171
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->detailArtView:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->safeSetVisibility(Landroid/view/View;I)V

    .line 172
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->errorText:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->safeSetVisibility(Landroid/view/View;I)V

    .line 173
    return-void
.end method
