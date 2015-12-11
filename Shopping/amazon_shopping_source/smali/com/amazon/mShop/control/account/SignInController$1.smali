.class Lcom/amazon/mShop/control/account/SignInController$1;
.super Ljava/lang/Object;
.source "SignInController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/account/SignInController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/account/SignInController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/account/SignInController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    iput-object p2, p0, Lcom/amazon/mShop/control/account/SignInController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/account/SignInController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 88
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    iget-object v5, p0, Lcom/amazon/mShop/control/account/SignInController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/account/SignInController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v4, v5}, Lcom/amazon/mShop/control/account/SignInController;->access$000(Lcom/amazon/mShop/control/account/SignInController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 89
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    # invokes: Lcom/amazon/mShop/control/account/SignInController;->serviceCallCompleted()V
    invoke-static {v4}, Lcom/amazon/mShop/control/account/SignInController;->access$100(Lcom/amazon/mShop/control/account/SignInController;)V

    .line 91
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getNotification()Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    move-result-object v1

    .line 92
    .local v1, "notification":Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/LoginResponse;->getLoginData()Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    move-result-object v0

    .line 94
    .local v0, "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    if-eqz v0, :cond_1

    .line 96
    if-eqz v1, :cond_3

    invoke-static {v1}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 100
    invoke-static {v2}, Lcom/amazon/mShop/control/account/OneClickController;->setDidAttemptAutoActivationOnFirstSignIn(Z)V

    .line 110
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    # getter for: Lcom/amazon/mShop/control/account/SignInController;->mNeedCallUserSignedIn:Z
    invoke-static {v4}, Lcom/amazon/mShop/control/account/SignInController;->access$300(Lcom/amazon/mShop/control/account/SignInController;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 111
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    # getter for: Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;
    invoke-static {v4}, Lcom/amazon/mShop/control/account/SignInController;->access$200(Lcom/amazon/mShop/control/account/SignInController;)Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v0}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    .line 118
    :cond_1
    :goto_1
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    # getter for: Lcom/amazon/mShop/control/account/SignInController;->subscriber:Lcom/amazon/mShop/control/account/SignInSubscriber;
    invoke-static {v4}, Lcom/amazon/mShop/control/account/SignInController;->access$400(Lcom/amazon/mShop/control/account/SignInController;)Lcom/amazon/mShop/control/account/SignInSubscriber;

    move-result-object v4

    if-eqz v0, :cond_5

    :goto_2
    invoke-interface {v4, v2, v1}, Lcom/amazon/mShop/control/account/SignInSubscriber;->onSignInCompleted(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 120
    .end local v0    # "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    .end local v1    # "notification":Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    :cond_2
    return-void

    .line 101
    .restart local v0    # "loginData":Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    .restart local v1    # "notification":Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    :cond_3
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    # getter for: Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;
    invoke-static {v4}, Lcom/amazon/mShop/control/account/SignInController;->access$200(Lcom/amazon/mShop/control/account/SignInController;)Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->getOneClickDeviceName()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 104
    invoke-static {v3}, Lcom/amazon/mShop/control/account/OneClickController;->setDidAttemptAutoActivationOnFirstSignIn(Z)V

    goto :goto_0

    .line 114
    :cond_4
    iget-object v4, p0, Lcom/amazon/mShop/control/account/SignInController$1;->this$0:Lcom/amazon/mShop/control/account/SignInController;

    # getter for: Lcom/amazon/mShop/control/account/SignInController;->loginRequest:Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;
    invoke-static {v4}, Lcom/amazon/mShop/control/account/SignInController;->access$200(Lcom/amazon/mShop/control/account/SignInController;)Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/LoginRequest;->getEmail()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v0}, Lcom/amazon/mShop/model/auth/User;->saveUser(Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    goto :goto_1

    :cond_5
    move v2, v3

    .line 118
    goto :goto_2
.end method
