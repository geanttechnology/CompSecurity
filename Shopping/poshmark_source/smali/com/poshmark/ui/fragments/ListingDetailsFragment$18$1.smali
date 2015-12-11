.class Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;
.super Ljava/lang/Object;
.source "ListingDetailsFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;)V
    .locals 0

    .prologue
    .line 1089
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .prologue
    .line 1092
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 1093
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    const v2, 0x7f0600b7

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 1094
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "delete_listing"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1095
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;->this$1:Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18;->this$0:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingId:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsFragment$18$1;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->deleteListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 1115
    :cond_0
    return-void
.end method
