.class Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;
.super Ljava/lang/Object;
.source "ListingDetailsDrawerFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V
    .locals 0

    .prologue
    .line 271
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 276
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 277
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMContainerActivity;->hideDrawer()V

    .line 281
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v1

    sget-object v2, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v1, v2, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->isUserAdmin()Z

    move-result v1

    if-nez v1, :cond_0

    .line 284
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const-string v2, ""

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const v4, 0x7f06016a

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    :goto_0
    return-void

    .line 288
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const v3, 0x7f0600b8

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;

    const v4, 0x7f0600b9

    invoke-virtual {v3, v4}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;)V

    invoke-virtual {v1, v2, v3, v4}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    goto :goto_0
.end method
