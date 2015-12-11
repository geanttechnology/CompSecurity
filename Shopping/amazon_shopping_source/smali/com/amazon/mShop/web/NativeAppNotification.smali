.class public Lcom/amazon/mShop/web/NativeAppNotification;
.super Ljava/lang/Object;
.source "NativeAppNotification.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;,
        Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;
    }
.end annotation


# static fields
.field private static sNativeCarSubscribers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;",
            ">;"
        }
    .end annotation
.end field

.field private static sNativeWishListSubscriber:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeCarSubscribers:Ljava/util/List;

    .line 62
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeWishListSubscriber:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    return-void
.end method

.method public static addNativeCartSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;)V
    .locals 1
    .param p0, "subscriber"    # Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;

    .prologue
    .line 34
    sget-object v0, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeCarSubscribers:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 35
    return-void
.end method

.method public static addNativeWishListSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;)V
    .locals 1
    .param p0, "subscriber"    # Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;

    .prologue
    .line 65
    sget-object v0, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeWishListSubscriber:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 66
    return-void
.end method

.method public static notifyNativeCartChanged(I)V
    .locals 4
    .param p0, "cartItemsNum"    # I

    .prologue
    .line 42
    invoke-static {p0}, Lcom/amazon/mobile/mash/event/CartMASHNotificationReceiver;->getCartUpdateJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    .line 43
    .local v0, "eventDetail":Lorg/json/JSONObject;
    if-eqz v0, :cond_0

    .line 44
    sget-object v2, Lcom/amazon/mobile/mash/event/MASHEventType;->cartUpdated:Lcom/amazon/mobile/mash/event/MASHEventType;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/event/MASHEventType;->name()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v2, v0, v3}, Lcom/amazon/mobile/mash/api/MASHEventPlugin;->sendMASHEventBroadcast(Ljava/lang/String;Lorg/json/JSONObject;Landroid/content/Context;)V

    .line 48
    :cond_0
    sget-object v2, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeCarSubscribers:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v1, v2, -0x1

    .local v1, "i":I
    :goto_0
    if-ltz v1, :cond_1

    .line 49
    sget-object v2, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeCarSubscribers:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;

    invoke-interface {v2}, Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;->onCartChanged()V

    .line 48
    add-int/lit8 v1, v1, -0x1

    goto :goto_0

    .line 51
    :cond_1
    return-void
.end method

.method public static notifyNativeWishListChanged()V
    .locals 2

    .prologue
    .line 73
    sget-object v1, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeWishListSubscriber:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v0, v1, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_0

    .line 74
    sget-object v1, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeWishListSubscriber:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;

    invoke-interface {v1}, Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;->onWishListChanged()V

    .line 73
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 76
    :cond_0
    return-void
.end method

.method public static removeNativeCartSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;)V
    .locals 1
    .param p0, "subscriber"    # Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;

    .prologue
    .line 38
    sget-object v0, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeCarSubscribers:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 39
    return-void
.end method

.method public static removeNativeWishListSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;)V
    .locals 1
    .param p0, "subscriber"    # Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;

    .prologue
    .line 69
    sget-object v0, Lcom/amazon/mShop/web/NativeAppNotification;->sNativeWishListSubscriber:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 70
    return-void
.end method
