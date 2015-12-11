.class Lcom/poshmark/ui/fragments/AddressMatchFragment$2;
.super Ljava/lang/Object;
.source "AddressMatchFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/AddressMatchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/AddressMatchFragment;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$2;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 68
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$2;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$2;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$100(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/AddressCheckerResults;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/data_model/models/AddressCheckerResults;->address_entered:Lcom/poshmark/data_model/models/inner_models/Address;

    # setter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$002(Lcom/poshmark/ui/fragments/AddressMatchFragment;Lcom/poshmark/data_model/models/inner_models/Address;)Lcom/poshmark/data_model/models/inner_models/Address;

    .line 69
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$2;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressEnteredButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$300(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Landroid/widget/Button;

    move-result-object v0

    const v1, 0x7f02007d

    invoke-virtual {v0, v2, v2, v1, v2}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 70
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$2;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressFoundButton:Landroid/widget/Button;
    invoke-static {v0}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$200(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Landroid/widget/Button;

    move-result-object v0

    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 71
    return-void
.end method
