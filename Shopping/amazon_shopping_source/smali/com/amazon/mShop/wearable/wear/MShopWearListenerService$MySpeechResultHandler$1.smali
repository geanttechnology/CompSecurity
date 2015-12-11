.class Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;
.super Landroid/os/AsyncTask;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->asyncReply(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;

.field final synthetic val$data:Ljava/lang/String;

.field final synthetic val$path:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 790
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->this$1:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;

    iput-object p2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->val$path:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->val$data:Ljava/lang/String;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 790
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 4
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 793
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->this$1:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;

    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->mNode:Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->access$1700(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->this$1:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;

    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->mMessageId:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;->access$1800(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->val$path:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MySpeechResultHandler$1;->val$data:Ljava/lang/String;

    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->reply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2, v3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1400(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 794
    const/4 v0, 0x0

    return-object v0
.end method
