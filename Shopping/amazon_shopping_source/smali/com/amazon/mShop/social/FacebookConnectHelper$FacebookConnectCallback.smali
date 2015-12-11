.class public Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;
.super Ljava/lang/Object;
.source "FacebookConnectHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/social/FacebookConnectHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "FacebookConnectCallback"
.end annotation


# instance fields
.field private jsFailureCallback:Ljava/lang/String;

.field private jsSuccessCallback:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/social/FacebookConnectHelper;

.field private webView:Lcom/amazon/mShop/web/MShopWebView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/social/FacebookConnectHelper;Lcom/amazon/mShop/web/MShopWebView;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p2, "webView"    # Lcom/amazon/mShop/web/MShopWebView;
    .param p3, "successCallback"    # Ljava/lang/String;
    .param p4, "failureCallback"    # Ljava/lang/String;

    .prologue
    .line 156
    iput-object p1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->this$0:Lcom/amazon/mShop/social/FacebookConnectHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 157
    iput-object p2, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->webView:Lcom/amazon/mShop/web/MShopWebView;

    .line 158
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "javascript:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->jsSuccessCallback:Ljava/lang/String;

    .line 159
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "javascript:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->jsFailureCallback:Ljava/lang/String;

    .line 160
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;)Lcom/amazon/mShop/web/MShopWebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;

    .prologue
    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->webView:Lcom/amazon/mShop/web/MShopWebView;

    return-object v0
.end method

.method private callBackWebView(Ljava/lang/String;)V
    .locals 2
    .param p1, "callbackUrl"    # Ljava/lang/String;

    .prologue
    .line 171
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback$1;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback$1;-><init>(Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 177
    return-void
.end method


# virtual methods
.method public executeFailureCallback(Ljava/lang/String;)V
    .locals 2
    .param p1, "errorMsg"    # Ljava/lang/String;

    .prologue
    .line 167
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->jsFailureCallback:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "(\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\')"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->callBackWebView(Ljava/lang/String;)V

    .line 168
    return-void
.end method

.method public executeSuccessCallback(Ljava/lang/String;)V
    .locals 2
    .param p1, "accessToken"    # Ljava/lang/String;

    .prologue
    .line 163
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->jsSuccessCallback:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "(\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\')"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/social/FacebookConnectHelper$FacebookConnectCallback;->callBackWebView(Ljava/lang/String;)V

    .line 164
    return-void
.end method
