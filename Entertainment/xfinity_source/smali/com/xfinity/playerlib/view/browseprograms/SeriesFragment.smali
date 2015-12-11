.class public Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;
.super Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;
.source "SeriesFragment.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;>;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;-><init>()V

    .line 31
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 32
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SeriesSortPolicy;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    return-void
.end method


# virtual methods
.method protected getContentDescriptionForAccessibility()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 56
    sget v0, Lcom/xfinity/playerlib/R$string;->tv_series:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getFilterBundle()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 66
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    return-object v0
.end method

.method protected getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getSeriesFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

    return-object v0
.end method

.method protected getSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    return-object v0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 76
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-nez v0, :cond_0

    .line 77
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 96
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method protected hideSortButtons()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 137
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 138
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 139
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 141
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->filterButton:Landroid/view/View;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->sortBar:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 142
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->sortBar:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 145
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->onHideSortBar()V

    .line 146
    return-void
.end method

.method protected itemClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 3
    .param p1, "item"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 151
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 152
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isHideLockOn()Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v1

    .line 153
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    .line 154
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 156
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->startActivity(Landroid/content/Intent;)V

    .line 157
    return-void
.end method

.method protected bridge synthetic itemClicked(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 27
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->itemClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method protected itemLongClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 5
    .param p1, "item"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 161
    if-nez p1, :cond_0

    .line 166
    :goto_0
    return-void

    .line 164
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    new-instance v1, Lcom/xfinity/playerlib/model/VideoFavorite;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    .line 165
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;Z)V

    .line 164
    invoke-virtual {v0, p0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto :goto_0
.end method

.method protected bridge synthetic itemLongClicked(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 27
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->itemLongClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 39
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 40
    .local v0, "layout":Landroid/view/ViewGroup;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getSortTypes()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->setupSortButtons(Landroid/view/ViewGroup;Ljava/util/List;)V

    .line 42
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->otherSortButton:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->otherSortButton:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->btn_otherSort:I

    .line 43
    invoke-virtual {v1, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    sget v3, Lcom/xfinity/playerlib/R$string;->chronological_series_sort_button_text:I

    .line 44
    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->chronological_series_sort_button_speech:I

    .line 45
    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 42
    invoke-virtual {p0, v2, v1, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->setupOtherButton(Landroid/view/ViewGroup;Landroid/widget/Button;Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->TV_SERIES:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V

    .line 49
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->showFilterButton()V

    .line 51
    return-object v0
.end method

.method protected showSortButtons()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 124
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 125
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 126
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 128
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->filterButton:Landroid/view/View;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->sortBar:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 129
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->sortBar:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 132
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->onShowSortBar()V

    .line 133
    return-void
.end method

.method public updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 3
    .param p1, "selectedSort"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 101
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment$2;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType:[I

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 118
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->LOG:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unexpected sort="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 120
    :goto_0
    return-void

    .line 103
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->select(Landroid/view/ViewGroup;)V

    .line 104
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->unselect(Landroid/view/ViewGroup;)V

    .line 105
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->unselect(Landroid/view/ViewGroup;)V

    goto :goto_0

    .line 108
    :pswitch_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->select(Landroid/view/ViewGroup;)V

    .line 109
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->unselect(Landroid/view/ViewGroup;)V

    .line 110
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->unselect(Landroid/view/ViewGroup;)V

    goto :goto_0

    .line 113
    :pswitch_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->select(Landroid/view/ViewGroup;)V

    .line 114
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->unselect(Landroid/view/ViewGroup;)V

    .line 115
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/SeriesFragment;->unselect(Landroid/view/ViewGroup;)V

    goto :goto_0

    .line 101
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
