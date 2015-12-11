.class Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"

# interfaces
.implements Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$SpeechResultHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MySpeechResultHandler"
.end annotation


# instance fields
.field private final mMessageId:Ljava/lang/String;

.field private final mNode:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "node"    # Ljava/lang/String;
    .param p3, "messageId"    # Ljava/lang/String;

    .prologue
    .line 774
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 775
    iput-object p2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->mNode:Ljava/lang/String;

    .line 776
    iput-object p3, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->mMessageId:Ljava/lang/String;

    .line 777
    return-void
.end method

.method static synthetic access$1700(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;

    .prologue
    .line 770
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->mNode:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;

    .prologue
    .line 770
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->mMessageId:Ljava/lang/String;

    return-object v0
.end method

.method private asyncReply(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 790
    new-instance v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;-><init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 797
    return-void
.end method


# virtual methods
.method public onError()V
    .locals 2

    .prologue
    .line 786
    const-string/jumbo v0, "/error/asr"

    const-string/jumbo v1, "Error during speech regocnition"

    invoke-direct {p0, v0, v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->asyncReply(Ljava/lang/String;Ljava/lang/String;)V

    .line 787
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 1
    .param p1, "recognizedText"    # Ljava/lang/String;

    .prologue
    .line 781
    const-string/jumbo v0, "/speech/recognize/result"

    invoke-direct {p0, v0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->asyncReply(Ljava/lang/String;Ljava/lang/String;)V

    .line 782
    return-void
.end method
