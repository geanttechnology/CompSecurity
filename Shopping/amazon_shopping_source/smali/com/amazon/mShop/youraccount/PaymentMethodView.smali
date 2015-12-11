.class public Lcom/amazon/mShop/youraccount/PaymentMethodView;
.super Landroid/widget/ListView;
.source "PaymentMethodView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Landroid/view/View;Lcom/amazon/mShop/control/account/OneClickController;)V
    .locals 19
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "selectedOneClickAddress"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    .param p4, "previousView"    # Landroid/view/View;
    .param p5, "controller"    # Lcom/amazon/mShop/control/account/OneClickController;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/AmazonActivity;",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;",
            ">;",
            "Landroid/view/View;",
            "Lcom/amazon/mShop/control/account/OneClickController;",
            ")V"
        }
    .end annotation

    .prologue
    .line 35
    .local p3, "paymentMethods":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    invoke-direct/range {p0 .. p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 38
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->setHeaderDividersEnabled(Z)V

    .line 39
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->oneclick_settings_payment_method_header:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v13

    .line 41
    .local v13, "header":Landroid/view/View;
    const/4 v2, 0x0

    const/4 v3, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v13, v2, v3}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 44
    invoke-virtual/range {p5 .. p5}, Lcom/amazon/mShop/control/account/OneClickController;->getSelectedPaymentMethod()Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    move-result-object v16

    .line 45
    .local v16, "selectedPaymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    .line 46
    .local v18, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v14

    .local v14, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v14}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v14}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    .line 47
    .local v15, "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->picker_item:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/CheckedTextView;

    .line 50
    .local v12, "ctv":Landroid/widget/CheckedTextView;
    invoke-static {v15}, Lcom/amazon/mShop/ui/resources/PaymentFormat;->formatPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;)Ljava/lang/String;

    move-result-object v17

    .line 51
    .local v17, "shippingAndPayment":Ljava/lang/String;
    invoke-virtual/range {v15 .. v16}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    invoke-virtual {v12, v2}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 52
    move-object/from16 v0, v17

    invoke-virtual {v12, v0}, Landroid/widget/CheckedTextView;->setText(Ljava/lang/CharSequence;)V

    .line 53
    move-object/from16 v0, v18

    invoke-interface {v0, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 56
    .end local v12    # "ctv":Landroid/widget/CheckedTextView;
    .end local v15    # "paymentMethod":Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;
    .end local v17    # "shippingAndPayment":Ljava/lang/String;
    :cond_0
    const/4 v2, 0x0

    new-array v2, v2, [Landroid/view/View;

    move-object/from16 v0, v18

    invoke-interface {v0, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Landroid/view/View;

    .line 57
    .local v5, "viewsArray":[Landroid/view/View;
    new-instance v1, Lcom/amazon/mShop/youraccount/PaymentMethodView$1;

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->oneclick_settings_shipping_payment_method:I

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object v6, v5

    invoke-direct/range {v1 .. v6}, Lcom/amazon/mShop/youraccount/PaymentMethodView$1;-><init>(Lcom/amazon/mShop/youraccount/PaymentMethodView;Landroid/content/Context;I[Landroid/view/View;[Landroid/view/View;)V

    .line 65
    .local v1, "arrayAdapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Landroid/view/View;>;"
    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 67
    new-instance v6, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;

    move-object/from16 v7, p0

    move-object/from16 v8, p3

    move-object/from16 v9, p5

    move-object/from16 v10, p1

    move-object/from16 v11, p2

    invoke-direct/range {v6 .. v11}, Lcom/amazon/mShop/youraccount/PaymentMethodView$2;-><init>(Lcom/amazon/mShop/youraccount/PaymentMethodView;Ljava/util/List;Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 98
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 31
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 106
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/PaymentMethodView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_payment_method_title:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
