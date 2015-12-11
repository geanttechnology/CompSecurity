.class public abstract Lcom/amazon/mShop/control/BaseController;
.super Ljava/lang/Object;
.source "BaseController.java"

# interfaces
.implements Lcom/amazon/mShop/control/Cancellable;
.implements Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;


# instance fields
.field private serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field private taskCallback:Lcom/amazon/mShop/control/TaskCallback;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 217
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->cancel()V

    .line 219
    invoke-virtual {p0}, Lcom/amazon/mShop/control/BaseController;->serviceCallCompleted()V

    .line 221
    :cond_0
    return-void
.end method

.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 203
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 178
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/BaseController$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/BaseController$1;-><init>(Lcom/amazon/mShop/control/BaseController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 196
    return-void
.end method

.method protected abstract getSubscriber()Lcom/amazon/mShop/control/GenericSubscriber;
.end method

.method protected getTaskCallback()Lcom/amazon/mShop/control/TaskCallback;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    return-object v0
.end method

.method protected handleServiceCallError()V
    .locals 0

    .prologue
    .line 256
    invoke-virtual {p0}, Lcom/amazon/mShop/control/BaseController;->serviceCallCompleted()V

    .line 257
    return-void
.end method

.method public hasServiceCallRunning()Z
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    .locals 1
    .param p1, "anotherServiceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected serviceCallCompleted()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 147
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    invoke-interface {v0}, Lcom/amazon/mShop/control/TaskCallback;->endTask()V

    .line 149
    iput-object v1, p0, Lcom/amazon/mShop/control/BaseController;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    .line 152
    :cond_0
    iput-object v1, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 153
    return-void
.end method

.method protected serviceCallStarted(Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 2
    .param p1, "newServiceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .param p2, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 124
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "serviceCallStarted() called when a service call is already running"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 127
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 129
    if-eqz p2, :cond_1

    .line 130
    iput-object p2, p0, Lcom/amazon/mShop/control/BaseController;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    .line 131
    invoke-interface {p2}, Lcom/amazon/mShop/control/TaskCallback;->beginTask()V

    .line 133
    :cond_1
    return-void
.end method

.method protected setServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 78
    return-void
.end method

.method protected setTaskCallback(Lcom/amazon/mShop/control/TaskCallback;)V
    .locals 0
    .param p1, "taskCallback"    # Lcom/amazon/mShop/control/TaskCallback;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/amazon/mShop/control/BaseController;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    .line 86
    return-void
.end method

.method public userCancelledSignIn()V
    .locals 0

    .prologue
    .line 249
    invoke-virtual {p0}, Lcom/amazon/mShop/control/BaseController;->serviceCallCompleted()V

    .line 250
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    if-eqz v0, :cond_0

    .line 236
    iget-object v0, p0, Lcom/amazon/mShop/control/BaseController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->replay()V

    .line 239
    :cond_0
    return-void
.end method
