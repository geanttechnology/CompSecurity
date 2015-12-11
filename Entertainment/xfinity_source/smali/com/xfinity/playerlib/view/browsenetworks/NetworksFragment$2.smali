.class Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "NetworksFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->loadResources()V
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
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .prologue
    .line 129
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 178
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 179
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 7
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
    .line 138
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->initInfoViews()V
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$100(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V

    .line 140
    iget-object v3, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v3, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 141
    .local v3, "tagsRoot":Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    # setter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static {v5, v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$202(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Lcom/xfinity/playerlib/model/dibic/DibicResource;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 144
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    # setter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworks:Ljava/util/List;
    invoke-static {v4, v5}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$302(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/util/List;)Ljava/util/List;

    .line 147
    invoke-interface {v3}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworks()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/tags/Network;

    .line 148
    .local v2, "network":Lcom/xfinity/playerlib/model/tags/Network;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$200(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v5

    invoke-interface {v5, v2}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getGenreMapForNetwork(Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/Map;

    move-result-object v0

    .line 149
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 150
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworks:Ljava/util/List;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$300(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 155
    .end local v0    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    .end local v2    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworks:Ljava/util/List;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$300(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;

    move-result-object v4

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->NETWORK_NAME_COMPARATOR:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;
    invoke-static {}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$400()Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkNameComparator;

    move-result-object v5

    invoke-static {v4, v5}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 157
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    # setter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworks:Ljava/util/List;
    invoke-static {v4, v5}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$502(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/util/List;)Ljava/util/List;

    .line 158
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworks:Ljava/util/List;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$300(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/tags/Network;

    .line 159
    .local v1, "n":Lcom/xfinity/playerlib/model/tags/Network;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 160
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworks:Ljava/util/List;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$500(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 164
    .end local v1    # "n":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_3
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->noDataSpacer:Landroid/view/View;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$600(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/View;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 165
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->noDataSpacer:Landroid/view/View;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$600(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Landroid/view/View;

    move-result-object v5

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworks:Ljava/util/List;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$500(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_5

    const/16 v4, 0x8

    :goto_2
    invoke-virtual {v5, v4}, Landroid/view/View;->setVisibility(I)V

    .line 168
    :cond_4
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    sget v5, Lcom/xfinity/playerlib/R$id;->premium_networks:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->premiumNetworks:Ljava/util/List;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$500(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;

    move-result-object v6

    # invokes: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->updateAdapterFromList(Ljava/lang/Integer;Ljava/util/List;)V
    invoke-static {v4, v5, v6}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$700(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/lang/Integer;Ljava/util/List;)V

    .line 169
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    sget v5, Lcom/xfinity/playerlib/R$id;->all_networks:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->allNetworks:Ljava/util/List;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$300(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Ljava/util/List;

    move-result-object v6

    # invokes: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->updateAdapterFromList(Ljava/lang/Integer;Ljava/util/List;)V
    invoke-static {v4, v5, v6}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$800(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Ljava/lang/Integer;Ljava/util/List;)V

    .line 171
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 172
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$000(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v4, v5}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 173
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->fixScrollYPosition()V
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$900(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)V

    .line 174
    return-void

    .line 165
    :cond_5
    const/4 v4, 0x0

    goto :goto_2
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 129
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 133
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$000(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 134
    return-void
.end method
