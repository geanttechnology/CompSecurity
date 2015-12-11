.class final Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;
.super Ljava/lang/Object;
.source "AlipayServiceConnection.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mActivity:Landroid/app/Activity;

.field private final mCallback:Lcom/amazon/mShop/payment/alipay/AlipayCallback;

.field private final mOrderInfo:Ljava/lang/String;

.field private final mRemoteCallback:Lcom/alipay/android/app/IRemoteServiceCallback;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->TAG:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/app/Activity;Ljava/lang/String;Lcom/amazon/mShop/payment/alipay/AlipayCallback;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "orderInfo"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/mShop/payment/alipay/AlipayCallback;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 118
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$2;-><init>(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)V

    iput-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mRemoteCallback:Lcom/alipay/android/app/IRemoteServiceCallback;

    .line 30
    iput-object p1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mActivity:Landroid/app/Activity;

    .line 31
    iput-object p2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mOrderInfo:Ljava/lang/String;

    .line 32
    iput-object p3, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mCallback:Lcom/amazon/mShop/payment/alipay/AlipayCallback;

    .line 33
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)Lcom/alipay/android/app/IRemoteServiceCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mRemoteCallback:Lcom/alipay/android/app/IRemoteServiceCallback;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)Lcom/amazon/mShop/payment/alipay/AlipayCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mCallback:Lcom/amazon/mShop/payment/alipay/AlipayCallback;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->finishPayment()V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mActivity:Landroid/app/Activity;

    return-object v0
.end method

.method private finishPayment()V
    .locals 2

    .prologue
    .line 42
    iget-object v1, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mActivity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 43
    .local v0, "appContext":Landroid/content/Context;
    invoke-virtual {v0, p0}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    .line 44
    return-void
.end method

.method private invokePayServiceAsync(Lcom/alipay/android/app/IAlixPay;Ljava/lang/String;)V
    .locals 2
    .param p1, "alipayService"    # Lcom/alipay/android/app/IAlixPay;
    .param p2, "orderInfo"    # Ljava/lang/String;

    .prologue
    .line 81
    new-instance v0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection$1;-><init>(Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;Lcom/alipay/android/app/IAlixPay;Ljava/lang/String;)V

    .line 115
    .local v0, "task":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/String;>;"
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 116
    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 4
    .param p1, "name"    # Landroid/content/ComponentName;
    .param p2, "service"    # Landroid/os/IBinder;

    .prologue
    .line 48
    const/4 v1, 0x0

    .line 52
    .local v1, "result":Ljava/lang/String;
    invoke-static {p2}, Lcom/alipay/android/app/IAlixPay$Stub;->asInterface(Landroid/os/IBinder;)Lcom/alipay/android/app/IAlixPay;

    move-result-object v0

    .line 53
    .local v0, "alipayService":Lcom/alipay/android/app/IAlixPay;
    if-eqz v0, :cond_0

    .line 54
    iget-object v2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mOrderInfo:Ljava/lang/String;

    invoke-direct {p0, v0, v2}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->invokePayServiceAsync(Lcom/alipay/android/app/IAlixPay;Ljava/lang/String;)V

    .line 60
    :goto_0
    return-void

    .line 57
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mCallback:Lcom/amazon/mShop/payment/alipay/AlipayCallback;

    sget-object v3, Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;->SERVICE_BIND_FAILURE:Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;

    invoke-interface {v2, v3, v1}, Lcom/amazon/mShop/payment/alipay/AlipayCallback;->onPaymentFinish(Lcom/amazon/mShop/payment/alipay/AlipayAdapterStatus;Ljava/lang/String;)V

    .line 58
    invoke-direct {p0}, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->finishPayment()V

    goto :goto_0
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 0
    .param p1, "name"    # Landroid/content/ComponentName;

    .prologue
    .line 67
    return-void
.end method

.method public startPayment(Ljava/lang/String;)V
    .locals 3
    .param p1, "intentAction"    # Ljava/lang/String;

    .prologue
    .line 36
    iget-object v2, p0, Lcom/amazon/mShop/payment/alipay/AlipayServiceConnection;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 37
    .local v0, "appContext":Landroid/content/Context;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 38
    .local v1, "intent":Landroid/content/Intent;
    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 39
    return-void
.end method
