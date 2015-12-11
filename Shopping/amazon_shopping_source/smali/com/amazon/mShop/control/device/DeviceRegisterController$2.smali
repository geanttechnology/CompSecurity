.class Lcom/amazon/mShop/control/device/DeviceRegisterController$2;
.super Ljava/lang/Object;
.source "DeviceRegisterController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/device/DeviceRegisterController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    iput-object p2, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/device/DeviceRegisterController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->access$300(Lcom/amazon/mShop/control/device/DeviceRegisterController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    # invokes: Lcom/amazon/mShop/control/device/DeviceRegisterController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->access$400(Lcom/amazon/mShop/control/device/DeviceRegisterController;)V

    .line 99
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->kiangRegister()V

    .line 103
    :goto_0
    return-void

    .line 101
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceRegisterController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceRegisterController;

    # getter for: Lcom/amazon/mShop/control/device/DeviceRegisterController;->mKiangSubscriber:Lcom/amazon/mShop/control/device/KiangSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/device/DeviceRegisterController;->access$200(Lcom/amazon/mShop/control/device/DeviceRegisterController;)Lcom/amazon/mShop/control/device/KiangSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/device/KiangSubscriber;->onRegisterError()V

    goto :goto_0
.end method
