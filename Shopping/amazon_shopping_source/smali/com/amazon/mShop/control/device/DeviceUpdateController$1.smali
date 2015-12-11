.class Lcom/amazon/mShop/control/device/DeviceUpdateController$1;
.super Ljava/lang/Object;
.source "DeviceUpdateController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/device/DeviceUpdateController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    iput-object p2, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 61
    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    iget-object v2, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/device/DeviceUpdateController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v1, v2}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->access$000(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 62
    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    # invokes: Lcom/amazon/mShop/control/device/DeviceUpdateController;->serviceCallCompleted()V
    invoke-static {v1}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->access$100(Lcom/amazon/mShop/control/device/DeviceUpdateController;)V

    .line 69
    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;->getResetRegistration()Ljava/lang/Boolean;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangUpdateResponse;->getResetRegistration()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 70
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 71
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "applicationInstallId"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 72
    const-string/jumbo v1, "applicationSecretKey"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 73
    const-string/jumbo v1, "kiangUpdateSequenceNumber"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 75
    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$1;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    # getter for: Lcom/amazon/mShop/control/device/DeviceUpdateController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;
    invoke-static {v1}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->access$200(Lcom/amazon/mShop/control/device/DeviceUpdateController;)Lcom/amazon/mShop/control/device/KiangSubscriber;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/control/device/KiangSubscriber;->onResetRegister()V

    .line 78
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :cond_0
    return-void
.end method
