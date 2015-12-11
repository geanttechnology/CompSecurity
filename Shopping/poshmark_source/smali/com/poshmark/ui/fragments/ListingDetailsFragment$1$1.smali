.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

.field final synthetic val$comment:Lcom/poshmark/data_model/models/inner_models/Comment;

.field final synthetic val$commentIndex:I


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;Lcom/poshmark/data_model/models/inner_models/Comment;I)V
    .locals 0

    .prologue
    .line 196
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->val$comment:Lcom/poshmark/data_model/models/inner_models/Comment;

    iput p3, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->val$commentIndex:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 199
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 200
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "delete_listing_comment"

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const-string v1, "Deleting Comment..."

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 202
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;->val$comment:Lcom/poshmark/data_model/models/inner_models/Comment;

    iget-object v1, v1, Lcom/poshmark/data_model/models/inner_models/Comment;->id:Ljava/lang/String;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment$1$1;)V

    invoke-static {v0, v1, v2}, Lcom/poshmark/http/api/PMApi;->deleteComment(Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 214
    :cond_0
    return-void
.end method
