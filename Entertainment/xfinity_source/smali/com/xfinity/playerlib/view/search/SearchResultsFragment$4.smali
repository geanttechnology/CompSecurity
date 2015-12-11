.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;
.super Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->performSearchIfReady()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

.field final synthetic val$searchQuery:Lcom/xfinity/playerlib/view/search/SearchQuery;

.field final synthetic val$titleQuery:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;Lcom/xfinity/playerlib/view/search/SearchQuery;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .param p3, "x1"    # Landroid/content/Context;
    .param p4, "x2"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .param p5, "x3"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 294
    .local p2, "x0":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    iput-object p6, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$searchQuery:Lcom/xfinity/playerlib/view/search/SearchQuery;

    iput-object p7, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$titleQuery:Ljava/lang/String;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 24
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
    .line 298
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    move-object/from16 v0, p1

    iget-object v7, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v7, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 302
    .local v7, "fetchedTagsRoot":Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    invoke-static/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$300(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v7, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-nez v20, :cond_0

    .line 303
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    invoke-static {v0, v7}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$302(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 304
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    new-instance v21, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v22, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    invoke-static/range {v22 .. v22}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$300(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    move-result-object v22

    invoke-interface/range {v22 .. v22}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getAllPublicGenres()Ljava/util/Set;

    move-result-object v22

    invoke-direct/range {v21 .. v22}, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;-><init>(Ljava/util/Collection;)V

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->genreFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    invoke-static/range {v20 .. v21}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$402(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    .line 305
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    new-instance v21, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v22, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    invoke-static/range {v22 .. v22}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$300(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    move-result-object v22

    invoke-interface/range {v22 .. v22}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworks()Ljava/util/List;

    move-result-object v22

    invoke-direct/range {v21 .. v22}, Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;-><init>(Ljava/util/Collection;)V

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->networkFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    invoke-static/range {v20 .. v21}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$502(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    .line 308
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v21, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    move-object/from16 v20, v0

    check-cast v20, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$602(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/dibic/DibicResource;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 311
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$searchQuery:Lcom/xfinity/playerlib/view/search/SearchQuery;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getNetworkFilters()Ljava/util/Set;

    move-result-object v12

    .line 312
    .local v12, "networkFilters":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/tags/Network;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$searchQuery:Lcom/xfinity/playerlib/view/search/SearchQuery;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getGenreFilters()Ljava/util/Set;

    move-result-object v9

    .line 313
    .local v9, "genreFilters":Ljava/util/Set;, "Ljava/util/Set<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$searchQuery:Lcom/xfinity/playerlib/view/search/SearchQuery;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchQuery;->getTagFilters()Ljava/util/Set;

    move-result-object v18

    .line 314
    .local v18, "tagFilters":Ljava/util/Set;, "Ljava/util/Set<+Lcom/xfinity/playerlib/model/tags/Tag;>;"
    invoke-interface/range {v18 .. v18}, Ljava/util/Set;->size()I

    move-result v20

    const/16 v21, 0x3

    move/from16 v0, v20

    move/from16 v1, v21

    if-ge v0, v1, :cond_7

    .line 322
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$titleQuery:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v22, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->networkFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    invoke-static/range {v22 .. v22}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$500(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    move-result-object v22

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->findMostRelevantEmbeddedTag(Ljava/lang/String;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;Ljava/util/Set;)Lcom/xfinity/playerlib/model/tags/Tag;
    invoke-static {v0, v1, v2, v12}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;Ljava/util/Set;)Lcom/xfinity/playerlib/model/tags/Tag;

    move-result-object v13

    check-cast v13, Lcom/xfinity/playerlib/model/tags/Network;

    .local v13, "networkMatch":Lcom/xfinity/playerlib/model/tags/Network;
    if-eqz v13, :cond_5

    .line 323
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    sget v21, Lcom/xfinity/playerlib/R$string;->search_network_callout:I

    invoke-virtual/range {v20 .. v21}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 324
    .local v4, "calloutText":Ljava/lang/String;
    new-instance v5, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$1;

    move-object/from16 v0, p0

    invoke-direct {v5, v0, v13, v12}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$1;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;Lcom/xfinity/playerlib/model/tags/Network;Ljava/util/Set;)V

    .line 329
    .local v5, "clickListener":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener<Lcom/xfinity/playerlib/model/tags/Network;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->setUpTagCallout(Lcom/xfinity/playerlib/model/tags/Tag;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;)V
    invoke-static {v0, v13, v4, v5}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/Tag;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;)V

    .line 345
    .end local v4    # "calloutText":Ljava/lang/String;
    .end local v5    # "clickListener":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener<Lcom/xfinity/playerlib/model/tags/Network;>;"
    .end local v13    # "networkMatch":Lcom/xfinity/playerlib/model/tags/Network;
    :goto_0
    new-instance v19, Lorg/apache/commons/lang3/time/StopWatch;

    invoke-direct/range {v19 .. v19}, Lorg/apache/commons/lang3/time/StopWatch;-><init>()V

    .line 346
    .local v19, "timer":Lorg/apache/commons/lang3/time/StopWatch;
    invoke-virtual/range {v19 .. v19}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 347
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$titleQuery:Ljava/lang/String;

    move-object/from16 v21, v0

    invoke-interface/range {v20 .. v21}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;

    move-result-object v16

    .line 350
    .local v16, "results":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface/range {v18 .. v18}, Ljava/util/Set;->isEmpty()Z

    move-result v20

    if-nez v20, :cond_8

    .line 351
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$titleQuery:Ljava/lang/String;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->isEmpty()Z

    move-result v20

    if-eqz v20, :cond_1

    .line 356
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getPrograms()Ljava/util/List;

    move-result-object v16

    .line 358
    :cond_1
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .line 359
    .local v11, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_2
    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_8

    .line 360
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 361
    .local v15, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-interface {v12}, Ljava/util/Set;->isEmpty()Z

    move-result v20

    if-nez v20, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v21, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->networkMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;
    invoke-static/range {v21 .. v21}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1000(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->programMatchesAny(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Ljava/util/Set;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;)Z
    invoke-static {v0, v15, v12, v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1100(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Ljava/util/Set;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;)Z

    move-result v20

    if-eqz v20, :cond_4

    .line 362
    :cond_3
    invoke-interface {v9}, Ljava/util/Set;->isEmpty()Z

    move-result v20

    if-nez v20, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v21, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->genreMatcher:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;
    invoke-static/range {v21 .. v21}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1200(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->programMatchesAny(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Ljava/util/Set;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;)Z
    invoke-static {v0, v15, v9, v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1100(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Ljava/util/Set;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagMatcher;)Z

    move-result v20

    if-nez v20, :cond_2

    .line 363
    :cond_4
    invoke-interface {v11}, Ljava/util/Iterator;->remove()V

    goto :goto_1

    .line 330
    .end local v11    # "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v15    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v16    # "results":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v19    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    .restart local v13    # "networkMatch":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->val$titleQuery:Ljava/lang/String;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v22, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->genreFinder:Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;
    invoke-static/range {v22 .. v22}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;

    move-result-object v22

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->findMostRelevantEmbeddedTag(Ljava/lang/String;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;Ljava/util/Set;)Lcom/xfinity/playerlib/model/tags/Tag;
    invoke-static {v0, v1, v2, v9}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$700(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/EmbeddedTagFinder;Ljava/util/Set;)Lcom/xfinity/playerlib/model/tags/Tag;

    move-result-object v10

    check-cast v10, Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .local v10, "genreMatch":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    if-eqz v10, :cond_6

    .line 331
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v20

    sget v21, Lcom/xfinity/playerlib/R$string;->search_genre_callout:I

    invoke-virtual/range {v20 .. v21}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 332
    .restart local v4    # "calloutText":Ljava/lang/String;
    new-instance v6, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$2;

    move-object/from16 v0, p0

    invoke-direct {v6, v0, v10, v9}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4$2;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;Lcom/xfinity/playerlib/model/tags/OrderedTag;Ljava/util/Set;)V

    .line 337
    .local v6, "clickListener":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->setUpTagCallout(Lcom/xfinity/playerlib/model/tags/Tag;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;)V
    invoke-static {v0, v10, v4, v6}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$800(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/model/tags/Tag;Ljava/lang/String;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;)V

    goto/16 :goto_0

    .line 339
    .end local v4    # "calloutText":Ljava/lang/String;
    .end local v6    # "clickListener":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener;, "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$TagCalloutClickListener<Lcom/xfinity/playerlib/model/tags/OrderedTag;>;"
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutContainer:Landroid/view/View;
    invoke-static/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$900(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/view/View;

    move-result-object v20

    const/16 v21, 0x8

    invoke-virtual/range {v20 .. v21}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 342
    .end local v10    # "genreMatch":Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .end local v13    # "networkMatch":Lcom/xfinity/playerlib/model/tags/Network;
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->tagCalloutContainer:Landroid/view/View;
    invoke-static/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$900(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/view/View;

    move-result-object v20

    const/16 v21, 0x8

    invoke-virtual/range {v20 .. v21}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 367
    .restart local v16    # "results":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .restart local v19    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    :cond_8
    new-instance v20, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    const/16 v21, 0x1

    invoke-direct/range {v20 .. v21}, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;-><init>(Z)V

    move-object/from16 v0, v16

    move-object/from16 v1, v20

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 368
    invoke-virtual/range {v19 .. v19}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 369
    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1300()Lorg/slf4j/Logger;

    move-result-object v20

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "Search performed in "

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-interface/range {v20 .. v21}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 372
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v14

    .line 373
    .local v14, "newResults":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v8

    .line 374
    .local v8, "fullResults":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    invoke-interface/range {v16 .. v16}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v20

    :goto_2
    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->hasNext()Z

    move-result v21

    if-eqz v21, :cond_a

    invoke-interface/range {v20 .. v20}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 375
    .restart local v15    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v15}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isNew()Z

    move-result v21

    if-eqz v21, :cond_9

    .line 376
    new-instance v21, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    sget-object v22, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->NEW:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v0, v1, v15}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    move-object/from16 v0, v21

    invoke-interface {v14, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 378
    :cond_9
    new-instance v21, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    sget-object v22, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->FULL:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-direct {v0, v1, v15}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    move-object/from16 v0, v21

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 380
    .end local v15    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_a
    invoke-static {v14}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v17

    .line 381
    .local v17, "sectionedResults":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    move-object/from16 v0, v17

    invoke-interface {v0, v8}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 383
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move-object/from16 v1, v17

    # invokes: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showResults(Ljava/util/List;)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/util/List;)V

    .line 385
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-object/from16 v20, v0

    invoke-virtual/range {v20 .. v20}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v20

    if-eqz v20, :cond_b

    .line 386
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    new-instance v21, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v22, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v17

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Ljava/util/List;)V

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speakResultsRunnable:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;
    invoke-static/range {v20 .. v21}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1502(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

    .line 387
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v20, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->handler:Landroid/os/Handler;
    invoke-static/range {v20 .. v20}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1600(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Landroid/os/Handler;

    move-result-object v20

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-object/from16 v21, v0

    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->speakResultsRunnable:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;
    invoke-static/range {v21 .. v21}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->access$1500(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SpeakResultsRunnable;

    move-result-object v21

    const-wide/16 v22, 0x1f4

    invoke-virtual/range {v20 .. v23}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 390
    :cond_b
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 294
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$4;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method
