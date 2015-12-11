.class Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;
.super Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
.source "SearchResultView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/search/SearchResultView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TaskListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-direct {p0}, Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;Lcom/amazon/retailsearch/android/ui/search/SearchResultView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/search/SearchResultView;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/search/SearchResultView$1;

    .prologue
    .line 212
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;-><init>(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;)V

    return-void
.end method


# virtual methods
.method public displaySettings(Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;)V
    .locals 3
    .param p1, "displaySettings"    # Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;

    .prologue
    .line 218
    if-eqz p1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    # getter for: Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->hasViewType:Z
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->access$100(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    invoke-static {v1, v2}, Lcom/amazon/retailsearch/experiment/DisplaySettingsUtil;->displaySettingsEnabled(Landroid/content/res/Resources;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 229
    :cond_0
    :goto_0
    return-void

    .line 223
    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/DisplaySettings;->getResultLayout()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->findByNameIgnoreCase(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    .line 224
    .local v0, "newViewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    if-eqz v0, :cond_0

    .line 226
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    const/4 v2, 0x1

    # setter for: Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->hasViewType:Z
    invoke-static {v1, v2}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->access$102(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;Z)Z

    .line 227
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1, v0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->setViewType(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    goto :goto_0
.end method

.method public endPage()V
    .locals 3

    .prologue
    .line 234
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    # getter for: Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->infoBar:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->access$200(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;)Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->getViewSelector()Lcom/amazon/retailsearch/android/ui/results/ViewSelector;

    move-result-object v0

    .line 235
    .local v0, "viewSelector":Lcom/amazon/retailsearch/android/ui/results/ViewSelector;
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    # getter for: Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->hasViewType:Z
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->access$100(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    invoke-static {v1, v2}, Lcom/amazon/retailsearch/experiment/DisplaySettingsUtil;->displaySettingsEnabled(Landroid/content/res/Resources;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 245
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    const/4 v2, 0x1

    # setter for: Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->hasViewType:Z
    invoke-static {v1, v2}, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->access$102(Lcom/amazon/retailsearch/android/ui/search/SearchResultView;Z)Z

    .line 246
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/search/SearchResultView$TaskListener;->this$0:Lcom/amazon/retailsearch/android/ui/search/SearchResultView;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/search/SearchResultView;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/ViewSelector;->updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 248
    :cond_0
    return-void
.end method
