.class Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;
.super Ljava/lang/Object;
.source "ShippingPaymentMethodView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Lcom/amazon/mShop/control/account/OneClickController;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$controller:Lcom/amazon/mShop/control/account/OneClickController;

.field final synthetic val$oneClickAddresses:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;Lcom/amazon/mShop/control/account/OneClickController;Ljava/util/List;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    iput-object p2, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    iput-object p3, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$oneClickAddresses:Ljava/util/List;

    iput-object p4, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 8
    .param p2, "clickedView"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v4, 0x0

    const/4 v1, 0x1

    .line 94
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/OneClickController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_1

    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    invoke-virtual {v0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->getHeaderViewsCount()I

    move-result v0

    sub-int v6, p3, v0

    .line 96
    .local v6, "oneClickAddressIndex":I
    if-ltz v6, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$oneClickAddresses:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v6, v0, :cond_2

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;)V

    .line 127
    .end local v6    # "oneClickAddressIndex":I
    .end local p2    # "clickedView":Landroid/view/View;
    :cond_1
    :goto_0
    return-void

    .line 102
    .restart local v6    # "oneClickAddressIndex":I
    .restart local p2    # "clickedView":Landroid/view/View;
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$oneClickAddresses:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .line 103
    .local v2, "selectedOneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getPaymentMethod()Ljava/util/List;

    move-result-object v3

    .line 104
    .local v3, "paymentMethods":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    if-eqz v3, :cond_3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    if-ge v0, v1, :cond_4

    .line 105
    :cond_3
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;)V

    .line 106
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    goto :goto_0

    .line 110
    :cond_4
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v1, :cond_6

    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    # getter for: Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->currentCheckedTextView:Landroid/widget/CheckedTextView;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->access$000(Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;)Landroid/widget/CheckedTextView;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 112
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    # getter for: Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->currentCheckedTextView:Landroid/widget/CheckedTextView;
    invoke-static {v0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->access$000(Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;)Landroid/widget/CheckedTextView;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 114
    :cond_5
    check-cast p2, Landroid/widget/CheckedTextView;

    .end local p2    # "clickedView":Landroid/view/View;
    invoke-virtual {p2, v1}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 116
    new-instance v7, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v7, v0}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    .line 117
    .local v7, "taskCallBackImpl":Lcom/amazon/mShop/TaskCallbackFactory;
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/account/OneClickController;->setSelectedOneClickAddress(Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;)V

    .line 118
    iget-object v1, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/account/OneClickController;->setSelectedPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)V

    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v4, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_saving_shipping_payment_method:I

    invoke-virtual {v7, v1, v4, v5}, Lcom/amazon/mShop/TaskCallbackFactory;->getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->doSetOneClickConfig(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    goto :goto_0

    .line 122
    .end local v7    # "taskCallBackImpl":Lcom/amazon/mShop/TaskCallbackFactory;
    .restart local p2    # "clickedView":Landroid/view/View;
    :cond_6
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    iget-object v1, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v4, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->swapPaymentMethodView(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Landroid/view/View;Lcom/amazon/mShop/control/account/OneClickController;)V

    goto :goto_0
.end method
