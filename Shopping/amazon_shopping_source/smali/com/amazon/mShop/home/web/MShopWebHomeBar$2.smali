.class Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;
.super Ljava/lang/Object;
.source "MShopWebHomeBar.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/web/MShopWebHomeBar;->onPushViewCompleted()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)V
    .locals 0

    .prologue
    .line 119
    iput-object p1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 126
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 127
    .local v0, "metricStartTime":J
    iget-object v5, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v5}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$000(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v5

    invoke-virtual {v5, v3}, Lcom/amazon/mShop/control/home/HomeController;->setReturnCartItems(Z)V

    .line 131
    iget-object v5, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v5}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$000(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v5

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v6

    sget-object v7, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    if-ne v6, v7, :cond_1

    :goto_0
    invoke-virtual {v5, v3}, Lcom/amazon/mShop/control/home/HomeController;->setReturnHomeItems(Z)V

    .line 132
    iget-object v3, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mHomeController:Lcom/amazon/mShop/control/home/HomeController;
    invoke-static {v3}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$000(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/control/home/HomeController;

    move-result-object v3

    iget-object v5, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mApplicationStarted:Z
    invoke-static {v5}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$100(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Z

    move-result v5

    iget-object v6, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mApplicationStarted:Z
    invoke-static {v6}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$100(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Z

    move-result v6

    invoke-virtual {v3, v5, v6}, Lcom/amazon/mShop/control/home/HomeController;->phoneHome(ZZ)Z

    move-result v2

    .line 133
    .local v2, "phoneHomeInvoked":Z
    iget-object v3, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mApplicationStarted:Z
    invoke-static {v3}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$100(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 136
    iget-object v3, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;
    invoke-static {v3}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$200(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->loadHTMLGateway()V

    .line 144
    :cond_0
    :goto_1
    iget-object v3, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # setter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mApplicationStarted:Z
    invoke-static {v3, v4}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$102(Lcom/amazon/mShop/home/web/MShopWebHomeBar;Z)Z

    .line 145
    return-void

    .end local v2    # "phoneHomeInvoked":Z
    :cond_1
    move v3, v4

    .line 131
    goto :goto_0

    .line 137
    .restart local v2    # "phoneHomeInvoked":Z
    :cond_2
    if-eqz v2, :cond_0

    .line 140
    iget-object v3, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$2;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;
    invoke-static {v3}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$200(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;->reloadHtmlGateway(J)V

    goto :goto_1
.end method
