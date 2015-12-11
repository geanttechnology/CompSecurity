.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$3;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment_Offers.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->setupHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 249
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v1}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v0

    .line 250
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "offer_submit_button_tapped"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$3;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->processOffer()V
    invoke-static {v1}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;->access$000(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers;)V

    .line 252
    return-void
.end method
