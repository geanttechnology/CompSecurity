.class Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;
.super Ljava/lang/Object;
.source "ListingDetailsMenuPopup.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;)V
    .locals 0

    .prologue
    .line 175
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingDetails;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v0

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-ne v0, v1, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isUserAdmin()Z

    move-result v0

    if-nez v0, :cond_0

    .line 186
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const-string v1, ""

    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v2, v2, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    const v3, 0x7f06016a

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    :goto_0
    return-void

    .line 190
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    const v2, 0x7f0600b8

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;->this$0:Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;

    iget-object v2, v2, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    const v3, 0x7f0600b9

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4$1;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4$1;-><init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showConfirmationMessage(Ljava/lang/String;Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    goto :goto_0
.end method
