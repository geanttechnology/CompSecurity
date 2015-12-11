.class public Lcom/amazon/mShop/wishlist/AddToWishlistAction;
.super Ljava/lang/Object;
.source "AddToWishlistAction.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;
.implements Landroid/view/View$OnClickListener;
.implements Lcom/amazon/mShop/control/wishlist/WishListSubscriber;
.implements Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;


# instance fields
.field private dismissWhenLogin:Z

.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mAsin:Ljava/lang/String;

.field private mListChooserDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;-><init>(Z)V

    .line 58
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 1
    .param p1, "dismissWhenLogin"    # Z

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    new-instance v0, Lcom/amazon/mShop/control/wishlist/WishListController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/wishlist/WishListController;-><init>(Lcom/amazon/mShop/control/wishlist/WishListSubscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    .line 54
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->dismissWhenLogin:Z

    .line 61
    iput-boolean p1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->dismissWhenLogin:Z

    .line 62
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/wishlist/AddToWishlistAction;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wishlist/AddToWishlistAction;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method private addItemToWishList(Ljava/lang/String;)V
    .locals 4
    .param p1, "listId"    # Ljava/lang/String;

    .prologue
    .line 215
    iget-object v1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 216
    new-instance v1, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iget-object v2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->wishlist_adding_to_wishlist:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    .line 218
    .local v0, "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    iget-object v1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/wishlist/WishListController;->hasServiceCallRunning()Z

    move-result v1

    if-nez v1, :cond_0

    .line 219
    iget-object v1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    iget-object v2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    invoke-virtual {v1, v2, p1, v0}, Lcom/amazon/mShop/control/wishlist/WishListController;->addToWishList(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 222
    .end local v0    # "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    :cond_0
    return-void
.end method


# virtual methods
.method public addItem(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
    .locals 4
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "asin"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 90
    iput-object p2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    .line 91
    iget-object v1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/wishlist/WishListController;->hasServiceCallRunning()Z

    move-result v1

    if-nez v1, :cond_0

    .line 93
    new-instance v1, Lcom/amazon/mShop/TaskCallbackFactory;

    iget-object v2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v1, v2}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iget-object v2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->wishlist_getting_lists:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->getTaskCallback(Lcom/amazon/mShop/control/Cancellable;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    .line 95
    .local v0, "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    iget-object v1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    const-string/jumbo v2, "wishlist"

    invoke-virtual {v1, v2, v0}, Lcom/amazon/mShop/control/wishlist/WishListController;->getListList(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V

    .line 98
    .end local v0    # "taskCallback":Lcom/amazon/mShop/control/TaskCallback;
    :cond_0
    return-void
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 167
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startWishListActivity(Landroid/content/Context;)Z

    .line 171
    :cond_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 172
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 68
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/AmazonActivity;

    iput-object v4, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 69
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    .line 70
    instance-of v4, p1, Lcom/amazon/mShop/details/BuyButtonView;

    if-eqz v4, :cond_1

    move-object v0, p1

    .line 71
    check-cast v0, Lcom/amazon/mShop/details/BuyButtonView;

    .line 72
    .local v0, "buyButtonView":Lcom/amazon/mShop/details/BuyButtonView;
    invoke-virtual {v0}, Lcom/amazon/mShop/details/BuyButtonView;->getBuyButtonController()Lcom/amazon/mShop/control/item/BuyButtonController;

    move-result-object v1

    .line 73
    .local v1, "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/BuyButtonController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v2

    .line 74
    .local v2, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    .line 82
    .end local v0    # "buyButtonView":Lcom/amazon/mShop/details/BuyButtonView;
    .end local v1    # "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    .end local v2    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v5, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    invoke-virtual {p0, v4, v5}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->addItem(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    .line 85
    const-string/jumbo v4, "wl_add"

    invoke-static {v4}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 86
    return-void

    .line 75
    :cond_1
    instance-of v4, p1, Landroid/widget/TextView;

    if-eqz v4, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lcom/amazon/mShop/control/item/ProductController;

    if-eqz v4, :cond_0

    move-object v3, p1

    .line 76
    check-cast v3, Landroid/widget/TextView;

    .line 78
    .local v3, "textView":Landroid/widget/TextView;
    invoke-virtual {v3}, Landroid/widget/TextView;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/control/item/ProductController;

    .line 79
    .restart local v2    # "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mAsin:Ljava/lang/String;

    goto :goto_0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 5
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 112
    const-string/jumbo v2, "AmazonActivity"

    invoke-virtual {p1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 114
    iget-object v2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    .line 116
    .local v0, "currentView":Landroid/view/View;
    new-instance v1, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;

    invoke-direct {v1, p0, v0}, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;-><init>(Lcom/amazon/mShop/wishlist/AddToWishlistAction;Landroid/view/View;)V

    .line 129
    .local v1, "errorHandler":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    iget-object v2, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v3, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->ok:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v1, v0, p1, v3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;Ljava/lang/String;)V

    .line 130
    return-void
.end method

.method public onListLists(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ListList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "lists":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ListList;>;"
    const/4 v7, 0x1

    const/4 v2, 0x0

    .line 193
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, v7, :cond_0

    .line 194
    new-instance v6, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-direct {v6, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 195
    .local v6, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->wishlist_add_dialog_title:I

    invoke-virtual {v6, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 196
    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mListChooserDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    .line 197
    new-instance v1, Lcom/amazon/mShop/wishlist/WishListChooserView;

    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    const/4 v3, 0x4

    invoke-direct {v1, v0, v3, p0}, Lcom/amazon/mShop/wishlist/WishListChooserView;-><init>(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/wishlist/WishListChooserSubscriber;)V

    .line 199
    .local v1, "content":Lcom/amazon/mShop/wishlist/WishListChooserView;
    invoke-virtual {v1, p1}, Lcom/amazon/mShop/wishlist/WishListChooserView;->setWishLists(Ljava/util/List;)V

    .line 200
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mListChooserDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    move v3, v2

    move v4, v2

    move v5, v2

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/AmazonAlertDialog;->setView(Landroid/view/View;IIII)V

    .line 201
    invoke-virtual {v1, v7}, Lcom/amazon/mShop/wishlist/WishListChooserView;->setFocusable(Z)V

    .line 202
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mListChooserDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/AmazonAlertDialog;->setIcon(I)V

    .line 203
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mListChooserDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 212
    .end local v1    # "content":Lcom/amazon/mShop/wishlist/WishListChooserView;
    .end local v6    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    :goto_0
    return-void

    .line 207
    :cond_0
    const-string/jumbo v0, ""

    invoke-direct {p0, v0}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->addItemToWishList(Ljava/lang/String;)V

    .line 210
    invoke-static {}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->getInstance()Lcom/amazon/mShop/control/wishlist/WishListManageController;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->setCurrentList(Lcom/amazon/rio/j2me/client/services/mShop/ListList;)V

    goto :goto_0
.end method

.method public onListSelected(Lcom/amazon/rio/j2me/client/services/mShop/ListList;I)V
    .locals 1
    .param p1, "selectedList"    # Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    .param p2, "operationType"    # I

    .prologue
    .line 102
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->getListId()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->addItemToWishList(Ljava/lang/String;)V

    .line 103
    invoke-static {}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->getInstance()Lcom/amazon/mShop/control/wishlist/WishListManageController;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->setCurrentList(Lcom/amazon/rio/j2me/client/services/mShop/ListList;)V

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mListChooserDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 105
    return-void
.end method

.method public onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V
    .locals 2
    .param p1, "callback"    # Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;

    .prologue
    .line 139
    iget-boolean v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->dismissWhenLogin:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    if-ne p1, v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mWishListController:Lcom/amazon/mShop/control/wishlist/WishListController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/wishlist/WishListController;->dismissProgressDialog()V

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 144
    return-void
.end method

.method public onWishListItemAdded()V
    .locals 2

    .prologue
    .line 157
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->wishlist_added_to_wishlist:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 158
    invoke-static {}, Lcom/amazon/mShop/web/NativeAppNotification;->notifyNativeWishListChanged()V

    .line 159
    return-void
.end method
