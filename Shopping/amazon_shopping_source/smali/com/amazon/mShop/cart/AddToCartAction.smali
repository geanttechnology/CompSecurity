.class public Lcom/amazon/mShop/cart/AddToCartAction;
.super Ljava/lang/Object;
.source "AddToCartAction.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;
.implements Landroid/view/View$OnClickListener;
.implements Lcom/amazon/mShop/control/Cancellable;
.implements Lcom/amazon/mShop/control/cart/CartSubscriber;


# instance fields
.field private mAsin:Ljava/lang/String;

.field protected mContext:Landroid/content/Context;

.field private mDealId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    return-void
.end method

.method private getDialogMessage(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)Ljava/lang/String;
    .locals 10
    .param p1, "cart"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 173
    const/4 v0, 0x0

    .line 174
    .local v0, "asinAdded":Z
    const/4 v4, 0x0

    .line 175
    .local v4, "minutesRemaining":I
    const/4 v5, 0x0

    .line 177
    .local v5, "title":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->getCartItem()Ljava/util/List;

    move-result-object v2

    .line 178
    .local v2, "cartItems":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/CartItem;>;"
    if-eqz v2, :cond_2

    .line 179
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .line 180
    .local v1, "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getAsin()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mAsin:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 181
    const/4 v0, 0x1

    .line 182
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getMsToExpiry()Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 183
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItem;->getMsToExpiry()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    int-to-float v6, v6

    const/high16 v7, 0x447a0000    # 1000.0f

    div-float/2addr v6, v7

    const/high16 v7, 0x42700000    # 60.0f

    div-float/2addr v6, v7

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v4

    goto :goto_0

    .line 188
    .end local v1    # "cartItem":Lcom/amazon/rio/j2me/client/services/mShop/CartItem;
    :cond_1
    if-eqz v0, :cond_3

    iget-object v6, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mDealId:Ljava/lang/String;

    if-eqz v6, :cond_3

    .line 190
    iget-object v6, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->cart_added_timed_to_cart:I

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 197
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    return-object v5

    .line 191
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_3
    if-eqz v0, :cond_2

    .line 193
    iget-object v6, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->cart_added_to_cart:I

    invoke-virtual {v6, v7}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    goto :goto_1
.end method

