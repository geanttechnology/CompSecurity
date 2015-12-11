.class Lcom/amazon/mShop/sso/MShopCheckLogin$3;
.super Ljava/lang/Object;
.source "MShopCheckLogin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/MShopCheckLogin;->completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

.field final synthetic val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/MShopCheckLogin;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 0

    .prologue
    .line 153
    iput-object p1, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    iput-object p2, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    iget-object v1, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    # invokes: Lcom/amazon/mShop/sso/MShopCheckLogin;->handleLoginResponse(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/sso/MShopCheckLogin;->access$000(Lcom/amazon/mShop/sso/MShopCheckLogin;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    .line 157
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    # getter for: Lcom/amazon/mShop/sso/MShopCheckLogin;->mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->access$100(Lcom/amazon/mShop/sso/MShopCheckLogin;)Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->val$loginResponse:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    if-eqz v0, :cond_1

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    # getter for: Lcom/amazon/mShop/sso/MShopCheckLogin;->mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->access$100(Lcom/amazon/mShop/sso/MShopCheckLogin;)Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;->onComplete()V

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 161
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$3;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    # getter for: Lcom/amazon/mShop/sso/MShopCheckLogin;->mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->access$100(Lcom/amazon/mShop/sso/MShopCheckLogin;)Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;->onError()V

    goto :goto_0
.end method
