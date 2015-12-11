.class abstract Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleResultListener;
.super Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/amazon/mShop/wearable/SearchResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "SimpleResultListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "node"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 578
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleResultListener;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    .line 579
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;)V

    .line 580
    return-void
.end method
