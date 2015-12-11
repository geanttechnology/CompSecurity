.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->onClick(Landroid/content/DialogInterface;I)V
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
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;)V
    .locals 0

    .prologue
    .line 1095
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;

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
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1098
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1099
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->hideProgressDialog()V

    .line 1100
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v1

    if-nez v1, :cond_1

    .line 1103
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingDeletedMessage(Ljava/lang/String;)V

    .line 1104
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 1105
    .local v0, "parent":Lcom/poshmark/ui/PMActivity;
    invoke-virtual {v0}, Lcom/poshmark/ui/PMActivity;->onBackPressed()V

    .line 1112
    .end local v0    # "parent":Lcom/poshmark/ui/PMActivity;
    :cond_0
    :goto_0
    return-void

    .line 1108
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    new-instance v2, Lcom/poshmark/ui/model/ActionErrorContext;

    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    sget-object v4, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->DELETE_LISTING:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v5, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const v6, 0x7f0600e2

    invoke-virtual {v5, v6}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v3, v4, v5}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_0
.end method
