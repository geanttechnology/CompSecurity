.class public Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;
.super Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;
.source "KidsProgramsFragment.java"


# instance fields
.field private label:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected getContentDescriptionForAccessibility()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 52
    sget v0, Lcom/xfinity/playerlib/R$string;->flyin_menu_kids:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getFilterBundle()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 57
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    return-object v0
.end method

.method protected getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getKidsFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

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
    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-nez v0, :cond_0

    .line 79
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 107
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected itemClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 3
    .param p1, "item"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 67
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 68
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getFilterValue()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isHideLockOn()Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v1

    .line 69
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    .line 70
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 72
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->startActivity(Landroid/content/Intent;)V

    .line 73
    return-void
.end method

.method protected bridge synthetic itemClicked(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 22
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->itemClicked(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 28
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/MultiTypeProgramsFragment;->onCreate(Landroid/os/Bundle;)V

    .line 30
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 31
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 32
    .local v2, "intent":Landroid/content/Intent;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 33
    invoke-virtual {v2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 36
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 37
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 40
    :cond_1
    const-string v3, "label"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->label:Ljava/lang/String;

    .line 42
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    .line 44
    .local v1, "container":Lcom/comcast/cim/container/PlayerContainer;
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getProgramsAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 45
    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getNullSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/NullSortPolicy;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    .line 47
    const/4 v3, 0x1

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->setHasOptionsMenu(Z)V

    .line 48
    return-void
.end method
