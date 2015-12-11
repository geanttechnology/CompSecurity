.class Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "KidsProgramsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "error"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 104
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 82
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v2, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 83
    .local v2, "programResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 85
    .local v4, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->showFilterButton()V

    .line 87
    new-instance v3, Ljava/util/ArrayList;

    invoke-interface {v2}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getPrograms()Ljava/util/List;

    move-result-object v5

    invoke-direct {v3, v5}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 90
    .local v3, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 91
    .local v0, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 92
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 93
    .local v1, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isKids()Z

    move-result v5

    if-nez v5, :cond_0

    .line 94
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 98
    .end local v1    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;

    invoke-virtual {v5, v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment;->displayPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 99
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 79
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/KidsProgramsFragment$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method
