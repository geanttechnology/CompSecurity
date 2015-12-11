.class Lcom/amazon/mShop/control/account/SignOutController$1;
.super Ljava/lang/Object;
.source "SignOutController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/account/SignOutController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/account/SignOutController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/account/SignOutController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;)V
    .locals 0

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->this$0:Lcom/amazon/mShop/control/account/SignOutController;

    iput-object p2, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->this$0:Lcom/amazon/mShop/control/account/SignOutController;

    iget-object v1, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/account/SignOutController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/account/SignOutController;->access$000(Lcom/amazon/mShop/control/account/SignOutController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 70
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->this$0:Lcom/amazon/mShop/control/account/SignOutController;

    # invokes: Lcom/amazon/mShop/control/account/SignOutController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/account/SignOutController;->access$100(Lcom/amazon/mShop/control/account/SignOutController;)V

    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;->getFailureMessage()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 73
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 76
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->this$0:Lcom/amazon/mShop/control/account/SignOutController;

    # getter for: Lcom/amazon/mShop/control/account/SignOutController;->subscriber:Lcom/amazon/mShop/control/account/SignOutSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/account/SignOutController;->access$200(Lcom/amazon/mShop/control/account/SignOutController;)Lcom/amazon/mShop/control/account/SignOutSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/account/SignOutController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/LogoutResponse;->getFailureMessage()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/account/SignOutSubscriber;->onSignOutComplete(Ljava/lang/String;)V

    .line 78
    :cond_1
    return-void
.end method
