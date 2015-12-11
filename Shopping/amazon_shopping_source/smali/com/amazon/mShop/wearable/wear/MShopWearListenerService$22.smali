.class Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;
.super Landroid/os/AsyncTask;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->onMessageReceived(Lcom/google/android/gms/wearable/MessageEvent;)V
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
.field final synthetic this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

.field final synthetic val$handler:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;

.field final synthetic val$messageEvent:Lcom/google/android/gms/wearable/MessageEvent;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;Lcom/google/android/gms/wearable/MessageEvent;)V
    .locals 0

    .prologue
    .line 467
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    iput-object p2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->val$handler:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;

    iput-object p3, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->val$messageEvent:Lcom/google/android/gms/wearable/MessageEvent;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 467
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 3
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 470
    iget-object v0, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->val$handler:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;

    iget-object v1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->this$0:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;

    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$22;->val$messageEvent:Lcom/google/android/gms/wearable/MessageEvent;

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$MessageHandler;->onHandleMessage(Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;Lcom/google/android/gms/wearable/MessageEvent;)V

    .line 471
    const/4 v0, 0x0

    return-object v0
.end method
