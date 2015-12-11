.class Lcom/amazon/mShop/youraccount/PaymentMethodView$2;
.super Ljava/lang/Object;
.source "PaymentMethodView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/youraccount/PaymentMethodView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Landroid/view/View;Lcom/amazon/mShop/control/account/OneClickController;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/youraccount/PaymentMethodView;

.field final synthetic val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field final synthetic val$controller:Lcom/amazon/mShop/control/account/OneClickController;

.field final synthetic val$paymentMethods:Ljava/util/List;

.field final synthetic val$selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/youraccount/PaymentMethodView;Ljava/util/List;Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/PaymentMethodView;

    iput-object p2, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$paymentMethods:Ljava/util/List;

    iput-object p3, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    iput-object p4, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iput-object p5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 9
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
    .line 71
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->this$0:Lcom/amazon/mShop/youraccount/PaymentMethodView;

    invoke-virtual {v5}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->getHeaderViewsCount()I

    move-result v5

    sub-int v3, p3, v5

    .line 72
    .local v3, "paymentMethodIndex":I
    if-ltz v3, :cond_0

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$paymentMethods:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    if-le v3, v5, :cond_1

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 79
    :cond_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getChildCount()I

    move-result v5

    if-ge v1, v5, :cond_4

    .line 80
    invoke-virtual {p1, v1}, Landroid/widget/AdapterView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 81
    .local v0, "childView":Landroid/view/View;
    instance-of v5, v0, Landroid/widget/Checkable;

    if-eqz v5, :cond_2

    move-object v5, v0

    .line 82
    check-cast v5, Landroid/widget/Checkable;

    if-ne v0, p2, :cond_3

    const/4 v6, 0x1

    :goto_2
    invoke-interface {v5, v6}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 79
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 82
    :cond_3
    const/4 v6, 0x0

    goto :goto_2

    .line 86
    .end local v0    # "childView":Landroid/view/View;
    :cond_4
    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/account/OneClickController;->hasServiceCallRunning()Z

    move-result v5

    if-nez v5, :cond_0

    .line 87
    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$paymentMethods:Ljava/util/List;

    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 89
    .local v2, "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    new-instance v4, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v4, v5}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    .line 90
    .local v4, "taskCallBack":Lcom/amazon/mShop/TaskCallbackFactory;
    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v6, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$selectedOneClickAddress:Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/control/account/OneClickController;->setSelectedOneClickAddress(Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;)V

    .line 91
    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    invoke-virtual {v5, v2}, Lcom/amazon/mShop/control/account/OneClickController;->setSelectedPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)V

    .line 92
    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v6, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$controller:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v7, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_saving_shipping_payment_method:I

    invoke-virtual {v4, v6, v7, v8}, Lcom/amazon/mShop/TaskCallbackFactory;->getPopViewTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/mShop/control/account/OneClickController;->doSetOneClickConfig(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 93
    iget-object v5, p0, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;->val$amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v5}, Lcom/amazon/mShop/AmazonActivity;->popView()Z

    goto :goto_0
.end method
