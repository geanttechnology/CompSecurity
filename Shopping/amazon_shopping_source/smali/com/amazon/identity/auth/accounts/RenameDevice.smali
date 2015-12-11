.class public Lcom/amazon/identity/auth/accounts/RenameDevice;
.super Ljava/lang/Object;
.source "RenameDevice.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

.field private mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/identity/auth/accounts/RenameDevice;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/accounts/RenameDevice;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    if-nez p1, :cond_0

    .line 37
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "One or more arguments are null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 40
    :cond_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice;->mContext:Landroid/content/Context;

    .line 41
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "dcp_amazon_account_man"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    iput-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    .line 43
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/RenameDevice;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "x2"    # I
    .param p3, "x3"    # Ljava/lang/String;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    return-void
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/identity/auth/accounts/RenameDevice;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/accounts/RenameDevice;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/RenameDevice;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/accounts/RenameDevice;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "x0"    # Lcom/amazon/identity/auth/accounts/RenameDevice;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 26
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v1, "new_device_name"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method private callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V
    .locals 3
    .param p1, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p2, "errorCode"    # I
    .param p3, "errorMessage"    # Ljava/lang/String;

    .prologue
    .line 156
    sget-object v0, Lcom/amazon/identity/auth/accounts/RenameDevice;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Rename Device Error: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    invoke-static {p2}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->renameDeviceRequestFailure(I)V

    .line 158
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v1, "error_code_key"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    const-string/jumbo v1, "error_message_key"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 159
    return-void
.end method


# virtual methods
.method protected invokeWebRequest(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "webRequest"    # Lcom/amazon/identity/kcpsdk/common/WebRequest;
    .param p3, "responseParser"    # Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
    .param p4, "listener"    # Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    .param p5, "context"    # Landroid/content/Context;
    .param p6, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 141
    new-instance v0, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;

    invoke-direct {v0, p5, p1, p6}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 142
    invoke-virtual {v0, p2, p3, p4}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCaller;->createCall(Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;)Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;

    move-result-object v0

    .line 144
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/AsyncAmazonWebserviceCall;->call()V

    .line 145
    return-void
.end method

.method public renameDevice(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 8
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "deviceName"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 51
    sget-object v0, Lcom/amazon/identity/auth/accounts/RenameDevice;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Start to process rename device request"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 53
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/RenameDevice;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->doesAccountExist(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 55
    :cond_0
    const/4 v0, 0x6

    const-string/jumbo v1, "The provided amazon account could not be found on the device."

    invoke-direct {p0, p4, v0, v1}, Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 132
    :goto_0
    return-void

    .line 61
    :cond_1
    new-instance v7, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;

    invoke-direct {v7}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;-><init>()V

    .line 65
    .local v7, "request":Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;
    invoke-virtual {v7, p2}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->setDeviceName(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 67
    const/4 v0, 0x3

    const-string/jumbo v1, "Invalid device name.  The device name cannot be null or empty."

    invoke-direct {p0, p4, v0, v1}, Lcom/amazon/identity/auth/accounts/RenameDevice;->callbackOnError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    goto :goto_0

    .line 73
    :cond_2
    new-instance v4, Lcom/amazon/identity/auth/accounts/RenameDevice$1;

    invoke-direct {v4, p0, p4, p1}, Lcom/amazon/identity/auth/accounts/RenameDevice$1;-><init>(Lcom/amazon/identity/auth/accounts/RenameDevice;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;)V

    .line 126
    .local v4, "webserviceCallListener":Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;
    invoke-virtual {v7}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceRequest;->getWebRequest()Lcom/amazon/identity/kcpsdk/common/WebRequest;

    move-result-object v2

    new-instance v3, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;

    invoke-direct {v3}, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser;-><init>()V

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/RenameDevice;->mContext:Landroid/content/Context;

    move-object v0, p0

    move-object v1, p1

    move-object v6, p5

    invoke-virtual/range {v0 .. v6}, Lcom/amazon/identity/auth/accounts/RenameDevice;->invokeWebRequest(Ljava/lang/String;Lcom/amazon/identity/kcpsdk/common/WebRequest;Lcom/amazon/identity/kcpsdk/common/WebResponseParser;Lcom/amazon/identity/kcpsdk/auth/IAmazonWebserviceCallListener;Landroid/content/Context;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method
