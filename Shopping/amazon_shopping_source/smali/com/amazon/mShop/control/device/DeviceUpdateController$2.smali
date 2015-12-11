.class Lcom/amazon/mShop/control/device/DeviceUpdateController$2;
.super Ljava/lang/Object;
.source "DeviceUpdateController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/device/DeviceUpdateController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    iput-object p2, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    iget-object v1, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/device/DeviceUpdateController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->access$300(Lcom/amazon/mShop/control/device/DeviceUpdateController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    # invokes: Lcom/amazon/mShop/control/device/DeviceUpdateController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->access$400(Lcom/amazon/mShop/control/device/DeviceUpdateController;)V

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/control/device/DeviceUpdateController$2;->this$0:Lcom/amazon/mShop/control/device/DeviceUpdateController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/device/DeviceUpdateController;->kiangUpdate()V

    .line 90
    :cond_0
    return-void
.end method
