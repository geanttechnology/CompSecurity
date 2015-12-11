.class Lcom/amazon/mShop/sso/MShopCheckLogin$1;
.super Ljava/lang/Object;
.source "MShopCheckLogin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/MShopCheckLogin;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/MShopCheckLogin;)V
    .locals 0

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$1;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$1;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    const/4 v1, 0x0

    # invokes: Lcom/amazon/mShop/sso/MShopCheckLogin;->handleLoginResponse(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/sso/MShopCheckLogin;->access$000(Lcom/amazon/mShop/sso/MShopCheckLogin;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V

    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$1;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    # getter for: Lcom/amazon/mShop/sso/MShopCheckLogin;->mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->access$100(Lcom/amazon/mShop/sso/MShopCheckLogin;)Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lcom/amazon/mShop/sso/MShopCheckLogin$1;->this$0:Lcom/amazon/mShop/sso/MShopCheckLogin;

    # getter for: Lcom/amazon/mShop/sso/MShopCheckLogin;->mSubscriber:Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;
    invoke-static {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->access$100(Lcom/amazon/mShop/sso/MShopCheckLogin;)Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;->onError()V

    .line 123
    :cond_0
    return-void
.end method
