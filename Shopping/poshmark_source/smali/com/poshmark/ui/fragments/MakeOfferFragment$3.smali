.class Lcom/poshmark/ui/fragments/MakeOfferFragment$3;
.super Ljava/lang/Object;
.source "MakeOfferFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MakeOfferFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V
    .locals 0

    .prologue
    .line 131
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 134
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    # getter for: Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->access$000(Lcom/poshmark/ui/fragments/MakeOfferFragment;)Lcom/poshmark/utils/OfferFlowHandler;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    # getter for: Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;
    invoke-static {v3}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->access$000(Lcom/poshmark/ui/fragments/MakeOfferFragment;)Lcom/poshmark/utils/OfferFlowHandler;

    move-result-object v3

    instance-of v3, v3, Lcom/poshmark/utils/OfferFlowHandler;

    if-eqz v3, :cond_0

    .line 135
    const/4 v1, 0x0

    .line 136
    .local v1, "onlyAmount":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerText:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 137
    .local v0, "amount":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    # invokes: Lcom/poshmark/ui/fragments/MakeOfferFragment;->offerValid(Ljava/lang/String;)Z
    invoke-static {v3, v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->access$100(Lcom/poshmark/ui/fragments/MakeOfferFragment;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 138
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/MakeOfferFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v5, "listing"

    const-string v6, "offer_price_entered_next_tapped"

    iget-object v7, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    # getter for: Lcom/poshmark/ui/fragments/MakeOfferFragment;->flowHandler:Lcom/poshmark/utils/OfferFlowHandler;
    invoke-static {v7}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->access$000(Lcom/poshmark/ui/fragments/MakeOfferFragment;)Lcom/poshmark/utils/OfferFlowHandler;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/utils/OfferFlowHandler;->getListingDetails()Lcom/poshmark/data_model/models/ListingSummary;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMContainerActivity;

    .line 140
    .local v2, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {p1}, Landroid/view/View;->clearFocus()V

    .line 141
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v3

    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 142
    iget-object v3, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$3;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/poshmark/ui/fragments/MakeOfferFragment;->setupOffer(Ljava/lang/String;)V
    invoke-static {v3, v4}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->access$200(Lcom/poshmark/ui/fragments/MakeOfferFragment;Ljava/lang/String;)V

    .line 145
    .end local v0    # "amount":Ljava/lang/String;
    .end local v1    # "onlyAmount":Ljava/lang/String;
    .end local v2    # "parent":Lcom/poshmark/ui/PMContainerActivity;
    :cond_0
    return-void
.end method
