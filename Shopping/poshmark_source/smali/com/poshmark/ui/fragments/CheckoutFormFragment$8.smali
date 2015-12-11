.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Landroid/view/View$OnFocusChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0

    .prologue
    .line 532
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFocusChange(Landroid/view/View;Z)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "hasFocus"    # Z

    .prologue
    .line 535
    if-eqz p2, :cond_0

    .line 536
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    if-ne p1, v0, :cond_1

    .line 537
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->hideKeyboard()V

    .line 538
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    check-cast p1, Lcom/poshmark/ui/customviews/LabelledEditText;

    .end local p1    # "v":Landroid/view/View;
    # setter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1102(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Lcom/poshmark/ui/customviews/LabelledEditText;)Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 539
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showCreditCardExpirationSelectorDialog()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1200(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    .line 547
    :cond_0
    :goto_0
    return-void

    .line 541
    .restart local p1    # "v":Landroid/view/View;
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    if-eq p1, v0, :cond_2

    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    if-ne p1, v0, :cond_0

    .line 542
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->hideKeyboard()V

    .line 543
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    check-cast p1, Lcom/poshmark/ui/customviews/LabelledEditText;

    .end local p1    # "v":Landroid/view/View;
    # setter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1102(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Lcom/poshmark/ui/customviews/LabelledEditText;)Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 544
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showStateSelectorDialog()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1300(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    goto :goto_0
.end method
