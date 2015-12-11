.class Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$12;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingEditorFragment$12;)V
    .locals 0

    .prologue
    .line 809
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public dialogDismissed()V
    .locals 3

    .prologue
    .line 813
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$12;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    const-string v1, "not_for_sale"

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/NewListing;->setInventoryStatus(Ljava/lang/String;)V

    .line 815
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$12;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->availabilityEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$12;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$12;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/NewListing;->getInventoryStatusDisplayString(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 816
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12$1;->this$1:Lcom/poshmark/ui/fragments/ListingEditorFragment$12;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingEditorFragment$12;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->gotoShareScreen()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$300(Lcom/poshmark/ui/fragments/ListingEditorFragment;)V

    .line 817
    return-void
.end method