.method private showDialog(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 5
    .param p1, "cart"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 149
    new-instance v1, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v3, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    invoke-direct {v1, v3}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 150
    .local v1, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    const/4 v2, 0x0

    .line 153
    .local v2, "message":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 154
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->getMessages()Ljava/util/List;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 155
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/CartItems;->getMessages()Ljava/util/List;

    move-result-object v3

    const-string/jumbo v4, "\n"

    invoke-static {v3, v4}, Lcom/amazon/mShop/util/Util;->join(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 156
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 165
    :cond_0
    :goto_0
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->cart_go_to_shopping_cart_button_dialog:I

    invoke-virtual {v1, v3, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 166
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->cart_continue_shopping_button_dialog:I

    invoke-virtual {v1, v3, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 167
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    .line 168
    .local v0, "alert":Lcom/amazon/mShop/AmazonAlertDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/AmazonAlertDialog;->setIcon(I)V

    .line 169
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 170
    return-void

    .line 158
    .end local v0    # "alert":Lcom/amazon/mShop/AmazonAlertDialog;
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/mShop/cart/AddToCartAction;->getDialogMessage(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)Ljava/lang/String;

    move-result-object v2

    .line 159
    if-eqz v2, :cond_0

    .line 160
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    goto :goto_0
.end method


# virtual methods
.method public addItem(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "asin"    # Ljava/lang/String;
    .param p3, "offerId"    # Ljava/lang/String;
    .param p4, "listId"    # Ljava/lang/String;
    .param p5, "listItemId"    # Ljava/lang/String;
    .param p6, "dealId"    # Ljava/lang/String;
    .param p7, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    .line 85
    iput-object p6, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mDealId:Ljava/lang/String;

    .line 86
    iput-object p2, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mAsin:Ljava/lang/String;

    .line 88
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    .line 89
    .local v0, "cart":Lcom/amazon/mShop/control/cart/CartController;
    invoke-virtual {v0}, Lcom/amazon/mShop/control/cart/CartController;->hasServiceCallRunning()Z

    move-result v1

    if-nez v1, :cond_0

    .line 90
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/control/cart/CartController;->addCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V

    .line 92
    new-instance v1, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v2, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->cart_adding_to_cart:I

    invoke-virtual {v1, p0, v2}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v7

    .local v7, "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    move-object v1, p2

    move-object v2, p3

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    move-object v6, p7

    .line 93
    invoke-virtual/range {v0 .. v7}, Lcom/amazon/mShop/control/cart/CartController;->addToCart(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 95
    .end local v7    # "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    :cond_0
    return-void
.end method

.method public cancel()V
    .locals 2

    .prologue
    .line 231
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    .line 232
    .local v0, "cart":Lcom/amazon/mShop/control/cart/CartController;
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/control/cart/CartController;->removeCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V

    .line 233
    invoke-virtual {v0}, Lcom/amazon/mShop/control/cart/CartController;->cancel()V

    .line 234
    return-void
.end method

.method public onCartDidUpdateCheckOutTimerForItem(Lcom/amazon/rio/j2me/client/services/mShop/CartItem;)V
    .locals 0
    .param p1, "cartItem"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .prologue
    .line 239
    return-void
.end method

.method public onCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 3
    .param p1, "cart"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 138
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/cart/CartController;->removeCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V

    .line 139
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/cart/CartController;->getCartTotalQuantity()I

    move-result v0

    invoke-static {v0}, Lcom/amazon/mShop/web/NativeAppNotification;->notifyNativeCartChanged(I)V

    .line 142
    iget-object v0, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    const-wide/16 v1, 0x32

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/UIUtils;->vibrate(Landroid/content/Context;J)V

    .line 144
    invoke-direct {p0, p1}, Lcom/amazon/mShop/cart/AddToCartAction;->showDialog(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 145
    return-void
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 206
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 208
    iget-object v0, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startCartActivity(Landroid/content/Context;)Z

    .line 209
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 212
    const-string/jumbo v0, "crt_dia_go_to_crt"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 223
    :goto_0
    return-void

    .line 213
    :cond_0
    const/4 v0, -0x2

    if-ne p2, v0, :cond_1

    .line 215
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 218
    const-string/jumbo v0, "crt_dia_con_shop"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 221
    :cond_1
    const-string/jumbo v0, "Amazon.AddToCartAction"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Unexpected button click with which="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 11
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 65
    instance-of v0, p1, Lcom/amazon/mShop/details/BuyButtonView;

    if-eqz v0, :cond_0

    move-object v8, p1

    .line 67
    check-cast v8, Lcom/amazon/mShop/details/BuyButtonView;

    .line 68
    .local v8, "buyButtonView":Lcom/amazon/mShop/details/BuyButtonView;
    invoke-virtual {v8}, Lcom/amazon/mShop/details/BuyButtonView;->getBuyButtonController()Lcom/amazon/mShop/control/item/BuyButtonController;

    move-result-object v9

    .line 69
    .local v9, "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-virtual {v9}, Lcom/amazon/mShop/control/item/BuyButtonController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v10

    .line 70
    .local v10, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v2

    .line 71
    .local v2, "asin":Ljava/lang/String;
    invoke-virtual {v9}, Lcom/amazon/mShop/control/item/BuyButtonController;->getOfferId()Ljava/lang/String;

    move-result-object v3

    .line 72
    .local v3, "offerId":Ljava/lang/String;
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/ProductController;->getClickStreamTag()Lcom/amazon/mShop/control/item/ClickStreamTag;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v7

    .line 73
    .local v7, "clickStreamOrigin":Ljava/lang/String;
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/ProductController;->getListId()Ljava/lang/String;

    move-result-object v4

    .line 74
    .local v4, "listId":Ljava/lang/String;
    invoke-virtual {v10}, Lcom/amazon/mShop/control/item/ProductController;->getListItemId()Ljava/lang/String;

    move-result-object v5

    .line 75
    .local v5, "listItemId":Ljava/lang/String;
    invoke-virtual {v9}, Lcom/amazon/mShop/control/item/BuyButtonController;->getDealId()Ljava/lang/String;

    move-result-object v6

    .line 76
    .local v6, "dealId":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Lcom/amazon/mShop/cart/AddToCartAction;->addItem(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    const-string/jumbo v0, "dp_buy_crt"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 81
    .end local v2    # "asin":Ljava/lang/String;
    .end local v3    # "offerId":Ljava/lang/String;
    .end local v4    # "listId":Ljava/lang/String;
    .end local v5    # "listItemId":Ljava/lang/String;
    .end local v6    # "dealId":Ljava/lang/String;
    .end local v7    # "clickStreamOrigin":Ljava/lang/String;
    .end local v8    # "buyButtonView":Lcom/amazon/mShop/details/BuyButtonView;
    .end local v9    # "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    .end local v10    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_0
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 5
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 102
    instance-of v2, p1, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mDealId:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 105
    invoke-static {p1}, Lcom/amazon/mShop/util/UIUtils;->getServerMessageForException(Ljava/lang/Exception;)Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    .line 106
    iget-object v2, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->deal_cannot_add_to_cart:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;)V

    .line 129
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v2

    invoke-virtual {v2, p0}, Lcom/amazon/mShop/control/cart/CartController;->removeCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V

    .line 130
    return-void

    .line 108
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    invoke-static {v2, p1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/Exception;)V

    goto :goto_0

    .line 112
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    check-cast v2, Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 114
    .local v0, "currentView":Landroid/view/View;
    new-instance v1, Lcom/amazon/mShop/cart/AddToCartAction$1;

    invoke-direct {v1, p0, v0}, Lcom/amazon/mShop/cart/AddToCartAction$1;-><init>(Lcom/amazon/mShop/cart/AddToCartAction;Landroid/view/View;)V

    .line 127
    .local v1, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v2, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    check-cast v2, Lcom/amazon/mShop/AmazonActivity;

    iget-object v3, p0, Lcom/amazon/mShop/cart/AddToCartAction;->mContext:Landroid/content/Context;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->ok:I

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v1, v0, p1, v3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_0
.end method
