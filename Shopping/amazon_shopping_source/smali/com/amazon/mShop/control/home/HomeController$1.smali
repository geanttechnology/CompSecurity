.class Lcom/amazon/mShop/control/home/HomeController$1;
.super Ljava/lang/Object;
.source "HomeController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/HomeController;->receivedLoginData(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/home/HomeController;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginData;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V
    .locals 0

    .prologue
    .line 380
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController$1;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    iput-object p2, p0, Lcom/amazon/mShop/control/home/HomeController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 384
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController$1;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->loginDataReceived:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/home/HomeController;->access$002(Lcom/amazon/mShop/control/home/HomeController;Z)Z

    .line 385
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/LoginData;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userUpdated(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;)V

    .line 386
    return-void
.end method
