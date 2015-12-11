.class public Lcom/amazon/mShop/sso/DebugListener;
.super Ljava/lang/Object;
.source "DebugListener.java"

# interfaces
.implements Lcom/amazon/mShop/control/cart/CartSubscriber;
.implements Lcom/amazon/mShop/control/home/HomeSubscriber;
.implements Lcom/amazon/mShop/model/auth/UserListener;


# static fields
.field private static volatile sInitialized:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/sso/DebugListener;->sInitialized:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static init()V
    .locals 2

    .prologue
    .line 29
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 30
    sget-boolean v1, Lcom/amazon/mShop/sso/DebugListener;->sInitialized:Z

    if-nez v1, :cond_0

    .line 31
    new-instance v0, Lcom/amazon/mShop/sso/DebugListener;

    invoke-direct {v0}, Lcom/amazon/mShop/sso/DebugListener;-><init>()V

    .line 32
    .local v0, "self":Lcom/amazon/mShop/sso/DebugListener;
    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 33
    invoke-static {}, Lcom/amazon/mShop/control/home/HomeController;->getInstance()Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/home/HomeController;->addSubscriber(Lcom/amazon/mShop/control/home/HomeSubscriber;)V

    .line 34
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/control/cart/CartController;->addCartSubscriber(Lcom/amazon/mShop/control/cart/CartSubscriber;)V

    .line 35
    const/4 v1, 0x1

    sput-boolean v1, Lcom/amazon/mShop/sso/DebugListener;->sInitialized:Z

    .line 38
    :cond_0
    return-void
.end method


# virtual methods
.method public onAvailableCountReceived(I)V
    .locals 3
    .param p1, "availableCount"    # I

    .prologue
    .line 42
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 43
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DebugListener.onAvailableCountReceived "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 44
    :cond_0
    return-void
.end method

.method public onCancelled()V
    .locals 2

    .prologue
    .line 60
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 61
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onCancelled"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 62
    :cond_0
    return-void
.end method

.method public onCartDidUpdateCheckOutTimerForItem(Lcom/amazon/rio/j2me/client/services/mShop/CartItem;)V
    .locals 2
    .param p1, "paramCartItem"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItem;

    .prologue
    .line 116
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 117
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onCartDidUpdateCheckOutTimerForItem"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    :cond_0
    return-void
.end method

.method public onCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 2
    .param p1, "paramCartItems"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    .prologue
    .line 110
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 111
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onCartReceived"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 112
    :cond_0
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 72
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 73
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DebugListener.onError "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " call "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p2}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 75
    :cond_0
    return-void
.end method

.method public onHomeCallStarted()V
    .locals 2

    .prologue
    .line 79
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 80
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onHomeCallStarted"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 81
    :cond_0
    return-void
.end method

.method public onHomeShoveler0Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 2
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 122
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 123
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onHomeShoveler0Received"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 124
    :cond_0
    return-void
.end method

.method public onHomeShoveler1Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 2
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    .prologue
    .line 128
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 129
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onHomeShoveler1Received"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 130
    :cond_0
    return-void
.end method

.method public onNotificationReceived(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 3
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 85
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 86
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DebugListener.onNotificationReceived "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 88
    :cond_0
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 48
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 49
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DebugListener.onObjectReceived "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " index "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 50
    :cond_0
    return-void
.end method

.method public onObjectsReceived()V
    .locals 2

    .prologue
    .line 54
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 55
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onObjectsReceived"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 56
    :cond_0
    return-void
.end method

.method public onPageComplete()V
    .locals 2

    .prologue
    .line 66
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 67
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onPageComplete"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    :cond_0
    return-void
.end method

.method public onPromoSlot0Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 2
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 134
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 135
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onPromoSlot0Received"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    return-void
.end method

.method public onPromoSlot1Received(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;)V
    .locals 2
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;

    .prologue
    .line 139
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 140
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.onPromoSlot1Received"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    :cond_0
    return-void
.end method

.method public preHomeCallStarted()V
    .locals 2

    .prologue
    .line 144
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 145
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.preHomeCallStarted"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 146
    :cond_0
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 3
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 98
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 99
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DebugListener.userSignedIn "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 100
    :cond_0
    return-void
.end method

.method public userSignedOut()V
    .locals 2

    .prologue
    .line 104
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 105
    const-string/jumbo v0, "Amazon.SSOUtil"

    const-string/jumbo v1, "DebugListener.userSignedOut"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    :cond_0
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 3
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 92
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 93
    const-string/jumbo v0, "Amazon.SSOUtil"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "DebugListener.userUpdated "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 94
    :cond_0
    return-void
.end method
