.class Lcom/poshmark/ui/fragments/AddressMatchFragment$3;
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
    .line 74
    iput-object p1, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 77
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 78
    .local v1, "i":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 79
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "CITY"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$000(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getCity()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v2, "STATE"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$000(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getState()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    const-string v2, "STREET"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$000(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getStreet()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    const-string v2, "STREET2"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$000(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getStreet2()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    const-string v2, "TYPE"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$000(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    const-string v2, "ZIP"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->selectedAddress:Lcom/poshmark/data_model/models/inner_models/Address;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$000(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/inner_models/Address;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getZip()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    const-string v2, "NAME"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$100(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/AddressCheckerResults;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/data_model/models/AddressCheckerResults;->address_entered:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    const-string v2, "PHONE"

    iget-object v3, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    # getter for: Lcom/poshmark/ui/fragments/AddressMatchFragment;->addressCheckerResults:Lcom/poshmark/data_model/models/AddressCheckerResults;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->access$100(Lcom/poshmark/ui/fragments/AddressMatchFragment;)Lcom/poshmark/data_model/models/AddressCheckerResults;

    move-result-object v3

    iget-object v3, v3, Lcom/poshmark/data_model/models/AddressCheckerResults;->address_entered:Lcom/poshmark/data_model/models/inner_models/Address;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/inner_models/Address;->getPhone()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 88
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 89
    iget-object v2, p0, Lcom/poshmark/ui/fragments/AddressMatchFragment$3;->this$0:Lcom/poshmark/ui/fragments/AddressMatchFragment;

    const/4 v3, -0x1

    invoke-virtual {v2, v3, v1}, Lcom/poshmark/ui/fragments/AddressMatchFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 90
    return-void
.end method
