.class public Lcom/amazon/mShop/details/BuyButtonView;
.super Landroid/widget/Button;
.source "BuyButtonView.java"


# instance fields
.field protected buyButtonController:Lcom/amazon/mShop/control/item/BuyButtonController;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 34
    return-void
.end method


# virtual methods
.method public getBuyButtonController()Lcom/amazon/mShop/control/item/BuyButtonController;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyButtonView;->buyButtonController:Lcom/amazon/mShop/control/item/BuyButtonController;

    return-object v0
.end method

.method protected getFriendAppText()Ljava/lang/String;
    .locals 3

    .prologue
    .line 207
    iget-object v2, p0, Lcom/amazon/mShop/details/BuyButtonView;->buyButtonController:Lcom/amazon/mShop/control/item/BuyButtonController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/BuyButtonController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v0

    .line 208
    .local v0, "product":Lcom/amazon/mShop/control/item/ProductController;
    invoke-static {v0}, Lcom/amazon/mShop/details/FriendAppProxy$Factory;->getProxy(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/details/FriendAppProxy;

    move-result-object v1

    .line 209
    .local v1, "proxy":Lcom/amazon/mShop/details/FriendAppProxy;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyButtonView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/details/FriendAppProxy;->getButtonLabel(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public getPrimeText(Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;Z)Ljava/lang/String;
    .locals 9
    .param p1, "primeOneClickShippingOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    .param p2, "isPreorder"    # Z

    .prologue
    .line 170
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getDeliveryDate()Lcom/amazon/rio/j2me/client/services/mShop/Date;

    move-result-object v1

    .line 171
    .local v1, "deliveryDate":Lcom/amazon/rio/j2me/client/services/mShop/Date;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getName()Ljava/lang/String;

    move-result-object v2

    .line 172
    .local v2, "name":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getPrice()Ljava/lang/String;

    move-result-object v3

    .line 174
    .local v3, "price":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyButtonView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 175
    .local v4, "res":Landroid/content/res/Resources;
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    .line 177
    .local v5, "sb":Ljava/lang/StringBuffer;
    if-eqz p2, :cond_0

    .line 178
    sget v6, Lcom/amazon/mShop/android/lib/R$string;->buy_box_pre_order:I

    invoke-virtual {v4, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 181
    :cond_0
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 182
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v6

    if-lez v6, :cond_1

    .line 183
    const-string/jumbo v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 185
    :cond_1
    invoke-virtual {v5, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 188
    :cond_2
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v6

    if-lez v6, :cond_3

    .line 189
    const-string/jumbo v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 192
    :cond_3
    invoke-virtual {v5, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 194
    if-eqz v1, :cond_4

    .line 195
    const-string/jumbo v6, "\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 197
    invoke-static {v1}, Lcom/amazon/mShop/ui/resources/DateFormat;->getCalendarFromDate(Lcom/amazon/rio/j2me/client/services/mShop/Date;)Ljava/util/Calendar;

    move-result-object v0

    .line 199
    .local v0, "date":Ljava/util/Calendar;
    sget v6, Lcom/amazon/mShop/android/lib/R$string;->buy_box_1_click_prime_with_get_it_by_promise_android:I

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v0, v7, v8

    const/4 v8, 0x1

    aput-object v0, v7, v8

    const/4 v8, 0x2

    aput-object v0, v7, v8

    invoke-virtual {v4, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 203
    .end local v0    # "date":Ljava/util/Calendar;
    :cond_4
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public update(Lcom/amazon/mShop/control/item/BuyButtonController;)V
    .locals 18
    .param p1, "buyButtonController"    # Lcom/amazon/mShop/control/item/BuyButtonController;

    .prologue
    .line 43
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/details/BuyButtonView;->buyButtonController:Lcom/amazon/mShop/control/item/BuyButtonController;

    .line 45
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v11

    .line 46
    .local v11, "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/control/item/BuyButtonController;->getPrimeOneClickShippingOffer()Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    move-result-object v6

    .line 48
    .local v6, "primeOneClickShippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    .line 50
    .local v7, "res":Landroid/content/res/Resources;
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_CART:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_3

    .line 51
    sget v12, Lcom/amazon/mShop/android/lib/R$string;->buy_box_add_to_cart:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(I)V

    .line 77
    :cond_0
    :goto_0
    sget v12, Lcom/amazon/mShop/android/lib/R$integer;->text_min_lines_buy_button:I

    invoke-virtual {v7, v12}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v4

    .line 78
    .local v4, "minLines":I
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    sget v13, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v12, v13}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v12

    float-to-int v5, v12

    .line 79
    .local v5, "padding":I
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    sget v13, Lcom/amazon/mShop/android/lib/R$dimen;->padding_small:I

    invoke-virtual {v12, v13}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v12

    float-to-int v8, v12

    .line 80
    .local v8, "smallPadding":I
    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/BuyButtonType;->getStyleColor()I

    move-result v12

    sparse-switch v12, :sswitch_data_0

    .line 112
    :goto_1
    invoke-virtual {v11}, Lcom/amazon/mShop/control/item/BuyButtonType;->getActionIcon()I

    move-result v12

    sparse-switch v12, :sswitch_data_1

    .line 124
    const/4 v3, 0x0

    .line 128
    .local v3, "icon":Landroid/graphics/drawable/Drawable;
    :goto_2
    const/16 v2, 0x7f

    .line 129
    .local v2, "alpha":I
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->isEnabled()Z

    move-result v12

    if-eqz v12, :cond_1

    .line 130
    const/16 v2, 0xff

    .line 132
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getCurrentTextColor()I

    move-result v9

    .line 133
    .local v9, "textColor":I
    invoke-static {v9}, Landroid/graphics/Color;->red(I)I

    move-result v12

    invoke-static {v9}, Landroid/graphics/Color;->green(I)I

    move-result v13

    invoke-static {v9}, Landroid/graphics/Color;->blue(I)I

    move-result v14

    invoke-static {v2, v12, v13, v14}, Landroid/graphics/Color;->argb(IIII)I

    move-result v12

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setTextColor(I)V

    .line 134
    if-eqz v3, :cond_2

    .line 135
    invoke-virtual {v3, v2}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 138
    :cond_2
    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v3, v12, v13, v14}, Lcom/amazon/mShop/details/BuyButtonView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 140
    return-void

    .line 52
    .end local v2    # "alpha":I
    .end local v3    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v4    # "minLines":I
    .end local v5    # "padding":I
    .end local v8    # "smallPadding":I
    .end local v9    # "textColor":I
    :cond_3
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_WISH_LIST:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_4

    .line 53
    sget v12, Lcom/amazon/mShop/android/lib/R$string;->buy_box_add_to_wishlist:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(I)V

    goto :goto_0

    .line 54
    :cond_4
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_5

    .line 55
    sget v12, Lcom/amazon/mShop/android/lib/R$string;->buy_box_buy_now:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(I)V

    goto :goto_0

    .line 56
    :cond_5
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_6

    .line 57
    sget v12, Lcom/amazon/mShop/android/lib/R$string;->buy_box_buy_now_with_one_click:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(I)V

    goto :goto_0

    .line 58
    :cond_6
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_7

    .line 59
    sget v12, Lcom/amazon/mShop/android/lib/R$string;->buy_box_preorder_with_one_click:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(I)V

    goto/16 :goto_0

    .line 60
    :cond_7
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_8

    .line 61
    sget v12, Lcom/amazon/mShop/android/lib/R$string;->buy_box_pre_order_now:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(I)V

    goto/16 :goto_0

    .line 62
    :cond_8
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->SEE_MORE_BUYING_OPTIONS:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_9

    .line 63
    sget v12, Lcom/amazon/mShop/android/lib/R$string;->buy_box_see_all_buying_options:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(I)V

    goto/16 :goto_0

    .line 64
    :cond_9
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_a

    .line 65
    const/4 v12, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v12}, Lcom/amazon/mShop/details/BuyButtonView;->getPrimeText(Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;Z)Ljava/lang/String;

    move-result-object v12

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 66
    :cond_a
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_b

    .line 67
    const/4 v12, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v12}, Lcom/amazon/mShop/details/BuyButtonView;->getPrimeText(Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;Z)Ljava/lang/String;

    move-result-object v12

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 68
    :cond_b
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->FRIEND_APP_BUTTON:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_c

    .line 69
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getFriendAppText()Ljava/lang/String;

    move-result-object v12

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 70
    :cond_c
    sget-object v12, Lcom/amazon/mShop/control/item/BuyButtonType;->SUBSCRIBER_AND_SAVE:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v12, v11, :cond_0

    .line 71
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    sget v13, Lcom/amazon/mShop/android/lib/R$string;->sns_dp_subscribe_button:I

    const/4 v14, 0x3

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getResources()Landroid/content/res/Resources;

    move-result-object v16

    sget v17, Lcom/amazon/mShop/android/lib/R$string;->sns_dp_button_prefix:I

    invoke-virtual/range {v16 .. v17}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x1

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/details/BuyButtonView;->getResources()Landroid/content/res/Resources;

    move-result-object v16

    sget v17, Lcom/amazon/mShop/android/lib/R$string;->sns_dp_block_save:I

    invoke-virtual/range {v16 .. v17}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    const/4 v15, 0x2

    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/control/item/BuyButtonController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/mShop/control/item/ProductController;->getExtraOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getSnsDiscountPercent()Ljava/lang/String;

    move-result-object v16

    aput-object v16, v14, v15

    invoke-virtual {v12, v13, v14}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 82
    .restart local v4    # "minLines":I
    .restart local v5    # "padding":I
    .restart local v8    # "smallPadding":I
    :sswitch_0
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_orange:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setBackgroundResource(I)V

    .line 83
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/details/BuyButtonView;->setMinLines(I)V

    .line 84
    move-object/from16 v0, p0

    invoke-virtual {v0, v5, v8, v5, v8}, Lcom/amazon/mShop/details/BuyButtonView;->setPadding(IIII)V

    goto/16 :goto_1

    .line 87
    :sswitch_1
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_gold:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setBackgroundResource(I)V

    .line 88
    const/4 v12, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setMinLines(I)V

    .line 89
    const/4 v12, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v5, v5, v12, v5}, Lcom/amazon/mShop/details/BuyButtonView;->setPadding(IIII)V

    .line 90
    sget v12, Lcom/amazon/mShop/android/lib/R$dimen;->buy_box_add_button_text_size:I

    invoke-virtual {v7, v12}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v10

    .line 91
    .local v10, "textPixelSize":I
    const/4 v12, 0x0

    int-to-float v13, v10

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Lcom/amazon/mShop/details/BuyButtonView;->setTextSize(IF)V

    .line 92
    const/16 v12, 0x13

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setGravity(I)V

    goto/16 :goto_1

    .line 95
    .end local v10    # "textPixelSize":I
    :sswitch_2
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_gray:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setBackgroundResource(I)V

    .line 96
    const/4 v12, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setMinLines(I)V

    .line 97
    sget v12, Lcom/amazon/mShop/android/lib/R$dimen;->buy_box_add_button_text_size:I

    invoke-virtual {v7, v12}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v10

    .line 98
    .restart local v10    # "textPixelSize":I
    const/4 v12, 0x0

    int-to-float v13, v10

    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v13}, Lcom/amazon/mShop/details/BuyButtonView;->setTextSize(IF)V

    .line 99
    const/16 v12, 0x11

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setGravity(I)V

    goto/16 :goto_1

    .line 102
    .end local v10    # "textPixelSize":I
    :sswitch_3
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_taupe:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setBackgroundResource(I)V

    .line 103
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/details/BuyButtonView;->setMinLines(I)V

    goto/16 :goto_1

    .line 106
    :sswitch_4
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_orange:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setBackgroundResource(I)V

    .line 107
    const/4 v12, 0x2

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/amazon/mShop/details/BuyButtonView;->setMinLines(I)V

    goto/16 :goto_1

    .line 114
    :sswitch_5
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_icn_arrow:I

    invoke-virtual {v7, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 115
    .restart local v3    # "icon":Landroid/graphics/drawable/Drawable;
    goto/16 :goto_2

    .line 117
    .end local v3    # "icon":Landroid/graphics/drawable/Drawable;
    :sswitch_6
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_icn_cart:I

    invoke-virtual {v7, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 118
    .restart local v3    # "icon":Landroid/graphics/drawable/Drawable;
    goto/16 :goto_2

    .line 120
    .end local v3    # "icon":Landroid/graphics/drawable/Drawable;
    :sswitch_7
    sget v12, Lcom/amazon/mShop/android/lib/R$drawable;->btn_icn_1_click:I

    invoke-virtual {v7, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 121
    .restart local v3    # "icon":Landroid/graphics/drawable/Drawable;
    goto/16 :goto_2

    .line 80
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_3
        0x4 -> :sswitch_1
        0x8 -> :sswitch_4
        0x10 -> :sswitch_2
    .end sparse-switch

    .line 112
    :sswitch_data_1
    .sparse-switch
        0x20 -> :sswitch_7
        0x40 -> :sswitch_5
        0x80 -> :sswitch_6
    .end sparse-switch
.end method
