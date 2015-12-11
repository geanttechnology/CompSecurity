.class abstract Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;
.super Lcom/amazon/mShop/wearable/AbstractResultListener;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "ErrorListener"
.end annotation


# instance fields
.field private final mError:Ljava/lang/String;

.field protected final mMessageId:Ljava/lang/String;

.field protected final mNode:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p2, "node"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 529
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 530
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "node"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;
    .param p4, "error"    # Ljava/lang/String;

    .prologue
    .line 532
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    invoke-direct {p0}, Lcom/amazon/mShop/wearable/AbstractResultListener;-><init>()V

    .line 533
    iput-object p2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->mNode:Ljava/lang/String;

    .line 534
    iput-object p4, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->mError:Ljava/lang/String;

    .line 535
    iput-object p3, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->mMessageId:Ljava/lang/String;

    .line 536
    return-void
.end method


# virtual methods
.method public final onError(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "error"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 540
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->mNode:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->mMessageId:Ljava/lang/String;

    const-string/jumbo v2, "/error"

    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1400(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 541
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->mError:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 542
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->mWearableService:Lcom/amazon/mShop/wearable/WearableService;
    invoke-static {v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1500(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;)Lcom/amazon/mShop/wearable/WearableService;

    move-result-object v0

    const-string/jumbo v1, "VoiceSearch"

    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$ErrorListener;->mError:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/wearable/WearableService;->incrementMetricCounter(Ljava/lang/String;Ljava/lang/String;I)V

    .line 544
    :cond_0
    return-void
.end method
