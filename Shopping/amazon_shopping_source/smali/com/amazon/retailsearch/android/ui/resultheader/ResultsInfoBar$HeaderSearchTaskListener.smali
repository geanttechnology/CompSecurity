.class Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;
.super Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
.source "ResultsInfoBar.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HeaderSearchTaskListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)V
    .locals 0

    .prologue
    .line 430
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-direct {p0}, Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;

    .prologue
    .line 430
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;-><init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)V

    return-void
.end method


# virtual methods
.method public breadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V
    .locals 1
    .param p1, "breadcrumb"    # Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .prologue
    .line 459
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->setBreadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V

    .line 460
    return-void
.end method

.method public refinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 1
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 447
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    .line 448
    return-void
.end method

.method public resultMetadata(Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;)V
    .locals 4
    .param p1, "resultMetadata"    # Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;

    .prologue
    .line 465
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    # getter for: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasMetadata:Z
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$500(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 468
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;->getTotalResults()J

    move-result-wide v1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/ResultsMetadata;->getResultsLabel()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->setCountAndLabel(JLjava/lang/String;)V

    .line 469
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasMetadata:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->access$502(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Z)Z

    .line 471
    :cond_0
    return-void
.end method

.method public sort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 1
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 453
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V

    .line 454
    return-void
.end method

.method public startResult()V
    .locals 1

    .prologue
    .line 435
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->clearAll()V

    .line 436
    return-void
.end method

.method public trackingInfo(Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;)V
    .locals 2
    .param p1, "trackingInfo"    # Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    .prologue
    .line 441
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;->getSearchAliasDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->setDepartment(Ljava/lang/String;)V

    .line 442
    return-void
.end method
