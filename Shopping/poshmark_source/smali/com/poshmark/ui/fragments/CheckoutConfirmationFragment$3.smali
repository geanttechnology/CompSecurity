.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->setupHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V
    .locals 0

    .prologue
    .line 199
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 202
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v0

    .line 203
    .local v0, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PMOrder;->isOrderCheckoutTypeBundle()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 204
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "bundle"

    const-string v4, "submit_order"

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->processOrder()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;)V

    .line 209
    return-void

    .line 206
    :cond_0
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "submit_order"

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
