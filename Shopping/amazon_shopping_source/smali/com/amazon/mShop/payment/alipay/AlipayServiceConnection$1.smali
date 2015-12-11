.class Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;
.super Landroid/os/AsyncTask;
.source "AlipayServiceConnection.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->invokePayServiceAsync(Lcom/alipay/android/app/IAlixPay;Ljava/lang/String;)V
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
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

.field final synthetic val$alipayService:Lcom/alipay/android/app/IAlixPay;

.field final synthetic val$orderInfo:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;Lcom/alipay/android/app/IAlixPay;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    iput-object p2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->val$alipayService:Lcom/alipay/android/app/IAlixPay;

    iput-object p3, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->val$orderInfo:Ljava/lang/String;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 81
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 85
    const/4 v0, 0x0

    .line 86
    .local v0, "result":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->val$alipayService:Lcom/alipay/android/app/IAlixPay;

    if-eqz v1, :cond_0

    .line 88
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->val$alipayService:Lcom/alipay/android/app/IAlixPay;

    iget-object v2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    # getter for: Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mRemoteCallback:Lcom/alipay/android/app/IRemoteServiceCallback;
    invoke-static {v2}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->access$000(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)Lcom/alipay/android/app/IRemoteServiceCallback;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/alipay/android/app/IAlixPay;->registerCallback(Lcom/alipay/android/app/IRemoteServiceCallback;)V

    .line 89
    iget-object v1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->val$alipayService:Lcom/alipay/android/app/IAlixPay;

    iget-object v2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->val$orderInfo:Ljava/lang/String;

    invoke-interface {v1, v2}, Lcom/alipay/android/app/IAlixPay;->Pay(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 90
    iget-object v1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->val$alipayService:Lcom/alipay/android/app/IAlixPay;

    iget-object v2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    # getter for: Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mRemoteCallback:Lcom/alipay/android/app/IRemoteServiceCallback;
    invoke-static {v2}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->access$000(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)Lcom/alipay/android/app/IRemoteServiceCallback;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/alipay/android/app/IAlixPay;->unregisterCallback(Lcom/alipay/android/app/IRemoteServiceCallback;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 103
    :cond_0
    :goto_0
    return-object v0

    .line 94
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 81
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    # getter for: Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mCallback:Lcom/amazon/mShop/payment/alipay/AlipayCallback;
    invoke-static {v0}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->access$100(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)Lcom/amazon/mShop/payment/alipay/AlipayCallback;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->SERVICE_INVOKE_SUCCESS:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    invoke-interface {v0, v1, p1}, Lcom/amazon/mShop/payment/alipay/AlipayCallback;->onPaymentFinish(Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;->this$0:Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    # invokes: Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->finishPayment()V
    invoke-static {v0}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->access$200(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)V

    .line 111
    return-void
.end method
