.class Lcom/poshmark/ui/fragments/ListingEditorFragment$11;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V
    .locals 0

    .prologue
    .line 777
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 780
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-boolean v1, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    if-nez v1, :cond_0

    .line 781
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 782
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->hideKeyboard()V

    move-object v0, p1

    .line 783
    check-cast v0, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 784
    .local v0, "imgSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isNextSelector()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->isImageSet()Z

    move-result v1

    if-nez v1, :cond_1

    .line 785
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v2, 0x0

    iput-boolean v2, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->handlingUserTap:Z

    .line 792
    .end local v0    # "imgSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_0
    :goto_0
    return-void

    .line 788
    .restart local v0    # "imgSelectorView":Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    .line 789
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageView:Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;

    invoke-virtual {v1}, Lcom/poshmark/ui/customviews/PMEditListingImageSelectorView;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    iput v1, v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;->currentActiveImageIndex:I

    .line 790
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$11;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const/4 v2, 0x0

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->handleNewState(Landroid/content/Intent;)V
    invoke-static {v1, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$100(Lcom/poshmark/ui/fragments/ListingEditorFragment;Landroid/content/Intent;)V

    goto :goto_0
.end method
