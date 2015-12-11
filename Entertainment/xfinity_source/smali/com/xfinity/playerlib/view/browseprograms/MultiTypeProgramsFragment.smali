.class public abstract Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;
.super Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;
.source "MultiTypeProgramsFragment.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;>;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field protected filterSubNav:Landroid/view/View;

.field protected provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field protected sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field protected taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;-><init>()V

    .line 109
    return-void
.end method


# virtual methods
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
    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    return-object v0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 173
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 67
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method protected hideSortButtons()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 140
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 141
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 142
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 146
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->filterButton:Landroid/view/View;

    if-nez v0, :cond_0

    .line 147
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->filterSubNav:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortBar:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 150
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortBar:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 154
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->onHideSortBar()V

    .line 155
    return-void
.end method

.method protected isSortable()Z
    .locals 2

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortType()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected itemLongClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 5
    .param p1, "item"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 159
    if-nez p1, :cond_0

    .line 169
    :goto_0
    return-void

    .line 162
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 163
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    new-instance v1, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 164
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;Z)V

    .line 163
    invoke-virtual {v0, p0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto :goto_0

    .line 166
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    new-instance v1, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 167
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;Z)V

    .line 166
    invoke-virtual {v0, p0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto :goto_0
.end method

.method protected bridge synthetic itemLongClicked(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 23
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->itemLongClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->onAttach(Landroid/app/Activity;)V

    .line 62
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 63
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 40
    .local v0, "layout":Landroid/view/ViewGroup;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getSortTypes()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->setupSortButtons(Landroid/view/ViewGroup;Ljava/util/List;)V

    .line 42
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortBar:Landroid/view/View;

    if-nez v1, :cond_0

    .line 43
    sget v1, Lcom/xfinity/playerlib/R$id;->FilterSubNavBar:I

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->filterSubNav:Landroid/view/View;

    .line 48
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->btn_otherSort:I

    .line 49
    invoke-virtual {v1, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    sget v3, Lcom/xfinity/playerlib/R$string;->chronological_series_sort_button_text:I

    .line 50
    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->chronological_series_sort_button_speech:I

    .line 51
    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 48
    invoke-virtual {p0, v2, v1, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->setupOtherButton(Landroid/view/ViewGroup;Landroid/widget/Button;Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    sget v2, Lcom/xfinity/playerlib/R$id;->touchy_parent:I

    invoke-interface {v1, v0, v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->setupPassiveGestureDetector(Landroid/view/View;I)V

    .line 55
    return-object v0

    .line 45
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortBar:Landroid/view/View;

    sget v2, Lcom/xfinity/playerlib/R$id;->list_header:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->filterSubNav:Landroid/view/View;

    goto :goto_0
.end method

.method protected showSortButtons()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 115
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getSortTypes()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    .line 116
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Trying to show nonexistent sort buttons"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 120
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 121
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getSortTypes()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    .line 122
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 127
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->filterButton:Landroid/view/View;

    if-nez v0, :cond_2

    .line 128
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->filterSubNav:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 130
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortBar:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 131
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortBar:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 135
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->onShowSortBar()V

    .line 136
    return-void
.end method

.method protected updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 3
    .param p1, "selectedSortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 83
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getSortTypes()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    .line 85
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->NONE:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    if-eq p1, v0, :cond_1

    .line 86
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected sort type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 91
    :cond_0
    sget-object v0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment$1;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType:[I

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 109
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected sort type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 93
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->select(Landroid/view/ViewGroup;)V

    .line 94
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->unselect(Landroid/view/ViewGroup;)V

    .line 95
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->unselect(Landroid/view/ViewGroup;)V

    .line 111
    :cond_1
    :goto_0
    return-void

    .line 99
    :pswitch_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->select(Landroid/view/ViewGroup;)V

    .line 100
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->unselect(Landroid/view/ViewGroup;)V

    .line 101
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->unselect(Landroid/view/ViewGroup;)V

    goto :goto_0

    .line 104
    :pswitch_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->popularityButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->select(Landroid/view/ViewGroup;)V

    .line 105
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->alphaSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->unselect(Landroid/view/ViewGroup;)V

    .line 106
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->unselect(Landroid/view/ViewGroup;)V

    goto :goto_0

    .line 91
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
