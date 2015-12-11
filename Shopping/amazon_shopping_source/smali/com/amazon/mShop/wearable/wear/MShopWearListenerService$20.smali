.class final Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$20;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/amazon/mShop/control/account/OneClickListener;


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
    .line 266
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public oneClickStatusChanged(Z)V
    .locals 1
    .param p1, "isOneClick"    # Z

    .prologue
    .line 269
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sMobileState:Lcom/amazon/mShop/wearable/model/MobileState;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$700()Lcom/amazon/mShop/wearable/model/MobileState;

    move-result-object v0

    iput-boolean p1, v0, Lcom/amazon/mShop/wearable/model/MobileState;->oneClickEnabled:Z

    .line 270
    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->updateMobileState()V
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$600()V

    .line 271
    return-void
.end method
