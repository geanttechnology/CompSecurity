.class final Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$21;
.super Landroid/os/AsyncTask;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMobileState()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
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
.field final synthetic val$responseJson:[B


# direct methods
.method constructor <init>([B)V
    .locals 0

    .prologue
    .line 363
    iput-object p1, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$21;->val$responseJson:[B

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 363
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$21;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 4
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v3, 0x0

    .line 366
    # getter for: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sWearableNode:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1000()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "/query/mobileState"

    iget-object v2, p0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$21;->val$responseJson:[B

    # invokes: Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->sendMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    invoke-static {v0, v3, v1, v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;->access$1100(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V

    .line 367
    return-object v3
.end method
