.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "NetworkCollectionsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->loadResources()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 215
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 235
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 236
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 218
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->companyId:J
    invoke-static {v3}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$600(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)J

    move-result-wide v4

    invoke-interface {v1, v4, v5}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v1

    # setter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v2, v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$502(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/Network;)Lcom/xfinity/playerlib/model/tags/Network;

    .line 219
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 221
    .local v0, "programsResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/tags/Network;->getCategories()Ljava/util/List;

    move-result-object v2

    # setter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$702(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Ljava/util/List;)Ljava/util/List;

    .line 222
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$700(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingGenresAndNetwork(Ljava/util/List;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v2

    # setter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryToProgramsMap:Ljava/util/Map;
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$802(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Ljava/util/Map;)Ljava/util/Map;

    .line 226
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$500(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$700(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_1

    .line 227
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    # setter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$702(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Ljava/util/List;)Ljava/util/List;

    .line 228
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryList:Ljava/util/List;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$700(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Ljava/util/List;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # getter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->categoryToProgramsMap:Ljava/util/Map;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$800(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 230
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # invokes: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->displayScreenProgramsIfReady()V
    invoke-static {v1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$400(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V

    .line 231
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 215
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$5;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method
