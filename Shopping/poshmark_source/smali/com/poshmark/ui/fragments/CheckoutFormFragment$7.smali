.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


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
    .line 511
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 513
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    if-eq v2, v1, :cond_1

    .line 528
    .end local p1    # "v":Landroid/view/View;
    :cond_0
    :goto_0
    return v0

    .line 516
    .restart local p1    # "v":Landroid/view/View;
    :cond_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    if-ne p1, v2, :cond_2

    .line 518
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    check-cast p1, Lcom/poshmark/ui/customviews/LabelledEditText;

    .end local p1    # "v":Landroid/view/View;
    # setter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1102(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Lcom/poshmark/ui/customviews/LabelledEditText;)Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 519
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showCreditCardExpirationSelectorDialog()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1200(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    move v0, v1

    .line 520
    goto :goto_0

    .line 522
    .restart local p1    # "v":Landroid/view/View;
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->billingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    if-eq p1, v2, :cond_3

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->shippingStateEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    if-ne p1, v2, :cond_0

    .line 523
    :cond_3
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    check-cast p1, Lcom/poshmark/ui/customviews/LabelledEditText;

    .end local p1    # "v":Landroid/view/View;
    # setter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1102(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Lcom/poshmark/ui/customviews/LabelledEditText;)Lcom/poshmark/ui/customviews/LabelledEditText;

    .line 524
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$7;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showStateSelectorDialog()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1300(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    move v0, v1

    .line 525
    goto :goto_0
.end method
