.class public Lcom/amazon/mShop/actionBar/ActionBarCartView;
.super Landroid/widget/FrameLayout;
.source "ActionBarCartView.java"

# interfaces
.implements Lcom/amazon/mShop/control/cart/CartSubscriber;
.implements Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;


# static fields
.field private static mCurrentQuantity:I


# instance fields
.field private mCartTextView:Landroid/widget/TextView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/cart/CartController;->getCartTotalQuantity()I

    move-result v0

    sput v0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    return-void
.end method

.method public static getCurrentQuantity()I
    .locals 1

    .prologue
    .line 96
    sget v0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    return v0
.end method

.method public static setCurrentQuantity(I)V
    .locals 0
    .param p0, "currentQuantity"    # I

    .prologue
    .line 100
    sput p0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    .line 101
    return-void
.end method

.method private updateActionBarCart(I)V
    .locals 0
    .param p1, "cartCount"    # I

    .prologue
    .line 91
    sput p1, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    .line 92
    invoke-direct {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->updateCartCount()V

    .line 93
    return-void
.end method

.method private updateCartCount()V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 54
    sget v1, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    const/16 v2, 0x9

    if-gt v1, v2, :cond_0

    .line 55
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCartTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->action_bar_cart_text_size:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    invoke-virtual {v1, v4, v2}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 60
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getCartPadding()[I

    move-result-object v0

    .line 61
    .local v0, "padding":[I
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCartTextView:Landroid/widget/TextView;

    aget v2, v0, v4

    const/4 v3, 0x1

    aget v3, v0, v3

    const/4 v4, 0x2

    aget v4, v0, v4

    const/4 v5, 0x3

    aget v5, v0, v5

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 63
    iget-object v2, p0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCartTextView:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    const/16 v3, 0x63

    if-le v1, v3, :cond_1

    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->max_cart_quantity:I

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    :goto_1
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 64
    return-void

    .line 57
    .end local v0    # "padding":[I
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCartTextView:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->action_bar_cart_smaller_text_size:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v2

    invoke-virtual {v1, v4, v2}, Landroid/widget/TextView;->setTextSize(IF)V

    goto :goto_0

    .line 63
    .restart local v0    # "padding":[I
    :cond_1
    sget v1, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method


# virtual methods
.method public getCartPadding()[I
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 69
    sget v2, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    const/16 v3, 0x9

    if-gt v2, v3, :cond_0

    .line 70
    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->cart_number_padding_left_v2:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 71
    .local v1, "left":I
    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->cart_number_padding_bottom_v2:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 80
    .local v0, "bottom":I
    :goto_0
    const/4 v2, 0x4

    new-array v2, v2, [I

    aput v1, v2, v4

    const/4 v3, 0x1

    aput v4, v2, v3

    const/4 v3, 0x2

    aput v4, v2, v3

    const/4 v3, 0x3

    aput v0, v2, v3

    return-object v2

    .line 72
    .end local v0    # "bottom":I
    .end local v1    # "left":I
    :cond_0
    sget v2, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCurrentQuantity:I

    const/16 v3, 0x63

    if-gt v2, v3, :cond_1

    .line 73
    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->cart_number_padding_left_v2:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 74
    .restart local v1    # "left":I
    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->cart_number_padding_bottom_two_digits:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .restart local v0    # "bottom":I
    goto :goto_0

    .line 76
    .end local v0    # "bottom":I
    .end local v1    # "left":I
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->cart_number_padding_left_three_digits:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 77
    .restart local v1    # "left":I
    invoke-virtual {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->cart_number_padding_bottom_three_digits:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .restart local v0    # "bottom":I
    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 36
    invoke-super {p0}, Landroid/widget/FrameLayout;->onAttachedToWindow()V

    .line 37
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/cart/CartController;->addCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V

    .line 38
    invoke-static {p0}, Lcom/amazon/mShop/web/MShopWebViewNotification;->addWebCartSubscriber(Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;)V

    .line 39
    invoke-direct {p0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->updateCartCount()V

    .line 40
    return-void
.end method

.method public onCartCountChanged(I)V
    .locals 0
    .param p1, "cartCount"    # I

    .prologue
    .line 116
    invoke-direct {p0, p1}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->updateActionBarCart(I)V

    .line 117
    return-void
.end method

.method public onCartDidUpdateCheckOutTimerForItem(Lcom/amazon/rio/j2me/client/services/mShop/CartItem;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .prologue
    .line 112
    return-void
.end method

.method public onCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 1
    .param p1, "cart"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 86
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/cart/CartController;->getCartTotalQuantity()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->updateActionBarCart(I)V

    .line 87
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 44
    invoke-super {p0}, Landroid/widget/FrameLayout;->onDetachedFromWindow()V

    .line 45
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/cart/CartController;->removeCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V

    .line 46
    invoke-static {p0}, Lcom/amazon/mShop/web/MShopWebViewNotification;->removeWebCartSubscriber(Lcom/amazon/mShop/web/MShopWebViewNotification$WebCartSubscriber;)V

    .line 47
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Ljava/lang/Exception;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 106
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 31
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->action_bar_cart_count:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/actionBar/ActionBarCartView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/actionBar/ActionBarCartView;->mCartTextView:Landroid/widget/TextView;

    .line 32
    return-void
.end method
