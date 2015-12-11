.class Lcom/poshmark/ui/fragments/ListingEditorFragment$12;
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
    .line 796
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 799
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->hideKeyboard()V

    .line 800
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->validInput()Z
    invoke-static {v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$200(Lcom/poshmark/ui/fragments/ListingEditorFragment;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 823
    :goto_0
    return-void

    .line 805
    :cond_0
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/utils/FeatureManager;->getListingFeature()Lcom/poshmark/data_model/models/inner_models/ListingFeature;

    move-result-object v1

    .line 806
    .local v1, "feature":Lcom/poshmark/data_model/models/inner_models/ListingFeature;
    const-string v0, "available"

    .line 807
    .local v0, "available":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getPrice()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->isValidSellingPrice(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/NewListing;->getInventoryStatus()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 808
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    const v4, 0x7f060175

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/ListingFeature;->getFormattedMinimumSellingPrice()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 809
    .local v2, "message":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    new-instance v4, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;-><init>(Lcom/poshmark/ui/fragments/ListingEditorFragment$12;)V

    invoke-virtual {v3, v2, v4}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->showAutoHideProgressDialogWithMessage(Ljava/lang/String;Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;)V

    goto :goto_0

    .line 821
    .end local v2    # "message":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->gotoShareScreen()V
    invoke-static {v3}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$300(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    goto :goto_0
.end method
