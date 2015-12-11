.class Lcom/amazon/mShop/control/cvsd/CVSDController$1;
.super Ljava/lang/Object;
.source "CVSDController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/cvsd/CVSDController;->completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/cvsd/CVSDController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 132
    iput-object p1, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    iput-object p2, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 136
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    iget-object v1, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/cvsd/CVSDController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$000(Lcom/amazon/mShop/control/cvsd/CVSDController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 137
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # invokes: Lcom/amazon/mShop/control/cvsd/CVSDController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$100(Lcom/amazon/mShop/control/cvsd/CVSDController;)V

    .line 139
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedTypeVaule:I
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$200(Lcom/amazon/mShop/control/cvsd/CVSDController;)I

    move-result v0

    if-nez v0, :cond_2

    .line 141
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$300(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedMessage:Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$400(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 142
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$500(Lcom/amazon/mShop/control/cvsd/CVSDController;)Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$500(Lcom/amazon/mShop/control/cvsd/CVSDController;)Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedMessage:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$400(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;->onOnlyMessageReceived(Ljava/lang/String;)V

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 148
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$500(Lcom/amazon/mShop/control/cvsd/CVSDController;)Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$500(Lcom/amazon/mShop/control/cvsd/CVSDController;)Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;
    invoke-static {v1}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$300(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;->onDeliveryLocationsReceived(Ljava/util/List;)V

    goto :goto_0

    .line 151
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedTypeVaule:I
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$200(Lcom/amazon/mShop/control/cvsd/CVSDController;)I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 155
    invoke-static {}, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->reset()V

    .line 156
    sput v2, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedType:I

    .line 157
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->receivedMessage:Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$400(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->message:Ljava/lang/String;

    .line 158
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->resultAddressList:Ljava/util/List;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$300(Lcom/amazon/mShop/control/cvsd/CVSDController;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$500(Lcom/amazon/mShop/control/cvsd/CVSDController;)Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 161
    iget-object v0, p0, Lcom/amazon/mShop/control/cvsd/CVSDController$1;->this$0:Lcom/amazon/mShop/control/cvsd/CVSDController;

    # getter for: Lcom/amazon/mShop/control/cvsd/CVSDController;->subscriber:Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/cvsd/CVSDController;->access$500(Lcom/amazon/mShop/control/cvsd/CVSDController;)Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/cvsd/CVSDSubscriber;->onRefinementsReceived()V

    goto :goto_0
.end method
