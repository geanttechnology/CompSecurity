.class final Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$2;
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
    .line 143
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onHandleMessage(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0
    .param p1, "service"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
    .param p2, "messageEvent"    # Lcom/google/android/gms/wearable/MessageEvent;

    .prologue
    .line 146
    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onSpeechReconition(Lcom/google/android/gms/wearable/MessageEvent;)V
    invoke-static {p1, p2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$000(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V

    .line 147
    return-void
.end method
