.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$10;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;->showStateSelectorDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

.field final synthetic val$items:[Ljava/lang/CharSequence;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;[Ljava/lang/CharSequence;)V
    .locals 0

    .prologue
    .line 570
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$10;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$10;->val$items:[Ljava/lang/CharSequence;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "item"    # I

    .prologue
    .line 572
    invoke-static {}, Lcom/poshmark/utils/AddressUtils;->statesOfUSA()Ljava/util/HashMap;

    move-result-object v0

    .line 573
    .local v0, "statesMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$10;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->currentInputEditText:Lcom/poshmark/ui/customviews/LabelledEditText;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$1100(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/ui/customviews/LabelledEditText;

    move-result-object v2

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$10;->val$items:[Ljava/lang/CharSequence;

    aget-object v1, v1, p2

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v2, v1}, Lcom/poshmark/ui/customviews/LabelledEditText;->setText(Ljava/lang/CharSequence;)V

    .line 574
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 575
    return-void
.end method
