.class Lcom/amazon/mShop/control/home/HomeController$5;
.super Ljava/lang/Object;
.source "HomeController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/HomeController;->receivedNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/home/HomeController;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/Notification;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 0

    .prologue
    .line 486
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController$5;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    iput-object p2, p0, Lcom/amazon/mShop/control/home/HomeController$5;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 490
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController$5;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;
    invoke-static {v3}, Lcom/amazon/mShop/control/home/HomeController;->access$200(Lcom/amazon/mShop/control/home/HomeController;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 491
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/home/HomeSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 492
    .local v1, "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController$5;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    invoke-interface {v1, v3}, Lcom/amazon/mShop/control/home/HomeSubscriber;->onNotificationReceived(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    goto :goto_0

    .line 495
    .end local v1    # "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    :cond_0
    return-void
.end method
