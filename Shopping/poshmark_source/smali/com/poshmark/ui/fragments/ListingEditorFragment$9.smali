.class Lcom/poshmark/ui/fragments/ListingEditorFragment$9;
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
    .line 626
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 8
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 639
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 640
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 641
    .local v3, "newText":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v5, v3}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 642
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v6, v6, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->listingPriceEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    invoke-virtual {v6}, Lcom/poshmark/ui/customviews/LabelledEditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->length()I

    move-result v6

    invoke-static {v5, v6}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    .line 645
    .end local v3    # "newText":Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 646
    .local v4, "priceString":Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 647
    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v5

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    .line 648
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {v5, v4}, Lcom/poshmark/data_model/models/NewListing;->setListingPrice(Ljava/lang/String;)V

    .line 649
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-lez v5, :cond_1

    .line 651
    :try_start_0
    new-instance v2, Ljava/math/BigDecimal;

    invoke-direct {v2, v4}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    .line 652
    .local v2, "listingPrice":Ljava/math/BigDecimal;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingEditorFragment;->getSellerEarnings(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    invoke-static {v5, v2}, Lcom/poshmark/ui/fragments/ListingEditorFragment;->access$000(Lcom/poshmark/ui/fragments/ListingEditorFragment;Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v1

    .line 653
    .local v1, "earnings":Ljava/math/BigDecimal;
    invoke-static {v1}, Lcom/poshmark/utils/CurrencyUtils;->getPriceAsFormattedString(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object v0

    .line 654
    .local v0, "e":Ljava/lang/String;
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingEditorFragment$9;->this$0:Lcom/poshmark/ui/fragments/ListingEditorFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;->viewHolder:Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;

    iget-object v5, v5, Lcom/poshmark/utils/view_holders/ListingEditorViewHolder;->earningsTextView:Landroid/widget/TextView;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 660
    .end local v0    # "e":Ljava/lang/String;
    .end local v1    # "earnings":Ljava/math/BigDecimal;
    .end local v2    # "listingPrice":Ljava/math/BigDecimal;
    :cond_1
    :goto_0
    return-void

    .line 655
    :catch_0
    move-exception v5

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 630
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 635
    return-void
.end method
