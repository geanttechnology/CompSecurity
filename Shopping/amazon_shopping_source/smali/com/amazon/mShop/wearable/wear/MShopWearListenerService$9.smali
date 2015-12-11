.class final Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$9;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;


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
    .line 185
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onHandleMessage(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p1, "service"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p2, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 188
    invoke-virtual {p1, p2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onPurchaseAsin(Lcom/google/android/gms/wearable/MessageEvent;)V

    .line 189
    return-void
.end method
