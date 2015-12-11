.class Lcom/poshmark/webcommands/WebCommandsManager$14$1;
.super Ljava/lang/Object;
.source "WebCommandsManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/webcommands/WebCommandsManager$14;->runOnUIThread(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/ListingDetails;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/webcommands/WebCommandsManager$14;

.field final synthetic val$id:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/poshmark/webcommands/WebCommandsManager$14;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 890
    iput-object p1, p0, Lcom/poshmark/webcommands/WebCommandsManager$14$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$14;

    iput-object p2, p0, Lcom/poshmark/webcommands/WebCommandsManager$14$1;->val$id:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/ListingDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 893
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ListingDetails;>;"
    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager$14$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$14;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager$14;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/MappPageFragment;->hideProgressDialog()V

    .line 894
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v4

    if-nez v4, :cond_0

    .line 895
    iget-object v1, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v1, Lcom/poshmark/data_model/models/ListingDetails;

    .line 896
    .local v1, "details":Lcom/poshmark/data_model/models/ListingDetails;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v2

    .line 897
    .local v2, "listingOwner":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->getListingStatus()Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    move-result-object v3

    .line 898
    .local v3, "status":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    sget-object v4, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    if-eq v3, v4, :cond_1

    .line 900
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 901
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "NEW_LISTING"

    const/4 v5, 0x0

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 902
    const-string v4, "ID"

    iget-object v5, p0, Lcom/poshmark/webcommands/WebCommandsManager$14$1;->val$id:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 903
    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager$14$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$14;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager$14;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager;->parentActivity:Lcom/poshmark/ui/PMActivity;

    const-class v5, Lcom/poshmark/ui/fragments/ListingEditorFragment;

    invoke-virtual {v4, v0, v5, v1}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 908
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "details":Lcom/poshmark/data_model/models/ListingDetails;
    .end local v2    # "listingOwner":Ljava/lang/String;
    .end local v3    # "status":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    :cond_0
    :goto_0
    return-void

    .line 905
    .restart local v1    # "details":Lcom/poshmark/data_model/models/ListingDetails;
    .restart local v2    # "listingOwner":Ljava/lang/String;
    .restart local v3    # "status":Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    :cond_1
    iget-object v4, p0, Lcom/poshmark/webcommands/WebCommandsManager$14$1;->this$1:Lcom/poshmark/webcommands/WebCommandsManager$14;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager$14;->this$0:Lcom/poshmark/webcommands/WebCommandsManager;

    iget-object v4, v4, Lcom/poshmark/webcommands/WebCommandsManager;->fragment:Lcom/poshmark/ui/fragments/MappPageFragment;

    const-string v5, ""

    const-string v6, "Cannot edit Listing"

    invoke-virtual {v4, v5, v6}, Lcom/poshmark/ui/fragments/MappPageFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
