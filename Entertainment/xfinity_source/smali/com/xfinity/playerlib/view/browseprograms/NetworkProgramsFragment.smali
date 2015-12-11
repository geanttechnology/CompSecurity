.class public Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;
.super Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;
.source "NetworkProgramsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

.field private category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

.field protected categoryId:Ljava/lang/String;

.field protected companyId:J

.field private displayType:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

.field protected network:Lcom/xfinity/playerlib/model/tags/Network;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-class v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;-><init>()V

    .line 181
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    return-object v0
.end method

.method static synthetic access$002(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;Lcom/xfinity/playerlib/model/tags/OrderedTag;)Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    return-object p1
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->displayType:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->filterButton:Landroid/view/View;

    return-object v0
.end method

.method public static createBundle(Lcom/xfinity/playerlib/model/tags/Network;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 4
    .param p0, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .param p1, "categoryId"    # Ljava/lang/String;

    .prologue
    .line 174
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 175
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "companyId"

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 176
    const-string v1, "categoryId"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 177
    return-object v0
.end method


# virtual methods
.method protected getContentDescriptionForAccessibility()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x0

    return-object v0
.end method

.method protected getFilterBundle()Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 97
    iget-wide v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->companyId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->categoryId:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFilterDialog;->createBundle(Ljava/lang/Long;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    return-object v0
.end method

.method protected getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 4

    .prologue
    .line 102
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    iget-wide v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->companyId:J

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->categoryId:Ljava/lang/String;

    invoke-virtual {v0, v2, v3, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getNetworkProgramsFilter(JLjava/lang/String;)Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v0

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
    .line 118
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-nez v0, :cond_0

    .line 119
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 170
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected itemClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 4
    .param p1, "item"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 108
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    .line 109
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v1

    .line 110
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    .line 111
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 113
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->startActivity(Landroid/content/Intent;)V

    .line 114
    return-void
.end method

.method protected bridge synthetic itemClicked(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 29
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->itemClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->onAttach(Landroid/app/Activity;)V

    .line 49
    instance-of v0, p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    if-eqz v0, :cond_0

    .line 50
    check-cast p1, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    .line 52
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->onCreate(Landroid/os/Bundle;)V

    .line 63
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 64
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 65
    .local v2, "intent":Landroid/content/Intent;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 66
    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 69
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 70
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 73
    :cond_1
    const-string v3, "companyId"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->companyId:J

    .line 74
    const-string v3, "categoryId"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->categoryId:Ljava/lang/String;

    .line 75
    const-string v3, "showFilterButton"

    const/4 v4, 0x1

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->shouldShowFilterButton:Z

    .line 77
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->categoryId:Ljava/lang/String;

    invoke-static {v3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 79
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    .line 80
    .local v1, "container":Lcom/comcast/cim/container/PlayerContainer;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->categoryId:Ljava/lang/String;

    sget-object v4, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_MOVIES:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 81
    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->ALL_MOVIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->displayType:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    .line 82
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getMoviesAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 83
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getMovieCollectionSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/MovieCollectionSortPolicy;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    .line 93
    :goto_0
    return-void

    .line 84
    :cond_2
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->categoryId:Ljava/lang/String;

    sget-object v4, Lcom/xfinity/playerlib/model/tags/OrderedTag;->ALL_TV:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/OrderedTag;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 85
    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->ALL_TV_SERIES:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->displayType:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    .line 86
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 87
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCollectionSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SeriesCollectionSortPolicy;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    goto :goto_0

    .line 89
    :cond_3
    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->COLLECTION:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->displayType:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    .line 90
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getProgramsAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 91
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getNullSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    goto :goto_0
.end method
