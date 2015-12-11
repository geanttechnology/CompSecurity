.class Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;
.super Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
.source "StackLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Listener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V
    .locals 0

    .prologue
    .line 1086
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-direct {p0}, Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$1;

    .prologue
    .line 1086
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)V

    return-void
.end method


# virtual methods
.method public categoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V
    .locals 2
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;

    .prologue
    .line 1168
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # operator++ for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1108(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    .line 1169
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1100(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addCategoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;I)V

    .line 1170
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1171
    return-void
.end method

.method public clearError()V
    .locals 1

    .prologue
    .line 1108
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->clearError()V

    .line 1109
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1110
    return-void
.end method

.method public didYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 1
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 1175
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addDidYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V

    .line 1176
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1177
    return-void
.end method

.method public endPage()V
    .locals 3

    .prologue
    .line 1114
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->hideProgressBar()V

    .line 1115
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getProgressBar()Landroid/widget/LinearLayout;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->endPage(Landroid/view/View;)V

    .line 1117
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1000(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    if-eqz v0, :cond_0

    .line 1118
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loaderScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    check-cast v0, Landroid/widget/AdapterView;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$LoaderScrollListener;->processView(Landroid/widget/AdapterView;Z)V

    .line 1120
    :cond_0
    return-void
.end method

.method public endResult()V
    .locals 1

    .prologue
    .line 1089
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->endResult()V

    .line 1090
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1091
    return-void
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 1102
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addError(Ljava/lang/Exception;)V

    .line 1103
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1104
    return-void
.end method

.method public fkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V
    .locals 2
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;

    .prologue
    .line 1147
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # operator++ for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1108(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    .line 1148
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1100(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addFkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;I)V

    .line 1149
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1150
    return-void
.end method

.method public noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 1
    .param p1, "noResultsSet"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 1187
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addNoResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V

    .line 1188
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1189
    return-void
.end method

.method public preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
    .locals 1
    .param p1, "preloadImages"    # Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .prologue
    .line 1135
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V

    .line 1136
    return-void
.end method

.method public product(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 2
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 1140
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addProductWrapper(Lcom/amazon/searchapp/retailsearch/model/Product;)V

    .line 1141
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showProducts(Z)V

    .line 1142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1143
    return-void
.end method

.method public ready()V
    .locals 3

    .prologue
    .line 1125
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enabled:Z
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1000(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1127
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1128
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getFirstVisiblePosition()I

    move-result v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getLastVisiblePosition()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->loadAtBottom(II)V

    .line 1131
    :cond_0
    return-void
.end method

.method public relatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 1
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 1181
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addRelatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V

    .line 1182
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1183
    return-void
.end method

.method public spellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 2
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 1154
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # operator++ for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1108(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    .line 1155
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1100(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addSpellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;I)V

    .line 1156
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1157
    return-void
.end method

.method public startPage()V
    .locals 3

    .prologue
    .line 1094
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->startPage()V

    .line 1095
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->showProgressBar()V

    .line 1096
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1097
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getProgressBar()Landroid/widget/LinearLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->state:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$500(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayoutState;->getProductCount()I

    move-result v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->startPage(Landroid/view/View;I)V

    .line 1098
    return-void
.end method

.method public wordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V
    .locals 2
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;

    .prologue
    .line 1161
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # operator++ for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1108(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    .line 1162
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->asinGroupCount:I
    invoke-static {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->access$1100(Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;)I

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addWordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;I)V

    .line 1163
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$Listener;->this$0:Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->update()V

    .line 1164
    return-void
.end method
