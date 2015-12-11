.class Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;
.super Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SimpleListener"
.end annotation


# instance fields
.field private final mPath:Ljava/lang/String;

.field private final mSuccess:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p2, "node"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "path"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 559
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v6, v5

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 560
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "node"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "path"    # Ljava/lang/String;
    .param p5, "success"    # Ljava/lang/String;
    .param p6, "error"    # Ljava/lang/String;

    .prologue
    .line 562
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    .line 563
    invoke-direct {p0, p1, p2, p3, p6}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 564
    iput-object p4, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->mPath:Ljava/lang/String;

    .line 565
    iput-object p5, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->mSuccess:Ljava/lang/String;

    .line 566
    return-void
.end method


# virtual methods
.method public onSuccess()V
    .locals 4

    .prologue
    .line 570
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->mNode:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->mMessageId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->mPath:Ljava/lang/String;

    const/4 v3, 0x0

    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1100(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    .line 571
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->mSuccess:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 572
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;
    invoke-static {v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1500(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;)Lcom/amazon/mShop/wearable/WearableService;

    move-result-object v0

    const-string/jumbo v1, "VoiceSearch"

    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SimpleListener;->mSuccess:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/wearable/WearableService;->incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;I)V

    .line 574
    :cond_0
    return-void
.end method
