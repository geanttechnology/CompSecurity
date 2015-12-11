.class Lcom/poshmark/ui/fragments/ListingEditorFragment$8;
.super Ljava/lang/Object;
.source "ListingEditorFragment.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingEditorFragment;->setupPriceValidators()V
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
    .line 599
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 612
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 613
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 614
    .local v0, "newText":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2, v0}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 615
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v2}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v3, v3, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->originalPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v3}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-interface {v3}, Landroid/text/Editable;->length()I

    move-result v3

    invoke-static {v2, v3}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    .line 618
    .end local v0    # "newText":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 619
    .local v1, "priceString":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 620
    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    .line 621
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$8;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v2, v1}, Lcom/poshmark/data_model/models/NewListing;->setOriginalPrice(Ljava/lang/String;)V

    .line 623
    :cond_1
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 603
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 608
    return-void
.end method
