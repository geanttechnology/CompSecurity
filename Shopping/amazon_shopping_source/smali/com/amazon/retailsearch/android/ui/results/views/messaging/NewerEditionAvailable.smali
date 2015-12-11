.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;
.super Landroid/widget/TextView;
.source "NewerEditionAvailable.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;",
        ">;"
    }
.end annotation


# instance fields
.field private model:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 44
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 1
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->model:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    .line 53
    if-nez p1, :cond_0

    .line 55
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->setVisibility(I)V

    .line 61
    :goto_0
    return-void

    .line 59
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->getNewerVersionText()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->setText(Ljava/lang/CharSequence;)V

    .line 60
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 27
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method public getView()Landroid/view/View;
    .locals 0

    .prologue
    .line 84
    return-object p0
.end method

.method public handleSingleTap()V
    .locals 5

    .prologue
    .line 69
    new-instance v1, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;-><init>()V

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->model:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->getAsin()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->model:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->getNewerVersionUrl()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->model:Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailableModel;->getProductGroup()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem$Builder;->build(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    move-result-object v0

    .line 75
    .local v0, "resultItem":Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/NewerEditionAvailable;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    sget-object v2, Lcom/amazon/retailsearch/metrics/DetailPageType;->NEWER_EDITION:Lcom/amazon/retailsearch/metrics/DetailPageType;

    invoke-interface {v1, v0, v2}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->resultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Lcom/amazon/retailsearch/metrics/DetailPageType;)V

    .line 76
    return-void
.end method
