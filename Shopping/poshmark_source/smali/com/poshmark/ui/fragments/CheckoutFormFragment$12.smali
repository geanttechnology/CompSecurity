.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showCreditCardExpirationSelectorDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

.field final synthetic val$v:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 598
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->val$v:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 601
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->val$v:Landroid/view/View;

    const v3, 0x7f0c009b

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/NumberPicker;

    .line 602
    .local v0, "monthPicker":Landroid/widget/NumberPicker;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->val$v:Landroid/view/View;

    const v3, 0x7f0c009c

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/NumberPicker;

    .line 603
    .local v1, "yearPicker":Landroid/widget/NumberPicker;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-virtual {v0}, Landroid/widget/NumberPicker;->getValue()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->setExpirationMonth(Ljava/lang/String;)V

    .line 604
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-virtual {v1}, Landroid/widget/NumberPicker;->getValue()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->setExpirationYear(Ljava/lang/String;)V

    .line 606
    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewHolder:Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$500(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;

    move-result-object v2

    iget-object v2, v2, Lcom/poshmark/utils/view_holders/CheckoutFormViewHolder;->expirationEditText:Lcom/poshmark/ui/customviews/LabelledEditText;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationMonth()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " / "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$12;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->cc_local:Lcom/poshmark/data_model/models/inner_models/CreditCard;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/inner_models/CreditCard;->getExpirationYear()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 607
    return-void
.end method
