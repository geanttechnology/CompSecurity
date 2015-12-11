.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->onClick(Landroid/content/DialogInterface;I)V
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
.field final synthetic this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;)V
    .locals 0

    .prologue
    .line 202
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
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
    .line 205
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->hideProgressDialog()V

    .line 206
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 207
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;

    iget v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->val$commentIndex:I

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/ListingDetails;->deleteComment(I)V

    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;->this$2:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    # invokes: Lcom/poshmark/ui/fragments/ListingDetailsFragment;->updateCursorData()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->access$000(Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V

    .line 210
    :cond_0
    return-void
.end method
