.class Lcom/amazon/mShop/control/device/DeviceRegisterController$1;
.super Ljava/lang/Object;
.source "DeviceRegisterController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/device/DeviceRegisterController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    iput-object p2, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 57
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    iget-object v4, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/device/DeviceRegisterController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v3, v4}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->access$000(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 58
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    # invokes: Lcom/amazon/mShop/control/device/DeviceRegisterController;->serviceCallCompleted()V
    invoke-static {v3}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->access$100(Lcom/amazon/mShop/control/device/DeviceRegisterController;)V

    .line 60
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;->getApplicationInstallId()Ljava/lang/String;

    move-result-object v1

    .line 61
    .local v1, "mAppInstallID":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/KiangRegisterResponse;->getSecret()Ljava/lang/String;

    move-result-object v2

    .line 63
    .local v2, "secret":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 70
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    new-instance v4, Lcom/amazon/mShop/control/device/DeviceRegisterController$1$1;

    invoke-direct {v4, p0}, Lcom/amazon/mShop/control/device/DeviceRegisterController$1$1;-><init>(Lcom/amazon/mShop/control/device/DeviceRegisterController$1;)V

    iget-object v5, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->getDelayTime()I

    move-result v5

    int-to-long v5, v5

    invoke-interface {v3, v4, v5, v6}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 88
    .end local v1    # "mAppInstallID":Ljava/lang/String;
    .end local v2    # "secret":Ljava/lang/String;
    :goto_0
    return-void

    .line 79
    .restart local v1    # "mAppInstallID":Ljava/lang/String;
    .restart local v2    # "secret":Ljava/lang/String;
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 80
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "applicationInstallId"

    invoke-interface {v0, v3, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    const-string/jumbo v3, "applicationSecretKey"

    invoke-interface {v0, v3, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    # getter for: Lcom/amazon/mShop/control/device/DeviceRegisterController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;
    invoke-static {v3}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->access$200(Lcom/amazon/mShop/control/device/DeviceRegisterController;)Lcom/amazon/mShop/control/device/KiangSubscriber;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/control/device/KiangSubscriber;->onRegisterCompleted()V

    goto :goto_0

    .line 86
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .end local v1    # "mAppInstallID":Ljava/lang/String;
    .end local v2    # "secret":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    # getter for: Lcom/amazon/mShop/control/device/DeviceRegisterController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;
    invoke-static {v3}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->access$200(Lcom/amazon/mShop/control/device/DeviceRegisterController;)Lcom/amazon/mShop/control/device/KiangSubscriber;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/control/device/KiangSubscriber;->onRegisterError()V

    goto :goto_0
.end method
