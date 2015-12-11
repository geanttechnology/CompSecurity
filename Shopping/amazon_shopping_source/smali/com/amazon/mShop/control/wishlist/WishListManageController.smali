.class public Lcom/amazon/mShop/control/wishlist/WishListManageController;
.super Ljava/lang/Object;
.source "WishListManageController.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# static fields
.field private static sInstance:Lcom/amazon/mShop/control/wishlist/WishListManageController;


# instance fields
.field private mCurrentList:Lcom/amazon/rio/j2me/client/services/mShop/ListList;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 43
    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mShop/control/wishlist/WishListManageController;
    .locals 2

    .prologue
    .line 31
    const-class v1, Lcom/amazon/mShop/control/wishlist/WishListManageController;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/control/wishlist/WishListManageController;->sInstance:Lcom/amazon/mShop/control/wishlist/WishListManageController;

    if-nez v0, :cond_0

    .line 32
    new-instance v0, Lcom/amazon/mShop/control/wishlist/WishListManageController;

    invoke-direct {v0}, Lcom/amazon/mShop/control/wishlist/WishListManageController;-><init>()V

    sput-object v0, Lcom/amazon/mShop/control/wishlist/WishListManageController;->sInstance:Lcom/amazon/mShop/control/wishlist/WishListManageController;

    .line 34
    :cond_0
    sget-object v0, Lcom/amazon/mShop/control/wishlist/WishListManageController;->sInstance:Lcom/amazon/mShop/control/wishlist/WishListManageController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 31
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setInstance(Lcom/amazon/mShop/control/wishlist/WishListManageController;)V
    .locals 2
    .param p0, "controller"    # Lcom/amazon/mShop/control/wishlist/WishListManageController;

    .prologue
    .line 38
    const-class v0, Lcom/amazon/mShop/control/wishlist/WishListManageController;

    monitor-enter v0

    :try_start_0
    sput-object p0, Lcom/amazon/mShop/control/wishlist/WishListManageController;->sInstance:Lcom/amazon/mShop/control/wishlist/WishListManageController;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 39
    monitor-exit v0

    return-void

    .line 38
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method


# virtual methods
.method public getCurrentList()Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListManageController;->mCurrentList:Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    return-object v0
.end method

.method public setCurrentList(Lcom/amazon/rio/j2me/client/services/mShop/ListList;)V
    .locals 0
    .param p1, "currentList"    # Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/control/wishlist/WishListManageController;->mCurrentList:Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    .line 26
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 53
    return-void
.end method

.method public userSignedOut()V
    .locals 1

    .prologue
    .line 57
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->setCurrentList(Lcom/amazon/rio/j2me/client/services/mShop/ListList;)V

    .line 58
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 48
    return-void
.end method
