.class Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;
.super Landroid/os/AsyncTask;
.source "WechatSDKManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/share/WechatSDKManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SendRequestTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;",
        "Ljava/lang/Void;",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 290
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/share/WechatSDKManager$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/share/WechatSDKManager$1;

    .prologue
    .line 290
    invoke-direct {p0}, Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;)Ljava/lang/Boolean;
    .locals 8
    .param p1, "params"    # [Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;

    .prologue
    const/4 v7, 0x0

    .line 293
    aget-object v6, p1, v7

    invoke-virtual {v6}, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->getShareContext()Landroid/content/Context;

    move-result-object v0

    .line 294
    .local v0, "context":Landroid/content/Context;
    aget-object v6, p1, v7

    invoke-virtual {v6}, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->getShareIntent()Landroid/content/Intent;

    move-result-object v1

    .line 295
    .local v1, "intent":Landroid/content/Intent;
    aget-object v6, p1, v7

    invoke-virtual {v6}, Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;->isShareToFriend()Z

    move-result v4

    .line 296
    .local v4, "shareToFriend":Z
    # invokes: Lcom/amazon/mShop/share/WechatSDKManager;->buildMessage(Landroid/content/Context;Landroid/content/Intent;Z)Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;
    invoke-static {v0, v1, v4}, Lcom/amazon/mShop/share/WechatSDKManager;->access$200(Landroid/content/Context;Landroid/content/Intent;Z)Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    move-result-object v2

    .line 298
    .local v2, "requestMessage":Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;
    new-instance v5, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;

    invoke-direct {v5}, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;-><init>()V

    .line 299
    .local v5, "wechatRequest":Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;
    # invokes: Lcom/amazon/mShop/share/WechatSDKManager;->buildTransaction(Landroid/content/Intent;)Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/share/WechatSDKManager;->access$300(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->transaction:Ljava/lang/String;

    .line 300
    iput-object v2, v5, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    .line 302
    if-eqz v4, :cond_0

    .line 303
    iput v7, v5, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->scene:I

    .line 308
    :goto_0
    invoke-static {v0}, Lcom/amazon/mShop/share/WechatSDKManager;->getAPIHandle(Landroid/content/Context;)Lcom/tencent/mm/sdk/openapi/IWXAPI;

    move-result-object v3

    .line 309
    .local v3, "sdkHandle":Lcom/tencent/mm/sdk/openapi/IWXAPI;
    if-nez v3, :cond_1

    .line 310
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    .line 312
    :goto_1
    return-object v6

    .line 305
    .end local v3    # "sdkHandle":Lcom/tencent/mm/sdk/openapi/IWXAPI;
    :cond_0
    const/4 v6, 0x1

    iput v6, v5, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->scene:I

    goto :goto_0

    .line 312
    .restart local v3    # "sdkHandle":Lcom/tencent/mm/sdk/openapi/IWXAPI;
    :cond_1
    invoke-interface {v3, v5}, Lcom/tencent/mm/sdk/openapi/IWXAPI;->sendReq(Lcom/tencent/mm/sdk/modelbase/BaseReq;)Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    goto :goto_1
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 290
    check-cast p1, [Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/share/WechatSDKManager$SendRequestTask;->doInBackground([Lcom/amazon/mShop/share/WechatSDKManager$WechatMessageParams;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
