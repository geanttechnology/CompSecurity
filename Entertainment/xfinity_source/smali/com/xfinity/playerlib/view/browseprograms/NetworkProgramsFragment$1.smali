.class Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "NetworkProgramsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
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
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "error"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 167
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 10
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
    .line 122
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 123
    .local v0, "programResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v2, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e2:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 124
    .local v2, "tagsRoot":Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    iget-object v3, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v3, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 125
    .local v3, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-wide v6, v5, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->companyId:J

    invoke-interface {v2, v6, v7}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v5

    iput-object v5, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    .line 126
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v5, v5, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->categoryId:Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/model/tags/Network;->getCategoryById(Ljava/lang/String;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v5

    # setter for: Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-static {v4, v5}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->access$002(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;Lcom/xfinity/playerlib/model/tags/OrderedTag;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 128
    sget-object v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$2;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$NetworkProgramsFragment$DisplayType:[I

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->displayType:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->access$100(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 146
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-boolean v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->shouldShowFilterButton:Z

    if-eqz v4, :cond_2

    .line 147
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->showFilterButton()V

    .line 152
    :cond_0
    :goto_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    if-eqz v4, :cond_1

    .line 153
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 154
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v5, v5, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->access$000(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;->loadNetworkLogoAndCategory(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/tags/Tag;)V

    .line 160
    :cond_1
    :goto_2
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->access$000(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v5, v5, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    invoke-interface {v0, v4, v5}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingGenreAndNetwork(Lcom/xfinity/playerlib/model/tags/OrderedTag;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/List;

    move-result-object v1

    .line 161
    .local v1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    invoke-virtual {v4, v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->displayPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 162
    return-void

    .line 130
    .end local v1    # "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :pswitch_0
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v6, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    sget v7, Lcom/xfinity/playerlib/R$id;->btn_otherSort:I

    .line 131
    invoke-virtual {v4, v7}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    sget v8, Lcom/xfinity/playerlib/R$string;->chronological_movie_sort_button_text:I

    .line 132
    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    sget v9, Lcom/xfinity/playerlib/R$string;->chronological_movie_sort_button_speech:I

    .line 133
    invoke-virtual {v8, v9}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 130
    invoke-virtual {v5, v6, v4, v7, v8}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->setupOtherButton(Landroid/view/ViewGroup;Landroid/widget/Button;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 136
    :pswitch_1
    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v6, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->otherSortButton:Landroid/view/ViewGroup;

    sget v7, Lcom/xfinity/playerlib/R$id;->btn_otherSort:I

    .line 137
    invoke-virtual {v4, v7}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    sget v8, Lcom/xfinity/playerlib/R$string;->chronological_series_sort_button_text:I

    .line 138
    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    sget v9, Lcom/xfinity/playerlib/R$string;->chronological_series_sort_button_speech:I

    .line 139
    invoke-virtual {v8, v9}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 136
    invoke-virtual {v5, v6, v4, v7, v8}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->setupOtherButton(Landroid/view/ViewGroup;Landroid/widget/Button;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 142
    :pswitch_2
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    const/4 v5, 0x0

    iput-boolean v5, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->shouldShowFilterButton:Z

    goto/16 :goto_0

    .line 148
    :cond_2
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->filterButton:Landroid/view/View;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->access$200(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Landroid/view/View;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 149
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->filterSubNav:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 156
    :cond_3
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->actionBarController:Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    iget-object v5, v5, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->network:Lcom/xfinity/playerlib/model/tags/Network;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;->access$000(Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;->setNetworkNameAndCategory(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/tags/Tag;)V

    goto/16 :goto_2

    .line 128
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 119
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method
