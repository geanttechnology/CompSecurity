.class final Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$19;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 249
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 253
    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->updateMobileState()V
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$600()V

    .line 254
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 258
    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->updateMobileState()V
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$600()V

    .line 259
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 263
    return-void
.end method
