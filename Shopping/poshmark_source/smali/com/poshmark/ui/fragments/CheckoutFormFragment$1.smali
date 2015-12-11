.class Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;
.super Ljava/lang/Object;
.source "CheckoutFormFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CheckoutFormFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V
    .locals 0

    .prologue
    .line 220
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v8, 0x0

    .line 223
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v3

    .line 224
    .local v3, "order":Lcom/poshmark/data_model/models/PMOrder;
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PMOrder;->isOrderCheckoutTypeBundle()Z

    move-result v0

    .line 225
    .local v0, "isBundle":Z
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v1

    .line 226
    .local v1, "label":Ljava/lang/String;
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # getter for: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;
    invoke-static {v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$000(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Lcom/poshmark/utils/CheckoutFlowHandler;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOffer()Lcom/poshmark/data_model/models/PMOffer;

    move-result-object v2

    .line 227
    .local v2, "offer":Lcom/poshmark/data_model/models/PMOffer;
    if-eqz v0, :cond_1

    .line 228
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v6, "bundle"

    const-string v7, "secure_checkout"

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 240
    :goto_0
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->isValidInput()Z
    invoke-static {v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$100(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 241
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->saveCreditCardInfo()V
    invoke-static {v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$200(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    .line 242
    iget-object v4, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutFormFragment;->checkAddressValidity()V
    invoke-static {v4}, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->access$300(Lcom/poshmark/ui/fragments/CheckoutFormFragment;)V

    .line 244
    :cond_0
    return-void

    .line 230
    :cond_1
    if-eqz v2, :cond_2

    .line 231
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v6, "listing"

    const-string v7, "offer_payment_and_shipping_entered_next_tapped"

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 233
    :cond_2
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/ui/fragments/CheckoutFormFragment$1;->this$0:Lcom/poshmark/ui/fragments/CheckoutFormFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/CheckoutFormFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v6, "listing"

    const-string v7, "secure_checkout"

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
