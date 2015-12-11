.class Lcom/amazon/mShop/control/BaseController$1;
.super Ljava/lang/Object;
.source "BaseController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/BaseController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/BaseController;

.field final synthetic val$e:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/BaseController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 178
    iput-object p1, p0, Lcom/amazon/mShop/control/BaseController$1;->this$0:Lcom/amazon/mShop/control/BaseController;

    iput-object p2, p0, Lcom/amazon/mShop/control/BaseController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/BaseController$1;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 182
    iget-object v1, p0, Lcom/amazon/mShop/control/BaseController$1;->this$0:Lcom/amazon/mShop/control/BaseController;

    iget-object v2, p0, Lcom/amazon/mShop/control/BaseController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/BaseController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 183
    iget-object v1, p0, Lcom/amazon/mShop/control/BaseController$1;->this$0:Lcom/amazon/mShop/control/BaseController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/BaseController;->getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;

    move-result-object v0

    .line 185
    .local v0, "subscriber":Lcom/amazon/mShop/control/GenericSubscriber;
    iget-object v1, p0, Lcom/amazon/mShop/control/BaseController$1;->val$e:Ljava/lang/Exception;

    instance-of v1, v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    if-eqz v1, :cond_1

    sget-object v2, Lcom/amazon/rio/j2me/client/services/ApplicationException;->USER_NOT_AUTHENTICATED:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/mShop/control/BaseController$1;->val$e:Ljava/lang/Exception;

    check-cast v1, Lcom/amazon/rio/j2me/client/services/ApplicationException;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/ApplicationException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    instance-of v1, v0, Lcom/amazon/mShop/model/auth/UserSubscriber;

    if-eqz v1, :cond_1

    .line 188
    check-cast v0, Lcom/amazon/mShop/model/auth/UserSubscriber;

    .end local v0    # "subscriber":Lcom/amazon/mShop/control/GenericSubscriber;
    iget-object v1, p0, Lcom/amazon/mShop/control/BaseController$1;->this$0:Lcom/amazon/mShop/control/BaseController;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/model/auth/UserSubscriber;->onRequiresUserLogin(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 194
    :cond_0
    :goto_0
    return-void

    .line 190
    .restart local v0    # "subscriber":Lcom/amazon/mShop/control/GenericSubscriber;
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/control/BaseController$1;->this$0:Lcom/amazon/mShop/control/BaseController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/BaseController;->handleServiceCallError()V

    .line 191
    iget-object v1, p0, Lcom/amazon/mShop/control/BaseController$1;->val$e:Ljava/lang/Exception;

    iget-object v2, p0, Lcom/amazon/mShop/control/BaseController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/control/GenericSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0
.end method
