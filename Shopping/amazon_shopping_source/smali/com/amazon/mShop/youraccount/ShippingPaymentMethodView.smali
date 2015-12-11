.class public Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;
.super Landroid/widget/ListView;
.source "ShippingPaymentMethodView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# instance fields
.field private currentCheckedTextView:Landroid/widget/CheckedTextView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Lcom/amazon/mShop/control/account/OneClickController;)V
    .locals 17
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "selectedOneClickAddress"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    .param p4, "controller"    # Lcom/amazon/mShop/control/account/OneClickController;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/AmazonActivity;",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;",
            ">;",
            "Lcom/amazon/mShop/control/account/OneClickController;",
            ")V"
        }
    .end annotation

    .prologue
    .line 38
    .local p3, "oneClickAddresses":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;>;"
    invoke-direct/range {p0 .. p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 34
    const/4 v5, 0x0

    move-object/from16 v0, p0

    iput-object v5, v0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->currentCheckedTextView:Landroid/widget/CheckedTextView;

    .line 41
    const/4 v5, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->setHeaderDividersEnabled(Z)V

    .line 42
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$layout;->oneclick_settings_shipping_payment_method_header:I

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v12

    .line 44
    .local v12, "header":Landroid/view/View;
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v5, v6}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 48
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v5

    const/4 v6, 0x1

    if-ge v5, v6, :cond_0

    .line 49
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->choose_default_address_and_payment_title:I

    invoke-virtual {v12, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Landroid/view/View;->setVisibility(I)V

    .line 53
    :cond_0
    new-instance v16, Ljava/util/ArrayList;

    invoke-direct/range {v16 .. v16}, Ljava/util/ArrayList;-><init>()V

    .line 54
    .local v16, "views":Ljava/util/List;, "Ljava/util/List<Landroid/view/View;>;"
    const/4 v13, 0x0

    .local v13, "i":I
    :goto_0
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->size()I

    move-result v5

    if-ge v13, v5, :cond_4

    .line 55
    move-object/from16 v0, p3

    invoke-interface {v0, v13}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .line 57
    .local v14, "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    invoke-virtual {v14}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v10

    .line 58
    .local v10, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    if-nez v10, :cond_2

    .line 54
    :cond_1
    :goto_1
    add-int/lit8 v13, v13, 0x1

    goto :goto_0

    .line 62
    :cond_2
    invoke-virtual {v14}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getPaymentMethod()Ljava/util/List;

    move-result-object v15

    .line 63
    .local v15, "paymentMethods":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    if-eqz v15, :cond_1

    invoke-interface {v15}, Ljava/util/List;->size()I

    move-result v5

    const/4 v6, 0x1

    if-lt v5, v6, :cond_1

    .line 67
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$layout;->picker_item:I

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/CheckedTextView;

    .line 70
    .local v11, "ctv":Landroid/widget/CheckedTextView;
    move-object/from16 v0, p2

    invoke-virtual {v14, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 71
    const/4 v5, 0x1

    invoke-virtual {v11, v5}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 72
    move-object/from16 v0, p0

    iput-object v11, v0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->currentCheckedTextView:Landroid/widget/CheckedTextView;

    .line 75
    :cond_3
    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->getShippingPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v11, v5}, Landroid/widget/CheckedTextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    move-object/from16 v0, v16

    invoke-interface {v0, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 79
    .end local v10    # "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    .end local v11    # "ctv":Landroid/widget/CheckedTextView;
    .end local v14    # "oneClickAddress":Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;
    .end local v15    # "paymentMethods":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    :cond_4
    const/4 v5, 0x0

    new-array v5, v5, [Landroid/view/View;

    move-object/from16 v0, v16

    invoke-interface {v0, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Landroid/view/View;

    .line 80
    .local v8, "viewsArray":[Landroid/view/View;
    new-instance v4, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$1;

    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->oneclick_settings_shipping_payment_method:I

    move-object/from16 v5, p0

    move-object/from16 v6, p1

    move-object v9, v8

    invoke-direct/range {v4 .. v9}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$1;-><init>(Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;Landroid/content/Context;I[Landroid/view/View;[Landroid/view/View;)V

    .line 88
    .local v4, "arrayAdapter":Landroid/widget/ArrayAdapter;, "Landroid/widget/ArrayAdapter<Landroid/view/View;>;"
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 90
    new-instance v5, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;

    move-object/from16 v0, p0

    move-object/from16 v1, p4

    move-object/from16 v2, p3

    move-object/from16 v3, p1

    invoke-direct {v5, v0, v1, v2, v3}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView$2;-><init>(Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;Lcom/amazon/mShop/control/account/OneClickController;Ljava/util/List;Lcom/amazon/mShop/AmazonActivity;)V

    move-object/from16 v0, p0

    invoke-virtual {v0, v5}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 129
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;)Landroid/widget/CheckedTextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->currentCheckedTextView:Landroid/widget/CheckedTextView;

    return-object v0
.end method

.method private getShippingPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;)Ljava/lang/String;
    .locals 5
    .param p1, "oneClickAddress"    # Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;

    .prologue
    const/4 v4, 0x1

    .line 145
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getAddress()Lcom/amazon/rio/j2me/client/services/mShop/Address;

    move-result-object v0

    .line 146
    .local v0, "address":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;->getPaymentMethod()Ljava/util/List;

    move-result-object v2

    .line 148
    .local v2, "paymentMethods":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 149
    .local v1, "out":Ljava/lang/StringBuffer;
    invoke-static {v0, v1, v4}, Lcom/amazon/mShop/ui/resources/AddressFormat;->appendAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;Ljava/lang/StringBuffer;I)V

    .line 150
    const-string/jumbo v3, "\n"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 151
    if-eqz v2, :cond_0

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    if-ne v4, v3, :cond_0

    .line 152
    const/4 v3, 0x0

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;

    invoke-static {v3, v1}, Lcom/amazon/mShop/ui/resources/PaymentFormat;->appendPaymentMethod(Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;Ljava/lang/StringBuffer;)V

    .line 157
    :goto_0
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 154
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_select_payment_method:I

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 166
    invoke-virtual {p0}, Lcom/amazon/mShop/youraccount/ShippingPaymentMethodView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->one_click_settings_shipping_payment_method_title:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected swapPaymentMethodView(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Landroid/view/View;Lcom/amazon/mShop/control/account/OneClickController;)V
    .locals 6
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
    .line 139
    .local p3, "paymentMethods":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/PaymentMethod;>;"
    new-instance v0, Lcom/amazon/mShop/youraccount/PaymentMethodView;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p0

    move-object v5, p5

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/youraccount/PaymentMethodView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/OneClickAddress;Ljava/util/List;Landroid/view/View;Lcom/amazon/mShop/control/account/OneClickController;)V

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonActivity;->swapView(Landroid/view/View;)V

    .line 142
    return-void
.end method
