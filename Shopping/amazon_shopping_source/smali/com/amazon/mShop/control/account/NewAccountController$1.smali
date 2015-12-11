.class Lcom/amazon/mShop/control/account/NewAccountController$1;
.super Ljava/lang/Object;
.source "NewAccountController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/account/NewAccountController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/account/NewAccountController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/account/NewAccountController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->this$0:Lcom/amazon/mShop/control/account/NewAccountController;

    iput-object p2, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 53
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->this$0:Lcom/amazon/mShop/control/account/NewAccountController;

    iget-object v2, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/account/NewAccountController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v1, v2}, Lcom/amazon/mShop/control/account/NewAccountController;->access$000(Lcom/amazon/mShop/control/account/NewAccountController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 54
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->this$0:Lcom/amazon/mShop/control/account/NewAccountController;

    # invokes: Lcom/amazon/mShop/control/account/NewAccountController;->serviceCallCompleted()V
    invoke-static {v1}, Lcom/amazon/mShop/control/account/NewAccountController;->access$100(Lcom/amazon/mShop/control/account/NewAccountController;)V

    .line 56
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getLoginData()Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    move-result-object v0

    .line 58
    .local v0, "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    if-eqz v0, :cond_0

    .line 60
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->this$0:Lcom/amazon/mShop/control/account/NewAccountController;

    # getter for: Lcom/amazon/mShop/control/account/NewAccountController;->newAccountrequest:Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;
    invoke-static {v1}, Lcom/amazon/mShop/control/account/NewAccountController;->access$200(Lcom/amazon/mShop/control/account/NewAccountController;)Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->getEmail()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    .line 62
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->this$0:Lcom/amazon/mShop/control/account/NewAccountController;

    # getter for: Lcom/amazon/mShop/control/account/NewAccountController;->subscriber:Lcom/amazon/mShop/control/account/NewAccountSubscriber;
    invoke-static {v1}, Lcom/amazon/mShop/control/account/NewAccountController;->access$300(Lcom/amazon/mShop/control/account/NewAccountController;)Lcom/amazon/mShop/control/account/NewAccountSubscriber;

    move-result-object v2

    if-eqz v0, :cond_2

    const/4 v1, 0x1

    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/control/account/NewAccountController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getNotification()Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    move-result-object v3

    invoke-interface {v2, v1, v3}, Lcom/amazon/mShop/control/account/NewAccountSubscriber;->onNewAccountCreation(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 65
    .end local v0    # "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    :cond_1
    return-void

    .line 62
    .restart local v0    # "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method
